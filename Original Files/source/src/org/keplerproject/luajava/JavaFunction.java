// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.keplerproject.luajava;


// Referenced classes of package org.keplerproject.luajava:
//            LuaState, LuaObject

public abstract class JavaFunction
{

    protected LuaState L;

    public JavaFunction(LuaState luastate)
    {
        L = luastate;
    }

    public abstract int execute();

    public LuaObject getParam(int i)
    {
        return L.getLuaObject(i);
    }

    public void register(String s)
    {
        synchronized (L)
        {
            L.pushJavaFunction(this);
            L.setGlobal(s);
        }
        return;
        exception;
        luastate;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
