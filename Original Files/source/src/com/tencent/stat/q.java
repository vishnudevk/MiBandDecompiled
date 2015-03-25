// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.stat;

import com.tencent.stat.common.StatLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.tencent.stat:
//            StatStore, StatConfig, t, c, 
//            r

class q
    implements Runnable
{

    final int a;
    final StatStore b;

    q(StatStore statstore, int i)
    {
        b = statstore;
        a = i;
        super();
    }

    public void run()
    {
        if (b.b != 0)
        {
            StatStore.b().i((new StringBuilder()).append("Load ").append(Integer.toString(b.b)).append(" unsent events").toString());
            ArrayList arraylist = new ArrayList();
            ArrayList arraylist1 = new ArrayList();
            int i = a;
            int j;
            StatStore statstore;
            if (i == -1 || i > StatConfig.a())
            {
                j = StatConfig.a();
            } else
            {
                j = i;
            }
            statstore = b;
            statstore.b = statstore.b - j;
            StatStore.b(b, arraylist1, j);
            StatStore.b().i((new StringBuilder()).append("Peek ").append(Integer.toString(arraylist1.size())).append(" unsent events.").toString());
            if (!arraylist1.isEmpty())
            {
                StatStore.a(b, arraylist1, 2);
                for (Iterator iterator = arraylist1.iterator(); iterator.hasNext(); arraylist.add(((t)iterator.next()).b)) { }
                c.b().b(arraylist, new r(this, arraylist1, j));
                return;
            }
        }
    }
}
