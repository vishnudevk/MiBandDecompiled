// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.util;


// Referenced classes of package com.nineoldandroids.util:
//            Property

public abstract class IntProperty extends Property
{

    public IntProperty(String s)
    {
        super(java/lang/Integer, s);
    }

    public final void set(Object obj, Integer integer)
    {
        set(obj, Integer.valueOf(integer.intValue()));
    }

    public volatile void set(Object obj, Object obj1)
    {
        set((Object)obj, (Integer)obj1);
    }

    public abstract void setValue(Object obj, int i);
}
