// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.constants;


public final class Build
{

    public static final int EMOJI_SUPPORTED_SDK_INT = 0x21030001;
    public static final int FAVORITE_SUPPPORTED_SDK_INT = 0x22000001;
    public static final int MESSAGE_ACTION_SUPPPORTED_SDK_INT = 0x22010003;
    public static final int MIN_SDK_INT = 0x21010001;
    public static final int MUSIC_DATA_URL_SUPPORTED_SDK_INT = 0x21040001;
    public static final int OPENID_SUPPORTED_SDK_INT = 0x22000001;
    public static final int PAY_SUPPORTED_SDK_INT = 0x22000001;
    public static final int SDK_INT = 0x22010003;
    public static final String SDK_VERSION_NAME = "android 2.1.3";
    public static final int TIMELINE_SUPPORTED_SDK_INT = 0x21020001;

    private Build()
    {
        throw new RuntimeException((new StringBuilder()).append(getClass().getSimpleName()).append(" should not be instantiated").toString());
    }

    public static int getMajorVersion()
    {
        return 2;
    }

    public static int getMinorVersion()
    {
        return 1;
    }
}
