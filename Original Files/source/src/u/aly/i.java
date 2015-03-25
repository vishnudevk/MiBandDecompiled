// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package u.aly:
//            a, bv, bi

public class i extends a
{

    private static final String a = "utdid";
    private static final String b = "android.permission.WRITE_EXTERNAL_STORAGE";
    private static final Pattern c = Pattern.compile("UTDID\">([^<]+)");
    private Context d;

    public i(Context context)
    {
        super("utdid");
        d = context;
    }

    private String b(String s)
    {
        Matcher matcher;
        if (s != null)
        {
            if ((matcher = c.matcher(s)).find())
            {
                return matcher.group(1);
            }
        }
        return null;
    }

    private String g()
    {
        FileInputStream fileinputstream;
        File file = h();
        if (file == null || !file.exists())
        {
            return null;
        }
        String s;
        try
        {
            fileinputstream = new FileInputStream(file);
        }
        catch (Exception exception1)
        {
            exception1.printStackTrace();
            return null;
        }
        s = b(bv.a(fileinputstream));
        bv.c(fileinputstream);
        return s;
        Exception exception;
        exception;
        bv.c(fileinputstream);
        throw exception;
    }

    private File h()
    {
        while (!bi.a(d, "android.permission.WRITE_EXTERNAL_STORAGE") || !Environment.getExternalStorageState().equals("mounted")) 
        {
            return null;
        }
        File file = Environment.getExternalStorageDirectory();
        File file1;
        try
        {
            file1 = new File(file.getCanonicalPath(), ".UTSystemConfig/Global/Alvin2.xml");
        }
        catch (Exception exception)
        {
            return null;
        }
        return file1;
    }

    public String f()
    {
        return g();
    }

}
