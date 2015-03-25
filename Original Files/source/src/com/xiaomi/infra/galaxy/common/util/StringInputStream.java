// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.util;

import java.io.ByteArrayInputStream;

public class StringInputStream extends ByteArrayInputStream
{

    private final String string;

    public StringInputStream(String s)
    {
        super(s.getBytes("UTF-8"));
        string = s;
    }

    public String getString()
    {
        return string;
    }
}
