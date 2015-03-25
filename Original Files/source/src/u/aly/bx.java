// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;


public class bx
{

    private short a[];
    private int b;

    public bx(int i)
    {
        b = -1;
        a = new short[i];
    }

    private void d()
    {
        short aword0[] = new short[2 * a.length];
        System.arraycopy(a, 0, aword0, 0, a.length);
        a = aword0;
    }

    public short a()
    {
        short aword0[] = a;
        int i = b;
        b = i - 1;
        return aword0[i];
    }

    public void a(short word0)
    {
        if (a.length == 1 + b)
        {
            d();
        }
        short aword0[] = a;
        int i = 1 + b;
        b = i;
        aword0[i] = word0;
    }

    public short b()
    {
        return a[b];
    }

    public void c()
    {
        b = -1;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("<ShortStack vector:[");
        int i = 0;
        do
        {
            if (i >= a.length)
            {
                stringbuilder.append("]>");
                return stringbuilder.toString();
            }
            if (i != 0)
            {
                stringbuilder.append(" ");
            }
            if (i == b)
            {
                stringbuilder.append(">>");
            }
            stringbuilder.append(a[i]);
            if (i == b)
            {
                stringbuilder.append("<<");
            }
            i++;
        } while (true);
    }
}
