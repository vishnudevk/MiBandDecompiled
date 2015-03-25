// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.channel.openauth;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

// Referenced classes of package com.xiaomi.channel.openauth:
//            AuthorizeActivity

class a extends WebViewClient
{

    final AuthorizeActivity a;

    a(AuthorizeActivity authorizeactivity)
    {
        a = authorizeactivity;
        super();
    }

    public void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        String s1;
        int i;
        super.onPageStarted(webview, s, bitmap);
        s1 = new String(s);
        i = s1.indexOf("?");
        if (i <= 0) goto _L2; else goto _L1
_L1:
        String s3 = s1.substring(i + 1);
        if (!s3.contains("code=") && !s3.contains("&code=")) goto _L4; else goto _L3
_L3:
        AuthorizeActivity.a(a, AuthorizeActivity.RESULT_SUCCESS, s1);
_L6:
        return;
_L4:
        if (s3.contains("error=") || s3.contains("&error="))
        {
            AuthorizeActivity.a(a, AuthorizeActivity.RESULT_FAIL, s1);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        int j = s1.indexOf("#");
        if (j > 0)
        {
            String s2 = s1.substring(j + 1);
            if (s2.contains("access_token=") || s2.contains("&access_token="))
            {
                AuthorizeActivity.a(a, AuthorizeActivity.RESULT_SUCCESS, s1.replace("#", "?"));
                return;
            }
            if (s2.contains("error=") || s2.contains("&error="))
            {
                AuthorizeActivity.a(a, AuthorizeActivity.RESULT_FAIL, s1.replace("#", "?"));
                return;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        return super.shouldOverrideUrlLoading(webview, s);
    }
}
