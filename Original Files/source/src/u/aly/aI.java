// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;


// Referenced classes of package u.aly:
//            dj, de, ar, cy, 
//            bz

class aI extends dj
{

    private aI()
    {
    }

    aI(aI ai)
    {
        this();
    }

    public void a(cy cy, ar ar1)
    {
        de de1 = (de)cy;
        de1.a(ar1.a);
        de1.a(ar1.b);
        de1.a(ar1.c);
    }

    public void a(cy cy, bz bz)
    {
        b(cy, (ar)bz);
    }

    public void b(cy cy, ar ar1)
    {
        de de1 = (de)cy;
        ar1.a = de1.z();
        ar1.a(true);
        ar1.b = de1.x();
        ar1.b(true);
        ar1.c = de1.w();
        ar1.c(true);
    }

    public void b(cy cy, bz bz)
    {
        a(cy, (ar)bz);
    }
}
