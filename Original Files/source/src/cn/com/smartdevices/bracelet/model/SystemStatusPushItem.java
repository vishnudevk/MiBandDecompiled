// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.model;


// Referenced classes of package cn.com.smartdevices.bracelet.model:
//            BasePushItem, MicroBlogItem, ShareContent

public class SystemStatusPushItem extends BasePushItem
{

    public MicroBlogItem item;

    public SystemStatusPushItem()
    {
        super(2);
        item = new MicroBlogItem();
    }

    public String getContent()
    {
        return item.shareContent.message;
    }
}
