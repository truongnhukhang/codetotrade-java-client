package coin.algorithm.grpc.service;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.64.0)",
    comments = "Source: coin_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CoinAlgorithmServiceGrpc {

  private CoinAlgorithmServiceGrpc() {}

  public static final String SERVICE_NAME = "coin.algorithm.grpc.service.generated.CoinAlgorithmService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<GetTimeTravelRequest,
      GetTimeTravelResponse> getGetTimeTravelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTimeTravel",
      requestType = GetTimeTravelRequest.class,
      responseType = GetTimeTravelResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<GetTimeTravelRequest,
      GetTimeTravelResponse> getGetTimeTravelMethod() {
    io.grpc.MethodDescriptor<GetTimeTravelRequest, GetTimeTravelResponse> getGetTimeTravelMethod;
    if ((getGetTimeTravelMethod = CoinAlgorithmServiceGrpc.getGetTimeTravelMethod) == null) {
      synchronized (CoinAlgorithmServiceGrpc.class) {
        if ((getGetTimeTravelMethod = CoinAlgorithmServiceGrpc.getGetTimeTravelMethod) == null) {
          CoinAlgorithmServiceGrpc.getGetTimeTravelMethod = getGetTimeTravelMethod =
              io.grpc.MethodDescriptor.<GetTimeTravelRequest, GetTimeTravelResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTimeTravel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GetTimeTravelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GetTimeTravelResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CoinAlgorithmServiceMethodDescriptorSupplier("GetTimeTravel"))
              .build();
        }
      }
    }
    return getGetTimeTravelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<CreateBackTestRequest,
      CreateBackTestResponse> getCreateBackTestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBackTest",
      requestType = CreateBackTestRequest.class,
      responseType = CreateBackTestResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<CreateBackTestRequest,
      CreateBackTestResponse> getCreateBackTestMethod() {
    io.grpc.MethodDescriptor<CreateBackTestRequest, CreateBackTestResponse> getCreateBackTestMethod;
    if ((getCreateBackTestMethod = CoinAlgorithmServiceGrpc.getCreateBackTestMethod) == null) {
      synchronized (CoinAlgorithmServiceGrpc.class) {
        if ((getCreateBackTestMethod = CoinAlgorithmServiceGrpc.getCreateBackTestMethod) == null) {
          CoinAlgorithmServiceGrpc.getCreateBackTestMethod = getCreateBackTestMethod =
              io.grpc.MethodDescriptor.<CreateBackTestRequest, CreateBackTestResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateBackTest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CreateBackTestRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CreateBackTestResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CoinAlgorithmServiceMethodDescriptorSupplier("CreateBackTest"))
              .build();
        }
      }
    }
    return getCreateBackTestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<CreateOnlineRunRequest,
      CreateOnlineResponse> getCreateOnlineRunMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateOnlineRun",
      requestType = CreateOnlineRunRequest.class,
      responseType = CreateOnlineResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<CreateOnlineRunRequest,
      CreateOnlineResponse> getCreateOnlineRunMethod() {
    io.grpc.MethodDescriptor<CreateOnlineRunRequest, CreateOnlineResponse> getCreateOnlineRunMethod;
    if ((getCreateOnlineRunMethod = CoinAlgorithmServiceGrpc.getCreateOnlineRunMethod) == null) {
      synchronized (CoinAlgorithmServiceGrpc.class) {
        if ((getCreateOnlineRunMethod = CoinAlgorithmServiceGrpc.getCreateOnlineRunMethod) == null) {
          CoinAlgorithmServiceGrpc.getCreateOnlineRunMethod = getCreateOnlineRunMethod =
              io.grpc.MethodDescriptor.<CreateOnlineRunRequest, CreateOnlineResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateOnlineRun"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CreateOnlineRunRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CreateOnlineResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CoinAlgorithmServiceMethodDescriptorSupplier("CreateOnlineRun"))
              .build();
        }
      }
    }
    return getCreateOnlineRunMethod;
  }

  private static volatile io.grpc.MethodDescriptor<GetTradeMetadataRequest,
      GetTradeMetadataResponse> getGetTradeMetadataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTradeMetadata",
      requestType = GetTradeMetadataRequest.class,
      responseType = GetTradeMetadataResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<GetTradeMetadataRequest,
      GetTradeMetadataResponse> getGetTradeMetadataMethod() {
    io.grpc.MethodDescriptor<GetTradeMetadataRequest, GetTradeMetadataResponse> getGetTradeMetadataMethod;
    if ((getGetTradeMetadataMethod = CoinAlgorithmServiceGrpc.getGetTradeMetadataMethod) == null) {
      synchronized (CoinAlgorithmServiceGrpc.class) {
        if ((getGetTradeMetadataMethod = CoinAlgorithmServiceGrpc.getGetTradeMetadataMethod) == null) {
          CoinAlgorithmServiceGrpc.getGetTradeMetadataMethod = getGetTradeMetadataMethod =
              io.grpc.MethodDescriptor.<GetTradeMetadataRequest, GetTradeMetadataResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTradeMetadata"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GetTradeMetadataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GetTradeMetadataResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CoinAlgorithmServiceMethodDescriptorSupplier("GetTradeMetadata"))
              .build();
        }
      }
    }
    return getGetTradeMetadataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<StreamCandleRequest,
      StreamCandleResponse> getStreamCandleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamCandle",
      requestType = StreamCandleRequest.class,
      responseType = StreamCandleResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<StreamCandleRequest,
      StreamCandleResponse> getStreamCandleMethod() {
    io.grpc.MethodDescriptor<StreamCandleRequest, StreamCandleResponse> getStreamCandleMethod;
    if ((getStreamCandleMethod = CoinAlgorithmServiceGrpc.getStreamCandleMethod) == null) {
      synchronized (CoinAlgorithmServiceGrpc.class) {
        if ((getStreamCandleMethod = CoinAlgorithmServiceGrpc.getStreamCandleMethod) == null) {
          CoinAlgorithmServiceGrpc.getStreamCandleMethod = getStreamCandleMethod =
              io.grpc.MethodDescriptor.<StreamCandleRequest, StreamCandleResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamCandle"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  StreamCandleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  StreamCandleResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CoinAlgorithmServiceMethodDescriptorSupplier("StreamCandle"))
              .build();
        }
      }
    }
    return getStreamCandleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<GetSignalRequest,
      GetSignalResponse> getGetSignalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSignal",
      requestType = GetSignalRequest.class,
      responseType = GetSignalResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<GetSignalRequest,
      GetSignalResponse> getGetSignalMethod() {
    io.grpc.MethodDescriptor<GetSignalRequest, GetSignalResponse> getGetSignalMethod;
    if ((getGetSignalMethod = CoinAlgorithmServiceGrpc.getGetSignalMethod) == null) {
      synchronized (CoinAlgorithmServiceGrpc.class) {
        if ((getGetSignalMethod = CoinAlgorithmServiceGrpc.getGetSignalMethod) == null) {
          CoinAlgorithmServiceGrpc.getGetSignalMethod = getGetSignalMethod =
              io.grpc.MethodDescriptor.<GetSignalRequest, GetSignalResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSignal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GetSignalRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GetSignalResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CoinAlgorithmServiceMethodDescriptorSupplier("GetSignal"))
              .build();
        }
      }
    }
    return getGetSignalMethod;
  }

  private static volatile io.grpc.MethodDescriptor<GetOrderStatusRequest,
      GetOrderStatusResponse> getGetOrderStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetOrderStatus",
      requestType = GetOrderStatusRequest.class,
      responseType = GetOrderStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<GetOrderStatusRequest,
      GetOrderStatusResponse> getGetOrderStatusMethod() {
    io.grpc.MethodDescriptor<GetOrderStatusRequest, GetOrderStatusResponse> getGetOrderStatusMethod;
    if ((getGetOrderStatusMethod = CoinAlgorithmServiceGrpc.getGetOrderStatusMethod) == null) {
      synchronized (CoinAlgorithmServiceGrpc.class) {
        if ((getGetOrderStatusMethod = CoinAlgorithmServiceGrpc.getGetOrderStatusMethod) == null) {
          CoinAlgorithmServiceGrpc.getGetOrderStatusMethod = getGetOrderStatusMethod =
              io.grpc.MethodDescriptor.<GetOrderStatusRequest, GetOrderStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetOrderStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GetOrderStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GetOrderStatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CoinAlgorithmServiceMethodDescriptorSupplier("GetOrderStatus"))
              .build();
        }
      }
    }
    return getGetOrderStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<CreateOrderRequest,
      CreateOrderResponse> getCreateOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateOrder",
      requestType = CreateOrderRequest.class,
      responseType = CreateOrderResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<CreateOrderRequest,
      CreateOrderResponse> getCreateOrderMethod() {
    io.grpc.MethodDescriptor<CreateOrderRequest, CreateOrderResponse> getCreateOrderMethod;
    if ((getCreateOrderMethod = CoinAlgorithmServiceGrpc.getCreateOrderMethod) == null) {
      synchronized (CoinAlgorithmServiceGrpc.class) {
        if ((getCreateOrderMethod = CoinAlgorithmServiceGrpc.getCreateOrderMethod) == null) {
          CoinAlgorithmServiceGrpc.getCreateOrderMethod = getCreateOrderMethod =
              io.grpc.MethodDescriptor.<CreateOrderRequest, CreateOrderResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CreateOrderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CreateOrderResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CoinAlgorithmServiceMethodDescriptorSupplier("CreateOrder"))
              .build();
        }
      }
    }
    return getCreateOrderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<CancelOrderRequest,
      CancelOrderResponse> getCancelOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelOrder",
      requestType = CancelOrderRequest.class,
      responseType = CancelOrderResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<CancelOrderRequest,
      CancelOrderResponse> getCancelOrderMethod() {
    io.grpc.MethodDescriptor<CancelOrderRequest, CancelOrderResponse> getCancelOrderMethod;
    if ((getCancelOrderMethod = CoinAlgorithmServiceGrpc.getCancelOrderMethod) == null) {
      synchronized (CoinAlgorithmServiceGrpc.class) {
        if ((getCancelOrderMethod = CoinAlgorithmServiceGrpc.getCancelOrderMethod) == null) {
          CoinAlgorithmServiceGrpc.getCancelOrderMethod = getCancelOrderMethod =
              io.grpc.MethodDescriptor.<CancelOrderRequest, CancelOrderResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CancelOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CancelOrderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CancelOrderResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CoinAlgorithmServiceMethodDescriptorSupplier("CancelOrder"))
              .build();
        }
      }
    }
    return getCancelOrderMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CoinAlgorithmServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CoinAlgorithmServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CoinAlgorithmServiceStub>() {
        @Override
        public CoinAlgorithmServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CoinAlgorithmServiceStub(channel, callOptions);
        }
      };
    return CoinAlgorithmServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CoinAlgorithmServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CoinAlgorithmServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CoinAlgorithmServiceBlockingStub>() {
        @Override
        public CoinAlgorithmServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CoinAlgorithmServiceBlockingStub(channel, callOptions);
        }
      };
    return CoinAlgorithmServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CoinAlgorithmServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CoinAlgorithmServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CoinAlgorithmServiceFutureStub>() {
        @Override
        public CoinAlgorithmServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CoinAlgorithmServiceFutureStub(channel, callOptions);
        }
      };
    return CoinAlgorithmServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getTimeTravel(GetTimeTravelRequest request,
                               io.grpc.stub.StreamObserver<GetTimeTravelResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTimeTravelMethod(), responseObserver);
    }

    /**
     */
    default void createBackTest(CreateBackTestRequest request,
                                io.grpc.stub.StreamObserver<CreateBackTestResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateBackTestMethod(), responseObserver);
    }

    /**
     */
    default void createOnlineRun(CreateOnlineRunRequest request,
                                 io.grpc.stub.StreamObserver<CreateOnlineResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateOnlineRunMethod(), responseObserver);
    }

    /**
     */
    default void getTradeMetadata(GetTradeMetadataRequest request,
                                  io.grpc.stub.StreamObserver<GetTradeMetadataResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTradeMetadataMethod(), responseObserver);
    }

    /**
     */
    default void streamCandle(StreamCandleRequest request,
                              io.grpc.stub.StreamObserver<StreamCandleResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStreamCandleMethod(), responseObserver);
    }

    /**
     */
    default void getSignal(GetSignalRequest request,
                           io.grpc.stub.StreamObserver<GetSignalResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSignalMethod(), responseObserver);
    }

    /**
     */
    default void getOrderStatus(GetOrderStatusRequest request,
                                io.grpc.stub.StreamObserver<GetOrderStatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetOrderStatusMethod(), responseObserver);
    }

    /**
     */
    default void createOrder(CreateOrderRequest request,
                             io.grpc.stub.StreamObserver<CreateOrderResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateOrderMethod(), responseObserver);
    }

    /**
     */
    default void cancelOrder(CancelOrderRequest request,
                             io.grpc.stub.StreamObserver<CancelOrderResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCancelOrderMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CoinAlgorithmService.
   */
  public static abstract class CoinAlgorithmServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return CoinAlgorithmServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CoinAlgorithmService.
   */
  public static final class CoinAlgorithmServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CoinAlgorithmServiceStub> {
    private CoinAlgorithmServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected CoinAlgorithmServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CoinAlgorithmServiceStub(channel, callOptions);
    }

    /**
     */
    public void getTimeTravel(GetTimeTravelRequest request,
                              io.grpc.stub.StreamObserver<GetTimeTravelResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTimeTravelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createBackTest(CreateBackTestRequest request,
                               io.grpc.stub.StreamObserver<CreateBackTestResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateBackTestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createOnlineRun(CreateOnlineRunRequest request,
                                io.grpc.stub.StreamObserver<CreateOnlineResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateOnlineRunMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTradeMetadata(GetTradeMetadataRequest request,
                                 io.grpc.stub.StreamObserver<GetTradeMetadataResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTradeMetadataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void streamCandle(StreamCandleRequest request,
                             io.grpc.stub.StreamObserver<StreamCandleResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStreamCandleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getSignal(GetSignalRequest request,
                          io.grpc.stub.StreamObserver<GetSignalResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSignalMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getOrderStatus(GetOrderStatusRequest request,
                               io.grpc.stub.StreamObserver<GetOrderStatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetOrderStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createOrder(CreateOrderRequest request,
                            io.grpc.stub.StreamObserver<CreateOrderResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateOrderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void cancelOrder(CancelOrderRequest request,
                            io.grpc.stub.StreamObserver<CancelOrderResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCancelOrderMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CoinAlgorithmService.
   */
  public static final class CoinAlgorithmServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CoinAlgorithmServiceBlockingStub> {
    private CoinAlgorithmServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected CoinAlgorithmServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CoinAlgorithmServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public GetTimeTravelResponse getTimeTravel(GetTimeTravelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTimeTravelMethod(), getCallOptions(), request);
    }

    /**
     */
    public CreateBackTestResponse createBackTest(CreateBackTestRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateBackTestMethod(), getCallOptions(), request);
    }

    /**
     */
    public CreateOnlineResponse createOnlineRun(CreateOnlineRunRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateOnlineRunMethod(), getCallOptions(), request);
    }

    /**
     */
    public GetTradeMetadataResponse getTradeMetadata(GetTradeMetadataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTradeMetadataMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<StreamCandleResponse> streamCandle(
        StreamCandleRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStreamCandleMethod(), getCallOptions(), request);
    }

    /**
     */
    public GetSignalResponse getSignal(GetSignalRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSignalMethod(), getCallOptions(), request);
    }

    /**
     */
    public GetOrderStatusResponse getOrderStatus(GetOrderStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOrderStatusMethod(), getCallOptions(), request);
    }

    /**
     */
    public CreateOrderResponse createOrder(CreateOrderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateOrderMethod(), getCallOptions(), request);
    }

    /**
     */
    public CancelOrderResponse cancelOrder(CancelOrderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelOrderMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CoinAlgorithmService.
   */
  public static final class CoinAlgorithmServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CoinAlgorithmServiceFutureStub> {
    private CoinAlgorithmServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected CoinAlgorithmServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CoinAlgorithmServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GetTimeTravelResponse> getTimeTravel(
        GetTimeTravelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTimeTravelMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<CreateBackTestResponse> createBackTest(
        CreateBackTestRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateBackTestMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<CreateOnlineResponse> createOnlineRun(
        CreateOnlineRunRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateOnlineRunMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GetTradeMetadataResponse> getTradeMetadata(
        GetTradeMetadataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTradeMetadataMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GetSignalResponse> getSignal(
        GetSignalRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSignalMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<GetOrderStatusResponse> getOrderStatus(
        GetOrderStatusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetOrderStatusMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<CreateOrderResponse> createOrder(
        CreateOrderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateOrderMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<CancelOrderResponse> cancelOrder(
        CancelOrderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCancelOrderMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_TIME_TRAVEL = 0;
  private static final int METHODID_CREATE_BACK_TEST = 1;
  private static final int METHODID_CREATE_ONLINE_RUN = 2;
  private static final int METHODID_GET_TRADE_METADATA = 3;
  private static final int METHODID_STREAM_CANDLE = 4;
  private static final int METHODID_GET_SIGNAL = 5;
  private static final int METHODID_GET_ORDER_STATUS = 6;
  private static final int METHODID_CREATE_ORDER = 7;
  private static final int METHODID_CANCEL_ORDER = 8;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_TIME_TRAVEL:
          serviceImpl.getTimeTravel((GetTimeTravelRequest) request,
              (io.grpc.stub.StreamObserver<GetTimeTravelResponse>) responseObserver);
          break;
        case METHODID_CREATE_BACK_TEST:
          serviceImpl.createBackTest((CreateBackTestRequest) request,
              (io.grpc.stub.StreamObserver<CreateBackTestResponse>) responseObserver);
          break;
        case METHODID_CREATE_ONLINE_RUN:
          serviceImpl.createOnlineRun((CreateOnlineRunRequest) request,
              (io.grpc.stub.StreamObserver<CreateOnlineResponse>) responseObserver);
          break;
        case METHODID_GET_TRADE_METADATA:
          serviceImpl.getTradeMetadata((GetTradeMetadataRequest) request,
              (io.grpc.stub.StreamObserver<GetTradeMetadataResponse>) responseObserver);
          break;
        case METHODID_STREAM_CANDLE:
          serviceImpl.streamCandle((StreamCandleRequest) request,
              (io.grpc.stub.StreamObserver<StreamCandleResponse>) responseObserver);
          break;
        case METHODID_GET_SIGNAL:
          serviceImpl.getSignal((GetSignalRequest) request,
              (io.grpc.stub.StreamObserver<GetSignalResponse>) responseObserver);
          break;
        case METHODID_GET_ORDER_STATUS:
          serviceImpl.getOrderStatus((GetOrderStatusRequest) request,
              (io.grpc.stub.StreamObserver<GetOrderStatusResponse>) responseObserver);
          break;
        case METHODID_CREATE_ORDER:
          serviceImpl.createOrder((CreateOrderRequest) request,
              (io.grpc.stub.StreamObserver<CreateOrderResponse>) responseObserver);
          break;
        case METHODID_CANCEL_ORDER:
          serviceImpl.cancelOrder((CancelOrderRequest) request,
              (io.grpc.stub.StreamObserver<CancelOrderResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetTimeTravelMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              GetTimeTravelRequest,
              GetTimeTravelResponse>(
                service, METHODID_GET_TIME_TRAVEL)))
        .addMethod(
          getCreateBackTestMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              CreateBackTestRequest,
              CreateBackTestResponse>(
                service, METHODID_CREATE_BACK_TEST)))
        .addMethod(
          getCreateOnlineRunMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              CreateOnlineRunRequest,
              CreateOnlineResponse>(
                service, METHODID_CREATE_ONLINE_RUN)))
        .addMethod(
          getGetTradeMetadataMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              GetTradeMetadataRequest,
              GetTradeMetadataResponse>(
                service, METHODID_GET_TRADE_METADATA)))
        .addMethod(
          getStreamCandleMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              StreamCandleRequest,
              StreamCandleResponse>(
                service, METHODID_STREAM_CANDLE)))
        .addMethod(
          getGetSignalMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              GetSignalRequest,
              GetSignalResponse>(
                service, METHODID_GET_SIGNAL)))
        .addMethod(
          getGetOrderStatusMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              GetOrderStatusRequest,
              GetOrderStatusResponse>(
                service, METHODID_GET_ORDER_STATUS)))
        .addMethod(
          getCreateOrderMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              CreateOrderRequest,
              CreateOrderResponse>(
                service, METHODID_CREATE_ORDER)))
        .addMethod(
          getCancelOrderMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              CancelOrderRequest,
              CancelOrderResponse>(
                service, METHODID_CANCEL_ORDER)))
        .build();
  }

  private static abstract class CoinAlgorithmServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CoinAlgorithmServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return CoinService.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CoinAlgorithmService");
    }
  }

  private static final class CoinAlgorithmServiceFileDescriptorSupplier
      extends CoinAlgorithmServiceBaseDescriptorSupplier {
    CoinAlgorithmServiceFileDescriptorSupplier() {}
  }

  private static final class CoinAlgorithmServiceMethodDescriptorSupplier
      extends CoinAlgorithmServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CoinAlgorithmServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CoinAlgorithmServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CoinAlgorithmServiceFileDescriptorSupplier())
              .addMethod(getGetTimeTravelMethod())
              .addMethod(getCreateBackTestMethod())
              .addMethod(getCreateOnlineRunMethod())
              .addMethod(getGetTradeMetadataMethod())
              .addMethod(getStreamCandleMethod())
              .addMethod(getGetSignalMethod())
              .addMethod(getGetOrderStatusMethod())
              .addMethod(getCreateOrderMethod())
              .addMethod(getCancelOrderMethod())
              .build();
        }
      }
    }
    return result;
  }
}
