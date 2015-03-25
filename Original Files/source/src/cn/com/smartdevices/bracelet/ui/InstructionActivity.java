// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.ui.widget.PageIndicator;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            SystemBarTintActivity, az, ay

public class InstructionActivity extends SystemBarTintActivity
    implements android.view.View.OnClickListener
{

    private View a;
    private ViewPager b;
    private PageIndicator c;
    private az d;
    private ArrayList e;
    private int f;

    public InstructionActivity()
    {
    }

    static int a(InstructionActivity instructionactivity, int i)
    {
        instructionactivity.f = i;
        return i;
    }

    static ArrayList a(InstructionActivity instructionactivity)
    {
        return instructionactivity.e;
    }

    static byte[] a(InputStream inputstream)
    {
        return b(inputstream);
    }

    static int b(InstructionActivity instructionactivity)
    {
        return instructionactivity.f;
    }

    private static byte[] b(InputStream inputstream)
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        byte abyte0[] = new byte[1024];
        do
        {
            int i = inputstream.read(abyte0);
            if (i != -1)
            {
                bytearrayoutputstream.write(abyte0, 0, i);
            } else
            {
                bytearrayoutputstream.flush();
                return bytearrayoutputstream.toByteArray();
            }
        } while (true);
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131361844: 
            finish();
            break;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030004);
        a = (TextView)findViewById(0x7f0a0034);
        a.setOnClickListener(this);
        b = (ViewPager)findViewById(0x7f0a0035);
        c = (PageIndicator)findViewById(0x7f0a0036);
        e = new ArrayList(3);
        e.add(Fragment.instantiate(this, cn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage1.getName()));
        e.add(Fragment.instantiate(this, cn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage2.getName()));
        e.add(Fragment.instantiate(this, cn/com/smartdevices/bracelet/ui/InstructionActivity$InstructionPage3.getName()));
        d = new az(this, getFragmentManager());
        b.setAdapter(d);
        b.setOffscreenPageLimit(3);
        c.setViewPager(b);
        c.setOnPageChangeListener(new ay(this));
    }

    protected void onPause()
    {
        super.onPause();
        UmengAnalytics.endPage("PageInstruction");
        UmengAnalytics.endSession(this);
    }

    protected void onResume()
    {
        super.onResume();
        UmengAnalytics.startPage("PageInstruction");
        UmengAnalytics.startSession(this);
    }
}
