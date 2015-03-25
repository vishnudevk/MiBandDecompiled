// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.Button;

// Referenced classes of package com.tencent.connect.avatar:
//            ImageActivity

class f extends View
{

    final ImageActivity a;

    public f(ImageActivity imageactivity, Context context)
    {
        a = imageactivity;
        super(context);
    }

    public void a(Button button)
    {
        StateListDrawable statelistdrawable = new StateListDrawable();
        android.graphics.drawable.Drawable drawable = ImageActivity.a(a, "com.tencent.plus.blue_normal.png");
        android.graphics.drawable.Drawable drawable1 = ImageActivity.a(a, "com.tencent.plus.blue_down.png");
        android.graphics.drawable.Drawable drawable2 = ImageActivity.a(a, "com.tencent.plus.blue_disable.png");
        statelistdrawable.addState(View.PRESSED_ENABLED_STATE_SET, drawable1);
        statelistdrawable.addState(View.ENABLED_FOCUSED_STATE_SET, drawable);
        statelistdrawable.addState(View.ENABLED_STATE_SET, drawable);
        statelistdrawable.addState(View.FOCUSED_STATE_SET, drawable);
        statelistdrawable.addState(View.EMPTY_STATE_SET, drawable2);
        button.setBackgroundDrawable(statelistdrawable);
    }

    public void b(Button button)
    {
        StateListDrawable statelistdrawable = new StateListDrawable();
        android.graphics.drawable.Drawable drawable = ImageActivity.a(a, "com.tencent.plus.gray_normal.png");
        android.graphics.drawable.Drawable drawable1 = ImageActivity.a(a, "com.tencent.plus.gray_down.png");
        android.graphics.drawable.Drawable drawable2 = ImageActivity.a(a, "com.tencent.plus.gray_disable.png");
        statelistdrawable.addState(View.PRESSED_ENABLED_STATE_SET, drawable1);
        statelistdrawable.addState(View.ENABLED_FOCUSED_STATE_SET, drawable);
        statelistdrawable.addState(View.ENABLED_STATE_SET, drawable);
        statelistdrawable.addState(View.FOCUSED_STATE_SET, drawable);
        statelistdrawable.addState(View.EMPTY_STATE_SET, drawable2);
        button.setBackgroundDrawable(statelistdrawable);
    }
}
