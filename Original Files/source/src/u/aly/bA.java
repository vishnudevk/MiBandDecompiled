// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;


// Referenced classes of package u.aly:
//            di, cy, ct, aw, 
//            cz, db, bz

class bA extends di
{

    private bA()
    {
    }

    bA(bA ba)
    {
        this();
    }

    public void a(cy cy1, aw aw1)
    {
        cy1.j();
_L6:
        ct ct1;
        ct1 = cy1.l();
        if (ct1.b == 0)
        {
            cy1.k();
            if (!aw1.e())
            {
                throw new cz((new StringBuilder("Required field 'lat' was not found in serialized data! Struct: ")).append(toString()).toString());
            }
            break MISSING_BLOCK_LABEL_216;
        }
        ct1.c;
        JVM INSTR tableswitch 1 3: default 88
    //                   1 104
    //                   2 141
    //                   3 178;
           goto _L1 _L2 _L3 _L4
_L4:
        break MISSING_BLOCK_LABEL_178;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        db.a(cy1, ct1.b);
_L7:
        cy1.m();
        if (true) goto _L6; else goto _L5
_L5:
        if (ct1.b == 4)
        {
            aw1.a = cy1.y();
            aw1.a(true);
        } else
        {
            db.a(cy1, ct1.b);
        }
          goto _L7
_L3:
        if (ct1.b == 4)
        {
            aw1.b = cy1.y();
            aw1.b(true);
        } else
        {
            db.a(cy1, ct1.b);
        }
          goto _L7
        if (ct1.b == 10)
        {
            aw1.c = cy1.x();
            aw1.c(true);
        } else
        {
            db.a(cy1, ct1.b);
        }
          goto _L7
        if (!aw1.i())
        {
            throw new cz((new StringBuilder("Required field 'lng' was not found in serialized data! Struct: ")).append(toString()).toString());
        }
        if (!aw1.l())
        {
            throw new cz((new StringBuilder("Required field 'ts' was not found in serialized data! Struct: ")).append(toString()).toString());
        } else
        {
            aw1.m();
            return;
        }
    }

    public volatile void a(cy cy1, bz bz)
    {
        a(cy1, (aw)bz);
    }

    public void b(cy cy1, aw aw1)
    {
        aw1.m();
        cy1.a(aw.n());
        cy1.a(aw.o());
        cy1.a(aw1.a);
        cy1.c();
        cy1.a(aw.p());
        cy1.a(aw1.b);
        cy1.c();
        cy1.a(aw.q());
        cy1.a(aw1.c);
        cy1.c();
        cy1.d();
        cy1.b();
    }

    public volatile void b(cy cy1, bz bz)
    {
        b(cy1, (aw)bz);
    }
}
