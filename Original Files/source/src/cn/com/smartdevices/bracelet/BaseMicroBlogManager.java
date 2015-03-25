// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet;

import cn.com.smartdevices.bracelet.model.MicroBlogItem;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import java.util.ArrayList;

public class BaseMicroBlogManager
{

    public static final int PAGE_BLOG_COUNT = 10;
    private PersonInfo a;
    private ArrayList b;
    private int c;

    public BaseMicroBlogManager()
    {
        b = new ArrayList();
        c = 0;
    }

    public void addBlog(MicroBlogItem microblogitem)
    {
        b.add(microblogitem);
    }

    public void addBlogs(ArrayList arraylist)
    {
        b.addAll(arraylist);
    }

    public void clearBlogs()
    {
        b.clear();
        c = 0;
    }

    public MicroBlogItem getBlog(int i)
    {
        if (i < 0 || i > -1 + b.size())
        {
            return null;
        } else
        {
            return (MicroBlogItem)b.get(i);
        }
    }

    public ArrayList getBlogs()
    {
        return b;
    }

    public PersonInfo getCurOwner()
    {
        return a;
    }

    public int pageCount()
    {
        return c;
    }

    public void setCurOwner(PersonInfo personinfo)
    {
        a = personinfo;
    }

    public void setCurOwner(ArrayList arraylist)
    {
        if (arraylist != null && arraylist.size() > 0)
        {
            a = ((MicroBlogItem)arraylist.get(0)).info;
        }
    }

    public void setPageCount(int i)
    {
        c = i;
    }
}
