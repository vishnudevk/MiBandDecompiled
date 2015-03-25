// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine.tools;


// Referenced classes of package org.achartengine.tools:
//            ZoomEvent

public interface ZoomListener
{

    public abstract void zoomApplied(ZoomEvent zoomevent);

    public abstract void zoomReset();
}
