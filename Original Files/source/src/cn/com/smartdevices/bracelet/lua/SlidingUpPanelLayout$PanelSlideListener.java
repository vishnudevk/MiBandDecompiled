// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.lua;

import android.view.View;

public interface 
{

    public abstract int onGetPullDownDistance();

    public abstract Boolean onGetPullDownDockEnable();

    public abstract float onGetThreshhold();

    public abstract float onGetThreshhold2();

    public abstract void onLastSlideOffset(View view, float f);

    public abstract void onPanelAnchored(View view);

    public abstract void onPanelCollapsed(View view);

    public abstract void onPanelExpanded(View view);

    public abstract void onPanelSlide(View view, Boolean boolean1, float f);
}
