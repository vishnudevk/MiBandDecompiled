// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

// Referenced classes of package com.xiaomi.hm.view:
//            GifAction, GifReDraw, GifImageType, b, 
//            GifAnimation, GifDecoder, GifFrame, GifListener

public class GifView extends ImageView
    implements GifAction, GifReDraw
{

    private GifDecoder a;
    private Bitmap b;
    private GifAnimation c;
    private boolean d;
    private int e;
    private boolean f;
    private int g;
    private int h;
    private GifListener i;
    private boolean j;
    private int k;
    private GifImageType l;
    private Handler m;

    public GifView(Context context)
    {
        super(context);
        a = null;
        b = null;
        c = null;
        d = false;
        e = -1;
        f = false;
        g = 0;
        h = 0;
        i = null;
        j = false;
        k = 0;
        l = GifImageType.SYNC_DECODER;
        m = new b(this);
        setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        c = new GifAnimation();
        c.setRedraw(this);
    }

    public GifView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public GifView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        a = null;
        b = null;
        c = null;
        d = false;
        e = -1;
        f = false;
        g = 0;
        h = 0;
        i = null;
        j = false;
        k = 0;
        l = GifImageType.SYNC_DECODER;
        m = new b(this);
        setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        c = new GifAnimation();
        c.setRedraw(this);
    }

    private void a()
    {
        b();
        if (b != null)
        {
            b = null;
        }
        if (a != null)
        {
            c();
            a.destroy();
            a = null;
        }
        g = 0;
        a = new GifDecoder(this);
        if (f)
        {
            a.setLoopAnimation();
        }
    }

    private void a(Resources resources, int i1)
    {
        a();
        a.setGifImage(resources, i1);
        a.start();
    }

    static void a(GifView gifview)
    {
        gifview.g();
    }

    private void a(byte abyte0[])
    {
        a();
        a.setGifImage(abyte0);
        a.start();
    }

    private void b()
    {
        if (j)
        {
            return;
        } else
        {
            c.stopAnimation();
            d = false;
            return;
        }
    }

    private void c()
    {
        if (a != null && a.getState() != Thread.State.TERMINATED)
        {
            a.interrupt();
            a.destroy();
        }
    }

    private void d()
    {
        if (j)
        {
            return;
        } else
        {
            b();
            g = 0;
            c.runAnimation();
            return;
        }
    }

    private int e()
    {
        GifFrame gifframe;
label0:
        {
            if (a != null)
            {
                gifframe = a.next();
                if (gifframe != null)
                {
                    break label0;
                }
            }
            return -1;
        }
        if (gifframe.image != null)
        {
            b = gifframe.image;
        }
        return gifframe.delay;
    }

    private void f()
    {
        if (m != null)
        {
            android.os.Message message = m.obtainMessage();
            m.sendMessage(message);
        }
    }

    private void g()
    {
        if (b == null || b != null && !b.isRecycled())
        {
            setImageBitmap(b);
            invalidate();
            if (i != null && (k == 2 || k == 3))
            {
                h = 1 + h;
                i.frameCount(h);
            }
        }
    }

    public void destroy()
    {
        b();
        c();
        c.destroy();
        a.destroy();
        a = null;
        c = null;
    }

    public void dispatchWindowVisibilityChanged(int i1)
    {
        if (i1 != 8 && i1 != 4) goto _L2; else goto _L1
_L1:
        pauseGifAnimation();
_L4:
        super.dispatchWindowVisibilityChanged(i1);
        return;
_L2:
        if (i1 == 0)
        {
            restartGifAnimation();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void loopEnd()
    {
        g = 1 + g;
        if (e > 0 && g >= e)
        {
            b();
            c();
        }
        if (i != null)
        {
            if (k == 1 || k == 3)
            {
                i.gifEnd(g);
            }
            h = 0;
        }
    }

    protected void onWindowVisibilityChanged(int i1)
    {
    }

    public void parseReturn(int i1)
    {
        if (getVisibility() != 8 && getVisibility() != 4) goto _L2; else goto _L1
_L1:
        return;
_L2:
        switch (i1)
        {
        default:
            return;

        case 1: // '\001'
            Log.d("parseReturn", "FIRST");
            if (l == GifImageType.COVER || l == GifImageType.SYNC_DECODER)
            {
                b = a.getFrameImage();
                f();
                return;
            }
            break;

        case 2: // '\002'
            Log.d("parseReturn", "FINISH");
            if (a.getFrameCount() == 1)
            {
                e();
                f();
                b();
                c();
                j = true;
                return;
            }
            j = false;
            if (!d)
            {
                d();
                d = true;
                return;
            }
            break;

        case 3: // '\003'
            Log.d("parseReturn", "CACHE_FINISH");
            if (!d)
            {
                d();
                d = true;
                return;
            }
            break;

        case 4: // '\004'
            Log.e("parseReturn", "ERROR");
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void pauseGifAnimation()
    {
        if (j)
        {
            return;
        } else
        {
            c.pauseAnimation();
            return;
        }
    }

    public int reDraw()
    {
        int i1 = e();
        g();
        return i1;
    }

    public void restartGifAnimation()
    {
        while (j || !d) 
        {
            return;
        }
        c.restartAnimation();
    }

    public void setGifImage(int i1)
    {
        a(getResources(), i1);
    }

    public void setGifImage(String s)
    {
        a();
        a.setGifImage(s);
        a.start();
    }

    public void setGifImage(byte abyte0[])
    {
        a(abyte0);
    }

    public void setGifImageType(GifImageType gifimagetype)
    {
        if (a == null)
        {
            l = gifimagetype;
        }
    }

    public void setListener(GifListener giflistener, int i1)
    {
        i = giflistener;
        if (i1 >= 1 && i1 <= 3)
        {
            k = i1;
        }
    }

    public void setLoopAnimation()
    {
        f = true;
        if (a != null)
        {
            a.setLoopAnimation();
        }
    }

    public void setLoopNumber(int i1)
    {
        if (i1 > 1)
        {
            e = i1;
            setLoopAnimation();
        }
    }

    public void setVisibility(int i1)
    {
        super.setVisibility(i1);
        if (i1 == 8 || i1 == 4)
        {
            b();
        } else
        if (i1 == 0)
        {
            d();
            return;
        }
    }
}
