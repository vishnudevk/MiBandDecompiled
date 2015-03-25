// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing;


public final class ResultMetadataType extends Enum
{

    public static final ResultMetadataType BYTE_SEGMENTS;
    public static final ResultMetadataType ERROR_CORRECTION_LEVEL;
    public static final ResultMetadataType ISSUE_NUMBER;
    public static final ResultMetadataType ORIENTATION;
    public static final ResultMetadataType OTHER;
    public static final ResultMetadataType POSSIBLE_COUNTRY;
    public static final ResultMetadataType SUGGESTED_PRICE;
    private static final ResultMetadataType a[];

    private ResultMetadataType(String s, int i)
    {
        super(s, i);
    }

    public static ResultMetadataType valueOf(String s)
    {
        return (ResultMetadataType)Enum.valueOf(com/google/zxing/ResultMetadataType, s);
    }

    public static ResultMetadataType[] values()
    {
        return (ResultMetadataType[])a.clone();
    }

    static 
    {
        OTHER = new ResultMetadataType("OTHER", 0);
        ORIENTATION = new ResultMetadataType("ORIENTATION", 1);
        BYTE_SEGMENTS = new ResultMetadataType("BYTE_SEGMENTS", 2);
        ERROR_CORRECTION_LEVEL = new ResultMetadataType("ERROR_CORRECTION_LEVEL", 3);
        ISSUE_NUMBER = new ResultMetadataType("ISSUE_NUMBER", 4);
        SUGGESTED_PRICE = new ResultMetadataType("SUGGESTED_PRICE", 5);
        POSSIBLE_COUNTRY = new ResultMetadataType("POSSIBLE_COUNTRY", 6);
        ResultMetadataType aresultmetadatatype[] = new ResultMetadataType[7];
        aresultmetadatatype[0] = OTHER;
        aresultmetadatatype[1] = ORIENTATION;
        aresultmetadatatype[2] = BYTE_SEGMENTS;
        aresultmetadatatype[3] = ERROR_CORRECTION_LEVEL;
        aresultmetadatatype[4] = ISSUE_NUMBER;
        aresultmetadatatype[5] = SUGGESTED_PRICE;
        aresultmetadatatype[6] = POSSIBLE_COUNTRY;
        a = aresultmetadatatype;
    }
}
