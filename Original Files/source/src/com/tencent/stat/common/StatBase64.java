// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.stat.common;


// Referenced classes of package com.tencent.stat.common:
//            d, e

public class StatBase64
{

    static final boolean a;

    private StatBase64()
    {
    }

    public static byte[] decode(byte abyte0[], int i)
    {
        return decode(abyte0, 0, abyte0.length, i);
    }

    public static byte[] decode(byte abyte0[], int i, int j, int k)
    {
        d d1 = new d(k, new byte[(j * 3) / 4]);
        if (!d1.a(abyte0, i, j, true))
        {
            throw new IllegalArgumentException("bad base-64");
        }
        if (d1.b == d1.a.length)
        {
            return d1.a;
        } else
        {
            byte abyte1[] = new byte[d1.b];
            System.arraycopy(d1.a, 0, abyte1, 0, d1.b);
            return abyte1;
        }
    }

    public static byte[] encode(byte abyte0[], int i)
    {
        return encode(abyte0, 0, abyte0.length, i);
    }

    public static byte[] encode(byte abyte0[], int i, int j, int k)
    {
        e e1;
        int l;
        e1 = new e(k, null);
        l = 4 * (j / 3);
        if (!e1.d) goto _L2; else goto _L1
_L1:
        if (j % 3 > 0)
        {
            l += 4;
        }
_L4:
        if (e1.e && j > 0)
        {
            int i1 = 1 + (j - 1) / 57;
            byte byte0;
            if (e1.f)
            {
                byte0 = 2;
            } else
            {
                byte0 = 1;
            }
            l += byte0 * i1;
        }
        e1.a = new byte[l];
        e1.a(abyte0, i, j, true);
        if (!a && e1.b != l)
        {
            throw new AssertionError();
        } else
        {
            return e1.a;
        }
_L2:
        switch (j % 3)
        {
        case 1: // '\001'
            l += 2;
            break;

        case 2: // '\002'
            l += 3;
            break;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static 
    {
        boolean flag;
        if (!com/tencent/stat/common/StatBase64.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
    }
}
