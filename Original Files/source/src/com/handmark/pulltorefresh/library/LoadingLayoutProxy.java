// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import com.handmark.pulltorefresh.library.internal.LoadingLayout;
import java.util.HashSet;
import java.util.Iterator;

// Referenced classes of package com.handmark.pulltorefresh.library:
//            ILoadingLayout

public class LoadingLayoutProxy
    implements ILoadingLayout
{

    private final HashSet a = new HashSet();

    LoadingLayoutProxy()
    {
    }

    public void addLayout(LoadingLayout loadinglayout)
    {
        if (loadinglayout != null)
        {
            a.add(loadinglayout);
        }
    }

    public void setLastUpdatedLabel(CharSequence charsequence)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((LoadingLayout)iterator.next()).setLastUpdatedLabel(charsequence)) { }
    }

    public void setLoadingDrawable(Drawable drawable)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((LoadingLayout)iterator.next()).setLoadingDrawable(drawable)) { }
    }

    public void setPullLabel(CharSequence charsequence)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((LoadingLayout)iterator.next()).setPullLabel(charsequence)) { }
    }

    public void setRefreshingLabel(CharSequence charsequence)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((LoadingLayout)iterator.next()).setRefreshingLabel(charsequence)) { }
    }

    public void setReleaseLabel(CharSequence charsequence)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((LoadingLayout)iterator.next()).setReleaseLabel(charsequence)) { }
    }

    public void setTextTypeface(Typeface typeface)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((LoadingLayout)iterator.next()).setTextTypeface(typeface)) { }
    }
}
