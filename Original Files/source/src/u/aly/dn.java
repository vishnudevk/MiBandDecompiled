// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;


// Referenced classes of package u.aly:
//            cf

public class dn extends cf
{

    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    private static final long g = 1L;
    protected int f;

    public dn()
    {
        f = 0;
    }

    public dn(int i)
    {
        f = 0;
        f = i;
    }

    public dn(int i, String s)
    {
        super(s);
        f = 0;
        f = i;
    }

    public dn(int i, String s, Throwable throwable)
    {
        super(s, throwable);
        f = 0;
        f = i;
    }

    public dn(int i, Throwable throwable)
    {
        super(throwable);
        f = 0;
        f = i;
    }

    public dn(String s)
    {
        super(s);
        f = 0;
    }

    public dn(String s, Throwable throwable)
    {
        super(s, throwable);
        f = 0;
    }

    public dn(Throwable throwable)
    {
        super(throwable);
        f = 0;
    }

    public int a()
    {
        return f;
    }
}
