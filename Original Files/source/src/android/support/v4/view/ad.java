// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.graphics.Paint;
import android.view.View;

// Referenced classes of package android.support.v4.view:
//            ac, ak

class ad extends ac
{

    ad()
    {
    }

    long a()
    {
        return ak.a();
    }

    public void a(View view, int i, Paint paint)
    {
        ak.a(view, i, paint);
    }

    public void a(View view, Paint paint)
    {
        a(view, g(view), paint);
        view.invalidate();
    }

    public float f(View view)
    {
        return ak.a(view);
    }

    public int g(View view)
    {
        return ak.b(view);
    }
}
