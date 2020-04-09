package com.reactlibrary;

import android.view.View;

import androidx.appcompat.widget.AppCompatCheckBox;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.scroll.ReactScrollViewManager;

public class TurboScrollviewManager extends ReactScrollViewManager {

    public static final String REACT_CLASS = "TurboScrollview";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public TurboScrollview createViewInstance(ThemedReactContext c) {
        return new TurboScrollview(c);
    }
}
