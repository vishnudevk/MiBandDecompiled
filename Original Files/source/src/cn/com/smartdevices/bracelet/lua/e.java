// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.lua;

import android.view.MotionEvent;
import android.view.View;
import cn.com.smartdevices.bracelet.Debug;

// Referenced classes of package cn.com.smartdevices.bracelet.lua:
//            LuaListAdapterFake

class e
    implements android.view.View.OnTouchListener
{

    final LuaListAdapterFake a;

    e(LuaListAdapterFake lualistadapterfake)
    {
        a = lualistadapterfake;
        super();
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        Debug.i("chenee", "blank list item touched");
        return false;
    }
}
