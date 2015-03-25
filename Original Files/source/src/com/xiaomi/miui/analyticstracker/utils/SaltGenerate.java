// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.miui.analyticstracker.utils;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.http.NameValuePair;

// Referenced classes of package com.xiaomi.miui.analyticstracker.utils:
//            a, MD5

public class SaltGenerate
{

    private static final String a = "8007236f-";
    private static final String b = "a2d6-4847-ac83-";
    private static final String c = "c49395ad6d65";

    public SaltGenerate()
    {
    }

    private static byte[] a(String s)
    {
        byte abyte0[];
        try
        {
            abyte0 = s.getBytes("UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            return s.getBytes();
        }
        return abyte0;
    }

    public static String getKeyFromParams(List list)
    {
        Collections.sort(list, new a());
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = list.iterator();
        for (boolean flag = true; iterator.hasNext(); flag = false)
        {
            NameValuePair namevaluepair = (NameValuePair)iterator.next();
            if (!flag)
            {
                stringbuilder.append("&");
            }
            stringbuilder.append(namevaluepair.getName()).append("=").append(namevaluepair.getValue());
        }

        stringbuilder.append("&").append("8007236f-");
        stringbuilder.append("a2d6-4847-ac83-");
        stringbuilder.append("c49395ad6d65");
        return MD5.getMd5Digest(Base64.encodeToString(a(stringbuilder.toString()), 2));
    }
}
