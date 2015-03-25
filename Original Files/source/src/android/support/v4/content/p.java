// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.content;

import android.os.Process;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package android.support.v4.content:
//            u, ModernAsyncTask

class p extends u
{

    final ModernAsyncTask a;

    p(ModernAsyncTask modernasynctask)
    {
        a = modernasynctask;
        super(null);
    }

    public Object call()
    {
        ModernAsyncTask.a(a).set(true);
        Process.setThreadPriority(10);
        return ModernAsyncTask.a(a, a.a(b));
    }
}
