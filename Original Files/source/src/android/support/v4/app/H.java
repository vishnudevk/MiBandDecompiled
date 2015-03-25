// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.widget.ListView;

// Referenced classes of package android.support.v4.app:
//            ListFragment

class H
    implements Runnable
{

    final ListFragment a;

    H(ListFragment listfragment)
    {
        a = listfragment;
        super();
    }

    public void run()
    {
        a.e.focusableViewAvailable(a.e);
    }
}
