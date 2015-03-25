// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.os.Handler;
import cn.com.smartdevices.bracelet.BleTask.BleCallBack;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            BaseSCActivity

class u extends BleCallBack
{

    final BaseSCActivity b;

    u(BaseSCActivity basescactivity)
    {
        b = basescactivity;
        super();
    }

    public void onFailed(Object obj)
    {
        super.onFailed(obj);
        Debug.i(BaseSCActivity.a(b), "START SYNC DATA...onFailed");
        Debug.f(BaseSCActivity.a(b), "START SYNC DATA...onFailed");
        BaseSCActivity.b(b, false);
        BaseSCActivity.m(b);
        BaseSCActivity.a(b, 11, Boolean.valueOf(false));
    }

    public void onFinish(Object obj)
    {
        super.onFinish(obj);
        Debug.i(BaseSCActivity.a(b), "START SYNC DATA...onFinish");
        Debug.f(BaseSCActivity.a(b), "START SYNC DATA...onFinish");
        BaseSCActivity.b(b, false);
        BaseSCActivity.m(b);
        if (((Long)obj).longValue() == -1L)
        {
            if (BaseSCActivity.n(b) > 0)
            {
                Debug.f(BaseSCActivity.a(b), "not synced data,we will sync again!");
                BaseSCActivity.a(b, 11, Boolean.valueOf(true));
                BaseSCActivity.o(b).sendEmptyMessage(4104);
                return;
            } else
            {
                BaseSCActivity.a(b, 11, Boolean.valueOf(false));
                return;
            }
        } else
        {
            b.startAnalysisThreadForLuaEvent(false);
            Keeper.keepSyncTime(System.currentTimeMillis());
            Keeper.keepSyncBraceletTime(((Long)obj).longValue());
            BaseSCActivity.a(b, 11, Boolean.valueOf(true));
            return;
        }
    }

    public void onStart()
    {
        super.onStart();
        Debug.i(BaseSCActivity.a(b), "START SYNC DATA...onStart");
        Debug.f(BaseSCActivity.a(b), "START SYNC DATA...onStart");
        BaseSCActivity.b(b, true);
        BaseSCActivity.a(b, 9, Integer.valueOf((int)BaseSCActivity.l(b)));
    }
}
