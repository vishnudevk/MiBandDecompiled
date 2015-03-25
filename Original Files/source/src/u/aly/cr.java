// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

// Referenced classes of package u.aly:
//            cy, dd, dm, cf, 
//            ct, cu, cv, cw, 
//            dc, cz

public class cr extends cy
{

    protected static final int a = 0xffff0000;
    protected static final int b = 0x80010000;
    private static final dd h = new dd();
    protected boolean c;
    protected boolean d;
    protected int e;
    protected boolean f;
    private byte i[];
    private byte j[];
    private byte k[];
    private byte l[];
    private byte m[];
    private byte n[];
    private byte o[];
    private byte p[];

    public cr(dm dm1)
    {
        this(dm1, false, true);
    }

    public cr(dm dm1, boolean flag, boolean flag1)
    {
        super(dm1);
        c = false;
        d = true;
        f = false;
        i = new byte[1];
        j = new byte[2];
        k = new byte[4];
        l = new byte[8];
        m = new byte[1];
        n = new byte[2];
        o = new byte[4];
        p = new byte[8];
        c = flag;
        d = flag1;
    }

    private int a(byte abyte0[], int i1, int j1)
    {
        d(j1);
        return g.d(abyte0, i1, j1);
    }

    public ByteBuffer A()
    {
        int i1 = w();
        d(i1);
        if (g.h() >= i1)
        {
            ByteBuffer bytebuffer = ByteBuffer.wrap(g.f(), g.g(), i1);
            g.a(i1);
            return bytebuffer;
        } else
        {
            byte abyte0[] = new byte[i1];
            g.d(abyte0, 0, i1);
            return ByteBuffer.wrap(abyte0);
        }
    }

    public void a()
    {
    }

    public void a(byte byte0)
    {
        i[0] = byte0;
        g.b(i, 0, 1);
    }

    public void a(double d1)
    {
        a(Double.doubleToLongBits(d1));
    }

    public void a(int i1)
    {
        k[0] = (byte)(0xff & i1 >> 24);
        k[1] = (byte)(0xff & i1 >> 16);
        k[2] = (byte)(0xff & i1 >> 8);
        k[3] = (byte)(i1 & 0xff);
        g.b(k, 0, 4);
    }

    public void a(long l1)
    {
        l[0] = (byte)(int)(255L & l1 >> 56);
        l[1] = (byte)(int)(255L & l1 >> 48);
        l[2] = (byte)(int)(255L & l1 >> 40);
        l[3] = (byte)(int)(255L & l1 >> 32);
        l[4] = (byte)(int)(255L & l1 >> 24);
        l[5] = (byte)(int)(255L & l1 >> 16);
        l[6] = (byte)(int)(255L & l1 >> 8);
        l[7] = (byte)(int)(255L & l1);
        g.b(l, 0, 8);
    }

    public void a(String s1)
    {
        try
        {
            byte abyte0[] = s1.getBytes("UTF-8");
            a(abyte0.length);
            g.b(abyte0, 0, abyte0.length);
            return;
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new cf("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public void a(ByteBuffer bytebuffer)
    {
        int i1 = bytebuffer.limit() - bytebuffer.position();
        a(i1);
        g.b(bytebuffer.array(), bytebuffer.position() + bytebuffer.arrayOffset(), i1);
    }

    public void a(ct ct1)
    {
        a(ct1.b);
        a(ct1.c);
    }

    public void a(cu cu1)
    {
        a(cu1.a);
        a(cu1.b);
    }

    public void a(cv cv1)
    {
        a(cv1.a);
        a(cv1.b);
        a(cv1.c);
    }

    public void a(cw cw1)
    {
        if (d)
        {
            a(0x80010000 | cw1.b);
            a(cw1.a);
            a(cw1.c);
            return;
        } else
        {
            a(cw1.a);
            a(cw1.b);
            a(cw1.c);
            return;
        }
    }

    public void a(dc dc1)
    {
        a(dc1.a);
        a(dc1.b);
    }

    public void a(dd dd1)
    {
    }

    public void a(short word0)
    {
        j[0] = (byte)(0xff & word0 >> 8);
        j[1] = (byte)(word0 & 0xff);
        g.b(j, 0, 2);
    }

    public void a(boolean flag)
    {
        byte byte0;
        if (flag)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        a(byte0);
    }

    public String b(int i1)
    {
        String s1;
        try
        {
            d(i1);
            byte abyte0[] = new byte[i1];
            g.d(abyte0, 0, i1);
            s1 = new String(abyte0, "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new cf("JVM DOES NOT SUPPORT UTF-8");
        }
        return s1;
    }

    public void b()
    {
    }

    public void c()
    {
    }

    public void c(int i1)
    {
        e = i1;
        f = true;
    }

    public void d()
    {
        a((byte)0);
    }

    protected void d(int i1)
    {
        if (i1 < 0)
        {
            throw new cz((new StringBuilder("Negative length: ")).append(i1).toString());
        }
        if (f)
        {
            e = e - i1;
            if (e < 0)
            {
                throw new cz((new StringBuilder("Message length exceeded: ")).append(i1).toString());
            }
        }
    }

    public void e()
    {
    }

    public void f()
    {
    }

    public void g()
    {
    }

    public cw h()
    {
        int i1 = w();
        if (i1 < 0)
        {
            if ((0xffff0000 & i1) != 0x80010000)
            {
                throw new cz(4, "Bad version in readMessageBegin");
            } else
            {
                return new cw(z(), (byte)(i1 & 0xff), w());
            }
        }
        if (c)
        {
            throw new cz(4, "Missing version in readMessageBegin, old client?");
        } else
        {
            return new cw(b(i1), u(), w());
        }
    }

    public void i()
    {
    }

    public dd j()
    {
        return h;
    }

    public void k()
    {
    }

    public ct l()
    {
        byte byte0 = u();
        short word0;
        if (byte0 == 0)
        {
            word0 = 0;
        } else
        {
            word0 = v();
        }
        return new ct("", byte0, word0);
    }

    public void m()
    {
    }

    public cv n()
    {
        return new cv(u(), u(), w());
    }

    public void o()
    {
    }

    public cu p()
    {
        return new cu(u(), w());
    }

    public void q()
    {
    }

    public dc r()
    {
        return new dc(u(), w());
    }

    public void s()
    {
    }

    public boolean t()
    {
        return u() == 1;
    }

    public byte u()
    {
        if (g.h() >= 1)
        {
            byte byte0 = g.f()[g.g()];
            g.a(1);
            return byte0;
        } else
        {
            a(m, 0, 1);
            return m[0];
        }
    }

    public short v()
    {
        byte abyte0[] = n;
        int i1;
        if (g.h() >= 2)
        {
            abyte0 = g.f();
            i1 = g.g();
            g.a(2);
        } else
        {
            a(n, 0, 2);
            i1 = 0;
        }
        return (short)((0xff & abyte0[i1]) << 8 | 0xff & abyte0[i1 + 1]);
    }

    public int w()
    {
        byte abyte0[] = o;
        int i1;
        if (g.h() >= 4)
        {
            abyte0 = g.f();
            i1 = g.g();
            g.a(4);
        } else
        {
            a(o, 0, 4);
            i1 = 0;
        }
        return (0xff & abyte0[i1]) << 24 | (0xff & abyte0[i1 + 1]) << 16 | (0xff & abyte0[i1 + 2]) << 8 | 0xff & abyte0[i1 + 3];
    }

    public long x()
    {
        byte abyte0[] = p;
        int i1;
        if (g.h() >= 8)
        {
            abyte0 = g.f();
            i1 = g.g();
            g.a(8);
        } else
        {
            a(p, 0, 8);
            i1 = 0;
        }
        return (long)(0xff & abyte0[i1]) << 56 | (long)(0xff & abyte0[i1 + 1]) << 48 | (long)(0xff & abyte0[i1 + 2]) << 40 | (long)(0xff & abyte0[i1 + 3]) << 32 | (long)(0xff & abyte0[i1 + 4]) << 24 | (long)(0xff & abyte0[i1 + 5]) << 16 | (long)(0xff & abyte0[i1 + 6]) << 8 | (long)(0xff & abyte0[i1 + 7]);
    }

    public double y()
    {
        return Double.longBitsToDouble(x());
    }

    public String z()
    {
        int i1 = w();
        if (g.h() >= i1)
        {
            String s1;
            try
            {
                s1 = new String(g.f(), g.g(), i1, "UTF-8");
                g.a(i1);
            }
            catch (UnsupportedEncodingException unsupportedencodingexception)
            {
                throw new cf("JVM DOES NOT SUPPORT UTF-8");
            }
            return s1;
        } else
        {
            return b(i1);
        }
    }

}
