// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.data;

import android.os.AsyncTask;
import android.util.SparseArray;
import java.util.ArrayList;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.data:
//            AsyncChartDataLoader, a

class b extends AsyncTask
{

    final AsyncChartDataLoader a;

    private b(AsyncChartDataLoader asyncchartdataloader)
    {
        a = asyncchartdataloader;
        super();
    }

    b(AsyncChartDataLoader asyncchartdataloader, a a1)
    {
        this(asyncchartdataloader);
    }

    protected transient ChartDataLoader.ItemData a(Integer ainteger[])
    {
        ChartDataLoader.ItemData itemdata = a.mCallback.loadData(ainteger[0].intValue());
        itemdata.index = ainteger[0].intValue();
        a.mItemsData.put(ainteger[0].intValue(), itemdata);
        return itemdata;
    }

    protected void a(ChartDataLoader.ItemData itemdata)
    {
        a.mCallback.onDataLoaded(itemdata);
        AsyncChartDataLoader.a(a).remove(this);
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Integer[])aobj);
    }

    protected void onCancelled()
    {
        AsyncChartDataLoader.a(a).remove(this);
    }

    protected void onPostExecute(Object obj)
    {
        a((ChartDataLoader.ItemData)obj);
    }
}
