// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: coin_service.proto

// Protobuf Java Version: 3.25.1
package coin.algorithm.grpc.service;

/**
 * Protobuf type {@code coin.algorithm.grpc.service.generated.GetSignalResponse}
 */
public final class GetSignalResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:coin.algorithm.grpc.service.generated.GetSignalResponse)
    GetSignalResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GetSignalResponse.newBuilder() to construct.
  private GetSignalResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetSignalResponse() {
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new GetSignalResponse();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return CoinService.internal_static_coin_algorithm_grpc_service_generated_GetSignalResponse_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return CoinService.internal_static_coin_algorithm_grpc_service_generated_GetSignalResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            GetSignalResponse.class, Builder.class);
  }

  private int bitField0_;
  public static final int SIGNAL_FIELD_NUMBER = 1;
  private Signal signal_;
  /**
   * <code>.coin.algorithm.grpc.service.generated.Signal signal = 1;</code>
   * @return Whether the signal field is set.
   */
  @Override
  public boolean hasSignal() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>.coin.algorithm.grpc.service.generated.Signal signal = 1;</code>
   * @return The signal.
   */
  @Override
  public Signal getSignal() {
    return signal_ == null ? Signal.getDefaultInstance() : signal_;
  }
  /**
   * <code>.coin.algorithm.grpc.service.generated.Signal signal = 1;</code>
   */
  @Override
  public SignalOrBuilder getSignalOrBuilder() {
    return signal_ == null ? Signal.getDefaultInstance() : signal_;
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
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeMessage(1, getSignal());
    }
    getUnknownFields().writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getSignal());
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
    if (!(obj instanceof GetSignalResponse)) {
      return super.equals(obj);
    }
    GetSignalResponse other = (GetSignalResponse) obj;

    if (hasSignal() != other.hasSignal()) return false;
    if (hasSignal()) {
      if (!getSignal()
          .equals(other.getSignal())) return false;
    }
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
    if (hasSignal()) {
      hash = (37 * hash) + SIGNAL_FIELD_NUMBER;
      hash = (53 * hash) + getSignal().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static GetSignalResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static GetSignalResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static GetSignalResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static GetSignalResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static GetSignalResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static GetSignalResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static GetSignalResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static GetSignalResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static GetSignalResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static GetSignalResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static GetSignalResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static GetSignalResponse parseFrom(
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
  public static Builder newBuilder(GetSignalResponse prototype) {
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
   * Protobuf type {@code coin.algorithm.grpc.service.generated.GetSignalResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:coin.algorithm.grpc.service.generated.GetSignalResponse)
      GetSignalResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return CoinService.internal_static_coin_algorithm_grpc_service_generated_GetSignalResponse_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return CoinService.internal_static_coin_algorithm_grpc_service_generated_GetSignalResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              GetSignalResponse.class, Builder.class);
    }

    // Construct using coin.algorithm.grpc.service.GetSignalResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getSignalFieldBuilder();
      }
    }
    @Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      signal_ = null;
      if (signalBuilder_ != null) {
        signalBuilder_.dispose();
        signalBuilder_ = null;
      }
      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return CoinService.internal_static_coin_algorithm_grpc_service_generated_GetSignalResponse_descriptor;
    }

    @Override
    public GetSignalResponse getDefaultInstanceForType() {
      return GetSignalResponse.getDefaultInstance();
    }

    @Override
    public GetSignalResponse build() {
      GetSignalResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public GetSignalResponse buildPartial() {
      GetSignalResponse result = new GetSignalResponse(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(GetSignalResponse result) {
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.signal_ = signalBuilder_ == null
            ? signal_
            : signalBuilder_.build();
        to_bitField0_ |= 0x00000001;
      }
      result.bitField0_ |= to_bitField0_;
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
      if (other instanceof GetSignalResponse) {
        return mergeFrom((GetSignalResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(GetSignalResponse other) {
      if (other == GetSignalResponse.getDefaultInstance()) return this;
      if (other.hasSignal()) {
        mergeSignal(other.getSignal());
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
            case 10: {
              input.readMessage(
                  getSignalFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000001;
              break;
            } // case 10
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

    private Signal signal_;
    private com.google.protobuf.SingleFieldBuilderV3<
        Signal, Signal.Builder, SignalOrBuilder> signalBuilder_;
    /**
     * <code>.coin.algorithm.grpc.service.generated.Signal signal = 1;</code>
     * @return Whether the signal field is set.
     */
    public boolean hasSignal() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>.coin.algorithm.grpc.service.generated.Signal signal = 1;</code>
     * @return The signal.
     */
    public Signal getSignal() {
      if (signalBuilder_ == null) {
        return signal_ == null ? Signal.getDefaultInstance() : signal_;
      } else {
        return signalBuilder_.getMessage();
      }
    }
    /**
     * <code>.coin.algorithm.grpc.service.generated.Signal signal = 1;</code>
     */
    public Builder setSignal(Signal value) {
      if (signalBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        signal_ = value;
      } else {
        signalBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.coin.algorithm.grpc.service.generated.Signal signal = 1;</code>
     */
    public Builder setSignal(
        Signal.Builder builderForValue) {
      if (signalBuilder_ == null) {
        signal_ = builderForValue.build();
      } else {
        signalBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.coin.algorithm.grpc.service.generated.Signal signal = 1;</code>
     */
    public Builder mergeSignal(Signal value) {
      if (signalBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0) &&
          signal_ != null &&
          signal_ != Signal.getDefaultInstance()) {
          getSignalBuilder().mergeFrom(value);
        } else {
          signal_ = value;
        }
      } else {
        signalBuilder_.mergeFrom(value);
      }
      if (signal_ != null) {
        bitField0_ |= 0x00000001;
        onChanged();
      }
      return this;
    }
    /**
     * <code>.coin.algorithm.grpc.service.generated.Signal signal = 1;</code>
     */
    public Builder clearSignal() {
      bitField0_ = (bitField0_ & ~0x00000001);
      signal_ = null;
      if (signalBuilder_ != null) {
        signalBuilder_.dispose();
        signalBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.coin.algorithm.grpc.service.generated.Signal signal = 1;</code>
     */
    public Signal.Builder getSignalBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getSignalFieldBuilder().getBuilder();
    }
    /**
     * <code>.coin.algorithm.grpc.service.generated.Signal signal = 1;</code>
     */
    public SignalOrBuilder getSignalOrBuilder() {
      if (signalBuilder_ != null) {
        return signalBuilder_.getMessageOrBuilder();
      } else {
        return signal_ == null ?
            Signal.getDefaultInstance() : signal_;
      }
    }
    /**
     * <code>.coin.algorithm.grpc.service.generated.Signal signal = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        Signal, Signal.Builder, SignalOrBuilder>
        getSignalFieldBuilder() {
      if (signalBuilder_ == null) {
        signalBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            Signal, Signal.Builder, SignalOrBuilder>(
                getSignal(),
                getParentForChildren(),
                isClean());
        signal_ = null;
      }
      return signalBuilder_;
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


    // @@protoc_insertion_point(builder_scope:coin.algorithm.grpc.service.generated.GetSignalResponse)
  }

  // @@protoc_insertion_point(class_scope:coin.algorithm.grpc.service.generated.GetSignalResponse)
  private static final GetSignalResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new GetSignalResponse();
  }

  public static GetSignalResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetSignalResponse>
      PARSER = new com.google.protobuf.AbstractParser<GetSignalResponse>() {
    @Override
    public GetSignalResponse parsePartialFrom(
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

  public static com.google.protobuf.Parser<GetSignalResponse> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<GetSignalResponse> getParserForType() {
    return PARSER;
  }

  @Override
  public GetSignalResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

