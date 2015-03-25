// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twotoasters.jazzylistview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AbsListView;
import com.nineoldandroids.view.ViewPropertyAnimator;
import com.twotoasters.jazzylistview.effects.CardsEffect;
import com.twotoasters.jazzylistview.effects.CurlEffect;
import com.twotoasters.jazzylistview.effects.FadeEffect;
import com.twotoasters.jazzylistview.effects.FanEffect;
import com.twotoasters.jazzylistview.effects.FlipEffect;
import com.twotoasters.jazzylistview.effects.FlyEffect;
import com.twotoasters.jazzylistview.effects.GrowEffect;
import com.twotoasters.jazzylistview.effects.HelixEffect;
import com.twotoasters.jazzylistview.effects.ReverseFlyEffect;
import com.twotoasters.jazzylistview.effects.SlideInEffect;
import com.twotoasters.jazzylistview.effects.StandardEffect;
import com.twotoasters.jazzylistview.effects.TiltEffect;
import com.twotoasters.jazzylistview.effects.TwirlEffect;
import com.twotoasters.jazzylistview.effects.WaveEffect;
import com.twotoasters.jazzylistview.effects.WaveRightEffect;
import com.twotoasters.jazzylistview.effects.ZipperEffect;
import java.util.HashSet;

// Referenced classes of package com.twotoasters.jazzylistview:
//            JazzyEffect

public class JazzyHelper
    implements android.widget.AbsListView.OnScrollListener
{

    public static final int CARDS = 2;
    public static final int CURL = 3;
    public static final int DURATION = 600;
    public static final int FADE = 12;
    public static final int FAN = 9;
    public static final int FLIP = 5;
    public static final int FLY = 6;
    public static final int GROW = 1;
    public static final int HELIX = 8;
    public static final int MAX_VELOCITY_OFF = 0;
    public static final int OPAQUE = 255;
    public static final int REVERSE_FLY = 7;
    public static final int SLIDE_IN = 14;
    public static final int STANDARD = 0;
    public static final int TILT = 10;
    public static final int TRANSPARENT = 0;
    public static final int TWIRL = 13;
    public static final int WAVE = 4;
    public static final int WAVERIGHT = 15;
    public static final int ZIPPER = 11;
    private JazzyEffect a;
    private boolean b;
    private int c;
    private int d;
    private int e;
    private long f;
    private double g;
    private int h;
    private android.widget.AbsListView.OnScrollListener i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private final HashSet n = new HashSet();

    public JazzyHelper(Context context, AttributeSet attributeset)
    {
        a = null;
        b = false;
        c = -1;
        d = -1;
        e = 0;
        f = 0L;
        g = 0.0D;
        h = 0;
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, com.xiaomi.hm.health.R.styleable.JazzyListView);
        int i1 = typedarray.getInteger(0, 0);
        int j1 = typedarray.getInteger(4, 0);
        j = typedarray.getBoolean(1, false);
        k = typedarray.getBoolean(4, false);
        m = typedarray.getBoolean(3, false);
        typedarray.recycle();
        setTransitionEffect(i1);
        setMaxAnimationVelocity(j1);
    }

    private double a()
    {
        return g;
    }

    private void a(int i1, int j1)
    {
        if (h > 0 && e != i1)
        {
            long l1 = System.currentTimeMillis();
            long l2 = l1 - f;
            if (l2 < 1L)
            {
                double d1 = 1000D * (1.0D / (double)l2);
                if (d1 < 0.89999997615814209D * g)
                {
                    g = 0.89999997615814209D * g;
                } else
                if (d1 > 1.1000000238418579D * g)
                {
                    g = 1.1000000238418579D * g;
                } else
                {
                    g = d1;
                }
            } else
            {
                g = 1000D * (1.0D / (double)l2);
            }
            e = i1;
            f = l1;
        }
    }

    private void a(View view, int i1, int j1)
    {
        while (!b || j && n.contains(Integer.valueOf(i1)) || k && !l || h > 0 && (double)h < a()) 
        {
            return;
        }
        if (m)
        {
            ViewGroup viewgroup = (ViewGroup)view;
            for (int k1 = 0; k1 < viewgroup.getChildCount(); k1++)
            {
                b(viewgroup.getChildAt(k1), i1, j1);
            }

        } else
        {
            b(view, i1, j1);
        }
        n.add(Integer.valueOf(i1));
    }

    private void a(AbsListView abslistview, int i1)
    {
        if (i != null)
        {
            i.onScrollStateChanged(abslistview, i1);
        }
    }

    private void a(AbsListView abslistview, int i1, int j1, int k1)
    {
        if (i != null)
        {
            i.onScroll(abslistview, i1, j1, k1);
        }
    }

    private void b(View view, int i1, int j1)
    {
        ViewPropertyAnimator viewpropertyanimator = ViewPropertyAnimator.animate(view).setDuration(600L).setInterpolator(new AccelerateDecelerateInterpolator());
        int k1;
        if (j1 > 0)
        {
            k1 = 1;
        } else
        {
            k1 = -1;
        }
        a.initView(view, i1, k1);
        a.setupAnimation(view, i1, k1, viewpropertyanimator);
        viewpropertyanimator.start();
    }

    public final void onScroll(AbsListView abslistview, int i1, int j1, int k1)
    {
        boolean flag;
        int l1;
        if (c != -1 && d != -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        l1 = -1 + (i1 + j1);
        if (b && flag)
        {
            a(i1, k1);
            int j2 = 0;
            int i3;
            do
            {
                int k2 = i1 + j2;
                int l2 = c;
                i3 = 0;
                if (k2 >= l2)
                {
                    break;
                }
                a(abslistview.getChildAt(j2), i1 + j2, -1);
                j2++;
            } while (true);
            for (; l1 - i3 > d; i3++)
            {
                a(abslistview.getChildAt(l1 - i1 - i3), l1 - i3, 1);
            }

        } else
        if (!flag)
        {
            for (int i2 = i1; i2 < j1; i2++)
            {
                n.add(Integer.valueOf(i2));
            }

        }
        c = i1;
        d = l1;
        a(abslistview, i1, j1, k1);
    }

    public void onScrollStateChanged(AbsListView abslistview, int i1)
    {
        i1;
        JVM INSTR tableswitch 0 2: default 28
    //                   0 35
    //                   1 56
    //                   2 48;
           goto _L1 _L2 _L3 _L4
_L1:
        a(abslistview, i1);
        return;
_L2:
        b = false;
        l = false;
        continue; /* Loop/switch isn't completed */
_L4:
        l = true;
        continue; /* Loop/switch isn't completed */
_L3:
        b = true;
        l = false;
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void setMaxAnimationVelocity(int i1)
    {
        h = i1;
    }

    public void setOnScrollListener(android.widget.AbsListView.OnScrollListener onscrolllistener)
    {
        i = onscrolllistener;
    }

    public void setShouldOnlyAnimateFling(boolean flag)
    {
        k = flag;
    }

    public void setShouldOnlyAnimateNewItems(boolean flag)
    {
        j = flag;
    }

    public void setSimulateGridWithList(boolean flag)
    {
        m = flag;
    }

    public void setTransitionEffect(int i1)
    {
        switch (i1)
        {
        default:
            return;

        case 0: // '\0'
            setTransitionEffect(((JazzyEffect) (new StandardEffect())));
            return;

        case 1: // '\001'
            setTransitionEffect(((JazzyEffect) (new GrowEffect())));
            return;

        case 2: // '\002'
            setTransitionEffect(((JazzyEffect) (new CardsEffect())));
            return;

        case 3: // '\003'
            setTransitionEffect(((JazzyEffect) (new CurlEffect())));
            return;

        case 4: // '\004'
            setTransitionEffect(((JazzyEffect) (new WaveEffect())));
            return;

        case 5: // '\005'
            setTransitionEffect(((JazzyEffect) (new FlipEffect())));
            return;

        case 6: // '\006'
            setTransitionEffect(((JazzyEffect) (new FlyEffect())));
            return;

        case 7: // '\007'
            setTransitionEffect(((JazzyEffect) (new ReverseFlyEffect())));
            return;

        case 8: // '\b'
            setTransitionEffect(((JazzyEffect) (new HelixEffect())));
            return;

        case 9: // '\t'
            setTransitionEffect(((JazzyEffect) (new FanEffect())));
            return;

        case 10: // '\n'
            setTransitionEffect(((JazzyEffect) (new TiltEffect())));
            return;

        case 11: // '\013'
            setTransitionEffect(((JazzyEffect) (new ZipperEffect())));
            return;

        case 12: // '\f'
            setTransitionEffect(((JazzyEffect) (new FadeEffect())));
            return;

        case 13: // '\r'
            setTransitionEffect(((JazzyEffect) (new TwirlEffect())));
            return;

        case 14: // '\016'
            setTransitionEffect(((JazzyEffect) (new SlideInEffect())));
            return;

        case 15: // '\017'
            setTransitionEffect(((JazzyEffect) (new WaveRightEffect())));
            break;
        }
    }

    public void setTransitionEffect(JazzyEffect jazzyeffect)
    {
        a = jazzyeffect;
    }
}
