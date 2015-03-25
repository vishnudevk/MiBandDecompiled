// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.animation;


// Referenced classes of package com.nineoldandroids.animation:
//            Keyframe

class i extends Keyframe
{

    int d;

    i(float f)
    {
        a = f;
        b = Integer.TYPE;
    }

    i(float f, int j)
    {
        a = f;
        d = j;
        b = Integer.TYPE;
        c = true;
    }

    public int a()
    {
        return d;
    }

    public i b()
    {
        i j = new i(getFraction(), d);
        j.setInterpolator(getInterpolator());
        return j;
    }

    public Keyframe clone()
    {
        return b();
    }

    public Object getValue()
    {
        return Integer.valueOf(d);
    }

    public void setValue(Object obj)
    {
        if (obj != null && obj.getClass() == java/lang/Integer)
        {
            d = ((Integer)obj).intValue();
            c = true;
        }
    }
}
