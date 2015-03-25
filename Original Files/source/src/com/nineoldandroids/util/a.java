// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Referenced classes of package com.nineoldandroids.util:
//            Property, NoSuchPropertyException

class a extends Property
{

    private static final String a = "get";
    private static final String b = "is";
    private static final String c = "set";
    private Method d;
    private Method e;
    private Field f;

    public a(Class class1, Class class2, String s)
    {
        Class class4;
        String s5;
        super(class2, s);
        char c1 = Character.toUpperCase(s.charAt(0));
        String s1 = s.substring(1);
        String s2 = (new StringBuilder(String.valueOf(c1))).append(s1).toString();
        String s3 = (new StringBuilder("get")).append(s2).toString();
        try
        {
            e = class1.getMethod(s3, null);
        }
        catch (NoSuchMethodException nosuchmethodexception)
        {
            try
            {
                e = class1.getDeclaredMethod(s3, null);
                e.setAccessible(true);
            }
            catch (NoSuchMethodException nosuchmethodexception1)
            {
                String s4 = (new StringBuilder("is")).append(s2).toString();
                try
                {
                    e = class1.getMethod(s4, null);
                }
                catch (NoSuchMethodException nosuchmethodexception2)
                {
                    try
                    {
                        e = class1.getDeclaredMethod(s4, null);
                        e.setAccessible(true);
                    }
                    catch (NoSuchMethodException nosuchmethodexception3)
                    {
                        try
                        {
                            f = class1.getField(s);
                            Class class3 = f.getType();
                            if (!a(class2, class3))
                            {
                                throw new NoSuchPropertyException((new StringBuilder("Underlying type (")).append(class3).append(") ").append("does not match Property type (").append(class2).append(")").toString());
                            }
                        }
                        catch (NoSuchFieldException nosuchfieldexception)
                        {
                            throw new NoSuchPropertyException((new StringBuilder("No accessor method or field found for property with name ")).append(s).toString());
                        }
                        break MISSING_BLOCK_LABEL_367;
                    }
                }
            }
        }
        class4 = e.getReturnType();
        if (!a(class2, class4))
        {
            throw new NoSuchPropertyException((new StringBuilder("Underlying type (")).append(class4).append(") ").append("does not match Property type (").append(class2).append(")").toString());
        }
        s5 = (new StringBuilder("set")).append(s2).toString();
        d = class1.getDeclaredMethod(s5, new Class[] {
            class4
        });
        d.setAccessible(true);
        return;
        NoSuchMethodException nosuchmethodexception4;
        nosuchmethodexception4;
    }

    private boolean a(Class class1, Class class2)
    {
        if (class2 != class1)
        {
            return class2.isPrimitive() && (class2 == Float.TYPE && class1 == java/lang/Float || class2 == Integer.TYPE && class1 == java/lang/Integer || class2 == Boolean.TYPE && class1 == java/lang/Boolean || class2 == Long.TYPE && class1 == java/lang/Long || class2 == Double.TYPE && class1 == java/lang/Double || class2 == Short.TYPE && class1 == java/lang/Short || class2 == Byte.TYPE && class1 == java/lang/Byte || class2 == Character.TYPE && class1 == java/lang/Character);
        } else
        {
            return true;
        }
    }

    public Object get(Object obj)
    {
        if (e != null)
        {
            Object obj2;
            try
            {
                obj2 = e.invoke(obj, null);
            }
            catch (IllegalAccessException illegalaccessexception1)
            {
                throw new AssertionError();
            }
            catch (InvocationTargetException invocationtargetexception)
            {
                throw new RuntimeException(invocationtargetexception.getCause());
            }
            return obj2;
        }
        if (f != null)
        {
            Object obj1;
            try
            {
                obj1 = f.get(obj);
            }
            catch (IllegalAccessException illegalaccessexception)
            {
                throw new AssertionError();
            }
            return obj1;
        } else
        {
            throw new AssertionError();
        }
    }

    public boolean isReadOnly()
    {
        return d == null && f == null;
    }

    public void set(Object obj, Object obj1)
    {
        if (d != null)
        {
            try
            {
                d.invoke(obj, new Object[] {
                    obj1
                });
                return;
            }
            catch (IllegalAccessException illegalaccessexception1)
            {
                throw new AssertionError();
            }
            catch (InvocationTargetException invocationtargetexception)
            {
                throw new RuntimeException(invocationtargetexception.getCause());
            }
        }
        if (f != null)
        {
            try
            {
                f.set(obj, obj1);
                return;
            }
            catch (IllegalAccessException illegalaccessexception)
            {
                throw new AssertionError();
            }
        } else
        {
            throw new UnsupportedOperationException((new StringBuilder("Property ")).append(getName()).append(" is read-only").toString());
        }
    }
}
