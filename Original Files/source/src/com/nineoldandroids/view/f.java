// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.view;

import java.util.ArrayList;

// Referenced classes of package com.nineoldandroids.view:
//            e

class f
{

    int a;
    ArrayList b;

    f(int i, ArrayList arraylist)
    {
        a = i;
        b = arraylist;
    }

    boolean a(int i)
    {
        if ((i & a) == 0 || b == null) goto _L2; else goto _L1
_L1:
        int j;
        int k;
        j = b.size();
        k = 0;
_L5:
        if (k < j) goto _L3; else goto _L2
_L2:
        return false;
_L3:
        if (((e)b.get(k)).a == i)
        {
            b.remove(k);
            a = a & ~i;
            return true;
        }
        k++;
        if (true) goto _L5; else goto _L4
_L4:
    }
}
