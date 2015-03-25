// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.event;


public class EventBusException extends RuntimeException
{

    private static final long serialVersionUID = 0xd79482abcae9c669L;

    public EventBusException(String s)
    {
        super(s);
    }

    public EventBusException(String s, Throwable throwable)
    {
        super(s, throwable);
    }

    public EventBusException(Throwable throwable)
    {
        super(throwable);
    }
}
