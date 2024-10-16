// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: coin_service.proto

// Protobuf Java Version: 3.25.1
package coin.algorithm.grpc.service;

public interface PlotOrBuilder extends
    // @@protoc_insertion_point(interface_extends:coin.algorithm.grpc.service.generated.Plot)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string name = 1;</code>
   * @return The name.
   */
  String getName();
  /**
   * <code>string name = 1;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>string color = 2;</code>
   * @return The color.
   */
  String getColor();
  /**
   * <code>string color = 2;</code>
   * @return The bytes for color.
   */
  com.google.protobuf.ByteString
      getColorBytes();

  /**
   * <code>.coin.algorithm.grpc.service.generated.PlotStyle style = 3;</code>
   * @return The enum numeric value on the wire for style.
   */
  int getStyleValue();
  /**
   * <code>.coin.algorithm.grpc.service.generated.PlotStyle style = 3;</code>
   * @return The style.
   */
  PlotStyle getStyle();

  /**
   * <code>int32 pricePrecision = 4;</code>
   * @return The pricePrecision.
   */
  int getPricePrecision();

  /**
   * <code>repeated float valueList = 5;</code>
   * @return A list containing the valueList.
   */
  java.util.List<Float> getValueListList();
  /**
   * <code>repeated float valueList = 5;</code>
   * @return The count of valueList.
   */
  int getValueListCount();
  /**
   * <code>repeated float valueList = 5;</code>
   * @param index The index of the element to return.
   * @return The valueList at the given index.
   */
  float getValueList(int index);
}
