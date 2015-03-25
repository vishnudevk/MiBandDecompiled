// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.gson.internal:
//            p

public final class Excluder
    implements TypeAdapterFactory, Cloneable
{

    public static final Excluder DEFAULT = new Excluder();
    private static final double a = -1D;
    private double b;
    private int c;
    private boolean d;
    private boolean e;
    private List f;
    private List g;

    public Excluder()
    {
        b = -1D;
        c = 136;
        d = true;
        f = Collections.emptyList();
        g = Collections.emptyList();
    }

    private boolean a(Since since)
    {
        return since == null || since.value() <= b;
    }

    private boolean a(Since since, Until until)
    {
        return a(since) && a(until);
    }

    private boolean a(Until until)
    {
        return until == null || until.value() > b;
    }

    private boolean a(Class class1)
    {
        return !java/lang/Enum.isAssignableFrom(class1) && (class1.isAnonymousClass() || class1.isLocalClass());
    }

    private boolean b(Class class1)
    {
        return class1.isMemberClass() && !c(class1);
    }

    private boolean c(Class class1)
    {
        return (8 & class1.getModifiers()) != 0;
    }

    protected Excluder clone()
    {
        Excluder excluder;
        try
        {
            excluder = (Excluder)super.clone();
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            throw new AssertionError();
        }
        return excluder;
    }

    protected volatile Object clone()
    {
        return clone();
    }

    public TypeAdapter create(Gson gson, TypeToken typetoken)
    {
        Class class1 = typetoken.getRawType();
        boolean flag = excludeClass(class1, true);
        boolean flag1 = excludeClass(class1, false);
        if (!flag && !flag1)
        {
            return null;
        } else
        {
            return new p(this, flag1, flag, gson, typetoken);
        }
    }

    public Excluder disableInnerClassSerialization()
    {
        Excluder excluder = clone();
        excluder.d = false;
        return excluder;
    }

    public boolean excludeClass(Class class1, boolean flag)
    {
        if (b != -1D && !a((Since)class1.getAnnotation(com/google/gson/annotations/Since), (Until)class1.getAnnotation(com/google/gson/annotations/Until)))
        {
            return true;
        }
        if (!d && b(class1))
        {
            return true;
        }
        if (a(class1))
        {
            return true;
        }
        List list;
        Iterator iterator;
        if (flag)
        {
            list = f;
        } else
        {
            list = g;
        }
        for (iterator = list.iterator(); iterator.hasNext();)
        {
            if (((ExclusionStrategy)iterator.next()).shouldSkipClass(class1))
            {
                return true;
            }
        }

        return false;
    }

    public boolean excludeField(Field field, boolean flag)
    {
label0:
        {
            if ((c & field.getModifiers()) != 0)
            {
                return true;
            }
            if (b != -1D && !a((Since)field.getAnnotation(com/google/gson/annotations/Since), (Until)field.getAnnotation(com/google/gson/annotations/Until)))
            {
                return true;
            }
            if (field.isSynthetic())
            {
                return true;
            }
            if (e)
            {
                Expose expose = (Expose)field.getAnnotation(com/google/gson/annotations/Expose);
                if (expose == null || (flag ? !expose.serialize() : !expose.deserialize()))
                {
                    return true;
                }
            }
            if (!d && b(field.getType()))
            {
                return true;
            }
            if (a(field.getType()))
            {
                return true;
            }
            List list;
            FieldAttributes fieldattributes;
            Iterator iterator;
            if (flag)
            {
                list = f;
            } else
            {
                list = g;
            }
            if (list.isEmpty())
            {
                break label0;
            }
            fieldattributes = new FieldAttributes(field);
            iterator = list.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
            } while (!((ExclusionStrategy)iterator.next()).shouldSkipField(fieldattributes));
            return true;
        }
        return false;
    }

    public Excluder excludeFieldsWithoutExposeAnnotation()
    {
        Excluder excluder = clone();
        excluder.e = true;
        return excluder;
    }

    public Excluder withExclusionStrategy(ExclusionStrategy exclusionstrategy, boolean flag, boolean flag1)
    {
        Excluder excluder = clone();
        if (flag)
        {
            excluder.f = new ArrayList(f);
            excluder.f.add(exclusionstrategy);
        }
        if (flag1)
        {
            excluder.g = new ArrayList(g);
            excluder.g.add(exclusionstrategy);
        }
        return excluder;
    }

    public transient Excluder withModifiers(int ai[])
    {
        int i = 0;
        Excluder excluder = clone();
        excluder.c = 0;
        for (int j = ai.length; i < j; i++)
        {
            excluder.c = ai[i] | excluder.c;
        }

        return excluder;
    }

    public Excluder withVersion(double d1)
    {
        Excluder excluder = clone();
        excluder.b = d1;
        return excluder;
    }

}
