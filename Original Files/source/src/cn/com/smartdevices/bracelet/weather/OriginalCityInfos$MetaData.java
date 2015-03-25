// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.weather;


public class 
{

    private String altitude;
    private String areaCode;
    private String country;
    private String phoneCode;
    private String x;
    private String y;

    public String getAltitude()
    {
        return altitude;
    }

    public String getAreaCode()
    {
        return areaCode;
    }

    public String getCountry()
    {
        return country;
    }

    public String getPhoneCode()
    {
        return phoneCode;
    }

    public String getX()
    {
        return x;
    }

    public String getY()
    {
        return y;
    }

    public void setAltitude(String s)
    {
        altitude = s;
    }

    public void setAreaCode(String s)
    {
        areaCode = s;
    }

    public void setCountry(String s)
    {
        country = s;
    }

    public void setPhoneCode(String s)
    {
        phoneCode = s;
    }

    public void setX(String s)
    {
        x = s;
    }

    public void setY(String s)
    {
        y = s;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("\n\t\t").append("Altitude : ").append(altitude).append(", ");
        stringbuilder.append("\n\t\t").append("AreaCode : ").append(areaCode).append(", ");
        stringbuilder.append("\n\t\t").append("Country : ").append(country).append(", ");
        stringbuilder.append("\n\t\t").append("PhoneCode : ").append(phoneCode).append(", ");
        stringbuilder.append("\n\t\t").append("X : ").append(x).append(", ");
        stringbuilder.append("\n\t\t").append("Y : ").append(y);
        return stringbuilder.toString();
    }

    public ()
    {
    }
}
