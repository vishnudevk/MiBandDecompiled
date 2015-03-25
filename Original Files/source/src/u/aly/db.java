// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;


// Referenced classes of package u.aly:
//            cf, cy, ct, cv, 
//            dc, cu, da

public class db
{

    private static int a = 0x7fffffff;

    public db()
    {
    }

    public static da a(byte abyte0[], da da)
    {
        if (abyte0[0] > 16)
        {
            da = new cs.a();
        } else
        if (abyte0.length > 1 && (0x80 & abyte0[1]) != 0)
        {
            return new cs.a();
        }
        return da;
    }

    public static void a(int i)
    {
        a = i;
    }

    public static void a(cy cy1, byte byte0)
    {
        a(cy1, byte0, a);
    }

    public static void a(cy cy1, byte byte0, int i)
    {
        int j = 0;
        if (i <= 0)
        {
            throw new cf("Maximum skip depth exceeded");
        }
        cu cu1;
        switch (byte0)
        {
        case 5: // '\005'
        case 7: // '\007'
        case 9: // '\t'
        default:
            return;

        case 2: // '\002'
            cy1.t();
            return;

        case 3: // '\003'
            cy1.u();
            return;

        case 6: // '\006'
            cy1.v();
            return;

        case 8: // '\b'
            cy1.w();
            return;

        case 10: // '\n'
            cy1.x();
            return;

        case 4: // '\004'
            cy1.y();
            return;

        case 11: // '\013'
            cy1.A();
            return;

        case 12: // '\f'
            cy1.j();
            do
            {
                ct ct1 = cy1.l();
                if (ct1.b == 0)
                {
                    cy1.k();
                    return;
                }
                a(cy1, ct1.b, i - 1);
                cy1.m();
            } while (true);

        case 13: // '\r'
            cv cv1 = cy1.n();
            do
            {
                if (j >= cv1.c)
                {
                    cy1.o();
                    return;
                }
                a(cy1, cv1.a, i - 1);
                a(cy1, cv1.b, i - 1);
                j++;
            } while (true);

        case 14: // '\016'
            dc dc1 = cy1.r();
            do
            {
                if (j >= dc1.b)
                {
                    cy1.s();
                    return;
                }
                a(cy1, dc1.a, i - 1);
                j++;
            } while (true);

        case 15: // '\017'
            cu1 = cy1.p();
            break;
        }
        do
        {
            if (j >= cu1.b)
            {
                cy1.q();
                return;
            }
            a(cy1, cu1.a, i - 1);
            j++;
        } while (true);
    }

}
