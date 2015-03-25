// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;


// Referenced classes of package u.aly:
//            bo, bn, cO, bj, 
//            bm

public class bl extends bo
{

    private static final String a = u/aly/bl.getName();

    public bl()
    {
    }

    public bn.a a(bm bm)
    {
        bn bn1 = (bn)a(((bp) (bm)), u/aly/bn);
        if (bn1 == null)
        {
            return bn.a.b;
        } else
        {
            return bn1.a;
        }
    }

    public void a(bm bm, a a1)
    {
        (new cO(this, bm, a1)).execute(new Integer[0]);
_L1:
        return;
        Exception exception;
        exception;
        bj.b(a, "", exception);
        if (a1 != null)
        {
            a1.a(bn.a.b);
            return;
        }
          goto _L1
    }


    private class a
    {

        public abstract void a();

        public abstract void a(bn.a a1);
    }

}
