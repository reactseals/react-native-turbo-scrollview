package com.reactlibrary;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.ReactClippingViewGroup;
import com.facebook.react.views.scroll.ReactScrollView;

import androidx.annotation.Nullable;

public class TurboScrollview extends ReactScrollView {
    private @Nullable ObjectAnimator mAnimator = null;

    public TurboScrollview(ReactContext context) {
        super(context);
    }

    public void animateScroll(int mDestX, int mDestY, int mDuration) {
        Log.d("DURATION animateScroll", String.valueOf(mDuration));

        if (mAnimator != null) {
            mAnimator.cancel();
        }
        PropertyValuesHolder scrollX = PropertyValuesHolder.ofInt("scrollX", mDestX);
        PropertyValuesHolder scrollY = PropertyValuesHolder.ofInt("scrollY", mDestY);
        mAnimator = ObjectAnimator.ofPropertyValuesHolder(this, scrollX, scrollY);
        mAnimator.setDuration(mDuration).start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (mAnimator != null) {
            mAnimator.cancel();
            mAnimator = null;
        }
        return super.onTouchEvent(ev);
    }
}
