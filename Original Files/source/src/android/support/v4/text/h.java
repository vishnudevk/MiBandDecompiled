// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.text;


// Referenced classes of package android.support.v4.text:
//            j, TextDirectionHeuristicsCompat

class h
    implements j
{

    public static final h a = new h(true);
    public static final h b = new h(false);
    private final boolean c;

    private h(boolean flag)
    {
        c = flag;
    }

    public int a(CharSequence charsequence, int i, int k)
    {
        int l;
        int i1;
        int j1;
        l = 1;
        i1 = i + k;
        j1 = 0;
_L6:
        if (i >= i1) goto _L2; else goto _L1
_L1:
        TextDirectionHeuristicsCompat.b(Character.getDirectionality(charsequence.charAt(i)));
        JVM INSTR tableswitch 0 1: default 52
    //                   0 58
    //                   1 78;
           goto _L3 _L4 _L5
_L3:
        i++;
          goto _L6
_L4:
        if (!c) goto _L8; else goto _L7
_L7:
        l = 0;
_L10:
        return l;
_L8:
        j1 = l;
          goto _L3
_L5:
        if (!c) goto _L10; else goto _L9
_L9:
        j1 = l;
          goto _L3
_L2:
        if (j1 == 0) goto _L12; else goto _L11
_L11:
        if (!c)
        {
            return 0;
        }
          goto _L10
_L12:
        return 2;
          goto _L3
    }

}
