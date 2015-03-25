// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.auth;

import java.text.SimpleDateFormat;
import java.util.SimpleTimeZone;

// Referenced classes of package com.xiaomi.infra.galaxy.common.auth:
//            Galaxy4Signer

class this._cls0 extends ThreadLocal
{

    final Galaxy4Signer this$0;

    protected volatile Object initialValue()
    {
        return initialValue();
    }

    protected SimpleDateFormat initialValue()
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
        simpledateformat.setTimeZone(new SimpleTimeZone(0, "UTC"));
        return simpledateformat;
    }

    _cls9()
    {
        this$0 = Galaxy4Signer.this;
        super();
    }
}
