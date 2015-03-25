// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.edmodo.cropper;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import cn.com.smartdevices.bracelet.Debug;
import com.edmodo.cropper.cropwindow.CropOverlayView;
import com.edmodo.cropper.cropwindow.edge.Edge;
import com.edmodo.cropper.util.ImageViewUtil;

public class CropImageView extends FrameLayout
{

    public static final int DEFAULT_ASPECT_RATIO_X = 1;
    public static final int DEFAULT_ASPECT_RATIO_Y = 1;
    public static final boolean DEFAULT_FIXED_ASPECT_RATIO = false;
    public static final int DEFAULT_GUIDELINES = 1;
    private static final Rect a = new Rect();
    private static final int b = 0;
    private static final String c = "DEGREES_ROTATED";
    private static final String d = "CropImageView";
    private ImageView e;
    private CropOverlayView f;
    private Bitmap g;
    private int h;
    private int i;
    private int j;
    private int k;
    private boolean l;
    private int m;
    private int n;
    private int o;

    public CropImageView(Context context)
    {
        super(context);
        h = 0;
        k = 1;
        l = false;
        m = 1;
        n = 1;
        o = 0;
        a(context);
    }

    public CropImageView(Context context, AttributeSet attributeset)
    {
        TypedArray typedarray;
        super(context, attributeset);
        h = 0;
        k = 1;
        l = false;
        m = 1;
        n = 1;
        o = 0;
        typedarray = context.obtainStyledAttributes(attributeset, com.xiaomi.hm.health.R.styleable.CropImageView, 0, 0);
        k = typedarray.getInteger(0, 1);
        l = typedarray.getBoolean(1, false);
        m = typedarray.getInteger(2, 1);
        n = typedarray.getInteger(3, 1);
        o = typedarray.getResourceId(4, 0);
        typedarray.recycle();
_L2:
        a(context);
        return;
        Exception exception1;
        exception1;
        exception1.printStackTrace();
        typedarray.recycle();
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        typedarray.recycle();
        throw exception;
    }

    private static int a(int i1, int j1, int k1)
    {
        if (i1 == 0x40000000)
        {
            return j1;
        }
        if (i1 == 0x80000000)
        {
            return Math.min(k1, j1);
        } else
        {
            return k1;
        }
    }

    private void a(Context context)
    {
        View view = LayoutInflater.from(context).inflate(0x7f03001a, this, true);
        e = (ImageView)view.findViewById(0x7f0a009c);
        setImageResource(o);
        f = (CropOverlayView)view.findViewById(0x7f0a009d);
        f.setInitialAttributeValues(k, l, m, n);
    }

    public RectF getActualCropRect()
    {
        Rect rect = ImageViewUtil.getBitmapRectCenterInside(g, e);
        float f1 = (float)g.getWidth() / (float)rect.width();
        float f2 = (float)g.getHeight() / (float)rect.height();
        float f3 = Edge.LEFT.getCoordinate() - (float)rect.left;
        float f4 = Edge.TOP.getCoordinate() - (float)rect.top;
        float f5 = Edge.getWidth();
        float f6 = Edge.getHeight();
        float f7 = f3 * f1;
        float f8 = f4 * f2;
        float f9 = f7 + f1 * f5;
        float f10 = f8 + f2 * f6;
        return new RectF(Math.max(0.0F, f7), Math.max(0.0F, f8), Math.min(g.getWidth(), f9), Math.min(g.getHeight(), f10));
    }

    public Bitmap getCroppedImage(int i1, int j1)
    {
        if (g == null)
        {
            return null;
        }
        Rect rect = ImageViewUtil.getBitmapRectCenterInside(g, e);
        float f1 = (float)g.getWidth() / (float)rect.width();
        float f2 = (float)g.getHeight() / (float)rect.height();
        float f3 = Edge.LEFT.getCoordinate() - (float)rect.left;
        float f4 = Edge.TOP.getCoordinate() - (float)rect.top;
        float f5 = Edge.getWidth();
        float f6 = Edge.getHeight();
        float f7 = f3 * f1;
        float f8 = f4 * f2;
        float f9 = f5 * f1;
        float f10 = f6 * f2;
        Debug.i("CropImageView", (new StringBuilder()).append(", actualCropWidth=").append(f9).append(", actualCropHeight=").append(f10).toString());
        if (f9 < 100F || f10 < 100F)
        {
            return g;
        }
        Matrix matrix = new Matrix();
        if ((float)i1 < f9 || (float)j1 < f10)
        {
            float f11 = (float)i1 / f9;
            float f12 = (float)j1 / f10;
            Debug.i("CropImageView", (new StringBuilder()).append("scaleWidth = ").append(f11).append(", scaleHeight=").append(f12).toString());
            matrix.postScale(f11, f12);
        }
        return Bitmap.createBitmap(g, (int)f7, (int)f8, (int)f9, (int)f10, matrix, false);
    }

    public int getImageResource()
    {
        return o;
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        super.onLayout(flag, i1, j1, k1, l1);
        if (i > 0 && j > 0)
        {
            android.view.ViewGroup.LayoutParams layoutparams = getLayoutParams();
            layoutparams.width = i;
            layoutparams.height = j;
            setLayoutParams(layoutparams);
        }
    }

    protected void onMeasure(int i1, int j1)
    {
        int k1 = android.view.View.MeasureSpec.getMode(i1);
        int l1 = android.view.View.MeasureSpec.getSize(i1);
        int i2 = android.view.View.MeasureSpec.getMode(j1);
        int j2 = android.view.View.MeasureSpec.getSize(j1);
        if (g != null)
        {
            super.onMeasure(i1, j1);
            if (j2 == 0)
            {
                j2 = g.getHeight();
            }
            double d1;
            double d2;
            int k2;
            int l2;
            int i3;
            int j3;
            Rect rect;
            if (l1 < g.getWidth())
            {
                d1 = (double)l1 / (double)g.getWidth();
            } else
            {
                d1 = (1.0D / 0.0D);
            }
            if (j2 < g.getHeight())
            {
                d2 = (double)j2 / (double)g.getHeight();
            } else
            {
                d2 = (1.0D / 0.0D);
            }
            if (d1 != (1.0D / 0.0D) || d2 != (1.0D / 0.0D))
            {
                if (d1 <= d2)
                {
                    l2 = (int)(d1 * (double)g.getHeight());
                    k2 = l1;
                } else
                {
                    k2 = (int)(d2 * (double)g.getWidth());
                    l2 = j2;
                }
            } else
            {
                k2 = g.getWidth();
                l2 = g.getHeight();
            }
            i3 = a(k1, l1, k2);
            j3 = a(i2, j2, l2);
            i = i3;
            j = j3;
            rect = ImageViewUtil.getBitmapRectCenterInside(g.getWidth(), g.getHeight(), i, j);
            f.setBitmapRect(rect);
            setMeasuredDimension(i, j);
            return;
        } else
        {
            f.setBitmapRect(a);
            setMeasuredDimension(l1, j2);
            return;
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        if (parcelable instanceof Bundle)
        {
            Bundle bundle = (Bundle)parcelable;
            if (g != null)
            {
                h = bundle.getInt("DEGREES_ROTATED");
                int i1 = h;
                rotateImage(h);
                h = i1;
            }
            super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
            return;
        } else
        {
            super.onRestoreInstanceState(parcelable);
            return;
        }
    }

    public Parcelable onSaveInstanceState()
    {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("DEGREES_ROTATED", h);
        return bundle;
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        if (g != null)
        {
            Rect rect = ImageViewUtil.getBitmapRectCenterInside(g, this);
            f.setBitmapRect(rect);
            return;
        } else
        {
            f.setBitmapRect(a);
            return;
        }
    }

    public void rotateImage(int i1)
    {
        Matrix matrix = new Matrix();
        matrix.postRotate(i1);
        g = Bitmap.createBitmap(g, 0, 0, g.getWidth(), g.getHeight(), matrix, true);
        setImageBitmap(g);
        h = i1 + h;
        h = h % 360;
    }

    public void setAspectRatio(int i1, int j1)
    {
        m = i1;
        f.setAspectRatioX(m);
        n = j1;
        f.setAspectRatioY(n);
    }

    public void setFixedAspectRatio(boolean flag)
    {
        f.setFixedAspectRatio(flag);
    }

    public void setGuidelines(int i1)
    {
        f.setGuidelines(i1);
    }

    public void setImageBitmap(Bitmap bitmap)
    {
        g = bitmap;
        e.setImageBitmap(g);
        if (f != null)
        {
            f.resetCropOverlayView();
        }
    }

    public void setImageBitmap(Bitmap bitmap, ExifInterface exifinterface)
    {
        Matrix matrix;
        if (bitmap == null)
        {
            return;
        }
        if (exifinterface == null)
        {
            setImageBitmap(bitmap);
            return;
        }
        matrix = new Matrix();
        exifinterface.getAttributeInt("Orientation", 1);
        JVM INSTR tableswitch 3 8: default 68
    //                   3 91
    //                   4 68
    //                   5 68
    //                   6 99
    //                   7 68
    //                   8 83;
           goto _L1 _L2 _L1 _L1 _L3 _L1 _L4
_L3:
        break MISSING_BLOCK_LABEL_99;
_L1:
        int i1 = -1;
_L5:
        if (i1 == -1)
        {
            setImageBitmap(bitmap);
            return;
        } else
        {
            matrix.postRotate(i1);
            setImageBitmap(Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true));
            bitmap.recycle();
            return;
        }
_L4:
        i1 = 270;
          goto _L5
_L2:
        i1 = 180;
          goto _L5
        i1 = 90;
          goto _L5
    }

    public void setImageResource(int i1)
    {
        if (i1 != 0)
        {
            setImageBitmap(BitmapFactory.decodeResource(getResources(), i1));
        }
    }

}
