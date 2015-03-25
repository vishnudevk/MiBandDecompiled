// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.KeyEvent;
import android.view.View;

// Referenced classes of package android.support.v4.view:
//            s, q, t

public class KeyEventCompat
{

    static final t a;

    public KeyEventCompat()
    {
    }

    public static boolean dispatch(KeyEvent keyevent, android.view.KeyEvent.Callback callback, Object obj, Object obj1)
    {
        return a.a(keyevent, callback, obj, obj1);
    }

    public static Object getKeyDispatcherState(View view)
    {
        return a.a(view);
    }

    public static boolean hasModifiers(KeyEvent keyevent, int i)
    {
        return a.a(keyevent.getMetaState(), i);
    }

    public static boolean hasNoModifiers(KeyEvent keyevent)
    {
        return a.b(keyevent.getMetaState());
    }

    public static boolean isTracking(KeyEvent keyevent)
    {
        return a.b(keyevent);
    }

    public static boolean metaStateHasModifiers(int i, int j)
    {
        return a.a(i, j);
    }

    public static boolean metaStateHasNoModifiers(int i)
    {
        return a.b(i);
    }

    public static int normalizeMetaState(int i)
    {
        return a.a(i);
    }

    public static void startTracking(KeyEvent keyevent)
    {
        a.a(keyevent);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            a = new s();
        } else
        {
            a = new q();
        }
    }
}
