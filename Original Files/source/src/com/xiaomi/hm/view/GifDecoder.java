// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.view;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.xiaomi.hm.view:
//            GifAction, GifFrame

public class GifDecoder extends Thread
{

    private static final int H = 4096;
    private static final int N = 15;
    public static final int STATUS_FINISH = -1;
    public static final int STATUS_FORMAT_ERROR = 1;
    public static final int STATUS_OPEN_ERROR = 2;
    public static final int STATUS_PARSING;
    private byte A[];
    private int B;
    private int C;
    private int D;
    private boolean E;
    private int F;
    private int G;
    private short I[];
    private byte J[];
    private byte K[];
    private byte L[];
    private int M;
    private Queue O;
    private final ReentrantLock P;
    private final Condition Q;
    private final Condition R;
    private int S;
    private boolean T;
    private ArrayList U;
    private int V;
    private boolean W;
    private GifAction X;
    private byte Y[];
    private boolean Z;
    private InputStream a;
    private int aa;
    private Resources ab;
    private int ac;
    private String ad;
    private int ae[];
    private int af[];
    private InputStream b;
    private int c;
    private boolean d;
    private int e;
    private int f;
    private int g[];
    private int h[];
    public int height;
    private int i[];
    public boolean isDestroy;
    private int j;
    private int k;
    private int l;
    private int m;
    private boolean n;
    private boolean o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    public int width;
    private int x;
    private Bitmap y;
    private Bitmap z;

    public GifDecoder(GifAction gifaction)
    {
        isDestroy = false;
        f = 1;
        A = new byte[256];
        B = 0;
        C = 0;
        D = 0;
        E = false;
        F = 0;
        O = new ArrayBlockingQueue(15);
        P = new ReentrantLock();
        Q = P.newCondition();
        R = P.newCondition();
        S = 0;
        T = false;
        U = new ArrayList(M);
        V = 0;
        W = false;
        X = null;
        Y = null;
        Z = false;
        aa = 0;
        ab = null;
        ac = 0;
        ad = null;
        ae = null;
        af = new int[256];
        X = gifaction;
    }

    public GifDecoder(GifAction gifaction, boolean flag)
    {
        isDestroy = false;
        f = 1;
        A = new byte[256];
        B = 0;
        C = 0;
        D = 0;
        E = false;
        F = 0;
        O = new ArrayBlockingQueue(15);
        P = new ReentrantLock();
        Q = P.newCondition();
        R = P.newCondition();
        S = 0;
        T = false;
        U = new ArrayList(M);
        V = 0;
        W = false;
        X = null;
        Y = null;
        Z = false;
        aa = 0;
        ab = null;
        ac = 0;
        ad = null;
        ae = null;
        af = new int[256];
        X = gifaction;
        Z = flag;
    }

    private void a()
    {
        a = new ByteArrayInputStream(Y);
    }

    private int[] a(int i1)
    {
        int j1;
        int k1;
        byte abyte0[];
        j1 = 0;
        k1 = i1 * 3;
        abyte0 = new byte[k1];
        int l3 = a.read(abyte0);
        int l1 = l3;
_L1:
        Exception exception;
        if (l1 < k1)
        {
            c = 1;
        } else
        {
            int i2 = 0;
            while (j1 < i1) 
            {
                int j2 = i2 + 1;
                int k2 = 0xff & abyte0[i2];
                int l2 = j2 + 1;
                int i3 = 0xff & abyte0[j2];
                i2 = l2 + 1;
                int j3 = 0xff & abyte0[l2];
                int ai[] = af;
                int k3 = j1 + 1;
                ai[j1] = j3 | (0xff000000 | k2 << 16 | i3 << 8);
                j1 = k3;
            }
        }
        return af;
        exception;
        exception.printStackTrace();
        l1 = 0;
          goto _L1
    }

    private void b()
    {
        a = ab.openRawResource(ac);
    }

    private void c()
    {
        try
        {
            a = new FileInputStream(ad);
            return;
        }
        catch (Exception exception)
        {
            Log.e("open failed", exception.toString());
        }
    }

    private void d()
    {
        if (a != null)
        {
            try
            {
                a.close();
            }
            catch (Exception exception) { }
            a = null;
        }
        Y = null;
        c = 0;
        if (U != null)
        {
            U.clear();
            U = null;
        }
        if (O != null)
        {
            O.clear();
            O = null;
        }
    }

    private void e()
    {
        if (ae == null)
        {
            ae = new int[width * height];
        }
        if (D <= 0) goto _L2; else goto _L1
_L1:
        if (D == 3)
        {
            if (-2 + M <= 0)
            {
                z = null;
            }
            z = null;
        }
        if (z == null) goto _L2; else goto _L3
_L3:
        z.getPixels(ae, 0, width, 0, 0, width, height);
        if (D != 2) goto _L2; else goto _L4
_L4:
        if (E) goto _L6; else goto _L5
_L5:
        int l4 = l;
          goto _L7
_L27:
        int i5;
        if (i5 < x) goto _L8; else goto _L2
_L28:
        int i1;
        int j1;
        int k1;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        int l3;
        byte abyte0[];
        int i4;
        int k4;
        int j5;
        int k5;
        try
        {
            if (k1 >= t)
            {
                y = Bitmap.createBitmap(ae, width, height, android.graphics.Bitmap.Config.RGB_565);
                return;
            }
        }
        catch (OutOfMemoryError outofmemoryerror)
        {
            outofmemoryerror.printStackTrace();
            return;
        }
        catch (StackOverflowError stackoverflowerror)
        {
            stackoverflowerror.printStackTrace();
            return;
        }
        catch (Exception exception)
        {
            Log.e("GifView decode setpixel", exception.toString());
            return;
        }
          goto _L9
_L8:
        j5 = (i5 + v) * width + u;
        k5 = j5 + w;
          goto _L10
_L30:
        ae[j5] = l4;
        j5++;
        continue; /* Loop/switch isn't completed */
_L9:
        if (!o) goto _L12; else goto _L11
_L11:
        if (j1 < t) goto _L14; else goto _L13
_L13:
        ++i1;
        JVM INSTR tableswitch 2 4: default 481
    //                   2 524
    //                   3 530
    //                   4 539;
           goto _L14 _L15 _L16 _L17
_L26:
        j2 = j1 + r;
        if (j2 >= height) goto _L19; else goto _L18
_L18:
        k2 = j2 * width;
        l2 = k2 + q;
        i3 = l2 + s;
        if (k2 + width >= i3) goto _L21; else goto _L20
_L20:
        j3 = k2 + width;
_L25:
        k3 = k1 * s;
        l3 = l2;
          goto _L22
_L31:
        abyte0 = L;
        i4 = k3 + 1;
        int j4 = 0xff & abyte0[k3];
        k4 = i[j4];
        if (k4 == 0) goto _L24; else goto _L23
_L23:
        ae[l3] = k4;
_L24:
        l3++;
        k3 = i4;
        continue; /* Loop/switch isn't completed */
_L21:
        j3 = i3;
          goto _L25
_L12:
        byte byte0;
        int l1;
        byte byte1;
        int i2;
        l1 = j1;
        byte1 = byte0;
        i2 = i1;
        j1 = k1;
          goto _L26
_L6:
        l4 = 0;
_L7:
        i5 = 0;
          goto _L27
_L2:
        byte0 = 8;
        i1 = 1;
        j1 = 0;
        k1 = 0;
          goto _L28
_L10:
        if (j5 < k5) goto _L30; else goto _L29
_L29:
        i5++;
          goto _L27
_L14:
        l1 = j1 + byte0;
        byte1 = byte0;
        i2 = i1;
          goto _L26
_L22:
        if (l3 < j3) goto _L31; else goto _L19
_L19:
        k1++;
        j1 = l1;
        byte0 = byte1;
        i1 = i2;
          goto _L28
_L15:
        j1 = 4;
          goto _L14
_L16:
        j1 = 2;
        byte0 = 4;
          goto _L14
_L17:
        j1 = 1;
        byte0 = 2;
          goto _L14
    }

    private int f()
    {
        j();
        if (a == null) goto _L2; else goto _L1
_L1:
        o();
        if (!i())
        {
            m();
            if (!T && M < 0)
            {
                c = 1;
                if (X != null)
                {
                    X.parseReturn(4);
                }
            }
        }
        try
        {
            if (a != null)
            {
                a.close();
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        a = null;
        g();
_L4:
        return c;
_L2:
        c = 2;
        if (X != null)
        {
            X.parseReturn(4);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void g()
    {
        if (Z && !W) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (M > 15) goto _L4; else goto _L3
_L3:
        P.lockInterruptibly();
        W = true;
        c = -1;
        if (X != null)
        {
            X.parseReturn(2);
        }
        Q.signal();
        P.unlock();
_L9:
        aa;
        JVM INSTR tableswitch 1 3: default 104
    //                   1 160
    //                   2 167
    //                   3 174;
           goto _L5 _L6 _L7 _L8
_L5:
        break; /* Loop/switch isn't completed */
_L8:
        break MISSING_BLOCK_LABEL_174;
_L10:
        T = true;
        if (!isDestroy)
        {
            f();
            return;
        }
          goto _L1
        Exception exception1;
        exception1;
        P.unlock();
          goto _L9
        Exception exception;
        exception;
        P.unlock();
        throw exception;
_L4:
        if (U != null)
        {
            U.clear();
        }
          goto _L9
_L6:
        b();
          goto _L10
_L7:
        c();
          goto _L10
        a();
          goto _L10
    }

    private void h()
    {
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        i1 = s * t;
        if (L == null || L.length < i1)
        {
            L = new byte[i1];
        }
        if (I == null)
        {
            I = new short[4096];
        }
        if (J == null)
        {
            J = new byte[4096];
        }
        if (K == null)
        {
            K = new byte[4097];
        }
        j1 = k();
        k1 = 1 << j1;
        l1 = k1 + 1;
        i2 = k1 + 2;
        j2 = j1 + 1;
        k2 = -1 + (1 << j2);
        l2 = 0;
_L5:
        if (l2 < k1) goto _L2; else goto _L1
_L1:
        int i3;
        int j3;
        int k3;
        int l3;
        int i4;
        int j4;
        int k4;
        int l4;
        int i5;
        i3 = 0;
        j3 = 0;
        k3 = 0;
        l3 = 0;
        i4 = 0;
        j4 = 0;
        k4 = 0;
        l4 = -1;
        i5 = 0;
_L7:
        if (i4 < i1) goto _L4; else goto _L3
_L2:
        I[l2] = 0;
        J[l2] = (byte)l2;
        l2++;
          goto _L5
_L4:
        if (j3 != 0)
        {
            break MISSING_BLOCK_LABEL_661;
        }
        if (k4 >= j2)
        {
            break MISSING_BLOCK_LABEL_252;
        }
        if (j4 != 0)
        {
            break MISSING_BLOCK_LABEL_221;
        }
        j4 = l();
        if (j4 <= 0) goto _L3; else goto _L6
_L6:
        i5 = 0;
        l3 += (0xff & A[i5]) << k4;
        k4 += 8;
        i5++;
        j4--;
          goto _L7
        int i8;
        i8 = l3 & k2;
        l3 >>= j2;
        k4 -= j2;
        if (i8 > i2 || i8 == l1) goto _L3; else goto _L8
_L8:
        if (i8 == k1)
        {
            j2 = j1 + 1;
            k2 = -1 + (1 << j2);
            i2 = k1 + 2;
            l4 = -1;
        } else
        {
label0:
            {
                if (l4 != -1)
                {
                    break label0;
                }
                byte abyte4[] = K;
                int l9 = j3 + 1;
                abyte4[j3] = J[i8];
                j3 = l9;
                l4 = i8;
                k3 = i8;
            }
        }
          goto _L7
        int j5;
        int k5;
        int l5;
        int i6;
        int j6;
        int k6;
        int l6;
        int i7;
        int j8;
        int k8;
        if (i8 == i2)
        {
            byte abyte3[] = K;
            j8 = j3 + 1;
            abyte3[j3] = (byte)k3;
            k8 = l4;
        } else
        {
            j8 = j3;
            k8 = i8;
        }
        if (k8 > k1) goto _L10; else goto _L9
_L9:
        i9 = 0xff & J[k8];
        if (i2 >= 4096) goto _L3; else goto _L11
_L11:
        byte abyte2[] = K;
        int j9 = j8 + 1;
        abyte2[j8] = (byte)i9;
        I[i2] = (short)l4;
        J[i2] = (byte)i9;
        i7 = i2 + 1;
        if ((i7 & k2) == 0 && i7 < 4096)
        {
            j2++;
            k2 += i7;
        }
        k6 = l3;
        l6 = i8;
        j5 = k2;
        k5 = i9;
        l5 = k4;
        i6 = j2;
        j6 = j9;
_L12:
        int j7 = j6 - 1;
        byte abyte0[] = L;
        int k7 = i3 + 1;
        abyte0[i3] = K[j7];
        i4++;
        i3 = k7;
        j2 = i6;
        k4 = l5;
        k3 = k5;
        k2 = j5;
        int l7 = l6;
        l3 = k6;
        j3 = j7;
        i2 = i7;
        l4 = l7;
          goto _L7
_L10:
        byte abyte1[] = K;
        int l8 = j8 + 1;
        abyte1[j8] = J[k8];
        k8 = I[k8];
        j8 = l8;
        break MISSING_BLOCK_LABEL_393;
_L3:
        int k9 = i3;
        do
        {
            int i9;
            if (k9 >= i1)
            {
                return;
            }
            L[k9] = 0;
            k9++;
        } while (true);
        j5 = k2;
        k5 = k3;
        l5 = k4;
        i6 = j2;
        j6 = j3;
        k6 = l3;
        l6 = l4;
        i7 = i2;
          goto _L12
    }

    private boolean i()
    {
        return c != 0;
    }

    private void j()
    {
        c = 0;
        if (!T)
        {
            M = 0;
        }
        g = null;
        h = null;
        S = 0;
    }

    private int k()
    {
        int i1;
        try
        {
            i1 = a.read();
        }
        catch (Exception exception)
        {
            c = 1;
            return 0;
        }
        return i1;
    }

    private int l()
    {
        int i1;
        int j1;
        B = k();
        i1 = B;
        j1 = 0;
        if (i1 <= 0) goto _L2; else goto _L1
_L1:
        int k1 = B;
        if (j1 < k1) goto _L4; else goto _L3
_L3:
        if (j1 < B)
        {
            c = 1;
        }
_L2:
        return j1;
_L4:
        int l1 = a.read(A, j1, B - j1);
        if (l1 == -1) goto _L3; else goto _L5
_L5:
        j1 += l1;
          goto _L1
        Exception exception;
        exception;
        exception.printStackTrace();
          goto _L3
    }

    private void m()
    {
        boolean flag = false;
label0:
        do
        {
            if (flag || i() || isDestroy)
            {
                return;
            }
            switch (k())
            {
            default:
                c = 1;
                continue;

            case 0: // '\0'
                break;

            case 44: // ','
                p();
                continue;

            case 33: // '!'
                String s1;
                int i1;
                switch (k())
                {
                default:
                    u();
                    continue;

                case 249: 
                    n();
                    continue;

                case 255: 
                    l();
                    s1 = "";
                    i1 = 0;
                    break;
                }
                do
                {
                    if (i1 >= 11)
                    {
                        if (s1.equals("NETSCAPE2.0"))
                        {
                            r();
                        } else
                        {
                            u();
                        }
                        continue label0;
                    }
                    s1 = (new StringBuilder(String.valueOf(s1))).append((char)A[i1]).toString();
                    i1++;
                } while (true);

            case 59: // ';'
                flag = true;
                break;
            }
        } while (true);
    }

    private void n()
    {
        boolean flag = true;
        k();
        int i1 = k();
        C = (i1 & 0x1c) >> 2;
        if (C == 0)
        {
            C = ((flag) ? 1 : 0);
        }
        if ((i1 & 1) == 0)
        {
            flag = false;
        }
        E = flag;
        F = 10 * s();
        if (F == 0)
        {
            F = 100;
        }
        G = k();
        k();
    }

    private void o()
    {
        String s1;
        int i1;
        s1 = "";
        i1 = 0;
_L8:
        if (i1 < 6) goto _L2; else goto _L1
_L1:
        if (s1.startsWith("GIF")) goto _L4; else goto _L3
_L3:
        c = 1;
_L6:
        return;
_L2:
        s1 = (new StringBuilder(String.valueOf(s1))).append((char)k()).toString();
        i1++;
        continue; /* Loop/switch isn't completed */
_L4:
        q();
        if (!d || i()) goto _L6; else goto _L5
_L5:
        g = a(e);
        k = g[j];
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void p()
    {
        int j1;
        q = s();
        r = s();
        s = s();
        t = s();
        int i1 = k();
        boolean flag;
        boolean flag1;
        boolean flag2;
        int ai[];
        int k1;
        int l1;
        int i2;
        int j2;
        if ((i1 & 0x80) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        n = flag;
        if ((i1 & 0x40) != 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        o = flag1;
        p = 2 << (i1 & 7);
        if (n)
        {
            h = a(p);
            i = h;
        } else
        {
            i = g;
            if (j == G)
            {
                k = 0;
            }
        }
_L14:
        flag2 = E;
        j1 = 0;
        if (flag2)
        {
            ai = i;
            j1 = 0;
            if (ai != null)
            {
                k1 = i.length;
                j1 = 0;
                if (k1 > 0)
                {
                    l1 = i.length;
                    i2 = G;
                    j1 = 0;
                    if (l1 > i2)
                    {
                        j2 = i[G];
                        i[G] = 0;
                        j1 = j2;
                    }
                }
            }
        }
        if (i == null)
        {
            c = 1;
        }
        if (!i()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        h();
        u();
        if (i()) goto _L1; else goto _L3
_L3:
        if (!T)
        {
            M = 1 + M;
        }
        e();
        P.lockInterruptibly();
_L11:
        if (O != null && O.size() >= 15) goto _L5; else goto _L4
_L4:
        if (O == null) goto _L7; else goto _L6
_L6:
        GifFrame gifframe = new GifFrame(y, F);
        O.add(gifframe);
        if (!T)
        {
            U.add(gifframe);
        }
        Q.signal();
        if (T || S < 0) goto _L7; else goto _L8
_L8:
        S = 1 + S;
        if (S < 15) goto _L10; else goto _L9
_L9:
        X.parseReturn(3);
        S = -1;
_L7:
        InterruptedException interruptedexception;
        try
        {
            P.unlock();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
_L12:
        if (E)
        {
            i[G] = j1;
        }
        t();
        return;
_L5:
        R.await();
          goto _L11
        interruptedexception;
        R.signal();
        P.unlock();
          goto _L12
_L10:
        if (S != 1) goto _L7; else goto _L13
_L13:
        X.parseReturn(1);
          goto _L7
        Exception exception1;
        exception1;
        P.unlock();
        throw exception1;
          goto _L14
    }

    private void q()
    {
        width = s();
        height = s();
        int i1 = k();
        boolean flag;
        if ((i1 & 0x80) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        d = flag;
        e = 2 << (i1 & 7);
        j = k();
        m = k();
    }

    private void r()
    {
        do
        {
            l();
            if (A[0] == 1)
            {
                f = 0xff & A[1] | (0xff & A[2]) << 8;
            }
        } while (B > 0 && !i());
    }

    private int s()
    {
        return k() | k() << 8;
    }

    private void t()
    {
        D = C;
        u = q;
        v = r;
        w = s;
        x = t;
        z = y;
        l = k;
        C = 0;
        E = false;
        F = 0;
        h = null;
    }

    private void u()
    {
        do
        {
            l();
        } while (B > 0 && !i());
    }

    public void destroy()
    {
        isDestroy = true;
        d();
        X = null;
    }

    public GifFrame getCurrentFrame()
    {
        if (W && O.size() == 0)
        {
            if (V >= M)
            {
                V = 0;
                X.loopEnd();
            }
            GifFrame gifframe1 = (GifFrame)U.get(V);
            V = 1 + V;
            return gifframe1;
        }
        GifFrame gifframe;
        try
        {
            P.lockInterruptibly();
        }
        catch (Exception exception1)
        {
            P.unlock();
            return null;
        }
        if (!W && O.size() == 0)
        {
            break MISSING_BLOCK_LABEL_174;
        }
        gifframe = (GifFrame)O.poll();
        R.signal();
        V = 1 + V;
        if (T && V >= M)
        {
            X.loopEnd();
            V = 0;
        }
        P.unlock();
        return gifframe;
        try
        {
            Q.await();
            break MISSING_BLOCK_LABEL_80;
        }
        catch (Exception exception2) { }
        finally
        {
            P.unlock();
            throw exception;
        }
        Q.signal();
        P.unlock();
        return null;
    }

    public int getFrameCount()
    {
        if (!T && c != -1)
        {
            return -1;
        } else
        {
            return M;
        }
    }

    public Bitmap getFrameImage()
    {
        GifFrame gifframe = getCurrentFrame();
        if (gifframe == null)
        {
            return null;
        } else
        {
            return gifframe.image;
        }
    }

    public Bitmap getImage()
    {
        return getFrameImage();
    }

    public InputStream getInputStream()
    {
        return b;
    }

    public int getLoopCount()
    {
        return f;
    }

    public int getStatus()
    {
        return c;
    }

    public GifFrame next()
    {
        return getCurrentFrame();
    }

    public void run()
    {
        try
        {
            f();
            return;
        }
        catch (Exception exception)
        {
            Log.e("GifView decode run", exception.toString());
            exception.printStackTrace();
            return;
        }
    }

    public void setGifImage(Resources resources, int i1)
    {
        ab = resources;
        ac = i1;
        b();
        aa = 1;
    }

    public void setGifImage(String s1)
    {
        ad = s1;
        aa = 2;
        c();
    }

    public void setGifImage(byte abyte0[])
    {
        Y = abyte0;
        a();
        aa = 3;
    }

    public void setLoopAnimation()
    {
        Z = true;
    }
}
