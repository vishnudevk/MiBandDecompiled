// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;


class f
{

    static final int a[];

    static 
    {
        a = new int[com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.values().length];
        try
        {
            a[com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.HTTP.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        try
        {
            a[com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.HTTPS.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1)
        {
            return;
        }
    }
}
