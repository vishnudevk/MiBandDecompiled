// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao.query;

import java.util.List;

public interface WhereCondition
{

    public abstract void appendTo(StringBuilder stringbuilder, String s);

    public abstract void appendValuesTo(List list);
}
