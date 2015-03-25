// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.util;


public class SparseArrayCompat
{

    private static final Object a = new Object();
    private boolean b;
    private int c[];
    private Object d[];
    private int e;

    public SparseArrayCompat()
    {
        this(10);
    }

    public SparseArrayCompat(int i)
    {
        b = false;
        int j = b(i);
        c = new int[j];
        d = new Object[j];
        e = 0;
    }

    static int a(int i)
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

    private static int a(int ai[], int i, int j, int k)
    {
        int l = i + j;
        int i1 = i - 1;
        int j1;
        for (j1 = l; j1 - i1 > 1;)
        {
            int k1 = (j1 + i1) / 2;
            if (ai[k1] < k)
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
        if (ai[j1] != k)
        {
            return ~j1;
        }
        return j1;
    }

    private void a()
    {
        int i = e;
        int ai[] = c;
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
                ai[k] = ai[j];
                aobj[k] = obj;
            }
            k++;
        }

        b = false;
        e = k;
    }

    static int b(int i)
    {
        return a(i * 4) / 4;
    }

    public void append(int i, Object obj)
    {
        if (e != 0 && i <= c[-1 + e])
        {
            put(i, obj);
            return;
        }
        if (b && e >= c.length)
        {
            a();
        }
        int j = e;
        if (j >= c.length)
        {
            int k = b(j + 1);
            int ai[] = new int[k];
            Object aobj[] = new Object[k];
            System.arraycopy(c, 0, ai, 0, c.length);
            System.arraycopy(((Object) (d)), 0, ((Object) (aobj)), 0, d.length);
            c = ai;
            d = aobj;
        }
        c[j] = i;
        d[j] = obj;
        e = j + 1;
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

    public void delete(int i)
    {
        int j = a(c, 0, e, i);
        if (j >= 0 && d[j] != a)
        {
            d[j] = a;
            b = true;
        }
    }

    public Object get(int i)
    {
        return get(i, null);
    }

    public Object get(int i, Object obj)
    {
        int j = a(c, 0, e, i);
        if (j < 0 || d[j] == a)
        {
            return obj;
        } else
        {
            return d[j];
        }
    }

    public int indexOfKey(int i)
    {
        if (b)
        {
            a();
        }
        return a(c, 0, e, i);
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

    public int keyAt(int i)
    {
        if (b)
        {
            a();
        }
        return c[i];
    }

    public void put(int i, Object obj)
    {
        int j = a(c, 0, e, i);
        if (j >= 0)
        {
            d[j] = obj;
            return;
        }
        int k = ~j;
        if (k < e && d[k] == a)
        {
            c[k] = i;
            d[k] = obj;
            return;
        }
        if (b && e >= c.length)
        {
            a();
            k = -1 ^ a(c, 0, e, i);
        }
        if (e >= c.length)
        {
            int l = b(1 + e);
            int ai[] = new int[l];
            Object aobj[] = new Object[l];
            System.arraycopy(c, 0, ai, 0, c.length);
            System.arraycopy(((Object) (d)), 0, ((Object) (aobj)), 0, d.length);
            c = ai;
            d = aobj;
        }
        if (e - k != 0)
        {
            System.arraycopy(c, k, c, k + 1, e - k);
            System.arraycopy(((Object) (d)), k, ((Object) (d)), k + 1, e - k);
        }
        c[k] = i;
        d[k] = obj;
        e = 1 + e;
    }

    public void remove(int i)
    {
        delete(i);
    }

    public void removeAt(int i)
    {
        if (d[i] != a)
        {
            d[i] = a;
            b = true;
        }
    }

    public void removeAtRange(int i, int j)
    {
        for (int k = Math.min(e, i + j); i < k; i++)
        {
            removeAt(i);
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
