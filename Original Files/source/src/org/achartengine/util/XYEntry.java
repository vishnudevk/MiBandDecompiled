// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine.util;


public class XYEntry
    implements java.util.Map.Entry
{

    private final Object a;
    private Object b;

    public XYEntry(Object obj, Object obj1)
    {
        a = obj;
        b = obj1;
    }

    public Object getKey()
    {
        return a;
    }

    public Object getValue()
    {
        return b;
    }

    public Object setValue(Object obj)
    {
        b = obj;
        return b;
    }
}
