// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;

// Referenced classes of package com.sina.weibo.sdk.utils:
//            LogUtil

public class ResourceManager
{

    private static final String DIALOG_BACKGROUND_IMAGE_NAME = "weibosdk_dialog_bg.9.png";
    public static final int DIALOG_BOTTOM_MARGIN = 10;
    private static final String DIALOG_CLOSE_BUTTON_IMAGE_NAME = "ic_com_sina_weibo_sdk_close.png";
    public static final int DIALOG_LEFT_MARGIN = 10;
    public static final int DIALOG_RIGHT_MARGIN = 10;
    public static final int DIALOG_TOP_MARGIN = 30;
    private static final String DRAWABLE = "drawable";
    private static final String DRAWABLE_HDPI = "drawable-hdpi";
    private static final String DRAWABLE_LDPI = "drawable-ldpi";
    private static final String DRAWABLE_MDPI = "drawable-mdpi";
    private static final String DRAWABLE_XHDPI = "drawable-xhdpi";
    private static final String DRAWABLE_XXHDPI = "drawable-xxhdpi";
    private static final String LOADING_EN = "Loading...";
    private static final String LOADING_ZH_CN = "\u52A0\u8F7D\u4E2D...";
    private static final String LOADING_ZH_TW = "\u8F09\u5165\u4E2D...";
    private static final String NETWORK_NOT_AVAILABLE_EN = "Network is not available";
    private static final String NETWORK_NOT_AVAILABLE_ZH_CN = "\u65E0\u6CD5\u8FDE\u63A5\u5230\u7F51\u7EDC\uFF0C\u8BF7\u68C0\u67E5\u7F51\u7EDC\u914D\u7F6E";
    private static final String NETWORK_NOT_AVAILABLE_ZH_TW = "\u7121\u6CD5\u9023\u63A5\u5230\u7DB2\u7EDC\uFF0C\u8ACB\u6AA2\u67E5\u7DB2\u7EDC\u914D\u7F6E";
    private static final String PRE_INSTALL_DRAWBLE_PATHS[] = {
        "drawable-xxhdpi", "drawable-xhdpi", "drawable-hdpi", "drawable-mdpi", "drawable-ldpi", "drawable"
    };
    private static final String TAG = com/sina/weibo/sdk/utils/ResourceManager.getName();
    public static final int dimen_dialog_bottom_margin = 4;
    public static final int dimen_dialog_left_margin = 1;
    public static final int dimen_dialog_right_margin = 3;
    public static final int dimen_dialog_top_margin = 2;
    public static final int drawable_dialog_background = 1;
    public static final int drawable_dialog_close_button = 2;
    private static final SparseArray sDrawableMap;
    private static final HashMap sLanguageMap;
    private static final SparseIntArray sLayoutMap;
    public static final int string_loading = 1;
    public static final int string_network_not_available = 2;

    public ResourceManager()
    {
    }

    private static Drawable extractDrawable(Context context, String s)
    {
        InputStream inputstream = context.getAssets().open(s);
        DisplayMetrics displaymetrics = context.getResources().getDisplayMetrics();
        TypedValue typedvalue = new TypedValue();
        typedvalue.density = displaymetrics.densityDpi;
        Drawable drawable = Drawable.createFromResourceStream(context.getResources(), typedvalue, inputstream, s);
        inputstream.close();
        return drawable;
    }

    private static View extractView(Context context, String s, ViewGroup viewgroup)
    {
        android.content.res.XmlResourceParser xmlresourceparser = context.getAssets().openXmlResourceParser(s);
        return ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(xmlresourceparser, viewgroup);
    }

    public static String getAppropriatePathOfDrawable(Context context, String s)
    {
        boolean flag;
        String s1;
        int i;
        flag = false;
        if (TextUtils.isEmpty(s))
        {
            LogUtil.e(TAG, "id is NOT correct!");
            return null;
        }
        s1 = getCurrentDpiFolder(context);
        String s2 = (new StringBuilder(String.valueOf(s1))).append("/").append(s).toString();
        LogUtil.i(TAG, (new StringBuilder("Maybe the appropriate path: ")).append(s2).toString());
        if (isFileExisted(context, s2))
        {
            return s2;
        }
        LogUtil.d(TAG, "Not the correct path, we need to find one...");
        i = 0;
_L2:
        if (i >= PRE_INSTALL_DRAWBLE_PATHS.length)
        {
            LogUtil.e(TAG, "Not find the appropriate path for drawable");
            return null;
        }
        if (flag)
        {
            break; /* Loop/switch isn't completed */
        }
        if (s1.equals(PRE_INSTALL_DRAWBLE_PATHS[i]))
        {
            flag = true;
            LogUtil.i(TAG, (new StringBuilder("Have Find index: ")).append(i).append(", ").append(PRE_INSTALL_DRAWBLE_PATHS[i]).toString());
        }
_L3:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        String s3 = (new StringBuilder(String.valueOf(PRE_INSTALL_DRAWBLE_PATHS[i]))).append("/").append(s).toString();
        if (isFileExisted(context, s3))
        {
            return s3;
        }
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
    }

    private static String getCurrentDpiFolder(Context context)
    {
        int i = context.getResources().getDisplayMetrics().densityDpi;
        if (i <= 120)
        {
            return "drawable-ldpi";
        }
        if (i > 120 && i <= 160)
        {
            return "drawable-mdpi";
        }
        if (i > 160 && i <= 240)
        {
            return "drawable-hdpi";
        }
        if (i > 240 && i <= 320)
        {
            return "drawable-xhdpi";
        } else
        {
            return "drawable-xxhdpi";
        }
    }

    public static int getDimensionPixelSize(int i)
    {
        return sLayoutMap.get(i, 0);
    }

    public static Drawable getDrawable(Context context, int i)
    {
        return getDrawableFromAssert(context, getAppropriatePathOfDrawable(context, (String)sDrawableMap.get(i, "")), false);
    }

    public static Drawable getDrawableFromAssert(Context context, String s, boolean flag)
    {
        AssetManager assetmanager = context.getAssets();
        InputStream inputstream2 = assetmanager.open(s);
        InputStream inputstream1 = inputstream2;
        if (inputstream1 == null) goto _L2; else goto _L1
_L1:
        Bitmap bitmap;
        DisplayMetrics displaymetrics;
        bitmap = BitmapFactory.decodeStream(inputstream1);
        displaymetrics = context.getResources().getDisplayMetrics();
        if (!flag) goto _L4; else goto _L3
_L3:
        Object obj;
        android.content.res.Configuration configuration = context.getResources().getConfiguration();
        obj = new NinePatchDrawable(new Resources(context.getAssets(), displaymetrics, configuration), bitmap, bitmap.getNinePatchChunk(), new Rect(0, 0, 0, 0), null);
_L9:
        IOException ioexception;
        InputStream inputstream;
        Exception exception;
        IOException ioexception1;
        IOException ioexception2;
        if (inputstream1 != null)
        {
            try
            {
                inputstream1.close();
            }
            catch (IOException ioexception3)
            {
                ioexception3.printStackTrace();
                return ((Drawable) (obj));
            }
        }
        return ((Drawable) (obj));
_L4:
        bitmap.setDensity(displaymetrics.densityDpi);
        obj = new BitmapDrawable(context.getResources(), bitmap);
        continue; /* Loop/switch isn't completed */
        ioexception;
        inputstream = inputstream1;
_L7:
        ioexception.printStackTrace();
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (IOException ioexception2)
            {
                ioexception2.printStackTrace();
            }
            return null;
        } else
        {
            return null;
        }
        exception;
        inputstream1 = null;
_L6:
        if (inputstream1 != null)
        {
            try
            {
                inputstream1.close();
            }
            // Misplaced declaration of an exception variable
            catch (IOException ioexception1)
            {
                ioexception1.printStackTrace();
            }
        }
        throw exception;
        exception;
        continue; /* Loop/switch isn't completed */
        exception;
        inputstream1 = inputstream;
        if (true) goto _L6; else goto _L5
_L5:
        ioexception;
        inputstream = null;
        if (true) goto _L7; else goto _L2
_L2:
        obj = null;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public static Locale getLanguage()
    {
        Locale locale = Locale.getDefault();
        if (Locale.SIMPLIFIED_CHINESE.equals(locale) || Locale.TRADITIONAL_CHINESE.equals(locale))
        {
            return locale;
        } else
        {
            return Locale.ENGLISH;
        }
    }

    public static Drawable getNinePatchDrawable(Context context, int i)
    {
        return getDrawableFromAssert(context, getAppropriatePathOfDrawable(context, (String)sDrawableMap.get(i, "")), true);
    }

    public static String getString(Context context, int i)
    {
        Locale locale = getLanguage();
        return (String)((SparseArray)sLanguageMap.get(locale)).get(i, "");
    }

    private static boolean isFileExisted(Context context, String s)
    {
        if (context != null && !TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        AssetManager assetmanager;
        InputStream inputstream;
        assetmanager = context.getAssets();
        inputstream = null;
        inputstream = assetmanager.open(s);
        LogUtil.d(TAG, (new StringBuilder("file [")).append(s).append("] existed").toString());
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            catch (IOException ioexception3)
            {
                ioexception3.printStackTrace();
            }
        }
        return true;
        IOException ioexception1;
        ioexception1;
        LogUtil.d(TAG, (new StringBuilder("file [")).append(s).append("] NOT existed").toString());
        if (inputstream == null) goto _L1; else goto _L3
_L3:
        try
        {
            inputstream.close();
        }
        catch (IOException ioexception2)
        {
            ioexception2.printStackTrace();
            return false;
        }
        return false;
        Exception exception;
        exception;
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            catch (IOException ioexception)
            {
                ioexception.printStackTrace();
            }
        }
        throw exception;
    }

    static 
    {
        sLayoutMap = new SparseIntArray();
        sLayoutMap.put(1, 10);
        sLayoutMap.put(2, 30);
        sLayoutMap.put(3, 10);
        sLayoutMap.put(4, 10);
        sDrawableMap = new SparseArray();
        sDrawableMap.put(1, "weibosdk_dialog_bg.9.png");
        sDrawableMap.put(2, "ic_com_sina_weibo_sdk_close.png");
        sLanguageMap = new HashMap();
        SparseArray sparsearray = new SparseArray();
        sparsearray.put(1, "\u52A0\u8F7D\u4E2D...");
        sparsearray.put(2, "\u65E0\u6CD5\u8FDE\u63A5\u5230\u7F51\u7EDC\uFF0C\u8BF7\u68C0\u67E5\u7F51\u7EDC\u914D\u7F6E");
        sLanguageMap.put(Locale.SIMPLIFIED_CHINESE, sparsearray);
        SparseArray sparsearray1 = new SparseArray();
        sparsearray1.put(1, "\u8F09\u5165\u4E2D...");
        sparsearray1.put(2, "\u7121\u6CD5\u9023\u63A5\u5230\u7DB2\u7EDC\uFF0C\u8ACB\u6AA2\u67E5\u7DB2\u7EDC\u914D\u7F6E");
        sLanguageMap.put(Locale.TRADITIONAL_CHINESE, sparsearray1);
        SparseArray sparsearray2 = new SparseArray();
        sparsearray2.put(1, "Loading...");
        sparsearray2.put(2, "Network is not available");
        sLanguageMap.put(Locale.ENGLISH, sparsearray2);
    }
}
