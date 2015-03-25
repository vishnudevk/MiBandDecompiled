// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned.rss.expanded;

import com.google.zxing.oned.rss.DataCharacter;
import com.google.zxing.oned.rss.FinderPattern;

final class b
{

    private final boolean a;
    private final DataCharacter b;
    private final DataCharacter c;
    private final FinderPattern d;

    b(DataCharacter datacharacter, DataCharacter datacharacter1, FinderPattern finderpattern, boolean flag)
    {
        b = datacharacter;
        c = datacharacter1;
        d = finderpattern;
        a = flag;
    }

    boolean a()
    {
        return a;
    }

    DataCharacter b()
    {
        return b;
    }

    DataCharacter c()
    {
        return c;
    }

    FinderPattern d()
    {
        return d;
    }

    public boolean e()
    {
        return c == null;
    }
}
