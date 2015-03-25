// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.google.zxing.oned:
//            UPCEANWriter, Code128Reader

public final class Code128Writer extends UPCEANWriter
{

    private static final int a = 104;
    private static final int b = 105;
    private static final int c = 100;
    private static final int d = 99;
    private static final int e = 106;
    private static final char f = 241;
    private static final char g = 242;
    private static final char h = 243;
    private static final char i = 244;
    private static final int j = 102;
    private static final int k = 97;
    private static final int l = 96;
    private static final int m = 100;

    public Code128Writer()
    {
    }

    private static boolean a(CharSequence charsequence, int i1, int j1)
    {
        int k1 = i1 + j1;
        int l1;
        for (l1 = charsequence.length(); i1 < k1 && i1 < l1; i1++)
        {
            char c1 = charsequence.charAt(i1);
            if (c1 >= '0' && c1 <= '9')
            {
                continue;
            }
            if (c1 != '\361')
            {
                return false;
            }
            k1++;
        }

        boolean flag;
        if (k1 <= l1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag;
    }

    public BitMatrix encode(String s, BarcodeFormat barcodeformat, int i1, int j1, Map map)
    {
        if (barcodeformat != BarcodeFormat.CODE_128)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Can only encode CODE_128, but got ").append(barcodeformat).toString());
        } else
        {
            return super.encode(s, barcodeformat, i1, j1, map);
        }
    }

    public byte[] encode(String s)
    {
        int i1;
        int j1;
        int k1;
        i1 = 0;
        j1 = s.length();
        if (j1 < 1 || j1 > 80)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Contents length should be between 1 and 80 characters, but got ").append(j1).toString());
        }
        k1 = 0;
_L11:
        ArrayList arraylist;
        int l1;
        int i2;
        int j2;
        int k2;
        if (k1 < j1)
        {
            char c1 = s.charAt(k1);
            if (c1 < ' ' || c1 > '~')
            {
                switch (c1)
                {
                default:
                    throw new IllegalArgumentException((new StringBuilder()).append("Bad character in input: ").append(c1).toString());

                case 241: 
                case 242: 
                case 243: 
                case 244: 
                    break;
                }
            }
            k1++;
            continue; /* Loop/switch isn't completed */
        }
        arraylist = new ArrayList();
        l1 = 0;
        i2 = 0;
        j2 = 1;
        k2 = 0;
_L7:
        if (l1 >= j1) goto _L2; else goto _L1
_L1:
        byte byte1;
        int i4;
        int k4;
        int l4;
        byte byte0;
        int i5;
        if (i2 == 99)
        {
            byte0 = 2;
        } else
        {
            byte0 = 4;
        }
        if (a(s, l1, byte0))
        {
            byte1 = 99;
        } else
        {
            byte1 = 100;
        }
        if (byte1 != i2) goto _L4; else goto _L3
_L3:
        if (i2 != 100) goto _L6; else goto _L5
_L5:
        i4 = -32 + s.charAt(l1);
        l4 = l1 + 1;
        k4 = i2;
_L9:
        arraylist.add(Code128Reader.a[i4]);
        i5 = k2 + i4 * j2;
        int l2;
        Iterator iterator;
        int i3;
        byte abyte0[];
        Iterator iterator1;
        int ai[];
        int j3;
        int k3;
        int l3;
        int j4;
        int j5;
        if (l4 != 0)
        {
            j5 = j2 + 1;
        } else
        {
            j5 = j2;
        }
        j2 = j5;
        k2 = i5;
        i2 = k4;
        l1 = l4;
          goto _L7
_L6:
        switch (s.charAt(l1))
        {
        default:
            i4 = Integer.parseInt(s.substring(l1, l1 + 2));
            l4 = l1 + 2;
            k4 = i2;
            break;

        case 241: 
            i4 = 102;
            l4 = l1 + 1;
            k4 = i2;
            break;

        case 242: 
            i4 = 97;
            l4 = l1 + 1;
            k4 = i2;
            break;

        case 243: 
            i4 = 96;
            l4 = l1 + 1;
            k4 = i2;
            break;

        case 244: 
            l4 = l1 + 1;
            k4 = i2;
            i4 = 100;
            break;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (i2 == 0)
        {
            if (byte1 == 100)
            {
                i4 = 104;
            } else
            {
                i4 = 105;
            }
        } else
        {
            i4 = byte1;
        }
        j4 = l1;
        k4 = byte1;
        l4 = j4;
        continue; /* Loop/switch isn't completed */
_L2:
        l2 = k2 % 103;
        arraylist.add(Code128Reader.a[l2]);
        arraylist.add(Code128Reader.a[106]);
        iterator = arraylist.iterator();
        i3 = 0;
        while (iterator.hasNext()) 
        {
            ai = (int[])iterator.next();
            j3 = ai.length;
            k3 = 0;
            while (k3 < j3) 
            {
                l3 = i3 + ai[k3];
                k3++;
                i3 = l3;
            }
        }
        abyte0 = new byte[i3];
        for (iterator1 = arraylist.iterator(); iterator1.hasNext();)
        {
            i1 += appendPattern(abyte0, i1, (int[])iterator1.next(), 1);
        }

        return abyte0;
        if (true) goto _L9; else goto _L8
_L8:
        if (true) goto _L11; else goto _L10
_L10:
    }
}
