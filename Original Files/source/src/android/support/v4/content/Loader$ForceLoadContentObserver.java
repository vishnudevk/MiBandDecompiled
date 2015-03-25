// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.content;

import android.database.ContentObserver;
import android.os.Handler;

// Referenced classes of package android.support.v4.content:
//            Loader

public final class a extends ContentObserver
{

    final Loader a;

    public boolean deliverSelfNotifications()
    {
        return true;
    }

    public void onChange(boolean flag)
    {
        a.onContentChanged();
    }

    public (Loader loader)
    {
        a = loader;
        super(new Handler());
    }
}
