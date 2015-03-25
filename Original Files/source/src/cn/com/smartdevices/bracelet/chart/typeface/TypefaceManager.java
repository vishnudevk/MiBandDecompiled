// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.typeface;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class TypefaceManager
{

    private static final TypefaceManager a = new TypefaceManager();
    private final HashMap b = new HashMap();
    private final HashSet c = new HashSet();

    private TypefaceManager()
    {
    }

    public static void addTextStyleExtractor(TextStyleExtractor textstyleextractor)
    {
        a.c.add(textstyleextractor);
    }

    public static TypefaceManager getInstance()
    {
        return a;
    }

    public void applyTypeface(TextView textview, Context context, AttributeSet attributeset)
    {
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, new int[] {
            0x10103ac
        });
        applyTypeface(textview, typedarray.getString(0));
        typedarray.recycle();
    }

    public void applyTypeface(TextView textview, TextStyle textstyle)
    {
        Typeface typeface = getTypeface(textview.getContext(), textstyle);
        if (typeface != null)
        {
            textview.setTypeface(typeface);
        }
    }

    public void applyTypeface(TextView textview, String s)
    {
        Typeface typeface = getTypeface(textview.getContext(), s);
        if (typeface != null)
        {
            textview.setTypeface(typeface);
        }
    }

    public Typeface getTypeface(Context context, TextStyle textstyle)
    {
        Typeface typeface = null;
        if (textstyle != null) goto _L2; else goto _L1
_L1:
        return typeface;
_L2:
        if (!b.containsKey(textstyle))
        {
            break MISSING_BLOCK_LABEL_98;
        }
        if ((typeface = (Typeface)((WeakReference)b.get(textstyle)).get()) != null) goto _L1; else goto _L3
_L3:
        Typeface typeface1 = typeface;
_L5:
        Typeface typeface2 = Typeface.createFromAsset(context.getAssets(), textstyle.getFontName());
        typeface = typeface2;
_L4:
        if (typeface != null)
        {
            b.put(textstyle, new WeakReference(typeface));
            return typeface;
        }
          goto _L1
        Exception exception;
        exception;
        exception.printStackTrace();
        typeface = typeface1;
          goto _L4
        typeface1 = null;
          goto _L5
    }

    public Typeface getTypeface(Context context, String s)
    {
label0:
        {
            if (TextUtils.isEmpty(s))
            {
                break label0;
            }
            Iterator iterator = c.iterator();
            TextStyle textstyle;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                textstyle = ((TextStyleExtractor)iterator.next()).getTextStyle(s);
            } while (textstyle == null);
            return getTypeface(context, textstyle);
        }
        return null;
    }


    private class TextStyle
    {

        public abstract String getFontName();

        public abstract String getName();
    }


    private class TextStyleExtractor
    {

        public TextStyle getTextStyle(String s)
        {
            TextStyle atextstyle[] = getTextStyles();
            int i = atextstyle.length;
            for (int j = 0; j < i; j++)
            {
                TextStyle textstyle = atextstyle[j];
                if (textstyle.getName().equals(s))
                {
                    return textstyle;
                }
            }

            return null;
        }

        public abstract TextStyle[] getTextStyles();

        public TextStyleExtractor()
        {
        }
    }

}
