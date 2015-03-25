// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.database.DataSetObserver;

// Referenced classes of package android.support.v4.widget:
//            CursorAdapter, a

class c extends DataSetObserver
{

    final CursorAdapter a;

    private c(CursorAdapter cursoradapter)
    {
        a = cursoradapter;
        super();
    }

    c(CursorAdapter cursoradapter, a a1)
    {
        this(cursoradapter);
    }

    public void onChanged()
    {
        a.mDataValid = true;
        a.notifyDataSetChanged();
    }

    public void onInvalidated()
    {
        a.mDataValid = false;
        a.notifyDataSetInvalidated();
    }
}
