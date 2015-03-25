// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;


// Referenced classes of package u.aly:
//            di, cy, ct, bh, 
//            cz, db, bz

class cK extends di
{

    private cK()
    {
    }

    cK(cK ck)
    {
        this();
    }

    public void a(cy cy1, bh bh1)
    {
        cy1.j();
_L12:
        ct ct1;
        ct1 = cy1.l();
        if (ct1.b == 0)
        {
            cy1.k();
            if (!bh1.o())
            {
                throw new cz((new StringBuilder("Required field 'serial_num' was not found in serialized data! Struct: ")).append(toString()).toString());
            }
            break MISSING_BLOCK_LABEL_470;
        }
        ct1.c;
        JVM INSTR tableswitch 1 9: default 112
    //                   1 128
    //                   2 166
    //                   3 204
    //                   4 242
    //                   5 280
    //                   6 318
    //                   7 356
    //                   8 394
    //                   9 432;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L10:
        break MISSING_BLOCK_LABEL_432;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        db.a(cy1, ct1.b);
_L13:
        cy1.m();
        if (true) goto _L12; else goto _L11
_L11:
        if (ct1.b == 11)
        {
            bh1.a = cy1.z();
            bh1.a(true);
        } else
        {
            db.a(cy1, ct1.b);
        }
          goto _L13
_L3:
        if (ct1.b == 11)
        {
            bh1.b = cy1.z();
            bh1.b(true);
        } else
        {
            db.a(cy1, ct1.b);
        }
          goto _L13
_L4:
        if (ct1.b == 11)
        {
            bh1.c = cy1.z();
            bh1.c(true);
        } else
        {
            db.a(cy1, ct1.b);
        }
          goto _L13
_L5:
        if (ct1.b == 8)
        {
            bh1.d = cy1.w();
            bh1.d(true);
        } else
        {
            db.a(cy1, ct1.b);
        }
          goto _L13
_L6:
        if (ct1.b == 8)
        {
            bh1.e = cy1.w();
            bh1.e(true);
        } else
        {
            db.a(cy1, ct1.b);
        }
          goto _L13
_L7:
        if (ct1.b == 8)
        {
            bh1.f = cy1.w();
            bh1.f(true);
        } else
        {
            db.a(cy1, ct1.b);
        }
          goto _L13
_L8:
        if (ct1.b == 11)
        {
            bh1.g = cy1.A();
            bh1.g(true);
        } else
        {
            db.a(cy1, ct1.b);
        }
          goto _L13
_L9:
        if (ct1.b == 11)
        {
            bh1.h = cy1.z();
            bh1.h(true);
        } else
        {
            db.a(cy1, ct1.b);
        }
          goto _L13
        if (ct1.b == 11)
        {
            bh1.i = cy1.z();
            bh1.i(true);
        } else
        {
            db.a(cy1, ct1.b);
        }
          goto _L13
        if (!bh1.r())
        {
            throw new cz((new StringBuilder("Required field 'ts_secs' was not found in serialized data! Struct: ")).append(toString()).toString());
        }
        if (!bh1.u())
        {
            throw new cz((new StringBuilder("Required field 'length' was not found in serialized data! Struct: ")).append(toString()).toString());
        } else
        {
            bh1.F();
            return;
        }
    }

    public volatile void a(cy cy1, bz bz)
    {
        a(cy1, (bh)bz);
    }

    public void b(cy cy1, bh bh1)
    {
        bh1.F();
        cy1.a(bh.G());
        if (bh1.a != null)
        {
            cy1.a(bh.H());
            cy1.a(bh1.a);
            cy1.c();
        }
        if (bh1.b != null)
        {
            cy1.a(bh.I());
            cy1.a(bh1.b);
            cy1.c();
        }
        if (bh1.c != null)
        {
            cy1.a(bh.J());
            cy1.a(bh1.c);
            cy1.c();
        }
        cy1.a(bh.K());
        cy1.a(bh1.d);
        cy1.c();
        cy1.a(bh.L());
        cy1.a(bh1.e);
        cy1.c();
        cy1.a(bh.M());
        cy1.a(bh1.f);
        cy1.c();
        if (bh1.g != null)
        {
            cy1.a(bh.N());
            cy1.a(bh1.g);
            cy1.c();
        }
        if (bh1.h != null)
        {
            cy1.a(bh.O());
            cy1.a(bh1.h);
            cy1.c();
        }
        if (bh1.i != null)
        {
            cy1.a(bh.P());
            cy1.a(bh1.i);
            cy1.c();
        }
        cy1.d();
        cy1.b();
    }

    public volatile void b(cy cy1, bz bz)
    {
        b(cy1, (bh)bz);
    }
}
