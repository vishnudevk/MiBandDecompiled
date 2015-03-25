// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.util.BitSet;

// Referenced classes of package u.aly:
//            dj, de, au, cy, 
//            bz

class aU extends dj
{

    private aU()
    {
    }

    aU(aU au1)
    {
        this();
    }

    public void a(cy cy, au au1)
    {
        de de1 = (de)cy;
        de1.a(au1.b);
        de1.a(au1.c);
        BitSet bitset = new BitSet();
        if (au1.e())
        {
            bitset.set(0);
        }
        de1.a(bitset, 1);
        if (au1.e())
        {
            de1.a(au1.a);
        }
    }

    public void a(cy cy, bz bz)
    {
        b(cy, (au)bz);
    }

    public void b(cy cy, au au1)
    {
        de de1 = (de)cy;
        au1.b = de1.x();
        au1.b(true);
        au1.c = de1.z();
        au1.c(true);
        if (de1.b(1).get(0))
        {
            au1.a = de1.z();
            au1.a(true);
        }
    }

    public void b(cy cy, bz bz)
    {
        a(cy, (au)bz);
    }
}
