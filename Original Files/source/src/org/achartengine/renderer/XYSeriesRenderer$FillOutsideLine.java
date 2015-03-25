// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine.renderer;

import android.graphics.Color;
import java.io.Serializable;

public class a
    implements Serializable
{

    private final Type a;
    private int b;
    private int c[];

    public int getColor()
    {
        return b;
    }

    public int[] getFillRange()
    {
        return c;
    }

    public Type getType()
    {
        return a;
    }

    public void setColor(int i)
    {
        b = i;
    }

    public void setFillRange(int ai[])
    {
        c = ai;
    }

    public Type(Type type)
    {
        b = Color.argb(125, 0, 0, 200);
        a = type;
    }
}
