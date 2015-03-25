// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.model;


// Referenced classes of package cn.com.smartdevices.bracelet.model:
//            PersonInfo

public class CommentItem
{

    public long cid;
    public long createTime;
    public String ipAddress;
    public String message;
    public String source;
    public int status;
    public PersonInfo userInfo;

    public CommentItem()
    {
        cid = -1L;
        userInfo = new PersonInfo();
        ipAddress = "";
        createTime = 0L;
        message = "";
        source = "";
        status = 1;
    }
}
