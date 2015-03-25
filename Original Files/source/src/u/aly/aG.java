// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;


// Referenced classes of package u.aly:
//            di, cy, ct, ar, 
//            cz, db, bz

class aG extends di
{

    private aG()
    {
    }

    aG(aG ag)
    {
        this();
    }

    public void a(cy cy1, ar ar1)
    {
        cy1.j();
_L6:
        ct ct1;
        ct1 = cy1.l();
        if (ct1.b == 0)
        {
            cy1.k();
            if (!ar1.i())
            {
                throw new cz((new StringBuilder("Required field 'ts' was not found in serialized data! Struct: ")).append(toString()).toString());
            }
            break MISSING_BLOCK_LABEL_218;
        }
        ct1.c;
        JVM INSTR tableswitch 1 3: default 88
    //                   1 104
    //                   2 142
    //                   3 180;
           goto _L1 _L2 _L3 _L4
_L4:
        break MISSING_BLOCK_LABEL_180;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        db.a(cy1, ct1.b);
_L7:
        cy1.m();
        if (true) goto _L6; else goto _L5
_L5:
        if (ct1.b == 11)
        {
            ar1.a = cy1.z();
            ar1.a(true);
        } else
        {
            db.a(cy1, ct1.b);
        }
          goto _L7
_L3:
        if (ct1.b == 10)
        {
            ar1.b = cy1.x();
            ar1.b(true);
        } else
        {
            db.a(cy1, ct1.b);
        }
          goto _L7
        if (ct1.b == 8)
        {
            ar1.c = cy1.w();
            ar1.c(true);
        } else
        {
            db.a(cy1, ct1.b);
        }
          goto _L7
        if (!ar1.l())
        {
            throw new cz((new StringBuilder("Required field 'version' was not found in serialized data! Struct: ")).append(toString()).toString());
        } else
        {
            ar1.m();
            return;
        }
    }

    public volatile void a(cy cy1, bz bz)
    {
        a(cy1, (ar)bz);
    }

    public void b(cy cy1, ar ar1)
    {
        ar1.m();
        cy1.a(ar.n());
        if (ar1.a != null)
        {
            cy1.a(ar.o());
            cy1.a(ar1.a);
            cy1.c();
        }
        cy1.a(ar.p());
        cy1.a(ar1.b);
        cy1.c();
        cy1.a(ar.q());
        cy1.a(ar1.c);
        cy1.c();
        cy1.d();
        cy1.b();
    }

    public volatile void b(cy cy1, bz bz)
    {
        b(cy1, (ar)bz);
    }
}
