// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.text.Html;
import java.util.ArrayList;

public class b
{

    private Activity a;
    private Intent b;
    private CharSequence c;
    private ArrayList d;
    private ArrayList e;
    private ArrayList f;
    private ArrayList g;

    private void a(String s, ArrayList arraylist)
    {
        String as[] = b.getStringArrayExtra(s);
        int i;
        String as1[];
        if (as != null)
        {
            i = as.length;
        } else
        {
            i = 0;
        }
        as1 = new String[i + arraylist.size()];
        arraylist.toArray(as1);
        if (as != null)
        {
            System.arraycopy(as, 0, as1, arraylist.size(), i);
        }
        b.putExtra(s, as1);
    }

    private void a(String s, String as[])
    {
        Intent intent = getIntent();
        String as1[] = intent.getStringArrayExtra(s);
        int i;
        String as2[];
        if (as1 != null)
        {
            i = as1.length;
        } else
        {
            i = 0;
        }
        as2 = new String[i + as.length];
        if (as1 != null)
        {
            System.arraycopy(as1, 0, as2, 0, i);
        }
        System.arraycopy(as, 0, as2, i, as.length);
        intent.putExtra(s, as2);
    }

    public static getIntent from(Activity activity)
    {
        return new <init>(activity);
    }

    Activity a()
    {
        return a;
    }

    public a addEmailBcc(String s)
    {
        if (f == null)
        {
            f = new ArrayList();
        }
        f.add(s);
        return this;
    }

    public f addEmailBcc(String as[])
    {
        a("android.intent.extra.BCC", as);
        return this;
    }

    public a addEmailCc(String s)
    {
        if (e == null)
        {
            e = new ArrayList();
        }
        e.add(s);
        return this;
    }

    public e addEmailCc(String as[])
    {
        a("android.intent.extra.CC", as);
        return this;
    }

    public a addEmailTo(String s)
    {
        if (d == null)
        {
            d = new ArrayList();
        }
        d.add(s);
        return this;
    }

    public d addEmailTo(String as[])
    {
        a("android.intent.extra.EMAIL", as);
        return this;
    }

    public a addStream(Uri uri)
    {
        Uri uri1 = (Uri)b.getParcelableExtra("android.intent.extra.STREAM");
        if (uri1 == null)
        {
            return setStream(uri);
        }
        if (g == null)
        {
            g = new ArrayList();
        }
        if (uri1 != null)
        {
            b.removeExtra("android.intent.extra.STREAM");
            g.add(uri1);
        }
        g.add(uri);
        return this;
    }

    public Intent createChooserIntent()
    {
        return Intent.createChooser(getIntent(), c);
    }

    public Intent getIntent()
    {
        if (d != null)
        {
            a("android.intent.extra.EMAIL", d);
            d = null;
        }
        if (e != null)
        {
            a("android.intent.extra.CC", e);
            e = null;
        }
        if (f != null)
        {
            a("android.intent.extra.BCC", f);
            f = null;
        }
        boolean flag;
        boolean flag1;
        if (g != null && g.size() > 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = b.getAction().equals("android.intent.action.SEND_MULTIPLE");
        if (!flag && flag1)
        {
            b.setAction("android.intent.action.SEND");
            if (g != null && !g.isEmpty())
            {
                b.putExtra("android.intent.extra.STREAM", (Parcelable)g.get(0));
            } else
            {
                b.removeExtra("android.intent.extra.STREAM");
            }
            g = null;
        }
        if (flag && !flag1)
        {
            b.setAction("android.intent.action.SEND_MULTIPLE");
            if (g != null && !g.isEmpty())
            {
                b.putParcelableArrayListExtra("android.intent.extra.STREAM", g);
            } else
            {
                b.removeExtra("android.intent.extra.STREAM");
            }
        }
        return b;
    }

    public b setChooserTitle(int i)
    {
        return setChooserTitle(a.getText(i));
    }

    public a setChooserTitle(CharSequence charsequence)
    {
        c = charsequence;
        return this;
    }

    public c setEmailBcc(String as[])
    {
        b.putExtra("android.intent.extra.BCC", as);
        return this;
    }

    public b setEmailCc(String as[])
    {
        b.putExtra("android.intent.extra.CC", as);
        return this;
    }

    public b setEmailTo(String as[])
    {
        if (d != null)
        {
            d = null;
        }
        b.putExtra("android.intent.extra.EMAIL", as);
        return this;
    }

    public b setHtmlText(String s)
    {
        b.putExtra("android.intent.extra.HTML_TEXT", s);
        if (!b.hasExtra("android.intent.extra.TEXT"))
        {
            setText(Html.fromHtml(s));
        }
        return this;
    }

    public setText setStream(Uri uri)
    {
        if (!b.getAction().equals("android.intent.action.SEND"))
        {
            b.setAction("android.intent.action.SEND");
        }
        g = null;
        b.putExtra("android.intent.extra.STREAM", uri);
        return this;
    }

    public b setSubject(String s)
    {
        b.putExtra("android.intent.extra.SUBJECT", s);
        return this;
    }

    public b setText(CharSequence charsequence)
    {
        b.putExtra("android.intent.extra.TEXT", charsequence);
        return this;
    }

    public b setType(String s)
    {
        b.setType(s);
        return this;
    }

    public void startChooser()
    {
        a.startActivity(createChooserIntent());
    }

    private (Activity activity)
    {
        a = activity;
        b = (new Intent()).setAction("android.intent.action.SEND");
        b.putExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE", activity.getPackageName());
        b.putExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY", activity.getComponentName());
        b.addFlags(0x80000);
    }
}
