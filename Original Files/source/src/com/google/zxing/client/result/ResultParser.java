// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.google.zxing.client.result:
//            BookmarkDoCoMoResultParser, AddressBookDoCoMoResultParser, EmailDoCoMoResultParser, AddressBookAUResultParser, 
//            VCardResultParser, BizcardResultParser, VEventResultParser, EmailAddressResultParser, 
//            SMTPResultParser, TelResultParser, SMSMMSResultParser, SMSTOMMSTOResultParser, 
//            GeoResultParser, WifiResultParser, URLTOResultParser, URIResultParser, 
//            ISBNResultParser, ProductResultParser, ExpandedProductResultParser, TextParsedResult, 
//            ParsedResult

public abstract class ResultParser
{

    private static final ResultParser a[];
    private static final Pattern b = Pattern.compile("\\d*");
    private static final Pattern c = Pattern.compile("[a-zA-Z0-9]*");
    private static final Pattern d = Pattern.compile("&");
    private static final Pattern e = Pattern.compile("=");

    public ResultParser()
    {
    }

    private static void a(CharSequence charsequence, Map map)
    {
        String as[] = e.split(charsequence, 2);
        if (as.length == 2)
        {
            String s = as[0];
            String s1 = as[1];
            String s2;
            try
            {
                s2 = URLDecoder.decode(s1, "UTF-8");
            }
            catch (UnsupportedEncodingException unsupportedencodingexception)
            {
                throw new IllegalStateException(unsupportedencodingexception);
            }
            map.put(s, s2);
        }
    }

    static String[] a(String s, String s1, char c1, boolean flag)
    {
        int i = s1.length();
        int j = 0;
        Object obj = null;
        do
        {
label0:
            {
                int k;
                if (j < i)
                {
                    k = s1.indexOf(s, j);
                    if (k >= 0)
                    {
                        break label0;
                    }
                }
                int l;
                boolean flag1;
                Object obj1;
                int i1;
                int j1;
                int k1;
                String s2;
                if (obj == null || ((List) (obj)).isEmpty())
                {
                    return null;
                } else
                {
                    return (String[])((List) (obj)).toArray(new String[((List) (obj)).size()]);
                }
            }
            l = k + s.length();
            flag1 = true;
            obj1 = obj;
            i1 = l;
            while (flag1) 
            {
                k1 = s1.indexOf(c1, i1);
                if (k1 < 0)
                {
                    i1 = s1.length();
                    flag1 = false;
                } else
                if (s1.charAt(k1 - 1) == '\\')
                {
                    i1 = k1 + 1;
                } else
                {
                    if (obj1 == null)
                    {
                        obj1 = new ArrayList(3);
                    }
                    s2 = unescapeBackslash(s1.substring(l, k1));
                    if (flag)
                    {
                        s2 = s2.trim();
                    }
                    ((List) (obj1)).add(s2);
                    i1 = k1 + 1;
                    flag1 = false;
                }
            }
            j1 = i1;
            obj = obj1;
            j = j1;
        } while (true);
    }

    static String b(String s, String s1, char c1, boolean flag)
    {
        String as[] = a(s, s1, c1, flag);
        if (as == null)
        {
            return null;
        } else
        {
            return as[0];
        }
    }

    static Map b(String s)
    {
        int i = s.indexOf('?');
        Object obj;
        if (i < 0)
        {
            obj = null;
        } else
        {
            obj = new HashMap(3);
            String as[] = d.split(s.substring(i + 1));
            int j = as.length;
            int k = 0;
            while (k < j) 
            {
                a(as[k], ((Map) (obj)));
                k++;
            }
        }
        return ((Map) (obj));
    }

    protected static boolean isStringOfDigits(CharSequence charsequence, int i)
    {
        return charsequence != null && i == charsequence.length() && b.matcher(charsequence).matches();
    }

    protected static boolean isSubstringOfAlphaNumeric(CharSequence charsequence, int i, int j)
    {
        int k;
        if (charsequence != null)
        {
            if (charsequence.length() >= (k = i + j) && c.matcher(charsequence.subSequence(i, k)).matches())
            {
                return true;
            }
        }
        return false;
    }

    protected static boolean isSubstringOfDigits(CharSequence charsequence, int i, int j)
    {
        int k;
        if (charsequence != null)
        {
            if (charsequence.length() >= (k = i + j) && b.matcher(charsequence.subSequence(i, k)).matches())
            {
                return true;
            }
        }
        return false;
    }

    protected static void maybeAppend(String s, StringBuilder stringbuilder)
    {
        if (s != null)
        {
            stringbuilder.append('\n');
            stringbuilder.append(s);
        }
    }

    protected static void maybeAppend(String as[], StringBuilder stringbuilder)
    {
        if (as != null)
        {
            int i = as.length;
            for (int j = 0; j < i; j++)
            {
                String s = as[j];
                stringbuilder.append('\n');
                stringbuilder.append(s);
            }

        }
    }

    protected static String[] maybeWrap(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return (new String[] {
                s
            });
        }
    }

    protected static int parseHexDigit(char c1)
    {
        if (c1 >= '0' && c1 <= '9')
        {
            return c1 - 48;
        }
        if (c1 >= 'a' && c1 <= 'f')
        {
            return 10 + (c1 - 97);
        }
        if (c1 >= 'A' && c1 <= 'F')
        {
            return 10 + (c1 - 65);
        } else
        {
            return -1;
        }
    }

    public static ParsedResult parseResult(Result result)
    {
        ResultParser aresultparser[] = a;
        int i = aresultparser.length;
        for (int j = 0; j < i; j++)
        {
            ParsedResult parsedresult = aresultparser[j].parse(result);
            if (parsedresult != null)
            {
                return parsedresult;
            }
        }

        return new TextParsedResult(result.getText(), null);
    }

    protected static String unescapeBackslash(String s)
    {
        int i = s.indexOf('\\');
        if (i < 0)
        {
            return s;
        }
        int j = s.length();
        StringBuilder stringbuilder = new StringBuilder(j - 1);
        stringbuilder.append(s.toCharArray(), 0, i);
        int k = i;
        boolean flag = false;
        while (k < j) 
        {
            char c1 = s.charAt(k);
            if (flag || c1 != '\\')
            {
                stringbuilder.append(c1);
                flag = false;
            } else
            {
                flag = true;
            }
            k++;
        }
        return stringbuilder.toString();
    }

    public abstract ParsedResult parse(Result result);

    static 
    {
        ResultParser aresultparser[] = new ResultParser[19];
        aresultparser[0] = new BookmarkDoCoMoResultParser();
        aresultparser[1] = new AddressBookDoCoMoResultParser();
        aresultparser[2] = new EmailDoCoMoResultParser();
        aresultparser[3] = new AddressBookAUResultParser();
        aresultparser[4] = new VCardResultParser();
        aresultparser[5] = new BizcardResultParser();
        aresultparser[6] = new VEventResultParser();
        aresultparser[7] = new EmailAddressResultParser();
        aresultparser[8] = new SMTPResultParser();
        aresultparser[9] = new TelResultParser();
        aresultparser[10] = new SMSMMSResultParser();
        aresultparser[11] = new SMSTOMMSTOResultParser();
        aresultparser[12] = new GeoResultParser();
        aresultparser[13] = new WifiResultParser();
        aresultparser[14] = new URLTOResultParser();
        aresultparser[15] = new URIResultParser();
        aresultparser[16] = new ISBNResultParser();
        aresultparser[17] = new ProductResultParser();
        aresultparser[18] = new ExpandedProductResultParser();
        a = aresultparser;
    }
}
