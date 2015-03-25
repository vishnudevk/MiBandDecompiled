// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;


// Referenced classes of package u.aly:
//            cf, dd, ct, cy, 
//            db

public class by extends cf
{

    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    public static final int g = 6;
    public static final int h = 7;
    private static final dd j = new dd("TApplicationException");
    private static final ct k = new ct("message", (byte)11, (short)1);
    private static final ct l = new ct("type", (byte)8, (short)2);
    private static final long m = 1L;
    protected int i;

    public by()
    {
        i = 0;
    }

    public by(int i1)
    {
        i = 0;
        i = i1;
    }

    public by(int i1, String s)
    {
        super(s);
        i = 0;
        i = i1;
    }

    public by(String s)
    {
        super(s);
        i = 0;
    }

    public static by a(cy cy1)
    {
        String s;
        int i1;
        cy1.j();
        s = null;
        i1 = 0;
_L2:
        ct ct1;
        ct1 = cy1.l();
        if (ct1.b == 0)
        {
            cy1.k();
            return new by(i1, s);
        }
        switch (ct1.c)
        {
        default:
            db.a(cy1, ct1.b);
            break;

        case 1: // '\001'
            break; /* Loop/switch isn't completed */

        case 2: // '\002'
            break MISSING_BLOCK_LABEL_110;
        }
_L3:
        cy1.m();
        if (true) goto _L2; else goto _L1
_L1:
        if (ct1.b == 11)
        {
            s = cy1.z();
        } else
        {
            db.a(cy1, ct1.b);
        }
          goto _L3
        if (ct1.b == 8)
        {
            i1 = cy1.w();
        } else
        {
            db.a(cy1, ct1.b);
        }
          goto _L3
    }

    public int a()
    {
        return i;
    }

    public void b(cy cy1)
    {
        cy1.a(j);
        if (getMessage() != null)
        {
            cy1.a(k);
            cy1.a(getMessage());
            cy1.c();
        }
        cy1.a(l);
        cy1.a(i);
        cy1.c();
        cy1.d();
        cy1.b();
    }

}
