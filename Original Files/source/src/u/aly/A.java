// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;


// Referenced classes of package u.aly:
//            di, cy, ct, ah, 
//            cz, db, bz

class A extends di
{

    private A()
    {
    }

    A(A a1)
    {
        this();
    }

    public void a(cy cy1, ah ah1)
    {
        cy1.j();
_L1:
        ct ct1 = cy1.l();
        if (ct1.b == 0)
        {
            cy1.k();
            if (!ah1.e())
            {
                throw new cz((new StringBuilder("Required field 'ts' was not found in serialized data! Struct: ")).append(toString()).toString());
            } else
            {
                ah1.f();
                return;
            }
        }
        switch (ct1.c)
        {
        default:
            db.a(cy1, ct1.b);
            break;

        case 1: // '\001'
            break MISSING_BLOCK_LABEL_96;
        }
        cy1.m();
          goto _L1
        if (ct1.b == 10)
        {
            ah1.a = cy1.x();
            ah1.a(true);
        } else
        {
            db.a(cy1, ct1.b);
        }
        break MISSING_BLOCK_LABEL_89;
    }

    public volatile void a(cy cy1, bz bz)
    {
        a(cy1, (ah)bz);
    }

    public void b(cy cy1, ah ah1)
    {
        ah1.f();
        cy1.a(ah.h());
        cy1.a(ah.i());
        cy1.a(ah1.a);
        cy1.c();
        cy1.d();
        cy1.b();
    }

    public volatile void b(cy cy1, bz bz)
    {
        b(cy1, (ah)bz);
    }
}
