// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.cache.disc.naming;


// Referenced classes of package com.nostra13.universalimageloader.cache.disc.naming:
//            FileNameGenerator

public class HashCodeFileNameGenerator
    implements FileNameGenerator
{

    public HashCodeFileNameGenerator()
    {
    }

    public String generate(String s)
    {
        return String.valueOf(s.hashCode());
    }
}
