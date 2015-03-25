// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.utils;

import com.nostra13.universalimageloader.core.assist.ViewScaleType;

class a
{

    static final int a[];

    static 
    {
        a = new int[ViewScaleType.values().length];
        try
        {
            a[ViewScaleType.FIT_INSIDE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        try
        {
            a[ViewScaleType.CROP.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1)
        {
            return;
        }
    }
}
