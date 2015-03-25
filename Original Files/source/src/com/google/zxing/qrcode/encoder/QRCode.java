// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.qrcode.encoder;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;

// Referenced classes of package com.google.zxing.qrcode.encoder:
//            ByteMatrix

public final class QRCode
{

    public static final int NUM_MASK_PATTERNS = 8;
    private Mode a;
    private ErrorCorrectionLevel b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private ByteMatrix j;

    public QRCode()
    {
        a = null;
        b = null;
        c = -1;
        d = -1;
        e = -1;
        f = -1;
        g = -1;
        h = -1;
        i = -1;
        j = null;
    }

    public static boolean isValidMaskPattern(int k)
    {
        return k >= 0 && k < 8;
    }

    public int at(int k, int l)
    {
        byte byte0 = j.get(k, l);
        if (byte0 != 0 && byte0 != 1)
        {
            throw new IllegalStateException("Bad value");
        } else
        {
            return byte0;
        }
    }

    public ErrorCorrectionLevel getECLevel()
    {
        return b;
    }

    public int getMaskPattern()
    {
        return e;
    }

    public ByteMatrix getMatrix()
    {
        return j;
    }

    public int getMatrixWidth()
    {
        return d;
    }

    public Mode getMode()
    {
        return a;
    }

    public int getNumDataBytes()
    {
        return g;
    }

    public int getNumECBytes()
    {
        return h;
    }

    public int getNumRSBlocks()
    {
        return i;
    }

    public int getNumTotalBytes()
    {
        return f;
    }

    public int getVersion()
    {
        return c;
    }

    public boolean isValid()
    {
        return a != null && b != null && c != -1 && d != -1 && e != -1 && f != -1 && g != -1 && h != -1 && i != -1 && isValidMaskPattern(e) && f == g + h && j != null && d == j.getWidth() && j.getWidth() == j.getHeight();
    }

    public void setECLevel(ErrorCorrectionLevel errorcorrectionlevel)
    {
        b = errorcorrectionlevel;
    }

    public void setMaskPattern(int k)
    {
        e = k;
    }

    public void setMatrix(ByteMatrix bytematrix)
    {
        j = bytematrix;
    }

    public void setMatrixWidth(int k)
    {
        d = k;
    }

    public void setMode(Mode mode)
    {
        a = mode;
    }

    public void setNumDataBytes(int k)
    {
        g = k;
    }

    public void setNumECBytes(int k)
    {
        h = k;
    }

    public void setNumRSBlocks(int k)
    {
        i = k;
    }

    public void setNumTotalBytes(int k)
    {
        f = k;
    }

    public void setVersion(int k)
    {
        c = k;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(200);
        stringbuilder.append("<<\n");
        stringbuilder.append(" mode: ");
        stringbuilder.append(a);
        stringbuilder.append("\n ecLevel: ");
        stringbuilder.append(b);
        stringbuilder.append("\n version: ");
        stringbuilder.append(c);
        stringbuilder.append("\n matrixWidth: ");
        stringbuilder.append(d);
        stringbuilder.append("\n maskPattern: ");
        stringbuilder.append(e);
        stringbuilder.append("\n numTotalBytes: ");
        stringbuilder.append(f);
        stringbuilder.append("\n numDataBytes: ");
        stringbuilder.append(g);
        stringbuilder.append("\n numECBytes: ");
        stringbuilder.append(h);
        stringbuilder.append("\n numRSBlocks: ");
        stringbuilder.append(i);
        if (j == null)
        {
            stringbuilder.append("\n matrix: null\n");
        } else
        {
            stringbuilder.append("\n matrix:\n");
            stringbuilder.append(j.toString());
        }
        stringbuilder.append(">>\n");
        return stringbuilder.toString();
    }
}
