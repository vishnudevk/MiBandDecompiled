// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

public class JsonWriter
    implements Closeable, Flushable
{

    private static final String a[];
    private static final String b[];
    private final Writer c;
    private int d[];
    private int e;
    private String f;
    private String g;
    private boolean h;
    private boolean i;
    private String j;
    private boolean k;

    public JsonWriter(Writer writer)
    {
        d = new int[32];
        e = 0;
        a(6);
        g = ":";
        k = true;
        if (writer == null)
        {
            throw new NullPointerException("out == null");
        } else
        {
            c = writer;
            return;
        }
    }

    private int a()
    {
        if (e == 0)
        {
            throw new IllegalStateException("JsonWriter is closed.");
        } else
        {
            return d[-1 + e];
        }
    }

    private JsonWriter a(int l, int i1, String s)
    {
        int j1 = a();
        if (j1 != i1 && j1 != l)
        {
            throw new IllegalStateException("Nesting problem.");
        }
        if (j != null)
        {
            throw new IllegalStateException((new StringBuilder()).append("Dangling name: ").append(j).toString());
        }
        e = -1 + e;
        if (j1 == i1)
        {
            c();
        }
        c.write(s);
        return this;
    }

    private JsonWriter a(int l, String s)
    {
        a(true);
        a(l);
        c.write(s);
        return this;
    }

    private void a(int l)
    {
        if (e == d.length)
        {
            int ai1[] = new int[2 * e];
            System.arraycopy(d, 0, ai1, 0, e);
            d = ai1;
        }
        int ai[] = d;
        int i1 = e;
        e = i1 + 1;
        ai[i1] = l;
    }

    private void a(String s)
    {
        int l;
        int i1;
        int j1;
        char c1;
        String s1;
        l = 0;
        String as[];
        if (i)
        {
            as = b;
        } else
        {
            as = a;
        }
        c.write("\"");
        i1 = s.length();
        j1 = 0;
        if (j1 >= i1)
        {
            break MISSING_BLOCK_LABEL_141;
        }
        c1 = s.charAt(j1);
        if (c1 >= '\200') goto _L2; else goto _L1
_L1:
        s1 = as[c1];
        if (s1 != null) goto _L4; else goto _L3
_L3:
        j1++;
        break MISSING_BLOCK_LABEL_31;
_L2:
        if (c1 != '\u2028')
        {
            continue; /* Loop/switch isn't completed */
        }
        s1 = "\\u2028";
_L4:
        if (l < j1)
        {
            c.write(s, l, j1 - l);
        }
        c.write(s1);
        l = j1 + 1;
        if (true) goto _L3; else goto _L5
_L5:
        if (c1 != '\u2029') goto _L3; else goto _L6
_L6:
        s1 = "\\u2029";
          goto _L4
        if (l < i1)
        {
            c.write(s, l, i1 - l);
        }
        c.write("\"");
        return;
    }

    private void a(boolean flag)
    {
        switch (a())
        {
        case 3: // '\003'
        case 5: // '\005'
        default:
            throw new IllegalStateException("Nesting problem.");

        case 7: // '\007'
            if (!h)
            {
                throw new IllegalStateException("JSON must have only one top-level value.");
            }
            // fall through

        case 6: // '\006'
            if (!h && !flag)
            {
                throw new IllegalStateException("JSON must start with an array or an object.");
            } else
            {
                b(7);
                return;
            }

        case 1: // '\001'
            b(2);
            c();
            return;

        case 2: // '\002'
            c.append(',');
            c();
            return;

        case 4: // '\004'
            c.append(g);
            b(5);
            return;
        }
    }

    private void b()
    {
        if (j != null)
        {
            d();
            a(j);
            j = null;
        }
    }

    private void b(int l)
    {
        d[-1 + e] = l;
    }

    private void c()
    {
        if (f != null)
        {
            c.write("\n");
            int l = 1;
            int i1 = e;
            while (l < i1) 
            {
                c.write(f);
                l++;
            }
        }
    }

    private void d()
    {
        int l = a();
        if (l == 5)
        {
            c.write(44);
        } else
        if (l != 3)
        {
            throw new IllegalStateException("Nesting problem.");
        }
        c();
        b(4);
    }

    public JsonWriter beginArray()
    {
        b();
        return a(1, "[");
    }

    public JsonWriter beginObject()
    {
        b();
        return a(3, "{");
    }

    public void close()
    {
        c.close();
        int l = e;
        if (l > 1 || l == 1 && d[l - 1] != 7)
        {
            throw new IOException("Incomplete document");
        } else
        {
            e = 0;
            return;
        }
    }

    public JsonWriter endArray()
    {
        return a(1, 2, "]");
    }

    public JsonWriter endObject()
    {
        return a(3, 5, "}");
    }

    public void flush()
    {
        if (e == 0)
        {
            throw new IllegalStateException("JsonWriter is closed.");
        } else
        {
            c.flush();
            return;
        }
    }

    public final boolean getSerializeNulls()
    {
        return k;
    }

    public final boolean isHtmlSafe()
    {
        return i;
    }

    public boolean isLenient()
    {
        return h;
    }

    public JsonWriter name(String s)
    {
        if (s == null)
        {
            throw new NullPointerException("name == null");
        }
        if (j != null)
        {
            throw new IllegalStateException();
        }
        if (e == 0)
        {
            throw new IllegalStateException("JsonWriter is closed.");
        } else
        {
            j = s;
            return this;
        }
    }

    public JsonWriter nullValue()
    {
label0:
        {
            if (j != null)
            {
                if (!k)
                {
                    break label0;
                }
                b();
            }
            a(false);
            c.write("null");
            return this;
        }
        j = null;
        return this;
    }

    public final void setHtmlSafe(boolean flag)
    {
        i = flag;
    }

    public final void setIndent(String s)
    {
        if (s.length() == 0)
        {
            f = null;
            g = ":";
            return;
        } else
        {
            f = s;
            g = ": ";
            return;
        }
    }

    public final void setLenient(boolean flag)
    {
        h = flag;
    }

    public final void setSerializeNulls(boolean flag)
    {
        k = flag;
    }

    public JsonWriter value(double d1)
    {
        if (Double.isNaN(d1) || Double.isInfinite(d1))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Numeric values must be finite, but was ").append(d1).toString());
        } else
        {
            b();
            a(false);
            c.append(Double.toString(d1));
            return this;
        }
    }

    public JsonWriter value(long l)
    {
        b();
        a(false);
        c.write(Long.toString(l));
        return this;
    }

    public JsonWriter value(Number number)
    {
        if (number == null)
        {
            return nullValue();
        }
        b();
        String s = number.toString();
        if (!h && (s.equals("-Infinity") || s.equals("Infinity") || s.equals("NaN")))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Numeric values must be finite, but was ").append(number).toString());
        } else
        {
            a(false);
            c.append(s);
            return this;
        }
    }

    public JsonWriter value(String s)
    {
        if (s == null)
        {
            return nullValue();
        } else
        {
            b();
            a(false);
            a(s);
            return this;
        }
    }

    public JsonWriter value(boolean flag)
    {
        b();
        a(false);
        Writer writer = c;
        String s;
        if (flag)
        {
            s = "true";
        } else
        {
            s = "false";
        }
        writer.write(s);
        return this;
    }

    static 
    {
        a = new String[128];
        for (int l = 0; l <= 31; l++)
        {
            String as[] = a;
            Object aobj[] = new Object[1];
            aobj[0] = Integer.valueOf(l);
            as[l] = String.format("\\u%04x", aobj);
        }

        a[34] = "\\\"";
        a[92] = "\\\\";
        a[9] = "\\t";
        a[8] = "\\b";
        a[10] = "\\n";
        a[13] = "\\r";
        a[12] = "\\f";
        b = (String[])a.clone();
        b[60] = "\\u003c";
        b[62] = "\\u003e";
        b[38] = "\\u0026";
        b[61] = "\\u003d";
        b[39] = "\\u0027";
    }
}
