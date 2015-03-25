// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao.test;

import java.util.Random;

// Referenced classes of package de.greenrobot.dao.test:
//            AbstractDaoTestSinglePk

public abstract class AbstractDaoTestStringPk extends AbstractDaoTestSinglePk
{

    public AbstractDaoTestStringPk(Class class1)
    {
        super(class1);
    }

    protected volatile Object createRandomPk()
    {
        return createRandomPk();
    }

    protected String createRandomPk()
    {
        int i = 1 + random.nextInt(30);
        StringBuilder stringbuilder = new StringBuilder();
        for (int j = 0; j < i; j++)
        {
            stringbuilder.append((char)(97 + random.nextInt(25)));
        }

        return stringbuilder.toString();
    }
}
