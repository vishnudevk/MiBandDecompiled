// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kankan.wheel.widget.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

// Referenced classes of package kankan.wheel.widget.adapters:
//            AbstractWheelAdapter

public abstract class AbstractWheelTextAdapter extends AbstractWheelAdapter
{

    public static final int DEFAULT_TEXT_COLOR = 0xff101010;
    public static final int DEFAULT_TEXT_SIZE = 20;
    public static final int LABEL_COLOR = 0xff700070;
    protected static final int NO_RESOURCE = 0;
    public static final int TEXT_VIEW_ITEM_RESOURCE = -1;
    private int a;
    private int b;
    protected Context context;
    protected int emptyItemResourceId;
    protected LayoutInflater inflater;
    protected int itemResourceId;
    protected int itemTextResourceId;

    protected AbstractWheelTextAdapter(Context context1)
    {
        this(context1, -1);
    }

    protected AbstractWheelTextAdapter(Context context1, int i)
    {
        this(context1, i, 0);
    }

    protected AbstractWheelTextAdapter(Context context1, int i, int j)
    {
        a = 0xff101010;
        b = 20;
        context = context1;
        itemResourceId = i;
        itemTextResourceId = j;
        inflater = (LayoutInflater)context1.getSystemService("layout_inflater");
    }

    private View a(int i, ViewGroup viewgroup)
    {
        switch (i)
        {
        default:
            return inflater.inflate(i, viewgroup, false);

        case 0: // '\0'
            return null;

        case -1: 
            return new TextView(context);
        }
    }

    private TextView a(View view, int i)
    {
        TextView textview;
        if (i == 0)
        {
            try
            {
                if (view instanceof TextView)
                {
                    return (TextView)view;
                }
            }
            catch (ClassCastException classcastexception)
            {
                Log.e("AbstractWheelAdapter", "You must supply a resource ID for a TextView");
                throw new IllegalStateException("AbstractWheelAdapter requires the resource ID to be a TextView", classcastexception);
            }
        }
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        textview = (TextView)view.findViewById(i);
        return textview;
        return null;
    }

    protected void configureTextView(TextView textview)
    {
        textview.setGravity(17);
        textview.setTextSize(b);
        textview.setLines(1);
        textview.setTypeface(Typeface.SANS_SERIF, 0);
        textview.setPadding(0, 10, 0, 10);
    }

    public View getEmptyItem(View view, ViewGroup viewgroup)
    {
        View view1;
        if (view == null)
        {
            view1 = a(emptyItemResourceId, viewgroup);
        } else
        {
            view1 = view;
        }
        if (emptyItemResourceId == -1 && (view1 instanceof TextView))
        {
            configureTextView((TextView)view1);
        }
        return view1;
    }

    public int getEmptyItemResource()
    {
        return emptyItemResourceId;
    }

    public View getItem(int i, View view, ViewGroup viewgroup)
    {
        if (i >= 0 && i < getItemsCount())
        {
            if (view == null)
            {
                view = a(itemResourceId, viewgroup);
            }
            TextView textview = a(view, itemTextResourceId);
            if (textview != null)
            {
                Object obj = getItemText(i);
                if (obj == null)
                {
                    obj = "";
                }
                textview.setText(((CharSequence) (obj)));
                if (itemResourceId == -1)
                {
                    configureTextView(textview);
                }
            }
            return view;
        } else
        {
            return null;
        }
    }

    public int getItemResource()
    {
        return itemResourceId;
    }

    protected abstract CharSequence getItemText(int i);

    public int getItemTextResource()
    {
        return itemTextResourceId;
    }

    public int getTextColor()
    {
        return a;
    }

    public int getTextSize()
    {
        return b;
    }

    public void setEmptyItemResource(int i)
    {
        emptyItemResourceId = i;
    }

    public void setItemResource(int i)
    {
        itemResourceId = i;
    }

    public void setItemTextResource(int i)
    {
        itemTextResourceId = i;
    }

    public void setTextColor(int i)
    {
        a = i;
    }

    public void setTextSize(int i)
    {
        b = i;
    }
}
