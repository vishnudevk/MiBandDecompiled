// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.edmodo.cropper.cropwindow.edge;


// Referenced classes of package com.edmodo.cropper.cropwindow.edge:
//            Edge

public class EdgePair
{

    public Edge primary;
    public Edge secondary;

    public EdgePair(Edge edge, Edge edge1)
    {
        primary = edge;
        secondary = edge1;
    }
}
