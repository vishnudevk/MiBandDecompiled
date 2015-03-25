// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.activity;

import android.content.Intent;
import android.view.View;
import cn.com.smartdevices.bracelet.ui.SearchSingleBraceletActivity;

// Referenced classes of package cn.com.smartdevices.bracelet.activity:
//            PersonInfoFinishedActivity

class i
    implements android.view.View.OnClickListener
{

    final PersonInfoFinishedActivity a;

    i(PersonInfoFinishedActivity personinfofinishedactivity)
    {
        a = personinfofinishedactivity;
        super();
    }

    public void onClick(View view)
    {
        Intent intent = new Intent(a, cn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity);
        a.startActivity(intent);
        a.finish();
    }
}
