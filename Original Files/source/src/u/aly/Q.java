// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package u.aly:
//            di, cy, ct, al, 
//            cz, db, cv, bz

class Q extends di
{

    private Q()
    {
    }

    Q(Q q)
    {
        this();
    }

    public void a(cy cy1, al al1)
    {
        cy1.j();
_L7:
        ct ct1 = cy1.l();
        if (ct1.b == 0)
        {
            cy1.k();
            cv cv1;
            int i;
            String s;
            String s1;
            if (!al1.e())
            {
                throw new cz((new StringBuilder("Required field 'ts' was not found in serialized data! Struct: ")).append(toString()).toString());
            } else
            {
                al1.t();
                return;
            }
        }
        ct1.c;
        JVM INSTR tableswitch 1 5: default 96
    //                   1 112
    //                   2 150
    //                   3 188
    //                   4 291
    //                   5 329;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L6:
        break MISSING_BLOCK_LABEL_329;
_L1:
        db.a(cy1, ct1.b);
_L8:
        cy1.m();
          goto _L7
_L2:
        if (ct1.b == 10)
        {
            al1.a = cy1.x();
            al1.a(true);
        } else
        {
            db.a(cy1, ct1.b);
        }
          goto _L8
_L3:
        if (ct1.b == 11)
        {
            al1.b = cy1.z();
            al1.b(true);
        } else
        {
            db.a(cy1, ct1.b);
        }
          goto _L8
_L4:
        if (ct1.b != 13)
        {
            break MISSING_BLOCK_LABEL_279;
        }
        cv1 = cy1.n();
        al1.c = new HashMap(2 * cv1.c);
        i = 0;
_L9:
label0:
        {
            if (i < cv1.c)
            {
                break label0;
            }
            cy1.o();
            al1.c(true);
        }
          goto _L8
        s = cy1.z();
        s1 = cy1.z();
        al1.c.put(s, s1);
        i++;
          goto _L9
        db.a(cy1, ct1.b);
          goto _L8
_L5:
        if (ct1.b == 10)
        {
            al1.d = cy1.x();
            al1.d(true);
        } else
        {
            db.a(cy1, ct1.b);
        }
          goto _L8
        if (ct1.b == 8)
        {
            al1.e = cy1.w();
            al1.e(true);
        } else
        {
            db.a(cy1, ct1.b);
        }
          goto _L8
    }

    public volatile void a(cy cy1, bz bz)
    {
        a(cy1, (al)bz);
    }

    public void b(cy cy1, al al1)
    {
        al1.t();
        cy1.a(al.u());
        cy1.a(al.v());
        cy1.a(al1.a);
        cy1.c();
        if (al1.b != null)
        {
            cy1.a(al.w());
            cy1.a(al1.b);
            cy1.c();
        }
        if (al1.c == null) goto _L2; else goto _L1
_L1:
        Iterator iterator;
        cy1.a(al.x());
        cy1.a(new cv((byte)11, (byte)11, al1.c.size()));
        iterator = al1.c.entrySet().iterator();
_L6:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        cy1.e();
        cy1.c();
_L2:
        if (al1.p())
        {
            cy1.a(al.y());
            cy1.a(al1.d);
            cy1.c();
        }
        if (al1.s())
        {
            cy1.a(al.z());
            cy1.a(al1.e);
            cy1.c();
        }
        cy1.d();
        cy1.b();
        return;
_L4:
        java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
        cy1.a((String)entry.getKey());
        cy1.a((String)entry.getValue());
        if (true) goto _L6; else goto _L5
_L5:
    }

    public volatile void b(cy cy1, bz bz)
    {
        b(cy1, (al)bz);
    }
}
