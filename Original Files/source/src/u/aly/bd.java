// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package u.aly:
//            bz, dd, ct, di, 
//            bV, dj, bX, cl, 
//            cm, cn, cq, ay, 
//            aw, be, cf, cs, 
//            dk, cz, cy, dh, 
//            dg, bw, cg

public class bd
    implements Serializable, Cloneable, bz
{

    public static final Map h;
    private static final dd i = new dd("Session");
    private static final ct j = new ct("id", (byte)11, (short)1);
    private static final ct k = new ct("start_time", (byte)10, (short)2);
    private static final ct l = new ct("end_time", (byte)10, (short)3);
    private static final ct m = new ct("duration", (byte)10, (short)4);
    private static final ct n = new ct("pages", (byte)15, (short)5);
    private static final ct o = new ct("locations", (byte)15, (short)6);
    private static final ct p = new ct("traffic", (byte)12, (short)7);
    private static final Map q;
    private static final int r = 0;
    private static final int s = 1;
    private static final int t = 2;
    public String a;
    public long b;
    public long c;
    public long d;
    public List e;
    public List f;
    public be g;
    private byte u;
    private e v[];

    public bd()
    {
        u = 0;
        e ae[] = new e[3];
        ae[0] = e.e;
        ae[1] = e.f;
        ae[2] = e.g;
        v = ae;
    }

    public bd(String s1, long l1, long l2, long l3)
    {
        this();
        a = s1;
        b = l1;
        b(true);
        c = l2;
        c(true);
        d = l3;
        d(true);
    }

    public bd(bd bd1)
    {
        u = 0;
        e ae[] = new e[3];
        ae[0] = e.e;
        ae[1] = e.f;
        ae[2] = e.g;
        v = ae;
        u = bd1.u;
        if (bd1.e())
        {
            a = bd1.a;
        }
        b = bd1.b;
        c = bd1.c;
        d = bd1.d;
        if (!bd1.t()) goto _L2; else goto _L1
_L1:
        ArrayList arraylist;
        Iterator iterator;
        arraylist = new ArrayList();
        iterator = bd1.e.iterator();
_L6:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        e = arraylist;
_L2:
        if (bd1.y())
        {
            ArrayList arraylist1 = new ArrayList();
            for (Iterator iterator1 = bd1.f.iterator(); iterator1.hasNext(); arraylist1.add(new aw((aw)iterator1.next())))
            {
                break MISSING_BLOCK_LABEL_218;
            }

            f = arraylist1;
        }
        if (bd1.B())
        {
            g = new be(bd1.g);
        }
        return;
_L4:
        arraylist.add(new ay((ay)iterator.next()));
        if (true) goto _L6; else goto _L5
_L5:
    }

    static dd D()
    {
        return i;
    }

    static ct E()
    {
        return j;
    }

    static ct F()
    {
        return k;
    }

    static ct G()
    {
        return l;
    }

    static ct H()
    {
        return m;
    }

    static ct I()
    {
        return n;
    }

    static ct J()
    {
        return o;
    }

    static ct K()
    {
        return p;
    }

    private void a(ObjectInputStream objectinputstream)
    {
        try
        {
            u = 0;
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

    public void A()
    {
        g = null;
    }

    public boolean B()
    {
        return g != null;
    }

    public void C()
    {
        if (a == null)
        {
            throw new cz((new StringBuilder("Required field 'id' was not present! Struct: ")).append(toString()).toString());
        }
        if (g != null)
        {
            g.j();
        }
    }

    public e a(int i1)
    {
        return e.a(i1);
    }

    public bd a()
    {
        return new bd(this);
    }

    public bd a(long l1)
    {
        b = l1;
        b(true);
        return this;
    }

    public bd a(String s1)
    {
        a = s1;
        return this;
    }

    public bd a(List list)
    {
        e = list;
        return this;
    }

    public bd a(be be1)
    {
        g = be1;
        return this;
    }

    public void a(aw aw1)
    {
        if (f == null)
        {
            f = new ArrayList();
        }
        f.add(aw1);
    }

    public void a(ay ay1)
    {
        if (e == null)
        {
            e = new ArrayList();
        }
        e.add(ay1);
    }

    public void a(cy cy1)
    {
        ((dh)q.get(cy1.D())).b().a(cy1, this);
    }

    public void a(boolean flag)
    {
        if (!flag)
        {
            a = null;
        }
    }

    public bd b(long l1)
    {
        c = l1;
        c(true);
        return this;
    }

    public bd b(List list)
    {
        f = list;
        return this;
    }

    public cg b(int i1)
    {
        return a(i1);
    }

    public void b()
    {
        a = null;
        b(false);
        b = 0L;
        c(false);
        c = 0L;
        d(false);
        d = 0L;
        e = null;
        f = null;
        g = null;
    }

    public void b(cy cy1)
    {
        ((dh)q.get(cy1.D())).b().b(cy1, this);
    }

    public void b(boolean flag)
    {
        u = bw.a(u, 0, flag);
    }

    public String c()
    {
        return a;
    }

    public bd c(long l1)
    {
        d = l1;
        d(true);
        return this;
    }

    public void c(boolean flag)
    {
        u = bw.a(u, 1, flag);
    }

    public void d()
    {
        a = null;
    }

    public void d(boolean flag)
    {
        u = bw.a(u, 2, flag);
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

    public long f()
    {
        return b;
    }

    public void f(boolean flag)
    {
        if (!flag)
        {
            f = null;
        }
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

    public void h()
    {
        u = bw.b(u, 0);
    }

    public boolean i()
    {
        return bw.a(u, 0);
    }

    public long j()
    {
        return c;
    }

    public void k()
    {
        u = bw.b(u, 1);
    }

    public boolean l()
    {
        return bw.a(u, 1);
    }

    public long m()
    {
        return d;
    }

    public void n()
    {
        u = bw.b(u, 2);
    }

    public boolean o()
    {
        return bw.a(u, 2);
    }

    public int p()
    {
        if (e == null)
        {
            return 0;
        } else
        {
            return e.size();
        }
    }

    public Iterator q()
    {
        if (e == null)
        {
            return null;
        } else
        {
            return e.iterator();
        }
    }

    public List r()
    {
        return e;
    }

    public void s()
    {
        e = null;
    }

    public boolean t()
    {
        return e != null;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("Session(");
        stringbuilder.append("id:");
        if (a == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(a);
        }
        stringbuilder.append(", ");
        stringbuilder.append("start_time:");
        stringbuilder.append(b);
        stringbuilder.append(", ");
        stringbuilder.append("end_time:");
        stringbuilder.append(c);
        stringbuilder.append(", ");
        stringbuilder.append("duration:");
        stringbuilder.append(d);
        if (t())
        {
            stringbuilder.append(", ");
            stringbuilder.append("pages:");
            if (e == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(e);
            }
        }
        if (y())
        {
            stringbuilder.append(", ");
            stringbuilder.append("locations:");
            if (f == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(f);
            }
        }
        if (B())
        {
            stringbuilder.append(", ");
            stringbuilder.append("traffic:");
            if (g == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(g);
            }
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    public int u()
    {
        if (f == null)
        {
            return 0;
        } else
        {
            return f.size();
        }
    }

    public Iterator v()
    {
        if (f == null)
        {
            return null;
        } else
        {
            return f.iterator();
        }
    }

    public List w()
    {
        return f;
    }

    public void x()
    {
        f = null;
    }

    public boolean y()
    {
        return f != null;
    }

    public be z()
    {
        return g;
    }

    static 
    {
        q = new HashMap();
        q.put(u/aly/di, new bV(null));
        q.put(u/aly/dj, new bX(null));
        EnumMap enummap = new EnumMap(u/aly/bd$e);
        enummap.put(e.a, new cl("id", (byte)1, new cm((byte)11)));
        enummap.put(e.b, new cl("start_time", (byte)1, new cm((byte)10)));
        enummap.put(e.c, new cl("end_time", (byte)1, new cm((byte)10)));
        enummap.put(e.d, new cl("duration", (byte)1, new cm((byte)10)));
        enummap.put(e.e, new cl("pages", (byte)2, new cn((byte)15, new cq((byte)12, u/aly/ay))));
        enummap.put(e.f, new cl("locations", (byte)2, new cn((byte)15, new cq((byte)12, u/aly/aw))));
        enummap.put(e.g, new cl("traffic", (byte)2, new cq((byte)12, u/aly/be)));
        h = Collections.unmodifiableMap(enummap);
        cl.a(u/aly/bd, h);
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
        private static final Map h;
        private static final e k[];
        private final short i;
        private final String j;

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
            }
        }

        public static e a(String s1)
        {
            return (e)h.get(s1);
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
            return (e)Enum.valueOf(u/aly/bd$e, s1);
        }

        public static e[] values()
        {
            e ae[] = k;
            int i1 = ae.length;
            e ae1[] = new e[i1];
            System.arraycopy(ae, 0, ae1, 0, i1);
            return ae1;
        }

        public short a()
        {
            return i;
        }

        public String b()
        {
            return j;
        }

        static 
        {
            a = new e("ID", 0, (short)1, "id");
            b = new e("START_TIME", 1, (short)2, "start_time");
            c = new e("END_TIME", 2, (short)3, "end_time");
            d = new e("DURATION", 3, (short)4, "duration");
            e = new e("PAGES", 4, (short)5, "pages");
            f = new e("LOCATIONS", 5, (short)6, "locations");
            g = new e("TRAFFIC", 6, (short)7, "traffic");
            e ae[] = new e[7];
            ae[0] = a;
            ae[1] = b;
            ae[2] = c;
            ae[3] = d;
            ae[4] = e;
            ae[5] = f;
            ae[6] = g;
            k = ae;
            h = new HashMap();
            Iterator iterator = EnumSet.allOf(u/aly/bd$e).iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    return;
                }
                e e1 = (e)iterator.next();
                h.put(e1.b(), e1);
            } while (true);
        }

        private e(String s1, int i1, short word0, String s2)
        {
            super(s1, i1);
            i = word0;
            j = s2;
        }
    }

}
