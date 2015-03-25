// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.channel.openauth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package com.xiaomi.channel.openauth:
//            a

public class AuthorizeActivity extends Activity
{

    public static int RESULT_CANCEL = 0;
    public static int RESULT_FAIL = 0;
    public static int RESULT_SUCCESS = 0;
    private static final String a = "https://account.xiaomi.com/oauth2/authorize";
    private static final String b = "UTF-8";
    private WebView c;
    private WebSettings d;
    private String e;

    public AuthorizeActivity()
    {
    }

    private Bundle a(String s)
    {
        Bundle bundle;
        bundle = new Bundle();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        Iterator iterator = URLEncodedUtils.parse(new URI(s), "UTF-8").iterator();
_L2:
        if (!iterator.hasNext())
        {
            return bundle;
        }
        NameValuePair namevaluepair = (NameValuePair)iterator.next();
        if (!TextUtils.isEmpty(namevaluepair.getName()) && !TextUtils.isEmpty(namevaluepair.getValue()))
        {
            bundle.putString(namevaluepair.getName(), namevaluepair.getValue());
        }
        if (true) goto _L2; else goto _L1
_L1:
        URISyntaxException urisyntaxexception;
        urisyntaxexception;
        Log.e("openauth", urisyntaxexception.getMessage());
        return bundle;
    }

    private View a()
    {
        LinearLayout linearlayout = new LinearLayout(this);
        linearlayout.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        linearlayout.setOrientation(1);
        c = new WebView(this);
        linearlayout.addView(c, new android.view.ViewGroup.LayoutParams(-2, -2));
        return linearlayout;
    }

    private String a(Bundle bundle)
    {
        if (bundle == null)
        {
            return "";
        }
        ArrayList arraylist = new ArrayList();
        Iterator iterator = bundle.keySet().iterator();
        do
        {
            String s;
            String s1;
            do
            {
                if (!iterator.hasNext())
                {
                    return URLEncodedUtils.format(arraylist, "UTF-8");
                }
                s = (String)iterator.next();
                s1 = bundle.getString(s);
            } while (TextUtils.isEmpty(s) || TextUtils.isEmpty(s1));
            arraylist.add(new BasicNameValuePair(s, s1));
        } while (true);
    }

    private void a(int i, String s)
    {
        Intent intent = new Intent();
        intent.putExtras(a(s));
        setResult(i, intent);
        finish();
    }

    static void a(AuthorizeActivity authorizeactivity, int i, String s)
    {
        authorizeactivity.a(i, s);
    }

    public void onBackPressed()
    {
        if (c.canGoBack())
        {
            c.goBack();
            return;
        } else
        {
            a(RESULT_CANCEL, null);
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(a());
        d = c.getSettings();
        d.setJavaScriptEnabled(true);
        d.setSavePassword(false);
        d.setSaveFormData(false);
        Bundle bundle1 = getIntent().getBundleExtra("url_param");
        e = (new StringBuilder("https://account.xiaomi.com/oauth2/authorize?")).append(a(bundle1)).toString();
        c.loadUrl(e);
        a a1 = new a(this);
        c.setWebViewClient(a1);
    }

    static 
    {
        RESULT_SUCCESS = -1;
        RESULT_FAIL = 1;
        RESULT_CANCEL = 0;
    }
}
