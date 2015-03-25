// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.cache.disc.impl.ext;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.Charset;

final class g
{

    static final Charset a = Charset.forName("US-ASCII");
    static final Charset b = Charset.forName("UTF-8");

    private g()
    {
    }

    static String a(Reader reader)
    {
        StringWriter stringwriter;
        char ac[];
        stringwriter = new StringWriter();
        ac = new char[1024];
_L1:
        int i = reader.read(ac);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        stringwriter.write(ac, 0, i);
          goto _L1
        Exception exception;
        exception;
        reader.close();
        throw exception;
        String s = stringwriter.toString();
        reader.close();
        return s;
    }

    static void a(Closeable closeable)
    {
        if (closeable == null)
        {
            break MISSING_BLOCK_LABEL_10;
        }
        closeable.close();
        return;
        RuntimeException runtimeexception;
        runtimeexception;
        throw runtimeexception;
        Exception exception;
        exception;
    }

    static void a(File file)
    {
        File afile[] = file.listFiles();
        if (afile == null)
        {
            throw new IOException((new StringBuilder()).append("not a readable directory: ").append(file).toString());
        }
        int i = afile.length;
        for (int j = 0; j < i; j++)
        {
            File file1 = afile[j];
            if (file1.isDirectory())
            {
                a(file1);
            }
            if (!file1.delete())
            {
                throw new IOException((new StringBuilder()).append("failed to delete file: ").append(file1).toString());
            }
        }

    }

}
