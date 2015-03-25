// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.model;


public class ShareBackgroundItem
{

    public String reachedBgUrl;
    public String unReachedBgUrl;

    public ShareBackgroundItem()
    {
        reachedBgUrl = "";
        unReachedBgUrl = "";
    }

    public boolean equals(Object obj)
    {
        ShareBackgroundItem sharebackgrounditem = (ShareBackgroundItem)obj;
        return sharebackgrounditem.reachedBgUrl.equalsIgnoreCase(reachedBgUrl) && sharebackgrounditem.unReachedBgUrl.equalsIgnoreCase(unReachedBgUrl);
    }

    public boolean isValid()
    {
        return reachedBgUrl != null && reachedBgUrl.length() > 0 && reachedBgUrl.startsWith("http://") && unReachedBgUrl != null && unReachedBgUrl.length() > 0 && unReachedBgUrl.startsWith("http://");
    }
}
