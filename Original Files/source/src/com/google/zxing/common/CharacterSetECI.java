// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.common;

import java.util.HashMap;
import java.util.Map;

public final class CharacterSetECI extends Enum
{

    public static final CharacterSetECI ASCII;
    public static final CharacterSetECI Big5;
    public static final CharacterSetECI Cp1250;
    public static final CharacterSetECI Cp1251;
    public static final CharacterSetECI Cp1252;
    public static final CharacterSetECI Cp1256;
    public static final CharacterSetECI Cp437;
    public static final CharacterSetECI EUC_KR;
    public static final CharacterSetECI GB18030;
    public static final CharacterSetECI ISO8859_1;
    public static final CharacterSetECI ISO8859_10;
    public static final CharacterSetECI ISO8859_11;
    public static final CharacterSetECI ISO8859_13;
    public static final CharacterSetECI ISO8859_14;
    public static final CharacterSetECI ISO8859_15;
    public static final CharacterSetECI ISO8859_16;
    public static final CharacterSetECI ISO8859_2;
    public static final CharacterSetECI ISO8859_3;
    public static final CharacterSetECI ISO8859_4;
    public static final CharacterSetECI ISO8859_5;
    public static final CharacterSetECI ISO8859_6;
    public static final CharacterSetECI ISO8859_7;
    public static final CharacterSetECI ISO8859_8;
    public static final CharacterSetECI ISO8859_9;
    public static final CharacterSetECI SJIS;
    public static final CharacterSetECI UTF8;
    public static final CharacterSetECI UnicodeBigUnmarked;
    private static final Map a;
    private static final Map b;
    private static final CharacterSetECI e[];
    private final int c[];
    private final String d[];

    private CharacterSetECI(String s, int i, int j)
    {
        this(s, i, new int[] {
            j
        }, new String[0]);
    }

    private transient CharacterSetECI(String s, int i, int j, String as[])
    {
        super(s, i);
        c = (new int[] {
            j
        });
        d = as;
    }

    private transient CharacterSetECI(String s, int i, int ai[], String as[])
    {
        super(s, i);
        c = ai;
        d = as;
    }

    public static CharacterSetECI getCharacterSetECIByName(String s)
    {
        return (CharacterSetECI)b.get(s);
    }

    public static CharacterSetECI getCharacterSetECIByValue(int i)
    {
        if (i < 0 || i >= 900)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Bad ECI value: ").append(i).toString());
        } else
        {
            return (CharacterSetECI)a.get(Integer.valueOf(i));
        }
    }

    public static CharacterSetECI valueOf(String s)
    {
        return (CharacterSetECI)Enum.valueOf(com/google/zxing/common/CharacterSetECI, s);
    }

    public static CharacterSetECI[] values()
    {
        return (CharacterSetECI[])e.clone();
    }

    public int getValue()
    {
        return c[0];
    }

    static 
    {
        Cp437 = new CharacterSetECI("Cp437", 0, new int[] {
            0, 2
        }, new String[0]);
        ISO8859_1 = new CharacterSetECI("ISO8859_1", 1, new int[] {
            1, 3
        }, new String[] {
            "ISO-8859-1"
        });
        ISO8859_2 = new CharacterSetECI("ISO8859_2", 2, 4, new String[] {
            "ISO-8859-2"
        });
        ISO8859_3 = new CharacterSetECI("ISO8859_3", 3, 5, new String[] {
            "ISO-8859-3"
        });
        ISO8859_4 = new CharacterSetECI("ISO8859_4", 4, 6, new String[] {
            "ISO-8859-4"
        });
        ISO8859_5 = new CharacterSetECI("ISO8859_5", 5, 7, new String[] {
            "ISO-8859-5"
        });
        ISO8859_6 = new CharacterSetECI("ISO8859_6", 6, 8, new String[] {
            "ISO-8859-6"
        });
        ISO8859_7 = new CharacterSetECI("ISO8859_7", 7, 9, new String[] {
            "ISO-8859-7"
        });
        ISO8859_8 = new CharacterSetECI("ISO8859_8", 8, 10, new String[] {
            "ISO-8859-8"
        });
        ISO8859_9 = new CharacterSetECI("ISO8859_9", 9, 11, new String[] {
            "ISO-8859-9"
        });
        ISO8859_10 = new CharacterSetECI("ISO8859_10", 10, 12, new String[] {
            "ISO-8859-10"
        });
        ISO8859_11 = new CharacterSetECI("ISO8859_11", 11, 13, new String[] {
            "ISO-8859-11"
        });
        ISO8859_13 = new CharacterSetECI("ISO8859_13", 12, 15, new String[] {
            "ISO-8859-13"
        });
        ISO8859_14 = new CharacterSetECI("ISO8859_14", 13, 16, new String[] {
            "ISO-8859-14"
        });
        ISO8859_15 = new CharacterSetECI("ISO8859_15", 14, 17, new String[] {
            "ISO-8859-15"
        });
        ISO8859_16 = new CharacterSetECI("ISO8859_16", 15, 18, new String[] {
            "ISO-8859-16"
        });
        SJIS = new CharacterSetECI("SJIS", 16, 20, new String[] {
            "Shift_JIS"
        });
        Cp1250 = new CharacterSetECI("Cp1250", 17, 21, new String[] {
            "windows-1250"
        });
        Cp1251 = new CharacterSetECI("Cp1251", 18, 22, new String[] {
            "windows-1251"
        });
        Cp1252 = new CharacterSetECI("Cp1252", 19, 23, new String[] {
            "windows-1252"
        });
        Cp1256 = new CharacterSetECI("Cp1256", 20, 24, new String[] {
            "windows-1256"
        });
        UnicodeBigUnmarked = new CharacterSetECI("UnicodeBigUnmarked", 21, 25, new String[] {
            "UTF-16BE", "UnicodeBig"
        });
        UTF8 = new CharacterSetECI("UTF8", 22, 26, new String[] {
            "UTF-8"
        });
        ASCII = new CharacterSetECI("ASCII", 23, new int[] {
            27, 170
        }, new String[] {
            "US-ASCII"
        });
        Big5 = new CharacterSetECI("Big5", 24, 28);
        GB18030 = new CharacterSetECI("GB18030", 25, 29, new String[] {
            "GB2312", "EUC_CN", "GBK"
        });
        EUC_KR = new CharacterSetECI("EUC_KR", 26, 30, new String[] {
            "EUC-KR"
        });
        CharacterSetECI acharacterseteci[] = new CharacterSetECI[27];
        acharacterseteci[0] = Cp437;
        acharacterseteci[1] = ISO8859_1;
        acharacterseteci[2] = ISO8859_2;
        acharacterseteci[3] = ISO8859_3;
        acharacterseteci[4] = ISO8859_4;
        acharacterseteci[5] = ISO8859_5;
        acharacterseteci[6] = ISO8859_6;
        acharacterseteci[7] = ISO8859_7;
        acharacterseteci[8] = ISO8859_8;
        acharacterseteci[9] = ISO8859_9;
        acharacterseteci[10] = ISO8859_10;
        acharacterseteci[11] = ISO8859_11;
        acharacterseteci[12] = ISO8859_13;
        acharacterseteci[13] = ISO8859_14;
        acharacterseteci[14] = ISO8859_15;
        acharacterseteci[15] = ISO8859_16;
        acharacterseteci[16] = SJIS;
        acharacterseteci[17] = Cp1250;
        acharacterseteci[18] = Cp1251;
        acharacterseteci[19] = Cp1252;
        acharacterseteci[20] = Cp1256;
        acharacterseteci[21] = UnicodeBigUnmarked;
        acharacterseteci[22] = UTF8;
        acharacterseteci[23] = ASCII;
        acharacterseteci[24] = Big5;
        acharacterseteci[25] = GB18030;
        acharacterseteci[26] = EUC_KR;
        e = acharacterseteci;
        a = new HashMap();
        b = new HashMap();
        CharacterSetECI acharacterseteci1[] = values();
        int i = acharacterseteci1.length;
        for (int j = 0; j < i; j++)
        {
            CharacterSetECI characterseteci = acharacterseteci1[j];
            int ai[] = characterseteci.c;
            int k = ai.length;
            for (int l = 0; l < k; l++)
            {
                int k1 = ai[l];
                a.put(Integer.valueOf(k1), characterseteci);
            }

            b.put(characterseteci.name(), characterseteci);
            String as[] = characterseteci.d;
            int i1 = as.length;
            for (int j1 = 0; j1 < i1; j1++)
            {
                String s = as[j1];
                b.put(s, characterseteci);
            }

        }

    }
}
