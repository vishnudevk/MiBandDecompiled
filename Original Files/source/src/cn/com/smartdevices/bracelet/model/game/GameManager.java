// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.model.game;

import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.eventbus.EventGameUpdate;
import cn.com.smartdevices.bracelet.lua.ConfigDynamicDataInfo;
import cn.com.smartdevices.bracelet.model.SportDay;
import cn.com.smartdevices.bracelet.webapi.WebAPI;
import de.greenrobot.event.EventBus;
import java.util.Calendar;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package cn.com.smartdevices.bracelet.model.game:
//            GameBriefInfo, GameStage

public class GameManager
{

    public static final String GAME_MARK = "GAME_";
    public static final String NEW_GAME = "NewGame";
    public static final int STATUS_ACTIVE = 1;
    private static final String STR_GAME_BONUS = "game_bonus";
    public static final String STR_GAME_CLEAR_BANNER = "game_clear_banner";
    private static final String STR_GAME_DEFAULT = "game_default";
    private static final String STR_GAME_NOT_REGISTER = "game_not_registered";
    private static final String STR_GAME_PLAYING = "game_playing";
    private static final String STR_GAME_PLAYING_FAIL = "game_playing_fail";
    private static final String STR_GAME_PLAYING_FAILED = "game_playing_failed";
    private static final String STR_GAME_REGISTER = "game_registered";
    private static final String TAG = "GameManager";
    boolean TEST;
    private GameBriefInfo mGameBriefInfo;
    private int mTotalSteps;

    public GameManager()
    {
        TEST = false;
        mGameBriefInfo = new GameBriefInfo();
    }

    private int checkContinusReachGoal(SportDay sportday, SportDay sportday1)
    {
        int i;
        i = 1 + sportday1.offsetDay(sportday);
        Debug.i("GameManager", (new StringBuilder()).append("Check continus reach goal,  startDay = ").append(sportday).append(", stopDay = ").append(sportday1).append(", goal=").append(mGameBriefInfo.getGoal()).append("curGameDurationDay = ").append(i).toString());
        if (i >= 0) goto _L2; else goto _L1
_L1:
        byte byte0;
        Debug.fi("GameManager", (new StringBuilder()).append("Game start/stop time illegal : start = ").append(sportday).append(", stopday = ").append(sportday1).toString());
        byte0 = -1;
_L4:
        return byte0;
_L2:
        mTotalSteps = 0;
        int j = 0;
        do
        {
            byte0 = 0;
            if (j >= i)
            {
                continue;
            }
            SportDay sportday2 = sportday.addDay(j);
            int k = DataManager.getInstance().getSummary(sportday2).getSteps();
            mTotalSteps = k + mTotalSteps;
            Debug.i("GameManager", (new StringBuilder()).append("sumary step = ").append(k).toString());
            if (mGameBriefInfo.getGoal() > k)
            {
                int l = (int)(sportday2.calendar.getTimeInMillis() / 1000L);
                Debug.i("GameManager", (new StringBuilder()).append("First failed at ").append(sportday2).toString());
                return l;
            }
            j++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void clearGameUI(EventGameUpdate eventgameupdate)
    {
        eventgameupdate.getConfigInfo().setTitle("game_clear_banner");
        EventBus.getDefault().post(eventgameupdate);
    }

    private GameBriefInfo getGameBriefInfo()
    {
        Debug.i("GameManager", "start get game briefInfo ");
        WebAPI.getGameBriefInfo(new _cls1());
        Debug.i("GameManager", (new StringBuilder()).append("get game briefInfo = ").append(mGameBriefInfo).toString());
        return mGameBriefInfo;
    }

    private void getRegisterInfo()
    {
        WebAPI.getGameRegisterInfo(new _cls2());
    }

    private void parseGameBriefInfo(GameBriefInfo gamebriefinfo, byte abyte0[])
    {
        String s;
        s = new String("{\"code\":1,\"message\":\"config info\",\"data\":{\"like\":1,\"name\":\"\\u56fd\\u5e86\\u4e03\\u5929\\u4e50\",\"actno\":\"20141001\",\"config\":\"{\\\"global\\\":{\\\"no\\\":20141001,\\\"stime\\\":1411401600,\\\"etime\\\":1411646400},\\\"bm\\\":{\\\"stime\\\":1411439400,\\\"etime\\\":1411444800,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/hd.ahhuami.com\\\\\\/\\\"},\\\"act\\\":{\\\"stime\\\":1411444801,\\\"etime\\\":1411624800,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/hd.ahhuami.com\\\\\\/act.php\\\"},\\\"award\\\":{\\\"stime\\\":1411624801,\\\"etime\\\":1411646400,\\\"url\\\":\\\"http:\\\\\\/\\\\\\/hd.ahhuami.com\\\\\\/award.php\\\"}}\",\"server_time\":1411539767,\"goal\":\"2000\",\"bonus\":0,\"bonus_opentime\":1411632000}}");
        if (!TEST)
        {
            s = new String(abyte0);
        }
        JSONObject jsonobject;
        int i;
        jsonobject = new JSONObject(s);
        i = jsonobject.optInt("code");
        if (i == 1)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        Debug.i("GameManager", (new StringBuilder()).append("parseGameBriefInfo error code =").append(i).toString());
        JSONObject jsonobject1 = jsonobject.optJSONObject("data");
        if (jsonobject1 != null) goto _L2; else goto _L1
_L1:
        JSONObject jsonobject2;
        try
        {
            Debug.fi("GameManager", "dataObj is null");
            return;
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
        }
          goto _L3
_L2:
        if (gamebriefinfo != null)
        {
            break MISSING_BLOCK_LABEL_110;
        }
        gamebriefinfo = new GameBriefInfo();
        Debug.i("GameManager", (new StringBuilder()).append("dataObj = ").append(jsonobject1.toString()).toString());
        gamebriefinfo.setName(jsonobject1.optString("name"));
        gamebriefinfo.setId(jsonobject1.optInt("actno"));
        gamebriefinfo.setDefaultUrl(jsonobject1.optString("defaultUrl"));
        gamebriefinfo.setGoal(jsonobject1.optInt("goal"));
        gamebriefinfo.setBonus(jsonobject1.optInt("bonus"));
        gamebriefinfo.setBonusOpenTime(jsonobject1.optInt("bonus_opentime"));
        gamebriefinfo.setServerTime(jsonobject1.optInt("server_time"));
        gamebriefinfo.setLike(jsonobject1.optInt("like", 1));
        jsonobject2 = new JSONObject(jsonobject1.optString("config"));
        if (jsonobject2 != null) goto _L5; else goto _L4
_L4:
        Debug.fi("GameManager", "configObj is null");
        return;
_L3:
        JSONObject jsonobject3;
        JSONObject jsonobject4;
        JSONObject jsonobject5;
        JSONObject jsonobject6;
        if (TEST)
        {
            return;
        } else
        {
            return;
        }
_L5:
        jsonobject3 = jsonobject2.optJSONObject("global");
        jsonobject4 = jsonobject2.optJSONObject("bm");
        jsonobject5 = jsonobject2.optJSONObject("act");
        jsonobject6 = jsonobject2.optJSONObject("award");
        if (jsonobject3 == null)
        {
            break MISSING_BLOCK_LABEL_361;
        }
        gamebriefinfo.setId(jsonobject3.optInt("no"));
        gamebriefinfo.setStartTime(jsonobject3.optInt("stime"));
        gamebriefinfo.setStopTime(jsonobject3.optInt("etime"));
        if (jsonobject4 == null)
        {
            break MISSING_BLOCK_LABEL_375;
        }
        gamebriefinfo.setRegisterStage(GameStage.fromJson(jsonobject4));
        if (jsonobject5 == null) goto _L7; else goto _L6
_L6:
        gamebriefinfo.setPlayingStage(GameStage.fromJson(jsonobject5));
_L7:
        if (jsonobject6 == null) goto _L3; else goto _L8
_L8:
        gamebriefinfo.setBonusStage(GameStage.fromJson(jsonobject6));
          goto _L3
    }

    private void showBonusBanner(EventGameUpdate eventgameupdate)
    {
        GameStage gamestage = mGameBriefInfo.getPlayingStage();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000L * gamestage.getStartTime());
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTimeInMillis(1000L * gamestage.getStopTime());
        int i = checkContinusReachGoal(new SportDay(calendar), new SportDay(calendar1));
        if (i == -1)
        {
            Debug.fi("GameManager", (new StringBuilder()).append("showBonusBanner, illegal playing stage time: ").append(gamestage.getStartTime()).append(", ").append(gamestage.getStopTime()).toString());
            return;
        }
        boolean flag;
        if (i > 0)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        Debug.i("GameManager", (new StringBuilder()).append("showBonusBanner continueRecord = ").append(flag).toString());
        eventgameupdate.getConfigInfo().setTitle("game_bonus");
        eventgameupdate.getConfigInfo().setUrl(mGameBriefInfo.getBonusUrl());
        eventgameupdate.getConfigInfo().setTimeStamp(mGameBriefInfo.getBonusOpenTime());
        eventgameupdate.getConfigInfo().setServerTimeStamp(mGameBriefInfo.getServerTime());
        eventgameupdate.getConfigInfo().setBonus(mGameBriefInfo.getBonus());
        eventgameupdate.getConfigInfo().setIsBind(Boolean.valueOf(flag));
        eventgameupdate.getConfigInfo().setRecordStep(mTotalSteps);
        EventBus.getDefault().post(eventgameupdate);
    }

    private void showGameRecord(EventGameUpdate eventgameupdate)
    {
        GameStage gamestage = mGameBriefInfo.getPlayingStage();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1000L * gamestage.getStartTime());
        Calendar.getInstance().setTimeInMillis(1000L * gamestage.getStopTime());
        int i = checkContinusReachGoal(new SportDay(calendar), (new SportDay()).addDay(-1));
        if (i == -1)
        {
            return;
        }
        boolean flag;
        if (i > 0)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        if (flag)
        {
            cn.com.smartdevices.bracelet.model.DaySportData.Summary summary = DataManager.getInstance().getSummary(new SportDay());
            eventgameupdate.getConfigInfo().setGoal(mGameBriefInfo.getGoal());
            Debug.i("GameManager", (new StringBuilder()).append("playing start time =").append(gamestage.getStartTime()).toString());
            eventgameupdate.getConfigInfo().setTimeStamp(gamestage.getStartTime());
            eventgameupdate.getConfigInfo().setTimeStamp1(gamestage.getStopTime());
            eventgameupdate.getConfigInfo().setTimeStamp2(mGameBriefInfo.getBonusOpenTime());
            eventgameupdate.getConfigInfo().setTitle("game_playing");
            eventgameupdate.getConfigInfo().setUrl(mGameBriefInfo.getGamePlayingUrl());
            Debug.i("GameManager", (new StringBuilder()).append("steps = ").append(summary.getSteps()).toString());
            eventgameupdate.getConfigInfo().setRecordStep(summary.getSteps());
        } else
        {
            if (!Keeper.readGameFailed())
            {
                Keeper.keepGameFailed(true);
                eventgameupdate.getConfigInfo().setTitle("game_playing_fail");
            } else
            {
                eventgameupdate.getConfigInfo().setTitle("game_playing_failed");
            }
            eventgameupdate.getConfigInfo().setUrl(mGameBriefInfo.getGamePlayingUrl());
            eventgameupdate.getConfigInfo().setTimeStamp(i);
        }
        EventBus.getDefault().post(eventgameupdate);
    }

    public void processGameEvent(String s)
    {
        (new GameTask(null)).execute(new String[] {
            s, null, null
        });
    }








    private class _cls1 extends AsyncHttpResponseHandler
    {

        final GameManager this$0;

        public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
        {
            Debug.fi("GameManager", (new StringBuilder()).append("Get game info failed , statusCode = ").append(i).toString());
        }

        public void onSuccess(int i, Header aheader[], byte abyte0[])
        {
            Debug.i("GameManager", (new StringBuilder()).append("get responseBody=").append(new String(abyte0)).toString());
            if (abyte0 != null && abyte0.length > 0)
            {
                parseGameBriefInfo(mGameBriefInfo, abyte0);
            }
        }

        _cls1()
        {
            this$0 = GameManager.this;
            super();
        }
    }


    private class _cls2 extends AsyncHttpResponseHandler
    {

        final GameManager this$0;

        public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
        {
            Debug.fi("GameManager", (new StringBuilder()).append("Get game register info failed , statusCode = ").append(i).toString());
        }

        public void onSuccess(int i, Header aheader[], byte abyte0[])
        {
            String s;
            Debug.i("GameManager", (new StringBuilder()).append("get register responseBody=").append(new String(abyte0)).toString());
            s = new String(abyte0);
            JSONObject jsonobject;
            GameBriefInfo gamebriefinfo;
            jsonobject = new JSONObject(s);
            gamebriefinfo = mGameBriefInfo;
            boolean flag;
            if (jsonobject.optInt("code") > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            try
            {
                gamebriefinfo.setRegistered(flag);
                return;
            }
            catch (JSONException jsonexception)
            {
                jsonexception.printStackTrace();
            }
            return;
        }

        _cls2()
        {
            this$0 = GameManager.this;
            super();
        }
    }


    private class GameTask extends AsyncTask
    {

        final GameManager this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient String doInBackground(String as[])
        {
            GameBriefInfo gamebriefinfo = getGameBriefInfo();
            EventGameUpdate eventgameupdate = new EventGameUpdate();
            eventgameupdate.getConfigInfo().setType((new StringBuilder()).append("GAME_").append(gamebriefinfo.getId()).toString());
            eventgameupdate.getConfigInfo().setRight("onTop");
            Debug.i("GameManager", (new StringBuilder()).append("mark = ").append(as[0]).toString());
            if (gamebriefinfo.getLike() == 0 || as[0].equals("game_clear_banner"))
            {
                clearGameUI(eventgameupdate);
                return null;
            }
            if (gamebriefinfo.isGameStart())
            {
                getRegisterInfo();
                if (gamebriefinfo.isInRegisterStage())
                {
                    if (mGameBriefInfo.isRegistered())
                    {
                        eventgameupdate.getConfigInfo().setTitle("game_registered");
                        eventgameupdate.getConfigInfo().setUrl(mGameBriefInfo.getRegisterUrl());
                        eventgameupdate.getConfigInfo().setTimeStamp(mGameBriefInfo.getRegisterEndTimeStamp());
                        EventBus.getDefault().post(eventgameupdate);
                        return null;
                    } else
                    {
                        eventgameupdate.getConfigInfo().setTitle("game_not_registered");
                        eventgameupdate.getConfigInfo().setUrl(mGameBriefInfo.getRegisterUrl());
                        EventBus.getDefault().post(eventgameupdate);
                        return null;
                    }
                }
                if (gamebriefinfo.isInGamingStage())
                {
                    if (!mGameBriefInfo.isRegistered())
                    {
                        clearGameUI(eventgameupdate);
                        return null;
                    } else
                    {
                        showGameRecord(eventgameupdate);
                        return null;
                    }
                }
                if (gamebriefinfo.isInBonusStage())
                {
                    if (!mGameBriefInfo.isRegistered())
                    {
                        clearGameUI(eventgameupdate);
                        return null;
                    } else
                    {
                        showBonusBanner(eventgameupdate);
                        return null;
                    }
                } else
                {
                    eventgameupdate.getConfigInfo().setTitle("game_default");
                    eventgameupdate.getConfigInfo().setUrl(mGameBriefInfo.getDefaultUrl());
                    EventBus.getDefault().post(eventgameupdate);
                    return null;
                }
            } else
            {
                clearGameUI(eventgameupdate);
                return null;
            }
        }

        private GameTask()
        {
            this$0 = GameManager.this;
            super();
        }

        GameTask(_cls1 _pcls1)
        {
            this();
        }
    }

}
