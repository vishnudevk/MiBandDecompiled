// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.common;


// Referenced classes of package com.google.zxing.common:
//            BitArray

public final class BitMatrix
{

    private final int a;
    private final int b;
    private final int c;
    private final int d[];

    public BitMatrix(int i)
    {
        this(i, i);
    }

    public BitMatrix(int i, int j)
    {
        if (i < 1 || j < 1)
        {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        } else
        {
            a = i;
            b = j;
            c = i + 31 >> 5;
            d = new int[j * c];
            return;
        }
    }

    public void clear()
    {
        int i = d.length;
        for (int j = 0; j < i; j++)
        {
            d[j] = 0;
        }

    }

    public boolean equals(Object obj)
    {
        if (obj instanceof BitMatrix) goto _L2; else goto _L1
_L1:
        BitMatrix bitmatrix;
        return false;
_L2:
        if (a == (bitmatrix = (BitMatrix)obj).a && b == bitmatrix.b && c == bitmatrix.c && d.length == bitmatrix.d.length)
        {
            int i = 0;
label0:
            do
            {
label1:
                {
                    if (i >= d.length)
                    {
                        break label1;
                    }
                    if (d[i] != bitmatrix.d[i])
                    {
                        break label0;
                    }
                    i++;
                }
            } while (true);
        }
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }

    public void flip(int i, int j)
    {
        int k = j * c + (i >> 5);
        int ai[] = d;
        ai[k] = ai[k] ^ 1 << (i & 0x1f);
    }

    public boolean get(int i, int j)
    {
        int k = j * c + (i >> 5);
        return (1 & d[k] >>> (i & 0x1f)) != 0;
    }

    public int[] getBottomRightOnBit()
    {
        int i;
        for (i = -1 + d.length; i >= 0 && d[i] == 0; i--) { }
        if (i < 0)
        {
            return null;
        }
        int j = i / c;
        int k = i % c << 5;
        int l = d[i];
        int i1;
        for (i1 = 31; l >>> i1 == 0; i1--) { }
        return (new int[] {
            k + i1, j
        });
    }

    public int[] getEnclosingRectangle()
    {
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int i = a;
        j = b;
        k = i;
        l = -1;
        i1 = -1;
        j1 = 0;
_L12:
        if (j1 >= b) goto _L2; else goto _L1
_L1:
        int i2 = 0;
_L11:
        if (i2 >= c) goto _L4; else goto _L3
_L3:
        int j2;
        j2 = d[i2 + j1 * c];
        if (j2 == 0)
        {
            break MISSING_BLOCK_LABEL_292;
        }
        if (j1 < j)
        {
            j = j1;
        }
        if (j1 > i1)
        {
            i1 = j1;
        }
        if (i2 * 32 >= k) goto _L6; else goto _L5
_L5:
        int i4;
        for (i4 = 0; j2 << 31 - i4 == 0; i4++) { }
        if (i4 + i2 * 32 >= k) goto _L6; else goto _L7
_L7:
        int k2 = i4 + i2 * 32;
_L14:
        if (31 + i2 * 32 <= l) goto _L9; else goto _L8
_L8:
        int k3;
        for (k3 = 31; j2 >>> k3 == 0; k3--) { }
        if (k3 + i2 * 32 <= l) goto _L9; else goto _L10
_L10:
        int l2;
        int i3;
        int j3;
        int l3 = k3 + i2 * 32;
        l2 = j;
        i3 = l3;
        j3 = i1;
_L13:
        i2++;
        i1 = j3;
        l = i3;
        j = l2;
        k = k2;
          goto _L11
_L4:
        j1++;
          goto _L12
_L2:
        int k1 = l - k;
        int l1 = i1 - j;
        if (k1 < 0 || l1 < 0)
        {
            return null;
        } else
        {
            return (new int[] {
                k, j, k1, l1
            });
        }
_L9:
        l2 = j;
        i3 = l;
        j3 = i1;
          goto _L13
_L6:
        k2 = k;
          goto _L14
        k2 = k;
        l2 = j;
        i3 = l;
        j3 = i1;
          goto _L13
    }

    public int getHeight()
    {
        return b;
    }

    public BitArray getRow(int i, BitArray bitarray)
    {
        if (bitarray == null || bitarray.getSize() < a)
        {
            bitarray = new BitArray(a);
        }
        int j = i * c;
        for (int k = 0; k < c; k++)
        {
            bitarray.setBulk(k << 5, d[j + k]);
        }

        return bitarray;
    }

    public int[] getTopLeftOnBit()
    {
        int i;
        for (i = 0; i < d.length && d[i] == 0; i++) { }
        if (i == d.length)
        {
            return null;
        }
        int j = i / c;
        int k = i % c << 5;
        int l = d[i];
        int i1;
        for (i1 = 0; l << 31 - i1 == 0; i1++) { }
        return (new int[] {
            k + i1, j
        });
    }

    public int getWidth()
    {
        return a;
    }

    public int hashCode()
    {
        int i = 31 * (31 * (31 * a + a) + b) + c;
        int ai[] = d;
        int j = ai.length;
        for (int k = 0; k < j; k++)
        {
            i = ai[k] + i * 31;
        }

        return i;
    }

    public void set(int i, int j)
    {
        int k = j * c + (i >> 5);
        int ai[] = d;
        ai[k] = ai[k] | 1 << (i & 0x1f);
    }

    public void setRegion(int i, int j, int k, int l)
    {
        int i1;
        int j1;
        if (j < 0 || i < 0)
        {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (l < 1 || k < 1)
        {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        i1 = i + k;
        j1 = j + l;
        if (j1 > b || i1 > a)
        {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
_L3:
        if (j < j1)
        {
            int k1 = j * c;
            int l1 = i;
            while (l1 < i1) 
            {
                int ai[] = d;
                int i2 = k1 + (l1 >> 5);
                ai[i2] = ai[i2] | 1 << (l1 & 0x1f);
                l1++;
            }
        } else
        {
            return;
        }
        if (true) goto _L2; else goto _L1
_L2:
        j++;
        if (true) goto _L3; else goto _L1
_L1:
    }

    public void setRow(int i, BitArray bitarray)
    {
        System.arraycopy(bitarray.getBitArray(), 0, d, i * c, c);
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(b * (1 + a));
        for (int i = 0; i < b; i++)
        {
            int j = 0;
            while (j < a) 
            {
                String s;
                if (get(j, i))
                {
                    s = "X ";
                } else
                {
                    s = "  ";
                }
                stringbuilder.append(s);
                j++;
            }
            stringbuilder.append('\n');
        }

        return stringbuilder.toString();
    }
}
