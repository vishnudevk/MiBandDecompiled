// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing;

import java.util.Map;

// Referenced classes of package com.google.zxing:
//            BinaryBitmap, Result

public interface Reader
{

    public abstract Result decode(BinaryBitmap binarybitmap);

    public abstract Result decode(BinaryBitmap binarybitmap, Map map);

    public abstract void reset();
}
