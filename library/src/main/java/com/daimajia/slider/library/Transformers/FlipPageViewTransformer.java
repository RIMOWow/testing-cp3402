package com.daimajia.slider.library.Transformers;

import android.os.Build;
import android.view.View;

import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.nineoldandroids.view.ViewHelper;

public class FlipPageViewTransformer extends BaseTransformer {

    @Override
    protected void onTransform(View view, float position) {
        float percen