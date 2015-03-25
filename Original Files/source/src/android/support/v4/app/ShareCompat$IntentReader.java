// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import java.util.ArrayList;

// Referenced classes of package android.support.v4.app:
//            ShareCompat, Y

public class ivity
{

    private static final String a = "IntentReader";
    private Activity b;
    private Intent c;
    private String d;
    private ComponentName e;
    private ArrayList f;

    public static ivity from(Activity activity)
    {
        return new <init>(activity);
    }

    public ComponentName getCallingActivity()
    {
        return e;
    }

    public Drawable getCallingActivityIcon()
    {
        if (e == null)
        {
            return null;
        }
        PackageManager packagemanager = b.getPackageManager();
        Drawable drawable;
        try
        {
            drawable = packagemanager.getActivityIcon(e);
        }
        catch (android.content.pm.ndException ndexception)
        {
            Log.e("IntentReader", "Could not retrieve icon for calling activity", ndexception);
            return null;
        }
        return drawable;
    }

    public Drawable getCallingApplicationIcon()
    {
        if (d == null)
        {
            return null;
        }
        PackageManager packagemanager = b.getPackageManager();
        Drawable drawable;
        try
        {
            drawable = packagemanager.getApplicationIcon(d);
        }
        catch (android.content.pm.ndException ndexception)
        {
            Log.e("IntentReader", "Could not retrieve icon for calling application", ndexception);
            return null;
        }
        return drawable;
    }

    public CharSequence getCallingApplicationLabel()
    {
        if (d == null)
        {
            return null;
        }
        PackageManager packagemanager = b.getPackageManager();
        CharSequence charsequence;
        try
        {
            charsequence = packagemanager.getApplicationLabel(packagemanager.getApplicationInfo(d, 0));
        }
        catch (android.content.pm.ndException ndexception)
        {
            Log.e("IntentReader", "Could not retrieve label for calling application", ndexception);
            return null;
        }
        return charsequence;
    }

    public String getCallingPackage()
    {
        return d;
    }

    public String[] getEmailBcc()
    {
        return c.getStringArrayExtra("android.intent.extra.BCC");
    }

    public String[] getEmailCc()
    {
        return c.getStringArrayExtra("android.intent.extra.CC");
    }

    public String[] getEmailTo()
    {
        return c.getStringArrayExtra("android.intent.extra.EMAIL");
    }

    public String getHtmlText()
    {
        String s = c.getStringExtra("android.intent.extra.HTML_TEXT");
        if (c == null)
        {
            CharSequence charsequence = getText();
            if (charsequence instanceof Spanned)
            {
                return Html.toHtml((Spanned)charsequence);
            }
            if (charsequence != null)
            {
                return ShareCompat.a().a(charsequence);
            }
        }
        return s;
    }

    public Uri getStream()
    {
        return (Uri)c.getParcelableExtra("android.intent.extra.STREAM");
    }

    public Uri getStream(int i)
    {
        if (f == null && isMultipleShare())
        {
            f = c.getParcelableArrayListExtra("android.intent.extra.STREAM");
        }
        if (f != null)
        {
            return (Uri)f.get(i);
        }
        if (i == 0)
        {
            return (Uri)c.getParcelableExtra("android.intent.extra.STREAM");
        } else
        {
            throw new IndexOutOfBoundsException((new StringBuilder()).append("Stream items available: ").append(getStreamCount()).append(" index requested: ").append(i).toString());
        }
    }

    public int getStreamCount()
    {
        if (f == null && isMultipleShare())
        {
            f = c.getParcelableArrayListExtra("android.intent.extra.STREAM");
        }
        if (f != null)
        {
            return f.size();
        }
        return !c.hasExtra("android.intent.extra.STREAM") ? 0 : 1;
    }

    public String getSubject()
    {
        return c.getStringExtra("android.intent.extra.SUBJECT");
    }

    public CharSequence getText()
    {
        return c.getCharSequenceExtra("android.intent.extra.TEXT");
    }

    public String getType()
    {
        return c.getType();
    }

    public boolean isMultipleShare()
    {
        return "android.intent.action.SEND_MULTIPLE".equals(c.getAction());
    }

    public boolean isShareIntent()
    {
        String s = c.getAction();
        return "android.intent.action.SEND".equals(s) || "android.intent.action.SEND_MULTIPLE".equals(s);
    }

    public boolean isSingleShare()
    {
        return "android.intent.action.SEND".equals(c.getAction());
    }

    private ception(Activity activity)
    {
        b = activity;
        c = activity.getIntent();
        d = ShareCompat.getCallingPackage(activity);
        e = ShareCompat.getCallingActivity(activity);
    }
}
