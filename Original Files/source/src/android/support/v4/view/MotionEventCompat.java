// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.MotionEvent;

// Referenced classes of package android.support.v4.view:
//            K, J, L

public class MotionEventCompat
{

    public static final int ACTION_HOVER_ENTER = 9;
    public static final int ACTION_HOVER_EXIT = 10;
    public static final int ACTION_HOVER_MOVE = 7;
    public static final int ACTION_MASK = 255;
    public static final int ACTION_POINTER_DOWN = 5;
    public static final int ACTION_POINTER_INDEX_MASK = 65280;
    public static final int ACTION_POINTER_INDEX_SHIFT = 8;
    public static final int ACTION_POINTER_UP = 6;
    public static final int ACTION_SCROLL = 8;
    static final L a;

    public MotionEventCompat()
    {
    }

    public static int findPointerIndex(MotionEvent motionevent, int i)
    {
        return a.a(motionevent, i);
    }

    public static int getActionIndex(MotionEvent motionevent)
    {
        return (0xff00 & motionevent.getAction()) >> 8;
    }

    public static int getActionMasked(MotionEvent motionevent)
    {
        return 0xff & motionevent.getAction();
    }

    public static int getPointerCount(MotionEvent motionevent)
    {
        return a.a(motionevent);
    }

    public static int getPointerId(MotionEvent motionevent, int i)
    {
        return a.b(motionevent, i);
    }

    public static float getX(MotionEvent motionevent, int i)
    {
        return a.c(motionevent, i);
    }

    public static float getY(MotionEvent motionevent, int i)
    {
        return a.d(motionevent, i);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 5)
        {
            a = new K();
        } else
        {
            a = new J();
        }
    }
}
