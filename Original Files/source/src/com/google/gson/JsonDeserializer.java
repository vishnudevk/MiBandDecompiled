// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson;

import java.lang.reflect.Type;

// Referenced classes of package com.google.gson:
//            JsonElement, JsonDeserializationContext

public interface JsonDeserializer
{

    public abstract Object deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext);
}
