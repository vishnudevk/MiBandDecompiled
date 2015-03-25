// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;


// Referenced classes of package u.aly:
//            di, cy, ct, bb, 
//            cz, db, at, bz

class bQ extends di
{

    private bQ()
    {
    }

    bQ(bQ bq)
    {
        this();
    }

    public void a(cy cy1, bb bb1)
    {
        cy1.j();
_L5:
        ct ct1 = cy1.l();
        if (ct1.b == 0)
        {
            cy1.k();
            if (!bb1.e())
            {
                throw new cz((new StringBuilder("Required field 'resp_code' was not found in serialized data! Struct: ")).append(toString()).toString());
            } else
            {
                bb1.m();
                return;
            }
        }
        ct1.c;
        JVM INSTR tableswitch 1 3: default 88
    //                   1 104
    //                   2 142
    //                   3 180;
           goto _L1 _L2 _L3 _L4
_L4:
        break MISSING_BLOCK_LABEL_180;
_L1:
        db.a(cy1, ct1.b);
_L6:
        cy1.m();
          goto _L5
_L2:
        if (ct1.b == 8)
        {
            bb1.a = cy1.w();
            bb1.a(true);
        } else
        {
            db.a(cy1, ct1.b);
        }
          goto _L6
_L3:
        if (ct1.b == 11)
        {
            bb1.b = cy1.z();
            bb1.b(true);
        } else
        {
            db.a(cy1, ct1.b);
        }
          goto _L6
        if (ct1.b == 12)
        {
            bb1.c = new at();
            bb1.c.a(cy1);
            bb1.c(true);
        } else
        {
            db.a(cy1, ct1.b);
        }
          goto _L6
    }

    public volatile void a(cy cy1, bz bz)
    {
        a(cy1, (bb)bz);
    }

    public void b(cy cy1, bb bb1)
    {
        bb1.m();
        cy1.a(bb.n());
        cy1.a(bb.o());
        cy1.a(bb1.a);
        cy1.c();
        if (bb1.b != null && bb1.i())
        {
            cy1.a(bb.p());
            cy1.a(bb1.b);
            cy1.c();
        }
        if (bb1.c != null && bb1.l())
        {
            cy1.a(bb.q());
            bb1.c.b(cy1);
            cy1.c();
        }
        cy1.d();
        cy1.b();
    }

    public volatile void b(cy cy1, bz bz)
    {
        b(cy1, (bb)bz);
    }
}
