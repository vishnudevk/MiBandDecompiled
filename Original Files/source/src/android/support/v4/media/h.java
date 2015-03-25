// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.media;


// Referenced classes of package android.support.v4.media:
//            d, c

class h
    implements android.media.AudioManager.OnAudioFocusChangeListener
{

    final d a;

    h(d d1)
    {
        a = d1;
        super();
    }

    public void onAudioFocusChange(int i)
    {
        a.d.a(i);
    }
}
