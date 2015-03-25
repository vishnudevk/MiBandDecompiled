// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.bleservice.profile;


public final class category
{

    public static final int N = 3;
    public int category;
    public int intensity;
    public int steps;

    public String toString()
    {
        return (new StringBuilder()).append("ActivityData [intensity=").append(intensity).append(", steps=").append(steps).append(", category=").append(category).append("]").toString();
    }

    public (byte byte0, byte byte1, byte byte2)
    {
        intensity = 0;
        steps = 0;
        category = 0;
        intensity = byte0;
        steps = byte1;
        category = byte2;
    }
}
