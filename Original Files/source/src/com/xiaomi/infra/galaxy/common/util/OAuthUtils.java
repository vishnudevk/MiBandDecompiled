// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.util;

import com.xiaomi.infra.galaxy.common.model.OAuthProvider;

public class OAuthUtils
{

    public OAuthUtils()
    {
    }

    public static String getOauthUserId(OAuthProvider oauthprovider, String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(oauthprovider.name()).append(":").append(s);
        return stringbuilder.toString();
    }
}
