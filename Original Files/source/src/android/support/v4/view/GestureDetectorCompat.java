// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.content.Context;
import android.os.Handler;
import android.view.MotionEvent;

// Referenced classes of package android.support.v4.view:
//            l, j, i

public class GestureDetectorCompat
{

    private final i a;

    public GestureDetectorCompat(Context context, android.view.GestureDetector.OnGestureListener ongesturelistener)
    {
        this(context, ongesturelistener, null);
    }

    public GestureDetectorCompat(Context context, android.view.GestureDetector.OnGestureListener ongesturelistener, Handler handler)
    {
        if (android.os.Build.VERSION.SDK_INT > 17)
        {
            a = new l(context, ongesturelistener, handler);
            return;
        } else
        {
            a = new j(context, ongesturelistener, handler);
            return;
        }
    }

    public boolean isLongpressEnabled()
    {
        return a.a();
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        return a.a(motionevent);
    }

    public void setIsLongpressEnabled(boolean flag)
    {
        a.a(flag);
    }

    public void setOnDoubleTapListener(android.view.GestureDetector.OnDoubleTapListener ondoubletaplistener)
    {
        a.a(ondoubletaplistener);
    }
}
