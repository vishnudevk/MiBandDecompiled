// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.connect.a.a;
import com.tencent.connect.auth.QQAuth;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.tauth.IUiListener;
import com.tencent.utils.HttpUtils;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.tencent.open:
//            z, r, F, E, 
//            D, t, G, u, 
//            w, x, s

public class TaskGuide extends BaseApi
{

    private static int K = 3000;
    static long b = 5000L;
    private static Drawable k;
    private static Drawable l;
    private static Drawable m;
    private static int n = 75;
    private static int o = 284;
    private static int p = 75;
    private static int q = 30;
    private static int r = 29;
    private static int s = 5;
    private static int t = 74;
    private static int u = 0;
    private static int v = 6;
    private static int w = 153;
    private static int x = 30;
    private static int y = 6;
    private static int z = 3;
    private int A;
    private int B;
    private float C;
    private Interpolator D;
    private boolean E;
    private boolean F;
    private boolean G;
    private long H;
    private int I;
    private int J;
    private Runnable L;
    private Runnable M;
    boolean a;
    IUiListener c;
    private android.view.WindowManager.LayoutParams d;
    private ViewGroup e;
    private WindowManager f;
    private Handler g;
    private E h;
    private z i;
    private z j;

    public TaskGuide(Context context, QQAuth qqauth, QQToken qqtoken)
    {
        super(context, qqauth, qqtoken);
        d = null;
        e = null;
        g = new Handler(Looper.getMainLooper());
        i = com.tencent.open.z.a;
        j = com.tencent.open.z.a;
        A = 0;
        B = 0;
        C = 0.0F;
        D = new AccelerateInterpolator();
        E = false;
        a = false;
        F = false;
        G = false;
        L = null;
        M = null;
        f = (WindowManager)context.getSystemService("window");
        d();
    }

    public TaskGuide(Context context, QQToken qqtoken)
    {
        super(context, qqtoken);
        d = null;
        e = null;
        g = new Handler(Looper.getMainLooper());
        i = com.tencent.open.z.a;
        j = com.tencent.open.z.a;
        A = 0;
        B = 0;
        C = 0.0F;
        D = new AccelerateInterpolator();
        E = false;
        a = false;
        F = false;
        G = false;
        L = null;
        M = null;
        f = (WindowManager)context.getSystemService("window");
        d();
    }

    static int a()
    {
        return p;
    }

    private int a(int i1)
    {
        return (int)((float)i1 * C);
    }

    private Drawable a(String s1, Context context)
    {
        AssetManager assetmanager = context.getApplicationContext().getAssets();
        InputStream inputstream = assetmanager.open(s1);
        if (inputstream == null)
        {
            return null;
        }
        if (!s1.endsWith(".9.png")) goto _L2; else goto _L1
_L1:
        Bitmap bitmap = BitmapFactory.decodeStream(inputstream);
        if (bitmap == null) goto _L4; else goto _L3
_L3:
        NinePatchDrawable ninepatchdrawable;
        byte abyte0[] = bitmap.getNinePatchChunk();
        NinePatch.isNinePatchChunk(abyte0);
        ninepatchdrawable = new NinePatchDrawable(bitmap, abyte0, new Rect(), null);
        return ninepatchdrawable;
        IOException ioexception;
        ioexception;
        Drawable drawable;
        IOException ioexception1;
        drawable = null;
        ioexception1 = ioexception;
_L6:
        ioexception1.printStackTrace();
        return drawable;
_L4:
        return null;
_L2:
        Drawable drawable1 = Drawable.createFromStream(inputstream, s1);
        drawable = drawable1;
        inputstream.close();
        return drawable;
        ioexception1;
        if (true) goto _L6; else goto _L5
_L5:
    }

    static ViewGroup a(TaskGuide taskguide, Context context)
    {
        return taskguide.b(context);
    }

    static ViewGroup a(TaskGuide taskguide, ViewGroup viewgroup)
    {
        taskguide.e = viewgroup;
        return viewgroup;
    }

    private android.view.WindowManager.LayoutParams a(Context context)
    {
        android.view.WindowManager.LayoutParams layoutparams = new android.view.WindowManager.LayoutParams();
        layoutparams.gravity = 49;
        f.getDefaultDisplay().getWidth();
        f.getDefaultDisplay().getHeight();
        layoutparams.width = a(o);
        layoutparams.height = a(n);
        layoutparams.windowAnimations = 0x1030002;
        layoutparams.format = 1;
        layoutparams.flags = 0x208 | layoutparams.flags;
        layoutparams.type = 2;
        d = layoutparams;
        return layoutparams;
    }

    static android.view.WindowManager.LayoutParams a(TaskGuide taskguide, android.view.WindowManager.LayoutParams layoutparams)
    {
        taskguide.d = layoutparams;
        return layoutparams;
    }

    static E a(TaskGuide taskguide, E e1)
    {
        taskguide.h = e1;
        return e1;
    }

    static z a(TaskGuide taskguide, int i1)
    {
        return taskguide.c(i1);
    }

    private void a(int i1, z z1)
    {
        if (i1 == 0)
        {
            i = z1;
            return;
        }
        if (i1 == 1)
        {
            j = z1;
            return;
        } else
        {
            i = z1;
            j = z1;
            return;
        }
    }

    static void a(TaskGuide taskguide, int i1, z z1)
    {
        taskguide.a(i1, z1);
    }

    static void a(TaskGuide taskguide, String s1)
    {
        taskguide.a(s1);
    }

    private void a(String s1)
    {
        g.post(new r(this, s1));
    }

    private void a(boolean flag)
    {
        H = SystemClock.currentThreadTimeMillis();
        android.view.WindowManager.LayoutParams layoutparams;
        if (flag)
        {
            F = true;
        } else
        {
            G = true;
        }
        I = d.height;
        J = d.y;
        layoutparams = d;
        layoutparams.flags = 0x10 | layoutparams.flags;
        f.updateViewLayout(e, d);
    }

    static boolean a(TaskGuide taskguide)
    {
        return taskguide.E;
    }

    static boolean a(TaskGuide taskguide, boolean flag)
    {
        taskguide.E = flag;
        return flag;
    }

    private ViewGroup b(Context context)
    {
        F f1 = new F(this, context);
        A aa[] = h.c;
        if (aa.length == 1)
        {
            D d1 = new D(this, context, aa[0]);
            d1.setId(1);
            android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -2);
            layoutparams.addRule(15);
            f1.addView(d1, layoutparams);
        } else
        {
            D d2 = new D(this, context, aa[0]);
            d2.setId(1);
            D d3 = new D(this, context, aa[1]);
            d3.setId(2);
            android.widget.RelativeLayout.LayoutParams layoutparams1 = new android.widget.RelativeLayout.LayoutParams(-1, -2);
            layoutparams1.addRule(14);
            layoutparams1.setMargins(0, a(6), 0, 0);
            android.widget.RelativeLayout.LayoutParams layoutparams2 = new android.widget.RelativeLayout.LayoutParams(-1, -2);
            layoutparams2.addRule(14);
            layoutparams2.setMargins(0, a(4), 0, 0);
            layoutparams2.addRule(3, 1);
            layoutparams2.addRule(5, 1);
            f1.addView(d2, layoutparams1);
            f1.addView(d3, layoutparams2);
        }
        f1.setBackgroundDrawable(f());
        return f1;
    }

    static ViewGroup b(TaskGuide taskguide)
    {
        return taskguide.e;
    }

    static android.view.WindowManager.LayoutParams b(TaskGuide taskguide, Context context)
    {
        return taskguide.a(context);
    }

    private void b(int i1)
    {
        if (g != null)
        {
            g.post(new t(this, i1));
        }
    }

    static void b(TaskGuide taskguide, int i1)
    {
        taskguide.e(i1);
    }

    static int c()
    {
        return q;
    }

    private z c(int i1)
    {
        if (i1 == 0)
        {
            return i;
        }
        if (i1 == 1)
        {
            return j;
        } else
        {
            return com.tencent.open.z.a;
        }
    }

    static z c(TaskGuide taskguide)
    {
        return taskguide.i;
    }

    static void c(TaskGuide taskguide, int i1)
    {
        taskguide.b(i1);
    }

    static int d(TaskGuide taskguide, int i1)
    {
        return taskguide.a(i1);
    }

    static z d(TaskGuide taskguide)
    {
        return taskguide.j;
    }

    private void d()
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        f.getDefaultDisplay().getMetrics(displaymetrics);
        A = displaymetrics.widthPixels;
        B = displaymetrics.heightPixels;
        C = displaymetrics.density;
    }

    private void d(int i1)
    {
        i();
        M = new G(this, null);
        g.postDelayed(M, i1);
    }

    private void e()
    {
        if (d != null)
        {
            d.y = -d.height;
        }
    }

    private void e(int i1)
    {
        Bundle bundle = composeCGIParams();
        bundle.putString("action", "get_gift");
        bundle.putString("task_id", h.a);
        bundle.putString("step_no", (new Integer(i1)).toString());
        bundle.putString("appid", mToken.getAppId());
        u u1 = new u(this, i1);
        HttpUtils.requestAsync(mToken, mContext, "http://appact.qzone.qq.com/appstore_activity_task_pcpush_sdk", bundle, "GET", u1);
        a(i1, z.c);
        com.tencent.connect.a.a.a(mContext, mToken, "TaskApi", new String[] {
            "getGift"
        });
    }

    static void e(TaskGuide taskguide)
    {
        taskguide.i();
    }

    static void e(TaskGuide taskguide, int i1)
    {
        taskguide.d(i1);
    }

    static Context f(TaskGuide taskguide)
    {
        return taskguide.mContext;
    }

    private Drawable f()
    {
        if (k == null)
        {
            k = a("background.9.png", mContext);
        }
        return k;
    }

    static Context g(TaskGuide taskguide)
    {
        return taskguide.mContext;
    }

    private Drawable g()
    {
        if (l == null)
        {
            l = a("button_green.9.png", mContext);
        }
        return l;
    }

    private Drawable h()
    {
        if (m == null)
        {
            m = a("button_red.9.png", mContext);
        }
        return m;
    }

    static void h(TaskGuide taskguide)
    {
        taskguide.e();
    }

    static Context i(TaskGuide taskguide)
    {
        return taskguide.mContext;
    }

    private void i()
    {
        g.removeCallbacks(M);
        if (!k())
        {
            g.removeCallbacks(L);
        }
    }

    static Context j(TaskGuide taskguide)
    {
        return taskguide.mContext;
    }

    private void j()
    {
        if (F)
        {
            d(3000);
        } else
        {
            removeWindow();
        }
        if (F)
        {
            android.view.WindowManager.LayoutParams layoutparams = d;
            layoutparams.flags = 0xffffffef & layoutparams.flags;
            f.updateViewLayout(e, d);
        }
        F = false;
        G = false;
    }

    static android.view.WindowManager.LayoutParams k(TaskGuide taskguide)
    {
        return taskguide.d;
    }

    private boolean k()
    {
        return F || G;
    }

    private void l()
    {
        if (!k())
        {
            g.removeCallbacks(M);
            g.removeCallbacks(L);
            L = new w(this, true);
            a(true);
            g.post(L);
        }
    }

    static void l(TaskGuide taskguide)
    {
        taskguide.l();
    }

    static Context m(TaskGuide taskguide)
    {
        return taskguide.mContext;
    }

    private void m()
    {
        if (!k())
        {
            g.removeCallbacks(M);
            g.removeCallbacks(L);
            L = new w(this, false);
            a(false);
            g.post(L);
        }
    }

    static Context n(TaskGuide taskguide)
    {
        return taskguide.mContext;
    }

    static Drawable o(TaskGuide taskguide)
    {
        return taskguide.g();
    }

    static Drawable p(TaskGuide taskguide)
    {
        return taskguide.h();
    }

    static void q(TaskGuide taskguide)
    {
        taskguide.m();
    }

    static Interpolator r(TaskGuide taskguide)
    {
        return taskguide.D;
    }

    static int s(TaskGuide taskguide)
    {
        return taskguide.I;
    }

    static int t(TaskGuide taskguide)
    {
        return taskguide.J;
    }

    static WindowManager u(TaskGuide taskguide)
    {
        return taskguide.f;
    }

    static void v(TaskGuide taskguide)
    {
        taskguide.j();
    }

    static Runnable w(TaskGuide taskguide)
    {
        return taskguide.L;
    }

    static Handler x(TaskGuide taskguide)
    {
        return taskguide.g;
    }

    static E y(TaskGuide taskguide)
    {
        return taskguide.h;
    }

    static Context z(TaskGuide taskguide)
    {
        return taskguide.mContext;
    }

    public void removeWindow()
    {
        if (E)
        {
            f.removeView(e);
            E = false;
        }
    }

    public void showTaskGuideWindow(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        mContext = activity;
        c = iuilistener;
        if (i == z.b || j == z.b || E)
        {
            return;
        }
        h = null;
        Bundle bundle1;
        x x1;
        if (bundle != null)
        {
            bundle1 = new Bundle(bundle);
            bundle1.putAll(composeCGIParams());
        } else
        {
            bundle1 = composeCGIParams();
        }
        x1 = new x(this, null);
        bundle1.putString("action", "task_list");
        bundle1.putString("auth", "mobile");
        bundle1.putString("appid", mToken.getAppId());
        HttpUtils.requestAsync(mToken, mContext, "http://appact.qzone.qq.com/appstore_activity_task_pcpush_sdk", bundle1, "GET", x1);
        a(2, z.b);
    }

    public void showWindow()
    {
        (new Handler(Looper.getMainLooper())).post(new s(this));
        com.tencent.connect.a.a.a(mContext, mToken, "TaskApi", new String[] {
            "showTaskWindow"
        });
    }

}
