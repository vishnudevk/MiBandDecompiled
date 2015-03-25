// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.stat;

import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.common.StatPreferences;
import com.tencent.stat.event.Event;
import com.tencent.stat.event.EventType;

// Referenced classes of package com.tencent.stat:
//            StatConfig, StatStore, i, c, 
//            StatService, StatReportStrategy, g, j

class h
    implements Runnable
{

    private Event a;
    private StatReportStrategy b;

    public h(Event event)
    {
        b = null;
        a = event;
        b = StatConfig.getStatSendStrategy();
    }

    static Event a(h h1)
    {
        return h1.a;
    }

    private void a()
    {
        if (StatStore.getInstance().getNumStoredEvents() > 0)
        {
            StatStore.getInstance().b(a, null);
            StatStore.getInstance().a(-1);
            return;
        } else
        {
            a(true);
            return;
        }
    }

    private void a(boolean flag)
    {
        i k = null;
        if (flag)
        {
            k = new i(this);
        }
        c.b().a(a, k);
    }

    public void run()
    {
        if (StatConfig.isEnableStatService()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        android.content.Context context;
        if (a.getType() != EventType.ERROR && a.toJsonString().length() > StatConfig.getMaxReportEventLength())
        {
            StatService.b().e((new StringBuilder()).append("Event length exceed StatConfig.getMaxReportEventLength(): ").append(StatConfig.getMaxReportEventLength()).toString());
            return;
        }
        if (StatConfig.getMaxSessionStatReportCount() > 0)
        {
            if (StatConfig.getCurSessionStatReportCount() >= StatConfig.getMaxSessionStatReportCount())
            {
                StatService.b().e("Times for reporting events has reached the limit of StatConfig.getMaxSessionStatReportCount() in current session.");
                return;
            }
            StatConfig.c();
        }
        StatService.b().i((new StringBuilder()).append("Lauch stat task in thread:").append(Thread.currentThread().getName()).toString());
        context = a.getContext();
        if (!StatCommonHelper.isNetworkAvailable(context))
        {
            StatStore.getInstance(context).b(a, null);
            return;
        }
        if (StatConfig.isEnableSmartReporting() && b != StatReportStrategy.ONLY_WIFI_NO_CACHE && StatCommonHelper.isWifiNet(context))
        {
            b = StatReportStrategy.INSTANT;
        }
        switch (g.a[b.ordinal()])
        {
        default:
            StatService.b().error((new StringBuilder()).append("Invalid stat strategy:").append(StatConfig.getStatSendStrategy()).toString());
            return;

        case 7: // '\007'
            continue; /* Loop/switch isn't completed */

        case 1: // '\001'
            a();
            return;

        case 2: // '\002'
            if (StatCommonHelper.isWiFiActive(context))
            {
                a();
                return;
            } else
            {
                StatStore.getInstance(context).b(a, null);
                return;
            }

        case 3: // '\003'
        case 4: // '\004'
            StatStore.getInstance(context).b(a, null);
            return;

        case 5: // '\005'
            if (StatStore.getInstance(a.getContext()) != null)
            {
                StatStore.getInstance(context).b(a, new j(this));
                return;
            }
            break;

        case 6: // '\006'
            try
            {
                StatStore.getInstance(context).b(a, null);
                Long long1 = Long.valueOf(StatPreferences.getLong(context, "last_period_ts", 0L));
                Long long2 = Long.valueOf(System.currentTimeMillis());
                if (Long.valueOf(Long.valueOf(long2.longValue() - long1.longValue()).longValue() / 60000L).longValue() > (long)StatConfig.getSendPeriodMinutes())
                {
                    StatStore.getInstance(context).a(-1);
                    StatPreferences.putLong(context, "last_period_ts", long2.longValue());
                    return;
                }
            }
            catch (Exception exception)
            {
                StatService.b().e(exception);
                return;
            }
            break;
        }
        continue; /* Loop/switch isn't completed */
        if (!StatCommonHelper.isWiFiActive(context)) goto _L1; else goto _L3
_L3:
        a(false);
        return;
        if (true) goto _L1; else goto _L4
_L4:
    }
}
