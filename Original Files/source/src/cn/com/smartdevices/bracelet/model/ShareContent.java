// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.model;

import java.util.ArrayList;

// Referenced classes of package cn.com.smartdevices.bracelet.model:
//            ShareSportData

public class ShareContent
{

    public static final int SHARE_TYPE_PICTURE = 2;
    public static final int SHARE_TYPE_SPORT_DATA = 1;
    public String message;
    public ArrayList pics;
    public String picturePath;
    public ShareSportData shareSportData;
    public int shareType;

    public ShareContent()
    {
        shareType = 0;
        picturePath = "";
        message = "";
        pics = new ArrayList();
        shareSportData = new ShareSportData();
    }
}
