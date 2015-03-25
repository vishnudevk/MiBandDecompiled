// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.cache.disc.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.core.DefaultConfigurationFactory;
import java.io.File;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.nostra13.universalimageloader.cache.disc.impl:
//            BaseDiscCache

public class LimitedAgeDiscCache extends BaseDiscCache
{

    private final long a;
    private final Map b;

    public LimitedAgeDiscCache(File file, long l)
    {
        this(file, null, DefaultConfigurationFactory.createFileNameGenerator(), l);
    }

    public LimitedAgeDiscCache(File file, File file1, long l)
    {
        this(file, file1, DefaultConfigurationFactory.createFileNameGenerator(), l);
    }

    public LimitedAgeDiscCache(File file, File file1, FileNameGenerator filenamegenerator, long l)
    {
        super(file, file1, filenamegenerator);
        b = Collections.synchronizedMap(new HashMap());
        a = 1000L * l;
    }

    private void a(String s)
    {
        File file = getFile(s);
        long l = System.currentTimeMillis();
        file.setLastModified(l);
        b.put(file, Long.valueOf(l));
    }

    public void clear()
    {
        super.clear();
        b.clear();
    }

    public File get(String s)
    {
        File file = super.get(s);
        if (file != null && file.exists())
        {
            Long long1 = (Long)b.get(file);
            boolean flag;
            if (long1 == null)
            {
                flag = false;
                long1 = Long.valueOf(file.lastModified());
            } else
            {
                flag = true;
            }
            if (System.currentTimeMillis() - long1.longValue() > a)
            {
                file.delete();
                b.remove(file);
            } else
            if (!flag)
            {
                b.put(file, long1);
                return file;
            }
        }
        return file;
    }

    public boolean remove(String s)
    {
        b.remove(getFile(s));
        return super.remove(s);
    }

    public boolean save(String s, Bitmap bitmap)
    {
        boolean flag = super.save(s, bitmap);
        a(s);
        return flag;
    }

    public boolean save(String s, InputStream inputstream, com.nostra13.universalimageloader.utils.IoUtils.CopyListener copylistener)
    {
        boolean flag = super.save(s, inputstream, copylistener);
        a(s);
        return flag;
    }
}
