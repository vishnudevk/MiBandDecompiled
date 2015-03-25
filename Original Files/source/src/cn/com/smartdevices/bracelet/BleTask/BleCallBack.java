// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.BleTask;

import android.os.Handler;
import android.os.Message;
import cn.com.smartdevices.bracelet.Debug;

// Referenced classes of package cn.com.smartdevices.bracelet.BleTask:
//            a

public class BleCallBack
{

    private static final int b;
    Handler a;
    private final int c = 1;
    private final int d = 2;
    private final int e = 3;
    private final String f = "BleCallBack";

    public BleCallBack()
    {
        a = new a(this);
    }

    public void onFailed(Object obj)
    {
        Debug.i("BleCallBack", (new StringBuilder()).append("onFailed:").append(obj).toString());
    }

    public void onFinish(Object obj)
    {
        Debug.i("BleCallBack", (new StringBuilder()).append("onFinish:").append(obj).toString());
    }

    public void onProgress(int i)
    {
        Debug.i("BleCallBack", (new StringBuilder()).append("onProgress:").append(i).toString());
    }

    public void onStart()
    {
        Debug.i("BleCallBack", "onStart");
    }

    public void sendOnFailedMessage(Object obj)
    {
        Message message = a.obtainMessage(3);
        message.obj = obj;
        a.sendMessage(message);
    }

    public void sendOnFinishMessage(Object obj)
    {
        Message message = a.obtainMessage(1);
        message.obj = obj;
        a.sendMessage(message);
    }

    public void sendOnProgressMessage(int i)
    {
        Message message = a.obtainMessage(2);
        message.arg1 = i;
        a.sendMessage(message);
    }

    public void sendOnStartMessage()
    {
        Message message = a.obtainMessage(0);
        a.sendMessage(message);
    }

    public int taskCondition()
    {
        return 0;
    }
}
