// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.model;

import java.util.Date;
import org.json.JSONArray;

// Referenced classes of package cn.com.smartdevices.bracelet.model:
//            BasePushItem

public class DataStatusPushItem extends BasePushItem
{

    public JSONArray dates;
    public long timeStamp;
    public String uuid;

    public DataStatusPushItem()
    {
        super(1);
        timeStamp = 0L;
        uuid = "";
        dates = new JSONArray();
    }

    public String getContent()
    {
        return (new StringBuilder()).append(uuid).append(":").append(dates.toString()).append("\n").append("[").append((new Date(timeStamp)).toString()).append("]").toString();
    }
}
