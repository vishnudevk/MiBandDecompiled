// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson;


// Referenced classes of package com.google.gson:
//            FieldNamingStrategy, b, c, d, 
//            e, f

public abstract class FieldNamingPolicy extends Enum
    implements FieldNamingStrategy
{

    public static final FieldNamingPolicy IDENTITY;
    public static final FieldNamingPolicy LOWER_CASE_WITH_DASHES;
    public static final FieldNamingPolicy LOWER_CASE_WITH_UNDERSCORES;
    public static final FieldNamingPolicy UPPER_CAMEL_CASE;
    public static final FieldNamingPolicy UPPER_CAMEL_CASE_WITH_SPACES;
    private static final FieldNamingPolicy a[];

    private FieldNamingPolicy(String s, int i)
    {
        super(s, i);
    }

    FieldNamingPolicy(String s, int i, b b1)
    {
        this(s, i);
    }

    private static String a(char c1, String s, int i)
    {
        if (i < s.length())
        {
            return (new StringBuilder()).append(c1).append(s.substring(i)).toString();
        } else
        {
            return String.valueOf(c1);
        }
    }

    static String a(String s)
    {
        return b(s);
    }

    static String a(String s, String s1)
    {
        return b(s, s1);
    }

    private static String b(String s)
    {
        StringBuilder stringbuilder;
        int i;
        char c1;
        stringbuilder = new StringBuilder();
        i = 0;
        c1 = s.charAt(0);
_L8:
        if (i < -1 + s.length() && !Character.isLetter(c1)) goto _L2; else goto _L1
_L1:
        if (i != s.length()) goto _L4; else goto _L3
_L3:
        s = stringbuilder.toString();
_L6:
        return s;
_L2:
        stringbuilder.append(c1);
        i++;
        c1 = s.charAt(i);
        continue; /* Loop/switch isn't completed */
_L4:
        if (Character.isUpperCase(c1)) goto _L6; else goto _L5
_L5:
        return stringbuilder.append(a(Character.toUpperCase(c1), s, i + 1)).toString();
        if (true) goto _L8; else goto _L7
_L7:
    }

    private static String b(String s, String s1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
        {
            char c1 = s.charAt(i);
            if (Character.isUpperCase(c1) && stringbuilder.length() != 0)
            {
                stringbuilder.append(s1);
            }
            stringbuilder.append(c1);
        }

        return stringbuilder.toString();
    }

    public static FieldNamingPolicy valueOf(String s)
    {
        return (FieldNamingPolicy)Enum.valueOf(com/google/gson/FieldNamingPolicy, s);
    }

    public static FieldNamingPolicy[] values()
    {
        return (FieldNamingPolicy[])a.clone();
    }

    static 
    {
        IDENTITY = new b("IDENTITY", 0);
        UPPER_CAMEL_CASE = new c("UPPER_CAMEL_CASE", 1);
        UPPER_CAMEL_CASE_WITH_SPACES = new d("UPPER_CAMEL_CASE_WITH_SPACES", 2);
        LOWER_CASE_WITH_UNDERSCORES = new e("LOWER_CASE_WITH_UNDERSCORES", 3);
        LOWER_CASE_WITH_DASHES = new f("LOWER_CASE_WITH_DASHES", 4);
        FieldNamingPolicy afieldnamingpolicy[] = new FieldNamingPolicy[5];
        afieldnamingpolicy[0] = IDENTITY;
        afieldnamingpolicy[1] = UPPER_CAMEL_CASE;
        afieldnamingpolicy[2] = UPPER_CAMEL_CASE_WITH_SPACES;
        afieldnamingpolicy[3] = LOWER_CASE_WITH_UNDERSCORES;
        afieldnamingpolicy[4] = LOWER_CASE_WITH_DASHES;
        a = afieldnamingpolicy;
    }
}
