// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal;


class z
    implements CharSequence
{

    char a[];

    z()
    {
    }

    public char charAt(int i)
    {
        return a[i];
    }

    public int length()
    {
        return a.length;
    }

    public CharSequence subSequence(int i, int j)
    {
        return new String(a, i, j - i);
    }
}
