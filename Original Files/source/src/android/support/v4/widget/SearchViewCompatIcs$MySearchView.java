// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.content.Context;
import android.widget.SearchView;

public class  extends SearchView
{

    public void onActionViewCollapsed()
    {
        setQuery("", false);
        super.onActionViewCollapsed();
    }

    public (Context context)
    {
        super(context);
    }
}
