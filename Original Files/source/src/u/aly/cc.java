// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

// Referenced classes of package u.aly:
//            dl, da, cy, ct, 
//            cf, cg, db, bz

public class cc
{

    private final cy a;
    private final dl b;

    public cc()
    {
        this(((da) (new cs.a())));
    }

    public cc(da da1)
    {
        b = new dl();
        a = da1.a(b);
    }

    private transient Object a(byte byte0, byte abyte0[], cg cg1, cg acg[])
    {
        ct ct1 = j(abyte0, cg1, acg);
        if (ct1 == null) goto _L2; else goto _L1
_L1:
        byte0;
        JVM INSTR lookupswitch 8: default 92
    //                   2: 108
    //                   3: 146
    //                   4: 184
    //                   6: 222
    //                   8: 261
    //                   10: 300
    //                   11: 339
    //                   100: 375;
           goto _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L2:
        b.e();
        a.B();
        return null;
_L3:
        if (ct1.b != 2) goto _L2; else goto _L11
_L11:
        Boolean boolean1 = Boolean.valueOf(a.t());
        b.e();
        a.B();
        return boolean1;
_L4:
        if (ct1.b != 3) goto _L2; else goto _L12
_L12:
        Byte byte1 = Byte.valueOf(a.u());
        b.e();
        a.B();
        return byte1;
_L5:
        if (ct1.b != 4) goto _L2; else goto _L13
_L13:
        Double double1 = Double.valueOf(a.y());
        b.e();
        a.B();
        return double1;
_L6:
        if (ct1.b != 6) goto _L2; else goto _L14
_L14:
        Short short1 = Short.valueOf(a.v());
        b.e();
        a.B();
        return short1;
_L7:
        if (ct1.b != 8) goto _L2; else goto _L15
_L15:
        Integer integer = Integer.valueOf(a.w());
        b.e();
        a.B();
        return integer;
_L8:
        if (ct1.b != 10) goto _L2; else goto _L16
_L16:
        Long long1 = Long.valueOf(a.x());
        b.e();
        a.B();
        return long1;
_L9:
        if (ct1.b != 11) goto _L2; else goto _L17
_L17:
        String s = a.z();
        b.e();
        a.B();
        return s;
_L10:
        if (ct1.b != 11) goto _L2; else goto _L18
_L18:
        ByteBuffer bytebuffer = a.A();
        b.e();
        a.B();
        return bytebuffer;
        Exception exception1;
        exception1;
        throw new cf(exception1);
        Exception exception;
        exception;
        b.e();
        a.B();
        throw exception;
    }

    private transient ct j(byte abyte0[], cg cg1, cg acg[])
    {
        int k;
        cg acg1[];
        int l;
        k = 0;
        b.a(abyte0);
        acg1 = new cg[1 + acg.length];
        acg1[0] = cg1;
        l = 0;
_L5:
        if (l < acg.length) goto _L2; else goto _L1
_L1:
        ct ct1;
        a.j();
        ct1 = null;
_L9:
        if (k < acg1.length) goto _L4; else goto _L3
_L3:
        ct ct2 = ct1;
_L7:
        return ct2;
_L2:
        acg1[l + 1] = acg[l];
        l++;
          goto _L5
_L4:
        byte byte0;
        ct1 = a.l();
        byte0 = ct1.b;
        ct2 = null;
        if (byte0 == 0) goto _L7; else goto _L6
_L6:
        short word0;
        short word1;
        word0 = ct1.c;
        word1 = acg1[k].a();
        ct2 = null;
        if (word0 > word1) goto _L7; else goto _L8
_L8:
        if (ct1.c != acg1[k].a())
        {
            db.a(a, ct1.b);
            a.m();
        } else
        if (++k < acg1.length)
        {
            a.j();
        }
          goto _L9
    }

    public transient Boolean a(byte abyte0[], cg cg1, cg acg[])
    {
        return (Boolean)a((byte)2, abyte0, cg1, acg);
    }

    public void a(bz bz1, String s)
    {
        a(bz1, s.getBytes());
    }

    public void a(bz bz1, String s, String s1)
    {
        a(bz1, s.getBytes(s1));
        a.B();
        return;
        UnsupportedEncodingException unsupportedencodingexception;
        unsupportedencodingexception;
        throw new cf((new StringBuilder("JVM DOES NOT SUPPORT ENCODING: ")).append(s1).toString());
        Exception exception;
        exception;
        a.B();
        throw exception;
    }

    public void a(bz bz1, byte abyte0[])
    {
        b.a(abyte0);
        bz1.a(a);
        b.e();
        a.B();
        return;
        Exception exception;
        exception;
        b.e();
        a.B();
        throw exception;
    }

    public transient void a(bz bz1, byte abyte0[], cg cg1, cg acg[])
    {
        if (j(abyte0, cg1, acg) != null)
        {
            bz1.a(a);
        }
        b.e();
        a.B();
        return;
        Exception exception1;
        exception1;
        throw new cf(exception1);
        Exception exception;
        exception;
        b.e();
        a.B();
        throw exception;
    }

    public transient Byte b(byte abyte0[], cg cg1, cg acg[])
    {
        return (Byte)a((byte)3, abyte0, cg1, acg);
    }

    public transient Double c(byte abyte0[], cg cg1, cg acg[])
    {
        return (Double)a((byte)4, abyte0, cg1, acg);
    }

    public transient Short d(byte abyte0[], cg cg1, cg acg[])
    {
        return (Short)a((byte)6, abyte0, cg1, acg);
    }

    public transient Integer e(byte abyte0[], cg cg1, cg acg[])
    {
        return (Integer)a((byte)8, abyte0, cg1, acg);
    }

    public transient Long f(byte abyte0[], cg cg1, cg acg[])
    {
        return (Long)a((byte)10, abyte0, cg1, acg);
    }

    public transient String g(byte abyte0[], cg cg1, cg acg[])
    {
        return (String)a((byte)11, abyte0, cg1, acg);
    }

    public transient ByteBuffer h(byte abyte0[], cg cg1, cg acg[])
    {
        return (ByteBuffer)a((byte)100, abyte0, cg1, acg);
    }

    public transient Short i(byte abyte0[], cg cg1, cg acg[])
    {
        Short short1;
        if (j(abyte0, cg1, acg) == null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        a.j();
        short1 = Short.valueOf(a.l().c);
        b.e();
        a.B();
        return short1;
        b.e();
        a.B();
        return null;
        Exception exception1;
        exception1;
        throw new cf(exception1);
        Exception exception;
        exception;
        b.e();
        a.B();
        throw exception;
    }
}
