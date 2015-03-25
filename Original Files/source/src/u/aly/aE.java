// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.util.BitSet;

// Referenced classes of package u.aly:
//            dj, de, aq, cy, 
//            bz

class aE extends dj
{

    private aE()
    {
    }

    aE(aE ae)
    {
        this();
    }

    public void a(cy cy, aq aq1)
    {
        de de1 = (de)cy;
        de1.a(aq1.a);
        de1.a(aq1.c);
        de1.a(aq1.d);
        BitSet bitset = new BitSet();
        if (aq1.i())
        {
            bitset.set(0);
        }
        de1.a(bitset, 1);
        if (aq1.i())
        {
            de1.a(aq1.b);
        }
    }

    public void a(cy cy, bz bz)
    {
        b(cy, (aq)bz);
    }

    public void b(cy cy, aq aq1)
    {
        de de1 = (de)cy;
        aq1.a = de1.z();
        aq1.a(true);
        aq1.c = de1.z();
        aq1.c(true);
        aq1.d = de1.x();
        aq1.d(true);
        if (de1.b(1).get(0))
        {
            aq1.b = de1.z();
            aq1.b(true);
        }
    }

    public void b(cy cy, bz bz)
    {
        a(cy, (aq)bz);
    }
}
