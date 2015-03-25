// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.utils;

import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.nostra13.universalimageloader.utils:
//            b

public final class MemoryCacheUtils
{

    private static final String a = "_";
    private static final String b = "x";

    private MemoryCacheUtils()
    {
    }

    public static Comparator createFuzzyKeyComparator()
    {
        return new b();
    }

    public static List findCacheKeysForImageUri(String s, MemoryCache memorycache)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = memorycache.keys().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s1 = (String)iterator.next();
            if (s1.startsWith(s))
            {
                arraylist.add(s1);
            }
        } while (true);
        return arraylist;
    }

    public static List findCachedBitmapsForImageUri(String s, MemoryCache memorycache)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = memorycache.keys().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s1 = (String)iterator.next();
            if (s1.startsWith(s))
            {
                arraylist.add(memorycache.get(s1));
            }
        } while (true);
        return arraylist;
    }

    public static String generateKey(String s, ImageSize imagesize)
    {
        return (new StringBuilder(s)).append("_").append(imagesize.getWidth()).append("x").append(imagesize.getHeight()).toString();
    }

    public static void removeFromCache(String s, MemoryCache memorycache)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = memorycache.keys().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s1 = (String)iterator.next();
            if (s1.startsWith(s))
            {
                arraylist.add(s1);
            }
        } while (true);
        for (Iterator iterator1 = arraylist.iterator(); iterator1.hasNext(); memorycache.remove((String)iterator1.next())) { }
    }
}
