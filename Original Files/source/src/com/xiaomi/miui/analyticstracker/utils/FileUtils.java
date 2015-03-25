// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.miui.analyticstracker.utils;

import android.content.Context;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class FileUtils
{

    public FileUtils()
    {
    }

    public static boolean expired(File file)
    {
        return file == null || System.currentTimeMillis() - file.lastModified() >= 0x5265c00L;
    }

    public static File getFileByName(Context context, String s, boolean flag)
    {
        File file = new File((new StringBuilder()).append(context.getFilesDir()).append("/").toString(), s);
        if (flag && !file.exists())
        {
            file.createNewFile();
        }
        return file;
    }

    public static String getFileContent(File file)
    {
        if (file != null)
        {
            StringBuilder stringbuilder = new StringBuilder();
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            for (String s = bufferedreader.readLine(); s != null; s = bufferedreader.readLine())
            {
                stringbuilder.append(s).append("\n");
            }

            bufferedreader.close();
            return stringbuilder.toString();
        } else
        {
            return "";
        }
    }

    public static void writeFile(File file, String s)
    {
        if (file != null)
        {
            PrintStream printstream = new PrintStream(file);
            printstream.println(s);
            printstream.close();
        }
    }
}
