// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.a.a;

import java.io.File;
import java.io.FileFilter;

// Referenced classes of package com.tencent.a.a:
//            h

class j
    implements FileFilter
{

    final h a;

    j(h h1)
    {
        a = h1;
        super();
    }

    public boolean accept(File file)
    {
        while (!file.getName().endsWith(a.j()) || h.d(file) == -1) 
        {
            return false;
        }
        return true;
    }
}
