// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.utils.ImageSizeUtils;
import com.nostra13.universalimageloader.utils.IoUtils;
import com.nostra13.universalimageloader.utils.L;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.nostra13.universalimageloader.core.decode:
//            ImageDecoder, ImageDecodingInfo

public class BaseImageDecoder
    implements ImageDecoder
{

    protected static final String ERROR_CANT_DECODE_IMAGE = "Image can't be decoded [%s]";
    protected static final String LOG_FLIP_IMAGE = "Flip image horizontally [%s]";
    protected static final String LOG_ROTATE_IMAGE = "Rotate image on %1$d\260 [%2$s]";
    protected static final String LOG_SCALE_IMAGE = "Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]";
    protected static final String LOG_SUBSAMPLE_IMAGE = "Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]";
    protected final boolean loggingEnabled;

    public BaseImageDecoder(boolean flag)
    {
        loggingEnabled = flag;
    }

    private boolean a(String s, String s1)
    {
        return android.os.Build.VERSION.SDK_INT >= 5 && "image/jpeg".equalsIgnoreCase(s1) && com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.ofUri(s) == com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.FILE;
    }

    protected Bitmap considerExactScaleAndOrientatiton(Bitmap bitmap, ImageDecodingInfo imagedecodinginfo, int i, boolean flag)
    {
        Matrix matrix = new Matrix();
        ImageScaleType imagescaletype = imagedecodinginfo.getImageScaleType();
        if (imagescaletype == ImageScaleType.EXACTLY || imagescaletype == ImageScaleType.EXACTLY_STRETCHED)
        {
            ImageSize imagesize = new ImageSize(bitmap.getWidth(), bitmap.getHeight(), i);
            ImageSize imagesize1 = imagedecodinginfo.getTargetSize();
            com.nostra13.universalimageloader.core.assist.ViewScaleType viewscaletype = imagedecodinginfo.getViewScaleType();
            boolean flag1;
            float f;
            Bitmap bitmap1;
            Object aobj[];
            Object aobj1[];
            if (imagescaletype == ImageScaleType.EXACTLY_STRETCHED)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            f = ImageSizeUtils.computeImageScale(imagesize, imagesize1, viewscaletype, flag1);
            if (Float.compare(f, 1.0F) != 0)
            {
                matrix.setScale(f, f);
                if (loggingEnabled)
                {
                    Object aobj2[] = new Object[4];
                    aobj2[0] = imagesize;
                    aobj2[1] = imagesize.scale(f);
                    aobj2[2] = Float.valueOf(f);
                    aobj2[3] = imagedecodinginfo.getImageKey();
                    L.d("Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]", aobj2);
                }
            }
        }
        if (flag)
        {
            matrix.postScale(-1F, 1.0F);
            if (loggingEnabled)
            {
                aobj1 = new Object[1];
                aobj1[0] = imagedecodinginfo.getImageKey();
                L.d("Flip image horizontally [%s]", aobj1);
            }
        }
        if (i != 0)
        {
            matrix.postRotate(i);
            if (loggingEnabled)
            {
                aobj = new Object[2];
                aobj[0] = Integer.valueOf(i);
                aobj[1] = imagedecodinginfo.getImageKey();
                L.d("Rotate image on %1$d\260 [%2$s]", aobj);
            }
        }
        bitmap1 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (bitmap1 != bitmap)
        {
            bitmap.recycle();
        }
        return bitmap1;
    }

    public Bitmap decode(ImageDecodingInfo imagedecodinginfo)
    {
        InputStream inputstream = getImageStream(imagedecodinginfo);
        ImageFileInfo imagefileinfo;
        Bitmap bitmap;
        imagefileinfo = defineImageSizeAndRotation(inputstream, imagedecodinginfo);
        inputstream = resetStream(inputstream, imagedecodinginfo);
        bitmap = BitmapFactory.decodeStream(inputstream, null, prepareDecodingOptions(imagefileinfo.imageSize, imagedecodinginfo));
        IoUtils.closeSilently(inputstream);
        Exception exception;
        if (bitmap == null)
        {
            Object aobj[] = new Object[1];
            aobj[0] = imagedecodinginfo.getImageKey();
            L.e("Image can't be decoded [%s]", aobj);
            return bitmap;
        } else
        {
            return considerExactScaleAndOrientatiton(bitmap, imagedecodinginfo, imagefileinfo.exif.rotation, imagefileinfo.exif.flipHorizontal);
        }
        exception;
        IoUtils.closeSilently(inputstream);
        throw exception;
    }

    protected ExifInfo defineExifOrientation(String s)
    {
        int i;
        boolean flag;
        i = 0;
        flag = true;
        int j = (new ExifInterface(com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.FILE.crop(s))).getAttributeInt("Orientation", 1);
        i = 0;
        j;
        JVM INSTR tableswitch 1 8: default 76
    //                   1 76
    //                   2 78
    //                   3 96
    //                   4 98
    //                   5 107
    //                   6 88
    //                   7 90
    //                   8 105;
           goto _L1 _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        flag = false;
_L10:
        return new ExifInfo(i, flag);
_L6:
        flag = false;
_L7:
        i = 90;
        continue; /* Loop/switch isn't completed */
_L3:
        flag = false;
_L4:
        i = 180;
        continue; /* Loop/switch isn't completed */
_L8:
        flag = false;
_L5:
        i = 270;
        if (true) goto _L10; else goto _L9
_L9:
        IOException ioexception;
        ioexception;
        Object aobj[] = new Object[flag];
        aobj[0] = s;
        L.w("Can't read EXIF tags from file [%s]", aobj);
        if (true) goto _L1; else goto _L11
_L11:
    }

    protected ImageFileInfo defineImageSizeAndRotation(InputStream inputstream, ImageDecodingInfo imagedecodinginfo)
    {
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputstream, null, options);
        String s = imagedecodinginfo.getImageUri();
        ExifInfo exifinfo;
        if (imagedecodinginfo.shouldConsiderExifParams() && a(s, options.outMimeType))
        {
            exifinfo = defineExifOrientation(s);
        } else
        {
            exifinfo = new ExifInfo();
        }
        return new ImageFileInfo(new ImageSize(options.outWidth, options.outHeight, exifinfo.rotation), exifinfo);
    }

    protected InputStream getImageStream(ImageDecodingInfo imagedecodinginfo)
    {
        return imagedecodinginfo.getDownloader().getStream(imagedecodinginfo.getImageUri(), imagedecodinginfo.getExtraForDownloader());
    }

    protected android.graphics.BitmapFactory.Options prepareDecodingOptions(ImageSize imagesize, ImageDecodingInfo imagedecodinginfo)
    {
        ImageScaleType imagescaletype = imagedecodinginfo.getImageScaleType();
        int i;
        android.graphics.BitmapFactory.Options options;
        if (imagescaletype == ImageScaleType.NONE)
        {
            i = ImageSizeUtils.computeMinImageSampleSize(imagesize);
        } else
        {
            ImageSize imagesize1 = imagedecodinginfo.getTargetSize();
            boolean flag;
            if (imagescaletype == ImageScaleType.IN_SAMPLE_POWER_OF_2)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            i = ImageSizeUtils.computeImageSampleSize(imagesize, imagesize1, imagedecodinginfo.getViewScaleType(), flag);
        }
        if (i > 1 && loggingEnabled)
        {
            Object aobj[] = new Object[4];
            aobj[0] = imagesize;
            aobj[1] = imagesize.scaleDown(i);
            aobj[2] = Integer.valueOf(i);
            aobj[3] = imagedecodinginfo.getImageKey();
            L.d("Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]", aobj);
        }
        options = imagedecodinginfo.getDecodingOptions();
        options.inSampleSize = i;
        return options;
    }

    protected InputStream resetStream(InputStream inputstream, ImageDecodingInfo imagedecodinginfo)
    {
        try
        {
            inputstream.reset();
        }
        catch (IOException ioexception)
        {
            IoUtils.closeSilently(inputstream);
            return getImageStream(imagedecodinginfo);
        }
        return inputstream;
    }

    private class ImageFileInfo
    {

        public final ExifInfo exif;
        public final ImageSize imageSize;

        protected ImageFileInfo(ImageSize imagesize, ExifInfo exifinfo)
        {
            imageSize = imagesize;
            exif = exifinfo;
        }
    }


    private class ExifInfo
    {

        public final boolean flipHorizontal;
        public final int rotation;

        protected ExifInfo()
        {
            rotation = 0;
            flipHorizontal = false;
        }

        protected ExifInfo(int i, boolean flag)
        {
            rotation = i;
            flipHorizontal = flag;
        }
    }

}
