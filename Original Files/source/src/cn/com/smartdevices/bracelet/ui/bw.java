// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import java.util.Comparator;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            bu, SearchSingleBraceletActivity, bq

class bw
    implements Comparator
{

    final SearchSingleBraceletActivity a;

    private bw(SearchSingleBraceletActivity searchsinglebraceletactivity)
    {
        a = searchsinglebraceletactivity;
        super();
    }

    bw(SearchSingleBraceletActivity searchsinglebraceletactivity, bq bq)
    {
        this(searchsinglebraceletactivity);
    }

    public int compare(Object obj, Object obj1)
    {
        bu bu1 = (bu)obj;
        return ((bu)obj1).b - bu1.b;
    }
}
