// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.model;

import java.util.ArrayList;

// Referenced classes of package cn.com.smartdevices.bracelet.model:
//            PersonInfo, UploadData, ShareContent, PicUrl, 
//            CommentItem

public class MicroBlogItem
{

    private static final int MAX_COMMENT_COUNT = 5;
    public String allComments;
    public ArrayList comments;
    public int commentsNum;
    public String createTime;
    public UploadData data;
    public PersonInfo info;
    public int likeNum;
    public ArrayList likePersons;
    public long postid;
    public ShareContent shareContent;
    public String source;
    public int systemFlag;
    public int visible;
    public String webUrl;

    public MicroBlogItem()
    {
        postid = -1L;
        info = new PersonInfo();
        data = new UploadData();
        source = "";
        createTime = "";
        likeNum = 0;
        commentsNum = 0;
        comments = new ArrayList();
        likePersons = new ArrayList();
        shareContent = new ShareContent();
        webUrl = "";
        systemFlag = 0;
        visible = 1;
        allComments = "";
    }

    public static MicroBlogItem getDefaultBlogItem()
    {
        MicroBlogItem microblogitem = new MicroBlogItem();
        microblogitem.systemFlag = 1;
        microblogitem.visible = 0;
        microblogitem.webUrl = "file:///android_asset/help.html";
        microblogitem.source = "\u5982\u4F55\u73A9\u8F6C\u5C0F\u7C73\u624B\u73AF";
        microblogitem.createTime = "1401206400000";
        microblogitem.shareContent.shareType = 2;
        PicUrl picurl = new PicUrl();
        picurl.thumbUrl = "drawable://2130837598";
        picurl.originUrl = picurl.thumbUrl;
        microblogitem.shareContent.pics.add(picurl);
        return microblogitem;
    }

    public String getAllComments()
    {
        if (allComments.length() < 1 && comments.size() > 0)
        {
            int i = comments.size();
            if (i > 5)
            {
                i = 5;
            }
            for (int j = 0; j < i; j++)
            {
                CommentItem commentitem = (CommentItem)comments.get(j);
                allComments = (new StringBuilder()).append(allComments).append(commentitem.userInfo.nickname).append(" : ").append(commentitem.message).append("\n").toString();
            }

        }
        return allComments;
    }
}
