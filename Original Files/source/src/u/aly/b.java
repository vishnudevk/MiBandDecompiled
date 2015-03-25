// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import android.content.Context;

// Referenced classes of package u.aly:
//            a

public class b extends a
{

    private static final String a = "android_id";
    private Context b;

    public b(Context context)
    {
        super("android_id");
        b = context;
    }

    public String f()
    {
        String s;
        try
        {
            s = android.provider.Settings.Secure.getString(b.getContentResolver(), "android_id");
        }
        catch (Exception exception)
        {
            return null;
        }
        return s;
    }
}
