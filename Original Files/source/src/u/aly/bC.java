// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;


// Referenced classes of package u.aly:
//            dj, de, aw, cy, 
//            bz

class bC extends dj
{

    private bC()
    {
    }

    bC(bC bc)
    {
        this();
    }

    public void a(cy cy, aw aw1)
    {
        de de1 = (de)cy;
        de1.a(aw1.a);
        de1.a(aw1.b);
        de1.a(aw1.c);
    }

    public void a(cy cy, bz bz)
    {
        b(cy, (aw)bz);
    }

    public void b(cy cy, aw aw1)
    {
        de de1 = (de)cy;
        aw1.a = de1.y();
        aw1.a(true);
        aw1.b = de1.y();
        aw1.b(true);
        aw1.c = de1.x();
        aw1.c(true);
    }

    public void b(cy cy, bz bz)
    {
        a(cy, (aw)bz);
    }
}
