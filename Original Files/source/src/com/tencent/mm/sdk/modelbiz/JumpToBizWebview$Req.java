// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.modelbase.BaseReq;

public class c extends BaseReq
{

    private static final String a = "MicroMsg.SDK.JumpToBizWebview.Req";
    private static final int b = 1024;
    private int c;
    public String extMsg;
    public String toUserName;
    public int webType;

    public boolean checkArgs()
    {
        if (toUserName == null || toUserName.length() <= 0)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.JumpToBizWebview.Req", "checkArgs fail, toUserName is invalid");
            return false;
        }
        if (extMsg != null && extMsg.length() > 1024)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.JumpToBizWebview.Req", "ext msg is not null, while the length exceed 1024 bytes");
            return false;
        }
        if (webType != 0)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.JumpToBizWebview.Req", "now only support the webtype is 0");
            return false;
        } else
        {
            return true;
        }
    }

    public int getType()
    {
        return 8;
    }

    public void toBundle(Bundle bundle)
    {
        super.toBundle(bundle);
        bundle.putString("_wxapi_jump_to_biz_webview_req_to_user_name", toUserName);
        bundle.putString("_wxapi_jump_to_biz_webview_req_ext_msg", extMsg);
        bundle.putInt("_wxapi_jump_to_biz_webview_req_web_type", webType);
        bundle.putInt("_wxapi_jump_to_biz_webview_req_scene", c);
    }

    public ()
    {
        c = 1;
    }
}
