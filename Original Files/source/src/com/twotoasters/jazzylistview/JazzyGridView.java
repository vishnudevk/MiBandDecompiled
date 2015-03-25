// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twotoasters.jazzylistview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

// Referenced classes of package com.twotoasters.jazzylistview:
//            JazzyHelper, JazzyEffect

public class JazzyGridView extends GridView
{

    private final JazzyHelper a;

    public JazzyGridView(Context context)
    {
        super(context);
        a = a(context, null);
    }

    public JazzyGridView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = a(context, attributeset);
    }

    public JazzyGridView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a = a(context, attributeset);
    }

    private JazzyHelper a(Context context, AttributeSet attributeset)
    {
        JazzyHelper jazzyhelper = new JazzyHelper(context, attributeset);
        super.setOnScrollListener(jazzyhelper);
        return jazzyhelper;
    }

    public final void setOnScrollListener(android.widget.AbsListView.OnScrollListener onscrolllistener)
    {
        a.setOnScrollListener(onscrolllistener);
    }

    public void setShouldOnlyAnimateNewItems(boolean flag)
    {
        a.setShouldOnlyAnimateNewItems(flag);
    }

    public void setTransitionEffect(int i)
    {
        a.setTransitionEffect(i);
    }

    public void setTransitionEffect(JazzyEffect jazzyeffect)
    {
        a.setTransitionEffect(jazzyeffect);
    }
}
