// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.a.a;

import java.io.File;
import java.io.FileFilter;

// Referenced classes of package com.tencent.a.a:
//            h

final class i
    implements FileFilter
{

    i()
    {
    }

    public boolean accept(File file)
    {
        while (!file.isDirectory() || h.a(file) <= 0L) 
        {
            return false;
        }
        return true;
    }
}
