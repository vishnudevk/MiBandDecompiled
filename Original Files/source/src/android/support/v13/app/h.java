// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v13.app;

import android.content.Context;
import android.view.View;

class h
    implements android.widget.TabHost.TabContentFactory
{

    private final Context a;

    public h(Context context)
    {
        a = context;
    }

    public View createTabContent(String s)
    {
        View view = new View(a);
        view.setMinimumWidth(0);
        view.setMinimumHeight(0);
        return view;
    }
}
