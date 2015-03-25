// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import java.lang.reflect.Type;

// Referenced classes of package com.google.gson.internal:
//            ObjectConstructor, ConstructorConstructor

class h
    implements ObjectConstructor
{

    final InstanceCreator a;
    final Type b;
    final ConstructorConstructor c;

    h(ConstructorConstructor constructorconstructor, InstanceCreator instancecreator, Type type)
    {
        c = constructorconstructor;
        a = instancecreator;
        b = type;
        super();
    }

    public Object construct()
    {
        return a.createInstance(b);
    }
}
