// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.view.View;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            UnlockScreenInvalidHelperActivity

class cm
    implements android.view.View.OnClickListener
{

    final UnlockScreenInvalidHelperActivity a;

    cm(UnlockScreenInvalidHelperActivity unlockscreeninvalidhelperactivity)
    {
        a = unlockscreeninvalidhelperactivity;
        super();
    }

    public void onClick(View view)
    {
        a.finish();
    }
}
