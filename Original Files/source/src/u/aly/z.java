// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package u.aly:
//            ae, u, x, bj

public class z
{

    private static final String a = "activities";
    private final Map b = new HashMap();
    private final ArrayList c = new ArrayList();

    public z()
    {
    }

    public static List a(SharedPreferences sharedpreferences)
    {
        String s = sharedpreferences.getString("activities", "");
        if (!"".equals(s)) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        ArrayList arraylist = new ArrayList();
        String as[] = s.split(";");
        int i = 0;
_L5:
        int j = as.length;
        if (i < j)
        {
            break MISSING_BLOCK_LABEL_62;
        }
_L4:
        if (arraylist.size() <= 0) goto _L1; else goto _L3
_L3:
        return arraylist;
label0:
        {
            String s1 = as[i];
            if (TextUtils.isEmpty(s1))
            {
                break label0;
            }
            try
            {
                arraylist.add(new ae(s1));
                break label0;
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }
          goto _L4
          goto _L1
        i++;
          goto _L5
    }

    public void a()
    {
        Map map = b;
        map;
        JVM INSTR monitorenter ;
        Iterator iterator = b.entrySet().iterator();
        String s;
        long l;
        s = null;
        l = 0L;
_L2:
        if (iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_51;
        }
        map;
        JVM INSTR monitorexit ;
        if (s != null)
        {
            b(s);
        }
        return;
        long l1;
        java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
        if (((Long)entry.getValue()).longValue() <= l)
        {
            continue; /* Loop/switch isn't completed */
        }
        l1 = ((Long)entry.getValue()).longValue();
        s = (String)entry.getKey();
        l = l1;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(Context context)
    {
        SharedPreferences sharedpreferences;
        android.content.SharedPreferences.Editor editor;
        sharedpreferences = u.a(context);
        editor = sharedpreferences.edit();
        if (c.size() <= 0) goto _L2; else goto _L1
_L1:
        StringBuilder stringbuilder;
        String s = sharedpreferences.getString("activities", "");
        stringbuilder = new StringBuilder();
        if (!TextUtils.isEmpty(s))
        {
            stringbuilder.append(s);
            stringbuilder.append(";");
        }
        ArrayList arraylist = c;
        arraylist;
        JVM INSTR monitorenter ;
        Iterator iterator = c.iterator();
_L3:
        if (iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_149;
        }
        c.clear();
        stringbuilder.deleteCharAt(-1 + stringbuilder.length());
        editor.remove("activities");
        editor.putString("activities", stringbuilder.toString());
_L2:
        editor.commit();
        return;
        x x1 = (x)iterator.next();
        Object aobj[] = new Object[2];
        aobj[0] = x1.a;
        aobj[1] = Long.valueOf(x1.b);
        stringbuilder.append(String.format("[\"%s\",%d]", aobj));
        stringbuilder.append(";");
          goto _L3
        Exception exception;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            synchronized (b)
            {
                b.put(s, Long.valueOf(System.currentTimeMillis()));
            }
            return;
        } else
        {
            return;
        }
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void b(String s)
    {
        Long long1;
        if (!TextUtils.isEmpty(s))
        {
            synchronized (b)
            {
                long1 = (Long)b.remove(s);
            }
            if (long1 != null)
            {
                break MISSING_BLOCK_LABEL_60;
            }
            bj.e("MobclickAgent", String.format("please call 'onPageStart(%s)' before onPageEnd", new Object[] {
                s
            }));
        }
        return;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
        long l = System.currentTimeMillis() - long1.longValue();
        synchronized (c)
        {
            c.add(new x(s, l));
        }
        return;
        exception1;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception1;
    }
}
