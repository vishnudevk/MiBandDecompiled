// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.miui.analyticstracker;

import android.content.Context;

// Referenced classes of package com.xiaomi.miui.analyticstracker:
//            TrackEvent, LogEvent, TrackPageViewEvent

public interface Dispatchable
{

    public abstract void dispatchEvent(TrackEvent trackevent);

    public abstract void dispatchLog(LogEvent logevent);

    public abstract void dispatchPageView(TrackPageViewEvent trackpageviewevent);

    public abstract void start(Context context, String s);

    public abstract void stop();
}
