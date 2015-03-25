// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.model;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.ui.ShareActivity;
import java.text.SimpleDateFormat;
import java.util.Date;

// Referenced classes of package cn.com.smartdevices.bracelet.model:
//            SportDay, ReportData, ShareData

public class ShareListDelegateActivity extends Activity
{

    public static final String REF_REPORT_DATA = "REF_REPORT_DATA";
    public static final String SHARE_TYPE_CONTIUE_REACH_GOAL = "SHARE_TYPE_CONTIUE_REACH_GOAL";
    public static final String SHARE_TYPE_LAST_MONTH = "SHARE_TYPE_LAST_MONTH";
    public static final String SHARE_TYPE_LAST_WEEK = "SHARE_TYPE_LAST_WEEK";
    public static final String SHARE_TYPE_MAIN_UI_SHARE = "SHARE_TYPE_MAIN_UI_SHARE";
    public static final String SHARE_TYPE_NEW_RECORD = "SHARE_TYPE_NEW_RECORD";
    private static final String TAG = "ShareListDelegateActivity";
    private int mNewRecordSteps;
    private ReportData mReportData;
    private String mShareType;

    public ShareListDelegateActivity()
    {
    }

    private SportDay getSportDayFromDateStr(String s)
    {
        String as[] = s.split("-");
        SportDay sportday;
        try
        {
            int i = Integer.valueOf(as[0]).intValue();
            int j = Integer.valueOf(as[1]).intValue();
            int k = Integer.valueOf(as[2]).intValue();
            sportday = new SportDay(i, j - 1, k);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        return sportday;
    }

    protected void onCreate(Bundle bundle)
    {
        Intent intent;
        String s;
        super.onCreate(bundle);
        intent = getIntent();
        s = "";
        if (intent == null) goto _L2; else goto _L1
_L1:
        String s1 = intent.getStringExtra("REF_REPORT_DATA");
        if (s1 != null)
        {
            mReportData = ReportData.fromJsonStr(s1);
            if (mReportData == null)
            {
                finish();
                return;
            }
        } else
        {
            Debug.i("ShareListDelegateActivity", "intent of mReportData is null");
            finish();
            return;
        }
        Debug.i("ShareListDelegateActivity", (new StringBuilder()).append("mReportData = ").append(mReportData.type).toString());
        mShareType = mReportData.type;
        if (!"SHARE_TYPE_LAST_WEEK".equals(mShareType) && !"SHARE_TYPE_LAST_MONTH".equals(mShareType)) goto _L4; else goto _L3
_L3:
        SportDay sportday;
        SportDay sportday1;
        SportDay sportday3 = getSportDayFromDateStr(mReportData.timeFrom);
        SportDay sportday4 = getSportDayFromDateStr(mReportData.timeTo);
        SportDay sportday5 = getSportDayFromDateStr(mReportData.maxDateStr);
        String s2 = "";
        if (sportday5 != null)
        {
            s2 = sportday5.formatStringDay();
        }
        s = s2;
        sportday = sportday4;
        sportday1 = sportday3;
_L6:
        ShareData sharedata = new ShareData();
        int i;
        SportDay sportday6;
        if ("SHARE_TYPE_LAST_MONTH".equals(mShareType))
        {
            Date date = new Date();
            date.setMonth(sportday1.mon);
            SimpleDateFormat simpledateformat = new SimpleDateFormat("MMMM, ");
            sharedata.title = (new StringBuilder()).append(getString(0x7f0d00ce)).append(simpledateformat.format(date)).append(getString(0x7f0d0173)).toString();
            sharedata.setType(6);
            sharedata.description = Utils.getMonthShareTips(this, mReportData.steps, mReportData.distance, mReportData.calories, s, mReportData.maxDateStep, mReportData.runDistance);
            i = mReportData.steps;
            sharedata.contentUnit = getString(0x7f0d01c4);
            sharedata.time = (new StringBuilder()).append(sportday1.formatStringDayShort()).append("-").append(sportday.formatStringDayShort()).toString();
        } else
        if ("SHARE_TYPE_LAST_WEEK".equals(mShareType))
        {
            sharedata.title = (new StringBuilder()).append(getString(0x7f0d0120)).append(getString(0x7f0d0173)).toString();
            sharedata.setType(7);
            sharedata.description = Utils.getWeekShareTips(this, mReportData.distance, mReportData.calories, s, mReportData.maxDateStep, mReportData.runDistance);
            i = mReportData.steps;
            sharedata.contentUnit = getString(0x7f0d01c4);
            sharedata.time = (new StringBuilder()).append(sportday1.formatStringDayShort()).append("-").append(sportday.formatStringDayShort()).toString();
        } else
        if ("SHARE_TYPE_NEW_RECORD".equals(mShareType))
        {
            sharedata.setType(5);
            sharedata.title = getString(0x7f0d0108);
            i = mNewRecordSteps;
            sharedata.contentUnit = getString(0x7f0d01c4);
            sharedata.time = (new SportDay()).formatString();
            String as[] = ChartData.formatDistance(this, mReportData.getDistance());
            sharedata.description = getString(0x7f0d0109, new Object[] {
                (new StringBuilder()).append(as[0]).append(as[1]).toString(), (new StringBuilder()).append("").append(mReportData.getCalories()).toString()
            });
        } else
        if ("SHARE_TYPE_CONTIUE_REACH_GOAL".equals(mShareType))
        {
            Object aobj[];
            if (mReportData.getContinueDays() > mReportData.getMaxContinueDays())
            {
                sharedata.setType(10);
                sharedata.title = getString(0x7f0d004d);
            } else
            {
                sharedata.setType(8);
                sharedata.title = getString(0x7f0d004c);
            }
            i = mReportData.continueDays;
            sharedata.contentUnit = getString(0x7f0d005f);
            aobj = new Object[1];
            aobj[0] = sportday.formatStringDayShort();
            sharedata.time = getString(0x7f0d01da, aobj);
            sharedata.time_tips = "";
            sharedata.description = Utils.getContinueReachGoalShareTips(this, mReportData);
        } else
        {
            if ("SHARE_TYPE_MAIN_UI_SHARE".equals(mShareType))
            {
                SportDay sportday2 = DataManager.getInstance().getCurDay();
                Utils.getMainUIShareTips(this, DataManager.getInstance().get(sportday2), sharedata);
                intent.putExtra("pic_url", mReportData.picture_url);
            }
            i = 0;
        }
        sharedata.content = (new StringBuilder()).append("").append(i).toString();
        intent.setClass(this, cn/com/smartdevices/bracelet/ui/ShareActivity);
        intent.putExtra("share_data", sharedata);
        startActivity(intent);
        UmengAnalytics.event(this, "ShareFrom", "ShareFromDynamicList");
        finish();
        return;
_L4:
        if ("SHARE_TYPE_NEW_RECORD".equals(mShareType))
        {
            mNewRecordSteps = mReportData.getSteps();
            sportday = null;
            sportday1 = null;
            continue; /* Loop/switch isn't completed */
        }
        if ("SHARE_TYPE_CONTIUE_REACH_GOAL".equals(mShareType))
        {
            sportday6 = getSportDayFromDateStr(mReportData.timeFrom);
            sportday = getSportDayFromDateStr(mReportData.timeTo);
            sportday1 = sportday6;
            continue; /* Loop/switch isn't completed */
        }
_L2:
        sportday = null;
        sportday1 = null;
        if (true) goto _L6; else goto _L5
_L5:
    }
}
