// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.view.View;

public abstract class 
{

    public int clampViewPositionHorizontal(View view, int i, int j)
    {
        return 0;
    }

    public int clampViewPositionVertical(View view, int i, int j)
    {
        return 0;
    }

    public int getOrderedChildIndex(int i)
    {
        return i;
    }

    public int getViewHorizontalDragRange(View view)
    {
        return 0;
    }

    public int getViewVerticalDragRange(View view)
    {
        return 0;
    }

    public void onEdgeDragStarted(int i, int j)
    {
    }

    public boolean onEdgeLock(int i)
    {
        return false;
    }

    public void onEdgeTouched(int i, int j)
    {
    }

    public void onViewCaptured(View view, int i)
    {
    }

    public void onViewDragStateChanged(int i)
    {
    }

    public void onViewPositionChanged(View view, int i, int j, int k, int l)
    {
    }

    public void onViewReleased(View view, float f, float f1)
    {
    }

    public abstract boolean tryCaptureView(View view, int i);

    public ()
    {
    }
}
