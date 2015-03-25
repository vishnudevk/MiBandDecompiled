// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package u.aly:
//            di, cy, ct, av, 
//            db, cu, am, ao, 
//            bz

class aW extends di
{

    private aW()
    {
    }

    aW(aW aw)
    {
        this();
    }

    public void a(cy cy1, av av1)
    {
        cy1.j();
_L7:
        ct ct1;
        ct1 = cy1.l();
        if (ct1.b == 0)
        {
            cy1.k();
            av1.v();
            return;
        }
        ct1.c;
        JVM INSTR tableswitch 1 4: default 64
    //                   1 80
    //                   2 118
    //                   3 220
    //                   4 322;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        db.a(cy1, ct1.b);
_L8:
        cy1.m();
        if (true) goto _L7; else goto _L6
_L6:
        if (ct1.b == 11)
        {
            av1.a = cy1.z();
            av1.a(true);
        } else
        {
            db.a(cy1, ct1.b);
        }
          goto _L8
_L3:
        cu cu3;
        int k;
        if (ct1.b != 15)
        {
            break MISSING_BLOCK_LABEL_208;
        }
        cu3 = cy1.p();
        av1.b = new ArrayList(cu3.b);
        k = 0;
_L9:
label0:
        {
            if (k < cu3.b)
            {
                break label0;
            }
            cy1.q();
            av1.b(true);
        }
          goto _L8
        am am1 = new am();
        am1.a(cy1);
        av1.b.add(am1);
        k++;
          goto _L9
        db.a(cy1, ct1.b);
          goto _L8
_L4:
        cu cu2;
        int j;
        if (ct1.b != 15)
        {
            break MISSING_BLOCK_LABEL_310;
        }
        cu2 = cy1.p();
        av1.c = new ArrayList(cu2.b);
        j = 0;
_L10:
label1:
        {
            if (j < cu2.b)
            {
                break label1;
            }
            cy1.q();
            av1.c(true);
        }
          goto _L8
        ao ao2 = new ao();
        ao2.a(cy1);
        av1.c.add(ao2);
        j++;
          goto _L10
        db.a(cy1, ct1.b);
          goto _L8
_L5:
        cu cu1;
        int i;
        if (ct1.b != 15)
        {
            break MISSING_BLOCK_LABEL_412;
        }
        cu1 = cy1.p();
        av1.d = new ArrayList(cu1.b);
        i = 0;
_L11:
label2:
        {
            if (i < cu1.b)
            {
                break label2;
            }
            cy1.q();
            av1.d(true);
        }
          goto _L8
        ao ao1 = new ao();
        ao1.a(cy1);
        av1.d.add(ao1);
        i++;
          goto _L11
        db.a(cy1, ct1.b);
          goto _L8
    }

    public volatile void a(cy cy1, bz bz)
    {
        a(cy1, (av)bz);
    }

    public void b(cy cy1, av av1)
    {
        av1.v();
        cy1.a(av.w());
        if (av1.a != null)
        {
            cy1.a(av.x());
            cy1.a(av1.a);
            cy1.c();
        }
        if (av1.b == null || !av1.k()) goto _L2; else goto _L1
_L1:
        Iterator iterator2;
        cy1.a(av.y());
        cy1.a(new cu((byte)12, av1.b.size()));
        iterator2 = av1.b.iterator();
_L6:
        if (iterator2.hasNext()) goto _L4; else goto _L3
_L3:
        cy1.f();
        cy1.c();
_L2:
        if (av1.c != null && av1.p())
        {
            cy1.a(av.z());
            cy1.a(new cu((byte)12, av1.c.size()));
            for (Iterator iterator1 = av1.c.iterator(); iterator1.hasNext(); ((ao)iterator1.next()).b(cy1))
            {
                break MISSING_BLOCK_LABEL_277;
            }

            cy1.f();
            cy1.c();
        }
        if (av1.d != null && av1.u())
        {
            cy1.a(av.A());
            cy1.a(new cu((byte)12, av1.d.size()));
            for (Iterator iterator = av1.d.iterator(); iterator.hasNext(); ((ao)iterator.next()).b(cy1))
            {
                break MISSING_BLOCK_LABEL_294;
            }

            cy1.f();
            cy1.c();
        }
        cy1.d();
        cy1.b();
        return;
_L4:
        ((am)iterator2.next()).b(cy1);
        if (true) goto _L6; else goto _L5
_L5:
    }

    public volatile void b(cy cy1, bz bz)
    {
        b(cy1, (av)bz);
    }
}
