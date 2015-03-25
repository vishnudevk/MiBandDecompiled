// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aps;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

// Referenced classes of package com.aps:
//            af, Y, Z, X, 
//            z, v

final class s
    implements Serializable
{

    protected byte a[];
    protected byte b[];
    protected byte c[];
    protected short d;
    protected short e;
    protected byte f;
    protected byte g[];
    protected byte h[];
    protected short i;
    protected ArrayList j;
    private byte k;
    private short l;

    s()
    {
        k = 4;
        l = 0;
        a = new byte[16];
        b = new byte[16];
        c = new byte[16];
        d = 0;
        e = 0;
        f = 0;
        g = new byte[16];
        h = new byte[32];
        i = 0;
        j = new ArrayList();
    }

    private Boolean a(DataOutputStream dataoutputstream)
    {
        Boolean.valueOf(true);
        ByteArrayOutputStream bytearrayoutputstream;
        DataOutputStream dataoutputstream1;
        short word0;
        ByteArrayOutputStream bytearrayoutputstream1;
        DataOutputStream dataoutputstream2;
        Y y;
        Boolean boolean1;
        try
        {
            bytearrayoutputstream = new ByteArrayOutputStream();
            dataoutputstream1 = new DataOutputStream(bytearrayoutputstream);
            dataoutputstream1.flush();
            dataoutputstream1.write(a);
            dataoutputstream1.write(b);
            dataoutputstream1.write(c);
            dataoutputstream1.writeShort(d);
            dataoutputstream1.writeShort(e);
            dataoutputstream1.writeByte(f);
            g[15] = 0;
            dataoutputstream1.write(af.a(g, g.length));
            h[31] = 0;
            dataoutputstream1.write(af.a(h, h.length));
            dataoutputstream1.writeShort(i);
        }
        catch (IOException ioexception)
        {
            return Boolean.valueOf(false);
        }
        word0 = 0;
        if (word0 >= i)
        {
            break; /* Loop/switch isn't completed */
        }
        bytearrayoutputstream1 = new ByteArrayOutputStream();
        dataoutputstream2 = new DataOutputStream(bytearrayoutputstream1);
        dataoutputstream2.flush();
        y = (Y)j.get(word0);
        if (y.c != null && !y.c.a(dataoutputstream2).booleanValue())
        {
            Boolean.valueOf(false);
        }
        if (y.d != null && !y.d.a(dataoutputstream2).booleanValue())
        {
            Boolean.valueOf(false);
        }
        if (y.e != null && !y.e.a(dataoutputstream2).booleanValue())
        {
            Boolean.valueOf(false);
        }
        if (y.f != null && !y.f.a(dataoutputstream2).booleanValue())
        {
            Boolean.valueOf(false);
        }
        y.a = Integer.valueOf(4 + bytearrayoutputstream1.size()).shortValue();
        dataoutputstream1.writeShort(y.a);
        dataoutputstream1.writeInt(y.b);
        dataoutputstream1.write(bytearrayoutputstream1.toByteArray());
        word0++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_144;
_L1:
        l = Integer.valueOf(bytearrayoutputstream.size()).shortValue();
        dataoutputstream.writeByte(k);
        dataoutputstream.writeShort(l);
        dataoutputstream.write(bytearrayoutputstream.toByteArray());
        boolean1 = Boolean.valueOf(true);
        return boolean1;
    }

    protected final byte[] a()
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        a(new DataOutputStream(bytearrayoutputstream));
        return bytearrayoutputstream.toByteArray();
    }
}
