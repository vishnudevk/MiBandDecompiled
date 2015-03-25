// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.b.b;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.telephony.NeighboringCellInfo;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public final class s
{

    public static String a = "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567";
    public static int b[] = {
        0, 49345, 49537, 320, 49921, 960, 640, 49729, 50689, 1728, 
        1920, 51009, 1280, 50625, 50305, 1088, 52225, 3264, 3456, 52545, 
        3840, 53185, 52865, 3648, 2560, 51905, 52097, 2880, 51457, 2496, 
        2176, 51265, 55297, 6336, 6528, 55617, 6912, 56257, 55937, 6720, 
        7680, 57025, 57217, 8000, 56577, 7616, 7296, 56385, 5120, 54465, 
        54657, 5440, 55041, 6080, 5760, 54849, 53761, 4800, 4992, 54081, 
        4352, 53697, 53377, 4160, 61441, 12480, 12672, 61761, 13056, 62401, 
        62081, 12864, 13824, 63169, 63361, 14144, 62721, 13760, 13440, 62529, 
        15360, 64705, 64897, 15680, 65281, 16320, 16000, 65089, 64001, 15040, 
        15232, 64321, 14592, 63937, 63617, 14400, 10240, 59585, 59777, 10560, 
        60161, 11200, 10880, 59969, 60929, 11968, 12160, 61249, 11520, 60865, 
        60545, 11328, 58369, 9408, 9600, 58689, 9984, 59329, 59009, 9792, 
        8704, 58049, 58241, 9024, 57601, 8640, 8320, 57409, 40961, 24768, 
        24960, 41281, 25344, 41921, 41601, 25152, 26112, 42689, 42881, 26432, 
        42241, 26048, 25728, 42049, 27648, 44225, 44417, 27968, 44801, 28608, 
        28288, 44609, 43521, 27328, 27520, 43841, 26880, 43457, 43137, 26688, 
        30720, 47297, 47489, 31040, 47873, 31680, 31360, 47681, 48641, 32448, 
        32640, 48961, 32000, 48577, 48257, 31808, 46081, 29888, 30080, 46401, 
        30464, 47041, 46721, 30272, 29184, 45761, 45953, 29504, 45313, 29120, 
        28800, 45121, 20480, 37057, 37249, 20800, 37633, 21440, 21120, 37441, 
        38401, 22208, 22400, 38721, 21760, 38337, 38017, 21568, 39937, 23744, 
        23936, 40257, 24320, 40897, 40577, 24128, 23040, 39617, 39809, 23360, 
        39169, 22976, 22656, 38977, 34817, 18624, 18816, 35137, 19200, 35777, 
        35457, 19008, 19968, 36545, 36737, 20288, 36097, 19904, 19584, 35905, 
        17408, 33985, 34177, 17728, 34561, 18368, 18048, 34369, 33281, 17088, 
        17280, 33601, 16640, 33217, 32897, 16448
    };

    public static double a(double d, int i)
    {
        if (Double.isNaN(d))
        {
            return 0.0D;
        }
        double d1;
        try
        {
            d1 = BigDecimal.valueOf(d).setScale(i, RoundingMode.HALF_DOWN).doubleValue();
        }
        catch (Exception exception)
        {
            return 0.0D;
        }
        return d1;
    }

    public static int a(char c1)
    {
        int i = 256;
        if (c1 >= 'A' && c1 <= 'Z')
        {
            i = c1 - 65;
        }
        if (c1 >= 'a' && c1 <= 'z')
        {
            i = 64 + (c1 - 97);
        }
        if (c1 >= '0' && c1 <= '9')
        {
            i = -48 + (c1 + 128);
        }
        return i;
    }

    private static String a(int i, int j, int k, int l, int i1, int j1, int k1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("{");
        stringbuilder.append("\"mcc\":");
        stringbuilder.append(i);
        stringbuilder.append(",\"mnc\":");
        stringbuilder.append(j);
        stringbuilder.append(",\"lac\":");
        stringbuilder.append(k);
        stringbuilder.append(",\"cellid\":");
        stringbuilder.append(l);
        stringbuilder.append(",\"rss\":");
        stringbuilder.append(i1);
        if (j1 != 0x7fffffff && k1 != 0x7fffffff)
        {
            stringbuilder.append(",\"stationLat\":");
            Object aobj[] = new Object[1];
            aobj[0] = Float.valueOf((float)j1 / 14400F);
            stringbuilder.append(String.format("%.6f", aobj));
            stringbuilder.append(",\"stationLng\":");
            Object aobj1[] = new Object[1];
            aobj1[0] = Float.valueOf((float)k1 / 14400F);
            stringbuilder.append(String.format("%.6f", aobj1));
        }
        stringbuilder.append("}");
        return stringbuilder.toString();
    }

    public static String a(e.a a1)
    {
        if (a1.b() == null)
        {
            return "{}";
        } else
        {
            Location location = a1.b();
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("{");
            stringbuilder.append("\"latitude\":");
            stringbuilder.append(location.getLatitude());
            stringbuilder.append(",\"longitude\":");
            stringbuilder.append(location.getLongitude());
            stringbuilder.append(",\"additional\":");
            stringbuilder.append((new StringBuilder("\"")).append(location.getAltitude()).append(",").append(location.getAccuracy()).append(",").append(location.getBearing()).append(",").append(location.getSpeed()).append(",").append(location.getTime()).append("\"").toString());
            stringbuilder.append("}");
            return stringbuilder.toString();
        }
    }

    public static String a(f.b b1)
    {
        if (b1 == null || b1.a() == null)
        {
            return "[]";
        }
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("[");
        if (b1.a() == null || b1.a().size() <= 0)
        {
            stringbuilder.append("]");
            return stringbuilder.toString();
        }
        List list = b1.a();
        Iterator iterator = list.iterator();
        int i = 0;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ScanResult scanresult = (ScanResult)iterator.next();
            int j = list.size();
            int k = scanresult.level;
            byte byte0;
            boolean flag;
            if (j < 6)
            {
                byte0 = -95;
            } else
            {
                byte0 = -90;
            }
            if (k < byte0)
            {
                flag = false;
            } else
            {
                flag = true;
            }
            if (flag)
            {
                if (i > 0)
                {
                    stringbuilder.append(",");
                }
                stringbuilder.append("{\"mac\":\"").append(scanresult.BSSID).append("\",");
                stringbuilder.append("\"rssi\":").append(scanresult.level).append("}");
                i++;
            }
        } while (true);
        stringbuilder.append("]");
        return stringbuilder.toString();
    }

    public static String a(m.b b1, List list)
    {
        StringBuilder stringbuilder;
        int i;
        int j;
        int k;
        if (b1 == null)
        {
            return "[]";
        }
        stringbuilder = new StringBuilder();
        stringbuilder.append("[");
        i = b1.b;
        j = b1.c;
        boolean flag = a(b1.a, i, j, b1.d, b1.e);
        k = 0;
        if (flag)
        {
            stringbuilder.append(a(i, j, b1.d, b1.e, b1.f, b1.g, b1.h));
            k = 1;
        }
        if (list == null) goto _L2; else goto _L1
_L1:
        Method method;
        Iterator iterator;
        method = Class.forName("android.telephony.NeighboringCellInfo").getMethod("getLac", new Class[0]);
        iterator = list.iterator();
_L5:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        NeighboringCellInfo neighboringcellinfo;
        int l;
        neighboringcellinfo = (NeighboringCellInfo)iterator.next();
        l = Integer.parseInt(method.invoke(neighboringcellinfo, new Object[0]).toString());
        if (!a(b1.a, i, j, l, neighboringcellinfo.getCid()))
        {
            break MISSING_BLOCK_LABEL_272;
        }
        if (k <= 0)
        {
            break MISSING_BLOCK_LABEL_205;
        }
        stringbuilder.append(",");
        stringbuilder.append(a(i, j, l, neighboringcellinfo.getCid(), -113 + (neighboringcellinfo.getRssi() << 1), 0x7fffffff, 0x7fffffff));
        int i1 = k + 1;
_L6:
        k = i1;
          goto _L5
        Exception exception;
        exception;
_L4:
        list.clear();
_L2:
        stringbuilder.append("]");
        return stringbuilder.toString();
        i1 = k;
          goto _L6
    }

    public static String a(String s1, String s2, String s3, String s4, boolean flag)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("{");
        stringbuilder.append("\"imei\":\"");
        stringbuilder.append(s1);
        stringbuilder.append("\",\"imsi\":\"");
        stringbuilder.append(s2);
        stringbuilder.append("\",\"phonenum\":\"");
        stringbuilder.append(s3);
        stringbuilder.append("\",\"roaming\":\"");
        stringbuilder.append(flag);
        stringbuilder.append("\",\"qq\":\"");
        stringbuilder.append(s4);
        stringbuilder.append("\"");
        stringbuilder.append("}");
        return stringbuilder.toString();
    }

    public static boolean a(int i, int j, int k, int l, int i1)
    {
        boolean flag = true;
        if (i == 2)
        {
            if (j < 0 || k < 0 || l < 0 || l > 65535 || i1 < 0 || i1 > 65535 || k == 0 && l == 0 && i1 == 0)
            {
                flag = false;
            }
        } else
        {
            if (j < 0 || k < 0 || l <= 0 || l >= 65535)
            {
                return false;
            }
            if (i1 == 0xfffffff || i1 == 0x7fffffff || i1 == 0x3040101 || i1 == 65535 || i1 == 8 || i1 == 10 || i1 == 33 || i1 <= 0)
            {
                return false;
            }
        }
        return flag;
    }

    public static boolean a(String s1)
    {
        while (s1 == null || s1.length() > 32 || s1.length() < 6 || !Pattern.compile("[a-zA-Z0-9_]{6,32}").matcher(s1).matches()) 
        {
            return false;
        }
        return true;
    }

    public static boolean b(String s1)
    {
        while (s1 == null || s1.length() != 29 || !Pattern.compile("([A-Z2-7]{5}){1}(-[A-Z2-7]{5}){4}").matcher(s1).matches()) 
        {
            return false;
        }
        return true;
    }

    public static boolean c(String s1)
    {
        JSONObject jsonobject = new JSONObject(s1);
        boolean flag;
        if (s1.contains("latitude"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
label0:
        {
            boolean flag1;
            int i;
            boolean flag2;
            boolean flag3;
            if (jsonobject.getJSONArray("cells").length() > 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            try
            {
                i = jsonobject.getJSONArray("wifis").length();
            }
            catch (Exception exception)
            {
                return false;
            }
            if (i > 0)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (!flag && !flag1)
            {
                flag3 = false;
                if (!flag2)
                {
                    break label0;
                }
            }
            flag3 = true;
        }
        return flag3;
    }

    static 
    {
        new int[] {
            0x16dbd, 0x18627, 0x137e3, 0x12515, 59699, 55667, 46867, 38039
        };
    }
}
