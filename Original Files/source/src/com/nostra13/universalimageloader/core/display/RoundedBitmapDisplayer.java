// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.display;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;

// Referenced classes of package com.nostra13.universalimageloader.core.display:
//            BitmapDisplayer

public class RoundedBitmapDisplayer
    implements BitmapDisplayer
{

    protected final int cornerRadius;
    protected final int margin;

    public RoundedBitmapDisplayer(int i)
    {
        this(i, 0);
    }

    public RoundedBitmapDisplayer(int i, int j)
    {
        cornerRadius = i;
        margin = j;
    }

    public void display(Bitmap bitmap, ImageAware imageaware, LoadedFrom loadedfrom)
    {
        if (!(imageaware instanceof ImageViewAware))
        {
            throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
        } else
        {
            imageaware.setImageDrawable(new RoundedDrawable(bitmap, cornerRadius, margin));
            return;
        }
    }

    private class RoundedDrawable extends Drawable
    {

        protected final BitmapShader bitmapShader;
        protected final float cornerRadius;
        protected final RectF mBitmapRect;
        protected final RectF mRect = new RectF();
        protected final int margin;
        protected final Paint paint = new Paint();

        public void draw(Canvas canvas)
        {
            canvas.drawRoundRect(mRect, cornerRadius, cornerRadius, paint);
        }

        public int getOpacity()
        {
            return -3;
        }

        protected void onBoundsChange(Rect rect)
        {
            super.onBoundsChange(rect);
            mRect.set(margin, margin, rect.width() - margin, rect.height() - margin);
            Matrix matrix = new Matrix();
            matrix.setRectToRect(mBitmapRect, mRect, android.graphics.Matrix.ScaleToFit.FILL);
            bitmapShader.setLocalMatrix(matrix);
        }

        public void setAlpha(int i)
        {
            paint.setAlpha(i);
        }

        public void setColorFilter(ColorFilter colorfilter)
        {
            paint.setColorFilter(colorfilter);
        }

        public RoundedDrawable(Bitmap bitmap, int i, int j)
        {
            cornerRadius = i;
            margin = j;
            bitmapShader = new BitmapShader(bitmap, android.graphics.Shader.TileMode.CLAMP, android.graphics.Shader.TileMode.CLAMP);
            mBitmapRect = new RectF(j, j, bitmap.getWidth() - j, bitmap.getHeight() - j);
            paint.setAntiAlias(true);
            paint.setShader(bitmapShader);
        }
    }

}
