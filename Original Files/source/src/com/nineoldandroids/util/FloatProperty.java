// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.util;


// Referenced classes of package com.nineoldandroids.util:
//            Property

public abstract class FloatProperty extends Property
{

    public FloatProperty(String s)
    {
        super(java/lang/Float, s);
    }

    public final void set(Object obj, Float float1)
    {
        setValue(obj, float1.floatValue());
    }

    public volatile void set(Object obj, Object obj1)
    {
        set((Object)obj, (Float)obj1);
    }

    public abstract void setValue(Object obj, float f);
}
