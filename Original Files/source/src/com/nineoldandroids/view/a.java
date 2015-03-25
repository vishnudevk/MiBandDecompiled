// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.view;

import android.view.View;

final class a
{

    private a()
    {
    }

    static float a(View view)
    {
        return view.getAlpha();
    }

    static void a(View view, float f1)
    {
        view.setAlpha(f1);
    }

    static void a(View view, int i1)
    {
        view.setScrollX(i1);
    }

    static float b(View view)
    {
        return view.getPivotX();
    }

    static void b(View view, float f1)
    {
        view.setPivotX(f1);
    }

    static void b(View view, int i1)
    {
        view.setScrollY(i1);
    }

    static float c(View view)
    {
        return view.getPivotY();
    }

    static void c(View view, float f1)
    {
        view.setPivotY(f1);
    }

    static float d(View view)
    {
        return view.getRotation();
    }

    static void d(View view, float f1)
    {
        view.setRotation(f1);
    }

    static float e(View view)
    {
        return view.getRotationX();
    }

    static void e(View view, float f1)
    {
        view.setRotationX(f1);
    }

    static float f(View view)
    {
        return view.getRotationY();
    }

    static void f(View view, float f1)
    {
        view.setRotationY(f1);
    }

    static float g(View view)
    {
        return view.getScaleX();
    }

    static void g(View view, float f1)
    {
        view.setScaleX(f1);
    }

    static float h(View view)
    {
        return view.getScaleY();
    }

    static void h(View view, float f1)
    {
        view.setScaleY(f1);
    }

    static float i(View view)
    {
        return (float)view.getScrollX();
    }

    static void i(View view, float f1)
    {
        view.setTranslationX(f1);
    }

    static float j(View view)
    {
        return (float)view.getScrollY();
    }

    static void j(View view, float f1)
    {
        view.setTranslationY(f1);
    }

    static float k(View view)
    {
        return view.getTranslationX();
    }

    static void k(View view, float f1)
    {
        view.setX(f1);
    }

    static float l(View view)
    {
        return view.getTranslationY();
    }

    static void l(View view, float f1)
    {
        view.setY(f1);
    }

    static float m(View view)
    {
        return view.getX();
    }

    static float n(View view)
    {
        return view.getY();
    }
}
