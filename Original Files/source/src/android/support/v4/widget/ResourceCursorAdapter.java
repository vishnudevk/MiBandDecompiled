// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package android.support.v4.widget:
//            CursorAdapter

public abstract class ResourceCursorAdapter extends CursorAdapter
{

    private int a;
    private int b;
    private LayoutInflater c;

    public ResourceCursorAdapter(Context context, int i, Cursor cursor)
    {
        super(context, cursor);
        b = i;
        a = i;
        c = (LayoutInflater)context.getSystemService("layout_inflater");
    }

    public ResourceCursorAdapter(Context context, int i, Cursor cursor, int j)
    {
        super(context, cursor, j);
        b = i;
        a = i;
        c = (LayoutInflater)context.getSystemService("layout_inflater");
    }

    public ResourceCursorAdapter(Context context, int i, Cursor cursor, boolean flag)
    {
        super(context, cursor, flag);
        b = i;
        a = i;
        c = (LayoutInflater)context.getSystemService("layout_inflater");
    }

    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewgroup)
    {
        return c.inflate(b, viewgroup, false);
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewgroup)
    {
        return c.inflate(a, viewgroup, false);
    }

    public void setDropDownViewResource(int i)
    {
        b = i;
    }

    public void setViewResource(int i)
    {
        a = i;
    }
}
