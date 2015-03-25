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
//            aX, dj, aZ, cl, 
//            cm, cn, cq, am, 
//            ao, cf, cs, dk, 
//            cy, dh, dg, cz, 
//            cg

public class av
    implements Serializable, Cloneable, bz
{

    public static final Map e;
    private static final dd f = new dd("InstantMsg");
    private static final ct g = new ct("id", (byte)11, (short)1);
    private static final ct h = new ct("errors", (byte)15, (short)2);
    private static final ct i = new ct("events", (byte)15, (short)3);
    private static final ct j = new ct("game_events", (byte)15, (short)4);
    private static final Map k;
    public String a;
    public List b;
    public List c;
    public List d;
    private e l[];

    public av()
    {
        e ae[] = new e[3];
        ae[0] = e.b;
        ae[1] = e.c;
        ae[2] = e.d;
        l = ae;
    }

    public av(String s1)
    {
        this();
        a = s1;
    }

    public av(av av1)
    {
        e ae[] = new e[3];
        ae[0] = e.b;
        ae[1] = e.c;
        ae[2] = e.d;
        l = ae;
        if (av1.e())
        {
            a = av1.a;
        }
        if (!av1.k()) goto _L2; else goto _L1
_L1:
        ArrayList arraylist;
        Iterator iterator;
        arraylist = new ArrayList();
        iterator = av1.b.iterator();
_L6:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        b = arraylist;
_L2:
        if (av1.p())
        {
            ArrayList arraylist1 = new ArrayList();
            for (Iterator iterator1 = av1.c.iterator(); iterator1.hasNext(); arraylist1.add(new ao((ao)iterator1.next())))
            {
                break MISSING_BLOCK_LABEL_202;
            }

            c = arraylist1;
        }
        if (av1.u())
        {
            ArrayList arraylist2 = new ArrayList();
            for (Iterator iterator2 = av1.d.iterator(); iterator2.hasNext(); arraylist2.add(new ao((ao)iterator2.next())))
            {
                break MISSING_BLOCK_LABEL_230;
            }

            d = arraylist2;
        }
        return;
_L4:
        arraylist.add(new am((am)iterator.next()));
        if (true) goto _L6; else goto _L5
_L5:
    }

    static ct A()
    {
        return j;
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

    static dd w()
    {
        return f;
    }

    static ct x()
    {
        return g;
    }

    static ct y()
    {
        return h;
    }

    static ct z()
    {
        return i;
    }

    public e a(int i1)
    {
        return e.a(i1);
    }

    public av a()
    {
        return new av(this);
    }

    public av a(String s1)
    {
        a = s1;
        return this;
    }

    public av a(List list)
    {
        b = list;
        return this;
    }

    public void a(am am1)
    {
        if (b == null)
        {
            b = new ArrayList();
        }
        b.add(am1);
    }

    public void a(ao ao1)
    {
        if (c == null)
        {
            c = new ArrayList();
        }
        c.add(ao1);
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

    public av b(List list)
    {
        c = list;
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
    }

    public void b(ao ao1)
    {
        if (d == null)
        {
            d = new ArrayList();
        }
        d.add(ao1);
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

    public av c(List list)
    {
        d = list;
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

    public Iterator h()
    {
        if (b == null)
        {
            return null;
        } else
        {
            return b.iterator();
        }
    }

    public List i()
    {
        return b;
    }

    public void j()
    {
        b = null;
    }

    public boolean k()
    {
        return b != null;
    }

    public int l()
    {
        if (c == null)
        {
            return 0;
        } else
        {
            return c.size();
        }
    }

    public Iterator m()
    {
        if (c == null)
        {
            return null;
        } else
        {
            return c.iterator();
        }
    }

    public List n()
    {
        return c;
    }

    public void o()
    {
        c = null;
    }

    public boolean p()
    {
        return c != null;
    }

    public int q()
    {
        if (d == null)
        {
            return 0;
        } else
        {
            return d.size();
        }
    }

    public Iterator r()
    {
        if (d == null)
        {
            return null;
        } else
        {
            return d.iterator();
        }
    }

    public List s()
    {
        return d;
    }

    public void t()
    {
        d = null;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("InstantMsg(");
        stringbuilder.append("id:");
        if (a == null)
        {
            stringbuilder.append("null");
        } else
        {
            stringbuilder.append(a);
        }
        if (k())
        {
            stringbuilder.append(", ");
            stringbuilder.append("errors:");
            if (b == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(b);
            }
        }
        if (p())
        {
            stringbuilder.append(", ");
            stringbuilder.append("events:");
            if (c == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(c);
            }
        }
        if (u())
        {
            stringbuilder.append(", ");
            stringbuilder.append("game_events:");
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

    public boolean u()
    {
        return d != null;
    }

    public void v()
    {
        if (a == null)
        {
            throw new cz((new StringBuilder("Required field 'id' was not present! Struct: ")).append(toString()).toString());
        } else
        {
            return;
        }
    }

    static 
    {
        k = new HashMap();
        k.put(u/aly/di, new aX(null));
        k.put(u/aly/dj, new aZ(null));
        EnumMap enummap = new EnumMap(u/aly/av$e);
        enummap.put(e.a, new cl("id", (byte)1, new cm((byte)11)));
        enummap.put(e.b, new cl("errors", (byte)2, new cn((byte)15, new cq((byte)12, u/aly/am))));
        enummap.put(e.c, new cl("events", (byte)2, new cn((byte)15, new cq((byte)12, u/aly/ao))));
        enummap.put(e.d, new cl("game_events", (byte)2, new cn((byte)15, new cq((byte)12, u/aly/ao))));
        e = Collections.unmodifiableMap(enummap);
        cl.a(u/aly/av, e);
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
            return (e)Enum.valueOf(u/aly/av$e, s1);
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
            a = new e("ID", 0, (short)1, "id");
            b = new e("ERRORS", 1, (short)2, "errors");
            c = new e("EVENTS", 2, (short)3, "events");
            d = new e("GAME_EVENTS", 3, (short)4, "game_events");
            e ae[] = new e[4];
            ae[0] = a;
            ae[1] = b;
            ae[2] = c;
            ae[3] = d;
            h = ae;
            e = new HashMap();
            Iterator iterator = EnumSet.allOf(u/aly/av$e).iterator();
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
