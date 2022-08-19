package com.li.server;


import com.li.rpc.MyRequest;
import com.li.rpc.MyResponse;
import com.li.rpc.BidirectionGrpc.BidirectionImplBase;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BidirectionServiceImpl extends  BidirectionImplBase{

    //双向流
    @Override
    public StreamObserver<MyRequest> manyToMany(StreamObserver<MyResponse> responseObserver) {
        // 返回匿名类，给上层框架使用
        return new StreamObserver<MyRequest>() {
            // 记录总量
            private int totalCount = 0;

            @Override
            public void onNext(MyRequest myRequest) {
                log.info("正在处理[{}]，数量为[{}]",
                        myRequest.getName(),
                        myRequest.getValue());

                // 增加总量
                totalCount += myRequest.getValue();

                Integer value;
                String message;
                if (0 == myRequest.getValue() % 2) {
                    value = myRequest.getValue() / 2;
                    message = String.format(myRequest.getName() + "的值是2的倍数，减半[%d]成功", value);
                } else {
                    value = (myRequest.getValue() + 1) / 2;
                    message = String.format(myRequest.getName() + "的值不是2的倍数，减半[%d]成功", value);
                }

                responseObserver.onNext(MyResponse.newBuilder()
                        .setResult(value)
                        .setMessage(message)
                        .build());
            }

            @Override
            public void onError(Throwable t) {
                log.error("异常", t);
            }

            @Override
            public void onCompleted() {
                log.info("共计[{}]", totalCount);
                responseObserver.onCompleted();
            }
        };
    }
}
