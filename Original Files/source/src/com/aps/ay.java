// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aps;

import android.telephony.CellLocation;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;

public final class ay
{

    int a;
    int b;
    int c;
    int d;
    int e;

    ay(CellLocation celllocation)
    {
        a = 0x7fffffff;
        b = 0x7fffffff;
        c = 0x7fffffff;
        d = 0x7fffffff;
        e = 0x7fffffff;
        if (celllocation != null)
        {
            if (celllocation instanceof GsmCellLocation)
            {
                GsmCellLocation gsmcelllocation = (GsmCellLocation)celllocation;
                e = gsmcelllocation.getCid();
                d = gsmcelllocation.getLac();
            } else
            if (celllocation instanceof CdmaCellLocation)
            {
                CdmaCellLocation cdmacelllocation = (CdmaCellLocation)celllocation;
                c = cdmacelllocation.getBaseStationId();
                b = cdmacelllocation.getNetworkId();
                a = cdmacelllocation.getSystemId();
                return;
            }
        }
    }
}
