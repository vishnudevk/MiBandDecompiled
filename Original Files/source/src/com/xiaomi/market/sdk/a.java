// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.market.sdk;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;

// Referenced classes of package com.xiaomi.market.sdk:
//            b

public class a
{

    static final int a;
    static int b;
    static int c;
    static String d;
    static int e;
    static int f;
    static String g;
    static ArrayList h;
    static ArrayList i;
    static ArrayList j;
    static int k;
    static String l;
    static String m;
    static String n;
    static String o;
    static String p;
    static String q;
    private static final Object r = new Object();

    public a()
    {
    }

    static void a(Context context)
    {
        b(context);
        c(context);
        d(context);
        e(context);
        c();
        f(context);
        g(context);
        h(context);
    }

    static boolean a()
    {
        return k >= 13;
    }

    private static void b(Context context)
    {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getMetrics(displaymetrics);
        c = displaymetrics.heightPixels;
        b = displaymetrics.widthPixels;
        d = (new StringBuilder(String.valueOf(c))).append("*").append(b).toString();
        e = displaymetrics.densityDpi;
    }

    static boolean b()
    {
        return k >= 11;
    }

    private static void c()
    {
        String s = d();
        Object obj = r;
        obj;
        JVM INSTR monitorenter ;
        j = new ArrayList();
        if (TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        String as[];
        int i1;
        as = TextUtils.split(s, " ");
        i1 = as.length;
        int j1 = 0;
          goto _L3
_L2:
        Collections.sort(j);
        obj;
        JVM INSTR monitorexit ;
        return;
_L5:
        String s1 = as[j1];
        if (!TextUtils.isEmpty(s1))
        {
            j.add(s1);
        }
          goto _L4
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L3:
        if (j1 < i1) goto _L5; else goto _L2
_L4:
        j1++;
          goto _L3
    }

    private static void c(Context context)
    {
        ConfigurationInfo configurationinfo = ((ActivityManager)context.getSystemService("activity")).getDeviceConfigurationInfo();
        f = configurationinfo.reqTouchScreen;
        g = configurationinfo.getGlEsVersion();
    }

    private static String d()
    {
        EGL10 egl10;
        javax.microedition.khronos.egl.EGLDisplay egldisplay;
        egl10 = (EGL10)EGLContext.getEGL();
        egldisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        break MISSING_BLOCK_LABEL_17;
        if (egldisplay != EGL10.EGL_NO_DISPLAY && egl10.eglInitialize(egldisplay, new int[2]))
        {
            int ai[] = new int[1];
            EGLConfig aeglconfig[] = new EGLConfig[1];
            if (egl10.eglChooseConfig(egldisplay, new int[] {
    12339, 1, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 
    12344
}, aeglconfig, 1, ai))
            {
                EGLConfig eglconfig;
                EGLContext eglcontext;
                javax.microedition.khronos.egl.EGLSurface eglsurface;
                if (ai[0] > 0)
                {
                    eglconfig = aeglconfig[0];
                } else
                {
                    eglconfig = null;
                }
                eglcontext = egl10.eglCreateContext(egldisplay, eglconfig, EGL10.EGL_NO_CONTEXT, null);
                eglsurface = egl10.eglCreatePbufferSurface(egldisplay, eglconfig, new int[] {
                    12375, 480, 12374, 800, 12344
                });
                if (eglsurface != null && eglsurface != EGL10.EGL_NO_SURFACE)
                {
                    egl10.eglMakeCurrent(egldisplay, eglsurface, eglsurface, eglcontext);
                    if (egl10.eglMakeCurrent(egldisplay, eglsurface, eglsurface, eglcontext))
                    {
                        String s = ((GL10)eglcontext.getGL()).glGetString(7939);
                        egl10.eglDestroySurface(egldisplay, eglsurface);
                        egl10.eglDestroyContext(egldisplay, eglcontext);
                        egl10.eglTerminate(egldisplay);
                        if (s != null)
                        {
                            return s.trim();
                        }
                    }
                }
            }
        }
        return null;
    }

    private static void d(Context context)
    {
        FeatureInfo afeatureinfo[] = context.getPackageManager().getSystemAvailableFeatures();
        Object obj = r;
        obj;
        JVM INSTR monitorenter ;
        h = new ArrayList();
        if (afeatureinfo == null) goto _L2; else goto _L1
_L1:
        int i1 = afeatureinfo.length;
        int j1 = 0;
          goto _L3
_L2:
        Collections.sort(h);
        obj;
        JVM INSTR monitorexit ;
        return;
_L5:
        FeatureInfo featureinfo = afeatureinfo[j1];
        if (!TextUtils.isEmpty(featureinfo.name))
        {
            h.add(featureinfo.name);
        }
          goto _L4
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L3:
        if (j1 < i1) goto _L5; else goto _L2
_L4:
        j1++;
          goto _L3
    }

    private static void e(Context context)
    {
        String as[] = context.getPackageManager().getSystemSharedLibraryNames();
        Object obj = r;
        obj;
        JVM INSTR monitorenter ;
        i = new ArrayList();
        if (as == null) goto _L2; else goto _L1
_L1:
        int i1 = as.length;
        int j1 = 0;
          goto _L3
_L2:
        Collections.sort(i);
        obj;
        JVM INSTR monitorexit ;
        return;
_L5:
        String s = as[j1];
        if (!TextUtils.isEmpty(s))
        {
            i.add(s);
        }
          goto _L4
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L3:
        if (j1 < i1) goto _L5; else goto _L2
_L4:
        j1++;
          goto _L3
    }

    private static void f(Context context)
    {
        m = android.os.Build.VERSION.RELEASE;
        l = android.os.Build.VERSION.INCREMENTAL;
        k = android.os.Build.VERSION.SDK_INT;
    }

    private static void g(Context context)
    {
        q = Locale.getDefault().getCountry();
        p = Locale.getDefault().getLanguage();
    }

    private static void h(Context context)
    {
        String s = ((TelephonyManager)context.getSystemService("phone")).getDeviceId();
        String s1;
        String s2;
        StringBuffer stringbuffer;
        if (TextUtils.isEmpty(s))
        {
            s1 = "";
        } else
        {
            s1 = s;
        }
        n = s1;
        s2 = ((WifiManager)context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        stringbuffer = new StringBuffer();
        if (!TextUtils.isEmpty(s1))
        {
            stringbuffer.append(s1);
        }
        if (!TextUtils.isEmpty(s2))
        {
            stringbuffer.append("_");
            stringbuffer.append(s2);
        }
        o = com.xiaomi.market.sdk.b.a(stringbuffer.toString());
    }

}
