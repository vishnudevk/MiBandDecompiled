// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.openapi;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.sdk.a.a.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelpay.PayResp;

// Referenced classes of package com.tencent.mm.sdk.openapi:
//            IWXAPI, a, c, IWXAPIEventHandler

final class d
    implements IWXAPI
{

    private static final String a = "MicroMsg.SDK.WXApiImplV10";
    private static String f = null;
    private Context b;
    private String c;
    private boolean d;
    private boolean e;

    d(Context context, String s, boolean flag)
    {
        d = false;
        e = false;
        com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.WXApiImplV10", (new StringBuilder("<init>, appId = ")).append(s).append(", checkSignature = ").append(flag).toString());
        b = context;
        c = s;
        d = flag;
    }

    private boolean a(Context context, Bundle bundle)
    {
        if (f == null)
        {
            f = (new com.tencent.mm.sdk.openapi.a(context)).getString("_wxapp_pay_entry_classname_", null);
            com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.WXApiImplV10", (new StringBuilder("pay, set wxappPayEntryClassname = ")).append(f).toString());
            if (f == null)
            {
                com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "pay fail, wxappPayEntryClassname is null");
                return false;
            }
        }
        com.tencent.mm.sdk.a.a.a a1 = new com.tencent.mm.sdk.a.a.a();
        a1.e = bundle;
        a1.b = "com.tencent.mm";
        a1.c = f;
        return com.tencent.mm.sdk.a.a.a(context, a1);
    }

    private boolean a(byte abyte0[], byte abyte1[])
    {
        if (abyte0 != null && abyte0.length != 0 && abyte1 != null && abyte1.length != 0) goto _L2; else goto _L1
_L1:
        com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "checkSumConsistent fail, invalid arguments");
_L4:
        return false;
_L2:
        if (abyte0.length != abyte1.length)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "checkSumConsistent fail, length is different");
            return false;
        }
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= abyte0.length)
                {
                    break label1;
                }
                if (abyte0[i] != abyte1[i])
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        return true;
    }

    private boolean b(Context context, Bundle bundle)
    {
        ContentResolver contentresolver = context.getContentResolver();
        Uri uri = Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToBizProfile");
        String as[] = new String[5];
        as[0] = c;
        as[1] = bundle.getString("_wxapi_jump_to_biz_profile_req_to_user_name");
        as[2] = bundle.getString("_wxapi_jump_to_biz_profile_req_ext_msg");
        as[3] = (new StringBuilder()).append(bundle.getInt("_wxapi_jump_to_biz_profile_req_scene")).toString();
        as[4] = (new StringBuilder()).append(bundle.getInt("_wxapi_jump_to_biz_profile_req_profile_type")).toString();
        contentresolver.query(uri, null, null, as, null);
        return true;
    }

    private boolean c(Context context, Bundle bundle)
    {
        ContentResolver contentresolver = context.getContentResolver();
        Uri uri = Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToBizProfile");
        String as[] = new String[4];
        as[0] = c;
        as[1] = bundle.getString("_wxapi_jump_to_biz_webview_req_to_user_name");
        as[2] = bundle.getString("_wxapi_jump_to_biz_webview_req_ext_msg");
        as[3] = (new StringBuilder()).append(bundle.getInt("_wxapi_jump_to_biz_webview_req_scene")).toString();
        contentresolver.query(uri, null, null, as, null);
        return true;
    }

    public final void detach()
    {
        com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.WXApiImplV10", "detach");
        e = true;
        b = null;
    }

    public final int getWXAppSupportAPI()
    {
        if (e)
        {
            throw new IllegalStateException("getWXAppSupportAPI fail, WXMsgImpl has been detached");
        }
        if (!isWXAppInstalled())
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "open wx app failed, not installed or signature check failed");
            return 0;
        } else
        {
            return (new com.tencent.mm.sdk.openapi.a(b)).getInt("_build_info_sdk_int_", 0);
        }
    }

    public final boolean handleIntent(Intent intent, IWXAPIEventHandler iwxapieventhandler)
    {
        if (!com.tencent.mm.sdk.openapi.c.a(intent, "com.tencent.mm.openapi.token"))
        {
            com.tencent.mm.sdk.b.a.b("MicroMsg.SDK.WXApiImplV10", "handleIntent fail, intent not from weixin msg");
            return false;
        }
        if (e)
        {
            throw new IllegalStateException("handleIntent fail, WXMsgImpl has been detached");
        }
        String s = intent.getStringExtra("_mmessage_content");
        int i = intent.getIntExtra("_mmessage_sdkVersion", 0);
        String s1 = intent.getStringExtra("_mmessage_appPackage");
        if (s1 == null || s1.length() == 0)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "invalid argument");
            return false;
        }
        if (!a(intent.getByteArrayExtra("_mmessage_checksum"), com.tencent.mm.sdk.a.a.b.a(s, i, s1)))
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "checksum fail");
            return false;
        }
        int j = intent.getIntExtra("_wxapi_command_type", 0);
        switch (j)
        {
        default:
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", (new StringBuilder("unknown cmd = ")).append(j).toString());
            return false;

        case 1: // '\001'
            iwxapieventhandler.onResp(new com.tencent.mm.sdk.modelmsg.SendAuth.Resp(intent.getExtras()));
            return true;

        case 2: // '\002'
            iwxapieventhandler.onResp(new com.tencent.mm.sdk.modelmsg.SendMessageToWX.Resp(intent.getExtras()));
            return true;

        case 3: // '\003'
            iwxapieventhandler.onReq(new com.tencent.mm.sdk.modelmsg.GetMessageFromWX.Req(intent.getExtras()));
            return true;

        case 4: // '\004'
            iwxapieventhandler.onReq(new com.tencent.mm.sdk.modelmsg.ShowMessageFromWX.Req(intent.getExtras()));
            return true;

        case 5: // '\005'
            iwxapieventhandler.onResp(new PayResp(intent.getExtras()));
            return true;

        case 6: // '\006'
            iwxapieventhandler.onReq(new com.tencent.mm.sdk.modelmsg.LaunchFromWX.Req(intent.getExtras()));
            break;
        }
        return true;
    }

    public final boolean isWXAppInstalled()
    {
        if (e)
        {
            throw new IllegalStateException("isWXAppInstalled fail, WXMsgImpl has been detached");
        }
        PackageInfo packageinfo;
        boolean flag;
        try
        {
            packageinfo = b.getPackageManager().getPackageInfo("com.tencent.mm", 64);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            return false;
        }
        if (packageinfo == null)
        {
            return false;
        }
        flag = com.tencent.mm.sdk.openapi.c.a(b, packageinfo.signatures, d);
        return flag;
    }

    public final boolean isWXAppSupportAPI()
    {
        if (e)
        {
            throw new IllegalStateException("isWXAppSupportAPI fail, WXMsgImpl has been detached");
        }
        return getWXAppSupportAPI() >= 0x22010003;
    }

    public final boolean openWXApp()
    {
        if (e)
        {
            throw new IllegalStateException("openWXApp fail, WXMsgImpl has been detached");
        }
        if (!isWXAppInstalled())
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "open wx app failed, not installed or signature check failed");
            return false;
        }
        try
        {
            b.startActivity(b.getPackageManager().getLaunchIntentForPackage("com.tencent.mm"));
        }
        catch (Exception exception)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", (new StringBuilder("startActivity fail, exception = ")).append(exception.getMessage()).toString());
            return false;
        }
        return true;
    }

    public final boolean registerApp(String s)
    {
        if (e)
        {
            throw new IllegalStateException("registerApp fail, WXMsgImpl has been detached");
        }
        if (!com.tencent.mm.sdk.openapi.c.a(b, "com.tencent.mm", d))
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "register app failed for wechat app signature check failed");
            return false;
        }
        com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.WXApiImplV10", (new StringBuilder("registerApp, appId = ")).append(s).toString());
        if (s != null)
        {
            c = s;
        }
        com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.WXApiImplV10", (new StringBuilder("register app ")).append(b.getPackageName()).toString());
        com.tencent.mm.sdk.a.a.a.a a1 = new com.tencent.mm.sdk.a.a.a.a();
        a1.f = "com.tencent.mm";
        a1.g = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_REGISTER";
        a1.d = (new StringBuilder("weixin://registerapp?appid=")).append(c).toString();
        return com.tencent.mm.sdk.a.a.a.a(b, a1);
    }

    public final boolean sendReq(BaseReq basereq)
    {
        if (e)
        {
            throw new IllegalStateException("sendReq fail, WXMsgImpl has been detached");
        }
        if (!com.tencent.mm.sdk.openapi.c.a(b, "com.tencent.mm", d))
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "sendReq failed for wechat app signature check failed");
            return false;
        }
        if (!basereq.checkArgs())
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "sendReq checkArgs fail");
            return false;
        }
        com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.WXApiImplV10", (new StringBuilder("sendReq, req type = ")).append(basereq.getType()).toString());
        Bundle bundle = new Bundle();
        basereq.toBundle(bundle);
        if (basereq.getType() == 5)
        {
            return a(b, bundle);
        }
        if (basereq.getType() == 7)
        {
            return b(b, bundle);
        }
        if (basereq.getType() == 8)
        {
            return c(b, bundle);
        } else
        {
            com.tencent.mm.sdk.a.a.a a1 = new com.tencent.mm.sdk.a.a.a();
            a1.e = bundle;
            a1.d = (new StringBuilder("weixin://sendreq?appid=")).append(c).toString();
            a1.b = "com.tencent.mm";
            a1.c = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
            return com.tencent.mm.sdk.a.a.a(b, a1);
        }
    }

    public final boolean sendResp(BaseResp baseresp)
    {
        if (e)
        {
            throw new IllegalStateException("sendResp fail, WXMsgImpl has been detached");
        }
        if (!com.tencent.mm.sdk.openapi.c.a(b, "com.tencent.mm", d))
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "sendResp failed for wechat app signature check failed");
            return false;
        }
        if (!baseresp.checkArgs())
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "sendResp checkArgs fail");
            return false;
        } else
        {
            Bundle bundle = new Bundle();
            baseresp.toBundle(bundle);
            com.tencent.mm.sdk.a.a.a a1 = new com.tencent.mm.sdk.a.a.a();
            a1.e = bundle;
            a1.d = (new StringBuilder("weixin://sendresp?appid=")).append(c).toString();
            a1.b = "com.tencent.mm";
            a1.c = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
            return com.tencent.mm.sdk.a.a.a(b, a1);
        }
    }

    public final void unregisterApp()
    {
        if (e)
        {
            throw new IllegalStateException("unregisterApp fail, WXMsgImpl has been detached");
        }
        if (!com.tencent.mm.sdk.openapi.c.a(b, "com.tencent.mm", d))
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "unregister app failed for wechat app signature check failed");
            return;
        }
        com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.WXApiImplV10", (new StringBuilder("unregisterApp, appId = ")).append(c).toString());
        if (c == null || c.length() == 0)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXApiImplV10", "unregisterApp fail, appId is empty");
            return;
        } else
        {
            com.tencent.mm.sdk.b.a.c("MicroMsg.SDK.WXApiImplV10", (new StringBuilder("unregister app ")).append(b.getPackageName()).toString());
            com.tencent.mm.sdk.a.a.a.a a1 = new com.tencent.mm.sdk.a.a.a.a();
            a1.f = "com.tencent.mm";
            a1.g = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_UNREGISTER";
            a1.d = (new StringBuilder("weixin://unregisterapp?appid=")).append(c).toString();
            com.tencent.mm.sdk.a.a.a.a(b, a1);
            return;
        }
    }

}
