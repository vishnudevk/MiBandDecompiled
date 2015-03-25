// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.util;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Debug;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.util:
//            d, e, l, a, 
//            f, m, b, c, 
//            g, h, i, j, 
//            k

public class AnimUtil
{

    public static final int DURATION_CHART_SLEEP_SWITCH = 650;
    public static final int DURATION_CHART_STEP_SLEEP_SWITCH = 500;
    public static final int DURATION_CHART_STEP_SWITCH = 550;
    public static final int DURATION_DATE_SWITCH = 600;
    public static final int DURATION_FLOW_IN = 600;
    public static final int DURATION_LOADING = 3500;
    public static final int DURATION_NUM_SWITCH = 20;
    public static final int DURATION_PIE_CHART = 800;
    private static final String a = "Chart.AnimUtil";
    private static LayoutTransition b;
    private static LayoutTransition c;

    public AnimUtil()
    {
    }

    private static LayoutTransition a()
    {
        LayoutTransition layouttransition = new LayoutTransition();
        layouttransition.setDuration(90L);
        layouttransition.setInterpolator(2, new AccelerateDecelerateInterpolator());
        layouttransition.setInterpolator(3, new AccelerateDecelerateInterpolator());
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(null, "rotationX", new float[] {
            90F, 0.0F
        }).setDuration(layouttransition.getDuration(2));
        layouttransition.setAnimator(2, objectanimator);
        objectanimator.addListener(new d());
        ObjectAnimator objectanimator1 = ObjectAnimator.ofFloat(null, "rotationX", new float[] {
            0.0F, -90F
        }).setDuration(layouttransition.getDuration(3));
        layouttransition.setAnimator(3, objectanimator1);
        objectanimator1.addListener(new e());
        return layouttransition;
    }

    private static String a(String s, String s1, int i1, int j1)
    {
        Debug.i("Chart.AnimUtil", (new StringBuilder()).append("Change Digital Index : ").append(i1).append(" , ").append(j1).toString());
        if (s.length() < s1.length())
        {
            int i2 = s1.length() - s.length();
            for (int j2 = 0; j2 < i2; j2++)
            {
                s = (new StringBuilder()).append('0').append(s).toString();
            }

        } else
        if (s1.length() < s.length())
        {
            int k1 = s.length() - s1.length();
            for (int l1 = 0; l1 < k1; l1++)
            {
                s1 = (new StringBuilder()).append('0').append(s1).toString();
            }

        }
        String s2;
        String s3;
        String s4;
        if (i1 == 0)
        {
            s2 = "";
        } else
        {
            s2 = s.substring(s1.length() - i1, s1.length());
        }
        if (i1 == -1 + s.length())
        {
            s3 = "";
        } else
        {
            s3 = s1.substring(0, -1 + (s.length() - i1));
        }
        s4 = Integer.valueOf((new StringBuilder()).append(s3).append(j1).append(s2).toString()).toString();
        Debug.i("Chart.AnimUtil", (new StringBuilder()).append("Show Num : ").append(s4).toString());
        return s4;
    }

    public static transient Animator animColorTrans(int i1, int j1, AnimColorListener animcolorlistener, View aview[])
    {
        ValueAnimator valueanimator = ValueAnimator.ofFloat(new float[] {
            0.0F, 1.0F
        });
        int k1 = Color.red(j1);
        int l1 = Color.green(j1);
        int i2 = Color.blue(j1);
        valueanimator.addUpdateListener(new l(k1, Color.red(i1), l1, Color.green(i1), i2, Color.blue(i1), aview, animcolorlistener));
        valueanimator.setInterpolator(new AccelerateInterpolator());
        valueanimator.setDuration(500L);
        return valueanimator;
    }

    public static transient Animator animColorTrans(int i1, int j1, View aview[])
    {
        return animColorTrans(i1, j1, null, aview);
    }

    public static Animator animDateSwitch(String s, String s1, TextView textview, TextView textview1)
    {
        ValueAnimator valueanimator = ValueAnimator.ofFloat(new float[] {
            0.0F, 1.0F
        });
        valueanimator.addListener(new a(textview, s, textview1, s1));
        valueanimator.addUpdateListener(new f(textview, textview1));
        valueanimator.setDuration(600L);
        return valueanimator;
    }

    public static Animator animFade(View view, float f1, float f2)
    {
        return ObjectAnimator.ofFloat(view, "alpha", new float[] {
            f1, f2
        });
    }

    public static Animator animFadeIn(View view)
    {
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(view, "alpha", new float[] {
            0.3F, 1.0F
        });
        objectanimator.setInterpolator(new AccelerateInterpolator());
        return objectanimator;
    }

    public static Animator animFlow(android.animation.ValueAnimator.AnimatorUpdateListener animatorupdatelistener)
    {
        ValueAnimator valueanimator = ValueAnimator.ofFloat(new float[] {
            0.0F, 1.0F
        });
        valueanimator.setInterpolator(new AccelerateInterpolator());
        valueanimator.addUpdateListener(animatorupdatelistener);
        return valueanimator;
    }

    public static void animInfoSwitch(ViewGroup viewgroup, ViewGroup viewgroup1)
    {
        int i1 = 0;
        if (b == null)
        {
            b = a();
        }
        if (c == null)
        {
            c = a();
        }
        viewgroup.setLayoutTransition(b);
        viewgroup1.setLayoutTransition(c);
        viewgroup1.setVisibility(0);
        int j1 = viewgroup.getChildCount();
        int k1 = 0;
        int l1 = 0;
        for (; k1 < j1; k1++)
        {
            View view1 = viewgroup.getChildAt(k1);
            if (k1 * (100 - k1 * 10) > l1)
            {
                l1 = k1 * (100 - k1 * 10);
            }
            viewgroup.postDelayed(new m(view1), l1);
            if (k1 == j1 - 1)
            {
                viewgroup.postDelayed(new b(viewgroup), l1 + 90);
            }
        }

        int i2 = viewgroup1.getChildCount();
        int j2 = 0;
        for (; i1 < i2; i1++)
        {
            View view = viewgroup1.getChildAt(i1);
            if (i1 * (100 - i1 * 10) > j2)
            {
                j2 = i1 * (100 - i1 * 10);
            }
            viewgroup1.postDelayed(new c(view), j2);
        }

    }

    public static Animator animNumSwitch(int i1, int j1, TextView textview)
    {
        int k1 = j1 - i1;
        String s = String.valueOf(Math.abs(k1));
        int ai[] = new int[s.length()];
        for (int l1 = 0; l1 < s.length(); l1++)
        {
            ai[l1] = -48 + s.charAt(-1 + (s.length() - l1));
        }

        ArrayList arraylist = new ArrayList();
        arraylist.add(formatNumStyle(i1));
        int i2 = 0;
        int j2 = 1;
        do
        {
            if (i2 >= ai.length)
            {
                break;
            }
            int i3 = Integer.valueOf(ai[i2]).intValue();
            int j3 = 0;
            while (j3 < i3) 
            {
                if (k1 > 0)
                {
                    i1 += j2;
                } else
                if (k1 < 0)
                {
                    i1 -= j2;
                }
                arraylist.add(formatNumStyle(i1));
                j3++;
            }
            j2 *= 10;
            i2++;
        } while (true);
        arraylist.add(formatNumStyle(j1));
        Keyframe akeyframe[] = new Keyframe[1 + arraylist.size()];
        int k2 = 0;
        while (k2 <= arraylist.size()) 
        {
            float f1 = (1.0F / (float)arraylist.size()) * (float)k2;
            int l2;
            if (k2 == 0)
            {
                l2 = 0;
            } else
            {
                l2 = k2 - 1;
            }
            akeyframe[k2] = Keyframe.ofObject(f1, arraylist.get(l2));
            k2++;
        }
        ValueAnimator valueanimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] {
            PropertyValuesHolder.ofKeyframe("Text", akeyframe)
        });
        valueanimator.setEvaluator(new g());
        valueanimator.addUpdateListener(new h(textview));
        valueanimator.setDuration(20 * akeyframe.length);
        return valueanimator;
    }

    public static Animator animNumSwitch1(int i1, int j1, TextView textview)
    {
        String s = String.valueOf(i1);
        int ai[] = new int[s.length()];
        for (int k1 = 0; k1 < s.length(); k1++)
        {
            ai[-1 + (s.length() - k1)] = -48 + s.charAt(k1);
            Debug.i("Chart.AnimUtil", (new StringBuilder()).append("Num : ").append(ai[-1 + (s.length() - k1)]).toString());
        }

        String s1 = String.valueOf(j1);
        int ai1[] = new int[s1.length()];
        for (int l1 = 0; l1 < s1.length(); l1++)
        {
            ai1[-1 + (s1.length() - l1)] = -48 + s1.charAt(l1);
            Debug.i("Chart.AnimUtil", (new StringBuilder()).append("Num : ").append(ai1[-1 + (s1.length() - l1)]).toString());
        }

        ArrayList arraylist = new ArrayList();
        for (int i2 = -1 + ai1.length; i2 >= 0; i2--)
        {
            int k2 = ai1[i2];
            int l2;
            if (ai.length > i2)
            {
                l2 = ai[i2];
            } else
            {
                l2 = 0;
            }
            if (k2 > l2)
            {
                for (int j3 = 0; j3 < 1 + (k2 - l2); j3++)
                {
                    arraylist.add(a(s, s1, i2, l2 + j3));
                }

                continue;
            }
            if (k2 < l2)
            {
                for (int i3 = 0; i3 < 1 + (l2 - k2); i3++)
                {
                    arraylist.add(a(s, s1, i2, l2 - i3));
                }

            } else
            {
                arraylist.add(a(s, s1, i2, l2));
            }
        }

        Keyframe akeyframe[] = new Keyframe[1 + arraylist.size()];
        Iterator iterator = arraylist.iterator();
        int j2 = 0;
        while (iterator.hasNext()) 
        {
            String s2 = (String)iterator.next();
            j2++;
            akeyframe[j2] = Keyframe.ofObject((1.0F / (float)arraylist.size()) * (float)j2, s2);
        }
        akeyframe[0] = akeyframe[1];
        ValueAnimator valueanimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] {
            PropertyValuesHolder.ofKeyframe("Text", akeyframe)
        });
        valueanimator.setEvaluator(new i());
        valueanimator.addUpdateListener(new j(textview));
        valueanimator.setDuration(20L);
        return valueanimator;
    }

    public static Animator animNumSwitch2(int i1, int j1, TextView textview)
    {
        ValueAnimator valueanimator = ValueAnimator.ofInt(new int[] {
            i1, j1
        });
        valueanimator.addUpdateListener(new k(textview));
        valueanimator.setDuration(500L);
        return valueanimator;
    }

    public static Animator animScaleX(View view, float f1, float f2)
    {
        return ObjectAnimator.ofFloat(view, "scaleX", new float[] {
            f1, f2
        });
    }

    public static Animator animSlideIn(int i1, View view)
    {
        float af[] = new float[2];
        af[0] = i1;
        af[1] = 0.0F;
        return ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[] {
            PropertyValuesHolder.ofFloat("translationY", af), PropertyValuesHolder.ofFloat("alpha", new float[] {
                0.3F, 1.0F
            })
        });
    }

    public static Animator animSlideOut(int i1, View view)
    {
        float af[] = new float[2];
        af[0] = 0.0F;
        af[1] = -i1;
        return ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[] {
            PropertyValuesHolder.ofFloat("translationY", af), PropertyValuesHolder.ofFloat("alpha", new float[] {
                0.7F, 0.0F
            })
        });
    }

    public static void dismissChildren(ViewGroup viewgroup)
    {
        int i1 = viewgroup.getChildCount();
        for (int j1 = 0; j1 < i1; j1++)
        {
            viewgroup.getChildAt(j1).setVisibility(4);
        }

        viewgroup.setVisibility(8);
    }

    public static String formatNum(int i1)
    {
        String s = String.valueOf(i1);
        if (i1 == 0)
        {
            s = "0000";
        } else
        if (s.length() < 4)
        {
            switch (s.length())
            {
            default:
                return s;

            case 1: // '\001'
                return (new StringBuilder()).append("000").append(s).toString();

            case 2: // '\002'
                return (new StringBuilder()).append("00").append(s).toString();

            case 3: // '\003'
                return (new StringBuilder()).append("0").append(s).toString();
            }
        }
        return s;
    }

    public static CharSequence formatNumStyle(int i1)
    {
        SpannableStringBuilder spannablestringbuilder;
        ForegroundColorSpan foregroundcolorspan;
        String s;
        String s1;
        spannablestringbuilder = new SpannableStringBuilder();
        foregroundcolorspan = new ForegroundColorSpan(0x99ffffff);
        s = String.valueOf(i1);
        s1 = "";
        if (i1 != 0) goto _L2; else goto _L1
_L1:
        s1 = "0000";
_L4:
        SpannableString spannablestring = new SpannableString(s1);
        spannablestring.setSpan(foregroundcolorspan, 0, s1.length(), 33);
        SpannableString spannablestring1 = new SpannableString(s);
        if (i1 == 0)
        {
            spannablestringbuilder.append(spannablestring);
            return spannablestringbuilder;
        } else
        {
            spannablestringbuilder.append(spannablestring).append(spannablestring1);
            return spannablestringbuilder;
        }
_L2:
        if (s.length() >= 4) goto _L4; else goto _L3
_L3:
        switch (s.length())
        {
        case 1: // '\001'
            s1 = "000";
            break;

        case 2: // '\002'
            s1 = "00";
            break;

        case 3: // '\003'
            s1 = "0";
            break;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public static long getAnimDuration(AnimatorSet animatorset)
    {
        Iterator iterator = animatorset.getChildAnimations().iterator();
        long l1 = 0L;
        while (iterator.hasNext()) 
        {
            Animator animator = (Animator)iterator.next();
            long l2 = animator.getStartDelay() + animator.getDuration();
            long l3;
            if (l2 > l1)
            {
                l3 = l2;
            } else
            {
                l3 = l1;
            }
            l1 = l3;
        }
        return l1;
    }

    public static void infoSwitch(ViewGroup viewgroup, ViewGroup viewgroup1)
    {
        viewgroup.setLayoutTransition(null);
        viewgroup1.setLayoutTransition(null);
        dismissChildren(viewgroup);
        showChildren(viewgroup1);
    }

    public static void seekAnim(AnimatorSet animatorset, long l1)
    {
        if (animatorset != null)
        {
            if (animatorset.isStarted())
            {
                animatorset.end();
            }
            Iterator iterator = animatorset.getChildAnimations().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Animator animator = (Animator)iterator.next();
                long l2 = l1 - animator.getStartDelay();
                if (l2 < 0L)
                {
                    l2 = 0L;
                }
                if (animator instanceof ValueAnimator)
                {
                    ((ValueAnimator)animator).setCurrentPlayTime(l2);
                }
            } while (true);
        }
    }

    public static void seekAnim(View view, AnimatorSet animatorset, long l1)
    {
        seekAnim(animatorset, l1);
        view.postInvalidateOnAnimation();
    }

    public static void showChildren(ViewGroup viewgroup)
    {
        int i1 = viewgroup.getChildCount();
        for (int j1 = 0; j1 < i1; j1++)
        {
            viewgroup.getChildAt(j1).setVisibility(0);
        }

        viewgroup.setVisibility(0);
    }
}
