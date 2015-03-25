// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.bleservice.gatt;

import com.xiaomi.hm.bleservice.util.Debug;
import java.util.concurrent.ThreadFactory;

// Referenced classes of package com.xiaomi.hm.bleservice.gatt:
//            AbsGattCallback

class this._cls0
    implements ThreadFactory
{

    final AbsGattCallback this$0;

    public Thread newThread(Runnable runnable)
    {
        Debug.TRACE();
        Debug.INFO("********************************");
        Debug.INFO((new StringBuilder()).append("NEW THREAD: ").append(AbsGattCallback.access$000()).toString());
        Debug.INFO("********************************");
        Thread thread = new Thread(runnable, AbsGattCallback.access$000());
        class _cls1
            implements Thread.UncaughtExceptionHandler
        {

            final AbsGattCallback._cls1 this$1;

            public void uncaughtException(Thread thread1, Throwable throwable)
            {
                Debug.TRACE();
                throwable.printStackTrace();
            }

            _cls1()
            {
                this$1 = AbsGattCallback._cls1.this;
                super();
            }
        }

        thread.setUncaughtExceptionHandler(new _cls1());
        return thread;
    }

    _cls1()
    {
        this$0 = AbsGattCallback.this;
        super();
    }
}
