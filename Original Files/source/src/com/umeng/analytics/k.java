// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.analytics;

import android.graphics.Bitmap;
import android.os.Message;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

// Referenced classes of package com.umeng.analytics:
//            MobclickAgent, MobclickAgentJSInterface, d

final class k extends WebChromeClient
{

    WebChromeClient a;
    final MobclickAgentJSInterface b;
    private final String c = "ekv";
    private final String d = "event";

    public k(MobclickAgentJSInterface mobclickagentjsinterface, WebChromeClient webchromeclient)
    {
        b = mobclickagentjsinterface;
        super();
        a = null;
        if (webchromeclient == null)
        {
            a = new WebChromeClient();
            return;
        } else
        {
            a = webchromeclient;
            return;
        }
    }

    public void onCloseWindow(WebView webview)
    {
        a.onCloseWindow(webview);
    }

    public boolean onCreateWindow(WebView webview, boolean flag, boolean flag1, Message message)
    {
        return a.onCreateWindow(webview, flag, flag1, message);
    }

    public boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult)
    {
        return a.onJsAlert(webview, s, s1, jsresult);
    }

    public boolean onJsBeforeUnload(WebView webview, String s, String s1, JsResult jsresult)
    {
        return a.onJsBeforeUnload(webview, s, s1, jsresult);
    }

    public boolean onJsConfirm(WebView webview, String s, String s1, JsResult jsresult)
    {
        return a.onJsConfirm(webview, s, s1, jsresult);
    }

    public boolean onJsPrompt(WebView webview, String s, String s1, String s2, JsPromptResult jspromptresult)
    {
        if (!"ekv".equals(s1)) goto _L2; else goto _L1
_L1:
        JSONObject jsonobject1;
        HashMap hashmap;
        String s4;
        jsonobject1 = new JSONObject(s2);
        hashmap = new HashMap();
        s4 = (String)jsonobject1.remove("id");
        if (!jsonobject1.isNull("duration")) goto _L4; else goto _L3
_L3:
        int i = 0;
_L10:
        Iterator iterator = jsonobject1.keys();
_L8:
        if (iterator.hasNext()) goto _L6; else goto _L5
_L5:
        MobclickAgent.getAgent().a(MobclickAgentJSInterface.a(b), s4, hashmap, i);
_L7:
        jspromptresult.confirm();
        return true;
_L4:
        String s5;
        try
        {
            i = ((Integer)jsonobject1.remove("duration")).intValue();
            continue; /* Loop/switch isn't completed */
        }
        catch (Exception exception1)
        {
            exception1.printStackTrace();
        }
          goto _L7
_L6:
        s5 = (String)iterator.next();
        hashmap.put(s5, jsonobject1.getString(s5));
          goto _L8
_L2:
        if (!"event".equals(s1))
        {
            break MISSING_BLOCK_LABEL_237;
        }
        JSONObject jsonobject;
        String s3;
        jsonobject = new JSONObject(s2);
        s3 = jsonobject.optString("label");
        if ("".equals(s3))
        {
            s3 = null;
        }
        try
        {
            MobclickAgent.getAgent().a(MobclickAgentJSInterface.a(b), jsonobject.getString("tag"), s3, jsonobject.optInt("duration"), 1);
        }
        catch (Exception exception) { }
          goto _L7
        return a.onJsPrompt(webview, s, s1, s2, jspromptresult);
        if (true) goto _L10; else goto _L9
_L9:
    }

    public void onProgressChanged(WebView webview, int i)
    {
        a.onProgressChanged(webview, i);
    }

    public void onReceivedIcon(WebView webview, Bitmap bitmap)
    {
        a.onReceivedIcon(webview, bitmap);
    }

    public void onReceivedTitle(WebView webview, String s)
    {
        a.onReceivedTitle(webview, s);
    }

    public void onRequestFocus(WebView webview)
    {
        a.onRequestFocus(webview);
    }
}
