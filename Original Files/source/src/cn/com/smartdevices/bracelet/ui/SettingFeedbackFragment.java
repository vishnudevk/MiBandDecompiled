// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.view.CustomToast;
import cn.com.smartdevices.bracelet.webapi.WebAPI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            bG, bE, bF

public class SettingFeedbackFragment extends Fragment
    implements android.view.View.OnClickListener
{

    private static final String d = "^[\\w\\-\\.]+@[\\w\\-]+(\\.\\w+)+$";
    private static final String e = "^\\d+$";
    private EditText a;
    private EditText b;
    private View c;

    public SettingFeedbackFragment()
    {
    }

    static View a(SettingFeedbackFragment settingfeedbackfragment)
    {
        return settingfeedbackfragment.c;
    }

    private void a(String s, String s1)
    {
        WebAPI.sendFeedback(Keeper.readLoginData(), s, s1, new bG(this));
    }

    public static boolean isContentValid(String s)
    {
        return !TextUtils.isEmpty(s);
    }

    public static boolean isEmailValid(String s)
    {
        while (!TextUtils.isEmpty(s) && (Pattern.compile("^[\\w\\-\\.]+@[\\w\\-]+(\\.\\w+)+$").matcher(s).matches() || Pattern.compile("^\\d+$").matcher(s).matches())) 
        {
            return true;
        }
        return false;
    }

    public void onClick(View view)
    {
        String s = a.getText().toString();
        String s1 = b.getText().toString();
        if (isContentValid(s))
        {
            if (isEmailValid(s1))
            {
                a(s, s1);
                UmengAnalytics.event(getActivity(), "AboutSendFeedback");
                return;
            } else
            {
                CustomToast.makeText(getActivity(), "\u8054\u7CFB\u65B9\u5F0F\u65E0\u6548\uFF0C\u8BF7\u91CD\u586B!", 0).show();
                return;
            }
        } else
        {
            CustomToast.makeText(getActivity(), "\u8BF7\u586B\u5199\u53CD\u9988\u5185\u5BB9!", 0).show();
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        View view = layoutinflater.inflate(0x7f030043, viewgroup, false);
        a = (EditText)view.findViewById(0x7f0a0119);
        b = (EditText)view.findViewById(0x7f0a0118);
        c = view.findViewById(0x7f0a011a);
        c.setOnClickListener(this);
        b.setOnEditorActionListener(new bE(this));
        ((TextView)view.findViewById(0x7f0a0034)).setOnClickListener(new bF(this));
        return view;
    }

    public void onPause()
    {
        super.onPause();
        UmengAnalytics.endPage("PageFeedback");
    }

    public void onResume()
    {
        super.onResume();
        UmengAnalytics.startPage("PageFeedback");
    }
}
