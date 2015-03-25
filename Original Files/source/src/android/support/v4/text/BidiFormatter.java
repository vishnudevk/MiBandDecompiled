// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.text;

import java.util.Locale;

// Referenced classes of package android.support.v4.text:
//            TextDirectionHeuristicsCompat, b, TextDirectionHeuristicCompat, TextUtilsCompat, 
//            a

public final class BidiFormatter
{

    private static TextDirectionHeuristicCompat a;
    private static final char b = 8234;
    private static final char c = 8235;
    private static final char d = 8236;
    private static final char e = 8206;
    private static final char f = 8207;
    private static final String g = Character.toString('\u200E');
    private static final String h = Character.toString('\u200F');
    private static final String i = "";
    private static final int j = 2;
    private static final int k = 2;
    private static final BidiFormatter l;
    private static final BidiFormatter m;
    private static final int q = -1;
    private static final int r = 0;
    private static final int s = 1;
    private final boolean n;
    private final int o;
    private final TextDirectionHeuristicCompat p;

    private BidiFormatter(boolean flag, int i1, TextDirectionHeuristicCompat textdirectionheuristiccompat)
    {
        n = flag;
        o = i1;
        p = textdirectionheuristiccompat;
    }

    BidiFormatter(boolean flag, int i1, TextDirectionHeuristicCompat textdirectionheuristiccompat, a a1)
    {
        this(flag, i1, textdirectionheuristiccompat);
    }

    private static int a(String s1)
    {
        return (new b(s1, false)).b();
    }

    static TextDirectionHeuristicCompat a()
    {
        return a;
    }

    private String a(String s1, TextDirectionHeuristicCompat textdirectionheuristiccompat)
    {
        boolean flag = textdirectionheuristiccompat.isRtl(s1, 0, s1.length());
        if (!n && (flag || a(s1) == 1))
        {
            return g;
        }
        if (n && (!flag || a(s1) == -1))
        {
            return h;
        } else
        {
            return "";
        }
    }

    static boolean a(Locale locale)
    {
        return b(locale);
    }

    private static int b(String s1)
    {
        return (new b(s1, false)).a();
    }

    static BidiFormatter b()
    {
        return m;
    }

    private String b(String s1, TextDirectionHeuristicCompat textdirectionheuristiccompat)
    {
        boolean flag = textdirectionheuristiccompat.isRtl(s1, 0, s1.length());
        if (!n && (flag || b(s1) == 1))
        {
            return g;
        }
        if (n && (!flag || b(s1) == -1))
        {
            return h;
        } else
        {
            return "";
        }
    }

    private static boolean b(Locale locale)
    {
        return TextUtilsCompat.getLayoutDirectionFromLocale(locale) == 1;
    }

    static BidiFormatter c()
    {
        return l;
    }

    public static BidiFormatter getInstance()
    {
        return (new Builder()).build();
    }

    public static BidiFormatter getInstance(Locale locale)
    {
        return (new Builder(locale)).build();
    }

    public static BidiFormatter getInstance(boolean flag)
    {
        return (new Builder(flag)).build();
    }

    public boolean getStereoReset()
    {
        return (2 & o) != 0;
    }

    public boolean isRtl(String s1)
    {
        return p.isRtl(s1, 0, s1.length());
    }

    public boolean isRtlContext()
    {
        return n;
    }

    public String unicodeWrap(String s1)
    {
        return unicodeWrap(s1, p, true);
    }

    public String unicodeWrap(String s1, TextDirectionHeuristicCompat textdirectionheuristiccompat)
    {
        return unicodeWrap(s1, textdirectionheuristiccompat, true);
    }

    public String unicodeWrap(String s1, TextDirectionHeuristicCompat textdirectionheuristiccompat, boolean flag)
    {
        boolean flag1 = textdirectionheuristiccompat.isRtl(s1, 0, s1.length());
        StringBuilder stringbuilder = new StringBuilder();
        if (getStereoReset() && flag)
        {
            TextDirectionHeuristicCompat textdirectionheuristiccompat2;
            if (flag1)
            {
                textdirectionheuristiccompat2 = TextDirectionHeuristicsCompat.RTL;
            } else
            {
                textdirectionheuristiccompat2 = TextDirectionHeuristicsCompat.LTR;
            }
            stringbuilder.append(b(s1, textdirectionheuristiccompat2));
        }
        if (flag1 != n)
        {
            char c1;
            if (flag1)
            {
                c1 = '\u202B';
            } else
            {
                c1 = '\u202A';
            }
            stringbuilder.append(c1);
            stringbuilder.append(s1);
            stringbuilder.append('\u202C');
        } else
        {
            stringbuilder.append(s1);
        }
        if (flag)
        {
            TextDirectionHeuristicCompat textdirectionheuristiccompat1;
            if (flag1)
            {
                textdirectionheuristiccompat1 = TextDirectionHeuristicsCompat.RTL;
            } else
            {
                textdirectionheuristiccompat1 = TextDirectionHeuristicsCompat.LTR;
            }
            stringbuilder.append(a(s1, textdirectionheuristiccompat1));
        }
        return stringbuilder.toString();
    }

    public String unicodeWrap(String s1, boolean flag)
    {
        return unicodeWrap(s1, p, flag);
    }

    static 
    {
        a = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        l = new BidiFormatter(false, 2, a);
        m = new BidiFormatter(true, 2, a);
    }

    private class Builder
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

        public Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat textdirectionheuristiccompat)
        {
            c = textdirectionheuristiccompat;
            return this;
        }

        public Builder stereoReset(boolean flag)
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

        public Builder()
        {
            a(BidiFormatter.a(Locale.getDefault()));
        }

        public Builder(Locale locale)
        {
            a(BidiFormatter.a(locale));
        }

        public Builder(boolean flag)
        {
            a(flag);
        }
    }

}
