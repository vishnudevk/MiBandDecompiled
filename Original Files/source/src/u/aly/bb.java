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
//            bR, dj, bT, cl, 
//            cm, cq, at, cf, 
//            cs, dk, cy, dh, 
//            dg, bw, cg

public class bb
    implements Serializable, Cloneable, bz
{

    public static final Map d;
    private static final dd e = new dd("Response");
    private static final ct f = new ct("resp_code", (byte)8, (short)1);
    private static final ct g = new ct("msg", (byte)11, (short)2);
    private static final ct h = new ct("imprint", (byte)12, (short)3);
    private static final Map i;
    private static final int j;
    public int a;
    public String b;
    public at c;
    private byte k;
    private e l[];

    public bb()
    {
        k = 0;
        e ae[] = new e[2];
        ae[0] = e.b;
        ae[1] = e.c;
        l = ae;
    }

    public bb(int i1)
    {
        this();
        a = i1;
        a(true);
    }

    public bb(bb bb1)
    {
        k = 0;
        e ae[] = new e[2];
        ae[0] = e.b;
        ae[1] = e.c;
        l = ae;
        k = bb1.k;
        a = bb1.a;
        if (bb1.i())
        {
            b = bb1.b;
        }
        if (bb1.l())
        {
            c = new at(bb1.c);
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

    public bb a()
    {
        return new bb(this);
    }

    public bb a(int i1)
    {
        a = i1;
        a(true);
        return this;
    }

    public bb a(String s)
    {
        b = s;
        return this;
    }

    public bb a(at at1)
    {
        c = at1;
        return this;
    }

    public void a(cy cy1)
    {
        ((dh)i.get(cy1.D())).b().a(cy1, this);
    }

    public void a(boolean flag)
    {
        k = bw.a(k, 0, flag);
    }

    public cg b(int i1)
    {
        return c(i1);
    }

    public void b()
    {
        a(false);
        a = 0;
        b = null;
        c = null;
    }

    public void b(cy cy1)
    {
        ((dh)i.get(cy1.D())).b().b(cy1, this);
    }

    public void b(boolean flag)
    {
        if (!flag)
        {
            b = null;
        }
    }

    public int c()
    {
        return a;
    }

    public e c(int i1)
    {
        return e.a(i1);
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
        k = bw.b(k, 0);
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

    public at j()
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
        if (c != null)
        {
            c.n();
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("Response(");
        stringbuilder.append("resp_code:");
        stringbuilder.append(a);
        if (i())
        {
            stringbuilder.append(", ");
            stringbuilder.append("msg:");
            if (b == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(b);
            }
        }
        if (l())
        {
            stringbuilder.append(", ");
            stringbuilder.append("imprint:");
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
        i.put(u/aly/di, new bR(null));
        i.put(u/aly/dj, new bT(null));
        EnumMap enummap = new EnumMap(u/aly/bb$e);
        enummap.put(e.a, new cl("resp_code", (byte)1, new cm((byte)8)));
        enummap.put(e.b, new cl("msg", (byte)2, new cm((byte)11)));
        enummap.put(e.c, new cl("imprint", (byte)2, new cq((byte)12, u/aly/at)));
        d = Collections.unmodifiableMap(enummap);
        cl.a(u/aly/bb, d);
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
            return (e)Enum.valueOf(u/aly/bb$e, s);
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
            a = new e("RESP_CODE", 0, (short)1, "resp_code");
            b = new e("MSG", 1, (short)2, "msg");
            c = new e("IMPRINT", 2, (short)3, "imprint");
            e ae[] = new e[3];
            ae[0] = a;
            ae[1] = b;
            ae[2] = c;
            g = ae;
            d = new HashMap();
            Iterator iterator = EnumSet.allOf(u/aly/bb$e).iterator();
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
