// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;

// Referenced classes of package android.support.v4.view:
//            i

class l
    implements i
{

    private final GestureDetector a;

    public l(Context context, android.view.GestureDetector.OnGestureListener ongesturelistener, Handler handler)
    {
        a = new GestureDetector(context, ongesturelistener, handler);
    }

    public void a(android.view.GestureDetector.OnDoubleTapListener ondoubletaplistener)
    {
        a.setOnDoubleTapListener(ondoubletaplistener);
    }

    public void a(boolean flag)
    {
        a.setIsLongpressEnabled(flag);
    }

    public boolean a()
    {
        return a.isLongpressEnabled();
    }

    public boolean a(MotionEvent motionevent)
    {
        return a.onTouchEvent(motionevent);
    }
}
