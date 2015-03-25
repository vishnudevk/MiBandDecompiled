// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.lua;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import cn.com.smartdevices.bracelet.Debug;
import com.nineoldandroids.view.animation.AnimatorProxy;

// Referenced classes of package cn.com.smartdevices.bracelet.lua:
//            o, m, LuaListAdapter, l

public class SlidingUpPanelLayout extends ViewGroup
{

    private static final int DEFAULT_ATTRS[] = {
        0x10100af
    };
    private static final int DEFAULT_FADE_COLOR = 0x99000000;
    private static final int DEFAULT_MIN_FLING_VELOCITY = 400;
    private static final boolean DEFAULT_OVERLAY_FLAG = false;
    private static final int DEFAULT_PANEL_HEIGHT = 68;
    private static final int DEFAULT_PARALAX_OFFSET = 0;
    private static final int DEFAULT_SHADOW_HEIGHT = 4;
    private static final int ONE_PAGE_ITEMS = 8;
    private static final String TAG = "chenee";
    private Boolean isPressed;
    private LuaListAdapter listAdapter;
    private float mAnchorPoint;
    private boolean mCanSlide;
    private int mCoveredFadeColor;
    private final Paint mCoveredFadePaint;
    private final ViewDragHelper mDragHelper;
    private View mDragView;
    private int mDragViewResId;
    private boolean mFirstLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private boolean mIsSlidingEnabled;
    private boolean mIsSlidingUp;
    private boolean mIsUnableToDrag;
    private boolean mIsUsingDragViewTouchEvents;
    private View mMainView;
    private int mMinFlingVelocity;
    private boolean mOverlayContent;
    private int mPanelHeight;
    private PanelSlideListener mPanelSlideListener;
    private int mParalaxOffset;
    private final int mScrollTouchSlop;
    private final Drawable mShadowDrawable;
    private int mShadowHeight;
    private float mSlideOffset;
    private int mSlideRange;
    private o mSlideState;
    private View mSlideableView;
    private final Rect mTmpRect;

    public SlidingUpPanelLayout(Context context)
    {
        this(context, null);
    }

    public SlidingUpPanelLayout(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public SlidingUpPanelLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mMinFlingVelocity = 400;
        mCoveredFadeColor = 0x99000000;
        mCoveredFadePaint = new Paint();
        mPanelHeight = -1;
        mShadowHeight = -1;
        mParalaxOffset = -1;
        mOverlayContent = false;
        mDragViewResId = -1;
        mSlideState = o.b;
        mAnchorPoint = 0.0F;
        isPressed = Boolean.valueOf(false);
        listAdapter = null;
        mFirstLayout = true;
        mTmpRect = new Rect();
        if (isInEditMode())
        {
            mShadowDrawable = null;
            mScrollTouchSlop = 0;
            mDragHelper = null;
            return;
        }
        if (attributeset != null)
        {
            TypedArray typedarray = context.obtainStyledAttributes(attributeset, DEFAULT_ATTRS);
            if (typedarray != null)
            {
                int j = typedarray.getInt(0, 0);
                if (j != 48 && j != 80)
                {
                    throw new IllegalArgumentException("gravity must be set to either top or bottom");
                }
                float f;
                TypedArray typedarray1;
                boolean flag;
                if (j == 80)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                mIsSlidingUp = flag;
            }
            typedarray.recycle();
            typedarray1 = context.obtainStyledAttributes(attributeset, com.xiaomi.hm.health.R.styleable.SlidingUpPanelLayout);
            if (typedarray1 != null)
            {
                mPanelHeight = typedarray1.getDimensionPixelSize(0, -1);
                mShadowHeight = typedarray1.getDimensionPixelSize(1, -1);
                mParalaxOffset = typedarray1.getDimensionPixelSize(2, -1);
                mMinFlingVelocity = typedarray1.getInt(4, 400);
                mCoveredFadeColor = typedarray1.getColor(3, 0x99000000);
                mDragViewResId = typedarray1.getResourceId(5, -1);
                mOverlayContent = typedarray1.getBoolean(6, false);
            }
            typedarray1.recycle();
        }
        f = context.getResources().getDisplayMetrics().density;
        if (mPanelHeight == -1)
        {
            mPanelHeight = (int)(0.5F + 68F * f);
        }
        if (mShadowHeight == -1)
        {
            mShadowHeight = (int)(0.5F + 4F * f);
        }
        if (mParalaxOffset == -1)
        {
            mParalaxOffset = (int)(0.0F * f);
        }
        if (mShadowHeight > 0)
        {
            if (mIsSlidingUp)
            {
                mShadowDrawable = getResources().getDrawable(0x7f020001);
            } else
            {
                mShadowDrawable = getResources().getDrawable(0x7f02000d);
            }
        } else
        {
            mShadowDrawable = null;
        }
        setWillNotDraw(false);
        mDragHelper = ViewDragHelper.create(this, 0.5F, new m(this, null));
        mDragHelper.setMinVelocity(f * (float)mMinFlingVelocity);
        mCanSlide = true;
        mIsSlidingEnabled = true;
        mScrollTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    private boolean collapsePane(View view, int i)
    {
        return mFirstLayout || smoothSlideTo(1.0F, i);
    }

    private boolean expandPane(View view, int i, float f)
    {
        return mFirstLayout || smoothSlideTo(f, i);
    }

    private int getSlidingTop()
    {
        if (mSlideableView != null)
        {
            if (mIsSlidingUp)
            {
                return getMeasuredHeight() - getPaddingBottom() - mSlideableView.getMeasuredHeight();
            } else
            {
                return getPaddingTop();
            }
        } else
        {
            return getMeasuredHeight() - getPaddingBottom();
        }
    }

    private static boolean hasOpaqueBackground(View view)
    {
        Drawable drawable = view.getBackground();
        return drawable != null && drawable.getOpacity() == -1;
    }

    private boolean innerListViewNeedSlide(float f)
    {
        return mInitialMotionY - f > (float)mScrollTouchSlop && listAdapter.getCount() >= 8;
    }

    private boolean isDragViewUnder(int i, int j)
    {
        boolean flag = true;
        View view;
        if (mDragView != null)
        {
            view = mDragView;
        } else
        {
            view = mSlideableView;
        }
        if (view == null)
        {
            return false;
        }
        int ai[] = new int[2];
        view.getLocationOnScreen(ai);
        int ai1[] = new int[2];
        getLocationOnScreen(ai1);
        int k = i + ai1[0];
        int i1 = j + ai1[flag];
        if (k < ai[0] || k >= ai[0] + view.getWidth() || i1 < ai[flag] || i1 >= ai[flag] + view.getHeight())
        {
            flag = false;
        }
        return flag;
    }

    private void onPanelDragged(int i)
    {
        int k;
label0:
        {
            int j = getSlidingTop();
            float f;
            if (mIsSlidingUp)
            {
                f = (float)(i - j) / (float)mSlideRange;
            } else
            {
                f = (float)(j - i) / (float)mSlideRange;
            }
            mSlideOffset = f;
            dispatchOnPanelSlide(mSlideableView);
            if (mParalaxOffset > 0)
            {
                k = getCurrentParalaxOffset();
                if (android.os.Build.VERSION.SDK_INT < 11)
                {
                    break label0;
                }
                mMainView.setTranslationY(k);
            }
            return;
        }
        AnimatorProxy.wrap(mMainView).setTranslationY(k);
    }

    protected boolean canScroll(View view, boolean flag, int i, int j, int k)
    {
        if (!(view instanceof ViewGroup)) goto _L2; else goto _L1
_L1:
        ViewGroup viewgroup;
        int i1;
        int j1;
        int k1;
        viewgroup = (ViewGroup)view;
        i1 = view.getScrollX();
        j1 = view.getScrollY();
        k1 = -1 + viewgroup.getChildCount();
_L8:
        if (k1 < 0) goto _L2; else goto _L3
_L3:
        View view1 = viewgroup.getChildAt(k1);
        if (j + i1 < view1.getLeft() || j + i1 >= view1.getRight() || k + j1 < view1.getTop() || k + j1 >= view1.getBottom() || !canScroll(view1, true, i, (j + i1) - view1.getLeft(), (k + j1) - view1.getTop())) goto _L5; else goto _L4
_L4:
        return true;
_L5:
        k1--;
        continue; /* Loop/switch isn't completed */
_L2:
        if (flag && ViewCompat.canScrollHorizontally(view, -i)) goto _L4; else goto _L6
_L6:
        return false;
        if (true) goto _L8; else goto _L7
_L7:
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return (layoutparams instanceof LayoutParams) && super.checkLayoutParams(layoutparams);
    }

    public boolean collapsePane()
    {
        return collapsePane(mSlideableView, 0);
    }

    public void computeScroll()
    {
        while (mDragHelper == null || !mDragHelper.continueSettling(true)) 
        {
            return;
        }
        if (!mCanSlide)
        {
            mDragHelper.abort();
            return;
        } else
        {
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }
    }

    void dispatchOnPanelAnchored(View view)
    {
        if (mPanelSlideListener != null)
        {
            mPanelSlideListener.onPanelAnchored(view);
        }
        sendAccessibilityEvent(32);
    }

    void dispatchOnPanelCollapsed(View view)
    {
        if (mPanelSlideListener != null)
        {
            mPanelSlideListener.onPanelCollapsed(view);
        }
        sendAccessibilityEvent(32);
    }

    void dispatchOnPanelExpanded(View view)
    {
        if (mPanelSlideListener != null)
        {
            mPanelSlideListener.onPanelExpanded(view);
        }
        sendAccessibilityEvent(32);
    }

    void dispatchOnPanelLastOffset(View view)
    {
        if (mPanelSlideListener != null)
        {
            mPanelSlideListener.onLastSlideOffset(view, mSlideOffset);
        }
    }

    void dispatchOnPanelSlide(View view)
    {
        if (mPanelSlideListener != null)
        {
            mPanelSlideListener.onPanelSlide(view, isPressed, mSlideOffset);
        }
    }

    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        if (mSlideableView != null)
        {
            int i = mSlideableView.getRight();
            int j;
            int k;
            int i1;
            if (mIsSlidingUp)
            {
                j = mSlideableView.getTop() - mShadowHeight;
                k = mSlideableView.getTop();
            } else
            {
                j = mSlideableView.getBottom();
                k = mSlideableView.getBottom() + mShadowHeight;
            }
            i1 = mSlideableView.getLeft();
            if (mShadowDrawable != null)
            {
                mShadowDrawable.setBounds(i1, j, i, k);
                mShadowDrawable.draw(canvas);
                return;
            }
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long l1)
    {
        LayoutParams layoutparams;
        int i;
        layoutparams = (LayoutParams)view.getLayoutParams();
        i = canvas.save(2);
        if (!mCanSlide || layoutparams.slideable || mSlideableView == null) goto _L2; else goto _L1
_L1:
        boolean flag;
        if (!mOverlayContent)
        {
            canvas.getClipBounds(mTmpRect);
            boolean flag1;
            int j;
            if (mIsSlidingUp)
            {
                mTmpRect.bottom = Math.min(mTmpRect.bottom, mSlideableView.getTop());
            } else
            {
                mTmpRect.top = Math.max(mTmpRect.top, mSlideableView.getBottom());
            }
            canvas.clipRect(mTmpRect);
        }
        if (mSlideOffset >= 1.0F) goto _L2; else goto _L3
_L3:
        flag = true;
_L5:
        flag1 = super.drawChild(canvas, view, l1);
        canvas.restoreToCount(i);
        if (flag)
        {
            j = (int)((float)((0xff000000 & mCoveredFadeColor) >>> 24) * (1.0F - mSlideOffset)) << 24 | 0xffffff & mCoveredFadeColor;
            mCoveredFadePaint.setColor(j);
            canvas.drawRect(mTmpRect, mCoveredFadePaint);
        }
        return flag1;
_L2:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public boolean expandPane()
    {
        return expandPane(0.0F);
    }

    public boolean expandPane(float f)
    {
        if (!isPaneVisible())
        {
            showPane();
        }
        return expandPane(mSlideableView, 0, f);
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        return new LayoutParams();
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        return new LayoutParams(getContext(), attributeset);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (layoutparams instanceof android.view.ViewGroup.MarginLayoutParams)
        {
            return new LayoutParams((android.view.ViewGroup.MarginLayoutParams)layoutparams);
        } else
        {
            return new LayoutParams(layoutparams);
        }
    }

    public int getCoveredFadeColor()
    {
        return mCoveredFadeColor;
    }

    public int getCurrentParalaxOffset()
    {
        int i = (int)((float)mParalaxOffset * (1.0F - mSlideOffset));
        if (mIsSlidingUp)
        {
            i = -i;
        }
        return i;
    }

    public int getPanelHeight()
    {
        return mPanelHeight;
    }

    int getPullDownDistance()
    {
        if (mPanelSlideListener != null)
        {
            return mPanelSlideListener.onGetPullDownDistance();
        } else
        {
            return 0;
        }
    }

    Boolean getPullDownDockEnable()
    {
        if (mPanelSlideListener != null)
        {
            return mPanelSlideListener.onGetPullDownDockEnable();
        } else
        {
            return Boolean.valueOf(true);
        }
    }

    float getSlideThreshhold()
    {
        if (mPanelSlideListener != null)
        {
            return mPanelSlideListener.onGetThreshhold();
        } else
        {
            return 0.0F;
        }
    }

    float getSlideThreshhold2()
    {
        if (mPanelSlideListener != null)
        {
            return mPanelSlideListener.onGetThreshhold2();
        } else
        {
            return 0.0F;
        }
    }

    public Boolean getSlidingEnable()
    {
        return Boolean.valueOf(mIsSlidingEnabled);
    }

    public void hidePane()
    {
        if (mSlideableView == null)
        {
            return;
        } else
        {
            mSlideableView.setVisibility(8);
            requestLayout();
            return;
        }
    }

    public boolean isAnchored()
    {
        return mSlideState == o.c;
    }

    public boolean isCollapsed()
    {
        return mSlideState == o.b;
    }

    public boolean isExpanded()
    {
        return mSlideState == o.a;
    }

    public boolean isOverlayed()
    {
        return mOverlayContent;
    }

    public boolean isPaneVisible()
    {
        boolean flag = true;
        if (getChildCount() < 2)
        {
            return false;
        }
        if (getChildAt(flag).getVisibility() != 0)
        {
            flag = false;
        }
        return flag;
    }

    public boolean isSlideable()
    {
        return mCanSlide;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        mFirstLayout = true;
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        mFirstLayout = true;
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        if (mDragViewResId != -1)
        {
            mDragView = findViewById(mDragViewResId);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        float f;
        float f1;
        int i;
        f = motionevent.getX();
        f1 = motionevent.getY();
        i = MotionEventCompat.getActionMasked(motionevent);
        if (mCanSlide && mIsSlidingEnabled && (!mIsUnableToDrag || i == 0)) goto _L2; else goto _L1
_L1:
        boolean flag;
        mDragHelper.cancel();
        flag = super.onInterceptTouchEvent(motionevent);
_L7:
        return flag;
_L2:
        if (i == 3 || i == 1)
        {
            mDragHelper.cancel();
            return false;
        }
        i;
        JVM INSTR tableswitch 0 2: default 108
    //                   0 132
    //                   1 108
    //                   2 171;
           goto _L3 _L4 _L3 _L5
_L3:
        boolean flag1 = false;
_L9:
        if (mDragHelper.shouldInterceptTouchEvent(motionevent))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = false;
        if (!flag1) goto _L7; else goto _L6
_L6:
        return true;
_L4:
        mIsUnableToDrag = false;
        mInitialMotionX = f;
        mInitialMotionY = f1;
        if (!isDragViewUnder((int)f, (int)f1) || mIsUsingDragViewTouchEvents) goto _L3; else goto _L8
_L8:
        flag1 = true;
          goto _L9
_L5:
        float f2;
        float f3;
        int j;
        f2 = Math.abs(f - mInitialMotionX);
        f3 = Math.abs(f1 - mInitialMotionY);
        j = mDragHelper.getTouchSlop();
        if (isExpanded() && listAdapter != null && innerListViewNeedSlide(f1))
        {
            setSlidingEnabled(false);
            return false;
        }
        if (!mIsUsingDragViewTouchEvents) goto _L11; else goto _L10
_L10:
        if (f2 > (float)mScrollTouchSlop && f3 < (float)mScrollTouchSlop)
        {
            return super.onInterceptTouchEvent(motionevent);
        }
        if (f3 <= (float)mScrollTouchSlop) goto _L11; else goto _L12
_L12:
        flag1 = isDragViewUnder((int)f, (int)f1);
_L13:
        if (f3 > (float)j && f2 > f3 || !isDragViewUnder((int)f, (int)f1))
        {
            mDragHelper.cancel();
            mIsUnableToDrag = true;
            return false;
        }
          goto _L9
_L11:
        flag1 = false;
          goto _L13
    }

    protected void onLayout(boolean flag, int i, int j, int k, int i1)
    {
        int j1;
        int k1;
        int l1;
        j1 = getPaddingLeft();
        k1 = getPaddingTop();
        l1 = getSlidingTop();
        int i2 = getChildCount();
        if (mFirstLayout)
        {
            int j2;
            switch (l.a[mSlideState.ordinal()])
            {
            default:
                mSlideOffset = 1.0F;
                break;

            case 1: // '\001'
                float f1;
                if (mCanSlide)
                {
                    f1 = 0.0F;
                } else
                {
                    f1 = 1.0F;
                }
                mSlideOffset = f1;
                continue;

            case 2: // '\002'
                float f;
                if (mCanSlide)
                {
                    f = mAnchorPoint;
                } else
                {
                    f = 1.0F;
                }
                mSlideOffset = f;
                continue;
            }
            break;
        }
        do
        {
            j2 = 0;
            while (j2 < i2) 
            {
                View view = getChildAt(j2);
                if (view.getVisibility() != 8)
                {
                    LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
                    int k2 = view.getMeasuredHeight();
                    if (layoutparams.slideable)
                    {
                        mSlideRange = k2 - mPanelHeight;
                    }
                    int l2;
                    if (mIsSlidingUp)
                    {
                        int i3;
                        int j3;
                        if (layoutparams.slideable)
                        {
                            j3 = l1 + (int)((float)mSlideRange * mSlideOffset);
                        } else
                        {
                            j3 = k1;
                        }
                        l2 = j3;
                    } else
                    {
                        if (layoutparams.slideable)
                        {
                            l2 = l1 - (int)((float)mSlideRange * mSlideOffset);
                        } else
                        {
                            l2 = k1;
                        }
                        if (!layoutparams.slideable && !mOverlayContent)
                        {
                            l2 += mPanelHeight;
                        }
                    }
                    i3 = l2 + k2;
                    view.layout(j1, l2, j1 + view.getMeasuredWidth(), i3);
                }
                j2++;
            }
            if (mFirstLayout)
            {
                updateObscuredViewVisibility();
            }
            mFirstLayout = false;
            return;
        } while (true);
    }

    protected void onMeasure(int i, int j)
    {
        int k = android.view.View.MeasureSpec.getMode(i);
        int i1 = android.view.View.MeasureSpec.getSize(i);
        int j1 = android.view.View.MeasureSpec.getMode(j);
        int k1 = android.view.View.MeasureSpec.getSize(j);
        if (k != 0x40000000)
        {
            throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        }
        if (j1 != 0x40000000)
        {
            throw new IllegalStateException("Height must have an exact value or MATCH_PARENT");
        }
        int l1 = k1 - getPaddingTop() - getPaddingBottom();
        int i2 = mPanelHeight;
        int j2 = getChildCount();
        int k2;
        int l2;
        if (j2 > 2)
        {
            Debug.e("chenee", "onMeasure: More than two child views are not supported.");
            k2 = i2;
        } else
        if (getChildAt(1).getVisibility() == 8)
        {
            k2 = 0;
        } else
        {
            k2 = i2;
        }
        mSlideableView = null;
        mCanSlide = false;
        l2 = 0;
        do
        {
            if (l2 < j2)
            {
                View view = getChildAt(l2);
                LayoutParams layoutparams = (LayoutParams)view.getLayoutParams();
                if (view.getVisibility() == 8)
                {
                    layoutparams.dimWhenOffset = false;
                } else
                {
                    int i3;
                    int j3;
                    int k3;
                    if (l2 == 1)
                    {
                        layoutparams.slideable = true;
                        layoutparams.dimWhenOffset = true;
                        mSlideableView = view;
                        mCanSlide = true;
                        i3 = l1;
                    } else
                    {
                        if (!mOverlayContent)
                        {
                            i3 = l1 - k2;
                        } else
                        {
                            i3 = l1;
                        }
                        mMainView = view;
                    }
                    if (layoutparams.width == -2)
                    {
                        j3 = android.view.View.MeasureSpec.makeMeasureSpec(i1, 0x80000000);
                    } else
                    if (layoutparams.width == -1)
                    {
                        j3 = android.view.View.MeasureSpec.makeMeasureSpec(i1, 0x40000000);
                    } else
                    {
                        j3 = android.view.View.MeasureSpec.makeMeasureSpec(layoutparams.width, 0x40000000);
                    }
                    if (layoutparams.height == -2)
                    {
                        k3 = android.view.View.MeasureSpec.makeMeasureSpec(i3, 0x80000000);
                    } else
                    if (layoutparams.height == -1)
                    {
                        k3 = android.view.View.MeasureSpec.makeMeasureSpec(i3, 0x40000000);
                    } else
                    {
                        k3 = android.view.View.MeasureSpec.makeMeasureSpec(layoutparams.height, 0x40000000);
                    }
                    view.measure(j3, k3);
                }
            } else
            {
                setMeasuredDimension(i1, k1);
                return;
            }
            l2++;
        } while (true);
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        SavedState savedstate = (SavedState)parcelable;
        super.onRestoreInstanceState(savedstate.getSuperState());
        mSlideState = savedstate.a;
    }

    protected Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        savedstate.a = mSlideState;
        return savedstate;
    }

    protected void onSizeChanged(int i, int j, int k, int i1)
    {
        super.onSizeChanged(i, j, k, i1);
        if (j != i1)
        {
            mFirstLayout = true;
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag;
        if (!mCanSlide || !mIsSlidingEnabled)
        {
            flag = super.onTouchEvent(motionevent);
        } else
        {
            mDragHelper.processTouchEvent(motionevent);
            int i = motionevent.getAction();
            flag = true;
            switch (i & 0xff)
            {
            default:
                return flag;

            case 0: // '\0'
                float f4 = motionevent.getX();
                float f5 = motionevent.getY();
                mInitialMotionX = f4;
                mInitialMotionY = f5;
                return flag;

            case 1: // '\001'
                dispatchOnPanelLastOffset(mSlideableView);
                break;
            }
            float f = motionevent.getX();
            float f1 = motionevent.getY();
            float f2 = f - mInitialMotionX;
            float f3 = f1 - mInitialMotionY;
            int j = mDragHelper.getTouchSlop();
            View view;
            if (mDragView != null)
            {
                view = mDragView;
            } else
            {
                view = mSlideableView;
            }
            if (f2 * f2 + f3 * f3 < (float)(j * j) && isDragViewUnder((int)f, (int)f1))
            {
                view.playSoundEffect(0);
                if (!isExpanded() && !isAnchored())
                {
                    expandPane(mAnchorPoint);
                    return flag;
                } else
                {
                    collapsePane();
                    return flag;
                }
            }
        }
        return flag;
    }

    void setAllChildrenVisible()
    {
        int i = getChildCount();
        for (int j = 0; j < i; j++)
        {
            View view = getChildAt(j);
            if (view.getVisibility() == 4)
            {
                view.setVisibility(0);
            }
        }

    }

    public void setAnchorPoint(float f)
    {
        if (f > 0.0F && f < 1.0F)
        {
            mAnchorPoint = f;
        }
    }

    public void setCoveredFadeColor(int i)
    {
        mCoveredFadeColor = i;
        invalidate();
    }

    public void setDragView(View view)
    {
        mDragView = view;
    }

    public void setEnableDragViewTouchEvents(boolean flag)
    {
        mIsUsingDragViewTouchEvents = flag;
    }

    public void setListAdapter(LuaListAdapter lualistadapter)
    {
        listAdapter = lualistadapter;
    }

    public void setOverlayed(boolean flag)
    {
        mOverlayContent = flag;
    }

    public void setPanelHeight(int i)
    {
        mPanelHeight = i;
        requestLayout();
    }

    public void setPanelSlideListener(PanelSlideListener panelslidelistener)
    {
        mPanelSlideListener = panelslidelistener;
    }

    public void setSlidingEnabled(boolean flag)
    {
        Debug.i("chenee", (new StringBuilder()).append("setSlidingEnabled  = ").append(flag).toString());
        mIsSlidingEnabled = flag;
    }

    public void showPane()
    {
        if (getChildCount() < 2)
        {
            return;
        } else
        {
            getChildAt(1).setVisibility(0);
            requestLayout();
            return;
        }
    }

    public boolean smoothSlideTo(float f, int i)
    {
        if (!mCanSlide || mDragHelper == null || mSlideableView == null)
        {
            return false;
        }
        int j = getSlidingTop();
        int k;
        if (mIsSlidingUp)
        {
            k = (int)((float)j + f * (float)mSlideRange);
        } else
        {
            k = (int)((float)j - f * (float)mSlideRange);
        }
        if (mDragHelper.smoothSlideViewTo(mSlideableView, mSlideableView.getLeft(), k))
        {
            setAllChildrenVisible();
            ViewCompat.postInvalidateOnAnimation(this);
            return true;
        } else
        {
            return false;
        }
    }

    void updateObscuredViewVisibility()
    {
        if (getChildCount() == 0)
        {
            return;
        }
        int i = getPaddingLeft();
        int j = getWidth() - getPaddingRight();
        int k = getPaddingTop();
        int i1 = getHeight() - getPaddingBottom();
        int j1;
        int k1;
        int l1;
        int i2;
        View view;
        int j2;
        int k2;
        int l2;
        int i3;
        byte byte0;
        if (mSlideableView != null && hasOpaqueBackground(mSlideableView))
        {
            i2 = mSlideableView.getLeft();
            l1 = mSlideableView.getRight();
            k1 = mSlideableView.getTop();
            j1 = mSlideableView.getBottom();
        } else
        {
            j1 = 0;
            k1 = 0;
            l1 = 0;
            i2 = 0;
        }
        view = getChildAt(0);
        j2 = Math.max(i, view.getLeft());
        k2 = Math.max(k, view.getTop());
        l2 = Math.min(j, view.getRight());
        i3 = Math.min(i1, view.getBottom());
        byte0 = 0;
        if (j2 >= i2)
        {
            byte0 = 0;
            if (k2 >= k1)
            {
                byte0 = 0;
                if (l2 <= l1)
                {
                    byte0 = 0;
                    if (i3 <= j1)
                    {
                        byte0 = 4;
                    }
                }
            }
        }
        view.setVisibility(byte0);
    }












/*
    static o access$602(SlidingUpPanelLayout slidinguppanellayout, o o1)
    {
        slidinguppanellayout.mSlideState = o1;
        return o1;
    }

*/



/*
    static Boolean access$802(SlidingUpPanelLayout slidinguppanellayout, Boolean boolean1)
    {
        slidinguppanellayout.isPressed = boolean1;
        return boolean1;
    }

*/


    private class LayoutParams extends android.view.ViewGroup.MarginLayoutParams
    {

        private static final int ATTRS[] = {
            0x1010181
        };
        Paint dimPaint;
        boolean dimWhenOffset;
        boolean slideable;


        public LayoutParams()
        {
            super(-1, -1);
        }

        public LayoutParams(int i, int j)
        {
            super(i, j);
        }

        public LayoutParams(Context context, AttributeSet attributeset)
        {
            super(context, attributeset);
            context.obtainStyledAttributes(attributeset, ATTRS).recycle();
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
        {
            super(layoutparams);
        }

        public LayoutParams(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
        {
            super(marginlayoutparams);
        }

        public LayoutParams(LayoutParams layoutparams)
        {
            super(layoutparams);
        }
    }


    private class PanelSlideListener
    {

        public abstract int onGetPullDownDistance();

        public abstract Boolean onGetPullDownDockEnable();

        public abstract float onGetThreshhold();

        public abstract float onGetThreshhold2();

        public abstract void onLastSlideOffset(View view, float f);

        public abstract void onPanelAnchored(View view);

        public abstract void onPanelCollapsed(View view);

        public abstract void onPanelExpanded(View view);

        public abstract void onPanelSlide(View view, Boolean boolean1, float f);
    }


    private class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new n();
        o a;

        public void writeToParcel(Parcel parcel, int i)
        {
            super.writeToParcel(parcel, i);
            parcel.writeString(a.toString());
        }


        private SavedState(Parcel parcel)
        {
            super(parcel);
            try
            {
                a = (o)Enum.valueOf(cn/com/smartdevices/bracelet/lua/o, parcel.readString());
                return;
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                a = o.b;
            }
        }

        SavedState(Parcel parcel, l l1)
        {
            this(parcel);
        }

        SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

}
