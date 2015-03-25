// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kankan.wheel.widget.adapters;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package kankan.wheel.widget.adapters:
//            WheelViewAdapter

public abstract class AbstractWheelAdapter
    implements WheelViewAdapter
{

    private List a;

    public AbstractWheelAdapter()
    {
    }

    public View getEmptyItem(View view, ViewGroup viewgroup)
    {
        return null;
    }

    protected void notifyDataChangedEvent()
    {
        if (a != null)
        {
            for (Iterator iterator = a.iterator(); iterator.hasNext(); ((DataSetObserver)iterator.next()).onChanged()) { }
        }
    }

    protected void notifyDataInvalidatedEvent()
    {
        if (a != null)
        {
            for (Iterator iterator = a.iterator(); iterator.hasNext(); ((DataSetObserver)iterator.next()).onInvalidated()) { }
        }
    }

    public void registerDataSetObserver(DataSetObserver datasetobserver)
    {
        if (a == null)
        {
            a = new LinkedList();
        }
        a.add(datasetobserver);
    }

    public void unregisterDataSetObserver(DataSetObserver datasetobserver)
    {
        if (a != null)
        {
            a.remove(datasetobserver);
        }
    }
}
