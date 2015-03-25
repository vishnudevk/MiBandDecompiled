// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.weather;


public class A
{

    private String affiliation;
    private String father;
    private String language;
    private String name;
    private String shortName;

    public String getAffiliation()
    {
        return affiliation;
    }

    public String getFather()
    {
        return father;
    }

    public String getLanguage()
    {
        return language;
    }

    public String getName()
    {
        return name;
    }

    public String getShortName()
    {
        return shortName;
    }

    public void setAffiliation(String s)
    {
        affiliation = s;
    }

    public void setFather(String s)
    {
        father = s;
    }

    public void setLanguage(String s)
    {
        language = s;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setShortName(String s)
    {
        shortName = s;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("\n\t\t").append("Affiliation : ").append(affiliation).append(", ");
        stringbuilder.append("\n\t\t").append("Father : ").append(father).append(", ");
        stringbuilder.append("\n\t\t").append("Language : ").append(language).append(", ");
        stringbuilder.append("\n\t\t").append("Name : ").append(name).append(", ");
        stringbuilder.append("\n\t\t").append("ShortName : ").append(shortName);
        return stringbuilder.toString();
    }

    public A()
    {
    }
}
