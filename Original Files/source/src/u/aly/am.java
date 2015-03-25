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
//            V, dj, X, cl, 
//            cm, ck, an, cf, 
//            cs, dk, cy, dh, 
//            dg, bw, cz, cg

public class am
    implements Serializable, Cloneable, bz
{

    public static final Map d;
    private static final dd e = new dd("Error");
    private static final ct f = new ct("ts", (byte)10, (short)1);
    private static final ct g = new ct("context", (byte)11, (short)2);
    private static final ct h = new ct("source", (byte)8, (short)3);
    private static final Map i;
    private static final int j;
    public long a;
    public String b;
    public an c;
    private byte k;
    private e l[];

    public am()
    {
        k = 0;
        e ae[] = new e[1];
        ae[0] = e.c;
        l = ae;
    }

    public am(long l1, String s)
    {
        this();
        a = l1;
        b(true);
        b = s;
    }

    public am(am am1)
    {
        k = 0;
        e ae[] = new e[1];
        ae[0] = e.c;
        l = ae;
        k = am1.k;
        a = am1.a;
        if (am1.i())
        {
            b = am1.b;
        }
        if (am1.l())
        {
            c = am1.c;
        }
    }

    private void a(ObjectInputStream objectinputstream)
    {
        try
        {
            k = 0;
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

    public e a(int i1)
    {
        return e.a(i1);
    }

    public am a()
    {
        return new am(this);
    }

    public am a(long l1)
    {
        a = l1;
        b(true);
        return this;
    }

    public am a(String s)
    {
        b = s;
        return this;
    }

    public am a(an an1)
    {
        c = an1;
        return this;
    }

    public void a(cy cy1)
    {
        ((dh)i.get(cy1.D())).b().a(cy1, this);
    }

    public cg b(int i1)
    {
        return a(i1);
    }

    public void b()
    {
        b(false);
        a = 0L;
        b = null;
        c = null;
    }

    public void b(cy cy1)
    {
        ((dh)i.get(cy1.D())).b().b(cy1, this);
    }

    public void b(boolean flag)
    {
        k = bw.a(k, 0, flag);
    }

    public long c()
    {
        return a;
    }

    public void c(boolean flag)
    {
        if (!flag)
        {
            b = null;
        }
    }

    public void d()
    {
        k = bw.b(k, 0);
    }

    public void d(boolean flag)
    {
        if (!flag)
        {
            c = null;
        }
    }

    public boolean e()
    {
        return bw.a(k, 0);
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

    public an j()
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

    public void m()
    {
        if (b == null)
        {
            throw new cz((new StringBuilder("Required field 'context' was not present! Struct: ")).append(toString()).toString());
        } else
        {
            return;
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("Error(");
        stringbuilder.append("ts:");
        stringbuilder.append(a);
        stringbuilder.append(", ");
        stringbuilder.append("context:");
        if (b == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(b);
        }
        if (l())
        {
            stringbuilder.append(", ");
            stringbuilder.append("source:");
            if (c == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(c);
            }
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    static 
    {
        i = new HashMap();
        i.put(u/aly/di, new V(null));
        i.put(u/aly/dj, new X(null));
        EnumMap enummap = new EnumMap(u/aly/am$e);
        enummap.put(e.a, new cl("ts", (byte)1, new cm((byte)10)));
        enummap.put(e.b, new cl("context", (byte)1, new cm((byte)11)));
        enummap.put(e.c, new cl("source", (byte)2, new ck((byte)16, u/aly/an)));
        d = Collections.unmodifiableMap(enummap);
        cl.a(u/aly/am, d);
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
            return (e)Enum.valueOf(u/aly/am$e, s);
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
            a = new e("TS", 0, (short)1, "ts");
            b = new e("CONTEXT", 1, (short)2, "context");
            c = new e("SOURCE", 2, (short)3, "source");
            e ae[] = new e[3];
            ae[0] = a;
            ae[1] = b;
            ae[2] = c;
            g = ae;
            d = new HashMap();
            Iterator iterator = EnumSet.allOf(u/aly/am$e).iterator();
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
