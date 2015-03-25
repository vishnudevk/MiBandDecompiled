// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet;

import cn.com.smartdevices.bracelet.BleTask.BleCallBack;

// Referenced classes of package cn.com.smartdevices.bracelet:
//            Debug

final class f extends BleCallBack
{

    f()
    {
    }

    public void onFailed(Object obj)
    {
        super.onFailed(obj);
        Debug.i("Utils", "\n                 sendUserInfo2Mili fail");
    }

    public void onFinish(Object obj)
    {
        super.onFinish(obj);
        if (obj != null)
        {
            Debug.i("Utils", "     sendUserInfo2Mili ok!");
        }
    }
}
