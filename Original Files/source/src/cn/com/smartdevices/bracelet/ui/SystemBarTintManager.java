// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.lang.reflect.Method;

public class SystemBarTintManager
{

    public static final int DEFAULT_TINT_COLOR = 0x99000000;
    private static String a;
    private final SystemBarConfig b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private View g;
    private View h;

    public SystemBarTintManager(Activity activity)
    {
        Window window;
        ViewGroup viewgroup;
        TypedArray typedarray;
        window = activity.getWindow();
        viewgroup = (ViewGroup)window.getDecorView();
        if (android.os.Build.VERSION.SDK_INT < 19)
        {
            break MISSING_BLOCK_LABEL_109;
        }
        typedarray = activity.obtainStyledAttributes(new int[] {
            0x10103ef, 0x10103f0
        });
        c = typedarray.getBoolean(0, false);
        d = typedarray.getBoolean(1, false);
        typedarray.recycle();
        android.view.WindowManager.LayoutParams layoutparams = window.getAttributes();
        if ((0x4000000 & layoutparams.flags) != 0)
        {
            c = true;
        }
        if ((0x8000000 & layoutparams.flags) != 0)
        {
            d = true;
        }
        b = new SystemBarConfig(activity, c, d, null);
        if (!b.hasNavigtionBar())
        {
            d = false;
        }
        if (c)
        {
            a(activity, viewgroup);
        }
        if (d)
        {
            b(activity, viewgroup);
        }
        return;
        Exception exception;
        exception;
        typedarray.recycle();
        throw exception;
    }

    static String a()
    {
        return a;
    }

    private void a(Context context, ViewGroup viewgroup)
    {
        g = new View(context);
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, b.getStatusBarHeight());
        layoutparams.gravity = 48;
        if (d && !b.isNavigationAtBottom())
        {
            layoutparams.rightMargin = b.getNavigationBarWidth();
        }
        g.setLayoutParams(layoutparams);
        g.setBackgroundColor(0x99000000);
        g.setVisibility(8);
        viewgroup.addView(g);
    }

    private void b(Context context, ViewGroup viewgroup)
    {
        h = new View(context);
        android.widget.FrameLayout.LayoutParams layoutparams;
        if (b.isNavigationAtBottom())
        {
            layoutparams = new android.widget.FrameLayout.LayoutParams(-1, b.getNavigationBarHeight());
            layoutparams.gravity = 80;
        } else
        {
            layoutparams = new android.widget.FrameLayout.LayoutParams(b.getNavigationBarWidth(), -1);
            layoutparams.gravity = 5;
        }
        h.setLayoutParams(layoutparams);
        h.setBackgroundColor(0x99000000);
        h.setVisibility(8);
        viewgroup.addView(h);
    }

    public SystemBarConfig getConfig()
    {
        return b;
    }

    public boolean isNavBarTintEnabled()
    {
        return f;
    }

    public boolean isStatusBarTintEnabled()
    {
        return e;
    }

    public void setNavigationBarAlpha(float f1)
    {
        if (d && android.os.Build.VERSION.SDK_INT >= 11)
        {
            h.setAlpha(f1);
        }
    }

    public void setNavigationBarTintColor(int i)
    {
        if (d)
        {
            h.setBackgroundColor(i);
        }
    }

    public void setNavigationBarTintDrawable(Drawable drawable)
    {
        if (d)
        {
            h.setBackgroundDrawable(drawable);
        }
    }

    public void setNavigationBarTintEnabled(boolean flag)
    {
        f = flag;
        if (d)
        {
            View view = h;
            int i;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            view.setVisibility(i);
        }
    }

    public void setNavigationBarTintResource(int i)
    {
        if (d)
        {
            h.setBackgroundResource(i);
        }
    }

    public void setStatusBarAlpha(float f1)
    {
        if (c && android.os.Build.VERSION.SDK_INT >= 11)
        {
            g.setAlpha(f1);
        }
    }

    public void setStatusBarTintColor(int i)
    {
        if (c)
        {
            g.setBackgroundColor(i);
        }
    }

    public void setStatusBarTintDrawable(Drawable drawable)
    {
        if (c)
        {
            g.setBackgroundDrawable(drawable);
        }
    }

    public void setStatusBarTintEnabled(boolean flag)
    {
        e = flag;
        if (c)
        {
            View view = g;
            int i;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            view.setVisibility(i);
        }
    }

    public void setStatusBarTintResource(int i)
    {
        if (c)
        {
            g.setBackgroundResource(i);
        }
    }

    public void setTintAlpha(float f1)
    {
        setStatusBarAlpha(f1);
        setNavigationBarAlpha(f1);
    }

    public void setTintColor(int i)
    {
        setStatusBarTintColor(i);
        setNavigationBarTintColor(i);
    }

    public void setTintDrawable(Drawable drawable)
    {
        setStatusBarTintDrawable(drawable);
        setNavigationBarTintDrawable(drawable);
    }

    public void setTintResource(int i)
    {
        setStatusBarTintResource(i);
        setNavigationBarTintResource(i);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT < 19)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        Method method = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[] {
            java/lang/String
        });
        method.setAccessible(true);
        a = (String)method.invoke(null, new Object[] {
            "qemu.hw.mainkeys"
        });
        return;
        Throwable throwable;
        throwable;
        a = null;
    }

    private class SystemBarConfig
    {

        private static final String a = "status_bar_height";
        private static final String b = "navigation_bar_height";
        private static final String c = "navigation_bar_height_landscape";
        private static final String d = "navigation_bar_width";
        private static final String e = "config_showNavigationBar";
        private final boolean f;
        private final boolean g;
        private final int h;
        private final int i;
        private final boolean j;
        private final int k;
        private final int l;
        private final boolean m;
        private final float n;

        private float a(Activity activity)
        {
            DisplayMetrics displaymetrics = new DisplayMetrics();
            if (android.os.Build.VERSION.SDK_INT >= 16)
            {
                activity.getWindowManager().getDefaultDisplay().getRealMetrics(displaymetrics);
            } else
            {
                activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
            }
            return Math.min((float)displaymetrics.widthPixels / displaymetrics.density, (float)displaymetrics.heightPixels / displaymetrics.density);
        }

        private int a(Context context)
        {
            int i1 = android.os.Build.VERSION.SDK_INT;
            int j1 = 0;
            if (i1 >= 14)
            {
                TypedValue typedvalue = new TypedValue();
                context.getTheme().resolveAttribute(0x10102eb, typedvalue, true);
                j1 = context.getResources().getDimensionPixelSize(typedvalue.resourceId);
            }
            return j1;
        }

        private int a(Resources resources, String s)
        {
            int i1 = resources.getIdentifier(s, "dimen", "android");
            int j1 = 0;
            if (i1 > 0)
            {
                j1 = resources.getDimensionPixelSize(i1);
            }
            return j1;
        }

        private int b(Context context)
        {
            Resources resources = context.getResources();
            int i1 = android.os.Build.VERSION.SDK_INT;
            int j1 = 0;
            if (i1 >= 14)
            {
                boolean flag = d(context);
                j1 = 0;
                if (flag)
                {
                    String s;
                    if (m)
                    {
                        s = "navigation_bar_height";
                    } else
                    {
                        s = "navigation_bar_height_landscape";
                    }
                    j1 = a(resources, s);
                }
            }
            return j1;
        }

        private int c(Context context)
        {
            Resources resources = context.getResources();
            int i1 = android.os.Build.VERSION.SDK_INT;
            int j1 = 0;
            if (i1 >= 14)
            {
                boolean flag = d(context);
                j1 = 0;
                if (flag)
                {
                    j1 = a(resources, "navigation_bar_width");
                }
            }
            return j1;
        }

        private boolean d(Context context)
        {
            boolean flag = true;
            Resources resources = context.getResources();
            int i1 = resources.getIdentifier("config_showNavigationBar", "bool", "android");
            if (i1 != 0)
            {
                boolean flag1 = resources.getBoolean(i1);
                if ("1".equals(SystemBarTintManager.a()))
                {
                    return false;
                }
                if ("0".equals(SystemBarTintManager.a()))
                {
                    return flag;
                } else
                {
                    return flag1;
                }
            }
            if (ViewConfiguration.get(context).hasPermanentMenuKey())
            {
                flag = false;
            }
            return flag;
        }

        public int getActionBarHeight()
        {
            return i;
        }

        public int getNavigationBarHeight()
        {
            return k;
        }

        public int getNavigationBarWidth()
        {
            return l;
        }

        public int getPixelInsetBottom()
        {
            if (g && isNavigationAtBottom())
            {
                return k;
            } else
            {
                return 0;
            }
        }

        public int getPixelInsetRight()
        {
            if (g && !isNavigationAtBottom())
            {
                return l;
            } else
            {
                return 0;
            }
        }

        public int getPixelInsetTop(boolean flag)
        {
            int i1;
            int j1;
            if (f)
            {
                i1 = h;
            } else
            {
                i1 = 0;
            }
            j1 = 0;
            if (flag)
            {
                j1 = i;
            }
            return j1 + i1;
        }

        public int getStatusBarHeight()
        {
            return h;
        }

        public boolean hasNavigtionBar()
        {
            return j;
        }

        public boolean isNavigationAtBottom()
        {
            return n >= 600F || m;
        }

        private SystemBarConfig(Activity activity, boolean flag, boolean flag1)
        {
            boolean flag2 = true;
            super();
            Resources resources = activity.getResources();
            boolean flag3;
            if (resources.getConfiguration().orientation == flag2)
            {
                flag3 = flag2;
            } else
            {
                flag3 = false;
            }
            m = flag3;
            n = a(activity);
            h = a(resources, "status_bar_height");
            i = a(activity);
            k = b(activity);
            l = c(activity);
            if (k <= 0)
            {
                flag2 = false;
            }
            j = flag2;
            f = flag;
            g = flag1;
        }

        SystemBarConfig(Activity activity, boolean flag, boolean flag1, ck ck)
        {
            this(activity, flag, flag1);
        }
    }

}
