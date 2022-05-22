
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

    private GradientDrawable mUnSelectedGradientDrawable;
    private GradientDrawable mSelectedGradientDrawable;

    private LayerDrawable mSelectedLayerDrawable;
    private LayerDrawable mUnSelectedLayerDrawable;

    private float mPadding_left;
    private float mPadding_right;
    private float mPadding_top;
    private float mPadding_bottom;

    private float mSelectedPadding_Left;
    private float mSelectedPadding_Right;
    private float mSelectedPadding_Top;
    private float mSelectedPadding_Bottom;

    private float mUnSelectedPadding_Left;
    private float mUnSelectedPadding_Right;
    private float mUnSelectedPadding_Top;
    private float mUnSelectedPadding_Bottom;

    /**
     * Put all the indicators into a ArrayList, so we can remove them easily.
     */
    private ArrayList<ImageView> mIndicators = new ArrayList<ImageView>();


    public PagerIndicator(Context context) {
        this(context,null);
    }

    public PagerIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);

        mContext = context;

        final TypedArray attributes = context.obtainStyledAttributes(attrs,R.styleable.PagerIndicator,0,0);

        int visibility = attributes.getInt(R.styleable.PagerIndicator_visibility,IndicatorVisibility.Visible.ordinal());

        for(IndicatorVisibility v : IndicatorVisibility.values()){
            if(v.ordinal() == visibility){
                mVisibility = v;
                break;
            }
        }

        int shape = attributes.getInt(R.styleable.PagerIndicator_shape, Shape.Oval.ordinal());
        for(Shape s: Shape.values()){
            if(s.ordinal() == shape){
                mIndicatorShape = s;
                break;
            }
        }

        mUserSetSelectedIndicatorResId = attributes.getResourceId(R.styleable.PagerIndicator_selected_drawable,
                0);
        mUserSetUnSelectedIndicatorResId = attributes.getResourceId(R.styleable.PagerIndicator_unselected_drawable,
                0);

        mDefaultSelectedColor = attributes.getColor(R.styleable.PagerIndicator_selected_color, Color.rgb(255, 255, 255));
        mDefaultUnSelectedColor = attributes.getColor(R.styleable.PagerIndicator_unselected_color, Color.argb(33,255,255,255));

        mDefaultSelectedWidth = attributes.getDimension(R.styleable.PagerIndicator_selected_width,(int)pxFromDp(6));
        mDefaultSelectedHeight = attributes.getDimensionPixelSize(R.styleable.PagerIndicator_selected_height,(int)pxFromDp(6));

        mDefaultUnSelectedWidth = attributes.getDimensionPixelSize(R.styleable.PagerIndicator_unselected_width,(int)pxFromDp(6));
        mDefaultUnSelectedHeight = attributes.getDimensionPixelSize(R.styleable.PagerIndicator_unselected_height,(int)pxFromDp(6));

        mSelectedGradientDrawable = new GradientDrawable();