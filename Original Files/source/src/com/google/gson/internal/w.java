// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal;


final class w
    implements java.util.Map.Entry
{

    w a;
    w b;
    w c;
    w d;
    w e;
    final Object f;
    Object g;
    int h;

    w()
    {
        f = null;
        e = this;
        d = this;
    }

    w(w w1, Object obj, w w2, w w3)
    {
        a = w1;
        f = obj;
        h = 1;
        d = w2;
        e = w3;
        w3.d = this;
        w2.e = this;
    }

    public w a()
    {
        w w2;
        for (w w1 = b; w1 != null; w1 = w2)
        {
            w2 = w1.b;
            this = w1;
        }

        return this;
    }

    public w b()
    {
        w w2;
        for (w w1 = c; w1 != null; w1 = w2)
        {
            w2 = w1.c;
            this = w1;
        }

        return this;
    }

    public boolean equals(Object obj)
    {
        boolean flag;
        boolean flag1;
        flag = obj instanceof java.util.Map.Entry;
        flag1 = false;
        if (!flag) goto _L2; else goto _L1
_L1:
        java.util.Map.Entry entry = (java.util.Map.Entry)obj;
        if (f != null) goto _L4; else goto _L3
_L3:
        Object obj2;
        obj2 = entry.getKey();
        flag1 = false;
        if (obj2 != null) goto _L2; else goto _L5
_L5:
        if (g != null) goto _L7; else goto _L6
_L6:
        Object obj1;
        obj1 = entry.getValue();
        flag1 = false;
        if (obj1 != null) goto _L2; else goto _L8
_L8:
        flag1 = true;
_L2:
        return flag1;
_L4:
        boolean flag2;
        flag2 = f.equals(entry.getKey());
        flag1 = false;
        if (!flag2) goto _L2; else goto _L5
_L7:
        boolean flag3;
        flag3 = g.equals(entry.getValue());
        flag1 = false;
        if (!flag3) goto _L2; else goto _L8
    }

    public Object getKey()
    {
        return f;
    }

    public Object getValue()
    {
        return g;
    }

    public int hashCode()
    {
        int i;
        Object obj;
        int j;
        if (f == null)
        {
            i = 0;
        } else
        {
            i = f.hashCode();
        }
        obj = g;
        j = 0;
        if (obj != null)
        {
            j = g.hashCode();
        }
        return i ^ j;
    }

    public Object setValue(Object obj)
    {
        Object obj1 = g;
        g = obj;
        return obj1;
    }

    public String toString()
    {
        return (new StringBuilder()).append(f).append("=").append(g).toString();
    }
}
