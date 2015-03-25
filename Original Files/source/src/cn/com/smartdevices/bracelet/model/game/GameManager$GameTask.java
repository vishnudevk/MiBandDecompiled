// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.model.game;

import android.os.AsyncTask;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.eventbus.EventGameUpdate;
import cn.com.smartdevices.bracelet.lua.ConfigDynamicDataInfo;
import de.greenrobot.event.EventBus;

// Referenced classes of package cn.com.smartdevices.bracelet.model.game:
//            GameManager, GameBriefInfo

class <init> extends AsyncTask
{

    final GameManager this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient String doInBackground(String as[])
    {
        GameBriefInfo gamebriefinfo = GameManager.access$100(GameManager.this);
        EventGameUpdate eventgameupdate = new EventGameUpdate();
        eventgameupdate.getConfigInfo().setType((new StringBuilder()).append("GAME_").append(gamebriefinfo.getId()).toString());
        eventgameupdate.getConfigInfo().setRight("onTop");
        Debug.i("GameManager", (new StringBuilder()).append("mark = ").append(as[0]).toString());
        if (gamebriefinfo.getLike() == 0 || as[0].equals("game_clear_banner"))
        {
            GameManager.access$200(GameManager.this, eventgameupdate);
            return null;
        }
        if (gamebriefinfo.isGameStart())
        {
            GameManager.access$300(GameManager.this);
            if (gamebriefinfo.isInRegisterStage())
            {
                if (GameManager.access$400(GameManager.this).isRegistered())
                {
                    eventgameupdate.getConfigInfo().setTitle("game_registered");
                    eventgameupdate.getConfigInfo().setUrl(GameManager.access$400(GameManager.this).getRegisterUrl());
                    eventgameupdate.getConfigInfo().setTimeStamp(GameManager.access$400(GameManager.this).getRegisterEndTimeStamp());
                    EventBus.getDefault().post(eventgameupdate);
                    return null;
                } else
                {
                    eventgameupdate.getConfigInfo().setTitle("game_not_registered");
                    eventgameupdate.getConfigInfo().setUrl(GameManager.access$400(GameManager.this).getRegisterUrl());
                    EventBus.getDefault().post(eventgameupdate);
                    return null;
                }
            }
            if (gamebriefinfo.isInGamingStage())
            {
                if (!GameManager.access$400(GameManager.this).isRegistered())
                {
                    GameManager.access$200(GameManager.this, eventgameupdate);
                    return null;
                } else
                {
                    GameManager.access$500(GameManager.this, eventgameupdate);
                    return null;
                }
            }
            if (gamebriefinfo.isInBonusStage())
            {
                if (!GameManager.access$400(GameManager.this).isRegistered())
                {
                    GameManager.access$200(GameManager.this, eventgameupdate);
                    return null;
                } else
                {
                    GameManager.access$600(GameManager.this, eventgameupdate);
                    return null;
                }
            } else
            {
                eventgameupdate.getConfigInfo().setTitle("game_default");
                eventgameupdate.getConfigInfo().setUrl(GameManager.access$400(GameManager.this).getDefaultUrl());
                EventBus.getDefault().post(eventgameupdate);
                return null;
            }
        } else
        {
            GameManager.access$200(GameManager.this, eventgameupdate);
            return null;
        }
    }

    private ()
    {
        this$0 = GameManager.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
