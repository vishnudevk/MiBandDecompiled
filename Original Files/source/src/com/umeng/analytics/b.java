// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.analytics;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

public class b
{

    public b()
    {
    }

    public static boolean a(Context context)
    {
        int i;
        Iterator iterator;
        i = Process.myPid();
        iterator = ((ActivityManager)context.getSystemService("activity")).getRunningAppProcesses().iterator();
        String s = null;
_L4:
        boolean flag = iterator.hasNext();
        if (flag) goto _L2; else goto _L1
_L1:
        CharSequence charsequence = s;
_L5:
        Exception exception;
        android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo;
        String s1;
        return TextUtils.isEmpty(charsequence) || context.getPackageName().equals(charsequence);
_L2:
        runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)iterator.next();
        if (runningappprocessinfo.pid != i) goto _L4; else goto _L3
_L3:
        s1 = runningappprocessinfo.processName.trim();
        s = s1;
          goto _L4
        exception;
        charsequence = null;
          goto _L5
    }
}
