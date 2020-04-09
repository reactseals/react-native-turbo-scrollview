package com.reactlibrary;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.scroll.ReactHorizontalScrollContainerViewManager;
import com.facebook.react.views.scroll.ReactHorizontalScrollViewManager;

public class TurboHorizontalScrollContentViewManager extends ReactHorizontalScrollContainerViewManager {
    public static final String REACT_CLASS = "TurboHorizontalScrollContainerView";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public TurboHorizontalScrollContentView createViewInstance(ThemedReactContext c) {
        return new TurboHorizontalScrollContentView(c);
    }
}
