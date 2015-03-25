// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;

// Referenced classes of package com.google.zxing.qrcode.decoder:
//            n, ErrorCorrectionLevel

public final class Version
{

    private static final int a[] = {
        31892, 34236, 39577, 42195, 48118, 51042, 55367, 58893, 63784, 0x10b78, 
        0x1145d, 0x12a17, 0x13532, 0x149a6, 0x15683, 0x168c9, 0x177ec, 0x18ec4, 0x191e1, 0x1afab, 
        0x1b08e, 0x1cc1a, 0x1d33f, 0x1ed75, 0x1f250, 0x209d5, 0x216f0, 0x228ba, 0x2379f, 0x24b0b, 
        0x2542e, 0x26a64, 0x27541, 0x28c69
    };
    private static final Version b[] = b();
    private final int c;
    private final int d[];
    private final ECBlocks e[];
    private final int f;

    private transient Version(int i, int ai[], ECBlocks aecblocks[])
    {
        int j = 0;
        super();
        c = i;
        d = ai;
        e = aecblocks;
        int k = aecblocks[0].getECCodewordsPerBlock();
        ECB aecb[] = aecblocks[0].getECBlocks();
        int l = aecb.length;
        int i1 = 0;
        for (; j < l; j++)
        {
            ECB ecb = aecb[j];
            i1 += ecb.getCount() * (k + ecb.getDataCodewords());
        }

        f = i1;
    }

    static Version a(int i)
    {
        int j = 0;
        int k = 0x7fffffff;
        int l = 0;
        for (; j < a.length; j++)
        {
            int i1 = a[j];
            if (i1 == i)
            {
                return getVersionForNumber(j + 7);
            }
            int j1 = n.a(i, i1);
            if (j1 < k)
            {
                l = j + 7;
                k = j1;
            }
        }

        if (k <= 3)
        {
            return getVersionForNumber(l);
        } else
        {
            return null;
        }
    }

    private static Version[] b()
    {
        Version aversion[] = new Version[40];
        int ai[] = new int[0];
        ECBlocks aecblocks[] = new ECBlocks[4];
        ECB aecb[] = new ECB[1];
        aecb[0] = new ECB(1, 19);
        aecblocks[0] = new ECBlocks(7, aecb);
        ECB aecb1[] = new ECB[1];
        aecb1[0] = new ECB(1, 16);
        aecblocks[1] = new ECBlocks(10, aecb1);
        ECB aecb2[] = new ECB[1];
        aecb2[0] = new ECB(1, 13);
        aecblocks[2] = new ECBlocks(13, aecb2);
        ECB aecb3[] = new ECB[1];
        aecb3[0] = new ECB(1, 9);
        aecblocks[3] = new ECBlocks(17, aecb3);
        aversion[0] = new Version(1, ai, aecblocks);
        int ai1[] = {
            6, 18
        };
        ECBlocks aecblocks1[] = new ECBlocks[4];
        ECB aecb4[] = new ECB[1];
        aecb4[0] = new ECB(1, 34);
        aecblocks1[0] = new ECBlocks(10, aecb4);
        ECB aecb5[] = new ECB[1];
        aecb5[0] = new ECB(1, 28);
        aecblocks1[1] = new ECBlocks(16, aecb5);
        ECB aecb6[] = new ECB[1];
        aecb6[0] = new ECB(1, 22);
        aecblocks1[2] = new ECBlocks(22, aecb6);
        ECB aecb7[] = new ECB[1];
        aecb7[0] = new ECB(1, 16);
        aecblocks1[3] = new ECBlocks(28, aecb7);
        aversion[1] = new Version(2, ai1, aecblocks1);
        int ai2[] = {
            6, 22
        };
        ECBlocks aecblocks2[] = new ECBlocks[4];
        ECB aecb8[] = new ECB[1];
        aecb8[0] = new ECB(1, 55);
        aecblocks2[0] = new ECBlocks(15, aecb8);
        ECB aecb9[] = new ECB[1];
        aecb9[0] = new ECB(1, 44);
        aecblocks2[1] = new ECBlocks(26, aecb9);
        ECB aecb10[] = new ECB[1];
        aecb10[0] = new ECB(2, 17);
        aecblocks2[2] = new ECBlocks(18, aecb10);
        ECB aecb11[] = new ECB[1];
        aecb11[0] = new ECB(2, 13);
        aecblocks2[3] = new ECBlocks(22, aecb11);
        aversion[2] = new Version(3, ai2, aecblocks2);
        int ai3[] = {
            6, 26
        };
        ECBlocks aecblocks3[] = new ECBlocks[4];
        ECB aecb12[] = new ECB[1];
        aecb12[0] = new ECB(1, 80);
        aecblocks3[0] = new ECBlocks(20, aecb12);
        ECB aecb13[] = new ECB[1];
        aecb13[0] = new ECB(2, 32);
        aecblocks3[1] = new ECBlocks(18, aecb13);
        ECB aecb14[] = new ECB[1];
        aecb14[0] = new ECB(2, 24);
        aecblocks3[2] = new ECBlocks(26, aecb14);
        ECB aecb15[] = new ECB[1];
        aecb15[0] = new ECB(4, 9);
        aecblocks3[3] = new ECBlocks(16, aecb15);
        aversion[3] = new Version(4, ai3, aecblocks3);
        int ai4[] = {
            6, 30
        };
        ECBlocks aecblocks4[] = new ECBlocks[4];
        ECB aecb16[] = new ECB[1];
        aecb16[0] = new ECB(1, 108);
        aecblocks4[0] = new ECBlocks(26, aecb16);
        ECB aecb17[] = new ECB[1];
        aecb17[0] = new ECB(2, 43);
        aecblocks4[1] = new ECBlocks(24, aecb17);
        ECB aecb18[] = new ECB[2];
        aecb18[0] = new ECB(2, 15);
        aecb18[1] = new ECB(2, 16);
        aecblocks4[2] = new ECBlocks(18, aecb18);
        ECB aecb19[] = new ECB[2];
        aecb19[0] = new ECB(2, 11);
        aecb19[1] = new ECB(2, 12);
        aecblocks4[3] = new ECBlocks(22, aecb19);
        aversion[4] = new Version(5, ai4, aecblocks4);
        int ai5[] = {
            6, 34
        };
        ECBlocks aecblocks5[] = new ECBlocks[4];
        ECB aecb20[] = new ECB[1];
        aecb20[0] = new ECB(2, 68);
        aecblocks5[0] = new ECBlocks(18, aecb20);
        ECB aecb21[] = new ECB[1];
        aecb21[0] = new ECB(4, 27);
        aecblocks5[1] = new ECBlocks(16, aecb21);
        ECB aecb22[] = new ECB[1];
        aecb22[0] = new ECB(4, 19);
        aecblocks5[2] = new ECBlocks(24, aecb22);
        ECB aecb23[] = new ECB[1];
        aecb23[0] = new ECB(4, 15);
        aecblocks5[3] = new ECBlocks(28, aecb23);
        aversion[5] = new Version(6, ai5, aecblocks5);
        int ai6[] = {
            6, 22, 38
        };
        ECBlocks aecblocks6[] = new ECBlocks[4];
        ECB aecb24[] = new ECB[1];
        aecb24[0] = new ECB(2, 78);
        aecblocks6[0] = new ECBlocks(20, aecb24);
        ECB aecb25[] = new ECB[1];
        aecb25[0] = new ECB(4, 31);
        aecblocks6[1] = new ECBlocks(18, aecb25);
        ECB aecb26[] = new ECB[2];
        aecb26[0] = new ECB(2, 14);
        aecb26[1] = new ECB(4, 15);
        aecblocks6[2] = new ECBlocks(18, aecb26);
        ECB aecb27[] = new ECB[2];
        aecb27[0] = new ECB(4, 13);
        aecb27[1] = new ECB(1, 14);
        aecblocks6[3] = new ECBlocks(26, aecb27);
        aversion[6] = new Version(7, ai6, aecblocks6);
        int ai7[] = {
            6, 24, 42
        };
        ECBlocks aecblocks7[] = new ECBlocks[4];
        ECB aecb28[] = new ECB[1];
        aecb28[0] = new ECB(2, 97);
        aecblocks7[0] = new ECBlocks(24, aecb28);
        ECB aecb29[] = new ECB[2];
        aecb29[0] = new ECB(2, 38);
        aecb29[1] = new ECB(2, 39);
        aecblocks7[1] = new ECBlocks(22, aecb29);
        ECB aecb30[] = new ECB[2];
        aecb30[0] = new ECB(4, 18);
        aecb30[1] = new ECB(2, 19);
        aecblocks7[2] = new ECBlocks(22, aecb30);
        ECB aecb31[] = new ECB[2];
        aecb31[0] = new ECB(4, 14);
        aecb31[1] = new ECB(2, 15);
        aecblocks7[3] = new ECBlocks(26, aecb31);
        aversion[7] = new Version(8, ai7, aecblocks7);
        int ai8[] = {
            6, 26, 46
        };
        ECBlocks aecblocks8[] = new ECBlocks[4];
        ECB aecb32[] = new ECB[1];
        aecb32[0] = new ECB(2, 116);
        aecblocks8[0] = new ECBlocks(30, aecb32);
        ECB aecb33[] = new ECB[2];
        aecb33[0] = new ECB(3, 36);
        aecb33[1] = new ECB(2, 37);
        aecblocks8[1] = new ECBlocks(22, aecb33);
        ECB aecb34[] = new ECB[2];
        aecb34[0] = new ECB(4, 16);
        aecb34[1] = new ECB(4, 17);
        aecblocks8[2] = new ECBlocks(20, aecb34);
        ECB aecb35[] = new ECB[2];
        aecb35[0] = new ECB(4, 12);
        aecb35[1] = new ECB(4, 13);
        aecblocks8[3] = new ECBlocks(24, aecb35);
        aversion[8] = new Version(9, ai8, aecblocks8);
        int ai9[] = {
            6, 28, 50
        };
        ECBlocks aecblocks9[] = new ECBlocks[4];
        ECB aecb36[] = new ECB[2];
        aecb36[0] = new ECB(2, 68);
        aecb36[1] = new ECB(2, 69);
        aecblocks9[0] = new ECBlocks(18, aecb36);
        ECB aecb37[] = new ECB[2];
        aecb37[0] = new ECB(4, 43);
        aecb37[1] = new ECB(1, 44);
        aecblocks9[1] = new ECBlocks(26, aecb37);
        ECB aecb38[] = new ECB[2];
        aecb38[0] = new ECB(6, 19);
        aecb38[1] = new ECB(2, 20);
        aecblocks9[2] = new ECBlocks(24, aecb38);
        ECB aecb39[] = new ECB[2];
        aecb39[0] = new ECB(6, 15);
        aecb39[1] = new ECB(2, 16);
        aecblocks9[3] = new ECBlocks(28, aecb39);
        aversion[9] = new Version(10, ai9, aecblocks9);
        int ai10[] = {
            6, 30, 54
        };
        ECBlocks aecblocks10[] = new ECBlocks[4];
        ECB aecb40[] = new ECB[1];
        aecb40[0] = new ECB(4, 81);
        aecblocks10[0] = new ECBlocks(20, aecb40);
        ECB aecb41[] = new ECB[2];
        aecb41[0] = new ECB(1, 50);
        aecb41[1] = new ECB(4, 51);
        aecblocks10[1] = new ECBlocks(30, aecb41);
        ECB aecb42[] = new ECB[2];
        aecb42[0] = new ECB(4, 22);
        aecb42[1] = new ECB(4, 23);
        aecblocks10[2] = new ECBlocks(28, aecb42);
        ECB aecb43[] = new ECB[2];
        aecb43[0] = new ECB(3, 12);
        aecb43[1] = new ECB(8, 13);
        aecblocks10[3] = new ECBlocks(24, aecb43);
        aversion[10] = new Version(11, ai10, aecblocks10);
        int ai11[] = {
            6, 32, 58
        };
        ECBlocks aecblocks11[] = new ECBlocks[4];
        ECB aecb44[] = new ECB[2];
        aecb44[0] = new ECB(2, 92);
        aecb44[1] = new ECB(2, 93);
        aecblocks11[0] = new ECBlocks(24, aecb44);
        ECB aecb45[] = new ECB[2];
        aecb45[0] = new ECB(6, 36);
        aecb45[1] = new ECB(2, 37);
        aecblocks11[1] = new ECBlocks(22, aecb45);
        ECB aecb46[] = new ECB[2];
        aecb46[0] = new ECB(4, 20);
        aecb46[1] = new ECB(6, 21);
        aecblocks11[2] = new ECBlocks(26, aecb46);
        ECB aecb47[] = new ECB[2];
        aecb47[0] = new ECB(7, 14);
        aecb47[1] = new ECB(4, 15);
        aecblocks11[3] = new ECBlocks(28, aecb47);
        aversion[11] = new Version(12, ai11, aecblocks11);
        int ai12[] = {
            6, 34, 62
        };
        ECBlocks aecblocks12[] = new ECBlocks[4];
        ECB aecb48[] = new ECB[1];
        aecb48[0] = new ECB(4, 107);
        aecblocks12[0] = new ECBlocks(26, aecb48);
        ECB aecb49[] = new ECB[2];
        aecb49[0] = new ECB(8, 37);
        aecb49[1] = new ECB(1, 38);
        aecblocks12[1] = new ECBlocks(22, aecb49);
        ECB aecb50[] = new ECB[2];
        aecb50[0] = new ECB(8, 20);
        aecb50[1] = new ECB(4, 21);
        aecblocks12[2] = new ECBlocks(24, aecb50);
        ECB aecb51[] = new ECB[2];
        aecb51[0] = new ECB(12, 11);
        aecb51[1] = new ECB(4, 12);
        aecblocks12[3] = new ECBlocks(22, aecb51);
        aversion[12] = new Version(13, ai12, aecblocks12);
        int ai13[] = {
            6, 26, 46, 66
        };
        ECBlocks aecblocks13[] = new ECBlocks[4];
        ECB aecb52[] = new ECB[2];
        aecb52[0] = new ECB(3, 115);
        aecb52[1] = new ECB(1, 116);
        aecblocks13[0] = new ECBlocks(30, aecb52);
        ECB aecb53[] = new ECB[2];
        aecb53[0] = new ECB(4, 40);
        aecb53[1] = new ECB(5, 41);
        aecblocks13[1] = new ECBlocks(24, aecb53);
        ECB aecb54[] = new ECB[2];
        aecb54[0] = new ECB(11, 16);
        aecb54[1] = new ECB(5, 17);
        aecblocks13[2] = new ECBlocks(20, aecb54);
        ECB aecb55[] = new ECB[2];
        aecb55[0] = new ECB(11, 12);
        aecb55[1] = new ECB(5, 13);
        aecblocks13[3] = new ECBlocks(24, aecb55);
        aversion[13] = new Version(14, ai13, aecblocks13);
        int ai14[] = {
            6, 26, 48, 70
        };
        ECBlocks aecblocks14[] = new ECBlocks[4];
        ECB aecb56[] = new ECB[2];
        aecb56[0] = new ECB(5, 87);
        aecb56[1] = new ECB(1, 88);
        aecblocks14[0] = new ECBlocks(22, aecb56);
        ECB aecb57[] = new ECB[2];
        aecb57[0] = new ECB(5, 41);
        aecb57[1] = new ECB(5, 42);
        aecblocks14[1] = new ECBlocks(24, aecb57);
        ECB aecb58[] = new ECB[2];
        aecb58[0] = new ECB(5, 24);
        aecb58[1] = new ECB(7, 25);
        aecblocks14[2] = new ECBlocks(30, aecb58);
        ECB aecb59[] = new ECB[2];
        aecb59[0] = new ECB(11, 12);
        aecb59[1] = new ECB(7, 13);
        aecblocks14[3] = new ECBlocks(24, aecb59);
        aversion[14] = new Version(15, ai14, aecblocks14);
        int ai15[] = {
            6, 26, 50, 74
        };
        ECBlocks aecblocks15[] = new ECBlocks[4];
        ECB aecb60[] = new ECB[2];
        aecb60[0] = new ECB(5, 98);
        aecb60[1] = new ECB(1, 99);
        aecblocks15[0] = new ECBlocks(24, aecb60);
        ECB aecb61[] = new ECB[2];
        aecb61[0] = new ECB(7, 45);
        aecb61[1] = new ECB(3, 46);
        aecblocks15[1] = new ECBlocks(28, aecb61);
        ECB aecb62[] = new ECB[2];
        aecb62[0] = new ECB(15, 19);
        aecb62[1] = new ECB(2, 20);
        aecblocks15[2] = new ECBlocks(24, aecb62);
        ECB aecb63[] = new ECB[2];
        aecb63[0] = new ECB(3, 15);
        aecb63[1] = new ECB(13, 16);
        aecblocks15[3] = new ECBlocks(30, aecb63);
        aversion[15] = new Version(16, ai15, aecblocks15);
        int ai16[] = {
            6, 30, 54, 78
        };
        ECBlocks aecblocks16[] = new ECBlocks[4];
        ECB aecb64[] = new ECB[2];
        aecb64[0] = new ECB(1, 107);
        aecb64[1] = new ECB(5, 108);
        aecblocks16[0] = new ECBlocks(28, aecb64);
        ECB aecb65[] = new ECB[2];
        aecb65[0] = new ECB(10, 46);
        aecb65[1] = new ECB(1, 47);
        aecblocks16[1] = new ECBlocks(28, aecb65);
        ECB aecb66[] = new ECB[2];
        aecb66[0] = new ECB(1, 22);
        aecb66[1] = new ECB(15, 23);
        aecblocks16[2] = new ECBlocks(28, aecb66);
        ECB aecb67[] = new ECB[2];
        aecb67[0] = new ECB(2, 14);
        aecb67[1] = new ECB(17, 15);
        aecblocks16[3] = new ECBlocks(28, aecb67);
        aversion[16] = new Version(17, ai16, aecblocks16);
        int ai17[] = {
            6, 30, 56, 82
        };
        ECBlocks aecblocks17[] = new ECBlocks[4];
        ECB aecb68[] = new ECB[2];
        aecb68[0] = new ECB(5, 120);
        aecb68[1] = new ECB(1, 121);
        aecblocks17[0] = new ECBlocks(30, aecb68);
        ECB aecb69[] = new ECB[2];
        aecb69[0] = new ECB(9, 43);
        aecb69[1] = new ECB(4, 44);
        aecblocks17[1] = new ECBlocks(26, aecb69);
        ECB aecb70[] = new ECB[2];
        aecb70[0] = new ECB(17, 22);
        aecb70[1] = new ECB(1, 23);
        aecblocks17[2] = new ECBlocks(28, aecb70);
        ECB aecb71[] = new ECB[2];
        aecb71[0] = new ECB(2, 14);
        aecb71[1] = new ECB(19, 15);
        aecblocks17[3] = new ECBlocks(28, aecb71);
        aversion[17] = new Version(18, ai17, aecblocks17);
        int ai18[] = {
            6, 30, 58, 86
        };
        ECBlocks aecblocks18[] = new ECBlocks[4];
        ECB aecb72[] = new ECB[2];
        aecb72[0] = new ECB(3, 113);
        aecb72[1] = new ECB(4, 114);
        aecblocks18[0] = new ECBlocks(28, aecb72);
        ECB aecb73[] = new ECB[2];
        aecb73[0] = new ECB(3, 44);
        aecb73[1] = new ECB(11, 45);
        aecblocks18[1] = new ECBlocks(26, aecb73);
        ECB aecb74[] = new ECB[2];
        aecb74[0] = new ECB(17, 21);
        aecb74[1] = new ECB(4, 22);
        aecblocks18[2] = new ECBlocks(26, aecb74);
        ECB aecb75[] = new ECB[2];
        aecb75[0] = new ECB(9, 13);
        aecb75[1] = new ECB(16, 14);
        aecblocks18[3] = new ECBlocks(26, aecb75);
        aversion[18] = new Version(19, ai18, aecblocks18);
        int ai19[] = {
            6, 34, 62, 90
        };
        ECBlocks aecblocks19[] = new ECBlocks[4];
        ECB aecb76[] = new ECB[2];
        aecb76[0] = new ECB(3, 107);
        aecb76[1] = new ECB(5, 108);
        aecblocks19[0] = new ECBlocks(28, aecb76);
        ECB aecb77[] = new ECB[2];
        aecb77[0] = new ECB(3, 41);
        aecb77[1] = new ECB(13, 42);
        aecblocks19[1] = new ECBlocks(26, aecb77);
        ECB aecb78[] = new ECB[2];
        aecb78[0] = new ECB(15, 24);
        aecb78[1] = new ECB(5, 25);
        aecblocks19[2] = new ECBlocks(30, aecb78);
        ECB aecb79[] = new ECB[2];
        aecb79[0] = new ECB(15, 15);
        aecb79[1] = new ECB(10, 16);
        aecblocks19[3] = new ECBlocks(28, aecb79);
        aversion[19] = new Version(20, ai19, aecblocks19);
        int ai20[] = {
            6, 28, 50, 72, 94
        };
        ECBlocks aecblocks20[] = new ECBlocks[4];
        ECB aecb80[] = new ECB[2];
        aecb80[0] = new ECB(4, 116);
        aecb80[1] = new ECB(4, 117);
        aecblocks20[0] = new ECBlocks(28, aecb80);
        ECB aecb81[] = new ECB[1];
        aecb81[0] = new ECB(17, 42);
        aecblocks20[1] = new ECBlocks(26, aecb81);
        ECB aecb82[] = new ECB[2];
        aecb82[0] = new ECB(17, 22);
        aecb82[1] = new ECB(6, 23);
        aecblocks20[2] = new ECBlocks(28, aecb82);
        ECB aecb83[] = new ECB[2];
        aecb83[0] = new ECB(19, 16);
        aecb83[1] = new ECB(6, 17);
        aecblocks20[3] = new ECBlocks(30, aecb83);
        aversion[20] = new Version(21, ai20, aecblocks20);
        int ai21[] = {
            6, 26, 50, 74, 98
        };
        ECBlocks aecblocks21[] = new ECBlocks[4];
        ECB aecb84[] = new ECB[2];
        aecb84[0] = new ECB(2, 111);
        aecb84[1] = new ECB(7, 112);
        aecblocks21[0] = new ECBlocks(28, aecb84);
        ECB aecb85[] = new ECB[1];
        aecb85[0] = new ECB(17, 46);
        aecblocks21[1] = new ECBlocks(28, aecb85);
        ECB aecb86[] = new ECB[2];
        aecb86[0] = new ECB(7, 24);
        aecb86[1] = new ECB(16, 25);
        aecblocks21[2] = new ECBlocks(30, aecb86);
        ECB aecb87[] = new ECB[1];
        aecb87[0] = new ECB(34, 13);
        aecblocks21[3] = new ECBlocks(24, aecb87);
        aversion[21] = new Version(22, ai21, aecblocks21);
        int ai22[] = {
            6, 30, 54, 78, 102
        };
        ECBlocks aecblocks22[] = new ECBlocks[4];
        ECB aecb88[] = new ECB[2];
        aecb88[0] = new ECB(4, 121);
        aecb88[1] = new ECB(5, 122);
        aecblocks22[0] = new ECBlocks(30, aecb88);
        ECB aecb89[] = new ECB[2];
        aecb89[0] = new ECB(4, 47);
        aecb89[1] = new ECB(14, 48);
        aecblocks22[1] = new ECBlocks(28, aecb89);
        ECB aecb90[] = new ECB[2];
        aecb90[0] = new ECB(11, 24);
        aecb90[1] = new ECB(14, 25);
        aecblocks22[2] = new ECBlocks(30, aecb90);
        ECB aecb91[] = new ECB[2];
        aecb91[0] = new ECB(16, 15);
        aecb91[1] = new ECB(14, 16);
        aecblocks22[3] = new ECBlocks(30, aecb91);
        aversion[22] = new Version(23, ai22, aecblocks22);
        int ai23[] = {
            6, 28, 54, 80, 106
        };
        ECBlocks aecblocks23[] = new ECBlocks[4];
        ECB aecb92[] = new ECB[2];
        aecb92[0] = new ECB(6, 117);
        aecb92[1] = new ECB(4, 118);
        aecblocks23[0] = new ECBlocks(30, aecb92);
        ECB aecb93[] = new ECB[2];
        aecb93[0] = new ECB(6, 45);
        aecb93[1] = new ECB(14, 46);
        aecblocks23[1] = new ECBlocks(28, aecb93);
        ECB aecb94[] = new ECB[2];
        aecb94[0] = new ECB(11, 24);
        aecb94[1] = new ECB(16, 25);
        aecblocks23[2] = new ECBlocks(30, aecb94);
        ECB aecb95[] = new ECB[2];
        aecb95[0] = new ECB(30, 16);
        aecb95[1] = new ECB(2, 17);
        aecblocks23[3] = new ECBlocks(30, aecb95);
        aversion[23] = new Version(24, ai23, aecblocks23);
        int ai24[] = {
            6, 32, 58, 84, 110
        };
        ECBlocks aecblocks24[] = new ECBlocks[4];
        ECB aecb96[] = new ECB[2];
        aecb96[0] = new ECB(8, 106);
        aecb96[1] = new ECB(4, 107);
        aecblocks24[0] = new ECBlocks(26, aecb96);
        ECB aecb97[] = new ECB[2];
        aecb97[0] = new ECB(8, 47);
        aecb97[1] = new ECB(13, 48);
        aecblocks24[1] = new ECBlocks(28, aecb97);
        ECB aecb98[] = new ECB[2];
        aecb98[0] = new ECB(7, 24);
        aecb98[1] = new ECB(22, 25);
        aecblocks24[2] = new ECBlocks(30, aecb98);
        ECB aecb99[] = new ECB[2];
        aecb99[0] = new ECB(22, 15);
        aecb99[1] = new ECB(13, 16);
        aecblocks24[3] = new ECBlocks(30, aecb99);
        aversion[24] = new Version(25, ai24, aecblocks24);
        int ai25[] = {
            6, 30, 58, 86, 114
        };
        ECBlocks aecblocks25[] = new ECBlocks[4];
        ECB aecb100[] = new ECB[2];
        aecb100[0] = new ECB(10, 114);
        aecb100[1] = new ECB(2, 115);
        aecblocks25[0] = new ECBlocks(28, aecb100);
        ECB aecb101[] = new ECB[2];
        aecb101[0] = new ECB(19, 46);
        aecb101[1] = new ECB(4, 47);
        aecblocks25[1] = new ECBlocks(28, aecb101);
        ECB aecb102[] = new ECB[2];
        aecb102[0] = new ECB(28, 22);
        aecb102[1] = new ECB(6, 23);
        aecblocks25[2] = new ECBlocks(28, aecb102);
        ECB aecb103[] = new ECB[2];
        aecb103[0] = new ECB(33, 16);
        aecb103[1] = new ECB(4, 17);
        aecblocks25[3] = new ECBlocks(30, aecb103);
        aversion[25] = new Version(26, ai25, aecblocks25);
        int ai26[] = {
            6, 34, 62, 90, 118
        };
        ECBlocks aecblocks26[] = new ECBlocks[4];
        ECB aecb104[] = new ECB[2];
        aecb104[0] = new ECB(8, 122);
        aecb104[1] = new ECB(4, 123);
        aecblocks26[0] = new ECBlocks(30, aecb104);
        ECB aecb105[] = new ECB[2];
        aecb105[0] = new ECB(22, 45);
        aecb105[1] = new ECB(3, 46);
        aecblocks26[1] = new ECBlocks(28, aecb105);
        ECB aecb106[] = new ECB[2];
        aecb106[0] = new ECB(8, 23);
        aecb106[1] = new ECB(26, 24);
        aecblocks26[2] = new ECBlocks(30, aecb106);
        ECB aecb107[] = new ECB[2];
        aecb107[0] = new ECB(12, 15);
        aecb107[1] = new ECB(28, 16);
        aecblocks26[3] = new ECBlocks(30, aecb107);
        aversion[26] = new Version(27, ai26, aecblocks26);
        int ai27[] = {
            6, 26, 50, 74, 98, 122
        };
        ECBlocks aecblocks27[] = new ECBlocks[4];
        ECB aecb108[] = new ECB[2];
        aecb108[0] = new ECB(3, 117);
        aecb108[1] = new ECB(10, 118);
        aecblocks27[0] = new ECBlocks(30, aecb108);
        ECB aecb109[] = new ECB[2];
        aecb109[0] = new ECB(3, 45);
        aecb109[1] = new ECB(23, 46);
        aecblocks27[1] = new ECBlocks(28, aecb109);
        ECB aecb110[] = new ECB[2];
        aecb110[0] = new ECB(4, 24);
        aecb110[1] = new ECB(31, 25);
        aecblocks27[2] = new ECBlocks(30, aecb110);
        ECB aecb111[] = new ECB[2];
        aecb111[0] = new ECB(11, 15);
        aecb111[1] = new ECB(31, 16);
        aecblocks27[3] = new ECBlocks(30, aecb111);
        aversion[27] = new Version(28, ai27, aecblocks27);
        int ai28[] = {
            6, 30, 54, 78, 102, 126
        };
        ECBlocks aecblocks28[] = new ECBlocks[4];
        ECB aecb112[] = new ECB[2];
        aecb112[0] = new ECB(7, 116);
        aecb112[1] = new ECB(7, 117);
        aecblocks28[0] = new ECBlocks(30, aecb112);
        ECB aecb113[] = new ECB[2];
        aecb113[0] = new ECB(21, 45);
        aecb113[1] = new ECB(7, 46);
        aecblocks28[1] = new ECBlocks(28, aecb113);
        ECB aecb114[] = new ECB[2];
        aecb114[0] = new ECB(1, 23);
        aecb114[1] = new ECB(37, 24);
        aecblocks28[2] = new ECBlocks(30, aecb114);
        ECB aecb115[] = new ECB[2];
        aecb115[0] = new ECB(19, 15);
        aecb115[1] = new ECB(26, 16);
        aecblocks28[3] = new ECBlocks(30, aecb115);
        aversion[28] = new Version(29, ai28, aecblocks28);
        int ai29[] = {
            6, 26, 52, 78, 104, 130
        };
        ECBlocks aecblocks29[] = new ECBlocks[4];
        ECB aecb116[] = new ECB[2];
        aecb116[0] = new ECB(5, 115);
        aecb116[1] = new ECB(10, 116);
        aecblocks29[0] = new ECBlocks(30, aecb116);
        ECB aecb117[] = new ECB[2];
        aecb117[0] = new ECB(19, 47);
        aecb117[1] = new ECB(10, 48);
        aecblocks29[1] = new ECBlocks(28, aecb117);
        ECB aecb118[] = new ECB[2];
        aecb118[0] = new ECB(15, 24);
        aecb118[1] = new ECB(25, 25);
        aecblocks29[2] = new ECBlocks(30, aecb118);
        ECB aecb119[] = new ECB[2];
        aecb119[0] = new ECB(23, 15);
        aecb119[1] = new ECB(25, 16);
        aecblocks29[3] = new ECBlocks(30, aecb119);
        aversion[29] = new Version(30, ai29, aecblocks29);
        int ai30[] = {
            6, 30, 56, 82, 108, 134
        };
        ECBlocks aecblocks30[] = new ECBlocks[4];
        ECB aecb120[] = new ECB[2];
        aecb120[0] = new ECB(13, 115);
        aecb120[1] = new ECB(3, 116);
        aecblocks30[0] = new ECBlocks(30, aecb120);
        ECB aecb121[] = new ECB[2];
        aecb121[0] = new ECB(2, 46);
        aecb121[1] = new ECB(29, 47);
        aecblocks30[1] = new ECBlocks(28, aecb121);
        ECB aecb122[] = new ECB[2];
        aecb122[0] = new ECB(42, 24);
        aecb122[1] = new ECB(1, 25);
        aecblocks30[2] = new ECBlocks(30, aecb122);
        ECB aecb123[] = new ECB[2];
        aecb123[0] = new ECB(23, 15);
        aecb123[1] = new ECB(28, 16);
        aecblocks30[3] = new ECBlocks(30, aecb123);
        aversion[30] = new Version(31, ai30, aecblocks30);
        int ai31[] = {
            6, 34, 60, 86, 112, 138
        };
        ECBlocks aecblocks31[] = new ECBlocks[4];
        ECB aecb124[] = new ECB[1];
        aecb124[0] = new ECB(17, 115);
        aecblocks31[0] = new ECBlocks(30, aecb124);
        ECB aecb125[] = new ECB[2];
        aecb125[0] = new ECB(10, 46);
        aecb125[1] = new ECB(23, 47);
        aecblocks31[1] = new ECBlocks(28, aecb125);
        ECB aecb126[] = new ECB[2];
        aecb126[0] = new ECB(10, 24);
        aecb126[1] = new ECB(35, 25);
        aecblocks31[2] = new ECBlocks(30, aecb126);
        ECB aecb127[] = new ECB[2];
        aecb127[0] = new ECB(19, 15);
        aecb127[1] = new ECB(35, 16);
        aecblocks31[3] = new ECBlocks(30, aecb127);
        aversion[31] = new Version(32, ai31, aecblocks31);
        int ai32[] = {
            6, 30, 58, 86, 114, 142
        };
        ECBlocks aecblocks32[] = new ECBlocks[4];
        ECB aecb128[] = new ECB[2];
        aecb128[0] = new ECB(17, 115);
        aecb128[1] = new ECB(1, 116);
        aecblocks32[0] = new ECBlocks(30, aecb128);
        ECB aecb129[] = new ECB[2];
        aecb129[0] = new ECB(14, 46);
        aecb129[1] = new ECB(21, 47);
        aecblocks32[1] = new ECBlocks(28, aecb129);
        ECB aecb130[] = new ECB[2];
        aecb130[0] = new ECB(29, 24);
        aecb130[1] = new ECB(19, 25);
        aecblocks32[2] = new ECBlocks(30, aecb130);
        ECB aecb131[] = new ECB[2];
        aecb131[0] = new ECB(11, 15);
        aecb131[1] = new ECB(46, 16);
        aecblocks32[3] = new ECBlocks(30, aecb131);
        aversion[32] = new Version(33, ai32, aecblocks32);
        int ai33[] = {
            6, 34, 62, 90, 118, 146
        };
        ECBlocks aecblocks33[] = new ECBlocks[4];
        ECB aecb132[] = new ECB[2];
        aecb132[0] = new ECB(13, 115);
        aecb132[1] = new ECB(6, 116);
        aecblocks33[0] = new ECBlocks(30, aecb132);
        ECB aecb133[] = new ECB[2];
        aecb133[0] = new ECB(14, 46);
        aecb133[1] = new ECB(23, 47);
        aecblocks33[1] = new ECBlocks(28, aecb133);
        ECB aecb134[] = new ECB[2];
        aecb134[0] = new ECB(44, 24);
        aecb134[1] = new ECB(7, 25);
        aecblocks33[2] = new ECBlocks(30, aecb134);
        ECB aecb135[] = new ECB[2];
        aecb135[0] = new ECB(59, 16);
        aecb135[1] = new ECB(1, 17);
        aecblocks33[3] = new ECBlocks(30, aecb135);
        aversion[33] = new Version(34, ai33, aecblocks33);
        int ai34[] = {
            6, 30, 54, 78, 102, 126, 150
        };
        ECBlocks aecblocks34[] = new ECBlocks[4];
        ECB aecb136[] = new ECB[2];
        aecb136[0] = new ECB(12, 121);
        aecb136[1] = new ECB(7, 122);
        aecblocks34[0] = new ECBlocks(30, aecb136);
        ECB aecb137[] = new ECB[2];
        aecb137[0] = new ECB(12, 47);
        aecb137[1] = new ECB(26, 48);
        aecblocks34[1] = new ECBlocks(28, aecb137);
        ECB aecb138[] = new ECB[2];
        aecb138[0] = new ECB(39, 24);
        aecb138[1] = new ECB(14, 25);
        aecblocks34[2] = new ECBlocks(30, aecb138);
        ECB aecb139[] = new ECB[2];
        aecb139[0] = new ECB(22, 15);
        aecb139[1] = new ECB(41, 16);
        aecblocks34[3] = new ECBlocks(30, aecb139);
        aversion[34] = new Version(35, ai34, aecblocks34);
        int ai35[] = {
            6, 24, 50, 76, 102, 128, 154
        };
        ECBlocks aecblocks35[] = new ECBlocks[4];
        ECB aecb140[] = new ECB[2];
        aecb140[0] = new ECB(6, 121);
        aecb140[1] = new ECB(14, 122);
        aecblocks35[0] = new ECBlocks(30, aecb140);
        ECB aecb141[] = new ECB[2];
        aecb141[0] = new ECB(6, 47);
        aecb141[1] = new ECB(34, 48);
        aecblocks35[1] = new ECBlocks(28, aecb141);
        ECB aecb142[] = new ECB[2];
        aecb142[0] = new ECB(46, 24);
        aecb142[1] = new ECB(10, 25);
        aecblocks35[2] = new ECBlocks(30, aecb142);
        ECB aecb143[] = new ECB[2];
        aecb143[0] = new ECB(2, 15);
        aecb143[1] = new ECB(64, 16);
        aecblocks35[3] = new ECBlocks(30, aecb143);
        aversion[35] = new Version(36, ai35, aecblocks35);
        int ai36[] = {
            6, 28, 54, 80, 106, 132, 158
        };
        ECBlocks aecblocks36[] = new ECBlocks[4];
        ECB aecb144[] = new ECB[2];
        aecb144[0] = new ECB(17, 122);
        aecb144[1] = new ECB(4, 123);
        aecblocks36[0] = new ECBlocks(30, aecb144);
        ECB aecb145[] = new ECB[2];
        aecb145[0] = new ECB(29, 46);
        aecb145[1] = new ECB(14, 47);
        aecblocks36[1] = new ECBlocks(28, aecb145);
        ECB aecb146[] = new ECB[2];
        aecb146[0] = new ECB(49, 24);
        aecb146[1] = new ECB(10, 25);
        aecblocks36[2] = new ECBlocks(30, aecb146);
        ECB aecb147[] = new ECB[2];
        aecb147[0] = new ECB(24, 15);
        aecb147[1] = new ECB(46, 16);
        aecblocks36[3] = new ECBlocks(30, aecb147);
        aversion[36] = new Version(37, ai36, aecblocks36);
        int ai37[] = {
            6, 32, 58, 84, 110, 136, 162
        };
        ECBlocks aecblocks37[] = new ECBlocks[4];
        ECB aecb148[] = new ECB[2];
        aecb148[0] = new ECB(4, 122);
        aecb148[1] = new ECB(18, 123);
        aecblocks37[0] = new ECBlocks(30, aecb148);
        ECB aecb149[] = new ECB[2];
        aecb149[0] = new ECB(13, 46);
        aecb149[1] = new ECB(32, 47);
        aecblocks37[1] = new ECBlocks(28, aecb149);
        ECB aecb150[] = new ECB[2];
        aecb150[0] = new ECB(48, 24);
        aecb150[1] = new ECB(14, 25);
        aecblocks37[2] = new ECBlocks(30, aecb150);
        ECB aecb151[] = new ECB[2];
        aecb151[0] = new ECB(42, 15);
        aecb151[1] = new ECB(32, 16);
        aecblocks37[3] = new ECBlocks(30, aecb151);
        aversion[37] = new Version(38, ai37, aecblocks37);
        int ai38[] = {
            6, 26, 54, 82, 110, 138, 166
        };
        ECBlocks aecblocks38[] = new ECBlocks[4];
        ECB aecb152[] = new ECB[2];
        aecb152[0] = new ECB(20, 117);
        aecb152[1] = new ECB(4, 118);
        aecblocks38[0] = new ECBlocks(30, aecb152);
        ECB aecb153[] = new ECB[2];
        aecb153[0] = new ECB(40, 47);
        aecb153[1] = new ECB(7, 48);
        aecblocks38[1] = new ECBlocks(28, aecb153);
        ECB aecb154[] = new ECB[2];
        aecb154[0] = new ECB(43, 24);
        aecb154[1] = new ECB(22, 25);
        aecblocks38[2] = new ECBlocks(30, aecb154);
        ECB aecb155[] = new ECB[2];
        aecb155[0] = new ECB(10, 15);
        aecb155[1] = new ECB(67, 16);
        aecblocks38[3] = new ECBlocks(30, aecb155);
        aversion[38] = new Version(39, ai38, aecblocks38);
        int ai39[] = {
            6, 30, 58, 86, 114, 142, 170
        };
        ECBlocks aecblocks39[] = new ECBlocks[4];
        ECB aecb156[] = new ECB[2];
        aecb156[0] = new ECB(19, 118);
        aecb156[1] = new ECB(6, 119);
        aecblocks39[0] = new ECBlocks(30, aecb156);
        ECB aecb157[] = new ECB[2];
        aecb157[0] = new ECB(18, 47);
        aecb157[1] = new ECB(31, 48);
        aecblocks39[1] = new ECBlocks(28, aecb157);
        ECB aecb158[] = new ECB[2];
        aecb158[0] = new ECB(34, 24);
        aecb158[1] = new ECB(34, 25);
        aecblocks39[2] = new ECBlocks(30, aecb158);
        ECB aecb159[] = new ECB[2];
        aecb159[0] = new ECB(20, 15);
        aecb159[1] = new ECB(61, 16);
        aecblocks39[3] = new ECBlocks(30, aecb159);
        aversion[39] = new Version(40, ai39, aecblocks39);
        return aversion;
    }

    public static Version getProvisionalVersionForDimension(int i)
    {
        if (i % 4 != 1)
        {
            throw FormatException.getFormatInstance();
        }
        int j = i - 17 >> 2;
        Version version;
        try
        {
            version = getVersionForNumber(j);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            throw FormatException.getFormatInstance();
        }
        return version;
    }

    public static Version getVersionForNumber(int i)
    {
        if (i < 1 || i > 40)
        {
            throw new IllegalArgumentException();
        } else
        {
            return b[i - 1];
        }
    }

    BitMatrix a()
    {
        int i = getDimensionForVersion();
        BitMatrix bitmatrix = new BitMatrix(i);
        bitmatrix.setRegion(0, 0, 9, 9);
        bitmatrix.setRegion(i - 8, 0, 8, 9);
        bitmatrix.setRegion(0, i - 8, 9, 8);
        int j = d.length;
        for (int k = 0; k < j; k++)
        {
            int l = -2 + d[k];
            int i1 = 0;
            while (i1 < j) 
            {
                if ((k != 0 || i1 != 0 && i1 != j - 1) && (k != j - 1 || i1 != 0))
                {
                    bitmatrix.setRegion(-2 + d[i1], l, 5, 5);
                }
                i1++;
            }
        }

        bitmatrix.setRegion(6, 9, 1, i - 17);
        bitmatrix.setRegion(9, 6, i - 17, 1);
        if (c > 6)
        {
            bitmatrix.setRegion(i - 11, 0, 3, 6);
            bitmatrix.setRegion(0, i - 11, 6, 3);
        }
        return bitmatrix;
    }

    public int[] getAlignmentPatternCenters()
    {
        return d;
    }

    public int getDimensionForVersion()
    {
        return 17 + 4 * c;
    }

    public ECBlocks getECBlocksForLevel(ErrorCorrectionLevel errorcorrectionlevel)
    {
        return e[errorcorrectionlevel.ordinal()];
    }

    public int getTotalCodewords()
    {
        return f;
    }

    public int getVersionNumber()
    {
        return c;
    }

    public String toString()
    {
        return String.valueOf(c);
    }


    private class ECBlocks
    {

        private final int a;
        private final ECB b[];

        public ECB[] getECBlocks()
        {
            return b;
        }

        public int getECCodewordsPerBlock()
        {
            return a;
        }

        public int getNumBlocks()
        {
            int i = 0;
            ECB aecb[] = b;
            int j = aecb.length;
            int k = 0;
            for (; i < j; i++)
            {
                k += aecb[i].getCount();
            }

            return k;
        }

        public int getTotalECCodewords()
        {
            return a * getNumBlocks();
        }

        transient ECBlocks(int i, ECB aecb[])
        {
            a = i;
            b = aecb;
        }
    }


    private class ECB
    {

        private final int a;
        private final int b;

        public int getCount()
        {
            return a;
        }

        public int getDataCodewords()
        {
            return b;
        }

        ECB(int i, int j)
        {
            a = i;
            b = j;
        }
    }

}
