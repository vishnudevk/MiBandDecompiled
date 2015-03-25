// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.database.DataSetObserver;

// Referenced classes of package android.support.v4.view:
//            ViewPager, ay

class aF extends DataSetObserver
{

    final ViewPager a;

    private aF(ViewPager viewpager)
    {
        a = viewpager;
        super();
    }

    aF(ViewPager viewpager, ay ay)
    {
        this(viewpager);
    }

    public void onChanged()
    {
        a.b();
    }

    public void onInvalidated()
    {
        a.b();
    }
}
