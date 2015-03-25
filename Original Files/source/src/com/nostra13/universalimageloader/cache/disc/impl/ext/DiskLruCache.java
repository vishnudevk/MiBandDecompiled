// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.cache.disc.impl.ext;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.nostra13.universalimageloader.cache.disc.impl.ext:
//            b, a, d, g, 
//            e

final class DiskLruCache
    implements Closeable
{

    private static final OutputStream B = new b();
    static final String a = "journal";
    static final String b = "journal.tmp";
    static final String c = "journal.bkp";
    static final String d = "libcore.io.DiskLruCache";
    static final String e = "1";
    static final long f = -1L;
    static final Pattern g = Pattern.compile("[a-z0-9_-]{1,64}");
    private static final String i = "CLEAN";
    private static final String j = "DIRTY";
    private static final String k = "REMOVE";
    private static final String l = "READ";
    private final Callable A = new a(this);
    final ThreadPoolExecutor h;
    private final File m;
    private final File n;
    private final File o;
    private final File p;
    private final int q;
    private long r;
    private int s;
    private final int t;
    private long u;
    private int v;
    private Writer w;
    private final LinkedHashMap x = new LinkedHashMap(0, 0.75F, true);
    private int y;
    private long z;

    private DiskLruCache(File file, int i1, int j1, long l1, int k1)
    {
        u = 0L;
        v = 0;
        z = 0L;
        h = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        m = file;
        q = i1;
        n = new File(file, "journal");
        o = new File(file, "journal.tmp");
        p = new File(file, "journal.bkp");
        t = j1;
        r = l1;
        s = k1;
    }

    static int a(DiskLruCache disklrucache, int i1)
    {
        disklrucache.y = i1;
        return i1;
    }

    static Editor a(DiskLruCache disklrucache, String s1, long l1)
    {
        return disklrucache.a(s1, l1);
    }

    private Editor a(String s1, long l1)
    {
        this;
        JVM INSTR monitorenter ;
        d d1;
        n();
        e(s1);
        d1 = (d)x.get(s1);
        if (l1 == -1L) goto _L2; else goto _L1
_L1:
        if (d1 == null) goto _L4; else goto _L3
_L3:
        long l2 = com.nostra13.universalimageloader.cache.disc.impl.ext.d.e(d1);
        if (l2 == l1) goto _L2; else goto _L4
_L4:
        Editor editor1 = null;
_L7:
        this;
        JVM INSTR monitorexit ;
        return editor1;
_L2:
        if (d1 != null) goto _L6; else goto _L5
_L5:
        d d3;
        d3 = new d(this, s1, null);
        x.put(s1, d3);
        d d2 = d3;
_L9:
        editor1 = new Editor(d2, null);
        com.nostra13.universalimageloader.cache.disc.impl.ext.d.a(d2, editor1);
        w.write((new StringBuilder()).append("DIRTY ").append(s1).append('\n').toString());
        w.flush();
          goto _L7
        Exception exception;
        exception;
        throw exception;
_L6:
        Editor editor = com.nostra13.universalimageloader.cache.disc.impl.ext.d.a(d1);
label0:
        {
            if (editor == null)
            {
                break label0;
            }
            editor1 = null;
        }
        if (true) goto _L7; else goto _L8
_L8:
        d2 = d1;
          goto _L9
    }

    public static DiskLruCache a(File file, int i1, int j1, long l1, int k1)
    {
        DiskLruCache disklrucache;
        if (l1 <= 0L)
        {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (k1 <= 0)
        {
            throw new IllegalArgumentException("maxFileCount <= 0");
        }
        if (j1 <= 0)
        {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file1 = new File(file, "journal.bkp");
        if (file1.exists())
        {
            File file2 = new File(file, "journal");
            if (file2.exists())
            {
                file1.delete();
            } else
            {
                a(file1, file2, false);
            }
        }
        disklrucache = new DiskLruCache(file, i1, j1, l1, k1);
        if (!disklrucache.n.exists())
        {
            break MISSING_BLOCK_LABEL_229;
        }
        disklrucache.j();
        disklrucache.k();
        disklrucache.w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(disklrucache.n, true), g.a));
        return disklrucache;
        IOException ioexception;
        ioexception;
        System.out.println((new StringBuilder()).append("DiskLruCache ").append(file).append(" is corrupt: ").append(ioexception.getMessage()).append(", removing").toString());
        disklrucache.h();
        file.mkdirs();
        DiskLruCache disklrucache1 = new DiskLruCache(file, i1, j1, l1, k1);
        disklrucache1.l();
        return disklrucache1;
    }

    static Writer a(DiskLruCache disklrucache)
    {
        return disklrucache.w;
    }

    static String a(InputStream inputstream)
    {
        return b(inputstream);
    }

    private void a(Editor editor, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        d d1;
        d1 = Editor.a(editor);
        if (com.nostra13.universalimageloader.cache.disc.impl.ext.d.a(d1) != editor)
        {
            throw new IllegalStateException();
        }
        break MISSING_BLOCK_LABEL_30;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        int i1 = 0;
        if (!flag) goto _L2; else goto _L1
_L1:
        boolean flag1 = com.nostra13.universalimageloader.cache.disc.impl.ext.d.d(d1);
        i1 = 0;
        if (flag1) goto _L2; else goto _L3
_L3:
        int j1 = 0;
_L7:
        int k1 = t;
        i1 = 0;
        if (j1 >= k1) goto _L2; else goto _L4
_L4:
        if (!Editor.b(editor)[j1])
        {
            editor.abort();
            throw new IllegalStateException((new StringBuilder()).append("Newly created entry didn't create value for index ").append(j1).toString());
        }
        if (d1.b(j1).exists()) goto _L6; else goto _L5
_L5:
        editor.abort();
_L8:
        this;
        JVM INSTR monitorexit ;
        return;
_L6:
        j1++;
          goto _L7
_L2:
        long l1;
        File file;
        File file1;
        long l2;
        long l3;
        for (; i1 >= t; i1++)
        {
            break MISSING_BLOCK_LABEL_249;
        }

        file = d1.b(i1);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_241;
        }
        if (file.exists())
        {
            file1 = d1.a(i1);
            file.renameTo(file1);
            l2 = com.nostra13.universalimageloader.cache.disc.impl.ext.d.b(d1)[i1];
            l3 = file1.length();
            com.nostra13.universalimageloader.cache.disc.impl.ext.d.b(d1)[i1] = l3;
            u = l3 + (u - l2);
            v = 1 + v;
        }
        break MISSING_BLOCK_LABEL_457;
        a(file);
        break MISSING_BLOCK_LABEL_457;
        y = 1 + y;
        com.nostra13.universalimageloader.cache.disc.impl.ext.d.a(d1, null);
        if (!(flag | com.nostra13.universalimageloader.cache.disc.impl.ext.d.d(d1)))
        {
            break MISSING_BLOCK_LABEL_405;
        }
        com.nostra13.universalimageloader.cache.disc.impl.ext.d.a(d1, true);
        w.write((new StringBuilder()).append("CLEAN ").append(com.nostra13.universalimageloader.cache.disc.impl.ext.d.c(d1)).append(d1.a()).append('\n').toString());
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_353;
        }
        l1 = z;
        z = 1L + l1;
        com.nostra13.universalimageloader.cache.disc.impl.ext.d.a(d1, l1);
_L9:
        w.flush();
        if (u > r || v > s || m())
        {
            h.submit(A);
        }
          goto _L8
        x.remove(com.nostra13.universalimageloader.cache.disc.impl.ext.d.c(d1));
        w.write((new StringBuilder()).append("REMOVE ").append(com.nostra13.universalimageloader.cache.disc.impl.ext.d.c(d1)).append('\n').toString());
          goto _L9
    }

    static void a(DiskLruCache disklrucache, Editor editor, boolean flag)
    {
        disklrucache.a(editor, flag);
    }

    private static void a(File file)
    {
        if (file.exists() && !file.delete())
        {
            throw new IOException();
        } else
        {
            return;
        }
    }

    private static void a(File file, File file1, boolean flag)
    {
        if (flag)
        {
            a(file1);
        }
        if (!file.renameTo(file1))
        {
            throw new IOException();
        } else
        {
            return;
        }
    }

    private static String b(InputStream inputstream)
    {
        return com.nostra13.universalimageloader.cache.disc.impl.ext.g.a(new InputStreamReader(inputstream, g.b));
    }

    static void b(DiskLruCache disklrucache)
    {
        disklrucache.o();
    }

    static void c(DiskLruCache disklrucache)
    {
        disklrucache.p();
    }

    private void d(String s1)
    {
        int i1;
        int j1;
        int k1;
        i1 = s1.indexOf(' ');
        if (i1 == -1)
        {
            throw new IOException((new StringBuilder()).append("unexpected journal line: ").append(s1).toString());
        }
        j1 = i1 + 1;
        k1 = s1.indexOf(' ', j1);
        if (k1 != -1) goto _L2; else goto _L1
_L1:
        String s3;
        s3 = s1.substring(j1);
        if (i1 != "REMOVE".length() || !s1.startsWith("REMOVE"))
        {
            break MISSING_BLOCK_LABEL_304;
        }
        x.remove(s3);
_L4:
        return;
_L2:
        String s2 = s1.substring(j1, k1);
_L5:
        d d1 = (d)x.get(s2);
        if (d1 == null)
        {
            d1 = new d(this, s2, null);
            x.put(s2, d1);
        }
        if (k1 != -1 && i1 == "CLEAN".length() && s1.startsWith("CLEAN"))
        {
            String as[] = s1.substring(k1 + 1).split(" ");
            com.nostra13.universalimageloader.cache.disc.impl.ext.d.a(d1, true);
            com.nostra13.universalimageloader.cache.disc.impl.ext.d.a(d1, null);
            com.nostra13.universalimageloader.cache.disc.impl.ext.d.a(d1, as);
            return;
        }
        if (k1 == -1 && i1 == "DIRTY".length() && s1.startsWith("DIRTY"))
        {
            com.nostra13.universalimageloader.cache.disc.impl.ext.d.a(d1, new Editor(d1, null));
            return;
        }
        if (k1 == -1 && i1 == "READ".length() && s1.startsWith("READ")) goto _L4; else goto _L3
_L3:
        throw new IOException((new StringBuilder()).append("unexpected journal line: ").append(s1).toString());
        s2 = s3;
          goto _L5
    }

    static boolean d(DiskLruCache disklrucache)
    {
        return disklrucache.m();
    }

    static void e(DiskLruCache disklrucache)
    {
        disklrucache.l();
    }

    private void e(String s1)
    {
        if (!g.matcher(s1).matches())
        {
            throw new IllegalArgumentException((new StringBuilder()).append("keys must match regex [a-z0-9_-]{1,64}: \"").append(s1).append("\"").toString());
        } else
        {
            return;
        }
    }

    static int f(DiskLruCache disklrucache)
    {
        return disklrucache.t;
    }

    static File g(DiskLruCache disklrucache)
    {
        return disklrucache.m;
    }

    static OutputStream i()
    {
        return B;
    }

    private void j()
    {
        e e1 = new e(new FileInputStream(n), g.a);
        String s1 = e1.a();
        String s2 = e1.a();
        String s3 = e1.a();
        String s4 = e1.a();
        String s5 = e1.a();
        if (!"libcore.io.DiskLruCache".equals(s1) || !"1".equals(s2) || !Integer.toString(q).equals(s3) || !Integer.toString(t).equals(s4) || !"".equals(s5))
        {
            throw new IOException((new StringBuilder()).append("unexpected journal header: [").append(s1).append(", ").append(s2).append(", ").append(s4).append(", ").append(s5).append("]").toString());
        }
        break MISSING_BLOCK_LABEL_185;
        Exception exception;
        exception;
        com.nostra13.universalimageloader.cache.disc.impl.ext.g.a(e1);
        throw exception;
        int i1 = 0;
_L2:
        d(e1.a());
        i1++;
        if (true) goto _L2; else goto _L1
_L1:
        EOFException eofexception;
        eofexception;
        y = i1 - x.size();
        com.nostra13.universalimageloader.cache.disc.impl.ext.g.a(e1);
        return;
    }

    private void k()
    {
        a(o);
        for (Iterator iterator = x.values().iterator(); iterator.hasNext();)
        {
            d d1 = (d)iterator.next();
            if (com.nostra13.universalimageloader.cache.disc.impl.ext.d.a(d1) == null)
            {
                int j1 = 0;
                while (j1 < t) 
                {
                    u = u + com.nostra13.universalimageloader.cache.disc.impl.ext.d.b(d1)[j1];
                    v = 1 + v;
                    j1++;
                }
            } else
            {
                com.nostra13.universalimageloader.cache.disc.impl.ext.d.a(d1, null);
                for (int i1 = 0; i1 < t; i1++)
                {
                    a(d1.a(i1));
                    a(d1.b(i1));
                }

                iterator.remove();
            }
        }

    }

    private void l()
    {
        this;
        JVM INSTR monitorenter ;
        BufferedWriter bufferedwriter;
        if (w != null)
        {
            w.close();
        }
        bufferedwriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(o), g.a));
        Iterator iterator;
        bufferedwriter.write("libcore.io.DiskLruCache");
        bufferedwriter.write("\n");
        bufferedwriter.write("1");
        bufferedwriter.write("\n");
        bufferedwriter.write(Integer.toString(q));
        bufferedwriter.write("\n");
        bufferedwriter.write(Integer.toString(t));
        bufferedwriter.write("\n");
        bufferedwriter.write("\n");
        iterator = x.values().iterator();
_L1:
        d d1;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_249;
            }
            d1 = (d)iterator.next();
            if (com.nostra13.universalimageloader.cache.disc.impl.ext.d.a(d1) == null)
            {
                break MISSING_BLOCK_LABEL_205;
            }
            bufferedwriter.write((new StringBuilder()).append("DIRTY ").append(com.nostra13.universalimageloader.cache.disc.impl.ext.d.c(d1)).append('\n').toString());
        } while (true);
        Exception exception1;
        exception1;
        bufferedwriter.close();
        throw exception1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        bufferedwriter.write((new StringBuilder()).append("CLEAN ").append(com.nostra13.universalimageloader.cache.disc.impl.ext.d.c(d1)).append(d1.a()).append('\n').toString());
          goto _L1
        bufferedwriter.close();
        if (n.exists())
        {
            a(n, p, true);
        }
        a(o, n, false);
        p.delete();
        w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(n, true), g.a));
        this;
        JVM INSTR monitorexit ;
    }

    private boolean m()
    {
        return y >= 2000 && y >= x.size();
    }

    private void n()
    {
        if (w == null)
        {
            throw new IllegalStateException("cache is closed");
        } else
        {
            return;
        }
    }

    private void o()
    {
        while (u > r) 
        {
            c((String)((java.util.Map.Entry)x.entrySet().iterator().next()).getKey());
        }
    }

    private void p()
    {
        while (v > s) 
        {
            c((String)((java.util.Map.Entry)x.entrySet().iterator().next()).getKey());
        }
    }

    public Snapshot a(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        d d1;
        n();
        e(s1);
        d1 = (d)x.get(s1);
        if (d1 != null) goto _L2; else goto _L1
_L1:
        Snapshot snapshot = null;
_L8:
        this;
        JVM INSTR monitorexit ;
        return snapshot;
_L2:
        if (!com.nostra13.universalimageloader.cache.disc.impl.ext.d.d(d1))
        {
            snapshot = null;
            continue; /* Loop/switch isn't completed */
        }
        File afile[];
        InputStream ainputstream[];
        afile = new File[t];
        ainputstream = new InputStream[t];
        int i1 = 0;
_L4:
        if (i1 >= t)
        {
            break; /* Loop/switch isn't completed */
        }
        File file = d1.a(i1);
        afile[i1] = file;
        ainputstream[i1] = new FileInputStream(file);
        i1++;
        if (true) goto _L4; else goto _L3
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        int j1 = 0;
_L6:
        if (j1 >= t || ainputstream[j1] == null)
        {
            break; /* Loop/switch isn't completed */
        }
        com.nostra13.universalimageloader.cache.disc.impl.ext.g.a(ainputstream[j1]);
        j1++;
        if (true) goto _L6; else goto _L5
_L3:
        y = 1 + y;
        w.append((new StringBuilder()).append("READ ").append(s1).append('\n').toString());
        if (m())
        {
            h.submit(A);
        }
        snapshot = new Snapshot(s1, com.nostra13.universalimageloader.cache.disc.impl.ext.d.e(d1), afile, ainputstream, com.nostra13.universalimageloader.cache.disc.impl.ext.d.b(d1), null);
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        throw exception;
_L5:
        snapshot = null;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public File a()
    {
        return m;
    }

    public void a(long l1)
    {
        this;
        JVM INSTR monitorenter ;
        r = l1;
        h.submit(A);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public long b()
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = r;
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception;
        exception;
        throw exception;
    }

    public Editor b(String s1)
    {
        return a(s1, -1L);
    }

    public int c()
    {
        this;
        JVM INSTR monitorenter ;
        int i1 = s;
        this;
        JVM INSTR monitorexit ;
        return i1;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean c(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        d d1;
        n();
        e(s1);
        d1 = (d)x.get(s1);
        if (d1 == null) goto _L2; else goto _L1
_L1:
        Editor editor = com.nostra13.universalimageloader.cache.disc.impl.ext.d.a(d1);
        int i1 = 0;
        if (editor == null) goto _L3; else goto _L2
_L2:
        boolean flag = false;
_L7:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L5:
        u = u - com.nostra13.universalimageloader.cache.disc.impl.ext.d.b(d1)[i1];
        v = -1 + v;
        com.nostra13.universalimageloader.cache.disc.impl.ext.d.b(d1)[i1] = 0L;
        i1++;
_L3:
        File file;
        if (i1 >= t)
        {
            break MISSING_BLOCK_LABEL_153;
        }
        file = d1.a(i1);
        if (!file.exists() || file.delete()) goto _L5; else goto _L4
_L4:
        throw new IOException((new StringBuilder()).append("failed to delete ").append(file).toString());
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        y = 1 + y;
        w.append((new StringBuilder()).append("REMOVE ").append(s1).append('\n').toString());
        x.remove(s1);
        if (m())
        {
            h.submit(A);
        }
        flag = true;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void close()
    {
        this;
        JVM INSTR monitorenter ;
        Writer writer = w;
        if (writer != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Iterator iterator = (new ArrayList(x.values())).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            d d1 = (d)iterator.next();
            if (com.nostra13.universalimageloader.cache.disc.impl.ext.d.a(d1) != null)
            {
                com.nostra13.universalimageloader.cache.disc.impl.ext.d.a(d1).abort();
            }
        } while (true);
        break MISSING_BLOCK_LABEL_76;
        Exception exception;
        exception;
        throw exception;
        o();
        p();
        w.close();
        w = null;
          goto _L1
    }

    public long d()
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = u;
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception;
        exception;
        throw exception;
    }

    public long e()
    {
        this;
        JVM INSTR monitorenter ;
        int i1 = v;
        long l1 = i1;
        this;
        JVM INSTR monitorexit ;
        return l1;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean f()
    {
        this;
        JVM INSTR monitorenter ;
        Writer writer = w;
        boolean flag;
        if (writer == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public void g()
    {
        this;
        JVM INSTR monitorenter ;
        n();
        o();
        p();
        w.flush();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void h()
    {
        close();
        com.nostra13.universalimageloader.cache.disc.impl.ext.g.a(m);
    }


    private class Editor
    {

        final DiskLruCache a;
        private final d b;
        private final boolean c[];
        private boolean d;
        private boolean e;

        static d a(Editor editor)
        {
            return editor.b;
        }

        static boolean a(Editor editor, boolean flag)
        {
            editor.d = flag;
            return flag;
        }

        static boolean[] b(Editor editor)
        {
            return editor.c;
        }

        public void abort()
        {
            DiskLruCache.a(a, this, false);
        }

        public void abortUnlessCommitted()
        {
            if (e)
            {
                break MISSING_BLOCK_LABEL_11;
            }
            abort();
            return;
            IOException ioexception;
            ioexception;
        }

        public void commit()
        {
            if (d)
            {
                DiskLruCache.a(a, this, false);
                a.c(com.nostra13.universalimageloader.cache.disc.impl.ext.d.c(b));
            } else
            {
                DiskLruCache.a(a, this, true);
            }
            e = true;
        }

        public String getString(int i1)
        {
            InputStream inputstream = newInputStream(i1);
            if (inputstream != null)
            {
                return DiskLruCache.a(inputstream);
            } else
            {
                return null;
            }
        }

        public InputStream newInputStream(int i1)
        {
            DiskLruCache disklrucache = a;
            disklrucache;
            JVM INSTR monitorenter ;
            if (com.nostra13.universalimageloader.cache.disc.impl.ext.d.a(b) != this)
            {
                throw new IllegalStateException();
            }
            break MISSING_BLOCK_LABEL_31;
            Exception exception;
            exception;
            disklrucache;
            JVM INSTR monitorexit ;
            throw exception;
            if (com.nostra13.universalimageloader.cache.disc.impl.ext.d.d(b))
            {
                break MISSING_BLOCK_LABEL_45;
            }
            disklrucache;
            JVM INSTR monitorexit ;
            return null;
            FileInputStream fileinputstream = new FileInputStream(b.a(i1));
            disklrucache;
            JVM INSTR monitorexit ;
            return fileinputstream;
            FileNotFoundException filenotfoundexception;
            filenotfoundexception;
            disklrucache;
            JVM INSTR monitorexit ;
            return null;
        }

        public OutputStream newOutputStream(int i1)
        {
            DiskLruCache disklrucache = a;
            disklrucache;
            JVM INSTR monitorenter ;
            if (com.nostra13.universalimageloader.cache.disc.impl.ext.d.a(b) != this)
            {
                throw new IllegalStateException();
            }
            break MISSING_BLOCK_LABEL_31;
            Exception exception;
            exception;
            disklrucache;
            JVM INSTR monitorexit ;
            throw exception;
            File file;
            if (!com.nostra13.universalimageloader.cache.disc.impl.ext.d.d(b))
            {
                c[i1] = true;
            }
            file = b.b(i1);
            FileOutputStream fileoutputstream = new FileOutputStream(file);
            FileOutputStream fileoutputstream1 = fileoutputstream;
_L1:
            c c1 = new c(this, fileoutputstream1, null);
            disklrucache;
            JVM INSTR monitorexit ;
            return c1;
            FileNotFoundException filenotfoundexception;
            filenotfoundexception;
            DiskLruCache.g(a).mkdirs();
            FileOutputStream fileoutputstream2 = new FileOutputStream(file);
            fileoutputstream1 = fileoutputstream2;
              goto _L1
            FileNotFoundException filenotfoundexception1;
            filenotfoundexception1;
            OutputStream outputstream = DiskLruCache.i();
            disklrucache;
            JVM INSTR monitorexit ;
            return outputstream;
        }

        public void set(int i1, String s1)
        {
            OutputStreamWriter outputstreamwriter = new OutputStreamWriter(newOutputStream(i1), g.b);
            outputstreamwriter.write(s1);
            com.nostra13.universalimageloader.cache.disc.impl.ext.g.a(outputstreamwriter);
            return;
            Exception exception;
            exception;
            outputstreamwriter = null;
_L2:
            com.nostra13.universalimageloader.cache.disc.impl.ext.g.a(outputstreamwriter);
            throw exception;
            exception;
            if (true) goto _L2; else goto _L1
_L1:
        }

        private Editor(d d1)
        {
            a = DiskLruCache.this;
            super();
            b = d1;
            boolean aflag[];
            if (com.nostra13.universalimageloader.cache.disc.impl.ext.d.d(d1))
            {
                aflag = null;
            } else
            {
                aflag = new boolean[DiskLruCache.f(DiskLruCache.this)];
            }
            c = aflag;
        }

        Editor(d d1, a a1)
        {
            this(d1);
        }
    }


    private class Snapshot
        implements Closeable
    {

        final DiskLruCache a;
        private final String b;
        private final long c;
        private File d[];
        private final InputStream e[];
        private final long f[];

        public void close()
        {
            InputStream ainputstream[] = e;
            int i1 = ainputstream.length;
            for (int j1 = 0; j1 < i1; j1++)
            {
                com.nostra13.universalimageloader.cache.disc.impl.ext.g.a(ainputstream[j1]);
            }

        }

        public Editor edit()
        {
            return DiskLruCache.a(a, b, c);
        }

        public File getFile(int i1)
        {
            return d[i1];
        }

        public InputStream getInputStream(int i1)
        {
            return e[i1];
        }

        public long getLength(int i1)
        {
            return f[i1];
        }

        public String getString(int i1)
        {
            return DiskLruCache.a(getInputStream(i1));
        }

        private Snapshot(String s1, long l1, File afile[], InputStream ainputstream[], long al[])
        {
            a = DiskLruCache.this;
            super();
            b = s1;
            c = l1;
            d = afile;
            e = ainputstream;
            f = al;
        }

        Snapshot(String s1, long l1, File afile[], InputStream ainputstream[], long al[], 
                a a1)
        {
            this(s1, l1, afile, ainputstream, al);
        }
    }

}
