// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.auth;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.sina.weibo.sdk.exception.WeiboDialogException;
import com.sina.weibo.sdk.utils.LogUtil;

// Referenced classes of package com.sina.weibo.sdk.auth:
//            WeiboDialog, WeiboAuth, WeiboAuthListener

class <init> extends WebViewClient
{

    private boolean isCallBacked;
    final WeiboDialog this$0;

    public void onPageFinished(WebView webview, String s)
    {
        LogUtil.d("WeiboDialog", (new StringBuilder("onPageFinished URL: ")).append(s).toString());
        super.onPageFinished(webview, s);
        if (!WeiboDialog.access$3(WeiboDialog.this) && WeiboDialog.access$4(WeiboDialog.this) != null)
        {
            WeiboDialog.access$4(WeiboDialog.this).dismiss();
        }
        WeiboDialog.access$5(WeiboDialog.this).setVisibility(0);
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        LogUtil.d("WeiboDialog", (new StringBuilder("onPageStarted URL: ")).append(s).toString());
        if (s.startsWith(WeiboDialog.access$1(WeiboDialog.this).getAuthInfo().rl()) && !isCallBacked)
        {
            isCallBacked = true;
            WeiboDialog.access$2(WeiboDialog.this, s);
            webview.stopLoading();
            dismiss();
        } else
        {
            super.onPageStarted(webview, s, bitmap);
            if (!WeiboDialog.access$3(WeiboDialog.this) && WeiboDialog.access$4(WeiboDialog.this) != null && !WeiboDialog.access$4(WeiboDialog.this).isShowing())
            {
                WeiboDialog.access$4(WeiboDialog.this).show();
                return;
            }
        }
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        LogUtil.d("WeiboDialog", (new StringBuilder("onReceivedError: errorCode = ")).append(i).append(", description = ").append(s).append(", failingUrl = ").append(s1).toString());
        super.onReceivedError(webview, i, s, s1);
        if (WeiboDialog.access$0(WeiboDialog.this) != null)
        {
            WeiboDialog.access$0(WeiboDialog.this).onWeiboException(new WeiboDialogException(s, i, s1));
        }
        dismiss();
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        LogUtil.i("WeiboDialog", (new StringBuilder("load URL: ")).append(s).toString());
        if (s.startsWith("sms:"))
        {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.putExtra("address", s.replace("sms:", ""));
            intent.setType("vnd.android-dir/mms-sms");
            getContext().startActivity(intent);
            return true;
        } else
        {
            return super.shouldOverrideUrlLoading(webview, s);
        }
    }

    private ()
    {
        this$0 = WeiboDialog.this;
        super();
        isCallBacked = false;
    }

    isCallBacked(isCallBacked iscallbacked)
    {
        this();
    }
}
