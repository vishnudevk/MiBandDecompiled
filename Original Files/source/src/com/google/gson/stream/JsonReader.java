// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.stream;

import com.google.gson.internal.JsonReaderInternalAccess;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

// Referenced classes of package com.google.gson.stream:
//            a, MalformedJsonException, JsonToken

public class JsonReader
    implements Closeable
{

    private static final int A = 6;
    private static final int B = 7;
    private static final char a[] = ")]}'\n".toCharArray();
    private static final long b = 0xf333333333333334L;
    private static final int c = 0;
    private static final int d = 1;
    private static final int e = 2;
    private static final int f = 3;
    private static final int g = 4;
    private static final int h = 5;
    private static final int i = 6;
    private static final int j = 7;
    private static final int k = 8;
    private static final int l = 9;
    private static final int m = 10;
    private static final int n = 11;
    private static final int o = 12;
    private static final int p = 13;
    private static final int q = 14;
    private static final int r = 15;
    private static final int s = 16;
    private static final int t = 17;
    private static final int u = 0;
    private static final int v = 1;
    private static final int w = 2;
    private static final int x = 3;
    private static final int y = 4;
    private static final int z = 5;
    private final Reader C;
    private boolean D;
    private final char E[] = new char[1024];
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private long K;
    private int L;
    private String M;
    private int N[];
    private int O;

    public JsonReader(Reader reader)
    {
        D = false;
        F = 0;
        G = 0;
        H = 0;
        I = 0;
        J = 0;
        N = new int[32];
        O = 0;
        int ai[] = N;
        int i1 = O;
        O = i1 + 1;
        ai[i1] = 6;
        if (reader == null)
        {
            throw new NullPointerException("in == null");
        } else
        {
            C = reader;
            return;
        }
    }

    private int a()
    {
        int i1 = N[-1 + O];
        if (i1 != 1) goto _L2; else goto _L1
_L1:
        N[-1 + O] = 2;
_L14:
        a(true);
        JVM INSTR lookupswitch 7: default 100
    //                   34: 668
    //                   39: 655
    //                   44: 615
    //                   59: 615
    //                   91: 689
    //                   93: 603
    //                   123: 696;
           goto _L3 _L4 _L5 _L6 _L6 _L7 _L8 _L9
_L3:
        int k1;
        F = -1 + F;
        if (O == 1)
        {
            h();
        }
        k1 = b();
        if (k1 == 0) goto _L11; else goto _L10
_L10:
        return k1;
_L2:
        if (i1 == 2)
        {
            switch (a(true))
            {
            default:
                throw b("Unterminated array");

            case 93: // ']'
                J = 4;
                return 4;

            case 59: // ';'
                h();
                break;

            case 44: // ','
                break;
            }
        } else
        {
            if (i1 == 3 || i1 == 5)
            {
                N[-1 + O] = 4;
                if (i1 == 5)
                {
                    switch (a(true))
                    {
                    default:
                        throw b("Unterminated object");

                    case 125: // '}'
                        J = 2;
                        return 2;

                    case 59: // ';'
                        h();
                        break;

                    case 44: // ','
                        break;
                    }
                }
                int j1 = a(true);
                switch (j1)
                {
                default:
                    h();
                    F = -1 + F;
                    if (a((char)j1))
                    {
                        J = 14;
                        return 14;
                    } else
                    {
                        throw b("Expected name");
                    }

                case 34: // '"'
                    J = 13;
                    return 13;

                case 39: // '\''
                    h();
                    J = 12;
                    return 12;

                case 125: // '}'
                    break;
                }
                if (i1 != 5)
                {
                    J = 2;
                    return 2;
                } else
                {
                    throw b("Expected name");
                }
            }
            if (i1 == 4)
            {
                N[-1 + O] = 5;
                switch (a(true))
                {
                case 59: // ';'
                case 60: // '<'
                default:
                    throw b("Expected ':'");

                case 61: // '='
                    h();
                    if ((F < G || b(1)) && E[F] == '>')
                    {
                        F = 1 + F;
                    }
                    break;

                case 58: // ':'
                    break;
                }
            } else
            if (i1 == 6)
            {
                if (D)
                {
                    k();
                }
                N[-1 + O] = 7;
            } else
            if (i1 == 7)
            {
                if (a(false) == -1)
                {
                    J = 17;
                    return 17;
                }
                h();
                F = -1 + F;
            } else
            if (i1 == 8)
            {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        continue; /* Loop/switch isn't completed */
_L8:
        if (i1 == 1)
        {
            J = 4;
            return 4;
        }
_L6:
        if (i1 == 1 || i1 == 2)
        {
            h();
            F = -1 + F;
            J = 7;
            return 7;
        } else
        {
            throw b("Unexpected value");
        }
_L5:
        h();
        J = 8;
        return 8;
_L4:
        if (O == 1)
        {
            h();
        }
        J = 9;
        return 9;
_L7:
        J = 3;
        return 3;
_L9:
        J = 1;
        return 1;
_L11:
        if ((k1 = c()) != 0) goto _L10; else goto _L12
_L12:
        if (!a(E[F]))
        {
            throw b("Expected value");
        } else
        {
            h();
            J = 10;
            return 10;
        }
        if (true) goto _L14; else goto _L13
_L13:
    }

    static int a(JsonReader jsonreader)
    {
        return jsonreader.J;
    }

    static int a(JsonReader jsonreader, int i1)
    {
        jsonreader.J = i1;
        return i1;
    }

    private int a(boolean flag)
    {
        char ac[];
        int i1;
        int j1;
        ac = E;
        i1 = F;
        j1 = G;
_L2:
        int k1;
        do
        {
            if (i1 == j1)
            {
                F = i1;
                char c1;
                boolean flag1;
                if (!b(1))
                {
                    if (flag)
                    {
                        throw new EOFException((new StringBuilder()).append("End of input at line ").append(f()).append(" column ").append(g()).toString());
                    } else
                    {
                        return -1;
                    }
                }
                i1 = F;
                j1 = G;
            }
            k1 = i1 + 1;
            c1 = ac[i1];
            if (c1 == '\n')
            {
                H = 1 + H;
                I = k1;
                i1 = k1;
            } else
            {
label0:
                {
                    if (c1 == ' ' || c1 == '\r')
                    {
                        break label0;
                    }
                    if (c1 == '\t')
                    {
                        i1 = k1;
                    } else
                    {
                        if (c1 == '/')
                        {
                            F = k1;
                            if (k1 == j1)
                            {
                                F = -1 + F;
                                flag1 = b(2);
                                F = 1 + F;
                                if (!flag1)
                                {
                                    return c1;
                                }
                            }
                            h();
                            switch (ac[F])
                            {
                            default:
                                return c1;

                            case 42: // '*'
                                F = 1 + F;
                                if (!a("*/"))
                                {
                                    throw b("Unterminated comment");
                                }
                                i1 = 2 + F;
                                j1 = G;
                                break;

                            case 47: // '/'
                                F = 1 + F;
                                i();
                                i1 = F;
                                j1 = G;
                                break;
                            }
                        } else
                        if (c1 == '#')
                        {
                            F = k1;
                            h();
                            i();
                            i1 = F;
                            j1 = G;
                        } else
                        {
                            F = k1;
                            return c1;
                        }
                        continue; /* Loop/switch isn't completed */
                    }
                }
            }
        } while (true);
        i1 = k1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void a(int i1)
    {
        if (O == N.length)
        {
            int ai1[] = new int[2 * O];
            System.arraycopy(N, 0, ai1, 0, O);
            N = ai1;
        }
        int ai[] = N;
        int j1 = O;
        O = j1 + 1;
        ai[j1] = i1;
    }

    private boolean a(char c1)
    {
        switch (c1)
        {
        default:
            return true;

        case 35: // '#'
        case 47: // '/'
        case 59: // ';'
        case 61: // '='
        case 92: // '\\'
            h();
            // fall through

        case 9: // '\t'
        case 10: // '\n'
        case 12: // '\f'
        case 13: // '\r'
        case 32: // ' '
        case 44: // ','
        case 58: // ':'
        case 91: // '['
        case 93: // ']'
        case 123: // '{'
        case 125: // '}'
            return false;
        }
    }

    private boolean a(String s1)
    {
_L2:
        boolean flag;
        if (F + s1.length() > G)
        {
            boolean flag1 = b(s1.length());
            flag = false;
            if (!flag1)
            {
                break MISSING_BLOCK_LABEL_117;
            }
        }
        if (E[F] != '\n')
        {
            break; /* Loop/switch isn't completed */
        }
        H = 1 + H;
        I = 1 + F;
_L4:
        F = 1 + F;
        if (true) goto _L2; else goto _L1
_L1:
        int i1 = 0;
_L5:
        if (i1 >= s1.length())
        {
            break MISSING_BLOCK_LABEL_115;
        }
        if (E[i1 + F] != s1.charAt(i1)) goto _L4; else goto _L3
_L3:
        i1++;
          goto _L5
          goto _L4
        flag = true;
        return flag;
    }

    private int b()
    {
        char c1 = E[F];
        String s1;
        String s2;
        int i1;
        if (c1 == 't' || c1 == 'T')
        {
            s1 = "true";
            s2 = "TRUE";
            i1 = 5;
        } else
        if (c1 == 'f' || c1 == 'F')
        {
            s1 = "false";
            s2 = "FALSE";
            i1 = 6;
        } else
        if (c1 == 'n' || c1 == 'N')
        {
            s1 = "null";
            s2 = "NULL";
            i1 = 7;
        } else
        {
            return 0;
        }
        do
        {
            int j1 = s1.length();
            for (int k1 = 1; k1 < j1; k1++)
            {
                if (k1 + F >= G && !b(k1 + 1))
                {
                    return 0;
                }
                char c2 = E[k1 + F];
                if (c2 != s1.charAt(k1) && c2 != s2.charAt(k1))
                {
                    return 0;
                }
            }

            if ((j1 + F < G || b(j1 + 1)) && a(E[j1 + F]))
            {
                return 0;
            }
            F = j1 + F;
            J = i1;
            return i1;
        } while (true);
    }

    static int b(JsonReader jsonreader)
    {
        return jsonreader.a();
    }

    private IOException b(String s1)
    {
        throw new MalformedJsonException((new StringBuilder()).append(s1).append(" at line ").append(f()).append(" column ").append(g()).toString());
    }

    private String b(char c1)
    {
        char ac[] = E;
        StringBuilder stringbuilder = new StringBuilder();
        do
        {
            int i1 = F;
            int j1 = G;
            int k1 = i1;
            while (k1 < j1) 
            {
                int l1 = k1 + 1;
                char c2 = ac[k1];
                if (c2 == c1)
                {
                    F = l1;
                    stringbuilder.append(ac, i1, -1 + (l1 - i1));
                    return stringbuilder.toString();
                }
                if (c2 == '\\')
                {
                    F = l1;
                    stringbuilder.append(ac, i1, -1 + (l1 - i1));
                    stringbuilder.append(j());
                    i1 = F;
                    j1 = G;
                    l1 = i1;
                } else
                if (c2 == '\n')
                {
                    H = 1 + H;
                    I = l1;
                }
                k1 = l1;
            }
            stringbuilder.append(ac, i1, k1 - i1);
            F = k1;
        } while (b(1));
        throw b("Unterminated string");
    }

    private boolean b(int i1)
    {
        char ac[] = E;
        I = I - F;
        boolean flag;
        if (G != F)
        {
            G = G - F;
            System.arraycopy(ac, F, ac, 0, G);
        } else
        {
            G = 0;
        }
        F = 0;
        do
        {
            int j1 = C.read(ac, G, ac.length - G);
            flag = false;
            if (j1 == -1)
            {
                break;
            }
            G = j1 + G;
            if (H == 0 && I == 0 && G > 0 && ac[0] == '\uFEFF')
            {
                F = 1 + F;
                I = 1 + I;
                i1++;
            }
            if (G < i1)
            {
                continue;
            }
            flag = true;
            break;
        } while (true);
        return flag;
    }

    private int c()
    {
        char ac[];
        long l1;
        boolean flag;
        boolean flag1;
        int k1;
        int i2;
        int j2;
        int k2;
        ac = E;
        int i1 = F;
        int j1 = G;
        l1 = 0L;
        flag = false;
        flag1 = true;
        k1 = 0;
        i2 = 0;
        j2 = j1;
        k2 = i1;
_L12:
        if (k2 + i2 != j2) goto _L2; else goto _L1
_L1:
        if (i2 == ac.length)
        {
            return 0;
        }
        if (b(i2 + 1)) goto _L4; else goto _L3
_L4:
        k2 = F;
        j2 = G;
_L2:
        c1 = ac[k2 + i2];
        c1;
        JVM INSTR lookupswitch 5: default 196
    //                   43: 301
    //                   45: 221
    //                   46: 360
    //                   69: 328
    //                   101: 328;
           goto _L5 _L6 _L7 _L8 _L9 _L9
_L6:
        break; /* Loop/switch isn't completed */
_L5:
        if (c1 >= '0' && c1 <= '9')
        {
            break MISSING_BLOCK_LABEL_386;
        }
        if (a(c1))
        {
            return 0;
        }
        break; /* Loop/switch isn't completed */
_L7:
        int l2;
        boolean flag2;
        boolean flag3;
        long l3;
        boolean flag4;
        boolean flag5;
        if (k1 == 0)
        {
            l2 = 1;
            boolean flag6 = flag1;
            flag3 = true;
            flag2 = flag6;
            l3 = l1;
        } else
        if (k1 == 5)
        {
            l2 = 6;
            flag2 = flag1;
            flag3 = flag;
            l3 = l1;
        } else
        {
            return 0;
        }
        break MISSING_BLOCK_LABEL_244;
        if (true) goto _L3; else goto _L10
_L10:
        i2++;
        flag4 = flag2;
        k1 = l2;
        flag5 = flag3;
        flag1 = flag4;
        l1 = l3;
        flag = flag5;
        if (true) goto _L12; else goto _L11
_L11:
        if (k1 == 5)
        {
            l2 = 6;
            flag2 = flag1;
            flag3 = flag;
            l3 = l1;
        } else
        {
            return 0;
        }
          goto _L10
_L9:
        if (k1 == 2 || k1 == 4)
        {
            l2 = 5;
            flag2 = flag1;
            flag3 = flag;
            l3 = l1;
        } else
        {
            return 0;
        }
          goto _L10
_L8:
        if (k1 == 2)
        {
            l2 = 3;
            flag2 = flag1;
            flag3 = flag;
            l3 = l1;
        } else
        {
            return 0;
        }
          goto _L10
        if (k1 == 1 || k1 == 0)
        {
            long l4 = -(c1 - 48);
            l2 = 2;
            flag2 = flag1;
            flag3 = flag;
            l3 = l4;
        } else
        if (k1 == 2)
        {
            if (l1 == 0L)
            {
                return 0;
            }
            long l5 = 10L * l1 - (long)(c1 - 48);
            boolean flag7;
            boolean flag8;
            int i3;
            if (l1 > 0xf333333333333334L || l1 == 0xf333333333333334L && l5 < l1)
            {
                flag7 = true;
            } else
            {
                flag7 = false;
            }
            flag8 = flag7 & flag1;
            flag3 = flag;
            l3 = l5;
            i3 = k1;
            flag2 = flag8;
            l2 = i3;
        } else
        if (k1 == 3)
        {
            l2 = 4;
            flag2 = flag1;
            flag3 = flag;
            l3 = l1;
        } else
        if (k1 == 5 || k1 == 6)
        {
            l2 = 7;
            flag2 = flag1;
            flag3 = flag;
            l3 = l1;
        } else
        {
            l2 = k1;
            flag2 = flag1;
            flag3 = flag;
            l3 = l1;
        }
          goto _L10
_L3:
        if (k1 == 2 && flag1 && (l1 != 0x8000000000000000L || flag))
        {
            char c1;
            if (!flag)
            {
                l1 = -l1;
            }
            K = l1;
            F = i2 + F;
            J = 15;
            return 15;
        }
        if (k1 == 2 || k1 == 4 || k1 == 7)
        {
            L = i2;
            J = 16;
            return 16;
        } else
        {
            return 0;
        }
    }

    static int c(JsonReader jsonreader)
    {
        return jsonreader.f();
    }

    private void c(char c1)
    {
        char ac[] = E;
        do
        {
            int i1 = F;
            int j1 = G;
            int k1 = i1;
            while (k1 < j1) 
            {
                int l1 = k1 + 1;
                char c2 = ac[k1];
                if (c2 == c1)
                {
                    F = l1;
                    return;
                }
                if (c2 == '\\')
                {
                    F = l1;
                    j();
                    l1 = F;
                    j1 = G;
                } else
                if (c2 == '\n')
                {
                    H = 1 + H;
                    I = l1;
                }
                k1 = l1;
            }
            F = k1;
        } while (b(1));
        throw b("Unterminated string");
    }

    static int d(JsonReader jsonreader)
    {
        return jsonreader.g();
    }

    private String d()
    {
        StringBuilder stringbuilder;
        int i1;
        stringbuilder = null;
        i1 = 0;
_L2:
        String s1;
        if (i1 + F < G)
        {
            switch (E[i1 + F])
            {
            default:
                i1++;
                continue; /* Loop/switch isn't completed */

            case 35: // '#'
            case 47: // '/'
            case 59: // ';'
            case 61: // '='
            case 92: // '\\'
                h();
                break;

            case 9: // '\t'
            case 10: // '\n'
            case 12: // '\f'
            case 13: // '\r'
            case 32: // ' '
            case 44: // ','
            case 58: // ':'
            case 91: // '['
            case 93: // ']'
            case 123: // '{'
            case 125: // '}'
                break;
            }
        } else
        if (i1 < E.length)
        {
            if (b(i1 + 1))
            {
                continue; /* Loop/switch isn't completed */
            }
        } else
        {
label0:
            {
                if (stringbuilder == null)
                {
                    stringbuilder = new StringBuilder();
                }
                stringbuilder.append(E, F, i1);
                F = i1 + F;
                if (b(1))
                {
                    break label0;
                }
                i1 = 0;
            }
        }
        if (stringbuilder == null)
        {
            s1 = new String(E, F, i1);
        } else
        {
            stringbuilder.append(E, F, i1);
            s1 = stringbuilder.toString();
        }
        F = i1 + F;
        return s1;
        i1 = 0;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void e()
    {
_L2:
        int i1;
label0:
        {
            i1 = 0;
            do
            {
                if (i1 + F >= G)
                {
                    break label0;
                }
                switch (E[i1 + F])
                {
                default:
                    i1++;
                    break;

                case 35: // '#'
                case 47: // '/'
                case 59: // ';'
                case 61: // '='
                case 92: // '\\'
                    h();
                    // fall through

                case 9: // '\t'
                case 10: // '\n'
                case 12: // '\f'
                case 13: // '\r'
                case 32: // ' '
                case 44: // ','
                case 58: // ':'
                case 91: // '['
                case 93: // ']'
                case 123: // '{'
                case 125: // '}'
label1:
                    {
                        F = i1 + F;
                        break label1;
                    }
                    break;
                }
            } while (true);
            break label0;
        }
        return;
        F = i1 + F;
        if (!b(1))
        {
            return;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    private int f()
    {
        return 1 + H;
    }

    private int g()
    {
        return 1 + (F - I);
    }

    private void h()
    {
        if (!D)
        {
            throw b("Use JsonReader.setLenient(true) to accept malformed JSON");
        } else
        {
            return;
        }
    }

    private void i()
    {
        char c1;
        do
        {
            if (F < G || b(1))
            {
                char ac[] = E;
                int i1 = F;
                F = i1 + 1;
                c1 = ac[i1];
                if (c1 != '\n')
                {
                    continue;
                }
                H = 1 + H;
                I = F;
            }
            return;
        } while (c1 != '\r');
    }

    private char j()
    {
        if (F == G && !b(1))
        {
            throw b("Unterminated escape sequence");
        }
        char ac[] = E;
        int i1 = F;
        F = i1 + 1;
        char c1 = ac[i1];
        switch (c1)
        {
        default:
            return c1;

        case 117: // 'u'
            if (4 + F > G && !b(4))
            {
                throw b("Unterminated escape sequence");
            }
            int j1 = F;
            int k1 = j1 + 4;
            char c2 = '\0';
            int l1 = j1;
            while (l1 < k1) 
            {
                char c3 = E[l1];
                char c4 = (char)(c2 << 4);
                if (c3 >= '0' && c3 <= '9')
                {
                    c2 = (char)(c4 + (c3 - 48));
                } else
                if (c3 >= 'a' && c3 <= 'f')
                {
                    c2 = (char)(c4 + (10 + (c3 - 97)));
                } else
                if (c3 >= 'A' && c3 <= 'F')
                {
                    c2 = (char)(c4 + (10 + (c3 - 65)));
                } else
                {
                    throw new NumberFormatException((new StringBuilder()).append("\\u").append(new String(E, F, 4)).toString());
                }
                l1++;
            }
            F = 4 + F;
            return c2;

        case 116: // 't'
            return '\t';

        case 98: // 'b'
            return '\b';

        case 110: // 'n'
            return '\n';

        case 114: // 'r'
            return '\r';

        case 102: // 'f'
            return '\f';

        case 10: // '\n'
            H = 1 + H;
            I = F;
            return c1;
        }
    }

    private void k()
    {
        a(true);
        F = -1 + F;
        if (F + a.length <= G || b(a.length)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i1 = 0;
label0:
        do
        {
label1:
            {
                if (i1 >= a.length)
                {
                    break label1;
                }
                if (E[i1 + F] != a[i1])
                {
                    break label0;
                }
                i1++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        F = F + a.length;
        return;
    }

    public void beginArray()
    {
        int i1 = J;
        if (i1 == 0)
        {
            i1 = a();
        }
        if (i1 == 3)
        {
            a(1);
            J = 0;
            return;
        } else
        {
            throw new IllegalStateException((new StringBuilder()).append("Expected BEGIN_ARRAY but was ").append(peek()).append(" at line ").append(f()).append(" column ").append(g()).toString());
        }
    }

    public void beginObject()
    {
        int i1 = J;
        if (i1 == 0)
        {
            i1 = a();
        }
        if (i1 == 1)
        {
            a(3);
            J = 0;
            return;
        } else
        {
            throw new IllegalStateException((new StringBuilder()).append("Expected BEGIN_OBJECT but was ").append(peek()).append(" at line ").append(f()).append(" column ").append(g()).toString());
        }
    }

    public void close()
    {
        J = 0;
        N[0] = 8;
        O = 1;
        C.close();
    }

    public void endArray()
    {
        int i1 = J;
        if (i1 == 0)
        {
            i1 = a();
        }
        if (i1 == 4)
        {
            O = -1 + O;
            J = 0;
            return;
        } else
        {
            throw new IllegalStateException((new StringBuilder()).append("Expected END_ARRAY but was ").append(peek()).append(" at line ").append(f()).append(" column ").append(g()).toString());
        }
    }

    public void endObject()
    {
        int i1 = J;
        if (i1 == 0)
        {
            i1 = a();
        }
        if (i1 == 2)
        {
            O = -1 + O;
            J = 0;
            return;
        } else
        {
            throw new IllegalStateException((new StringBuilder()).append("Expected END_OBJECT but was ").append(peek()).append(" at line ").append(f()).append(" column ").append(g()).toString());
        }
    }

    public boolean hasNext()
    {
        int i1 = J;
        if (i1 == 0)
        {
            i1 = a();
        }
        return i1 != 2 && i1 != 4;
    }

    public final boolean isLenient()
    {
        return D;
    }

    public boolean nextBoolean()
    {
        int i1 = J;
        if (i1 == 0)
        {
            i1 = a();
        }
        if (i1 == 5)
        {
            J = 0;
            return true;
        }
        if (i1 == 6)
        {
            J = 0;
            return false;
        } else
        {
            throw new IllegalStateException((new StringBuilder()).append("Expected a boolean but was ").append(peek()).append(" at line ").append(f()).append(" column ").append(g()).toString());
        }
    }

    public double nextDouble()
    {
        int i1 = J;
        if (i1 == 0)
        {
            i1 = a();
        }
        if (i1 == 15)
        {
            J = 0;
            return (double)K;
        }
        if (i1 == 16)
        {
            M = new String(E, F, L);
            F = F + L;
        } else
        if (i1 == 8 || i1 == 9)
        {
            char c1;
            if (i1 == 8)
            {
                c1 = '\'';
            } else
            {
                c1 = '"';
            }
            M = b(c1);
        } else
        {
            if (i1 != 10)
            {
                continue;
            }
            M = d();
        }
        do
        {
            J = 11;
            double d1 = Double.parseDouble(M);
            if (!D && (Double.isNaN(d1) || Double.isInfinite(d1)))
            {
                throw new MalformedJsonException((new StringBuilder()).append("JSON forbids NaN and infinities: ").append(d1).append(" at line ").append(f()).append(" column ").append(g()).toString());
            } else
            {
                M = null;
                J = 0;
                return d1;
            }
        } while (i1 == 11);
        throw new IllegalStateException((new StringBuilder()).append("Expected a double but was ").append(peek()).append(" at line ").append(f()).append(" column ").append(g()).toString());
    }

    public int nextInt()
    {
        int i1;
        i1 = J;
        if (i1 == 0)
        {
            i1 = a();
        }
        if (i1 == 15)
        {
            int l1 = (int)K;
            if (K != (long)l1)
            {
                throw new NumberFormatException((new StringBuilder()).append("Expected an int but was ").append(K).append(" at line ").append(f()).append(" column ").append(g()).toString());
            } else
            {
                J = 0;
                return l1;
            }
        }
        if (i1 != 16) goto _L2; else goto _L1
_L1:
        M = new String(E, F, L);
        F = F + L;
_L3:
        J = 11;
        double d1 = Double.parseDouble(M);
        int j1 = (int)d1;
        char c1;
        NumberFormatException numberformatexception;
        int k1;
        if ((double)j1 != d1)
        {
            throw new NumberFormatException((new StringBuilder()).append("Expected an int but was ").append(M).append(" at line ").append(f()).append(" column ").append(g()).toString());
        } else
        {
            M = null;
            J = 0;
            return j1;
        }
_L2:
        if (i1 != 8 && i1 != 9)
        {
            break MISSING_BLOCK_LABEL_284;
        }
        if (i1 == 8)
        {
            c1 = '\'';
        } else
        {
            c1 = '"';
        }
        M = b(c1);
        k1 = Integer.parseInt(M);
        J = 0;
        return k1;
        numberformatexception;
          goto _L3
        throw new IllegalStateException((new StringBuilder()).append("Expected an int but was ").append(peek()).append(" at line ").append(f()).append(" column ").append(g()).toString());
    }

    public long nextLong()
    {
        int i1;
        i1 = J;
        if (i1 == 0)
        {
            i1 = a();
        }
        if (i1 == 15)
        {
            J = 0;
            return K;
        }
        if (i1 != 16) goto _L2; else goto _L1
_L1:
        M = new String(E, F, L);
        F = F + L;
_L3:
        J = 11;
        double d1 = Double.parseDouble(M);
        long l1 = (long)d1;
        char c1;
        NumberFormatException numberformatexception;
        long l2;
        if ((double)l1 != d1)
        {
            throw new NumberFormatException((new StringBuilder()).append("Expected a long but was ").append(M).append(" at line ").append(f()).append(" column ").append(g()).toString());
        } else
        {
            M = null;
            J = 0;
            return l1;
        }
_L2:
        if (i1 != 8 && i1 != 9)
        {
            break MISSING_BLOCK_LABEL_213;
        }
        if (i1 == 8)
        {
            c1 = '\'';
        } else
        {
            c1 = '"';
        }
        M = b(c1);
        l2 = Long.parseLong(M);
        J = 0;
        return l2;
        numberformatexception;
          goto _L3
        throw new IllegalStateException((new StringBuilder()).append("Expected a long but was ").append(peek()).append(" at line ").append(f()).append(" column ").append(g()).toString());
    }

    public String nextName()
    {
        int i1 = J;
        if (i1 == 0)
        {
            i1 = a();
        }
        String s1;
        if (i1 == 14)
        {
            s1 = d();
        } else
        if (i1 == 12)
        {
            s1 = b('\'');
        } else
        if (i1 == 13)
        {
            s1 = b('"');
        } else
        {
            throw new IllegalStateException((new StringBuilder()).append("Expected a name but was ").append(peek()).append(" at line ").append(f()).append(" column ").append(g()).toString());
        }
        J = 0;
        return s1;
    }

    public void nextNull()
    {
        int i1 = J;
        if (i1 == 0)
        {
            i1 = a();
        }
        if (i1 == 7)
        {
            J = 0;
            return;
        } else
        {
            throw new IllegalStateException((new StringBuilder()).append("Expected null but was ").append(peek()).append(" at line ").append(f()).append(" column ").append(g()).toString());
        }
    }

    public String nextString()
    {
        int i1 = J;
        if (i1 == 0)
        {
            i1 = a();
        }
        String s1;
        if (i1 == 10)
        {
            s1 = d();
        } else
        if (i1 == 8)
        {
            s1 = b('\'');
        } else
        if (i1 == 9)
        {
            s1 = b('"');
        } else
        if (i1 == 11)
        {
            s1 = M;
            M = null;
        } else
        if (i1 == 15)
        {
            s1 = Long.toString(K);
        } else
        if (i1 == 16)
        {
            s1 = new String(E, F, L);
            F = F + L;
        } else
        {
            throw new IllegalStateException((new StringBuilder()).append("Expected a string but was ").append(peek()).append(" at line ").append(f()).append(" column ").append(g()).toString());
        }
        J = 0;
        return s1;
    }

    public JsonToken peek()
    {
        int i1 = J;
        if (i1 == 0)
        {
            i1 = a();
        }
        switch (i1)
        {
        default:
            throw new AssertionError();

        case 1: // '\001'
            return JsonToken.BEGIN_OBJECT;

        case 2: // '\002'
            return JsonToken.END_OBJECT;

        case 3: // '\003'
            return JsonToken.BEGIN_ARRAY;

        case 4: // '\004'
            return JsonToken.END_ARRAY;

        case 12: // '\f'
        case 13: // '\r'
        case 14: // '\016'
            return JsonToken.NAME;

        case 5: // '\005'
        case 6: // '\006'
            return JsonToken.BOOLEAN;

        case 7: // '\007'
            return JsonToken.NULL;

        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
        case 11: // '\013'
            return JsonToken.STRING;

        case 15: // '\017'
        case 16: // '\020'
            return JsonToken.NUMBER;

        case 17: // '\021'
            return JsonToken.END_DOCUMENT;
        }
    }

    public final void setLenient(boolean flag)
    {
        D = flag;
    }

    public void skipValue()
    {
        int i1 = 0;
_L2:
        int j1;
        j1 = J;
        if (j1 == 0)
        {
            j1 = a();
        }
        if (j1 != 3)
        {
            break; /* Loop/switch isn't completed */
        }
        a(1);
        i1++;
_L3:
        J = 0;
        if (i1 == 0)
        {
            return;
        }
        if (true) goto _L2; else goto _L1
_L1:
        if (j1 == 1)
        {
            a(3);
            i1++;
        } else
        if (j1 == 4)
        {
            O = -1 + O;
            i1--;
        } else
        if (j1 == 2)
        {
            O = -1 + O;
            i1--;
        } else
        if (j1 == 14 || j1 == 10)
        {
            e();
        } else
        if (j1 == 8 || j1 == 12)
        {
            c('\'');
        } else
        if (j1 == 9 || j1 == 13)
        {
            c('"');
        } else
        if (j1 == 16)
        {
            F = F + L;
        }
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getSimpleName()).append(" at line ").append(f()).append(" column ").append(g()).toString();
    }

    static 
    {
        JsonReaderInternalAccess.INSTANCE = new a();
    }
}
