package com.daimajia.slider.library.Transformers;

import android.os.Build;
import android.view.View;

import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.nineoldandroids.view.ViewHelper;

public class FlipPageViewTransformer extends BaseTransformer {

    @Override
    protected void onTransform(View view, float position) {
        float percentage = 1 - Math.abs(position);
        if(Build.VERSION.SDK_INT >= 13){
            view.setCameraDistance(12000);
        }
        setVisibility(view, position);
        setTranslation(view);
        setSize(view, position, percent