// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.util;

import java.io.PrintWriter;

public class TimeUtils
{

    public static final int HUNDRED_DAY_FIELD_LEN = 19;
    private static final int a = 60;
    private static final int b = 3600;
    private static final int c = 0x15180;
    private static final Object d = new Object();
    private static char e[] = new char[24];

    public TimeUtils()
    {
    }

    private static int a(int i, int j, boolean flag, int k)
    {
        if (i > 99 || flag && k >= 3)
        {
            return j + 3;
        }
        if (i > 9 || flag && k >= 2)
        {
            return j + 2;
        }
        if (flag || i > 0)
        {
            return j + 1;
        } else
        {
            return 0;
        }
    }

    private static int a(long l, int i)
    {
        if (e.length < i)
        {
            e = new char[i];
        }
        char ac[] = e;
        if (l == 0L)
        {
            for (int l6 = i - 1; l6 < 0;)
            {
                ac[0] = ' ';
            }

            ac[0] = '0';
            return 1;
        }
        char c1;
        int j;
        int k;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        if (l > 0L)
        {
            c1 = '+';
        } else
        {
            l = -l;
            c1 = '-';
        }
        j = (int)(l % 1000L);
        k = (int)Math.floor(l / 1000L);
        i1 = 0;
        if (k > 0x15180)
        {
            i1 = k / 0x15180;
            k -= 0x15180 * i1;
        }
        int k2;
        boolean flag;
        int l2;
        boolean flag1;
        byte byte0;
        int i3;
        boolean flag2;
        byte byte1;
        int j3;
        boolean flag3;
        byte byte2;
        int k3;
        byte byte3;
        int l3;
        if (k > 3600)
        {
            int j6 = k / 3600;
            int k6 = k - j6 * 3600;
            k1 = j6;
            j1 = k6;
        } else
        {
            j1 = k;
            k1 = 0;
        }
        if (j1 > 60)
        {
            int l5 = j1 / 60;
            int i6 = j1 - l5 * 60;
            i2 = l5;
            l1 = i6;
        } else
        {
            l1 = j1;
            i2 = 0;
        }
        if (i != 0)
        {
            int i4 = a(i1, 1, false, 0);
            boolean flag4;
            int j4;
            boolean flag5;
            int k4;
            boolean flag6;
            int l4;
            byte byte4;
            int i5;
            if (i4 > 0)
            {
                flag4 = true;
            } else
            {
                flag4 = false;
            }
            j4 = i4 + a(k1, 1, flag4, 2);
            if (j4 > 0)
            {
                flag5 = true;
            } else
            {
                flag5 = false;
            }
            k4 = j4 + a(i2, 1, flag5, 2);
            if (k4 > 0)
            {
                flag6 = true;
            } else
            {
                flag6 = false;
            }
            l4 = k4 + a(l1, 1, flag6, 2);
            if (l4 > 0)
            {
                byte4 = 3;
            } else
            {
                byte4 = 0;
            }
            i5 = l4 + (1 + a(j, 2, true, byte4));
            j2 = 0;
            for (int j5 = i5; j5 < i;)
            {
                ac[j2] = ' ';
                int k5 = j2 + 1;
                j5++;
                j2 = k5;
            }

        } else
        {
            j2 = 0;
        }
        ac[j2] = c1;
        k2 = j2 + 1;
        if (i != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        l2 = a(ac, i1, 'd', k2, false, 0);
        if (l2 != k2)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag)
        {
            byte0 = 2;
        } else
        {
            byte0 = 0;
        }
        i3 = a(ac, k1, 'h', l2, flag1, byte0);
        if (i3 != k2)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (flag)
        {
            byte1 = 2;
        } else
        {
            byte1 = 0;
        }
        j3 = a(ac, i2, 'm', i3, flag2, byte1);
        if (j3 != k2)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        if (flag)
        {
            byte2 = 2;
        } else
        {
            byte2 = 0;
        }
        k3 = a(ac, l1, 's', j3, flag3, byte2);
        if (flag && k3 != k2)
        {
            byte3 = 3;
        } else
        {
            byte3 = 0;
        }
        l3 = a(ac, j, 'm', k3, true, byte3);
        ac[l3] = 's';
        return l3 + 1;
    }

    private static int a(char ac[], int i, char c1, int j, boolean flag, int k)
    {
        if (flag || i > 0)
        {
            int l;
            int i1;
            int k1;
            if (flag && k >= 3 || i > 99)
            {
                int l1 = i / 100;
                ac[j] = (char)(l1 + 48);
                l = j + 1;
                i1 = i - l1 * 100;
            } else
            {
                l = j;
                i1 = i;
            }
            if (flag && k >= 2 || i1 > 9 || j != l)
            {
                int j1 = i1 / 10;
                ac[l] = (char)(j1 + 48);
                l++;
                i1 -= j1 * 10;
            }
            ac[l] = (char)(i1 + 48);
            k1 = l + 1;
            ac[k1] = c1;
            j = k1 + 1;
        }
        return j;
    }

    public static void formatDuration(long l, long l1, PrintWriter printwriter)
    {
        if (l == 0L)
        {
            printwriter.print("--");
            return;
        } else
        {
            formatDuration(l - l1, printwriter, 0);
            return;
        }
    }

    public static void formatDuration(long l, PrintWriter printwriter)
    {
        formatDuration(l, printwriter, 0);
    }

    public static void formatDuration(long l, PrintWriter printwriter, int i)
    {
        synchronized (d)
        {
            int j = a(l, i);
            printwriter.print(new String(e, 0, j));
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static void formatDuration(long l, StringBuilder stringbuilder)
    {
        synchronized (d)
        {
            int i = a(l, 0);
            stringbuilder.append(e, 0, i);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
