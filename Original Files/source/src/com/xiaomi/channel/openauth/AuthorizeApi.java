// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.channel.openauth;

import android.content.Context;
import com.xiaomi.channel.openauth.utils.Network;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package com.xiaomi.channel.openauth:
//            AuthorizeHelper, XMAuthericationException

public class AuthorizeApi
{

    private static final String a = "UTF-8";
    private static String b = "GET";
    private static String c = "POST";
    private static String d = "open.account.xiaomi.com";
    private static String e = "https://";

    public AuthorizeApi()
    {
    }

    public static String doHttpGet(Context context, String s, long l, String s1, String s2, String s3)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("clientId", String.valueOf(l)));
        arraylist.add(new BasicNameValuePair("token", s1));
        String s4 = AuthorizeHelper.generateNonce();
        String s6;
        try
        {
            String s5 = AuthorizeHelper.getMacAccessTokenSignatureString(s4, b, d, s, URLEncodedUtils.format(arraylist, "UTF-8"), s2, s3);
            s6 = Network.downloadXml(context, new URL(AuthorizeHelper.generateUrl((new StringBuilder(String.valueOf(e))).append(d).append(s).toString(), arraylist)), null, null, AuthorizeHelper.buildMacRequestHead(s1, s4, s5), null);
        }
        catch (InvalidKeyException invalidkeyexception)
        {
            throw new XMAuthericationException(invalidkeyexception);
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            throw new XMAuthericationException(nosuchalgorithmexception);
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new XMAuthericationException(unsupportedencodingexception);
        }
        catch (IOException ioexception)
        {
            throw new XMAuthericationException(ioexception);
        }
        return s6;
    }

    public static String doHttpPost(Context context, String s, long l, String s1, String s2, String s3)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("clientId", String.valueOf(l)));
        arraylist.add(new BasicNameValuePair("token", s1));
        String s4 = AuthorizeHelper.generateNonce();
        String s6;
        try
        {
            String s5 = AuthorizeHelper.getMacAccessTokenSignatureString(s4, c, d, s, URLEncodedUtils.format(arraylist, "UTF-8"), s2, s3);
            s6 = Network.doHttpPost(context, (new StringBuilder(String.valueOf(e))).append(d).append(s).toString(), arraylist, AuthorizeHelper.buildMacRequestHead(s1, s4, s5), null, null, null);
        }
        catch (InvalidKeyException invalidkeyexception)
        {
            throw new XMAuthericationException(invalidkeyexception);
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            throw new XMAuthericationException(nosuchalgorithmexception);
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new XMAuthericationException(unsupportedencodingexception);
        }
        catch (IOException ioexception)
        {
            throw new XMAuthericationException(ioexception);
        }
        return s6;
    }

}
