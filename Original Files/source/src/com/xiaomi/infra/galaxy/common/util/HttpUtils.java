// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.util;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import com.xiaomi.infra.galaxy.common.HttpMethodName;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class HttpUtils
{

    private static final String DEFAULT_ENCODING = "UTF-8";
    private static final Pattern ENCODED_CHARACTERS_PATTERN;

    public HttpUtils()
    {
    }

    public static String encodeParameters(BasicGalaxyRequest basicgalaxyrequest)
    {
        ArrayList arraylist1;
        if (basicgalaxyrequest.getParameters().size() > 0)
        {
            ArrayList arraylist = new ArrayList(basicgalaxyrequest.getParameters().size());
            java.util.Map.Entry entry;
            for (Iterator iterator = basicgalaxyrequest.getParameters().entrySet().iterator(); iterator.hasNext(); arraylist.add(new BasicNameValuePair((String)entry.getKey(), (String)entry.getValue())))
            {
                entry = (java.util.Map.Entry)iterator.next();
            }

            arraylist1 = arraylist;
        } else
        {
            arraylist1 = null;
        }
        if (arraylist1 != null)
        {
            return URLEncodedUtils.format(arraylist1, "UTF-8");
        } else
        {
            return null;
        }
    }

    public static boolean isUsingNonDefaultPort(URI uri)
    {
        String s = uri.getScheme().toLowerCase();
        for (int i = uri.getPort(); i <= 0 || s.equals("http") && i == 80 || s.equals("https") && i == 443;)
        {
            return false;
        }

        return true;
    }

    public static String urlEncode(String s, boolean flag)
    {
        if (s == null)
        {
            return "";
        }
        Matcher matcher;
        StringBuffer stringbuffer;
        String s1 = URLEncoder.encode(s, "UTF-8");
        matcher = ENCODED_CHARACTERS_PATTERN.matcher(s1);
        stringbuffer = new StringBuffer(s1.length());
_L3:
        String s3;
        if (!matcher.find())
        {
            break MISSING_BLOCK_LABEL_144;
        }
        s3 = matcher.group(0);
        if (!"+".equals(s3)) goto _L2; else goto _L1
_L1:
        s3 = "%20";
_L4:
        try
        {
            matcher.appendReplacement(stringbuffer, s3);
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new RuntimeException(unsupportedencodingexception);
        }
          goto _L3
_L2:
        if (!"*".equals(s3))
        {
            break MISSING_BLOCK_LABEL_106;
        }
        s3 = "%2A";
          goto _L4
        if (!"%7E".equals(s3)) goto _L6; else goto _L5
_L5:
        s3 = "~";
          goto _L4
_L6:
        if (!flag) goto _L4; else goto _L7
_L7:
        if (!"%2F".equals(s3)) goto _L4; else goto _L8
_L8:
        s3 = "/";
          goto _L4
        String s2;
        matcher.appendTail(stringbuffer);
        s2 = stringbuffer.toString();
        return s2;
    }

    public static boolean usePayloadForQueryParameters(BasicGalaxyRequest basicgalaxyrequest)
    {
        boolean flag = HttpMethodName.POST.equals(basicgalaxyrequest.getHttpMethod());
        boolean flag1;
        if (basicgalaxyrequest.getContent() == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        return flag && flag1;
    }

    static 
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(Pattern.quote("+")).append("|").append(Pattern.quote("*")).append("|").append(Pattern.quote("%7E")).append("|").append(Pattern.quote("%2F"));
        ENCODED_CHARACTERS_PATTERN = Pattern.compile(stringbuilder.toString());
    }
}
