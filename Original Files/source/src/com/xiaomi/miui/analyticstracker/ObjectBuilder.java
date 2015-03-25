// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.miui.analyticstracker;

import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.xiaomi.miui.analyticstracker:
//            c

public class ObjectBuilder
{

    private ArrayList a;

    public ObjectBuilder()
    {
        a = new ArrayList();
    }

    public Object buildObject(String s)
    {
        Object obj;
        Iterator iterator;
        obj = null;
        iterator = a.iterator();
_L2:
        c c1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_88;
        }
        c1 = (c)iterator.next();
        if (!c1.b.equals(s))
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj2 = c1.a.newInstance();
        Object obj1 = obj2;
_L3:
        obj = obj1;
        if (true) goto _L2; else goto _L1
        InstantiationException instantiationexception;
        instantiationexception;
        instantiationexception.printStackTrace();
        obj1 = obj;
          goto _L3
        IllegalAccessException illegalaccessexception;
        illegalaccessexception;
        illegalaccessexception.printStackTrace();
_L1:
        obj1 = obj;
          goto _L3
        return obj;
    }

    public boolean registerClass(Class class1, String s)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext();)
        {
            if (s.equals(((c)iterator.next()).b))
            {
                return false;
            }
        }

        return a.add(new c(this, class1, s));
    }
}
