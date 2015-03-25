// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.google.zxing.client.result:
//            ResultParser, AddressBookParsedResult, ParsedResult

public final class VCardResultParser extends ResultParser
{

    private static final Pattern a = Pattern.compile("BEGIN:VCARD", 2);
    private static final Pattern b = Pattern.compile("\\d{4}-?\\d{2}-?\\d{2}");
    private static final Pattern c = Pattern.compile("\r\n[ \t]");
    private static final Pattern d = Pattern.compile("\\\\[nN]");
    private static final Pattern e = Pattern.compile("\\\\([,;\\\\])");
    private static final Pattern f = Pattern.compile("=");
    private static final Pattern g = Pattern.compile(";");

    public VCardResultParser()
    {
    }

    private static String a(CharSequence charsequence, String s)
    {
        int i;
        StringBuilder stringbuilder;
        ByteArrayOutputStream bytearrayoutputstream;
        int j;
        i = charsequence.length();
        stringbuilder = new StringBuilder(i);
        bytearrayoutputstream = new ByteArrayOutputStream();
        j = 0;
_L8:
        if (j >= i) goto _L2; else goto _L1
_L1:
        char c1 = charsequence.charAt(j);
        c1;
        JVM INSTR lookupswitch 3: default 80
    //                   10: 94
    //                   13: 94
    //                   61: 100;
           goto _L3 _L4 _L4 _L5
_L4:
        break; /* Loop/switch isn't completed */
_L3:
        a(bytearrayoutputstream, s, stringbuilder);
        stringbuilder.append(c1);
_L6:
        j++;
        continue; /* Loop/switch isn't completed */
_L5:
        if (j < i - 2)
        {
            char c2 = charsequence.charAt(j + 1);
            if (c2 != '\r' && c2 != '\n')
            {
                char c3 = charsequence.charAt(j + 2);
                int k = parseHexDigit(c2);
                int l = parseHexDigit(c3);
                if (k >= 0 && l >= 0)
                {
                    bytearrayoutputstream.write(l + (k << 4));
                }
                j += 2;
            }
        }
        if (true) goto _L6; else goto _L2
_L2:
        a(bytearrayoutputstream, s, stringbuilder);
        return stringbuilder.toString();
        if (true) goto _L8; else goto _L7
_L7:
    }

    private static String a(List list)
    {
        if (list == null || list.isEmpty())
        {
            return null;
        } else
        {
            return (String)list.get(0);
        }
    }

    static List a(CharSequence charsequence, String s, boolean flag)
    {
        List list = b(charsequence, s, flag);
        if (list == null || list.isEmpty())
        {
            return null;
        } else
        {
            return (List)list.get(0);
        }
    }

    private static void a(ByteArrayOutputStream bytearrayoutputstream, String s, StringBuilder stringbuilder)
    {
        if (bytearrayoutputstream.size() > 0)
        {
            byte abyte0[] = bytearrayoutputstream.toByteArray();
            String s1;
            if (s == null)
            {
                s1 = new String(abyte0);
            } else
            {
                try
                {
                    s1 = new String(abyte0, s);
                }
                catch (UnsupportedEncodingException unsupportedencodingexception)
                {
                    s1 = new String(abyte0);
                }
            }
            bytearrayoutputstream.reset();
            stringbuilder.append(s1);
        }
    }

    private static void a(Iterable iterable)
    {
        if (iterable != null)
        {
            List list;
            StringBuilder stringbuilder;
            for (Iterator iterator = iterable.iterator(); iterator.hasNext(); list.set(0, stringbuilder.toString().trim()))
            {
                list = (List)iterator.next();
                String s = (String)list.get(0);
                String as[] = new String[5];
                int i = 0;
                int j = 0;
                do
                {
                    int k = s.indexOf(';', j);
                    if (k <= 0)
                    {
                        break;
                    }
                    as[i] = s.substring(j, k);
                    i++;
                    j = k + 1;
                } while (true);
                as[i] = s.substring(j);
                stringbuilder = new StringBuilder(100);
                a(as, 3, stringbuilder);
                a(as, 1, stringbuilder);
                a(as, 2, stringbuilder);
                a(as, 0, stringbuilder);
                a(as, 4, stringbuilder);
            }

        }
    }

    private static void a(String as[], int i, StringBuilder stringbuilder)
    {
        if (as[i] != null)
        {
            stringbuilder.append(' ');
            stringbuilder.append(as[i]);
        }
    }

    private static boolean a(CharSequence charsequence)
    {
        return charsequence == null || b.matcher(charsequence).matches();
    }

    private static String[] a(Collection collection)
    {
        if (collection == null || collection.isEmpty())
        {
            return null;
        }
        ArrayList arraylist = new ArrayList(collection.size());
        for (Iterator iterator = collection.iterator(); iterator.hasNext(); arraylist.add(((List)iterator.next()).get(0))) { }
        return (String[])arraylist.toArray(new String[collection.size()]);
    }

    private static List b(CharSequence charsequence, String s, boolean flag)
    {
        Object obj;
        int i;
        int j;
        obj = null;
        i = 0;
        j = s.length();
_L10:
        int k;
        ArrayList arraylist;
        boolean flag1;
        String s2;
        String as[];
        int j2;
        int k2;
        Matcher matcher;
label0:
        {
            if (i < j)
            {
                matcher = Pattern.compile((new StringBuilder()).append("(?:^|\n)").append(charsequence).append("(?:;([^:]*))?:").toString(), 2).matcher(s);
                if (i > 0)
                {
                    i--;
                }
                if (matcher.find(i))
                {
                    break label0;
                }
            }
            return ((List) (obj));
        }
        k = matcher.end(0);
        String s1 = matcher.group(1);
        arraylist = null;
        flag1 = false;
        s2 = null;
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_592;
        }
        as = g.split(s1);
        j2 = as.length;
        k2 = 0;
_L7:
        if (k2 >= j2) goto _L2; else goto _L1
_L1:
        String as1[];
        String s7 = as[k2];
        if (arraylist == null)
        {
            arraylist = new ArrayList(1);
        }
        arraylist.add(s7);
        as1 = f.split(s7, 2);
        if (as1.length <= 1) goto _L4; else goto _L3
_L3:
        String s8;
        String s9;
        s8 = as1[0];
        s9 = as1[1];
        if (!"ENCODING".equalsIgnoreCase(s8) || !"QUOTED-PRINTABLE".equalsIgnoreCase(s9)) goto _L6; else goto _L5
_L5:
        boolean flag2 = true;
_L9:
        k2++;
        flag1 = flag2;
          goto _L7
_L6:
        if (!"CHARSET".equalsIgnoreCase(s8)) goto _L4; else goto _L8
_L8:
        s2 = s9;
        flag2 = flag1;
          goto _L9
_L2:
        ArrayList arraylist1 = arraylist;
_L11:
        int l = k;
        int i1;
        do
        {
            i1 = s.indexOf('\n', l);
            if (i1 < 0)
            {
                break;
            }
            if (i1 < -1 + s.length() && (s.charAt(i1 + 1) == ' ' || s.charAt(i1 + 1) == '\t'))
            {
                l = i1 + 2;
                continue;
            }
            if (!flag1 || s.charAt(i1 - 1) != '=' && s.charAt(i1 - 2) != '=')
            {
                break;
            }
            l = i1 + 1;
        } while (true);
        Object obj1;
        int k1;
        int l1;
        if (i1 < 0)
        {
            obj1 = obj;
            k1 = j;
        } else
        if (i1 > k)
        {
            if (obj == null)
            {
                obj = new ArrayList(1);
            }
            if (s.charAt(i1 - 1) == '\r')
            {
                i1--;
            }
            String s3 = s.substring(k, i1);
            if (flag)
            {
                s3 = s3.trim();
            }
            String s6;
            int i2;
            if (flag1)
            {
                s6 = a(s3, s2);
            } else
            {
                String s4 = c.matcher(s3).replaceAll("");
                String s5 = d.matcher(s4).replaceAll("\n");
                s6 = e.matcher(s5).replaceAll("$1");
            }
            if (arraylist1 == null)
            {
                ArrayList arraylist2 = new ArrayList(1);
                arraylist2.add(s6);
                ((List) (obj)).add(arraylist2);
            } else
            {
                arraylist1.add(0, s6);
                ((List) (obj)).add(arraylist1);
            }
            i2 = i1 + 1;
            obj1 = obj;
            k1 = i2;
        } else
        {
            int j1 = i1 + 1;
            obj1 = obj;
            k1 = j1;
        }
        l1 = k1;
        obj = obj1;
        i = l1;
          goto _L10
_L4:
        flag2 = flag1;
          goto _L9
        s2 = null;
        arraylist1 = null;
        flag1 = false;
          goto _L11
    }

    private static String[] b(Collection collection)
    {
        ArrayList arraylist;
        Iterator iterator;
        if (collection == null || collection.isEmpty())
        {
            return null;
        }
        arraylist = new ArrayList(collection.size());
        iterator = collection.iterator();
_L3:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        List list;
        int i;
        list = (List)iterator.next();
        i = 1;
_L4:
        String s;
        if (i >= list.size())
        {
            break MISSING_BLOCK_LABEL_163;
        }
        s = (String)list.get(i);
        int j = s.indexOf('=');
        if (j >= 0)
        {
label0:
            {
                if (!"TYPE".equalsIgnoreCase(s.substring(0, j)))
                {
                    break label0;
                }
                s = s.substring(j + 1);
            }
        }
_L5:
        arraylist.add(s);
          goto _L3
        i++;
          goto _L4
_L2:
        return (String[])arraylist.toArray(new String[collection.size()]);
        s = null;
          goto _L5
    }

    public AddressBookParsedResult parse(Result result)
    {
        String s = result.getText();
        Matcher matcher = a.matcher(s);
        if (!matcher.find() || matcher.start() != 0)
        {
            return null;
        }
        List list = b("FN", s, true);
        if (list == null)
        {
            list = b("N", s, true);
            a(list);
        }
        List list1 = list;
        List list2 = b("TEL", s, true);
        List list3 = b("EMAIL", s, true);
        List list4 = a("NOTE", s, false);
        List list5 = b("ADR", s, true);
        if (list5 != null)
        {
            List list12;
            for (Iterator iterator = list5.iterator(); iterator.hasNext(); list12.set(0, list12.get(0)))
            {
                list12 = (List)iterator.next();
            }

        }
        List list6 = a("ORG", s, true);
        List list7 = a("BDAY", s, true);
        List list8;
        List list9;
        List list10;
        List list11;
        if (list7 != null && !a((CharSequence)list7.get(0)))
        {
            list8 = null;
        } else
        {
            list8 = list7;
        }
        list9 = a("TITLE", s, true);
        list10 = a("URL", s, true);
        list11 = a("IMPP", s, true);
        return new AddressBookParsedResult(a(list1), null, a(list2), b(list2), a(list3), b(list3), a(list11), a(list4), a(list5), b(list5), a(list6), a(list8), a(list9), a(list10));
    }

    public volatile ParsedResult parse(Result result)
    {
        return parse(result);
    }

}
