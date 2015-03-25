// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine;


// Referenced classes of package org.achartengine:
//            GraphicalView

class b
    implements Runnable
{

    final int a;
    final int b;
    final int c;
    final int d;
    final GraphicalView e;

    b(GraphicalView graphicalview, int i, int j, int k, int l)
    {
        e = graphicalview;
        a = i;
        b = j;
        c = k;
        d = l;
        super();
    }

    public void run()
    {
        e.invalidate(a, b, c, d);
    }
}
