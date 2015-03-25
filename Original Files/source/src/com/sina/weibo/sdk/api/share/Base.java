// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.api.share;

import android.content.Context;
import android.os.Bundle;

// Referenced classes of package com.sina.weibo.sdk.api.share:
//            VersionCheckHandler

public abstract class Base
{

    public String transaction;

    public Base()
    {
    }

    abstract boolean check(Context context, VersionCheckHandler versioncheckhandler);

    public abstract void fromBundle(Bundle bundle);

    public abstract int getType();

    public abstract void toBundle(Bundle bundle);
}
