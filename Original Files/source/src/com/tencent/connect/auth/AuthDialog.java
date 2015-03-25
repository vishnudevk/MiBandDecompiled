// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.auth;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.tauth.IUiListener;
import com.tencent.utils.Util;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.connect.auth:
//            m, QQToken, n, l, 
//            k, AuthMap

public class AuthDialog extends Dialog
{

    private static WeakReference a;
    private static WeakReference l;
    private String b;
    private m c;
    private IUiListener d;
    private Handler e;
    private FrameLayout f;
    private LinearLayout g;
    private FrameLayout h;
    private ProgressBar i;
    private String j;
    private WebView k;
    private boolean m;

    public AuthDialog(Context context, String s, String s1, IUiListener iuilistener, QQToken qqtoken)
    {
        super(context, 0x1030010);
        m = false;
        a = new WeakReference(context.getApplicationContext());
        b = s1;
        c = new m(this, s, s1, qqtoken.getAppId(), iuilistener);
        e = new n(c, context.getMainLooper());
        d = iuilistener;
        j = s;
    }

    static String a(AuthDialog authdialog, Object obj)
    {
        String s = (new StringBuilder()).append(authdialog.b).append(obj).toString();
        authdialog.b = s;
        return s;
    }

    static WeakReference a()
    {
        return a;
    }

    static void a(Context context, String s)
    {
        b(context, s);
    }

    static boolean a(AuthDialog authdialog)
    {
        return authdialog.f();
    }

    static boolean a(AuthDialog authdialog, boolean flag)
    {
        authdialog.m = flag;
        return flag;
    }

    static WeakReference b()
    {
        return l;
    }

    private static void b(Context context, String s)
    {
        try
        {
            JSONObject jsonobject = Util.parseJson(s);
            int i1 = jsonobject.getInt("type");
            String s1 = jsonobject.getString("msg");
            Toast.makeText(context.getApplicationContext(), s1, i1).show();
            return;
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
        }
    }

    static boolean b(AuthDialog authdialog)
    {
        return authdialog.m;
    }

    static String c(AuthDialog authdialog)
    {
        return authdialog.b;
    }

    private void c()
    {
        d();
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        k = new WebView((Context)a.get());
        k.setLayoutParams(layoutparams);
        f = new FrameLayout((Context)a.get());
        layoutparams.gravity = 17;
        f.setLayoutParams(layoutparams);
        f.addView(k);
        f.addView(h);
        l = new WeakReference(h);
        setContentView(f);
    }

    static WebView d(AuthDialog authdialog)
    {
        return authdialog.k;
    }

    private void d()
    {
        i = new ProgressBar((Context)a.get());
        android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-2, -2);
        i.setLayoutParams(layoutparams);
        g = new LinearLayout((Context)a.get());
        boolean flag = j.equals("action_login");
        TextView textview = null;
        if (flag)
        {
            android.widget.LinearLayout.LayoutParams layoutparams1 = new android.widget.LinearLayout.LayoutParams(-2, -2);
            layoutparams1.gravity = 16;
            layoutparams1.leftMargin = 5;
            TextView textview1 = new TextView((Context)a.get());
            android.widget.FrameLayout.LayoutParams layoutparams2;
            android.widget.FrameLayout.LayoutParams layoutparams3;
            if (Locale.getDefault().getLanguage().equals("zh"))
            {
                textview1.setText("\u767B\u5F55\u4E2D...");
            } else
            {
                textview1.setText("Logging in...");
            }
            textview1.setTextColor(Color.rgb(255, 255, 255));
            textview1.setTextSize(18F);
            textview1.setLayoutParams(layoutparams1);
            textview = textview1;
        }
        layoutparams2 = new android.widget.FrameLayout.LayoutParams(-2, -2);
        layoutparams2.gravity = 17;
        g.setLayoutParams(layoutparams2);
        g.addView(i);
        if (textview != null)
        {
            g.addView(textview);
        }
        h = new FrameLayout((Context)a.get());
        layoutparams3 = new android.widget.FrameLayout.LayoutParams(-1, -2);
        layoutparams3.leftMargin = 80;
        layoutparams3.rightMargin = 80;
        layoutparams3.topMargin = 40;
        layoutparams3.bottomMargin = 40;
        layoutparams3.gravity = 17;
        h.setLayoutParams(layoutparams3);
        h.setBackgroundResource(0x1080000);
        h.addView(g);
    }

    static m e(AuthDialog authdialog)
    {
        return authdialog.c;
    }

    private void e()
    {
        k.setVerticalScrollBarEnabled(false);
        k.setHorizontalScrollBarEnabled(false);
        k.setWebViewClient(new l(this, null));
        k.setWebChromeClient(new WebChromeClient());
        k.clearFormData();
        WebSettings websettings = k.getSettings();
        websettings.setSavePassword(false);
        websettings.setSaveFormData(false);
        websettings.setCacheMode(-1);
        websettings.setNeedInitialFocus(false);
        websettings.setBuiltInZoomControls(true);
        websettings.setSupportZoom(true);
        websettings.setRenderPriority(android.webkit.WebSettings.RenderPriority.HIGH);
        websettings.setJavaScriptEnabled(true);
        if (a != null && a.get() != null)
        {
            websettings.setDatabaseEnabled(true);
            websettings.setDatabasePath(((Context)a.get()).getApplicationContext().getDir("databases", 0).getPath());
        }
        websettings.setDomStorageEnabled(true);
        try
        {
            Method method = android/webkit/WebView.getMethod("addJavascriptInterface", new Class[] {
                java/lang/Object, java/lang/String
            });
            WebView webview = k;
            Object aobj[] = new Object[2];
            aobj[0] = new k(this, null);
            aobj[1] = "sdk_js_if";
            method.invoke(webview, aobj);
        }
        catch (NoSuchMethodException nosuchmethodexception)
        {
            nosuchmethodexception.printStackTrace();
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            illegalargumentexception.printStackTrace();
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            illegalaccessexception.printStackTrace();
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            invocationtargetexception.printStackTrace();
        }
        catch (Exception exception)
        {
            Log.e("AuthDialog", exception.getMessage());
        }
        k.loadUrl(b);
        k.setVisibility(4);
        k.getSettings().setSavePassword(false);
    }

    static Handler f(AuthDialog authdialog)
    {
        return authdialog.e;
    }

    private boolean f()
    {
        AuthMap authmap = AuthMap.getInstance();
        String s = authmap.makeKey();
        AuthMap.Auth auth = new AuthMap.Auth();
        auth.listener = d;
        auth.dialog = this;
        auth.key = s;
        String s1 = authmap.set(auth);
        String s2 = b.substring(0, b.indexOf("?"));
        Bundle bundle = Util.parseUrl(b);
        bundle.putString("token_key", s);
        bundle.putString("serial", s1);
        bundle.putString("browser", "1");
        b = (new StringBuilder()).append(s2).append("?").append(Util.encodeUrl(bundle)).toString();
        WeakReference weakreference = a;
        boolean flag = false;
        if (weakreference != null)
        {
            Object obj = a.get();
            flag = false;
            if (obj != null)
            {
                flag = Util.openBrowser((Context)a.get(), b);
            }
        }
        return flag;
    }

    public void callJs(String s, String s1)
    {
        String s2 = (new StringBuilder()).append("javascript:").append(s).append("(").append(s1).append(");void(").append(System.currentTimeMillis()).append(");").toString();
        k.loadUrl(s2);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        c();
        e();
    }

    protected void onStop()
    {
        if (!m)
        {
            c.onCancel();
        }
        super.onStop();
    }
}
