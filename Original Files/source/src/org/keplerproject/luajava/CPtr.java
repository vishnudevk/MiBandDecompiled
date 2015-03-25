// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.keplerproject.luajava;


public class CPtr
{

    private long peer;

    CPtr()
    {
    }

    public boolean equals(Object obj)
    {
        boolean flag = true;
        if (obj != null)
        {
            if (obj == this)
            {
                return flag;
            }
            if (org/keplerproject/luajava/CPtr == obj.getClass())
            {
                if (peer != ((CPtr)obj).peer)
                {
                    flag = false;
                }
                return flag;
            }
        }
        return false;
    }

    protected long getPeer()
    {
        return peer;
    }
}
