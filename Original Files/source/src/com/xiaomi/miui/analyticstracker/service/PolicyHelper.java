// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.miui.analyticstracker.service;

import android.text.TextUtils;
import com.xiaomi.miui.analyticstracker.ObjectBuilder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.PatternSyntaxException;

// Referenced classes of package com.xiaomi.miui.analyticstracker.service:
//            LastPolicy, NormalPolicy, CountPolicy, Policy

public class PolicyHelper
{

    private static final String c = ":";
    private Map a;
    private ObjectBuilder b;

    public PolicyHelper()
    {
        a = new HashMap();
        b = new ObjectBuilder();
        b.registerClass(com/xiaomi/miui/analyticstracker/service/LastPolicy, "last");
        b.registerClass(com/xiaomi/miui/analyticstracker/service/NormalPolicy, "normal");
        b.registerClass(com/xiaomi/miui/analyticstracker/service/CountPolicy, "count");
    }

    public void clear()
    {
        a.clear();
    }

    public void end()
    {
        String s;
        for (Iterator iterator = a.keySet().iterator(); iterator.hasNext(); ((Policy)a.get(s)).end())
        {
            s = (String)iterator.next();
        }

    }

    public Policy getPolicy(String s)
    {
        if (TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        String as[] = s.split(":");
        if (as.length <= 0) goto _L2; else goto _L3
_L3:
        Policy policy = (Policy)a.get(as[0]);
        if (as.length <= 1) goto _L5; else goto _L4
_L4:
        String s1 = as[1];
_L12:
        if (policy != null) goto _L7; else goto _L6
_L6:
        policy = (Policy)b.buildObject(s);
        if (policy == null) goto _L9; else goto _L8
_L8:
        a.put(s, policy);
        policy.setParam(s1);
        policy.prepare();
        return policy;
_L7:
        policy.setParam(s1);
        return policy;
        PatternSyntaxException patternsyntaxexception1;
        patternsyntaxexception1;
_L10:
        patternsyntaxexception1.printStackTrace();
        return policy;
        PatternSyntaxException patternsyntaxexception;
        patternsyntaxexception;
        patternsyntaxexception1 = patternsyntaxexception;
        policy = null;
        if (true) goto _L10; else goto _L2
_L2:
        policy = null;
_L9:
        return policy;
_L5:
        s1 = "";
        if (true) goto _L12; else goto _L11
_L11:
    }
}
