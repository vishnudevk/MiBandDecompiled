// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.auth;

import android.view.View;

// Referenced classes of package com.sina.weibo.sdk.auth:
//            WeiboDialog, WeiboAuthListener

class this._cls0
    implements android.view.stener
{

    final WeiboDialog this$0;

    public void onClick(View view)
    {
        dismiss();
        if (WeiboDialog.access$0(WeiboDialog.this) != null)
        {
            WeiboDialog.access$0(WeiboDialog.this).onCancel();
        }
    }

    ner()
    {
        this$0 = WeiboDialog.this;
        super();
    }
}
