// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.auth;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.PaintDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.tencent.utils.HttpUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.connect.auth:
//            AuthAgent, d, e, f

class c
    implements IUiListener
{

    IUiListener a;
    final AuthAgent b;
    private String c;
    private String d;
    private String e;

    public c(AuthAgent authagent, IUiListener iuilistener)
    {
        b = authagent;
        super();
        c = "sendinstall";
        d = "installwording";
        e = "http://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi";
        a = iuilistener;
    }

    private Drawable a(String s, Context context)
    {
        AssetManager assetmanager = context.getApplicationContext().getAssets();
        InputStream inputstream = assetmanager.open(s);
        if (inputstream == null)
        {
            return null;
        }
        if (!s.endsWith(".9.png")) goto _L2; else goto _L1
_L1:
        Bitmap bitmap = BitmapFactory.decodeStream(inputstream);
        if (bitmap == null) goto _L4; else goto _L3
_L3:
        NinePatchDrawable ninepatchdrawable;
        byte abyte0[] = bitmap.getNinePatchChunk();
        NinePatch.isNinePatchChunk(abyte0);
        ninepatchdrawable = new NinePatchDrawable(bitmap, abyte0, new Rect(), null);
        return ninepatchdrawable;
        IOException ioexception;
        ioexception;
        Drawable drawable;
        IOException ioexception1;
        drawable = null;
        ioexception1 = ioexception;
_L6:
        ioexception1.printStackTrace();
        return drawable;
_L4:
        return null;
_L2:
        Drawable drawable1 = Drawable.createFromStream(inputstream, s);
        drawable = drawable1;
        inputstream.close();
        return drawable;
        ioexception1;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private View a(Context context, Drawable drawable, String s, android.view.View.OnClickListener onclicklistener, android.view.View.OnClickListener onclicklistener1)
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
        float f1 = displaymetrics.density;
        RelativeLayout relativelayout = new RelativeLayout(context);
        ImageView imageview = new ImageView(context);
        imageview.setImageDrawable(drawable);
        imageview.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        imageview.setId(1);
        int i = (int)(60F * f1);
        int j = (int)(60F * f1);
        int _tmp = (int)(14F * f1);
        int k = (int)(18F * f1);
        int l = (int)(6F * f1);
        int i1 = (int)(18F * f1);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(i, j);
        layoutparams.addRule(9);
        layoutparams.setMargins(0, k, l, i1);
        relativelayout.addView(imageview, layoutparams);
        TextView textview = new TextView(context);
        textview.setText(s);
        textview.setTextSize(14F);
        textview.setGravity(3);
        textview.setIncludeFontPadding(false);
        textview.setPadding(0, 0, 0, 0);
        textview.setLines(2);
        textview.setId(5);
        textview.setMinWidth((int)(185F * f1));
        android.widget.RelativeLayout.LayoutParams layoutparams1 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams1.addRule(1, 1);
        layoutparams1.addRule(6, 1);
        int _tmp1 = (int)(10F * f1);
        layoutparams1.setMargins(0, 0, (int)(5F * f1), 0);
        relativelayout.addView(textview, layoutparams1);
        View view = new View(context);
        view.setBackgroundColor(Color.rgb(214, 214, 214));
        view.setId(3);
        android.widget.RelativeLayout.LayoutParams layoutparams2 = new android.widget.RelativeLayout.LayoutParams(-2, 2);
        layoutparams2.addRule(3, 1);
        layoutparams2.addRule(5, 1);
        layoutparams2.addRule(7, 5);
        layoutparams2.setMargins(0, 0, 0, (int)(12F * f1));
        relativelayout.addView(view, layoutparams2);
        LinearLayout linearlayout = new LinearLayout(context);
        android.widget.RelativeLayout.LayoutParams layoutparams3 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams3.addRule(5, 1);
        layoutparams3.addRule(7, 5);
        layoutparams3.addRule(3, 3);
        Button button = new Button(context);
        button.setText("\u8DF3\u8FC7");
        button.setBackgroundDrawable(a("buttonNegt.png", context));
        button.setTextColor(Color.rgb(36, 97, 131));
        button.setTextSize(20F);
        button.setOnClickListener(onclicklistener1);
        button.setId(4);
        android.widget.LinearLayout.LayoutParams layoutparams4 = new android.widget.LinearLayout.LayoutParams(0, (int)(45F * f1));
        layoutparams4.rightMargin = (int)(14F * f1);
        layoutparams4.leftMargin = (int)(4F * f1);
        layoutparams4.weight = 1.0F;
        linearlayout.addView(button, layoutparams4);
        Button button1 = new Button(context);
        button1.setText("\u786E\u5B9A");
        button1.setTextSize(20F);
        button1.setTextColor(Color.rgb(255, 255, 255));
        button1.setBackgroundDrawable(a("buttonPost.png", context));
        button1.setOnClickListener(onclicklistener);
        android.widget.LinearLayout.LayoutParams layoutparams5 = new android.widget.LinearLayout.LayoutParams(0, (int)(45F * f1));
        layoutparams5.weight = 1.0F;
        layoutparams5.rightMargin = (int)(4F * f1);
        linearlayout.addView(button1, layoutparams5);
        relativelayout.addView(linearlayout, layoutparams3);
        android.widget.FrameLayout.LayoutParams layoutparams6 = new android.widget.FrameLayout.LayoutParams((int)(279F * f1), (int)(163F * f1));
        relativelayout.setPadding((int)(14F * f1), 0, (int)(12F * f1), (int)(12F * f1));
        relativelayout.setLayoutParams(layoutparams6);
        relativelayout.setBackgroundColor(Color.rgb(247, 251, 247));
        PaintDrawable paintdrawable = new PaintDrawable(Color.rgb(247, 251, 247));
        paintdrawable.setCornerRadius(f1 * 5F);
        relativelayout.setBackgroundDrawable(paintdrawable);
        return relativelayout;
    }

    private void a(String s, IUiListener iuilistener, Object obj)
    {
        Dialog dialog;
        PackageManager packagemanager;
        dialog = new Dialog(AuthAgent.i(b));
        dialog.requestWindowFeature(1);
        packagemanager = AuthAgent.i(b).getPackageManager();
        PackageInfo packageinfo1 = packagemanager.getPackageInfo(AuthAgent.i(b).getPackageName(), 0);
        PackageInfo packageinfo = packageinfo1;
_L2:
        Drawable drawable = null;
        if (packageinfo != null)
        {
            drawable = packageinfo.applicationInfo.loadIcon(packagemanager);
        }
        d d1 = new d(this, dialog, iuilistener, obj);
        e e1 = new e(this, dialog, iuilistener, obj);
        ColorDrawable colordrawable = new ColorDrawable();
        colordrawable.setAlpha(0);
        dialog.getWindow().setBackgroundDrawable(colordrawable);
        dialog.setContentView(a(((Context) (AuthAgent.i(b))), drawable, s, ((android.view.View.OnClickListener) (d1)), ((android.view.View.OnClickListener) (e1))));
        dialog.setOnCancelListener(new f(this, iuilistener, obj));
        if (AuthAgent.i(b) != null && !AuthAgent.i(b).isFinishing())
        {
            dialog.show();
        }
        return;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        namenotfoundexception.printStackTrace();
        packageinfo = null;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected void a()
    {
        android.os.Bundle bundle = AuthAgent.j(b);
        HttpUtils.requestAsync(AuthAgent.k(b), AuthAgent.i(b), e, bundle, "POST", null);
    }

    public void onCancel()
    {
        if (a != null)
        {
            a.onCancel();
        }
    }

    public void onComplete(Object obj)
    {
        boolean flag = false;
        if (obj == null) goto _L2; else goto _L1
_L1:
        JSONObject jsonobject = (JSONObject)obj;
        if (jsonobject == null) goto _L4; else goto _L3
_L3:
        boolean flag2;
        String s;
        String s1;
        int i;
        String s2;
        try
        {
            i = jsonobject.getInt(c);
        }
        catch (JSONException jsonexception)
        {
            boolean flag1 = flag;
            Toast.makeText(AuthAgent.i(b), "json error", 1);
            jsonexception.printStackTrace();
            flag2 = flag1;
            s = "";
            continue; /* Loop/switch isn't completed */
        }
        flag = false;
        if (i == 1)
        {
            flag = true;
        }
        s2 = jsonobject.getString(d);
        s = s2;
        flag2 = flag;
_L10:
        s1 = URLDecoder.decode(s);
        Log.d("TAG", (new StringBuilder()).append(" WORDING = ").append(s1).append("xx").toString());
        if (!flag2 || TextUtils.isEmpty(s1)) goto _L6; else goto _L5
_L5:
        a(s1, a, obj);
_L4:
        return;
_L6:
        if (a == null) goto _L4; else goto _L7
_L7:
        a.onComplete(obj);
        return;
_L2:
        if (a == null) goto _L4; else goto _L8
_L8:
        a.onComplete(null);
        return;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public void onError(UiError uierror)
    {
        if (a != null)
        {
            a.onError(uierror);
        }
    }
}
