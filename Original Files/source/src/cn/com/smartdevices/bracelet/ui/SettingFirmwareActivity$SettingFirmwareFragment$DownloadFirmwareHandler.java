// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.upgrade.OtaVersionInfo;
import cn.com.smartdevices.bracelet.view.CustomToast;
import com.loopj.android.http.FileAsyncHttpResponseHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import org.apache.http.Header;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            bM

public class a extends FileAsyncHttpResponseHandler
{

    private static final char h[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'a', 'b', 'c', 'd', 'e', 'f'
    };
    private c b;
    private Context c;
    private File d;
    private OtaVersionInfo e;
    private boolean f;
    private ProgressDialog g;

    private void a()
    {
        if (g != null)
        {
            g.show();
        }
    }

    private void a(int i)
    {
        if (g != null)
        {
            g.setProgress(i);
        }
    }

    private void a(Context context)
    {
        if (g == null)
        {
            g = new ProgressDialog(context);
            g.setMax(100);
            g.setProgress(0);
            g.setTitle("\u56FA\u4EF6\u4E0B\u8F7D");
            g.setMessage("\u4E0B\u8F7D\u8FDB\u5EA6");
            g.setProgressStyle(1);
            g.setIndeterminate(false);
            g.setCancelable(true);
            g.setOnCancelListener(new bM(this));
        }
    }

    static boolean a(g g1, boolean flag)
    {
        g1.f = flag;
        return flag;
    }

    private void b()
    {
        if (g != null)
        {
            g.dismiss();
        }
    }

    public static String md5sum(File file)
    {
        byte abyte0[];
        if (!file.isFile())
        {
            return null;
        }
        abyte0 = new byte[1024];
        FileInputStream fileinputstream;
        MessageDigest messagedigest;
        fileinputstream = new FileInputStream(file);
        messagedigest = MessageDigest.getInstance("MD5");
_L1:
        int i = fileinputstream.read(abyte0);
label0:
        {
            if (i <= 0)
            {
                break label0;
            }
            String s;
            try
            {
                messagedigest.update(abyte0, 0, i);
            }
            catch (Exception exception)
            {
                return null;
            }
        }
          goto _L1
        fileinputstream.close();
        s = toHexString(messagedigest.digest());
        return s;
    }

    public static String toHexString(byte abyte0[])
    {
        StringBuilder stringbuilder = new StringBuilder(2 * abyte0.length);
        for (int i = 0; i < abyte0.length; i++)
        {
            stringbuilder.append(h[(0xf0 & abyte0[i]) >>> 4]);
            stringbuilder.append(h[0xf & abyte0[i]]);
        }

        return stringbuilder.toString();
    }

    public void onFailure(int i, Header aheader[], Throwable throwable, File file)
    {
        Debug.w("Setting.Firmware", (new StringBuilder()).append("Download On Failure : ").append(d.getPath()).toString());
        Debug.w("Setting.Firmware", throwable.toString());
        if (aheader != null)
        {
            int j = aheader.length;
            for (int k = 0; k < j; k++)
            {
                Header header = aheader[k];
                Debug.i("Setting.Firmware", (new StringBuilder()).append(header.getName()).append(" : ").append(header.getValue()).toString());
            }

        }
        if (f)
        {
            return;
        } else
        {
            b();
            CustomToast.makeText(c, "\u4E0B\u8F7D\u56FA\u4EF6\u5931\u8D25\uFF0C\u8BF7\u91CD\u8BD5", 0).show();
            return;
        }
    }

    public void onFinish()
    {
        Debug.i("Setting.Firmware", "Download On Finish!!");
        if (d.exists())
        {
            d.delete();
        }
        b();
    }

    public void onProgress(int i, int j)
    {
        Debug.i("Setting.Firmware", (new StringBuilder()).append("Download On Progress : ").append(i).append(" Total : ").append(j).toString());
        a((int)(100F * ((float)i / (float)j)));
    }

    public void onStart()
    {
        super.onStart();
        Debug.i("Setting.Firmware", "Download On Start!!");
        a();
    }

    public void onSuccess(int i, Header aheader[], File file)
    {
        Debug.i("Setting.Firmware", "Download On Success!!");
        if (aheader != null)
        {
            int j = aheader.length;
            for (int k = 0; k < j; k++)
            {
                Header header = aheader[k];
                Debug.i("Setting.Firmware", (new StringBuilder()).append(header.getName()).append(" : ").append(header.getValue()).toString());
            }

        }
        if (f)
        {
            return;
        }
        String s = d.getPath();
        File file1 = new File(s.substring(0, s.length() - ".tmp".length()));
        if (file1.exists())
        {
            file1.delete();
        }
        d.renameTo(file1);
        Debug.i("Setting.Firmware", (new StringBuilder()).append("FirmwareFile : ").append(file1).append(" , ").append(file1.exists()).append(" , ").append(file1.length()).toString());
        String s1 = md5sum(file1);
        Debug.i("Setting.Firmware", (new StringBuilder()).append("FirmwareMd5 : ").append(s1).toString());
        if (s1.equalsIgnoreCase(e.firmwareMd5))
        {
            b.b();
            return;
        } else
        {
            CustomToast.makeText(c, "\u56FA\u4EF6\u6821\u9A8C\u5931\u8D25\uFF0C\u8BF7\u91CD\u8BD5", 0).show();
            return;
        }
    }


    public ( , Context context, File file, OtaVersionInfo otaversioninfo)
    {
        super(file);
        b = ;
        c = context;
        d = file;
        e = otaversioninfo;
        a(context);
    }
}
