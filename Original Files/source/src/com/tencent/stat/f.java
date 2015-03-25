// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.event.ErrorEvent;

// Referenced classes of package com.tencent.stat:
//            StatConfig, StatStore, StatService

final class f
    implements Thread.UncaughtExceptionHandler
{

    final Context a;

    f(Context context)
    {
        a = context;
        super();
    }

    public void uncaughtException(Thread thread, Throwable throwable)
    {
        if (!StatConfig.isEnableStatService())
        {
            return;
        }
        StatStore.getInstance(a).b(new ErrorEvent(a, StatService.a(a, false), 2, throwable), null);
        StatService.b().debug("MTA has caught the following uncaught exception:");
        StatService.b().error(throwable);
        if (StatService.c() != null)
        {
            StatService.b().debug("Call the original uncaught exception handler.");
            StatService.c().uncaughtException(thread, throwable);
            return;
        } else
        {
            StatService.b().debug("Original uncaught exception handler not set.");
            return;
        }
    }
}
