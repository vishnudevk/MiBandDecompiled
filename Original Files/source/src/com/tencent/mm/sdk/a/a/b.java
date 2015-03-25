// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.a.a;


public final class b
{

    public static byte[] a(String s, int i, String s1)
    {
        StringBuffer stringbuffer = new StringBuffer();
        if (s != null)
        {
            stringbuffer.append(s);
        }
        stringbuffer.append(i);
        stringbuffer.append(s1);
        stringbuffer.append("mMcShCsTr");
        return com.tencent.mm.a.b.a(stringbuffer.toString().substring(1, 9).getBytes()).getBytes();
    }
}
