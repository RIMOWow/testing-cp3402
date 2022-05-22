
package com.daimajia.slider.library.Indicators;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.view.PagerAdapter;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.daimajia.slider.library.R;
import com.daimajia.slider.library.Tricks.InfinitePagerAdapter;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.ArrayList;

/**
 * Pager Indicator.
 */
public class PagerIndicator extends LinearLayout implements ViewPagerEx.OnPageChangeListener{

    private Context mContext;

    /**
     * bind this Indicator with {@link com.daimajia.slider.library.Tricks.ViewPagerEx}
     */
    private ViewPagerEx mPager;

    /**
     * Variable to remember the previous selected indicator.
     */
    private ImageView mPreviousSelectedIndicator;

    /**
     * Previous selected indicator position.
     */
    private int mPreviousSelectedPosition;

    /**
     * Custom selected indicator style resource id.
     */
    private int mUserSetUnSelectedIndicatorResId;


    /**
     * Custom unselected indicator style resource id.
     */
    private int mUserSetSelectedIndicatorResId;

    private Drawable mSelectedDrawable;
    private Drawable mUnselectedDrawable;

    /**
     *This value is from {@link com.daimajia.slider.library.SliderAdapter} getRealCount() represent
     *
     * the indicator count that we should draw.
     */
    private int mItemCount = 0;

    private Shape mIndicatorShape = Shape.Oval;

    private IndicatorVisibility mVisibility = IndicatorVisibility.Visible;

    private int mDefaultSelectedColor;
    private int mDefaultUnSelectedColor;

    private float mDefaultSelectedWidth;
    private float mDefaultSelectedHeight;

    private float mDefaultUnSelectedWidth;
    private float mDefaultUnSelectedHeight;

    public enum IndicatorVisibility{
        Visible,
        Invisible;
    };