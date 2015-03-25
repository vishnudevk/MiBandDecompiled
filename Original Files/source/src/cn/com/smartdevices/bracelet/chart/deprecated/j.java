// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.deprecated;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.deprecated:
//            DynamicDetailFragmentOld

class j
    implements android.view.View.OnTouchListener
{

    final DynamicDetailFragmentOld a;

    j(DynamicDetailFragmentOld dynamicdetailfragmentold)
    {
        a = dynamicdetailfragmentold;
        super();
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        return DynamicDetailFragmentOld.d(a).onTouchEvent(motionevent);
    }
}
