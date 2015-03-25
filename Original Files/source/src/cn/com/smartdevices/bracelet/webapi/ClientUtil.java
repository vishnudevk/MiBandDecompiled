// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.webapi;

import android.os.SystemClock;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientUtil
{

    private static String a = "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

    public ClientUtil()
    {
    }

    public static String encodeStr(String s)
    {
        String s1;
        try
        {
            s1 = URLEncoder.encode(s, "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            unsupportedencodingexception.printStackTrace();
            return null;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        return s1;
    }

    public static String encryptPassword(String s)
    {
        int i = 10 + (new Random(SystemClock.currentThreadTimeMillis())).nextInt(90);
        return (new StringBuilder()).append(md5((new StringBuilder()).append(i).append(s).toString())).append(":").append(i).toString();
    }

    public static String generateBgsid(HashMap hashmap)
    {
        StringBuffer stringbuffer = new StringBuffer();
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = hashmap.entrySet().iterator(); iterator.hasNext(); arraylist.add(((java.util.Map.Entry)iterator.next()).getKey())) { }
        Collections.sort(arraylist, String.CASE_INSENSITIVE_ORDER);
        for (Iterator iterator1 = arraylist.iterator(); iterator1.hasNext(); stringbuffer.append((String)hashmap.get((String)iterator1.next()))) { }
        stringbuffer.append("c18c24046606b2e084edd37f9fe9f94d");
        return md5(stringbuffer.toString());
    }

    public static long generateCallId()
    {
        return (new Date()).getTime();
    }

    public static HashMap getParamMap(Map map)
    {
        HashMap hashmap = new HashMap();
        hashmap.put(encodeStr("appid"), encodeStr("1uMqYWpHo3MoLH"));
        hashmap.put(encodeStr("callid"), encodeStr((new StringBuilder()).append("").append(generateCallId()).toString()));
        hashmap.put(encodeStr("v"), encodeStr("1.0"));
        hashmap.put(encodeStr("lang"), encodeStr(Locale.getDefault().getLanguage()));
        if (map != null)
        {
            hashmap.putAll(map);
        }
        hashmap.put("bd_sig", generateBgsid(hashmap));
        return hashmap;
    }

    public static HashMap getSysParamMap(Map map)
    {
        HashMap hashmap = new HashMap();
        HashMap hashmap1 = new HashMap();
        hashmap.put(encodeStr("appid"), encodeStr("1uMqYWpHo3MoLH"));
        hashmap.put(encodeStr("callid"), encodeStr((new StringBuilder()).append("").append(generateCallId()).toString()));
        hashmap.put(encodeStr("v"), encodeStr("1.0"));
        hashmap.put(encodeStr("lang"), encodeStr(Locale.getDefault().getLanguage()));
        hashmap1.putAll(hashmap);
        if (map != null)
        {
            hashmap1.putAll(map);
        }
        hashmap.put("bd_sig", generateBgsid(hashmap1));
        return hashmap;
    }

    public static boolean isValidEmailAndPassword(String s, String s1)
    {
        while (s == null || s.length() < 1 || s1 == null || s1.length() < 6 || s1.length() > 25 || !Pattern.compile(a).matcher(s).matches()) 
        {
            return false;
        }
        return true;
    }

    public static String md5(String s)
    {
        byte abyte0[];
        StringBuilder stringbuilder;
        int i;
        try
        {
            abyte0 = MessageDigest.getInstance("MD5").digest(s.getBytes("UTF-8"));
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            throw new RuntimeException("Huh, MD5 should be supported?", nosuchalgorithmexception);
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new RuntimeException("Huh, UTF-8 should be supported?", unsupportedencodingexception);
        }
        stringbuilder = new StringBuilder(2 * abyte0.length);
        i = abyte0.length;
        for (int j = 0; j < i; j++)
        {
            byte byte0 = abyte0[j];
            if ((byte0 & 0xff) < 16)
            {
                stringbuilder.append("0");
            }
            stringbuilder.append(Integer.toHexString(byte0 & 0xff));
        }

        return stringbuilder.toString();
    }

}
