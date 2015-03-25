// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import java.lang.reflect.Array;

// Referenced classes of package cn.com.smartdevices.bracelet:
//            Debug

public class Blur
{

    private static final String a = "Blur";

    public Blur()
    {
    }

    public static Bitmap fastblur(Context context, Bitmap bitmap, int i)
    {
        if (android.os.Build.VERSION.SDK_INT > 16)
        {
            Bitmap bitmap2 = bitmap.copy(bitmap.getConfig(), true);
            RenderScript renderscript = RenderScript.create(context);
            Allocation allocation = Allocation.createFromBitmap(renderscript, bitmap, android.renderscript.Allocation.MipmapControl.MIPMAP_NONE, 1);
            Allocation allocation1 = Allocation.createTyped(renderscript, allocation.getType());
            ScriptIntrinsicBlur scriptintrinsicblur = ScriptIntrinsicBlur.create(renderscript, Element.U8_4(renderscript));
            scriptintrinsicblur.setRadius(i);
            scriptintrinsicblur.setInput(allocation);
            scriptintrinsicblur.forEach(allocation1);
            allocation1.copyTo(bitmap2);
            return bitmap2;
        }
        Bitmap bitmap1 = bitmap.copy(bitmap.getConfig(), true);
        if (i < 1)
        {
            return null;
        }
        int j = bitmap1.getWidth();
        int k = bitmap1.getHeight();
        int ai[] = new int[j * k];
        Debug.e("pix", (new StringBuilder()).append(j).append(" ").append(k).append(" ").append(ai.length).toString());
        bitmap1.getPixels(ai, 0, j, 0, 0, j, k);
        int l = j - 1;
        int i1 = k - 1;
        int j1 = j * k;
        int k1 = 1 + (i + i);
        int ai1[] = new int[j1];
        int ai2[] = new int[j1];
        int ai3[] = new int[j1];
        int ai4[] = new int[Math.max(j, k)];
        int l1 = k1 + 1 >> 1;
        int i2 = l1 * l1;
        int ai5[] = new int[i2 * 256];
        for (int j2 = 0; j2 < i2 * 256; j2++)
        {
            ai5[j2] = j2 / i2;
        }

        int ai6[] = {
            k1, 3
        };
        int ai7[][] = (int[][])Array.newInstance(Integer.TYPE, ai6);
        int k2 = i + 1;
        int l2 = 0;
        int i3 = 0;
        int i18;
        for (int j3 = 0; j3 < k; j3 = i18)
        {
            int k13 = 0;
            int l13 = -i;
            int i14 = 0;
            int j14 = 0;
            int k14 = 0;
            int l14 = 0;
            int i15 = l13;
            int j15 = 0;
            int k15 = 0;
            int l15 = 0;
            int i16 = 0;
            while (i15 <= i) 
            {
                int l20 = ai[i3 + Math.min(l, Math.max(i15, 0))];
                int ai13[] = ai7[i15 + i];
                ai13[0] = (0xff0000 & l20) >> 16;
                ai13[1] = (0xff00 & l20) >> 8;
                ai13[2] = l20 & 0xff;
                int i21 = k2 - Math.abs(i15);
                l15 += i21 * ai13[0];
                k15 += i21 * ai13[1];
                j15 += i21 * ai13[2];
                if (i15 > 0)
                {
                    i14 += ai13[0];
                    i16 += ai13[1];
                    k13 += ai13[2];
                } else
                {
                    l14 += ai13[0];
                    k14 += ai13[1];
                    j14 += ai13[2];
                }
                i15++;
            }
            int j16 = l15;
            int k16 = k15;
            int l16 = j15;
            int i17 = 0;
            int j17 = i3;
            int k17 = i;
            for (; i17 < j; i17++)
            {
                ai1[j17] = ai5[j16];
                ai2[j17] = ai5[k16];
                ai3[j17] = ai5[l16];
                int j18 = j16 - l14;
                int k18 = k16 - k14;
                int l18 = l16 - j14;
                int ai11[] = ai7[(k1 + (k17 - i)) % k1];
                int i19 = l14 - ai11[0];
                int j19 = k14 - ai11[1];
                int k19 = j14 - ai11[2];
                if (j3 == 0)
                {
                    ai4[i17] = Math.min(1 + (i17 + i), l);
                }
                int l19 = ai[l2 + ai4[i17]];
                ai11[0] = (0xff0000 & l19) >> 16;
                ai11[1] = (0xff00 & l19) >> 8;
                ai11[2] = l19 & 0xff;
                int i20 = i14 + ai11[0];
                int j20 = i16 + ai11[1];
                int k20 = k13 + ai11[2];
                j16 = j18 + i20;
                k16 = k18 + j20;
                l16 = l18 + k20;
                k17 = (k17 + 1) % k1;
                int ai12[] = ai7[k17 % k1];
                l14 = i19 + ai12[0];
                k14 = j19 + ai12[1];
                j14 = k19 + ai12[2];
                i14 = i20 - ai12[0];
                i16 = j20 - ai12[1];
                k13 = k20 - ai12[2];
                j17++;
            }

            int l17 = l2 + j;
            i18 = j3 + 1;
            l2 = l17;
            i3 = j17;
        }

        for (int k3 = 0; k3 < j; k3++)
        {
            int l3 = 0;
            int i4 = j * -i;
            int j4 = -i;
            int k4 = 0;
            int l4 = 0;
            int i5 = 0;
            int j5 = 0;
            int k5 = j4;
            int l5 = 0;
            int i6 = 0;
            int j6 = 0;
            int k6 = 0;
            while (k5 <= i) 
            {
                int j12 = k3 + Math.max(0, i4);
                int ai10[] = ai7[k5 + i];
                ai10[0] = ai1[j12];
                ai10[1] = ai2[j12];
                ai10[2] = ai3[j12];
                int k12 = k2 - Math.abs(k5);
                int l12 = j6 + k12 * ai1[j12];
                int i13 = i6 + k12 * ai2[j12];
                int j13 = l5 + k12 * ai3[j12];
                if (k5 > 0)
                {
                    k4 += ai10[0];
                    k6 += ai10[1];
                    l3 += ai10[2];
                } else
                {
                    j5 += ai10[0];
                    i5 += ai10[1];
                    l4 += ai10[2];
                }
                if (k5 < i1)
                {
                    i4 += j;
                }
                k5++;
                l5 = j13;
                i6 = i13;
                j6 = l12;
            }
            int l6 = i6;
            int i7 = j6;
            int j7 = 0;
            int k7 = l5;
            int l7 = k3;
            int i8 = l3;
            int j8 = k6;
            int k8 = k4;
            int l8 = l4;
            int i9 = i5;
            int j9 = j5;
            int k9 = i;
            for (; j7 < k; j7++)
            {
                ai[l7] = 0xff000000 & ai[l7] | ai5[i7] << 16 | ai5[l6] << 8 | ai5[k7];
                int l9 = i7 - j9;
                int i10 = l6 - i9;
                int j10 = k7 - l8;
                int ai8[] = ai7[(k1 + (k9 - i)) % k1];
                int k10 = j9 - ai8[0];
                int l10 = i9 - ai8[1];
                int i11 = l8 - ai8[2];
                if (k3 == 0)
                {
                    ai4[j7] = j * Math.min(j7 + k2, i1);
                }
                int j11 = k3 + ai4[j7];
                ai8[0] = ai1[j11];
                ai8[1] = ai2[j11];
                ai8[2] = ai3[j11];
                int k11 = k8 + ai8[0];
                int l11 = j8 + ai8[1];
                int i12 = i8 + ai8[2];
                i7 = l9 + k11;
                l6 = i10 + l11;
                k7 = j10 + i12;
                k9 = (k9 + 1) % k1;
                int ai9[] = ai7[k9];
                j9 = k10 + ai9[0];
                i9 = l10 + ai9[1];
                l8 = i11 + ai9[2];
                k8 = k11 - ai9[0];
                j8 = l11 - ai9[1];
                i8 = i12 - ai9[2];
                l7 += j;
            }

        }

        Debug.e("pix", (new StringBuilder()).append(j).append(" ").append(k).append(" ").append(ai.length).toString());
        bitmap1.setPixels(ai, 0, j, 0, 0, j, k);
        return bitmap1;
    }
}
