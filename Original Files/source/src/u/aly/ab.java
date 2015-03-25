// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package u.aly:
//            ao, p, aa, az, 
//            bf, av

public class ab extends ao
    implements p
{

    public ab(String s, Map map, long l, int i)
    {
        a(s);
        b(System.currentTimeMillis());
        if (map.size() > 0)
        {
            a(b(map));
        }
        if (i <= 0)
        {
            i = 1;
        }
        a(i);
        if (l > 0L)
        {
            a(l);
        }
    }

    public static aa a(String s, String s1, Map map)
    {
        aa aa1 = new aa();
        aa1.b = s;
        aa1.c = s1;
        aa1.d = map;
        return aa1;
    }

    public static String b(String s, String s1, Map map)
    {
        return (new StringBuilder(String.valueOf(s))).append(s1).toString();
    }

    private HashMap b(Map map)
    {
        Iterator iterator;
        HashMap hashmap;
        int i;
        iterator = map.entrySet().iterator();
        hashmap = new HashMap();
        i = 0;
_L2:
        java.util.Map.Entry entry;
        az az1;
        Object obj;
        if (i >= 10 || !iterator.hasNext())
        {
            return hashmap;
        }
        entry = (java.util.Map.Entry)iterator.next();
        az1 = new az();
        obj = entry.getValue();
        if (!(obj instanceof String))
        {
            break; /* Loop/switch isn't completed */
        }
        az1.b((String)obj);
_L3:
        if (az1.l())
        {
            hashmap.put((String)entry.getKey(), az1);
            i++;
        }
        if (true) goto _L2; else goto _L1
_L1:
        if (obj instanceof Long)
        {
            az1.b(((Long)obj).longValue());
        } else
        if (obj instanceof Integer)
        {
            az1.b(((Integer)obj).longValue());
        } else
        if (obj instanceof Float)
        {
            az1.b(((Float)obj).longValue());
        } else
        if (obj instanceof Double)
        {
            az1.b(((Double)obj).longValue());
        }
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
    }

    public void a(bf bf1, String s)
    {
        if (bf1.s() <= 0) goto _L2; else goto _L1
_L1:
        Iterator iterator = bf1.u().iterator();
_L5:
        if (iterator.hasNext()) goto _L3; else goto _L2
_L2:
        av av1 = null;
_L4:
        if (av1 == null)
        {
            av1 = new av();
            av1.a(s);
            bf1.a(av1);
        }
        av1.a(this);
        return;
_L3:
        av1 = (av)iterator.next();
        if (!s.equals(av1.c())) goto _L5; else goto _L4
    }
}
