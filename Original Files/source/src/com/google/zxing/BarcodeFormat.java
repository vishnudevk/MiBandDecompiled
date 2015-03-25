// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing;


public final class BarcodeFormat extends Enum
{

    public static final BarcodeFormat AZTEC;
    public static final BarcodeFormat CODABAR;
    public static final BarcodeFormat CODE_128;
    public static final BarcodeFormat CODE_39;
    public static final BarcodeFormat CODE_93;
    public static final BarcodeFormat DATA_MATRIX;
    public static final BarcodeFormat EAN_13;
    public static final BarcodeFormat EAN_8;
    public static final BarcodeFormat ITF;
    public static final BarcodeFormat MAXICODE;
    public static final BarcodeFormat PDF_417;
    public static final BarcodeFormat QR_CODE;
    public static final BarcodeFormat RSS_14;
    public static final BarcodeFormat RSS_EXPANDED;
    public static final BarcodeFormat UPC_A;
    public static final BarcodeFormat UPC_E;
    public static final BarcodeFormat UPC_EAN_EXTENSION;
    private static final BarcodeFormat a[];

    private BarcodeFormat(String s, int i)
    {
        super(s, i);
    }

    public static BarcodeFormat valueOf(String s)
    {
        return (BarcodeFormat)Enum.valueOf(com/google/zxing/BarcodeFormat, s);
    }

    public static BarcodeFormat[] values()
    {
        return (BarcodeFormat[])a.clone();
    }

    static 
    {
        AZTEC = new BarcodeFormat("AZTEC", 0);
        CODABAR = new BarcodeFormat("CODABAR", 1);
        CODE_39 = new BarcodeFormat("CODE_39", 2);
        CODE_93 = new BarcodeFormat("CODE_93", 3);
        CODE_128 = new BarcodeFormat("CODE_128", 4);
        DATA_MATRIX = new BarcodeFormat("DATA_MATRIX", 5);
        EAN_8 = new BarcodeFormat("EAN_8", 6);
        EAN_13 = new BarcodeFormat("EAN_13", 7);
        ITF = new BarcodeFormat("ITF", 8);
        MAXICODE = new BarcodeFormat("MAXICODE", 9);
        PDF_417 = new BarcodeFormat("PDF_417", 10);
        QR_CODE = new BarcodeFormat("QR_CODE", 11);
        RSS_14 = new BarcodeFormat("RSS_14", 12);
        RSS_EXPANDED = new BarcodeFormat("RSS_EXPANDED", 13);
        UPC_A = new BarcodeFormat("UPC_A", 14);
        UPC_E = new BarcodeFormat("UPC_E", 15);
        UPC_EAN_EXTENSION = new BarcodeFormat("UPC_EAN_EXTENSION", 16);
        BarcodeFormat abarcodeformat[] = new BarcodeFormat[17];
        abarcodeformat[0] = AZTEC;
        abarcodeformat[1] = CODABAR;
        abarcodeformat[2] = CODE_39;
        abarcodeformat[3] = CODE_93;
        abarcodeformat[4] = CODE_128;
        abarcodeformat[5] = DATA_MATRIX;
        abarcodeformat[6] = EAN_8;
        abarcodeformat[7] = EAN_13;
        abarcodeformat[8] = ITF;
        abarcodeformat[9] = MAXICODE;
        abarcodeformat[10] = PDF_417;
        abarcodeformat[11] = QR_CODE;
        abarcodeformat[12] = RSS_14;
        abarcodeformat[13] = RSS_EXPANDED;
        abarcodeformat[14] = UPC_A;
        abarcodeformat[15] = UPC_E;
        abarcodeformat[16] = UPC_EAN_EXTENSION;
        a = abarcodeformat;
    }
}
