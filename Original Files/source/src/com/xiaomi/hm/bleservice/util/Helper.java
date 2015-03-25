// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.bleservice.util;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

// Referenced classes of package com.xiaomi.hm.bleservice.util:
//            Debug

public final class Helper
{

    public static final UUID UUID_DESCRIPTOR_CHARACTERISTIC_USER_CONFIGURATION = UUID16("2901");
    public static final UUID UUID_DESCRIPTOR_CLIENT_CHARACTERISTIC_CONFIGURATION = UUID16("2902");
    private static final String a = "0000%4s-0000-1000-8000-00805f9b34fb";
    private static final String b = String.format("0000%4s-0000-1000-8000-00805f9b34fb", new Object[] {
        "...."
    });
    private static final int c[] = {
        0, 49345, 49537, 320, 49921, 960, 640, 49729, 50689, 1728, 
        1920, 51009, 1280, 50625, 50305, 1088, 52225, 3264, 3456, 52545, 
        3840, 53185, 52865, 3648, 2560, 51905, 52097, 2880, 51457, 2496, 
        2176, 51265, 55297, 6336, 6528, 55617, 6912, 56257, 55937, 6720, 
        7680, 57025, 57217, 8000, 56577, 7616, 7296, 56385, 5120, 54465, 
        54657, 5440, 55041, 6080, 5760, 54849, 53761, 4800, 4992, 54081, 
        4352, 53697, 53377, 4160, 61441, 12480, 12672, 61761, 13056, 62401, 
        62081, 12864, 13824, 63169, 63361, 14144, 62721, 13760, 13440, 62529, 
        15360, 64705, 64897, 15680, 65281, 16320, 16000, 65089, 64001, 15040, 
        15232, 64321, 14592, 63937, 63617, 14400, 10240, 59585, 59777, 10560, 
        60161, 11200, 10880, 59969, 60929, 11968, 12160, 61249, 11520, 60865, 
        60545, 11328, 58369, 9408, 9600, 58689, 9984, 59329, 59009, 9792, 
        8704, 58049, 58241, 9024, 57601, 8640, 8320, 57409, 40961, 24768, 
        24960, 41281, 25344, 41921, 41601, 25152, 26112, 42689, 42881, 26432, 
        42241, 26048, 25728, 42049, 27648, 44225, 44417, 27968, 44801, 28608, 
        28288, 44609, 43521, 27328, 27520, 43841, 26880, 43457, 43137, 26688, 
        30720, 47297, 47489, 31040, 47873, 31680, 31360, 47681, 48641, 32448, 
        32640, 48961, 32000, 48577, 48257, 31808, 46081, 29888, 30080, 46401, 
        30464, 47041, 46721, 30272, 29184, 45761, 45953, 29504, 45313, 29120, 
        28800, 45121, 20480, 37057, 37249, 20800, 37633, 21440, 21120, 37441, 
        38401, 22208, 22400, 38721, 21760, 38337, 38017, 21568, 39937, 23744, 
        23936, 40257, 24320, 40897, 40577, 24128, 23040, 39617, 39809, 23360, 
        39169, 22976, 22656, 38977, 34817, 18624, 18816, 35137, 19200, 35777, 
        35457, 19008, 19968, 36545, 36737, 20288, 36097, 19904, 19584, 35905, 
        17408, 33985, 34177, 17728, 34561, 18368, 18048, 34369, 33281, 17088, 
        17280, 33601, 16640, 33217, 32897, 16448
    };
    private static final byte d = 1;
    private static final byte e = 2;
    private static final byte f = 3;
    private static final byte g = 6;
    private static final byte h = 7;
    private static final byte i = 8;
    private static final byte j = 9;
    private static final byte k = 10;
    private static final byte l = 20;
    private static final byte m = 21;
    private static final byte n = -1;

    public Helper()
    {
    }

    public static byte[] AESDecrypt(byte abyte0[], byte abyte1[])
    {
        byte abyte2[];
        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
        cipher.init(2, new SecretKeySpec(abyte0, "AES"));
        abyte2 = cipher.doFinal(abyte1);
        return abyte2;
        NoSuchAlgorithmException nosuchalgorithmexception;
        nosuchalgorithmexception;
        nosuchalgorithmexception.printStackTrace();
_L2:
        return null;
        NoSuchPaddingException nosuchpaddingexception;
        nosuchpaddingexception;
        nosuchpaddingexception.printStackTrace();
        continue; /* Loop/switch isn't completed */
        InvalidKeyException invalidkeyexception;
        invalidkeyexception;
        invalidkeyexception.printStackTrace();
        continue; /* Loop/switch isn't completed */
        IllegalBlockSizeException illegalblocksizeexception;
        illegalblocksizeexception;
        illegalblocksizeexception.printStackTrace();
        continue; /* Loop/switch isn't completed */
        BadPaddingException badpaddingexception;
        badpaddingexception;
        badpaddingexception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static byte[] AESEncrypt(byte abyte0[], byte abyte1[])
    {
        byte abyte2[];
        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
        cipher.init(1, new SecretKeySpec(abyte0, "AES"));
        abyte2 = cipher.doFinal(abyte1);
        return abyte2;
        NoSuchAlgorithmException nosuchalgorithmexception;
        nosuchalgorithmexception;
        nosuchalgorithmexception.printStackTrace();
_L2:
        return null;
        NoSuchPaddingException nosuchpaddingexception;
        nosuchpaddingexception;
        nosuchpaddingexception.printStackTrace();
        continue; /* Loop/switch isn't completed */
        InvalidKeyException invalidkeyexception;
        invalidkeyexception;
        invalidkeyexception.printStackTrace();
        continue; /* Loop/switch isn't completed */
        IllegalBlockSizeException illegalblocksizeexception;
        illegalblocksizeexception;
        illegalblocksizeexception.printStackTrace();
        continue; /* Loop/switch isn't completed */
        BadPaddingException badpaddingexception;
        badpaddingexception;
        badpaddingexception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static int CRC16(byte abyte0[])
    {
        int i1 = 0;
        int j1 = 65535;
        for (; i1 < abyte0.length; i1++)
        {
            int k1 = 0xffff & (j1 >>> 8 | j1 << 8) ^ 0xff & abyte0[i1];
            int l1 = k1 ^ (k1 & 0xff) >> 4;
            int i2 = l1 ^ 0xffff & l1 << 12;
            j1 = i2 ^ 0xffff & (i2 & 0xff) << 5;
        }

        return j1 & 0xffff;
    }

    public static int CRC8(byte abyte0[])
    {
        int i1 = 0;
        int j1 = 0;
        for (; i1 < abyte0.length; i1++)
        {
            j1 ^= 0xff & abyte0[i1];
            int k1 = 0;
            while (k1 < 8) 
            {
                if ((j1 & 1) != 0)
                {
                    j1 = 0x8c ^ 0xff & j1 >> 1;
                } else
                {
                    j1 = 0xff & j1 >> 1;
                }
                k1++;
            }
        }

        return j1;
    }

    public static UUID UUID(byte abyte0[])
    {
        StringBuilder stringbuilder;
        switch (abyte0.length)
        {
        default:
            return null;

        case 2: // '\002'
            Object aobj4[] = new Object[2];
            aobj4[0] = Byte.valueOf(abyte0[0]);
            aobj4[1] = Byte.valueOf(abyte0[1]);
            return UUID16(String.format("%02x%02x", aobj4));

        case 16: // '\020'
            stringbuilder = new StringBuilder(128);
            break;
        }
        Object aobj[] = new Object[4];
        aobj[0] = Byte.valueOf(abyte0[0]);
        aobj[1] = Byte.valueOf(abyte0[1]);
        aobj[2] = Byte.valueOf(abyte0[2]);
        aobj[3] = Byte.valueOf(abyte0[3]);
        stringbuilder.append(String.format("%02x%02x%02x%02x", aobj));
        Object aobj1[] = new Object[4];
        aobj1[0] = Byte.valueOf(abyte0[4]);
        aobj1[1] = Byte.valueOf(abyte0[5]);
        aobj1[2] = Byte.valueOf(abyte0[6]);
        aobj1[3] = Byte.valueOf(abyte0[7]);
        stringbuilder.append(String.format("-%02x%02x-%02x%02x", aobj1));
        Object aobj2[] = new Object[4];
        aobj2[0] = Byte.valueOf(abyte0[8]);
        aobj2[1] = Byte.valueOf(abyte0[9]);
        aobj2[2] = Byte.valueOf(abyte0[10]);
        aobj2[3] = Byte.valueOf(abyte0[11]);
        stringbuilder.append(String.format("-%02x%02x-%02x%02x", aobj2));
        Object aobj3[] = new Object[4];
        aobj3[0] = Byte.valueOf(abyte0[12]);
        aobj3[1] = Byte.valueOf(abyte0[13]);
        aobj3[2] = Byte.valueOf(abyte0[14]);
        aobj3[3] = Byte.valueOf(abyte0[15]);
        stringbuilder.append(String.format("%02x%02x%02x%02x", aobj3));
        return UUID128(stringbuilder.toString());
    }

    public static UUID UUID128(String s)
    {
        return java.util.UUID.fromString(s);
    }

    public static UUID UUID16(String s)
    {
        return java.util.UUID.fromString(String.format("0000%4s-0000-1000-8000-00805f9b34fb", new Object[] {
            s
        }));
    }

    private static int a(byte abyte0[])
    {
        int i1 = 0;
        int j1 = abyte0.length;
        int k1 = 0;
        for (; i1 < j1; i1++)
        {
            byte byte0 = abyte0[i1];
            k1 = k1 >>> 8 ^ c[0xff & (k1 ^ byte0)];
        }

        return k1;
    }

    public static String bytesToHexString(byte abyte0[])
    {
        Debug.ASSERT_NOT_NULL(abyte0);
        if (abyte0 == null || abyte0.length == 0)
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        int i1 = abyte0.length;
        for (int j1 = 0; j1 < i1; j1++)
        {
            byte byte0 = abyte0[j1];
            Object aobj[] = new Object[1];
            aobj[0] = Byte.valueOf(byte0);
            stringbuilder.append(String.format("%02x ", aobj));
        }

        return stringbuilder.substring(0, -1 + stringbuilder.length());
    }

    public static int bytesToInt(byte abyte0[], int i1)
    {
        return bytesToInt(abyte0, i1, 4);
    }

    public static int bytesToInt(byte abyte0[], int i1, int j1)
    {
        boolean flag = true;
        int k1 = 0;
        boolean flag1;
        int l1;
        if (i1 + j1 <= abyte0.length)
        {
            flag1 = flag;
        } else
        {
            flag1 = false;
        }
        Debug.ASSERT_TRUE(flag1);
        if (j1 > 4)
        {
            flag = false;
        }
        Debug.ASSERT_TRUE(flag);
        l1 = 0;
        for (; k1 < j1; k1++)
        {
            l1 |= (0xff & abyte0[i1 + k1]) << k1 * 8;
        }

        return l1;
    }

    public static boolean isDeviceValid(byte abyte0[], UUID auuid[])
    {
        boolean flag;
        int i1;
        int j1;
        byte byte0;
        flag = true;
        boolean flag1;
        if (abyte0.length == 62)
        {
            flag1 = flag;
        } else
        {
            flag1 = false;
        }
        Debug.ASSERT_TRUE(flag1);
        i1 = 0;
_L11:
        j1 = i1 + 1;
        byte0 = abyte0[i1];
        if (byte0 != 0) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        return flag;
_L2:
        byte byte1;
        int k1;
        i1 = j1 + 1;
        byte1 = abyte0[j1];
        if (byte1 != 3 && byte1 != 2)
        {
            break MISSING_BLOCK_LABEL_195;
        }
        k1 = 0;
_L6:
        int i2;
        String s;
        int j2;
        int k2;
        if (k1 >= byte0 - 1)
        {
            continue; /* Loop/switch isn't completed */
        }
        byte abyte1[] = new byte[2];
        int l1 = i1 + 1;
        abyte1[0] = abyte0[i1];
        i2 = l1 + 1;
        abyte1[flag] = abyte0[l1];
        Object aobj[] = new Object[2];
        aobj[0] = Byte.valueOf(abyte1[flag]);
        aobj[flag] = Byte.valueOf(abyte1[0]);
        s = String.format("%02x%02x", aobj);
        j2 = auuid.length;
        k2 = 0;
_L5:
        if (k2 >= j2)
        {
            break MISSING_BLOCK_LABEL_185;
        }
        if (parseUUID(auuid[k2]).equals(s)) goto _L4; else goto _L3
_L3:
        k2++;
          goto _L5
        k1 += 2;
        i1 = i2;
          goto _L6
        int l2;
        if (byte1 != 7 && byte1 != 6)
        {
            break MISSING_BLOCK_LABEL_560;
        }
        l2 = 0;
_L9:
        int i3;
        String s1;
        int k3;
        int l3;
        if (l2 >= byte0 - 1)
        {
            continue; /* Loop/switch isn't completed */
        }
        byte abyte2[] = new byte[16];
        i3 = i1;
        for (int j3 = 0; j3 < 16;)
        {
            int i4 = i3 + 1;
            abyte2[j3] = abyte0[i3];
            j3++;
            i3 = i4;
        }

        Object aobj1[] = new Object[16];
        aobj1[0] = Byte.valueOf(abyte2[15]);
        aobj1[flag] = Byte.valueOf(abyte2[14]);
        aobj1[2] = Byte.valueOf(abyte2[13]);
        aobj1[3] = Byte.valueOf(abyte2[12]);
        aobj1[4] = Byte.valueOf(abyte2[11]);
        aobj1[5] = Byte.valueOf(abyte2[10]);
        aobj1[6] = Byte.valueOf(abyte2[9]);
        aobj1[7] = Byte.valueOf(abyte2[8]);
        aobj1[8] = Byte.valueOf(abyte2[7]);
        aobj1[9] = Byte.valueOf(abyte2[6]);
        aobj1[10] = Byte.valueOf(abyte2[5]);
        aobj1[11] = Byte.valueOf(abyte2[4]);
        aobj1[12] = Byte.valueOf(abyte2[3]);
        aobj1[13] = Byte.valueOf(abyte2[2]);
        aobj1[14] = Byte.valueOf(abyte2[flag]);
        aobj1[15] = Byte.valueOf(abyte2[0]);
        s1 = String.format("%02x%02x%02x%02x-%02x%02x-%02x%02x-%02x%02x-%02x%02x%02x%02x%02x%02x", aobj1);
        k3 = auuid.length;
        l3 = 0;
_L8:
        UUID uuid;
        if (l3 >= k3)
        {
            break MISSING_BLOCK_LABEL_550;
        }
        uuid = auuid[l3];
        Debug.DEBUG((new StringBuilder()).append(uuid.toString()).append("==").append(s1).toString());
        if (parseUUID(uuid).equals(s1)) goto _L4; else goto _L7
_L7:
        l3++;
          goto _L8
          goto _L4
        l2 += 16;
        i1 = i3;
          goto _L9
        i1 += byte0 - 1;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public static void parseAdvData(byte abyte0[])
    {
        boolean flag;
        int i1;
        if (abyte0.length == 62)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Debug.ASSERT_TRUE(flag);
        i1 = 0;
        do
        {
            int j1 = i1 + 1;
            byte byte0 = abyte0[i1];
            if (byte0 == 0)
            {
                return;
            }
            int k1 = j1 + 1;
            byte byte1 = abyte0[j1];
            byte abyte11[];
            switch (byte1)
            {
            case 0: // '\0'
            case 4: // '\004'
            case 5: // '\005'
            case 11: // '\013'
            case 12: // '\f'
            case 13: // '\r'
            case 14: // '\016'
            case 15: // '\017'
            case 16: // '\020'
            case 17: // '\021'
            case 18: // '\022'
            case 19: // '\023'
            default:
                abyte11 = new byte[byte0 - 1];
                i1 = k1;
                for (int l9 = 0; l9 < byte0 - 1;)
                {
                    int i10 = i1 + 1;
                    abyte11[l9] = abyte0[i1];
                    l9++;
                    i1 = i10;
                }

                break;

            case 1: // '\001'
                boolean flag1;
                byte byte2;
                StringBuilder stringbuilder6;
                Object aobj[];
                if (byte0 == 2)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                Debug.ASSERT_TRUE(flag1);
                i1 = k1 + 1;
                byte2 = abyte0[k1];
                stringbuilder6 = (new StringBuilder()).append("        flag: ");
                aobj = new Object[1];
                aobj[0] = Byte.valueOf(byte2);
                Debug.DEBUG(stringbuilder6.append(String.format("%02x", aobj)).toString());
                continue;

            case 3: // '\003'
                StringBuilder stringbuilder5 = new StringBuilder();
                int l8 = 0;
                int i9;
                for (i1 = k1; l8 < byte0 - 1; i1 = i9)
                {
                    byte abyte10[] = new byte[2];
                    i9 = i1;
                    for (int j9 = 0; j9 < 2;)
                    {
                        int k9 = i9 + 1;
                        abyte10[j9] = abyte0[i9];
                        j9++;
                        i9 = k9;
                    }

                    stringbuilder5.append(bytesToHexString(abyte10));
                    stringbuilder5.append("; ");
                    l8 += 2;
                }

                Debug.DEBUG((new StringBuilder()).append("      serv16: ").append(stringbuilder5.toString()).toString());
                continue;

            case 2: // '\002'
                StringBuilder stringbuilder4 = new StringBuilder();
                int l7 = 0;
                int i8;
                for (i1 = k1; l7 < byte0 - 1; i1 = i8)
                {
                    byte abyte9[] = new byte[2];
                    i8 = i1;
                    for (int j8 = 0; j8 < 2;)
                    {
                        int k8 = i8 + 1;
                        abyte9[j8] = abyte0[i8];
                        j8++;
                        i8 = k8;
                    }

                    stringbuilder4.append(bytesToHexString(abyte9));
                    stringbuilder4.append("; ");
                    l7 += 2;
                }

                Debug.DEBUG((new StringBuilder()).append("   (*)serv16: ").append(stringbuilder4.toString()).toString());
                continue;

            case 7: // '\007'
                StringBuilder stringbuilder3 = new StringBuilder();
                int l6 = 0;
                int i7;
                for (i1 = k1; l6 < byte0 - 1; i1 = i7)
                {
                    byte abyte8[] = new byte[16];
                    i7 = i1;
                    for (int j7 = 0; j7 < 16;)
                    {
                        int k7 = i7 + 1;
                        abyte8[j7] = abyte0[i7];
                        j7++;
                        i7 = k7;
                    }

                    stringbuilder3.append(bytesToHexString(abyte8));
                    stringbuilder3.append("; ");
                    l6 += 16;
                }

                Debug.DEBUG((new StringBuilder()).append("     serv128: ").append(stringbuilder3.toString()).toString());
                continue;

            case 6: // '\006'
                StringBuilder stringbuilder2 = new StringBuilder();
                int l5 = 0;
                int i6;
                for (i1 = k1; l5 < byte0 - 1; i1 = i6)
                {
                    byte abyte7[] = new byte[16];
                    i6 = i1;
                    for (int j6 = 0; j6 < 16;)
                    {
                        int k6 = i6 + 1;
                        abyte7[j6] = abyte0[i6];
                        j6++;
                        i6 = k6;
                    }

                    stringbuilder2.append(bytesToHexString(abyte7));
                    stringbuilder2.append("; ");
                    l5 += 16;
                }

                Debug.DEBUG((new StringBuilder()).append("  (*)serv128: ").append(stringbuilder2.toString()).toString());
                continue;

            case 20: // '\024'
                StringBuilder stringbuilder1 = new StringBuilder();
                int l4 = 0;
                int i5;
                for (i1 = k1; l4 < byte0 - 1; i1 = i5)
                {
                    byte abyte6[] = new byte[2];
                    i5 = i1;
                    for (int j5 = 0; j5 < 2;)
                    {
                        int k5 = i5 + 1;
                        abyte6[j5] = abyte0[i5];
                        j5++;
                        i5 = k5;
                    }

                    stringbuilder1.append(bytesToHexString(abyte6));
                    stringbuilder1.append("; ");
                    l4 += 2;
                }

                Debug.DEBUG((new StringBuilder()).append("   solicit16: ").append(stringbuilder1.toString()).toString());
                continue;

            case 21: // '\025'
                StringBuilder stringbuilder = new StringBuilder();
                int l3 = 0;
                int i4;
                for (i1 = k1; l3 < byte0 - 1; i1 = i4)
                {
                    byte abyte5[] = new byte[16];
                    i4 = i1;
                    for (int j4 = 0; j4 < 16;)
                    {
                        int k4 = i4 + 1;
                        abyte5[j4] = abyte0[i4];
                        j4++;
                        i4 = k4;
                    }

                    stringbuilder.append(bytesToHexString(abyte5));
                    stringbuilder.append("; ");
                    l3 += 16;
                }

                Debug.DEBUG((new StringBuilder()).append("  solicit128: ").append(stringbuilder.toString()).toString());
                continue;

            case 9: // '\t'
                byte abyte4[] = new byte[byte0 - 1];
                i1 = k1;
                for (int j3 = 0; j3 < byte0 - 1;)
                {
                    int k3 = i1 + 1;
                    abyte4[j3] = abyte0[i1];
                    j3++;
                    i1 = k3;
                }

                String s3 = new String(abyte4);
                Debug.DEBUG((new StringBuilder()).append("        name: ").append(s3).toString());
                continue;

            case 8: // '\b'
                byte abyte3[] = new byte[byte0 - 1];
                i1 = k1;
                for (int l2 = 0; l2 < byte0 - 1;)
                {
                    int i3 = i1 + 1;
                    abyte3[l2] = abyte0[i1];
                    l2++;
                    i1 = i3;
                }

                String s2 = new String(abyte3);
                Debug.DEBUG((new StringBuilder()).append("     (*)name: ").append(s2).toString());
                continue;

            case 10: // '\n'
                byte abyte2[] = new byte[byte0 - 1];
                i1 = k1;
                for (int j2 = 0; j2 < byte0 - 1;)
                {
                    int k2 = i1 + 1;
                    abyte2[j2] = abyte0[i1];
                    j2++;
                    i1 = k2;
                }

                String s1 = bytesToHexString(abyte2);
                Debug.DEBUG((new StringBuilder()).append("    tx level: ").append(s1).toString());
                continue;

            case -1: 
                byte abyte1[] = new byte[byte0 - 1];
                i1 = k1;
                for (int l1 = 0; l1 < byte0 - 1;)
                {
                    int i2 = i1 + 1;
                    abyte1[l1] = abyte0[i1];
                    l1++;
                    i1 = i2;
                }

                String s = bytesToHexString(abyte1);
                Debug.DEBUG((new StringBuilder()).append("    manufact: ").append(s).toString());
                continue;
            }
            StringBuilder stringbuilder7 = (new StringBuilder()).append("      ");
            Object aobj1[] = new Object[1];
            aobj1[0] = Byte.valueOf(byte1);
            Debug.DEBUG(stringbuilder7.append(String.format("[0x%02x]", aobj1)).append(": ").append(bytesToHexString(abyte11)).toString());
        } while (true);
    }

    public static String parsePermissions(int i1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if ((i1 & 1) > 0)
        {
            stringbuilder.append("READ ");
        }
        if ((i1 & 2) > 0)
        {
            stringbuilder.append("READ_ENCRYPTED ");
        }
        if ((i1 & 4) > 0)
        {
            stringbuilder.append("READ_ENCRYPTED_MITM ");
        }
        if ((i1 & 0x10) > 0)
        {
            stringbuilder.append("WRITE ");
        }
        if ((i1 & 0x20) > 0)
        {
            stringbuilder.append("WRITE_ENCRYPTED ");
        }
        if ((i1 & 0x40) > 0)
        {
            stringbuilder.append("WRITE_ENCRYPTED_MITM ");
        }
        if ((i1 & 0x80) > 0)
        {
            stringbuilder.append("WRITE_SIGNED ");
        }
        if ((i1 & 0x100) > 0)
        {
            stringbuilder.append("WRITE_SIGNED_MITM ");
        }
        return stringbuilder.toString();
    }

    public static String parseProperties(int i1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if ((i1 & 1) > 0)
        {
            stringbuilder.append("BROADCAST ");
        }
        if ((i1 & 0x80) > 0)
        {
            stringbuilder.append("EXTENDED_PROPS ");
        }
        if ((i1 & 0x20) > 0)
        {
            stringbuilder.append("INDICATE ");
        }
        if ((i1 & 0x10) > 0)
        {
            stringbuilder.append("NOTIFY ");
        }
        if ((i1 & 2) > 0)
        {
            stringbuilder.append("READ ");
        }
        if ((i1 & 0x40) > 0)
        {
            stringbuilder.append("SIGNED_WRITE ");
        }
        if ((i1 & 8) > 0)
        {
            stringbuilder.append("WRITE ");
        }
        if ((i1 & 4) > 0)
        {
            stringbuilder.append("WRITE_NO_RESPONSE ");
        }
        return stringbuilder.toString();
    }

    public static String parseUUID(UUID uuid)
    {
        String s = uuid.toString();
        if (s.matches(b))
        {
            s = s.substring(4, 8);
        }
        return s;
    }

}
