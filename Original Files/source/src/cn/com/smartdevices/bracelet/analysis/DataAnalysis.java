// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.analysis;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.model.DaySportData;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.model.SportData;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

// Referenced classes of package cn.com.smartdevices.bracelet.analysis:
//            c, ActiveItem, b, StageSteps, 
//            SleepInfo, StepsInfo

public class DataAnalysis
{

    public static boolean DEBUG = false;
    private static final int a = 30;
    private static final int b = 3;
    private static final int c = 5;
    private static final int d = 10;
    private static final int e = 30;
    private static final int f = 15;
    private static final int g = 20;
    private static final double h = 0.41999999999999998D;
    private static final double i[][] = {
        {
            2D, 2D
        }, {
            2.5D, 2.2000000000000002D
        }, {
            3D, 2.5D
        }, {
            3.5D, 3D
        }, {
            5D, 4D
        }, {
            6.2999999999999998D, 4.5D
        }, {
            8D, 5D
        }, {
            10D, 6D
        }, {
            13D, 7D
        }, {
            15.5D, 8D
        }, {
            18D, 9D
        }
    };
    private static final double j[][] = {
        {
            40.232999999999997D, 0.94999999999999996D
        }, {
            53.645000000000003D, 1.1899999999999999D
        }, {
            67.055999999999997D, 1.4099999999999999D
        }, {
            80.466999999999999D, 1.5700000000000001D
        }, {
            93.878D, 1.78D
        }, {
            107.29000000000001D, 2.3599999999999999D
        }, {
            120.7D, 2.9700000000000002D
        }, {
            134.11000000000001D, 3.79D
        }, {
            160.94D, 4.6699999999999999D
        }, {
            187.75999999999999D, 5.2400000000000002D
        }, {
            214.58000000000001D, 5.6200000000000001D
        }, {
            241.40000000000001D, 6.0999999999999996D
        }, {
            268.23000000000002D, 6.9100000000000001D
        }, {
            295.05000000000001D, 7.6200000000000001D
        }, {
            321.87D, 9.0500000000000007D
        }, {
            348.69D, 9.4299999999999997D
        }, {
            375.51999999999998D, 10.949999999999999D
        }
    };

    public DataAnalysis()
    {
    }

    private static int a(ArrayList arraylist, int ai[], int ai1[], int k, int l)
    {
        int i1 = ai.length;
        int j1 = 0;
        int k1 = 0;
        while (k <= l) 
        {
            int l1 = ((SportData)arraylist.get(k)).getActivity();
            int i2;
            if (l1 < 20)
            {
                if (l1 < 2)
                {
                    i2 = 0;
                } else
                {
                    i2 = 2;
                }
            }
            for (i2 = 1; k1 > 0 && i2 != ai[k1]; k1 = ai1[k1 - 1]) { }
            int j2;
            int l2;
            int i3;
            if (i2 == ai[k1])
            {
                j2 = k1 + 1;
            } else
            {
                j2 = k1;
            }
            if (j2 == i1)
            {
                int j3 = ai1[j2 - 1];
                i3 = j1 + 1;
                l2 = j3;
            } else
            {
                int k2 = j1;
                l2 = j2;
                i3 = k2;
            }
            k++;
            k1 = l2;
            j1 = i3;
        }
        return j1;
    }

    private static c a(ArrayList arraylist, int k, int l, SharedPreferences sharedpreferences, boolean flag, int i1, boolean flag1, boolean flag2, 
            cn.com.smartdevices.bracelet.chart.util.ChartData.UserSleepModify usersleepmodify, int j1)
    {
        ArrayList arraylist1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        arraylist1 = new ArrayList();
        int k45;
        int l45;
        if (flag2)
        {
            k1 = 1440;
        } else
        {
            k1 = 2880;
        }
        l1 = 0;
        i2 = 0;
        if (usersleepmodify == null) goto _L2; else goto _L1
_L1:
        k45 = usersleepmodify.sleepStart;
        l1 = 0;
        i2 = 0;
        if (k45 >= -1440)
        {
            l45 = usersleepmodify.sleepStart;
            l1 = 0;
            i2 = 0;
            if (l45 <= 1440)
            {
                int i46;
                if (flag2)
                {
                    if (usersleepmodify.sleepStart >= 0)
                    {
                        i46 = usersleepmodify.sleepStart;
                    } else
                    {
                        i46 = 0;
                    }
                } else
                {
                    i46 = j1 + usersleepmodify.sleepStart;
                }
                i2 = i46;
                l1 = 1;
            }
        }
        if (usersleepmodify.sleepEnd < -1440 || usersleepmodify.sleepEnd > 1440) goto _L2; else goto _L3
_L3:
        if (flag2)
        {
            if (usersleepmodify.sleepEnd < arraylist.size())
            {
                k1 = usersleepmodify.sleepEnd;
            } else
            {
                k1 = -1 + arraylist.size();
            }
        } else
        {
            k1 = j1 + usersleepmodify.sleepEnd;
        }
        l1 += 2;
        if (k1 <= 0) goto _L2; else goto _L4
_L4:
        k1--;
        j2 = i2;
        k2 = l1;
_L99:
        if (DEBUG)
        {
            Debug.i("sleepanalyze", (new StringBuilder()).append("form ").append(k).append("->").append(l).toString());
        }
        int l2 = Math.min(l, arraylist.size());
        int i3 = l2 - 1;
        do
        {
            if (i3 <= k || ((SportData)arraylist.get(i3)).getSportMode() != 126)
            {
                int j3 = 0;
                int k3 = k;
                int l3 = 0;
                int i4 = k;
                while (i4 < i3) 
                {
                    SportData sportdata1 = (SportData)arraylist.get(i4);
                    int j45;
                    if (sportdata1.getStep() > 0 && sportdata1.getActivity() >= 60)
                    {
                        j45 = l3 + 1;
                        j3 = i4;
                    } else
                    if (sportdata1.getActivity() >= 6)
                    {
                        j45 = l3 + 1;
                    } else
                    {
                        int j4;
                        int k4;
                        int l4;
                        int i5;
                        int j5;
                        int k5;
                        int l5;
                        int i6;
                        boolean flag3;
                        int j6;
                        int k6;
                        int l6;
                        int i7;
                        int j7;
                        int k7;
                        int l7;
                        int i8;
                        int j8;
                        int k8;
                        int l8;
                        int i9;
                        int j9;
                        int k9;
                        int l9;
                        int i10;
                        int j10;
                        int k10;
                        int l10;
                        int i11;
                        ArrayList arraylist2;
                        int j11;
                        int k11;
                        int l11;
                        int i12;
                        int j12;
                        int k12;
                        int l12;
                        int i13;
                        int j13;
                        int k13;
                        int l13;
                        int i14;
                        int j14;
                        int k14;
                        int l14;
                        boolean flag4;
                        int i15;
                        boolean flag5;
                        int j15;
                        int k15;
                        int l15;
                        int i16;
                        int j16;
                        int k16;
                        int l16;
                        int i17;
                        int j17;
                        int k17;
                        int l17;
                        int i18;
                        int j18;
                        int k18;
                        int l18;
                        int i19;
                        int j19;
                        int k19;
                        int l19;
                        HashMap hashmap;
                        HashMap hashmap1;
                        int i20;
                        int j20;
                        int k20;
                        int l20;
                        int i21;
                        int j21;
                        int k21;
                        int l21;
                        int i22;
                        int j22;
                        int k22;
                        int l22;
                        HashMap hashmap2;
                        int i23;
                        int j23;
                        int k23;
                        int l23;
                        int i24;
                        int j24;
                        int k24;
                        HashMap hashmap3;
                        int l24;
                        int i25;
                        int j25;
                        int k25;
                        int l25;
                        int i26;
                        int j26;
                        int k26;
                        int l26;
                        int i27;
                        HashMap hashmap4;
                        int j27;
                        int k27;
                        int l27;
                        int i28;
                        HashMap hashmap5;
                        int j28;
                        int k28;
                        int l28;
                        int i29;
                        int j29;
                        int k29;
                        HashMap hashmap6;
                        HashMap hashmap7;
                        int l29;
                        int i30;
                        int j30;
                        int k30;
                        int l30;
                        int i31;
                        int j31;
                        int k31;
                        ArrayList arraylist3;
                        int l31;
                        int i32;
                        int j32;
                        HashMap hashmap8;
                        int k32;
                        int l32;
                        ArrayList arraylist4;
                        int i33;
                        int j33;
                        int k33;
                        int l33;
                        HashMap hashmap9;
                        int i34;
                        HashMap hashmap10;
                        int j34;
                        int k34;
                        int l34;
                        int i35;
                        int j35;
                        int k35;
                        int l35;
                        int i36;
                        int j36;
                        int k36;
                        int l36;
                        HashMap hashmap11;
                        int i37;
                        int j37;
                        int k37;
                        int l37;
                        int i38;
                        int j38;
                        int k38;
                        int l38;
                        int i39;
                        int j39;
                        HashMap hashmap12;
                        int k39;
                        int l39;
                        int i40;
                        int j40;
                        int k40;
                        int l40;
                        int i41;
                        int j41;
                        int k41;
                        int l41;
                        int i42;
                        int j42;
                        HashMap hashmap13;
                        int k42;
                        int l42;
                        int i43;
                        int j43;
                        int k43;
                        int l43;
                        int i44;
                        int j44;
                        SportData sportdata;
                        int k44;
                        int l44;
                        int i45;
                        if (l3 > 9)
                        {
                            b(arraylist, k3, -1 + (i4 - l3));
                            a(arraylist, i4 - l3, i4 - 1);
                            l44 = 0;
                            k44 = i4;
                        } else
                        if (j3 > 0)
                        {
                            b(arraylist, k3, -1 + (i4 - l3));
                            a(arraylist, i4 - l3, i4 - 1);
                            k44 = i4;
                            l44 = 0;
                        } else
                        {
                            k44 = k3;
                            l44 = j3;
                        }
                        i45 = k44;
                        j3 = l44;
                        k3 = i45;
                        j45 = 0;
                    }
                    i4++;
                    l3 = j45;
                }
                break;
            }
            i3--;
        } while (true);
        if (l3 > 9)
        {
            b(arraylist, k3, -1 + (i4 - l3));
            a(arraylist, i4 - l3, i4 - 1);
            j4 = i4;
        } else
        if (j3 > 0)
        {
            b(arraylist, k3, -1 + (i4 - l3));
            a(arraylist, i4 - l3, i4 - 1);
            j4 = i4;
        } else
        {
            j4 = k3;
        }
        if (!flag1) goto _L6; else goto _L5
_L5:
        l43 = 0;
        i44 = j4;
_L16:
        if (i44 >= i3)
        {
            break MISSING_BLOCK_LABEL_6607;
        }
        sportdata = (SportData)arraylist.get(i44);
        if (sportdata.getStep() <= 0 || sportdata.getActivity() < 60) goto _L8; else goto _L7
_L7:
        j44 = 10;
_L15:
        if (j44 <= 9)
        {
            b(arraylist, j4, i3);
        }
_L6:
        if (DEBUG)
        {
            Debug.i("sleepAnalyze", "do Analyze");
        }
        k4 = k + 1;
        l4 = k;
_L13:
        if (k4 >= l2) goto _L10; else goto _L9
_L9:
        i40 = ((SportData)arraylist.get(k4 - 1)).getSportMode();
        j40 = ((SportData)arraylist.get(k4)).getSportMode();
        if (i40 == 5 || i40 == 4 || j40 != 5 && j40 != 4) goto _L12; else goto _L11
_L11:
        k40 = k4;
_L39:
        k4++;
        l4 = k40;
          goto _L13
_L8:
        if (sportdata.getActivity() < 6)
        {
            break MISSING_BLOCK_LABEL_756;
        }
        j44 = l43 + 1;
        if (j44 > 9) goto _L15; else goto _L14
_L14:
        i44++;
        l43 = j44;
          goto _L16
        j44 = 0;
          goto _L14
_L12:
        if (i40 != 5 && i40 != 4 || j40 == 4 || j40 == 5) goto _L18; else goto _L17
_L17:
        l40 = 0;
        i41 = l4;
_L40:
        if (i41 >= k4 - 1) goto _L20; else goto _L19
_L19:
        if (((SportData)arraylist.get(i41)).getActivity() >= 6) goto _L22; else goto _L21
_L21:
        j41 = l40 + 1;
        if (j41 < 5) goto _L24; else goto _L23
_L23:
        k41 = 1 + (i41 - j41);
        if (k41 < 0)
        {
            l41 = 0;
        } else
        {
            l41 = k41;
        }
        a(arraylist, l4, l41 - 1);
        i42 = k4 - 1;
        if (1 + (i42 - l41) < 120) goto _L26; else goto _L25
_L25:
        i43 = 0;
        j43 = i42;
_L41:
        if (j43 < l41) goto _L28; else goto _L27
_L27:
        if (((SportData)arraylist.get(j43)).getActivity() >= 6) goto _L30; else goto _L29
_L29:
        k43 = i43 + 1;
        if (k43 < 5) goto _L32; else goto _L31
_L31:
        i42 = -1 + (k43 + j43);
        a(arraylist, i42 + 1, k4 - 1);
_L26:
        j42 = i42;
        if (j42 - l41 < 15) goto _L34; else goto _L33
_L33:
        hashmap13 = new HashMap();
        hashmap13.put("start", Integer.valueOf(l41));
        hashmap13.put("stop", Integer.valueOf(j42));
        hashmap13.put("reset", Integer.valueOf(0));
        k42 = l4;
_L42:
        if (k42 >= k && ((SportData)arraylist.get(k42)).getStep() <= 0 && ((SportData)arraylist.get(k42)).getSportMode() != 126) goto _L36; else goto _L35
_L35:
        hashmap13.put("startBed", Integer.valueOf(k42 + 1));
        l42 = k4;
_L43:
        if (l42 <= l && ((SportData)arraylist.get(l42)).getStep() <= 0 && ((SportData)arraylist.get(l42)).getSportMode() != 126) goto _L38; else goto _L37
_L37:
        hashmap13.put("stopBed", Integer.valueOf(l42 - 1));
        arraylist1.add(hashmap13);
        if (DEBUG)
        {
            Debug.i("sleepAnalyze", (new StringBuilder()).append("item:").append(l41).append("->").append(j42).toString());
        }
        k40 = l4;
          goto _L39
_L22:
        j41 = 0;
_L24:
        i41++;
        l40 = j41;
          goto _L40
_L30:
        k43 = 0;
_L32:
        j43--;
        i43 = k43;
          goto _L41
_L36:
        k42--;
          goto _L42
_L38:
        l42++;
          goto _L43
_L34:
        if (j42 - l41 >= 0)
        {
            a(arraylist, l41, j42);
        }
_L18:
        k40 = l4;
          goto _L39
_L10:
        if (DEBUG)
        {
            Debug.i("sleepAnalyze", (new StringBuilder()).append("Sleep sections=").append(arraylist1.size()).toString());
        }
        if (arraylist1.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_6568;
        }
        k9 = i1 + 1920;
        l9 = i1 + 1380;
        i10 = i1 + 1440;
        if (l9 < 0)
        {
            j10 = 0;
        } else
        {
            j10 = l9;
        }
        if (DEBUG)
        {
            Debug.i("sleepAnalyze", (new StringBuilder()).append("Use Ref: ").append(j2).append("->").append(k1).toString());
        }
        Log.i("sleepAnalyze", (new StringBuilder()).append("Use Ref: ").append(j2).append("->").append(k1).append(", hasRef=").append(0).toString());
        if (arraylist1.size() < 2)
        {
            k10 = arraylist1.size();
        } else
        {
            k10 = 2;
        }
        l10 = 0;
        if (l10 >= k10) goto _L45; else goto _L44
_L44:
        j37 = 0;
        k37 = 0;
        for (l37 = 0; l37 < arraylist1.size(); l37++)
        {
            hashmap12 = (HashMap)arraylist1.get(l37);
            k39 = Integer.parseInt(hashmap12.get("start").toString());
            l39 = 1 + (Integer.parseInt(hashmap12.get("stop").toString()) - k39);
            if (l39 > k37 && k39 < k9)
            {
                k37 = l39;
                j37 = l37;
            }
        }

        i38 = 0;
        if (DEBUG)
        {
            Debug.i("sleepAnalyze", (new StringBuilder()).append("maxSec=").append(j37).append(",maxS=").append(k37).toString());
        }
        j38 = Integer.parseInt(((HashMap)arraylist1.get(j37)).get("start").toString());
        k38 = Integer.parseInt(((HashMap)arraylist1.get(j37)).get("stop").toString());
        l38 = j38;
        while (l38 <= k38) 
        {
            if (((SportData)arraylist.get(l38)).getSportMode() == 5)
            {
                j39 = i38 + 1;
            } else
            {
                j39 = i38;
            }
            l38++;
            i38 = j39;
        }
        if (DEBUG)
        {
            Debug.i("sleepAnalyze", (new StringBuilder()).append("maxSec:").append(j38).append("->").append(k38).append(",nrem=").append(i38).toString());
        }
        if (((double)i38 >= 0.97999999999999998D * (double)k37 || (double)i38 <= 0.65000000000000002D * (double)k37) && k37 > 0 && true) goto _L47; else goto _L46
_L46:
        if (k37 > 0)
        {
            i39 = (i38 * 100) / k37;
        } else
        {
            i39 = 85;
        }
        i11 = i39;
_L97:
        if (DEBUG)
        {
            Debug.i("sleepAnalyze", (new StringBuilder()).append("quality ref=").append(i11).toString());
        }
        arraylist2 = new ArrayList();
        j11 = 0;
_L49:
        if (j11 >= arraylist1.size())
        {
            break; /* Loop/switch isn't completed */
        }
        hashmap7 = (HashMap)arraylist1.get(j11);
        l29 = Integer.parseInt(hashmap7.get("start").toString());
        i30 = Integer.parseInt(hashmap7.get("stop").toString());
        j30 = 1 + (i30 - l29);
        if (j30 < 15)
        {
            if (DEBUG)
            {
                Debug.i("sleepAnalyze", (new StringBuilder()).append("del ").append(j11).toString());
            }
            arraylist2.add(Integer.valueOf(j11));
        } else
        {
label0:
            {
                ((HashMap)arraylist1.get(j11)).put("refmode", Integer.valueOf(0));
                Debug.i("sleepAnalyze", (new StringBuilder()).append("hasRef=").append(0).append(",refMode=").append(0).toString());
                Log.i("sleepAnalyze", (new StringBuilder()).append(l29).append("->").append(i30).append(",hasRef=").append(0).append(",refMode=").append(0).toString());
                k30 = 0;
                l30 = 0;
                i31 = l29;
                while (i31 <= i30) 
                {
                    if (((SportData)arraylist.get(i31)).getSportMode() == 5)
                    {
                        l30++;
                    }
                    if (((SportData)arraylist.get(i31)).getActivity() >= 15)
                    {
                        i37 = k30 + 1;
                    } else
                    {
                        i37 = k30;
                    }
                    i31++;
                    k30 = i37;
                }
                if (DEBUG)
                {
                    Debug.i("sleepAnalyze", (new StringBuilder()).append("Sec").append(j11).append(":").append(l29).append("->").append(i30).append(" nrem=").append(l30).append(" quality=").append((l30 * 100) / j30).append(",activeNum=").append(k30).toString());
                }
                if (i11 >= 75)
                {
                    i11 - 5;
                }
                if (i11 <= 92)
                {
                    i11 + 5;
                }
                if (i11 < 85)
                {
                    j31 = 70;
                } else
                {
                    j31 = i11 - 15;
                }
                if (i11 <= 87)
                {
                    i11 + 10;
                }
                k31 = (l30 * 100) / j30;
                if ((j30 < 100 || k31 >= j31 && k31 < 98) && (j30 >= 100 || k31 >= j31 && k31 < 98) || j11 == -1 + arraylist1.size())
                {
                    break label0;
                }
                if (DEBUG)
                {
                    Debug.i("sleepAnalyze", (new StringBuilder()).append("del ").append(j11).toString());
                }
                arraylist2.add(Integer.valueOf(j11));
            }
        }
_L57:
        j11++;
        if (true) goto _L49; else goto _L48
_L47:
        if (DEBUG)
        {
            Debug.i("sleepAnalyze", (new StringBuilder()).append("del MAX ").append(j37).toString());
        }
        a(arraylist, j38, k38);
        arraylist1.remove(j37);
        l10++;
        break MISSING_BLOCK_LABEL_1411;
        arraylist3 = new ArrayList();
        l31 = l29 + 1;
        i32 = l29;
        while (l31 <= i30) 
        {
            if (((SportData)arraylist.get(l31)).getSportMode() != ((SportData)arraylist.get(l31 - 1)).getSportMode())
            {
                l36 = ((SportData)arraylist.get(i32)).getSportMode();
                if (l36 == 5 && l31 - i32 < 10)
                {
                    l36 = 4;
                    a(arraylist, i32, l31 - 1, l36);
                }
                hashmap11 = new HashMap();
                hashmap11.put("start", Integer.valueOf(i32));
                hashmap11.put("stop", Integer.valueOf(l31 - 1));
                hashmap11.put("mode", Integer.valueOf(l36));
                arraylist3.add(hashmap11);
                k36 = l31;
            } else
            {
                k36 = i32;
            }
            l31++;
            i32 = k36;
        }
        j32 = ((SportData)arraylist.get(i32)).getSportMode();
        if (j32 == 5 && (i30 + 1) - i32 < 10)
        {
            j32 = 4;
            a(arraylist, i32, i30, j32);
        }
        hashmap8 = new HashMap();
        hashmap8.put("start", Integer.valueOf(i32));
        hashmap8.put("stop", Integer.valueOf(i30));
        hashmap8.put("mode", Integer.valueOf(j32));
        arraylist3.add(hashmap8);
        k32 = 0;
        l32 = 0;
        while (l32 < arraylist3.size()) 
        {
            i35 = ((Integer)((HashMap)arraylist3.get(l32)).get("start")).intValue();
            j35 = ((Integer)((HashMap)arraylist3.get(l32)).get("stop")).intValue();
            k35 = ((Integer)((HashMap)arraylist3.get(l32)).get("mode")).intValue();
            l35 = 1 + (j35 - i35);
            if (k35 != 7)
            {
                if (k35 == 5 && l35 > k32)
                {
                    k32 = l35;
                }
                if ((k35 == 4 || k35 == 5) && k35 == 4 && l35 < 10 && l32 > 0 && l32 < -1 + arraylist3.size())
                {
                    i36 = ((Integer)((HashMap)arraylist3.get(l32 - 1)).get("mode")).intValue();
                    j36 = ((Integer)((HashMap)arraylist3.get(l32 + 1)).get("mode")).intValue();
                    if (i36 == 5 && j36 == 5)
                    {
                        a(arraylist, i35, j35, 5);
                    }
                }
            }
            l32++;
        }
        arraylist4 = new ArrayList();
        i33 = 0;
        j33 = 0;
        k33 = l29 + 1;
        l33 = l29;
        if (k33 > i30) goto _L51; else goto _L50
_L50:
        if (((SportData)arraylist.get(k33)).getSportMode() == ((SportData)arraylist.get(k33 - 1)).getSportMode()) goto _L53; else goto _L52
_L52:
        hashmap10 = new HashMap();
        hashmap10.put("start", Integer.valueOf(l33));
        hashmap10.put("stop", Integer.valueOf(k33 - 1));
        hashmap10.put("mode", Integer.valueOf(((SportData)arraylist.get(l33)).getSportMode()));
        arraylist4.add(hashmap10);
        if (((SportData)arraylist.get(l33)).getSportMode() != 5) goto _L55; else goto _L54
_L54:
        i33++;
        if (k33 - l33 <= j33) goto _L55; else goto _L56
_L56:
        j34 = k33 - l33;
        k34 = i33;
_L95:
        l34 = k33;
_L96:
        k33++;
        l33 = l34;
        i33 = k34;
        j33 = j34;
        break MISSING_BLOCK_LABEL_2972;
_L51:
        hashmap9 = new HashMap();
        hashmap9.put("start", Integer.valueOf(l33));
        hashmap9.put("stop", Integer.valueOf(i30));
        hashmap9.put("mode", Integer.valueOf(((SportData)arraylist.get(l33)).getSportMode()));
        arraylist4.add(hashmap9);
        if (((SportData)arraylist.get(l33)).getSportMode() == 5)
        {
            i33++;
            if (1 + (i30 - l33) > j33)
            {
                j33 = 1 + (i30 - l33);
            }
        }
        if (DEBUG)
        {
            Debug.i("sleepAnalyze", (new StringBuilder()).append("total=").append(arraylist4.size()).append(",maxnrem=").append(k32).append(",nremNum=").append(i33).append(",size=").append(j30).append(",quality=").append(k31).append(",maxnrem2=").append(j33).toString());
        }
        if (arraylist4.size() <= 1 || k32 > 150 || k32 > 120 && i33 <= 1 || i33 <= 1 && j30 >= 120 && k31 > 95 || i33 > j30 / 20 && j30 >= 60 || (k30 * 100) / j30 >= 40 || (k30 * 100) / j30 <= 1 && j30 >= 60)
        {
            i34 = a(arraylist, new int[] {
                0, 1, 0
            }, new int[] {
                0, 0, 1
            }, l29, i30);
            if (j11 == -1 + arraylist1.size() && j30 < 120 && k31 > 60 && l29 < k9 || i34 > 0 && i33 > 0 && k31 < 97 && (k30 * 100) / j30 < 40)
            {
                if (DEBUG)
                {
                    Debug.i("sleepAnalyze", "not del last");
                }
            } else
            {
                if (DEBUG)
                {
                    Debug.i("sleepAnalyze", (new StringBuilder()).append("del ").append(j11).toString());
                }
                arraylist2.add(Integer.valueOf(j11));
            }
        }
          goto _L57
_L48:
        if (arraylist2.size() > 0)
        {
            for (j29 = -1 + arraylist2.size(); j29 >= 0; j29--)
            {
                k29 = Integer.parseInt(arraylist2.get(j29).toString());
                hashmap6 = (HashMap)arraylist1.get(k29);
                a(arraylist, Integer.parseInt(hashmap6.get("start").toString()), Integer.parseInt(hashmap6.get("stop").toString()));
                arraylist1.remove(k29);
            }

        }
        k11 = arraylist1.size();
        if (k11 > 1)
        {
            j20 = 0;
            k20 = 0;
            l20 = 0;
            while (l20 < k11) 
            {
                hashmap5 = (HashMap)arraylist1.get(l20);
                j28 = Integer.parseInt(hashmap5.get("start").toString());
                k28 = 1 + (Integer.parseInt(hashmap5.get("stop").toString()) - j28);
                if (k28 > j20)
                {
                    i29 = k28;
                    l28 = l20;
                } else
                {
                    l28 = k20;
                    i29 = j20;
                }
                l20++;
                j20 = i29;
                k20 = l28;
            }
            if (Integer.parseInt(((HashMap)arraylist1.get(k20)).get("start").toString()) > k9 && j20 < 180)
            {
                k26 = 0;
                l26 = 0;
                i27 = 0;
                while (i27 < k11) 
                {
                    hashmap4 = (HashMap)arraylist1.get(i27);
                    j27 = Integer.parseInt(hashmap4.get("start").toString());
                    k27 = 1 + (Integer.parseInt(hashmap4.get("stop").toString()) - j27);
                    if (k27 > k26 && j27 < k9)
                    {
                        i28 = k27;
                        l27 = i27;
                    } else
                    {
                        l27 = l26;
                        i28 = k26;
                    }
                    i27++;
                    k26 = i28;
                    l26 = l27;
                }
                if (k26 > 0)
                {
                    k20 = l26;
                }
            }
            i21 = Integer.parseInt(((HashMap)arraylist1.get(k20)).get("stop").toString());
            j21 = 0;
            k21 = k20 + 1;
            while (k21 < k11) 
            {
                hashmap3 = (HashMap)arraylist1.get(k21);
                l24 = Integer.parseInt(hashmap3.get("start").toString());
                i25 = Integer.parseInt(hashmap3.get("stop").toString());
                j25 = Integer.parseInt(hashmap3.get("refmode").toString());
                k25 = 1 + (l24 - i21);
                l25 = 1 + (i25 - l24);
                if ((k25 > l25 && (i25 >= k9 || l24 <= j10) || k25 >= l25 * 2) && j25 == 0)
                {
                    if (DEBUG)
                    {
                        Debug.i("sleepAnalyze", (new StringBuilder()).append("delta > size, del ").append(k21).toString());
                    }
                    a(arraylist, l24, i25);
                    i26 = j21 | 1 << k21;
                    j26 = i21;
                } else
                {
                    i26 = j21;
                    j26 = i25;
                }
                k21++;
                i21 = j26;
                j21 = i26;
            }
            l21 = Integer.parseInt(((HashMap)arraylist1.get(k20)).get("start").toString());
            i22 = k20 - 1;
            j22 = l21;
            k22 = j21;
            while (i22 >= 0) 
            {
                hashmap2 = (HashMap)arraylist1.get(i22);
                i23 = Integer.parseInt(hashmap2.get("start").toString());
                j23 = Integer.parseInt(hashmap2.get("stop").toString());
                k23 = Integer.parseInt(hashmap2.get("refmode").toString());
                l23 = (j22 + 1) - j23;
                i24 = 1 + (j23 - i23);
                if ((l23 > i24 && (j23 >= k9 || i23 <= j10) || l23 >= i24 * 2) && k23 == 0)
                {
                    if (DEBUG)
                    {
                        Debug.i("sleepAnalyze", (new StringBuilder()).append("delta2 > size, del ").append(i22).toString());
                    }
                    a(arraylist, i23, j23);
                    k24 = k22 | 1 << i22;
                    j24 = j22;
                } else
                {
                    j24 = i23;
                    k24 = k22;
                }
                i22--;
                k22 = k24;
                j22 = j24;
            }
            for (l22 = 31; l22 >= 0; l22--)
            {
                if ((k22 & 1 << l22) == 0)
                {
                    continue;
                }
                if (DEBUG)
                {
                    Debug.i("sleepAnalyze", (new StringBuilder()).append("del ").append(l22).toString());
                }
                arraylist1.remove(l22);
            }

        }
        l11 = 0;
        for (i12 = 0; i12 < arraylist1.size(); i12++)
        {
            hashmap1 = (HashMap)arraylist1.get(i12);
            i20 = Integer.parseInt(hashmap1.get("start").toString());
            l11 += 1 + (Integer.parseInt(hashmap1.get("stop").toString()) - i20);
        }

        if (l11 <= 90 || l11 <= 150 && Integer.parseInt(((HashMap)arraylist1.get(-1 + arraylist1.size())).get("stop").toString()) < i10)
        {
            if (DEBUG)
            {
                Debug.i("sleepAnalyze", "totalSize too small, so clear");
            }
            for (j12 = -1 + arraylist1.size(); j12 >= 0; j12--)
            {
                hashmap = (HashMap)arraylist1.get(j12);
                a(arraylist, Integer.parseInt(hashmap.get("start").toString()), Integer.parseInt(hashmap.get("stop").toString()));
                arraylist1.remove(j12);
            }

        }
        k12 = arraylist1.size();
        if (DEBUG)
        {
            Debug.i("sleepAnalyze", (new StringBuilder()).append("now sleeplist=").append(k12).toString());
        }
        if (k12 > 0)
        {
            i17 = Integer.parseInt(((HashMap)arraylist1.get(0)).get("start").toString());
            j17 = Integer.parseInt(((HashMap)arraylist1.get(k12 - 1)).get("stop").toString());
            k17 = Integer.parseInt(((HashMap)arraylist1.get(0)).get("startBed").toString());
            l17 = Integer.parseInt(((HashMap)arraylist1.get(k12 - 1)).get("stopBed").toString());
            i18 = 1;
            j18 = 0;
            while (i18 < k12) 
            {
                k18 = Integer.parseInt(((HashMap)arraylist1.get(i18 - 1)).get("stop").toString());
                l18 = Integer.parseInt(((HashMap)arraylist1.get(i18)).get("start").toString());
                i19 = Integer.parseInt(((HashMap)arraylist1.get(i18)).get("startBed").toString());
                if (i19 > k18)
                {
                    l19 = -1 + (i19 - k18);
                    if (l19 <= 30)
                    {
                        a(arraylist, k18 + 1, i19 - 1, 7);
                    } else
                    {
                        c(arraylist, k18 + 1, i19 - 1);
                    }
                    j19 = l19 + j18;
                    a(arraylist, i19, l18 - 1, 4);
                } else
                if (l18 > k18)
                {
                    k19 = -1 + (l18 - k18);
                    if (k19 <= 30)
                    {
                        a(arraylist, k18 + 1, l18 - 1, 7);
                    } else
                    {
                        c(arraylist, k18 + 1, l18 - 1);
                    }
                    j19 = k19 + j18;
                } else
                {
                    j19 = j18;
                }
                i18++;
                j18 = j19;
            }
            l12 = k17;
            i13 = j17;
            j13 = i17;
            k13 = j18;
            j5 = l17;
        } else
        {
            j5 = 0;
            l12 = 0;
            i13 = 0;
            j13 = 0;
            k13 = 0;
        }
        if (DEBUG)
        {
            Debug.i("sleepAnalyze", (new StringBuilder()).append("sleepanalyze ").append(j13).append("->").append(i13).append(", OnBed=").append(l12).append("->").append(j5).toString());
        }
        if (j13 >= i13) goto _L59; else goto _L58
_L58:
        if (false) goto _L61; else goto _L60
_L60:
        if (j13 > 30)
        {
            l13 = j13 - 30;
        } else
        {
            l13 = 0;
        }
        if (j13 > 15)
        {
            i14 = j13 - 15;
        } else
        {
            i14 = 0;
        }
        j14 = j13 - 1;
        k14 = Math.max(l12, l13);
        l14 = Math.max(l12, i14);
        flag4 = true;
_L81:
        if (j14 < l14) goto _L63; else goto _L62
_L62:
        if (flag4 && ((SportData)arraylist.get(j14)).getActivity() < 6)
        {
            flag4 = true;
        } else
        {
            flag4 = false;
        }
        if (flag4) goto _L64; else goto _L63
_L63:
        i15 = j14 + 1;
        if (DEBUG)
        {
            Debug.i("DataAnalysis", (new StringBuilder()).append("k=").append(j14).append(",start=").append(j13).toString());
        }
        if (1 + (j13 - i15) >= 15)
        {
            a(arraylist, i15, j13, 5);
        } else
        {
            a(arraylist, i15, j13, 4);
        }
        flag5 = true;
_L82:
        if (j14 < k14) goto _L66; else goto _L65
_L65:
        if (flag5 && ((SportData)arraylist.get(j14)).getActivity() < 30 && ((SportData)arraylist.get(j14)).getStep() == 0)
        {
            flag5 = true;
        } else
        {
            flag5 = false;
        }
        if (flag5) goto _L67; else goto _L66
_L66:
        j15 = j14 + 1;
        if (DEBUG)
        {
            Debug.i("DataAnalysis", (new StringBuilder()).append("k=").append(j14).append(",start=").append(j13).append(",startNREM=").append(i15).toString());
        }
        a(arraylist, j15, i15 - 1, 4);
        if (DEBUG)
        {
            Debug.i("sleepAnalyze", (new StringBuilder()).append("prev stop at ").append(i13).toString());
        }
        k15 = i13 + 1;
        l15 = i13;
        i16 = 0;
_L87:
        if (k15 > j5) goto _L69; else goto _L68
_L68:
        j16 = ((SportData)arraylist.get(k15)).getSportMode();
        if (j16 != 2 && j16 != 1 && j16 != 126) goto _L71; else goto _L70
_L70:
        l15 = k15 - 1;
_L69:
        if (DEBUG)
        {
            Debug.i("sleepAnalyze", (new StringBuilder()).append("now stop at ").append(l15).toString());
        }
        i5 = l12;
        l5 = j15;
        k5 = l15;
        i6 = k13;
_L90:
        flag3 = false;
        if (l5 < k5)
        {
            flag3 = true;
        }
        Log.i("sleepM", (new StringBuilder()).append(">>>>>>analyze: ").append(l5).append("->").append(k5).toString());
        if (1 == k2)
        {
            k1 = k5;
        } else
        if (2 == k2)
        {
            j2 = l5;
        }
        if (k2 == 0) goto _L73; else goto _L72
_L72:
        Log.i("sleepM", (new StringBuilder()).append(">>>>>>>>now ref=").append(j2).append("->").append(k1).toString());
        if (!flag3)
        {
            a(arraylist, j2, k1, 100);
        } else
        if (l5 != j2 || k5 != k1)
        {
            i6 = c(arraylist, j2, k1);
        }
        if (flag3)
        {
            if (l5 < j2)
            {
                a(arraylist, l5, j2 - 1);
            }
            if (k5 > k1)
            {
                a(arraylist, k1 + 1, k5);
            }
        }
        if (!flag3) goto _L75; else goto _L74
_L74:
        i9 = j2;
_L91:
        if (i9 >= k && ((SportData)arraylist.get(i9)).getStep() <= 0 && ((SportData)arraylist.get(i9)).getSportMode() != 126 && ((SportData)arraylist.get(i9)).getSportMode() != 6) goto _L77; else goto _L76
_L76:
        k8 = i9 + 1;
        j9 = k1;
_L92:
        if (j9 <= l && ((SportData)arraylist.get(j9)).getStep() <= 0 && ((SportData)arraylist.get(j9)).getSportMode() != 126 && ((SportData)arraylist.get(j9)).getSportMode() != 6) goto _L79; else goto _L78
_L78:
        j8 = j9 - 1;
_L93:
        Log.i("sleepM", (new StringBuilder()).append(">>>>>onbed: ").append(k8).append("->").append(j8).toString());
        j5 = j8;
        l8 = k8;
        k6 = j2;
        j6 = l8;
          goto _L80
_L64:
        j14--;
          goto _L81
_L67:
        j14--;
          goto _L82
_L71:
        if (j16 != 0 && j16 != 3) goto _L84; else goto _L83
_L83:
        if (((SportData)arraylist.get(k15)).getActivity() >= 6) goto _L86; else goto _L85
_L85:
        ((SportData)arraylist.get(k15)).setMode(4);
        k16 = 0;
        l16 = k15;
_L94:
        k15++;
        l15 = l16;
        i16 = k16;
          goto _L87
_L86:
        ((SportData)arraylist.get(k15)).setMode(4);
        k16 = i16 + 1;
        if (i16 < 4) goto _L89; else goto _L88
_L88:
        l15 = k15 - 4;
        a(arraylist, k15 - 3, k15, 0);
          goto _L69
_L61:
        i5 = l12;
        k5 = i13;
        l5 = j13;
        i6 = k13;
          goto _L90
_L77:
        i9--;
          goto _L91
_L79:
        j9++;
          goto _L92
_L73:
        i6 = c(arraylist, l5, k5);
        j6 = i5;
        k1 = k5;
        k6 = l5;
_L80:
        l6 = 0;
        i7 = 0;
        j7 = k6;
        while (j7 <= k1) 
        {
            if (4 == ((SportData)arraylist.get(j7)).getSportMode())
            {
                i8 = l6 + 1;
            } else
            if (5 == ((SportData)arraylist.get(j7)).getSportMode())
            {
                i7++;
                i8 = l6;
            } else
            {
                i8 = l6;
            }
            j7++;
            l6 = i8;
        }
        if (DEBUG)
        {
            Debug.i("DataAnalyze", (new StringBuilder()).append("total=").append(i7).append(",sleep=").append(k6).append("->").append(k1).append(",").append((float)i7 / (float)(1 + (k1 - k6))).toString());
        }
        if (k6 < k1)
        {
            for (k7 = j6; k7 < k6; k7++)
            {
                ((SportData)arraylist.get(k7)).setMode(7);
            }

            for (l7 = k1 + 1; l7 <= j5; l7++)
            {
                ((SportData)arraylist.get(l7)).setMode(7);
            }

        }
        return new c(k6, k1, j6, j5, i7, arraylist1.size(), 0, i6, flag3);
_L75:
        j8 = k1;
        k8 = j2;
          goto _L93
_L89:
        l16 = l15;
          goto _L94
_L84:
        k16 = i16;
        l16 = l15;
          goto _L94
_L59:
        k5 = i13;
        l5 = j13;
        i6 = k13;
        i5 = 0;
        j5 = 0;
          goto _L90
_L55:
        j34 = j33;
        k34 = i33;
          goto _L95
_L53:
        j34 = j33;
        k34 = i33;
        l34 = l33;
          goto _L96
_L45:
        i11 = 85;
          goto _L97
        i5 = 0;
        j5 = 0;
        k5 = 0;
        l5 = 0;
        i6 = 0;
          goto _L90
_L28:
        k43 = i43;
          goto _L31
_L20:
        j41 = l40;
          goto _L23
        j44 = l43;
          goto _L15
_L2:
        j2 = i2;
        k2 = l1;
        if (true) goto _L99; else goto _L98
_L98:
    }

    private static void a(SharedPreferences sharedpreferences, boolean flag, int k, int l, int i1, int j1, int k1)
    {
        android.content.SharedPreferences.Editor editor = sharedpreferences.edit();
        if (sharedpreferences == null)
        {
            return;
        }
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        if (flag)
        {
            l1 = (k + sharedpreferences.getInt("start1", 1440)) / 2;
            i2 = (l + sharedpreferences.getInt("stop1", 1920)) / 2;
            j2 = ((i1 * 100) / (1 + (l - k)) + sharedpreferences.getInt("quality1", 85)) / 2;
            k2 = (j1 + sharedpreferences.getInt("wakecnt1", 1)) / 2;
            l2 = (k1 + sharedpreferences.getInt("maxnrem", 60)) / 2;
            editor.putInt("start1", l1);
            editor.putInt("stop1", i2);
            editor.putInt("quality1", j2);
            editor.putInt("wakecnt1", k2);
            editor.putInt("maxnrem", l2);
        } else
        {
            l1 = (k + sharedpreferences.getInt("start2", 1440)) / 2;
            i2 = (l + sharedpreferences.getInt("stop2", 1920)) / 2;
            j2 = ((i1 * 100) / (1 + (l - k)) + sharedpreferences.getInt("quality2", 85)) / 2;
            k2 = (j1 + sharedpreferences.getInt("wakecnt2", 1)) / 2;
            l2 = (k1 + sharedpreferences.getInt("maxnrem", 60)) / 2;
            editor.putInt("start2", l1);
            editor.putInt("stop2", i2);
            editor.putInt("quality2", j2);
            editor.putInt("wakecnt2", k2);
            editor.putInt("maxnrem", l2);
        }
        if (DEBUG)
        {
            Debug.i("sleepAnalyze", (new StringBuilder()).append("storeRef: ").append(l1).append("->").append(i2).append(",quality=").append(j2).append(",wakecnt=").append(k2).append(",maxnrem=").append(l2).append(",store1=").append(flag).toString());
        }
        editor.commit();
    }

    private static void a(ArrayList arraylist, int k, int l)
    {
        int i1 = arraylist.size();
        if (i1 != 0 && k < i1 && l < i1 && k <= l)
        {
            if (DEBUG)
            {
                Debug.i("sleepAnalyze", (new StringBuilder()).append(">>>resetData[").append(k).append("->").append(l).append("]").toString());
            }
            while (k <= l) 
            {
                int j1 = ((SportData)arraylist.get(k)).getActivity();
                int k1 = ((SportData)arraylist.get(k)).getStep();
                if (((SportData)arraylist.get(k)).getSportMode() == 4 || ((SportData)arraylist.get(k)).getSportMode() == 5)
                {
                    if (k1 >= 130)
                    {
                        ((SportData)arraylist.get(k)).setMode(2);
                    } else
                    if (k1 > 15)
                    {
                        ((SportData)arraylist.get(k)).setMode(1);
                    } else
                    if (j1 <= 1)
                    {
                        ((SportData)arraylist.get(k)).setMode(3);
                    } else
                    {
                        ((SportData)arraylist.get(k)).setMode(0);
                    }
                }
                k++;
            }
        }
    }

    private static void a(ArrayList arraylist, int k, int l, int i1)
    {
        int j1 = arraylist.size();
        if (j1 != 0 && k < j1 && l < j1 && k <= l)
        {
            if (DEBUG)
            {
                Debug.i("DataAnalysis", (new StringBuilder()).append(">>>modifyData[").append(k).append("->").append(l).append("] from ").append(((SportData)arraylist.get(k)).getSportMode()).append(" to ").append(i1).toString());
            }
            while (k <= l) 
            {
                if (((SportData)arraylist.get(k)).getSportMode() != 6)
                {
                    ((SportData)arraylist.get(k)).setMode(i1);
                }
                k++;
            }
        }
    }

    private static void a(ArrayList arraylist, int k, int l, ArrayList arraylist1, boolean flag)
    {
        if (k <= l && k < arraylist.size() && l < arraylist.size()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (DEBUG)
        {
            Debug.i("dataAnalysis", (new StringBuilder()).append("filterData ").append(k).append("->").append(l).toString());
        }
        ArrayList arraylist2 = new ArrayList();
        int i1 = k + 1;
        int j1 = k;
        while (i1 <= l) 
        {
            HashMap hashmap;
            int k1;
            boolean flag1;
            int l1;
            int i2;
            int j2;
            int k2;
            boolean flag2;
            ActiveItem activeitem;
            ActiveItem activeitem1;
            int l2;
            int i3;
            int j3;
            int k3;
            boolean flag3;
            int l3;
            int i4;
            int j4;
            int k4;
            int l4;
            int i5;
            int j5;
            int k5;
            int l5;
            int i6;
            int j6;
            int k6;
            int l6;
            int i7;
            boolean flag4;
            int j7;
            int k7;
            if (((SportData)arraylist.get(i1)).getSportMode() != ((SportData)arraylist.get(i1 - 1)).getSportMode())
            {
                HashMap hashmap1 = new HashMap();
                hashmap1.put("start", Integer.valueOf(j1));
                hashmap1.put("stop", Integer.valueOf(i1 - 1));
                hashmap1.put("mode", Integer.valueOf(((SportData)arraylist.get(j1)).getSportMode()));
                arraylist2.add(hashmap1);
                k7 = i1;
            } else
            {
                k7 = j1;
            }
            i1++;
            j1 = k7;
        }
        hashmap = new HashMap();
        hashmap.put("start", Integer.valueOf(j1));
        hashmap.put("stop", Integer.valueOf(l));
        hashmap.put("mode", Integer.valueOf(((SportData)arraylist.get(j1)).getSportMode()));
        arraylist2.add(hashmap);
        k1 = 1 + (l - k);
        if (arraylist2.size() != 1)
        {
            break; /* Loop/switch isn't completed */
        }
        j7 = ((SportData)arraylist.get(k)).getSportMode();
        if (j7 == 1 && k1 >= 5 || j7 == 2 && k1 >= 3)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        j2 = l;
        k2 = k;
        if (flag2)
        {
            if (DEBUG)
            {
                Debug.i("dataAnalysis", (new StringBuilder()).append("section ").append(k2).append("->").append(j2).toString());
            }
            activeitem1 = new ActiveItem();
            activeitem1.start = k2;
            activeitem1.stop = j2;
            arraylist1.add(activeitem1);
        }
        if (flag)
        {
            activeitem = new ActiveItem();
            activeitem.flag = 1;
            arraylist1.add(activeitem);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        flag1 = false;
        l1 = arraylist2.size();
        i2 = 0;
        j2 = l;
        k2 = k;
_L12:
        if (i2 >= l1) goto _L5; else goto _L4
_L4:
        if (((Integer)((HashMap)arraylist2.get(i2)).get("mode")).intValue() != 0)
        {
            break MISSING_BLOCK_LABEL_1329;
        }
        k4 = 1 + (((Integer)((HashMap)arraylist2.get(i2)).get("stop")).intValue() - ((Integer)((HashMap)arraylist2.get(i2)).get("start")).intValue());
        if (k4 > 1 || i2 <= 0 || i2 >= l1 - 1) goto _L7; else goto _L6
_L6:
        j6 = ((Integer)((HashMap)arraylist2.get(i2 - 1)).get("mode")).intValue();
        k6 = ((Integer)((HashMap)arraylist2.get(i2 + 1)).get("mode")).intValue();
        l6 = 1 + (((Integer)((HashMap)arraylist2.get(i2 - 1)).get("stop")).intValue() - ((Integer)((HashMap)arraylist2.get(i2 - 1)).get("start")).intValue());
        i7 = 1 + (((Integer)((HashMap)arraylist2.get(i2 + 1)).get("stop")).intValue() - ((Integer)((HashMap)arraylist2.get(i2 + 1)).get("start")).intValue());
        if (l6 < 3 && i7 < 3 && i7 + l6 < 5) goto _L9; else goto _L8
_L8:
        flag1 = true;
        if (j6 != k6) goto _L11; else goto _L10
_L10:
        a(arraylist, ((Integer)((HashMap)arraylist2.get(i2)).get("start")).intValue(), ((Integer)((HashMap)arraylist2.get(i2)).get("start")).intValue(), j6);
        flag4 = flag1;
_L13:
        flag1 = flag4;
        i4 = j2;
        j4 = k2;
_L14:
        i2++;
        k2 = j4;
        j2 = i4;
          goto _L12
_L11:
        a(arraylist, ((Integer)((HashMap)arraylist2.get(i2)).get("start")).intValue(), ((Integer)((HashMap)arraylist2.get(i2)).get("start")).intValue(), 1);
_L9:
        flag4 = flag1;
          goto _L13
_L7:
        if (k4 > 1 && i2 > 0 && i2 < l1 - 1)
        {
            j5 = ((Integer)((HashMap)arraylist2.get(i2 - 1)).get("mode")).intValue();
            k5 = ((Integer)((HashMap)arraylist2.get(i2 + 1)).get("mode")).intValue();
            l5 = 1 + (((Integer)((HashMap)arraylist2.get(i2 - 1)).get("stop")).intValue() - ((Integer)((HashMap)arraylist2.get(i2 - 1)).get("start")).intValue());
            i6 = 1 + (((Integer)((HashMap)arraylist2.get(i2 + 1)).get("stop")).intValue() - ((Integer)((HashMap)arraylist2.get(i2 + 1)).get("start")).intValue());
            if (l5 >= 3 && j5 == 2 || j5 == 1 && l5 >= 4 || k5 == 2 && i6 >= 3 || k5 == 1 && i6 >= 4)
            {
                flag1 = true;
            }
            i4 = j2;
            j4 = k2;
        } else
        if (i2 == l1 - 1 && i2 > 0)
        {
            i4 = ((Integer)((HashMap)arraylist2.get(i2 - 1)).get("stop")).intValue();
            j4 = k2;
        } else
        {
            if (i2 != 0 || i2 + 1 >= l1)
            {
                break MISSING_BLOCK_LABEL_1329;
            }
            l4 = ((Integer)((HashMap)arraylist2.get(i2 + 1)).get("start")).intValue();
            i5 = j2;
            j4 = l4;
            i4 = i5;
        }
          goto _L14
_L5:
        if (!flag1)
        {
            if (1 + (j2 - k2) >= 10)
            {
                l2 = 0;
                flag2 = true;
                i3 = k2;
                while (i3 <= j2) 
                {
                    j3 = ((SportData)arraylist.get(i3)).getSportMode();
                    if (j3 == 1 || j3 == 2)
                    {
                        k3 = l2 + 1;
                    } else
                    {
                        k3 = l2;
                    }
                    if (k3 >= (1 + (j2 - k2)) / 2)
                    {
                        flag3 = true;
                    } else
                    {
                        flag3 = false;
                    }
                    i3++;
                    l3 = k3;
                    flag2 = flag3;
                    l2 = l3;
                }
            } else
            {
                flag2 = false;
            }
        } else
        {
            flag2 = true;
        }
        break MISSING_BLOCK_LABEL_326;
        i4 = j2;
        j4 = k2;
          goto _L14
    }

    private static void b(ArrayList arraylist, int k, int l)
    {
        int i1 = arraylist.size();
        if (i1 != 0 && k < i1 && l < i1 && k <= l)
        {
            if (DEBUG)
            {
                Debug.i("sleepAnalyze", (new StringBuilder()).append(">>>setSleep[").append(k).append("->").append(l).append("]").toString());
            }
            while (k <= l) 
            {
                int j1 = ((SportData)arraylist.get(k)).getActivity();
                if (((SportData)arraylist.get(k)).getSportMode() != 6 && ((SportData)arraylist.get(k)).getSportMode() != 126)
                {
                    if (j1 < 6)
                    {
                        ((SportData)arraylist.get(k)).setMode(5);
                    } else
                    {
                        ((SportData)arraylist.get(k)).setMode(4);
                    }
                }
                k++;
            }
        }
    }

    private static int c(ArrayList arraylist, int k, int l)
    {
        int i1;
        int j1;
        i1 = 0;
        j1 = arraylist.size();
        if (j1 != 0 && k < j1 && l < j1 && k <= l) goto _L2; else goto _L1
_L1:
        int k1 = 0;
_L6:
        return k1;
_L2:
        int l1 = k;
        while (l1 <= l) 
        {
            int i8 = ((SportData)arraylist.get(l1)).getActivity();
            if (((SportData)arraylist.get(l1)).getSportMode() != 6)
            {
                if (((SportData)arraylist.get(l1)).getSportMode() == 126)
                {
                    ((SportData)arraylist.get(l1)).setMode(100);
                } else
                if (((SportData)arraylist.get(l1)).getStep() > 0 && i8 >= 60)
                {
                    ((SportData)arraylist.get(l1)).setMode(7);
                } else
                if (i8 < 6)
                {
                    ((SportData)arraylist.get(l1)).setMode(5);
                } else
                {
                    ((SportData)arraylist.get(l1)).setMode(4);
                }
            }
            l1++;
        }
        ArrayList arraylist1 = new ArrayList();
        int i2 = k + 1;
        int j2 = k;
        k1 = 0;
        while (i2 <= l) 
        {
            int k2;
            HashMap hashmap;
            int l2;
            ArrayList arraylist2;
            int i3;
            int j3;
            int k3;
            HashMap hashmap1;
            int l3;
            int i4;
            int j4;
            int k4;
            int l4;
            int i5;
            int j5;
            int k5;
            HashMap hashmap2;
            int l5;
            int i6;
            int j6;
            int k6;
            int l6;
            int i7;
            int j7;
            if (((SportData)arraylist.get(i2)).getSportMode() != ((SportData)arraylist.get(i2 - 1)).getSportMode())
            {
                int k7 = ((SportData)arraylist.get(j2)).getSportMode();
                HashMap hashmap3;
                if (k7 == 5 && i2 - j2 < 15)
                {
                    a(arraylist, j2, i2 - 1, 4);
                    k7 = 4;
                } else
                if (k7 == 4 && i2 - j2 >= 10)
                {
                    int l7 = k1 + (i2 - j2);
                    a(arraylist, j2, i2 - 1, 7);
                    k1 = l7;
                    k7 = 7;
                } else
                if (k7 == 7)
                {
                    k1 += i2 - j2;
                }
                hashmap3 = new HashMap();
                hashmap3.put("start", Integer.valueOf(j2));
                hashmap3.put("stop", Integer.valueOf(i2 - 1));
                hashmap3.put("mode", Integer.valueOf(k7));
                arraylist1.add(hashmap3);
                j7 = i2;
            } else
            {
                j7 = j2;
            }
            i2++;
            j2 = j7;
        }
        k2 = ((SportData)arraylist.get(j2)).getSportMode();
        if (k2 == 5 && (l + 1) - j2 < 15)
        {
            a(arraylist, j2, l, 4);
            k2 = 4;
        } else
        if (k2 == 4 && (l + 1) - j2 >= 10)
        {
            k1 += (l + 1) - j2;
            a(arraylist, j2, l, 7);
            k2 = 7;
        } else
        if (k2 == 7)
        {
            k1 += (l + 1) - j2;
        }
        hashmap = new HashMap();
        hashmap.put("start", Integer.valueOf(j2));
        hashmap.put("stop", Integer.valueOf(l));
        hashmap.put("mode", Integer.valueOf(k2));
        arraylist1.add(hashmap);
        l2 = 0;
        if (l2 >= arraylist1.size())
        {
            break; /* Loop/switch isn't completed */
        }
        l5 = ((Integer)((HashMap)arraylist1.get(l2)).get("start")).intValue();
        i6 = ((Integer)((HashMap)arraylist1.get(l2)).get("stop")).intValue();
        j6 = ((Integer)((HashMap)arraylist1.get(l2)).get("mode")).intValue();
        k6 = 1 + (i6 - l5);
        if (j6 != 7 && (j6 == 4 || j6 == 5) && j6 == 4 && k6 < 15 && l2 > 0 && l2 < -1 + arraylist1.size())
        {
            l6 = ((Integer)((HashMap)arraylist1.get(l2 - 1)).get("mode")).intValue();
            i7 = ((Integer)((HashMap)arraylist1.get(l2 + 1)).get("mode")).intValue();
            if (l6 == 5 && i7 == 5)
            {
                a(arraylist, l5, i6, 5);
            }
        }
        l2++;
        if (true) goto _L4; else goto _L3
_L4:
        break MISSING_BLOCK_LABEL_536;
_L3:
        arraylist2 = new ArrayList();
        i3 = k + 1;
        j3 = k;
        while (i3 <= l) 
        {
            if (((SportData)arraylist.get(i3)).getSportMode() != ((SportData)arraylist.get(i3 - 1)).getSportMode())
            {
                k5 = ((SportData)arraylist.get(j3)).getSportMode();
                hashmap2 = new HashMap();
                hashmap2.put("start", Integer.valueOf(j3));
                hashmap2.put("stop", Integer.valueOf(i3 - 1));
                hashmap2.put("mode", Integer.valueOf(k5));
                arraylist2.add(hashmap2);
                j5 = i3;
            } else
            {
                j5 = j3;
            }
            i3++;
            j3 = j5;
        }
        k3 = ((SportData)arraylist.get(j3)).getSportMode();
        hashmap1 = new HashMap();
        hashmap1.put("start", Integer.valueOf(j3));
        hashmap1.put("stop", Integer.valueOf(l));
        hashmap1.put("mode", Integer.valueOf(k3));
        arraylist2.add(hashmap1);
        while (i1 < arraylist2.size()) 
        {
            l3 = ((Integer)((HashMap)arraylist2.get(i1)).get("start")).intValue();
            i4 = ((Integer)((HashMap)arraylist2.get(i1)).get("stop")).intValue();
            j4 = ((Integer)((HashMap)arraylist2.get(i1)).get("mode")).intValue();
            k4 = 1 + (i4 - l3);
            if (j4 == 4 && k4 < 15 && i1 > 0 && i1 < -1 + arraylist2.size())
            {
                l4 = ((Integer)((HashMap)arraylist2.get(i1 - 1)).get("mode")).intValue();
                i5 = ((Integer)((HashMap)arraylist2.get(i1 + 1)).get("mode")).intValue();
                if (l4 == i5)
                {
                    a(arraylist, l3, i4, l4);
                    if (l4 == 7)
                    {
                        k1 += k4;
                    }
                } else
                if (l4 == 7 || i5 == 7)
                {
                    a(arraylist, l3, i4, 7);
                    k1 += k4;
                }
            }
            i1++;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static void dataPostProcess(Context context, DaySportData daysportdata, DaySportData daysportdata1, DaySportData daysportdata2)
    {
        int ai[] = {
            i.length, 3
        };
        double ad[][] = (double[][])Array.newInstance(Double.TYPE, ai);
        double d1 = 0.0D;
        long l = System.currentTimeMillis();
        ArrayList arraylist;
        ArrayList arraylist1;
        ArrayList arraylist2;
        boolean flag;
        ArrayList arraylist3;
        boolean flag1;
        boolean flag2;
        ArrayList arraylist4;
        ArrayList arraylist5;
        cn.com.smartdevices.bracelet.chart.util.ChartData.UserSleepModify usersleepmodify;
        cn.com.smartdevices.bracelet.chart.util.ChartData.UserSleepModify usersleepmodify1;
        ArrayList arraylist6;
        PersonInfo personinfo;
        double d2;
        int k;
        SharedPreferences sharedpreferences;
        Calendar calendar;
        int i1;
        boolean flag3;
        int j1;
        char c1;
        char c2;
        c c3;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        char c4;
        int l2;
        int i3;
        int j3;
        c c5;
        int k3;
        int l3;
        int i4;
        int j4;
        int k4;
        ArrayList arraylist7;
        int l4;
        int i5;
        int j5;
        int k5;
        int l5;
        int i6;
        int j6;
        ArrayList arraylist8;
        double d3;
        int k6;
        int l6;
        int i7;
        double d4;
        double d5;
        int j7;
        int k7;
        int l7;
        StageSteps stagesteps;
        int i8;
        HashMap hashmap;
        int j8;
        int k8;
        int l8;
        ArrayList arraylist9;
        int i9;
        int j9;
        ArrayList arraylist10;
        int k9;
        int l9;
        SleepInfo sleepinfo;
        StepsInfo stepsinfo;
        Calendar calendar1;
        Calendar calendar2;
        int i10;
        int j10;
        int k10;
        ArrayList arraylist11;
        int l10;
        CloneNotSupportedException clonenotsupportedexception;
        int i11;
        int j11;
        int k11;
        int l11;
        int i12;
        int j12;
        int k12;
        double d6;
        double d7;
        int l12;
        ActiveItem activeitem;
        int i13;
        ActiveItem activeitem1;
        int j13;
        int k13;
        int l13;
        boolean flag4;
        int i14;
        int j14;
        int k14;
        int l14;
        boolean flag5;
        int i15;
        int j15;
        int k15;
        int l15;
        int i16;
        HashMap hashmap1;
        int j16;
        int k16;
        int l16;
        byte byte0;
        int i17;
        int j17;
        int k17;
        int l17;
        int i18;
        int j18;
        int k18;
        b b1;
        int l18;
        int i19;
        int j19;
        int k19;
        double d8;
        double d9;
        int l19;
        double d10;
        int i20;
        int j20;
        int k20;
        HashMap hashmap2;
        int l20;
        int i21;
        int j21;
        double d11;
        double d12;
        int k21;
        double d13;
        int l21;
        double d14;
        int i22;
        int j22;
        int k22;
        StageSteps stagesteps1;
        int l22;
        int i23;
        int j23;
        double d15;
        int k23;
        double d16;
        int l23;
        int i24;
        char c6;
        int j24;
        int k24;
        int l24;
        int i25;
        int j25;
        int k25;
        int l25;
        if (daysportdata != null)
        {
            arraylist = Utils.copy(daysportdata.data());
        } else
        {
            arraylist = null;
        }
        arraylist1 = null;
        if (daysportdata1 != null)
        {
            arraylist1 = Utils.copy(daysportdata1.data());
        }
        arraylist2 = null;
        if (daysportdata2 != null)
        {
            arraylist2 = Utils.copy(daysportdata2.data());
        }
        if (arraylist1 != null && arraylist1.size() >= 1) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (arraylist == null || arraylist.size() < 1)
        {
            flag = true;
            arraylist3 = new ArrayList();
        } else
        {
            arraylist3 = arraylist;
            flag = false;
        }
        arraylist3.addAll(arraylist1);
        if (arraylist2 == null || arraylist2.size() < 1)
        {
            flag1 = true;
            flag2 = flag;
            arraylist4 = arraylist1;
            arraylist5 = arraylist3;
        } else
        {
            arraylist3.addAll(arraylist2);
            flag2 = flag;
            arraylist4 = arraylist1;
            arraylist5 = arraylist3;
            flag1 = false;
        }
        usersleepmodify = ChartData.getDynamicData().getUserSleepModify(daysportdata1.getSportDay());
        if (usersleepmodify != null)
        {
            Log.i("sleepM", (new StringBuilder()).append("####ref=").append(usersleepmodify.sleepStart).append(", ").append(usersleepmodify.sleepEnd).toString());
            if ((usersleepmodify.sleepStart < -1440 || usersleepmodify.sleepStart >= 1440) && (usersleepmodify.sleepEnd < -1440 || usersleepmodify.sleepEnd >= 1440))
            {
                Debug.i("sleepAnalyze", "sleepReference not valid!!!");
                usersleepmodify = null;
            }
        }
        usersleepmodify1 = null;
        if (!flag1)
        {
            usersleepmodify1 = ChartData.getDynamicData().getUserSleepModify(daysportdata2.getSportDay());
            if (usersleepmodify1 != null)
            {
                Log.i("sleepM", (new StringBuilder()).append("####ref2=").append(usersleepmodify1.sleepStart).append(", ").append(usersleepmodify1.sleepEnd).toString());
                if ((usersleepmodify1.sleepStart < -1440 || usersleepmodify1.sleepStart >= 1440) && (usersleepmodify1.sleepEnd < -1440 || usersleepmodify1.sleepEnd >= 1440))
                {
                    Debug.i("sleepAnalyze", "sleepReference2 not valid!!!");
                    usersleepmodify1 = null;
                }
            }
        }
        arraylist6 = new ArrayList();
        if (DEBUG)
        {
            Debug.i("DataAnalysis", (new StringBuilder()).append("last=").append(daysportdata).append(",curr=").append(daysportdata1).append(",next=").append(daysportdata2).toString());
        }
        if (DEBUG)
        {
            Debug.i("sleepAnalyze", (new StringBuilder()).append(">>Analyze ").append(daysportdata1.getYear()).append(":").append(daysportdata1.getMonth()).append(":").append(daysportdata1.getDay()).toString());
        }
        personinfo = Keeper.readPersonInfoBase();
        if (personinfo == null || personinfo.height <= 0)
        {
            throw new NullPointerException("Keeper.readPersonInfo");
        }
        d2 = (0.41999999999999998D * (double)personinfo.height) / 100D;
        k = personinfo.getDaySportGoalSteps();
        if (k < 0)
        {
            throw new NullPointerException("Keeper.readDaySportGoals");
        }
        if (context != null)
        {
            sharedpreferences = context.getSharedPreferences(String.valueOf(personinfo.uid), 0);
        } else
        {
            sharedpreferences = null;
        }
        calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(daysportdata1.getYear(), daysportdata1.getMonth(), daysportdata1.getDay(), 0, 0);
        i1 = calendar.get(7);
        flag3 = true;
        if (i1 == 7 || i1 == 1)
        {
            flag3 = false;
        }
        if (flag2)
        {
            j1 = 0;
        } else
        {
            j1 = 1080;
        }
        if (flag2)
        {
            c1 = '\u04B0';
        } else
        {
            c1 = '\u0A50';
        }
        if (flag2)
        {
            c2 = '\uFA60';
        } else
        {
            c2 = '\0';
        }
        c3 = a(arraylist5, j1, c1, sharedpreferences, flag3, c2, flag1, flag2, usersleepmodify, 1440);
        if (c3.f > 0)
        {
            k1 = -1 + c3.f;
        } else
        {
            k1 = 0;
        }
        l1 = c3.h;
        i2 = c3.e;
        if (!flag2 && c3.a < c3.b)
        {
            l24 = c3.a;
            i25 = c3.b;
            j25 = c3.e;
            k25 = c3.f;
            l25 = c3.g;
            a(sharedpreferences, flag3, l24, i25, j25, k25, l25);
        }
        j2 = 1 + c3.d;
        if (c3.a == c3.b)
        {
            if (flag2)
            {
                j2 = 0;
            } else
            {
                j2 = 1440;
            }
        }
        k2 = -1 + Math.min(c1, arraylist5.size());
        a(arraylist5, j2, k2);
        if (flag2)
        {
            c4 = '\u0438';
        } else
        {
            c4 = '\u09D8';
        }
        if (flag2)
        {
            l2 = 2640;
        } else
        {
            l2 = 4080;
        }
        if (flag1)
        {
            l2 = (c4 - 1080) + arraylist4.size();
        }
        if (flag2)
        {
            i3 = 0;
        } else
        {
            i3 = 1440;
        }
        j3 = l2 - 1;
        c5 = a(arraylist5, c4, j3, sharedpreferences, flag3, i3, flag1, flag2, usersleepmodify1, 2880);
        if (flag1)
        {
            if (DEBUG)
            {
                Debug.i("DataAnalysis", (new StringBuilder()).append("no next day, so reset ").append(c5.c).append("->").append(c5.d).toString());
            }
            if (c5.c < c5.d)
            {
                j24 = c5.c;
                k24 = c5.d;
                a(arraylist5, j24, k24);
            }
        }
        k3 = c3.a;
        l3 = c3.b;
        if (k3 == l3)
        {
            if (flag2)
            {
                c6 = '\0';
            } else
            {
                c6 = '\u05A0';
            }
            i4 = c6;
            j4 = c6;
        } else
        {
            i4 = l3;
            j4 = k3;
        }
        if (DEBUG)
        {
            Debug.i("sleepAnalyze", (new StringBuilder()).append("sleep ").append(j4).append("->").append(i4).toString());
        }
        if (DEBUG)
        {
            Debug.i("DataAnalysis", (new StringBuilder()).append(">>>>height=").append(personinfo.height).append(",weight=").append(personinfo.weight).toString());
        }
        if (personinfo.gender != 0);
        for (k4 = 0; k4 < i.length; k4++)
        {
            ad[k4][0] = (int)((1609D * i[k4][1]) / (60D * d2));
            if (DEBUG)
            {
                Debug.i("DataAnalysis", (new StringBuilder()).append("alist ").append(k4).append(":").append(ad[k4][0]).toString());
            }
            ad[k4][1] = i[k4][0];
            ad[k4][2] = i[k4][1];
        }

        arraylist7 = new ArrayList();
        if (flag2)
        {
            l4 = 0;
        } else
        if (j4 < 1440)
        {
            l4 = j4;
        } else
        {
            l4 = 1440;
        }
        if (flag2)
        {
            i5 = 0;
        } else
        {
            i5 = 1440;
        }
        j5 = Math.min(i5 + 1440, arraylist5.size());
        if (DEBUG)
        {
            Debug.i("sleepAnalyze", (new StringBuilder()).append("startAnalyze=").append(l4).append(",stopSleep=").append(i4).append(",time:").append(daysportdata1.getMonth()).append(":").append(daysportdata1.getDay()).toString());
        }
        k5 = 0;
        l5 = 0;
        i6 = 0;
        j6 = 0;
        arraylist8 = new ArrayList();
        d3 = 1.5D;
        k6 = 0;
        l6 = l4 + 1;
        i7 = -1;
        d4 = 0.0D;
        d5 = 0.0D;
        j7 = 0;
        k7 = 0;
        l7 = l4;
        if (l6 >= j5) goto _L4; else goto _L3
_L3:
        j18 = ((SportData)arraylist5.get(l6)).getStep();
        k18 = ((SportData)arraylist5.get(l6)).getSportMode();
        b1 = new b(null);
        if (k18 < 0 || k18 > 7 || k18 == 6 || j18 <= 0 || l6 < i5)
        {
            break MISSING_BLOCK_LABEL_5012;
        }
        i21 = k7 + j18;
        if (DEBUG)
        {
            Debug.i("DataAnalysis", (new StringBuilder()).append("i=").append(l6).append(":steps=").append(j18).toString());
        }
        if (DEBUG)
        {
            Debug.i("DataAnalysis", (new StringBuilder()).append("alist size=").append(ad.length).toString());
        }
        if (j18 > 120)
        {
            j21 = 125;
        } else
        {
            j21 = 100;
        }
        if (j18 <= 90)
        {
            d11 = 0.90000000000000002D * (d2 * (double)j18);
        } else
        {
            d11 = (d2 * (double)j18 * (double)j18) / (double)j21;
        }
        d12 = d5 + d11;
        k21 = ((SportData)arraylist5.get(l6)).getRuns();
        if (k21 > 0)
        {
            d13 = d4 + d11 * (0.20000000000000001D + (double)((k21 * 2) / 15));
        } else
        {
            d13 = d4;
        }
        l21 = 0;
        if (l21 < -1 + j.length && d11 > j[l21][0]) goto _L6; else goto _L5
_L5:
        b1.a = d11;
        b1.b = (d11 * (2.2046000000000001D * (double)personinfo.weight * j[l21][1])) / (60D * j[l21][0]);
        d14 = d1 + b1.b;
        if (DEBUG)
        {
            Debug.i("DataAnalysis", (new StringBuilder()).append("iDistance=").append(d11).append(",p=").append(l21).append(",cals=").append(d14).toString());
        }
        i22 = k6 + j18;
        if (i22 >= k && i7 < 0)
        {
            j22 = l6;
        } else
        {
            j22 = i7;
        }
        k22 = (l6 - i5) / 60;
        if (k22 != j6)
        {
            stagesteps1 = new StageSteps();
            stagesteps1.time = j6;
            stagesteps1.steps = i6;
            stagesteps1.distance = k5;
            if (l5 > 60)
            {
                l22 = l5 / 60;
            } else
            {
                l22 = 1;
            }
            stagesteps1.count = l22;
            if (i6 > 0)
            {
                i23 = j7 + stagesteps1.count;
                arraylist6.add(stagesteps1);
            } else
            {
                i23 = j7;
            }
            j23 = (int)d11;
            if (j18 > 0 && j18 <= 60)
            {
                k23 = (int)((double)j18 / d3);
                d15 = d3;
            } else
            if (j18 > 60)
            {
                k23 = 60;
                d15 = (d3 + (double)(j18 / 60)) / 2D;
            } else
            {
                d15 = d3;
                k23 = l5;
            }
            d3 = d15;
            l5 = k23;
            l19 = i23;
            l18 = i22;
            i19 = k22;
            i7 = j22;
            d10 = d14;
            i20 = i21;
            d16 = d13;
            j19 = j18;
            k19 = j23;
            d8 = d16;
            d9 = d12;
        } else
        {
            l23 = i6 + j18;
            i24 = k5 + (int)d11;
            if (j18 > 0 && j18 <= 60)
            {
                l5 += (int)((double)j18 / d3);
                i19 = j6;
                i7 = j22;
                d9 = d12;
                l19 = j7;
                d8 = d13;
                j19 = l23;
                k19 = i24;
                l18 = i22;
                d10 = d14;
                i20 = i21;
            } else
            if (j18 > 60)
            {
                l5 += 60;
                d3 = (d3 + (double)(j18 / 60)) / 2D;
                i19 = j6;
                i7 = j22;
                d9 = d12;
                l19 = j7;
                d8 = d13;
                j19 = l23;
                k19 = i24;
                l18 = i22;
                d10 = d14;
                i20 = i21;
            } else
            {
                i19 = j6;
                i7 = j22;
                d9 = d12;
                l19 = j7;
                d8 = d13;
                j19 = l23;
                k19 = i24;
                l18 = i22;
                d10 = d14;
                i20 = i21;
            }
        }
_L18:
        arraylist8.add(b1);
        j20 = ((SportData)arraylist5.get(l6)).getSportMode();
        k20 = l6 - 1;
        if (j20 != ((SportData)arraylist5.get(k20)).getSportMode())
        {
            hashmap2 = new HashMap();
            hashmap2.put("start", Integer.valueOf(l7));
            hashmap2.put("stop", Integer.valueOf(l6 - 1));
            hashmap2.put("mode", Integer.valueOf(((SportData)arraylist5.get(l7)).getSportMode()));
            arraylist7.add(hashmap2);
            l20 = l6;
        } else
        {
            l20 = l7;
        }
        l6++;
        l7 = l20;
        d5 = d9;
        j7 = l19;
        k7 = i20;
        d1 = d10;
        i6 = j19;
        k5 = k19;
        d4 = d8;
        k6 = l18;
        j6 = i19;
        break MISSING_BLOCK_LABEL_1570;
_L6:
        l21++;
        break MISSING_BLOCK_LABEL_1813;
_L4:
        if (i6 > 0)
        {
            stagesteps = new StageSteps();
            stagesteps.time = j6;
            stagesteps.steps = i6;
            stagesteps.distance = k5;
            if (l5 > 60)
            {
                i8 = l5 / 60;
            } else
            {
                i8 = 1;
            }
            stagesteps.count = i8;
            j7 += stagesteps.count;
            arraylist6.add(stagesteps);
        }
        hashmap = new HashMap();
        hashmap.put("start", Integer.valueOf(l7));
        hashmap.put("stop", Integer.valueOf(j5 - 1));
        hashmap.put("mode", Integer.valueOf(((SportData)arraylist5.get(l7)).getSportMode()));
        arraylist7.add(hashmap);
        j8 = 0;
        k8 = 0;
        l8 = 0;
        if (j8 >= arraylist7.size())
        {
            break MISSING_BLOCK_LABEL_3104;
        }
        j16 = ((Integer)((HashMap)arraylist7.get(j8)).get("start")).intValue();
        k16 = ((Integer)((HashMap)arraylist7.get(j8)).get("stop")).intValue();
        l16 = ((Integer)((HashMap)arraylist7.get(j8)).get("mode")).intValue();
        if (l16 == 3 || l16 == 0)
        {
            byte0 = 0;
        } else
        if (l16 == 1 || l16 == 2)
        {
            byte0 = 1;
        } else
        {
            byte0 = 2;
        }
        if (DEBUG)
        {
            Debug.i("sleepAnalyze", (new StringBuilder()).append("mList[").append(j8).append("]:[").append(j16).append("->").append(k16).append("],mode=").append(l16).toString());
        }
        if (l16 == 6)
        {
            break MISSING_BLOCK_LABEL_3093;
        }
        if (l16 == 7)
        {
            i17 = k8;
            j17 = l8;
        } else
        {
label0:
            {
                if (l16 != 4 && l16 != 5)
                {
                    break label0;
                }
                i17 = k8;
                j17 = l8;
            }
        }
_L8:
        j8++;
        k8 = i17;
        l8 = j17;
        break MISSING_BLOCK_LABEL_2714;
        if (1 == byte0)
        {
            k17 = 1 + (k16 - j16);
            if (i5 > j16 && k16 >= i5)
            {
                l17 = 1 + (k16 - i5);
            } else
            {
                l17 = k17;
            }
            for (i18 = j16; i18 <= k16; i18++)
            {
                l8 += 10 * ((SportData)arraylist5.get(i18)).getRuns();
            }

            k8 = Math.max(k8, l17);
        }
        if (l16 == 3 && k16 - j16 < 30)
        {
            a(arraylist5, j16, k16, 0);
            ((HashMap)arraylist7.get(j8)).put("mode", Integer.valueOf(0));
        }
        i17 = k8;
        j17 = l8;
        if (true) goto _L8; else goto _L7
_L7:
        arraylist9 = new ArrayList();
        i9 = l4 + 1;
        j9 = l4;
        while (i9 < j5) 
        {
            i15 = ((SportData)arraylist5.get(i9)).getSportMode();
            j15 = i9 - 1;
            if (i15 != ((SportData)arraylist5.get(j15)).getSportMode())
            {
                l15 = i9 - 1;
                i16 = ((SportData)arraylist5.get(l15)).getSportMode();
                if (i16 == 0 && i9 - j9 >= 10 || i16 != 1 && i16 != 2 && i16 != 0)
                {
                    if (DEBUG)
                    {
                        Debug.i("dataAnalysis", (new StringBuilder()).append("intv ").append(j9).append("->").append(i9 - 1).toString());
                    }
                    hashmap1 = new HashMap();
                    if (j9 >= i5)
                    {
                        hashmap1.put("start", Integer.valueOf(j9));
                        hashmap1.put("stop", Integer.valueOf(i9 - 1));
                        arraylist9.add(hashmap1);
                    } else
                    if (i9 - 1 >= i5)
                    {
                        hashmap1.put("start", Integer.valueOf(i5));
                        hashmap1.put("stop", Integer.valueOf(i9 - 1));
                        arraylist9.add(hashmap1);
                    }
                }
                k15 = i9;
            } else
            {
                k15 = j9;
            }
            i9++;
            j9 = k15;
        }
        arraylist10 = new ArrayList();
        for (k9 = 1; k9 < arraylist9.size(); k9++)
        {
            k14 = 1 + ((Integer)((HashMap)arraylist9.get(k9 - 1)).get("stop")).intValue();
            l14 = -1 + ((Integer)((HashMap)arraylist9.get(k9)).get("start")).intValue();
            flag5 = false;
            if (i7 > 0)
            {
                flag5 = false;
                if (i7 >= k14)
                {
                    flag5 = false;
                    if (i7 <= l14)
                    {
                        flag5 = true;
                    }
                }
            }
            a(arraylist5, k14, l14, arraylist10, flag5);
        }

        if (arraylist9.size() <= 0) goto _L10; else goto _L9
_L9:
        l13 = j5 - 1;
_L14:
        if (l13 > ((Integer)((HashMap)arraylist9.get(-1 + arraylist9.size())).get("stop")).intValue() && ((SportData)arraylist5.get(l13)).getSportMode() == 126) goto _L12; else goto _L11
_L11:
        flag4 = false;
        if (i7 > 0)
        {
            j14 = 1 + ((Integer)((HashMap)arraylist9.get(-1 + arraylist9.size())).get("stop")).intValue();
            flag4 = false;
            if (i7 >= j14)
            {
                flag4 = false;
                if (i7 <= l13)
                {
                    flag4 = true;
                }
            }
        }
        i14 = 1 + ((Integer)((HashMap)arraylist9.get(-1 + arraylist9.size())).get("stop")).intValue();
        a(arraylist5, i14, l13, arraylist10, flag4);
_L10:
        l9 = 0;
        while (l9 < arraylist10.size()) 
        {
            if (((ActiveItem)arraylist10.get(l9)).flag == 0)
            {
                j11 = ((ActiveItem)arraylist10.get(l9)).start;
                k11 = ((ActiveItem)arraylist10.get(l9)).stop;
                l11 = 0;
                i12 = 1;
                j12 = 0;
                k12 = j11;
                d6 = 0.0D;
                d7 = 0.0D;
                l12 = 0;
                while (k12 <= k11) 
                {
                    k13 = -1 + (k12 - l4);
                    d6 += ((b)arraylist8.get(k13)).a;
                    d7 += ((b)arraylist8.get(k13)).b;
                    if (((SportData)arraylist5.get(k12)).getSportMode() == 2)
                    {
                        l11++;
                        j12++;
                    } else
                    if (((SportData)arraylist5.get(k12)).getSportMode() == 1)
                    {
                        j12++;
                    } else
                    if (((SportData)arraylist5.get(k12)).getSportMode() == 0)
                    {
                        i12 = 0;
                    }
                    l12 += ((SportData)arraylist5.get(k12)).getStep();
                    k12++;
                }
                if (l11 == 1 + (k11 - j11))
                {
                    i12 = 2;
                }
                ((ActiveItem)arraylist10.get(l9)).mode = i12;
                activeitem = (ActiveItem)arraylist10.get(l9);
                if (j11 >= 1440)
                {
                    i13 = j11 - 1440;
                } else
                {
                    i13 = j11;
                }
                activeitem.start = i13;
                activeitem1 = (ActiveItem)arraylist10.get(l9);
                if (k11 >= 1440)
                {
                    j13 = k11 - 1440;
                } else
                {
                    j13 = k11;
                }
                activeitem1.stop = j13;
                ((ActiveItem)arraylist10.get(l9)).distance = (int)d6;
                ((ActiveItem)arraylist10.get(l9)).calories = (int)d7;
                ((ActiveItem)arraylist10.get(l9)).runtime = l11;
                ((ActiveItem)arraylist10.get(l9)).steps = l12;
                ((ActiveItem)arraylist10.get(l9)).activeTime = j12;
            }
            l9++;
        }
        break; /* Loop/switch isn't completed */
_L12:
        l13--;
        if (true) goto _L14; else goto _L13
_L13:
        if (DEBUG)
        {
            Debug.i("DataAnalysis", "filter done");
        }
        sleepinfo = new SleepInfo();
        stepsinfo = new StepsInfo();
        calendar1 = Calendar.getInstance();
        calendar2 = Calendar.getInstance();
        calendar1.clear();
        calendar2.clear();
        if (flag2)
        {
            calendar1.set(daysportdata1.getYear(), daysportdata1.getMonth(), daysportdata1.getDay(), 0, 0);
            calendar2.set(daysportdata1.getYear(), daysportdata1.getMonth(), daysportdata1.getDay(), 0, 0);
        } else
        {
            calendar1.set(daysportdata.getYear(), daysportdata.getMonth(), daysportdata.getDay(), 0, 0);
            calendar2.set(daysportdata.getYear(), daysportdata.getMonth(), daysportdata.getDay(), 0, 0);
        }
        if (i4 > j4)
        {
            i10 = (1 + (i4 - j4)) - l1;
        } else
        {
            i10 = 0;
        }
        if (i10 > 0)
        {
            calendar1.add(12, j4);
            calendar2.add(12, i4 + 1);
            sleepinfo.setStartDate(calendar1.getTime());
            sleepinfo.setStopDate(calendar2.getTime());
            sleepinfo.setSleepCount(i10);
            sleepinfo.setRemCount(i10 - i2);
            sleepinfo.setNonRemCount(i2);
            if (l1 < 0)
            {
                i11 = 0;
            } else
            {
                i11 = l1;
            }
            sleepinfo.setAwakeCount(i11);
            sleepinfo.setAwakeNum(k1);
            calendar1.add(12, c3.c - j4);
            calendar2.add(12, c3.d - i4);
            sleepinfo.setStartOnBedDate(calendar1.getTime());
            sleepinfo.setStopOnBedDate(calendar2.getTime());
        } else
        {
            if (!flag2)
            {
                calendar1.add(5, 1);
                calendar2.add(5, 1);
            }
            sleepinfo.setStartDate(calendar1.getTime());
            sleepinfo.setStopDate(calendar2.getTime());
            sleepinfo.setStartOnBedDate(calendar1.getTime());
            sleepinfo.setStopOnBedDate(calendar2.getTime());
            sleepinfo.setNosleepReason(SleepInfo.NOSLEEP_NONWEAR);
        }
        sleepinfo.setHasSleep(c3.i);
        if (usersleepmodify != null && usersleepmodify.sleepStart > 0x80000000)
        {
            sleepinfo.setUserSleepStart(usersleepmodify.sleepStart);
        }
        if (usersleepmodify != null && usersleepmodify.sleepEnd > 0x80000000)
        {
            sleepinfo.setUserSleepEnd(usersleepmodify.sleepEnd);
        }
        stepsinfo.setStepsCount(k7);
        j10 = l8 / 60;
        if (j7 >= j10)
        {
            k10 = j7 - j10;
        } else
        {
            k10 = j7;
        }
        stepsinfo.setStepsTimeCount(k10);
        stepsinfo.setRunTimeCount(j10);
        stepsinfo.setDistance((int)d5);
        stepsinfo.setRunDistance((int)d4);
        stepsinfo.setCalories((int)d1);
        stepsinfo.setActMinutes(j7);
        stepsinfo.setContinuesActive(k8);
        stepsinfo.setStageSteps(arraylist6);
        stepsinfo.setActiveList(arraylist10);
        if (DEBUG)
        {
            Debug.i("DataAnalysis", (new StringBuilder()).append("Sleep(").append(calendar1.toString()).append("->").append(calendar2.toString()).append("), sleeps=").append(i10).append(",REM=").append(0).append(",NREM=").append(i2).append(",Steps=").append(k7).append(",totalStepMins=").append(j7).append(",totalRunMins=").append(j10).toString());
        }
        daysportdata1.setStepsInfo(stepsinfo);
        daysportdata1.setSleepInfo(sleepinfo);
        daysportdata1.setAnalysisData(arraylist4);
        daysportdata1.setNeedPostProcess(false);
        if (usersleepmodify == null || flag2 || usersleepmodify.sleepStart >= 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        arraylist11 = new ArrayList(1440);
        l10 = 0;
        if (l10 >= 1440)
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist11.add(((SportData)arraylist5.get(l10)).copy());
        l10++;
        if (true) goto _L16; else goto _L15
_L16:
        break MISSING_BLOCK_LABEL_4685;
        clonenotsupportedexception;
        clonenotsupportedexception.printStackTrace();
        arraylist11.clear();
_L15:
        daysportdata.setAnalysisData(arraylist11);
        daysportdata.setNeedPostProcess(false);
        if (!DEBUG) goto _L1; else goto _L17
_L17:
        Debug.i("DataAnalysis", (new StringBuilder()).append("used ").append(System.currentTimeMillis() - l).append("ms!").toString());
        return;
        l18 = k6;
        i19 = j6;
        j19 = i6;
        k19 = k5;
        d8 = d4;
        d9 = d5;
        l19 = j7;
        d10 = d1;
        i20 = k7;
          goto _L18
    }

    static 
    {
        DEBUG = true;
    }
}
