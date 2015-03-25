// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.auth.sso;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.text.TextUtils;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuth;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.exception.WeiboDialogException;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.SecurityHelper;
import java.util.Iterator;
import java.util.List;

public class SsoHandler
{

    private static final String DEFAULT_SINA_WEIBO_PACKAGE_NAME = "com.sina.weibo";
    private static final String DEFAULT_WEIBO_REMOTE_SSO_SERVICE_NAME = "com.sina.weibo.remotessoservice";
    private static final int REQUEST_CODE_SSO_AUTH = 32973;
    private static final String TAG = "Weibo_SSO_login";
    private Activity mAuthActivity;
    private WeiboAuthListener mAuthListener;
    private ServiceConnection mConnection;
    private int mSSOAuthRequestCode;
    private WeiboAuth mWeibo;

    public SsoHandler(Activity activity, WeiboAuth weiboauth)
    {
        mConnection = new _cls1();
        mAuthActivity = activity;
        mWeibo = weiboauth;
    }

    private boolean bindRemoteSSOService(Context context, String s)
    {
        boolean flag = true;
        if (TextUtils.isEmpty(s) || s.trim().equals(""))
        {
            s = "com.sina.weibo";
        }
        Intent intent = new Intent("com.sina.weibo.remotessoservice");
        intent.setPackage(s);
        if (!context.bindService(intent, mConnection, flag))
        {
            flag = context.bindService(new Intent("com.sina.weibo.remotessoservice"), mConnection, flag);
        }
        return flag;
    }

    public static ComponentName isServiceExisted(Context context, String s)
    {
        Iterator iterator = ((ActivityManager)context.getSystemService("activity")).getRunningServices(0x7fffffff).iterator();
        ComponentName componentname;
        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }
            componentname = ((android.app.ActivityManager.RunningServiceInfo)iterator.next()).service;
        } while (!componentname.getPackageName().equals(s) || !componentname.getClassName().equals((new StringBuilder(String.valueOf(s))).append(".business.RemoteSSOService").toString()));
        return componentname;
    }

    private boolean startSingleSignOn(String s, String s1)
    {
        boolean flag = true;
        Intent intent = new Intent();
        intent.setClassName(s, s1);
        intent.putExtras(mWeibo.getAuthInfo().getAuthBundle());
        intent.putExtra("_weibo_command_type", 3);
        intent.putExtra("_weibo_transaction", String.valueOf(System.currentTimeMillis()));
        if (!SecurityHelper.validateAppSignatureForIntent(mAuthActivity, intent))
        {
            return false;
        }
        try
        {
            mAuthActivity.startActivityForResult(intent, mSSOAuthRequestCode);
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            flag = false;
        }
        mAuthActivity.getApplicationContext().unbindService(mConnection);
        return flag;
    }

    public void authorize(int i, WeiboAuthListener weiboauthlistener, String s)
    {
        mSSOAuthRequestCode = i;
        mAuthListener = weiboauthlistener;
        if (!bindRemoteSSOService(mAuthActivity.getApplicationContext(), s) && mWeibo != null)
        {
            mWeibo.anthorize(mAuthListener);
        }
    }

    public void authorize(WeiboAuthListener weiboauthlistener)
    {
        authorize(32973, weiboauthlistener, null);
    }

    public void authorize(WeiboAuthListener weiboauthlistener, String s)
    {
        authorize(32973, weiboauthlistener, s);
    }

    public void authorizeCallBack(int i, int j, Intent intent)
    {
        if (i != mSSOAuthRequestCode) goto _L2; else goto _L1
_L1:
        if (j != -1) goto _L4; else goto _L3
_L3:
        if (SecurityHelper.checkResponseAppLegal(mAuthActivity, intent)) goto _L5; else goto _L2
_L2:
        return;
_L5:
        String s = intent.getStringExtra("error");
        if (s == null)
        {
            s = intent.getStringExtra("error_type");
        }
        if (s != null)
        {
            if (s.equals("access_denied") || s.equals("OAuthAccessDeniedException"))
            {
                LogUtil.d("Weibo_SSO_login", "Login canceled by user.");
                mAuthListener.onCancel();
                return;
            }
            String s1 = intent.getStringExtra("error_description");
            if (s1 != null)
            {
                s = (new StringBuilder(String.valueOf(s))).append(":").append(s1).toString();
            }
            LogUtil.d("Weibo_SSO_login", (new StringBuilder("Login failed: ")).append(s).toString());
            mAuthListener.onWeiboException(new WeiboDialogException(s, j, s1));
            return;
        }
        android.os.Bundle bundle = intent.getExtras();
        Oauth2AccessToken oauth2accesstoken = Oauth2AccessToken.parseAccessToken(bundle);
        if (oauth2accesstoken != null && oauth2accesstoken.isSessionValid())
        {
            LogUtil.d("Weibo_SSO_login", (new StringBuilder("Login Success! ")).append(oauth2accesstoken.toString()).toString());
            mAuthListener.onComplete(bundle);
            return;
        } else
        {
            LogUtil.d("Weibo_SSO_login", "Failed to receive access token by SSO");
            mWeibo.anthorize(mAuthListener);
            return;
        }
_L4:
        if (j == 0)
        {
            if (intent != null)
            {
                LogUtil.d("Weibo_SSO_login", (new StringBuilder("Login failed: ")).append(intent.getStringExtra("error")).toString());
                mAuthListener.onWeiboException(new WeiboDialogException(intent.getStringExtra("error"), intent.getIntExtra("error_code", -1), intent.getStringExtra("failing_url")));
                return;
            } else
            {
                LogUtil.d("Weibo_SSO_login", "Login canceled by user.");
                mAuthListener.onCancel();
                return;
            }
        }
        if (true) goto _L2; else goto _L6
_L6:
    }




    private class _cls1
        implements ServiceConnection
    {

        final SsoHandler this$0;

        public void onServiceConnected(ComponentName componentname, IBinder ibinder)
        {
            RemoteSSO remotesso = com.sina.sso.RemoteSSO.Stub.asInterface(ibinder);
            try
            {
                String s = remotesso.getPackageName();
                String s1 = remotesso.getActivityName();
                if (!startSingleSignOn(s, s1))
                {
                    mWeibo.anthorize(mAuthListener);
                }
                return;
            }
            catch (RemoteException remoteexception)
            {
                remoteexception.printStackTrace();
            }
        }

        public void onServiceDisconnected(ComponentName componentname)
        {
            mWeibo.anthorize(mAuthListener);
        }

        _cls1()
        {
            this$0 = SsoHandler.this;
            super();
        }
    }

}
