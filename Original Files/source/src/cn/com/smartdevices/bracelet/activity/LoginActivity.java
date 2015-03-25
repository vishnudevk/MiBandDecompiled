// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.activity;

import android.animation.ValueAnimator;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.model.BraceletBtInfo;
import cn.com.smartdevices.bracelet.model.LoginInfo;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.ui.MainUIActivity;
import cn.com.smartdevices.bracelet.ui.SearchSingleBraceletActivity;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;
import cn.com.smartdevices.bracelet.ui.person.PersonInfoSetGenderActivity;
import cn.com.smartdevices.bracelet.view.CustomToast;
import cn.com.smartdevices.bracelet.webapi.ClientConstant;
import com.xiaomi.account.openauth.AuthorizeActivity;
import com.xiaomi.account.openauth.XiaomiOAuthorize;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

// Referenced classes of package cn.com.smartdevices.bracelet.activity:
//            b, d, e, g, 
//            h, WebActivity, a

public class LoginActivity extends SystemBarTintActivity
    implements android.view.View.OnClickListener
{

    private static final String n = "LoginActivity";
    private static final int o = 21308;
    private static final boolean p = false;
    private static final int q = 256;
    private static String u = "/user/profile";
    private static String v = "/user/phone";
    private static int w = 10001;
    private ValueAnimator A;
    private View B;
    private TextView C;
    private Handler D;
    Long a;
    String b;
    String c;
    String d;
    String e;
    String f;
    String g;
    String h;
    String i;
    String j;
    String k;
    String l;
    String m;
    private Button r;
    private Button s;
    private LoginActivity t;
    private LoginInfo x;
    private String y;
    private View z;

    public LoginActivity()
    {
        r = null;
        s = null;
        a = ClientConstant.CLIENT_ID;
        b = "https://hm.xiaomi.com/huami.health.loginview.do";
        y = "";
    }

    static ValueAnimator a(LoginActivity loginactivity, ValueAnimator valueanimator)
    {
        loginactivity.A = valueanimator;
        return valueanimator;
    }

    static TextView a(LoginActivity loginactivity)
    {
        return loginactivity.C;
    }

    static String a()
    {
        return u;
    }

    static String a(LoginActivity loginactivity, String s1)
    {
        loginactivity.y = s1;
        return s1;
    }

    static void a(LoginActivity loginactivity, boolean flag)
    {
        loginactivity.a(flag);
    }

    private void a(boolean flag)
    {
        finish();
        i();
        Intent intent = new Intent();
        if (flag && Keeper.readPersonInfo().isValid())
        {
            BraceletBtInfo braceletbtinfo = Keeper.readBraceletBtInfo();
            if (braceletbtinfo != null && BluetoothAdapter.checkBluetoothAddress(braceletbtinfo.address))
            {
                intent.setClass(t, cn/com/smartdevices/bracelet/ui/MainUIActivity);
            } else
            {
                intent.setClass(t, cn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity);
            }
        } else
        {
            if (x != null)
            {
                PersonInfo personinfo = Keeper.readPersonInfo();
                if (x.miliaoIcon_320 != null && x.miliaoIcon_320.length() > 0)
                {
                    personinfo.avatarUrl = x.miliaoIcon_320;
                } else
                {
                    personinfo.avatarUrl = x.miliaoIcon;
                }
                Keeper.keepPersonInfo(personinfo);
            }
            intent.setClass(t, cn/com/smartdevices/bracelet/ui/person/PersonInfoSetGenderActivity);
        }
        startActivity(intent);
    }

    static Button b(LoginActivity loginactivity)
    {
        return loginactivity.r;
    }

    static String b()
    {
        return v;
    }

    static Button c(LoginActivity loginactivity)
    {
        return loginactivity.s;
    }

    private void c()
    {
        WebView webview = (WebView)findViewById(0x7f0a003b);
        WebSettings websettings = webview.getSettings();
        websettings.setUseWideViewPort(true);
        websettings.setLoadWithOverviewMode(true);
        webview.setLayerType(1, null);
        webview.setBackgroundColor(0);
        webview.setInitialScale((100 * getResources().getDisplayMetrics().densityDpi) / 480);
        webview.loadUrl("file:///android_asset/startup.gif");
        (new Handler()).postDelayed(new b(this), 4800L);
        C.setEnabled(false);
        r.setEnabled(false);
        s.setEnabled(false);
    }

    static ValueAnimator d(LoginActivity loginactivity)
    {
        return loginactivity.A;
    }

    private void d()
    {
        z = findViewById(0x7f0a003a);
        B = findViewById(0x7f0a003c);
        r = (Button)findViewById(0x7f0a003f);
        r.setOnClickListener(this);
        s = (Button)findViewById(0x7f0a0040);
        s.setOnClickListener(this);
        C = (TextView)findViewById(0x7f0a003e);
        String s1 = getString(0x7f0d01dd);
        C.setText(Html.fromHtml(getResources().getString(0x7f0d003b)));
        SpannableString spannablestring = new SpannableString(s1);
        spannablestring.setSpan(new d(this), 0, s1.length(), 33);
        C.setHighlightColor(0);
        C.append(spannablestring);
        C.setMovementMethod(LinkMovementMethod.getInstance());
    }

    static View e(LoginActivity loginactivity)
    {
        return loginactivity.z;
    }

    private void e()
    {
        Debug.i("LoginActivity", "getTokenByXiaomiSDK");
        D.sendEmptyMessageDelayed(256, 300L);
        clearCache();
        Bundle bundle = new Bundle();
        XiaomiOAuthorize.startGetAccessToken(this, a.longValue(), b, bundle, w);
        Debug.i("LoginActivity", "End of getTokenByXiaomiSDK");
    }

    static View f(LoginActivity loginactivity)
    {
        return loginactivity.B;
    }

    private void f()
    {
        (new e(this)).execute(new Void[0]);
    }

    private void g()
    {
        CustomToast.makeText(this, 0x7f0d00e2, 0).show();
        i();
    }

    static void g(LoginActivity loginactivity)
    {
        loginactivity.i();
    }

    static LoginInfo h(LoginActivity loginactivity)
    {
        return loginactivity.x;
    }

    private void h()
    {
        Utils.showProgressDialog(this, 0x7f0d00e4);
    }

    private void i()
    {
        Utils.hideProgressDialog(this);
    }

    static void i(LoginActivity loginactivity)
    {
        loginactivity.g();
    }

    private void j()
    {
        (new g(this)).execute(new Void[0]);
    }

    static void j(LoginActivity loginactivity)
    {
        loginactivity.l();
    }

    private void k()
    {
        Debug.i("LoginActivity", (new StringBuilder()).append("personSH = ").append(y).toString());
        if (y == null || y.equals(""))
        {
            y = Utils.getPhoneNum(this);
        }
        if (y != null && !y.equals(""))
        {
            y = Utils.encodeTel(y);
            Debug.i("LoginActivity", (new StringBuilder()).append("encode personSH = ").append(y).toString());
            PersonInfo personinfo = Keeper.readPersonInfo();
            HashMap hashmap = new HashMap();
            try
            {
                hashmap.put("person_sh", URLEncoder.encode(y, "utf-8"));
            }
            catch (UnsupportedEncodingException unsupportedencodingexception)
            {
                unsupportedencodingexception.printStackTrace();
                l();
                return;
            }
            Utils.updateProfile(personinfo, hashmap, new h(this));
            return;
        } else
        {
            l();
            return;
        }
    }

    private void l()
    {
        finish();
        Intent intent = new Intent();
        intent.setClass(t, cn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity);
        startActivity(intent);
        i();
    }

    public void clearCache()
    {
        c = "";
        d = "";
        e = "";
        f = "";
        g = "";
        h = "";
        i = "";
        j = "";
        k = "";
        l = "";
        m = "";
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        Debug.i("LoginActivity", (new StringBuilder()).append("onActivityResult requestCode =").append(i1).append(", data =").append(intent).append("resultcode=").append(j1).toString());
        if (intent == null)
        {
            if (1 == i1)
            {
                UmengAnalytics.event(this, "StartUpRegister", "Canceled");
            }
        } else
        {
            Bundle bundle = intent.getExtras();
            if (w == i1)
            {
                if (AuthorizeActivity.RESULT_SUCCESS == j1)
                {
                    h();
                    j = bundle.getString("access_token");
                    h = bundle.getString("expires_in");
                    i = bundle.getString("scope");
                    d = bundle.getString("state");
                    e = bundle.getString("token_type");
                    f = bundle.getString("mac_key");
                    g = bundle.getString("mac_algorithm");
                    if (x == null)
                    {
                        x = new LoginInfo();
                    }
                    x.accessToken = j;
                    x.macToken = f;
                    x.expiresIn = h;
                    Debug.i("LoginActivity", (new StringBuilder()).append("accessToken=").append(j).append(",expiresIn=").append(h).append(",scope=").append(i).append(",state=").append(d).append(",tokenType=").append(e).append(",macKey=").append(f).append(",macAlogorithm=").append(g).toString());
                    f();
                    UmengAnalytics.event(this, "StartUpLogin", "Successed");
                    return;
                }
                if (AuthorizeActivity.RESULT_FAIL == j1)
                {
                    l = bundle.getString("error");
                    m = bundle.getString("error_description");
                    i();
                    CustomToast.makeText(t, 0x7f0d00e2, 1).show();
                    UmengAnalytics.event(this, "StartUpLogin", "Failed");
                    return;
                } else
                {
                    Debug.i("LoginActivity", (new StringBuilder()).append("result cancel=").append(AuthorizeActivity.RESULT_CANCEL).toString());
                    i();
                    UmengAnalytics.event(this, "StartUpLogin", "Canceled");
                    return;
                }
            }
            if (1 == i1)
            {
                if (j1 == 3)
                {
                    a(bundle.getBoolean("miliao_has_binded"));
                    UmengAnalytics.event(this, "StartUpRegister", "Successed");
                    return;
                } else
                {
                    i();
                    CustomToast.makeText(t, 0x7f0d00e2, 1).show();
                    UmengAnalytics.event(this, "StartUpRegister", "Failed");
                    return;
                }
            }
        }
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131361855: 
            if (!Utils.isNetworkConnected(this))
            {
                CustomToast.makeText(this, 0x7f0d0105, 1).show();
                return;
            } else
            {
                e();
                UmengAnalytics.event(this, "StartUp", "StartLogin");
                return;
            }

        case 2131361856: 
            break;
        }
        if (!Utils.isNetworkConnected(this))
        {
            CustomToast.makeText(this, 0x7f0d0105, 1).show();
            return;
        } else
        {
            Intent intent = new Intent();
            intent.putExtra("web_type", 0);
            intent.setClass(this, cn/com/smartdevices/bracelet/activity/WebActivity);
            startActivityForResult(intent, 1);
            UmengAnalytics.event(this, "StartUp", "StartRegister");
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030008);
        disableAutoApplyStatusBarTint();
        applyStatusBarTintRes(0x7f020012);
        t = this;
        D = new a(this);
        d();
        c();
    }

    protected void onDestroy()
    {
        super.onDestroy();
        Debug.i("LoginActivity", "onDestroy");
    }

    protected void onPause()
    {
        super.onPause();
        Debug.i("LoginActivity", "onPause");
        D.removeMessages(256);
        UmengAnalytics.endPage("PageStartUp");
        UmengAnalytics.endSession(this);
    }

    protected void onResume()
    {
        super.onResume();
        UmengAnalytics.startPage("PageStartUp");
        UmengAnalytics.startSession(this);
    }

}
