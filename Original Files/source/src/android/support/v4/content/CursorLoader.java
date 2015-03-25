// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.content;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

// Referenced classes of package android.support.v4.content:
//            AsyncTaskLoader

public class CursorLoader extends AsyncTaskLoader
{

    final Loader.ForceLoadContentObserver h;
    Uri i;
    String j[];
    String k;
    String l[];
    String m;
    Cursor n;

    public CursorLoader(Context context)
    {
        super(context);
        h = new Loader.ForceLoadContentObserver(this);
    }

    public CursorLoader(Context context, Uri uri, String as[], String s, String as1[], String s1)
    {
        super(context);
        h = new Loader.ForceLoadContentObserver(this);
        i = uri;
        j = as;
        k = s;
        l = as1;
        m = s1;
    }

    public void deliverResult(Cursor cursor)
    {
        if (isReset())
        {
            if (cursor != null)
            {
                cursor.close();
            }
        } else
        {
            Cursor cursor1 = n;
            n = cursor;
            if (isStarted())
            {
                super.deliverResult(cursor);
            }
            if (cursor1 != null && cursor1 != cursor && !cursor1.isClosed())
            {
                cursor1.close();
                return;
            }
        }
    }

    public volatile void deliverResult(Object obj)
    {
        deliverResult((Cursor)obj);
    }

    public void dump(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        super.dump(s, filedescriptor, printwriter, as);
        printwriter.print(s);
        printwriter.print("mUri=");
        printwriter.println(i);
        printwriter.print(s);
        printwriter.print("mProjection=");
        printwriter.println(Arrays.toString(j));
        printwriter.print(s);
        printwriter.print("mSelection=");
        printwriter.println(k);
        printwriter.print(s);
        printwriter.print("mSelectionArgs=");
        printwriter.println(Arrays.toString(l));
        printwriter.print(s);
        printwriter.print("mSortOrder=");
        printwriter.println(m);
        printwriter.print(s);
        printwriter.print("mCursor=");
        printwriter.println(n);
        printwriter.print(s);
        printwriter.print("mContentChanged=");
        printwriter.println(u);
    }

    public String[] getProjection()
    {
        return j;
    }

    public String getSelection()
    {
        return k;
    }

    public String[] getSelectionArgs()
    {
        return l;
    }

    public String getSortOrder()
    {
        return m;
    }

    public Uri getUri()
    {
        return i;
    }

    public Cursor loadInBackground()
    {
        Cursor cursor = getContext().getContentResolver().query(i, j, k, l, m);
        if (cursor != null)
        {
            cursor.getCount();
            cursor.registerContentObserver(h);
        }
        return cursor;
    }

    public volatile Object loadInBackground()
    {
        return loadInBackground();
    }

    public void onCanceled(Cursor cursor)
    {
        if (cursor != null && !cursor.isClosed())
        {
            cursor.close();
        }
    }

    public volatile void onCanceled(Object obj)
    {
        onCanceled((Cursor)obj);
    }

    protected void onReset()
    {
        super.onReset();
        onStopLoading();
        if (n != null && !n.isClosed())
        {
            n.close();
        }
        n = null;
    }

    protected void onStartLoading()
    {
        if (n != null)
        {
            deliverResult(n);
        }
        if (takeContentChanged() || n == null)
        {
            forceLoad();
        }
    }

    protected void onStopLoading()
    {
        cancelLoad();
    }

    public void setProjection(String as[])
    {
        j = as;
    }

    public void setSelection(String s)
    {
        k = s;
    }

    public void setSelectionArgs(String as[])
    {
        l = as;
    }

    public void setSortOrder(String s)
    {
        m = s;
    }

    public void setUri(Uri uri)
    {
        i = uri;
    }
}
