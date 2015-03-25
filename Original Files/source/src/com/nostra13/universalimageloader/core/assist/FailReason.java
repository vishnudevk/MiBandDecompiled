// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.assist;


public class FailReason
{

    private final FailType a;
    private final Throwable b;

    public FailReason(FailType failtype, Throwable throwable)
    {
        a = failtype;
        b = throwable;
    }

    public Throwable getCause()
    {
        return b;
    }

    public FailType getType()
    {
        return a;
    }
}
