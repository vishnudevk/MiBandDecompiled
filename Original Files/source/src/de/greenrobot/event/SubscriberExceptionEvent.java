// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.event;


// Referenced classes of package de.greenrobot.event:
//            EventBus

public final class SubscriberExceptionEvent
{

    public final Object causingEvent;
    public final Object causingSubscriber;
    public final EventBus eventBus;
    public final Throwable throwable;

    public SubscriberExceptionEvent(EventBus eventbus, Throwable throwable1, Object obj, Object obj1)
    {
        eventBus = eventbus;
        throwable = throwable1;
        causingEvent = obj;
        causingSubscriber = obj1;
    }
}
