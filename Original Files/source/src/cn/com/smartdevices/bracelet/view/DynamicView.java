// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.chart.DynamicPieChartView;
import cn.com.smartdevices.bracelet.chart.util.AnimUtil;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.ui.DynamicDetailActivity;
import cn.com.smartdevices.bracelet.ui.widget.PageIndicator;

// Referenced classes of package cn.com.smartdevices.bracelet.view:
//            a, f, g, h, 
//            i, j, k, l, 
//            m, b, c, d, 
//            e

public class DynamicView extends FrameLayout
    implements android.widget.ViewSwitcher.ViewFactory
{

    private static final String a = "Chart.DynamicView";
    private ImageView A;
    private int B;
    private Boolean C;
    private int D;
    private PageIndicator E;
    private ValueAnimator F;
    private ValueAnimator G;
    private ValueAnimator H;
    private ValueAnimator I;
    private ValueAnimator J;
    private ValueAnimator K;
    private Context b;
    private FlowBgView c;
    private View d;
    private ViewGroup e;
    private View f;
    private View g;
    private View h;
    private DynamicPieChartView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private int u;
    private int v;
    private Animator w;
    private Animator x;
    private ImageView y;
    private ImageView z;

    public DynamicView(Context context)
    {
        this(context, null, 0);
    }

    public DynamicView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public DynamicView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        y = null;
        z = null;
        A = null;
        C = Boolean.valueOf(false);
        D = 0;
        F = null;
        G = null;
        H = null;
        I = null;
        J = null;
        K = null;
        b = context;
        D = (int)Utils.convertDpToPixel(106F, context);
        inflate(context, 0x7f030065, this);
        d = findViewById(0x7f0a01e0);
        c = (FlowBgView)findViewById(0x7f0a01d8);
        e = (ViewGroup)findViewById(0x7f0a01db);
        f = findViewById(0x7f0a01d9);
        g = findViewById(0x7f0a01dc);
        h = findViewById(0x7f0a01e3);
        i = (DynamicPieChartView)findViewById(0x7f0a01da);
        j = (TextView)findViewById(0x7f0a01dd);
        k = (TextView)findViewById(0x7f0a01e1);
        l = (TextView)findViewById(0x7f0a01e2);
        m = (TextView)findViewById(0x7f0a01df);
        n = (TextView)findViewById(0x7f0a01de);
        o = (TextView)findViewById(0x7f0a01e4);
        p = (TextView)findViewById(0x7f0a01e5);
        q = (TextView)findViewById(0x7f0a01e6);
        r = (TextView)findViewById(0x7f0a01e7);
        s = (TextView)findViewById(0x7f0a01e9);
        t = (TextView)findViewById(0x7f0a01e8);
        g.setOnClickListener(new a(this));
        h.setOnClickListener(new f(this));
        C = Keeper.readIsPlayEnterAnimation();
        if (C.booleanValue())
        {
            if (Keeper.readPlayEnterAnimationType() == 1)
            {
                y = (ImageView)findViewById(0x7f0a01ea);
                y.setVisibility(0);
                z = (ImageView)findViewById(0x7f0a01eb);
                z.setVisibility(0);
            } else
            if (Keeper.readPlayEnterAnimationType() == 2)
            {
                A = (ImageView)findViewById(0x7f0a01ec);
                A.setVisibility(0);
                return;
            }
        }
    }

    private void a()
    {
        Intent intent = new Intent(b, cn/com/smartdevices/bracelet/ui/DynamicDetailActivity);
        intent.putExtra("Mode", B);
        b.startActivity(intent);
    }

    static void a(DynamicView dynamicview)
    {
        dynamicview.a();
    }

    private Animator b()
    {
        cn.com.smartdevices.bracelet.chart.util.AnimUtil.AnimSetBuilder.setFirstAnim(c.animFlow(), 600L);
        cn.com.smartdevices.bracelet.chart.util.AnimUtil.AnimSetBuilder.addAnim(AnimUtil.animFadeIn(this), 600L);
        cn.com.smartdevices.bracelet.chart.util.AnimUtil.AnimSetBuilder.addAnim(AnimUtil.animNumSwitch(u, v, j), 0L, 600L);
        cn.com.smartdevices.bracelet.chart.util.AnimUtil.AnimSetBuilder.addAnim(i.animRefresh(), 0L, 600L);
        return cn.com.smartdevices.bracelet.chart.util.AnimUtil.AnimSetBuilder.build();
    }

    static ViewGroup b(DynamicView dynamicview)
    {
        return dynamicview.e;
    }

    private Animator c()
    {
        cn.com.smartdevices.bracelet.chart.util.AnimUtil.AnimSetBuilder.setFirstAnim(AnimUtil.animNumSwitch(u, v, j));
        cn.com.smartdevices.bracelet.chart.util.AnimUtil.AnimSetBuilder.addAnim(i.animRefresh());
        return cn.com.smartdevices.bracelet.chart.util.AnimUtil.AnimSetBuilder.build();
    }

    static PageIndicator c(DynamicView dynamicview)
    {
        return dynamicview.E;
    }

    static DynamicPieChartView d(DynamicView dynamicview)
    {
        return dynamicview.i;
    }

    private void d()
    {
        F = ValueAnimator.ofFloat(new float[] {
            0.0F, 100F
        });
        F.setDuration(800L);
        DecelerateInterpolator decelerateinterpolator = new DecelerateInterpolator(3F);
        F.setInterpolator(decelerateinterpolator);
        F.addUpdateListener(new g(this));
        F.start();
    }

    static View e(DynamicView dynamicview)
    {
        return dynamicview.f;
    }

    private void e()
    {
        if (G != null && G.isRunning())
        {
            return;
        } else
        {
            G = ValueAnimator.ofFloat(new float[] {
                1.0F, 1.03F, 1.07F, 1.1F, 1.1F, 1.07F, 1.03F, 1.0F, 0.95F, 0.9F, 
                0.95F, 1.0F, 1.05F, 1.0F
            });
            G.setDuration(1000L);
            DecelerateInterpolator decelerateinterpolator = new DecelerateInterpolator();
            G.setInterpolator(decelerateinterpolator);
            G.addListener(new h(this));
            G.addUpdateListener(new i(this));
            G.start();
            return;
        }
    }

    private void f()
    {
        H = ValueAnimator.ofFloat(new float[] {
            0.0F, 10F, 0.0F
        });
        H.setDuration(500L);
        DecelerateInterpolator decelerateinterpolator = new DecelerateInterpolator();
        H.setInterpolator(decelerateinterpolator);
        H.addListener(new j(this));
        H.addUpdateListener(new k(this));
        H.start();
    }

    static void f(DynamicView dynamicview)
    {
        dynamicview.f();
    }

    private void g()
    {
        if (H != null)
        {
            H.end();
        }
        if (F != null)
        {
            F.end();
        }
        I = ValueAnimator.ofFloat(new float[] {
            0.0F, 100F
        });
        I.setDuration(800L);
        LinearInterpolator linearinterpolator = new LinearInterpolator();
        I.setInterpolator(linearinterpolator);
        I.addListener(new l(this));
        I.addUpdateListener(new m(this));
        I.start();
    }

    static void g(DynamicView dynamicview)
    {
        dynamicview.d();
    }

    static ImageView h(DynamicView dynamicview)
    {
        return dynamicview.y;
    }

    private void h()
    {
        if (I != null)
        {
            I.end();
        }
        if (H != null)
        {
            H.end();
        }
        if (F != null)
        {
            F.end();
        }
        J = ValueAnimator.ofFloat(new float[] {
            0.0F, 100F
        });
        J.setDuration(600L);
        LinearInterpolator linearinterpolator = new LinearInterpolator();
        J.setInterpolator(linearinterpolator);
        J.addListener(new b(this));
        J.addUpdateListener(new c(this));
        J.start();
    }

    static ImageView i(DynamicView dynamicview)
    {
        return dynamicview.z;
    }

    private void i()
    {
        if (H != null)
        {
            H.end();
        }
        if (F != null)
        {
            F.end();
        }
        K = ValueAnimator.ofFloat(new float[] {
            0.0F, 600F
        });
        K.setDuration(800L);
        LinearInterpolator linearinterpolator = new LinearInterpolator();
        K.setInterpolator(linearinterpolator);
        K.addListener(new d(this));
        K.addUpdateListener(new e(this));
        K.start();
    }

    static void j(DynamicView dynamicview)
    {
        dynamicview.g();
    }

    static ImageView k(DynamicView dynamicview)
    {
        return dynamicview.A;
    }

    public View getCenter()
    {
        return e;
    }

    public long getShowAnimDuration()
    {
        return AnimUtil.getAnimDuration((AnimatorSet)w);
    }

    public long getSwitchAnimDuration()
    {
        return AnimUtil.getAnimDuration((AnimatorSet)x);
    }

    public View makeView()
    {
        return inflate(getContext(), 0x7f030066, null);
    }

    protected void onAttachedToWindow()
    {
        boolean flag = true;
        super.onAttachedToWindow();
        startShow(false);
        if (C.booleanValue() == flag)
        {
            if (Keeper.readPlayEnterAnimationType() == flag)
            {
                h();
            } else
            if (Keeper.readPlayEnterAnimationType() == 2)
            {
                i();
            }
        }
        if (Utils.isBinded())
        {
            flag = false;
        }
        setConnectingAlpha(Boolean.valueOf(flag));
    }

    public void refresh()
    {
        refresh(false);
    }

    public void refresh(boolean flag)
    {
        if (w != null && w.isStarted())
        {
            w.end();
        }
        if (x != null && x.isStarted())
        {
            x.end();
        }
        if (!flag)
        {
            CharSequence charsequence = AnimUtil.formatNumStyle(v);
            j.setText(charsequence);
            i.refresh(false);
            return;
        } else
        {
            x = c();
            x.start();
            return;
        }
    }

    public void seekShowAnim(long l1)
    {
        if (w != null)
        {
            AnimUtil.seekAnim(this, (AnimatorSet)w, l1);
        }
    }

    public void seekSwitchAnim(long l1)
    {
        if (x != null)
        {
            AnimUtil.seekAnim(this, (AnimatorSet)x, l1);
        }
    }

    public void setConnectingAlpha(Boolean boolean1)
    {
        if (f == null)
        {
            return;
        }
        if (boolean1.booleanValue())
        {
            f.setAlpha(0.3F);
            return;
        } else
        {
            f.setAlpha(1.0F);
            e();
            return;
        }
    }

    public void setIndicator(PageIndicator pageindicator)
    {
        E = pageindicator;
    }

    public void setMode(int i1)
    {
        B = i1;
        if (B != 1) goto _L2; else goto _L1
_L1:
        g.setVisibility(0);
        h.setVisibility(8);
_L4:
        i.setMode(B);
        return;
_L2:
        if (B == 16)
        {
            g.setVisibility(8);
            h.setVisibility(0);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setSleepDeepTime(int i1)
    {
        TextView textview = s;
        Context context = getContext();
        Object aobj[] = new Object[1];
        aobj[0] = ChartData.formatTimeLengthLong(getContext(), i1);
        textview.setText(context.getString(0x7f0d0083, aobj));
    }

    public void setSleepTime(int i1)
    {
        String as[] = ChartData.formatTimeHourMinLong(i1);
        o.setText(as[0]);
        p.setText(0x7f0d01bf);
        q.setText(as[1]);
        r.setText(0x7f0d01c3);
    }

    public void setSleepTip(String s1)
    {
        t.setText(s1);
    }

    public void setSlideUpPostion(float f1)
    {
        if (f1 < 0.0F || f1 > 1.0F)
        {
            return;
        } else
        {
            float f2 = 90F - f1 * 90F;
            i.setRotationX(f2);
            i.setAlpha(f1);
            f.setTranslationY((float)(-D) * (1.0F - f1));
            m.setAlpha(f1);
            d.setAlpha(f1);
            n.setAlpha(1.0F - f1);
            t.setAlpha(f1);
            s.setAlpha(f1);
            return;
        }
    }

    public void setStepCalorie(int i1)
    {
        l.setText((new StringBuilder()).append(String.valueOf(i1)).append(getContext().getString(0x7f0d01be)).toString());
    }

    public void setStepCount(int i1)
    {
        v = i1;
        i.setValue(i1);
    }

    public void setStepDistance(String as[])
    {
        String s1 = (new StringBuilder()).append(as[0]).append(as[1]).toString();
        k.setText(s1);
    }

    public void setStepGoal(int i1)
    {
        i.setMaxValue(i1);
    }

    public void setStepTip(String s1)
    {
        m.setText(s1);
    }

    public void startShow(boolean flag)
    {
        if (!flag)
        {
            refresh(false);
            return;
        }
        if (w != null && w.isStarted())
        {
            w.end();
        }
        w = b();
        w.start();
    }

    private class FlowBgView extends View
    {

        private Paint a;
        private float b;
        private float c;
        private float d;
        private float e;

        static float a(FlowBgView flowbgview)
        {
            return flowbgview.b;
        }

        static float a(FlowBgView flowbgview, float f1)
        {
            flowbgview.e = f1;
            return f1;
        }

        public Animator animFlow()
        {
            return AnimUtil.animFlow(new n(this));
        }

        protected void onDraw(Canvas canvas)
        {
            canvas.drawCircle(c, d, e, a);
        }

        protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
        {
            super.onLayout(flag, i1, j1, k1, l1);
            int i2 = k1 - i1;
            int j2 = l1 - j1;
            b = j2;
            e = b;
            c = (float)i2 / 2.0F;
            d = 0.4203719F * (float)j2;
        }

        public FlowBgView(Context context)
        {
            this(context, null, 0);
        }

        public FlowBgView(Context context, AttributeSet attributeset)
        {
            this(context, attributeset, 0);
        }

        public FlowBgView(Context context, AttributeSet attributeset, int i1)
        {
            super(context, attributeset, i1);
            a = new Paint();
            a.setColor(0xff2980b9);
        }
    }

}
