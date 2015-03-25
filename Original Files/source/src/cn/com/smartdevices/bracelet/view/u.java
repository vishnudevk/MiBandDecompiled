// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.os.Handler;
import android.view.MotionEvent;
import cn.com.smartdevices.bracelet.Debug;

// Referenced classes of package cn.com.smartdevices.bracelet.view:
//            RulerScrollView, v

class u extends android.view.GestureDetector.SimpleOnGestureListener
{

    final RulerScrollView a;

    u(RulerScrollView rulerscrollview)
    {
        a = rulerscrollview;
        super();
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        super.onFling(motionevent, motionevent1, f, f1);
        a.fling((int)f);
        Debug.i("RulerScrollView", (new StringBuilder()).append("fling end, vX:").append(f).toString());
        RulerScrollView.a().postDelayed(new v(this), 500L);
        return true;
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        return true;
    }
}
