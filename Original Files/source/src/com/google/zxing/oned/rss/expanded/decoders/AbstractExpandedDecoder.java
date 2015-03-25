// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

// Referenced classes of package com.google.zxing.oned.rss.expanded.decoders:
//            s, g, j, a, 
//            b, c, d, e

public abstract class AbstractExpandedDecoder
{

    private final BitArray a;
    private final s b;

    AbstractExpandedDecoder(BitArray bitarray)
    {
        a = bitarray;
        b = new s(bitarray);
    }

    public static AbstractExpandedDecoder createDecoder(BitArray bitarray)
    {
        if (bitarray.get(1))
        {
            return new g(bitarray);
        }
        if (!bitarray.get(2))
        {
            return new j(bitarray);
        }
        switch (s.a(bitarray, 1, 4))
        {
        default:
            switch (s.a(bitarray, 1, 5))
            {
            default:
                switch (s.a(bitarray, 1, 7))
                {
                default:
                    throw new IllegalStateException((new StringBuilder()).append("unknown decoder: ").append(bitarray).toString());

                case 56: // '8'
                    return new e(bitarray, "310", "11");

                case 57: // '9'
                    return new e(bitarray, "320", "11");

                case 58: // ':'
                    return new e(bitarray, "310", "13");

                case 59: // ';'
                    return new e(bitarray, "320", "13");

                case 60: // '<'
                    return new e(bitarray, "310", "15");

                case 61: // '='
                    return new e(bitarray, "320", "15");

                case 62: // '>'
                    return new e(bitarray, "310", "17");

                case 63: // '?'
                    return new e(bitarray, "320", "17");
                }

            case 12: // '\f'
                return new c(bitarray);

            case 13: // '\r'
                return new d(bitarray);
            }

        case 4: // '\004'
            return new a(bitarray);

        case 5: // '\005'
            return new b(bitarray);
        }
    }

    protected s getGeneralDecoder()
    {
        return b;
    }

    protected BitArray getInformation()
    {
        return a;
    }

    public abstract String parseInformation();
}
