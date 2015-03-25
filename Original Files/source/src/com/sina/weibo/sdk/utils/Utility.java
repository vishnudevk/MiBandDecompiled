// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboParameters;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.sina.weibo.sdk.utils:
//            LogUtil, MD5

public class Utility
{

    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final byte decodes[] = new byte[256];
    private static final char encodes[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

    public Utility()
    {
    }

    private static boolean __createNewFile(File file)
    {
        if (file == null)
        {
            return false;
        }
        makesureParentExist(file);
        if (file.exists())
        {
            delete(file);
        }
        boolean flag;
        try
        {
            flag = file.createNewFile();
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            return false;
        }
        return flag;
    }

    private static void createNewFile(File file)
    {
        while (file == null || __createNewFile(file)) 
        {
            return;
        }
        throw new RuntimeException((new StringBuilder(String.valueOf(file.getAbsolutePath()))).append(" doesn't be created!").toString());
    }

    public static byte[] decodeBase62(String s)
    {
        int i;
        char ac[];
        ByteArrayOutputStream bytearrayoutputstream;
        int j;
        int k;
        i = 0;
        if (s == null)
        {
            return null;
        }
        ac = s.toCharArray();
        bytearrayoutputstream = new ByteArrayOutputStream(s.toCharArray().length);
        j = 0;
        k = 0;
_L1:
        if (i >= ac.length)
        {
            return bytearrayoutputstream.toByteArray();
        }
        char c = ac[i];
        int l;
        char c1;
        if (c == 'i')
        {
            l = i + 1;
            char c2 = ac[l];
            if (c2 == 'a')
            {
                c1 = 'i';
            } else
            if (c2 == 'b')
            {
                c1 = '+';
            } else
            if (c2 == 'c')
            {
                c1 = '/';
            } else
            {
                l--;
                c1 = ac[l];
            }
        } else
        {
            l = i;
            c1 = c;
        }
        j = j << 6 | decodes[c1];
        k += 6;
label0:
        {
            if (k > 7)
            {
                break label0;
            }
            i = l + 1;
        }
          goto _L1
        k -= 8;
        bytearrayoutputstream.write(j >> k);
        j &= -1 + (1 << k);
        break MISSING_BLOCK_LABEL_94;
    }

    public static Bundle decodeUrl(String s)
    {
        Bundle bundle = new Bundle();
        if (s == null) goto _L2; else goto _L1
_L1:
        String as[];
        int i;
        int j;
        as = s.split("&");
        i = as.length;
        j = 0;
_L5:
        if (j < i) goto _L3; else goto _L2
_L2:
        return bundle;
_L3:
        String as1[] = as[j].split("=");
        try
        {
            bundle.putString(URLDecoder.decode(as1[0], "UTF-8"), URLDecoder.decode(as1[1], "UTF-8"));
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            unsupportedencodingexception.printStackTrace();
        }
        j++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private static void delete(File file)
    {
        if (file != null && file.exists() && !file.delete())
        {
            throw new RuntimeException((new StringBuilder(String.valueOf(file.getAbsolutePath()))).append(" doesn't be deleted!").toString());
        } else
        {
            return;
        }
    }

    private static boolean deleteDependon(File file, int i)
    {
        int j;
        boolean flag;
        j = 1;
        if (i < j)
        {
            i = 5;
        }
        flag = false;
        if (file == null) goto _L2; else goto _L1
_L1:
        if (!flag && j <= i && file.isFile() && file.exists()) goto _L3; else goto _L2
_L2:
        return flag;
_L3:
        flag = file.delete();
        if (!flag)
        {
            j++;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    private static boolean deleteDependon(String s)
    {
        return deleteDependon(s, 0);
    }

    private static boolean deleteDependon(String s, int i)
    {
        if (TextUtils.isEmpty(s))
        {
            return false;
        } else
        {
            return deleteDependon(new File(s), i);
        }
    }

    private static boolean doesExisted(File file)
    {
        return file != null && file.exists();
    }

    private static boolean doesExisted(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return false;
        } else
        {
            return doesExisted(new File(s));
        }
    }

    public static String encodeBase62(byte abyte0[])
    {
        int i;
        StringBuffer stringbuffer;
        int j;
        int k;
        i = 0;
        stringbuffer = new StringBuffer(2 * abyte0.length);
        j = 0;
        k = 0;
_L1:
        if (i >= abyte0.length)
        {
            if (k > 0)
            {
                char c1 = encodes[j << 6 - k];
                char ac[];
                int l;
                char c;
                Object obj;
                Object obj1;
                if (c1 == 'i')
                {
                    obj1 = "ia";
                } else
                if (c1 == '+')
                {
                    obj1 = "ib";
                } else
                if (c1 == '/')
                {
                    obj1 = "ic";
                } else
                {
                    obj1 = Character.valueOf(c1);
                }
                stringbuffer.append(obj1);
            }
            return stringbuffer.toString();
        }
        j = j << 8 | 0xff & abyte0[i];
        k += 8;
label0:
        {
            if (k > 5)
            {
                break label0;
            }
            i++;
        }
          goto _L1
        ac = encodes;
        l = k - 6;
        c = ac[j >> l];
        if (c == 'i')
        {
            obj = "ia";
        } else
        if (c == '+')
        {
            obj = "ib";
        } else
        if (c == '/')
        {
            obj = "ic";
        } else
        {
            obj = Character.valueOf(c);
        }
        stringbuffer.append(obj);
        j &= -1 + (1 << l);
        k = l;
        break MISSING_BLOCK_LABEL_82;
    }

    public static String encodeParameters(WeiboParameters weiboparameters)
    {
        int i = 0;
        if (weiboparameters == null || isBundleEmpty(weiboparameters))
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        int j = 0;
        do
        {
            if (i >= weiboparameters.size())
            {
                return stringbuilder.toString();
            }
            String s = weiboparameters.getKey(i);
            if (j != 0)
            {
                stringbuilder.append("&");
            }
            try
            {
                stringbuilder.append(URLEncoder.encode(s, "UTF-8")).append("=").append(URLEncoder.encode(weiboparameters.getValue(s), "UTF-8"));
            }
            catch (UnsupportedEncodingException unsupportedencodingexception) { }
            j++;
            i++;
        } while (true);
    }

    public static String encodeUrl(WeiboParameters weiboparameters)
    {
        if (weiboparameters == null)
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        boolean flag = true;
        int i = 0;
        do
        {
            if (i >= weiboparameters.size())
            {
                return stringbuilder.toString();
            }
            String s;
            if (flag)
            {
                flag = false;
            } else
            {
                stringbuilder.append("&");
            }
            s = weiboparameters.getKey(i);
            if (weiboparameters.getValue(s) == null)
            {
                LogUtil.i("encodeUrl", (new StringBuilder("key:")).append(s).append(" 's value is null").toString());
            } else
            {
                try
                {
                    stringbuilder.append((new StringBuilder(String.valueOf(URLEncoder.encode(weiboparameters.getKey(i), "UTF-8")))).append("=").append(URLEncoder.encode(weiboparameters.getValue(i), "UTF-8")).toString());
                }
                catch (UnsupportedEncodingException unsupportedencodingexception)
                {
                    unsupportedencodingexception.printStackTrace();
                }
            }
            LogUtil.i("encodeUrl", stringbuilder.toString());
            i++;
        } while (true);
    }

    public static Bundle errorSAX(String s)
    {
        Bundle bundle = new Bundle();
        if (s != null && s.indexOf("{") >= 0)
        {
            try
            {
                JSONObject jsonobject = new JSONObject(s);
                bundle.putString("error", jsonobject.optString("error"));
                bundle.putString("error_code", jsonobject.optString("error_code"));
                bundle.putString("error_description", jsonobject.optString("error_description"));
            }
            catch (JSONException jsonexception)
            {
                bundle.putString("error", "JSONExceptionerror");
                return bundle;
            }
        }
        return bundle;
    }

    public static Bundle formBundle(Oauth2AccessToken oauth2accesstoken)
    {
        Bundle bundle = new Bundle();
        bundle.putString("access_token", oauth2accesstoken.getToken());
        bundle.putString("refresh_token", oauth2accesstoken.getRefreshToken());
        bundle.putString("expires_in", (new StringBuilder(String.valueOf(oauth2accesstoken.getExpiresTime()))).toString());
        return bundle;
    }

    public static Bundle formErrorBundle(Exception exception)
    {
        Bundle bundle = new Bundle();
        bundle.putString("error", exception.getMessage());
        return bundle;
    }

    public static String generateGUID()
    {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String getSign(Context context, String s)
    {
        PackageInfo packageinfo;
        int i;
        try
        {
            packageinfo = context.getPackageManager().getPackageInfo(s, 64);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            return null;
        }
        i = 0;
        do
        {
            if (i >= packageinfo.signatures.length)
            {
                return null;
            }
            byte abyte0[] = packageinfo.signatures[i].toByteArray();
            if (abyte0 != null)
            {
                return MD5.hexdigest(abyte0);
            }
            i++;
        } while (true);
    }

    private static boolean isBundleEmpty(WeiboParameters weiboparameters)
    {
        return weiboparameters == null || weiboparameters.size() == 0;
    }

    public static boolean isChineseLocale(Context context)
    {
label0:
        {
label1:
            {
                boolean flag;
                try
                {
                    Locale locale = context.getResources().getConfiguration().locale;
                    if (Locale.CHINA.equals(locale) || Locale.CHINESE.equals(locale) || Locale.SIMPLIFIED_CHINESE.equals(locale))
                    {
                        break label1;
                    }
                    flag = Locale.TAIWAN.equals(locale);
                }
                catch (Exception exception)
                {
                    return true;
                }
                if (!flag)
                {
                    break label0;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean isWifi(Context context)
    {
        NetworkInfo networkinfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        return networkinfo != null && networkinfo.getType() == 1;
    }

    private static void makesureFileExist(File file)
    {
        while (file == null || file.exists()) 
        {
            return;
        }
        makesureParentExist(file);
        createNewFile(file);
    }

    private static void makesureFileExist(String s)
    {
        if (s == null)
        {
            return;
        } else
        {
            makesureFileExist(new File(s));
            return;
        }
    }

    private static void makesureParentExist(File file)
    {
        File file1;
        if (file != null)
        {
            if ((file1 = file.getParentFile()) != null && !file1.exists())
            {
                mkdirs(file1);
                return;
            }
        }
    }

    private static void mkdirs(File file)
    {
        while (file == null || file.exists() || file.mkdirs()) 
        {
            return;
        }
        throw new RuntimeException((new StringBuilder("fail to make ")).append(file.getAbsolutePath()).toString());
    }

    public static String packUrl(HashMap hashmap)
    {
        StringBuilder stringbuilder;
        Iterator iterator;
        boolean flag;
        if (hashmap == null)
        {
            return "";
        }
        stringbuilder = new StringBuilder();
        iterator = hashmap.keySet().iterator();
        flag = true;
_L2:
        String s;
        String s1;
        do
        {
            if (!iterator.hasNext())
            {
                return stringbuilder.toString();
            }
            s = (String)iterator.next();
            s1 = (String)hashmap.get(s);
        } while (TextUtils.isEmpty(s) || TextUtils.isEmpty(s1));
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = false;
_L3:
        try
        {
            stringbuilder.append(URLEncoder.encode(s, "UTF-8")).append("=").append(URLEncoder.encode(s1, "UTF-8"));
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            boolean flag1 = flag;
            unsupportedencodingexception.printStackTrace();
            flag = flag1;
        }
        if (true) goto _L2; else goto _L1
_L1:
        stringbuilder.append("&");
          goto _L3
    }

    public static Bundle parseUrl(String s)
    {
        Bundle bundle;
        try
        {
            URL url = new URL(s);
            bundle = decodeUrl(url.getQuery());
            bundle.putAll(decodeUrl(url.getRef()));
        }
        catch (MalformedURLException malformedurlexception)
        {
            return new Bundle();
        }
        return bundle;
    }

    public static void showToast(String s, Context context)
    {
        Toast.makeText(context, s, 1).show();
    }

    public static Bundle unpackUrl(String s)
    {
        Bundle bundle = new Bundle();
        if (s == null) goto _L2; else goto _L1
_L1:
        String as[];
        int i;
        int j;
        as = s.split("&");
        i = as.length;
        j = 0;
_L5:
        if (j < i) goto _L3; else goto _L2
_L2:
        return bundle;
_L3:
        String as1[] = as[j].split("=");
        try
        {
            bundle.putString(URLDecoder.decode(as1[0], "UTF-8"), URLDecoder.decode(as1[1], "UTF-8"));
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            unsupportedencodingexception.printStackTrace();
        }
        j++;
        if (true) goto _L5; else goto _L4
_L4:
    }




}
