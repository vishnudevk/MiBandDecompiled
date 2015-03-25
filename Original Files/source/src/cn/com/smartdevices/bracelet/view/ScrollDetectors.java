// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.webkit.WebView;
import android.widget.HorizontalScrollView;
import java.util.WeakHashMap;

// Referenced classes of package cn.com.smartdevices.bracelet.view:
//            y, x, z, ScrollDetectorFactory

public class ScrollDetectors
{

    private static final WeakHashMap a = new WeakHashMap();
    private static ScrollDetectorFactory b;

    public ScrollDetectors()
    {
    }

    private static ScrollDetector a(View view)
    {
        Class class1 = view.getClass();
        ScrollDetector scrolldetector = (ScrollDetector)a.get(class1);
        if (scrolldetector != null)
        {
            return scrolldetector;
        }
        Object obj;
        if (view instanceof ViewPager)
        {
            obj = new y(null);
        } else
        if (view instanceof HorizontalScrollView)
        {
            obj = new x(null);
        } else
        if (view instanceof WebView)
        {
            obj = new z(null);
        } else
        if (b != null)
        {
            obj = b.newScrollDetector(view);
        } else
        {
            return null;
        }
        a.put(class1, obj);
        return ((ScrollDetector) (obj));
    }

    public static boolean canScrollHorizontal(View view, int i)
    {
        ScrollDetector scrolldetector = a(view);
        if (scrolldetector == null)
        {
            return false;
        } else
        {
            return scrolldetector.canScrollHorizontal(view, i);
        }
    }

    public static boolean canScrollVertical(View view, int i)
    {
        ScrollDetector scrolldetector = a(view);
        if (scrolldetector == null)
        {
            return false;
        } else
        {
            return scrolldetector.canScrollVertical(view, i);
        }
    }

    public static void setScrollDetectorFactory(ScrollDetectorFactory scrolldetectorfactory)
    {
        b = scrolldetectorfactory;
    }


    private class ScrollDetector
    {

        public abstract boolean canScrollHorizontal(View view, int i);

        public abstract boolean canScrollVertical(View view, int i);
    }

}
