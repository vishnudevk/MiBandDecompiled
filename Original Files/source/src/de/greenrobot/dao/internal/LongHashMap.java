// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao.internal;

import de.greenrobot.dao.DaoLog;
import java.util.Arrays;

public final class LongHashMap
{

    private int capacity;
    private int size;
    private Entry table[];
    private int threshold;

    public LongHashMap()
    {
        this(16);
    }

    public LongHashMap(int i)
    {
        capacity = i;
        threshold = (i * 4) / 3;
        table = new Entry[i];
    }

    public void clear()
    {
        size = 0;
        Arrays.fill(table, null);
    }

    public boolean containsKey(long l)
    {
        int i = (0x7fffffff & ((int)(l >>> 32) ^ (int)l)) % capacity;
        for (Entry entry = table[i]; entry != null; entry = entry.next)
        {
            if (entry.key == l)
            {
                return true;
            }
        }

        return false;
    }

    public Object get(long l)
    {
        int i = (0x7fffffff & ((int)(l >>> 32) ^ (int)l)) % capacity;
        for (Entry entry = table[i]; entry != null; entry = entry.next)
        {
            if (entry.key == l)
            {
                return entry.value;
            }
        }

        return null;
    }

    public void logStats()
    {
        Entry aentry[] = table;
        int i = aentry.length;
        int j = 0;
        int k = 0;
        for (; j < i; j++)
        {
            for (Entry entry = aentry[j]; entry != null && entry.next != null; entry = entry.next)
            {
                k++;
            }

        }

        DaoLog.d((new StringBuilder()).append("load: ").append((float)size / (float)capacity).append(", size: ").append(size).append(", capa: ").append(capacity).append(", collisions: ").append(k).append(", collision ratio: ").append((float)k / (float)size).toString());
    }

    public Object put(long l, Object obj)
    {
        int i = (0x7fffffff & ((int)(l >>> 32) ^ (int)l)) % capacity;
        Entry entry = table[i];
        for (Entry entry1 = entry; entry1 != null; entry1 = entry1.next)
        {
            if (entry1.key == l)
            {
                Object obj1 = entry1.value;
                entry1.value = obj;
                return obj1;
            }
        }

        table[i] = new Entry(l, obj, entry);
        size = 1 + size;
        if (size > threshold)
        {
            setCapacity(2 * capacity);
        }
        return null;
    }

    public Object remove(long l)
    {
        int i = (0x7fffffff & ((int)(l >>> 32) ^ (int)l)) % capacity;
        Entry entry = table[i];
        Entry entry1 = null;
        do
        {
            Entry entry2;
label0:
            {
                Object obj = null;
                if (entry != null)
                {
                    entry2 = entry.next;
                    if (entry.key != l)
                    {
                        break label0;
                    }
                    if (entry1 == null)
                    {
                        table[i] = entry2;
                    } else
                    {
                        entry1.next = entry2;
                    }
                    size = -1 + size;
                    obj = entry.value;
                }
                return obj;
            }
            entry1 = entry;
            entry = entry2;
        } while (true);
    }

    public void reserveRoom(int i)
    {
        setCapacity((i * 5) / 3);
    }

    public void setCapacity(int i)
    {
        Entry aentry[] = new Entry[i];
        int j = table.length;
        for (int k = 0; k < j; k++)
        {
            Entry entry1;
            for (Entry entry = table[k]; entry != null; entry = entry1)
            {
                long l = entry.key;
                int i1 = (0x7fffffff & ((int)(l >>> 32) ^ (int)l)) % i;
                entry1 = entry.next;
                entry.next = aentry[i1];
                aentry[i1] = entry;
            }

        }

        table = aentry;
        capacity = i;
        threshold = (i * 4) / 3;
    }

    public int size()
    {
        return size;
    }

    private class Entry
    {

        final long key;
        Entry next;
        Object value;

        Entry(long l, Object obj, Entry entry)
        {
            key = l;
            value = obj;
            next = entry;
        }
    }

}
