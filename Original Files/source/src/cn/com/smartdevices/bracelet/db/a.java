// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.db;

import android.content.ContentUris;
import android.net.Uri;
import android.text.TextUtils;
import java.util.List;

class a
{

    public final String a;
    public final String b;
    public final String c[];

    a(Uri uri)
    {
        if (uri.getPathSegments().size() == 1)
        {
            a = (String)uri.getPathSegments().get(0);
            b = null;
            c = null;
            return;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid URI: ").append(uri).toString());
        }
    }

    a(Uri uri, String s, String as[])
    {
        if (uri.getPathSegments().size() == 1)
        {
            a = (String)uri.getPathSegments().get(0);
            b = s;
            c = as;
            return;
        }
        if (uri.getPathSegments().size() != 2)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid URI: ").append(uri).toString());
        }
        if (!TextUtils.isEmpty(s))
        {
            throw new UnsupportedOperationException((new StringBuilder()).append("WHERE clause not supported: ").append(uri).toString());
        } else
        {
            a = (String)uri.getPathSegments().get(0);
            b = (new StringBuilder()).append("_id=").append(ContentUris.parseId(uri)).toString();
            c = null;
            return;
        }
    }
}
