// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.animation;

import android.util.Log;
import com.nineoldandroids.util.FloatProperty;
import com.nineoldandroids.util.Property;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Referenced classes of package com.nineoldandroids.animation:
//            PropertyValuesHolder, f

class A extends PropertyValuesHolder
{

    f g;
    float h;
    private FloatProperty i;

    public A(Property property, f f1)
    {
        super(property, null);
        c = Float.TYPE;
        d = f1;
        g = (f)d;
        if (property instanceof FloatProperty)
        {
            i = (FloatProperty)mProperty;
        }
    }

    public transient A(Property property, float af[])
    {
        super(property, null);
        setFloatValues(af);
        if (property instanceof FloatProperty)
        {
            i = (FloatProperty)mProperty;
        }
    }

    public A(String s, f f1)
    {
        super(s, null);
        c = Float.TYPE;
        d = f1;
        g = (f)d;
    }

    public transient A(String s, float af[])
    {
        super(s, null);
        setFloatValues(af);
    }

    void a(float f1)
    {
        h = g.b(f1);
    }

    void a(Class class1)
    {
        if (mProperty != null)
        {
            return;
        } else
        {
            super.a(class1);
            return;
        }
    }

    Object b()
    {
        return Float.valueOf(h);
    }

    public A c()
    {
        A a1 = (A)super.clone();
        a1.g = (f)a1.d;
        return a1;
    }

    public PropertyValuesHolder clone()
    {
        return c();
    }

    void d(Object obj)
    {
        if (i != null)
        {
            i.setValue(obj, h);
        } else
        {
            if (mProperty != null)
            {
                mProperty.set(obj, Float.valueOf(h));
                return;
            }
            if (b != null)
            {
                try
                {
                    f[0] = Float.valueOf(h);
                    b.invoke(obj, f);
                    return;
                }
                catch (InvocationTargetException invocationtargetexception)
                {
                    Log.e("PropertyValuesHolder", invocationtargetexception.toString());
                    return;
                }
                catch (IllegalAccessException illegalaccessexception)
                {
                    Log.e("PropertyValuesHolder", illegalaccessexception.toString());
                }
                return;
            }
        }
    }

    public transient void setFloatValues(float af[])
    {
        super.setFloatValues(af);
        g = (f)d;
    }
}
