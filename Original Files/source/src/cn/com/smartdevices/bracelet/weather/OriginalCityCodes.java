// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.weather;

import java.util.ArrayList;
import java.util.Iterator;

public class OriginalCityCodes
{

    public static String TYPE_ACCU = "accu";
    public static String TYPE_ACCU_MI = "AC_MI";
    public static String TYPE_WEATHER_CHINA = "weathercomcn";
    public static String TYPE_XIAOMI = "xiaomi";
    private ArrayList dataSources;

    public OriginalCityCodes()
    {
    }

    public String getCityCode(String s)
    {
label0:
        {
            if (s == null || dataSources == null)
            {
                break label0;
            }
            Iterator iterator = dataSources.iterator();
            DataSource datasource;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                datasource = (DataSource)iterator.next();
            } while (!s.equals(datasource.getType()));
            return datasource.getKey();
        }
        return null;
    }

    public ArrayList getDataSources()
    {
        return dataSources;
    }

    public void setDataSources(ArrayList arraylist)
    {
        dataSources = arraylist;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        DataSource datasource;
        for (Iterator iterator = dataSources.iterator(); iterator.hasNext(); stringbuilder.append("\n\t").append(datasource))
        {
            datasource = (DataSource)iterator.next();
        }

        return stringbuilder.toString();
    }


    private class DataSource
    {

        private String key;
        private String type;

        public String getKey()
        {
            return key;
        }

        public String getType()
        {
            return type;
        }

        public void setKey(String s)
        {
            key = s;
        }

        public void setType(String s)
        {
            type = s;
        }

        public String toString()
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("Key : ").append(key).append(", ");
            stringbuilder.append("Type : ").append(type);
            return stringbuilder.toString();
        }

        public DataSource()
        {
        }
    }

}
