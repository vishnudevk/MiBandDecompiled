// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.market.sdk;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.xiaomi.market.sdk:
//            i, c

public class e extends i
{

    final c a;
    private File c;

    public e(c c1, File file)
    {
        a = c1;
        super(c1, new FileOutputStream(file));
        c = file;
    }

    public void reset()
    {
        try
        {
            S.close();
        }
        catch (IOException ioexception) { }
        c.delete();
        try
        {
            S = new FileOutputStream(c);
            return;
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            return;
        }
    }
}
