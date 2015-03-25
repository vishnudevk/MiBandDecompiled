// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.avatar;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.tauth.IUiListener;
import com.tencent.utils.Util;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.tencent.connect.avatar:
//            l, o, n, h, 
//            b, g, c, f, 
//            e, a, d

public class ImageActivity extends Activity
{

    RelativeLayout a;
    private QQToken b;
    private String c;
    private Handler d;
    private b e;
    private Button f;
    private Button g;
    private g h;
    private TextView i;
    private ProgressBar j;
    private int k;
    private boolean l;
    private long m;
    private int n;
    private int o;
    private int p;
    private Rect q;
    private String r;
    private Bitmap s;
    private android.view.View.OnClickListener t;
    private android.view.View.OnClickListener u;
    private IUiListener v;
    private IUiListener w;

    public ImageActivity()
    {
        k = 0;
        l = false;
        m = 0L;
        n = 0;
        o = 640;
        p = 640;
        q = new Rect();
        t = new l(this);
        u = new o(this);
        v = new n(this);
        w = new h(this);
    }

    private Bitmap a(String s1)
    {
        boolean flag = true;
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = flag;
        Uri uri = Uri.parse(s1);
        InputStream inputstream = getContentResolver().openInputStream(uri);
        if (inputstream == null)
        {
            return null;
        }
        BitmapFactory.decodeStream(inputstream, null, options);
        inputstream.close();
        int i1 = options.outWidth;
        int j1 = options.outHeight;
        do
        {
            if (i1 * j1 <= 0x400000)
            {
                options.inJustDecodeBounds = false;
                options.inSampleSize = ((flag) ? 1 : 0);
                return BitmapFactory.decodeStream(getContentResolver().openInputStream(uri), null, options);
            }
            i1 /= 2;
            j1 /= 2;
            flag *= 2;
        } while (true);
    }

    static Rect a(ImageActivity imageactivity, Rect rect)
    {
        imageactivity.q = rect;
        return rect;
    }

    static Drawable a(ImageActivity imageactivity, String s1)
    {
        return imageactivity.b(s1);
    }

    private View a()
    {
        android.view.ViewGroup.LayoutParams layoutparams = new android.view.ViewGroup.LayoutParams(-1, -1);
        android.view.ViewGroup.LayoutParams layoutparams1 = new android.view.ViewGroup.LayoutParams(-1, -1);
        android.view.ViewGroup.LayoutParams layoutparams2 = new android.view.ViewGroup.LayoutParams(-2, -2);
        a = new RelativeLayout(this);
        a.setLayoutParams(layoutparams);
        a.setBackgroundColor(0xff000000);
        RelativeLayout relativelayout = new RelativeLayout(this);
        relativelayout.setLayoutParams(layoutparams2);
        a.addView(relativelayout);
        e = new b(this);
        e.setLayoutParams(layoutparams1);
        e.setScaleType(android.widget.ImageView.ScaleType.MATRIX);
        relativelayout.addView(e);
        h = new g(this);
        android.widget.RelativeLayout.LayoutParams layoutparams3 = new android.widget.RelativeLayout.LayoutParams(layoutparams1);
        layoutparams3.addRule(14, -1);
        layoutparams3.addRule(15, -1);
        h.setLayoutParams(layoutparams3);
        relativelayout.addView(h);
        LinearLayout linearlayout = new LinearLayout(this);
        android.widget.RelativeLayout.LayoutParams layoutparams4 = new android.widget.RelativeLayout.LayoutParams(-2, com.tencent.connect.avatar.c.a(this, 80F));
        layoutparams4.addRule(14, -1);
        linearlayout.setLayoutParams(layoutparams4);
        linearlayout.setOrientation(0);
        linearlayout.setGravity(17);
        a.addView(linearlayout);
        ImageView imageview = new ImageView(this);
        imageview.setLayoutParams(new android.widget.LinearLayout.LayoutParams(com.tencent.connect.avatar.c.a(this, 24F), com.tencent.connect.avatar.c.a(this, 24F)));
        imageview.setImageDrawable(b("com.tencent.plus.logo.png"));
        linearlayout.addView(imageview);
        i = new TextView(this);
        android.widget.LinearLayout.LayoutParams layoutparams5 = new android.widget.LinearLayout.LayoutParams(layoutparams2);
        layoutparams5.leftMargin = com.tencent.connect.avatar.c.a(this, 7F);
        i.setLayoutParams(layoutparams5);
        i.setEllipsize(android.text.TextUtils.TruncateAt.END);
        i.setSingleLine();
        i.setTextColor(-1);
        i.setTextSize(24F);
        i.setVisibility(8);
        linearlayout.addView(i);
        RelativeLayout relativelayout1 = new RelativeLayout(this);
        android.widget.RelativeLayout.LayoutParams layoutparams6 = new android.widget.RelativeLayout.LayoutParams(-1, com.tencent.connect.avatar.c.a(this, 60F));
        layoutparams6.addRule(12, -1);
        layoutparams6.addRule(9, -1);
        relativelayout1.setLayoutParams(layoutparams6);
        relativelayout1.setBackgroundDrawable(b("com.tencent.plus.bar.png"));
        int i1 = com.tencent.connect.avatar.c.a(this, 10F);
        relativelayout1.setPadding(i1, i1, i1, 0);
        a.addView(relativelayout1);
        f f1 = new f(this, this);
        int j1 = com.tencent.connect.avatar.c.a(this, 14F);
        int k1 = com.tencent.connect.avatar.c.a(this, 7F);
        g = new Button(this);
        android.widget.RelativeLayout.LayoutParams layoutparams7 = new android.widget.RelativeLayout.LayoutParams(com.tencent.connect.avatar.c.a(this, 78F), com.tencent.connect.avatar.c.a(this, 45F));
        g.setLayoutParams(layoutparams7);
        g.setText("\u53D6\u6D88");
        g.setTextColor(-1);
        g.setTextSize(18F);
        g.setPadding(j1, k1, j1, k1);
        f1.b(g);
        relativelayout1.addView(g);
        f = new Button(this);
        android.widget.RelativeLayout.LayoutParams layoutparams8 = new android.widget.RelativeLayout.LayoutParams(com.tencent.connect.avatar.c.a(this, 78F), com.tencent.connect.avatar.c.a(this, 45F));
        layoutparams8.addRule(11, -1);
        f.setLayoutParams(layoutparams8);
        f.setTextColor(-1);
        f.setTextSize(18F);
        f.setPadding(j1, k1, j1, k1);
        f.setText("\u9009\u53D6");
        f1.a(f);
        relativelayout1.addView(f);
        TextView textview = new TextView(this);
        android.widget.RelativeLayout.LayoutParams layoutparams9 = new android.widget.RelativeLayout.LayoutParams(layoutparams2);
        layoutparams9.addRule(13, -1);
        textview.setLayoutParams(layoutparams9);
        textview.setText("\u79FB\u52A8\u548C\u7F29\u653E");
        textview.setPadding(0, com.tencent.connect.avatar.c.a(this, 3F), 0, 0);
        textview.setTextSize(18F);
        textview.setTextColor(-1);
        relativelayout1.addView(textview);
        j = new ProgressBar(this);
        android.widget.RelativeLayout.LayoutParams layoutparams10 = new android.widget.RelativeLayout.LayoutParams(layoutparams2);
        layoutparams10.addRule(14, -1);
        layoutparams10.addRule(15, -1);
        j.setLayoutParams(layoutparams10);
        j.setVisibility(8);
        a.addView(j);
        return a;
    }

    static g a(ImageActivity imageactivity)
    {
        return imageactivity.h;
    }

    private void a(int i1, String s1, String s2, String s3)
    {
        Intent intent = new Intent();
        intent.putExtra("key_error_code", i1);
        intent.putExtra("key_error_msg", s2);
        intent.putExtra("key_error_detail", s3);
        intent.putExtra("key_response", s1);
        setResult(-1, intent);
    }

    private void a(Bitmap bitmap)
    {
        (new e(this, this, b)).a(bitmap, v);
    }

    static void a(ImageActivity imageactivity, int i1, String s1, String s2, String s3)
    {
        imageactivity.a(i1, s1, s2, s3);
    }

    static void a(ImageActivity imageactivity, String s1, int i1)
    {
        imageactivity.b(s1, i1);
    }

    private void a(String s1, int i1)
    {
        d.post(new a(this, s1, i1));
    }

    static boolean a(ImageActivity imageactivity, boolean flag)
    {
        imageactivity.l = flag;
        return flag;
    }

    static Rect b(ImageActivity imageactivity)
    {
        return imageactivity.q;
    }

    private Drawable b(String s1)
    {
        AssetManager assetmanager = getAssets();
        InputStream inputstream;
        Drawable drawable1;
        inputstream = assetmanager.open(s1);
        drawable1 = Drawable.createFromStream(inputstream, s1);
        Drawable drawable = drawable1;
        inputstream.close();
        return drawable;
        IOException ioexception;
        ioexception;
        IOException ioexception1;
        drawable = null;
        ioexception1 = ioexception;
_L2:
        ioexception1.printStackTrace();
        return drawable;
        ioexception1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void b()
    {
        IOException ioexception;
        s = a(r);
        if (s == null)
        {
            throw new IOException((new StringBuilder()).append("cannot read picture: '").append(r).append("'!").toString());
        }
          goto _L1
_L3:
        f.setOnClickListener(t);
        g.setOnClickListener(u);
        a.getViewTreeObserver().addOnGlobalLayoutListener(new d(this));
        return;
_L1:
        try
        {
            e.setImageBitmap(s);
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            b("\u56FE\u7247\u8BFB\u53D6\u5931\u8D25\uFF0C\u8BF7\u68C0\u67E5\u8BE5\u56FE\u7247\u662F\u5426\u6709\u6548", 1);
            a(-5, null, "\u56FE\u7247\u8BFB\u53D6\u5931\u8D25\uFF0C\u8BF7\u68C0\u67E5\u8BE5\u56FE\u7247\u662F\u5426\u6709\u6548", ioexception.getMessage());
            d();
        }
        if (true) goto _L3; else goto _L2
_L2:
    }

    static void b(ImageActivity imageactivity, String s1)
    {
        imageactivity.c(s1);
    }

    static void b(ImageActivity imageactivity, String s1, int i1)
    {
        imageactivity.a(s1, i1);
    }

    private void b(String s1, int i1)
    {
        Toast toast = Toast.makeText(this, s1, 1);
        LinearLayout linearlayout = (LinearLayout)toast.getView();
        ((TextView)linearlayout.getChildAt(0)).setPadding(8, 0, 0, 0);
        ImageView imageview = new ImageView(this);
        imageview.setLayoutParams(new android.widget.LinearLayout.LayoutParams(com.tencent.connect.avatar.c.a(this, 16F), com.tencent.connect.avatar.c.a(this, 16F)));
        if (i1 == 0)
        {
            imageview.setImageDrawable(b("com.tencent.plus.ic_success.png"));
        } else
        {
            imageview.setImageDrawable(b("com.tencent.plus.ic_error.png"));
        }
        linearlayout.addView(imageview, 0);
        linearlayout.setOrientation(0);
        linearlayout.setGravity(17);
        toast.setView(linearlayout);
        toast.setGravity(17, 0, 0);
        toast.show();
    }

    static b c(ImageActivity imageactivity)
    {
        return imageactivity.e;
    }

    private void c()
    {
        float f1 = q.width();
        Matrix matrix = e.getImageMatrix();
        float af[] = new float[9];
        matrix.getValues(af);
        float f2 = af[2];
        float f3 = af[5];
        float f4 = af[0];
        float f5 = (float)o / f1;
        int i1 = (int)(((float)q.left - f2) / f4);
        int j1 = (int)(((float)q.top - f3) / f4);
        Matrix matrix1 = new Matrix();
        matrix1.set(matrix);
        matrix1.postScale(f5, f5);
        int k1 = (int)(650F / f4);
        int l1 = Math.min(s.getWidth() - i1, k1);
        int i2 = Math.min(s.getHeight() - j1, k1);
        Bitmap bitmap = Bitmap.createBitmap(s, i1, j1, l1, i2, matrix1, true);
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap, 0, 0, o, p);
        bitmap.recycle();
        a(bitmap1);
    }

    private void c(String s1)
    {
        String s2 = d(s1);
        if (!"".equals(s2))
        {
            i.setText(s2);
            i.setVisibility(0);
        }
    }

    static ProgressBar d(ImageActivity imageactivity)
    {
        return imageactivity.j;
    }

    private String d(String s1)
    {
        return s1.replaceAll("&gt;", ">").replaceAll("&lt;", "<").replaceAll("&quot;", "\"").replaceAll("&#39;", "'").replaceAll("&amp;", "&");
    }

    private void d()
    {
        finish();
        if (n != 0)
        {
            overridePendingTransition(0, n);
        }
    }

    static Button e(ImageActivity imageactivity)
    {
        return imageactivity.g;
    }

    private void e()
    {
        k = 1 + k;
        (new UserInfo(this, b)).getUserInfo(w);
    }

    static Button f(ImageActivity imageactivity)
    {
        return imageactivity.f;
    }

    static void g(ImageActivity imageactivity)
    {
        imageactivity.c();
    }

    static boolean h(ImageActivity imageactivity)
    {
        return imageactivity.l;
    }

    static long i(ImageActivity imageactivity)
    {
        return imageactivity.m;
    }

    static void j(ImageActivity imageactivity)
    {
        imageactivity.d();
    }

    static String k(ImageActivity imageactivity)
    {
        return imageactivity.c;
    }

    static Handler l(ImageActivity imageactivity)
    {
        return imageactivity.d;
    }

    static int m(ImageActivity imageactivity)
    {
        return imageactivity.k;
    }

    static void n(ImageActivity imageactivity)
    {
        imageactivity.e();
    }

    public void a(String s1, long l1)
    {
        Util.reportBernoulli(this, s1, l1, b.getAppId());
    }

    public void onBackPressed()
    {
        setResult(0);
        d();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setRequestedOrientation(1);
        setContentView(a());
        d = new Handler();
        Bundle bundle1 = getIntent().getBundleExtra("key_params");
        r = bundle1.getString("picture");
        c = bundle1.getString("return_activity");
        String s1 = bundle1.getString("appid");
        String s2 = bundle1.getString("access_token");
        long l1 = bundle1.getLong("expires_in");
        String s3 = bundle1.getString("openid");
        n = bundle1.getInt("exitAnim");
        b = new QQToken(s1);
        b.setAccessToken(s2, (new StringBuilder()).append((l1 - System.currentTimeMillis()) / 1000L).append("").toString());
        b.setOpenId(s3);
        b();
        e();
        m = System.currentTimeMillis();
        a("10653", 0L);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        e.setImageBitmap(null);
        if (s != null && !s.isRecycled())
        {
            s.recycle();
        }
    }
}
