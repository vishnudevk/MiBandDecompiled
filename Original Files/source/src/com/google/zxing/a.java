// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing;


// Referenced classes of package com.google.zxing:
//            BarcodeFormat

class a
{

    static final int a[];

    static 
    {
        a = new int[BarcodeFormat.values().length];
        try
        {
            a[BarcodeFormat.EAN_8.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        try
        {
            a[BarcodeFormat.EAN_13.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[BarcodeFormat.UPC_A.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[BarcodeFormat.QR_CODE.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[BarcodeFormat.CODE_39.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            a[BarcodeFormat.CODE_128.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            a[BarcodeFormat.ITF.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            a[BarcodeFormat.PDF_417.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            a[BarcodeFormat.CODABAR.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror8)
        {
            return;
        }
    }
}
