// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

// Referenced classes of package android.support.v4.widget:
//            e, b, c, d

public abstract class CursorAdapter extends BaseAdapter
    implements e, Filterable
{

    public static final int FLAG_AUTO_REQUERY = 1;
    public static final int FLAG_REGISTER_CONTENT_OBSERVER = 2;
    protected boolean mAutoRequery;
    protected b mChangeObserver;
    protected Context mContext;
    protected Cursor mCursor;
    protected d mCursorFilter;
    protected DataSetObserver mDataSetObserver;
    protected boolean mDataValid;
    protected FilterQueryProvider mFilterQueryProvider;
    protected int mRowIDColumn;

    public CursorAdapter(Context context, Cursor cursor)
    {
        a(context, cursor, 1);
    }

    public CursorAdapter(Context context, Cursor cursor, int i)
    {
        a(context, cursor, i);
    }

    public CursorAdapter(Context context, Cursor cursor, boolean flag)
    {
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 2;
        }
        a(context, cursor, i);
    }

    void a(Context context, Cursor cursor, int i)
    {
        boolean flag = true;
        int j;
        if ((i & 1) == flag)
        {
            i |= 2;
            mAutoRequery = flag;
        } else
        {
            mAutoRequery = false;
        }
        if (cursor == null)
        {
            flag = false;
        }
        mCursor = cursor;
        mDataValid = flag;
        mContext = context;
        if (flag)
        {
            j = cursor.getColumnIndexOrThrow("_id");
        } else
        {
            j = -1;
        }
        mRowIDColumn = j;
        if ((i & 2) == 2)
        {
            mChangeObserver = new b(this);
            mDataSetObserver = new c(this, null);
        } else
        {
            mChangeObserver = null;
            mDataSetObserver = null;
        }
        if (flag)
        {
            if (mChangeObserver != null)
            {
                cursor.registerContentObserver(mChangeObserver);
            }
            if (mDataSetObserver != null)
            {
                cursor.registerDataSetObserver(mDataSetObserver);
            }
        }
    }

    public abstract void bindView(View view, Context context, Cursor cursor);

    public void changeCursor(Cursor cursor)
    {
        Cursor cursor1 = swapCursor(cursor);
        if (cursor1 != null)
        {
            cursor1.close();
        }
    }

    public CharSequence convertToString(Cursor cursor)
    {
        if (cursor == null)
        {
            return "";
        } else
        {
            return cursor.toString();
        }
    }

    public int getCount()
    {
        if (mDataValid && mCursor != null)
        {
            return mCursor.getCount();
        } else
        {
            return 0;
        }
    }

    public Cursor getCursor()
    {
        return mCursor;
    }

    public View getDropDownView(int i, View view, ViewGroup viewgroup)
    {
        if (mDataValid)
        {
            mCursor.moveToPosition(i);
            if (view == null)
            {
                view = newDropDownView(mContext, mCursor, viewgroup);
            }
            bindView(view, mContext, mCursor);
            return view;
        } else
        {
            return null;
        }
    }

    public Filter getFilter()
    {
        if (mCursorFilter == null)
        {
            mCursorFilter = new d(this);
        }
        return mCursorFilter;
    }

    public FilterQueryProvider getFilterQueryProvider()
    {
        return mFilterQueryProvider;
    }

    public Object getItem(int i)
    {
        if (mDataValid && mCursor != null)
        {
            mCursor.moveToPosition(i);
            return mCursor;
        } else
        {
            return null;
        }
    }

    public long getItemId(int i)
    {
        long l = 0L;
        if (mDataValid && mCursor != null && mCursor.moveToPosition(i))
        {
            l = mCursor.getLong(mRowIDColumn);
        }
        return l;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (!mDataValid)
        {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (!mCursor.moveToPosition(i))
        {
            throw new IllegalStateException((new StringBuilder()).append("couldn't move cursor to position ").append(i).toString());
        }
        if (view == null)
        {
            view = newView(mContext, mCursor, viewgroup);
        }
        bindView(view, mContext, mCursor);
        return view;
    }

    public boolean hasStableIds()
    {
        return true;
    }

    protected void init(Context context, Cursor cursor, boolean flag)
    {
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 2;
        }
        a(context, cursor, i);
    }

    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewgroup)
    {
        return newView(context, cursor, viewgroup);
    }

    public abstract View newView(Context context, Cursor cursor, ViewGroup viewgroup);

    protected void onContentChanged()
    {
        if (mAutoRequery && mCursor != null && !mCursor.isClosed())
        {
            mDataValid = mCursor.requery();
        }
    }

    public Cursor runQueryOnBackgroundThread(CharSequence charsequence)
    {
        if (mFilterQueryProvider != null)
        {
            return mFilterQueryProvider.runQuery(charsequence);
        } else
        {
            return mCursor;
        }
    }

    public void setFilterQueryProvider(FilterQueryProvider filterqueryprovider)
    {
        mFilterQueryProvider = filterqueryprovider;
    }

    public Cursor swapCursor(Cursor cursor)
    {
        if (cursor == mCursor)
        {
            return null;
        }
        Cursor cursor1 = mCursor;
        if (cursor1 != null)
        {
            if (mChangeObserver != null)
            {
                cursor1.unregisterContentObserver(mChangeObserver);
            }
            if (mDataSetObserver != null)
            {
                cursor1.unregisterDataSetObserver(mDataSetObserver);
            }
        }
        mCursor = cursor;
        if (cursor != null)
        {
            if (mChangeObserver != null)
            {
                cursor.registerContentObserver(mChangeObserver);
            }
            if (mDataSetObserver != null)
            {
                cursor.registerDataSetObserver(mDataSetObserver);
            }
            mRowIDColumn = cursor.getColumnIndexOrThrow("_id");
            mDataValid = true;
            notifyDataSetChanged();
            return cursor1;
        } else
        {
            mRowIDColumn = -1;
            mDataValid = false;
            notifyDataSetInvalidated();
            return cursor1;
        }
    }
}
