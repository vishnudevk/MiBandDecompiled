// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned;


// Referenced classes of package com.google.zxing.oned:
//            OneDimensionalCodeWriter, CodaBarReader

public class CodaBarWriter extends OneDimensionalCodeWriter
{

    public CodaBarWriter()
    {
        super(20);
    }

    public byte[] encode(String s)
    {
        byte abyte0[];
        int k;
        int l;
        if (!CodaBarReader.a(new char[] {
    'A', 'B', 'C', 'D'
}, Character.toUpperCase(s.charAt(0))))
        {
            throw new IllegalArgumentException("Codabar should start with one of the following: 'A', 'B', 'C' or 'D'");
        }
        if (!CodaBarReader.a(new char[] {
    'T', 'N', '*', 'E'
}, Character.toUpperCase(s.charAt(-1 + s.length()))))
        {
            throw new IllegalArgumentException("Codabar should end with one of the following: 'T', 'N', '*' or 'E'");
        }
        char ac[] = {
            '/', ':', '+', '.'
        };
        int i = 20;
        int j = 1;
        while (j < -1 + s.length()) 
        {
            if (Character.isDigit(s.charAt(j)) || s.charAt(j) == '-' || s.charAt(j) == '$')
            {
                i += 9;
            } else
            if (CodaBarReader.a(ac, s.charAt(j)))
            {
                i += 10;
            } else
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Cannot encode : '").append(s.charAt(j)).append('\'').toString());
            }
            j++;
        }
        abyte0 = new byte[i + (-1 + s.length())];
        k = 0;
        l = 0;
_L1:
        int j1;
        int l1;
        if (k < s.length())
        {
            char c = Character.toUpperCase(s.charAt(k));
            int i1;
            if (k == -1 + s.length())
            {
                if (c == '*')
                {
                    c = 'C';
                } else
                if (c == 'E')
                {
                    c = 'D';
                }
            }
            i1 = 0;
            do
            {
                if (i1 >= CodaBarReader.a.length)
                {
                    break MISSING_BLOCK_LABEL_461;
                }
                int k1;
                byte byte0;
                byte byte1;
                if (c == CodaBarReader.a[i1])
                {
                    j1 = CodaBarReader.b[i1];
                    break MISSING_BLOCK_LABEL_330;
                }
                i1++;
            } while (true);
        } else
        {
            return abyte0;
        }
_L2:
        k1 = 0;
        l1 = 0;
        byte0 = 1;
        while (k1 < 7) 
        {
            abyte0[l] = byte0;
            int i2 = l + 1;
            if ((1 & j1 >> 6 - k1) == 0 || l1 == 1)
            {
                byte1 = (byte)(byte0 ^ 1);
                k1++;
                byte0 = byte1;
                l = i2;
                l1 = 0;
            } else
            {
                l1++;
                l = i2;
            }
        }
        if (k < -1 + s.length())
        {
            abyte0[l] = 0;
            l++;
        }
        k++;
          goto _L1
        j1 = 0;
          goto _L2
    }
}
