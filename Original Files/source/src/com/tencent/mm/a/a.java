// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.a;

import android.util.Base64;
import javax.crypto.Cipher;

public final class a
{

    private Cipher a;

    public final String a(String s)
    {
        String s1;
        try
        {
            byte abyte0[] = Base64.decode(s, 0);
            s1 = new String(a.doFinal(abyte0), "UTF8");
        }
        catch (Exception exception)
        {
            return (new StringBuilder("[des]")).append(s).append("|").append(exception.toString()).toString();
        }
        return s1;
    }
}
