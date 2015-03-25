// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.multi;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.Result;
import java.util.Map;

public interface MultipleBarcodeReader
{

    public abstract Result[] decodeMultiple(BinaryBitmap binarybitmap);

    public abstract Result[] decodeMultiple(BinaryBitmap binarybitmap, Map map);
}
