// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.download;


class a
{

    static final int a[];

    static 
    {
        a = new int[ImageDownloader.Scheme.values().length];
        try
        {
            a[ImageDownloader.Scheme.HTTP.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        try
        {
            a[ImageDownloader.Scheme.HTTPS.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[ImageDownloader.Scheme.FILE.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[ImageDownloader.Scheme.CONTENT.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[ImageDownloader.Scheme.ASSETS.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            a[ImageDownloader.Scheme.DRAWABLE.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            a[ImageDownloader.Scheme.UNKNOWN.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror6)
        {
            return;
        }
    }
}
