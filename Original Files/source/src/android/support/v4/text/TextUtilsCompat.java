// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.text;

import java.util.Locale;

// Referenced classes of package android.support.v4.text:
//            ICUCompat

public class TextUtilsCompat
{

    public static final Locale ROOT = new Locale("", "");
    private static String a = "Arab";
    private static String b = "Hebr";

    public TextUtilsCompat()
    {
    }

    private static int a(Locale locale)
    {
        switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0)))
        {
        default:
            return 0;

        case 1: // '\001'
        case 2: // '\002'
            return 1;
        }
    }

    public static int getLayoutDirectionFromLocale(Locale locale)
    {
        if (locale != null && !locale.equals(ROOT))
        {
            String s = ICUCompat.getScript(ICUCompat.addLikelySubtags(locale.toString()));
            if (s == null)
            {
                return a(locale);
            }
            if (s.equalsIgnoreCase(a) || s.equalsIgnoreCase(b))
            {
                return 1;
            }
        }
        return 0;
    }

    public static String htmlEncode(String s)
    {
        StringBuilder stringbuilder;
        int i;
        stringbuilder = new StringBuilder();
        i = 0;
_L8:
        char c;
        if (i >= s.length())
        {
            break MISSING_BLOCK_LABEL_138;
        }
        c = s.charAt(i);
        c;
        JVM INSTR lookupswitch 5: default 76
    //                   34: 128
    //                   38: 108
    //                   39: 118
    //                   60: 88
    //                   62: 98;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L2:
        break MISSING_BLOCK_LABEL_128;
_L5:
        break; /* Loop/switch isn't completed */
_L1:
        stringbuilder.append(c);
_L9:
        i++;
        if (true) goto _L8; else goto _L7
_L7:
        stringbuilder.append("&lt;");
          goto _L9
_L6:
        stringbuilder.append("&gt;");
          goto _L9
_L3:
        stringbuilder.append("&amp;");
          goto _L9
_L4:
        stringbuilder.append("&#39;");
          goto _L9
        stringbuilder.append("&quot;");
          goto _L9
        return stringbuilder.toString();
    }

}
