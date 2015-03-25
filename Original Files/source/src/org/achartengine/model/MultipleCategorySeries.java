// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package org.achartengine.model:
//            XYSeries

public class MultipleCategorySeries
    implements Serializable
{

    private String a;
    private List b;
    private List c;
    private List d;

    public MultipleCategorySeries(String s)
    {
        b = new ArrayList();
        c = new ArrayList();
        d = new ArrayList();
        a = s;
    }

    public void add(String s, String as[], double ad[])
    {
        b.add(s);
        c.add(as);
        d.add(ad);
    }

    public void add(String as[], double ad[])
    {
        add((new StringBuilder()).append(b.size()).append("").toString(), as, ad);
    }

    public void clear()
    {
        b.clear();
        c.clear();
        d.clear();
    }

    public int getCategoriesCount()
    {
        return b.size();
    }

    public String getCategory(int i)
    {
        return (String)b.get(i);
    }

    public int getItemCount(int i)
    {
        return ((double[])d.get(i)).length;
    }

    public String[] getTitles(int i)
    {
        return (String[])c.get(i);
    }

    public double[] getValues(int i)
    {
        return (double[])d.get(i);
    }

    public void remove(int i)
    {
        b.remove(i);
        c.remove(i);
        d.remove(i);
    }

    public XYSeries toXYSeries()
    {
        return new XYSeries(a);
    }
}
