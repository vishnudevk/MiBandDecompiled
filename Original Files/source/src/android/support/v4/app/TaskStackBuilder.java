// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package android.support.v4.app:
//            ah, ag, NavUtils, af

public class TaskStackBuilder
    implements Iterable
{

    private static final String a = "TaskStackBuilder";
    private static final af b;
    private final ArrayList c = new ArrayList();
    private final Context d;

    private TaskStackBuilder(Context context)
    {
        d = context;
    }

    public static TaskStackBuilder create(Context context)
    {
        return new TaskStackBuilder(context);
    }

    public static TaskStackBuilder from(Context context)
    {
        return create(context);
    }

    public TaskStackBuilder addNextIntent(Intent intent)
    {
        c.add(intent);
        return this;
    }

    public TaskStackBuilder addNextIntentWithParentStack(Intent intent)
    {
        ComponentName componentname = intent.getComponent();
        if (componentname == null)
        {
            componentname = intent.resolveActivity(d.getPackageManager());
        }
        if (componentname != null)
        {
            addParentStack(componentname);
        }
        addNextIntent(intent);
        return this;
    }

    public TaskStackBuilder addParentStack(Activity activity)
    {
        boolean flag = activity instanceof SupportParentable;
        Intent intent = null;
        if (flag)
        {
            intent = ((SupportParentable)activity).getSupportParentActivityIntent();
        }
        Intent intent1;
        if (intent == null)
        {
            intent1 = NavUtils.getParentActivityIntent(activity);
        } else
        {
            intent1 = intent;
        }
        if (intent1 != null)
        {
            ComponentName componentname = intent1.getComponent();
            if (componentname == null)
            {
                componentname = intent1.resolveActivity(d.getPackageManager());
            }
            addParentStack(componentname);
            addNextIntent(intent1);
        }
        return this;
    }

    public TaskStackBuilder addParentStack(ComponentName componentname)
    {
        int i = c.size();
        Intent intent;
        Intent intent1;
        try
        {
            intent = NavUtils.getParentActivityIntent(d, componentname);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(namenotfoundexception);
        }
        if (intent == null)
        {
            break; /* Loop/switch isn't completed */
        }
        c.add(i, intent);
        intent1 = NavUtils.getParentActivityIntent(d, intent.getComponent());
        intent = intent1;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_18;
_L1:
        return this;
    }

    public TaskStackBuilder addParentStack(Class class1)
    {
        return addParentStack(new ComponentName(d, class1));
    }

    public Intent editIntentAt(int i)
    {
        return (Intent)c.get(i);
    }

    public Intent getIntent(int i)
    {
        return editIntentAt(i);
    }

    public int getIntentCount()
    {
        return c.size();
    }

    public Intent[] getIntents()
    {
        Intent aintent[] = new Intent[c.size()];
        if (aintent.length == 0)
        {
            return aintent;
        }
        aintent[0] = (new Intent((Intent)c.get(0))).addFlags(0x1000c000);
        for (int i = 1; i < aintent.length; i++)
        {
            aintent[i] = new Intent((Intent)c.get(i));
        }

        return aintent;
    }

    public PendingIntent getPendingIntent(int i, int j)
    {
        return getPendingIntent(i, j, null);
    }

    public PendingIntent getPendingIntent(int i, int j, Bundle bundle)
    {
        if (c.isEmpty())
        {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
        } else
        {
            Intent aintent[] = (Intent[])c.toArray(new Intent[c.size()]);
            aintent[0] = (new Intent(aintent[0])).addFlags(0x1000c000);
            return b.a(d, aintent, i, j, bundle);
        }
    }

    public Iterator iterator()
    {
        return c.iterator();
    }

    public void startActivities()
    {
        startActivities(null);
    }

    public void startActivities(Bundle bundle)
    {
        if (c.isEmpty())
        {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent aintent[] = (Intent[])c.toArray(new Intent[c.size()]);
        aintent[0] = (new Intent(aintent[0])).addFlags(0x1000c000);
        if (!ContextCompat.startActivities(d, aintent, bundle))
        {
            Intent intent = new Intent(aintent[-1 + aintent.length]);
            intent.addFlags(0x10000000);
            d.startActivity(intent);
        }
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            b = new ah();
        } else
        {
            b = new ag();
        }
    }

    private class SupportParentable
    {

        public abstract Intent getSupportParentActivityIntent();
    }

}
