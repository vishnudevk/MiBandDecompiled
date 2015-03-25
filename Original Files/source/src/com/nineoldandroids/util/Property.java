// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.util;


// Referenced classes of package com.nineoldandroids.util:
//            a

public abstract class Property
{

    private final String a;
    private final Class b;

    public Property(Class class1, String s)
    {
        a = s;
        b = class1;
    }

    public static Property of(Class class1, Class class2, String s)
    {
        return new a(class1, class2, s);
    }

    public abstract Object get(Object obj);

    public String getName()
    {
        return a;
    }

    public Class getType()
    {
        return b;
    }

    public boolean isReadOnly()
    {
        return false;
    }

    public void set(Object obj, Object obj1)
    {
        throw new UnsupportedOperationException((new StringBuilder("Property ")).append(getName()).append(" is read-only").toString());
    }
}
