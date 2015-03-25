// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twotoasters.jazzylistview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

// Referenced classes of package com.twotoasters.jazzylistview:
//            JazzyHelper, JazzyEffect

public class JazzyListView extends ListView
{

    private final JazzyHelper a;

    public JazzyListView(Context context)
    {
        super(context);
        a = a(context, null);
    }

    public JazzyListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = a(context, attributeset);
    }

    public JazzyListView(Context context, AttributeSet attributeset, int i)
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

    public void setMaxAnimationVelocity(int i)
    {
        a.setMaxAnimationVelocity(i);
    }

    public final void setOnScrollListener(android.widget.AbsListView.OnScrollListener onscrolllistener)
    {
        a.setOnScrollListener(onscrolllistener);
    }

    public void setShouldOnlyAnimateFling(boolean flag)
    {
        a.setShouldOnlyAnimateFling(flag);
    }

    public void setShouldOnlyAnimateNewItems(boolean flag)
    {
        a.setShouldOnlyAnimateNewItems(flag);
    }

    public void setSimulateGridWithList(boolean flag)
    {
        a.setSimulateGridWithList(flag);
        boolean flag1;
        if (!flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        setClipChildren(flag1);
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
