package com.reactlibrary;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.scroll.ReactHorizontalScrollView;
import com.facebook.react.views.scroll.ReactHorizontalScrollViewManager;
import com.facebook.react.views.scroll.ReactScrollViewCommandHelper;

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

    public void scrollTo(TurboHorizontalScrollview scrollView, TurboScrollviewCommandHelper.ScrollToCommandData data) {
        if (data.mAnimated && data.mDuration != 0) {
            if (data.mDuration > 0) {
                // data.mDuration set to -1 to fallbacks to default platform behavior
                scrollView.animateScroll(data.mDestX, data.mDestY, data.mDuration);
            } else {
                scrollView.smoothScrollTo(data.mDestX, data.mDestY);
            }
        } else {
            scrollView.scrollTo(data.mDestX, data.mDestY);
        }
    }

    public void scrollToEnd(TurboHorizontalScrollview scrollView,
            TurboScrollviewCommandHelper.ScrollToEndCommandData data) {
        // ScrollView always has one child - the scrollable area
        int right = scrollView.getChildAt(0).getWidth() + scrollView.getPaddingRight();
        if (data.mAnimated && data.mDuration != 0) {
            if (data.mDuration > 0) {
                // data.mDuration set to -1 to fallbacks to default platform behavior
                scrollView.animateScroll(right, scrollView.getScrollY(), data.mDuration);
            } else {
                scrollView.smoothScrollTo(right, scrollView.getScrollY());
            }
        } else {
            scrollView.scrollTo(right, scrollView.getScrollY());
        }
    }
}
