// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned.rss;


public class DataCharacter
{

    private final int a;
    private final int b;

    public DataCharacter(int i, int j)
    {
        a = i;
        b = j;
    }

    public int getChecksumPortion()
    {
        return b;
    }

    public int getValue()
    {
        return a;
    }
}
