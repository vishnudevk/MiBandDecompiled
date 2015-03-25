// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.miui.analyticstracker.utils;

import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5
{

    private static final String a = "MD5";

    public MD5()
    {
    }

    public static String calculateMD5(File file)
    {
        String s = null;
        MessageDigest messagedigest;
        FileInputStream fileinputstream;
        byte abyte0[];
        messagedigest = MessageDigest.getInstance("MD5");
        fileinputstream = new FileInputStream(file);
        abyte0 = new byte[8192];
_L1:
        int i = fileinputstream.read(abyte0);
label0:
        {
            if (i <= 0)
            {
                break label0;
            }
            BigInteger biginteger;
            Object aobj[];
            try
            {
                messagedigest.update(abyte0, 0, i);
            }
            catch (NoSuchAlgorithmException nosuchalgorithmexception)
            {
                return s;
            }
            catch (FileNotFoundException filenotfoundexception)
            {
                return s;
            }
            catch (IOException ioexception)
            {
                throw new RuntimeException("Unable to process file for MD5", ioexception);
            }
        }
          goto _L1
        biginteger = new BigInteger(1, messagedigest.digest());
        aobj = new Object[1];
        aobj[0] = biginteger.toString(16);
        s = String.format("%32s", aobj).replace(' ', '0');
        fileinputstream.close();
        return s;
    }

    public static boolean checkMD5(String s, File file)
    {
        boolean flag = false;
        if (!TextUtils.isEmpty(s) && file != null && file.exists()) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        Log.d("Update file server md5:", s);
        String s1;
        try
        {
            s1 = calculateMD5(file);
        }
        catch (RuntimeException runtimeexception)
        {
            runtimeexception.printStackTrace();
            return flag;
        }
        flag = false;
        if (s1 == null) goto _L1; else goto _L3
_L3:
        flag = s1.equalsIgnoreCase(s);
        Log.d("Update file local md5:", s1);
        return flag;
    }

    public static String getMd5Digest(String s)
    {
        String s1;
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update(s.getBytes());
            s1 = String.format("%1$032X", new Object[] {
                new BigInteger(1, messagedigest.digest())
            });
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            return "";
        }
        return s1;
    }

    public static String getRecoveryMD5()
    {
        String s;
        try
        {
            Process process = Runtime.getRuntime().exec("su");
            OutputStream outputstream = process.getOutputStream();
            outputstream.write((new StringBuilder()).append("md5sum ").append("/dev/mtd/mtd1").toString().getBytes());
            outputstream.flush();
            outputstream.close();
            InputStream inputstream = process.getInputStream();
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
            s = bufferedreader.readLine().split("  ")[0].trim();
            inputstream.close();
            bufferedreader.close();
            process.destroy();
        }
        catch (Exception exception)
        {
            Log.e("MD5", "Exception on getting Recovery MD5", exception);
            return null;
        }
        Log.i("MD5", (new StringBuilder()).append("Recovery MD5: ").append(s).toString());
        return s;
    }
}
