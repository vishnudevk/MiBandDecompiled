// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing;

import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.CodaBarWriter;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.oned.Code39Writer;
import com.google.zxing.oned.EAN13Writer;
import com.google.zxing.oned.EAN8Writer;
import com.google.zxing.oned.ITFWriter;
import com.google.zxing.oned.UPCAWriter;
import com.google.zxing.pdf417.encoder.PDF417Writer;
import com.google.zxing.qrcode.QRCodeWriter;
import java.util.Map;

// Referenced classes of package com.google.zxing:
//            Writer, a, BarcodeFormat

public final class MultiFormatWriter
    implements Writer
{

    public MultiFormatWriter()
    {
    }

    public BitMatrix encode(String s, BarcodeFormat barcodeformat, int i, int j)
    {
        return encode(s, barcodeformat, i, j, null);
    }

    public BitMatrix encode(String s, BarcodeFormat barcodeformat, int i, int j, Map map)
    {
        a.a[barcodeformat.ordinal()];
        JVM INSTR tableswitch 1 9: default 60
    //                   1 87
    //                   2 111
    //                   3 123
    //                   4 135
    //                   5 147
    //                   6 159
    //                   7 171
    //                   8 183
    //                   9 195;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L1:
        throw new IllegalArgumentException((new StringBuilder()).append("No encoder available for format ").append(barcodeformat).toString());
_L2:
        Object obj = new EAN8Writer();
_L12:
        return ((Writer) (obj)).encode(s, barcodeformat, i, j, map);
_L3:
        obj = new EAN13Writer();
        continue; /* Loop/switch isn't completed */
_L4:
        obj = new UPCAWriter();
        continue; /* Loop/switch isn't completed */
_L5:
        obj = new QRCodeWriter();
        continue; /* Loop/switch isn't completed */
_L6:
        obj = new Code39Writer();
        continue; /* Loop/switch isn't completed */
_L7:
        obj = new Code128Writer();
        continue; /* Loop/switch isn't completed */
_L8:
        obj = new ITFWriter();
        continue; /* Loop/switch isn't completed */
_L9:
        obj = new PDF417Writer();
        continue; /* Loop/switch isn't completed */
_L10:
        obj = new CodaBarWriter();
        if (true) goto _L12; else goto _L11
_L11:
    }
}
