// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.hardware.display;

import android.content.Context;
import android.view.Display;
import java.util.WeakHashMap;

// Referenced classes of package android.support.v4.hardware.display:
//            a, b

public abstract class DisplayManagerCompat
{

    public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";
    private static final WeakHashMap a = new WeakHashMap();

    DisplayManagerCompat()
    {
    }

    public static DisplayManagerCompat getInstance(Context context)
    {
        WeakHashMap weakhashmap = a;
        weakhashmap;
        JVM INSTR monitorenter ;
        Object obj = (DisplayManagerCompat)a.get(context);
        if (obj != null) goto _L2; else goto _L1
_L1:
        if (android.os.Build.VERSION.SDK_INT < 17)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        obj = new a(context);
_L3:
        a.put(context, obj);
_L2:
        weakhashmap;
        JVM INSTR monitorexit ;
        return ((DisplayManagerCompat) (obj));
        obj = new b(context);
          goto _L3
        Exception exception;
        exception;
        weakhashmap;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public abstract Display getDisplay(int i);

    public abstract Display[] getDisplays();

    public abstract Display[] getDisplays(String s);

}
