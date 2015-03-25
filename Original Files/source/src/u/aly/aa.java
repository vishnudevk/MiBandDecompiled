// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.io.Serializable;
import java.util.Map;

public class aa
    implements Serializable
{

    private static final long e = 1L;
    public long a;
    public String b;
    public String c;
    public Map d;

    public aa()
    {
        a = System.currentTimeMillis();
    }

    public String a()
    {
        return (new StringBuilder(String.valueOf(b))).append(c).toString();
    }
}
