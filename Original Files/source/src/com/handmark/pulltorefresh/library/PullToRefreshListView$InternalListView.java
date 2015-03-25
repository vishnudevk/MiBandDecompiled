// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.handmark.pulltorefresh.library.internal.EmptyViewMethodAccessor;

// Referenced classes of package com.handmark.pulltorefresh.library:
//            PullToRefreshListView

public class b extends ListView
    implements EmptyViewMethodAccessor
{

    final PullToRefreshListView a;
    private boolean b;

    protected void dispatchDraw(Canvas canvas)
    {
        try
        {
            super.dispatchDraw(canvas);
            return;
        }
        catch (IndexOutOfBoundsException indexoutofboundsexception)
        {
            indexoutofboundsexception.printStackTrace();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionevent)
    {
        boolean flag;
        try
        {
            flag = super.dispatchTouchEvent(motionevent);
        }
        catch (IndexOutOfBoundsException indexoutofboundsexception)
        {
            indexoutofboundsexception.printStackTrace();
            return false;
        }
        return flag;
    }

    public volatile void setAdapter(Adapter adapter)
    {
        setAdapter((ListAdapter)adapter);
    }

    public void setAdapter(ListAdapter listadapter)
    {
        if (PullToRefreshListView.a(a) != null && !b)
        {
            addFooterView(PullToRefreshListView.a(a), null, false);
            b = true;
        }
        super.setAdapter(listadapter);
    }

    public void setEmptyView(View view)
    {
        a.setEmptyView(view);
    }

    public void setEmptyViewInternal(View view)
    {
        super.setEmptyView(view);
    }

    public (PullToRefreshListView pulltorefreshlistview, Context context, AttributeSet attributeset)
    {
        a = pulltorefreshlistview;
        super(context, attributeset);
        b = false;
    }
}
