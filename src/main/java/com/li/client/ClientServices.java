package com.li.client;


import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import com.li.rpc.BidirectionGrpc;
import com.li.rpc.MyRequest;
import com.li.rpc.MyResponse;
import com.li.rpc.BidirectionGrpc.BidirectionStub;

@Slf4j
public class ClientServices {

    private BidirectionStub stub;
    private ClientNetService netService;
    private final String ip = "localhost";
    private final int port = 8081;

    public ClientServices(){
        this.netService = new ClientNetService(ip, port);
        this.stub = BidirectionGrpc.newStub(this.netService.getChannel());
    }

    public List<String> manyToMany(String name,Integer value){
        CountDownLatch countDownLatch = new CountDownLatch(1);
        // responseObserver的onNext和onCompleted会在另一个线程中被执行，
        // ExtendResponseObserver继承自StreamObserver
        ExtendResponseObserver<MyResponse> responseObserver = new ExtendResponseObserver<MyResponse>() {

            //保存所有来自服务端的响应
            private List<String> strings = new ArrayList<>();
            @Override
            public List<String> getExtra() {
                return strings;
            }

            @Override
            public void onNext(MyResponse myResponse) {
                log.info("on next");
                // 放入匿名类的成员变量中
                strings.add(String.format("值[%d]，返回信息:%s" , myResponse.getResult(), myResponse.getMessage()));
            }

            @Override
            public void onError(Throwable t) {
                log.error("gRPC request error", t);
                strings.add("gRPC request error, " + t.getMessage());
                countDownLatch.countDown();
            }

            @Override
            public void onCompleted() {
                log.info("on complete");
                // 执行了countDown方法后，前面执行countDownLatch.await方法的线程就不再wait了，
                // 会继续往下执行
                countDownLatch.countDown();
            }
        };

        // 远程调用，此时数据还没有给到服务端
        StreamObserver<MyRequest> requestObserver = stub.manyToMany(responseObserver);

        for(int i=1; i <= 10; i++) {
            // 发送一笔数据到服务端
            requestObserver.onNext(MyRequest.newBuilder()
                    .setName(name)
                    .setValue(value + i)
                    .build());
        }

        // 客户端告诉服务端：数据已经发完了
        requestObserver.onCompleted();

        try {
            // 开始等待，如果服务端处理完成，那么responseObserver的onCompleted方法会在另一个线程被执行，
            // 那里会执行countDownLatch的countDown方法，一但countDown被执行，下面的await就执行完毕了，
            // await的超时时间设置为2秒
            countDownLatch.await(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("countDownLatch await error", e);
        }

        log.info("service finish");
        // 服务端返回的内容被放置在requestObserver中，从getExtra方法可以取得
        return (List<String>) responseObserver.getExtra();
    }

}
