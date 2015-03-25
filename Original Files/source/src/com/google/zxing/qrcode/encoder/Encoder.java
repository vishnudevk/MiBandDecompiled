// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.qrcode.encoder;

import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.google.zxing.qrcode.encoder:
//            d, c, QRCode, a, 
//            b, ByteMatrix

public final class Encoder
{

    static final String a = "ISO-8859-1";
    private static final int b[] = {
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, 
        -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 
        2, 3, 4, 5, 6, 7, 8, 9, 44, -1, 
        -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 
        15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
        25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 
        35, -1, -1, -1, -1, -1
    };

    private Encoder()
    {
    }

    static int a(int i)
    {
        if (i < b.length)
        {
            return b[i];
        } else
        {
            return -1;
        }
    }

    private static int a(int i, Version version, Mode mode)
    {
        return (7 + (i + (4 + mode.getCharacterCountBits(version)))) / 8;
    }

    private static int a(BitArray bitarray, ErrorCorrectionLevel errorcorrectionlevel, int i, ByteMatrix bytematrix)
    {
        int j = 0x7fffffff;
        int k = -1;
        int l = 0;
        while (l < 8) 
        {
            d.a(bitarray, errorcorrectionlevel, i, l, bytematrix);
            int i1 = a(bytematrix);
            if (i1 < j)
            {
                k = l;
            } else
            {
                i1 = j;
            }
            l++;
            j = i1;
        }
        return k;
    }

    private static int a(ByteMatrix bytematrix)
    {
        return 0 + c.a(bytematrix) + c.b(bytematrix) + c.c(bytematrix) + c.d(bytematrix);
    }

    private static Mode a(String s, String s1)
    {
        int i = 0;
        if ("Shift_JIS".equals(s1))
        {
            if (a(s))
            {
                return Mode.KANJI;
            } else
            {
                return Mode.BYTE;
            }
        }
        boolean flag = false;
        boolean flag1 = false;
        while (i < s.length()) 
        {
            char c1 = s.charAt(i);
            if (c1 >= '0' && c1 <= '9')
            {
                flag1 = true;
            } else
            if (a(c1) != -1)
            {
                flag = true;
            } else
            {
                return Mode.BYTE;
            }
            i++;
        }
        if (flag)
        {
            return Mode.ALPHANUMERIC;
        }
        if (flag1)
        {
            return Mode.NUMERIC;
        } else
        {
            return Mode.BYTE;
        }
    }

    static void a(int i, int j, int k, int l, int ai[], int ai1[])
    {
        if (l >= k)
        {
            throw new WriterException("Block ID too large");
        }
        int i1 = i % k;
        int j1 = k - i1;
        int k1 = i / k;
        int l1 = k1 + 1;
        int i2 = j / k;
        int j2 = i2 + 1;
        int k2 = k1 - i2;
        int l2 = l1 - j2;
        if (k2 != l2)
        {
            throw new WriterException("EC bytes mismatch");
        }
        if (k != j1 + i1)
        {
            throw new WriterException("RS blocks mismatch");
        }
        if (i != j1 * (i2 + k2) + i1 * (j2 + l2))
        {
            throw new WriterException("Total bytes mismatch");
        }
        if (l < j1)
        {
            ai[0] = i2;
            ai1[0] = k2;
            return;
        } else
        {
            ai[0] = j2;
            ai1[0] = l2;
            return;
        }
    }

    static void a(int i, int j, Mode mode, BitArray bitarray)
    {
        int k = mode.getCharacterCountBits(Version.getVersionForNumber(j));
        if (i > -1 + (1 << k))
        {
            throw new WriterException((new StringBuilder()).append(i).append("is bigger than").append(-1 + (1 << k)).toString());
        } else
        {
            bitarray.appendBits(i, k);
            return;
        }
    }

    static void a(int i, BitArray bitarray)
    {
        int j = i << 3;
        if (bitarray.getSize() > j)
        {
            throw new WriterException((new StringBuilder()).append("data bits cannot fit in the QR Code").append(bitarray.getSize()).append(" > ").append(j).toString());
        }
        for (int k = 0; k < 4 && bitarray.getSize() < j; k++)
        {
            bitarray.appendBit(false);
        }

        int l = 7 & bitarray.getSize();
        if (l > 0)
        {
            for (; l < 8; l++)
            {
                bitarray.appendBit(false);
            }

        }
        int i1 = i - bitarray.getSizeInBytes();
        int j1 = 0;
        while (j1 < i1) 
        {
            char c1;
            if ((j1 & 1) == 0)
            {
                c1 = '\354';
            } else
            {
                c1 = '\021';
            }
            bitarray.appendBits(c1, 8);
            j1++;
        }
        if (bitarray.getSize() != j)
        {
            throw new WriterException("Bits size does not equal capacity");
        } else
        {
            return;
        }
    }

    private static void a(int i, ErrorCorrectionLevel errorcorrectionlevel, Mode mode, QRCode qrcode)
    {
        qrcode.setECLevel(errorcorrectionlevel);
        qrcode.setMode(mode);
        for (int j = 1; j <= 40; j++)
        {
            Version version = Version.getVersionForNumber(j);
            int k = version.getTotalCodewords();
            com.google.zxing.qrcode.decoder.Version.ECBlocks ecblocks = version.getECBlocksForLevel(errorcorrectionlevel);
            int l = ecblocks.getTotalECCodewords();
            int i1 = ecblocks.getNumBlocks();
            int j1 = k - l;
            if (j1 >= a(i, version, mode))
            {
                qrcode.setVersion(j);
                qrcode.setNumTotalBytes(k);
                qrcode.setNumDataBytes(j1);
                qrcode.setNumRSBlocks(i1);
                qrcode.setNumECBytes(l);
                qrcode.setMatrixWidth(version.getDimensionForVersion());
                return;
            }
        }

        throw new WriterException("Cannot find proper rs block info (input data too big?)");
    }

    static void a(BitArray bitarray, int i, int j, int k, BitArray bitarray1)
    {
        if (bitarray.getSizeInBytes() != j)
        {
            throw new WriterException("Number of bits and data bytes does not match");
        }
        ArrayList arraylist = new ArrayList(k);
        int l = 0;
        int i1 = 0;
        int j1 = 0;
        int k1;
        int i3;
        for (k1 = 0; l < k; k1 = i3)
        {
            int ai[] = new int[1];
            int ai1[] = new int[1];
            a(i, j, k, l, ai, ai1);
            int j2 = ai[0];
            byte abyte2[] = new byte[j2];
            bitarray.toBytes(k1 * 8, abyte2, 0, j2);
            byte abyte3[] = a(abyte2, ai1[0]);
            arraylist.add(new a(abyte2, abyte3));
            int k2 = Math.max(j1, j2);
            int l2 = Math.max(i1, abyte3.length);
            i3 = k1 + ai[0];
            l++;
            i1 = l2;
            j1 = k2;
        }

        if (j != k1)
        {
            throw new WriterException("Data bytes does not match offset");
        }
label0:
        for (int l1 = 0; l1 < j1; l1++)
        {
            Iterator iterator1 = arraylist.iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    continue label0;
                }
                byte abyte1[] = ((a)iterator1.next()).a();
                if (l1 < abyte1.length)
                {
                    bitarray1.appendBits(abyte1[l1], 8);
                }
            } while (true);
        }

label1:
        for (int i2 = 0; i2 < i1; i2++)
        {
            Iterator iterator = arraylist.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    continue label1;
                }
                byte abyte0[] = ((a)iterator.next()).b();
                if (i2 < abyte0.length)
                {
                    bitarray1.appendBits(abyte0[i2], 8);
                }
            } while (true);
        }

        if (i != bitarray1.getSizeInBytes())
        {
            throw new WriterException((new StringBuilder()).append("Interleaving error: ").append(i).append(" and ").append(bitarray1.getSizeInBytes()).append(" differ.").toString());
        } else
        {
            return;
        }
    }

    private static void a(CharacterSetECI characterseteci, BitArray bitarray)
    {
        bitarray.appendBits(Mode.ECI.getBits(), 4);
        bitarray.appendBits(characterseteci.getValue(), 8);
    }

    static void a(Mode mode, BitArray bitarray)
    {
        bitarray.appendBits(mode.getBits(), 4);
    }

    static void a(CharSequence charsequence, BitArray bitarray)
    {
        int i = charsequence.length();
        for (int j = 0; j < i;)
        {
            int k = -48 + charsequence.charAt(j);
            if (j + 2 < i)
            {
                int l = -48 + charsequence.charAt(j + 1);
                bitarray.appendBits(-48 + charsequence.charAt(j + 2) + (k * 100 + l * 10), 10);
                j += 3;
            } else
            if (j + 1 < i)
            {
                bitarray.appendBits(-48 + charsequence.charAt(j + 1) + k * 10, 7);
                j += 2;
            } else
            {
                bitarray.appendBits(k, 4);
                j++;
            }
        }

    }

    static void a(String s, BitArray bitarray)
    {
        byte abyte0[];
        int i;
        int j;
        try
        {
            abyte0 = s.getBytes("Shift_JIS");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new WriterException(unsupportedencodingexception.toString());
        }
        i = abyte0.length;
        j = 0;
        while (j < i) 
        {
            int k = 0xff & abyte0[j];
            int l = 0xff & abyte0[j + 1] | k << 8;
            int i1;
            if (l >= 33088 && l <= 40956)
            {
                i1 = l - 33088;
            } else
            if (l >= 57408 && l <= 60351)
            {
                i1 = l - 49472;
            } else
            {
                i1 = -1;
            }
            if (i1 == -1)
            {
                throw new WriterException("Invalid byte sequence");
            }
            bitarray.appendBits(192 * (i1 >> 8) + (i1 & 0xff), 13);
            j += 2;
        }
    }

    static void a(String s, BitArray bitarray, String s1)
    {
        byte abyte0[];
        int i;
        try
        {
            abyte0 = s.getBytes(s1);
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new WriterException(unsupportedencodingexception.toString());
        }
        i = abyte0.length;
        for (int j = 0; j < i; j++)
        {
            bitarray.appendBits(abyte0[j], 8);
        }

    }

    static void a(String s, Mode mode, BitArray bitarray, String s1)
    {
        switch (b.a[mode.ordinal()])
        {
        default:
            throw new WriterException((new StringBuilder()).append("Invalid mode: ").append(mode).toString());

        case 1: // '\001'
            a(((CharSequence) (s)), bitarray);
            return;

        case 2: // '\002'
            b(s, bitarray);
            return;

        case 3: // '\003'
            a(s, bitarray, s1);
            return;

        case 4: // '\004'
            a(s, bitarray);
            break;
        }
    }

    private static boolean a(String s)
    {
        byte abyte0[];
        int i;
        int j;
        int k;
        try
        {
            abyte0 = s.getBytes("Shift_JIS");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            return false;
        }
        i = abyte0.length;
        if (i % 2 == 0) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        j = 0;
label0:
        do
        {
label1:
            {
                if (j >= i)
                {
                    break label1;
                }
                k = 0xff & abyte0[j];
                if ((k < 129 || k > 159) && (k < 224 || k > 235))
                {
                    break label0;
                }
                j += 2;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }

    static byte[] a(byte abyte0[], int i)
    {
        int j = 0;
        int k = abyte0.length;
        int ai[] = new int[k + i];
        for (int l = 0; l < k; l++)
        {
            ai[l] = 0xff & abyte0[l];
        }

        (new ReedSolomonEncoder(GenericGF.QR_CODE_FIELD_256)).encode(ai, i);
        byte abyte1[] = new byte[i];
        for (; j < i; j++)
        {
            abyte1[j] = (byte)ai[k + j];
        }

        return abyte1;
    }

    static void b(CharSequence charsequence, BitArray bitarray)
    {
        int i = charsequence.length();
        for (int j = 0; j < i;)
        {
            int k = a(charsequence.charAt(j));
            if (k == -1)
            {
                throw new WriterException();
            }
            if (j + 1 < i)
            {
                int l = a(charsequence.charAt(j + 1));
                if (l == -1)
                {
                    throw new WriterException();
                }
                bitarray.appendBits(l + k * 45, 11);
                j += 2;
            } else
            {
                bitarray.appendBits(k, 6);
                j++;
            }
        }

    }

    public static Mode chooseMode(String s)
    {
        return a(s, ((String) (null)));
    }

    public static void encode(String s, ErrorCorrectionLevel errorcorrectionlevel, QRCode qrcode)
    {
        encode(s, errorcorrectionlevel, null, qrcode);
    }

    public static void encode(String s, ErrorCorrectionLevel errorcorrectionlevel, Map map, QRCode qrcode)
    {
        String s1;
        Mode mode;
        BitArray bitarray;
        BitArray bitarray1;
        int i;
        BitArray bitarray2;
        ByteMatrix bytematrix;
        if (map == null)
        {
            s1 = null;
        } else
        {
            s1 = (String)map.get(EncodeHintType.CHARACTER_SET);
        }
        if (s1 == null)
        {
            s1 = "ISO-8859-1";
        }
        mode = a(s, s1);
        bitarray = new BitArray();
        a(s, mode, bitarray, s1);
        a(bitarray.getSize(), errorcorrectionlevel, mode, qrcode);
        bitarray1 = new BitArray();
        if (mode == Mode.BYTE && !"ISO-8859-1".equals(s1))
        {
            CharacterSetECI characterseteci = CharacterSetECI.getCharacterSetECIByName(s1);
            if (characterseteci != null)
            {
                a(characterseteci, bitarray1);
            }
        }
        a(mode, bitarray1);
        if (mode == Mode.BYTE)
        {
            i = bitarray.getSizeInBytes();
        } else
        {
            i = s.length();
        }
        a(i, qrcode.getVersion(), mode, bitarray1);
        bitarray1.appendBitArray(bitarray);
        a(qrcode.getNumDataBytes(), bitarray1);
        bitarray2 = new BitArray();
        a(bitarray1, qrcode.getNumTotalBytes(), qrcode.getNumDataBytes(), qrcode.getNumRSBlocks(), bitarray2);
        bytematrix = new ByteMatrix(qrcode.getMatrixWidth(), qrcode.getMatrixWidth());
        qrcode.setMaskPattern(a(bitarray2, errorcorrectionlevel, qrcode.getVersion(), bytematrix));
        d.a(bitarray2, errorcorrectionlevel, qrcode.getVersion(), qrcode.getMaskPattern(), bytematrix);
        qrcode.setMatrix(bytematrix);
        if (!qrcode.isValid())
        {
            throw new WriterException((new StringBuilder()).append("Invalid QR code: ").append(qrcode.toString()).toString());
        } else
        {
            return;
        }
    }

}
