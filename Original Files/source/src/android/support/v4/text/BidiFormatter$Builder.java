// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.text;

import java.util.Locale;

// Referenced classes of package android.support.v4.text:
//            BidiFormatter, TextDirectionHeuristicCompat

public final class a
{

    private boolean a;
    private int b;
    private TextDirectionHeuristicCompat c;

    private void a(boolean flag)
    {
        a = flag;
        c = BidiFormatter.a();
        b = 2;
    }

    private static BidiFormatter b(boolean flag)
    {
        if (flag)
        {
            return BidiFormatter.b();
        } else
        {
            return BidiFormatter.c();
        }
    }

    public BidiFormatter build()
    {
        if (b == 2 && c == BidiFormatter.a())
        {
            return b(a);
        } else
        {
            return new BidiFormatter(a, b, c, null);
        }
    }

    public Compat setTextDirectionHeuristic(TextDirectionHeuristicCompat textdirectionheuristiccompat)
    {
        c = textdirectionheuristiccompat;
        return this;
    }

    public c stereoReset(boolean flag)
    {
        if (flag)
        {
            b = 2 | b;
            return this;
        } else
        {
            b = -3 & b;
            return this;
        }
    }

    public Compat()
    {
        a(BidiFormatter.a(Locale.getDefault()));
    }

    public a(Locale locale)
    {
        a(BidiFormatter.a(locale));
    }

    public a(boolean flag)
    {
        a(flag);
    }
}
