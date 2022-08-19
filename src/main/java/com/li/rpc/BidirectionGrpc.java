package com.li.rpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: Bidirectional.proto")
public final class BidirectionGrpc {

  private BidirectionGrpc() {}

  public static final String SERVICE_NAME = "com.li.rpc.Bidirection";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.li.rpc.MyRequest,
      com.li.rpc.MyResponse> getManyToManyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ManyToMany",
      requestType = com.li.rpc.MyRequest.class,
      responseType = com.li.rpc.MyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.li.rpc.MyRequest,
      com.li.rpc.MyResponse> getManyToManyMethod() {
    io.grpc.MethodDescriptor<com.li.rpc.MyRequest, com.li.rpc.MyResponse> getManyToManyMethod;
    if ((getManyToManyMethod = BidirectionGrpc.getManyToManyMethod) == null) {
      synchronized (BidirectionGrpc.class) {
        if ((getManyToManyMethod = BidirectionGrpc.getManyToManyMethod) == null) {
          BidirectionGrpc.getManyToManyMethod = getManyToManyMethod =
              io.grpc.MethodDescriptor.<com.li.rpc.MyRequest, com.li.rpc.MyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ManyToMany"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.li.rpc.MyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.li.rpc.MyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BidirectionMethodDescriptorSupplier("ManyToMany"))
              .build();
        }
      }
    }
    return getManyToManyMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BidirectionStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BidirectionStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BidirectionStub>() {
        @java.lang.Override
        public BidirectionStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BidirectionStub(channel, callOptions);
        }
      };
    return BidirectionStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BidirectionBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BidirectionBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BidirectionBlockingStub>() {
        @java.lang.Override
        public BidirectionBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BidirectionBlockingStub(channel, callOptions);
        }
      };
    return BidirectionBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BidirectionFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BidirectionFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BidirectionFutureStub>() {
        @java.lang.Override
        public BidirectionFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BidirectionFutureStub(channel, callOptions);
        }
      };
    return BidirectionFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class BidirectionImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * 双向流
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.li.rpc.MyRequest> manyToMany(
        io.grpc.stub.StreamObserver<com.li.rpc.MyResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getManyToManyMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getManyToManyMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                com.li.rpc.MyRequest,
                com.li.rpc.MyResponse>(
                  this, METHODID_MANY_TO_MANY)))
          .build();
    }
  }

  /**
   */
  public static final class BidirectionStub extends io.grpc.stub.AbstractAsyncStub<BidirectionStub> {
    private BidirectionStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BidirectionStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BidirectionStub(channel, callOptions);
    }

    /**
     * <pre>
     * 双向流
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.li.rpc.MyRequest> manyToMany(
        io.grpc.stub.StreamObserver<com.li.rpc.MyResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getManyToManyMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class BidirectionBlockingStub extends io.grpc.stub.AbstractBlockingStub<BidirectionBlockingStub> {
    private BidirectionBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BidirectionBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BidirectionBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class BidirectionFutureStub extends io.grpc.stub.AbstractFutureStub<BidirectionFutureStub> {
    private BidirectionFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BidirectionFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BidirectionFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_MANY_TO_MANY = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BidirectionImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BidirectionImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_MANY_TO_MANY:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.manyToMany(
              (io.grpc.stub.StreamObserver<com.li.rpc.MyResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class BidirectionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BidirectionBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.li.rpc.BidirectionStream.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Bidirection");
    }
  }

  private static final class BidirectionFileDescriptorSupplier
      extends BidirectionBaseDescriptorSupplier {
    BidirectionFileDescriptorSupplier() {}
  }

  private static final class BidirectionMethodDescriptorSupplier
      extends BidirectionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BidirectionMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (BidirectionGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BidirectionFileDescriptorSupplier())
              .addMethod(getManyToManyMethod())
              .build();
        }
      }
    }
    return result;
  }
}
