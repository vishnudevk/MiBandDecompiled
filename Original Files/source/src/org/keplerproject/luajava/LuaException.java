// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.keplerproject.luajava;


public class LuaException extends Exception
{

    private static final long serialVersionUID = 1L;

    public LuaException(Exception exception)
    {
        if (exception.getCause() != null)
        {
            exception = exception.getCause();
        }
        super(exception);
    }

    public LuaException(String s)
    {
        super(s);
    }
}
