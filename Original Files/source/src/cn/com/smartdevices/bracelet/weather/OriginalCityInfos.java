// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.weather;

import java.util.ArrayList;
import java.util.Iterator;

public class OriginalCityInfos
{

    private ArrayList cityInfos;

    public OriginalCityInfos()
    {
    }

    public ArrayList getCityInfos()
    {
        return cityInfos;
    }

    public void setCityInfos(ArrayList arraylist)
    {
        cityInfos = arraylist;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (Iterator iterator = cityInfos.iterator(); iterator.hasNext(); stringbuilder.append((CityInfo)iterator.next())) { }
        return stringbuilder.toString();
    }

    private class CityInfo
    {

        private MetaData metaData;
        private ArrayList names;
        private int namesSize;

        public MetaData getMetaData()
        {
            return metaData;
        }

        public ArrayList getNames()
        {
            return names;
        }

        public int getNamesSize()
        {
            return namesSize;
        }

        public void setMetaData(MetaData metadata)
        {
            metaData = metadata;
        }

        public void setNames(ArrayList arraylist)
        {
            names = arraylist;
        }

        public void setNamesSize(int i)
        {
            namesSize = i;
        }

        public String toString()
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("\n\t").append("MetaData : ").append(metaData);
            stringbuilder.append("\n\t").append("Names : ");
            for (Iterator iterator = names.iterator(); iterator.hasNext(); stringbuilder.append((Name)iterator.next())) { }
            stringbuilder.append("\n\t").append("NamesSize : ").append(namesSize);
            return stringbuilder.toString();
        }

        public CityInfo()
        {
        }

        private class Name
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

            public Name()
            {
            }
        }

    }

}
