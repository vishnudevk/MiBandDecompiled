// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package u.aly:
//            dj, de, av, am, 
//            ao, cu, cy, bz

class aY extends dj
{

    private aY()
    {
    }

    aY(aY ay)
    {
        this();
    }

    public void a(cy cy, av av1)
    {
        de de1;
        de1 = (de)cy;
        de1.a(av1.a);
        BitSet bitset = new BitSet();
        if (av1.k())
        {
            bitset.set(0);
        }
        if (av1.p())
        {
            bitset.set(1);
        }
        if (av1.u())
        {
            bitset.set(2);
        }
        de1.a(bitset, 3);
        if (!av1.k()) goto _L2; else goto _L1
_L1:
        Iterator iterator2;
        de1.a(av1.b.size());
        iterator2 = av1.b.iterator();
_L5:
        if (iterator2.hasNext()) goto _L3; else goto _L2
_L2:
        if (av1.p())
        {
            de1.a(av1.c.size());
            for (Iterator iterator1 = av1.c.iterator(); iterator1.hasNext(); ((ao)iterator1.next()).b(de1))
            {
                break MISSING_BLOCK_LABEL_209;
            }

        }
        if (av1.u())
        {
            de1.a(av1.d.size());
            for (Iterator iterator = av1.d.iterator(); iterator.hasNext(); ((ao)iterator.next()).b(de1))
            {
                break MISSING_BLOCK_LABEL_226;
            }

        }
        return;
_L3:
        ((am)iterator2.next()).b(de1);
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void a(cy cy, bz bz)
    {
        b(cy, (av)bz);
    }

    public void b(cy cy, av av1)
    {
        int i;
        de de1;
        BitSet bitset;
        i = 0;
        de1 = (de)cy;
        av1.a = de1.z();
        av1.a(true);
        bitset = de1.b(3);
        if (!bitset.get(0)) goto _L2; else goto _L1
_L1:
        cu cu1;
        int j;
        cu1 = new cu((byte)12, de1.w());
        av1.b = new ArrayList(cu1.b);
        j = 0;
_L11:
        if (j < cu1.b) goto _L4; else goto _L3
_L3:
        av1.b(true);
_L2:
        if (!bitset.get(1)) goto _L6; else goto _L5
_L5:
        cu cu2;
        int k;
        cu2 = new cu((byte)12, de1.w());
        av1.c = new ArrayList(cu2.b);
        k = 0;
_L12:
        if (k < cu2.b) goto _L8; else goto _L7
_L7:
        av1.c(true);
_L6:
        if (!bitset.get(2)) goto _L10; else goto _L9
_L9:
        cu cu3;
        cu3 = new cu((byte)12, de1.w());
        av1.d = new ArrayList(cu3.b);
_L13:
        if (i < cu3.b)
        {
            break MISSING_BLOCK_LABEL_272;
        }
        av1.d(true);
_L10:
        return;
_L4:
        am am1 = new am();
        am1.a(de1);
        av1.b.add(am1);
        j++;
          goto _L11
_L8:
        ao ao1 = new ao();
        ao1.a(de1);
        av1.c.add(ao1);
        k++;
          goto _L12
        ao ao2 = new ao();
        ao2.a(de1);
        av1.d.add(ao2);
        i++;
          goto _L13
    }

    public void b(cy cy, bz bz)
    {
        a(cy, (av)bz);
    }
}
