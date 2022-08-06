package com.daimajia.slider.library.Transformers;

import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/**
 * Created by realandylawton on 11/22/13.
 */
public class FadeTransformer extends BaseTransformer {

    @Override
    protected void onTransform(View view, float position) {

        // Page is not an immediate sibling, just make transparent
        if(position < -1 || position > 1) {
            ViewHelper.setAlpha(view,0.6f);
        }
        // Page is sibling to left or right
        else if (position <=