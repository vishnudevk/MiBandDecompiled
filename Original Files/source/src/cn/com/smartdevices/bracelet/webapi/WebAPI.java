// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.webapi;

import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.model.LoginData;
import cn.com.smartdevices.bracelet.model.LoginInfo;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.SystemInfo;
import cn.com.smartdevices.bracelet.model.UserLocationData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.SyncHttpClient;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

// Referenced classes of package cn.com.smartdevices.bracelet.webapi:
//            BraceletHttpClient, ClientConstant

public class WebAPI
{

    public static String TAG = "WebAPI";

    public WebAPI()
    {
    }

    public static void download(String s, AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        BraceletHttpClient.client.get(s, asynchttpresponsehandler);
    }

    public static void getGameBriefInfo(AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        LoginData logindata = Keeper.readLoginData();
        RequestParams requestparams = BraceletHttpClient.getSysRp(logindata);
        String s = BraceletHttpClient.getUrl("huami.health.gethuodongconfig.json");
        HashMap hashmap = new HashMap();
        hashmap.put("userid", (new StringBuilder()).append("").append(logindata.uid).toString());
        hashmap.put("security", logindata.security);
        hashmap.put("v", "1.0");
        hashmap.put("appid", (new StringBuilder()).append("").append(ClientConstant.CLIENT_ID).toString());
        hashmap.put("callid", (new StringBuilder()).append("").append(System.currentTimeMillis()).toString());
        hashmap.put("lang", Locale.getDefault().getLanguage());
        BraceletHttpClient.getParamString(hashmap);
        Debug.i(TAG, (new StringBuilder()).append("game url =").append(s).toString());
        BraceletHttpClient.syncClient.post(s, requestparams, asynchttpresponsehandler);
    }

    public static void getGameRegisterInfo(AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        RequestParams requestparams = BraceletHttpClient.getSysRp(Keeper.readLoginData());
        String s = BraceletHttpClient.getUrl("huami.health.detectuserwhetherjoinhuodong.json");
        Debug.i(TAG, (new StringBuilder()).append("game register url =").append(s).toString());
        BraceletHttpClient.syncClient.post(s, requestparams, asynchttpresponsehandler);
    }

    public static void getLuaScript(LoginData logindata, AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        RequestParams requestparams = BraceletHttpClient.getSysRp(logindata);
        String s = BraceletHttpClient.getUrl("huami.health.getluapackdata.json");
        BraceletHttpClient.client.post(s, requestparams, asynchttpresponsehandler);
    }

    public static void getLuaScriptVersion(LoginData logindata, AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        RequestParams requestparams = BraceletHttpClient.getSysRp(logindata);
        String s = BraceletHttpClient.getUrl("huami.health.getlatestluaversion.json");
        BraceletHttpClient.client.post(s, requestparams, asynchttpresponsehandler);
    }

    public static void getLuaScriptVersionList(LoginData logindata, AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        RequestParams requestparams = BraceletHttpClient.getSysRp(logindata);
        String s = BraceletHttpClient.getUrl("huami.health.getlatestluaversionlist.json");
        BraceletHttpClient.client.post(s, requestparams, asynchttpresponsehandler);
    }

    public static void getUserInfo(LoginData logindata, long l, AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        RequestParams requestparams = BraceletHttpClient.getSysRp(logindata);
        requestparams.put("uid", (new StringBuilder()).append("").append(l).toString());
        String s = BraceletHttpClient.getUrl("huami.health.getUserInfo.json");
        BraceletHttpClient.client.post(s, requestparams, asynchttpresponsehandler);
    }

    public static void getWeixinQR(LoginData logindata, String s, AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        RequestParams requestparams = BraceletHttpClient.getSysRp(logindata);
        requestparams.put("deviceid", s);
        String s1 = BraceletHttpClient.getUrl("huami.health.createwxqr.json");
        BraceletHttpClient.client.post(s1, requestparams, asynchttpresponsehandler);
    }

    public static void sendFeedback(LoginData logindata, String s, String s1, AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        RequestParams requestparams = BraceletHttpClient.getSysRp(logindata);
        requestparams.put("message", s);
        requestparams.put("email", s1);
        String s2 = BraceletHttpClient.getUrl("huami.health.report.json");
        BraceletHttpClient.client.post(s2, requestparams, asynchttpresponsehandler);
    }

    public static void sendLocation(LoginData logindata, UserLocationData userlocationdata, AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        RequestParams requestparams = BraceletHttpClient.getSysRp(logindata);
        String s;
        try
        {
            requestparams.put("location", (new StringBuilder()).append("").append(URLEncoder.encode(userlocationdata.toString(), "utf-8")).toString());
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            unsupportedencodingexception.printStackTrace();
        }
        s = BraceletHttpClient.getUrl("huami.health.backup.json");
        BraceletHttpClient.client.post(s, requestparams, asynchttpresponsehandler);
    }

    public static void sendLoginResult(LoginInfo logininfo, String s, AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        RequestParams requestparams = new RequestParams();
        requestparams.put("access_token", (new StringBuilder()).append("").append(logininfo.accessToken).toString());
        requestparams.put("expiresIn", logininfo.expiresIn);
        requestparams.put("mac_token", logininfo.macToken);
        requestparams.put("miid", logininfo.miid);
        requestparams.put("aliasNick", logininfo.aliasNick);
        requestparams.put("miliaoNick", logininfo.miliaoNick);
        String s1;
        if (logininfo.miliaoIcon_320 != null && logininfo.miliaoIcon_320.length() > 0)
        {
            requestparams.put("miliaoIcon", logininfo.miliaoIcon_320);
        } else
        {
            requestparams.put("miliaoIcon", logininfo.miliaoIcon);
        }
        requestparams.put("friends", logininfo.friends);
        requestparams.put("deviceid", s);
        requestparams.put("devicetype", "0");
        s1 = BraceletHttpClient.getUrl("huami.health.apklogin.json");
        Debug.i(TAG, (new StringBuilder()).append("send login url= ").append(s1).toString());
        BraceletHttpClient.client.post(s1, requestparams, asynchttpresponsehandler);
    }

    public static void statisticBracelet(LoginData logindata, String s, String s1, AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        RequestParams requestparams = BraceletHttpClient.getSysRp(logindata);
        requestparams.put("deviceid", s);
        requestparams.put("statistic_bracelet", s1);
        String s2 = BraceletHttpClient.getUrl("huami.health.uploadcollectdata.json");
        BraceletHttpClient.client.post(s2, requestparams, asynchttpresponsehandler);
    }

    public static void syncFromServerNew(LoginData logindata, String s, int i, int j, int k, AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        RequestParams requestparams = BraceletHttpClient.getSysRp(logindata);
        requestparams.put("deviceid", s);
        requestparams.put("data_type", (new StringBuilder()).append("").append(i).toString());
        requestparams.put("source", (new StringBuilder()).append("").append(j).toString());
        requestparams.put("days", (new StringBuilder()).append("").append(k).toString());
        String s1 = BraceletHttpClient.getUrl("huami.health.getDataNew.json");
        BraceletHttpClient.syncClient.post(s1, requestparams, asynchttpresponsehandler);
    }

    public static void syncSummaryToServer(LoginData logindata, String s, int i, int j, String s1, AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        RequestParams requestparams = BraceletHttpClient.getSysRp(logindata);
        requestparams.put("data_json", s1);
        requestparams.put("deviceid", s);
        requestparams.put("data_type", (new StringBuilder()).append("").append(i).toString());
        requestparams.put("source", (new StringBuilder()).append("").append(j).toString());
        requestparams.put("data_len", (new StringBuilder()).append("").append(s1.length()).toString());
        requestparams.put("uuid", Keeper.readUUID());
        String s2 = BraceletHttpClient.getUrl("huami.health.updateSummary.json");
        Debug.i(TAG, (new StringBuilder()).append("Url : ").append(s2).toString());
        BraceletHttpClient.client.post(s2, requestparams, asynchttpresponsehandler);
    }

    public static void syncToServer(LoginData logindata, String s, int i, int j, String s1, AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        RequestParams requestparams = BraceletHttpClient.getSysRp(logindata);
        requestparams.put("data_json", s1);
        requestparams.put("deviceid", s);
        requestparams.put("data_type", (new StringBuilder()).append("").append(i).toString());
        requestparams.put("source", (new StringBuilder()).append("").append(j).toString());
        requestparams.put("data_len", (new StringBuilder()).append("").append(s1.length()).toString());
        requestparams.put("uuid", Keeper.readUUID());
        String s2 = BraceletHttpClient.getUrl("huami.health.receiveData.json");
        BraceletHttpClient.client.post(s2, requestparams, asynchttpresponsehandler);
    }

    public static void updateProfile(LoginData logindata, PersonInfo personinfo, AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        RequestParams requestparams = BraceletHttpClient.getSysRp(logindata);
        requestparams.put("birthday", personinfo.birthday);
        requestparams.put("gender", (new StringBuilder()).append("").append(personinfo.gender).toString());
        requestparams.put("height", (new StringBuilder()).append("").append(personinfo.height).toString());
        requestparams.put("weight", (new StringBuilder()).append("").append(personinfo.weight).toString());
        requestparams.put("nick_name", personinfo.nickname);
        requestparams.put("icon_url", personinfo.avatarUrl);
        requestparams.put("person_signature", personinfo.personSignature);
        requestparams.put("person_sh", personinfo.sh);
        requestparams.put("age", (new StringBuilder()).append(personinfo.age).append("").toString());
        Gson gson = (new GsonBuilder()).create();
        String s;
        try
        {
            requestparams.put("location", Utils.checkNull(URLEncoder.encode(gson.toJson(personinfo.location), "utf-8")));
            requestparams.put("alarm_clock", Utils.checkNull(URLEncoder.encode(gson.toJson(personinfo.alarmClockItems), "utf-8")));
            requestparams.put("config", Utils.checkNull(URLEncoder.encode(gson.toJson(personinfo.miliConfig), "utf-8")));
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            unsupportedencodingexception.printStackTrace();
        }
        s = BraceletHttpClient.getUrl("huami.health.bindProfile.json");
        if (personinfo.avatarPath == null || (1 & personinfo.getNeedSyncServer()) == 0)
        {
            BraceletHttpClient.client.post(s, requestparams, asynchttpresponsehandler);
            return;
        }
        try
        {
            requestparams.put("icon", new File(personinfo.avatarPath));
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            BraceletHttpClient.client.post(s, requestparams, asynchttpresponsehandler);
            return;
        }
        BraceletHttpClient.client.post(s, requestparams, asynchttpresponsehandler);
    }

    public static void updateProfile(LoginData logindata, HashMap hashmap, AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        HashMap hashmap1 = BraceletHttpClient.getSysHm(logindata);
        hashmap1.putAll(hashmap);
        String s = BraceletHttpClient.getUrl("huami.health.bindProfile.json");
        String s1 = (String)hashmap.get("icon_path");
        hashmap1.remove("icon_path");
        RequestParams requestparams = new RequestParams();
        java.util.Map.Entry entry;
        for (Iterator iterator = hashmap1.entrySet().iterator(); iterator.hasNext(); requestparams.put((String)entry.getKey(), (String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        if (s1 == null || s1.length() < 1)
        {
            BraceletHttpClient.client.post(s, requestparams, asynchttpresponsehandler);
            return;
        }
        try
        {
            requestparams.put("icon", new File(s1));
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            BraceletHttpClient.client.post(s, requestparams, asynchttpresponsehandler);
            return;
        }
        BraceletHttpClient.client.post(s, requestparams, asynchttpresponsehandler);
    }

    public static void updateSystemInfo(LoginData logindata, SystemInfo systeminfo, int i, AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        RequestParams requestparams = BraceletHttpClient.getSysRp(logindata);
        requestparams.put("deviceid", systeminfo.deviceId);
        requestparams.put("mac", URLEncoder.encode(systeminfo.braceletMacAddress));
        requestparams.put("devicetype", (new StringBuilder()).append("").append(i).toString());
        requestparams.put("miui_version_code", systeminfo.miuiVersionCode);
        requestparams.put("miui_version_name", systeminfo.miuiVersionName);
        requestparams.put("phone_brand", systeminfo.phoneBrand);
        requestparams.put("phone_model", systeminfo.phoneModel);
        requestparams.put("phone_system", systeminfo.phoneSystem);
        requestparams.put("fwversion", systeminfo.fwVersion);
        requestparams.put("softversion", systeminfo.softVersion);
        String s = BraceletHttpClient.getUrl("huami.health.updatedevicedata.json");
        BraceletHttpClient.client.post(s, requestparams, asynchttpresponsehandler);
    }

    public static void uploadLogFileBlock(LoginData logindata, File file, AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        RequestParams requestparams = BraceletHttpClient.getSysRp(logindata);
        String s;
        try
        {
            requestparams.put("log_file_name", file.getName());
            requestparams.put("log_file", file);
        }
        catch (FileNotFoundException filenotfoundexception) { }
        s = BraceletHttpClient.getUrl("huami.health.uploadlogdata.json");
        BraceletHttpClient.syncClient.post(s, requestparams, asynchttpresponsehandler);
    }

}
