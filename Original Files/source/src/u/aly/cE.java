// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package u.aly:
//            dj, de, bf, aj, 
//            ai, ak, ax, ah, 
//            at, as, av, bd, 
//            cu, cy, bz

class cE extends dj
{

    private cE()
    {
    }

    cE(cE ce)
    {
        this();
    }

    public void a(cy cy, bf bf1)
    {
        de de1;
        de1 = (de)cy;
        bf1.a.b(de1);
        bf1.b.b(de1);
        bf1.c.b(de1);
        bf1.d.b(de1);
        BitSet bitset = new BitSet();
        if (bf1.r())
        {
            bitset.set(0);
        }
        if (bf1.w())
        {
            bitset.set(1);
        }
        if (bf1.B())
        {
            bitset.set(2);
        }
        if (bf1.E())
        {
            bitset.set(3);
        }
        if (bf1.H())
        {
            bitset.set(4);
        }
        de1.a(bitset, 5);
        if (bf1.r())
        {
            bf1.e.b(de1);
        }
        if (!bf1.w()) goto _L2; else goto _L1
_L1:
        Iterator iterator1;
        de1.a(bf1.f.size());
        iterator1 = bf1.f.iterator();
_L5:
        if (iterator1.hasNext()) goto _L3; else goto _L2
_L2:
        if (bf1.B())
        {
            de1.a(bf1.g.size());
            for (Iterator iterator = bf1.g.iterator(); iterator.hasNext(); ((bd)iterator.next()).b(de1))
            {
                break MISSING_BLOCK_LABEL_263;
            }

        }
        if (bf1.E())
        {
            bf1.h.b(de1);
        }
        if (bf1.H())
        {
            bf1.i.b(de1);
        }
        return;
_L3:
        ((av)iterator1.next()).b(de1);
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void a(cy cy, bz bz)
    {
        b(cy, (bf)bz);
    }

    public void b(cy cy, bf bf1)
    {
        int i;
        de de1;
        BitSet bitset;
        i = 0;
        de1 = (de)cy;
        bf1.a = new aj();
        bf1.a.a(de1);
        bf1.a(true);
        bf1.b = new ai();
        bf1.b.a(de1);
        bf1.b(true);
        bf1.c = new ak();
        bf1.c.a(de1);
        bf1.c(true);
        bf1.d = new ax();
        bf1.d.a(de1);
        bf1.d(true);
        bitset = de1.b(5);
        if (bitset.get(0))
        {
            bf1.e = new ah();
            bf1.e.a(de1);
            bf1.e(true);
        }
        if (!bitset.get(1)) goto _L2; else goto _L1
_L1:
        cu cu1;
        int j;
        cu1 = new cu((byte)12, de1.w());
        bf1.f = new ArrayList(cu1.b);
        j = 0;
_L7:
        if (j < cu1.b) goto _L4; else goto _L3
_L3:
        bf1.f(true);
_L2:
        if (!bitset.get(2)) goto _L6; else goto _L5
_L5:
        cu cu2;
        cu2 = new cu((byte)12, de1.w());
        bf1.g = new ArrayList(cu2.b);
_L8:
        if (i < cu2.b)
        {
            break MISSING_BLOCK_LABEL_367;
        }
        bf1.g(true);
_L6:
        if (bitset.get(3))
        {
            bf1.h = new at();
            bf1.h.a(de1);
            bf1.h(true);
        }
        if (bitset.get(4))
        {
            bf1.i = new as();
            bf1.i.a(de1);
            bf1.i(true);
        }
        return;
_L4:
        av av1 = new av();
        av1.a(de1);
        bf1.f.add(av1);
        j++;
          goto _L7
        bd bd1 = new bd();
        bd1.a(de1);
        bf1.g.add(bd1);
        i++;
          goto _L8
    }

    public void b(cy cy, bz bz)
    {
        a(cy, (bf)bz);
    }
}
