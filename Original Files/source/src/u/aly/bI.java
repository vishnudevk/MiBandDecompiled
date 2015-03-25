// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;


// Referenced classes of package u.aly:
//            di, cy, ct, ay, 
//            cz, db, bz

class bI extends di
{

    private bI()
    {
    }

    bI(bI bi)
    {
        this();
    }

    public void a(cy cy1, ay ay1)
    {
        cy1.j();
_L4:
        ct ct1 = cy1.l();
        if (ct1.b == 0)
        {
            cy1.k();
            if (!ay1.i())
            {
                throw new cz((new StringBuilder("Required field 'duration' was not found in serialized data! Struct: ")).append(toString()).toString());
            } else
            {
                ay1.j();
                return;
            }
        }
        ct1.c;
        JVM INSTR tableswitch 1 2: default 84
    //                   1 100
    //                   2 138;
           goto _L1 _L2 _L3
_L3:
        break MISSING_BLOCK_LABEL_138;
_L1:
        db.a(cy1, ct1.b);
_L5:
        cy1.m();
          goto _L4
_L2:
        if (ct1.b == 11)
        {
            ay1.a = cy1.z();
            ay1.a(true);
        } else
        {
            db.a(cy1, ct1.b);
        }
          goto _L5
        if (ct1.b == 10)
        {
            ay1.b = cy1.x();
            ay1.b(true);
        } else
        {
            db.a(cy1, ct1.b);
        }
          goto _L5
    }

    public volatile void a(cy cy1, bz bz)
    {
        a(cy1, (ay)bz);
    }

    public void b(cy cy1, ay ay1)
    {
        ay1.j();
        cy1.a(ay.k());
        if (ay1.a != null)
        {
            cy1.a(ay.l());
            cy1.a(ay1.a);
            cy1.c();
        }
        cy1.a(ay.m());
        cy1.a(ay1.b);
        cy1.c();
        cy1.d();
        cy1.b();
    }

    public volatile void b(cy cy1, bz bz)
    {
        b(cy1, (ay)bz);
    }
}
