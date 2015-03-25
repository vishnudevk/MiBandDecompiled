// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.account.openauth.utils;

import java.io.FilterInputStream;
import java.io.InputStream;

public final class  extends FilterInputStream
{

    private boolean a;

    public int read(byte abyte0[], int i, int j)
    {
        if (!a)
        {
            int k = super.read(abyte0, i, j);
            if (k != -1)
            {
                return k;
            }
        }
        a = true;
        return -1;
    }

    public (InputStream inputstream)
    {
        super(inputstream);
    }
}
