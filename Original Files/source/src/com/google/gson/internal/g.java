// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal;

import java.lang.reflect.Type;

// Referenced classes of package com.google.gson.internal:
//            ObjectConstructor, UnsafeAllocator, ConstructorConstructor

class g
    implements ObjectConstructor
{

    final Class a;
    final Type b;
    final ConstructorConstructor c;
    private final UnsafeAllocator d = UnsafeAllocator.create();

    g(ConstructorConstructor constructorconstructor, Class class1, Type type)
    {
        c = constructorconstructor;
        a = class1;
        b = type;
        super();
    }

    public Object construct()
    {
        Object obj;
        try
        {
            obj = d.newInstance(a);
        }
        catch (Exception exception)
        {
            throw new RuntimeException((new StringBuilder()).append("Unable to invoke no-args constructor for ").append(b).append(". ").append("Register an InstanceCreator with Gson for this type may fix this problem.").toString(), exception);
        }
        return obj;
    }
}
