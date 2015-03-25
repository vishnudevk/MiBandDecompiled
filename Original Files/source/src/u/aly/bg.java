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
//            cH, dj, cJ, cl, 
//            ck, ap, cm, cf, 
//            cs, dk, cy, dh, 
//            dg, bw, cg

public class bg
    implements Serializable, Cloneable, bz
{

    public static final Map e;
    private static final dd f = new dd("UserInfo");
    private static final ct g = new ct("gender", (byte)8, (short)1);
    private static final ct h = new ct("age", (byte)8, (short)2);
    private static final ct i = new ct("id", (byte)11, (short)3);
    private static final ct j = new ct("source", (byte)11, (short)4);
    private static final Map k;
    private static final int l;
    public ap a;
    public int b;
    public String c;
    public String d;
    private byte m;
    private e n[];

    public bg()
    {
        m = 0;
        e ae[] = new e[4];
        ae[0] = e.a;
        ae[1] = e.b;
        ae[2] = e.c;
        ae[3] = e.d;
        n = ae;
    }

    public bg(bg bg1)
    {
        m = 0;
        e ae[] = new e[4];
        ae[0] = e.a;
        ae[1] = e.b;
        ae[2] = e.c;
        ae[3] = e.d;
        n = ae;
        m = bg1.m;
        if (bg1.e())
        {
            a = bg1.a;
        }
        b = bg1.b;
        if (bg1.l())
        {
            c = bg1.c;
        }
        if (bg1.o())
        {
            d = bg1.d;
        }
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

    public bg a()
    {
        return new bg(this);
    }

    public bg a(int i1)
    {
        b = i1;
        b(true);
        return this;
    }

    public bg a(String s1)
    {
        c = s1;
        return this;
    }

    public bg a(ap ap1)
    {
        a = ap1;
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

    public bg b(String s1)
    {
        d = s1;
        return this;
    }

    public cg b(int i1)
    {
        return c(i1);
    }

    public void b()
    {
        a = null;
        b(false);
        b = 0;
        c = null;
        d = null;
    }

    public void b(cy cy1)
    {
        ((dh)k.get(cy1.D())).b().b(cy1, this);
    }

    public void b(boolean flag)
    {
        m = bw.a(m, 0, flag);
    }

    public ap c()
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
        a = null;
    }

    public void d(boolean flag)
    {
        if (!flag)
        {
            d = null;
        }
    }

    public boolean e()
    {
        return a != null;
    }

    public int f()
    {
        return b;
    }

    public bz g()
    {
        return a();
    }

    public void h()
    {
        m = bw.b(m, 0);
    }

    public boolean i()
    {
        return bw.a(m, 0);
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

    public String m()
    {
        return d;
    }

    public void n()
    {
        d = null;
    }

    public boolean o()
    {
        return d != null;
    }

    public void p()
    {
    }

    public String toString()
    {
        boolean flag = false;
        StringBuilder stringbuilder = new StringBuilder("UserInfo(");
        boolean flag1 = true;
        if (e())
        {
            stringbuilder.append("gender:");
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
            stringbuilder.append("age:");
            stringbuilder.append(b);
            flag1 = false;
        }
        if (l())
        {
            if (!flag1)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("id:");
            if (c == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(c);
                flag = false;
            }
        } else
        {
            flag = flag1;
        }
        if (o())
        {
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append("source:");
            if (d == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(d);
            }
        }
        stringbuilder.append(")");
        return stringbuilder.toString();
    }

    static 
    {
        k = new HashMap();
        k.put(u/aly/di, new cH(null));
        k.put(u/aly/dj, new cJ(null));
        EnumMap enummap = new EnumMap(u/aly/bg$e);
        enummap.put(e.a, new cl("gender", (byte)2, new ck((byte)16, u/aly/ap)));
        enummap.put(e.b, new cl("age", (byte)2, new cm((byte)8)));
        enummap.put(e.c, new cl("id", (byte)2, new cm((byte)11)));
        enummap.put(e.d, new cl("source", (byte)2, new cm((byte)11)));
        e = Collections.unmodifiableMap(enummap);
        cl.a(u/aly/bg, e);
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
            return (e)Enum.valueOf(u/aly/bg$e, s1);
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
            a = new e("GENDER", 0, (short)1, "gender");
            b = new e("AGE", 1, (short)2, "age");
            c = new e("ID", 2, (short)3, "id");
            d = new e("SOURCE", 3, (short)4, "source");
            e ae[] = new e[4];
            ae[0] = a;
            ae[1] = b;
            ae[2] = c;
            ae[3] = d;
            h = ae;
            e = new HashMap();
            Iterator iterator = EnumSet.allOf(u/aly/bg$e).iterator();
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
