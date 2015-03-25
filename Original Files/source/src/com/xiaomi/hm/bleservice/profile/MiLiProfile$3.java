// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.bleservice.profile;

import com.xiaomi.hm.bleservice.util.Debug;

// Referenced classes of package com.xiaomi.hm.bleservice.profile:
//            MiLiProfile

class this._cls0
    implements com.xiaomi.hm.bleservice.gatt.INotifyCallback
{

    final MiLiProfile this$0;

    public void notify(byte abyte0[])
    {
        boolean flag;
        int i;
        if (abyte0.length == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Debug.ASSERT_TRUE(flag);
        i = 0xff & abyte0[0] | (0xff & abyte0[1]) << 8;
        Debug.DEBUG((new StringBuilder()).append("RealtimeSteps: ").append(i).toString());
        MiLiProfile.access$000(MiLiProfile.this, i);
    }

    tifyCallback()
    {
        this$0 = MiLiProfile.this;
        super();
    }
}
