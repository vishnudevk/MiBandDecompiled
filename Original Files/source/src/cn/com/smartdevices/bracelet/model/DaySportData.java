// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.model;

import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.analysis.SleepInfo;
import cn.com.smartdevices.bracelet.analysis.StepsInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package cn.com.smartdevices.bracelet.model:
//            SportDay, SportIndex, SportData, PersonInfo

public class DaySportData
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private ArrayList analysisDatas;
    private ArrayList datas;
    private ArrayList indexs;
    private SleepInfo mSleepInfo;
    private StepsInfo mStepsInfo;
    private boolean needPostProcess;
    private boolean needSyncToLocal;
    private boolean needSyncToServer;
    private ArrayList originDatas;
    private SportDay sDay;

    public DaySportData(int i, int j, int k)
    {
        this(new SportDay(i, j, k));
    }

    public DaySportData(SportDay sportday)
    {
        sDay = null;
        datas = null;
        originDatas = null;
        indexs = new ArrayList();
        needSyncToServer = false;
        needSyncToLocal = false;
        needPostProcess = true;
        mStepsInfo = null;
        mSleepInfo = null;
        analysisDatas = null;
        sDay = sportday;
        datas = new ArrayList(DataManager.INIT_INDEX_LIST);
        originDatas = new ArrayList(DataManager.INIT_ORIGIN_LIST);
    }

    public DaySportData(Calendar calendar)
    {
        this(new SportDay(calendar));
    }

    private void handleIndex(int i, com.xiaomi.hm.bleservice.profile.IMiLiProfile.ActivityData activitydata)
    {
        if (activitydata.category == 126)
        {
            return;
        }
        if (indexs.size() == 0)
        {
            indexs.add(new SportIndex(i, i));
            return;
        }
        SportIndex sportindex = (SportIndex)indexs.get(-1 + indexs.size());
        if (1 + sportindex.stopIndex == i)
        {
            sportindex.stopIndex = i;
            return;
        } else
        {
            SportIndex sportindex1 = new SportIndex(i, i);
            indexs.add(sportindex1);
            return;
        }
    }

    public static DaySportData sFromBinaryData(SportDay sportday, byte abyte0[])
    {
        int i = abyte0.length;
        DaySportData daysportdata = new DaySportData(sportday);
        for (int j = 0; j < i; j += 3)
        {
            com.xiaomi.hm.bleservice.profile.IMiLiProfile.ActivityData activitydata = new com.xiaomi.hm.bleservice.profile.IMiLiProfile.ActivityData(abyte0[j + 1], abyte0[j + 2], abyte0[j]);
            daysportdata.add(j / 3, activitydata);
        }

        return daysportdata;
    }

    public void add(int i, com.xiaomi.hm.bleservice.profile.IMiLiProfile.ActivityData activitydata)
    {
        if (((SportData)datas.get(i)).getSportMode() != 126)
        {
            return;
        } else
        {
            SportData sportdata = new SportData(i, 0xff & activitydata.category, 0xff & activitydata.intensity, 0xff & activitydata.steps);
            datas.set(i, sportdata);
            originDatas.set(i, activitydata);
            handleIndex(i, activitydata);
            return;
        }
    }

    public ArrayList data()
    {
        return datas;
    }

    public void fromBinaryData(SportDay sportday, byte abyte0[])
    {
        int i = abyte0.length;
        for (int j = 0; j < i; j += 3)
        {
            com.xiaomi.hm.bleservice.profile.IMiLiProfile.ActivityData activitydata = new com.xiaomi.hm.bleservice.profile.IMiLiProfile.ActivityData(abyte0[j + 1], abyte0[j + 2], abyte0[j]);
            add(j / 3, activitydata);
        }

    }

    public ArrayList getAnalysisData()
    {
        return analysisDatas;
    }

    public byte[] getBinaryData()
    {
        ArrayList arraylist = originDatas;
        byte abyte0[] = new byte[3 * arraylist.size()];
        for (int i = 0; i < arraylist.size(); i++)
        {
            com.xiaomi.hm.bleservice.profile.IMiLiProfile.ActivityData activitydata = (com.xiaomi.hm.bleservice.profile.IMiLiProfile.ActivityData)arraylist.get(i);
            abyte0[i * 3] = (byte)activitydata.category;
            abyte0[1 + i * 3] = (byte)activitydata.intensity;
            abyte0[2 + i * 3] = (byte)activitydata.steps;
        }

        return abyte0;
    }

    public int getDay()
    {
        return sDay.day;
    }

    public String getIndexS()
    {
        JSONArray jsonarray = new JSONArray();
        for (Iterator iterator = indexs.iterator(); iterator.hasNext(); jsonarray.put(((SportIndex)iterator.next()).toJSONObject())) { }
        return jsonarray.toString();
    }

    public String getKey()
    {
        return sDay.getKey();
    }

    public int getMonth()
    {
        return sDay.mon;
    }

    public ArrayList getOriginData()
    {
        return originDatas;
    }

    public SleepInfo getSleepInfo()
    {
        return mSleepInfo;
    }

    public SportDay getSportDay()
    {
        return sDay;
    }

    public StepsInfo getStepsInfo()
    {
        return mStepsInfo;
    }

    public String getSummary()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("v", 4);
            if (mSleepInfo != null)
            {
                jsonobject.put(SleepInfo.KEY_SLEEP_INFO, mSleepInfo.getSummaryJson());
            }
            if (mStepsInfo != null)
            {
                jsonobject.put(StepsInfo.KEY_STEP_INFO, mStepsInfo.getSummaryJson());
            }
            jsonobject.put("goal", Keeper.readPersonInfo().getDaySportGoalSteps());
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
        }
        return jsonobject.toString();
    }

    public int getYear()
    {
        return sDay.year;
    }

    public boolean isLocalNeedSync()
    {
        return needSyncToLocal;
    }

    public boolean isNeedPostProcess()
    {
        return needPostProcess;
    }

    public void merge(DaySportData daysportdata)
    {
        ArrayList arraylist = daysportdata.getOriginData();
        int i = arraylist.size();
        for (int j = 0; j < i; j++)
        {
            com.xiaomi.hm.bleservice.profile.IMiLiProfile.ActivityData activitydata = (com.xiaomi.hm.bleservice.profile.IMiLiProfile.ActivityData)arraylist.get(j);
            if (activitydata.category != 126 && activitydata.category != 127)
            {
                add(j, activitydata);
            }
        }

    }

    public void setAnalysisData(ArrayList arraylist)
    {
        analysisDatas = arraylist;
    }

    public void setLocalNeedSync(boolean flag)
    {
        needSyncToLocal = flag;
    }

    public void setNeedPostProcess(boolean flag)
    {
        needPostProcess = flag;
    }

    public void setNeedSync(boolean flag)
    {
        needSyncToLocal = flag;
        needSyncToServer = flag;
    }

    public void setSleepInfo(SleepInfo sleepinfo)
    {
        mSleepInfo = sleepinfo;
    }

    public void setStepsInfo(StepsInfo stepsinfo)
    {
        mStepsInfo = stepsinfo;
    }
}
