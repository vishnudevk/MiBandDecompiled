// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.animation;

import android.util.Log;
import com.nineoldandroids.util.Property;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// Referenced classes of package com.nineoldandroids.animation:
//            IntEvaluator, FloatEvaluator, Keyframe, A, 
//            B, k, g, f, 
//            TypeEvaluator

public class PropertyValuesHolder
    implements Cloneable
{

    private static final TypeEvaluator h = new IntEvaluator();
    private static final TypeEvaluator i = new FloatEvaluator();
    private static Class j[];
    private static Class k[];
    private static Class l[];
    private static final HashMap m = new HashMap();
    private static final HashMap n = new HashMap();
    String a;
    Method b;
    Class c;
    k d;
    final ReentrantReadWriteLock e;
    final Object f[];
    private Method g;
    protected Property mProperty;
    private TypeEvaluator o;
    private Object p;

    private PropertyValuesHolder(Property property)
    {
        b = null;
        g = null;
        d = null;
        e = new ReentrantReadWriteLock();
        f = new Object[1];
        mProperty = property;
        if (property != null)
        {
            a = property.getName();
        }
    }

    PropertyValuesHolder(Property property, PropertyValuesHolder propertyvaluesholder)
    {
        this(property);
    }

    private PropertyValuesHolder(String s)
    {
        b = null;
        g = null;
        d = null;
        e = new ReentrantReadWriteLock();
        f = new Object[1];
        a = s;
    }

    PropertyValuesHolder(String s, PropertyValuesHolder propertyvaluesholder)
    {
        this(s);
    }

    static String a(String s, String s1)
    {
        if (s1 == null || s1.length() == 0)
        {
            return s;
        } else
        {
            char c1 = Character.toUpperCase(s1.charAt(0));
            String s2 = s1.substring(1);
            return (new StringBuilder(String.valueOf(s))).append(c1).append(s2).toString();
        }
    }

    private Method a(Class class1, String s, Class class2)
    {
        Method method;
        String s1;
        method = null;
        s1 = a(s, a);
        if (class2 != null) goto _L2; else goto _L1
_L1:
        Method method3 = class1.getMethod(s1, null);
        return method3;
        NoSuchMethodException nosuchmethodexception2;
        nosuchmethodexception2;
        Method method2 = class1.getDeclaredMethod(s1, null);
        Method method1 = method2;
        method1.setAccessible(true);
        return method1;
        NoSuchMethodException nosuchmethodexception4;
        nosuchmethodexception4;
_L6:
        Log.e("PropertyValuesHolder", (new StringBuilder("Couldn't find no-arg method for property ")).append(a).append(": ").append(nosuchmethodexception2).toString());
        return method1;
_L2:
        Class aclass[];
        Class aclass1[];
        int j1;
        aclass = new Class[1];
        int i1;
        if (c.equals(java/lang/Float))
        {
            aclass1 = j;
        } else
        if (c.equals(java/lang/Integer))
        {
            aclass1 = k;
        } else
        if (c.equals(java/lang/Double))
        {
            aclass1 = l;
        } else
        {
            aclass1 = new Class[1];
            aclass1[0] = c;
        }
        i1 = aclass1.length;
        j1 = 0;
_L4:
        Class class3;
        if (j1 >= i1)
        {
            Log.e("PropertyValuesHolder", (new StringBuilder("Couldn't find setter/getter for property ")).append(a).append(" with value type ").append(c).toString());
            return method;
        }
        class3 = aclass1[j1];
        aclass[0] = class3;
        method = class1.getMethod(s1, aclass);
        c = class3;
        return method;
        NoSuchMethodException nosuchmethodexception;
        nosuchmethodexception;
        method = class1.getDeclaredMethod(s1, aclass);
        method.setAccessible(true);
        c = class3;
        return method;
        NoSuchMethodException nosuchmethodexception1;
        nosuchmethodexception1;
        j1++;
        if (true) goto _L4; else goto _L3
_L3:
        NoSuchMethodException nosuchmethodexception3;
        nosuchmethodexception3;
        method1 = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private Method a(Class class1, HashMap hashmap, String s, Class class2)
    {
        HashMap hashmap1;
        e.writeLock().lock();
        hashmap1 = (HashMap)hashmap.get(class1);
        Method method;
        method = null;
        if (hashmap1 == null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        method = (Method)hashmap1.get(a);
        if (method != null) goto _L2; else goto _L1
_L1:
        Method method1 = a(class1, s, class2);
        if (hashmap1 != null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        hashmap1 = new HashMap();
        hashmap.put(class1, hashmap1);
        hashmap1.put(a, method1);
        Method method2 = method1;
_L4:
        e.writeLock().unlock();
        return method2;
        Exception exception;
        exception;
        e.writeLock().unlock();
        throw exception;
_L2:
        method2 = method;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void a(Object obj, Keyframe keyframe)
    {
        if (mProperty != null)
        {
            keyframe.setValue(mProperty.get(obj));
        }
        try
        {
            if (g == null)
            {
                b(obj.getClass());
            }
            keyframe.setValue(g.invoke(obj, new Object[0]));
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
    }

    private void b(Class class1)
    {
        g = a(class1, n, "get", null);
    }

    public static transient PropertyValuesHolder ofFloat(Property property, float af[])
    {
        return new A(property, af);
    }

    public static transient PropertyValuesHolder ofFloat(String s, float af[])
    {
        return new A(s, af);
    }

    public static transient PropertyValuesHolder ofInt(Property property, int ai[])
    {
        return new B(property, ai);
    }

    public static transient PropertyValuesHolder ofInt(String s, int ai[])
    {
        return new B(s, ai);
    }

    public static transient PropertyValuesHolder ofKeyframe(Property property, Keyframe akeyframe[])
    {
        k k1 = com.nineoldandroids.animation.k.a(akeyframe);
        if (k1 instanceof g)
        {
            return new B(property, (g)k1);
        }
        if (k1 instanceof f)
        {
            return new A(property, (f)k1);
        } else
        {
            PropertyValuesHolder propertyvaluesholder = new PropertyValuesHolder(property);
            propertyvaluesholder.d = k1;
            propertyvaluesholder.c = akeyframe[0].getType();
            return propertyvaluesholder;
        }
    }

    public static transient PropertyValuesHolder ofKeyframe(String s, Keyframe akeyframe[])
    {
        k k1 = com.nineoldandroids.animation.k.a(akeyframe);
        if (k1 instanceof g)
        {
            return new B(s, (g)k1);
        }
        if (k1 instanceof f)
        {
            return new A(s, (f)k1);
        } else
        {
            PropertyValuesHolder propertyvaluesholder = new PropertyValuesHolder(s);
            propertyvaluesholder.d = k1;
            propertyvaluesholder.c = akeyframe[0].getType();
            return propertyvaluesholder;
        }
    }

    public static transient PropertyValuesHolder ofObject(Property property, TypeEvaluator typeevaluator, Object aobj[])
    {
        PropertyValuesHolder propertyvaluesholder = new PropertyValuesHolder(property);
        propertyvaluesholder.setObjectValues(aobj);
        propertyvaluesholder.setEvaluator(typeevaluator);
        return propertyvaluesholder;
    }

    public static transient PropertyValuesHolder ofObject(String s, TypeEvaluator typeevaluator, Object aobj[])
    {
        PropertyValuesHolder propertyvaluesholder = new PropertyValuesHolder(s);
        propertyvaluesholder.setObjectValues(aobj);
        propertyvaluesholder.setEvaluator(typeevaluator);
        return propertyvaluesholder;
    }

    void a()
    {
        if (o == null)
        {
            TypeEvaluator typeevaluator;
            if (c == java/lang/Integer)
            {
                typeevaluator = h;
            } else
            if (c == java/lang/Float)
            {
                typeevaluator = i;
            } else
            {
                typeevaluator = null;
            }
            o = typeevaluator;
        }
        if (o != null)
        {
            d.a(o);
        }
    }

    void a(float f1)
    {
        p = d.a(f1);
    }

    void a(Class class1)
    {
        b = a(class1, m, "set", c);
    }

    void a(Object obj)
    {
        if (mProperty == null)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        Iterator iterator1;
        mProperty.get(obj);
        iterator1 = d.e.iterator();
_L2:
        if (!iterator1.hasNext())
        {
            return;
        }
        Keyframe keyframe1 = (Keyframe)iterator1.next();
        if (!keyframe1.hasValue())
        {
            keyframe1.setValue(mProperty.get(obj));
        }
        if (true) goto _L2; else goto _L1
_L1:
        ClassCastException classcastexception;
        classcastexception;
        Log.e("PropertyValuesHolder", (new StringBuilder("No such property (")).append(mProperty.getName()).append(") on target object ").append(obj).append(". Trying reflection instead").toString());
        mProperty = null;
        Class class1 = obj.getClass();
        if (b == null)
        {
            a(class1);
        }
        Iterator iterator = d.e.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Keyframe keyframe = (Keyframe)iterator.next();
            if (!keyframe.hasValue())
            {
                if (g == null)
                {
                    b(class1);
                }
                try
                {
                    keyframe.setValue(g.invoke(obj, new Object[0]));
                }
                catch (InvocationTargetException invocationtargetexception)
                {
                    Log.e("PropertyValuesHolder", invocationtargetexception.toString());
                }
                catch (IllegalAccessException illegalaccessexception)
                {
                    Log.e("PropertyValuesHolder", illegalaccessexception.toString());
                }
            }
        } while (true);
        return;
    }

    Object b()
    {
        return p;
    }

    void b(Object obj)
    {
        a(obj, (Keyframe)d.e.get(0));
    }

    void c(Object obj)
    {
        a(obj, (Keyframe)d.e.get(-1 + d.e.size()));
    }

    public PropertyValuesHolder clone()
    {
        PropertyValuesHolder propertyvaluesholder;
        try
        {
            propertyvaluesholder = (PropertyValuesHolder)super.clone();
            propertyvaluesholder.a = a;
            propertyvaluesholder.mProperty = mProperty;
            propertyvaluesholder.d = d.b();
            propertyvaluesholder.o = o;
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            return null;
        }
        return propertyvaluesholder;
    }

    public volatile Object clone()
    {
        return clone();
    }

    void d(Object obj)
    {
        if (mProperty != null)
        {
            mProperty.set(obj, b());
        }
        if (b == null)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        f[0] = b();
        b.invoke(obj, f);
        return;
        InvocationTargetException invocationtargetexception;
        invocationtargetexception;
        Log.e("PropertyValuesHolder", invocationtargetexception.toString());
        return;
        IllegalAccessException illegalaccessexception;
        illegalaccessexception;
        Log.e("PropertyValuesHolder", illegalaccessexception.toString());
        return;
    }

    public String getPropertyName()
    {
        return a;
    }

    public void setEvaluator(TypeEvaluator typeevaluator)
    {
        o = typeevaluator;
        d.a(typeevaluator);
    }

    public transient void setFloatValues(float af[])
    {
        c = Float.TYPE;
        d = com.nineoldandroids.animation.k.a(af);
    }

    public transient void setIntValues(int ai[])
    {
        c = Integer.TYPE;
        d = com.nineoldandroids.animation.k.a(ai);
    }

    public transient void setKeyframes(Keyframe akeyframe[])
    {
        int i1 = 0;
        int j1 = akeyframe.length;
        Keyframe akeyframe1[] = new Keyframe[Math.max(j1, 2)];
        c = akeyframe[0].getType();
        do
        {
            if (i1 >= j1)
            {
                d = new k(akeyframe1);
                return;
            }
            akeyframe1[i1] = akeyframe[i1];
            i1++;
        } while (true);
    }

    public transient void setObjectValues(Object aobj[])
    {
        c = aobj[0].getClass();
        d = com.nineoldandroids.animation.k.a(aobj);
    }

    public void setProperty(Property property)
    {
        mProperty = property;
    }

    public void setPropertyName(String s)
    {
        a = s;
    }

    public String toString()
    {
        return (new StringBuilder(String.valueOf(a))).append(": ").append(d.toString()).toString();
    }

    static 
    {
        Class aclass[] = new Class[6];
        aclass[0] = Float.TYPE;
        aclass[1] = java/lang/Float;
        aclass[2] = Double.TYPE;
        aclass[3] = Integer.TYPE;
        aclass[4] = java/lang/Double;
        aclass[5] = java/lang/Integer;
        j = aclass;
        Class aclass1[] = new Class[6];
        aclass1[0] = Integer.TYPE;
        aclass1[1] = java/lang/Integer;
        aclass1[2] = Float.TYPE;
        aclass1[3] = Double.TYPE;
        aclass1[4] = java/lang/Float;
        aclass1[5] = java/lang/Double;
        k = aclass1;
        Class aclass2[] = new Class[6];
        aclass2[0] = Double.TYPE;
        aclass2[1] = java/lang/Double;
        aclass2[2] = Float.TYPE;
        aclass2[3] = Integer.TYPE;
        aclass2[4] = java/lang/Float;
        aclass2[5] = java/lang/Integer;
        l = aclass2;
    }
}
