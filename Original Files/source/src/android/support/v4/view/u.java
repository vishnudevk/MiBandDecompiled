// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.KeyEvent;
import android.view.View;

class u
{

    u()
    {
    }

    public static Object a(View view)
    {
        return view.getKeyDispatcherState();
    }

    public static void a(KeyEvent keyevent)
    {
        keyevent.startTracking();
    }

    public static boolean a(KeyEvent keyevent, android.view.KeyEvent.Callback callback, Object obj, Object obj1)
    {
        return keyevent.dispatch(callback, (android.view.KeyEvent.DispatcherState)obj, obj1);
    }

    public static boolean b(KeyEvent keyevent)
    {
        return keyevent.isTracking();
    }
}
