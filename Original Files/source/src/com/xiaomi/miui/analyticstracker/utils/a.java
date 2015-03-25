// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.miui.analyticstracker.utils;

import java.util.Comparator;
import org.apache.http.NameValuePair;

final class a
    implements Comparator
{

    a()
    {
    }

    public int a(NameValuePair namevaluepair, NameValuePair namevaluepair1)
    {
        return namevaluepair.getName().compareTo(namevaluepair1.getName());
    }

    public int compare(Object obj, Object obj1)
    {
        return a((NameValuePair)obj, (NameValuePair)obj1);
    }
}
