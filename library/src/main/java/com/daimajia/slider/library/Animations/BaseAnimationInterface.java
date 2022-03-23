package com.daimajia.slider.library.Animations;

import android.view.View;

/**
 * This interface gives you chance to inject your own animation or do something when the
 * {@link com.daimajia.slider.library.Tricks.ViewPagerEx} animation (PagerTransformer) starts or ends.
 *
 *
 * There are two items you have to know. The first item is the slider you are dragging. This item
 * I call it Current Item. The second is the slider that gonna to show. I call that Next Item.
 *
 * When you start to drag the slider in front of you, onPrepareCurrentItemLeaveScreen() and
 * onPrepareNextItemShowInScreen will be called.
 *
 * When you finish drag, the onC