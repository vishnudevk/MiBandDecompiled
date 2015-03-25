// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.StringUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.zxing.qrcode.decoder:
//            Mode, ErrorCorrectionLevel, Version

final class m
{

    private static final char a[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
        'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 
        'U', 'V', 'W', 'X', 'Y', 'Z', ' ', '$', '%', '*', 
        '+', '-', '.', '/', ':'
    };
    private static final int b = 1;

    private m()
    {
    }

    private static char a(int i)
    {
        if (i >= a.length)
        {
            throw FormatException.getFormatInstance();
        } else
        {
            return a[i];
        }
    }

    private static int a(BitSource bitsource)
    {
        int i = bitsource.readBits(8);
        if ((i & 0x80) == 0)
        {
            return i & 0x7f;
        }
        if ((i & 0xc0) == 128)
        {
            return bitsource.readBits(8) | (i & 0x3f) << 8;
        }
        if ((i & 0xe0) == 192)
        {
            return bitsource.readBits(16) | (i & 0x1f) << 16;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Bad ECI bits starting with byte ").append(i).toString());
        }
    }

    static DecoderResult a(byte abyte0[], Version version, ErrorCorrectionLevel errorcorrectionlevel, Map map)
    {
        BitSource bitsource = new BitSource(abyte0);
        StringBuilder stringbuilder = new StringBuilder(50);
        boolean flag = false;
        ArrayList arraylist = new ArrayList(1);
        CharacterSetECI characterseteci = null;
        do
        {
            Mode mode1;
            boolean flag1;
            if (bitsource.available() < 4)
            {
                mode1 = Mode.TERMINATOR;
            } else
            {
                Mode mode;
                try
                {
                    mode = Mode.forBits(bitsource.readBits(4));
                }
                catch (IllegalArgumentException illegalargumentexception)
                {
                    throw FormatException.getFormatInstance();
                }
                mode1 = mode;
            }
            if (mode1 != Mode.TERMINATOR)
            {
                if (mode1 == Mode.FNC1_FIRST_POSITION || mode1 == Mode.FNC1_SECOND_POSITION)
                {
                    flag1 = true;
                } else
                if (mode1 == Mode.STRUCTURED_APPEND)
                {
                    bitsource.readBits(16);
                    flag1 = flag;
                } else
                if (mode1 == Mode.ECI)
                {
                    characterseteci = CharacterSetECI.getCharacterSetECIByValue(a(bitsource));
                    if (characterseteci == null)
                    {
                        throw FormatException.getFormatInstance();
                    }
                    flag1 = flag;
                } else
                if (mode1 == Mode.HANZI)
                {
                    int j = bitsource.readBits(4);
                    int k = bitsource.readBits(mode1.getCharacterCountBits(version));
                    if (j == 1)
                    {
                        a(bitsource, stringbuilder, k);
                    }
                    flag1 = flag;
                } else
                {
                    int i = bitsource.readBits(mode1.getCharacterCountBits(version));
                    if (mode1 == Mode.NUMERIC)
                    {
                        c(bitsource, stringbuilder, i);
                        flag1 = flag;
                    } else
                    if (mode1 == Mode.ALPHANUMERIC)
                    {
                        a(bitsource, stringbuilder, i, flag);
                        flag1 = flag;
                    } else
                    if (mode1 == Mode.BYTE)
                    {
                        a(bitsource, stringbuilder, i, characterseteci, ((Collection) (arraylist)), map);
                        flag1 = flag;
                    } else
                    if (mode1 == Mode.KANJI)
                    {
                        b(bitsource, stringbuilder, i);
                        flag1 = flag;
                    } else
                    {
                        throw FormatException.getFormatInstance();
                    }
                }
            } else
            {
                flag1 = flag;
            }
            if (mode1 == Mode.TERMINATOR)
            {
                String s = stringbuilder.toString();
                if (arraylist.isEmpty())
                {
                    arraylist = null;
                }
                String s1 = null;
                if (errorcorrectionlevel != null)
                {
                    s1 = errorcorrectionlevel.toString();
                }
                return new DecoderResult(abyte0, s, arraylist, s1);
            }
            flag = flag1;
        } while (true);
    }

    private static void a(BitSource bitsource, StringBuilder stringbuilder, int i)
    {
        if (i * 13 > bitsource.available())
        {
            throw FormatException.getFormatInstance();
        }
        byte abyte0[] = new byte[i * 2];
        int j = 0;
        while (i > 0) 
        {
            int k = bitsource.readBits(13);
            int l = k / 96 << 8 | k % 96;
            int i1;
            int j1;
            if (l < 959)
            {
                i1 = l + 41377;
            } else
            {
                i1 = l + 42657;
            }
            abyte0[j] = (byte)(0xff & i1 >> 8);
            abyte0[j + 1] = (byte)(i1 & 0xff);
            j1 = j + 2;
            i--;
            j = j1;
        }
        try
        {
            stringbuilder.append(new String(abyte0, "GB2312"));
            return;
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw FormatException.getFormatInstance();
        }
    }

    private static void a(BitSource bitsource, StringBuilder stringbuilder, int i, CharacterSetECI characterseteci, Collection collection, Map map)
    {
        if (i << 3 > bitsource.available())
        {
            throw FormatException.getFormatInstance();
        }
        byte abyte0[] = new byte[i];
        for (int j = 0; j < i; j++)
        {
            abyte0[j] = (byte)bitsource.readBits(8);
        }

        String s;
        if (characterseteci == null)
        {
            s = StringUtils.guessEncoding(abyte0, map);
        } else
        {
            s = characterseteci.name();
        }
        try
        {
            stringbuilder.append(new String(abyte0, s));
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw FormatException.getFormatInstance();
        }
        collection.add(abyte0);
    }

    private static void a(BitSource bitsource, StringBuilder stringbuilder, int i, boolean flag)
    {
        int j = stringbuilder.length();
        for (; i > 1; i -= 2)
        {
            int k = bitsource.readBits(11);
            stringbuilder.append(a(k / 45));
            stringbuilder.append(a(k % 45));
        }

        if (i == 1)
        {
            stringbuilder.append(a(bitsource.readBits(6)));
        }
        if (flag)
        {
            while (j < stringbuilder.length()) 
            {
                if (stringbuilder.charAt(j) == '%')
                {
                    if (j < -1 + stringbuilder.length() && stringbuilder.charAt(j + 1) == '%')
                    {
                        stringbuilder.deleteCharAt(j + 1);
                    } else
                    {
                        stringbuilder.setCharAt(j, '\035');
                    }
                }
                j++;
            }
        }
    }

    private static void b(BitSource bitsource, StringBuilder stringbuilder, int i)
    {
        if (i * 13 > bitsource.available())
        {
            throw FormatException.getFormatInstance();
        }
        byte abyte0[] = new byte[i * 2];
        int j = 0;
        while (i > 0) 
        {
            int k = bitsource.readBits(13);
            int l = k / 192 << 8 | k % 192;
            int i1;
            int j1;
            if (l < 7936)
            {
                i1 = l + 33088;
            } else
            {
                i1 = l + 49472;
            }
            abyte0[j] = (byte)(i1 >> 8);
            abyte0[j + 1] = (byte)i1;
            j1 = j + 2;
            i--;
            j = j1;
        }
        try
        {
            stringbuilder.append(new String(abyte0, "SJIS"));
            return;
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw FormatException.getFormatInstance();
        }
    }

    private static void c(BitSource bitsource, StringBuilder stringbuilder, int i)
    {
        for (; i >= 3; i -= 3)
        {
            if (bitsource.available() < 10)
            {
                throw FormatException.getFormatInstance();
            }
            int l = bitsource.readBits(10);
            if (l >= 1000)
            {
                throw FormatException.getFormatInstance();
            }
            stringbuilder.append(a(l / 100));
            stringbuilder.append(a((l / 10) % 10));
            stringbuilder.append(a(l % 10));
        }

        if (i == 2)
        {
            if (bitsource.available() < 7)
            {
                throw FormatException.getFormatInstance();
            }
            int k = bitsource.readBits(7);
            if (k >= 100)
            {
                throw FormatException.getFormatInstance();
            }
            stringbuilder.append(a(k / 10));
            stringbuilder.append(a(k % 10));
        } else
        if (i == 1)
        {
            if (bitsource.available() < 4)
            {
                throw FormatException.getFormatInstance();
            }
            int j = bitsource.readBits(4);
            if (j >= 10)
            {
                throw FormatException.getFormatInstance();
            } else
            {
                stringbuilder.append(a(j));
                return;
            }
        }
    }

}
