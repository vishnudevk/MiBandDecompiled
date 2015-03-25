// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.model;


// Referenced classes of package cn.com.smartdevices.bracelet.model:
//            BasePushItem, PersonInfo

public class UserStatusPushItem extends BasePushItem
{

    public static int ACCEPT = 2;
    public static int DELETE = 4;
    public static int LOGIN = 0;
    public static int REFUSE = 3;
    public static int REQUEST = 1;
    public String content;
    public int status;
    public long timeStamp;
    public PersonInfo userInfo;

    public UserStatusPushItem()
    {
        super(0);
        status = LOGIN;
        timeStamp = 0L;
        content = "";
        userInfo = new PersonInfo();
    }

    public String getContent()
    {
        return content;
    }

}
