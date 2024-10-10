// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: coin_service.proto

// Protobuf Java Version: 3.25.1
package coin.algorithm.grpc.service;

/**
 * Protobuf enum {@code coin.algorithm.grpc.service.generated.PlotStyle}
 */
public enum PlotStyle
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>LINE = 0;</code>
   */
  LINE(0),
  /**
   * <code>COLUMN = 1;</code>
   */
  COLUMN(1),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>LINE = 0;</code>
   */
  public static final int LINE_VALUE = 0;
  /**
   * <code>COLUMN = 1;</code>
   */
  public static final int COLUMN_VALUE = 1;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @Deprecated
  public static PlotStyle valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static PlotStyle forNumber(int value) {
    switch (value) {
      case 0: return LINE;
      case 1: return COLUMN;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<PlotStyle>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      PlotStyle> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<PlotStyle>() {
          public PlotStyle findValueByNumber(int number) {
            return PlotStyle.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    if (this == UNRECOGNIZED) {
      throw new IllegalStateException(
          "Can't get the descriptor of an unrecognized enum value.");
    }
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return CoinService.getDescriptor().getEnumTypes().get(0);
  }

  private static final PlotStyle[] VALUES = values();

  public static PlotStyle valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private PlotStyle(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:coin.algorithm.grpc.service.generated.PlotStyle)
}

