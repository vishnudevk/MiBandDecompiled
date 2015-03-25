// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.account.openauth;

import android.os.Bundle;

public interface 
{

    public abstract void onAuthorizeFailed(Bundle bundle);

    public abstract void onAuthorizeSucceeded(Bundle bundle);

    public abstract void onCancelled();
}
