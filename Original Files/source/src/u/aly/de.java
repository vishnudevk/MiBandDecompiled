// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.util.BitSet;

// Referenced classes of package u.aly:
//            cs, dj, dm

public final class de extends cs
{

    public de(dm dm)
    {
        super(dm);
    }

    public static BitSet a(byte abyte0[])
    {
        BitSet bitset = new BitSet();
        int i = 0;
        do
        {
            if (i >= 8 * abyte0.length)
            {
                return bitset;
            }
            if ((abyte0[-1 + (abyte0.length - i / 8)] & 1 << i % 8) > 0)
            {
                bitset.set(i);
            }
            i++;
        } while (true);
    }

    public static byte[] b(BitSet bitset, int i)
    {
        byte abyte0[] = new byte[(int)Math.ceil((double)i / 8D)];
        int j = 0;
        do
        {
            if (j >= bitset.length())
            {
                return abyte0;
            }
            if (bitset.get(j))
            {
                int k = -1 + (abyte0.length - j / 8);
                abyte0[k] = (byte)(abyte0[k] | 1 << j % 8);
            }
            j++;
        } while (true);
    }

    public Class D()
    {
        return u/aly/dj;
    }

    public void a(BitSet bitset, int i)
    {
        byte abyte0[] = b(bitset, i);
        int j = abyte0.length;
        int k = 0;
        do
        {
            if (k >= j)
            {
                return;
            }
            a(abyte0[k]);
            k++;
        } while (true);
    }

    public BitSet b(int i)
    {
        int j = (int)Math.ceil((double)i / 8D);
        byte abyte0[] = new byte[j];
        int k = 0;
        do
        {
            if (k >= j)
            {
                return a(abyte0);
            }
            abyte0[k] = u();
            k++;
        } while (true);
    }
}
