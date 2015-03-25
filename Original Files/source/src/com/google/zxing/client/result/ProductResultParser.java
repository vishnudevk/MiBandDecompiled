// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.client.result;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import com.google.zxing.oned.UPCEReader;

// Referenced classes of package com.google.zxing.client.result:
//            ResultParser, ProductParsedResult, ParsedResult

public final class ProductResultParser extends ResultParser
{

    public ProductResultParser()
    {
    }

    public volatile ParsedResult parse(Result result)
    {
        return parse(result);
    }

    public ProductParsedResult parse(Result result)
    {
        BarcodeFormat barcodeformat = result.getBarcodeFormat();
        if (barcodeformat == BarcodeFormat.UPC_A || barcodeformat == BarcodeFormat.UPC_E || barcodeformat == BarcodeFormat.EAN_8 || barcodeformat == BarcodeFormat.EAN_13) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        String s;
        s = result.getText();
        int i = s.length();
        int j = 0;
label0:
        do
        {
label1:
            {
                if (j >= i)
                {
                    break label1;
                }
                char c = s.charAt(j);
                if (c < '0' || c > '9')
                {
                    break label0;
                }
                j++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        String s1;
        if (barcodeformat == BarcodeFormat.UPC_E)
        {
            s1 = UPCEReader.convertUPCEtoUPCA(s);
        } else
        {
            s1 = s;
        }
        return new ProductParsedResult(s, s1);
    }
}
