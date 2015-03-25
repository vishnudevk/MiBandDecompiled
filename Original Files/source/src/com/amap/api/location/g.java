// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amap.api.location;


// Referenced classes of package com.amap.api.location:
//            AMapLocationListener

public class g
{

    long a;
    public AMapLocationListener b;
    Boolean c;

    public g(long l, float f, AMapLocationListener amaplocationlistener, String s, boolean flag)
    {
        a = l;
        b = amaplocationlistener;
        c = Boolean.valueOf(flag);
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        g g1;
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        g1 = (g)obj;
        if (b != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (g1.b == null) goto _L1; else goto _L3
_L3:
        return false;
        if (b.equals(g1.b)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public int hashCode()
    {
        int i;
        if (b == null)
        {
            i = 0;
        } else
        {
            i = b.hashCode();
        }
        return i + 31;
    }
}
