// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

final class H
    implements TypeAdapterFactory
{

    final TypeToken a;
    final TypeAdapter b;

    H(TypeToken typetoken, TypeAdapter typeadapter)
    {
        a = typetoken;
        b = typeadapter;
        super();
    }

    public TypeAdapter create(Gson gson, TypeToken typetoken)
    {
        if (typetoken.equals(a))
        {
            return b;
        } else
        {
            return null;
        }
    }
}
