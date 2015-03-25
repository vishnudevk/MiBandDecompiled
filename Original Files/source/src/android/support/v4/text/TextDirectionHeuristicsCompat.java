// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.text;


// Referenced classes of package android.support.v4.text:
//            l, i, h, m, 
//            TextDirectionHeuristicCompat

public class TextDirectionHeuristicsCompat
{

    public static final TextDirectionHeuristicCompat ANYRTL_LTR;
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_LTR;
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_RTL;
    public static final TextDirectionHeuristicCompat LOCALE;
    public static final TextDirectionHeuristicCompat LTR = new l(null, false, null);
    public static final TextDirectionHeuristicCompat RTL = new l(null, true, null);
    private static final int a = 0;
    private static final int b = 1;
    private static final int c = 2;

    public TextDirectionHeuristicsCompat()
    {
    }

    static int a(int j)
    {
        return d(j);
    }

    static int b(int j)
    {
        return c(j);
    }

    private static int c(int j)
    {
        switch (j)
        {
        default:
            return 2;

        case 0: // '\0'
            return 1;

        case 1: // '\001'
        case 2: // '\002'
            return 0;
        }
    }

    private static int d(int j)
    {
        switch (j)
        {
        default:
            return 2;

        case 0: // '\0'
        case 14: // '\016'
        case 15: // '\017'
            return 1;

        case 1: // '\001'
        case 2: // '\002'
        case 16: // '\020'
        case 17: // '\021'
            return 0;
        }
    }

    static 
    {
        FIRSTSTRONG_LTR = new l(i.a, false, null);
        FIRSTSTRONG_RTL = new l(i.a, true, null);
        ANYRTL_LTR = new l(h.a, false, null);
        LOCALE = m.a;
    }
}
