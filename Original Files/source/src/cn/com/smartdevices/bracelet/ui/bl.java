// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.Utils;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            PersonInfoFragment

class bl
    implements Runnable
{

    final PersonInfoFragment a;

    bl(PersonInfoFragment personinfofragment)
    {
        a = personinfofragment;
        super();
    }

    public void run()
    {
        Utils.hideProgressDialog(a.getActivity());
        PersonInfoFragment.e(a);
    }
}
