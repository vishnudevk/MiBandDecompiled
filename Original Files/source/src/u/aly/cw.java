// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;


public final class cw
{

    public final String a;
    public final byte b;
    public final int c;

    public cw()
    {
        this("", (byte)0, 0);
    }

    public cw(String s, byte byte0, int i)
    {
        a = s;
        b = byte0;
        c = i;
    }

    public boolean a(cw cw1)
    {
        return a.equals(cw1.a) && b == cw1.b && c == cw1.c;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof cw)
        {
            return a((cw)obj);
        } else
        {
            return false;
        }
    }

    public String toString()
    {
        return (new StringBuilder("<TMessage name:'")).append(a).append("' type: ").append(b).append(" seqid:").append(c).append(">").toString();
    }
}
