// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.modelbase.BaseResp;

// Referenced classes of package com.tencent.mm.sdk.modelmsg:
//            WXMediaMessage

public class fromBundle extends BaseResp
{

    private static final String a = "MicroMsg.SDK.GetMessageFromWX.Resp";
    public WXMediaMessage message;

    public boolean checkArgs()
    {
        if (message == null)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.GetMessageFromWX.Resp", "checkArgs fail, message is null");
            return false;
        } else
        {
            return message.a();
        }
    }

    public void fromBundle(Bundle bundle)
    {
        super.fromBundle(bundle);
        message = .fromBundle(bundle);
    }

    public int getType()
    {
        return 3;
    }

    public void toBundle(Bundle bundle)
    {
        super.toBundle(bundle);
        bundle.putAll(.toBundle(message));
    }

    public ()
    {
    }

    public (Bundle bundle)
    {
        fromBundle(bundle);
    }
}
