// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: coin_service.proto

// Protobuf Java Version: 3.25.1
package coin.algorithm.grpc.service;

public interface ChartOrBuilder extends
    // @@protoc_insertion_point(interface_extends:coin.algorithm.grpc.service.generated.Chart)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>bool isOverlay = 1;</code>
   * @return The isOverlay.
   */
  boolean getIsOverlay();

  /**
   * <code>string name = 2;</code>
   * @return The name.
   */
  String getName();
  /**
   * <code>string name = 2;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>string backgroundColor = 3;</code>
   * @return The backgroundColor.
   */
  String getBackgroundColor();
  /**
   * <code>string backgroundColor = 3;</code>
   * @return The bytes for backgroundColor.
   */
  com.google.protobuf.ByteString
      getBackgroundColorBytes();

  /**
   * <code>int32 width = 4;</code>
   * @return The width.
   */
  int getWidth();

  /**
   * <code>int32 height = 5;</code>
   * @return The height.
   */
  int getHeight();

  /**
   * <code>repeated .coin.algorithm.grpc.service.generated.Plot plotList = 6;</code>
   */
  java.util.List<Plot>
      getPlotListList();
  /**
   * <code>repeated .coin.algorithm.grpc.service.generated.Plot plotList = 6;</code>
   */
  Plot getPlotList(int index);
  /**
   * <code>repeated .coin.algorithm.grpc.service.generated.Plot plotList = 6;</code>
   */
  int getPlotListCount();
  /**
   * <code>repeated .coin.algorithm.grpc.service.generated.Plot plotList = 6;</code>
   */
  java.util.List<? extends PlotOrBuilder>
      getPlotListOrBuilderList();
  /**
   * <code>repeated .coin.algorithm.grpc.service.generated.Plot plotList = 6;</code>
   */
  PlotOrBuilder getPlotListOrBuilder(
      int index);
}
