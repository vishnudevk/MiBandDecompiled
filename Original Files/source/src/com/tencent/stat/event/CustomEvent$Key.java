// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.stat.event;

import java.util.Arrays;
import java.util.Properties;

public class c
{

    String a;
    String b[];
    Properties c;

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        c c1;
        boolean flag;
        if (!(obj instanceof c))
        {
            break MISSING_BLOCK_LABEL_94;
        }
        c1 = (c)obj;
        if (a.equals(c1.a) && Arrays.equals(b, c1.b))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (c == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (flag && c.equals(c1.c)) goto _L1; else goto _L3
_L3:
        return false;
        if (flag && c1.c == null) goto _L1; else goto _L4
_L4:
        return false;
        return false;
    }

    public int hashCode()
    {
        String s = a;
        int i = 0;
        if (s != null)
        {
            i = a.hashCode();
        }
        if (b != null)
        {
            i ^= Arrays.hashCode(b);
        }
        if (c != null)
        {
            i ^= c.hashCode();
        }
        return i;
    }

    public String toString()
    {
        String s = a;
        String s1 = "";
        if (b != null)
        {
            String s2 = b[0];
            for (int i = 1; i < b.length; i++)
            {
                s2 = (new StringBuilder()).append(s2).append(",").append(b[i]).toString();
            }

            s1 = (new StringBuilder()).append("[").append(s2).append("]").toString();
        }
        if (c != null)
        {
            s1 = (new StringBuilder()).append(s1).append(c.toString()).toString();
        }
        return (new StringBuilder()).append(s).append(s1).toString();
    }

    public ()
    {
        c = null;
    }
}
