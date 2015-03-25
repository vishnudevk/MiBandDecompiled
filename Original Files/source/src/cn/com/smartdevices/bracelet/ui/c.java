// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.model.PersonInfo;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            AlarmActivity

class c
    implements cn.com.smartdevices.bracelet.Utils.OperationCallback
{

    final AlarmActivity a;

    c(AlarmActivity alarmactivity)
    {
        a = alarmactivity;
        super();
    }

    public void onFailure()
    {
        Debug.i("AlarmActivity", "sync alarm to server fail");
    }

    public void onSuccess()
    {
        Debug.i("AlarmActivity", "sync alarm to server ok");
        AlarmActivity.b(a).clearNeedSyncServer();
        Keeper.keepPersonInfo(AlarmActivity.b(a));
    }
}
