// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

// Referenced classes of package com.tencent.connect.common:
//            BaseApi

public class AssistActivity extends Activity
{

    private static BaseApi a;
    private BaseApi b;

    public AssistActivity()
    {
    }

    public static Intent getAssistActivityIntent(Context context)
    {
        return new Intent(context, com/tencent/connect/common/AssistActivity);
    }

    public static void setApiObject(BaseApi baseapi)
    {
        a = baseapi;
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (b != null)
        {
            b.onActivityResult(i, j, intent);
        }
        finish();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        if (a == null)
        {
            finish();
            return;
        } else
        {
            b = a;
            a = null;
            int i = b.b().getIntExtra("key_request_code", 0);
            startActivityForResult(b.b(), i);
            return;
        }
    }
}
