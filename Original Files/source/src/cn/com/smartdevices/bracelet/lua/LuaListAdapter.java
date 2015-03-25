// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.lua;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.DaoManager;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.query.QueryBuilder;
import de.greenrobot.dao.query.WhereCondition;
import de.greenrobot.daobracelet.LuaList;
import de.greenrobot.daobracelet.LuaListDao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package cn.com.smartdevices.bracelet.lua:
//            c, d, b

public class LuaListAdapter extends BaseAdapter
{

    private static Boolean isFirstTimeBoolean = Boolean.valueOf(true);
    private final String TYPE_UNBIND = "1005";
    private Animation animB2T;
    private Animation animT2B;
    private List infoList;
    private Context mContext;
    private final String nationalDay2014Type = "1005";
    private int newItemCount;
    private TranslateAnimation taBlow;
    private TranslateAnimation taLeft;
    private TranslateAnimation taRight;
    private TranslateAnimation taTop;

    public LuaListAdapter(Context context, List list)
    {
        mContext = null;
        infoList = null;
        newItemCount = 0;
        mContext = context;
        isFirstTimeBoolean = Boolean.valueOf(true);
        getNewList(list);
        InitAnim();
    }

    private void InitAnim()
    {
        taLeft = new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
        taRight = new TranslateAnimation(2, -1F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
        taTop = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, 1.0F, 2, 0.0F);
        taBlow = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, -1F, 2, 0.0F);
        taLeft.setDuration(1000L);
        taRight.setDuration(1000L);
        taTop.setDuration(1000L);
        taBlow.setDuration(1000L);
        animB2T = AnimationUtils.loadAnimation(mContext, 0x7f040006);
        animT2B = AnimationUtils.loadAnimation(mContext, 0x7f040007);
    }

    private String getDate()
    {
        return (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
    }

    private void getNewList(List list)
    {
        newItemCount = 0;
        if (list == null || list.size() == 0)
        {
            infoList = null;
            return;
        }
        ArrayList arraylist = new ArrayList();
        if (infoList == null || infoList.size() == 0)
        {
            for (int i = 0; i < list.size(); i++)
            {
                c c1 = new c(this);
                c1.a = (LuaList)list.get(i);
                c1.b = Boolean.valueOf(false);
                arraylist.add(c1);
            }

            newItemCount = arraylist.size();
        } else
        {
            int j = 0;
            while (j < list.size()) 
            {
                c c2 = new c(this);
                c2.a = (LuaList)list.get(j);
                if (judgeIsNew(c2.a).booleanValue())
                {
                    newItemCount = 1 + newItemCount;
                    c2.b = Boolean.valueOf(true);
                } else
                {
                    c2.b = Boolean.valueOf(false);
                }
                arraylist.add(c2);
                j++;
            }
        }
        infoList = arraylist;
    }

    private Boolean judgeIsNew(LuaList lualist)
    {
        for (int i = 0; i < infoList.size(); i++)
        {
            LuaList lualist1 = ((c)infoList.get(i)).a;
            Boolean boolean1 = ((c)infoList.get(i)).b;
            if (lualist.getId() == lualist1.getId())
            {
                if (boolean1.booleanValue())
                {
                    return Boolean.valueOf(true);
                } else
                {
                    return Boolean.valueOf(false);
                }
            }
        }

        return Boolean.valueOf(true);
    }

    public int getCount()
    {
        if (infoList != null)
        {
            return infoList.size();
        } else
        {
            return 0;
        }
    }

    public Object getItem(int i)
    {
        return Integer.valueOf(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public int getListSize()
    {
        if (infoList == null)
        {
            return 0;
        } else
        {
            return infoList.size();
        }
    }

    public int getNewItemCount()
    {
        if (isFirstTimeBoolean.booleanValue())
        {
            isFirstTimeBoolean = Boolean.valueOf(false);
            return 0;
        } else
        {
            return newItemCount;
        }
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        c c1;
        LuaList lualist;
        d d1;
        View view1;
        c1 = (c)infoList.get(i);
        lualist = c1.a;
        d1 = new d(this);
        view1 = LayoutInflater.from(mContext).inflate(0x7f030050, null);
        d1.a = (TextView)view1.findViewById(0x7f0a0165);
        d1.a.setTypeface(Typeface.DEFAULT, 1);
        d1.b = (TextView)view1.findViewById(0x7f0a0166);
        d1.c = (ImageView)view1.findViewById(0x7f0a0162);
        d1.c.setVisibility(8);
        if (!lualist.getType().equals("1005")) goto _L2; else goto _L1
_L1:
        d1.a.setTextColor(mContext.getResources().getColor(0x7f090000));
        d1.b.setVisibility(8);
_L4:
        view1.setOnClickListener(new b(this));
        d1.a.setText(lualist.getText1());
        String s1 = lualist.getText2();
        String s;
        int j;
        NullPointerException nullpointerexception;
        JSONException jsonexception;
        int k;
        if (s1 == null || s1.length() == 0)
        {
            d1.b.setVisibility(8);
        } else
        {
            d1.b.setVisibility(0);
            d1.b.setText(s1);
        }
        view1.setTag(d1);
        d1.a.setTag(lualist);
        if (c1.b.booleanValue())
        {
            view1.startAnimation(animT2B);
        }
        c1.b = Boolean.valueOf(false);
        return view1;
_L2:
        if (!lualist.getType().startsWith("GAME_")) goto _L4; else goto _L3
_L3:
        s = lualist.getJsonString();
        j = mContext.getResources().getColor(0x7f090021);
        k = (new JSONObject(s)).optInt("txtColor");
        j = k;
_L5:
        d1.a.setTextColor(0xcc000000 | j);
        d1.b.setTextColor(0x88000000 | j & 0xffffff);
        d1.c.setVisibility(0);
        ((android.widget.RelativeLayout.LayoutParams)((LinearLayout)view1.findViewById(0x7f0a0163)).getLayoutParams()).leftMargin = 0;
          goto _L4
        jsonexception;
        jsonexception.printStackTrace();
          goto _L5
        nullpointerexception;
        nullpointerexception.printStackTrace();
          goto _L5
    }

    public void refreshList()
    {
        LuaListDao lualistdao = DaoManager.getInstance().getLuaListDao();
        String s = getDate();
        QueryBuilder querybuilder = lualistdao.queryBuilder().where(de.greenrobot.daobracelet.LuaListDao.Properties.Date.eq(s), new WhereCondition[0]).where(de.greenrobot.daobracelet.LuaListDao.Properties.Type.notEq("8888"), new WhereCondition[0]).where(de.greenrobot.daobracelet.LuaListDao.Properties.Type.notEq("9999"), new WhereCondition[0]);
        Property aproperty[] = new Property[1];
        aproperty[0] = de.greenrobot.daobracelet.LuaListDao.Properties.Id;
        List list = querybuilder.orderDesc(aproperty).list();
        Collections.sort(list, new MyComparator());
        setList(list);
    }

    public void setFlagsToFalse()
    {
        for (int i = 0; i < infoList.size(); i++)
        {
            ((c)infoList.get(i)).b = Boolean.valueOf(false);
        }

    }

    public void setList(List list)
    {
        if (list != null)
        {
            getNewList(list);
            notifyDataSetChanged();
        }
    }



    private class MyComparator
        implements Comparator
    {

        final LuaListAdapter this$0;

        public int compare(LuaList lualist, LuaList lualist1)
        {
            byte byte0 = -1;
            String s = lualist1.getRight();
            String s1 = lualist.getRight();
            if (s == null && s1 == null)
            {
                byte0 = 0;
            } else
            if (s != null || s1 == null)
            {
                if (s != null && s1 == null)
                {
                    return 1;
                }
                if (s.length() > s1.length())
                {
                    return 1;
                }
                if (s.length() >= s1.length())
                {
                    return s.compareTo(s1);
                }
            }
            return byte0;
        }

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((LuaList)obj, (LuaList)obj1);
        }

        public MyComparator()
        {
            this$0 = LuaListAdapter.this;
            super();
        }
    }

}
