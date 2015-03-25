// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.util;


public class LongSparseArray
    implements Cloneable
{

    private static final Object a = new Object();
    private boolean b;
    private long c[];
    private Object d[];
    private int e;

    public LongSparseArray()
    {
        this(10);
    }

    public LongSparseArray(int i)
    {
        b = false;
        int j = idealLongArraySize(i);
        c = new long[j];
        d = new Object[j];
        e = 0;
    }

    private static int a(long al[], int i, int j, long l)
    {
        int k = i + j;
        int i1 = i - 1;
        int j1;
        for (j1 = k; j1 - i1 > 1;)
        {
            int k1 = (j1 + i1) / 2;
            if (al[k1] < l)
            {
                i1 = k1;
            } else
            {
                j1 = k1;
            }
        }

        if (j1 == i + j)
        {
            j1 = -1 ^ i + j;
        } else
        if (al[j1] != l)
        {
            return ~j1;
        }
        return j1;
    }

    private void a()
    {
        int i = e;
        long al[] = c;
        Object aobj[] = d;
        int j = 0;
        int k = 0;
        for (; j < i; j++)
        {
            Object obj = aobj[j];
            if (obj == a)
            {
                continue;
            }
            if (j != k)
            {
                al[k] = al[j];
                aobj[k] = obj;
                aobj[j] = null;
            }
            k++;
        }

        b = false;
        e = k;
    }

    public static int idealByteArraySize(int i)
    {
        int j = 4;
        do
        {
label0:
            {
                if (j < 32)
                {
                    if (i > -12 + (1 << j))
                    {
                        break label0;
                    }
                    i = -12 + (1 << j);
                }
                return i;
            }
            j++;
        } while (true);
    }

    public static int idealLongArraySize(int i)
    {
        return idealByteArraySize(i * 8) / 8;
    }

    public void append(long l, Object obj)
    {
        if (e != 0 && l <= c[-1 + e])
        {
            put(l, obj);
            return;
        }
        if (b && e >= c.length)
        {
            a();
        }
        int i = e;
        if (i >= c.length)
        {
            int j = idealLongArraySize(i + 1);
            long al[] = new long[j];
            Object aobj[] = new Object[j];
            System.arraycopy(c, 0, al, 0, c.length);
            System.arraycopy(((Object) (d)), 0, ((Object) (aobj)), 0, d.length);
            c = al;
            d = aobj;
        }
        c[i] = l;
        d[i] = obj;
        e = i + 1;
    }

    public void clear()
    {
        int i = e;
        Object aobj[] = d;
        for (int j = 0; j < i; j++)
        {
            aobj[j] = null;
        }

        e = 0;
        b = false;
    }

    public LongSparseArray clone()
    {
        LongSparseArray longsparsearray;
        try
        {
            longsparsearray = (LongSparseArray)super.clone();
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            return null;
        }
        try
        {
            longsparsearray.c = (long[])c.clone();
            longsparsearray.d = (Object[])((Object []) (d)).clone();
        }
        catch (CloneNotSupportedException clonenotsupportedexception1)
        {
            return longsparsearray;
        }
        return longsparsearray;
    }

    public volatile Object clone()
    {
        return clone();
    }

    public void delete(long l)
    {
        int i = a(c, 0, e, l);
        if (i >= 0 && d[i] != a)
        {
            d[i] = a;
            b = true;
        }
    }

    public Object get(long l)
    {
        return get(l, null);
    }

    public Object get(long l, Object obj)
    {
        int i = a(c, 0, e, l);
        if (i < 0 || d[i] == a)
        {
            return obj;
        } else
        {
            return d[i];
        }
    }

    public int indexOfKey(long l)
    {
        if (b)
        {
            a();
        }
        return a(c, 0, e, l);
    }

    public int indexOfValue(Object obj)
    {
        if (b)
        {
            a();
        }
        for (int i = 0; i < e; i++)
        {
            if (d[i] == obj)
            {
                return i;
            }
        }

        return -1;
    }

    public long keyAt(int i)
    {
        if (b)
        {
            a();
        }
        return c[i];
    }

    public void put(long l, Object obj)
    {
        int i = a(c, 0, e, l);
        if (i >= 0)
        {
            d[i] = obj;
            return;
        }
        int j = ~i;
        if (j < e && d[j] == a)
        {
            c[j] = l;
            d[j] = obj;
            return;
        }
        if (b && e >= c.length)
        {
            a();
            j = -1 ^ a(c, 0, e, l);
        }
        if (e >= c.length)
        {
            int k = idealLongArraySize(1 + e);
            long al[] = new long[k];
            Object aobj[] = new Object[k];
            System.arraycopy(c, 0, al, 0, c.length);
            System.arraycopy(((Object) (d)), 0, ((Object) (aobj)), 0, d.length);
            c = al;
            d = aobj;
        }
        if (e - j != 0)
        {
            System.arraycopy(c, j, c, j + 1, e - j);
            System.arraycopy(((Object) (d)), j, ((Object) (d)), j + 1, e - j);
        }
        c[j] = l;
        d[j] = obj;
        e = 1 + e;
    }

    public void remove(long l)
    {
        delete(l);
    }

    public void removeAt(int i)
    {
        if (d[i] != a)
        {
            d[i] = a;
            b = true;
        }
    }

    public void setValueAt(int i, Object obj)
    {
        if (b)
        {
            a();
        }
        d[i] = obj;
    }

    public int size()
    {
        if (b)
        {
            a();
        }
        return e;
    }

    public Object valueAt(int i)
    {
        if (b)
        {
            a();
        }
        return d[i];
    }

}
