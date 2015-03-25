// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal;

import java.util.AbstractSet;
import java.util.Iterator;

// Referenced classes of package com.google.gson.internal:
//            LinkedTreeMap, u

class t extends AbstractSet
{

    final LinkedTreeMap a;

    t(LinkedTreeMap linkedtreemap)
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
        return a.containsKey(obj);
    }

    public Iterator iterator()
    {
        return new u(this);
    }

    public boolean remove(Object obj)
    {
        return a.b(obj) != null;
    }

    public int size()
    {
        return a.c;
    }
}
