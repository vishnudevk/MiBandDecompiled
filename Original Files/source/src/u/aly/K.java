// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.util.BitSet;

// Referenced classes of package u.aly:
//            dj, de, aj, cy, 
//            bz

class K extends dj
{

    private K()
    {
    }

    K(K k)
    {
        this();
    }

    public void a(cy cy, aj aj1)
    {
        de de1 = (de)cy;
        de1.a(aj1.a);
        de1.a(aj1.b);
        BitSet bitset = new BitSet();
        if (aj1.l())
        {
            bitset.set(0);
        }
        de1.a(bitset, 1);
        if (aj1.l())
        {
            de1.a(aj1.c);
        }
    }

    public void a(cy cy, bz bz)
    {
        b(cy, (aj)bz);
    }

    public void b(cy cy, aj aj1)
    {
        de de1 = (de)cy;
        aj1.a = de1.w();
        aj1.a(true);
        aj1.b = de1.w();
        aj1.b(true);
        if (de1.b(1).get(0))
        {
            aj1.c = de1.w();
            aj1.c(true);
        }
    }

    public void b(cy cy, bz bz)
    {
        a(cy, (aj)bz);
    }
}
