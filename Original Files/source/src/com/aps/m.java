// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aps;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

// Referenced classes of package com.aps:
//            R, t, Q, c

public class m
{

    protected m()
    {
    }

    String a(String s)
    {
        if (s == null || s.length() == 0)
        {
            return null;
        }
        ByteArrayInputStream bytearrayinputstream;
        R r;
        try
        {
            bytearrayinputstream = new ByteArrayInputStream(s.getBytes("UTF-8"));
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            bytearrayinputstream = null;
        }
        r = new R(null);
        if (bytearrayinputstream == null)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        SAXParserFactory.newInstance().newSAXParser().parse(bytearrayinputstream, r);
        bytearrayinputstream.close();
_L2:
        return r.a;
        Throwable throwable;
        throwable;
        throwable.printStackTrace();
        t.a(throwable);
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        throw exception;
        SAXException saxexception;
        saxexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    c b(String s)
    {
        while (s == null || s.length() == 0 || s.contains("SuccessCode=\"0\"")) 
        {
            return null;
        }
        ByteArrayInputStream bytearrayinputstream;
        SAXParserFactory saxparserfactory;
        Q q;
        try
        {
            bytearrayinputstream = new ByteArrayInputStream(s.getBytes("UTF-8"));
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            bytearrayinputstream = null;
        }
        saxparserfactory = SAXParserFactory.newInstance();
        q = new Q(null);
        if (bytearrayinputstream == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        saxparserfactory.newSAXParser().parse(bytearrayinputstream, q);
        bytearrayinputstream.close();
_L2:
        q.a.c("network");
        if (q.a.g() == 0L)
        {
            q.a.a(t.a());
        }
        return q.a;
        Throwable throwable;
        throwable;
        throwable.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }
}
