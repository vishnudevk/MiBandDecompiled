// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.BraceletApp;
import cn.com.smartdevices.bracelet.BraceletImageLoader;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.view.CustomToast;
import com.edmodo.cropper.CropImageView;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            SystemBarTintActivity

public class CropImageActivity extends SystemBarTintActivity
    implements android.view.View.OnClickListener
{

    public static final String CROPPED_FILE_PATH = "CROPPED_FILE_PATH";
    private static final String a = "CropImageActivity";
    private static final int e = 1080;
    private static final int f = 1920;
    private final int b = 18;
    private CropImageView c;
    private Bitmap d;
    private View g;
    private View h;

    public CropImageActivity()
    {
    }

    private void a(String s)
    {
        Uri uri;
        Debug.i("CropImageActivity", (new StringBuilder()).append("path = ").append(s).toString());
        uri = Uri.parse(s);
        java.io.InputStream inputstream1 = getContentResolver().openInputStream(uri);
        java.io.InputStream inputstream = inputstream1;
_L1:
        Bitmap bitmap;
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputstream, null, options);
        int i = options.outWidth;
        int j = options.outHeight;
        Debug.i("CropImageActivity", (new StringBuilder()).append("selected image, origin width=").append(i).append(", height=").append(j).toString());
        FileNotFoundException filenotfoundexception;
        Bitmap bitmap1;
        if (i * j > 0x1fa400)
        {
            if (i / j >= 1)
            {
                j = (j * 1080) / i;
                i = 1080;
            } else
            {
                i = (i * 1920) / j;
                j = 1920;
            }
        }
        Debug.i("CropImageActivity", (new StringBuilder()).append("selected image, new width=").append(i).append(", height=").append(j).toString());
        if (i <= 0 || j <= 0)
        {
            j = 1920;
            i = 1080;
        }
        bitmap1 = BraceletImageLoader.getInstance().loadImageSync(s, new ImageSize(i, j));
        bitmap = bitmap1;
_L2:
        Exception exception;
        if (bitmap == null)
        {
            CustomToast.makeText(this, 0x7f0d00b9, 1).show();
            setResult(0);
            finish();
            return;
        } else
        {
            c.setImageBitmap(bitmap);
            return;
        }
        filenotfoundexception;
        filenotfoundexception.printStackTrace();
        inputstream = null;
          goto _L1
        exception;
        exception.printStackTrace();
        bitmap = null;
          goto _L2
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
label0:
        {
            if (i == 18)
            {
                if (intent == null)
                {
                    break label0;
                }
                a(intent.getDataString());
            }
            return;
        }
        finish();
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        case 2131361953: 
        default:
            return;

        case 2131361952: 
            setResult(0);
            finish();
            return;

        case 2131361954: 
            d = c.getCroppedImage(320, 320);
            break;
        }
        if (d == null)
        {
            CustomToast.makeText(this, 0x7f0d00b9, 1).show();
            setResult(0);
            finish();
            return;
        }
        String s = (new StringBuilder()).append(((BraceletApp)getApplication()).getStoragePath()).append("/bracelet_icon.jpg").toString();
        Intent intent;
        try
        {
            FileOutputStream fileoutputstream = new FileOutputStream(s);
            d.compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, fileoutputstream);
            fileoutputstream.close();
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            filenotfoundexception.printStackTrace();
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }
        intent = new Intent();
        intent.putExtra("CROPPED_FILE_PATH", s);
        setResult(-1, intent);
        finish();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030019);
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction("android.intent.action.GET_CONTENT");
        startActivityForResult(intent, 18);
        c = (CropImageView)findViewById(0x7f0a009b);
        g = findViewById(0x7f0a00a2);
        g.setOnClickListener(this);
        h = findViewById(0x7f0a00a0);
        h.setOnClickListener(this);
    }

    public void onPause()
    {
        super.onPause();
        UmengAnalytics.endPage("PagePersonInfoAvatarCrop");
    }

    public void onResume()
    {
        super.onResume();
        UmengAnalytics.startPage("PagePersonInfoAvatarCrop");
    }
}
