// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.auth;

import android.os.Bundle;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class Oauth2AccessToken
{

    private static final String KEY_ACCESS_TOKEN = "access_token";
    private static final String KEY_EXPIRES_IN = "expires_in";
    private static final String KEY_REFRESH_TOKEN = "refresh_token";
    private static final String KEY_UID = "uid";
    private String mAccessToken;
    private long mExpiresTime;
    private String mRefreshToken;
    private String mUid;

    public Oauth2AccessToken()
    {
        mUid = "";
        mAccessToken = "";
        mRefreshToken = "";
        mExpiresTime = 0L;
    }

    public Oauth2AccessToken(String s)
    {
        mUid = "";
        mAccessToken = "";
        mRefreshToken = "";
        mExpiresTime = 0L;
        if (s == null || s.indexOf("{") < 0)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        JSONObject jsonobject = new JSONObject(s);
        setUid(jsonobject.optString("uid"));
        setToken(jsonobject.optString("access_token"));
        setExpiresIn(jsonobject.optString("expires_in"));
        setRefreshToken(jsonobject.optString("refresh_token"));
        return;
        JSONException jsonexception;
        jsonexception;
        jsonexception.printStackTrace();
        return;
    }

    public Oauth2AccessToken(String s, String s1)
    {
        mUid = "";
        mAccessToken = "";
        mRefreshToken = "";
        mExpiresTime = 0L;
        mAccessToken = s;
        mExpiresTime = System.currentTimeMillis();
        if (s1 != null)
        {
            mExpiresTime = mExpiresTime + 1000L * Long.parseLong(s1);
        }
    }

    private static String getString(Bundle bundle, String s, String s1)
    {
        if (bundle != null)
        {
            String s2 = bundle.getString(s);
            if (s2 != null)
            {
                s1 = s2;
            }
        }
        return s1;
    }

    public static Oauth2AccessToken parseAccessToken(Bundle bundle)
    {
        if (bundle != null)
        {
            Oauth2AccessToken oauth2accesstoken = new Oauth2AccessToken();
            oauth2accesstoken.setUid(getString(bundle, "uid", ""));
            oauth2accesstoken.setToken(getString(bundle, "access_token", ""));
            oauth2accesstoken.setExpiresIn(getString(bundle, "expires_in", ""));
            oauth2accesstoken.setRefreshToken(getString(bundle, "refresh_token", ""));
            return oauth2accesstoken;
        } else
        {
            return null;
        }
    }

    public static Oauth2AccessToken parseAccessToken(String s)
    {
        if (TextUtils.isEmpty(s) || s.indexOf("{") < 0)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        Oauth2AccessToken oauth2accesstoken;
        JSONObject jsonobject = new JSONObject(s);
        oauth2accesstoken = new Oauth2AccessToken();
        oauth2accesstoken.setUid(jsonobject.optString("uid"));
        oauth2accesstoken.setToken(jsonobject.optString("access_token"));
        oauth2accesstoken.setExpiresIn(jsonobject.optString("expires_in"));
        oauth2accesstoken.setRefreshToken(jsonobject.optString("refresh_token"));
        return oauth2accesstoken;
        JSONException jsonexception;
        jsonexception;
        jsonexception.printStackTrace();
        return null;
    }

    public long getExpiresTime()
    {
        return mExpiresTime;
    }

    public String getRefreshToken()
    {
        return mRefreshToken;
    }

    public String getToken()
    {
        return mAccessToken;
    }

    public String getUid()
    {
        return mUid;
    }

    public boolean isSessionValid()
    {
        return !TextUtils.isEmpty(mAccessToken) && mExpiresTime != 0L && System.currentTimeMillis() < mExpiresTime;
    }

    public void setExpiresIn(String s)
    {
        if (!TextUtils.isEmpty(s) && !s.equals("0"))
        {
            setExpiresTime(System.currentTimeMillis() + 1000L * Long.parseLong(s));
        }
    }

    public void setExpiresTime(long l)
    {
        mExpiresTime = l;
    }

    public void setRefreshToken(String s)
    {
        mRefreshToken = s;
    }

    public void setToken(String s)
    {
        mAccessToken = s;
    }

    public void setUid(String s)
    {
        mUid = s;
    }

    public Bundle toBundle()
    {
        Bundle bundle = new Bundle();
        bundle.putString("uid", mUid);
        bundle.putString("access_token", mAccessToken);
        bundle.putString("refresh_token", mRefreshToken);
        bundle.putString("expires_in", Long.toString(mExpiresTime));
        return bundle;
    }

    public String toString()
    {
        return (new StringBuilder("uid: ")).append(mUid).append(", ").append("access_token").append(": ").append(mAccessToken).append(", ").append("refresh_token").append(": ").append(mRefreshToken).append(", ").append("expires_in").append(": ").append(Long.toString(mExpiresTime)).toString();
    }
}
