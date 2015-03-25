// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.account.openauth;

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

// Referenced classes of package com.xiaomi.account.openauth:
//            a

public class AuthorizeActivity extends Activity
{

    public static int RESULT_CANCEL = 0;
    public static int RESULT_FAIL = 0;
    public static int RESULT_SUCCESS = 0;
    private static final String a = "AuthorizeActivity";
    private static final String b = "https://account.xiaomi.com/oauth2/authorize";
    private static final String c = "UTF-8";
    private WebView d;
    private WebSettings e;
    private String f;

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
        d = new WebView(this);
        linearlayout.addView(d, new android.view.ViewGroup.LayoutParams(-2, -2));
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
        if (d.canGoBack())
        {
            d.goBack();
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
        e = d.getSettings();
        e.setJavaScriptEnabled(true);
        e.setSavePassword(false);
        e.setSaveFormData(false);
        Bundle bundle1 = getIntent().getBundleExtra("url_param");
        f = (new StringBuilder("https://account.xiaomi.com/oauth2/authorize?")).append(a(bundle1)).toString();
        d.loadUrl(f);
        a a1 = new a(this);
        d.setWebViewClient(a1);
    }

    static 
    {
        RESULT_SUCCESS = -1;
        RESULT_FAIL = 1;
        RESULT_CANCEL = 0;
    }
}
