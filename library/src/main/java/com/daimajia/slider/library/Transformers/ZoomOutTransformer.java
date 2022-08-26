package com.daimajia.slider.library.Transformers;

import android.view.View;

import com.nineoldandroids.view.ViewHelper;

public class ZoomOutTransformer extends BaseTransformer {

    @Override
    protected void onTransform(View view, float position) {
        final float scale = 1f + Math.abs(position);
        ViewHelper.setScaleX(view,scale);
        ViewHelper.setScaleY(view,scale);