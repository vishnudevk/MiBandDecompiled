// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.base;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.base:
//            Renderer

public class BitmapRenderer extends Renderer
{

    Bitmap a;
    Shader b;

    public BitmapRenderer(Bitmap bitmap)
    {
        a = bitmap;
        paint = new Paint();
        b = new BitmapShader(a, android.graphics.Shader.TileMode.REPEAT, android.graphics.Shader.TileMode.CLAMP);
        paint.setShader(b);
    }

    public int getHeight()
    {
        return a.getHeight();
    }

    public int getWidth()
    {
        return a.getWidth();
    }

    public void setBitmap(Bitmap bitmap)
    {
        BitmapShader bitmapshader = new BitmapShader(bitmap, android.graphics.Shader.TileMode.REPEAT, android.graphics.Shader.TileMode.CLAMP);
        paint.setShader(bitmapshader);
    }

    public void setScale(float f, float f1)
    {
        Matrix matrix = new Matrix();
        matrix.setScale(f, f1);
        b.setLocalMatrix(matrix);
    }
}
