// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.cache.disc.impl;

import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import java.io.File;

// Referenced classes of package com.nostra13.universalimageloader.cache.disc.impl:
//            BaseDiscCache

public class UnlimitedDiscCache extends BaseDiscCache
{

    public UnlimitedDiscCache(File file)
    {
        super(file);
    }

    public UnlimitedDiscCache(File file, File file1)
    {
        super(file, file1);
    }

    public UnlimitedDiscCache(File file, File file1, FileNameGenerator filenamegenerator)
    {
        super(file, file1, filenamegenerator);
    }
}
