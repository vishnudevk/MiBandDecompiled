// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.bleservice.profile;

import java.io.IOException;
import java.io.PipedOutputStream;

// Referenced classes of package com.xiaomi.hm.bleservice.profile:
//            MiLiProfile

class this._cls0
    implements com.xiaomi.hm.bleservice.gatt.INotifyCallback
{

    final MiLiProfile this$0;

    public void notify(byte abyte0[])
    {
        try
        {
            MiLiProfile.access$100(MiLiProfile.this).write(abyte0);
            return;
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }
    }

    tifyCallback()
    {
        this$0 = MiLiProfile.this;
        super();
    }
}
