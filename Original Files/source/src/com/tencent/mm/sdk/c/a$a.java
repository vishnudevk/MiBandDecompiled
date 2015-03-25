// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.c;

import com.tencent.mm.sdk.b.a;

public final class 
{

    public static Object a(int i, String s)
    {
        i;
        JVM INSTR tableswitch 1 6: default 40
    //                   1 50
    //                   2 55
    //                   3 84
    //                   4 60
    //                   5 65
    //                   6 70;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L2:
        return Integer.valueOf(s);
_L3:
        return Long.valueOf(s);
_L5:
        return Boolean.valueOf(s);
_L6:
        return Float.valueOf(s);
_L7:
        double1 = Double.valueOf(s);
        return double1;
_L1:
        Double double1;
        try
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.PluginProvider.Resolver", "unknown type");
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        s = null;
_L4:
        return s;
    }
}
