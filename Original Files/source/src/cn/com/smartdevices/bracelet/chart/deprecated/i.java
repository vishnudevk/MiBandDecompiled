// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.deprecated;

import android.os.Handler;
import android.view.MotionEvent;
import cn.com.smartdevices.bracelet.model.SportDay;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.deprecated:
//            DynamicDetailFragmentOld

class i
    implements android.view.GestureDetector.OnGestureListener
{

    final DynamicDetailFragmentOld a;

    i(DynamicDetailFragmentOld dynamicdetailfragmentold)
    {
        a = dynamicdetailfragmentold;
        super();
    }

    public boolean onDown(MotionEvent motionevent)
    {
        return false;
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        if (Math.abs(f) <= Math.abs(f1) || f <= 1000F) goto _L2; else goto _L1
_L1:
        if (DynamicDetailFragmentOld.b(a).after(DynamicDetailFragmentOld.a(a)))
        {
            DynamicDetailFragmentOld.a(a, DynamicDetailFragmentOld.b(a).addDay(-1));
            DynamicDetailFragmentOld.sRefreshHander.sendEmptyMessage(0);
        }
_L7:
        boolean flag = true;
_L4:
        return flag;
_L2:
        int j;
        j = Math.abs(f) != Math.abs(f1);
        flag = false;
        if (j <= 0) goto _L4; else goto _L3
_L3:
        int k;
        k = f != -1000F;
        flag = false;
        if (k >= 0) goto _L4; else goto _L5
_L5:
        if (DynamicDetailFragmentOld.b(a).before(DynamicDetailFragmentOld.c(a)))
        {
            DynamicDetailFragmentOld.a(a, DynamicDetailFragmentOld.b(a).addDay(1));
            DynamicDetailFragmentOld.sRefreshHander.sendEmptyMessage(0);
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void onLongPress(MotionEvent motionevent)
    {
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        return false;
    }

    public void onShowPress(MotionEvent motionevent)
    {
    }

    public boolean onSingleTapUp(MotionEvent motionevent)
    {
        return false;
    }
}
