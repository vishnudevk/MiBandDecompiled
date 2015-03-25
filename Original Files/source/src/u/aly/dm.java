// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;


// Referenced classes of package u.aly:
//            dn

public abstract class dm
{

    public dm()
    {
    }

    public abstract int a(byte abyte0[], int j, int k);

    public void a(int j)
    {
    }

    public abstract boolean a();

    public abstract void b();

    public void b(byte abyte0[])
    {
        b(abyte0, 0, abyte0.length);
    }

    public abstract void b(byte abyte0[], int j, int k);

    public abstract void c();

    public int d(byte abyte0[], int j, int k)
    {
        int l = 0;
        do
        {
            if (l >= k)
            {
                return l;
            }
            int i1 = a(abyte0, j + l, k - l);
            if (i1 <= 0)
            {
                throw new dn((new StringBuilder("Cannot read. Remote side has closed. Tried to read ")).append(k).append(" bytes, but only got ").append(l).append(" bytes. (This is often indicative of an internal error on the server side. Please check your server logs.)").toString());
            }
            l += i1;
        } while (true);
    }

    public void d()
    {
    }

    public byte[] f()
    {
        return null;
    }

    public int g()
    {
        return 0;
    }

    public int h()
    {
        return -1;
    }

    public boolean i()
    {
        return a();
    }
}
