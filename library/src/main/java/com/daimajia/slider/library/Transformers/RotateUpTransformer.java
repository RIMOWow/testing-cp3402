package com.daimajia.slider.library.Transformers;

import android.view.View;

import com.nineoldandroids.view.ViewHelper;

public class RotateUpTransformer extends BaseTransformer {

	private static final float ROT_MOD = -15f;

	@Override
	protected void onTransform(View view, float position) {
		final float width = view.getWidth();
		final float rotation = ROT_MOD * positio