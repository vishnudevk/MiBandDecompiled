// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.activity;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import cn.com.smartdevices.bracelet.Utils;

// Referenced classes of package cn.com.smartdevices.bracelet.activity:
//            LoginActivity

class d extends ClickableSpan
{

    final LoginActivity a;

    d(LoginActivity loginactivity)
    {
        a = loginactivity;
        super();
    }

    public void onClick(View view)
    {
        Utils.gotoWeb("file:///android_asset/useragreement.html", a.getString(0x7f0d01dd), a);
    }

    public void updateDrawState(TextPaint textpaint)
    {
        super.updateDrawState(textpaint);
        textpaint.setColor(-1);
        textpaint.setUnderlineText(true);
    }
}
