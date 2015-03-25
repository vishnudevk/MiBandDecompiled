// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.common;


public final class BitArray
{

    private int a[];
    private int b;

    public BitArray()
    {
        b = 0;
        a = new int[1];
    }

    public BitArray(int i)
    {
        b = i;
        a = b(i);
    }

    private void a(int i)
    {
        if (i > a.length << 5)
        {
            int ai[] = b(i);
            System.arraycopy(a, 0, ai, 0, a.length);
            a = ai;
        }
    }

    private static int[] b(int i)
    {
        return new int[i + 31 >> 5];
    }

    public void appendBit(boolean flag)
    {
        a(1 + b);
        if (flag)
        {
            int ai[] = a;
            int i = b >> 5;
            ai[i] = ai[i] | 1 << (0x1f & b);
        }
        b = 1 + b;
    }

    public void appendBitArray(BitArray bitarray)
    {
        int i = bitarray.b;
        a(i + b);
        for (int j = 0; j < i; j++)
        {
            appendBit(bitarray.get(j));
        }

    }

    public void appendBits(int i, int j)
    {
        if (j < 0 || j > 32)
        {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        a(j + b);
        while (j > 0) 
        {
            boolean flag;
            if ((1 & i >> j - 1) == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            appendBit(flag);
            j--;
        }
    }

    public void clear()
    {
        int i = a.length;
        for (int j = 0; j < i; j++)
        {
            a[j] = 0;
        }

    }

    public void flip(int i)
    {
        int ai[] = a;
        int j = i >> 5;
        ai[j] = ai[j] ^ 1 << (i & 0x1f);
    }

    public boolean get(int i)
    {
        return (a[i >> 5] & 1 << (i & 0x1f)) != 0;
    }

    public int[] getBitArray()
    {
        return a;
    }

    public int getNextSet(int i)
    {
        int l;
        if (i >= b)
        {
            l = b;
        } else
        {
            int j = i >> 5;
            int k;
            for (k = a[j] & (-1 ^ -1 + (1 << (i & 0x1f))); k == 0; k = a[j])
            {
                if (++j == a.length)
                {
                    return b;
                }
            }

            l = (j << 5) + Integer.numberOfTrailingZeros(k);
            if (l > b)
            {
                return b;
            }
        }
        return l;
    }

    public int getNextUnset(int i)
    {
        int l;
        if (i >= b)
        {
            l = b;
        } else
        {
            int j = i >> 5;
            int k;
            for (k = (-1 ^ a[j]) & (-1 ^ -1 + (1 << (i & 0x1f))); k == 0; k = -1 ^ a[j])
            {
                if (++j == a.length)
                {
                    return b;
                }
            }

            l = (j << 5) + Integer.numberOfTrailingZeros(k);
            if (l > b)
            {
                return b;
            }
        }
        return l;
    }

    public int getSize()
    {
        return b;
    }

    public int getSizeInBytes()
    {
        return 7 + b >> 3;
    }

    public boolean isRange(int i, int j, boolean flag)
    {
        if (j < i)
        {
            throw new IllegalArgumentException();
        }
        if (j == i)
        {
            return true;
        }
        int k = j - 1;
        int l = i >> 5;
        int i1 = k >> 5;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        for (int j1 = l; j1 <= i1; j1++)
        {
            int l2;
            if (j1 > l)
            {
                k1 = 0;
            } else
            {
                k1 = i & 0x1f;
            }
            if (j1 < i1)
            {
                l1 = 31;
            } else
            {
                l1 = k & 0x1f;
            }
            if (k1 == 0 && l1 == 31)
            {
                j2 = -1;
            } else
            {
                i2 = k1;
                j2 = 0;
                while (i2 <= l1) 
                {
                    k2 = j2 | 1 << i2;
                    i2++;
                    j2 = k2;
                }
            }
            l2 = j2 & a[j1];
            if (!flag)
            {
                j2 = 0;
            }
            if (l2 != j2)
            {
                return false;
            }
        }

        return true;
    }

    public void reverse()
    {
        int ai[] = new int[a.length];
        int i = b;
        for (int j = 0; j < i; j++)
        {
            if (get(-1 + (i - j)))
            {
                int k = j >> 5;
                ai[k] = ai[k] | 1 << (j & 0x1f);
            }
        }

        a = ai;
    }

    public void set(int i)
    {
        int ai[] = a;
        int j = i >> 5;
        ai[j] = ai[j] | 1 << (i & 0x1f);
    }

    public void setBulk(int i, int j)
    {
        a[i >> 5] = j;
    }

    public void setRange(int i, int j)
    {
        if (j < i)
        {
            throw new IllegalArgumentException();
        }
        if (j != i)
        {
            int k = j - 1;
            int l = i >> 5;
            int i1 = k >> 5;
            int j1 = l;
            while (j1 <= i1) 
            {
                int k1;
                int l1;
                int j2;
                int ai[];
                if (j1 > l)
                {
                    k1 = 0;
                } else
                {
                    k1 = i & 0x1f;
                }
                if (j1 < i1)
                {
                    l1 = 31;
                } else
                {
                    l1 = k & 0x1f;
                }
                if (k1 == 0 && l1 == 31)
                {
                    j2 = -1;
                } else
                {
                    int i2 = k1;
                    j2 = 0;
                    while (i2 <= l1) 
                    {
                        int k2 = j2 | 1 << i2;
                        i2++;
                        j2 = k2;
                    }
                }
                ai = a;
                ai[j1] = j2 | ai[j1];
                j1++;
            }
        }
    }

    public void toBytes(int i, byte abyte0[], int j, int k)
    {
        int l = 0;
        int k1;
        for (int i1 = i; l < k; i1 = k1)
        {
            int j1 = 0;
            k1 = i1;
            int l1 = 0;
            for (; j1 < 8; j1++)
            {
                if (get(k1))
                {
                    l1 |= 1 << 7 - j1;
                }
                k1++;
            }

            abyte0[j + l] = (byte)l1;
            l++;
        }

    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(b);
        int i = 0;
        while (i < b) 
        {
            if ((i & 7) == 0)
            {
                stringbuilder.append(' ');
            }
            char c;
            if (get(i))
            {
                c = 'X';
            } else
            {
                c = '.';
            }
            stringbuilder.append(c);
            i++;
        }
        return stringbuilder.toString();
    }

    public void xor(BitArray bitarray)
    {
        if (a.length != bitarray.a.length)
        {
            throw new IllegalArgumentException("Sizes don't match");
        }
        for (int i = 0; i < a.length; i++)
        {
            int ai[] = a;
            ai[i] = ai[i] ^ bitarray.a[i];
        }

    }
}
