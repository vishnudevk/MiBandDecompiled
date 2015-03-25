// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.google.zxing.qrcode.encoder.Encoder;
import com.google.zxing.qrcode.encoder.QRCode;
import java.util.Map;

public final class QRCodeWriter
    implements Writer
{

    private static final int a = 4;

    public QRCodeWriter()
    {
    }

    private static BitMatrix a(QRCode qrcode, int i, int j)
    {
        ByteMatrix bytematrix = qrcode.getMatrix();
        if (bytematrix == null)
        {
            throw new IllegalStateException();
        }
        int k = bytematrix.getWidth();
        int l = bytematrix.getHeight();
        int i1 = k + 8;
        int j1 = l + 8;
        int k1 = Math.max(i, i1);
        int l1 = Math.max(j, j1);
        int i2 = Math.min(k1 / i1, l1 / j1);
        int j2 = (k1 - k * i2) / 2;
        int k2 = (l1 - l * i2) / 2;
        BitMatrix bitmatrix = new BitMatrix(k1, l1);
        int l2 = k2;
        int l3;
        for (int i3 = 0; i3 < l; i3 = l3)
        {
            int j3 = j2;
            for (int k3 = 0; k3 < k;)
            {
                if (bytematrix.get(k3, i3) == 1)
                {
                    bitmatrix.setRegion(j3, l2, i2, i2);
                }
                k3++;
                j3 += i2;
            }

            l3 = i3 + 1;
            l2 += i2;
        }

        return bitmatrix;
    }

    public BitMatrix encode(String s, BarcodeFormat barcodeformat, int i, int j)
    {
        return encode(s, barcodeformat, i, j, null);
    }

    public BitMatrix encode(String s, BarcodeFormat barcodeformat, int i, int j, Map map)
    {
        ErrorCorrectionLevel errorcorrectionlevel;
        if (s.length() == 0)
        {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (barcodeformat != BarcodeFormat.QR_CODE)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Can only encode QR_CODE, but got ").append(barcodeformat).toString());
        }
        if (i < 0 || j < 0)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Requested dimensions are too small: ").append(i).append('x').append(j).toString());
        }
        errorcorrectionlevel = ErrorCorrectionLevel.L;
        if (map == null) goto _L2; else goto _L1
_L1:
        ErrorCorrectionLevel errorcorrectionlevel1 = (ErrorCorrectionLevel)map.get(EncodeHintType.ERROR_CORRECTION);
        if (errorcorrectionlevel1 == null) goto _L2; else goto _L3
_L3:
        QRCode qrcode = new QRCode();
        Encoder.encode(s, errorcorrectionlevel1, map, qrcode);
        return a(qrcode, i, j);
_L2:
        errorcorrectionlevel1 = errorcorrectionlevel;
        if (true) goto _L3; else goto _L4
_L4:
    }
}
