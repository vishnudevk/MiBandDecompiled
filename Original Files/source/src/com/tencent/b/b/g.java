// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.b.b;


// Referenced classes of package com.tencent.b.b:
//            a, s

class g
{

    final a a;

    private g(a a1)
    {
        a = a1;
        super();
    }

    g(a a1, byte byte0)
    {
        this(a1);
    }

    public boolean a(String s1, String s2)
    {
        int i = com.tencent.b.b.a.a(a, s1);
        int j = 0x1f & 36 + (10 + i * 9) / 3;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        if (s2.charAt(4) == s.a.charAt(j))
        {
            if (s2.charAt(7) == s.a.charAt(k = 0x1f & (11 + i * 5) / 5) && s2.charAt(12) == s.a.charAt(l = 0x1f & (i + 10) / 3 << 3) && s2.charAt(14) == s.a.charAt(i1 = 0x1f & (19 + i * 3) / 9) && s2.charAt(19) == s.a.charAt(j1 = 0x1f & (39 + i * 3) / 8) && s2.charAt(21) == s.a.charAt(k1 = 0x1f & (67 + i / 23) / 7) && s2.charAt(26) == s.a.charAt(l1 = 0x1f & 7 * (3 + (i + 23) / 6)))
            {
                int i2 = 0;
                int j2 = 0;
                for (; i2 < s1.length(); i2++)
                {
                    j2 = 0xff & j2 >> 8 ^ s.b[0xff & (j2 ^ s.a(s1.charAt(i2)))];
                }

                int k2 = j2 & 0x1f;
                if (s2.charAt(0) == s.a.charAt(k2))
                {
                    int l2 = 0x1f & j2 >> 5;
                    if (s2.charAt(1) == s.a.charAt(l2))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
