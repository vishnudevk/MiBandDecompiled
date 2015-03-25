// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.tencent.a.a.c;
import com.tencent.connect.a.a;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.tencent.utils.SystemUtils;
import com.tencent.utils.TemporaryStorage;
import com.tencent.utils.Util;
import java.net.URLEncoder;
import java.util.ArrayList;

// Referenced classes of package com.tencent.connect.share:
//            d, a, QQShare

public class QzoneShare extends BaseApi
{

    public static final String SHARE_TO_QQ_APP_NAME = "appName";
    public static final String SHARE_TO_QQ_AUDIO_URL = "audio_url";
    public static final String SHARE_TO_QQ_EXT_INT = "cflag";
    public static final String SHARE_TO_QQ_EXT_STR = "share_qq_ext_str";
    public static final String SHARE_TO_QQ_IMAGE_LOCAL_URL = "imageLocalUrl";
    public static final String SHARE_TO_QQ_IMAGE_URL = "imageUrl";
    public static final String SHARE_TO_QQ_SITE = "site";
    public static final String SHARE_TO_QQ_SUMMARY = "summary";
    public static final String SHARE_TO_QQ_TARGET_URL = "targetUrl";
    public static final String SHARE_TO_QQ_TITLE = "title";
    public static final String SHARE_TO_QZONE_KEY_TYPE = "req_type";
    public static final int SHARE_TO_QZONE_TYPE_IMAGE = 5;
    public static final int SHARE_TO_QZONE_TYPE_IMAGE_TEXT = 1;
    public static final int SHARE_TO_QZONE_TYPE_NO_TYPE;
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;

    public QzoneShare(Context context, QQToken qqtoken)
    {
        super(context, qqtoken);
        a = true;
        b = false;
        c = false;
        d = false;
    }

    private StringBuffer a(StringBuffer stringbuffer, Bundle bundle)
    {
        com.tencent.a.a.c.a("openSDK_LOG", "fillShareToQQParams() --start");
        ArrayList arraylist = bundle.getStringArrayList("imageUrl");
        String s = bundle.getString("appName");
        int i = bundle.getInt("req_type", 1);
        String s1 = bundle.getString("title");
        String s2 = bundle.getString("summary");
        bundle.putString("appId", mToken.getAppId());
        bundle.putString("sdkp", "a");
        bundle.putString("sdkv", "2.1");
        bundle.putString("status_os", android.os.Build.VERSION.RELEASE);
        bundle.putString("status_machine", Build.MODEL);
        if (!Util.isEmpty(s1) && s1.length() > 40)
        {
            bundle.putString("title", (new StringBuilder()).append(s1.substring(0, 40)).append("...").toString());
        }
        if (!Util.isEmpty(s2) && s2.length() > 80)
        {
            bundle.putString("summary", (new StringBuilder()).append(s2.substring(0, 80)).append("...").toString());
        }
        if (!TextUtils.isEmpty(s))
        {
            bundle.putString("site", s);
        }
        if (arraylist != null)
        {
            int j = arraylist.size();
            String as[] = new String[j];
            for (int k = 0; k < j; k++)
            {
                as[k] = (String)arraylist.get(k);
            }

            bundle.putStringArray("imageUrl", as);
        }
        bundle.putString("type", String.valueOf(i));
        String s3 = Util.encodeUrl(bundle);
        stringbuffer.append((new StringBuilder()).append("&").append(s3.replaceAll("\\+", "%20")).toString());
        com.tencent.a.a.c.a("openSDK_LOG", "fillShareToQQParams() --end");
        return stringbuffer;
    }

    private void a(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        com.tencent.a.a.c.a("openSDK_LOG", "doShareToQQ() --start");
        StringBuffer stringbuffer = new StringBuffer("mqqapi://share/to_qzone?src_type=app&version=1&file_type=news");
        ArrayList arraylist = bundle.getStringArrayList("imageUrl");
        String s = bundle.getString("title");
        String s1 = bundle.getString("summary");
        String s2 = bundle.getString("targetUrl");
        String s3 = bundle.getString("audio_url");
        int i = bundle.getInt("req_type", 1);
        String s4 = bundle.getString("appName");
        int j = bundle.getInt("cflag", 0);
        String s5 = bundle.getString("share_qq_ext_str");
        String s6 = mToken.getAppId();
        String s7 = mToken.getOpenId();
        Log.v("shareToQQ", (new StringBuilder()).append("openId:").append(s7).toString());
        if (arraylist != null)
        {
            StringBuffer stringbuffer1 = new StringBuffer();
            int k;
            int l;
            if (arraylist.size() > 9)
            {
                k = 9;
            } else
            {
                k = arraylist.size();
            }
            for (l = 0; l < k; l++)
            {
                stringbuffer1.append(URLEncoder.encode((String)arraylist.get(l)));
                if (l != k - 1)
                {
                    stringbuffer1.append(";");
                }
            }

            stringbuffer.append((new StringBuilder()).append("&image_url=").append(Base64.encodeToString(stringbuffer1.toString().getBytes(), 2)).toString());
        }
        if (!TextUtils.isEmpty(s))
        {
            stringbuffer.append((new StringBuilder()).append("&title=").append(Base64.encodeToString(s.getBytes(), 2)).toString());
        }
        if (!TextUtils.isEmpty(s1))
        {
            stringbuffer.append((new StringBuilder()).append("&description=").append(Base64.encodeToString(s1.getBytes(), 2)).toString());
        }
        if (!TextUtils.isEmpty(s6))
        {
            stringbuffer.append((new StringBuilder()).append("&share_id=").append(s6).toString());
        }
        if (!TextUtils.isEmpty(s2))
        {
            stringbuffer.append((new StringBuilder()).append("&url=").append(Base64.encodeToString(s2.getBytes(), 2)).toString());
        }
        if (!TextUtils.isEmpty(s4))
        {
            stringbuffer.append((new StringBuilder()).append("&app_name=").append(Base64.encodeToString(s4.getBytes(), 2)).toString());
        }
        if (!Util.isEmpty(s7))
        {
            stringbuffer.append((new StringBuilder()).append("&open_id=").append(Base64.encodeToString(s7.getBytes(), 2)).toString());
        }
        if (!Util.isEmpty(s3))
        {
            stringbuffer.append((new StringBuilder()).append("&audioUrl=").append(Base64.encodeToString(s3.getBytes(), 2)).toString());
        }
        stringbuffer.append((new StringBuilder()).append("&req_type=").append(Base64.encodeToString(String.valueOf(i).getBytes(), 2)).toString());
        if (!Util.isEmpty(s5))
        {
            stringbuffer.append((new StringBuilder()).append("&share_qq_ext_str=").append(Base64.encodeToString(s5.getBytes(), 2)).toString());
        }
        stringbuffer.append((new StringBuilder()).append("&cflag=").append(Base64.encodeToString(String.valueOf(j).getBytes(), 2)).toString());
        Log.v("shareToQQ", stringbuffer.toString());
        com.tencent.connect.a.a.a(mContext, mToken, "requireApi", new String[] {
            "shareToNativeQQ"
        });
        mActivityIntent = new Intent("android.intent.action.VIEW");
        mActivityIntent.setData(Uri.parse(stringbuffer.toString()));
        if (SystemUtils.compareQQVersion(activity, "4.6.0") >= 0) goto _L2; else goto _L1
_L1:
        if (hasActivityForIntent())
        {
            startAssitActivity(activity, iuilistener);
        }
_L4:
        com.tencent.a.a.c.a("openSDK_LOG", "doShareToQQ() --end");
        return;
_L2:
        Object obj = TemporaryStorage.set("shareToQzone", iuilistener);
        if (obj != null)
        {
            ((IUiListener)obj).onCancel();
        }
        if (hasActivityForIntent())
        {
            activity.startActivityForResult(mActivityIntent, 0);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void a(Context context, Bundle bundle, IUiListener iuilistener)
    {
        Object obj = TemporaryStorage.set("shareToQzone", iuilistener);
        if (obj != null)
        {
            ((IUiListener)obj).onCancel();
        }
        com.tencent.a.a.c.a("openSDK_LOG", "shareToH5Qzone() --start");
        StringBuffer stringbuffer = new StringBuffer("http://openmobile.qq.com/api/check2?page=qzshare.html&loginpage=loginindex.html&logintype=qzone");
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        StringBuffer stringbuffer1 = a(stringbuffer, bundle);
        com.tencent.connect.a.a.a(mContext, mToken, "requireApi", new String[] {
            "shareToH5QQ"
        });
        if (!Util.openBrowser(context, stringbuffer1.toString()) && iuilistener != null)
        {
            iuilistener.onError(new UiError(-6, "\u6253\u5F00\u6D4F\u89C8\u5668\u5931\u8D25!", null));
        }
        com.tencent.a.a.c.a("openSDK_LOG", "shareToH5QQ() --end");
    }

    static void a(QzoneShare qzoneshare, Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        qzoneshare.a(activity, bundle, iuilistener);
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
    }

    public void shareToQzone(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        String s;
        String s1;
        String s2;
        ArrayList arraylist;
        String s3;
        if (bundle == null)
        {
            iuilistener.onError(new UiError(-6, "\u4F20\u5165\u53C2\u6570\u4E0D\u53EF\u4EE5\u4E3A\u7A7A", null));
            return;
        }
        s = bundle.getString("title");
        s1 = bundle.getString("summary");
        s2 = bundle.getString("targetUrl");
        arraylist = bundle.getStringArrayList("imageUrl");
        s3 = Util.getApplicationLable(activity);
        if (s3 != null) goto _L2; else goto _L1
_L1:
        s3 = bundle.getString("appName");
_L13:
        int i = bundle.getInt("req_type");
        i;
        JVM INSTR lookupswitch 2: default 112
    //                   1: 236
    //                   5: 259;
           goto _L3 _L4 _L5
_L3:
        if (Util.isEmpty(s) && Util.isEmpty(s1))
        {
            if (arraylist != null && arraylist.size() != 0)
            {
                a = false;
            } else
            {
                s = (new StringBuilder()).append("\u6765\u81EA").append(s3).append("\u7684\u5206\u4EAB").toString();
                a = true;
            }
        } else
        {
            a = true;
        }
        b = false;
        c = true;
        d = false;
_L7:
        if (!Util.hasSDCard())
        {
            iuilistener.onError(new UiError(-6, "\u5206\u4EAB\u56FE\u7247\u5931\u8D25\uFF0C\u68C0\u6D4B\u4E0D\u5230SD\u5361!", null));
            com.tencent.a.a.c.a("openSDK_LOG", "shareToQzone() sdcard is null--end");
            return;
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (s3.length() > 20)
        {
            s3 = (new StringBuilder()).append(s3.substring(0, 20)).append("...").toString();
        }
        continue; /* Loop/switch isn't completed */
_L4:
        a = true;
        b = false;
        c = true;
        d = false;
        if (true) goto _L7; else goto _L6
_L5:
        iuilistener.onError(new UiError(-5, "\u6682\u4E0D\u652F\u6301\u7EAF\u56FE\u7247\u5206\u4EAB\u5230\u7A7A\u95F4\uFF0C\u5EFA\u8BAE\u4F7F\u7528\u56FE\u6587\u5206\u4EAB", null));
        com.tencent.a.a.c.a("openSDK_LOG", "shareToQzone() error--end\u6682\u4E0D\u652F\u6301\u7EAF\u56FE\u7247\u5206\u4EAB\u5230\u7A7A\u95F4\uFF0C\u5EFA\u8BAE\u4F7F\u7528\u56FE\u6587\u5206\u4EAB");
        return;
_L6:
        if (a)
        {
            if (TextUtils.isEmpty(s2))
            {
                iuilistener.onError(new UiError(-5, "targetUrl\u4E3A\u5FC5\u586B\u9879\uFF0C\u8BF7\u8865\u5145\u540E\u5206\u4EAB", null));
                com.tencent.a.a.c.a("openSDK_LOG", "shareToQzone() targetUrl null error--end");
                return;
            }
            if (!Util.isValidUrl(s2))
            {
                iuilistener.onError(new UiError(-5, "targetUrl\u6709\u8BEF", null));
                com.tencent.a.a.c.a("openSDK_LOG", "shareToQzone() targetUrl error--end");
                return;
            }
        }
        if (!b) goto _L9; else goto _L8
_L8:
        bundle.putString("title", "");
        bundle.putString("summary", "");
_L11:
        if (!TextUtils.isEmpty(s3))
        {
            bundle.putString("appName", s3);
        }
        if (arraylist != null && (arraylist == null || arraylist.size() != 0))
        {
            break; /* Loop/switch isn't completed */
        }
        if (d)
        {
            iuilistener.onError(new UiError(-6, "\u7EAF\u56FE\u5206\u4EAB\uFF0CimageUrl \u4E0D\u80FD\u4E3A\u7A7A", null));
            com.tencent.a.a.c.a("openSDK_LOG", "shareToQzone() imageUrl is null--end");
            return;
        }
        break MISSING_BLOCK_LABEL_720;
_L9:
        if (c && Util.isEmpty(s))
        {
            iuilistener.onError(new UiError(-6, "title\u4E0D\u80FD\u4E3A\u7A7A!", null));
            com.tencent.a.a.c.a("openSDK_LOG", "shareToQzone() title is null--end");
            return;
        }
        if (!Util.isEmpty(s) && s.length() > 200)
        {
            bundle.putString("title", Util.subString(s, 200, null, null));
        }
        if (!Util.isEmpty(s1) && s1.length() > 600)
        {
            bundle.putString("summary", Util.subString(s1, 600, null, null));
        }
        if (true) goto _L11; else goto _L10
_L10:
        for (int j = 0; j < arraylist.size(); j++)
        {
            String s5 = (String)arraylist.get(j);
            if (!Util.isValidUrl(s5) && !Util.isValidPath(s5))
            {
                arraylist.remove(j);
            }
        }

        if (arraylist.size() == 0)
        {
            iuilistener.onError(new UiError(-6, "\u975E\u6CD5\u7684\u56FE\u7247\u5730\u5740!", null));
            com.tencent.a.a.c.a("openSDK_LOG", "shareToQzone() MSG_PARAM_IMAGE_URL_FORMAT_ERROR--end");
            return;
        }
        bundle.putStringArrayList("imageUrl", arraylist);
        if (SystemUtils.compareQQVersion(activity, "4.6.0") >= 0)
        {
            com.tencent.connect.share.a.a(activity, arraylist, new d(this, bundle, activity, iuilistener));
        } else
        if (SystemUtils.compareQQVersion(activity, "4.2.0") >= 0 && SystemUtils.compareQQVersion(activity, "4.6.0") < 0)
        {
            QQShare qqshare = new QQShare(activity, mToken);
            if (arraylist != null && arraylist.size() > 0)
            {
                String s4 = (String)arraylist.get(0);
                if (i == 5 && !Util.fileExists(s4))
                {
                    iuilistener.onError(new UiError(-6, "\u624BQ\u7248\u672C\u8FC7\u4F4E\uFF0C\u7EAF\u56FE\u5206\u4EAB\u4E0D\u652F\u6301\u7F51\u8DEF\u56FE\u7247", null));
                    com.tencent.a.a.c.a("openSDK_LOG", "shareToQzone()\u624BQ\u7248\u672C\u8FC7\u4F4E\uFF0C\u7EAF\u56FE\u5206\u4EAB\u4E0D\u652F\u6301\u7F51\u8DEF\u56FE\u7247");
                    return;
                }
                bundle.putString("imageLocalUrl", s4);
            }
            if (SystemUtils.compareQQVersion(activity, "4.5.0") >= 0)
            {
                bundle.putInt("cflag", 1);
            }
            qqshare.shareToQQ(activity, bundle, iuilistener);
        } else
        {
            a(activity, bundle, iuilistener);
        }
        com.tencent.a.a.c.a("openSDK_LOG", "shareToQzone() --end");
        return;
        if (true) goto _L13; else goto _L12
_L12:
    }
}
