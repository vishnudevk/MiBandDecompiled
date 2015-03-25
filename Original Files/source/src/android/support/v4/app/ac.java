// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.ShareActionProvider;

class ac
{

    private static final String a = ".sharecompat_";

    ac()
    {
    }

    public static void a(MenuItem menuitem, Activity activity, Intent intent)
    {
        android.view.ActionProvider actionprovider = menuitem.getActionProvider();
        ShareActionProvider shareactionprovider;
        if (!(actionprovider instanceof ShareActionProvider))
        {
            shareactionprovider = new ShareActionProvider(activity);
        } else
        {
            shareactionprovider = (ShareActionProvider)actionprovider;
        }
        shareactionprovider.setShareHistoryFileName((new StringBuilder()).append(".sharecompat_").append(activity.getClass().getName()).toString());
        shareactionprovider.setShareIntent(intent);
        menuitem.setActionProvider(shareactionprovider);
    }
}
