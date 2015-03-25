// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.connect.auth.QQToken;
import com.tencent.tauth.IUiListener;
import com.tencent.utils.Util;
import java.io.File;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.open:
//            d, o, p, m, 
//            n, a

public class TDialog extends d
{

    static final android.widget.FrameLayout.LayoutParams a = new android.widget.FrameLayout.LayoutParams(-1, -1);
    static Toast b = null;
    private static WeakReference c;
    private static WeakReference d;
    private static WeakReference e;
    private String f;
    private o g;
    private IUiListener h;
    private FrameLayout i;
    private WebView j;
    private FrameLayout k;
    private ProgressBar l;
    private Handler m;
    private boolean n;
    private QQToken o;

    public TDialog(Context context, String s, String s1, IUiListener iuilistener, QQToken qqtoken)
    {
        super(context, 0x1030010);
        n = false;
        o = null;
        c = new WeakReference(context);
        f = s1;
        g = new o(context, s, s1, qqtoken.getAppId(), iuilistener);
        m = new p(g, context.getMainLooper());
        h = iuilistener;
        o = qqtoken;
    }

    static Handler a(TDialog tdialog)
    {
        return tdialog.m;
    }

    static WeakReference a()
    {
        return c;
    }

    static void a(Context context, String s)
    {
        c(context, s);
    }

    static o b(TDialog tdialog)
    {
        return tdialog.g;
    }

    static WeakReference b()
    {
        return d;
    }

    static void b(Context context, String s)
    {
        d(context, s);
    }

    static WebView c(TDialog tdialog)
    {
        return tdialog.j;
    }

    private void c()
    {
        l = new ProgressBar((Context)c.get());
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-2, -2);
        layoutparams.gravity = 17;
        l.setLayoutParams(layoutparams);
        (new TextView((Context)c.get())).setText("test");
        k = new FrameLayout((Context)c.get());
        android.widget.FrameLayout.LayoutParams layoutparams1 = new android.widget.FrameLayout.LayoutParams(-1, -2);
        layoutparams1.bottomMargin = 40;
        layoutparams1.leftMargin = 80;
        layoutparams1.rightMargin = 80;
        layoutparams1.topMargin = 40;
        layoutparams1.gravity = 17;
        k.setLayoutParams(layoutparams1);
        k.setBackgroundResource(0x1080000);
        k.addView(l);
        android.widget.FrameLayout.LayoutParams layoutparams2 = new android.widget.FrameLayout.LayoutParams(-1, -1);
        j = new WebView((Context)c.get());
        j.setLayoutParams(layoutparams2);
        i = new FrameLayout((Context)c.get());
        layoutparams2.gravity = 17;
        i.setLayoutParams(layoutparams2);
        i.addView(j);
        i.addView(k);
        d = new WeakReference(k);
        setContentView(i);
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
            break MISSING_BLOCK_LABEL_85;
        }
        if (b != null)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        b = Toast.makeText(context, s1, 0);
_L2:
        b.show();
        return;
        b.setView(b.getView());
        b.setText(s1);
        b.setDuration(0);
        if (true) goto _L2; else goto _L1
_L1:
        if (i1 != 1)
        {
            break MISSING_BLOCK_LABEL_144;
        }
        if (b != null)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        b = Toast.makeText(context, s1, 1);
_L4:
        b.show();
        return;
        b.setView(b.getView());
        b.setText(s1);
        b.setDuration(1);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void d()
    {
        j.setVerticalScrollBarEnabled(false);
        j.setHorizontalScrollBarEnabled(false);
        j.setWebViewClient(new m(this, null));
        j.setWebChromeClient(mChromeClient);
        j.clearFormData();
        WebSettings websettings = j.getSettings();
        websettings.setSavePassword(false);
        websettings.setSaveFormData(false);
        websettings.setCacheMode(-1);
        websettings.setNeedInitialFocus(false);
        websettings.setBuiltInZoomControls(true);
        websettings.setSupportZoom(true);
        websettings.setRenderPriority(android.webkit.WebSettings.RenderPriority.HIGH);
        websettings.setJavaScriptEnabled(true);
        if (c != null && c.get() != null)
        {
            websettings.setDatabaseEnabled(true);
            websettings.setDatabasePath(((Context)c.get()).getApplicationContext().getDir("databases", 0).getPath());
        }
        websettings.setDomStorageEnabled(true);
        jsBridge.a(new n(this, null), "sdk_js_if");
        j.loadUrl(f);
        j.setLayoutParams(a);
        j.setVisibility(4);
        j.getSettings().setSavePassword(false);
    }

    private static void d(Context context, String s)
    {
        if (context != null && s != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i1;
        String s1;
        ProgressDialog progressdialog;
        try
        {
            JSONObject jsonobject = Util.parseJson(s);
            i1 = jsonobject.getInt("action");
            s1 = jsonobject.getString("msg");
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            return;
        }
        if (i1 != 1)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (e == null)
        {
            progressdialog = new ProgressDialog(context);
            progressdialog.setMessage(s1);
            e = new WeakReference(progressdialog);
            progressdialog.show();
            return;
        }
        ((ProgressDialog)e.get()).setMessage(s1);
        if (((ProgressDialog)e.get()).isShowing()) goto _L1; else goto _L3
_L3:
        ((ProgressDialog)e.get()).show();
        return;
        if (i1 != 0) goto _L1; else goto _L4
_L4:
        if (e == null || e.get() == null || !((ProgressDialog)e.get()).isShowing()) goto _L1; else goto _L5
_L5:
        ((ProgressDialog)e.get()).dismiss();
        e = null;
        return;
    }

    protected void onConsoleMessage(String s)
    {
        Log.d("TDialog", "--onConsoleMessage--");
        try
        {
            jsBridge.a(j, s);
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
        c();
        d();
    }

    protected void onStop()
    {
        if (!n)
        {
            g.onCancel();
        }
        super.onStop();
    }

}
