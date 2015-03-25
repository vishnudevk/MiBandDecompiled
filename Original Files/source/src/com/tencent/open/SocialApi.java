// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.connect.auth.QQToken;
import com.tencent.tauth.IUiListener;
import com.tencent.utils.Util;

// Referenced classes of package com.tencent.open:
//            SocialApiIml

public class SocialApi
{

    private SocialApiIml a;

    public SocialApi(Context context, QQToken qqtoken)
    {
        a = new SocialApiIml(context, qqtoken);
    }

    public void ask(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        a.ask(activity, bundle, iuilistener);
    }

    public void brag(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        a.brag(activity, bundle, iuilistener);
    }

    public void challenge(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        a.challenge(activity, bundle, iuilistener);
    }

    public boolean checkVoiceApi(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        bundle.putString("version", Util.getAppVersion(activity));
        a.grade(activity, bundle, iuilistener);
        return true;
    }

    public void gift(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        a.gift(activity, bundle, iuilistener);
    }

    public void grade(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        bundle.putString("version", Util.getAppVersion(activity));
        a.grade(activity, bundle, iuilistener);
    }

    public void invite(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        a.invite(activity, bundle, iuilistener);
    }

    public void reactive(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        a.reactive(activity, bundle, iuilistener);
    }

    public void story(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        a.story(activity, bundle, iuilistener);
    }

    public void voice(Activity activity, Bundle bundle, IUiListener iuilistener)
    {
        bundle.putString("version", Util.getAppVersion(activity));
        a.voice(activity, bundle, iuilistener);
    }
}
