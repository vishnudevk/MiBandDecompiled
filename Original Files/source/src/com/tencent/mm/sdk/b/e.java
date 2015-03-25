// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.b;

import java.util.TimeZone;

public final class e
{

    private static final long a[] = {
        300L, 200L, 300L, 200L
    };
    private static final long b[] = {
        300L, 50L, 300L, 50L
    };
    private static final TimeZone c = TimeZone.getTimeZone("GMT");
    private static final char d[] = {
        '<', '>', '"', '\'', '&'
    };
    private static final String e[] = {
        "&lt;", "&gt;", "&quot;", "&apos;", "&amp;"
    };

    public static boolean c(String s)
    {
        return s == null || s.length() <= 0;
    }

}
