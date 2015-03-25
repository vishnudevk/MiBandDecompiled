// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.stat;

import android.app.Activity;

// Referenced classes of package com.tencent.stat:
//            StatService

public class EasyActivity extends Activity
{

    public EasyActivity()
    {
    }

    protected void onPause()
    {
        super.onPause();
        StatService.onPause(this);
    }

    protected void onResume()
    {
        super.onResume();
        StatService.onResume(this);
    }
}
