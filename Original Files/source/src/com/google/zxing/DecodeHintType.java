// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing;


public final class DecodeHintType extends Enum
{

    public static final DecodeHintType ALLOWED_LENGTHS;
    public static final DecodeHintType ASSUME_CODE_39_CHECK_DIGIT;
    public static final DecodeHintType CHARACTER_SET;
    public static final DecodeHintType NEED_RESULT_POINT_CALLBACK;
    public static final DecodeHintType OTHER;
    public static final DecodeHintType POSSIBLE_FORMATS;
    public static final DecodeHintType PURE_BARCODE;
    public static final DecodeHintType TRY_HARDER;
    private static final DecodeHintType a[];

    private DecodeHintType(String s, int i)
    {
        super(s, i);
    }

    public static DecodeHintType valueOf(String s)
    {
        return (DecodeHintType)Enum.valueOf(com/google/zxing/DecodeHintType, s);
    }

    public static DecodeHintType[] values()
    {
        return (DecodeHintType[])a.clone();
    }

    static 
    {
        OTHER = new DecodeHintType("OTHER", 0);
        PURE_BARCODE = new DecodeHintType("PURE_BARCODE", 1);
        POSSIBLE_FORMATS = new DecodeHintType("POSSIBLE_FORMATS", 2);
        TRY_HARDER = new DecodeHintType("TRY_HARDER", 3);
        CHARACTER_SET = new DecodeHintType("CHARACTER_SET", 4);
        ALLOWED_LENGTHS = new DecodeHintType("ALLOWED_LENGTHS", 5);
        ASSUME_CODE_39_CHECK_DIGIT = new DecodeHintType("ASSUME_CODE_39_CHECK_DIGIT", 6);
        NEED_RESULT_POINT_CALLBACK = new DecodeHintType("NEED_RESULT_POINT_CALLBACK", 7);
        DecodeHintType adecodehinttype[] = new DecodeHintType[8];
        adecodehinttype[0] = OTHER;
        adecodehinttype[1] = PURE_BARCODE;
        adecodehinttype[2] = POSSIBLE_FORMATS;
        adecodehinttype[3] = TRY_HARDER;
        adecodehinttype[4] = CHARACTER_SET;
        adecodehinttype[5] = ALLOWED_LENGTHS;
        adecodehinttype[6] = ASSUME_CODE_39_CHECK_DIGIT;
        adecodehinttype[7] = NEED_RESULT_POINT_CALLBACK;
        a = adecodehinttype;
    }
}
