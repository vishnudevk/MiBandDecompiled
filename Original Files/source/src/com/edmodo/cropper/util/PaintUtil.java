// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.edmodo.cropper.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.TypedValue;

public class PaintUtil
{

    private static final int a = -1;
    private static final String b = "#AAFFFFFF";
    private static final String c = "#B0000000";
    private static final float d = 1F;
    private static final float e = 2F;
    private static final float f = 1F;

    public PaintUtil()
    {
    }

    public static float getCornerThickness()
    {
        return 2.0F;
    }

    public static float getLineThickness()
    {
        return 1.0F;
    }

    public static Paint newBackgroundPaint(Context context)
    {
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#B0000000"));
        return paint;
    }

    public static Paint newBorderPaint(Context context)
    {
        float f1 = TypedValue.applyDimension(1, 1.0F, context.getResources().getDisplayMetrics());
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#AAFFFFFF"));
        paint.setStrokeWidth(f1);
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        paint.setAntiAlias(true);
        return paint;
    }

    public static Paint newCornerPaint(Context context)
    {
        float f1 = TypedValue.applyDimension(1, 2.0F, context.getResources().getDisplayMetrics());
        Paint paint = new Paint();
        paint.setColor(-1);
        paint.setStrokeWidth(f1);
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        return paint;
    }

    public static Paint newGuidelinePaint()
    {
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#AAFFFFFF"));
        paint.setStrokeWidth(1.0F);
        return paint;
    }
}
