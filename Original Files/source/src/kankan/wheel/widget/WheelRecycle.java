// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kankan.wheel.widget;

import android.view.View;
import android.widget.LinearLayout;
import java.util.LinkedList;
import java.util.List;
import kankan.wheel.widget.adapters.WheelViewAdapter;

// Referenced classes of package kankan.wheel.widget:
//            WheelView, ItemsRange

public class WheelRecycle
{

    private List a;
    private List b;
    private WheelView c;

    public WheelRecycle(WheelView wheelview)
    {
        c = wheelview;
    }

    private View a(List list)
    {
        if (list != null && list.size() > 0)
        {
            View view = (View)list.get(0);
            list.remove(0);
            return view;
        } else
        {
            return null;
        }
    }

    private List a(View view, List list)
    {
        if (list == null)
        {
            list = new LinkedList();
        }
        list.add(view);
        return list;
    }

    private void a(View view, int i)
    {
        int j = c.getViewAdapter().getItemsCount();
        if ((i < 0 || i >= j) && !c.isCyclic())
        {
            b = a(view, b);
            return;
        }
        for (; i < 0; i += j) { }
        int _tmp = i % j;
        a = a(view, a);
    }

    public void clearAll()
    {
        if (a != null)
        {
            a.clear();
        }
        if (b != null)
        {
            b.clear();
        }
    }

    public View getEmptyItem()
    {
        return a(b);
    }

    public View getItem()
    {
        return a(a);
    }

    public int recycleItems(LinearLayout linearlayout, int i, ItemsRange itemsrange)
    {
        int j = 0;
        int k = i;
        while (j < linearlayout.getChildCount()) 
        {
            if (!itemsrange.contains(i))
            {
                a(linearlayout.getChildAt(j), i);
                linearlayout.removeViewAt(j);
                if (j == 0)
                {
                    k++;
                }
            } else
            {
                j++;
            }
            i++;
        }
        return k;
    }
}
