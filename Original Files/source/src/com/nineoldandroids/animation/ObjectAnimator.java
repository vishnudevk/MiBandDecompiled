// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.animation;

import android.view.View;
import com.nineoldandroids.util.Property;
import com.nineoldandroids.view.animation.AnimatorProxy;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.nineoldandroids.animation:
//            ValueAnimator, l, PropertyValuesHolder, TypeEvaluator

public final class ObjectAnimator extends ValueAnimator
{

    private static final boolean m;
    private static final Map n;
    private Object o;
    private String p;
    private Property q;

    public ObjectAnimator()
    {
    }

    private ObjectAnimator(Object obj, Property property)
    {
        o = obj;
        setProperty(property);
    }

    private ObjectAnimator(Object obj, String s)
    {
        o = obj;
        setPropertyName(s);
    }

    public static transient ObjectAnimator ofFloat(Object obj, Property property, float af[])
    {
        ObjectAnimator objectanimator = new ObjectAnimator(obj, property);
        objectanimator.setFloatValues(af);
        return objectanimator;
    }

    public static transient ObjectAnimator ofFloat(Object obj, String s, float af[])
    {
        ObjectAnimator objectanimator = new ObjectAnimator(obj, s);
        objectanimator.setFloatValues(af);
        return objectanimator;
    }

    public static transient ObjectAnimator ofInt(Object obj, Property property, int ai[])
    {
        ObjectAnimator objectanimator = new ObjectAnimator(obj, property);
        objectanimator.setIntValues(ai);
        return objectanimator;
    }

    public static transient ObjectAnimator ofInt(Object obj, String s, int ai[])
    {
        ObjectAnimator objectanimator = new ObjectAnimator(obj, s);
        objectanimator.setIntValues(ai);
        return objectanimator;
    }

    public static transient ObjectAnimator ofObject(Object obj, Property property, TypeEvaluator typeevaluator, Object aobj[])
    {
        ObjectAnimator objectanimator = new ObjectAnimator(obj, property);
        objectanimator.setObjectValues(aobj);
        objectanimator.setEvaluator(typeevaluator);
        return objectanimator;
    }

    public static transient ObjectAnimator ofObject(Object obj, String s, TypeEvaluator typeevaluator, Object aobj[])
    {
        ObjectAnimator objectanimator = new ObjectAnimator(obj, s);
        objectanimator.setObjectValues(aobj);
        objectanimator.setEvaluator(typeevaluator);
        return objectanimator;
    }

    public static transient ObjectAnimator ofPropertyValuesHolder(Object obj, PropertyValuesHolder apropertyvaluesholder[])
    {
        ObjectAnimator objectanimator = new ObjectAnimator();
        objectanimator.o = obj;
        objectanimator.setValues(apropertyvaluesholder);
        return objectanimator;
    }

    void a()
    {
        if (this.j) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        if (q == null && AnimatorProxy.NEEDS_PROXY && (o instanceof View) && n.containsKey(p))
        {
            setProperty((Property)n.get(p));
        }
        i = k.length;
        j = 0;
_L6:
        if (j < i) goto _L4; else goto _L3
_L3:
        super.a();
_L2:
        return;
_L4:
        k[j].a(o);
        j++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    void a(float f)
    {
        super.a(f);
        int i = k.length;
        int j = 0;
        do
        {
            if (j >= i)
            {
                return;
            }
            k[j].d(o);
            j++;
        } while (true);
    }

    public ObjectAnimator clone()
    {
        return (ObjectAnimator)super.clone();
    }

    public volatile ValueAnimator clone()
    {
        return clone();
    }

    public String getPropertyName()
    {
        return p;
    }

    public Object getTarget()
    {
        return o;
    }

    public ObjectAnimator setDuration(long l1)
    {
        super.setDuration(l1);
        return this;
    }

    public volatile ValueAnimator setDuration(long l1)
    {
        return setDuration(l1);
    }

    public transient void setFloatValues(float af[])
    {
        if (k == null || k.length == 0)
        {
            if (q != null)
            {
                PropertyValuesHolder apropertyvaluesholder1[] = new PropertyValuesHolder[1];
                apropertyvaluesholder1[0] = PropertyValuesHolder.ofFloat(q, af);
                setValues(apropertyvaluesholder1);
                return;
            } else
            {
                PropertyValuesHolder apropertyvaluesholder[] = new PropertyValuesHolder[1];
                apropertyvaluesholder[0] = PropertyValuesHolder.ofFloat(p, af);
                setValues(apropertyvaluesholder);
                return;
            }
        } else
        {
            super.setFloatValues(af);
            return;
        }
    }

    public transient void setIntValues(int ai[])
    {
        if (k == null || k.length == 0)
        {
            if (q != null)
            {
                PropertyValuesHolder apropertyvaluesholder1[] = new PropertyValuesHolder[1];
                apropertyvaluesholder1[0] = PropertyValuesHolder.ofInt(q, ai);
                setValues(apropertyvaluesholder1);
                return;
            } else
            {
                PropertyValuesHolder apropertyvaluesholder[] = new PropertyValuesHolder[1];
                apropertyvaluesholder[0] = PropertyValuesHolder.ofInt(p, ai);
                setValues(apropertyvaluesholder);
                return;
            }
        } else
        {
            super.setIntValues(ai);
            return;
        }
    }

    public transient void setObjectValues(Object aobj[])
    {
        if (k == null || k.length == 0)
        {
            if (q != null)
            {
                PropertyValuesHolder apropertyvaluesholder1[] = new PropertyValuesHolder[1];
                apropertyvaluesholder1[0] = PropertyValuesHolder.ofObject(q, null, aobj);
                setValues(apropertyvaluesholder1);
                return;
            } else
            {
                PropertyValuesHolder apropertyvaluesholder[] = new PropertyValuesHolder[1];
                apropertyvaluesholder[0] = PropertyValuesHolder.ofObject(p, null, aobj);
                setValues(apropertyvaluesholder);
                return;
            }
        } else
        {
            super.setObjectValues(aobj);
            return;
        }
    }

    public void setProperty(Property property)
    {
        if (k != null)
        {
            PropertyValuesHolder propertyvaluesholder = k[0];
            String s = propertyvaluesholder.getPropertyName();
            propertyvaluesholder.setProperty(property);
            l.remove(s);
            l.put(p, propertyvaluesholder);
        }
        if (q != null)
        {
            p = property.getName();
        }
        q = property;
        j = false;
    }

    public void setPropertyName(String s)
    {
        if (k != null)
        {
            PropertyValuesHolder propertyvaluesholder = k[0];
            String s1 = propertyvaluesholder.getPropertyName();
            propertyvaluesholder.setPropertyName(s);
            l.remove(s1);
            l.put(s, propertyvaluesholder);
        }
        p = s;
        j = false;
    }

    public void setTarget(Object obj)
    {
label0:
        {
            if (o != obj)
            {
                Object obj1 = o;
                o = obj;
                if (obj1 == null || obj == null || obj1.getClass() != obj.getClass())
                {
                    break label0;
                }
            }
            return;
        }
        j = false;
    }

    public void setupEndValues()
    {
        a();
        int i = k.length;
        int j = 0;
        do
        {
            if (j >= i)
            {
                return;
            }
            k[j].c(o);
            j++;
        } while (true);
    }

    public void setupStartValues()
    {
        a();
        int i = k.length;
        int j = 0;
        do
        {
            if (j >= i)
            {
                return;
            }
            k[j].b(o);
            j++;
        } while (true);
    }

    public void start()
    {
        super.start();
    }

    public String toString()
    {
        String s = (new StringBuilder("ObjectAnimator@")).append(Integer.toHexString(hashCode())).append(", target ").append(o).toString();
        if (k == null) goto _L2; else goto _L1
_L1:
        int i = 0;
_L5:
        if (i < k.length) goto _L3; else goto _L2
_L2:
        return s;
_L3:
        s = (new StringBuilder(String.valueOf(s))).append("\n    ").append(k[i].toString()).toString();
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    static 
    {
        n = new HashMap();
        n.put("alpha", l.a);
        n.put("pivotX", l.b);
        n.put("pivotY", l.c);
        n.put("translationX", l.d);
        n.put("translationY", l.e);
        n.put("rotation", l.f);
        n.put("rotationX", l.g);
        n.put("rotationY", l.h);
        n.put("scaleX", l.i);
        n.put("scaleY", l.j);
        n.put("scrollX", l.k);
        n.put("scrollY", l.l);
        n.put("x", l.m);
        n.put("y", l.n);
    }
}
