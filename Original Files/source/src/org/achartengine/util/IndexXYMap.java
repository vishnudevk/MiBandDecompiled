// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

// Referenced classes of package org.achartengine.util:
//            XYEntry

public class IndexXYMap extends TreeMap
{

    private final List a = new ArrayList();
    private double b;

    public IndexXYMap()
    {
        b = 0.0D;
    }

    private void a()
    {
        if (a.size() < 2)
        {
            b = 0.0D;
        } else
        if (Math.abs(((Double)a.get(-1 + a.size())).doubleValue() - ((Double)a.get(-2 + a.size())).doubleValue()) > b)
        {
            b = Math.abs(((Double)a.get(-1 + a.size())).doubleValue() - ((Double)a.get(-2 + a.size())).doubleValue());
            return;
        }
    }

    public void clear()
    {
        a();
        super.clear();
        a.clear();
    }

    public XYEntry getByIndex(int i)
    {
        Object obj = a.get(i);
        return new XYEntry(obj, get(obj));
    }

    public int getIndexForKey(Object obj)
    {
        return Collections.binarySearch(a, obj, null);
    }

    public double getMaxXDifference()
    {
        return b;
    }

    public Object getXByIndex(int i)
    {
        return a.get(i);
    }

    public Object getYByIndex(int i)
    {
        return get(a.get(i));
    }

    public Object put(int i, Object obj, Object obj1)
    {
        a.add(i, obj);
        a();
        return super.put(obj, obj1);
    }

    public Object put(Object obj, Object obj1)
    {
        a.add(obj);
        a();
        return super.put(obj, obj1);
    }

    public XYEntry removeByIndex(int i)
    {
        Object obj = a.remove(i);
        return new XYEntry(obj, remove(obj));
    }
}
