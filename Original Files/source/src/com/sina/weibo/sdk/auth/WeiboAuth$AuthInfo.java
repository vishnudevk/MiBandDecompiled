// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.auth;

import android.content.Context;
import android.os.Bundle;
import com.sina.weibo.sdk.utils.Utility;

public class initAuthBundle
{

    private String mAppKey;
    private Bundle mBundle;
    private String mKeyHash;
    private String mPackageName;
    private String mRedirectUrl;
    private String mScope;

    private void initAuthBundle()
    {
        mBundle = new Bundle();
        mBundle.putString("appKey", mAppKey);
        mBundle.putString("redirectUri", mRedirectUrl);
        mBundle.putString("scope", mScope);
        mBundle.putString("packagename", mPackageName);
        mBundle.putString("key_hash", mKeyHash);
    }

    public String getAppKey()
    {
        return mAppKey;
    }

    public Bundle getAuthBundle()
    {
        return mBundle;
    }

    public String getRedirectUrl()
    {
        return mRedirectUrl;
    }

    public String getScope()
    {
        return mScope;
    }






    public (Context context, String s, String s1, String s2)
    {
        mAppKey = "";
        mRedirectUrl = "";
        mScope = "";
        mPackageName = "";
        mKeyHash = "";
        mBundle = null;
        mAppKey = s;
        mRedirectUrl = s1;
        mScope = s2;
        mPackageName = context.getPackageName();
        mKeyHash = Utility.getSign(context, mPackageName);
        initAuthBundle();
    }
}
