// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.database.DataSetObserver;

// Referenced classes of package cn.com.smartdevices.bracelet.view:
//            VerticalViewPager, C

class H extends DataSetObserver
{

    final VerticalViewPager a;

    private H(VerticalViewPager verticalviewpager)
    {
        a = verticalviewpager;
        super();
    }

    H(VerticalViewPager verticalviewpager, C c)
    {
        this(verticalviewpager);
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
