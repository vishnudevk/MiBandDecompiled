// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Referenced classes of package com.google.gson.internal:
//            LinkedTreeMap, w, q

abstract class v
    implements Iterator
{

    w b;
    w c;
    int d;
    final LinkedTreeMap e;

    private v(LinkedTreeMap linkedtreemap)
    {
        e = linkedtreemap;
        super();
        b = e.e.d;
        c = null;
        d = e.d;
    }

    v(LinkedTreeMap linkedtreemap, q q)
    {
        this(linkedtreemap);
    }

    final w b()
    {
        w w1 = b;
        if (w1 == e.e)
        {
            throw new NoSuchElementException();
        }
        if (e.d != d)
        {
            throw new ConcurrentModificationException();
        } else
        {
            b = w1.d;
            c = w1;
            return w1;
        }
    }

    public final boolean hasNext()
    {
        return b != e.e;
    }

    public final void remove()
    {
        if (c == null)
        {
            throw new IllegalStateException();
        } else
        {
            e.a(c, true);
            c = null;
            d = e.d;
            return;
        }
    }
}
