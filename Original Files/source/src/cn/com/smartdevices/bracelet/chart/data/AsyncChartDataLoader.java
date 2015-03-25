// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.data:
//            ChartDataLoader, b

public class AsyncChartDataLoader extends ChartDataLoader
{

    private Executor a;
    private ArrayList b;

    public AsyncChartDataLoader()
    {
        a = Executors.newSingleThreadExecutor();
        b = new ArrayList();
    }

    static ArrayList a(AsyncChartDataLoader asyncchartdataloader)
    {
        return asyncchartdataloader.b;
    }

    public void cancel()
    {
        if (!b.isEmpty())
        {
            Iterator iterator = b.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                b b1 = (b)iterator.next();
                if (!b1.isCancelled())
                {
                    b1.cancel(false);
                }
            } while (true);
        }
        b.clear();
    }

    public boolean isCancelled()
    {
label0:
        {
            if (b.isEmpty())
            {
                break label0;
            }
            Iterator iterator = b.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
            } while (!((b)iterator.next()).isCancelled());
            return true;
        }
        return false;
    }

    public void loadItemData(int i)
    {
        b b1 = new b(this, null);
        Executor executor = a;
        Integer ainteger[] = new Integer[1];
        ainteger[0] = Integer.valueOf(i);
        b1.executeOnExecutor(executor, ainteger);
        b.add(b1);
    }
}
