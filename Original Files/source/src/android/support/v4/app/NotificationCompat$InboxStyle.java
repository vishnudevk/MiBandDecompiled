// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import java.util.ArrayList;

public class setBuilder extends setBuilder
{

    ArrayList a;

    public setBuilder addLine(CharSequence charsequence)
    {
        a.add(charsequence);
        return this;
    }

    public a setBigContentTitle(CharSequence charsequence)
    {
        e = charsequence;
        return this;
    }

    public e setSummaryText(CharSequence charsequence)
    {
        f = charsequence;
        g = true;
        return this;
    }

    public ()
    {
        a = new ArrayList();
    }

    public a(a a1)
    {
        a = new ArrayList();
        setBuilder(a1);
    }
}
