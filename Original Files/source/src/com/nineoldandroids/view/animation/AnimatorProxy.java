// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.view.animation;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class AnimatorProxy extends Animation
{

    public static final boolean NEEDS_PROXY;
    private static final WeakHashMap a = new WeakHashMap();
    private final WeakReference b;
    private final Camera c = new Camera();
    private boolean d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private float l;
    private float m;
    private float n;
    private final RectF o = new RectF();
    private final RectF p = new RectF();
    private final Matrix q = new Matrix();

    private AnimatorProxy(View view)
    {
        e = 1.0F;
        k = 1.0F;
        l = 1.0F;
        setDuration(0L);
        setFillAfter(true);
        view.setAnimation(this);
        b = new WeakReference(view);
    }

    private void a()
    {
        View view = (View)b.get();
        if (view != null)
        {
            a(o, view);
        }
    }

    private void a(Matrix matrix, View view)
    {
        float f1 = view.getWidth();
        float f2 = view.getHeight();
        boolean flag = d;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        if (flag)
        {
            f3 = f;
        } else
        {
            f3 = f1 / 2.0F;
        }
        if (flag)
        {
            f4 = g;
        } else
        {
            f4 = f2 / 2.0F;
        }
        f5 = h;
        f6 = i;
        f7 = j;
        if (f5 != 0.0F || f6 != 0.0F || f7 != 0.0F)
        {
            Camera camera = c;
            camera.save();
            camera.rotateX(f5);
            camera.rotateY(f6);
            camera.rotateZ(-f7);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-f3, -f4);
            matrix.postTranslate(f3, f4);
        }
        f8 = k;
        f9 = l;
        if (f8 != 1.0F || f9 != 1.0F)
        {
            matrix.postScale(f8, f9);
            matrix.postTranslate(-(f3 / f1) * (f8 * f1 - f1), -(f4 / f2) * (f9 * f2 - f2));
        }
        matrix.postTranslate(m, n);
    }

    private void a(RectF rectf, View view)
    {
        rectf.set(0.0F, 0.0F, view.getWidth(), view.getHeight());
        Matrix matrix = q;
        matrix.reset();
        a(matrix, view);
        q.mapRect(rectf);
        rectf.offset(view.getLeft(), view.getTop());
        if (rectf.right < rectf.left)
        {
            float f2 = rectf.right;
            rectf.right = rectf.left;
            rectf.left = f2;
        }
        if (rectf.bottom < rectf.top)
        {
            float f1 = rectf.top;
            rectf.top = rectf.bottom;
            rectf.bottom = f1;
        }
    }

    private void b()
    {
        View view = (View)b.get();
        if (view == null || view.getParent() == null)
        {
            return;
        } else
        {
            RectF rectf = p;
            a(rectf, view);
            rectf.union(o);
            ((View)view.getParent()).invalidate((int)Math.floor(rectf.left), (int)Math.floor(rectf.top), (int)Math.ceil(rectf.right), (int)Math.ceil(rectf.bottom));
            return;
        }
    }

    public static AnimatorProxy wrap(View view)
    {
        AnimatorProxy animatorproxy = (AnimatorProxy)a.get(view);
        if (animatorproxy == null || animatorproxy != view.getAnimation())
        {
            animatorproxy = new AnimatorProxy(view);
            a.put(view, animatorproxy);
        }
        return animatorproxy;
    }

    protected void applyTransformation(float f1, Transformation transformation)
    {
        View view = (View)b.get();
        if (view != null)
        {
            transformation.setAlpha(e);
            a(transformation.getMatrix(), view);
        }
    }

    public float getAlpha()
    {
        return e;
    }

    public float getPivotX()
    {
        return f;
    }

    public float getPivotY()
    {
        return g;
    }

    public float getRotation()
    {
        return j;
    }

    public float getRotationX()
    {
        return h;
    }

    public float getRotationY()
    {
        return i;
    }

    public float getScaleX()
    {
        return k;
    }

    public float getScaleY()
    {
        return l;
    }

    public int getScrollX()
    {
        View view = (View)b.get();
        if (view == null)
        {
            return 0;
        } else
        {
            return view.getScrollX();
        }
    }

    public int getScrollY()
    {
        View view = (View)b.get();
        if (view == null)
        {
            return 0;
        } else
        {
            return view.getScrollY();
        }
    }

    public float getTranslationX()
    {
        return m;
    }

    public float getTranslationY()
    {
        return n;
    }

    public float getX()
    {
        View view = (View)b.get();
        if (view == null)
        {
            return 0.0F;
        } else
        {
            return (float)view.getLeft() + m;
        }
    }

    public float getY()
    {
        View view = (View)b.get();
        if (view == null)
        {
            return 0.0F;
        } else
        {
            return (float)view.getTop() + n;
        }
    }

    public void setAlpha(float f1)
    {
        if (e != f1)
        {
            e = f1;
            View view = (View)b.get();
            if (view != null)
            {
                view.invalidate();
            }
        }
    }

    public void setPivotX(float f1)
    {
        if (!d || f != f1)
        {
            a();
            d = true;
            f = f1;
            b();
        }
    }

    public void setPivotY(float f1)
    {
        if (!d || g != f1)
        {
            a();
            d = true;
            g = f1;
            b();
        }
    }

    public void setRotation(float f1)
    {
        if (j != f1)
        {
            a();
            j = f1;
            b();
        }
    }

    public void setRotationX(float f1)
    {
        if (h != f1)
        {
            a();
            h = f1;
            b();
        }
    }

    public void setRotationY(float f1)
    {
        if (i != f1)
        {
            a();
            i = f1;
            b();
        }
    }

    public void setScaleX(float f1)
    {
        if (k != f1)
        {
            a();
            k = f1;
            b();
        }
    }

    public void setScaleY(float f1)
    {
        if (l != f1)
        {
            a();
            l = f1;
            b();
        }
    }

    public void setScrollX(int i1)
    {
        View view = (View)b.get();
        if (view != null)
        {
            view.scrollTo(i1, view.getScrollY());
        }
    }

    public void setScrollY(int i1)
    {
        View view = (View)b.get();
        if (view != null)
        {
            view.scrollTo(view.getScrollX(), i1);
        }
    }

    public void setTranslationX(float f1)
    {
        if (m != f1)
        {
            a();
            m = f1;
            b();
        }
    }

    public void setTranslationY(float f1)
    {
        if (n != f1)
        {
            a();
            n = f1;
            b();
        }
    }

    public void setX(float f1)
    {
        View view = (View)b.get();
        if (view != null)
        {
            setTranslationX(f1 - (float)view.getLeft());
        }
    }

    public void setY(float f1)
    {
        View view = (View)b.get();
        if (view != null)
        {
            setTranslationY(f1 - (float)view.getTop());
        }
    }

    static 
    {
        boolean flag;
        if (Integer.valueOf(android.os.Build.VERSION.SDK).intValue() < 11)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        NEEDS_PROXY = flag;
    }
}
