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
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package u.aly:
//            bz, dd, ct, di, 
//            Z, dj, aB, cl, 
//            cm, co, cq, az, 
//            cf, cs, dk, cy, 
//            dh, dg, bw, cz, 
//            cg

public class ao
    implements Serializable, Cloneable, bz
{

    public static final Map f;
    private static final dd g = new dd("Event");
    private static final ct h = new ct("name", (byte)11, (short)1);
    private static final ct i = new ct("properties", (byte)13, (short)2);
    private static final ct j = new ct("duration", (byte)10, (short)3);
    private static final ct k = new ct("acc", (byte)8, (short)4);
    private static final ct l = new ct("ts", (byte)10, (short)5);
    private static final Map m;
    private static final int n = 0;
    private static final int o = 1;
    private static final int p = 2;
    public String a;
    public Map b;
    public long c;
    public int d;
    public long e;
    private byte q;
    private e r[];

    public ao()
    {
        q = 0;
        e ae[] = new e[2];
        ae[0] = e.c;
        ae[1] = e.d;
        r = ae;
    }

    public ao(String s1, Map map, long l1)
    {
        this();
        a = s1;
        b = map;
        e = l1;
        e(true);
    }

    public ao(ao ao1)
    {
        q = 0;
        e ae[] = new e[2];
        ae[0] = e.c;
        ae[1] = e.d;
        r = ae;
        q = ao1.q;
        if (ao1.e())
        {
            a = ao1.a;
        }
        if (!ao1.j()) goto _L2; else goto _L1
_L1:
        HashMap hashmap;
        Iterator iterator;
        hashmap = new HashMap();
        iterator = ao1.b.entrySet().iterator();
_L6:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        b = hashmap;
_L2:
        c = ao1.c;
        d = ao1.d;
        e = ao1.e;
        return;
_L4:
        java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
        hashmap.put((String)entry.getKey(), new az((az)entry.getValue()));
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void a(ObjectInputStream objectinputstream)
    {
        try
        {
            q = 0;
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

    static dd u()
    {
        return g;
    }

    static ct v()
    {
        return h;
    }

    static ct w()
    {
        return i;
    }

    static ct x()
    {
        return j;
    }

    static ct y()
    {
        return k;
    }

    static ct z()
    {
        return l;
    }

    public ao a()
    {
        return new ao(this);
    }

    public ao a(int i1)
    {
        d = i1;
        d(true);
        return this;
    }

    public ao a(long l1)
    {
        c = l1;
        c(true);
        return this;
    }

    public ao a(String s1)
    {
        a = s1;
        return this;
    }

    public ao a(Map map)
    {
        b = map;
        return this;
    }

    public void a(String s1, az az1)
    {
        if (b == null)
        {
            b = new HashMap();
        }
        b.put(s1, az1);
    }

    public void a(cy cy1)
    {
        ((dh)m.get(cy1.D())).b().a(cy1, this);
    }

    public void a(boolean flag)
    {
        if (!flag)
        {
            a = null;
        }
    }

    public ao b(long l1)
    {
        e = l1;
        e(true);
        return this;
    }

    public cg b(int i1)
    {
        return c(i1);
    }

    public void b()
    {
        a = null;
        b = null;
        c(false);
        c = 0L;
        d(false);
        d = 0;
        e(false);
        e = 0L;
    }

    public void b(cy cy1)
    {
        ((dh)m.get(cy1.D())).b().b(cy1, this);
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

    public e c(int i1)
    {
        return e.a(i1);
    }

    public void c(boolean flag)
    {
        q = bw.a(q, 0, flag);
    }

    public void d()
    {
        a = null;
    }

    public void d(boolean flag)
    {
        q = bw.a(q, 1, flag);
    }

    public void e(boolean flag)
    {
        q = bw.a(q, 2, flag);
    }

    public boolean e()
    {
        return a != null;
    }

    public int f()
    {
        if (b == null)
        {
            return 0;
        } else
        {
            return b.size();
        }
    }

    public bz g()
    {
        return a();
    }

    public Map h()
    {
        return b;
    }

    public void i()
    {
        b = null;
    }

    public boolean j()
    {
        return b != null;
    }

    public long k()
    {
        return c;
    }

    public void l()
    {
        q = bw.b(q, 0);
    }

    public boolean m()
    {
        return bw.a(q, 0);
    }

    public int n()
    {
        return d;
    }

    public void o()
    {
        q = bw.b(q, 1);
    }

    public boolean p()
    {
        return bw.a(q, 1);
    }

    public long q()
    {
        return e;
    }

    public void r()
    {
        q = bw.b(q, 2);
    }

    public boolean s()
    {
        return bw.a(q, 2);
    }

    public void t()
    {
        if (a == null)
        {
            throw new cz((new StringBuilder("Required field 'name' was not present! Struct: ")).append(toString()).toString());
        }
        if (b == null)
        {
            throw new cz((new StringBuilder("Required field 'properties' was not present! Struct: ")).append(toString()).toString());
        } else
        {
            return;
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("Event(");
        stringbuilder.append("name:");
        if (a == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(a);
        }
        stringbuilder.append(", ");
        stringbuilder.append("properties:");
        if (b == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(b);
        }
        if (m())
        {
            stringbuilder.append(", ");
            stringbuilder.append("duration:");
            stringbuilder.append(c);
        }
        if (p())
        {
            stringbuilder.append(", ");
            stringbuilder.append("acc:");
            stringbuilder.append(d);
        }
        stringbuilder.append(", ");
        stringbuilder.append("ts:");
        stringbuilder.append(e);
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    static 
    {
        m = new HashMap();
        m.put(u/aly/di, new Z(null));
        m.put(u/aly/dj, new aB(null));
        EnumMap enummap = new EnumMap(u/aly/ao$e);
        enummap.put(e.a, new cl("name", (byte)1, new cm((byte)11)));
        enummap.put(e.b, new cl("properties", (byte)1, new co((byte)13, new cm((byte)11), new cq((byte)12, u/aly/az))));
        enummap.put(e.c, new cl("duration", (byte)2, new cm((byte)10)));
        enummap.put(e.d, new cl("acc", (byte)2, new cm((byte)8)));
        enummap.put(e.e, new cl("ts", (byte)1, new cm((byte)10)));
        f = Collections.unmodifiableMap(enummap);
        cl.a(u/aly/ao, f);
    }

    private class e extends Enum
        implements cg
    {

        public static final e a;
        public static final e b;
        public static final e c;
        public static final e d;
        public static final e e;
        private static final Map f;
        private static final e i[];
        private final short g;
        private final String h;

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
            }
        }

        public static e a(String s1)
        {
            return (e)f.get(s1);
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
            return (e)Enum.valueOf(u/aly/ao$e, s1);
        }

        public static e[] values()
        {
            e ae[] = i;
            int i1 = ae.length;
            e ae1[] = new e[i1];
            System.arraycopy(ae, 0, ae1, 0, i1);
            return ae1;
        }

        public short a()
        {
            return g;
        }

        public String b()
        {
            return h;
        }

        static 
        {
            a = new e("NAME", 0, (short)1, "name");
            b = new e("PROPERTIES", 1, (short)2, "properties");
            c = new e("DURATION", 2, (short)3, "duration");
            d = new e("ACC", 3, (short)4, "acc");
            e = new e("TS", 4, (short)5, "ts");
            e ae[] = new e[5];
            ae[0] = a;
            ae[1] = b;
            ae[2] = c;
            ae[3] = d;
            ae[4] = e;
            i = ae;
            f = new HashMap();
            Iterator iterator = EnumSet.allOf(u/aly/ao$e).iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    return;
                }
                e e1 = (e)iterator.next();
                f.put(e1.b(), e1);
            } while (true);
        }

        private e(String s1, int i1, short word0, String s2)
        {
            super(s1, i1);
            g = word0;
            h = s2;
        }
    }

}
