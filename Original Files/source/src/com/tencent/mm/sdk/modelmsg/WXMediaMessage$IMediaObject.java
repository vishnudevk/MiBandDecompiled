// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;

public interface 
{

    public static final int TYPE_APPDATA = 7;
    public static final int TYPE_CARD_SHARE = 16;
    public static final int TYPE_DEVICE_ACCESS = 12;
    public static final int TYPE_EMOJI = 8;
    public static final int TYPE_EMOTICON_GIFT = 11;
    public static final int TYPE_EMOTICON_SHARED = 15;
    public static final int TYPE_FILE = 6;
    public static final int TYPE_IMAGE = 2;
    public static final int TYPE_LOCATION_SHARE = 17;
    public static final int TYPE_MALL_PRODUCT = 13;
    public static final int TYPE_MUSIC = 3;
    public static final int TYPE_OLD_TV = 14;
    public static final int TYPE_PRODUCT = 10;
    public static final int TYPE_RECODE = 19;
    public static final int TYPE_TEXT = 1;
    public static final int TYPE_TV = 20;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_URL = 5;
    public static final int TYPE_VIDEO = 4;

    public abstract boolean checkArgs();

    public abstract void serialize(Bundle bundle);

    public abstract int type();

    public abstract void unserialize(Bundle bundle);
}
