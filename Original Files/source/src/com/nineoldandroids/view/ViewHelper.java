// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.view;

import android.view.View;
import com.nineoldandroids.view.animation.AnimatorProxy;

// Referenced classes of package com.nineoldandroids.view:
//            a

public final class ViewHelper
{

    private ViewHelper()
    {
    }

    public static float getAlpha(View view)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            return AnimatorProxy.wrap(view).getAlpha();
        } else
        {
            return a.a(view);
        }
    }

    public static float getPivotX(View view)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            return AnimatorProxy.wrap(view).getPivotX();
        } else
        {
            return a.b(view);
        }
    }

    public static float getPivotY(View view)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            return AnimatorProxy.wrap(view).getPivotY();
        } else
        {
            return a.c(view);
        }
    }

    public static float getRotation(View view)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            return AnimatorProxy.wrap(view).getRotation();
        } else
        {
            return a.d(view);
        }
    }

    public static float getRotationX(View view)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            return AnimatorProxy.wrap(view).getRotationX();
        } else
        {
            return a.e(view);
        }
    }

    public static float getRotationY(View view)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            return AnimatorProxy.wrap(view).getRotationY();
        } else
        {
            return a.f(view);
        }
    }

    public static float getScaleX(View view)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            return AnimatorProxy.wrap(view).getScaleX();
        } else
        {
            return a.g(view);
        }
    }

    public static float getScaleY(View view)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            return AnimatorProxy.wrap(view).getScaleY();
        } else
        {
            return a.h(view);
        }
    }

    public static float getScrollX(View view)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            return (float)AnimatorProxy.wrap(view).getScrollX();
        } else
        {
            return a.i(view);
        }
    }

    public static float getScrollY(View view)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            return (float)AnimatorProxy.wrap(view).getScrollY();
        } else
        {
            return a.j(view);
        }
    }

    public static float getTranslationX(View view)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            return AnimatorProxy.wrap(view).getTranslationX();
        } else
        {
            return a.k(view);
        }
    }

    public static float getTranslationY(View view)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            return AnimatorProxy.wrap(view).getTranslationY();
        } else
        {
            return a.l(view);
        }
    }

    public static float getX(View view)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            return AnimatorProxy.wrap(view).getX();
        } else
        {
            return a.m(view);
        }
    }

    public static float getY(View view)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            return AnimatorProxy.wrap(view).getY();
        } else
        {
            return a.n(view);
        }
    }

    public static void setAlpha(View view, float f)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            AnimatorProxy.wrap(view).setAlpha(f);
            return;
        } else
        {
            a.a(view, f);
            return;
        }
    }

    public static void setPivotX(View view, float f)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            AnimatorProxy.wrap(view).setPivotX(f);
            return;
        } else
        {
            a.b(view, f);
            return;
        }
    }

    public static void setPivotY(View view, float f)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            AnimatorProxy.wrap(view).setPivotY(f);
            return;
        } else
        {
            a.c(view, f);
            return;
        }
    }

    public static void setRotation(View view, float f)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            AnimatorProxy.wrap(view).setRotation(f);
            return;
        } else
        {
            a.d(view, f);
            return;
        }
    }

    public static void setRotationX(View view, float f)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            AnimatorProxy.wrap(view).setRotationX(f);
            return;
        } else
        {
            a.e(view, f);
            return;
        }
    }

    public static void setRotationY(View view, float f)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            AnimatorProxy.wrap(view).setRotationY(f);
            return;
        } else
        {
            a.f(view, f);
            return;
        }
    }

    public static void setScaleX(View view, float f)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            AnimatorProxy.wrap(view).setScaleX(f);
            return;
        } else
        {
            a.g(view, f);
            return;
        }
    }

    public static void setScaleY(View view, float f)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            AnimatorProxy.wrap(view).setScaleY(f);
            return;
        } else
        {
            a.h(view, f);
            return;
        }
    }

    public static void setScrollX(View view, int i)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            AnimatorProxy.wrap(view).setScrollX(i);
            return;
        } else
        {
            a.a(view, i);
            return;
        }
    }

    public static void setScrollY(View view, int i)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            AnimatorProxy.wrap(view).setScrollY(i);
            return;
        } else
        {
            a.b(view, i);
            return;
        }
    }

    public static void setTranslationX(View view, float f)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            AnimatorProxy.wrap(view).setTranslationX(f);
            return;
        } else
        {
            a.i(view, f);
            return;
        }
    }

    public static void setTranslationY(View view, float f)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            AnimatorProxy.wrap(view).setTranslationY(f);
            return;
        } else
        {
            a.j(view, f);
            return;
        }
    }

    public static void setX(View view, float f)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            AnimatorProxy.wrap(view).setX(f);
            return;
        } else
        {
            a.k(view, f);
            return;
        }
    }

    public static void setY(View view, float f)
    {
        if (AnimatorProxy.NEEDS_PROXY)
        {
            AnimatorProxy.wrap(view).setY(f);
            return;
        } else
        {
            a.l(view, f);
            return;
        }
    }
}
