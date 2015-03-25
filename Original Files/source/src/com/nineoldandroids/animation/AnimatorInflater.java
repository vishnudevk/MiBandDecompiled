// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.animation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.animation.AnimationUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package com.nineoldandroids.animation:
//            Animator, AnimatorSet, ObjectAnimator, ValueAnimator, 
//            ArgbEvaluator

public class AnimatorInflater
{

    private static final int a[] = {
        0x10102e2
    };
    private static final int b = 0;
    private static final int c[] = {
        0x10102e1
    };
    private static final int d = 0;
    private static final int e[] = {
        0x1010141, 0x1010198, 0x10101be, 0x10101bf, 0x10101c0, 0x10102de, 0x10102df, 0x10102e0
    };
    private static final int f = 0;
    private static final int g = 1;
    private static final int h = 2;
    private static final int i = 3;
    private static final int j = 4;
    private static final int k = 5;
    private static final int l = 6;
    private static final int m = 7;
    private static final int n;
    private static final int o;

    public AnimatorInflater()
    {
    }

    private static Animator a(Context context, XmlPullParser xmlpullparser)
    {
        return a(context, xmlpullparser, Xml.asAttributeSet(xmlpullparser), null, 0);
    }

    private static Animator a(Context context, XmlPullParser xmlpullparser, AttributeSet attributeset, AnimatorSet animatorset, int i1)
    {
        int j1;
        int k1;
        ArrayList arraylist;
        Object obj;
        j1 = 0;
        k1 = xmlpullparser.getDepth();
        arraylist = null;
        obj = null;
_L10:
        int l1 = xmlpullparser.next();
        if ((l1 != 3 || xmlpullparser.getDepth() > k1) && l1 != 1) goto _L2; else goto _L1
_L1:
        if (animatorset == null || arraylist == null) goto _L4; else goto _L3
_L3:
        Animator aanimator[];
        Iterator iterator;
        aanimator = new Animator[arraylist.size()];
        iterator = arraylist.iterator();
_L8:
        if (iterator.hasNext()) goto _L6; else goto _L5
_L5:
        if (i1 != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        animatorset.playTogether(aanimator);
_L4:
        return ((Animator) (obj));
_L2:
        if (l1 == 2)
        {
            String s = xmlpullparser.getName();
            if (s.equals("objectAnimator"))
            {
                obj = a(context, attributeset);
            } else
            if (s.equals("animator"))
            {
                obj = a(context, attributeset, null);
            } else
            if (s.equals("set"))
            {
                obj = new AnimatorSet();
                TypedArray typedarray = context.obtainStyledAttributes(attributeset, a);
                TypedValue typedvalue = new TypedValue();
                typedarray.getValue(0, typedvalue);
                int i2;
                if (typedvalue.type == 16)
                {
                    i2 = typedvalue.data;
                } else
                {
                    i2 = 0;
                }
                a(context, xmlpullparser, attributeset, (AnimatorSet)obj, i2);
                typedarray.recycle();
            } else
            {
                throw new RuntimeException((new StringBuilder("Unknown animator name: ")).append(xmlpullparser.getName()).toString());
            }
            if (animatorset != null)
            {
                ArrayList arraylist1;
                Animator animator;
                int j2;
                if (arraylist == null)
                {
                    arraylist1 = new ArrayList();
                } else
                {
                    arraylist1 = arraylist;
                }
                arraylist1.add(obj);
                arraylist = arraylist1;
            }
        }
        continue; /* Loop/switch isn't completed */
_L6:
        animator = (Animator)iterator.next();
        j2 = j1 + 1;
        aanimator[j1] = animator;
        j1 = j2;
        if (true) goto _L8; else goto _L7
_L7:
        animatorset.playSequentially(aanimator);
        return ((Animator) (obj));
        if (true) goto _L10; else goto _L9
_L9:
    }

    private static ObjectAnimator a(Context context, AttributeSet attributeset)
    {
        ObjectAnimator objectanimator = new ObjectAnimator();
        a(context, attributeset, ((ValueAnimator) (objectanimator)));
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, c);
        objectanimator.setPropertyName(typedarray.getString(0));
        typedarray.recycle();
        return objectanimator;
    }

    private static ValueAnimator a(Context context, AttributeSet attributeset, ValueAnimator valueanimator)
    {
        TypedArray typedarray;
        boolean flag1;
        int j1;
        boolean flag2;
        int k1;
        typedarray = context.obtainStyledAttributes(attributeset, e);
        long l1 = typedarray.getInt(1, 0);
        long l2 = typedarray.getInt(2, 0);
        int i1 = typedarray.getInt(7, 0);
        if (valueanimator == null)
        {
            valueanimator = new ValueAnimator();
        }
        boolean flag;
        TypedValue typedvalue;
        TypedValue typedvalue1;
        int j2;
        if (i1 == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        typedvalue = typedarray.peekValue(5);
        if (typedvalue != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1)
        {
            j1 = typedvalue.type;
        } else
        {
            j1 = 0;
        }
        typedvalue1 = typedarray.peekValue(6);
        if (typedvalue1 != null)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (flag2)
        {
            k1 = typedvalue1.type;
        } else
        {
            k1 = 0;
        }
        if (flag1 && j1 >= 28 && j1 <= 31 || flag2 && k1 >= 28 && k1 <= 31)
        {
            flag = false;
            valueanimator.setEvaluator(new ArgbEvaluator());
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        if (flag1)
        {
            float f2;
            if (j1 == 5)
            {
                f2 = typedarray.getDimension(5, 0.0F);
            } else
            {
                f2 = typedarray.getFloat(5, 0.0F);
            }
            if (flag2)
            {
                float f3;
                if (k1 == 5)
                {
                    f3 = typedarray.getDimension(6, 0.0F);
                } else
                {
                    f3 = typedarray.getFloat(6, 0.0F);
                }
                valueanimator.setFloatValues(new float[] {
                    f2, f3
                });
            } else
            {
                valueanimator.setFloatValues(new float[] {
                    f2
                });
            }
        } else
        {
            float f1;
            if (k1 == 5)
            {
                f1 = typedarray.getDimension(6, 0.0F);
            } else
            {
                f1 = typedarray.getFloat(6, 0.0F);
            }
            valueanimator.setFloatValues(new float[] {
                f1
            });
        }
_L4:
        valueanimator.setDuration(l1);
        valueanimator.setStartDelay(l2);
        if (typedarray.hasValue(3))
        {
            valueanimator.setRepeatCount(typedarray.getInt(3, 0));
        }
        if (typedarray.hasValue(4))
        {
            valueanimator.setRepeatMode(typedarray.getInt(4, 1));
        }
        j2 = typedarray.getResourceId(0, 0);
        if (j2 > 0)
        {
            valueanimator.setInterpolator(AnimationUtils.loadInterpolator(context, j2));
        }
        typedarray.recycle();
        return valueanimator;
_L2:
        int i2;
        if (flag1)
        {
            int k2;
            if (j1 == 5)
            {
                k2 = (int)typedarray.getDimension(5, 0.0F);
            } else
            if (j1 >= 28 && j1 <= 31)
            {
                k2 = typedarray.getColor(5, 0);
            } else
            {
                k2 = typedarray.getInt(5, 0);
            }
            if (flag2)
            {
                int i3;
                if (k1 == 5)
                {
                    i3 = (int)typedarray.getDimension(6, 0.0F);
                } else
                if (k1 >= 28 && k1 <= 31)
                {
                    i3 = typedarray.getColor(6, 0);
                } else
                {
                    i3 = typedarray.getInt(6, 0);
                }
                valueanimator.setIntValues(new int[] {
                    k2, i3
                });
            } else
            {
                valueanimator.setIntValues(new int[] {
                    k2
                });
            }
            continue; /* Loop/switch isn't completed */
        }
        if (!flag2)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (k1 != 5)
        {
            break; /* Loop/switch isn't completed */
        }
        i2 = (int)typedarray.getDimension(6, 0.0F);
_L5:
        valueanimator.setIntValues(new int[] {
            i2
        });
        if (true) goto _L4; else goto _L3
_L3:
        if (k1 >= 28 && k1 <= 31)
        {
            i2 = typedarray.getColor(6, 0);
        } else
        {
            i2 = typedarray.getInt(6, 0);
        }
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }

    public static Animator loadAnimator(Context context, int i1)
    {
        XmlResourceParser xmlresourceparser = null;
        Animator animator;
        xmlresourceparser = context.getResources().getAnimation(i1);
        animator = a(context, xmlresourceparser);
        if (xmlresourceparser != null)
        {
            xmlresourceparser.close();
        }
        return animator;
        XmlPullParserException xmlpullparserexception;
        xmlpullparserexception;
        android.content.res.Resources.NotFoundException notfoundexception1 = new android.content.res.Resources.NotFoundException((new StringBuilder("Can't load animation resource ID #0x")).append(Integer.toHexString(i1)).toString());
        notfoundexception1.initCause(xmlpullparserexception);
        throw notfoundexception1;
        Exception exception;
        exception;
        if (xmlresourceparser != null)
        {
            xmlresourceparser.close();
        }
        throw exception;
        IOException ioexception;
        ioexception;
        android.content.res.Resources.NotFoundException notfoundexception = new android.content.res.Resources.NotFoundException((new StringBuilder("Can't load animation resource ID #0x")).append(Integer.toHexString(i1)).toString());
        notfoundexception.initCause(ioexception);
        throw notfoundexception;
    }

}
