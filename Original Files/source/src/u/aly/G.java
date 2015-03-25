// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.util.BitSet;

// Referenced classes of package u.aly:
//            dj, de, ai, bc, 
//            cy, bz

class G extends dj
{

    private G()
    {
    }

    G(G g)
    {
        this();
    }

    public void a(cy cy, ai ai1)
    {
        de de1 = (de)cy;
        de1.a(ai1.a);
        de1.a(ai1.e.a());
        de1.a(ai1.f);
        de1.a(ai1.g);
        BitSet bitset = new BitSet();
        if (ai1.i())
        {
            bitset.set(0);
        }
        if (ai1.l())
        {
            bitset.set(1);
        }
        if (ai1.o())
        {
            bitset.set(2);
        }
        if (ai1.A())
        {
            bitset.set(3);
        }
        if (ai1.D())
        {
            bitset.set(4);
        }
        if (ai1.G())
        {
            bitset.set(5);
        }
        de1.a(bitset, 6);
        if (ai1.i())
        {
            de1.a(ai1.b);
        }
        if (ai1.l())
        {
            de1.a(ai1.c);
        }
        if (ai1.o())
        {
            de1.a(ai1.d);
        }
        if (ai1.A())
        {
            de1.a(ai1.h);
        }
        if (ai1.D())
        {
            de1.a(ai1.i);
        }
        if (ai1.G())
        {
            de1.a(ai1.j);
        }
    }

    public void a(cy cy, bz bz)
    {
        b(cy, (ai)bz);
    }

    public void b(cy cy, ai ai1)
    {
        de de1 = (de)cy;
        ai1.a = de1.z();
        ai1.a(true);
        ai1.e = bc.a(de1.w());
        ai1.e(true);
        ai1.f = de1.z();
        ai1.f(true);
        ai1.g = de1.z();
        ai1.g(true);
        BitSet bitset = de1.b(6);
        if (bitset.get(0))
        {
            ai1.b = de1.z();
            ai1.b(true);
        }
        if (bitset.get(1))
        {
            ai1.c = de1.w();
            ai1.c(true);
        }
        if (bitset.get(2))
        {
            ai1.d = de1.z();
            ai1.d(true);
        }
        if (bitset.get(3))
        {
            ai1.h = de1.z();
            ai1.h(true);
        }
        if (bitset.get(4))
        {
            ai1.i = de1.z();
            ai1.i(true);
        }
        if (bitset.get(5))
        {
            ai1.j = de1.w();
            ai1.j(true);
        }
    }

    public void b(cy cy, bz bz)
    {
        a(cy, (ai)bz);
    }
}
