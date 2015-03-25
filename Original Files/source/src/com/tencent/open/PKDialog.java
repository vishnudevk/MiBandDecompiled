// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.b.a;
import com.tencent.tauth.IUiListener;
import com.tencent.utils.Util;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.open:
//            d, g, h, e, 
//            f, a

public class PKDialog extends d
    implements com.tencent.open.b.a.a
{

    static Toast a = null;
    private static final String b = com/tencent/open/PKDialog.getName();
    private static final int c = 185;
    private static final int d = 1;
    private static final int e = 2;
    private static final int f = 3;
    private static final int g = 4;
    private static final int h = 5;
    private static WeakReference o;
    private String i;
    private IUiListener j;
    private g k;
    private Handler l;
    private a m;
    private WebView n;
    private int p;

    public PKDialog(Context context, String s, String s1, IUiListener iuilistener, QQToken qqtoken)
    {
        super(context, 0x1030010);
        o = new WeakReference(context);
        i = s1;
        k = new g(context, s, s1, qqtoken.getAppId(), iuilistener);
        l = new h(k, context.getMainLooper());
        j = iuilistener;
        p = Math.round(185F * context.getResources().getDisplayMetrics().density);
        Log.e(b, (new StringBuilder()).append("density=").append(context.getResources().getDisplayMetrics().density).append("; webviewHeight=").append(p).toString());
    }

    static Handler a(PKDialog pkdialog)
    {
        return pkdialog.l;
    }

    static String a()
    {
        return b;
    }

    static void a(Context context, String s)
    {
        c(context, s);
    }

    private void a(String s, String s1, String s2)
    {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(s, s1));
        intent.setAction("android.intent.action.VIEW");
        intent.addFlags(0x40000000);
        intent.addFlags(0x10000000);
        intent.setData(Uri.parse(s2));
        if (o != null && o.get() != null)
        {
            ((Context)o.get()).startActivity(intent);
        }
    }

    static g b(PKDialog pkdialog)
    {
        return pkdialog.k;
    }

    static WeakReference b()
    {
        return o;
    }

    static void b(Context context, String s)
    {
        d(context, s);
    }

    static WebView c(PKDialog pkdialog)
    {
        return pkdialog.n;
    }

    private void c()
    {
        m = new a((Context)o.get());
        m.setBackgroundColor(0x66000000);
        m.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        n = new WebView((Context)o.get());
        n.setBackgroundColor(0);
        n.setBackgroundDrawable(null);
        android.widget.RelativeLayout.LayoutParams layoutparams;
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            try
            {
                Class aclass[] = new Class[2];
                aclass[0] = Integer.TYPE;
                aclass[1] = android/graphics/Paint;
                Method method = android/view/View.getMethod("setLayerType", aclass);
                WebView webview = n;
                Object aobj[] = new Object[2];
                aobj[0] = Integer.valueOf(1);
                aobj[1] = new Paint();
                method.invoke(webview, aobj);
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, p);
        layoutparams.addRule(13, -1);
        n.setLayoutParams(layoutparams);
        m.addView(n);
        m.a(this);
        setContentView(m);
    }

    private static void c(Context context, String s)
    {
        int i1;
        String s1;
        try
        {
            JSONObject jsonobject = Util.parseJson(s);
            i1 = jsonobject.getInt("type");
            s1 = jsonobject.getString("msg");
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            return;
        }
        if (i1 != 0)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        if (a != null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        a = Toast.makeText(context, s1, 0);
_L2:
        a.show();
        return;
        a.setView(a.getView());
        a.setText(s1);
        a.setDuration(0);
        if (true) goto _L2; else goto _L1
_L1:
        if (i1 != 1)
        {
            break MISSING_BLOCK_LABEL_146;
        }
        if (a != null)
        {
            break MISSING_BLOCK_LABEL_116;
        }
        a = Toast.makeText(context, s1, 1);
_L4:
        a.show();
        return;
        a.setView(a.getView());
        a.setText(s1);
        a.setDuration(1);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void d()
    {
        n.setVerticalScrollBarEnabled(false);
        n.setHorizontalScrollBarEnabled(false);
        n.setWebViewClient(new e(this, null));
        n.setWebChromeClient(mChromeClient);
        n.clearFormData();
        WebSettings websettings = n.getSettings();
        websettings.setSavePassword(false);
        websettings.setSaveFormData(false);
        websettings.setCacheMode(-1);
        websettings.setNeedInitialFocus(false);
        websettings.setBuiltInZoomControls(true);
        websettings.setSupportZoom(true);
        websettings.setRenderPriority(android.webkit.WebSettings.RenderPriority.HIGH);
        websettings.setJavaScriptEnabled(true);
        if (o != null && o.get() != null)
        {
            websettings.setDatabaseEnabled(true);
            websettings.setDatabasePath(((Context)o.get()).getApplicationContext().getDir("databases", 0).getPath());
        }
        websettings.setDomStorageEnabled(true);
        jsBridge.a(new f(this, null), "sdk_js_if");
        n.clearView();
        n.loadUrl(i);
        n.getSettings().setSavePassword(false);
    }

    private static void d(Context context, String s)
    {
        if (context != null && s != null)
        {
            int i1;
            try
            {
                JSONObject jsonobject = Util.parseJson(s);
                i1 = jsonobject.getInt("action");
                jsonobject.getString("msg");
            }
            catch (JSONException jsonexception)
            {
                jsonexception.printStackTrace();
                return;
            }
            if (i1 == 1)
            {
                return;
            }
        }
    }

    public void callJs(String s, String s1)
    {
        String s2 = (new StringBuilder()).append("javascript:").append(s).append("(").append(s1).append(")").toString();
        n.loadUrl(s2);
    }

    public void onBackPressed()
    {
        super.onBackPressed();
    }

    protected void onConsoleMessage(String s)
    {
        Log.d("PKDialog", "--onConsoleMessage--");
        try
        {
            jsBridge.a(n, s);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setSoftInputMode(16);
        getWindow().setSoftInputMode(1);
        c();
        d();
    }

    public void onKeyboardHidden()
    {
        n.getLayoutParams().height = p;
        Log.e(b, "keyboard hide");
    }

    public void onKeyboardShown(int i1)
    {
        if (o != null && o.get() != null)
        {
            if (i1 < p && 2 == ((Context)o.get()).getResources().getConfiguration().orientation)
            {
                n.getLayoutParams().height = i1;
            } else
            {
                n.getLayoutParams().height = p;
            }
        }
        Log.e(b, "keyboard show");
    }

}
