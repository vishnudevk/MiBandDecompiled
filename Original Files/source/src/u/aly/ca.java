// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

// Referenced classes of package u.aly:
//            cP

public final class ca
{

    private static final Comparator a = new cP(null);

    private ca()
    {
    }

    public static int a(byte byte0, byte byte1)
    {
        if (byte0 < byte1)
        {
            return -1;
        }
        return byte1 >= byte0 ? 0 : 1;
    }

    public static int a(double d1, double d2)
    {
        if (d1 < d2)
        {
            return -1;
        }
        return d2 >= d1 ? 0 : 1;
    }

    public static int a(int i, int j)
    {
        if (i < j)
        {
            return -1;
        }
        return j >= i ? 0 : 1;
    }

    public static int a(long l, long l1)
    {
        if (l < l1)
        {
            return -1;
        }
        return l1 >= l ? 0 : 1;
    }

    public static int a(Comparable comparable, Comparable comparable1)
    {
        return comparable.compareTo(comparable1);
    }

    public static int a(Object obj, Object obj1)
    {
        if (obj instanceof Comparable)
        {
            return a((Comparable)obj, (Comparable)obj1);
        }
        if (obj instanceof List)
        {
            return a((List)obj, (List)obj1);
        }
        if (obj instanceof Set)
        {
            return a((Set)obj, (Set)obj1);
        }
        if (obj instanceof Map)
        {
            return a((Map)obj, (Map)obj1);
        }
        if (obj instanceof byte[])
        {
            return a((byte[])obj, (byte[])obj1);
        } else
        {
            throw new IllegalArgumentException((new StringBuilder("Cannot compare objects of type ")).append(obj.getClass()).toString());
        }
    }

    public static int a(String s, String s1)
    {
        return s.compareTo(s1);
    }

    public static int a(ByteBuffer bytebuffer, byte abyte0[], int i)
    {
        int j = bytebuffer.remaining();
        System.arraycopy(bytebuffer.array(), bytebuffer.arrayOffset() + bytebuffer.position(), abyte0, i, j);
        return j;
    }

    public static int a(List list, List list1)
    {
        int i = a(list.size(), list1.size());
        if (i == 0) goto _L2; else goto _L1
_L1:
        int l = i;
_L4:
        return l;
_L2:
        int j = 0;
        do
        {
            int k = list.size();
            l = 0;
            if (j >= k)
            {
                continue;
            }
            int i1 = a.compare(list.get(j), list1.get(j));
            if (i1 != 0)
            {
                return i1;
            }
            j++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static int a(Map map, Map map1)
    {
        int i = a(map.size(), map1.size());
        if (i != 0)
        {
            return i;
        }
        TreeMap treemap = new TreeMap(a);
        treemap.putAll(map);
        Iterator iterator = treemap.entrySet().iterator();
        TreeMap treemap1 = new TreeMap(a);
        treemap1.putAll(map1);
        Iterator iterator1 = treemap1.entrySet().iterator();
        int k;
        do
        {
            if (!iterator.hasNext() || !iterator1.hasNext())
            {
                return 0;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            java.util.Map.Entry entry1 = (java.util.Map.Entry)iterator1.next();
            int j = a.compare(entry.getKey(), entry1.getKey());
            if (j != 0)
            {
                return j;
            }
            k = a.compare(entry.getValue(), entry1.getValue());
        } while (k == 0);
        return k;
    }

    public static int a(Set set, Set set1)
    {
        int i = a(set.size(), set1.size());
        if (i != 0)
        {
            return i;
        }
        TreeSet treeset = new TreeSet(a);
        treeset.addAll(set);
        TreeSet treeset1 = new TreeSet(a);
        treeset1.addAll(set1);
        Iterator iterator = treeset.iterator();
        Iterator iterator1 = treeset1.iterator();
        int j;
        do
        {
            if (!iterator.hasNext() || !iterator1.hasNext())
            {
                return 0;
            }
            j = a.compare(iterator.next(), iterator1.next());
        } while (j == 0);
        return j;
    }

    public static int a(short word0, short word1)
    {
        if (word0 < word1)
        {
            return -1;
        }
        return word1 >= word0 ? 0 : 1;
    }

    public static int a(boolean flag, boolean flag1)
    {
        return Boolean.valueOf(flag).compareTo(Boolean.valueOf(flag1));
    }

    public static int a(byte abyte0[], byte abyte1[])
    {
        int i = a(abyte0.length, abyte1.length);
        if (i == 0) goto _L2; else goto _L1
_L1:
        int l = i;
_L4:
        return l;
_L2:
        int j = 0;
        do
        {
            int k = abyte0.length;
            l = 0;
            if (j >= k)
            {
                continue;
            }
            int i1 = a(abyte0[j], abyte1[j]);
            if (i1 != 0)
            {
                return i1;
            }
            j++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static String a(byte byte0)
    {
        return Integer.toHexString(0x1ff & (byte0 | 0x100)).toUpperCase().substring(1);
    }

    public static void a(ByteBuffer bytebuffer, StringBuilder stringbuilder)
    {
        byte abyte0[] = bytebuffer.array();
        int i = bytebuffer.arrayOffset();
        int j = i + bytebuffer.position();
        int k = i + bytebuffer.limit();
        int l;
        int i1;
        if (k - j > 128)
        {
            l = j + 128;
        } else
        {
            l = k;
        }
        i1 = j;
        do
        {
            if (i1 >= l)
            {
                if (k != l)
                {
                    stringbuilder.append("...");
                }
                return;
            }
            if (i1 > j)
            {
                stringbuilder.append(" ");
            }
            stringbuilder.append(a(abyte0[i1]));
            i1++;
        } while (true);
    }

    public static byte[] a(ByteBuffer bytebuffer)
    {
        if (b(bytebuffer))
        {
            return bytebuffer.array();
        } else
        {
            byte abyte0[] = new byte[bytebuffer.remaining()];
            a(bytebuffer, abyte0, 0);
            return abyte0;
        }
    }

    public static byte[] a(byte abyte0[])
    {
        if (abyte0 == null)
        {
            return null;
        } else
        {
            byte abyte1[] = new byte[abyte0.length];
            System.arraycopy(abyte0, 0, abyte1, 0, abyte0.length);
            return abyte1;
        }
    }

    public static boolean b(ByteBuffer bytebuffer)
    {
        return bytebuffer.hasArray() && bytebuffer.position() == 0 && bytebuffer.arrayOffset() == 0 && bytebuffer.remaining() == bytebuffer.capacity();
    }

    public static ByteBuffer c(ByteBuffer bytebuffer)
    {
        if (bytebuffer == null)
        {
            bytebuffer = null;
        } else
        if (!b(bytebuffer))
        {
            return ByteBuffer.wrap(a(bytebuffer));
        }
        return bytebuffer;
    }

    public static ByteBuffer d(ByteBuffer bytebuffer)
    {
        if (bytebuffer == null)
        {
            return null;
        }
        ByteBuffer bytebuffer1 = ByteBuffer.wrap(new byte[bytebuffer.remaining()]);
        if (bytebuffer.hasArray())
        {
            System.arraycopy(bytebuffer.array(), bytebuffer.arrayOffset() + bytebuffer.position(), bytebuffer1.array(), 0, bytebuffer.remaining());
            return bytebuffer1;
        } else
        {
            bytebuffer.slice().get(bytebuffer1.array());
            return bytebuffer1;
        }
    }

}
