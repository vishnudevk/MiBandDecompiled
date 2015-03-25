// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao.internal;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;

public final class FastCursor
    implements Cursor
{

    private final int count;
    private int position;
    private final CursorWindow window;

    public FastCursor(CursorWindow cursorwindow)
    {
        window = cursorwindow;
        count = cursorwindow.getNumRows();
    }

    public void close()
    {
        throw new UnsupportedOperationException();
    }

    public void copyStringToBuffer(int i, CharArrayBuffer chararraybuffer)
    {
        throw new UnsupportedOperationException();
    }

    public void deactivate()
    {
        throw new UnsupportedOperationException();
    }

    public byte[] getBlob(int i)
    {
        return window.getBlob(position, i);
    }

    public int getColumnCount()
    {
        throw new UnsupportedOperationException();
    }

    public int getColumnIndex(String s)
    {
        throw new UnsupportedOperationException();
    }

    public int getColumnIndexOrThrow(String s)
    {
        throw new UnsupportedOperationException();
    }

    public String getColumnName(int i)
    {
        throw new UnsupportedOperationException();
    }

    public String[] getColumnNames()
    {
        throw new UnsupportedOperationException();
    }

    public int getCount()
    {
        return window.getNumRows();
    }

    public double getDouble(int i)
    {
        return window.getDouble(position, i);
    }

    public Bundle getExtras()
    {
        throw new UnsupportedOperationException();
    }

    public float getFloat(int i)
    {
        return window.getFloat(position, i);
    }

    public int getInt(int i)
    {
        return window.getInt(position, i);
    }

    public long getLong(int i)
    {
        return window.getLong(position, i);
    }

    public Uri getNotificationUri()
    {
        return null;
    }

    public int getPosition()
    {
        return position;
    }

    public short getShort(int i)
    {
        return window.getShort(position, i);
    }

    public String getString(int i)
    {
        return window.getString(position, i);
    }

    public int getType(int i)
    {
        throw new UnsupportedOperationException();
    }

    public boolean getWantsAllOnMoveCalls()
    {
        throw new UnsupportedOperationException();
    }

    public boolean isAfterLast()
    {
        throw new UnsupportedOperationException();
    }

    public boolean isBeforeFirst()
    {
        throw new UnsupportedOperationException();
    }

    public boolean isClosed()
    {
        throw new UnsupportedOperationException();
    }

    public boolean isFirst()
    {
        return position == 0;
    }

    public boolean isLast()
    {
        return position == -1 + count;
    }

    public boolean isNull(int i)
    {
        return window.isNull(position, i);
    }

    public boolean move(int i)
    {
        return moveToPosition(i + position);
    }

    public boolean moveToFirst()
    {
        position = 0;
        int i = count;
        boolean flag = false;
        if (i > 0)
        {
            flag = true;
        }
        return flag;
    }

    public boolean moveToLast()
    {
        if (count > 0)
        {
            position = -1 + count;
            return true;
        } else
        {
            return false;
        }
    }

    public boolean moveToNext()
    {
        if (position < -1 + count)
        {
            position = 1 + position;
            return true;
        } else
        {
            return false;
        }
    }

    public boolean moveToPosition(int i)
    {
        if (i >= 0 && i < count)
        {
            position = i;
            return true;
        } else
        {
            return false;
        }
    }

    public boolean moveToPrevious()
    {
        if (position > 0)
        {
            position = -1 + position;
            return true;
        } else
        {
            return false;
        }
    }

    public void registerContentObserver(ContentObserver contentobserver)
    {
        throw new UnsupportedOperationException();
    }

    public void registerDataSetObserver(DataSetObserver datasetobserver)
    {
        throw new UnsupportedOperationException();
    }

    public boolean requery()
    {
        throw new UnsupportedOperationException();
    }

    public Bundle respond(Bundle bundle)
    {
        throw new UnsupportedOperationException();
    }

    public void setNotificationUri(ContentResolver contentresolver, Uri uri)
    {
        throw new UnsupportedOperationException();
    }

    public void unregisterContentObserver(ContentObserver contentobserver)
    {
        throw new UnsupportedOperationException();
    }

    public void unregisterDataSetObserver(DataSetObserver datasetobserver)
    {
        throw new UnsupportedOperationException();
    }
}
