// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.activity;

import android.animation.ValueAnimator;
import android.widget.Button;
import android.widget.TextView;

// Referenced classes of package cn.com.smartdevices.bracelet.activity:
//            LoginActivity, c

class b
    implements Runnable
{

    final LoginActivity a;

    b(LoginActivity loginactivity)
    {
        a = loginactivity;
        super();
    }

    public void run()
    {
        LoginActivity.a(a).setEnabled(true);
        LoginActivity.b(a).setEnabled(true);
        LoginActivity.c(a).setEnabled(true);
        LoginActivity.a(a, ValueAnimator.ofFloat(new float[] {
            0.0F, 1.0F
        }));
        LoginActivity.d(a).setDuration(450L);
        LoginActivity.d(a).addUpdateListener(new c(this));
        LoginActivity.d(a).start();
    }
}
