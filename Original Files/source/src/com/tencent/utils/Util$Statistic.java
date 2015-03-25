// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.utils;


public class response
{

    public long reqSize;
    public String response;
    public long rspSize;

    public (String s, int i)
    {
        response = s;
        reqSize = i;
        if (response != null)
        {
            rspSize = response.length();
        }
    }
}
