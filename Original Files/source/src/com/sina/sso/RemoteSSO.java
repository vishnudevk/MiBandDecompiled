// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.sso;

import android.os.IInterface;

public interface RemoteSSO
    extends IInterface
{

    public abstract String getActivityName();

    public abstract String getLoginUserName();

    public abstract String getPackageName();
}
