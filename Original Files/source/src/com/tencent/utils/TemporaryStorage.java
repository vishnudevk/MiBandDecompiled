// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.utils;

import java.util.HashMap;

public class TemporaryStorage
{

    private static HashMap a = new HashMap();

    public TemporaryStorage()
    {
    }

    public static Object get(String s)
    {
        return a.remove(s);
    }

    public static Object set(String s, Object obj)
    {
        return a.put(s, obj);
    }

}
