// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

// Referenced classes of package com.google.zxing.oned.rss.expanded.decoders:
//            AbstractExpandedDecoder, s

final class j extends AbstractExpandedDecoder
{

    private static final int a = 5;

    j(BitArray bitarray)
    {
        super(bitarray);
    }

    public String parseInformation()
    {
        StringBuilder stringbuilder = new StringBuilder();
        return getGeneralDecoder().a(stringbuilder, 5);
    }
}
