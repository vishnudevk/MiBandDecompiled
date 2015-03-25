// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package u.aly:
//            di, cy, ct, ao, 
//            cz, db, cv, az, 
//            bz

class Y extends di
{

    private Y()
    {
    }

    Y(Y y)
    {
        this();
    }

    public void a(cy cy1, ao ao1)
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
            az az1;
            if (!ao1.s())
            {
                throw new cz((new StringBuilder("Required field 'ts' was not found in serialized data! Struct: ")).append(toString()).toString());
            } else
            {
                ao1.t();
                return;
            }
        }
        ct1.c;
        JVM INSTR tableswitch 1 5: default 96
    //                   1 112
    //                   2 150
    //                   3 262
    //                   4 300
    //                   5 338;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L6:
        break MISSING_BLOCK_LABEL_338;
_L1:
        db.a(cy1, ct1.b);
_L8:
        cy1.m();
          goto _L7
_L2:
        if (ct1.b == 11)
        {
            ao1.a = cy1.z();
            ao1.a(true);
        } else
        {
            db.a(cy1, ct1.b);
        }
          goto _L8
_L3:
        if (ct1.b != 13)
        {
            break MISSING_BLOCK_LABEL_250;
        }
        cv1 = cy1.n();
        ao1.b = new HashMap(2 * cv1.c);
        i = 0;
_L9:
label0:
        {
            if (i < cv1.c)
            {
                break label0;
            }
            cy1.o();
            ao1.b(true);
        }
          goto _L8
        s = cy1.z();
        az1 = new az();
        az1.a(cy1);
        ao1.b.put(s, az1);
        i++;
          goto _L9
        db.a(cy1, ct1.b);
          goto _L8
_L4:
        if (ct1.b == 10)
        {
            ao1.c = cy1.x();
            ao1.c(true);
        } else
        {
            db.a(cy1, ct1.b);
        }
          goto _L8
_L5:
        if (ct1.b == 8)
        {
            ao1.d = cy1.w();
            ao1.d(true);
        } else
        {
            db.a(cy1, ct1.b);
        }
          goto _L8
        if (ct1.b == 10)
        {
            ao1.e = cy1.x();
            ao1.e(true);
        } else
        {
            db.a(cy1, ct1.b);
        }
          goto _L8
    }

    public volatile void a(cy cy1, bz bz)
    {
        a(cy1, (ao)bz);
    }

    public void b(cy cy1, ao ao1)
    {
        ao1.t();
        cy1.a(ao.u());
        if (ao1.a != null)
        {
            cy1.a(ao.v());
            cy1.a(ao1.a);
            cy1.c();
        }
        if (ao1.b == null) goto _L2; else goto _L1
_L1:
        Iterator iterator;
        cy1.a(ao.w());
        cy1.a(new cv((byte)11, (byte)12, ao1.b.size()));
        iterator = ao1.b.entrySet().iterator();
_L6:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        cy1.e();
        cy1.c();
_L2:
        if (ao1.m())
        {
            cy1.a(ao.x());
            cy1.a(ao1.c);
            cy1.c();
        }
        if (ao1.p())
        {
            cy1.a(ao.y());
            cy1.a(ao1.d);
            cy1.c();
        }
        cy1.a(ao.z());
        cy1.a(ao1.e);
        cy1.c();
        cy1.d();
        cy1.b();
        return;
_L4:
        java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
        cy1.a((String)entry.getKey());
        ((az)entry.getValue()).b(cy1);
        if (true) goto _L6; else goto _L5
_L5:
    }

    public volatile void b(cy cy1, bz bz)
    {
        b(cy1, (ao)bz);
    }
}
