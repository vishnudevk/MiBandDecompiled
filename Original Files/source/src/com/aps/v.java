// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aps;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

// Referenced classes of package com.aps:
//            x, af

final class v
    implements Serializable
{

    protected byte a;
    protected ArrayList b;
    private byte c;

    v()
    {
        c = 8;
        a = 0;
        b = new ArrayList();
    }

    protected final Boolean a(DataOutputStream dataoutputstream)
    {
        Boolean boolean1 = Boolean.valueOf(false);
        int i;
        Boolean boolean2;
        x x1;
        try
        {
            dataoutputstream.writeByte(c);
            dataoutputstream.writeByte(a);
        }
        catch (IOException ioexception)
        {
            return boolean1;
        }
        i = 0;
        if (i >= a)
        {
            break; /* Loop/switch isn't completed */
        }
        x1 = (x)b.get(i);
        dataoutputstream.write(x1.a);
        dataoutputstream.writeShort(x1.b);
        dataoutputstream.write(af.a(x1.c, x1.c.length));
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_24;
_L1:
        boolean2 = Boolean.valueOf(true);
        return boolean2;
    }
}
