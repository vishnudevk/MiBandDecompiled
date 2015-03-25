// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.b.b;

import android.net.wifi.ScanResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.tencent.b.b:
//            f

public final class ext
    implements Cloneable
{

    private List a;

    public final List a()
    {
        return a;
    }

    public final Object clone()
    {
         ;
        try
        {
             = ()super.clone();
        }
        catch (Exception exception)
        {
             = null;
        }
        if (a != null)
        {
            .a = new ArrayList();
            .a.addAll(a);
        }
        return ;
    }

    public nResult(f f, List list, long l, int i)
    {
        a = null;
        if (list != null)
        {
            a = new ArrayList();
            ScanResult scanresult;
            for (Iterator iterator = list.iterator(); iterator.hasNext(); a.add(scanresult))
            {
                scanresult = (ScanResult)iterator.next();
            }

        }
    }
}
