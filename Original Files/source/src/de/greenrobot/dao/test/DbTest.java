// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao.test;

import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;
import de.greenrobot.dao.DbUtils;
import java.util.Random;

public abstract class DbTest extends AndroidTestCase
{

    public static final String DB_NAME = "greendao-unittest-db.temp";
    private Application application;
    protected SQLiteDatabase db;
    protected final boolean inMemory;
    protected final Random random;

    public DbTest()
    {
        this(true);
    }

    public DbTest(boolean flag)
    {
        inMemory = flag;
        random = new Random();
    }

    public Application createApplication(Class class1)
    {
        assertNull("Application already created", application);
        Application application1;
        try
        {
            application1 = Instrumentation.newApplication(class1, getContext());
        }
        catch (Exception exception)
        {
            throw new RuntimeException((new StringBuilder()).append("Could not create application ").append(class1).toString(), exception);
        }
        application1.onCreate();
        application = application1;
        return application1;
    }

    protected SQLiteDatabase createDatabase()
    {
        if (inMemory)
        {
            return SQLiteDatabase.create(null);
        } else
        {
            getContext().deleteDatabase("greendao-unittest-db.temp");
            return getContext().openOrCreateDatabase("greendao-unittest-db.temp", 0, null);
        }
    }

    public Application getApplication()
    {
        assertNotNull("Application not yet created", application);
        return application;
    }

    protected void logTableDump(String s)
    {
        DbUtils.logTableDump(db, s);
    }

    protected void setUp()
    {
        super.setUp();
        db = createDatabase();
    }

    protected void tearDown()
    {
        if (application != null)
        {
            terminateApplication();
        }
        db.close();
        if (!inMemory)
        {
            getContext().deleteDatabase("greendao-unittest-db.temp");
        }
        super.tearDown();
    }

    public void terminateApplication()
    {
        assertNotNull("Application not yet created", application);
        application.onTerminate();
        application = null;
    }
}
