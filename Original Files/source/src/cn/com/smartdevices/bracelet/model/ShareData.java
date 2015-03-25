// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ShareData
    implements Parcelable
{

    private static final int COLOR_ACTIVITY_STEP = 0xff1898c4;
    private static final int COLOR_CONTINUE_SUCC = 0xffe53c44;
    private static final int COLOR_CONTINUE_SUCC_NEW_RECORD = 0xfff57130;
    private static final int COLOR_GOAL_FAILED = 0xff1898c4;
    private static final int COLOR_GOAL_SUCC = 0xfff57130;
    private static final int COLOR_LAST_NIGHT_SLEEP = 0xff373d74;
    private static final int COLOR_MONTH_SLEEP = 0xff492a6c;
    private static final int COLOR_MONTH_STEP = 0xff17a262;
    private static final int COLOR_NEW_RECORD = 0xffee5734;
    private static final int COLOR_WEEK_SLEEP = 0xff492a6c;
    private static final int COLOR_WEEK_STEP = 0xff17a262;
    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    public static final int SHARE_TYPE_ACTIVITY_STEP = 9;
    public static final int SHARE_TYPE_CONTINUE_SUCC = 8;
    public static final int SHARE_TYPE_CONTINUE_SUCC_NEW_RECORD = 10;
    public static final int SHARE_TYPE_EVENT = 11;
    public static final int SHARE_TYPE_GOAL_FAILED = 1;
    public static final int SHARE_TYPE_GOAL_SUCC = 0;
    public static final int SHARE_TYPE_LAST_NIGHT_SLEEP = 2;
    public static final int SHARE_TYPE_MONTH_AVE_STEPS = 6;
    public static final int SHARE_TYPE_MONTH_SLEEP = 4;
    public static final int SHARE_TYPE_NEW_RECORD = 5;
    public static final int SHARE_TYPE_WEEK_AVE_STEPS = 7;
    public static final int SHARE_TYPE_WEEK_SLEEP = 3;
    public int color;
    public String content;
    public String contentUnit;
    public String description;
    public String time;
    public String time_tips;
    public String title;
    public int type;

    public ShareData()
    {
        type = 0;
        title = "";
        content = "";
        contentUnit = "";
        time = "";
        time_tips = "";
        description = "";
        color = 0;
    }

    public ShareData(int i)
    {
        type = 0;
        title = "";
        content = "";
        contentUnit = "";
        time = "";
        time_tips = "";
        description = "";
        color = 0;
        setType(i);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean isSleepType()
    {
        return type == 2 || type == 4 || type == 3;
    }

    public void setType(int i)
    {
        type = i;
        switch (i)
        {
        default:
            return;

        case 0: // '\0'
            color = 0xfff57130;
            return;

        case 1: // '\001'
            color = 0xff1898c4;
            return;

        case 2: // '\002'
            color = 0xff373d74;
            return;

        case 6: // '\006'
            color = 0xff17a262;
            return;

        case 4: // '\004'
            color = 0xff492a6c;
            return;

        case 5: // '\005'
            color = 0xffee5734;
            return;

        case 7: // '\007'
            color = 0xff17a262;
            return;

        case 3: // '\003'
            color = 0xff492a6c;
            return;

        case 8: // '\b'
            color = 0xffe53c44;
            return;

        case 10: // '\n'
            color = 0xfff57130;
            return;

        case 9: // '\t'
            color = 0xff1898c4;
            return;
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append("type:").append(type).append("\n").append("title:").append(title).append("\n").append("content:").append(content).append("\n").append("contentUnit:").append(contentUnit).append("\n").append("time:").append(time).append("\n").append("time_tips:").append(time_tips).append("\n").append("description:").append(description).append("\n").append("color:").append(color).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(title);
        parcel.writeString(content);
        parcel.writeString(contentUnit);
        parcel.writeString(time);
        parcel.writeString(time_tips);
        parcel.writeString(description);
        parcel.writeInt(color);
        parcel.writeInt(type);
    }


    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public ShareData createFromParcel(Parcel parcel)
        {
            ShareData sharedata = new ShareData();
            sharedata.title = parcel.readString();
            sharedata.content = parcel.readString();
            sharedata.contentUnit = parcel.readString();
            sharedata.time = parcel.readString();
            sharedata.time_tips = parcel.readString();
            sharedata.description = parcel.readString();
            sharedata.color = parcel.readInt();
            sharedata.type = parcel.readInt();
            return sharedata;
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ShareData[] newArray(int i)
        {
            return null;
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

        _cls1()
        {
        }
    }

}
