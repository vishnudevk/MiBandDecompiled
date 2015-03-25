// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.avatar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.tencent.utils.Util;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.connect.avatar:
//            ImageActivity

public class QQAvatar extends BaseApi
{

    private IUiListener a;

    public QQAvatar(Context context, QQToken qqtoken)
    {
        super(context, qqtoken);
    }

    private Intent a()
    {
        Intent intent = new Intent();
        intent.setClass(mContext, com/tencent/connect/avatar/ImageActivity);
        return intent;
    }

    private void a(Activity activity, Bundle bundle)
    {
        a(bundle);
        mActivityIntent.putExtra("key_action", "action_avatar");
        mActivityIntent.putExtra("key_params", bundle);
        startAssitActivity(activity, a);
    }

    private void a(Bundle bundle)
    {
        if (mToken != null)
        {
            bundle.putString("appid", mToken.getAppId());
            if (mToken.isSessionValid())
            {
                bundle.putString("keystr", mToken.getAccessToken());
                bundle.putString("keytype", "0x80");
            }
            String s = mToken.getOpenId();
            if (s != null)
            {
                bundle.putString("hopenid", s);
            }
            bundle.putString("platform", "androidqz");
            try
            {
                bundle.putString("pf", mContext.getSharedPreferences("pfStore", 0).getString("pf", "openmobile_android"));
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                bundle.putString("pf", "openmobile_android");
            }
        }
        bundle.putString("sdkv", "2.1");
        bundle.putString("sdkp", "a");
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        if (j == -1)
        {
            int k = intent.getIntExtra("key_error_code", 0);
            if (k == 0)
            {
                String s2 = intent.getStringExtra("key_response");
                if (s2 != null)
                {
                    try
                    {
                        JSONObject jsonobject = Util.parseJson(s2);
                        a.onComplete(jsonobject);
                        return;
                    }
                    catch (JSONException jsonexception)
                    {
                        a.onError(new UiError(-4, "\u670D\u52A1\u5668\u8FD4\u56DE\u6570\u636E\u683C\u5F0F\u6709\u8BEF!", s2));
                    }
                    return;
                } else
                {
                    a.onComplete(new JSONObject());
                    return;
                }
            } else
            {
                String s = intent.getStringExtra("key_error_msg");
                String s1 = intent.getStringExtra("key_error_detail");
                a.onError(new UiError(k, s, s1));
                return;
            }
        } else
        {
            a.onCancel();
            return;
        }
    }

    public void setAvatar(Activity activity, Uri uri, IUiListener iuilistener, int i)
    {
        if (a != null)
        {
            a.onCancel();
        }
        a = iuilistener;
        Bundle bundle = new Bundle();
        bundle.putString("picture", uri.toString());
        bundle.putInt("exitAnim", i);
        bundle.putString("appid", mToken.getAppId());
        bundle.putString("access_token", mToken.getAccessToken());
        bundle.putLong("expires_in", mToken.getExpireTimeInSecond());
        bundle.putString("openid", mToken.getOpenId());
        mActivityIntent = a();
        if (hasActivityForIntent())
        {
            a(activity, bundle);
        }
    }
}
