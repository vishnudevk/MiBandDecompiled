// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing;


public abstract class LuminanceSource
{

    private final int a;
    private final int b;

    protected LuminanceSource(int i, int j)
    {
        a = i;
        b = j;
    }

    public LuminanceSource crop(int i, int j, int k, int l)
    {
        throw new UnsupportedOperationException("This luminance source does not support cropping.");
    }

    public final int getHeight()
    {
        return b;
    }

    public abstract byte[] getMatrix();

    public abstract byte[] getRow(int i, byte abyte0[]);

    public final int getWidth()
    {
        return a;
    }

    public boolean isCropSupported()
    {
        return false;
    }

    public boolean isRotateSupported()
    {
        return false;
    }

    public LuminanceSource rotateCounterClockwise()
    {
        throw new UnsupportedOperationException("This luminance source does not support rotation.");
    }

    public String toString()
    {
        byte abyte0[] = new byte[a];
        StringBuilder stringbuilder = new StringBuilder(b * (1 + a));
        byte abyte1[] = abyte0;
        for (int i = 0; i < b; i++)
        {
            abyte1 = getRow(i, abyte1);
            int j = 0;
            while (j < a) 
            {
                int k = 0xff & abyte1[j];
                char c;
                if (k < 64)
                {
                    c = '#';
                } else
                if (k < 128)
                {
                    c = '+';
                } else
                if (k < 192)
                {
                    c = '.';
                } else
                {
                    c = ' ';
                }
                stringbuilder.append(c);
                j++;
            }
            stringbuilder.append('\n');
        }

        return stringbuilder.toString();
    }
}
