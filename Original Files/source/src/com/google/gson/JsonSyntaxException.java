// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson;


// Referenced classes of package com.google.gson:
//            JsonParseException

public final class JsonSyntaxException extends JsonParseException
{

    private static final long serialVersionUID = 1L;

    public JsonSyntaxException(String s)
    {
        super(s);
    }

    public JsonSyntaxException(String s, Throwable throwable)
    {
        super(s, throwable);
    }

    public JsonSyntaxException(Throwable throwable)
    {
        super(throwable);
    }
}
