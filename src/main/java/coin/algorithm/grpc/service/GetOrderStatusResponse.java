// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: coin_service.proto

// Protobuf Java Version: 3.25.1
package coin.algorithm.grpc.service;

/**
 * Protobuf type {@code coin.algorithm.grpc.service.generated.GetOrderStatusResponse}
 */
public final class GetOrderStatusResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:coin.algorithm.grpc.service.generated.GetOrderStatusResponse)
    GetOrderStatusResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GetOrderStatusResponse.newBuilder() to construct.
  private GetOrderStatusResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetOrderStatusResponse() {
    status_ = 0;
    payload_ = "";
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new GetOrderStatusResponse();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return CoinService.internal_static_coin_algorithm_grpc_service_generated_GetOrderStatusResponse_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return CoinService.internal_static_coin_algorithm_grpc_service_generated_GetOrderStatusResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            GetOrderStatusResponse.class, Builder.class);
  }

  public static final int STATUS_FIELD_NUMBER = 1;
  private int status_ = 0;
  /**
   * <code>.coin.algorithm.grpc.service.generated.OrderStatus status = 1;</code>
   * @return The enum numeric value on the wire for status.
   */
  @Override public int getStatusValue() {
    return status_;
  }
  /**
   * <code>.coin.algorithm.grpc.service.generated.OrderStatus status = 1;</code>
   * @return The status.
   */
  @Override public OrderStatus getStatus() {
    OrderStatus result = OrderStatus.forNumber(status_);
    return result == null ? OrderStatus.UNRECOGNIZED : result;
  }

  public static final int ISSUCCESS_FIELD_NUMBER = 3;
  private boolean isSuccess_ = false;
  /**
   * <code>bool isSuccess = 3;</code>
   * @return The isSuccess.
   */
  @Override
  public boolean getIsSuccess() {
    return isSuccess_;
  }

  public static final int PAYLOAD_FIELD_NUMBER = 2;
  @SuppressWarnings("serial")
  private volatile Object payload_ = "";
  /**
   * <code>string payload = 2;</code>
   * @return The payload.
   */
  @Override
  public String getPayload() {
    Object ref = payload_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      payload_ = s;
      return s;
    }
  }
  /**
   * <code>string payload = 2;</code>
   * @return The bytes for payload.
   */
  @Override
  public com.google.protobuf.ByteString
      getPayloadBytes() {
    Object ref = payload_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      payload_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (status_ != OrderStatus.NEW.getNumber()) {
      output.writeEnum(1, status_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(payload_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, payload_);
    }
    if (isSuccess_ != false) {
      output.writeBool(3, isSuccess_);
    }
    getUnknownFields().writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (status_ != OrderStatus.NEW.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, status_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(payload_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, payload_);
    }
    if (isSuccess_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(3, isSuccess_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof GetOrderStatusResponse)) {
      return super.equals(obj);
    }
    GetOrderStatusResponse other = (GetOrderStatusResponse) obj;

    if (status_ != other.status_) return false;
    if (getIsSuccess()
        != other.getIsSuccess()) return false;
    if (!getPayload()
        .equals(other.getPayload())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + STATUS_FIELD_NUMBER;
    hash = (53 * hash) + status_;
    hash = (37 * hash) + ISSUCCESS_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getIsSuccess());
    hash = (37 * hash) + PAYLOAD_FIELD_NUMBER;
    hash = (53 * hash) + getPayload().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static GetOrderStatusResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static GetOrderStatusResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static GetOrderStatusResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static GetOrderStatusResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static GetOrderStatusResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static GetOrderStatusResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static GetOrderStatusResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static GetOrderStatusResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static GetOrderStatusResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static GetOrderStatusResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static GetOrderStatusResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static GetOrderStatusResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(GetOrderStatusResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @Override
  protected Builder newBuilderForType(
      BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code coin.algorithm.grpc.service.generated.GetOrderStatusResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:coin.algorithm.grpc.service.generated.GetOrderStatusResponse)
      GetOrderStatusResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return CoinService.internal_static_coin_algorithm_grpc_service_generated_GetOrderStatusResponse_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return CoinService.internal_static_coin_algorithm_grpc_service_generated_GetOrderStatusResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              GetOrderStatusResponse.class, Builder.class);
    }

    // Construct using coin.algorithm.grpc.service.GetOrderStatusResponse.newBuilder()
    private Builder() {

    }

    private Builder(
        BuilderParent parent) {
      super(parent);

    }
    @Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      status_ = 0;
      isSuccess_ = false;
      payload_ = "";
      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return CoinService.internal_static_coin_algorithm_grpc_service_generated_GetOrderStatusResponse_descriptor;
    }

    @Override
    public GetOrderStatusResponse getDefaultInstanceForType() {
      return GetOrderStatusResponse.getDefaultInstance();
    }

    @Override
    public GetOrderStatusResponse build() {
      GetOrderStatusResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public GetOrderStatusResponse buildPartial() {
      GetOrderStatusResponse result = new GetOrderStatusResponse(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(GetOrderStatusResponse result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.status_ = status_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.isSuccess_ = isSuccess_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.payload_ = payload_;
      }
    }

    @Override
    public Builder clone() {
      return super.clone();
    }
    @Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.setField(field, value);
    }
    @Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return super.addRepeatedField(field, value);
    }
    @Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof GetOrderStatusResponse) {
        return mergeFrom((GetOrderStatusResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(GetOrderStatusResponse other) {
      if (other == GetOrderStatusResponse.getDefaultInstance()) return this;
      if (other.status_ != 0) {
        setStatusValue(other.getStatusValue());
      }
      if (other.getIsSuccess() != false) {
        setIsSuccess(other.getIsSuccess());
      }
      if (!other.getPayload().isEmpty()) {
        payload_ = other.payload_;
        bitField0_ |= 0x00000004;
        onChanged();
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @Override
    public final boolean isInitialized() {
      return true;
    }

    @Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {
              status_ = input.readEnum();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            case 18: {
              payload_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000004;
              break;
            } // case 18
            case 24: {
              isSuccess_ = input.readBool();
              bitField0_ |= 0x00000002;
              break;
            } // case 24
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private int status_ = 0;
    /**
     * <code>.coin.algorithm.grpc.service.generated.OrderStatus status = 1;</code>
     * @return The enum numeric value on the wire for status.
     */
    @Override public int getStatusValue() {
      return status_;
    }
    /**
     * <code>.coin.algorithm.grpc.service.generated.OrderStatus status = 1;</code>
     * @param value The enum numeric value on the wire for status to set.
     * @return This builder for chaining.
     */
    public Builder setStatusValue(int value) {
      status_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.coin.algorithm.grpc.service.generated.OrderStatus status = 1;</code>
     * @return The status.
     */
    @Override
    public OrderStatus getStatus() {
      OrderStatus result = OrderStatus.forNumber(status_);
      return result == null ? OrderStatus.UNRECOGNIZED : result;
    }
    /**
     * <code>.coin.algorithm.grpc.service.generated.OrderStatus status = 1;</code>
     * @param value The status to set.
     * @return This builder for chaining.
     */
    public Builder setStatus(OrderStatus value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000001;
      status_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.coin.algorithm.grpc.service.generated.OrderStatus status = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearStatus() {
      bitField0_ = (bitField0_ & ~0x00000001);
      status_ = 0;
      onChanged();
      return this;
    }

    private boolean isSuccess_ ;
    /**
     * <code>bool isSuccess = 3;</code>
     * @return The isSuccess.
     */
    @Override
    public boolean getIsSuccess() {
      return isSuccess_;
    }
    /**
     * <code>bool isSuccess = 3;</code>
     * @param value The isSuccess to set.
     * @return This builder for chaining.
     */
    public Builder setIsSuccess(boolean value) {

      isSuccess_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>bool isSuccess = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearIsSuccess() {
      bitField0_ = (bitField0_ & ~0x00000002);
      isSuccess_ = false;
      onChanged();
      return this;
    }

    private Object payload_ = "";
    /**
     * <code>string payload = 2;</code>
     * @return The payload.
     */
    public String getPayload() {
      Object ref = payload_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        payload_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string payload = 2;</code>
     * @return The bytes for payload.
     */
    public com.google.protobuf.ByteString
        getPayloadBytes() {
      Object ref = payload_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        payload_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string payload = 2;</code>
     * @param value The payload to set.
     * @return This builder for chaining.
     */
    public Builder setPayload(
        String value) {
      if (value == null) { throw new NullPointerException(); }
      payload_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>string payload = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearPayload() {
      payload_ = getDefaultInstance().getPayload();
      bitField0_ = (bitField0_ & ~0x00000004);
      onChanged();
      return this;
    }
    /**
     * <code>string payload = 2;</code>
     * @param value The bytes for payload to set.
     * @return This builder for chaining.
     */
    public Builder setPayloadBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      payload_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    @Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:coin.algorithm.grpc.service.generated.GetOrderStatusResponse)
  }

  // @@protoc_insertion_point(class_scope:coin.algorithm.grpc.service.generated.GetOrderStatusResponse)
  private static final GetOrderStatusResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new GetOrderStatusResponse();
  }

  public static GetOrderStatusResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetOrderStatusResponse>
      PARSER = new com.google.protobuf.AbstractParser<GetOrderStatusResponse>() {
    @Override
    public GetOrderStatusResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<GetOrderStatusResponse> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<GetOrderStatusResponse> getParserForType() {
    return PARSER;
  }

  @Override
  public GetOrderStatusResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

