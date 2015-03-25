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
//            aD, dj, aF, cl, 
//            cm, cf, cs, dk, 
//            cy, dh, dg, bw, 
//            cz, cg

public class aq
    implements Serializable, Cloneable, bz
{

    public static final Map e;
    private static final dd f = new dd("IdJournal");
    private static final ct g = new ct("domain", (byte)11, (short)1);
    private static final ct h = new ct("old_id", (byte)11, (short)2);
    private static final ct i = new ct("new_id", (byte)11, (short)3);
    private static final ct j = new ct("ts", (byte)10, (short)4);
    private static final Map k;
    private static final int l;
    public String a;
    public String b;
    public String c;
    public long d;
    private byte m;
    private e n[];

    public aq()
    {
        m = 0;
        e ae[] = new e[1];
        ae[0] = e.b;
        n = ae;
    }

    public aq(String s1, String s2, long l1)
    {
        this();
        a = s1;
        c = s2;
        d = l1;
        d(true);
    }

    public aq(aq aq1)
    {
        m = 0;
        e ae[] = new e[1];
        ae[0] = e.b;
        n = ae;
        m = aq1.m;
        if (aq1.e())
        {
            a = aq1.a;
        }
        if (aq1.i())
        {
            b = aq1.b;
        }
        if (aq1.l())
        {
            c = aq1.c;
        }
        d = aq1.d;
    }

    private void a(ObjectInputStream objectinputstream)
    {
        try
        {
            m = 0;
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

    static dd q()
    {
        return f;
    }

    static ct r()
    {
        return g;
    }

    static ct s()
    {
        return h;
    }

    static ct t()
    {
        return i;
    }

    static ct u()
    {
        return j;
    }

    public e a(int i1)
    {
        return e.a(i1);
    }

    public aq a()
    {
        return new aq(this);
    }

    public aq a(long l1)
    {
        d = l1;
        d(true);
        return this;
    }

    public aq a(String s1)
    {
        a = s1;
        return this;
    }

    public void a(cy cy1)
    {
        ((dh)k.get(cy1.D())).b().a(cy1, this);
    }

    public void a(boolean flag)
    {
        if (!flag)
        {
            a = null;
        }
    }

    public aq b(String s1)
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
        d(false);
        d = 0L;
    }

    public void b(cy cy1)
    {
        ((dh)k.get(cy1.D())).b().b(cy1, this);
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

    public aq c(String s1)
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

    public void d()
    {
        a = null;
    }

    public void d(boolean flag)
    {
        m = bw.a(m, 0, flag);
    }

    public boolean e()
    {
        return a != null;
    }

    public String f()
    {
        return b;
    }

    public bz g()
    {
        return a();
    }

    public void h()
    {
        b = null;
    }

    public boolean i()
    {
        return b != null;
    }

    public String j()
    {
        return c;
    }

    public void k()
    {
        c = null;
    }

    public boolean l()
    {
        return c != null;
    }

    public long m()
    {
        return d;
    }

    public void n()
    {
        m = bw.b(m, 0);
    }

    public boolean o()
    {
        return bw.a(m, 0);
    }

    public void p()
    {
        if (a == null)
        {
            throw new cz((new StringBuilder("Required field 'domain' was not present! Struct: ")).append(toString()).toString());
        }
        if (c == null)
        {
            throw new cz((new StringBuilder("Required field 'new_id' was not present! Struct: ")).append(toString()).toString());
        } else
        {
            return;
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("IdJournal(");
        stringbuilder.append("domain:");
        if (a == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(a);
        }
        if (i())
        {
            stringbuilder.append(", ");
            stringbuilder.append("old_id:");
            if (b == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(b);
            }
        }
        stringbuilder.append(", ");
        stringbuilder.append("new_id:");
        if (c == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(c);
        }
        stringbuilder.append(", ");
        stringbuilder.append("ts:");
        stringbuilder.append(d);
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    static 
    {
        k = new HashMap();
        k.put(u/aly/di, new aD(null));
        k.put(u/aly/dj, new aF(null));
        EnumMap enummap = new EnumMap(u/aly/aq$e);
        enummap.put(e.a, new cl("domain", (byte)1, new cm((byte)11)));
        enummap.put(e.b, new cl("old_id", (byte)2, new cm((byte)11)));
        enummap.put(e.c, new cl("new_id", (byte)1, new cm((byte)11)));
        enummap.put(e.d, new cl("ts", (byte)1, new cm((byte)10)));
        e = Collections.unmodifiableMap(enummap);
        cl.a(u/aly/aq, e);
    }

    private class e extends Enum
        implements cg
    {

        public static final e a;
        public static final e b;
        public static final e c;
        public static final e d;
        private static final Map e;
        private static final e h[];
        private final short f;
        private final String g;

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
            }
        }

        public static e a(String s1)
        {
            return (e)e.get(s1);
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
            return (e)Enum.valueOf(u/aly/aq$e, s1);
        }

        public static e[] values()
        {
            e ae[] = h;
            int i1 = ae.length;
            e ae1[] = new e[i1];
            System.arraycopy(ae, 0, ae1, 0, i1);
            return ae1;
        }

        public short a()
        {
            return f;
        }

        public String b()
        {
            return g;
        }

        static 
        {
            a = new e("DOMAIN", 0, (short)1, "domain");
            b = new e("OLD_ID", 1, (short)2, "old_id");
            c = new e("NEW_ID", 2, (short)3, "new_id");
            d = new e("TS", 3, (short)4, "ts");
            e ae[] = new e[4];
            ae[0] = a;
            ae[1] = b;
            ae[2] = c;
            ae[3] = d;
            h = ae;
            e = new HashMap();
            Iterator iterator = EnumSet.allOf(u/aly/aq$e).iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    return;
                }
                e e1 = (e)iterator.next();
                e.put(e1.b(), e1);
            } while (true);
        }

        private e(String s1, int i1, short word0, String s2)
        {
            super(s1, i1);
            f = word0;
            g = s2;
        }
    }

}
