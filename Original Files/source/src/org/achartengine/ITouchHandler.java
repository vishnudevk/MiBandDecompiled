// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine;

import android.view.MotionEvent;
import org.achartengine.tools.PanListener;
import org.achartengine.tools.ZoomListener;

public interface ITouchHandler
{

    public abstract void addPanListener(PanListener panlistener);

    public abstract void addZoomListener(ZoomListener zoomlistener);

    public abstract boolean handleTouch(MotionEvent motionevent);

    public abstract void removePanListener(PanListener panlistener);

    public abstract void removeZoomListener(ZoomListener zoomlistener);
}
