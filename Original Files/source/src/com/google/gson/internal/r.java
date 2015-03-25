// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal;

import java.util.AbstractSet;
import java.util.Iterator;

// Referenced classes of package com.google.gson.internal:
//            LinkedTreeMap, s

class r extends AbstractSet
{

    final LinkedTreeMap a;

    r(LinkedTreeMap linkedtreemap)
    {
        a = linkedtreemap;
        super();
    }

    public void clear()
    {
        a.clear();
    }

    public boolean contains(Object obj)
    {
        return (obj instanceof java.util.Map.Entry) && a.a((java.util.Map.Entry)obj) != null;
    }

    public Iterator iterator()
    {
        return new s(this);
    }

    public boolean remove(Object obj)
    {
        w w;
        if (obj instanceof java.util.Map.Entry)
        {
            if ((w = a.a((java.util.Map.Entry)obj)) != null)
            {
                a.a(w, true);
                return true;
            }
        }
        return false;
    }

    public int size()
    {
        return a.c;
    }
}
