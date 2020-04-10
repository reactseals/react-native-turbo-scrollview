package com.reactlibrary;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.views.scroll.ScrollEventType;
import java.util.Map;

class DirectedScrollViewManager extends ViewGroupManager<DirectedScrollView> {
  public static final int COMMAND_SCROLL_TO = 1;
  public static final int COMMAND_ZOOM_TO_START = 2;

  @Override
  @NonNull
  public String getName() {
    return "DirectedScrollView";
  }

  @Override
  @NonNull
  public DirectedScrollView createViewInstance(ThemedReactContext context) {
    return new DirectedScrollView(context);
  }

  @Override
  public Map<String, Integer> getCommandsMap() {
    return MapBuilder.of("scrollTo", COMMAND_SCROLL_TO, "zoomToStart", COMMAND_ZOOM_TO_START);
  }

  @Override
  public void receiveCommand(@NonNull DirectedScrollView view, String commandId, @Nullable ReadableArray args) {
    boolean animated = args.isNull(2) && args.getBoolean(2);

    switch (commandId) {

      case "scrollTo":
        double translateX = args.isNull(0) ? 0 : args.getDouble(0);
        double translateY = args.isNull(1) ? 0 : args.getDouble(1);

        view.scrollTo(translateX, translateY, animated);
        break;
      case "zoomToStart":
        view.scrollTo(0.0, 0.0, animated);
        break;
      default:
        throw new IllegalArgumentException(
            String.format("Unsupported command %d received by %s.", commandId, getClass().getSimpleName()));
    }
  }

  @Override
  public @Nullable Map<String, Object> getExportedCustomDirectEventTypeConstants() {
    return createExportedCustomDirectEventTypeConstants();
  }

  public static Map<String, Object> createExportedCustomDirectEventTypeConstants() {
    return MapBuilder.<String, Object>builder()
        .put(ScrollEventType.getJSEventName(ScrollEventType.SCROLL), MapBuilder.of("registrationName", "onScroll"))
        .put(ScrollEventType.getJSEventName(ScrollEventType.BEGIN_DRAG),
            MapBuilder.of("registrationName", "onScrollBeginDrag"))
        .put(ScrollEventType.getJSEventName(ScrollEventType.END_DRAG),
            MapBuilder.of("registrationName", "onScrollEndDrag"))
        .put(ScrollEventType.getJSEventName(ScrollEventType.MOMENTUM_BEGIN),
            MapBuilder.of("registrationName", "onMomentumScrollBegin"))
        .put(ScrollEventType.getJSEventName(ScrollEventType.MOMENTUM_END),
            MapBuilder.of("registrationName", "onMomentumScrollEnd"))
        .build();
  }

  @ReactProp(name = "minimumZoomScale", defaultFloat = 1.0f)
  public void setMinimumZoomScale(DirectedScrollView view, @Nullable float minimumZoomScale) {
    view.setMinimumZoomScale(minimumZoomScale);
  }

  @ReactProp(name = "maximumZoomScale", defaultFloat = 1.0f)
  public void setMaximumZoomScale(DirectedScrollView view, @Nullable float maximumZoomScale) {
    view.setMaximumZoomScale(maximumZoomScale);
  }

  @ReactProp(name = "bounces", defaultBoolean = true)
  public void setBounces(DirectedScrollView view, @Nullable boolean bounces) {
    view.setBounces(bounces);
  }

  @ReactProp(name = "bouncesZoom", defaultBoolean = true)
  public void setBouncesZoom(DirectedScrollView view, @Nullable boolean bouncesZoom) {
    view.setBouncesZoom(bouncesZoom);
  }

  @ReactProp(name = "alwaysBounceHorizontal", defaultBoolean = false)
  public void setAlwaysBounceHorizontal(DirectedScrollView view, @Nullable boolean alwaysBounceHorizontal) {
    view.setAlwaysBounceHorizontal(alwaysBounceHorizontal);
  }

  @ReactProp(name = "alwaysBounceVertical", defaultBoolean = false)
  public void setAlwaysBounceVertical(DirectedScrollView view, @Nullable boolean alwaysBounceVertical) {
    view.setAlwaysBounceVertical(alwaysBounceVertical);
  }

  @ReactProp(name = "scrollEnabled", defaultBoolean = true)
  public void setScrollEnabled(DirectedScrollView view, @Nullable boolean scrollEnabled) {
    view.setScrollEnabled(scrollEnabled);
  }

  @ReactProp(name = "pinchGestureEnabled", defaultBoolean = true)
  public void setPinchGestureEnabled(DirectedScrollView view, @Nullable boolean pinchGestureEnabled) {
    view.setPinchGestureEnabled(pinchGestureEnabled);
  }
}
