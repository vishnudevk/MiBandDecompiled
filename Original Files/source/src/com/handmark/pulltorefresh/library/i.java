// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ExpandableListView;
import com.handmark.pulltorefresh.library.internal.EmptyViewMethodAccessor;

// Referenced classes of package com.handmark.pulltorefresh.library:
//            PullToRefreshExpandableListView

class i extends ExpandableListView
    implements EmptyViewMethodAccessor
{

    final PullToRefreshExpandableListView a;

    public i(PullToRefreshExpandableListView pulltorefreshexpandablelistview, Context context, AttributeSet attributeset)
    {
        a = pulltorefreshexpandablelistview;
        super(context, attributeset);
    }

    public void setEmptyView(View view)
    {
        a.setEmptyView(view);
    }

    public void setEmptyViewInternal(View view)
    {
        super.setEmptyView(view);
    }
}
