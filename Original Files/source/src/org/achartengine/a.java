// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine;


// Referenced classes of package org.achartengine:
//            GraphicalView

class a
    implements Runnable
{

    final GraphicalView a;

    a(GraphicalView graphicalview)
    {
        a = graphicalview;
        super();
    }

    public void run()
    {
        a.invalidate();
    }
}
