// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.ViewConfiguration;
import android.view.WindowManager;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            SystemBarTintManager, ck

public class <init>
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
        if (android.os.ager.SystemBarConfig >= 16)
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
        int i1 = android.os.ager.SystemBarConfig;
        int j1 = 0;
        if (i1 >= 14)
        {
            TypedValue typedvalue = new TypedValue();
            context.getTheme().emBarConfig(0x10102eb, typedvalue, true);
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
        int i1 = android.os.ager.SystemBarConfig;
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
        int i1 = android.os.ager.SystemBarConfig;
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

    private (Activity activity, boolean flag, boolean flag1)
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

    g(Activity activity, boolean flag, boolean flag1, ck ck)
    {
        this(activity, flag, flag1);
    }
}
