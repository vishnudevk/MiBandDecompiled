// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned.rss.expanded.decoders;


// Referenced classes of package com.google.zxing.oned.rss.expanded.decoders:
//            q

final class n extends q
{

    static final char a = 36;
    private final char b;

    n(int i, char c)
    {
        super(i);
        b = c;
    }

    char a()
    {
        return b;
    }

    boolean b()
    {
        return b == '$';
    }
}
