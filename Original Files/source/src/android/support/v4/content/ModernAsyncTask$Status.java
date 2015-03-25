// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.content;


public final class  extends Enum
{

    public static final a FINISHED;
    public static final a PENDING;
    public static final a RUNNING;
    private static final a a[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(android/support/v4/content/ModernAsyncTask$Status, s);
    }

    public static [] values()
    {
        return ([])a.clone();
    }

    static 
    {
        PENDING = new <init>("PENDING", 0);
        RUNNING = new <init>("RUNNING", 1);
        FINISHED = new <init>("FINISHED", 2);
        s_3B_.clone aclone[] = new <init>[3];
        aclone[0] = PENDING;
        aclone[1] = RUNNING;
        aclone[2] = FINISHED;
        a = aclone;
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
