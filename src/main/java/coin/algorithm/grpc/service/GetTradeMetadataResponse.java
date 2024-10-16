// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: coin_service.proto

// Protobuf Java Version: 3.25.1
package coin.algorithm.grpc.service;

/**
 * Protobuf type {@code coin.algorithm.grpc.service.generated.GetTradeMetadataResponse}
 */
public final class GetTradeMetadataResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:coin.algorithm.grpc.service.generated.GetTradeMetadataResponse)
    GetTradeMetadataResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GetTradeMetadataResponse.newBuilder() to construct.
  private GetTradeMetadataResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetTradeMetadataResponse() {
    onlineId_ = "";
  }

  @Override
  @SuppressWarnings({"unused"})
  protected Object newInstance(
      UnusedPrivateParameter unused) {
    return new GetTradeMetadataResponse();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return CoinService.internal_static_coin_algorithm_grpc_service_generated_GetTradeMetadataResponse_descriptor;
  }

  @Override
  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return CoinService.internal_static_coin_algorithm_grpc_service_generated_GetTradeMetadataResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            GetTradeMetadataResponse.class, Builder.class);
  }

  private int bitField0_;
  public static final int ONLINEID_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile Object onlineId_ = "";
  /**
   * <code>string onlineId = 1;</code>
   * @return The onlineId.
   */
  @Override
  public String getOnlineId() {
    Object ref = onlineId_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      onlineId_ = s;
      return s;
    }
  }
  /**
   * <code>string onlineId = 1;</code>
   * @return The bytes for onlineId.
   */
  @Override
  public com.google.protobuf.ByteString
      getOnlineIdBytes() {
    Object ref = onlineId_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (String) ref);
      onlineId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TRADEMETADATA_FIELD_NUMBER = 2;
  private TradeMetadata tradeMetadata_;
  /**
   * <code>.coin.algorithm.grpc.service.generated.TradeMetadata tradeMetadata = 2;</code>
   * @return Whether the tradeMetadata field is set.
   */
  @Override
  public boolean hasTradeMetadata() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>.coin.algorithm.grpc.service.generated.TradeMetadata tradeMetadata = 2;</code>
   * @return The tradeMetadata.
   */
  @Override
  public TradeMetadata getTradeMetadata() {
    return tradeMetadata_ == null ? TradeMetadata.getDefaultInstance() : tradeMetadata_;
  }
  /**
   * <code>.coin.algorithm.grpc.service.generated.TradeMetadata tradeMetadata = 2;</code>
   */
  @Override
  public TradeMetadataOrBuilder getTradeMetadataOrBuilder() {
    return tradeMetadata_ == null ? TradeMetadata.getDefaultInstance() : tradeMetadata_;
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(onlineId_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, onlineId_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeMessage(2, getTradeMetadata());
    }
    getUnknownFields().writeTo(output);
  }

  @Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(onlineId_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, onlineId_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getTradeMetadata());
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
    if (!(obj instanceof GetTradeMetadataResponse)) {
      return super.equals(obj);
    }
    GetTradeMetadataResponse other = (GetTradeMetadataResponse) obj;

    if (!getOnlineId()
        .equals(other.getOnlineId())) return false;
    if (hasTradeMetadata() != other.hasTradeMetadata()) return false;
    if (hasTradeMetadata()) {
      if (!getTradeMetadata()
          .equals(other.getTradeMetadata())) return false;
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
    hash = (37 * hash) + ONLINEID_FIELD_NUMBER;
    hash = (53 * hash) + getOnlineId().hashCode();
    if (hasTradeMetadata()) {
      hash = (37 * hash) + TRADEMETADATA_FIELD_NUMBER;
      hash = (53 * hash) + getTradeMetadata().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static GetTradeMetadataResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static GetTradeMetadataResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static GetTradeMetadataResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static GetTradeMetadataResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static GetTradeMetadataResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static GetTradeMetadataResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static GetTradeMetadataResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static GetTradeMetadataResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static GetTradeMetadataResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static GetTradeMetadataResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static GetTradeMetadataResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static GetTradeMetadataResponse parseFrom(
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
  public static Builder newBuilder(GetTradeMetadataResponse prototype) {
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
   * Protobuf type {@code coin.algorithm.grpc.service.generated.GetTradeMetadataResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:coin.algorithm.grpc.service.generated.GetTradeMetadataResponse)
      GetTradeMetadataResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return CoinService.internal_static_coin_algorithm_grpc_service_generated_GetTradeMetadataResponse_descriptor;
    }

    @Override
    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return CoinService.internal_static_coin_algorithm_grpc_service_generated_GetTradeMetadataResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              GetTradeMetadataResponse.class, Builder.class);
    }

    // Construct using coin.algorithm.grpc.service.GetTradeMetadataResponse.newBuilder()
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
        getTradeMetadataFieldBuilder();
      }
    }
    @Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      onlineId_ = "";
      tradeMetadata_ = null;
      if (tradeMetadataBuilder_ != null) {
        tradeMetadataBuilder_.dispose();
        tradeMetadataBuilder_ = null;
      }
      return this;
    }

    @Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return CoinService.internal_static_coin_algorithm_grpc_service_generated_GetTradeMetadataResponse_descriptor;
    }

    @Override
    public GetTradeMetadataResponse getDefaultInstanceForType() {
      return GetTradeMetadataResponse.getDefaultInstance();
    }

    @Override
    public GetTradeMetadataResponse build() {
      GetTradeMetadataResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @Override
    public GetTradeMetadataResponse buildPartial() {
      GetTradeMetadataResponse result = new GetTradeMetadataResponse(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(GetTradeMetadataResponse result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.onlineId_ = onlineId_;
      }
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.tradeMetadata_ = tradeMetadataBuilder_ == null
            ? tradeMetadata_
            : tradeMetadataBuilder_.build();
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
      if (other instanceof GetTradeMetadataResponse) {
        return mergeFrom((GetTradeMetadataResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(GetTradeMetadataResponse other) {
      if (other == GetTradeMetadataResponse.getDefaultInstance()) return this;
      if (!other.getOnlineId().isEmpty()) {
        onlineId_ = other.onlineId_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (other.hasTradeMetadata()) {
        mergeTradeMetadata(other.getTradeMetadata());
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
              onlineId_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              input.readMessage(
                  getTradeMetadataFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000002;
              break;
            } // case 18
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

    private Object onlineId_ = "";
    /**
     * <code>string onlineId = 1;</code>
     * @return The onlineId.
     */
    public String getOnlineId() {
      Object ref = onlineId_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        onlineId_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }
    /**
     * <code>string onlineId = 1;</code>
     * @return The bytes for onlineId.
     */
    public com.google.protobuf.ByteString
        getOnlineIdBytes() {
      Object ref = onlineId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        onlineId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string onlineId = 1;</code>
     * @param value The onlineId to set.
     * @return This builder for chaining.
     */
    public Builder setOnlineId(
        String value) {
      if (value == null) { throw new NullPointerException(); }
      onlineId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>string onlineId = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearOnlineId() {
      onlineId_ = getDefaultInstance().getOnlineId();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>string onlineId = 1;</code>
     * @param value The bytes for onlineId to set.
     * @return This builder for chaining.
     */
    public Builder setOnlineIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      onlineId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private TradeMetadata tradeMetadata_;
    private com.google.protobuf.SingleFieldBuilderV3<
        TradeMetadata, TradeMetadata.Builder, TradeMetadataOrBuilder> tradeMetadataBuilder_;
    /**
     * <code>.coin.algorithm.grpc.service.generated.TradeMetadata tradeMetadata = 2;</code>
     * @return Whether the tradeMetadata field is set.
     */
    public boolean hasTradeMetadata() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>.coin.algorithm.grpc.service.generated.TradeMetadata tradeMetadata = 2;</code>
     * @return The tradeMetadata.
     */
    public TradeMetadata getTradeMetadata() {
      if (tradeMetadataBuilder_ == null) {
        return tradeMetadata_ == null ? TradeMetadata.getDefaultInstance() : tradeMetadata_;
      } else {
        return tradeMetadataBuilder_.getMessage();
      }
    }
    /**
     * <code>.coin.algorithm.grpc.service.generated.TradeMetadata tradeMetadata = 2;</code>
     */
    public Builder setTradeMetadata(TradeMetadata value) {
      if (tradeMetadataBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        tradeMetadata_ = value;
      } else {
        tradeMetadataBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.coin.algorithm.grpc.service.generated.TradeMetadata tradeMetadata = 2;</code>
     */
    public Builder setTradeMetadata(
        TradeMetadata.Builder builderForValue) {
      if (tradeMetadataBuilder_ == null) {
        tradeMetadata_ = builderForValue.build();
      } else {
        tradeMetadataBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.coin.algorithm.grpc.service.generated.TradeMetadata tradeMetadata = 2;</code>
     */
    public Builder mergeTradeMetadata(TradeMetadata value) {
      if (tradeMetadataBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0) &&
          tradeMetadata_ != null &&
          tradeMetadata_ != TradeMetadata.getDefaultInstance()) {
          getTradeMetadataBuilder().mergeFrom(value);
        } else {
          tradeMetadata_ = value;
        }
      } else {
        tradeMetadataBuilder_.mergeFrom(value);
      }
      if (tradeMetadata_ != null) {
        bitField0_ |= 0x00000002;
        onChanged();
      }
      return this;
    }
    /**
     * <code>.coin.algorithm.grpc.service.generated.TradeMetadata tradeMetadata = 2;</code>
     */
    public Builder clearTradeMetadata() {
      bitField0_ = (bitField0_ & ~0x00000002);
      tradeMetadata_ = null;
      if (tradeMetadataBuilder_ != null) {
        tradeMetadataBuilder_.dispose();
        tradeMetadataBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.coin.algorithm.grpc.service.generated.TradeMetadata tradeMetadata = 2;</code>
     */
    public TradeMetadata.Builder getTradeMetadataBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getTradeMetadataFieldBuilder().getBuilder();
    }
    /**
     * <code>.coin.algorithm.grpc.service.generated.TradeMetadata tradeMetadata = 2;</code>
     */
    public TradeMetadataOrBuilder getTradeMetadataOrBuilder() {
      if (tradeMetadataBuilder_ != null) {
        return tradeMetadataBuilder_.getMessageOrBuilder();
      } else {
        return tradeMetadata_ == null ?
            TradeMetadata.getDefaultInstance() : tradeMetadata_;
      }
    }
    /**
     * <code>.coin.algorithm.grpc.service.generated.TradeMetadata tradeMetadata = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        TradeMetadata, TradeMetadata.Builder, TradeMetadataOrBuilder>
        getTradeMetadataFieldBuilder() {
      if (tradeMetadataBuilder_ == null) {
        tradeMetadataBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            TradeMetadata, TradeMetadata.Builder, TradeMetadataOrBuilder>(
                getTradeMetadata(),
                getParentForChildren(),
                isClean());
        tradeMetadata_ = null;
      }
      return tradeMetadataBuilder_;
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


    // @@protoc_insertion_point(builder_scope:coin.algorithm.grpc.service.generated.GetTradeMetadataResponse)
  }

  // @@protoc_insertion_point(class_scope:coin.algorithm.grpc.service.generated.GetTradeMetadataResponse)
  private static final GetTradeMetadataResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new GetTradeMetadataResponse();
  }

  public static GetTradeMetadataResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetTradeMetadataResponse>
      PARSER = new com.google.protobuf.AbstractParser<GetTradeMetadataResponse>() {
    @Override
    public GetTradeMetadataResponse parsePartialFrom(
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

  public static com.google.protobuf.Parser<GetTradeMetadataResponse> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<GetTradeMetadataResponse> getParserForType() {
    return PARSER;
  }

  @Override
  public GetTradeMetadataResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

