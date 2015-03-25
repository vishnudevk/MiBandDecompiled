// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.a.a;

import java.io.File;
import java.util.Comparator;

// Referenced classes of package com.tencent.a.a:
//            h

class k
    implements Comparator
{

    final h a;

    k(h h1)
    {
        a = h1;
        super();
    }

    public int a(File file, File file1)
    {
        return h.d(file) - h.d(file1);
    }

    public int compare(Object obj, Object obj1)
    {
        return a((File)obj, (File)obj1);
    }
}
