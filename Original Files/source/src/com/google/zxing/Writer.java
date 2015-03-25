// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing;

import com.google.zxing.common.BitMatrix;
import java.util.Map;

// Referenced classes of package com.google.zxing:
//            BarcodeFormat

public interface Writer
{

    public abstract BitMatrix encode(String s, BarcodeFormat barcodeformat, int i, int j);

    public abstract BitMatrix encode(String s, BarcodeFormat barcodeformat, int i, int j, Map map);
}
