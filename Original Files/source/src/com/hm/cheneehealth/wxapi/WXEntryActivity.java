// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.hm.cheneehealth.wxapi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;
import cn.com.smartdevices.bracelet.view.CustomToast;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

// Referenced classes of package com.hm.cheneehealth.wxapi:
//            a, b

public class WXEntryActivity extends SystemBarTintActivity
    implements IWXAPIEventHandler
{

    private static final int a = 0x21020001;
    private TextView b;
    private IWXAPI c;

    public WXEntryActivity()
    {
    }

    static IWXAPI a(WXEntryActivity wxentryactivity)
    {
        return wxentryactivity.c;
    }

    private void a(com.tencent.mm.sdk.modelmsg.ShowMessageFromWX.Req req)
    {
        Log.d("chenee", "goto show............... msg");
        WXMediaMessage wxmediamessage = req.message;
        WXAppExtendObject wxappextendobject = (WXAppExtendObject)wxmediamessage.mediaObject;
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("---extInfo(uid): ");
        stringbuffer.append(wxappextendobject.extInfo);
        stringbuffer.append("\n");
        stringbuffer.append("---description: ");
        stringbuffer.append(wxmediamessage.description);
        stringbuffer.append("\n");
        stringbuffer.append("---filePath: ");
        stringbuffer.append(wxappextendobject.filePath);
        b.setText((new StringBuilder()).append(wxmediamessage.title).append("\n").append(stringbuffer.toString()).toString());
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03001e);
        c = WXAPIFactory.createWXAPI(this, "wx28e2610e92fbe111", false);
        ((Button)findViewById(0x7f0a00a5)).setOnClickListener(new a(this));
        ((Button)findViewById(0x7f0a00a6)).setOnClickListener(new b(this));
        b = (TextView)findViewById(0x7f0a00a4);
        c.handleIntent(getIntent(), this);
        Log.d("chenee", "on create......");
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        setIntent(intent);
        c.handleIntent(intent, this);
    }

    public void onReq(BaseReq basereq)
    {
        switch (basereq.getType())
        {
        default:
            return;

        case 3: // '\003'
            Log.d("chenee", "never come here ??????");
            return;

        case 4: // '\004'
            a((com.tencent.mm.sdk.modelmsg.ShowMessageFromWX.Req)basereq);
            break;
        }
    }

    public void onResp(BaseResp baseresp)
    {
        baseresp.errCode;
        JVM INSTR tableswitch -4 0: default 40
    //                   -4 94
    //                   -3 40
    //                   -2 88
    //                   -1 40
    //                   0 82;
           goto _L1 _L2 _L1 _L3 _L1 _L4
_L1:
        String s = "\u53D1\u9001\u8FD4\u56DE";
_L6:
        CustomToast.makeText(this, s, 1).show();
        Log.d("chenee", (new StringBuilder()).append("onResp...............").append(s).toString());
        finish();
        return;
_L4:
        s = "\u53D1\u9001\u6210\u529F!";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "\u53D1\u9001\u53D6\u6D88";
        continue; /* Loop/switch isn't completed */
_L2:
        s = "\u53D1\u9001\u88AB\u62D2\u7EDD";
        if (true) goto _L6; else goto _L5
_L5:
    }
}
