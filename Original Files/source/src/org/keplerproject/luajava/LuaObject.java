// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.keplerproject.luajava;

import java.io.PrintStream;
import java.lang.reflect.Proxy;
import java.util.StringTokenizer;

// Referenced classes of package org.keplerproject.luajava:
//            LuaException, LuaState, LuaInvocationHandler

public class LuaObject
{

    protected LuaState L;
    protected Integer ref;

    protected LuaObject(LuaObject luaobject, Number number)
    {
        LuaState luastate = luaobject.getLuaState();
        luastate;
        JVM INSTR monitorenter ;
        L = luaobject.getLuaState();
        if (!luaobject.isTable() && !luaobject.isUserdata())
        {
            throw new LuaException("Object parent should be a table or userdata .");
        }
        break MISSING_BLOCK_LABEL_50;
        Exception exception;
        exception;
        luastate;
        JVM INSTR monitorexit ;
        throw exception;
        luaobject.push();
        L.pushNumber(number.doubleValue());
        L.getTable(-2);
        L.remove(-2);
        registerValue(-1);
        L.pop(1);
        luastate;
        JVM INSTR monitorexit ;
    }

    protected LuaObject(LuaObject luaobject, String s)
    {
        LuaState luastate = luaobject.getLuaState();
        luastate;
        JVM INSTR monitorenter ;
        L = luaobject.getLuaState();
        if (!luaobject.isTable() && !luaobject.isUserdata())
        {
            throw new LuaException("Object parent should be a table or userdata .");
        }
        break MISSING_BLOCK_LABEL_50;
        Exception exception;
        exception;
        luastate;
        JVM INSTR monitorexit ;
        throw exception;
        luaobject.push();
        L.pushString(s);
        L.getTable(-2);
        L.remove(-2);
        registerValue(-1);
        L.pop(1);
        luastate;
        JVM INSTR monitorexit ;
    }

    protected LuaObject(LuaObject luaobject, LuaObject luaobject1)
    {
        if (luaobject.getLuaState() != luaobject1.getLuaState())
        {
            throw new LuaException("LuaStates must be the same!");
        }
        LuaState luastate = luaobject.getLuaState();
        luastate;
        JVM INSTR monitorenter ;
        if (!luaobject.isTable() && !luaobject.isUserdata())
        {
            throw new LuaException("Object parent should be a table or userdata .");
        }
        break MISSING_BLOCK_LABEL_63;
        Exception exception;
        exception;
        luastate;
        JVM INSTR monitorexit ;
        throw exception;
        L = luaobject.getLuaState();
        luaobject.push();
        luaobject1.push();
        L.getTable(-2);
        L.remove(-2);
        registerValue(-1);
        L.pop(1);
        luastate;
        JVM INSTR monitorexit ;
    }

    protected LuaObject(LuaState luastate, int i)
    {
        luastate;
        JVM INSTR monitorenter ;
        L = luastate;
        registerValue(i);
        luastate;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        luastate;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected LuaObject(LuaState luastate, String s)
    {
        luastate;
        JVM INSTR monitorenter ;
        L = luastate;
        luastate.getGlobal(s);
        registerValue(-1);
        luastate.pop(1);
        luastate;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        luastate;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void registerValue(int i)
    {
        synchronized (L)
        {
            L.pushValue(i);
            ref = new Integer(L.Lref(LuaState.LUA_REGISTRYINDEX.intValue()));
        }
        return;
        exception;
        luastate;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Object call(Object aobj[])
    {
        return call(aobj, 1)[0];
    }

    public Object[] call(Object aobj[], int i)
    {
        int j = 0;
        LuaState luastate = L;
        luastate;
        JVM INSTR monitorenter ;
        if (!isFunction() && !isTable() && !isUserdata())
        {
            throw new LuaException("Invalid object. Not a function, table or userdata .");
        }
        break MISSING_BLOCK_LABEL_50;
        Exception exception;
        exception;
        luastate;
        JVM INSTR monitorexit ;
        throw exception;
        int k;
        k = L.getTop();
        push();
        if (aobj == null) goto _L2; else goto _L1
_L1:
        int l = aobj.length;
_L4:
        if (j >= l)
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj = aobj[j];
        L.pushObjectValue(obj);
        j++;
        if (true) goto _L4; else goto _L3
_L3:
        int i1 = L.pcall(l, i, 0);
        if (i1 == 0) goto _L6; else goto _L5
_L5:
        String s;
        if (!L.isString(-1))
        {
            break MISSING_BLOCK_LABEL_400;
        }
        s = L.toString(-1);
        L.pop(1);
_L15:
        if (i1 != LuaState.LUA_ERRRUN.intValue()) goto _L8; else goto _L7
_L7:
        String s1 = (new StringBuilder()).append("Runtime error. ").append(s).toString();
_L11:
        throw new LuaException(s1);
_L8:
        if (i1 != LuaState.LUA_ERRMEM.intValue()) goto _L10; else goto _L9
_L9:
        s1 = (new StringBuilder()).append("Memory allocation error. ").append(s).toString();
          goto _L11
_L10:
label0:
        {
            if (i1 != LuaState.LUA_ERRERR.intValue())
            {
                break label0;
            }
            s1 = (new StringBuilder()).append("Error while running the error handler function. ").append(s).toString();
        }
          goto _L11
        s1 = (new StringBuilder()).append("Lua Error code ").append(i1).append(". ").append(s).toString();
          goto _L11
_L6:
        int j1;
        if (i != LuaState.LUA_MULTRET.intValue())
        {
            break MISSING_BLOCK_LABEL_388;
        }
        j1 = L.getTop() - k;
_L14:
        Object aobj1[];
        if (L.getTop() - k < j1)
        {
            throw new LuaException("Invalid Number of Results .");
        }
        aobj1 = new Object[j1];
_L13:
        if (j1 <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        aobj1[j1 - 1] = L.toJavaObject(-1);
        L.pop(1);
        j1--;
        if (true) goto _L13; else goto _L12
_L12:
        luastate;
        JVM INSTR monitorexit ;
        return aobj1;
        j1 = i;
          goto _L14
_L2:
        l = 0;
          goto _L3
        s = "";
          goto _L15
    }

    public Object createProxy(String s)
    {
        LuaState luastate = L;
        luastate;
        JVM INSTR monitorenter ;
        if (!isTable())
        {
            throw new LuaException("Invalid Object. Must be Table.");
        }
        break MISSING_BLOCK_LABEL_29;
        Exception exception;
        exception;
        luastate;
        JVM INSTR monitorexit ;
        throw exception;
        StringTokenizer stringtokenizer;
        Class aclass[];
        stringtokenizer = new StringTokenizer(s, ",");
        aclass = new Class[stringtokenizer.countTokens()];
        int i = 0;
_L2:
        if (!stringtokenizer.hasMoreTokens())
        {
            break; /* Loop/switch isn't completed */
        }
        aclass[i] = Class.forName(stringtokenizer.nextToken());
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        Object obj;
        LuaInvocationHandler luainvocationhandler = new LuaInvocationHandler(this);
        obj = Proxy.newProxyInstance(getClass().getClassLoader(), aclass, luainvocationhandler);
        luastate;
        JVM INSTR monitorexit ;
        return obj;
    }

    protected void finalize()
    {
        synchronized (L)
        {
            if (L.getCPtrPeer() != 0L)
            {
                L.LunRef(LuaState.LUA_REGISTRYINDEX.intValue(), ref.intValue());
            }
        }
        return;
        exception1;
        luastate;
        JVM INSTR monitorexit ;
        try
        {
            throw exception1;
        }
        catch (Exception exception)
        {
            System.err.println((new StringBuilder()).append("Unable to release object ").append(ref).toString());
        }
        return;
    }

    public boolean getBoolean()
    {
        boolean flag;
        synchronized (L)
        {
            push();
            flag = L.toBoolean(-1);
            L.pop(1);
        }
        return flag;
        exception;
        luastate;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public LuaObject getField(String s)
    {
        return L.getLuaObject(this, s);
    }

    public LuaState getLuaState()
    {
        return L;
    }

    public double getNumber()
    {
        double d;
        synchronized (L)
        {
            push();
            d = L.toNumber(-1);
            L.pop(1);
        }
        return d;
        exception;
        luastate;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Object getObject()
    {
        Object obj;
        synchronized (L)
        {
            push();
            obj = L.getObjectFromUserdata(-1);
            L.pop(1);
        }
        return obj;
        exception;
        luastate;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public String getString()
    {
        String s;
        synchronized (L)
        {
            push();
            s = L.toString(-1);
            L.pop(1);
        }
        return s;
        exception;
        luastate;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isBoolean()
    {
        boolean flag;
        synchronized (L)
        {
            push();
            flag = L.isBoolean(-1);
            L.pop(1);
        }
        return flag;
        exception;
        luastate;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isFunction()
    {
        boolean flag;
        synchronized (L)
        {
            push();
            flag = L.isFunction(-1);
            L.pop(1);
        }
        return flag;
        exception;
        luastate;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isJavaFunction()
    {
        boolean flag;
        synchronized (L)
        {
            push();
            flag = L.isJavaFunction(-1);
            L.pop(1);
        }
        return flag;
        exception;
        luastate;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isJavaObject()
    {
        boolean flag;
        synchronized (L)
        {
            push();
            flag = L.isObject(-1);
            L.pop(1);
        }
        return flag;
        exception;
        luastate;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isNil()
    {
        boolean flag;
        synchronized (L)
        {
            push();
            flag = L.isNil(-1);
            L.pop(1);
        }
        return flag;
        exception;
        luastate;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isNumber()
    {
        boolean flag;
        synchronized (L)
        {
            push();
            flag = L.isNumber(-1);
            L.pop(1);
        }
        return flag;
        exception;
        luastate;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isString()
    {
        boolean flag;
        synchronized (L)
        {
            push();
            flag = L.isString(-1);
            L.pop(1);
        }
        return flag;
        exception;
        luastate;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isTable()
    {
        boolean flag;
        synchronized (L)
        {
            push();
            flag = L.isTable(-1);
            L.pop(1);
        }
        return flag;
        exception;
        luastate;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isUserdata()
    {
        boolean flag;
        synchronized (L)
        {
            push();
            flag = L.isUserdata(-1);
            L.pop(1);
        }
        return flag;
        exception;
        luastate;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void push()
    {
        L.rawGetI(LuaState.LUA_REGISTRYINDEX.intValue(), ref.intValue());
    }

    public String toString()
    {
        luastate;
        JVM INSTR monitorenter ;
label0:
        {
            synchronized (L)
            {
                if (!isNil())
                {
                    break label0;
                }
            }
            return "nil";
        }
        String s3;
        if (!isBoolean())
        {
            break MISSING_BLOCK_LABEL_46;
        }
        s3 = String.valueOf(getBoolean());
        luastate;
        JVM INSTR monitorexit ;
        return s3;
        exception;
        luastate;
        JVM INSTR monitorexit ;
        throw exception;
        String s2;
        if (!isNumber())
        {
            break MISSING_BLOCK_LABEL_67;
        }
        s2 = String.valueOf(getNumber());
        luastate;
        JVM INSTR monitorexit ;
        return s2;
        String s1;
        if (!isString())
        {
            break MISSING_BLOCK_LABEL_85;
        }
        s1 = getString();
        luastate;
        JVM INSTR monitorexit ;
        return s1;
        if (!isFunction())
        {
            break MISSING_BLOCK_LABEL_98;
        }
        luastate;
        JVM INSTR monitorexit ;
        return "Lua Function";
        String s;
        if (!isJavaObject())
        {
            break MISSING_BLOCK_LABEL_119;
        }
        s = getObject().toString();
        luastate;
        JVM INSTR monitorexit ;
        return s;
        if (!isUserdata())
        {
            break MISSING_BLOCK_LABEL_132;
        }
        luastate;
        JVM INSTR monitorexit ;
        return "Userdata";
        if (!isTable())
        {
            break MISSING_BLOCK_LABEL_145;
        }
        luastate;
        JVM INSTR monitorexit ;
        return "Lua Table";
        if (isJavaFunction())
        {
            return "Java Function";
        }
        luastate;
        JVM INSTR monitorexit ;
        return null;
        LuaException luaexception;
        luaexception;
        luastate;
        JVM INSTR monitorexit ;
        return null;
    }

    public int type()
    {
        int i;
        synchronized (L)
        {
            push();
            i = L.type(-1);
            L.pop(1);
        }
        return i;
        exception;
        luastate;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
