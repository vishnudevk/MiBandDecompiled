// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.modelbase.BaseReq;

public class profileType extends BaseReq
{

    private static final String a = "MicroMsg.SDK.JumpToBizProfile.Req";
    private static final int b = 1024;
    public String extMsg;
    public int profileType;
    public String toUserName;

    public boolean checkArgs()
    {
        if (toUserName == null || toUserName.length() == 0)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.JumpToBizProfile.Req", "checkArgs fail, toUserName is invalid");
            return false;
        }
        if (extMsg != null && extMsg.length() > 1024)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.JumpToBizProfile.Req", "ext msg is not null, while the length exceed 1024 bytes");
            return false;
        }
        if (profileType == 1 && (extMsg == null || extMsg.length() == 0))
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.JumpToBizProfile.Req", "scene is jump to hardware profile, while extmsg is null");
            return false;
        } else
        {
            return true;
        }
    }

    public void fromBundle(Bundle bundle)
    {
        super.fromBundle(bundle);
        toUserName = bundle.getString("_wxapi_jump_to_biz_profile_req_to_user_name");
        extMsg = bundle.getString("_wxapi_jump_to_biz_profile_req_ext_msg");
    }

    public int getType()
    {
        return 7;
    }

    public void toBundle(Bundle bundle)
    {
        super.toBundle(bundle);
        bundle.putString("_wxapi_jump_to_biz_profile_req_to_user_name", toUserName);
        bundle.putString("_wxapi_jump_to_biz_profile_req_ext_msg", extMsg);
        bundle.putInt("_wxapi_jump_to_biz_profile_req_scene", 0);
        bundle.putInt("_wxapi_jump_to_biz_profile_req_profile_type", profileType);
    }

    public ()
    {
        profileType = 0;
    }
}
