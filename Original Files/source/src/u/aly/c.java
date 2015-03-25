// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import android.content.Context;
import android.content.SharedPreferences;
import java.security.MessageDigest;
import java.util.Locale;

// Referenced classes of package u.aly:
//            bu, bi, u, bh, 
//            ci

public class c
{

    private final byte a[] = new byte[8];
    private String b;
    private String c;
    private byte d[];
    private byte e[];
    private byte f[];
    private int g;
    private int h;
    private int i;
    private byte j[];
    private byte k[];

    private c(byte abyte0[], String s, byte abyte1[])
    {
        b = "1.0";
        c = null;
        d = null;
        e = null;
        f = null;
        g = 0;
        h = 0;
        i = 0;
        j = null;
        k = null;
        if (abyte0 == null || abyte0.length == 0)
        {
            throw new Exception("entity is null or empty");
        } else
        {
            c = s;
            i = abyte0.length;
            j = bu.a(abyte0);
            h = (int)(System.currentTimeMillis() / 1000L);
            k = abyte1;
            return;
        }
    }

    public static c a(Context context, String s, byte abyte0[])
    {
        c c1;
        try
        {
            String s1 = bi.p(context);
            String s2 = bi.f(context);
            SharedPreferences sharedpreferences = u.a(context);
            String s3 = sharedpreferences.getString("signature", null);
            int l = sharedpreferences.getInt("serial", 1);
            c1 = new c(abyte0, s, (new StringBuilder(String.valueOf(s2))).append(s1).toString().getBytes());
            c1.a(s3);
            c1.a(l);
            c1.b();
            sharedpreferences.edit().putInt("serial", l + 1).putString("signature", c1.a()).commit();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        return c1;
    }

    public static byte[] a(byte abyte0[])
    {
        byte abyte1[];
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.reset();
            messagedigest.update(abyte0);
            abyte1 = messagedigest.digest();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        return abyte1;
    }

    private byte[] a(byte abyte0[], int l)
    {
        int i1;
        byte abyte1[];
        byte abyte2[];
        int j1;
        byte abyte3[];
        int k1;
        i1 = 0;
        abyte1 = a(k);
        abyte2 = a(j);
        j1 = abyte1.length;
        abyte3 = new byte[j1 * 2];
        k1 = 0;
_L5:
        if (k1 < j1) goto _L2; else goto _L1
_L1:
        int l1 = 0;
_L6:
        if (l1 < 2) goto _L4; else goto _L3
_L3:
        byte abyte4[];
        abyte4 = new byte[4];
        abyte4[0] = (byte)(l & 0xff);
        abyte4[1] = (byte)(0xff & l >> 8);
        abyte4[2] = (byte)(0xff & l >> 16);
        abyte4[3] = (byte)(l >>> 24);
_L7:
        if (i1 >= abyte3.length)
        {
            return abyte3;
        }
        break MISSING_BLOCK_LABEL_179;
_L2:
        abyte3[k1 * 2] = abyte2[k1];
        abyte3[1 + k1 * 2] = abyte1[k1];
        k1++;
          goto _L5
_L4:
        abyte3[l1] = abyte0[l1];
        abyte3[-1 + (abyte3.length - l1)] = abyte0[-1 + (abyte0.length - l1)];
        l1++;
          goto _L6
        abyte3[i1] = (byte)(abyte3[i1] ^ abyte4[i1 % 4]);
        i1++;
          goto _L7
    }

    public static String b(byte abyte0[])
    {
        StringBuffer stringbuffer = new StringBuffer();
        int l = 0;
        do
        {
            if (l >= abyte0.length)
            {
                return stringbuffer.toString().toLowerCase(Locale.US);
            }
            Object aobj[] = new Object[1];
            aobj[0] = Byte.valueOf(abyte0[l]);
            stringbuffer.append(String.format("%02X", aobj));
            l++;
        } while (true);
    }

    public static byte[] b(String s)
    {
        byte abyte0[] = null;
        if (s != null) goto _L2; else goto _L1
_L1:
        return abyte0;
_L2:
        int l = s.length();
        int i1 = l % 2;
        abyte0 = null;
        if (i1 == 0)
        {
            abyte0 = new byte[l / 2];
            int j1 = 0;
            while (j1 < l) 
            {
                abyte0[j1 / 2] = (byte)Integer.valueOf(s.substring(j1, j1 + 2), 16).intValue();
                j1 += 2;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    private byte[] d()
    {
        return a(a, (int)(System.currentTimeMillis() / 1000L));
    }

    private byte[] e()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(b(d));
        stringbuilder.append(g);
        stringbuilder.append(h);
        stringbuilder.append(i);
        stringbuilder.append(b(e));
        return a(stringbuilder.toString().getBytes());
    }

    public String a()
    {
        return b(d);
    }

    public void a(int l)
    {
        g = l;
    }

    public void a(String s)
    {
        d = b(s);
    }

    public void b()
    {
        if (d == null)
        {
            d = d();
        }
        e = a(d, h);
        f = e();
    }

    public byte[] c()
    {
        bh bh1 = new bh();
        bh1.a(b);
        bh1.b(c);
        bh1.c(b(d));
        bh1.a(g);
        bh1.c(h);
        bh1.d(i);
        bh1.a(j);
        bh1.d(b(e));
        bh1.e(b(f));
        byte abyte0[];
        try
        {
            abyte0 = (new ci()).a(bh1);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        return abyte0;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        Object aobj[] = new Object[1];
        aobj[0] = b;
        stringbuilder.append(String.format("version : %s\n", aobj));
        Object aobj1[] = new Object[1];
        aobj1[0] = c;
        stringbuilder.append(String.format("address : %s\n", aobj1));
        Object aobj2[] = new Object[1];
        aobj2[0] = b(d);
        stringbuilder.append(String.format("signature : %s\n", aobj2));
        Object aobj3[] = new Object[1];
        aobj3[0] = Integer.valueOf(g);
        stringbuilder.append(String.format("serial : %s\n", aobj3));
        Object aobj4[] = new Object[1];
        aobj4[0] = Integer.valueOf(h);
        stringbuilder.append(String.format("timestamp : %d\n", aobj4));
        Object aobj5[] = new Object[1];
        aobj5[0] = Integer.valueOf(i);
        stringbuilder.append(String.format("length : %d\n", aobj5));
        Object aobj6[] = new Object[1];
        aobj6[0] = b(e);
        stringbuilder.append(String.format("guid : %s\n", aobj6));
        Object aobj7[] = new Object[1];
        aobj7[0] = b(f);
        stringbuilder.append(String.format("checksum : %s ", aobj7));
        return stringbuilder.toString();
    }
}
