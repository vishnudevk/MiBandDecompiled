// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao.identityscope;


public final class IdentityScopeType extends Enum
{

    private static final IdentityScopeType $VALUES[];
    public static final IdentityScopeType None;
    public static final IdentityScopeType Session;

    private IdentityScopeType(String s, int i)
    {
        super(s, i);
    }

    public static IdentityScopeType valueOf(String s)
    {
        return (IdentityScopeType)Enum.valueOf(de/greenrobot/dao/identityscope/IdentityScopeType, s);
    }

    public static IdentityScopeType[] values()
    {
        return (IdentityScopeType[])$VALUES.clone();
    }

    static 
    {
        Session = new IdentityScopeType("Session", 0);
        None = new IdentityScopeType("None", 1);
        IdentityScopeType aidentityscopetype[] = new IdentityScopeType[2];
        aidentityscopetype[0] = Session;
        aidentityscopetype[1] = None;
        $VALUES = aidentityscopetype;
    }
}
