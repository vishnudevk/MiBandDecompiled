// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.client.result;

import java.util.Map;

// Referenced classes of package com.google.zxing.client.result:
//            ParsedResult, ParsedResultType

public final class ExpandedProductParsedResult extends ParsedResult
{

    public static final String KILOGRAM = "KG";
    public static final String POUND = "LB";
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final String k;
    private final String l;
    private final String m;
    private final Map n;

    public ExpandedProductParsedResult(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9, String s10, String s11, String s12, Map map)
    {
        super(ParsedResultType.PRODUCT);
        a = s;
        b = s1;
        c = s2;
        d = s3;
        e = s4;
        f = s5;
        g = s6;
        h = s7;
        i = s8;
        j = s9;
        k = s10;
        l = s11;
        m = s12;
        n = map;
    }

    private static int a(Object obj)
    {
        if (obj == null)
        {
            return 0;
        } else
        {
            return obj.hashCode();
        }
    }

    private static boolean a(Object obj, Object obj1)
    {
        if (obj == null)
        {
            return obj1 == null;
        } else
        {
            return obj.equals(obj1);
        }
    }

    public boolean equals(Object obj)
    {
        ExpandedProductParsedResult expandedproductparsedresult;
        if (obj instanceof ExpandedProductParsedResult)
        {
            if (a(a, (expandedproductparsedresult = (ExpandedProductParsedResult)obj).a) && a(b, expandedproductparsedresult.b) && a(c, expandedproductparsedresult.c) && a(d, expandedproductparsedresult.d) && a(f, expandedproductparsedresult.f) && a(g, expandedproductparsedresult.g) && a(h, expandedproductparsedresult.h) && a(i, expandedproductparsedresult.i) && a(j, expandedproductparsedresult.j) && a(k, expandedproductparsedresult.k) && a(l, expandedproductparsedresult.l) && a(m, expandedproductparsedresult.m) && a(n, expandedproductparsedresult.n))
            {
                return true;
            }
        }
        return false;
    }

    public String getBestBeforeDate()
    {
        return f;
    }

    public String getDisplayResult()
    {
        return String.valueOf(a);
    }

    public String getExpirationDate()
    {
        return g;
    }

    public String getLotNumber()
    {
        return c;
    }

    public String getPackagingDate()
    {
        return e;
    }

    public String getPrice()
    {
        return k;
    }

    public String getPriceCurrency()
    {
        return m;
    }

    public String getPriceIncrement()
    {
        return l;
    }

    public String getProductID()
    {
        return a;
    }

    public String getProductionDate()
    {
        return d;
    }

    public String getSscc()
    {
        return b;
    }

    public Map getUncommonAIs()
    {
        return n;
    }

    public String getWeight()
    {
        return h;
    }

    public String getWeightIncrement()
    {
        return j;
    }

    public String getWeightType()
    {
        return i;
    }

    public int hashCode()
    {
        return 0 ^ a(a) ^ a(b) ^ a(c) ^ a(d) ^ a(f) ^ a(g) ^ a(h) ^ a(i) ^ a(j) ^ a(k) ^ a(l) ^ a(m) ^ a(n);
    }
}
