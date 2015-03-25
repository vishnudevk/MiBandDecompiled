// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import cn.com.smartdevices.bracelet.Debug;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Util
{

    private static final String a = "Util";
    private static ProgressDialog b = null;

    public Util()
    {
    }

    public static Bitmap bitmapFromFilePath(Context context, String s)
    {
        Uri uri = Uri.fromFile(new File(s));
        InputStream inputstream1 = context.getContentResolver().openInputStream(uri);
        InputStream inputstream = inputstream1;
        Drawable drawable1 = Drawable.createFromStream(inputstream, null);
        Drawable drawable;
        drawable = drawable1;
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            catch (IOException ioexception2)
            {
                Debug.w("ImageView", (new StringBuilder()).append("Unable to close content: ").append(uri).toString());
            }
        }
_L2:
        return ((BitmapDrawable)drawable).getBitmap();
        Exception exception2;
        exception2;
        inputstream = null;
_L5:
        Debug.w("ImageView", (new StringBuilder()).append("Unable to open content: ").append(uri).toString());
        drawable = null;
        if (inputstream == null) goto _L2; else goto _L1
_L1:
        inputstream.close();
        drawable = null;
          goto _L2
        IOException ioexception1;
        ioexception1;
        Debug.w("ImageView", (new StringBuilder()).append("Unable to close content: ").append(uri).toString());
        drawable = null;
          goto _L2
        Exception exception;
        exception;
        Exception exception1;
        inputstream = null;
        exception1 = exception;
_L4:
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            catch (IOException ioexception)
            {
                Debug.w("ImageView", (new StringBuilder()).append("Unable to close content: ").append(uri).toString());
            }
        }
        throw exception1;
        exception1;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception3;
        exception3;
          goto _L5
    }

    public static Bitmap clipToRoundBitmap(Bitmap bitmap)
    {
        if (bitmap == null)
        {
            return null;
        }
        int i = Math.min(bitmap.getWidth(), bitmap.getHeight());
        Debug.i("Util", (new StringBuilder()).append("round bitmap w=").append(bitmap.getWidth()).append(", h=").append(bitmap.getHeight()).toString());
        Bitmap bitmap1 = Bitmap.createBitmap(i, i, android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap1);
        Paint paint = new Paint();
        Rect rect = new Rect();
        RectF rectf = new RectF();
        int j;
        if (bitmap.getWidth() > bitmap.getHeight())
        {
            rect.left = (bitmap.getWidth() - i) / 2;
            rect.top = 0;
            rect.right = bitmap.getWidth() - rect.left;
            rect.bottom = bitmap.getHeight();
        } else
        if (bitmap.getWidth() < bitmap.getHeight())
        {
            rect.left = 0;
            rect.top = (bitmap.getHeight() - i) / 2;
            rect.right = bitmap.getWidth();
            rect.bottom = bitmap.getHeight() - rect.top;
        } else
        {
            rect.left = 0;
            rect.top = 0;
            rect.right = bitmap.getWidth();
            rect.bottom = bitmap.getHeight();
        }
        rectf.left = 0.0F;
        rectf.top = 0.0F;
        rectf.right = i;
        rectf.bottom = i;
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(0xff000000);
        j = i / 2;
        canvas.drawRoundRect(rectf, j, j, paint);
        paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rectf, paint);
        return bitmap1;
    }

    public static void hideProgressDialog()
    {
        try
        {
            Debug.i("Util", (new StringBuilder()).append("mPd = ").append(b).append(", is showing=").append(b.isShowing()).toString());
            if (b != null)
            {
                b.dismiss();
                b.hide();
            }
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        Debug.i("Util", (new StringBuilder()).append("Exception: mPd = ").append(b).toString());
    }

    public static void showProgressDialog(Context context, String s, String s1)
    {
        showProgressDialog(context, s, s1, false);
    }

    public static void showProgressDialog(Context context, String s, String s1, boolean flag)
    {
        if (b != null && b.isShowing())
        {
            updateProgressDialog(s1);
            return;
        }
        try
        {
            b = ProgressDialog.show(context, s, s1);
            b.setCancelable(flag);
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public static void updateProgressDialog(String s)
    {
        try
        {
            if (b != null && b.isShowing())
            {
                b.setMessage(s);
            }
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

}
