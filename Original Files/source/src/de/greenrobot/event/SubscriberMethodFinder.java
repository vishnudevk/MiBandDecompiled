// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.event;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package de.greenrobot.event:
//            EventBusException, ThreadMode, SubscriberMethod

class SubscriberMethodFinder
{

    private static final Map methodCache = new HashMap();
    private static final Map skipMethodNameVerificationForClasses = new ConcurrentHashMap();

    SubscriberMethodFinder()
    {
    }

    static void clearCaches()
    {
        methodCache.clear();
    }

    public static void clearSkipMethodNameVerifications()
    {
        skipMethodNameVerificationForClasses.clear();
    }

    static void skipMethodNameVerificationFor(Class class1)
    {
        if (!methodCache.isEmpty())
        {
            throw new IllegalStateException("This method must be called before registering anything");
        } else
        {
            skipMethodNameVerificationForClasses.put(class1, class1);
            return;
        }
    }

    List findSubscriberMethods(Class class1, String s)
    {
        String s1;
        s1 = (new StringBuilder(String.valueOf(class1.getName()))).append('.').append(s).toString();
        List list;
        synchronized (methodCache)
        {
            list = (List)methodCache.get(s1);
        }
        if (list != null)
        {
            return list;
        }
        break MISSING_BLOCK_LABEL_68;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
        ArrayList arraylist;
        HashSet hashset;
        StringBuilder stringbuilder;
        Class class2;
        arraylist = new ArrayList();
        hashset = new HashSet();
        stringbuilder = new StringBuilder();
        class2 = class1;
_L6:
        Method amethod[];
        int i;
        int j;
        String s2;
        while (class2 == null || ((s2 = class2.getName()).startsWith("java.") || s2.startsWith("javax.") || s2.startsWith("android."))) 
        {
            if (arraylist.isEmpty())
            {
                throw new EventBusException((new StringBuilder("Subscriber ")).append(class1).append(" has no methods called ").append(s).toString());
            }
            break MISSING_BLOCK_LABEL_444;
        }
        amethod = class2.getDeclaredMethods();
        i = amethod.length;
        j = 0;
_L2:
        Method method;
        if (j >= i)
        {
            class2 = class2.getSuperclass();
            continue; /* Loop/switch isn't completed */
        }
        method = amethod[j];
        String s3 = method.getName();
        if (s3.startsWith(s))
        {
            Class aclass[] = method.getParameterTypes();
            if (aclass.length == 1)
            {
                String s4 = s3.substring(s.length());
                ThreadMode threadmode;
                Class class3;
                if (s4.length() == 0)
                {
                    threadmode = ThreadMode.PostThread;
                } else
                if (s4.equals("MainThread"))
                {
                    threadmode = ThreadMode.MainThread;
                } else
                if (s4.equals("BackgroundThread"))
                {
                    threadmode = ThreadMode.BackgroundThread;
                } else
                {
                    if (!s4.equals("Async"))
                    {
                        continue; /* Loop/switch isn't completed */
                    }
                    threadmode = ThreadMode.Async;
                }
                class3 = aclass[0];
                stringbuilder.setLength(0);
                stringbuilder.append(s3);
                stringbuilder.append('>').append(class3.getName());
                if (hashset.add(stringbuilder.toString()))
                {
                    arraylist.add(new SubscriberMethod(method, threadmode, class3));
                }
            }
        }
_L4:
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        if (skipMethodNameVerificationForClasses.containsKey(class2)) goto _L4; else goto _L3
_L3:
        throw new EventBusException((new StringBuilder("Illegal onEvent method, check for typos: ")).append(method).toString());
        synchronized (methodCache)
        {
            methodCache.put(s1, arraylist);
        }
        return arraylist;
        exception1;
        map1;
        JVM INSTR monitorexit ;
        throw exception1;
        if (true) goto _L6; else goto _L5
_L5:
    }

}
