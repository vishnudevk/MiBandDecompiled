// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.activity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.model.ShareData;
import cn.com.smartdevices.bracelet.ui.ShareActivity;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

// Referenced classes of package cn.com.smartdevices.bracelet.activity:
//            l, k

public class WebActivity extends SystemBarTintActivity
    implements android.view.View.OnClickListener
{

    private static final String TAG = "WebActivity";
    private View mActionBar;
    private WebChromeClient mChromeClient;
    private String mLabel;
    private View mShare;
    private TextView mWebErrorTip;
    private int mWebType;
    private View mWebViewContainer;
    private ProgressBar mWebViewProgress;
    private WebView myWebView;

    public WebActivity()
    {
        myWebView = null;
        mWebType = 1;
        mChromeClient = new l(this);
    }

    private void share()
    {
        Debug.i("WebActivity", "Start Share!!");
        if (getIntent() != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i;
        i = getIntent().getIntExtra("EventPageType", 0);
        if (i != 1)
        {
            break; /* Loop/switch isn't completed */
        }
        android.graphics.Bitmap bitmap1 = BitmapFactory.decodeStream(getAssets().open("event_national_day_signup_share.jpg"));
        android.graphics.Bitmap bitmap = bitmap1;
_L4:
        String s = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/").append("share.jpg").toString();
        if (bitmap != null && Utils.saveBitmapToFile(s, bitmap))
        {
            mWebViewContainer.destroyDrawingCache();
            Intent intent = getIntent();
            intent.setClass(this, cn/com/smartdevices/bracelet/ui/ShareActivity);
            intent.putExtra("pic_url", s);
            intent.putExtra("EventPageType", i);
            ShareData sharedata = new ShareData();
            sharedata.setType(11);
            intent.putExtra("share_data", sharedata);
            startActivity(intent);
            return;
        }
        if (true) goto _L1; else goto _L3
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
        bitmap = null;
          goto _L4
_L3:
        mWebViewContainer.buildDrawingCache();
        bitmap = mWebViewContainer.getDrawingCache();
          goto _L4
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131361844: 
            finish();
            return;

        case 2131361962: 
            share();
            break;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03002e);
        mShare = findViewById(0x7f0a00aa);
        mActionBar = findViewById(0x7f0a0078);
        myWebView = (WebView)findViewById(0x7f0a0023);
        mWebErrorTip = (TextView)findViewById(0x7f0a00e0);
        mWebViewContainer = findViewById(0x7f0a00dd);
        mShare.setOnClickListener(this);
        myWebView.getSettings().setJavaScriptEnabled(true);
        Intent intent = getIntent();
        mWebType = intent.getIntExtra("web_type", 1);
        if (mWebType == 0)
        {
            String s1 = "&_locale=zh_CN";
            Debug.i("WebActivity", (new StringBuilder()).append("locale = ").append(Locale.getDefault().toString()).append(", LocaleChinese=").append(Locale.SIMPLIFIED_CHINESE).append(", english=").append(Locale.ENGLISH).append(", tw=").append(Locale.TRADITIONAL_CHINESE).toString());
            TextView textview;
            if (Locale.getDefault().toString().startsWith(Locale.ENGLISH.toString()))
            {
                s1 = "&_locale=en";
            } else
            if (Locale.TRADITIONAL_CHINESE.equals(Locale.getDefault()))
            {
                s1 = "&_locale=zh_TW";
            }
            myWebView.loadUrl((new StringBuilder()).append("https://account.xiaomi.com/pass/wap/register?qs=callback%3Dhttps%253A%252F%252Faccount.xiaomi.com%252Fsts%253Fsign%253D8VUxGitrfXxS7XlgXfr7V0uceQc%25253D%2526followup%253Dhttps%25253A%25252F%25252Faccount.xiaomi.com%25252Foauth2%25252Fauthorize%25253Fskip_confirm%25253Dfalse%252526client_id%25253D2882303761517154077%252526redirect_uri%25253Dhttps%2525253A%2525252F%2525252Fhm.xiaomi.com%2525252Fhuami.health.loginview.do%252526response_type%25253Dcode%2526sid%253Doauth2.0%26sid%3Doauth2.0%26_customDisplay%3D0%26mini%3Dtrue%26lsrp_appName%3D%25E4%25BD%25BF%25E7%2594%25A8%25E4%25BD%25A0%25E7%259A%2584%25E5%25B0%258F%25E7%25B1%25B3%25E5%25B8%2590%25E5%258F%25B7%25E8%25AE%25BF%25E9%2597%25AE%2524%257B%25E5%25B0%258F%25E7%25B1%25B3%25E6%2589%258B%25E7%258E%25AF%257D%2524%26_ssign%3DrBm1F4Qu%252F%252FE074tgruygkG18tX0%253D").append(s1).toString());
            Debug.i("WebActivity", (new StringBuilder()).append("url = https://account.xiaomi.com/pass/wap/register?qs=callback%3Dhttps%253A%252F%252Faccount.xiaomi.com%252Fsts%253Fsign%253D8VUxGitrfXxS7XlgXfr7V0uceQc%25253D%2526followup%253Dhttps%25253A%25252F%25252Faccount.xiaomi.com%25252Foauth2%25252Fauthorize%25253Fskip_confirm%25253Dfalse%252526client_id%25253D2882303761517154077%252526redirect_uri%25253Dhttps%2525253A%2525252F%2525252Fhm.xiaomi.com%2525252Fhuami.health.loginview.do%252526response_type%25253Dcode%2526sid%253Doauth2.0%26sid%3Doauth2.0%26_customDisplay%3D0%26mini%3Dtrue%26lsrp_appName%3D%25E4%25BD%25BF%25E7%2594%25A8%25E4%25BD%25A0%25E7%259A%2584%25E5%25B0%258F%25E7%25B1%25B3%25E5%25B8%2590%25E5%258F%25B7%25E8%25AE%25BF%25E9%2597%25AE%2524%257B%25E5%25B0%258F%25E7%25B1%25B3%25E6%2589%258B%25E7%258E%25AF%257D%2524%26_ssign%3DrBm1F4Qu%252F%252FE074tgruygkG18tX0%253D").append(s1).toString());
            myWebView.addJavascriptInterface(new LoginJsObject(), "login");
        } else
        if (mWebType == 1)
        {
            myWebView.loadUrl("https://hm.xiaomi.com/huami.health.login.json");
            myWebView.addJavascriptInterface(new LoginJsObject(), "login");
        } else
        if (mWebType == 2)
        {
            String s = intent.getStringExtra("web_url");
            if (s.startsWith("file://"))
            {
                WebSettings websettings = myWebView.getSettings();
                websettings.setUseWideViewPort(true);
                websettings.setLoadWithOverviewMode(true);
            }
            int i = intent.getIntExtra("ActionBarColor", getResources().getColor(0x7f090003));
            Debug.i("WebActivity", (new StringBuilder()).append("actionBarColor = ").append(i).toString());
            int j = i | 0xff000000;
            mActionBar.setBackgroundColor(j);
            findViewById(0x7f0a00de).setBackgroundColor(j);
            if (intent.getIntExtra("ShowShare", 0) > 0)
            {
                mShare.setVisibility(0);
            }
            if (intent.getIntExtra("EventPageType", 0) == 1)
            {
                UmengAnalytics.event(this, "Game_ViewSignup");
            }
            myWebView.addJavascriptInterface(new GameJsObject(), "game");
            Debug.i("WebActivity", (new StringBuilder()).append(" url = ").append(s).toString());
            myWebView.loadUrl(s);
        }
        textview = (TextView)findViewById(0x7f0a0034);
        textview.setOnClickListener(this);
        mLabel = intent.getStringExtra("Label");
        if (!TextUtils.isEmpty(mLabel))
        {
            textview.setText(mLabel);
        }
        mWebViewProgress = (ProgressBar)findViewById(0x7f0a00df);
        myWebView.setWebViewClient(new k(this));
        myWebView.setWebChromeClient(mChromeClient);
    }

    protected void onDestroy()
    {
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4 && myWebView.canGoBack())
        {
            myWebView.goBack();
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            finish();
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    protected void onPause()
    {
        String s;
        super.onPause();
        s = "PageWeb";
        mWebType;
        JVM INSTR tableswitch 0 2: default 40
    //                   0 49
    //                   1 40
    //                   2 56;
           goto _L1 _L2 _L1 _L3
_L1:
        UmengAnalytics.endPage(s);
        UmengAnalytics.endSession(this);
        return;
_L2:
        s = "PageWebRegister";
        continue; /* Loop/switch isn't completed */
_L3:
        if (getString(0x7f0d01dd).equals(mLabel))
        {
            s = "PageWebUserAgreement";
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    protected void onResume()
    {
        String s;
        super.onResume();
        s = "PageWeb";
        mWebType;
        JVM INSTR tableswitch 0 2: default 40
    //                   0 49
    //                   1 40
    //                   2 56;
           goto _L1 _L2 _L1 _L3
_L1:
        UmengAnalytics.startPage(s);
        UmengAnalytics.startSession(this);
        return;
_L2:
        s = "PageWebRegister";
        continue; /* Loop/switch isn't completed */
_L3:
        if (getString(0x7f0d01dd).equals(mLabel))
        {
            s = "PageWebUserAgreement";
        }
        if (true) goto _L1; else goto _L4
_L4:
    }



    private class LoginJsObject
    {

        final WebActivity a;

        public void callback(String s, String s1)
        {
            Debug.i("WPJ", (new StringBuilder()).append("uid:").append(s).append(",security:").append(s1).toString());
        }

        public void setUserInfo(String s, String s1, String s2, String s3, String s4, String s5)
        {
            boolean flag = true;
            Debug.i("WebActivity", (new StringBuilder()).append("uid:").append(s).append(",security:").append(s1).append(",iconUrl:").append(s2).append(",nick name:").append(s3).append(",has bind:").append(s4).toString());
            Keeper.keepLoginData(Long.parseLong(s), s1);
            Intent intent;
            if (Integer.parseInt(s4) != flag)
            {
                flag = false;
            }
            if (flag)
            {
                Debug.i("WebActivity", (new StringBuilder()).append("userInfo=").append(s5).toString());
                PersonInfo personinfo = Keeper.readPersonInfo();
                WebRes.parseBindedUserInfo(s5, personinfo);
                personinfo.uid = Long.parseLong(s);
                Keeper.keepPersonInfo(personinfo);
            }
            intent = new Intent();
            intent.putExtra("miliao_icon_url", s2);
            intent.putExtra("miliao_nick_name", s3);
            intent.putExtra("miliao_has_binded", flag);
            a.setResult(3, intent);
            a.finish();
        }

        public LoginJsObject()
        {
            a = WebActivity.this;
            super();
        }
    }


    private class GameJsObject
    {

        final WebActivity a;

        public void webCallback(String s, String s1, String s2, String s3)
        {
            Debug.i("WebActivity", (new StringBuilder()).append("uid:").append(s).append(",security:").append(s1).append(", type = ").append(s2).append(", data=").append(s3).toString());
            if ("dislike".equals(s2))
            {
                UmengAnalytics.event(a, "Game_Dislike");
                a.finish();
            }
        }

        public GameJsObject()
        {
            a = WebActivity.this;
            super();
        }
    }

}
