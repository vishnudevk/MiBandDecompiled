// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.webapi;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.activity.LoginActivity;
import cn.com.smartdevices.bracelet.model.BasePushItem;
import cn.com.smartdevices.bracelet.model.CommentItem;
import cn.com.smartdevices.bracelet.model.DataStatusPushItem;
import cn.com.smartdevices.bracelet.model.LoginInfo;
import cn.com.smartdevices.bracelet.model.MicroBlogItem;
import cn.com.smartdevices.bracelet.model.MiliConfig;
import cn.com.smartdevices.bracelet.model.NetDataInfo;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.PicUrl;
import cn.com.smartdevices.bracelet.model.ShareBackgroundItem;
import cn.com.smartdevices.bracelet.model.ShareContent;
import cn.com.smartdevices.bracelet.model.ShareSportData;
import cn.com.smartdevices.bracelet.model.SystemStatusPushItem;
import cn.com.smartdevices.bracelet.model.UploadData;
import cn.com.smartdevices.bracelet.model.UserLocationData;
import cn.com.smartdevices.bracelet.model.UserStatusPushItem;
import cn.com.smartdevices.bracelet.model.UserTotalSportData;
import java.util.ArrayList;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package cn.com.smartdevices.bracelet.webapi:
//            WebStatus

public class WebRes
{

    private static String a = "WebRes";
    private static Context b = null;
    private static WebStatus c = new WebStatus();

    public WebRes()
    {
    }

    private static ShareSportData a(String s)
    {
        ShareSportData sharesportdata = new ShareSportData();
        try
        {
            sharesportdata.fromString(s);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return sharesportdata;
        }
        return sharesportdata;
    }

    private static UploadData a(JSONObject jsonobject)
    {
        UploadData uploaddata = new UploadData();
        uploaddata.date = jsonobject.getString("date");
        uploaddata.summary = jsonobject.getString("summary");
        if (!jsonobject.isNull("data"))
        {
            uploaddata.data = Base64.decode(jsonobject.getString("data"), 2);
        }
        return uploaddata;
    }

    private static void a(JSONObject jsonobject, PersonInfo personinfo)
    {
        UserTotalSportData usertotalsportdata = new UserTotalSportData();
        usertotalsportdata.steps = jsonobject.optString("steps");
        usertotalsportdata.distance = jsonobject.optString("distance");
        usertotalsportdata.calories = jsonobject.optString("calories");
        usertotalsportdata.averageSteps = jsonobject.optString("averagesteps");
        usertotalsportdata.totalwearingdays = jsonobject.optString("totalwearingdays");
        personinfo.totalSportData = usertotalsportdata;
    }

    private static PersonInfo b(JSONObject jsonobject)
    {
        PersonInfo personinfo = new PersonInfo();
        if (jsonobject.has("uid") && jsonobject.getString("uid").length() > 0)
        {
            personinfo.uid = jsonobject.getLong("uid");
        }
        personinfo.nickname = jsonobject.getString("username");
        if (jsonobject.has("gender") && jsonobject.getString("gender").length() > 0)
        {
            personinfo.gender = jsonobject.getInt("gender");
        }
        if (jsonobject.has("height") && jsonobject.getString("height").length() > 0)
        {
            personinfo.height = jsonobject.getInt("height");
        }
        if (jsonobject.has("weight") && jsonobject.getString("weight").length() > 0)
        {
            personinfo.weight = jsonobject.getInt("weight");
        }
        personinfo.avatarUrl = jsonobject.getString("avatar");
        personinfo.birthday = jsonobject.getString("birthday");
        String as[] = personinfo.birthday.split("-");
        int i = Calendar.getInstance().get(1);
        if (as[0] != null && as[0].length() > 0)
        {
            personinfo.age = i - Integer.parseInt(as[0]);
        }
        personinfo.location = UserLocationData.fromJsonStr(jsonobject.optString("location"));
        personinfo.source = jsonobject.getString("source");
        if (jsonobject.has("status") && jsonobject.getString("status").length() > 0)
        {
            personinfo.state = jsonobject.getInt("status");
        }
        if (jsonobject.has("gid") && jsonobject.getString("gid").length() > 0)
        {
            personinfo.gid = jsonobject.getInt("gid");
        }
        personinfo.personSignature = jsonobject.getString("signature");
        personinfo.pinyin = "";
        return personinfo;
    }

    private static void b(JSONObject jsonobject, PersonInfo personinfo)
    {
        Debug.i(a, (new StringBuilder()).append("parseUserInfo dataObj:").append(jsonobject.toString()).toString());
        if (jsonobject.length() == 0)
        {
            Debug.i(a, "parseUserInfo dataObj is null");
            return;
        }
        if (jsonobject.has("uid") && jsonobject.getString("uid").length() > 0)
        {
            personinfo.uid = jsonobject.getLong("uid");
        }
        if (personinfo.getNeedSyncServer() != 0)
        {
            Debug.i(a, "\n Person info not synced to server, so we skip parse from server! \n");
            return;
        }
        if (jsonobject.has("height") && jsonobject.getString("height").length() > 0)
        {
            personinfo.height = jsonobject.getInt("height");
        }
        if (jsonobject.has("weight") && jsonobject.getString("weight").length() > 0)
        {
            personinfo.weight = jsonobject.getInt("weight");
        }
        if (jsonobject.has("gender") && jsonobject.getString("gender").length() > 0)
        {
            personinfo.gender = jsonobject.getInt("gender");
        }
        personinfo.lastLoginTime = jsonobject.getString("last_login_time");
        personinfo.createTime = jsonobject.getString("creat_time");
        personinfo.birthday = jsonobject.getString("birthday");
        personinfo.avatarUrl = jsonobject.getString("avatar");
        UserLocationData userlocationdata = UserLocationData.fromJsonStr(jsonobject.optString("location"));
        if (userlocationdata != null && userlocationdata.isValid())
        {
            personinfo.location = userlocationdata;
        }
        MiliConfig miliconfig = MiliConfig.fromJsonStr(Utils.URLDecodeStr(jsonobject.optString("config")));
        if (miliconfig != null && miliconfig.isValid())
        {
            personinfo.setMiliConfig(miliconfig);
            Debug.i(a, (new StringBuilder()).append("miliConfig=").append(miliconfig).toString());
        }
        ArrayList arraylist = PersonInfo.parseAlarmClockItems(Utils.URLDecodeStr(jsonobject.optString("alarm_clock")));
        if (arraylist != null)
        {
            personinfo.alarmClockItems = arraylist;
        }
        personinfo.age = jsonobject.optInt("age");
        personinfo.personSignature = jsonobject.getString("signature");
    }

    private static WebStatus c(JSONObject jsonobject)
    {
        Debug.i(a, (new StringBuilder()).append("getWebStatus:").append(jsonobject.toString()).toString());
        WebStatus webstatus = new WebStatus();
        try
        {
            webstatus.code = jsonobject.getInt("code");
            webstatus.message = jsonobject.getString("message");
        }
        catch (JSONException jsonexception)
        {
            webstatus.code = 2;
            Debug.i(a, jsonexception.getMessage());
        }
        if (webstatus.isAuthInvalid() && !c.equals(webstatus))
        {
            Intent intent = new Intent();
            intent.setClass(b, cn/com/smartdevices/bracelet/activity/LoginActivity);
            intent.setFlags(0x10008000);
            b.startActivity(intent);
        }
        c = webstatus;
        return webstatus;
    }

    private static MicroBlogItem d(JSONObject jsonobject)
    {
        int i;
        MicroBlogItem microblogitem;
        i = 0;
        Debug.l(a, (new StringBuilder()).append("parseMicroBlog:").append(jsonobject.toString()).toString());
        microblogitem = new MicroBlogItem();
        microblogitem.postid = jsonobject.getLong("postid");
        if (!jsonobject.isNull("visible"))
        {
            microblogitem.visible = jsonobject.getInt("visible");
        }
        if (!jsonobject.isNull("issystem"))
        {
            microblogitem.systemFlag = jsonobject.getInt("issystem");
        }
        if (!jsonobject.isNull("web_url"))
        {
            microblogitem.webUrl = jsonobject.getString("web_url");
        }
        b(jsonobject.getJSONObject("user"), microblogitem.info);
        microblogitem.shareContent.message = jsonobject.getString("message");
        microblogitem.shareContent.shareType = jsonobject.getInt("share_type");
        if (microblogitem.shareContent.shareType != 1) goto _L2; else goto _L1
_L1:
        if (jsonobject.has("share_sport_data"))
        {
            String s = jsonobject.getString("share_sport_data");
            if (s != null && s.length() > 0)
            {
                microblogitem.shareContent.shareSportData = a(s);
            }
        }
_L4:
        if (jsonobject.has("data") && jsonobject.getJSONObject("data").length() >= 3)
        {
            microblogitem.data = a(jsonobject.getJSONObject("data"));
        }
        microblogitem.source = jsonobject.getString("source");
        microblogitem.createTime = jsonobject.getString("create_time");
        microblogitem.likeNum = jsonobject.getInt("likenum");
        microblogitem.commentsNum = jsonobject.getInt("commentsnum");
        JSONArray jsonarray1 = jsonobject.getJSONArray("comments");
        for (int k = 0; k < jsonarray1.length(); k++)
        {
            CommentItem commentitem = e(jsonarray1.getJSONObject(k));
            microblogitem.comments.add(commentitem);
        }

        break; /* Loop/switch isn't completed */
_L2:
        if (microblogitem.shareContent.shareType == 2)
        {
            JSONArray jsonarray = jsonobject.getJSONArray("picurl");
            int j = 0;
            while (j < jsonarray.length()) 
            {
                JSONObject jsonobject1 = jsonarray.getJSONObject(j);
                PicUrl picurl = new PicUrl();
                picurl.originUrl = jsonobject1.getString("original_pic");
                picurl.thumbUrl = jsonobject1.getString("thumb_pic");
                microblogitem.shareContent.pics.add(picurl);
                j++;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        JSONArray jsonarray2 = jsonobject.getJSONArray("likeuserlist");
        if (jsonarray2 != null && jsonarray2.length() > 0)
        {
            if (microblogitem.likePersons == null)
            {
                microblogitem.likePersons = new ArrayList(8);
            } else
            {
                microblogitem.likePersons.clear();
                i = 0;
            }
            for (; i < jsonarray2.length(); i++)
            {
                PersonInfo personinfo = new PersonInfo();
                b(jsonarray2.getJSONObject(i), personinfo);
                microblogitem.likePersons.add(personinfo);
                Debug.i(a, (new StringBuilder()).append("Add like relation: ").append(personinfo.nickname).append(" like ").append(microblogitem.info.nickname).toString());
            }

        }
        return microblogitem;
    }

    private static CommentItem e(JSONObject jsonobject)
    {
        Debug.l(a, (new StringBuilder()).append("parseComment:").append(jsonobject.toString()).toString());
        CommentItem commentitem = new CommentItem();
        commentitem.cid = jsonobject.getLong("cid");
        b(jsonobject.getJSONObject("user"), commentitem.userInfo);
        commentitem.createTime = jsonobject.getLong("create_time");
        commentitem.message = jsonobject.getString("message");
        commentitem.source = jsonobject.getString("source");
        commentitem.status = jsonobject.getInt("status");
        return commentitem;
    }

    public static WebStatus getWebStatus(String s)
    {
        Debug.i(a, (new StringBuilder()).append("getWebStatus:").append(s).toString());
        WebStatus webstatus = new WebStatus();
        try
        {
            JSONObject jsonobject = new JSONObject(s);
            webstatus.code = jsonobject.getInt("code");
            webstatus.message = jsonobject.getString("message");
        }
        catch (JSONException jsonexception)
        {
            webstatus.code = 2;
            jsonexception.printStackTrace();
            Debug.i(a, jsonexception.getMessage());
        }
        if (webstatus.isAuthInvalid() && !c.equals(webstatus))
        {
            Intent intent = new Intent();
            intent.setClass(b, cn/com/smartdevices/bracelet/activity/LoginActivity);
            intent.setFlags(0x10008000);
            b.startActivity(intent);
        }
        c = webstatus;
        return webstatus;
    }

    public static void init(Context context)
    {
        b = context;
    }

    public static WebStatus parseAvatar(String s, PersonInfo personinfo)
    {
        WebStatus webstatus = new WebStatus();
        JSONObject jsonobject;
        WebStatus webstatus2;
        jsonobject = new JSONObject(s);
        webstatus2 = c(jsonobject);
        WebStatus webstatus1 = webstatus2;
        if (!webstatus1.success())
        {
            return webstatus1;
        }
        JSONObject jsonobject1 = jsonobject.getJSONObject("data");
        if (jsonobject1 == null) goto _L2; else goto _L1
_L1:
        String s1 = jsonobject1.optString("avatar");
        if (s1.length() > 0)
        {
            personinfo.avatarUrl = s1;
        }
        Debug.i(a, (new StringBuilder()).append("get avatar Url: ").append(s1).toString());
        return webstatus1;
        JSONException jsonexception1;
        jsonexception1;
_L4:
        webstatus1.code = 2;
        Debug.i(a, jsonexception1.getMessage());
        return webstatus1;
_L2:
        webstatus1.code = 2;
        return webstatus1;
        JSONException jsonexception;
        jsonexception;
        webstatus1 = webstatus;
        jsonexception1 = jsonexception;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static PersonInfo parseBindedUserInfo(String s, PersonInfo personinfo)
    {
        String s1 = Utils.purgeJson(s);
        try
        {
            b(new JSONObject(s1), personinfo);
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            return personinfo;
        }
        return personinfo;
    }

    public static WebStatus parseDownload(String s, ArrayList arraylist)
    {
        WebStatus webstatus = new WebStatus();
        JSONObject jsonobject;
        WebStatus webstatus2;
        Debug.l(a, (new StringBuilder()).append("parseDownload:\n").append(s).toString());
        Debug.f(a, s);
        jsonobject = new JSONObject(s);
        webstatus2 = c(jsonobject);
        WebStatus webstatus1 = webstatus2;
        if (!webstatus1.success())
        {
            return webstatus1;
        }
        JSONObject jsonobject1;
        int i;
        jsonobject1 = jsonobject.getJSONObject("data");
        i = jsonobject1.getInt("data_len");
        if (jsonobject1.isNull("dates")) goto _L2; else goto _L1
_L1:
        JSONArray jsonarray1;
        NetDataInfo netdatainfo1;
        jsonarray1 = jsonobject1.getJSONArray("dates");
        netdatainfo1 = new NetDataInfo();
        if (jsonarray1.length() != 2) goto _L4; else goto _L3
_L3:
        netdatainfo1.dataState = 2;
        netdatainfo1.startDate = jsonarray1.getString(0);
        netdatainfo1.stopDate = jsonarray1.getString(1);
_L13:
        Keeper.keepNetInfo(netdatainfo1);
_L2:
        JSONArray jsonarray = jsonobject1.getJSONArray("list");
        if (jsonarray.toString().length() == i) goto _L6; else goto _L5
_L5:
        Debug.i(a, "size error!");
        return webstatus1;
        JSONException jsonexception1;
        jsonexception1;
_L11:
        webstatus1.code = 2;
        Debug.i(a, (new StringBuilder()).append("parseDownload:").append(jsonexception1.getMessage()).toString());
        Debug.l(a, jsonexception1.getMessage());
        return webstatus1;
_L4:
        netdatainfo1.dataState = 1;
        continue; /* Loop/switch isn't completed */
_L6:
        int j;
        NetDataInfo netdatainfo;
        j = jsonarray.length();
        Debug.i(a, (new StringBuilder()).append("list Size:").append(j).toString());
        netdatainfo = new NetDataInfo();
        if (j <= 0)
        {
            break MISSING_BLOCK_LABEL_391;
        }
        netdatainfo.dataState = 2;
        netdatainfo.startDate = jsonarray.getJSONObject(0).getString("date");
        netdatainfo.stopDate = jsonarray.getJSONObject(j - 1).getString("date");
_L9:
        Keeper.keepNetInfo(netdatainfo);
        arraylist.ensureCapacity(j);
        int k = 0;
_L8:
        if (k >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist.add(a(jsonarray.getJSONObject(k)));
        k++;
        if (true) goto _L8; else goto _L7
_L7:
        break; /* Loop/switch isn't completed */
        netdatainfo.dataState = 1;
          goto _L9
        JSONException jsonexception;
        jsonexception;
        webstatus1 = webstatus;
        jsonexception1 = jsonexception;
        if (true) goto _L11; else goto _L10
_L10:
        return webstatus1;
        if (true) goto _L13; else goto _L12
_L12:
    }

    public static WebStatus parseFriendList(String s, ArrayList arraylist)
    {
        WebStatus webstatus;
        Debug.l(a, (new StringBuilder()).append("parseFriendList:").append(s).toString());
        webstatus = new WebStatus();
        JSONObject jsonobject;
        WebStatus webstatus2;
        jsonobject = new JSONObject(s);
        webstatus2 = c(jsonobject);
        WebStatus webstatus1 = webstatus2;
        if (!webstatus1.success())
        {
            return webstatus1;
        }
        JSONArray jsonarray;
        int i;
        jsonarray = jsonobject.getJSONObject("data").getJSONArray("list");
        i = jsonarray.length();
        arraylist.ensureCapacity(i);
        int j = 0;
_L2:
        if (j >= i)
        {
            break; /* Loop/switch isn't completed */
        }
        PersonInfo personinfo = b(jsonarray.getJSONObject(j));
        arraylist.add(personinfo);
        Debug.i(a, personinfo.toString());
        j++;
        if (true) goto _L2; else goto _L1
        Exception exception;
        exception;
        Exception exception1;
        webstatus1 = webstatus;
        exception1 = exception;
_L3:
        webstatus1.code = 2;
        Debug.i(a, exception1.getMessage());
        return webstatus1;
        exception1;
        if (true) goto _L3; else goto _L1
_L1:
        return webstatus1;
    }

    public static WebStatus parseMicroBlogs(String s, ArrayList arraylist)
    {
        WebStatus webstatus;
        Debug.l(a, (new StringBuilder()).append("parseMicroBlogs:").append(s).toString());
        webstatus = new WebStatus();
        JSONObject jsonobject;
        WebStatus webstatus2;
        jsonobject = new JSONObject(s);
        webstatus2 = c(jsonobject);
        WebStatus webstatus1 = webstatus2;
        if (!webstatus1.success())
        {
            return webstatus1;
        }
        JSONArray jsonarray;
        int i;
        jsonarray = jsonobject.getJSONObject("data").getJSONArray("list");
        i = jsonarray.length();
        int j = 0;
_L2:
        if (j >= i)
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist.add(d(jsonarray.getJSONObject(j)));
        j++;
        if (true) goto _L2; else goto _L1
        JSONException jsonexception;
        jsonexception;
        JSONException jsonexception1;
        webstatus1 = webstatus;
        jsonexception1 = jsonexception;
_L3:
        webstatus1.code = 2;
        Debug.i(a, jsonexception1.getMessage());
        return webstatus1;
        jsonexception1;
        if (true) goto _L3; else goto _L1
_L1:
        return webstatus1;
    }

    public static BasePushItem parsePushMessage(String s)
    {
        Debug.i(a, (new StringBuilder()).append("parsePushMessage:").append(s).toString());
        int i;
        JSONObject jsonobject1;
        JSONObject jsonobject = new JSONObject(s);
        i = jsonobject.getInt("type");
        jsonobject1 = jsonobject.getJSONObject("data");
        i;
        JVM INSTR tableswitch 0 2: default 239
    //                   0 145
    //                   1 80
    //                   2 211;
           goto _L1 _L2 _L3 _L4
_L3:
        DataStatusPushItem datastatuspushitem;
        datastatuspushitem = new DataStatusPushItem();
        datastatuspushitem.dates = jsonobject1.getJSONArray("dates");
        datastatuspushitem.timeStamp = jsonobject1.getLong("timeStamp");
        datastatuspushitem.uuid = jsonobject1.getString("uuid");
        return datastatuspushitem;
        JSONException jsonexception;
        jsonexception;
        Debug.i(a, jsonexception.getMessage());
          goto _L1
_L2:
        UserStatusPushItem userstatuspushitem;
        userstatuspushitem = new UserStatusPushItem();
        userstatuspushitem.status = jsonobject1.getInt("status");
        b(jsonobject1.getJSONObject("userinfo"), userstatuspushitem.userInfo);
        userstatuspushitem.content = jsonobject1.getString("content");
        userstatuspushitem.timeStamp = jsonobject1.getLong("timeStamp");
        return userstatuspushitem;
_L4:
        SystemStatusPushItem systemstatuspushitem;
        systemstatuspushitem = new SystemStatusPushItem();
        systemstatuspushitem.item = d(jsonobject1.getJSONObject("microblog"));
        return systemstatuspushitem;
_L1:
        return null;
    }

    public static WebStatus parseShareBackground(String s, ShareBackgroundItem sharebackgrounditem)
    {
        WebStatus webstatus;
        Debug.l(a, (new StringBuilder()).append("parseShareBackground:").append(s).toString());
        webstatus = new WebStatus();
        JSONObject jsonobject;
        WebStatus webstatus2;
        jsonobject = new JSONObject(s);
        webstatus2 = c(jsonobject);
        WebStatus webstatus1 = webstatus2;
        if (!webstatus1.success())
        {
            return webstatus1;
        }
        JSONObject jsonobject1 = jsonobject.getJSONObject("data");
        if (jsonobject1 == null) goto _L2; else goto _L1
_L1:
        JSONObject jsonobject2 = jsonobject1.getJSONObject("list");
        if (jsonobject2 == null) goto _L2; else goto _L3
_L3:
        sharebackgrounditem.reachedBgUrl = jsonobject2.getString("reach");
        sharebackgrounditem.unReachedBgUrl = jsonobject2.getString("unreach");
        return webstatus1;
        JSONException jsonexception1;
        jsonexception1;
_L4:
        webstatus1.code = 2;
        Debug.i(a, jsonexception1.getMessage());
        return webstatus1;
        JSONException jsonexception;
        jsonexception;
        webstatus1 = webstatus;
        jsonexception1 = jsonexception;
        if (true) goto _L4; else goto _L2
_L2:
        return webstatus1;
    }

    public static WebStatus parseUserInfo(String s, PersonInfo personinfo)
    {
        String s1;
        WebStatus webstatus;
        Debug.i(a, (new StringBuilder()).append("parseUserInfo :").append(s).toString());
        s1 = Utils.purgeJson(s);
        webstatus = new WebStatus();
        JSONObject jsonobject;
        WebStatus webstatus2;
        jsonobject = new JSONObject(s1);
        webstatus2 = c(jsonobject);
        WebStatus webstatus1 = webstatus2;
        if (!webstatus1.success())
        {
            return webstatus1;
        }
        b(jsonobject.getJSONObject("data"), personinfo);
        return webstatus1;
        JSONException jsonexception1;
        jsonexception1;
_L2:
        webstatus1.code = 2;
        Debug.i(a, jsonexception1.getMessage());
        return webstatus1;
        JSONException jsonexception;
        jsonexception;
        webstatus1 = webstatus;
        jsonexception1 = jsonexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static WebStatus parseUserTotalSportData(String s, PersonInfo personinfo)
    {
        WebStatus webstatus = new WebStatus();
        JSONObject jsonobject;
        WebStatus webstatus2;
        jsonobject = new JSONObject(s);
        webstatus2 = c(jsonobject);
        WebStatus webstatus1 = webstatus2;
        if (!webstatus1.success())
        {
            return webstatus1;
        }
        a(jsonobject.getJSONObject("data"), personinfo);
        return webstatus1;
        JSONException jsonexception1;
        jsonexception1;
_L2:
        webstatus1.code = 2;
        Debug.i(a, jsonexception1.getMessage());
        return webstatus1;
        JSONException jsonexception;
        jsonexception;
        webstatus1 = webstatus;
        jsonexception1 = jsonexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static String parseWeixinQR(String s)
    {
        WebStatus webstatus;
        Debug.l(a, (new StringBuilder()).append("parseWeixinQR:").append(s).toString());
        webstatus = new WebStatus();
        JSONObject jsonobject;
        jsonobject = new JSONObject(s);
        webstatus = c(jsonobject);
        if (!webstatus.success())
        {
            return null;
        }
        JSONObject jsonobject1 = jsonobject.getJSONObject("data");
        if (jsonobject1 == null)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        String s1 = jsonobject1.getString("list");
        return s1;
        JSONException jsonexception;
        jsonexception;
        webstatus.code = 2;
        Debug.i(a, jsonexception.getMessage());
        return null;
    }

    public static String parseXiaoMiUserPhone(String s)
    {
        if (s == null)
        {
            return "";
        }
        JSONObject jsonobject = new JSONObject(s);
        if (!jsonobject.optString("result").equals("ok"))
        {
            return "";
        }
        JSONObject jsonobject1 = jsonobject.optJSONObject("data");
        if (jsonobject1 == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        String s1 = jsonobject1.optString("phone");
        return s1;
        JSONException jsonexception;
        jsonexception;
        jsonexception.printStackTrace();
        return "";
    }

    public static LoginInfo parseXiaoMiUserProfile(LoginInfo logininfo, String s)
    {
        LoginInfo logininfo1;
        JSONObject jsonobject;
        if (logininfo == null)
        {
            logininfo1 = new LoginInfo();
        } else
        {
            logininfo1 = logininfo;
        }
        jsonobject = new JSONObject(s);
        if (!jsonobject.optString("result").equals("ok"))
        {
            return logininfo1;
        }
        JSONObject jsonobject1;
        try
        {
            jsonobject1 = jsonobject.optJSONObject("data");
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            return logininfo1;
        }
        if (jsonobject1 == null)
        {
            break MISSING_BLOCK_LABEL_128;
        }
        logininfo1.aliasNick = jsonobject1.optString("aliasNick");
        logininfo1.miliaoNick = jsonobject1.optString("miliaoNick");
        logininfo1.miid = jsonobject1.optString("userId");
        logininfo1.miliaoIcon = jsonobject1.optString("miliaoIcon");
        logininfo1.miliaoIcon_320 = jsonobject1.optString("miliaoIcon_320");
        return logininfo1;
        return logininfo1;
    }

    public static LoginInfo parseXiaoMiUserRelation(LoginInfo logininfo, String s)
    {
        JSONObject jsonobject = new JSONObject(s);
        if (!jsonobject.optString("result").equals("ok"))
        {
            return logininfo;
        }
        JSONObject jsonobject1 = jsonobject.optJSONObject("data");
        if (jsonobject1 == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        logininfo.friends = jsonobject1.optString("friends");
        return logininfo;
        JSONException jsonexception;
        jsonexception;
        jsonexception.printStackTrace();
        return logininfo;
    }

}
