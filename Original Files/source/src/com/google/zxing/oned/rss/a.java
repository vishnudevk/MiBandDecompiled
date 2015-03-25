// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned.rss;


// Referenced classes of package com.google.zxing.oned.rss:
//            DataCharacter, FinderPattern

final class a extends DataCharacter
{

    private final FinderPattern a;
    private int b;

    a(int i, int j, FinderPattern finderpattern)
    {
        super(i, j);
        a = finderpattern;
    }

    FinderPattern a()
    {
        return a;
    }

    int b()
    {
        return b;
    }

    void c()
    {
        b = 1 + b;
    }
}
