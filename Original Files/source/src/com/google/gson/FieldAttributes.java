// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

public final class FieldAttributes
{

    private final Field a;

    public FieldAttributes(Field field)
    {
        com.google.gson.internal..Gson.Preconditions.checkNotNull(field);
        a = field;
    }

    Object a(Object obj)
    {
        return a.get(obj);
    }

    boolean a()
    {
        return a.isSynthetic();
    }

    public Annotation getAnnotation(Class class1)
    {
        return a.getAnnotation(class1);
    }

    public Collection getAnnotations()
    {
        return Arrays.asList(a.getAnnotations());
    }

    public Class getDeclaredClass()
    {
        return a.getType();
    }

    public Type getDeclaredType()
    {
        return a.getGenericType();
    }

    public Class getDeclaringClass()
    {
        return a.getDeclaringClass();
    }

    public String getName()
    {
        return a.getName();
    }

    public boolean hasModifier(int i)
    {
        return (i & a.getModifiers()) != 0;
    }
}
