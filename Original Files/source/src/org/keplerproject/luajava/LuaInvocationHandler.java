// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.keplerproject.luajava;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// Referenced classes of package org.keplerproject.luajava:
//            LuaObject, LuaState

public class LuaInvocationHandler
    implements InvocationHandler
{

    private LuaObject obj;

    public LuaInvocationHandler(LuaObject luaobject)
    {
        obj = luaobject;
    }

    public Object invoke(Object obj1, Method method, Object aobj[])
    {
        Object obj2;
        LuaObject luaobject;
label0:
        {
            obj2 = null;
            synchronized (obj.L)
            {
                String s = method.getName();
                luaobject = obj.getField(s);
                if (!luaobject.isNil())
                {
                    break label0;
                }
            }
            return null;
        }
        Class class1 = method.getReturnType();
        if (!class1.equals(java/lang/Void) && !class1.equals(Void.TYPE)) goto _L2; else goto _L1
_L1:
        luaobject.call(aobj, 0);
_L4:
        luastate;
        JVM INSTR monitorexit ;
        return obj2;
        exception;
        luastate;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
        obj2 = luaobject.call(aobj, 1)[0];
        if (obj2 == null) goto _L4; else goto _L3
_L3:
        if (!(obj2 instanceof Double)) goto _L4; else goto _L5
_L5:
        Number number = LuaState.convertLuaNumber((Double)obj2, class1);
        obj2 = number;
          goto _L4
    }
}
