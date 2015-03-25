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
import com.tencent.utils.AsynLoadImg;
import com.tencent.utils.SystemUtils;
import com.tencent.utils.TemporaryStorage;
import com.tencent.utils.Util;
import java.io.File;

// Referenced classes of package com.tencent.connect.share:
//            c, b, a

public class QQShare extends BaseApi
{

    public static final String SHARE_TO_QQ_APP_NAME = "appName";
    public static final String SHARE_TO_QQ_AUDIO_URL = "audio_url";
    public static final String SHARE_TO_QQ_EXT_INT = "cflag";
    public static final String SHARE_TO_QQ_EXT_STR = "share_qq_ext_str";
    public static final int SHARE_TO_QQ_FLAG_QZONE_AUTO_OPEN = 1;
    public static final int SHARE_TO_QQ_FLAG_QZONE_ITEM_HIDE = 2;
    public static final String SHARE_TO_QQ_IMAGE_LOCAL_URL = "imageLocalUrl";
    public static final String SHARE_TO_QQ_IMAGE_URL = "imageUrl";
    public static final String SHARE_TO_QQ_KEY_TYPE = "req_type";
    public static final String SHARE_TO_QQ_SITE = "site";
    public static final String SHARE_TO_QQ_SUMMARY = "summary";
    public static final String SHARE_TO_QQ_TARGET_URL = "targetUrl";
    public static final String SHARE_TO_QQ_TITLE = "title";
    public static final int SHARE_TO_QQ_TYPE_AUDIO = 2;
    public static final int SHARE_TO_QQ_TYPE_DEFAULT = 1;
    public static final int SHARE_TO_QQ_TYPE_IMAGE = 5;

    public QQShare(Context context, QQToken qqtoken)
    {
        super(context, qqtoken);
    }

    private StringBuffer a(StringBuffer stringbuffer, Bundle bundle)
    {
        com.tencent.a.a.c.a("openSDK_LOG", "fillShareToQQParams() --start");
        bundle.putString("action", "shareToQQ");
        bundle.putString("appId", mToken.getAppId());
        bundle.putString("sdkp", "a");
        bundle.putString("sdkv", "2.1");
        bundle.putString("status_os", android.os.Build.VERSION.RELEASE);
        bundle.putString("status_machine", Build.MODEL);
        if (bundle.containsKey("content") && bundle.getString("content").length() > 40)
        {
            bundle.putString("content", (new StringBuilder()).append(bundle.getString("content").substring(0, 40)).append("...").toString());
        }
        if (bundle.containsKey("summary") && bundle.getString("summary").length() > 80)
        {
            bundle.putString("summary", (new StringBuilder()).append(bundle.getString("summary").substring(0, 80)).append("...").toString());
        }
        String s = Util.encodeUrl(bundle);
        stringbuffer.append((new StringBuilder()).append("&").append(s.replaceAll("\\+", "%20")).toString());
        com.tencent.a.a.c.a("openSDK_LOG", "fillShareToQQParams() --end");
        return stringbuffer;
    }

    private void a(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        com.tencent.a.a.c.a("openSDK_LOG", "shareToMobileQQ() --start");
        String s = bundle.getString("imageUrl");
        String s1 = bundle.getString("title");
        String s2 = bundle.getString("summary");
        if (!TextUtils.isEmpty(s))
        {
            if (Util.isValidUrl(s))
            {
                if (TextUtils.isEmpty(s1) && TextUtils.isEmpty(s2) && !Util.hasSDCard())
                {
                    if (iuilistener != null)
                    {
                        iuilistener.onError(new UiError(-6, "\u5206\u4EAB\u56FE\u7247\u5931\u8D25\uFF0C\u68C0\u6D4B\u4E0D\u5230SD\u5361!", null));
                        Log.v("shareToQQ", "\u5206\u4EAB\u56FE\u7247\u5931\u8D25\uFF0C\u68C0\u6D4B\u4E0D\u5230SD\u5361!");
                    }
                    return;
                }
                if (SystemUtils.compareQQVersion(activity, "4.3.0") >= 0)
                {
                    b(activity, bundle, iuilistener);
                } else
                {
                    (new AsynLoadImg(activity)).save(s, new com.tencent.connect.share.c(this, bundle, s1, s2, iuilistener, activity));
                }
            } else
            {
                bundle.putString("imageUrl", null);
                if (SystemUtils.compareQQVersion(activity, "4.3.0") < 0)
                {
                    b(activity, bundle, iuilistener);
                } else
                {
                    com.tencent.connect.share.a.a(activity, s, new b(this, bundle, s1, s2, iuilistener, activity));
                }
            }
        } else
        {
            b(activity, bundle, iuilistener);
        }
        com.tencent.a.a.c.a("openSDK_LOG", "shareToMobileQQ() --start");
    }

    static void a(QQShare qqshare, Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        qqshare.b(activity, bundle, iuilistener);
    }

    private void b(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        com.tencent.a.a.c.a("openSDK_LOG", "doShareToQQ() --start");
        StringBuffer stringbuffer = new StringBuffer("mqqapi://share/to_fri?src_type=app&version=1&file_type=news");
        String s = bundle.getString("imageUrl");
        String s1 = bundle.getString("title");
        String s2 = bundle.getString("summary");
        String s3 = bundle.getString("targetUrl");
        String s4 = bundle.getString("audio_url");
        int i = bundle.getInt("req_type", 1);
        int j = bundle.getInt("cflag", 0);
        String s5 = bundle.getString("share_qq_ext_str");
        String s6 = Util.getApplicationLable(activity);
        if (s6 == null)
        {
            s6 = bundle.getString("appName");
        }
        String s7 = bundle.getString("imageLocalUrl");
        String s8 = mToken.getAppId();
        String s9 = mToken.getOpenId();
        Log.v("shareToQQ", (new StringBuilder()).append("openId:").append(s9).toString());
        if (!TextUtils.isEmpty(s))
        {
            stringbuffer.append((new StringBuilder()).append("&image_url=").append(Base64.encodeToString(s.getBytes(), 2)).toString());
        }
        if (!TextUtils.isEmpty(s7))
        {
            stringbuffer.append((new StringBuilder()).append("&file_data=").append(Base64.encodeToString(s7.getBytes(), 2)).toString());
        }
        if (!TextUtils.isEmpty(s1))
        {
            stringbuffer.append((new StringBuilder()).append("&title=").append(Base64.encodeToString(s1.getBytes(), 2)).toString());
        }
        if (!TextUtils.isEmpty(s2))
        {
            stringbuffer.append((new StringBuilder()).append("&description=").append(Base64.encodeToString(s2.getBytes(), 2)).toString());
        }
        if (!TextUtils.isEmpty(s8))
        {
            stringbuffer.append((new StringBuilder()).append("&share_id=").append(s8).toString());
        }
        if (!TextUtils.isEmpty(s3))
        {
            stringbuffer.append((new StringBuilder()).append("&url=").append(Base64.encodeToString(s3.getBytes(), 2)).toString());
        }
        if (!TextUtils.isEmpty(s6))
        {
            if (s6.length() > 20)
            {
                s6 = (new StringBuilder()).append(s6.substring(0, 20)).append("...").toString();
            }
            stringbuffer.append((new StringBuilder()).append("&app_name=").append(Base64.encodeToString(s6.getBytes(), 2)).toString());
        }
        if (!TextUtils.isEmpty(s9))
        {
            stringbuffer.append((new StringBuilder()).append("&open_id=").append(Base64.encodeToString(s9.getBytes(), 2)).toString());
        }
        if (!TextUtils.isEmpty(s4))
        {
            stringbuffer.append((new StringBuilder()).append("&audioUrl=").append(Base64.encodeToString(s4.getBytes(), 2)).toString());
        }
        stringbuffer.append((new StringBuilder()).append("&req_type=").append(Base64.encodeToString(String.valueOf(i).getBytes(), 2)).toString());
        if (!TextUtils.isEmpty(s5))
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
        Object obj = TemporaryStorage.set("shareToQQ", iuilistener);
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

    private void c(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        Object obj = TemporaryStorage.set("shareToQQ", iuilistener);
        if (obj != null)
        {
            ((IUiListener)obj).onCancel();
        }
        com.tencent.a.a.c.a("openSDK_LOG", "shareToH5QQ() --start");
        StringBuffer stringbuffer = new StringBuffer("http://openmobile.qq.com/api/check?page=shareindex.html&style=9");
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        StringBuffer stringbuffer1 = a(stringbuffer, bundle);
        com.tencent.connect.a.a.a(mContext, mToken, "requireApi", new String[] {
            "shareToH5QQ"
        });
        if (!Util.openBrowser(activity, stringbuffer1.toString()) && iuilistener != null)
        {
            iuilistener.onError(new UiError(-6, "\u6253\u5F00\u6D4F\u89C8\u5668\u5931\u8D25!", null));
        }
        com.tencent.a.a.c.a("openSDK_LOG", "shareToH5QQ() --end");
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
    }

    public void shareToQQ(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        String s = bundle.getString("imageUrl");
        String s1 = bundle.getString("title");
        String s2 = bundle.getString("summary");
        String s3 = bundle.getString("targetUrl");
        String s4 = bundle.getString("imageLocalUrl");
        int i = bundle.getInt("req_type", 1);
        if (!Util.hasSDCard())
        {
            iuilistener.onError(new UiError(-6, "\u5206\u4EAB\u56FE\u7247\u5931\u8D25\uFF0C\u68C0\u6D4B\u4E0D\u5230SD\u5361!", null));
            com.tencent.a.a.c.a("openSDK_LOG", "shareToQQ() sdcard is null--end");
            return;
        }
        if (i == 5)
        {
            if (SystemUtils.compareQQVersion(activity, "4.3.0") < 0)
            {
                iuilistener.onError(new UiError(-6, "\u4F4E\u7248\u672C\u624BQ\u4E0D\u652F\u6301\u8BE5\u9879\u529F\u80FD!", null));
                com.tencent.a.a.c.a("openSDK_LOG", "shareToQQ() both null--end");
                return;
            }
            if (!Util.fileExists(s4))
            {
                iuilistener.onError(new UiError(-6, "\u975E\u6CD5\u7684\u56FE\u7247\u5730\u5740!", null));
                com.tencent.a.a.c.a("openSDK_LOG", "shareToQQ()--end\u975E\u6CD5\u7684\u56FE\u7247\u5730\u5740!");
                return;
            }
        }
        if (i != 5)
        {
            if (TextUtils.isEmpty(s3) || !s3.startsWith("http://") && !s3.startsWith("https://"))
            {
                iuilistener.onError(new UiError(-6, "\u4F20\u5165\u53C2\u6570\u6709\u8BEF!", null));
                com.tencent.a.a.c.a("openSDK_LOG", "shareToQQ() targetUrl error--end");
                return;
            }
            if (TextUtils.isEmpty(s1))
            {
                iuilistener.onError(new UiError(-6, "title\u4E0D\u80FD\u4E3A\u7A7A!", null));
                com.tencent.a.a.c.a("openSDK_LOG", "shareToQQ() title null--end");
                return;
            }
        }
        if (!TextUtils.isEmpty(s) && !s.startsWith("http://") && !s.startsWith("https://") && !(new File(s)).exists())
        {
            iuilistener.onError(new UiError(-6, "\u975E\u6CD5\u7684\u56FE\u7247\u5730\u5740!", null));
            com.tencent.a.a.c.a("openSDK_LOG", "shareToQQ() image url error--end");
            return;
        }
        if (!TextUtils.isEmpty(s1) && s1.length() > 45)
        {
            bundle.putString("title", Util.subString(s1, 45, null, null));
        }
        if (!TextUtils.isEmpty(s2) && s2.length() > 60)
        {
            bundle.putString("summary", Util.subString(s2, 60, null, null));
        }
        if (Util.isMobileQQSupportShare(activity))
        {
            a(activity, bundle, iuilistener);
        } else
        {
            c(activity, bundle, iuilistener);
        }
        com.tencent.a.a.c.a("openSDK_LOG", "shareToQQ() --end");
    }
}
