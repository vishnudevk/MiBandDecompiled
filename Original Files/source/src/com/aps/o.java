// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aps;

import android.text.TextUtils;
import java.util.zip.CRC32;

// Referenced classes of package com.aps:
//            q, t

public class o
{

    public byte A[];
    public String a;
    public short b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public String y;
    public String z;

    public o()
    {
        a = "1";
        b = 0;
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        l = null;
        m = null;
        n = null;
        o = null;
        p = null;
        q = null;
        r = null;
        s = null;
        t = null;
        u = null;
        v = null;
        w = null;
        x = null;
        y = null;
        z = null;
        A = null;
    }

    private String a(String s1, int i1)
    {
        String as[] = x.split("\\*")[i1].split(",");
        if (s1.equals("lac"))
        {
            return as[0];
        }
        if (s1.equals("cellid"))
        {
            return as[1];
        }
        if (s1.equals("signal"))
        {
            return as[2];
        } else
        {
            return null;
        }
    }

    private byte[] a(String s1)
    {
        String as[] = s1.split(":");
        if (as == null || as.length != 6)
        {
            String as1[] = new String[6];
            for (int i1 = 0; i1 < as1.length; i1++)
            {
                as1[i1] = "0";
            }

            as = as1;
        }
        byte abyte0[] = new byte[6];
        for (int j1 = 0; j1 < as.length; j1++)
        {
            if (as[j1].length() > 2)
            {
                as[j1] = as[j1].substring(0, 2);
            }
            abyte0[j1] = (byte)Integer.parseInt(as[j1], 16);
        }

        return abyte0;
    }

    private String b(String s1)
    {
        if (!w.contains((new StringBuilder()).append(s1).append(">").toString()))
        {
            return "0";
        } else
        {
            int i1 = w.indexOf((new StringBuilder()).append(s1).append(">").toString());
            int j1 = w.indexOf((new StringBuilder()).append("</").append(s1).toString());
            return w.substring(1 + (i1 + s1.length()), j1);
        }
    }

    private void b()
    {
        if (a == null)
        {
            a = "";
        }
        if (c == null)
        {
            c = "";
        }
        if (d == null)
        {
            d = "";
        }
        if (e == null)
        {
            e = "";
        }
        if (f == null)
        {
            f = "";
        }
        if (g == null)
        {
            g = "";
        }
        if (h == null)
        {
            h = "";
        }
        if (i == null)
        {
            i = "";
        }
        if (j == null)
        {
            j = "0";
        } else
        if (!j.equals("1") && !j.equals("2"))
        {
            j = "0";
        }
        if (k == null)
        {
            k = "0";
        } else
        if (!k.equals("0") && !k.equals("1"))
        {
            k = "0";
        }
        if (l == null)
        {
            l = "";
        } else
        {
            l = String.valueOf(Double.valueOf(1200000D * Double.parseDouble(l)).intValue());
        }
        if (m == null)
        {
            m = "";
        } else
        {
            m = String.valueOf(Double.valueOf(1000000D * Double.parseDouble(m)).intValue());
        }
        if (n == null)
        {
            n = "";
        }
        if (o == null)
        {
            o = "";
        }
        if (p == null)
        {
            p = "";
        }
        if (q == null)
        {
            q = "";
        }
        if (r == null)
        {
            r = "";
        }
        if (s == null)
        {
            s = "";
        }
        if (t == null)
        {
            t = "";
        }
        if (u == null)
        {
            u = "0";
        } else
        if (!u.equals("1") && !u.equals("2"))
        {
            u = "0";
        }
        if (v == null)
        {
            v = "0";
        } else
        if (!v.equals("1") && !v.equals("2"))
        {
            v = "0";
        }
        if (w == null)
        {
            w = "";
        }
        if (x == null)
        {
            x = "";
        }
        if (y == null)
        {
            y = "";
        }
        if (z == null)
        {
            z = "";
        }
        if (A == null)
        {
            A = new byte[0];
        }
    }

    public byte[] a()
    {
        byte abyte0[];
        int j1;
        b();
        int i1 = 1024;
        if (A != null)
        {
            i1 += 1 + A.length;
        }
        abyte0 = new byte[i1];
        abyte0[0] = Byte.parseByte(a);
        byte abyte1[] = com.aps.q.b(b);
        System.arraycopy(abyte1, 0, abyte0, 1, abyte1.length);
        j1 = 1 + abyte1.length;
        byte abyte36[];
        abyte36 = c.getBytes("GBK");
        abyte0[j1] = (byte)abyte36.length;
        j1++;
        int k16;
        System.arraycopy(abyte36, 0, abyte0, j1, abyte36.length);
        k16 = abyte36.length;
        int k1 = j1 + k16;
_L5:
        byte abyte35[];
        abyte35 = d.getBytes("GBK");
        abyte0[k1] = (byte)abyte35.length;
        k1++;
        int j16;
        System.arraycopy(abyte35, 0, abyte0, k1, abyte35.length);
        j16 = abyte35.length;
        int l1 = k1 + j16;
_L6:
        byte abyte34[];
        abyte34 = o.getBytes("GBK");
        abyte0[l1] = (byte)abyte34.length;
        l1++;
        int i16;
        System.arraycopy(abyte34, 0, abyte0, l1, abyte34.length);
        i16 = abyte34.length;
        int i2 = l1 + i16;
_L7:
        byte abyte33[];
        abyte33 = e.getBytes("GBK");
        abyte0[i2] = (byte)abyte33.length;
        i2++;
        int l15;
        System.arraycopy(abyte33, 0, abyte0, i2, abyte33.length);
        l15 = abyte33.length;
        int j2 = i2 + l15;
_L8:
        byte abyte32[];
        abyte32 = f.getBytes("GBK");
        abyte0[j2] = (byte)abyte32.length;
        j2++;
        int k15;
        System.arraycopy(abyte32, 0, abyte0, j2, abyte32.length);
        k15 = abyte32.length;
        int k2 = j2 + k15;
_L9:
        byte abyte31[];
        abyte31 = g.getBytes("GBK");
        abyte0[k2] = (byte)abyte31.length;
        k2++;
        int j15;
        System.arraycopy(abyte31, 0, abyte0, k2, abyte31.length);
        j15 = abyte31.length;
        int l2 = k2 + j15;
_L10:
        byte abyte30[];
        abyte30 = s.getBytes("GBK");
        abyte0[l2] = (byte)abyte30.length;
        l2++;
        int i15;
        System.arraycopy(abyte30, 0, abyte0, l2, abyte30.length);
        i15 = abyte30.length;
        int i3 = l2 + i15;
_L11:
        byte abyte29[];
        abyte29 = h.getBytes("GBK");
        abyte0[i3] = (byte)abyte29.length;
        i3++;
        int l14;
        System.arraycopy(abyte29, 0, abyte0, i3, abyte29.length);
        l14 = abyte29.length;
        int j3 = i3 + l14;
_L12:
        byte abyte28[];
        abyte28 = p.getBytes("GBK");
        abyte0[j3] = (byte)abyte28.length;
        j3++;
        int k14;
        System.arraycopy(abyte28, 0, abyte0, j3, abyte28.length);
        k14 = abyte28.length;
        int k3 = j3 + k14;
_L13:
        byte abyte27[];
        abyte27 = q.getBytes("GBK");
        abyte0[k3] = (byte)abyte27.length;
        k3++;
        int j14;
        System.arraycopy(abyte27, 0, abyte0, k3, abyte27.length);
        j14 = abyte27.length;
        int l3 = j14 + k3;
_L14:
        int j4;
        int k4;
        int j5;
        int l7;
        String as[];
        int i8;
        byte abyte26[];
        int i14;
        if (TextUtils.isEmpty(r))
        {
            abyte0[l3] = 0;
            j4 = l3 + 1;
        } else
        {
            byte abyte2[] = a(r);
            abyte0[l3] = (byte)abyte2.length;
            int i4 = l3 + 1;
            System.arraycopy(abyte2, 0, abyte0, i4, abyte2.length);
            j4 = i4 + abyte2.length;
        }
        abyte26 = t.getBytes("GBK");
        abyte0[j4] = (byte)abyte26.length;
        j4++;
        System.arraycopy(abyte26, 0, abyte0, j4, abyte26.length);
        i14 = abyte26.length;
        k4 = i14 + j4;
_L15:
        abyte0[k4] = Byte.parseByte(u);
        int l4 = k4 + 1;
        abyte0[l4] = Byte.parseByte(j);
        int i5 = l4 + 1;
        if (j.equals("1") || j.equals("2"))
        {
            byte abyte3[] = com.aps.q.a(Integer.parseInt(l));
            System.arraycopy(abyte3, 0, abyte0, i5, abyte3.length);
            i5 += abyte3.length;
        }
        if (j.equals("1") || j.equals("2"))
        {
            byte abyte4[] = com.aps.q.a(Integer.parseInt(m));
            System.arraycopy(abyte4, 0, abyte0, i5, abyte4.length);
            i5 += abyte4.length;
        }
        if (j.equals("1") || j.equals("2"))
        {
            byte abyte5[] = com.aps.q.b(n);
            System.arraycopy(abyte5, 0, abyte0, i5, abyte5.length);
            i5 += abyte5.length;
        }
        abyte0[i5] = Byte.parseByte(v);
        j5 = i5 + 1;
        if (v.equals("1"))
        {
            byte abyte20[] = com.aps.q.b(b("mcc"));
            System.arraycopy(abyte20, 0, abyte0, j5, abyte20.length);
            int i11 = j5 + abyte20.length;
            byte abyte21[] = com.aps.q.b(b("mnc"));
            System.arraycopy(abyte21, 0, abyte0, i11, abyte21.length);
            int j11 = i11 + abyte21.length;
            byte abyte22[] = com.aps.q.b(b("lac"));
            System.arraycopy(abyte22, 0, abyte0, j11, abyte22.length);
            int k11 = j11 + abyte22.length;
            byte abyte23[] = com.aps.q.a(b("cellid"));
            System.arraycopy(abyte23, 0, abyte0, k11, abyte23.length);
            int l11 = k11 + abyte23.length;
            int i12 = Integer.parseInt(b("signal"));
            Throwable throwable;
            Throwable throwable1;
            Throwable throwable2;
            Throwable throwable3;
            Throwable throwable4;
            Throwable throwable5;
            Throwable throwable6;
            Throwable throwable7;
            Throwable throwable8;
            Throwable throwable9;
            Throwable throwable10;
            byte abyte12[];
            int k8;
            byte abyte13[];
            CRC32 crc32;
            byte abyte14[];
            byte abyte15[];
            int j12;
            if (i12 > 127)
            {
                i12 = 0;
            } else
            if (i12 < -128)
            {
                i12 = 0;
            }
            abyte0[l11] = (byte)i12;
            j12 = l11 + 1;
            if (x.length() == 0)
            {
                abyte0[j12] = 0;
                j5 = j12 + 1;
            } else
            {
                int k12 = x.split("\\*").length;
                abyte0[j12] = (byte)k12;
                j5 = j12 + 1;
                int l12 = 0;
                while (l12 < k12) 
                {
                    byte abyte24[] = com.aps.q.b(a("lac", l12));
                    System.arraycopy(abyte24, 0, abyte0, j5, abyte24.length);
                    int i13 = j5 + abyte24.length;
                    byte abyte25[] = com.aps.q.a(a("cellid", l12));
                    System.arraycopy(abyte25, 0, abyte0, i13, abyte25.length);
                    int j13 = i13 + abyte25.length;
                    int k13 = Integer.parseInt(a("signal", l12));
                    int l13;
                    if (k13 > 127)
                    {
                        k13 = 0;
                    } else
                    if (k13 < -128)
                    {
                        k13 = 0;
                    }
                    abyte0[j13] = (byte)k13;
                    l13 = j13 + 1;
                    l12++;
                    j5 = l13;
                }
            }
        } else
        if (v.equals("2"))
        {
            byte abyte6[] = com.aps.q.b(b("mcc"));
            System.arraycopy(abyte6, 0, abyte0, j5, abyte6.length);
            int k5 = j5 + abyte6.length;
            byte abyte7[] = com.aps.q.b(b("sid"));
            System.arraycopy(abyte7, 0, abyte0, k5, abyte7.length);
            int l5 = k5 + abyte7.length;
            byte abyte8[] = com.aps.q.b(b("nid"));
            System.arraycopy(abyte8, 0, abyte0, l5, abyte8.length);
            int i6 = l5 + abyte8.length;
            byte abyte9[] = com.aps.q.b(b("bid"));
            System.arraycopy(abyte9, 0, abyte0, i6, abyte9.length);
            int j6 = i6 + abyte9.length;
            byte abyte10[] = com.aps.q.a(b("lon"));
            System.arraycopy(abyte10, 0, abyte0, j6, abyte10.length);
            int k6 = j6 + abyte10.length;
            byte abyte11[] = com.aps.q.a(b("lat"));
            System.arraycopy(abyte11, 0, abyte0, k6, abyte11.length);
            int l6 = k6 + abyte11.length;
            int i7 = Integer.parseInt(b("signal"));
            int j7;
            if (i7 > 127)
            {
                i7 = 0;
            } else
            if (i7 < -128)
            {
                i7 = 0;
            }
            abyte0[l6] = (byte)i7;
            j7 = l6 + 1;
            abyte0[j7] = 0;
            j5 = j7 + 1;
        }
        if (z.length() != 0) goto _L2; else goto _L1
_L1:
        abyte0[j5] = 0;
        l7 = j5 + 1;
_L16:
        as = y.split("\\*");
        if (!TextUtils.isEmpty(y) && as.length != 0) goto _L4; else goto _L3
_L3:
        abyte0[l7] = 0;
        i8 = l7 + 1;
_L19:
        int k7;
        Throwable throwable11;
        int j8;
        int l8;
        String as1[];
        byte abyte16[];
        int i9;
        Throwable throwable12;
        int j9;
        int k9;
        int l9;
        byte abyte17[];
        int i10;
        String as2[];
        byte abyte18[];
        int j10;
        Throwable throwable13;
        int k10;
        byte abyte19[];
        int l10;
        if (A != null)
        {
            j8 = A.length;
        } else
        {
            j8 = 0;
        }
        abyte12 = com.aps.q.b(j8);
        System.arraycopy(abyte12, 0, abyte0, i8, abyte12.length);
        k8 = i8 + abyte12.length;
        if (j8 > 0)
        {
            System.arraycopy(A, 0, abyte0, k8, A.length);
            k8 += A.length;
        }
        abyte13 = new byte[k8];
        System.arraycopy(abyte0, 0, abyte13, 0, k8);
        crc32 = new CRC32();
        crc32.update(abyte13);
        abyte14 = com.aps.q.a(crc32.getValue());
        abyte15 = new byte[k8 + abyte14.length];
        System.arraycopy(abyte13, 0, abyte15, 0, k8);
        System.arraycopy(abyte14, 0, abyte15, k8, abyte14.length);
        k8 + abyte14.length;
        return abyte15;
        throwable;
        throwable.printStackTrace();
        com.aps.t.a(throwable);
        abyte0[j1] = 0;
        k1 = j1 + 1;
          goto _L5
        throwable1;
        throwable1.printStackTrace();
        com.aps.t.a(throwable1);
        abyte0[k1] = 0;
        l1 = k1 + 1;
          goto _L6
        throwable2;
        throwable2.printStackTrace();
        com.aps.t.a(throwable2);
        abyte0[l1] = 0;
        i2 = l1 + 1;
          goto _L7
        throwable3;
        throwable3.printStackTrace();
        com.aps.t.a(throwable3);
        abyte0[i2] = 0;
        j2 = i2 + 1;
          goto _L8
        throwable4;
        throwable4.printStackTrace();
        com.aps.t.a(throwable4);
        abyte0[j2] = 0;
        k2 = j2 + 1;
          goto _L9
        throwable5;
        throwable5.printStackTrace();
        com.aps.t.a(throwable5);
        abyte0[k2] = 0;
        l2 = k2 + 1;
          goto _L10
        throwable6;
        throwable6.printStackTrace();
        com.aps.t.a(throwable6);
        abyte0[l2] = 0;
        i3 = l2 + 1;
          goto _L11
        throwable7;
        throwable7.printStackTrace();
        com.aps.t.a(throwable7);
        abyte0[i3] = 0;
        j3 = i3 + 1;
          goto _L12
        throwable8;
        throwable8.printStackTrace();
        com.aps.t.a(throwable8);
        abyte0[j3] = 0;
        k3 = j3 + 1;
          goto _L13
        throwable9;
        throwable9.printStackTrace();
        com.aps.t.a(throwable9);
        abyte0[k3] = 0;
        l3 = k3 + 1;
          goto _L14
        throwable10;
        throwable10.printStackTrace();
        com.aps.t.a(throwable10);
        abyte0[j4] = 0;
        k4 = j4 + 1;
          goto _L15
_L2:
        abyte0[j5] = 1;
        k7 = j5 + 1;
        as2 = z.split(",");
        abyte18 = a(as2[0]);
        System.arraycopy(abyte18, 0, abyte0, k7, abyte18.length);
        j10 = abyte18.length;
        k7 += j10;
        abyte19 = as2[2].getBytes("GBK");
        abyte0[k7] = (byte)abyte19.length;
        k7++;
        System.arraycopy(abyte19, 0, abyte0, k7, abyte19.length);
        l10 = abyte19.length;
        k7 += l10;
_L17:
        k10 = Integer.parseInt(as2[1]);
        if (k10 > 127)
        {
            k10 = 0;
        } else
        if (k10 < -128)
        {
            k10 = 0;
        }
        abyte0[k7] = Byte.parseByte(String.valueOf(k10));
        l7 = k7 + 1;
          goto _L16
        throwable13;
        throwable13.printStackTrace();
        com.aps.t.a(throwable13);
        abyte0[k7] = 0;
        k7++;
          goto _L17
        throwable11;
        throwable11.printStackTrace();
        com.aps.t.a(throwable11);
        abyte0[k7] = 0;
        l7 = k7 + 1;
          goto _L16
_L4:
        abyte0[l7] = (byte)as.length;
        i8 = l7 + 1;
        l8 = 0;
_L20:
        if (l8 >= as.length) goto _L19; else goto _L18
_L18:
        as1 = as[l8].split(",");
        abyte16 = a(as1[0]);
        System.arraycopy(abyte16, 0, abyte0, i8, abyte16.length);
        i9 = i8 + abyte16.length;
        abyte17 = as1[2].getBytes("GBK");
        abyte0[i9] = (byte)abyte17.length;
        i9++;
        System.arraycopy(abyte17, 0, abyte0, i9, abyte17.length);
        i10 = abyte17.length;
        j9 = i10 + i9;
_L21:
        k9 = Integer.parseInt(as1[1]);
        if (k9 > 127)
        {
            k9 = 0;
        } else
        if (k9 < -128)
        {
            k9 = 0;
        }
        abyte0[j9] = Byte.parseByte(String.valueOf(k9));
        l9 = j9 + 1;
        l8++;
        i8 = l9;
          goto _L20
          goto _L19
        throwable12;
        throwable12.printStackTrace();
        com.aps.t.a(throwable12);
        abyte0[i9] = 0;
        j9 = i9 + 1;
          goto _L21
    }
}
