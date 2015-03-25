// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.model;


public interface GalaxyMarshaller
{

    public abstract String marshall(Object obj);

    public abstract Object unmarshall(Class class1, String s);
}
