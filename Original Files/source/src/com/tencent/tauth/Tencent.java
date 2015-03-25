// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.tauth;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.a.a.c;
import com.tencent.connect.auth.QQAuth;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.avatar.QQAvatar;
import com.tencent.connect.share.QQShare;
import com.tencent.connect.share.QzoneShare;
import com.tencent.open.SocialApi;
import com.tencent.open.TaskGuide;
import com.tencent.utils.HttpUtils;
import com.tencent.utils.SystemUtils;
import org.json.JSONObject;

// Referenced classes of package com.tencent.tauth:
//            LocationApi, IUiListener, IRequestListener

public class Tencent
{

    private QQAuth a;
    private Context b;
    private LocationApi c;

    private Tencent(String s, Context context)
    {
        b = context;
        a = QQAuth.createInstance(s, context);
    }

    private static boolean a(Context context, String s)
    {
        try
        {
            ComponentName componentname = new ComponentName(context.getPackageName(), "com.tencent.tauth.AuthActivity");
            context.getPackageManager().getActivityInfo(componentname, 0);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            String s1 = (new StringBuilder()).append("\u6CA1\u6709\u5728AndroidManifest.xml\u4E2D\u68C0\u6D4B\u5230com.tencent.tauth.AuthActivity,\u8BF7\u52A0\u4E0Acom.tencent.open.AuthActivity,\u5E76\u914D\u7F6E<data android:scheme=\"tencent").append(s).append("\" />,\u8BE6\u7EC6\u4FE1\u606F\u8BF7\u67E5\u770B\u5B98\u7F51\u6587\u6863.").toString();
            String s2 = (new StringBuilder()).append(s1).append("\n\u914D\u7F6E\u793A\u4F8B\u5982\u4E0B: \n<activity\n     android:name=\"com.tencent.connect.util.AuthActivity\"\n     android:noHistory=\"true\"\n     android:launchMode=\"singleTask\">\n<intent-filter>\n    <action android:name=\"android.intent.action.VIEW\" />\n     <category android:name=\"android.intent.category.DEFAULT\" />\n    <category android:name=\"android.intent.category.BROWSABLE\" />\n    <data android:scheme=\"tencent").append(s).append("\" />\n").append("</intent-filter>\n").append("</activity>").toString();
            com.tencent.a.a.c.a();
            com.tencent.a.a.c.d("AndroidManifest.xml \u6CA1\u6709\u68C0\u6D4B\u5230com.tencent.tauth.AuthActivity", s2);
            return false;
        }
        try
        {
            ComponentName componentname1 = new ComponentName(context.getPackageName(), "com.tencent.connect.common.AssistActivity");
            context.getPackageManager().getActivityInfo(componentname1, 0);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception1)
        {
            String s3 = (new StringBuilder()).append("\u6CA1\u6709\u5728AndroidManifest.xml\u4E2D\u68C0\u6D4B\u5230com.tencent.connect.common.AssistActivity,\u8BF7\u52A0\u4E0Acom.tencent.connect.common.AssistActivity,\u8BE6\u7EC6\u4FE1\u606F\u8BF7\u67E5\u770B\u5B98\u7F51\u6587\u6863.").append("\n\u914D\u7F6E\u793A\u4F8B\u5982\u4E0B: \n<activity\n     android:name=\"com.tencent.connect.common.AssistActivity\"\n     android:screenOrientation=\"portrait\"\n     android:theme=\"@android:style/Theme.Translucent.NoTitleBar\"\n     android:configChanges=\"orientation|keyboardHidden\">\n</activity>").toString();
            com.tencent.a.a.c.a();
            com.tencent.a.a.c.d("AndroidManifest.xml \u6CA1\u6709\u68C0\u6D4B\u5230com.tencent.connect.common.AssistActivity", s3);
            return false;
        }
        return true;
    }

    public static Tencent createInstance(String s, Context context)
    {
        Tencent tencent = new Tencent(s, context);
        if (!a(context, s))
        {
            return null;
        } else
        {
            com.tencent.a.a.c.a("openSDK_LOG", "createInstance()  --end");
            return tencent;
        }
    }

    public int ask(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        (new SocialApi(activity, a.getQQToken())).ask(activity, bundle, iuilistener);
        return 0;
    }

    public int brag(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        (new SocialApi(activity, a.getQQToken())).brag(activity, bundle, iuilistener);
        return 0;
    }

    public int challenge(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        (new SocialApi(activity, a.getQQToken())).challenge(activity, bundle, iuilistener);
        return 0;
    }

    public int deleteLocation(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        if (c == null)
        {
            c = new LocationApi(activity, a.getQQToken());
        }
        c.deleteLocation(activity, bundle, iuilistener);
        return 0;
    }

    public String getAccessToken()
    {
        return a.getQQToken().getAccessToken();
    }

    public String getAppId()
    {
        return a.getQQToken().getAppId();
    }

    public long getExpiresIn()
    {
        return a.getQQToken().getExpireTimeInSecond();
    }

    public String getOpenId()
    {
        return a.getQQToken().getOpenId();
    }

    public QQToken getQQToken()
    {
        return a.getQQToken();
    }

    public int gift(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        (new SocialApi(activity, a.getQQToken())).gift(activity, bundle, iuilistener);
        return 0;
    }

    public void grade(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        (new SocialApi(activity, a.getQQToken())).grade(activity, bundle, iuilistener);
    }

    public int invite(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        (new SocialApi(activity, a.getQQToken())).invite(activity, bundle, iuilistener);
        return 0;
    }

    public boolean isReady()
    {
        return isSessionValid() && getOpenId() != null;
    }

    public boolean isSessionValid()
    {
        return a.isSessionValid();
    }

    public boolean isSupportSSOLogin(Activity activity)
    {
        if (SystemUtils.getAppVersionName(activity, "com.tencent.mobileqq") == null)
        {
            Toast.makeText(activity, "\u6CA1\u6709\u5B89\u88C5\u624BQ", 0).show();
            return false;
        }
        if (SystemUtils.checkMobileQQ(activity))
        {
            Toast.makeText(activity, "\u5DF2\u5B89\u88C5\u7684\u624BQ\u7248\u672C\u652F\u6301SSO\u767B\u9646", 0).show();
            return true;
        } else
        {
            Toast.makeText(activity, "\u5DF2\u5B89\u88C5\u7684\u624BQ\u7248\u672C\u4E0D\u652F\u6301SSO\u767B\u9646", 0).show();
            return false;
        }
    }

    public int login(Activity activity, String s, IUiListener iuilistener)
    {
        return a.login(activity, s, iuilistener);
    }

    public int loginWithOEM(Activity activity, String s, IUiListener iuilistener, String s1, String s2, String s3)
    {
        return a.loginWithOEM(activity, s, iuilistener, s1, s2, s3);
    }

    public void logout(Context context)
    {
        a.getQQToken().setAccessToken(null, "0");
        a.getQQToken().setOpenId(null);
    }

    public boolean onActivityResult(int i, int j, Intent intent)
    {
        return false;
    }

    public int reAuth(Activity activity, String s, IUiListener iuilistener)
    {
        return a.reAuth(activity, s, iuilistener);
    }

    public int reactive(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        (new SocialApi(activity, a.getQQToken())).reactive(activity, bundle, iuilistener);
        return 0;
    }

    public JSONObject request(String s, Bundle bundle, String s1)
    {
        return HttpUtils.request(a.getQQToken(), b, s, bundle, s1);
    }

    public void requestAsync(String s, Bundle bundle, String s1, IRequestListener irequestlistener, Object obj)
    {
        HttpUtils.requestAsync(a.getQQToken(), b, s, bundle, s1, irequestlistener);
    }

    public int searchNearby(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        if (c == null)
        {
            c = new LocationApi(activity, a.getQQToken());
        }
        c.searchNearby(activity, bundle, iuilistener);
        return 0;
    }

    public void setAccessToken(String s, String s1)
    {
        com.tencent.a.a.c.a("openSDK_LOG", (new StringBuilder()).append("setAccessToken(), expiresIn = ").append(s1).append("").toString());
        a.setAccessToken(s, s1);
    }

    public void setAvatar(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        String s = bundle.getString("picture");
        int i = bundle.getInt("exitAnim");
        (new QQAvatar(b, a.getQQToken())).setAvatar(activity, Uri.parse(s), iuilistener, i);
    }

    public void setAvatar(Activity activity, Bundle bundle, IUiListener iuilistener, int i, int j)
    {
        bundle.putInt("exitAnim", j);
        activity.overridePendingTransition(i, 0);
        setAvatar(activity, bundle, iuilistener);
    }

    public void setOpenId(String s)
    {
        com.tencent.a.a.c.a("openSDK_LOG", "setOpenId() --start");
        a.setOpenId(b, s);
        com.tencent.a.a.c.a("openSDK_LOG", "setOpenId() --end");
    }

    public void shareToQQ(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        (new QQShare(activity, a.getQQToken())).shareToQQ(activity, bundle, iuilistener);
    }

    public void shareToQzone(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        (new QzoneShare(activity, a.getQQToken())).shareToQzone(activity, bundle, iuilistener);
    }

    public void showTaskGuideWindow(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        (new TaskGuide(activity, a.getQQToken())).showTaskGuideWindow(activity, bundle, iuilistener);
    }

    public int story(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        (new SocialApi(activity, a.getQQToken())).story(activity, bundle, iuilistener);
        return 0;
    }

    public void voice(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        (new SocialApi(activity, a.getQQToken())).voice(activity, bundle, iuilistener);
    }
}
