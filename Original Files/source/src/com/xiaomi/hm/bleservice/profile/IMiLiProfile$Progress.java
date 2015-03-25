// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.bleservice.profile;


public final class progress
{

    public int progress;
    public int total;

    public String toString()
    {
        return (new StringBuilder()).append("Progress [").append(progress).append("/").append(total).append("]").toString();
    }

    public ()
    {
        total = -1;
        progress = -1;
    }
}
