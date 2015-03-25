// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package u.aly:
//            bz, dd, ct, di, 
//            N, dj, P, cl, 
//            cm, cq, ba, cf, 
//            cs, dk, bw, cy, 
//            dh, dg, cg

public class ak
    implements Serializable, Cloneable, bz
{

    private static final ct A = new ct("os_version", (byte)11, (short)8);
    private static final ct B = new ct("resolution", (byte)12, (short)9);
    private static final ct C = new ct("is_jailbroken", (byte)2, (short)10);
    private static final ct D = new ct("is_pirated", (byte)2, (short)11);
    private static final ct E = new ct("device_board", (byte)11, (short)12);
    private static final ct F = new ct("device_brand", (byte)11, (short)13);
    private static final ct G = new ct("device_manutime", (byte)10, (short)14);
    private static final ct H = new ct("device_manufacturer", (byte)11, (short)15);
    private static final ct I = new ct("device_manuid", (byte)11, (short)16);
    private static final ct J = new ct("device_name", (byte)11, (short)17);
    private static final Map K;
    private static final int L = 0;
    private static final int M = 1;
    private static final int N = 2;
    public static final Map r;
    private static final dd s = new dd("DeviceInfo");
    private static final ct t = new ct("device_id", (byte)11, (short)1);
    private static final ct u = new ct("idmd5", (byte)11, (short)2);
    private static final ct v = new ct("mac_address", (byte)11, (short)3);
    private static final ct w = new ct("open_udid", (byte)11, (short)4);
    private static final ct x = new ct("model", (byte)11, (short)5);
    private static final ct y = new ct("cpu", (byte)11, (short)6);
    private static final ct z = new ct("os", (byte)11, (short)7);
    private byte O;
    private e P[];
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public ba i;
    public boolean j;
    public boolean k;
    public String l;
    public String m;
    public long n;
    public String o;
    public String p;
    public String q;

    public ak()
    {
        O = 0;
        e ae1[] = new e[17];
        ae1[0] = e.a;
        ae1[1] = e.b;
        ae1[2] = e.c;
        ae1[3] = e.d;
        ae1[4] = e.e;
        ae1[5] = e.f;
        ae1[6] = e.g;
        ae1[7] = e.h;
        ae1[8] = e.i;
        ae1[9] = e.j;
        ae1[10] = e.k;
        ae1[11] = e.l;
        ae1[12] = e.m;
        ae1[13] = e.n;
        ae1[14] = e.o;
        ae1[15] = e.p;
        ae1[16] = e.q;
        P = ae1;
    }

    public ak(ak ak1)
    {
        O = 0;
        e ae1[] = new e[17];
        ae1[0] = e.a;
        ae1[1] = e.b;
        ae1[2] = e.c;
        ae1[3] = e.d;
        ae1[4] = e.e;
        ae1[5] = e.f;
        ae1[6] = e.g;
        ae1[7] = e.h;
        ae1[8] = e.i;
        ae1[9] = e.j;
        ae1[10] = e.k;
        ae1[11] = e.l;
        ae1[12] = e.m;
        ae1[13] = e.n;
        ae1[14] = e.o;
        ae1[15] = e.p;
        ae1[16] = e.q;
        P = ae1;
        O = ak1.O;
        if (ak1.e())
        {
            a = ak1.a;
        }
        if (ak1.i())
        {
            b = ak1.b;
        }
        if (ak1.l())
        {
            c = ak1.c;
        }
        if (ak1.o())
        {
            d = ak1.d;
        }
        if (ak1.r())
        {
            e = ak1.e;
        }
        if (ak1.u())
        {
            f = ak1.f;
        }
        if (ak1.x())
        {
            g = ak1.g;
        }
        if (ak1.A())
        {
            h = ak1.h;
        }
        if (ak1.D())
        {
            i = new ba(ak1.i);
        }
        j = ak1.j;
        k = ak1.k;
        if (ak1.M())
        {
            l = ak1.l;
        }
        if (ak1.P())
        {
            m = ak1.m;
        }
        n = ak1.n;
        if (ak1.V())
        {
            o = ak1.o;
        }
        if (ak1.Y())
        {
            p = ak1.p;
        }
        if (ak1.ab())
        {
            q = ak1.q;
        }
    }

    private void a(ObjectInputStream objectinputstream)
    {
        try
        {
            O = 0;
            a(((cy) (new cs(new dk(objectinputstream)))));
            return;
        }
        catch (cf cf1)
        {
            throw new IOException(cf1.getMessage());
        }
    }

    private void a(ObjectOutputStream objectoutputstream)
    {
        try
        {
            b(new cs(new dk(objectoutputstream)));
            return;
        }
        catch (cf cf1)
        {
            throw new IOException(cf1.getMessage());
        }
    }

    static dd ad()
    {
        return s;
    }

    static ct ae()
    {
        return t;
    }

    static ct af()
    {
        return u;
    }

    static ct ag()
    {
        return v;
    }

    static ct ah()
    {
        return w;
    }

    static ct ai()
    {
        return x;
    }

    static ct aj()
    {
        return y;
    }

    static ct ak()
    {
        return z;
    }

    static ct al()
    {
        return A;
    }

    static ct am()
    {
        return B;
    }

    static ct an()
    {
        return C;
    }

    static ct ao()
    {
        return D;
    }

    static ct ap()
    {
        return E;
    }

    static ct aq()
    {
        return F;
    }

    static ct ar()
    {
        return G;
    }

    static ct as()
    {
        return H;
    }

    static ct at()
    {
        return I;
    }

    static ct au()
    {
        return J;
    }

    public boolean A()
    {
        return h != null;
    }

    public ba B()
    {
        return i;
    }

    public void C()
    {
        i = null;
    }

    public boolean D()
    {
        return i != null;
    }

    public boolean E()
    {
        return j;
    }

    public void F()
    {
        O = bw.b(O, 0);
    }

    public boolean G()
    {
        return bw.a(O, 0);
    }

    public boolean H()
    {
        return k;
    }

    public void I()
    {
        O = bw.b(O, 1);
    }

    public boolean J()
    {
        return bw.a(O, 1);
    }

    public String K()
    {
        return l;
    }

    public void L()
    {
        l = null;
    }

    public boolean M()
    {
        return l != null;
    }

    public String N()
    {
        return m;
    }

    public void O()
    {
        m = null;
    }

    public boolean P()
    {
        return m != null;
    }

    public long Q()
    {
        return n;
    }

    public void R()
    {
        O = bw.b(O, 2);
    }

    public boolean S()
    {
        return bw.a(O, 2);
    }

    public String T()
    {
        return o;
    }

    public void U()
    {
        o = null;
    }

    public boolean V()
    {
        return o != null;
    }

    public String W()
    {
        return p;
    }

    public void X()
    {
        p = null;
    }

    public boolean Y()
    {
        return p != null;
    }

    public String Z()
    {
        return q;
    }

    public e a(int i1)
    {
        return e.a(i1);
    }

    public ak a()
    {
        return new ak(this);
    }

    public ak a(long l1)
    {
        n = l1;
        p(true);
        return this;
    }

    public ak a(String s1)
    {
        a = s1;
        return this;
    }

    public ak a(ba ba1)
    {
        i = ba1;
        return this;
    }

    public void a(cy cy1)
    {
        ((dh)K.get(cy1.D())).b().a(cy1, this);
    }

    public void a(boolean flag)
    {
        if (!flag)
        {
            a = null;
        }
    }

    public void aa()
    {
        q = null;
    }

    public boolean ab()
    {
        return q != null;
    }

    public void ac()
    {
        if (i != null)
        {
            i.j();
        }
    }

    public ak b(String s1)
    {
        b = s1;
        return this;
    }

    public cg b(int i1)
    {
        return a(i1);
    }

    public void b()
    {
        a = null;
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        k(false);
        j = false;
        m(false);
        k = false;
        l = null;
        m = null;
        p(false);
        n = 0L;
        o = null;
        p = null;
        q = null;
    }

    public void b(cy cy1)
    {
        ((dh)K.get(cy1.D())).b().b(cy1, this);
    }

    public void b(boolean flag)
    {
        if (!flag)
        {
            b = null;
        }
    }

    public String c()
    {
        return a;
    }

    public ak c(String s1)
    {
        c = s1;
        return this;
    }

    public void c(boolean flag)
    {
        if (!flag)
        {
            c = null;
        }
    }

    public ak d(String s1)
    {
        d = s1;
        return this;
    }

    public void d()
    {
        a = null;
    }

    public void d(boolean flag)
    {
        if (!flag)
        {
            d = null;
        }
    }

    public ak e(String s1)
    {
        e = s1;
        return this;
    }

    public void e(boolean flag)
    {
        if (!flag)
        {
            e = null;
        }
    }

    public boolean e()
    {
        return a != null;
    }

    public String f()
    {
        return b;
    }

    public ak f(String s1)
    {
        f = s1;
        return this;
    }

    public void f(boolean flag)
    {
        if (!flag)
        {
            f = null;
        }
    }

    public ak g(String s1)
    {
        g = s1;
        return this;
    }

    public bz g()
    {
        return a();
    }

    public void g(boolean flag)
    {
        if (!flag)
        {
            g = null;
        }
    }

    public ak h(String s1)
    {
        h = s1;
        return this;
    }

    public void h()
    {
        b = null;
    }

    public void h(boolean flag)
    {
        if (!flag)
        {
            h = null;
        }
    }

    public ak i(String s1)
    {
        l = s1;
        return this;
    }

    public void i(boolean flag)
    {
        if (!flag)
        {
            i = null;
        }
    }

    public boolean i()
    {
        return b != null;
    }

    public String j()
    {
        return c;
    }

    public ak j(String s1)
    {
        m = s1;
        return this;
    }

    public ak j(boolean flag)
    {
        j = flag;
        k(true);
        return this;
    }

    public ak k(String s1)
    {
        o = s1;
        return this;
    }

    public void k()
    {
        c = null;
    }

    public void k(boolean flag)
    {
        O = bw.a(O, 0, flag);
    }

    public ak l(String s1)
    {
        p = s1;
        return this;
    }

    public ak l(boolean flag)
    {
        k = flag;
        m(true);
        return this;
    }

    public boolean l()
    {
        return c != null;
    }

    public String m()
    {
        return d;
    }

    public ak m(String s1)
    {
        q = s1;
        return this;
    }

    public void m(boolean flag)
    {
        O = bw.a(O, 1, flag);
    }

    public void n()
    {
        d = null;
    }

    public void n(boolean flag)
    {
        if (!flag)
        {
            l = null;
        }
    }

    public void o(boolean flag)
    {
        if (!flag)
        {
            m = null;
        }
    }

    public boolean o()
    {
        return d != null;
    }

    public String p()
    {
        return e;
    }

    public void p(boolean flag)
    {
        O = bw.a(O, 2, flag);
    }

    public void q()
    {
        e = null;
    }

    public void q(boolean flag)
    {
        if (!flag)
        {
            o = null;
        }
    }

    public void r(boolean flag)
    {
        if (!flag)
        {
            p = null;
        }
    }

    public boolean r()
    {
        return e != null;
    }

    public String s()
    {
        return f;
    }

    public void s(boolean flag)
    {
        if (!flag)
        {
            q = null;
        }
    }

    public void t()
    {
        f = null;
    }

    public String toString()
    {
        boolean flag = false;
        StringBuilder stringbuilder = new StringBuilder("DeviceInfo(");
        boolean flag1 = true;
        if (e())
        {
            stringbuilder.append("device_id:");
            if (a == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(a);
            }
            flag1 = false;
        }
        if (i())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("idmd5:");
            if (b == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(b);
            }
            flag1 = false;
        }
        if (l())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("mac_address:");
            if (c == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(c);
            }
            flag1 = false;
        }
        if (o())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("open_udid:");
            if (d == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(d);
            }
            flag1 = false;
        }
        if (r())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("model:");
            if (e == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(e);
            }
            flag1 = false;
        }
        if (u())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("cpu:");
            if (f == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(f);
            }
            flag1 = false;
        }
        if (x())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("os:");
            if (g == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(g);
            }
            flag1 = false;
        }
        if (A())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("os_version:");
            if (h == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(h);
            }
            flag1 = false;
        }
        if (D())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("resolution:");
            if (i == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(i);
            }
            flag1 = false;
        }
        if (G())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("is_jailbroken:");
            stringbuilder.append(j);
            flag1 = false;
        }
        if (J())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("is_pirated:");
            stringbuilder.append(k);
            flag1 = false;
        }
        if (M())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("device_board:");
            if (l == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(l);
            }
            flag1 = false;
        }
        if (P())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("device_brand:");
            if (m == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(m);
            }
            flag1 = false;
        }
        if (S())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("device_manutime:");
            stringbuilder.append(n);
            flag1 = false;
        }
        if (V())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("device_manufacturer:");
            if (o == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(o);
            }
            flag1 = false;
        }
        if (Y())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("device_manuid:");
            if (p == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(p);
                flag = false;
            }
        } else
        {
            flag = flag1;
        }
        if (ab())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("device_name:");
            if (q == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(q);
            }
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public boolean u()
    {
        return f != null;
    }

    public String v()
    {
        return g;
    }

    public void w()
    {
        g = null;
    }

    public boolean x()
    {
        return g != null;
    }

    public String y()
    {
        return h;
    }

    public void z()
    {
        h = null;
    }

    static 
    {
        K = new HashMap();
        K.put(u/aly/di, new N(null));
        K.put(u/aly/dj, new P(null));
        EnumMap enummap = new EnumMap(u/aly/ak$e);
        enummap.put(e.a, new cl("device_id", (byte)2, new cm((byte)11)));
        enummap.put(e.b, new cl("idmd5", (byte)2, new cm((byte)11)));
        enummap.put(e.c, new cl("mac_address", (byte)2, new cm((byte)11)));
        enummap.put(e.d, new cl("open_udid", (byte)2, new cm((byte)11)));
        enummap.put(e.e, new cl("model", (byte)2, new cm((byte)11)));
        enummap.put(e.f, new cl("cpu", (byte)2, new cm((byte)11)));
        enummap.put(e.g, new cl("os", (byte)2, new cm((byte)11)));
        enummap.put(e.h, new cl("os_version", (byte)2, new cm((byte)11)));
        enummap.put(e.i, new cl("resolution", (byte)2, new cq((byte)12, u/aly/ba)));
        enummap.put(e.j, new cl("is_jailbroken", (byte)2, new cm((byte)2)));
        enummap.put(e.k, new cl("is_pirated", (byte)2, new cm((byte)2)));
        enummap.put(e.l, new cl("device_board", (byte)2, new cm((byte)11)));
        enummap.put(e.m, new cl("device_brand", (byte)2, new cm((byte)11)));
        enummap.put(e.n, new cl("device_manutime", (byte)2, new cm((byte)10)));
        enummap.put(e.o, new cl("device_manufacturer", (byte)2, new cm((byte)11)));
        enummap.put(e.p, new cl("device_manuid", (byte)2, new cm((byte)11)));
        enummap.put(e.q, new cl("device_name", (byte)2, new cm((byte)11)));
        r = Collections.unmodifiableMap(enummap);
        cl.a(u/aly/ak, r);
    }

    private class e extends Enum
        implements cg
    {

        public static final e a;
        public static final e b;
        public static final e c;
        public static final e d;
        public static final e e;
        public static final e f;
        public static final e g;
        public static final e h;
        public static final e i;
        public static final e j;
        public static final e k;
        public static final e l;
        public static final e m;
        public static final e n;
        public static final e o;
        public static final e p;
        public static final e q;
        private static final Map r;
        private static final e u[];
        private final short s;
        private final String t;

        public static e a(int i1)
        {
            switch (i1)
            {
            default:
                return null;

            case 1: // '\001'
                return a;

            case 2: // '\002'
                return b;

            case 3: // '\003'
                return c;

            case 4: // '\004'
                return d;

            case 5: // '\005'
                return e;

            case 6: // '\006'
                return f;

            case 7: // '\007'
                return g;

            case 8: // '\b'
                return h;

            case 9: // '\t'
                return i;

            case 10: // '\n'
                return j;

            case 11: // '\013'
                return k;

            case 12: // '\f'
                return l;

            case 13: // '\r'
                return m;

            case 14: // '\016'
                return n;

            case 15: // '\017'
                return o;

            case 16: // '\020'
                return p;

            case 17: // '\021'
                return q;
            }
        }

        public static e a(String s1)
        {
            return (e)r.get(s1);
        }

        public static e b(int i1)
        {
            e e1 = a(i1);
            if (e1 == null)
            {
                throw new IllegalArgumentException((new StringBuilder("Field ")).append(i1).append(" doesn't exist!").toString());
            } else
            {
                return e1;
            }
        }

        public static e valueOf(String s1)
        {
            return (e)Enum.valueOf(u/aly/ak$e, s1);
        }

        public static e[] values()
        {
            e ae1[] = u;
            int i1 = ae1.length;
            e ae2[] = new e[i1];
            System.arraycopy(ae1, 0, ae2, 0, i1);
            return ae2;
        }

        public short a()
        {
            return s;
        }

        public String b()
        {
            return t;
        }

        static 
        {
            a = new e("DEVICE_ID", 0, (short)1, "device_id");
            b = new e("IDMD5", 1, (short)2, "idmd5");
            c = new e("MAC_ADDRESS", 2, (short)3, "mac_address");
            d = new e("OPEN_UDID", 3, (short)4, "open_udid");
            e = new e("MODEL", 4, (short)5, "model");
            f = new e("CPU", 5, (short)6, "cpu");
            g = new e("OS", 6, (short)7, "os");
            h = new e("OS_VERSION", 7, (short)8, "os_version");
            i = new e("RESOLUTION", 8, (short)9, "resolution");
            j = new e("IS_JAILBROKEN", 9, (short)10, "is_jailbroken");
            k = new e("IS_PIRATED", 10, (short)11, "is_pirated");
            l = new e("DEVICE_BOARD", 11, (short)12, "device_board");
            m = new e("DEVICE_BRAND", 12, (short)13, "device_brand");
            n = new e("DEVICE_MANUTIME", 13, (short)14, "device_manutime");
            o = new e("DEVICE_MANUFACTURER", 14, (short)15, "device_manufacturer");
            p = new e("DEVICE_MANUID", 15, (short)16, "device_manuid");
            q = new e("DEVICE_NAME", 16, (short)17, "device_name");
            e ae1[] = new e[17];
            ae1[0] = a;
            ae1[1] = b;
            ae1[2] = c;
            ae1[3] = d;
            ae1[4] = e;
            ae1[5] = f;
            ae1[6] = g;
            ae1[7] = h;
            ae1[8] = i;
            ae1[9] = j;
            ae1[10] = k;
            ae1[11] = l;
            ae1[12] = m;
            ae1[13] = n;
            ae1[14] = o;
            ae1[15] = p;
            ae1[16] = q;
            u = ae1;
            r = new HashMap();
            Iterator iterator = EnumSet.allOf(u/aly/ak$e).iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    return;
                }
                e e1 = (e)iterator.next();
                r.put(e1.b(), e1);
            } while (true);
        }

        private e(String s1, int i1, short word0, String s2)
        {
            super(s1, i1);
            s = word0;
            t = s2;
        }
    }

}
