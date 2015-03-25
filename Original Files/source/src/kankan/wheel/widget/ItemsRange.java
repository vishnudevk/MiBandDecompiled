// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kankan.wheel.widget;


public class ItemsRange
{

    private int a;
    private int b;

    public ItemsRange()
    {
        this(0, 0);
    }

    public ItemsRange(int i, int j)
    {
        a = i;
        b = j;
    }

    public boolean contains(int i)
    {
        return i >= getFirst() && i <= getLast();
    }

    public int getCount()
    {
        return b;
    }

    public int getFirst()
    {
        return a;
    }

    public int getLast()
    {
        return -1 + (getFirst() + getCount());
    }
}
