// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.stat.event;

import android.content.Context;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.json.JSONObject;

// Referenced classes of package com.tencent.stat.event:
//            Event, EventType

public class ErrorEvent extends Event
{

    private String a;
    private int b;
    private int c;

    public ErrorEvent(Context context, int i, int j, Throwable throwable)
    {
        super(context, i);
        c = 100;
        StackTraceElement astacktraceelement[] = throwable.getStackTrace();
        if (astacktraceelement != null && astacktraceelement.length > c)
        {
            StackTraceElement astacktraceelement1[] = new StackTraceElement[c];
            for (int k = 0; k < c; k++)
            {
                astacktraceelement1[k] = astacktraceelement[k];
            }

            throwable.setStackTrace(astacktraceelement1);
        }
        StringWriter stringwriter = new StringWriter();
        PrintWriter printwriter = new PrintWriter(stringwriter);
        throwable.printStackTrace(printwriter);
        a = stringwriter.toString();
        b = j;
        printwriter.close();
    }

    public ErrorEvent(Context context, int i, String s)
    {
        super(context, i);
        c = 100;
        a = s;
        b = 0;
    }

    public EventType getType()
    {
        return EventType.ERROR;
    }

    public boolean onEncode(JSONObject jsonobject)
    {
        jsonobject.put("er", a);
        jsonobject.put("ea", b);
        return true;
    }
}
