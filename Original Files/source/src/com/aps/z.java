// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aps;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;

final class z
    implements Serializable
{

    protected int a;
    protected int b;
    protected short c;
    protected short d;
    protected int e;
    protected byte f;
    private byte g;

    z()
    {
        g = 4;
        a = 0;
        b = 0;
        c = 0;
        d = 0;
        e = 0;
        f = 0;
    }

    protected final Boolean a(DataOutputStream dataoutputstream)
    {
        Boolean boolean1 = Boolean.valueOf(false);
        Boolean boolean2;
        try
        {
            dataoutputstream.writeByte(g);
            dataoutputstream.writeInt(a);
            dataoutputstream.writeInt(b);
            dataoutputstream.writeShort(c);
            dataoutputstream.writeShort(d);
            dataoutputstream.writeInt(e);
            dataoutputstream.writeByte(f);
            boolean2 = Boolean.valueOf(true);
        }
        catch (IOException ioexception)
        {
            return boolean1;
        }
        return boolean2;
    }
}
