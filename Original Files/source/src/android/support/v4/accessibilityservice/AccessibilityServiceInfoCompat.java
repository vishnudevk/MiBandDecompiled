// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.accessibilityservice;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.ResolveInfo;

// Referenced classes of package android.support.v4.accessibilityservice:
//            b, a, c, d

public class AccessibilityServiceInfoCompat
{

    public static final int CAPABILITY_CAN_FILTER_KEY_EVENTS = 8;
    public static final int CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 4;
    public static final int CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION = 2;
    public static final int CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT = 1;
    public static final int DEFAULT = 1;
    public static final int FEEDBACK_ALL_MASK = -1;
    public static final int FEEDBACK_BRAILLE = 32;
    public static final int FLAG_INCLUDE_NOT_IMPORTANT_VIEWS = 2;
    public static final int FLAG_REPORT_VIEW_IDS = 16;
    public static final int FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 8;
    public static final int FLAG_REQUEST_FILTER_KEY_EVENTS = 32;
    public static final int FLAG_REQUEST_TOUCH_EXPLORATION_MODE = 4;
    private static final d a;

    private AccessibilityServiceInfoCompat()
    {
    }

    public static String capabilityToString(int i)
    {
        switch (i)
        {
        case 3: // '\003'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        default:
            return "UNKNOWN";

        case 1: // '\001'
            return "CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT";

        case 2: // '\002'
            return "CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION";

        case 4: // '\004'
            return "CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY";

        case 8: // '\b'
            return "CAPABILITY_CAN_FILTER_KEY_EVENTS";
        }
    }

    public static String feedbackTypeToString(int i)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("[");
        do
        {
            if (i > 0)
            {
                int j = 1 << Integer.numberOfTrailingZeros(i);
                i &= ~j;
                if (stringbuilder.length() > 1)
                {
                    stringbuilder.append(", ");
                }
                switch (j)
                {
                case 1: // '\001'
                    stringbuilder.append("FEEDBACK_SPOKEN");
                    break;

                case 4: // '\004'
                    stringbuilder.append("FEEDBACK_AUDIBLE");
                    break;

                case 2: // '\002'
                    stringbuilder.append("FEEDBACK_HAPTIC");
                    break;

                case 16: // '\020'
                    stringbuilder.append("FEEDBACK_GENERIC");
                    break;

                case 8: // '\b'
                    stringbuilder.append("FEEDBACK_VISUAL");
                    break;
                }
            } else
            {
                stringbuilder.append("]");
                return stringbuilder.toString();
            }
        } while (true);
    }

    public static String flagToString(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
            return "DEFAULT";

        case 2: // '\002'
            return "FLAG_INCLUDE_NOT_IMPORTANT_VIEWS";

        case 4: // '\004'
            return "FLAG_REQUEST_TOUCH_EXPLORATION_MODE";

        case 8: // '\b'
            return "FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY";

        case 16: // '\020'
            return "FLAG_REPORT_VIEW_IDS";

        case 32: // ' '
            return "FLAG_REQUEST_FILTER_KEY_EVENTS";
        }
    }

    public static boolean getCanRetrieveWindowContent(AccessibilityServiceInfo accessibilityserviceinfo)
    {
        return a.a(accessibilityserviceinfo);
    }

    public static int getCapabilities(AccessibilityServiceInfo accessibilityserviceinfo)
    {
        return a.f(accessibilityserviceinfo);
    }

    public static String getDescription(AccessibilityServiceInfo accessibilityserviceinfo)
    {
        return a.b(accessibilityserviceinfo);
    }

    public static String getId(AccessibilityServiceInfo accessibilityserviceinfo)
    {
        return a.c(accessibilityserviceinfo);
    }

    public static ResolveInfo getResolveInfo(AccessibilityServiceInfo accessibilityserviceinfo)
    {
        return a.d(accessibilityserviceinfo);
    }

    public static String getSettingsActivityName(AccessibilityServiceInfo accessibilityserviceinfo)
    {
        return a.e(accessibilityserviceinfo);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 18)
        {
            a = new b();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            a = new a();
        } else
        {
            a = new c();
        }
    }
}
