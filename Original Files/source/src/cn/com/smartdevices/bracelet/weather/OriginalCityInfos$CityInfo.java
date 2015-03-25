// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.weather;

import java.util.ArrayList;
import java.util.Iterator;

public class 
{

    private namesSize metaData;
    private ArrayList names;
    private int namesSize;

    public  getMetaData()
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

    public void setMetaData(namesSize namessize)
    {
        metaData = namessize;
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
        for (Iterator iterator = names.iterator(); iterator.hasNext(); stringbuilder.append((names)iterator.next())) { }
        stringbuilder.append("\n\t").append("NamesSize : ").append(namesSize);
        return stringbuilder.toString();
    }

    public ()
    {
    }
}
