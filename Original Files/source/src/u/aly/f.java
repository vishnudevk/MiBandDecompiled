// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import android.content.Context;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

// Referenced classes of package u.aly:
//            at, au, c, bv, 
//            cc, ci

public class f
{

    private static final String a = ".imprint";
    private static final byte b[] = "pbl0".getBytes();
    private at c;
    private Context d;

    public f(Context context)
    {
        c = null;
        d = context;
    }

    private at a(at at1, at at2)
    {
        if (at2 == null)
        {
            return at1;
        }
        Map map = at1.d();
        Iterator iterator = at2.d().entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                at1.a(at2.h());
                at1.a(a(at1));
                return at1;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (((au)entry.getValue()).e())
            {
                map.put((String)entry.getKey(), (au)entry.getValue());
            } else
            {
                map.remove(entry.getKey());
            }
        } while (true);
    }

    private boolean c(at at1)
    {
        if (!at1.k().equals(a(at1)))
        {
            return false;
        }
        Iterator iterator = at1.d().values().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return true;
            }
            au au1 = (au)iterator.next();
            byte abyte0[] = u.aly.c.b(au1.j());
            byte abyte1[] = a(au1);
            int i = 0;
            while (i < 4) 
            {
                if (abyte0[i] != abyte1[i])
                {
                    return false;
                }
                i++;
            }
        } while (true);
    }

    public String a(at at1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = (new TreeMap(at1.d())).entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                stringbuilder.append(at1.b);
                return bv.a(stringbuilder.toString()).toLowerCase(Locale.US);
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            stringbuilder.append((String)entry.getKey());
            stringbuilder.append(((au)entry.getValue()).c());
            stringbuilder.append(((au)entry.getValue()).f());
            stringbuilder.append(((au)entry.getValue()).j());
        } while (true);
    }

    public at a()
    {
        this;
        JVM INSTR monitorenter ;
        at at1 = c;
        this;
        JVM INSTR monitorexit ;
        return at1;
        Exception exception;
        exception;
        throw exception;
    }

    public byte[] a(au au1)
    {
        ByteBuffer bytebuffer = ByteBuffer.allocate(8);
        bytebuffer.order(null);
        bytebuffer.putLong(au1.f());
        byte abyte0[] = bytebuffer.array();
        byte abyte1[] = b;
        byte abyte2[] = new byte[4];
        int i = 0;
        do
        {
            if (i >= 4)
            {
                return abyte2;
            }
            abyte2[i] = (byte)(abyte0[i] ^ abyte1[i]);
            i++;
        } while (true);
    }

    public void b()
    {
        Object obj = null;
        if ((new File(d.getFilesDir(), ".imprint")).exists()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        java.io.FileInputStream fileinputstream1 = d.openFileInput(".imprint");
        java.io.FileInputStream fileinputstream = fileinputstream1;
        byte abyte1[] = bv.b(fileinputstream);
        byte abyte0[];
        abyte0 = abyte1;
        bv.c(fileinputstream);
_L4:
        if (abyte0 != null)
        {
            try
            {
                at at1 = new at();
                (new cc()).a(at1, abyte0);
                c = at1;
                return;
            }
            catch (Exception exception2)
            {
                exception2.printStackTrace();
            }
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception1;
        exception1;
        fileinputstream = null;
_L7:
        exception1.printStackTrace();
        bv.c(fileinputstream);
        abyte0 = null;
          goto _L4
        Exception exception;
        exception;
_L6:
        bv.c(((java.io.InputStream) (obj)));
        throw exception;
        exception;
        obj = fileinputstream;
        if (true) goto _L6; else goto _L5
_L5:
        exception1;
          goto _L7
    }

    public void b(at at1)
    {
        while (at1 == null || !c(at1)) 
        {
            return;
        }
        this;
        JVM INSTR monitorenter ;
        at at2 = c;
        if (at2 != null) goto _L2; else goto _L1
_L1:
        c = at1;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
        at at3 = a(at2, at1);
        at1 = at3;
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void c()
    {
        if (c == null)
        {
            return;
        }
        try
        {
            byte abyte0[] = (new ci()).a(c);
            bv.a(new File(d.getFilesDir(), ".imprint"), abyte0);
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public boolean d()
    {
        return (new File(d.getFilesDir(), ".imprint")).delete();
    }

}
