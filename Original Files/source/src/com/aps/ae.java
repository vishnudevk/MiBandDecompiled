// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aps;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ae
{

    protected File a;
    protected int b[];
    private ArrayList c;
    private boolean d;

    protected ae(File file, ArrayList arraylist, int ai[])
    {
        d = false;
        a = file;
        c = arraylist;
        b = ai;
    }

    protected final void a(boolean flag)
    {
        d = flag;
    }

    public byte[] a()
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        DataOutputStream dataoutputstream = new DataOutputStream(bytearrayoutputstream);
        for (Iterator iterator = c.iterator(); iterator.hasNext();)
        {
            byte abyte0[] = (byte[])iterator.next();
            try
            {
                dataoutputstream.writeInt(abyte0.length);
                dataoutputstream.write(abyte0);
            }
            catch (IOException ioexception1) { }
        }

        try
        {
            bytearrayoutputstream.close();
            dataoutputstream.close();
        }
        catch (IOException ioexception) { }
        return bytearrayoutputstream.toByteArray();
    }

    protected final boolean b()
    {
        return d;
    }

    protected final int c()
    {
        if (c == null)
        {
            return 0;
        }
        int i = 0;
        int j = 0;
        while (i < c.size()) 
        {
            int k;
            if (c.get(i) != null)
            {
                k = ((byte[])c.get(i)).length;
            } else
            {
                k = 0;
            }
            j += k;
            i++;
        }
        return j;
    }
}
