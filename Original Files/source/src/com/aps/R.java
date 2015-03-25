// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aps;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

// Referenced classes of package com.aps:
//            P

class R extends DefaultHandler
{

    public String a;
    private boolean b;

    private R()
    {
        a = "";
        b = false;
    }

    R(P p)
    {
        this();
    }

    public void characters(char ac[], int i, int j)
    {
        if (b)
        {
            a = String.valueOf(ac, i, j);
        }
    }

    public void endElement(String s, String s1, String s2)
    {
        if (s1.equals("sres"))
        {
            b = false;
        }
    }

    public void startElement(String s, String s1, String s2, Attributes attributes)
    {
        if (s1.equals("sres"))
        {
            b = true;
        }
    }
}
