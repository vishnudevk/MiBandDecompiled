// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package u.aly:
//            u, s, aa

public class l
{

    private final String a = "umeng_event_snapshot";
    private boolean b;
    private SharedPreferences c;
    private Map d;

    public l(Context context)
    {
        b = false;
        d = new HashMap();
        c = u.a(context, "umeng_event_snapshot");
    }

    private void c(String s1)
    {
        boolean flag;
        String s2;
        flag = d.containsKey(s1);
        s2 = null;
        if (!flag) goto _L2; else goto _L1
_L1:
        ArrayList arraylist = (ArrayList)d.get(s1);
_L6:
        if (arraylist.size() > 4) goto _L4; else goto _L3
_L3:
        s2 = s.a(arraylist);
_L2:
        c.edit().putString(s1, s2).commit();
        return;
_L4:
        arraylist.remove(0);
        if (true) goto _L6; else goto _L5
_L5:
    }

    private boolean d(String s1)
    {
        if (d.containsKey(s1))
        {
            return true;
        }
        String s2 = c.getString(s1, null);
        if (s2 != null)
        {
            ArrayList arraylist = (ArrayList)s.a(s2);
            if (arraylist != null)
            {
                d.put(s1, arraylist);
                return true;
            }
        }
        return false;
    }

    public int a(String s1)
    {
        if (d.containsKey(s1))
        {
            return ((ArrayList)d.get(s1)).size();
        } else
        {
            return 0;
        }
    }

    public void a(String s1, aa aa1)
    {
        if (b)
        {
            d(s1);
        }
        if (d.containsKey(s1))
        {
            ((ArrayList)d.get(s1)).add(aa1);
        } else
        {
            ArrayList arraylist = new ArrayList();
            arraylist.add(aa1);
            d.put(s1, arraylist);
        }
        if (b)
        {
            c(s1);
        }
    }

    public void a(boolean flag)
    {
        b = flag;
    }

    public aa b(String s1)
    {
        if (b)
        {
            d(s1);
        }
        if (!d.containsKey(s1)) goto _L2; else goto _L1
_L1:
        ArrayList arraylist = (ArrayList)d.get(s1);
        if (arraylist.size() <= 0) goto _L2; else goto _L3
_L3:
        aa aa1 = (aa)arraylist.remove(-1 + arraylist.size());
_L5:
        if (b)
        {
            c(s1);
        }
        return aa1;
_L2:
        aa1 = null;
        if (true) goto _L5; else goto _L4
_L4:
    }
}
