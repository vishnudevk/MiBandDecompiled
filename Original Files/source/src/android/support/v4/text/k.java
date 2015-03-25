// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.text;

import java.nio.CharBuffer;

// Referenced classes of package android.support.v4.text:
//            TextDirectionHeuristicCompat, j

abstract class k
    implements TextDirectionHeuristicCompat
{

    private final j a;

    public k(j j1)
    {
        a = j1;
    }

    private boolean a(CharSequence charsequence, int i, int l)
    {
        switch (a.a(charsequence, i, l))
        {
        default:
            return a();

        case 0: // '\0'
            return true;

        case 1: // '\001'
            return false;
        }
    }

    protected abstract boolean a();

    public boolean isRtl(CharSequence charsequence, int i, int l)
    {
        if (charsequence == null || i < 0 || l < 0 || charsequence.length() - l < i)
        {
            throw new IllegalArgumentException();
        }
        if (a == null)
        {
            return a();
        } else
        {
            return a(charsequence, i, l);
        }
    }

    public boolean isRtl(char ac[], int i, int l)
    {
        return isRtl(((CharSequence) (CharBuffer.wrap(ac))), i, l);
    }
}
