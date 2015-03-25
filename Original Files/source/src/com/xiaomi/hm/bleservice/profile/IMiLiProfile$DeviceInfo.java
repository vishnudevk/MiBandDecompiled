// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.bleservice.profile;


public final class firmwareVersion
{

    public static final byte STATUS_AUTHENTICATION_FAILED = 1;
    public static final byte STATUS_AUTHENTICATION_SUCCESS = 2;
    public final int appearance;
    public final String deviceID;
    public final int feature;
    public final int firmwareVersion;
    public final int hardwareVersion;
    public final int profileVersion;

    public int getFirmwareVersionBuild()
    {
        return 0xff & firmwareVersion;
    }

    public int getFirmwareVersionMajor()
    {
        return 0xff & firmwareVersion >> 24;
    }

    public int getFirmwareVersionMinor()
    {
        return 0xff & firmwareVersion >> 16;
    }

    public int getFirmwareVersionRevision()
    {
        return 0xff & firmwareVersion >> 8;
    }

    public String getFirmwareVersionStr()
    {
        return (new StringBuilder()).append(getFirmwareVersionMajor()).append(".").append(getFirmwareVersionMinor()).append(".").append(getFirmwareVersionRevision()).append(".").append(getFirmwareVersionBuild()).toString();
    }

    public int getProfileVersionBuild()
    {
        return 0xff & profileVersion;
    }

    public int getProfileVersionMajor()
    {
        return 0xff & profileVersion >> 24;
    }

    public int getProfileVersionMinor()
    {
        return 0xff & profileVersion >> 16;
    }

    public int getProfileVersionRevision()
    {
        return 0xff & profileVersion >> 8;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(256);
        String s = (new StringBuilder()).append("").append(getProfileVersionMajor()).append(".").append(getProfileVersionMinor()).append(".").append(getProfileVersionRevision()).append(".").append(getProfileVersionBuild()).toString();
        stringbuilder.append((new StringBuilder()).append("[[[ ").append(getClass().getSimpleName()).append(" ]]]").toString());
        stringbuilder.append((new StringBuilder()).append("\n         deviceID: ").append(deviceID).toString());
        stringbuilder.append((new StringBuilder()).append("\n          feature: ").append(Integer.toHexString(feature)).toString());
        stringbuilder.append((new StringBuilder()).append("\n       appearance: ").append(Integer.toHexString(appearance)).toString());
        stringbuilder.append((new StringBuilder()).append("\n  hardwareVersion: ").append(Integer.toHexString(hardwareVersion)).toString());
        stringbuilder.append((new StringBuilder()).append("\n   profileVersion: ").append(s).toString());
        stringbuilder.append((new StringBuilder()).append("\n  firmwareVersion: ").append(getFirmwareVersionStr()).toString());
        return stringbuilder.toString();
    }

    public (String s, int i, int j)
    {
        deviceID = s;
        feature = Integer.decode((new StringBuilder()).append("0x").append(s.substring(8, 10)).toString()).intValue();
        appearance = Integer.decode((new StringBuilder()).append("0x").append(s.substring(10, 12)).toString()).intValue();
        hardwareVersion = Integer.decode((new StringBuilder()).append("0x").append(s.substring(12, 14)).toString()).intValue();
        profileVersion = i;
        firmwareVersion = j;
    }
}
