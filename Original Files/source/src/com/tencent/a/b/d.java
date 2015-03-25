// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.a.b;

import android.os.StatFs;
import java.io.File;

public class d
{

    private File a;
    private long b;
    private long c;

    public d()
    {
    }

    public static d b(File file)
    {
        d d1 = new d();
        d1.a(file);
        StatFs statfs = new StatFs(file.getAbsolutePath());
        long l = statfs.getBlockSize();
        long l1 = statfs.getBlockCount();
        long l2 = statfs.getAvailableBlocks();
        d1.a(l1 * l);
        d1.b(l2 * l);
        return d1;
    }

    public File a()
    {
        return a;
    }

    public void a(long l)
    {
        b = l;
    }

    public void a(File file)
    {
        a = file;
    }

    public long b()
    {
        return b;
    }

    public void b(long l)
    {
        c = l;
    }

    public long c()
    {
        return c;
    }

    public String toString()
    {
        Object aobj[] = new Object[3];
        aobj[0] = a().getAbsolutePath();
        aobj[1] = Long.valueOf(c());
        aobj[2] = Long.valueOf(b());
        return String.format("[%s : %d / %d]", aobj);
    }
}
