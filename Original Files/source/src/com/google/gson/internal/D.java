// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal;


// Referenced classes of package com.google.gson.internal:
//            UnsafeAllocator

final class D extends UnsafeAllocator
{

    D()
    {
    }

    public Object newInstance(Class class1)
    {
        throw new UnsupportedOperationException((new StringBuilder()).append("Cannot allocate ").append(class1).toString());
    }
}
