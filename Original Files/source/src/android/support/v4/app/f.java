// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;
import java.lang.reflect.Method;

// Referenced classes of package android.support.v4.app:
//            g

class f
{

    private static final String a = "ActionBarDrawerToggleHoneycomb";
    private static final int b[] = {
        0x101030b
    };

    f()
    {
    }

    public static Drawable a(Activity activity)
    {
        TypedArray typedarray = activity.obtainStyledAttributes(b);
        Drawable drawable = typedarray.getDrawable(0);
        typedarray.recycle();
        return drawable;
    }

    public static Object a(Object obj, Activity activity, int i)
    {
        Object obj1;
        g g1;
        if (obj == null)
        {
            obj1 = new g(activity);
        } else
        {
            obj1 = obj;
        }
        g1 = (g)obj1;
        if (g1.a != null)
        {
            try
            {
                android.app.ActionBar actionbar = activity.getActionBar();
                Method method = g1.b;
                Object aobj[] = new Object[1];
                aobj[0] = Integer.valueOf(i);
                method.invoke(actionbar, aobj);
            }
            catch (Exception exception)
            {
                Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set content description via JB-MR2 API", exception);
                return obj1;
            }
        }
        return obj1;
    }

    public static Object a(Object obj, Activity activity, Drawable drawable, int i)
    {
        Object obj1;
        g g1;
        if (obj == null)
        {
            obj1 = new g(activity);
        } else
        {
            obj1 = obj;
        }
        g1 = (g)obj1;
        if (g1.a != null)
        {
            try
            {
                android.app.ActionBar actionbar = activity.getActionBar();
                g1.a.invoke(actionbar, new Object[] {
                    drawable
                });
                Method method = g1.b;
                Object aobj[] = new Object[1];
                aobj[0] = Integer.valueOf(i);
                method.invoke(actionbar, aobj);
            }
            catch (Exception exception)
            {
                Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set home-as-up indicator via JB-MR2 API", exception);
                return obj1;
            }
            return obj1;
        }
        if (g1.c != null)
        {
            g1.c.setImageDrawable(drawable);
            return obj1;
        } else
        {
            Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set home-as-up indicator");
            return obj1;
        }
    }

}
