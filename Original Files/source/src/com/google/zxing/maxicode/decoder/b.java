// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.maxicode.decoder;

import com.google.zxing.common.DecoderResult;
import java.text.DecimalFormat;
import java.text.NumberFormat;

final class b
{

    private static final char a = 65520;
    private static final char b = 65521;
    private static final char c = 65522;
    private static final char d = 65523;
    private static final char e = 65524;
    private static final char f = 65525;
    private static final char g = 65526;
    private static final char h = 65527;
    private static final char i = 65528;
    private static final char j = 65529;
    private static final char k = 65530;
    private static final char l = 65531;
    private static final char m = 65532;
    private static final char n = 28;
    private static final char o = 29;
    private static final char p = 30;
    private static final NumberFormat q = new DecimalFormat("000000000");
    private static final NumberFormat r = new DecimalFormat("000");
    private static final String s[] = {
        "\nABCDEFGHIJKLMNOPQRSTUVWXYZ\uFFFA\034\035\036\uFFFB \uFFFC\"#$%&'()*+,-./0123456789:\uFFF1\uFFF2\uFFF3\uFFF4\uFFF8", "`abcdefghijklmnopqrstuvwxyz\uFFFA\034\035\036\uFFFB{\uFFFC}~\177;<=>?[\\]^_ ,./:@!|\uFFFC\uFFF5\uFFF6\uFFFC\uFFF0\uFFF2\uFFF3\uFFF4\uFFF7", "\300\301\302\303\304\305\306\307\310\311\312\313\314\315\316\317\320\321\322\323\324\325\326\327\330\331\332\uFFFA\034\035\036\333\334\335\336\337\252\254\261\262\263\265\271\272\274\275\276\200\201\202\203\204\205\206\207\210\211\uFFF7 \uFFF9\uFFF3\uFFF4\uFFF8", "\340\341\342\343\344\345\346\347\350\351\352\353\354\355\356\357\360\361\362\363\364\365\366\367\370\371\372\uFFFA\034\035\036\uFFFB\373\374\375\376\377\241\250\253\257\260\264\267\270\273\277\212\213\214\215\216\217\220\221\222\223\224\uFFF7 \uFFF2\uFFF9\uFFF4\uFFF8", "\000\001\002\003\004\005\006\007\b\t\n\013\f\r\016\017\020\021\022\023\024\025\026\027\030\031\032\uFFFA\uFFFC\uFFFC\033\uFFFB\034\035\036\037\237\240\242\243\244\245\246\247\251\255\256\266\225\226\227\230\231\232\233\234\235\236\uFFF7 \uFFF2\uFFF3\uFFF9\uFFF8", "\000\001\002\003\004\005\006\007\b\t\n\013\f\r\016\017\020\021\022\023\024\025\026\027\030\031\032\033\034\035\036\037 !\"#$%&'()*+,-./0123456789:;<=>?"
    };

    private b()
    {
    }

    private static int a(int i1, byte abyte0[])
    {
        int j1 = 1;
        int k1 = i1 - 1;
        if ((abyte0[k1 / 6] & j1 << 5 - k1 % 6) == 0)
        {
            j1 = 0;
        }
        return j1;
    }

    private static int a(byte abyte0[])
    {
        return a(abyte0, new byte[] {
            53, 54, 43, 44, 45, 46, 47, 48, 37, 38
        });
    }

    private static int a(byte abyte0[], byte abyte1[])
    {
        int i1 = 0;
        int j1 = 0;
        for (; i1 < abyte1.length; i1++)
        {
            j1 += a(abyte1[i1], abyte0) << -1 + (abyte1.length - i1);
        }

        return j1;
    }

    static DecoderResult a(byte abyte0[], int i1)
    {
        StringBuilder stringbuilder = new StringBuilder(144);
        i1;
        JVM INSTR tableswitch 2 5: default 44
    //                   2 62
    //                   3 62
    //                   4 257
    //                   5 272;
           goto _L1 _L2 _L2 _L3 _L4
_L1:
        return new DecoderResult(abyte0, stringbuilder.toString(), null, String.valueOf(i1));
_L2:
        String s1;
        String s2;
        String s3;
        if (i1 == 2)
        {
            int j1 = d(abyte0);
            s1 = (new DecimalFormat("0000000000".substring(0, c(abyte0)))).format(j1);
        } else
        {
            s1 = e(abyte0);
        }
        s2 = r.format(a(abyte0));
        s3 = r.format(b(abyte0));
        stringbuilder.append(a(abyte0, 10, 84));
        if (stringbuilder.toString().startsWith("[)>\03601\035"))
        {
            stringbuilder.insert(9, (new StringBuilder()).append(s1).append('\035').append(s2).append('\035').append(s3).append('\035').toString());
        } else
        {
            stringbuilder.insert(0, (new StringBuilder()).append(s1).append('\035').append(s2).append('\035').append(s3).append('\035').toString());
        }
        continue; /* Loop/switch isn't completed */
_L3:
        stringbuilder.append(a(abyte0, 1, 93));
        continue; /* Loop/switch isn't completed */
_L4:
        stringbuilder.append(a(abyte0, 1, 77));
        if (true) goto _L1; else goto _L5
_L5:
    }

    private static String a(byte abyte0[], int i1, int j1)
    {
        StringBuilder stringbuilder;
        int k1;
        int l1;
        int i2;
        int j2;
        stringbuilder = new StringBuilder();
        k1 = i1;
        l1 = 0;
        i2 = 0;
        j2 = -1;
_L10:
        char c1;
        if (k1 >= i1 + j1)
        {
            break MISSING_BLOCK_LABEL_383;
        }
        c1 = s[i2].charAt(abyte0[k1]);
        c1;
        JVM INSTR tableswitch 65520 65531: default 108
    //                   65520 193
    //                   65521 193
    //                   65522 193
    //                   65523 193
    //                   65524 193
    //                   65525 222
    //                   65526 239
    //                   65527 167
    //                   65528 180
    //                   65529 365
    //                   65530 108
    //                   65531 256;
           goto _L1 _L2 _L2 _L2 _L2 _L2 _L3 _L4 _L5 _L6 _L7 _L1 _L8
_L7:
        break MISSING_BLOCK_LABEL_365;
_L5:
        break; /* Loop/switch isn't completed */
_L1:
        int l2;
        int i3;
        stringbuilder.append(c1);
        int i7 = k1;
        i3 = i2;
        l2 = i7;
_L11:
        int j3 = j2 - 1;
        if (j2 == 0)
        {
            i3 = l1;
        }
        int k3 = l2 + 1;
        j2 = j3;
        int l3 = i3;
        k1 = k3;
        i2 = l3;
        if (true) goto _L10; else goto _L9
_L9:
        l2 = k1;
        j2 = -1;
        i3 = 0;
          goto _L11
_L6:
        l2 = k1;
        j2 = -1;
        i3 = 1;
          goto _L11
_L2:
        int k6 = c1 - 65520;
        j2 = 1;
        int l6 = i2;
        l2 = k1;
        i3 = k6;
        l1 = l6;
          goto _L11
_L3:
        j2 = 2;
        l1 = i2;
        l2 = k1;
        i3 = 0;
          goto _L11
_L4:
        j2 = 3;
        l1 = i2;
        l2 = k1;
        i3 = 0;
          goto _L11
_L8:
        int i4 = k1 + 1;
        int j4 = abyte0[i4] << 24;
        int k4 = i4 + 1;
        int l4 = j4 + (abyte0[k4] << 18);
        int i5 = k4 + 1;
        int j5 = l4 + (abyte0[i5] << 12);
        int k5 = i5 + 1;
        int l5 = j5 + (abyte0[k5] << 6);
        int i6 = k5 + 1;
        int j6 = l5 + abyte0[i6];
        stringbuilder.append(q.format(j6));
        i3 = i2;
        l2 = i6;
          goto _L11
        j2 = -1;
        int k2 = i2;
        l2 = k1;
        i3 = k2;
          goto _L11
        for (; stringbuilder.length() > 0 && stringbuilder.charAt(-1 + stringbuilder.length()) == '\uFFFC'; stringbuilder.setLength(-1 + stringbuilder.length())) { }
        return stringbuilder.toString();
    }

    private static int b(byte abyte0[])
    {
        return a(abyte0, new byte[] {
            55, 56, 57, 58, 59, 60, 49, 50, 51, 52
        });
    }

    private static int c(byte abyte0[])
    {
        return a(abyte0, new byte[] {
            39, 40, 41, 42, 31, 32
        });
    }

    private static int d(byte abyte0[])
    {
        return a(abyte0, new byte[] {
            33, 34, 35, 36, 25, 26, 27, 28, 29, 30, 
            19, 20, 21, 22, 23, 24, 13, 14, 15, 16, 
            17, 18, 7, 8, 9, 10, 11, 12, 1, 2
        });
    }

    private static String e(byte abyte0[])
    {
        char ac[] = new char[6];
        ac[0] = s[0].charAt(a(abyte0, new byte[] {
            39, 40, 41, 42, 31, 32
        }));
        ac[1] = s[0].charAt(a(abyte0, new byte[] {
            33, 34, 35, 36, 25, 26
        }));
        ac[2] = s[0].charAt(a(abyte0, new byte[] {
            27, 28, 29, 30, 19, 20
        }));
        ac[3] = s[0].charAt(a(abyte0, new byte[] {
            21, 22, 23, 24, 13, 14
        }));
        ac[4] = s[0].charAt(a(abyte0, new byte[] {
            15, 16, 17, 18, 7, 8
        }));
        ac[5] = s[0].charAt(a(abyte0, new byte[] {
            9, 10, 11, 12, 1, 2
        }));
        return String.valueOf(ac);
    }

}
