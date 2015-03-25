// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.channel.openauth;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class APP2SDKReceiver extends BroadcastReceiver
{

    public static String AUTH_ACTION_NAME = "com.xiaomi.openauth.action.APP2SDK";
    public static List availableApp = new ArrayList();

    public APP2SDKReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        if (!TextUtils.isEmpty(intent.getStringExtra("pkg")))
        {
            availableApp.add(intent.getStringExtra("pkg"));
        }
    }

}
