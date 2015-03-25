// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;


// Referenced classes of package android.support.v4.app:
//            v, FragmentActivity

class z
    implements Runnable
{

    final int a;
    final int b;
    final v c;

    z(v v1, int i, int j)
    {
        c = v1;
        a = i;
        b = j;
        super();
    }

    public void run()
    {
        c.a(c.t.d, null, a, b);
    }
}
