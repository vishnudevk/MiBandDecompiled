// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.account.openauth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.account.openauth.utils.Base64Coder;
import com.xiaomi.account.openauth.utils.Network;
import java.net.URL;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package com.xiaomi.account.openauth:
//            AuthorizeActivity, b

public class AuthorizeHelper
{

    protected static final String ACTION_AUTH_ACTIVITY = "com.xiaomi.account.openauth.action.AUTH";
    protected static final String AUTHORIZATION_CODE = "authorization_code";
    public static String AUTH_ACTIVITY_NAME = "com.xiaomi.account.openauth.AuthorizeActivity";
    protected static final String HEADER_FLAG = "&&&START&&&";
    public static final String OAUTH2_HOST = "https://account.xiaomi.com";
    protected static final String REFRESH_TOKEN = "refresh_token";
    protected static final String TOKEN_PATH = "https://account.xiaomi.com/oauth2/token";
    private static final String a = "HmacSHA1";
    private static final String b = "UTF-8";
    private static Random c = new Random();

    public AuthorizeHelper()
    {
    }

    private static Intent a(Context context)
    {
        Intent intent = new Intent();
        intent.setClass(context, com/xiaomi/account/openauth/AuthorizeActivity);
        return intent;
    }

    protected static HashMap buildMacRequestHead(String s, String s1, String s2)
    {
        Object aobj[] = new Object[3];
        aobj[0] = URLEncoder.encode(s, "UTF-8");
        aobj[1] = URLEncoder.encode(s1, "UTF-8");
        aobj[2] = URLEncoder.encode(s2, "UTF-8");
        String s3 = String.format("MAC access_token=\"%s\", nonce=\"%s\",mac=\"%s\"", aobj);
        HashMap hashmap = new HashMap();
        hashmap.put("Authorization", s3);
        return hashmap;
    }

    protected static String encodeSign(byte abyte0[])
    {
        return new String(Base64Coder.encode(abyte0));
    }

    protected static byte[] encryptHMACSha1(byte abyte0[], byte abyte1[])
    {
        SecretKeySpec secretkeyspec = new SecretKeySpec(abyte1, "HmacSHA1");
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(secretkeyspec);
        mac.update(abyte0);
        return mac.doFinal();
    }

    protected static String generateNonce()
    {
        long l = c.nextLong();
        int i = (int)(System.currentTimeMillis() / 60000L);
        return (new StringBuilder(String.valueOf(l))).append(":").append(i).toString();
    }

    protected static String generateUrl(String s, List list)
    {
        if (list == null || list.size() <= 0) goto _L2; else goto _L1
_L1:
        android.net.Uri.Builder builder;
        Iterator iterator;
        builder = Uri.parse(s).buildUpon();
        iterator = list.iterator();
_L6:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        s = builder.build().toString();
_L2:
        return s;
_L4:
        NameValuePair namevaluepair = (NameValuePair)iterator.next();
        builder.appendQueryParameter(namevaluepair.getName(), namevaluepair.getValue());
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected static String getAccessTokenByAuthorizationCode(Context context, String s, long l, String s1, String s2)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("client_id", String.valueOf(l)));
        arraylist.add(new BasicNameValuePair("grant_type", "authorization_code"));
        arraylist.add(new BasicNameValuePair("client_secret", s1));
        arraylist.add(new BasicNameValuePair("token_type", "mac"));
        arraylist.add(new BasicNameValuePair("redirect_uri", s2));
        arraylist.add(new BasicNameValuePair("code", s));
        String s3 = Network.downloadXml(context, new URL(generateUrl("https://account.xiaomi.com/oauth2/token", arraylist)));
        if (!TextUtils.isEmpty(s3))
        {
            s3 = s3.replace("&&&START&&&", "");
        }
        return s3;
    }

    protected static String getAccessTokenByRefreshToken(Context context, String s, long l, String s1, String s2, String s3, String s4, 
            String s5)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("client_id", String.valueOf(l)));
        arraylist.add(new BasicNameValuePair("grant_type", "refresh_token"));
        arraylist.add(new BasicNameValuePair("client_secret", s1));
        arraylist.add(new BasicNameValuePair("token_type", "mac"));
        arraylist.add(new BasicNameValuePair("redirect_uri", s2));
        arraylist.add(new BasicNameValuePair("refresh_token", s));
        arraylist.add(new BasicNameValuePair("token_type", s3));
        arraylist.add(new BasicNameValuePair("mac_key", s4));
        arraylist.add(new BasicNameValuePair("mac_algorithm", s5));
        String s6 = Network.downloadXml(context, new URL(generateUrl("https://account.xiaomi.com/oauth2/token", arraylist)));
        if (!TextUtils.isEmpty(s6))
        {
            s6 = s6.replace("&&&START&&&", "");
        }
        return s6;
    }

    protected static String getMacAccessTokenSignatureString(String s, String s1, String s2, String s3, String s4, String s5, String s6)
    {
        if ("HmacSHA1".equalsIgnoreCase(s6))
        {
            StringBuilder stringbuilder = new StringBuilder("");
            stringbuilder.append((new StringBuilder(String.valueOf(s))).append("\n").toString());
            stringbuilder.append((new StringBuilder(String.valueOf(s1.toUpperCase()))).append("\n").toString());
            stringbuilder.append((new StringBuilder(String.valueOf(s2))).append("\n").toString());
            stringbuilder.append((new StringBuilder(String.valueOf(s3))).append("\n").toString());
            if (!TextUtils.isEmpty(s4))
            {
                StringBuffer stringbuffer = new StringBuffer();
                ArrayList arraylist = new ArrayList();
                URLEncodedUtils.parse(arraylist, new Scanner(s4), "UTF-8");
                Collections.sort(arraylist, new b());
                stringbuffer.append(URLEncodedUtils.format(arraylist, "UTF-8"));
                stringbuilder.append((new StringBuilder(String.valueOf(stringbuffer.toString()))).append("\n").toString());
            }
            return encodeSign(encryptHMACSha1(stringbuilder.toString().getBytes("UTF-8"), s5.getBytes("UTF-8")));
        } else
        {
            throw new NoSuchAlgorithmException((new StringBuilder("error mac algorithm : ")).append(s6).toString());
        }
    }

    protected static void startAuthorizeActivityForResult(Activity activity, long l, String s, String s1, String s2, String s3, int i)
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException("client id is error!!!");
        }
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("redirect url is empty!!!");
        }
        if (TextUtils.isEmpty(s1))
        {
            throw new IllegalArgumentException("responseType is empty!!!");
        } else
        {
            Intent intent = a(activity);
            intent.setPackage(activity.getPackageName());
            Bundle bundle = new Bundle();
            bundle.putString("client_id", String.valueOf(l));
            bundle.putString("redirect_uri", s);
            bundle.putString("response_type", s1);
            bundle.putString("scope", s2);
            bundle.putString("state", s3);
            intent.putExtra("url_param", bundle);
            activity.startActivityForResult(intent, i);
            return;
        }
    }

}
