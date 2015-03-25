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
//            aH, dj, aJ, cl, 
//            cm, cf, cs, dk, 
//            cy, dh, dg, bw, 
//            cz, cg

public class ar
    implements Serializable, Cloneable, bz
{

    public static final Map d;
    private static final dd e = new dd("IdSnapshot");
    private static final ct f = new ct("identity", (byte)11, (short)1);
    private static final ct g = new ct("ts", (byte)10, (short)2);
    private static final ct h = new ct("version", (byte)8, (short)3);
    private static final Map i;
    private static final int j = 0;
    private static final int k = 1;
    public String a;
    public long b;
    public int c;
    private byte l;

    public ar()
    {
        l = 0;
    }

    public ar(String s, long l1, int i1)
    {
        this();
        a = s;
        b = l1;
        b(true);
        c = i1;
        c(true);
    }

    public ar(ar ar1)
    {
        l = 0;
        l = ar1.l;
        if (ar1.e())
        {
            a = ar1.a;
        }
        b = ar1.b;
        c = ar1.c;
    }

    private void a(ObjectInputStream objectinputstream)
    {
        try
        {
            l = 0;
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

    static dd n()
    {
        return e;
    }

    static ct o()
    {
        return f;
    }

    static ct p()
    {
        return g;
    }

    static ct q()
    {
        return h;
    }

    public ar a()
    {
        return new ar(this);
    }

    public ar a(int i1)
    {
        c = i1;
        c(true);
        return this;
    }

    public ar a(long l1)
    {
        b = l1;
        b(true);
        return this;
    }

    public ar a(String s)
    {
        a = s;
        return this;
    }

    public void a(cy cy1)
    {
        ((dh)i.get(cy1.D())).b().a(cy1, this);
    }

    public void a(boolean flag)
    {
        if (!flag)
        {
            a = null;
        }
    }

    public cg b(int i1)
    {
        return c(i1);
    }

    public void b()
    {
        a = null;
        b(false);
        b = 0L;
        c(false);
        c = 0;
    }

    public void b(cy cy1)
    {
        ((dh)i.get(cy1.D())).b().b(cy1, this);
    }

    public void b(boolean flag)
    {
        l = bw.a(l, 0, flag);
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
        l = bw.a(l, 1, flag);
    }

    public void d()
    {
        a = null;
    }

    public boolean e()
    {
        return a != null;
    }

    public long f()
    {
        return b;
    }

    public bz g()
    {
        return a();
    }

    public void h()
    {
        l = bw.b(l, 0);
    }

    public boolean i()
    {
        return bw.a(l, 0);
    }

    public int j()
    {
        return c;
    }

    public void k()
    {
        l = bw.b(l, 1);
    }

    public boolean l()
    {
        return bw.a(l, 1);
    }

    public void m()
    {
        if (a == null)
        {
            throw new cz((new StringBuilder("Required field 'identity' was not present! Struct: ")).append(toString()).toString());
        } else
        {
            return;
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("IdSnapshot(");
        stringbuilder.append("identity:");
        if (a == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(a);
        }
        stringbuilder.append(", ");
        stringbuilder.append("ts:");
        stringbuilder.append(b);
        stringbuilder.append(", ");
        stringbuilder.append("version:");
        stringbuilder.append(c);
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    static 
    {
        i = new HashMap();
        i.put(u/aly/di, new aH(null));
        i.put(u/aly/dj, new aJ(null));
        EnumMap enummap = new EnumMap(u/aly/ar$e);
        enummap.put(e.a, new cl("identity", (byte)1, new cm((byte)11)));
        enummap.put(e.b, new cl("ts", (byte)1, new cm((byte)10)));
        enummap.put(e.c, new cl("version", (byte)1, new cm((byte)8)));
        d = Collections.unmodifiableMap(enummap);
        cl.a(u/aly/ar, d);
    }

    private class e extends Enum
        implements cg
    {

        public static final e a;
        public static final e b;
        public static final e c;
        private static final Map d;
        private static final e g[];
        private final short e;
        private final String f;

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
            }
        }

        public static e a(String s)
        {
            return (e)d.get(s);
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

        public static e valueOf(String s)
        {
            return (e)Enum.valueOf(u/aly/ar$e, s);
        }

        public static e[] values()
        {
            e ae[] = g;
            int i1 = ae.length;
            e ae1[] = new e[i1];
            System.arraycopy(ae, 0, ae1, 0, i1);
            return ae1;
        }

        public short a()
        {
            return e;
        }

        public String b()
        {
            return f;
        }

        static 
        {
            a = new e("IDENTITY", 0, (short)1, "identity");
            b = new e("TS", 1, (short)2, "ts");
            c = new e("VERSION", 2, (short)3, "version");
            e ae[] = new e[3];
            ae[0] = a;
            ae[1] = b;
            ae[2] = c;
            g = ae;
            d = new HashMap();
            Iterator iterator = EnumSet.allOf(u/aly/ar$e).iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    return;
                }
                e e1 = (e)iterator.next();
                d.put(e1.b(), e1);
            } while (true);
        }

        private e(String s, int i1, short word0, String s1)
        {
            super(s, i1);
            e = word0;
            f = s1;
        }
    }

}
