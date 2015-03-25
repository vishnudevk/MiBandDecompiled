// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.market.sdk;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

// Referenced classes of package com.xiaomi.market.sdk:
//            c

public class h
{

    final c a;
    private TreeMap b;

    public h(c c1)
    {
        this(c1, true);
    }

    public h(c c1, boolean flag)
    {
        a = c1;
        super();
        b = new TreeMap();
        if (flag)
        {
            c1.x = this;
        }
    }

    public h a(String s, boolean flag)
    {
        if (flag)
        {
            b.put(s, "true");
            return this;
        } else
        {
            b.put(s, "false");
            return this;
        }
    }

    public h d(String s, String s1)
    {
        if (s1 == null)
        {
            s1 = "";
        }
        b.put(s, s1);
        return this;
    }

    public String get(String s)
    {
        return (String)b.get(s);
    }

    public boolean isEmpty()
    {
        return b.isEmpty();
    }

    public TreeMap j()
    {
        return b;
    }

    public String toString()
    {
        if (b.isEmpty())
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = b.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return stringbuilder.deleteCharAt(-1 + stringbuilder.length()).toString();
            }
            String s = (String)iterator.next();
            stringbuilder.append(s);
            stringbuilder.append("=");
            try
            {
                stringbuilder.append(URLEncoder.encode((String)b.get(s), "UTF-8"));
            }
            catch (UnsupportedEncodingException unsupportedencodingexception) { }
            stringbuilder.append("&");
        } while (true);
    }
}
