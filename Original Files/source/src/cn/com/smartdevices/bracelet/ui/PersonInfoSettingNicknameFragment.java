// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.eventbus.EventPersonInfoUpdate;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.view.CustomToast;
import de.greenrobot.event.EventBus;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            DimPanelFragment

public class PersonInfoSettingNicknameFragment extends DimPanelFragment
{

    private PersonInfo a;
    private EditText b;

    public PersonInfoSettingNicknameFragment()
    {
    }

    protected int inflateLayout()
    {
        return 0x7f030039;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        a = Keeper.readPersonInfo();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        View view = super.onCreateView(layoutinflater, viewgroup, bundle);
        b = (EditText)view.findViewById(0x7f0a00fe);
        b.setText(a.nickname);
        b.setSelection(b.length());
        return view;
    }

    protected void onRightButtomClicked()
    {
        String s = a.nickname;
        if (TextUtils.isEmpty(b.getText()))
        {
            a.nickname = "";
        } else
        {
            a.nickname = b.getText().toString().replaceAll("\\s+", "");
        }
        if (!Utils.checkInputText(a.nickname))
        {
            CustomToast.makeText(getActivity(), 0x7f0d004b, 0).show();
            return;
        }
        if (a.nickname.equals(s))
        {
            dismiss();
            return;
        } else
        {
            a.setNeedSyncServer(2);
            Keeper.keepPersonInfo(a);
            EventBus.getDefault().post(new EventPersonInfoUpdate());
            dismiss();
            return;
        }
    }
}
