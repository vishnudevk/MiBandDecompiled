// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package android.support.v4.widget:
//            ResourceCursorAdapter

public class SimpleCursorAdapter extends ResourceCursorAdapter
{

    String a[];
    private int b;
    private CursorToStringConverter c;
    private ViewBinder d;
    protected int mFrom[];
    protected int mTo[];

    public SimpleCursorAdapter(Context context, int i, Cursor cursor, String as[], int ai[])
    {
        super(context, i, cursor);
        b = -1;
        mTo = ai;
        a = as;
        a(as);
    }

    public SimpleCursorAdapter(Context context, int i, Cursor cursor, String as[], int ai[], int j)
    {
        super(context, i, cursor, j);
        b = -1;
        mTo = ai;
        a = as;
        a(as);
    }

    private void a(String as[])
    {
        if (mCursor != null)
        {
            int i = as.length;
            if (mFrom == null || mFrom.length != i)
            {
                mFrom = new int[i];
            }
            for (int j = 0; j < i; j++)
            {
                mFrom[j] = mCursor.getColumnIndexOrThrow(as[j]);
            }

        } else
        {
            mFrom = null;
        }
    }

    public void bindView(View view, Context context, Cursor cursor)
    {
        ViewBinder viewbinder = d;
        int i = mTo.length;
        int ai[] = mFrom;
        int ai1[] = mTo;
        int j = 0;
        while (j < i) 
        {
            View view1 = view.findViewById(ai1[j]);
            if (view1 == null)
            {
                continue;
            }
            boolean flag;
            if (viewbinder != null)
            {
                flag = viewbinder.setViewValue(view1, cursor, ai[j]);
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                String s = cursor.getString(ai[j]);
                if (s == null)
                {
                    s = "";
                }
                if (view1 instanceof TextView)
                {
                    setViewText((TextView)view1, s);
                } else
                if (view1 instanceof ImageView)
                {
                    setViewImage((ImageView)view1, s);
                } else
                {
                    throw new IllegalStateException((new StringBuilder()).append(view1.getClass().getName()).append(" is not a ").append(" view that can be bounds by this SimpleCursorAdapter").toString());
                }
            }
            j++;
        }
    }

    public void changeCursorAndColumns(Cursor cursor, String as[], int ai[])
    {
        a = as;
        mTo = ai;
        super.changeCursor(cursor);
        a(a);
    }

    public CharSequence convertToString(Cursor cursor)
    {
        if (c != null)
        {
            return c.convertToString(cursor);
        }
        if (b > -1)
        {
            return cursor.getString(b);
        } else
        {
            return super.convertToString(cursor);
        }
    }

    public CursorToStringConverter getCursorToStringConverter()
    {
        return c;
    }

    public int getStringConversionColumn()
    {
        return b;
    }

    public ViewBinder getViewBinder()
    {
        return d;
    }

    public void setCursorToStringConverter(CursorToStringConverter cursortostringconverter)
    {
        c = cursortostringconverter;
    }

    public void setStringConversionColumn(int i)
    {
        b = i;
    }

    public void setViewBinder(ViewBinder viewbinder)
    {
        d = viewbinder;
    }

    public void setViewImage(ImageView imageview, String s)
    {
        try
        {
            imageview.setImageResource(Integer.parseInt(s));
            return;
        }
        catch (NumberFormatException numberformatexception)
        {
            imageview.setImageURI(Uri.parse(s));
        }
    }

    public void setViewText(TextView textview, String s)
    {
        textview.setText(s);
    }

    public Cursor swapCursor(Cursor cursor)
    {
        Cursor cursor1 = super.swapCursor(cursor);
        a(a);
        return cursor1;
    }

    private class ViewBinder
    {

        public abstract boolean setViewValue(View view, Cursor cursor, int i);
    }


    private class CursorToStringConverter
    {

        public abstract CharSequence convertToString(Cursor cursor);
    }

}
