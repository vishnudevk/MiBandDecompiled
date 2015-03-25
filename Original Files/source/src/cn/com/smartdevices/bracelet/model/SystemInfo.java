// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.model;


public class SystemInfo
{

    public String braceletMacAddress;
    public String deviceId;
    public String fwVersion;
    public String miuiVersionCode;
    public String miuiVersionName;
    public String phoneBrand;
    public String phoneModel;
    public String phoneSystem;
    public String softVersion;

    public SystemInfo()
    {
        deviceId = "";
        braceletMacAddress = "";
        miuiVersionName = "";
        miuiVersionCode = "";
        phoneBrand = "";
        phoneModel = "";
        phoneSystem = "";
        fwVersion = "";
        softVersion = "";
    }

    public String toString()
    {
        return (new StringBuilder()).append("deviceId:").append(deviceId).append("\n").append("braceletMacAddress:").append(braceletMacAddress).append("\n").append("miuiVersionName:").append(miuiVersionName).append("\n").append("miuiVersionCode:").append(miuiVersionCode).append("\n").append("phoneBrand:").append(phoneBrand).append("\n").append("phoneModel:").append(phoneModel).append("\n").append("phoneSystem:").append(phoneSystem).append("\n").append("fwVersion:").append(fwVersion).append("\n").append("softVersion:").append(softVersion).toString();
    }
}
