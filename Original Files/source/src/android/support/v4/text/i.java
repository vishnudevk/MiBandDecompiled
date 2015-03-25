// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.text;


// Referenced classes of package android.support.v4.text:
//            j, TextDirectionHeuristicsCompat

class i
    implements j
{

    public static final i a = new i();

    private i()
    {
    }

    public int a(CharSequence charsequence, int k, int l)
    {
        int i1 = k + l;
        int j1;
        for (j1 = 2; k < i1 && j1 == 2; k++)
        {
            j1 = TextDirectionHeuristicsCompat.a(Character.getDirectionality(charsequence.charAt(k)));
        }

        return j1;
    }

}
