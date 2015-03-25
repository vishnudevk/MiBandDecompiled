// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.zxing.client.result:
//            ResultParser, SMSParsedResult, ParsedResult

public final class SMSMMSResultParser extends ResultParser
{

    public SMSMMSResultParser()
    {
    }

    private static void a(Collection collection, Collection collection1, String s)
    {
        int i = s.indexOf(';');
        if (i < 0)
        {
            collection.add(s);
            collection1.add(null);
            return;
        }
        collection.add(s.substring(0, i));
        String s1 = s.substring(i + 1);
        boolean flag = s1.startsWith("via=");
        String s2 = null;
        if (flag)
        {
            s2 = s1.substring(4);
        }
        collection1.add(s2);
    }

    public volatile ParsedResult parse(Result result)
    {
        return parse(result);
    }

    public SMSParsedResult parse(Result result)
    {
        String s = result.getText();
        if (!s.startsWith("sms:") && !s.startsWith("SMS:") && !s.startsWith("mms:") && !s.startsWith("MMS:"))
        {
            return null;
        }
        Map map = b(s);
        boolean flag;
        String s1;
        String s2;
        int i;
        String s3;
        int j;
        ArrayList arraylist;
        ArrayList arraylist1;
        if (map != null && !map.isEmpty())
        {
            String s4 = (String)map.get("subject");
            s1 = (String)map.get("body");
            s2 = s4;
            flag = true;
        } else
        {
            flag = false;
            s1 = null;
            s2 = null;
        }
        i = s.indexOf('?', 4);
        if (i < 0 || !flag)
        {
            s3 = s.substring(4);
        } else
        {
            s3 = s.substring(4, i);
        }
        j = -1;
        arraylist = new ArrayList(1);
        arraylist1 = new ArrayList(1);
        do
        {
            int k = s3.indexOf(',', j + 1);
            if (k > j)
            {
                a(arraylist, arraylist1, s3.substring(j + 1, k));
                j = k;
            } else
            {
                a(arraylist, arraylist1, s3.substring(j + 1));
                return new SMSParsedResult((String[])arraylist.toArray(new String[arraylist.size()]), (String[])arraylist1.toArray(new String[arraylist1.size()]), s2, s1);
            }
        } while (true);
    }
}
