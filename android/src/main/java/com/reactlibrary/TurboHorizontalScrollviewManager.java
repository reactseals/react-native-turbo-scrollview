package com.reactlibrary;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.scroll.ReactHorizontalScrollViewManager;

public class TurboHorizontalScrollviewManager extends ReactHorizontalScrollViewManager {
    public static final String REACT_CLASS = "TurboHorizontalScrollview";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public TurboHorizontalScrollview createViewInstance(ThemedReactContext c) {
        return new TurboHorizontalScrollview(c);
    }
}
