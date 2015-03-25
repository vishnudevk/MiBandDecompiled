// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.qrcode.decoder;


public final class ErrorCorrectionLevel extends Enum
{

    public static final ErrorCorrectionLevel H;
    public static final ErrorCorrectionLevel L;
    public static final ErrorCorrectionLevel M;
    public static final ErrorCorrectionLevel Q;
    private static final ErrorCorrectionLevel a[];
    private static final ErrorCorrectionLevel c[];
    private final int b;

    private ErrorCorrectionLevel(String s, int i, int j)
    {
        super(s, i);
        b = j;
    }

    public static ErrorCorrectionLevel forBits(int i)
    {
        if (i < 0 || i >= a.length)
        {
            throw new IllegalArgumentException();
        } else
        {
            return a[i];
        }
    }

    public static ErrorCorrectionLevel valueOf(String s)
    {
        return (ErrorCorrectionLevel)Enum.valueOf(com/google/zxing/qrcode/decoder/ErrorCorrectionLevel, s);
    }

    public static ErrorCorrectionLevel[] values()
    {
        return (ErrorCorrectionLevel[])c.clone();
    }

    public int getBits()
    {
        return b;
    }

    static 
    {
        L = new ErrorCorrectionLevel("L", 0, 1);
        M = new ErrorCorrectionLevel("M", 1, 0);
        Q = new ErrorCorrectionLevel("Q", 2, 3);
        H = new ErrorCorrectionLevel("H", 3, 2);
        ErrorCorrectionLevel aerrorcorrectionlevel[] = new ErrorCorrectionLevel[4];
        aerrorcorrectionlevel[0] = L;
        aerrorcorrectionlevel[1] = M;
        aerrorcorrectionlevel[2] = Q;
        aerrorcorrectionlevel[3] = H;
        c = aerrorcorrectionlevel;
        ErrorCorrectionLevel aerrorcorrectionlevel1[] = new ErrorCorrectionLevel[4];
        aerrorcorrectionlevel1[0] = M;
        aerrorcorrectionlevel1[1] = L;
        aerrorcorrectionlevel1[2] = H;
        aerrorcorrectionlevel1[3] = Q;
        a = aerrorcorrectionlevel1;
    }
}
