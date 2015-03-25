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
import java.util.Set;

// Referenced classes of package u.aly:
//            bz, dd, ct, di, 
//            aL, dj, aN, cl, 
//            co, cm, cq, ar, 
//            cn, aq, cf, cs, 
//            dk, cy, dh, dg, 
//            cz, cg

public class as
    implements Serializable, Cloneable, bz
{

    public static final Map d;
    private static final dd e = new dd("IdTracking");
    private static final ct f = new ct("snapshots", (byte)13, (short)1);
    private static final ct g = new ct("journals", (byte)15, (short)2);
    private static final ct h = new ct("checksum", (byte)11, (short)3);
    private static final Map i;
    public Map a;
    public List b;
    public String c;
    private e j[];

    public as()
    {
        e ae[] = new e[2];
        ae[0] = e.b;
        ae[1] = e.c;
        j = ae;
    }

    public as(Map map)
    {
        this();
        a = map;
    }

    public as(as as1)
    {
        e ae[] = new e[2];
        ae[0] = e.b;
        ae[1] = e.c;
        j = ae;
        if (!as1.f()) goto _L2; else goto _L1
_L1:
        HashMap hashmap;
        Iterator iterator;
        hashmap = new HashMap();
        iterator = as1.a.entrySet().iterator();
_L6:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        a = hashmap;
_L2:
        if (as1.l())
        {
            ArrayList arraylist = new ArrayList();
            java.util.Map.Entry entry;
            for (Iterator iterator1 = as1.b.iterator(); iterator1.hasNext(); arraylist.add(new aq((aq)iterator1.next())))
            {
                break MISSING_BLOCK_LABEL_180;
            }

            b = arraylist;
        }
        if (as1.o())
        {
            c = as1.c;
        }
        return;
_L4:
        entry = (java.util.Map.Entry)iterator.next();
        hashmap.put((String)entry.getKey(), new ar((ar)entry.getValue()));
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void a(ObjectInputStream objectinputstream)
    {
        try
        {
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
        return e;
    }

    static ct r()
    {
        return f;
    }

    static ct s()
    {
        return g;
    }

    static ct t()
    {
        return h;
    }

    public e a(int i1)
    {
        return e.a(i1);
    }

    public as a()
    {
        return new as(this);
    }

    public as a(String s1)
    {
        c = s1;
        return this;
    }

    public as a(List list)
    {
        b = list;
        return this;
    }

    public as a(Map map)
    {
        a = map;
        return this;
    }

    public void a(String s1, ar ar1)
    {
        if (a == null)
        {
            a = new HashMap();
        }
        a.put(s1, ar1);
    }

    public void a(aq aq1)
    {
        if (b == null)
        {
            b = new ArrayList();
        }
        b.add(aq1);
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
        return a(i1);
    }

    public void b()
    {
        a = null;
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
        if (a == null)
        {
            return 0;
        } else
        {
            return a.size();
        }
    }

    public void c(boolean flag)
    {
        if (!flag)
        {
            c = null;
        }
    }

    public Map d()
    {
        return a;
    }

    public void e()
    {
        a = null;
    }

    public boolean f()
    {
        return a != null;
    }

    public bz g()
    {
        return a();
    }

    public int h()
    {
        if (b == null)
        {
            return 0;
        } else
        {
            return b.size();
        }
    }

    public Iterator i()
    {
        if (b == null)
        {
            return null;
        } else
        {
            return b.iterator();
        }
    }

    public List j()
    {
        return b;
    }

    public void k()
    {
        b = null;
    }

    public boolean l()
    {
        return b != null;
    }

    public String m()
    {
        return c;
    }

    public void n()
    {
        c = null;
    }

    public boolean o()
    {
        return c != null;
    }

    public void p()
    {
        if (a == null)
        {
            throw new cz((new StringBuilder("Required field 'snapshots' was not present! Struct: ")).append(toString()).toString());
        } else
        {
            return;
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("IdTracking(");
        stringbuilder.append("snapshots:");
        if (a == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(a);
        }
        if (l())
        {
            stringbuilder.append(", ");
            stringbuilder.append("journals:");
            if (b == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(b);
            }
        }
        if (o())
        {
            stringbuilder.append(", ");
            stringbuilder.append("checksum:");
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
        i.put(u/aly/di, new aL(null));
        i.put(u/aly/dj, new aN(null));
        EnumMap enummap = new EnumMap(u/aly/as$e);
        enummap.put(e.a, new cl("snapshots", (byte)1, new co((byte)13, new cm((byte)11), new cq((byte)12, u/aly/ar))));
        enummap.put(e.b, new cl("journals", (byte)2, new cn((byte)15, new cq((byte)12, u/aly/aq))));
        enummap.put(e.c, new cl("checksum", (byte)2, new cm((byte)11)));
        d = Collections.unmodifiableMap(enummap);
        cl.a(u/aly/as, d);
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

        public static e a(String s1)
        {
            return (e)d.get(s1);
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
            return (e)Enum.valueOf(u/aly/as$e, s1);
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
            a = new e("SNAPSHOTS", 0, (short)1, "snapshots");
            b = new e("JOURNALS", 1, (short)2, "journals");
            c = new e("CHECKSUM", 2, (short)3, "checksum");
            e ae[] = new e[3];
            ae[0] = a;
            ae[1] = b;
            ae[2] = c;
            g = ae;
            d = new HashMap();
            Iterator iterator = EnumSet.allOf(u/aly/as$e).iterator();
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

        private e(String s1, int i1, short word0, String s2)
        {
            super(s1, i1);
            e = word0;
            f = s2;
        }
    }

}
