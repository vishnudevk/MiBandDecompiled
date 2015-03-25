// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.view.View;
import android.webkit.WebView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Referenced classes of package cn.com.smartdevices.bracelet.view:
//            w

class z
    implements ScrollDetectors.ScrollDetector
{

    private z()
    {
    }

    z(w w)
    {
        this();
    }

    public boolean canScrollHorizontal(View view, int i)
    {
        int j;
        int k;
        Method method = android/webkit/WebView.getDeclaredMethod("computeHorizontalScrollOffset", new Class[0]);
        Method method1 = android/webkit/WebView.getDeclaredMethod("computeHorizontalScrollRange", new Class[0]);
        method.setAccessible(true);
        method1.setAccessible(true);
        j = ((Integer)method.invoke(view, new Object[0])).intValue();
        k = ((Integer)method1.invoke(view, new Object[0])).intValue();
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        if (view.getScrollX() > 0)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        if (i >= 0)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        int l = view.getWidth();
        if (j >= k - l)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        return true;
        return false;
        NoSuchMethodException nosuchmethodexception;
        nosuchmethodexception;
        nosuchmethodexception.printStackTrace();
_L2:
        return false;
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        illegalargumentexception.printStackTrace();
        continue; /* Loop/switch isn't completed */
        IllegalAccessException illegalaccessexception;
        illegalaccessexception;
        illegalaccessexception.printStackTrace();
        continue; /* Loop/switch isn't completed */
        InvocationTargetException invocationtargetexception;
        invocationtargetexception;
        invocationtargetexception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

    public boolean canScrollVertical(View view, int i)
    {
        return false;
    }
}
