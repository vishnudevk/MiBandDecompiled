// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.keplerproject.luajava;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package org.keplerproject.luajava:
//            LuaState

public final class LuaStateFactory
{

    private static final List states = new ArrayList();

    private LuaStateFactory()
    {
    }

    public static LuaState getExistingState(int i)
    {
        org/keplerproject/luajava/LuaStateFactory;
        JVM INSTR monitorenter ;
        LuaState luastate = (LuaState)states.get(i);
        org/keplerproject/luajava/LuaStateFactory;
        JVM INSTR monitorexit ;
        return luastate;
        Exception exception;
        exception;
        throw exception;
    }

    private static int getNextStateIndex()
    {
        org/keplerproject/luajava/LuaStateFactory;
        JVM INSTR monitorenter ;
        int i = 0;
_L2:
        Object obj;
        if (i >= states.size())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = states.get(i);
        if (obj == null)
        {
            break; /* Loop/switch isn't completed */
        }
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public static int insertLuaState(LuaState luastate)
    {
        org/keplerproject/luajava/LuaStateFactory;
        JVM INSTR monitorenter ;
        int i = 0;
_L9:
        if (i >= states.size()) goto _L2; else goto _L1
_L1:
        LuaState luastate1 = (LuaState)states.get(i);
        if (luastate1 == null) goto _L4; else goto _L3
_L3:
        long l;
        long l1;
        l = luastate1.getCPtrPeer();
        l1 = luastate.getCPtrPeer();
        if (l != l1) goto _L4; else goto _L5
_L5:
        int j = i;
_L7:
        org/keplerproject/luajava/LuaStateFactory;
        JVM INSTR monitorexit ;
        return j;
_L4:
        i++;
        continue; /* Loop/switch isn't completed */
_L2:
        j = getNextStateIndex();
        states.set(j, luastate);
        if (true) goto _L7; else goto _L6
_L6:
        Exception exception;
        exception;
        throw exception;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public static LuaState newLuaState()
    {
        org/keplerproject/luajava/LuaStateFactory;
        JVM INSTR monitorenter ;
        LuaState luastate;
        int i = getNextStateIndex();
        luastate = new LuaState(i);
        states.add(i, luastate);
        org/keplerproject/luajava/LuaStateFactory;
        JVM INSTR monitorexit ;
        return luastate;
        Exception exception;
        exception;
        throw exception;
    }

    public static void removeLuaState(int i)
    {
        org/keplerproject/luajava/LuaStateFactory;
        JVM INSTR monitorenter ;
        states.add(i, null);
        org/keplerproject/luajava/LuaStateFactory;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

}
