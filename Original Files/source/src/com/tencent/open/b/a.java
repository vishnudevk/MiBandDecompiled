// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

public class a extends RelativeLayout
{

    private static final String a = com/tencent/open/b/a.getName();
    private Rect b;
    private boolean c;
    private a d;

    public a(Context context)
    {
        super(context);
        b = null;
        c = false;
        d = null;
        if (b == null)
        {
            b = new Rect();
        }
    }

    public a(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b = null;
        c = false;
        d = null;
        if (b == null)
        {
            b = new Rect();
        }
    }

    public void a(a a1)
    {
        d = a1;
    }

    protected void onMeasure(int i, int j)
    {
        int k = android.view.View.MeasureSpec.getSize(j);
        Activity activity = (Activity)getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(b);
        int l = b.top;
        int i1 = activity.getWindowManager().getDefaultDisplay().getHeight() - l - k;
        if (d != null && k != 0)
        {
            if (i1 > 100)
            {
                d.onKeyboardShown(Math.abs(b.height()) - getPaddingBottom() - getPaddingTop());
            } else
            {
                d.onKeyboardHidden();
            }
        }
        super.onMeasure(i, j);
    }


    private class a
    {

        public abstract void onKeyboardHidden();

        public abstract void onKeyboardShown(int i);
    }

}
