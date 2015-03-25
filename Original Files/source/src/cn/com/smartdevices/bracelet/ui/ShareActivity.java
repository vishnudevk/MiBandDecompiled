// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.app.FragmentManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.ShareData;
import cn.com.smartdevices.bracelet.view.CustomToast;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.WXImageObject;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.tencent.tauth.Tencent;
import com.xiaomi.channel.sdk.MLImgObj;
import com.xiaomi.channel.sdk.MLShareApiFactory;
import com.xiaomi.channel.sdk.MLShareMessage;
import com.xiaomi.channel.sdk.MLShareReq;
import com.xiaomi.channel.sdk.VersionManager;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            SystemBarTintActivity, bW, bX, FragmentShareToMiliaoSelect

public class ShareActivity extends SystemBarTintActivity
    implements android.view.View.OnClickListener, IWXAPIEventHandler
{

    private static final String A = "share_weibo";
    private static final String B = "share_qq";
    private static final String C = "share_qq_zone";
    public static final int MODE_SHARE_DYNAMIC = 0;
    public static final int MODE_SHARE_IMAGE = 1;
    public static final String PACKAGE_WEIXIN = "com.tencent.mm";
    private static final String y = "share_weixin";
    private static final String z = "share_pengyouquan";
    private HashMap D;
    private final String E = "com.sina.weibo";
    private final String F = "com.qzone";
    private final String G = "com.tencent.mobileqq";
    private final String H = "com.tencent.mobileqq.activity.JumpActivity";
    private final String I = "com.tencent.mm.ui.tools.ShareImgUI";
    private final String J = "com.tencent.mm.ui.tools.ShareToTimeLineUI";
    private ShareData K;
    private TextView L;
    private Bitmap M;
    private String N;
    private TextView O;
    private TextView P;
    private TextView Q;
    private String R;
    private Bitmap S;
    private View T;
    private TextView U;
    private String V;
    private View a;
    private TextView b;
    private View c;
    private ImageView d;
    private TextView e;
    private ImageView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private Button k;
    private Button l;
    private Button m;
    private Button n;
    private Button o;
    private Button p;
    private View q;
    private TextView r;
    private Tencent s;
    private IWXAPI t;
    private MLShareApiFactory u;
    private String v;
    private String w;
    private String x;

    public ShareActivity()
    {
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        l = null;
        m = null;
        n = null;
        o = null;
        p = null;
        q = null;
        r = null;
        s = null;
        t = null;
        u = null;
        v = "";
        w = "";
        x = "";
        D = new HashMap();
        K = null;
        M = null;
        N = null;
        R = null;
        S = null;
    }

    private void a()
    {
        TextView textview;
        int i1;
        String s2;
        S = BitmapFactory.decodeFile(R);
        T.setVisibility(8);
        d.setVisibility(0);
        d.setImageBitmap(S);
        U.setVisibility(0);
        textview = (TextView)findViewById(0x7f0a0077);
        String s1 = (new SimpleDateFormat(getString(0x7f0d0055))).format(new Date());
        textview.setText((new StringBuilder()).append(getString(0x7f0d0047)).append(" ").append(s1).toString());
        i1 = ChartData.getDynamicData().getCurrentMode();
        s2 = getString(0x7f0d008f);
        if (i1 != 1) goto _L2; else goto _L1
_L1:
        if (Utils.isTodayReachGoal())
        {
            s2 = getString(0x7f0d0172);
        } else
        {
            s2 = getString(0x7f0d008f);
        }
_L4:
        U.setText(s2);
        if (K.type == 11)
        {
            U.setVisibility(8);
            f.setVisibility(8);
            g.setVisibility(8);
            if (getIntent().getIntExtra("EventPageType", 0) != 1)
            {
                break; /* Loop/switch isn't completed */
            }
            textview.setTextColor(0xfff2d1d2);
        }
        return;
_L2:
        if (i1 == 16)
        {
            s2 = getString(0x7f0d008e);
        }
        if (true) goto _L4; else goto _L3
_L3:
        ((View)textview.getParent()).setVisibility(8);
        return;
    }

    private void a(ResolveInfo resolveinfo, String s1, String s2)
    {
        try
        {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setComponent(new ComponentName(resolveinfo.activityInfo.packageName, resolveinfo.activityInfo.name));
            intent.setType("image/*");
            intent.putExtra("android.intent.extra.SUBJECT", v);
            intent.putExtra("android.intent.extra.TEXT", s2);
            intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(s1)));
            intent.setFlags(0x10000000);
            startActivity(intent);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    private void a(ShareData sharedata)
    {
        R = getIntent().getStringExtra("pic_url");
        if (R != null)
        {
            a();
        }
        Debug.i("share", sharedata.toString());
        e.setText(sharedata.time);
        i.setText(sharedata.contentUnit);
        q.setBackgroundColor(sharedata.color);
        r.setText(sharedata.title);
        j.setText(sharedata.description);
        L.setText(sharedata.time_tips);
        if (!sharedata.isSleepType()) goto _L2; else goto _L1
_L1:
        int l1 = Integer.valueOf(sharedata.content).intValue();
        int i1 = l1;
_L3:
        int j1 = i1 % 60;
        int k1 = i1 / 60;
        h.setText((new StringBuilder()).append(k1).append("").toString());
        P.setText((new StringBuilder()).append(j1).append("").toString());
        Q.setVisibility(0);
        P.setVisibility(0);
        O.setVisibility(0);
        return;
        Exception exception;
        exception;
        exception.printStackTrace();
        i1 = 0;
        if (true) goto _L3; else goto _L2
_L2:
        h.setText(sharedata.content);
        return;
    }

    private void a(String s1)
    {
        Bundle bundle = new Bundle();
        bundle.putInt("req_type", 5);
        bundle.putString("title", v);
        bundle.putString("summary", w);
        bundle.putString("targetUrl", "http://www.baidu.com");
        bundle.putString("appName", getString(0x7f0d001a));
        bundle.putString("imageLocalUrl", s1);
        s.shareToQQ(this, bundle, new bW(this));
    }

    private void a(String s1, String s2)
    {
        if (D.containsKey(s1))
        {
            a((ResolveInfo)D.get(s1), h(), s2);
            return;
        } else
        {
            CustomToast.makeText(this, 0x7f0d017d, 0).show();
            return;
        }
    }

    private boolean a(String s1, boolean flag)
    {
        if (!t.isWXAppInstalled())
        {
            CustomToast.makeText(this, 0x7f0d017d, 0).show();
            return false;
        }
        WXImageObject wximageobject = new WXImageObject();
        wximageobject.setImagePath(s1);
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inSampleSize = 4;
        M = BitmapFactory.decodeFile(s1, options);
        WXMediaMessage wxmediamessage = new WXMediaMessage();
        wxmediamessage.mediaObject = wximageobject;
        wxmediamessage.title = v;
        wxmediamessage.description = w;
        if (M != null)
        {
            wxmediamessage.setThumbImage(M);
        }
        com.tencent.mm.sdk.modelmsg.SendMessageToWX.Req req = new com.tencent.mm.sdk.modelmsg.SendMessageToWX.Req();
        req.transaction = String.valueOf(System.currentTimeMillis());
        req.message = wxmediamessage;
        int i1 = 0;
        if (flag)
        {
            i1 = 1;
        }
        req.scene = i1;
        return t.sendReq(req);
    }

    private void b()
    {
        K.type;
        JVM INSTR tableswitch 0 11: default 68
    //                   0 80
    //                   1 90
    //                   2 100
    //                   3 120
    //                   4 140
    //                   5 160
    //                   6 130
    //                   7 110
    //                   8 170
    //                   9 150
    //                   10 68
    //                   11 180;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L1 _L12
_L1:
        UmengAnalytics.event(this, "Share", V);
        return;
_L2:
        V = "ShareStepGoalSuccess";
        continue; /* Loop/switch isn't completed */
_L3:
        V = "ShareStepGoalFailed";
        continue; /* Loop/switch isn't completed */
_L4:
        V = "ShareSleep";
        continue; /* Loop/switch isn't completed */
_L9:
        V = "ShareWeeklySteps";
        continue; /* Loop/switch isn't completed */
_L5:
        V = "ShareWeeklySleep";
        continue; /* Loop/switch isn't completed */
_L8:
        V = "ShareMonthlySteps";
        continue; /* Loop/switch isn't completed */
_L6:
        V = "ShareMonthlySleep";
        continue; /* Loop/switch isn't completed */
_L11:
        V = "ShareStepDynamicList";
        continue; /* Loop/switch isn't completed */
_L7:
        V = "ShareNewRecord";
        continue; /* Loop/switch isn't completed */
_L10:
        V = "ShareContinueDays";
        continue; /* Loop/switch isn't completed */
_L12:
        V = "ShareEvent";
        if (true) goto _L1; else goto _L13
_L13:
    }

    private void b(String s1)
    {
        Bundle bundle = new Bundle();
        bundle.putString("title", v);
        bundle.putString("summary", w);
        bundle.putString("appName", getString(0x7f0d001a));
        bundle.putString("targetUrl", "http://www.baidu.com");
        ArrayList arraylist = new ArrayList();
        arraylist.add(s1);
        bundle.putStringArrayList("imageUrl", arraylist);
        s.shareToQzone(this, bundle, new bX(this));
    }

    private void c()
    {
        PersonInfo personinfo = Keeper.readPersonInfo();
        Debug.i("WPJ", personinfo.toString());
        f = (ImageView)findViewById(0x7f0a0074);
        Utils.updateAvatarUI(personinfo, f);
        g = (TextView)findViewById(0x7f0a0075);
        g.setText(personinfo.nickname);
        h = (TextView)findViewById(0x7f0a006b);
        Q = (TextView)findViewById(0x7f0a006c);
        P = (TextView)findViewById(0x7f0a006d);
        O = (TextView)findViewById(0x7f0a006e);
        i = (TextView)findViewById(0x7f0a006f);
        j = (TextView)findViewById(0x7f0a0076);
        q = findViewById(0x7f0a0067);
        r = (TextView)findViewById(0x7f0a0069);
        e = (TextView)findViewById(0x7f0a0070);
        L = (TextView)findViewById(0x7f0a0071);
    }

    private void d()
    {
        U = (TextView)findViewById(0x7f0a0073);
        a = findViewById(0x7f0a0078);
        b = (TextView)findViewById(0x7f0a0079);
        b.setOnClickListener(this);
        c = findViewById(0x7f0a0066);
        T = findViewById(0x7f0a0068);
        d = (ImageView)findViewById(0x7f0a0072);
        l = (Button)findViewById(0x7f0a007b);
        l.setOnClickListener(this);
        n = (Button)findViewById(0x7f0a007f);
        n.setOnClickListener(this);
        m = (Button)findViewById(0x7f0a007e);
        m.setOnClickListener(this);
        o = (Button)findViewById(0x7f0a007d);
        o.setOnClickListener(this);
        k = (Button)findViewById(0x7f0a007a);
        k.setOnClickListener(this);
        p = (Button)findViewById(0x7f0a007c);
        p.setOnClickListener(this);
    }

    private void e()
    {
        if (!t.isWXAppInstalled())
        {
            android.graphics.drawable.Drawable drawable4 = getResources().getDrawable(0x7f0200a5);
            l.setBackground(drawable4);
            android.graphics.drawable.Drawable drawable5 = getResources().getDrawable(0x7f0200ae);
            k.setBackground(drawable5);
        }
        if (!D.containsKey("share_qq"))
        {
            android.graphics.drawable.Drawable drawable3 = getResources().getDrawable(0x7f0200a7);
            n.setBackground(drawable3);
        }
        if (!D.containsKey("share_qq_zone"))
        {
            android.graphics.drawable.Drawable drawable2 = getResources().getDrawable(0x7f0200a9);
            m.setBackground(drawable2);
        }
        if (!D.containsKey("share_weibo"))
        {
            android.graphics.drawable.Drawable drawable1 = getResources().getDrawable(0x7f0200ac);
            o.setBackground(drawable1);
        }
        if (!VersionManager.isMiliaoVersionAvailable(this))
        {
            android.graphics.drawable.Drawable drawable = getResources().getDrawable(0x7f0200a3);
            p.setBackground(drawable);
            p.setVisibility(8);
        }
    }

    private List f()
    {
        Intent intent = new Intent("android.intent.action.SEND", null);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setType("image/*");
        return getPackageManager().queryIntentActivities(intent, 0);
    }

    private void g()
    {
        Iterator iterator = f().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ResolveInfo resolveinfo = (ResolveInfo)iterator.next();
            String s1 = resolveinfo.activityInfo.applicationInfo.packageName;
            String s2 = resolveinfo.activityInfo.name;
            if (s1.equalsIgnoreCase("com.sina.weibo"))
            {
                D.put("share_weibo", resolveinfo);
            } else
            if (s1.equalsIgnoreCase("com.tencent.mm"))
            {
                if (s2.equalsIgnoreCase("com.tencent.mm.ui.tools.ShareToTimeLineUI"))
                {
                    D.put("share_pengyouquan", resolveinfo);
                } else
                if (s2.equalsIgnoreCase("com.tencent.mm.ui.tools.ShareImgUI"))
                {
                    D.put("share_weixin", resolveinfo);
                }
            } else
            if (s1.equalsIgnoreCase("com.qzone"))
            {
                D.put("share_qq_zone", resolveinfo);
            } else
            if (s1.equalsIgnoreCase("com.tencent.mobileqq") && s2.equalsIgnoreCase("com.tencent.mobileqq.activity.JumpActivity"))
            {
                D.put("share_qq", resolveinfo);
            }
        } while (true);
    }

    private String h()
    {
        Bitmap bitmap = j();
        i();
        N = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/").append("share.jpg").toString();
        Utils.saveBitmapToFile(N, bitmap);
        c.destroyDrawingCache();
        return N;
    }

    private void i()
    {
        if (N != null)
        {
            File file = new File(N);
            if (file.exists())
            {
                file.delete();
            }
        }
        N = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/").append("share.jpg").toString();
        File file1 = new File(N);
        if (file1.exists())
        {
            file1.delete();
        }
    }

    private Bitmap j()
    {
        c.buildDrawingCache();
        return c.getDrawingCache();
    }

    private void k()
    {
        int i1 = VersionManager.checkMiliaoVersion(this);
        if (i1 == 0xfffea06f)
        {
            CustomToast.makeText(this, 0x7f0d017d, 0).show();
            return;
        }
        if (i1 == 0xfffea06e)
        {
            CustomToast.makeText(this, 0x7f0d0162, 0).show();
            return;
        } else
        {
            android.app.FragmentTransaction fragmenttransaction = getFragmentManager().beginTransaction();
            (new FragmentShareToMiliaoSelect()).show(fragmenttransaction, null);
            return;
        }
    }

    public void onClick(View view)
    {
        int i1;
        Object obj;
        i1 = view.getId();
        obj = null;
        i1;
        JVM INSTR tableswitch 2131361913 2131361919: default 52
    //                   2131361913 101
    //                   2131361914 198
    //                   2131361915 110
    //                   2131361916 215
    //                   2131361917 161
    //                   2131361918 144
    //                   2131361919 127;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            HashMap hashmap = new HashMap();
            hashmap.put("Type", V);
            hashmap.put("To", obj);
            UmengAnalytics.event(this, "ShareTo", hashmap);
        }
        return;
_L2:
        finish();
        obj = null;
        continue; /* Loop/switch isn't completed */
_L4:
        a(h(), true);
        obj = "ShareToWeChatFriends";
        continue; /* Loop/switch isn't completed */
_L8:
        a("share_qq", w);
        obj = "ShareToQQ";
        continue; /* Loop/switch isn't completed */
_L7:
        a("share_qq_zone", w);
        obj = "ShareToQQZone";
        continue; /* Loop/switch isn't completed */
_L6:
        a("share_weibo", (new StringBuilder()).append(x).append(w).toString());
        obj = "ShareToWeibo";
        continue; /* Loop/switch isn't completed */
_L3:
        a(h(), false);
        obj = "ShareToWeChat";
        continue; /* Loop/switch isn't completed */
_L5:
        k();
        obj = "ShareToMiChat";
        if (true) goto _L1; else goto _L9
_L9:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030010);
        t = WXAPIFactory.createWXAPI(this, "wx28e2610e92fbe111");
        t.registerApp("wx28e2610e92fbe111");
        t.handleIntent(getIntent(), this);
        u = new MLShareApiFactory(this);
        K = (ShareData)getIntent().getParcelableExtra("share_data");
        if (K == null)
        {
            K = new ShareData();
            K.type = getIntent().getIntExtra("type", 7);
            K.title = getIntent().getStringExtra("title");
            K.content = getIntent().getStringExtra("content");
            K.contentUnit = getIntent().getStringExtra("unit");
            K.time = getIntent().getStringExtra("time");
            K.description = getIntent().getStringExtra("description");
            K.time_tips = getIntent().getStringExtra("time_tips");
        }
        g();
        d();
        e();
        c();
        a(K);
        w = getIntent().getStringExtra("shareToContent");
        if (w == null)
        {
            w = "";
        }
        v = getText(0x7f0d017b).toString();
        if (K.type != 2 && K.type != 3 && K.type != 4) goto _L2; else goto _L1
_L1:
        w = getText(0x7f0d0175).toString();
_L4:
        x = getText(0x7f0d017c).toString();
        if (K.type == 11)
        {
            x = getText(0x7f0d01f6).toString();
        }
        b();
        return;
_L2:
        if (K.type != 11)
        {
            w = getText(0x7f0d0176).toString();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onDestroy()
    {
        super.onDestroy();
        if (M != null)
        {
            if (!M.isRecycled())
            {
                M.recycle();
            }
            M = null;
        }
        if (S != null)
        {
            S.recycle();
            S = null;
        }
        if (R != null)
        {
            File file = new File(R);
            if (file.exists())
            {
                file.delete();
            }
        }
        i();
    }

    protected void onPause()
    {
        super.onPause();
        UmengAnalytics.endPage("PageShare");
        UmengAnalytics.endSession(this);
    }

    public void onReq(BaseReq basereq)
    {
    }

    public void onResp(BaseResp baseresp)
    {
    }

    protected void onResume()
    {
        super.onResume();
        UmengAnalytics.startPage("PageShare");
        UmengAnalytics.startSession(this);
    }

    public boolean shareToMiliao(int i1)
    {
        Bitmap bitmap = j();
        String s1 = getPackageName();
        String s2 = getApplicationInfo().loadLabel(getPackageManager()).toString();
        u.setPackageNameAndAppName(s1, s2);
        MLShareMessage mlsharemessage = new MLShareMessage();
        mlsharemessage.imgObj = new MLImgObj(bitmap);
        mlsharemessage.imgObj.mImgSize = 0x200000L;
        MLShareReq mlsharereq = new MLShareReq(0x18705, mlsharemessage, i1);
        return u.sendReq(mlsharereq, false);
    }
}
