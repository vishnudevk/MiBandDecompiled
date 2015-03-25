// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Set;

// Referenced classes of package com.google.gson.internal:
//            q, w, r, t

public final class LinkedTreeMap extends AbstractMap
    implements Serializable
{

    static final boolean f;
    private static final Comparator g = new q();
    Comparator a;
    w b;
    int c;
    int d;
    final w e;
    private r h;
    private t i;

    public LinkedTreeMap()
    {
        this(g);
    }

    public LinkedTreeMap(Comparator comparator)
    {
        c = 0;
        d = 0;
        e = new w();
        if (comparator == null)
        {
            comparator = g;
        }
        a = comparator;
    }

    private void a(w w1)
    {
        w w2 = w1.b;
        w w3 = w1.c;
        w w4 = w3.b;
        w w5 = w3.c;
        w1.c = w4;
        if (w4 != null)
        {
            w4.a = w1;
        }
        a(w1, w3);
        w3.b = w1;
        w1.a = w3;
        int j;
        int k;
        int l;
        int i1;
        if (w2 != null)
        {
            j = w2.h;
        } else
        {
            j = 0;
        }
        if (w4 != null)
        {
            k = w4.h;
        } else
        {
            k = 0;
        }
        w1.h = 1 + Math.max(j, k);
        l = w1.h;
        i1 = 0;
        if (w5 != null)
        {
            i1 = w5.h;
        }
        w3.h = 1 + Math.max(l, i1);
    }

    private void a(w w1, w w2)
    {
        w w3 = w1.a;
        w1.a = null;
        if (w2 != null)
        {
            w2.a = w3;
        }
        if (w3 != null)
        {
            if (w3.b == w1)
            {
                w3.b = w2;
                return;
            }
            if (!f && w3.c != w1)
            {
                throw new AssertionError();
            } else
            {
                w3.c = w2;
                return;
            }
        } else
        {
            b = w2;
            return;
        }
    }

    private boolean a(Object obj, Object obj1)
    {
        return obj == obj1 || obj != null && obj.equals(obj1);
    }

    private void b(w w1)
    {
        w w2 = w1.b;
        w w3 = w1.c;
        w w4 = w2.b;
        w w5 = w2.c;
        w1.b = w5;
        if (w5 != null)
        {
            w5.a = w1;
        }
        a(w1, w2);
        w2.c = w1;
        w1.a = w2;
        int j;
        int k;
        int l;
        int i1;
        if (w3 != null)
        {
            j = w3.h;
        } else
        {
            j = 0;
        }
        if (w5 != null)
        {
            k = w5.h;
        } else
        {
            k = 0;
        }
        w1.h = 1 + Math.max(j, k);
        l = w1.h;
        i1 = 0;
        if (w4 != null)
        {
            i1 = w4.h;
        }
        w2.h = 1 + Math.max(l, i1);
    }

    private void b(w w1, boolean flag)
    {
_L11:
        if (w1 == null) goto _L2; else goto _L1
_L1:
        w w2;
        w w3;
        int j;
        int k;
        int l;
        w2 = w1.b;
        w3 = w1.c;
        w w6;
        w w7;
        if (w2 != null)
        {
            j = w2.h;
        } else
        {
            j = 0;
        }
        if (w3 != null)
        {
            k = w3.h;
        } else
        {
            k = 0;
        }
        l = j - k;
        if (l != -2) goto _L4; else goto _L3
_L3:
        w6 = w3.b;
        w7 = w3.c;
        int l1;
        int i2;
        int j2;
        if (w7 != null)
        {
            l1 = w7.h;
        } else
        {
            l1 = 0;
        }
        if (w6 != null)
        {
            i2 = w6.h;
        } else
        {
            i2 = 0;
        }
        j2 = i2 - l1;
        if (j2 == -1 || j2 == 0 && !flag)
        {
            a(w1);
        } else
        {
            if (!f && j2 != 1)
            {
                throw new AssertionError();
            }
            b(w3);
            a(w1);
        }
        if (!flag) goto _L5; else goto _L2
_L2:
        return;
_L4:
        if (l != 2) goto _L7; else goto _L6
_L6:
        w w4 = w2.b;
        w w5 = w2.c;
        int i1;
        int j1;
        int k1;
        if (w5 != null)
        {
            i1 = w5.h;
        } else
        {
            i1 = 0;
        }
        if (w4 != null)
        {
            j1 = w4.h;
        } else
        {
            j1 = 0;
        }
        k1 = j1 - i1;
        if (k1 == 1 || k1 == 0 && !flag)
        {
            b(w1);
        } else
        {
            if (!f && k1 != -1)
            {
                throw new AssertionError();
            }
            a(w2);
            b(w1);
        }
        if (flag) goto _L2; else goto _L5
_L5:
        w1 = w1.a;
        continue; /* Loop/switch isn't completed */
_L7:
        if (l != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        w1.h = j + 1;
        if (flag)
        {
            return;
        }
        if (true) goto _L5; else goto _L8
_L8:
        if (!f && l != -1 && l != 1)
        {
            throw new AssertionError();
        }
        w1.h = 1 + Math.max(j, k);
        if (flag) goto _L5; else goto _L9
_L9:
        return;
        if (true) goto _L11; else goto _L10
_L10:
    }

    private Object writeReplace()
    {
        return new LinkedHashMap(this);
    }

    w a(Object obj)
    {
        w w1 = null;
        if (obj != null)
        {
            w w2;
            try
            {
                w2 = a(obj, false);
            }
            catch (ClassCastException classcastexception)
            {
                return null;
            }
            w1 = w2;
        }
        return w1;
    }

    w a(Object obj, boolean flag)
    {
        Comparator comparator;
        w w1;
        comparator = a;
        w1 = b;
        if (w1 == null) goto _L2; else goto _L1
_L1:
        w w3;
        Comparable comparable;
        int k;
        if (comparator == g)
        {
            comparable = (Comparable)obj;
        } else
        {
            comparable = null;
        }
_L11:
        if (comparable != null)
        {
            k = comparable.compareTo(w1.f);
        } else
        {
            k = comparator.compare(obj, w1.f);
        }
        if (k != 0) goto _L4; else goto _L3
_L3:
        w3 = w1;
_L8:
        return w3;
_L4:
        w w2;
        int j;
        w w4;
        w w6;
        if (k < 0)
        {
            w6 = w1.b;
        } else
        {
            w6 = w1.c;
        }
        if (w6 != null) goto _L6; else goto _L5
_L5:
        int l = k;
        w2 = w1;
        j = l;
_L13:
        w3 = null;
        if (!flag) goto _L8; else goto _L7
_L7:
        w4 = e;
        if (w2 != null) goto _L10; else goto _L9
_L6:
        w1 = w6;
          goto _L11
_L9:
        w w5;
        if (comparator == g && !(obj instanceof Comparable))
        {
            throw new ClassCastException((new StringBuilder()).append(obj.getClass().getName()).append(" is not Comparable").toString());
        }
        w5 = new w(w2, obj, w4, w4.e);
        b = w5;
_L12:
        c = 1 + c;
        d = 1 + d;
        return w5;
_L10:
        w5 = new w(w2, obj, w4, w4.e);
        if (j < 0)
        {
            w2.b = w5;
        } else
        {
            w2.c = w5;
        }
        b(w2, true);
        if (true) goto _L12; else goto _L2
_L2:
        w2 = w1;
        j = 0;
          goto _L13
    }

    w a(java.util.Map.Entry entry)
    {
        w w1 = a(entry.getKey());
        boolean flag;
        if (w1 != null && a(w1.g, entry.getValue()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            return w1;
        } else
        {
            return null;
        }
    }

    void a(w w1, boolean flag)
    {
        if (flag)
        {
            w1.e.d = w1.d;
            w1.d.e = w1.e;
        }
        w w2 = w1.b;
        w w3 = w1.c;
        w w4 = w1.a;
        if (w2 != null && w3 != null)
        {
            w w5;
            w w6;
            int j;
            w w7;
            int k;
            if (w2.h > w3.h)
            {
                w5 = w2.b();
            } else
            {
                w5 = w3.a();
            }
            a(w5, false);
            w6 = w1.b;
            if (w6 != null)
            {
                j = w6.h;
                w5.b = w6;
                w6.a = w5;
                w1.b = null;
            } else
            {
                j = 0;
            }
            w7 = w1.c;
            k = 0;
            if (w7 != null)
            {
                k = w7.h;
                w5.c = w7;
                w7.a = w5;
                w1.c = null;
            }
            w5.h = 1 + Math.max(j, k);
            a(w1, w5);
            return;
        }
        if (w2 != null)
        {
            a(w1, w2);
            w1.b = null;
        } else
        if (w3 != null)
        {
            a(w1, w3);
            w1.c = null;
        } else
        {
            a(w1, ((w) (null)));
        }
        b(w4, false);
        c = -1 + c;
        d = 1 + d;
    }

    w b(Object obj)
    {
        w w1 = a(obj);
        if (w1 != null)
        {
            a(w1, true);
        }
        return w1;
    }

    public void clear()
    {
        b = null;
        c = 0;
        d = 1 + d;
        w w1 = e;
        w1.e = w1;
        w1.d = w1;
    }

    public boolean containsKey(Object obj)
    {
        return a(obj) != null;
    }

    public Set entrySet()
    {
        r r1 = h;
        if (r1 != null)
        {
            return r1;
        } else
        {
            r r2 = new r(this);
            h = r2;
            return r2;
        }
    }

    public Object get(Object obj)
    {
        w w1 = a(obj);
        if (w1 != null)
        {
            return w1.g;
        } else
        {
            return null;
        }
    }

    public Set keySet()
    {
        t t1 = i;
        if (t1 != null)
        {
            return t1;
        } else
        {
            t t2 = new t(this);
            i = t2;
            return t2;
        }
    }

    public Object put(Object obj, Object obj1)
    {
        if (obj == null)
        {
            throw new NullPointerException("key == null");
        } else
        {
            w w1 = a(obj, true);
            Object obj2 = w1.g;
            w1.g = obj1;
            return obj2;
        }
    }

    public Object remove(Object obj)
    {
        w w1 = b(obj);
        if (w1 != null)
        {
            return w1.g;
        } else
        {
            return null;
        }
    }

    public int size()
    {
        return c;
    }

    static 
    {
        boolean flag;
        if (!com/google/gson/internal/LinkedTreeMap.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f = flag;
    }
}
