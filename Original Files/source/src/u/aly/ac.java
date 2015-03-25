// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package u.aly:
//            am, p, an, bf, 
//            av

public class ac extends am
    implements p
{

    public ac()
    {
        a(System.currentTimeMillis());
        a(an.a);
    }

    public ac(String s)
    {
        this();
        a(s);
    }

    public ac(Throwable throwable)
    {
        this();
        a(a(throwable));
    }

    private String a(Throwable throwable)
    {
        PrintWriter printwriter;
        Throwable throwable1;
        String s = null;
        if (throwable == null)
        {
            return null;
        }
        StringWriter stringwriter;
        try
        {
            stringwriter = new StringWriter();
            printwriter = new PrintWriter(stringwriter);
            throwable.printStackTrace(printwriter);
            throwable1 = throwable.getCause();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return s;
        }
_L2:
        s = null;
        if (throwable1 != null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        s = stringwriter.toString();
        printwriter.close();
        stringwriter.close();
        return s;
        Throwable throwable2;
        throwable1.printStackTrace(printwriter);
        throwable2 = throwable1.getCause();
        throwable1 = throwable2;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public ac a(boolean flag)
    {
        an an1;
        if (flag)
        {
            an1 = an.a;
        } else
        {
            an1 = an.b;
        }
        a(an1);
        return this;
    }

    public void a(bf bf1, String s)
    {
        if (bf1.s() <= 0) goto _L2; else goto _L1
_L1:
        Iterator iterator = bf1.u().iterator();
_L5:
        if (iterator.hasNext()) goto _L3; else goto _L2
_L2:
        av av1 = null;
_L4:
        if (av1 == null)
        {
            av1 = new av();
            av1.a(s);
            bf1.a(av1);
        }
        av1.a(this);
        return;
_L3:
        av1 = (av)iterator.next();
        if (!s.equals(av1.c())) goto _L5; else goto _L4
    }
}
