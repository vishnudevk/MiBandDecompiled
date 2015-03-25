// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twotoasters.jazzylistview;

import android.view.View;
import com.nineoldandroids.view.ViewPropertyAnimator;

public interface JazzyEffect
{

    public abstract void initView(View view, int i, int j);

    public abstract void setupAnimation(View view, int i, int j, ViewPropertyAnimator viewpropertyanimator);
}
