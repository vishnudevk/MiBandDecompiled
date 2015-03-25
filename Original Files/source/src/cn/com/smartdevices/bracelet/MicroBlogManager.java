// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet;


// Referenced classes of package cn.com.smartdevices.bracelet:
//            BaseMicroBlogManager

public class MicroBlogManager extends BaseMicroBlogManager
{

    private static MicroBlogManager a = null;

    private MicroBlogManager()
    {
    }

    public static MicroBlogManager getInstance()
    {
        if (a == null)
        {
            a = new MicroBlogManager();
        }
        return a;
    }

}
