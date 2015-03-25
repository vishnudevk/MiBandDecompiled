// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.db;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.Debug;

// Referenced classes of package cn.com.smartdevices.bracelet.db:
//            a, BraceletDbHelper

public class BraceletProvider extends ContentProvider
{

    public static final boolean S = false;
    private static final String a = "BraceletProvider";
    private BraceletDbHelper b;

    public BraceletProvider()
    {
    }

    private void a(Uri uri)
    {
        getContext().getContentResolver().notifyChange(uri, null);
    }

    public int delete(Uri uri, String s, String as[])
    {
        return 0;
    }

    public String getType(Uri uri)
    {
        a a1 = new a(uri, null, null);
        if (TextUtils.isEmpty(a1.b))
        {
            return (new StringBuilder()).append("vnd.android.cursor.dir/").append(a1.a).toString();
        } else
        {
            return (new StringBuilder()).append("vnd.android.cursor.item/").append(a1.a).toString();
        }
    }

    public Uri insert(Uri uri, ContentValues contentvalues)
    {
        return null;
    }

    public boolean onCreate()
    {
        Debug.i("BraceletProvider", "onCreate");
        return false;
    }

    public Cursor query(Uri uri, String as[], String s, String as1[], String s1)
    {
        return null;
    }

    public int update(Uri uri, ContentValues contentvalues, String s, String as[])
    {
        return 0;
    }
}
