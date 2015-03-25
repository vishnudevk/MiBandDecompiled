// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.modelpay;

import android.os.Bundle;

public class callbackFlags
{

    public static final int INVALID_FLAGS = -1;
    public String callbackClassName;
    public int callbackFlags;

    public void fromBundle(Bundle bundle)
    {
        callbackClassName = bundle.getString("_wxapi_payoptions_callback_classname");
        callbackFlags = bundle.getInt("_wxapi_payoptions_callback_flags", -1);
    }

    public void toBundle(Bundle bundle)
    {
        bundle.putString("_wxapi_payoptions_callback_classname", callbackClassName);
        bundle.putInt("_wxapi_payoptions_callback_flags", callbackFlags);
    }

    public ()
    {
        callbackFlags = -1;
    }
}
