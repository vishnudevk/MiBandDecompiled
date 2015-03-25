// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.event;


// Referenced classes of package de.greenrobot.event:
//            EventBus

public final class NoSubscriberEvent
{

    public final EventBus eventBus;
    public final Object originalEvent;

    public NoSubscriberEvent(EventBus eventbus, Object obj)
    {
        eventBus = eventbus;
        originalEvent = obj;
    }
}
