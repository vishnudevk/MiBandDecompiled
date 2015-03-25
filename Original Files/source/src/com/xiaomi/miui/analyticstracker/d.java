// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.miui.analyticstracker;

import android.content.Context;
import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
import com.xiaomi.miui.analyticstracker.service.DispatcherHelper;
import com.xiaomi.miui.analyticstracker.utils.EventUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.xiaomi.miui.analyticstracker:
//            f, ObjectBuilder, TrackEvent, LogEvent, 
//            TrackPageViewEvent, i, Event, j, 
//            Item, g

class d
{

    private static final int a = 1;
    private static final int b = 2;
    private static final int c = 3;
    private boolean d;
    private f e;
    private Context f;
    private j g;
    private ObjectBuilder h;
    private ObjectBuilder i;
    private Handler j;
    private Object k;
    private DispatcherHelper l;
    private long m;

    public d()
    {
        d = false;
        e = f.a;
        h = new ObjectBuilder();
        i = new ObjectBuilder();
        k = new Object();
        l = null;
        i.registerClass(com/xiaomi/miui/analyticstracker/TrackEvent, "2");
        i.registerClass(com/xiaomi/miui/analyticstracker/LogEvent, "1");
        i.registerClass(com/xiaomi/miui/analyticstracker/TrackPageViewEvent, "3");
        h.registerClass(com/xiaomi/miui/analyticstracker/i, "ANALYTICS.SQLITESTORE");
    }

    static Handler a(d d1, Handler handler)
    {
        d1.j = handler;
        return handler;
    }

    static Object a(d d1)
    {
        return d1.k;
    }

    static void a(d d1, Event event)
    {
        d1.b(event);
    }

    private void b()
    {
        l = new DispatcherHelper(f);
        m = 0L;
        boolean flag = EventUtils.enableWrite(f);
        d = flag;
        if (flag)
        {
            String s = EventUtils.getDatabaseName();
            c(s);
            b(s);
        }
    }

    private void b(Event event)
    {
        if (g != null && f.a == e && d)
        {
            event.writeEvent(g);
        }
        if (l != null && System.currentTimeMillis() - m >= 0x36ee80L)
        {
            m = System.currentTimeMillis();
            l.dispatch();
        }
    }

    static void b(d d1)
    {
        d1.b();
    }

    private void b(String s)
    {
        g = (j)h.buildObject("ANALYTICS.SQLITESTORE");
        g.a(f, s);
    }

    private void c()
    {
        if (g != null)
        {
            g.a();
            g = null;
        }
        f = null;
    }

    static void c(d d1)
    {
        d1.c();
    }

    private void c(String s)
    {
        long l1 = EventUtils.getDay(System.currentTimeMillis());
        File file = f.getDatabasePath(s);
        if (file.exists() && l1 - (long)EventUtils.getDay(file.lastModified()) >= 7L)
        {
            EventUtils.deleteDatabaseFile(f, s);
        }
    }

    static Handler d(d d1)
    {
        return d1.j;
    }

    public List a(String s, List list)
    {
        Cursor cursor;
        ArrayList arraylist;
        if (g == null)
        {
            break MISSING_BLOCK_LABEL_200;
        }
        cursor = g.a(s);
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_200;
        }
        arraylist = new ArrayList();
_L2:
        Event event;
        do
        {
            if (!cursor.moveToNext())
            {
                break MISSING_BLOCK_LABEL_181;
            }
            int i1 = cursor.getInt(cursor.getColumnIndexOrThrow("type"));
            event = (Event)i.buildObject((new StringBuilder()).append(i1).append("").toString());
        } while (event == null);
        Iterator iterator;
        event.restore(cursor);
        iterator = list.iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        Item item = (Item)iterator.next();
        if (!item.idMatches(event.getEventId()) || !item.isDispatch(android.os.Build.VERSION.INCREMENTAL)) goto _L4; else goto _L3
_L3:
        event.setPolicy(item.getPolicy());
        arraylist.add(event);
          goto _L2
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        illegalargumentexception.printStackTrace();
        cursor.close();
        g.b(s);
        return arraylist;
        return Collections.emptyList();
    }

    public void a()
    {
        if (j != null)
        {
            Message message = new Message();
            message.what = 3;
            j.sendMessage(message);
            return;
        } else
        {
            c();
            return;
        }
    }

    public void a(Context context)
    {
        f = context.getApplicationContext();
        e = f.a;
        Object obj = k;
        obj;
        JVM INSTR monitorenter ;
        (new g(this, null)).start();
        Exception exception;
        Message message;
        try
        {
            k.wait();
        }
        catch (InterruptedException interruptedexception) { }
        message = new Message();
        message.what = 1;
        j.sendMessage(message);
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(Context context, String s)
    {
        f = context.getApplicationContext();
        e = f.b;
        b(s);
    }

    public void a(Event event)
    {
        if (j != null)
        {
            Message message = new Message();
            message.what = 2;
            message.obj = event.clone();
            j.sendMessage(message);
        }
    }

    public void a(String s, long l1)
    {
        a(((Event) (new TrackEvent(s, null, l1))));
    }

    public boolean a(String s)
    {
        j j1 = (j)h.buildObject(s);
        if (j1 != null)
        {
            if (g != null && j1 != g)
            {
                g.a();
            }
            g = j1;
            return true;
        } else
        {
            return false;
        }
    }
}
