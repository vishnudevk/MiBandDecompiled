// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.database.ContentObserver;
import android.os.Handler;

// Referenced classes of package android.support.v4.widget:
//            CursorAdapter

class b extends ContentObserver
{

    final CursorAdapter a;

    public b(CursorAdapter cursoradapter)
    {
        a = cursoradapter;
        super(new Handler());
    }

    public boolean deliverSelfNotifications()
    {
        return true;
    }

    public void onChange(boolean flag)
    {
        a.onContentChanged();
    }
}
