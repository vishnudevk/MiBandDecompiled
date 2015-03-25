// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// Referenced classes of package android.support.v4.widget:
//            M, SlidingPaneLayout

class N extends M
{

    private Method a;
    private Field b;

    N()
    {
        try
        {
            a = android/view/View.getDeclaredMethod("getDisplayList", (Class[])null);
        }
        catch (NoSuchMethodException nosuchmethodexception)
        {
            Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", nosuchmethodexception);
        }
        try
        {
            b = android/view/View.getDeclaredField("mRecreateDisplayList");
            b.setAccessible(true);
            return;
        }
        catch (NoSuchFieldException nosuchfieldexception)
        {
            Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", nosuchfieldexception);
        }
    }

    public void a(SlidingPaneLayout slidingpanelayout, View view)
    {
        if (a != null && b != null)
        {
            try
            {
                b.setBoolean(view, true);
                a.invoke(view, (Object[])null);
            }
            catch (Exception exception)
            {
                Log.e("SlidingPaneLayout", "Error refreshing display list state", exception);
            }
            super.a(slidingpanelayout, view);
            return;
        } else
        {
            view.invalidate();
            return;
        }
    }
}
