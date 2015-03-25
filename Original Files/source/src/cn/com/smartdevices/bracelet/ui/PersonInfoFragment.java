// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.AnalyticsTrackerManager;
import cn.com.smartdevices.bracelet.BleTask.BleSetPersonalInfoTask;
import cn.com.smartdevices.bracelet.BraceletApp;
import cn.com.smartdevices.bracelet.DaoManager;
import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.activity.LoginActivity;
import cn.com.smartdevices.bracelet.eventbus.EventPersonInfoUpdate;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.UploadData;
import cn.com.smartdevices.bracelet.model.UserLocationData;
import cn.com.smartdevices.bracelet.model.UserTotalSportData;
import cn.com.smartdevices.bracelet.view.Util;
import cn.com.smartdevices.bracelet.webapi.WebAPI;
import com.google.gson.Gson;
import de.greenrobot.daobracelet.LuaListDao;
import de.greenrobot.daobracelet.LuaZipFileDao;
import de.greenrobot.event.EventBus;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            bg, bh, MiliExitLoginFragment, bj, 
//            DimPanelFragment, bk, bl, bm, 
//            bn, PersonInfoSettingSignatureFragment, PersonInfoSettingNicknameFragment, PersonInfoSettingGenderFragment, 
//            PersonInfoSettingHeightFragment, PersonInfoSettingWeightFragment, PersonInfoSettingAgeFragment, SelectImageQuestionFragment, 
//            StatisticActivity

public class PersonInfoFragment extends Fragment
    implements android.view.View.OnClickListener
{

    public static final String EXTRA_PERSON_INFO = "person_info_json";
    public static final int REQ_SELECT_CROP_IMAGE = 17;
    public static final int REQ_TAKE_PHOTO = 18;
    private static final String c = "PersonInfoFragment";
    private ImageButton A;
    private Bitmap B;
    private View C;
    private TextView D;
    String a;
    String b;
    private TextView d;
    private View e;
    private TextView f;
    private View g;
    private TextView h;
    private View i;
    private TextView j;
    private View k;
    private PersonInfo l;
    private View m;
    private ImageButton n;
    private TextView o;
    private TextView p;
    private TextView q;
    private ImageView r;
    private ImageButton s;
    private ImageButton t;
    private TextView u;
    private TextView v;
    private TextView w;
    private View x;
    private View y;
    private View z;

    public PersonInfoFragment()
    {
        a = "";
        b = "";
        l = null;
    }

    static PersonInfo a(PersonInfoFragment personinfofragment)
    {
        return personinfofragment.l;
    }

    private void a()
    {
        WebAPI.getUserInfo(Keeper.readLoginData(), l.uid, new bg(this));
    }

    private void a(View view)
    {
        d = (TextView)view.findViewById(0x7f0a017a);
        e = view.findViewById(0x7f0a0179);
        e.setOnClickListener(this);
        f = (TextView)view.findViewById(0x7f0a017e);
        g = view.findViewById(0x7f0a017d);
        g.setOnClickListener(this);
        h = (TextView)view.findViewById(0x7f0a0180);
        i = view.findViewById(0x7f0a017f);
        i.setOnClickListener(this);
        j = (TextView)view.findViewById(0x7f0a017c);
        k = view.findViewById(0x7f0a017b);
        k.setOnClickListener(this);
        view.findViewById(0x7f0a0181).setOnClickListener(this);
        m = view.findViewById(0x7f0a0177);
        C = view.findViewById(0x7f0a0178);
        if (Keeper.readPersonInfo().uid == l.uid)
        {
            C.setVisibility(0);
        } else
        {
            C.setVisibility(8);
        }
        b();
    }

    private void a(PersonInfo personinfo)
    {
        boolean flag = false;
        boolean flag1;
        if (personinfo.age <= 0)
        {
            personinfo.age = 25;
            flag1 = false;
        } else
        {
            flag1 = true;
        }
        if (personinfo.height < 90 || personinfo.height > 230)
        {
            personinfo.height = 170;
            flag1 = false;
        }
        if (personinfo.weight < 20 || personinfo.weight > 205)
        {
            personinfo.weight = 60;
            flag1 = false;
        }
        if (personinfo.gender < 0)
        {
            personinfo.gender = 1;
        } else
        {
            flag = flag1;
        }
        if (!flag)
        {
            Keeper.keepPersonInfo(personinfo);
        }
    }

    static void a(PersonInfoFragment personinfofragment, boolean flag)
    {
        personinfofragment.a(flag);
    }

    private void a(boolean flag)
    {
        Utils.hideProgressDialog(getActivity());
        if (flag)
        {
            i();
            return;
        } else
        {
            f();
            return;
        }
    }

    private void b()
    {
        n = (ImageButton)m.findViewById(0x7f0a0183);
        n.setOnClickListener(this);
        o = (TextView)m.findViewById(0x7f0a0185);
        p = (TextView)m.findViewById(0x7f0a0187);
        q = (TextView)m.findViewById(0x7f0a0188);
        q.setOnClickListener(this);
        r = (ImageView)m.findViewById(0x7f0a0186);
        v = (TextView)m.findViewById(0x7f0a0189);
        u = (TextView)m.findViewById(0x7f0a018c);
        w = (TextView)m.findViewById(0x7f0a018a);
        D = (TextView)m.findViewById(0x7f0a018b);
        t = (ImageButton)m.findViewById(0x7f0a018e);
        t.setOnClickListener(this);
        s = (ImageButton)m.findViewById(0x7f0a0190);
        s.setOnClickListener(this);
        y = m.findViewById(0x7f0a018f);
        x = m.findViewById(0x7f0a018d);
        z = m.findViewById(0x7f0a0034);
        z.setOnClickListener(this);
    }

    private void b(PersonInfo personinfo)
    {
        (new Thread(new bh(this))).start();
    }

    static void b(PersonInfoFragment personinfofragment)
    {
        personinfofragment.c();
    }

    private void c()
    {
        a(l);
        if (getActivity() == null)
        {
            return;
        }
        TextView textview = d;
        String s1;
        if (l.gender == 1)
        {
            s1 = "\u7537";
        } else
        {
            s1 = "\u5973";
        }
        textview.setText(s1);
        f.setText((new StringBuilder()).append(l.height).append(getString(0x7f0d0046)).toString());
        h.setText((new StringBuilder()).append(l.weight).append(getString(0x7f0d00da)).toString());
        j.setText((new StringBuilder()).append(l.age).append("").toString());
        d();
    }

    static void c(PersonInfoFragment personinfofragment)
    {
        personinfofragment.j();
    }

    private void d()
    {
        Utils.updateAvatarUI(l, n);
        o.setText(l.nickname);
        p.setText(l.personSignature);
        v.setText(String.valueOf(l.uid));
        Float float1;
        Float float2;
        Float float3;
        Float float4;
        Float float5;
        if (l.gender == 0)
        {
            r.setImageResource(0x7f020064);
        } else
        {
            r.setImageResource(0x7f020065);
        }
        if (l.location.city.equals(""))
        {
            l.location.city = getString(0x7f0d01c5);
        }
        q.setText(l.location.city);
        if (l.totalSportData == null || !l.totalSportData.isValid()) goto _L2; else goto _L1
_L1:
        float1 = Float.valueOf(0.0F);
        float5 = Float.valueOf(l.totalSportData.distance);
        float1 = float5;
_L3:
        float2 = Float.valueOf((100F * (float)(int)(float1.floatValue() / 100F)) / 1000F);
        u.setText((new StringBuilder()).append(float2).append("").toString());
        float3 = Float.valueOf(0.0F);
        float4 = Float.valueOf(l.totalSportData.averageSteps);
        float3 = float4;
_L4:
        w.setText((new StringBuilder()).append("").append(float3.intValue()).toString());
        D.setText((new StringBuilder()).append(l.totalSportData.totalwearingdays).append("").toString());
_L2:
        Exception exception;
        Exception exception1;
        if (l.uid == Keeper.readPersonInfo().uid)
        {
            x.setVisibility(0);
            return;
        } else
        {
            x.setVisibility(4);
            return;
        }
        exception;
        exception.printStackTrace();
          goto _L3
        exception1;
        exception1.printStackTrace();
          goto _L4
    }

    static void d(PersonInfoFragment personinfofragment)
    {
        personinfofragment.i();
    }

    private void e()
    {
        MiliExitLoginFragment miliexitloginfragment = new MiliExitLoginFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("exit_login_type", 0);
        miliexitloginfragment.setArguments(bundle);
        miliexitloginfragment.setOpClickListener(new bj(this));
        DimPanelFragment.showPanel(getActivity(), miliexitloginfragment);
    }

    static void e(PersonInfoFragment personinfofragment)
    {
        personinfofragment.h();
    }

    private void f()
    {
        MiliExitLoginFragment miliexitloginfragment = new MiliExitLoginFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("exit_login_type", 1);
        miliexitloginfragment.setArguments(bundle);
        miliexitloginfragment.setOpClickListener(new bk(this));
        DimPanelFragment.showPanel(getActivity(), miliexitloginfragment);
    }

    private void g()
    {
        cn.com.smartdevices.bracelet.model.SwitchOperator switchoperator = Keeper.readSwitchOperator();
        android.content.SharedPreferences.Editor editor = Keeper.getSharedPref().edit();
        editor.clear();
        editor.commit();
        Keeper.keepSwitchOperator(switchoperator);
        DaoManager.getInstance().getLuaListDao().deleteAll();
        DaoManager.getInstance().getLuaZipFileDao().deleteAll();
        DataManager.getInstance().clearAll();
    }

    private void h()
    {
        Intent intent = new Intent();
        intent.setClass(getActivity(), cn/com/smartdevices/bracelet/activity/LoginActivity);
        intent.setFlags(0x10008000);
        startActivity(intent);
    }

    private void i()
    {
        Debug.f("switch", "exit login now!");
        Utils.showProgressDialog(getActivity(), 0x7f0d00ee);
        Utils.switchBracelet(getActivity(), 1);
        g();
        (new Handler()).postDelayed(new bl(this), 3000L);
    }

    private void j()
    {
        ArrayList arraylist = DataManager.getInstance().getNeedSyncDatas();
        if (arraylist == null || arraylist.size() == 0)
        {
            i();
            return;
        }
        Utils.showProgressDialog(getActivity(), 0x7f0d01b2);
        JSONArray jsonarray = new JSONArray();
        for (Iterator iterator = arraylist.iterator(); iterator.hasNext(); jsonarray.put(((UploadData)iterator.next()).toJSONObject())) { }
        WebAPI.syncToServer(Keeper.readLoginData(), Keeper.readDeviceId(), 0, 0, jsonarray.toString(), new bm(this));
    }

    private void k()
    {
        (new BleSetPersonalInfoTask(l, new bn(this))).work();
    }

    public static Fragment newInstance()
    {
        PersonInfoFragment personinfofragment = new PersonInfoFragment();
        Bundle bundle = new Bundle();
        PersonInfo personinfo = Keeper.readPersonInfo();
        if (personinfo != null)
        {
            bundle.putString("person_info_json", (new Gson()).toJson(personinfo));
        }
        personinfofragment.setArguments(bundle);
        return personinfofragment;
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        if (i1 == 17 && intent != null)
        {
            l.avatarPath = intent.getStringExtra("CROPPED_FILE_PATH");
            d();
            l.setNeedSyncServer(1);
            Keeper.keepPersonInfo(l);
            Debug.i("PersonInfoFragment", (new StringBuilder()).append("onActivityResult requst_code =").append(i1).toString());
            EventBus.getDefault().post(new EventPersonInfoUpdate("update_avatar"));
        } else
        if (i1 == 18 && intent != null && intent.getExtras() != null)
        {
            B = (Bitmap)intent.getExtras().get("data");
            if (B != null)
            {
                try
                {
                    String s1 = (new StringBuilder()).append(((BraceletApp)getActivity().getApplication()).getStoragePath()).append("/bracelet_icon.jpg").toString();
                    FileOutputStream fileoutputstream = new FileOutputStream(s1);
                    B.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, fileoutputstream);
                    fileoutputstream.close();
                    l.avatarPath = s1;
                    n.setBackground(new BitmapDrawable(getResources(), Util.clipToRoundBitmap(B)));
                    B.recycle();
                    B = null;
                    l.setNeedSyncServer(1);
                    Keeper.keepPersonInfo(l);
                    Debug.i("PersonInfoFragment", (new StringBuilder()).append("onActivityResult requst_code =").append(i1).append(" task photo post evnetbus").toString());
                    EventBus.getDefault().post(new EventPersonInfoUpdate("update_avatar"));
                    return;
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
                return;
            }
        }
    }

    public void onClick(View view)
    {
        Intent intent;
        switch (view.getId())
        {
        default:
            return;

        case 2131362177: 
            e();
            return;

        case 2131362047: 
            DimPanelFragment.showPanel(getActivity(), cn/com/smartdevices/bracelet/ui/PersonInfoSettingSignatureFragment);
            return;

        case 2131362046: 
            DimPanelFragment.showPanel(getActivity(), cn/com/smartdevices/bracelet/ui/PersonInfoSettingNicknameFragment);
            return;

        case 2131362169: 
            DimPanelFragment.showPanel(getActivity(), cn/com/smartdevices/bracelet/ui/PersonInfoSettingGenderFragment);
            return;

        case 2131362173: 
            DimPanelFragment.showPanel(getActivity(), cn/com/smartdevices/bracelet/ui/PersonInfoSettingHeightFragment);
            return;

        case 2131362175: 
            DimPanelFragment.showPanel(getActivity(), cn/com/smartdevices/bracelet/ui/PersonInfoSettingWeightFragment);
            return;

        case 2131362171: 
            DimPanelFragment.showPanel(getActivity(), cn/com/smartdevices/bracelet/ui/PersonInfoSettingAgeFragment);
            return;

        case 2131362179: 
            DimPanelFragment.showPanel(getActivity(), cn/com/smartdevices/bracelet/ui/SelectImageQuestionFragment);
            return;

        case 2131361844: 
            getActivity().finish();
            return;

        case 2131362190: 
            intent = new Intent();
            break;
        }
        intent.setClass(getActivity(), cn/com/smartdevices/bracelet/ui/StatisticActivity);
        startActivity(intent);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        String s1 = getArguments().getString("person_info_json");
        PersonInfo personinfo = (PersonInfo)(new Gson()).fromJson(s1, cn/com/smartdevices/bracelet/model/PersonInfo);
        Debug.i("PersonInfoFragment", (new StringBuilder()).append("thisperson=").append(personinfo).toString());
        l = personinfo;
        b = personinfo.avatarUrl;
        a = personinfo.nickname;
        EventBus.getDefault().register(this);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        View view = layoutinflater.inflate(0x7f030054, null);
        a(view);
        b(l);
        c();
        if (l.getNeedSyncServer() != 0)
        {
            onEvent(new EventPersonInfoUpdate());
        }
        return view;
    }

    public void onDestroy()
    {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void onEvent(EventPersonInfoUpdate eventpersoninfoupdate)
    {
        l = Keeper.readPersonInfo();
        Debug.i("PersonInfoFragment", (new StringBuilder()).append("update ... ui ").append(l).toString());
        if (!"update_avatar".equals(eventpersoninfoupdate.type))
        {
            c();
            k();
        }
        Utils.updateProfile(l);
    }

    public void onPause()
    {
        super.onPause();
        AnalyticsTrackerManager.endTimedEvent(new String[] {
            "EventPersonPage"
        });
        UmengAnalytics.endPage("PagePersonInfo");
    }

    public void onResume()
    {
        super.onResume();
        AnalyticsTrackerManager.trackTimedEvent("EventPersonPage");
        UmengAnalytics.startPage("PagePersonInfo");
    }
}
