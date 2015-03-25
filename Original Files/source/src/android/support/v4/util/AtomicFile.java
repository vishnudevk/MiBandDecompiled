// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.util;

import android.util.Log;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AtomicFile
{

    private final File a;
    private final File b;

    public AtomicFile(File file)
    {
        a = file;
        b = new File((new StringBuilder()).append(file.getPath()).append(".bak").toString());
    }

    static boolean a(FileOutputStream fileoutputstream)
    {
        if (fileoutputstream != null)
        {
            try
            {
                fileoutputstream.getFD().sync();
            }
            catch (IOException ioexception)
            {
                return false;
            }
        }
        return true;
    }

    public void delete()
    {
        a.delete();
        b.delete();
    }

    public void failWrite(FileOutputStream fileoutputstream)
    {
        if (fileoutputstream == null)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        a(fileoutputstream);
        fileoutputstream.close();
        a.delete();
        b.renameTo(a);
        return;
        IOException ioexception;
        ioexception;
        Log.w("AtomicFile", "failWrite: Got exception:", ioexception);
        return;
    }

    public void finishWrite(FileOutputStream fileoutputstream)
    {
        if (fileoutputstream == null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        a(fileoutputstream);
        fileoutputstream.close();
        b.delete();
        return;
        IOException ioexception;
        ioexception;
        Log.w("AtomicFile", "finishWrite: Got exception:", ioexception);
        return;
    }

    public File getBaseFile()
    {
        return a;
    }

    public FileInputStream openRead()
    {
        if (b.exists())
        {
            a.delete();
            b.renameTo(a);
        }
        return new FileInputStream(a);
    }

    public byte[] readFully()
    {
        int i;
        FileInputStream fileinputstream;
        i = 0;
        fileinputstream = openRead();
        byte abyte0[] = new byte[fileinputstream.available()];
_L1:
        int j = fileinputstream.read(abyte0, i, abyte0.length - i);
        int k;
        if (j <= 0)
        {
            fileinputstream.close();
            return abyte0;
        }
        k = j + i;
        byte abyte1[];
        int l = fileinputstream.available();
        if (l <= abyte0.length - k)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        abyte1 = new byte[l + k];
        System.arraycopy(abyte0, 0, abyte1, 0, k);
_L2:
        abyte0 = abyte1;
        i = k;
          goto _L1
        Exception exception;
        exception;
        fileinputstream.close();
        throw exception;
        abyte1 = abyte0;
          goto _L2
    }

    public FileOutputStream startWrite()
    {
        FileOutputStream fileoutputstream;
        if (a.exists())
        {
            if (!b.exists())
            {
                if (!a.renameTo(b))
                {
                    Log.w("AtomicFile", (new StringBuilder()).append("Couldn't rename file ").append(a).append(" to backup file ").append(b).toString());
                }
            } else
            {
                a.delete();
            }
        }
        try
        {
            fileoutputstream = new FileOutputStream(a);
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            if (!a.getParentFile().mkdir())
            {
                throw new IOException((new StringBuilder()).append("Couldn't create directory ").append(a).toString());
            }
            FileOutputStream fileoutputstream1;
            try
            {
                fileoutputstream1 = new FileOutputStream(a);
            }
            catch (FileNotFoundException filenotfoundexception1)
            {
                throw new IOException((new StringBuilder()).append("Couldn't create ").append(a).toString());
            }
            return fileoutputstream1;
        }
        return fileoutputstream;
    }
}
