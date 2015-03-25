// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.download;

import java.util.Locale;

public final class b extends Enum
{

    public static final c ASSETS;
    public static final c CONTENT;
    public static final c DRAWABLE;
    public static final c FILE;
    public static final c HTTP;
    public static final c HTTPS;
    public static final c UNKNOWN;
    private static final c c[];
    private String a;
    private String b;

    private boolean a(String s)
    {
        return s.toLowerCase(Locale.US).startsWith(b);
    }

    public static b ofUri(String s)
    {
        if (s != null)
        {
            b ab[] = values();
            int i = ab.length;
            for (int j = 0; j < i; j++)
            {
                b b1 = ab[j];
                if (b1.a(s))
                {
                    return b1;
                }
            }

        }
        return UNKNOWN;
    }

    public static UNKNOWN valueOf(String s)
    {
        return (UNKNOWN)Enum.valueOf(com/nostra13/universalimageloader/core/download/ImageDownloader$Scheme, s);
    }

    public static UNKNOWN[] values()
    {
        return (UNKNOWN[])c.clone();
    }

    public String crop(String s)
    {
        if (!a(s))
        {
            Object aobj[] = new Object[2];
            aobj[0] = s;
            aobj[1] = a;
            throw new IllegalArgumentException(String.format("URI [%1$s] doesn't have expected scheme [%2$s]", aobj));
        } else
        {
            return s.substring(b.length());
        }
    }

    public String wrap(String s)
    {
        return (new StringBuilder()).append(b).append(s).toString();
    }

    static 
    {
        HTTP = new <init>("HTTP", 0, "http");
        HTTPS = new <init>("HTTPS", 1, "https");
        FILE = new <init>("FILE", 2, "file");
        CONTENT = new <init>("CONTENT", 3, "content");
        ASSETS = new <init>("ASSETS", 4, "assets");
        DRAWABLE = new <init>("DRAWABLE", 5, "drawable");
        UNKNOWN = new <init>("UNKNOWN", 6, "");
        b ab[] = new <init>[7];
        ab[0] = HTTP;
        ab[1] = HTTPS;
        ab[2] = FILE;
        ab[3] = CONTENT;
        ab[4] = ASSETS;
        ab[5] = DRAWABLE;
        ab[6] = UNKNOWN;
        c = ab;
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        a = s1;
        b = (new StringBuilder()).append(s1).append("://").toString();
    }
}
