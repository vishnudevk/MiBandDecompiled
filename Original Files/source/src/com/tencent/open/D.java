// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

// Referenced classes of package com.tencent.open:
//            TaskGuide, B, A, q, 
//            z

class D extends LinearLayout
{

    final TaskGuide a;
    private TextView b;
    private Button c;
    private A d;

    public D(TaskGuide taskguide, Context context, A a1)
    {
        a = taskguide;
        super(context);
        d = a1;
        setOrientation(0);
        a();
    }

    private void a()
    {
        b = new TextView(TaskGuide.m(a));
        b.setTextColor(Color.rgb(255, 255, 255));
        b.setTextSize(15F);
        b.setShadowLayer(1.0F, 1.0F, 1.0F, Color.rgb(242, 211, 199));
        b.setGravity(3);
        b.setEllipsize(android.text.TextUtils.TruncateAt.END);
        b.setIncludeFontPadding(false);
        b.setSingleLine(true);
        android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(0, -2);
        layoutparams.weight = 1.0F;
        layoutparams.leftMargin = TaskGuide.d(a, 4);
        addView(b, layoutparams);
        c = new Button(TaskGuide.n(a));
        c.setPadding(0, 0, 0, 0);
        c.setTextSize(16F);
        c.setTextColor(Color.rgb(255, 255, 255));
        c.setShadowLayer(1.0F, 1.0F, 1.0F, Color.rgb(242, 211, 199));
        c.setIncludeFontPadding(false);
        c.setOnClickListener(new B(a, d.a));
        android.widget.LinearLayout.LayoutParams layoutparams1 = new android.widget.LinearLayout.LayoutParams(TaskGuide.d(a, TaskGuide.a()), TaskGuide.d(a, TaskGuide.c()));
        layoutparams1.leftMargin = TaskGuide.d(a, 2);
        layoutparams1.rightMargin = TaskGuide.d(a, 8);
        addView(c, layoutparams1);
    }

    public void a(z z1)
    {
        if (!TextUtils.isEmpty(d.b))
        {
            b.setText(d.b);
        }
        q.a[z1.ordinal()];
        JVM INSTR tableswitch 1 4: default 64
    //                   1 65
    //                   2 74
    //                   3 195
    //                   4 213;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return;
_L2:
        c.setEnabled(false);
        return;
_L3:
        if (d.e == 1)
        {
            c.setText(d.c);
            c.setBackgroundDrawable(null);
            c.setTextColor(Color.rgb(255, 246, 0));
            c.setEnabled(false);
            return;
        }
        if (d.e == 2)
        {
            c.setText("\u9886\u53D6\u5956\u52B1");
            c.setTextColor(Color.rgb(255, 255, 255));
            c.setBackgroundDrawable(TaskGuide.o(a));
            c.setEnabled(true);
            return;
        }
          goto _L1
_L4:
        c.setText("\u9886\u53D6\u4E2D...");
        c.setEnabled(false);
        return;
_L5:
        c.setText("\u5DF2\u9886\u53D6");
        c.setBackgroundDrawable(TaskGuide.p(a));
        c.setEnabled(false);
        return;
    }
}
