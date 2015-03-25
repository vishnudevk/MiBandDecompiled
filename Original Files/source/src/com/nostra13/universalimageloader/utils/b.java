// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.utils;

import java.util.Comparator;

final class b
    implements Comparator
{

    b()
    {
    }

    public int a(String s, String s1)
    {
        return s.substring(0, s.lastIndexOf("_")).compareTo(s1.substring(0, s1.lastIndexOf("_")));
    }

    public int compare(Object obj, Object obj1)
    {
        return a((String)obj, (String)obj1);
    }
}
