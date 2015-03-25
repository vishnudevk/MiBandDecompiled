// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aps;

import android.content.Context;
import android.location.Location;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.telephony.NeighboringCellInfo;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.zip.GZIPOutputStream;

// Referenced classes of package com.aps:
//            s, ai, Y, Z, 
//            y, X, A, z, 
//            v, x

public class af
{

    private Context a;
    private int b;
    private int c;
    private int d;

    protected af(Context context)
    {
        b = 0;
        c = 0;
        d = 0;
        a = context;
        a(768);
    }

    private static int a(int i, int j)
    {
        if (i < j)
        {
            return i;
        } else
        {
            return j;
        }
    }

    protected static s a(Location location, ai ai1, int i, byte byte0, long l)
    {
        s s1;
        boolean flag;
        boolean flag1;
        long l1;
        byte byte1;
label0:
        {
            s1 = new s();
            if (i <= 0 || i > 3 || ai1 == null)
            {
                return null;
            }
            byte abyte0[];
            byte abyte1[];
            byte abyte2[];
            byte abyte3[];
            byte abyte4[];
            boolean flag2;
            Y y4;
            X x2;
            if (i == 1 || i == 3)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (i == 2 || i == 3)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            abyte0 = ai1.p().getBytes();
            System.arraycopy(abyte0, 0, s1.c, 0, a(abyte0.length, s1.c.length));
            abyte1 = ai1.f().getBytes();
            System.arraycopy(abyte1, 0, s1.g, 0, a(abyte1.length, s1.g.length));
            abyte2 = ai1.g().getBytes();
            System.arraycopy(abyte2, 0, s1.a, 0, a(abyte2.length, s1.a.length));
            abyte3 = ai1.h().getBytes();
            System.arraycopy(abyte3, 0, s1.b, 0, a(abyte3.length, s1.b.length));
            s1.d = (short)ai1.q();
            s1.e = (short)ai1.r();
            s1.f = (byte)ai1.s();
            abyte4 = ai1.t().getBytes();
            System.arraycopy(abyte4, 0, s1.h, 0, a(abyte4.length, s1.h.length));
            l1 = l / 1000L;
            if (location != null && ai1.e())
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (flag2)
            {
                Y y1 = new Y();
                y1.b = (int)l1;
                Z z1 = new Z();
                z1.a = (int)(1000000D * location.getLongitude());
                z1.b = (int)(1000000D * location.getLatitude());
                z1.c = (int)location.getAltitude();
                z1.d = (int)location.getAccuracy();
                z1.e = (int)location.getSpeed();
                z1.f = (short)(int)location.getBearing();
                List list3;
                List list4;
                if (!ai.b(ai1.x()) || !y.b)
                {
                    z1.g = 0;
                } else
                {
                    z1.g = 1;
                }
                z1.h = byte0;
                z1.i = System.currentTimeMillis();
                z1.j = ai1.o();
                y1.c = z1;
                byte1 = 1;
                s1.j.add(y1);
                if (!ai1.c() || ai1.i() || !flag)
                {
                    break label0;
                }
                y4 = new Y();
                y4.b = (int)l1;
                x2 = new X();
                list3 = ai1.a(location.getSpeed());
                if (list3 != null && list3.size() >= 3)
                {
                    x2.a = (short)((Integer)list3.get(0)).intValue();
                    x2.b = ((Integer)list3.get(1)).intValue();
                }
                x2.c = ai1.l();
                list4 = ai1.m();
                x2.d = (byte)list4.size();
                for (int i1 = 0; i1 < list4.size(); i1++)
                {
                    A a1 = new A();
                    a1.a = (short)((NeighboringCellInfo)list4.get(i1)).getLac();
                    a1.b = ((NeighboringCellInfo)list4.get(i1)).getCid();
                    a1.c = (byte)((NeighboringCellInfo)list4.get(i1)).getRssi();
                    x2.e.add(a1);
                }

            } else
            {
                return null;
            }
            y4.d = x2;
            byte1 = 2;
            s1.j.add(y4);
        }
        int j = byte1;
        if (ai1.c() && ai1.i() && flag)
        {
            Y y3 = new Y();
            y3.b = (int)l1;
            z z2 = new z();
            List list2 = ai1.b(location.getSpeed());
            if (list2 != null && list2.size() >= 6)
            {
                z2.a = ((Integer)list2.get(3)).intValue();
                z2.b = ((Integer)list2.get(4)).intValue();
                z2.c = (short)((Integer)list2.get(0)).intValue();
                z2.d = (short)((Integer)list2.get(1)).intValue();
                z2.e = ((Integer)list2.get(2)).intValue();
                z2.f = ai1.l();
            }
            y3.e = z2;
            j++;
            s1.j.add(y3);
        }
        if (ai1.d() && flag1)
        {
            Y y2 = new Y();
            v v1 = new v();
            List list = ai1.u();
            y2.b = (int)(((Long)list.get(0)).longValue() / 1000L);
            v1.a = (byte)(-1 + list.size());
            for (int k = 1; k < list.size(); k++)
            {
                List list1 = (List)list.get(k);
                if (list1 != null && list1.size() >= 3)
                {
                    x x1 = new x();
                    byte abyte5[] = ((String)list1.get(0)).getBytes();
                    System.arraycopy(abyte5, 0, x1.a, 0, a(abyte5.length, x1.a.length));
                    x1.b = (short)((Integer)list1.get(1)).intValue();
                    byte abyte6[] = ((String)list1.get(2)).getBytes();
                    System.arraycopy(abyte6, 0, x1.c, 0, a(abyte6.length, x1.c.length));
                    v1.b.add(x1);
                }
            }

            y2.f = v1;
            j++;
            s1.j.add(y2);
        }
        s1.i = (short)j;
        if (j < 2)
        {
            return null;
        } else
        {
            return s1;
        }
    }

    protected static File a(Context context)
    {
        String s1 = (new StringBuilder("/Android/data/")).append(context.getPackageName()).append("/files/").toString();
        return new File((new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append(s1).toString());
    }

    private static ArrayList a(File afile[])
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < afile.length; i++)
        {
            if (afile[i].isFile() && afile[i].getName().length() == 10 && TextUtils.isDigitsOnly(afile[i].getName()))
            {
                arraylist.add(afile[i]);
            }
        }

        return arraylist;
    }

    protected static byte[] a(BitSet bitset)
    {
        byte abyte0[] = new byte[bitset.size() / 8];
        int i = 0;
        while (i < bitset.size()) 
        {
            int j = i / 8;
            int k = 7 - i % 8;
            byte byte0 = abyte0[j];
            int l;
            if (bitset.get(i))
            {
                l = 1;
            } else
            {
                l = 0;
            }
            abyte0[j] = (byte)(byte0 | l << k);
            i++;
        }
        return abyte0;
    }

    protected static byte[] a(byte abyte0[])
    {
        byte abyte1[] = null;
        try
        {
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            GZIPOutputStream gzipoutputstream = new GZIPOutputStream(bytearrayoutputstream);
            gzipoutputstream.write(abyte0);
            gzipoutputstream.finish();
            gzipoutputstream.close();
            abyte1 = bytearrayoutputstream.toByteArray();
            bytearrayoutputstream.close();
        }
        catch (Exception exception)
        {
            return abyte1;
        }
        return abyte1;
    }

    protected static byte[] a(byte abyte0[], int i)
    {
        if (abyte0 == null || abyte0.length == 0)
        {
            return null;
        }
        int j = (new String(abyte0)).indexOf('\0');
        byte abyte1[];
        if (j > 0)
        {
            if (j + 1 <= i)
            {
                i = j + 1;
            }
        } else
        {
            i = 1;
        }
        abyte1 = new byte[i];
        System.arraycopy(abyte0, 0, abyte1, 0, i);
        abyte1[i - 1] = 0;
        return abyte1;
    }

    protected static BitSet b(byte abyte0[])
    {
        BitSet bitset = new BitSet(abyte0.length << 3);
        int i = 0;
        int j = 0;
        for (; i < abyte0.length; i++)
        {
            int k = 7;
            while (k >= 0) 
            {
                int l = j + 1;
                boolean flag;
                if ((abyte0[i] & 1 << k) >> k == 1)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                bitset.set(j, flag);
                k--;
                j = l;
            }
        }

        return bitset;
    }

    private File c(long l)
    {
        if (Process.myUid() != 1000) goto _L2; else goto _L1
_L1:
        File file1 = null;
_L6:
        return file1;
_L2:
        boolean flag3 = "mounted".equals(Environment.getExternalStorageState());
        boolean flag = flag3;
_L4:
        if (c() && !flag)
        {
            break; /* Loop/switch isn't completed */
        }
        StatFs statfs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        if ((long)statfs.getAvailableBlocks() * (long)statfs.getBlockSize() <= (long)(c / 2))
        {
            return null;
        }
        break; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
        String s1 = a(a).getPath();
        File file = new File((new StringBuilder()).append(s1).append(File.separator).append("carrierdata").toString());
        if (!file.exists() || !file.isDirectory())
        {
            file.mkdirs();
        }
        file1 = new File((new StringBuilder()).append(file.getPath()).append(File.separator).append(l).toString());
        boolean flag2 = file1.createNewFile();
        boolean flag1 = flag2;
_L7:
        if (!flag1)
        {
            return null;
        }
        if (true) goto _L6; else goto _L5
        IOException ioexception;
        ioexception;
        flag1 = false;
          goto _L7
_L5:
        file1 = null;
        flag1 = false;
          goto _L7
    }

    protected static boolean c()
    {
        if (android.os.Build.VERSION.SDK_INT < 9)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        boolean flag = ((Boolean)android/os/Environment.getMethod("isExternalStorageRemovable", null).invoke(null, null)).booleanValue();
        return flag;
        Exception exception;
        exception;
        return true;
    }

    private File d()
    {
        if (Process.myUid() == 1000)
        {
            return null;
        }
        boolean flag1 = "mounted".equals(Environment.getExternalStorageState());
        boolean flag = flag1;
_L1:
        File file1;
label0:
        {
            if (c() && !flag)
            {
                break label0;
            }
            String s1 = a(a).getPath();
            File file = new File((new StringBuilder()).append(s1).append(File.separator).append("carrierdata").toString());
            if (!file.exists() || !file.isDirectory())
            {
                break label0;
            }
            File afile[] = file.listFiles();
            if (afile == null || afile.length <= 0)
            {
                break label0;
            }
            ArrayList arraylist = a(afile);
            Exception exception;
            if (arraylist.size() == 1)
            {
                if (((File)arraylist.get(0)).length() >= (long)d)
                {
                    break label0;
                }
                file1 = (File)arraylist.get(0);
            } else
            {
                if (arraylist.size() < 2)
                {
                    break label0;
                }
                file1 = (File)arraylist.get(0);
                File file2 = (File)arraylist.get(1);
                if (file1.getName().compareTo(file2.getName()) <= 0)
                {
                    file1 = file2;
                }
            }
        }
_L2:
        return file1;
        exception;
        flag = false;
          goto _L1
        file1 = null;
          goto _L2
    }

    private File d(long l)
    {
        File file2;
        File file = a.getFilesDir();
        File file1 = new File((new StringBuilder()).append(file.getPath()).append(File.separator).append("carrierdata").toString());
        if (!file1.exists() || !file1.isDirectory())
        {
            file1.mkdirs();
        }
        file2 = new File((new StringBuilder()).append(file1.getPath()).append(File.separator).append(l).toString());
        boolean flag1 = file2.createNewFile();
        boolean flag = flag1;
_L2:
        if (flag)
        {
            return file2;
        } else
        {
            return null;
        }
        IOException ioexception;
        ioexception;
        flag = false;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private int e()
    {
        if (Process.myUid() != 1000) goto _L2; else goto _L1
_L1:
        return 0;
_L2:
        boolean flag1 = "mounted".equals(Environment.getExternalStorageState());
        boolean flag = flag1;
_L4:
        ArrayList arraylist;
        if (!c() || flag)
        {
            String s1 = a(a).getPath();
            File file = new File((new StringBuilder()).append(s1).append(File.separator).append("carrierdata").toString());
            if (file.exists() && file.isDirectory())
            {
                File afile[] = file.listFiles();
                if (afile != null && afile.length > 0)
                {
                    arraylist = a(afile);
                    Exception exception;
                    if (arraylist.size() == 1)
                    {
                        return ((File)arraylist.get(0)).length() > 0L ? 1 : 10;
                    }
                    continue; /* Loop/switch isn't completed */
                }
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
        exception;
        flag = false;
          goto _L4
        if (arraylist.size() < 2) goto _L1; else goto _L5
_L5:
        return 2;
    }

    private File f()
    {
        if (Process.myUid() == 1000)
        {
            return null;
        }
        boolean flag1 = "mounted".equals(Environment.getExternalStorageState());
        boolean flag = flag1;
_L1:
        File file1;
        if (c() && !flag)
        {
            break MISSING_BLOCK_LABEL_193;
        }
        File file = a(a);
        if (file == null)
        {
            break MISSING_BLOCK_LABEL_193;
        }
        String s1 = file.getPath();
        File file2 = new File((new StringBuilder()).append(s1).append(File.separator).append("carrierdata").toString());
        if (!file2.exists() || !file2.isDirectory())
        {
            break MISSING_BLOCK_LABEL_193;
        }
        File afile[] = file2.listFiles();
        if (afile == null || afile.length <= 0)
        {
            break MISSING_BLOCK_LABEL_193;
        }
        ArrayList arraylist = a(afile);
        if (arraylist.size() < 2)
        {
            break MISSING_BLOCK_LABEL_193;
        }
        File file3 = (File)arraylist.get(0);
        file1 = (File)arraylist.get(1);
        Exception exception;
        if (file3.getName().compareTo(file1.getName()) <= 0)
        {
            file1 = file3;
        }
_L2:
        return file1;
        exception;
        flag = false;
          goto _L1
        file1 = null;
          goto _L2
    }

    protected int a()
    {
        return b;
    }

    protected File a(long l)
    {
        File file;
        file = d();
        if (file == null)
        {
            file = c(l);
        }
        if (file != null) goto _L2; else goto _L1
_L1:
        File file2;
        File file1 = a.getFilesDir();
        file2 = new File((new StringBuilder()).append(file1.getPath()).append(File.separator).append("carrierdata").toString());
        if (!file2.exists() || !file2.isDirectory()) goto _L4; else goto _L3
_L3:
        File afile[] = file2.listFiles();
        if (afile == null || afile.length <= 0) goto _L4; else goto _L5
_L5:
        ArrayList arraylist = a(afile);
        if (arraylist.size() != 1) goto _L7; else goto _L6
_L6:
        if (((File)arraylist.get(0)).length() >= (long)d) goto _L4; else goto _L8
_L8:
        file = (File)arraylist.get(0);
_L2:
        if (file == null)
        {
            file = d(l);
        }
        return file;
_L7:
        if (arraylist.size() >= 2)
        {
            file = (File)arraylist.get(0);
            File file3 = (File)arraylist.get(1);
            if (file.getName().compareTo(file3.getName()) <= 0)
            {
                file = file3;
            }
            continue; /* Loop/switch isn't completed */
        }
_L4:
        file = null;
        if (true) goto _L2; else goto _L9
_L9:
    }

    protected void a(int i)
    {
        b = i;
        c = 4 + (1500 * (b << 3) + b);
        if (b == 256 || b == 768)
        {
            d = c / 100;
        } else
        if (b == 8736)
        {
            d = -5000 + c;
            return;
        }
    }

    protected File b()
    {
        File file3;
label0:
        {
            File file = f();
            if (file == null)
            {
                File file1 = a.getFilesDir();
                File file2 = new File((new StringBuilder()).append(file1.getPath()).append(File.separator).append("carrierdata").toString());
                boolean flag = file2.exists();
                file = null;
                if (flag)
                {
                    boolean flag1 = file2.isDirectory();
                    file = null;
                    if (flag1)
                    {
                        File afile[] = file2.listFiles();
                        file = null;
                        if (afile != null)
                        {
                            int i = afile.length;
                            file = null;
                            if (i > 0)
                            {
                                ArrayList arraylist = a(afile);
                                int j = arraylist.size();
                                file = null;
                                if (j >= 2)
                                {
                                    file3 = (File)arraylist.get(0);
                                    file = (File)arraylist.get(1);
                                    if (file3.getName().compareTo(file.getName()) <= 0)
                                    {
                                        break label0;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return file;
        }
        return file3;
    }

    protected boolean b(long l)
    {
        int i = e();
        if (i == 0)
        {
            File file = a.getFilesDir();
            File file1 = new File((new StringBuilder()).append(file.getPath()).append(File.separator).append("carrierdata").toString());
            byte byte0;
            if (file1.exists() && file1.isDirectory())
            {
                File afile[] = file1.listFiles();
                if (afile != null && afile.length > 0)
                {
                    ArrayList arraylist = a(afile);
                    if (arraylist.size() == 1)
                    {
                        if (((File)arraylist.get(0)).length() <= 0L)
                        {
                            byte0 = 10;
                        } else
                        {
                            byte0 = 1;
                        }
                        break MISSING_BLOCK_LABEL_128;
                    }
                    if (arraylist.size() >= 2)
                    {
                        byte0 = 2;
                        continue; /* Loop/switch isn't completed */
                    }
                }
            }
            byte0 = 0;
        } else
        {
            if (i == 1)
            {
                return c(l) != null;
            }
            return i == 2;
        }
          goto _L1
_L3:
        if (byte0 == 0)
        {
            return false;
        }
        if (byte0 == 1)
        {
            return d(l) != null;
        }
        return byte0 == 2;
_L1:
        if (true) goto _L3; else goto _L2
_L2:
    }
}
