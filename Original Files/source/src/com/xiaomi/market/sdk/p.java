// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.market.sdk;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;

// Referenced classes of package com.xiaomi.market.sdk:
//            n, m, XiaomiUpdateAgent, r, 
//            l, q, w, b

class p
    implements Runnable
{

    final n a;

    p(n n1)
    {
        a = n1;
        super();
    }

    public void run()
    {
        if (m.d(n.a(a)) != null && m.c(n.a(a)) != null && m.e(n.a(a)) != null) goto _L2; else goto _L1
_L1:
        m.a(n.a(a), XiaomiUpdateAgent.a(m.a(n.a(a))));
        if (m.d(n.a(a)) != null) goto _L4; else goto _L3
_L3:
        return;
_L4:
        Cursor cursor1;
        r r1 = r.j(m.a(n.a(a)));
        String as[] = l.aJ;
        String as1[] = new String[1];
        as1[0] = m.d(n.a(a)).packageName;
        cursor1 = r1.query("update_download", as, "package_name=?", as1, null, null, null);
        Cursor cursor;
        cursor = cursor1;
        if (cursor == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        String s;
        boolean flag;
        if (!cursor.moveToFirst())
        {
            continue; /* Loop/switch isn't completed */
        }
        m.a(n.a(a), cursor.getLong(cursor.getColumnIndex("download_id")));
        w w1 = new w();
        w1.d = cursor.getInt(cursor.getColumnIndex("version_code"));
        w1.f = cursor.getString(cursor.getColumnIndex("apk_url"));
        w1.g = cursor.getString(cursor.getColumnIndex("apk_hash"));
        w1.i = cursor.getString(cursor.getColumnIndex("diff_url"));
        w1.j = cursor.getString(cursor.getColumnIndex("diff_hash"));
        m.a(n.a(a), w1);
        s = cursor.getString(cursor.getColumnIndex("apk_path"));
        flag = TextUtils.isEmpty(s);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_330;
        }
        if (cursor == null) goto _L3; else goto _L5
_L5:
        cursor.close();
        return;
        m.a(n.a(a), new File(s));
        if (cursor != null)
        {
            cursor.close();
        }
_L2:
        Exception exception;
        String s1;
        if (!TextUtils.isEmpty(m.c(n.a(a)).i))
        {
            s1 = n.a(a, m.e(n.a(a)).getAbsolutePath(), m.c(n.a(a)).j);
        } else
        {
            s1 = m.e(n.a(a)).getAbsolutePath();
        }
        if (!TextUtils.isEmpty(m.c(n.a(a)).g) && !TextUtils.isEmpty(s1) && !TextUtils.equals(b.a(new File(s1)), m.c(n.a(a)).g)) goto _L3; else goto _L6
_L6:
        Uri uri = Uri.parse((new StringBuilder("file://")).append(s1).toString());
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(uri, "application/vnd.android.package-archive");
        intent.setFlags(0x10000000);
        m.a(n.a(a)).startActivity(intent);
        return;
        if (cursor == null) goto _L3; else goto _L7
_L7:
        cursor.close();
        return;
        exception;
        cursor = null;
_L9:
        if (cursor != null)
        {
            cursor.close();
        }
        throw exception;
        exception;
        if (true) goto _L9; else goto _L8
_L8:
    }
}
