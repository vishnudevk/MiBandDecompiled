// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.keplerproject.luajava;


// Referenced classes of package org.keplerproject.luajava:
//            LuaStateFactory, CPtr, LuaObject, LuaException, 
//            JavaFunction

public class LuaState
{

    private static final String LUAJAVA_LIB = "luajava";
    public static final Integer LUA_ERRERR = new Integer(5);
    public static final Integer LUA_ERRMEM = new Integer(4);
    public static final Integer LUA_ERRRUN = new Integer(1);
    public static final Integer LUA_ERRSYNTAX = new Integer(3);
    public static final Integer LUA_GCCOLLECT = new Integer(2);
    public static final Integer LUA_GCCOUNT = new Integer(3);
    public static final Integer LUA_GCCOUNTB = new Integer(4);
    public static final Integer LUA_GCRESTART = new Integer(1);
    public static final Integer LUA_GCSETPAUSE = new Integer(6);
    public static final Integer LUA_GCSETSTEPMUL = new Integer(7);
    public static final Integer LUA_GCSTEP = new Integer(5);
    public static final Integer LUA_GCSTOP = new Integer(0);
    public static final Integer LUA_GLOBALSINDEX = new Integer(-10002);
    public static final Integer LUA_MULTRET = new Integer(-1);
    public static final Integer LUA_REGISTRYINDEX = new Integer(-10000);
    public static final Integer LUA_TBOOLEAN = new Integer(1);
    public static final Integer LUA_TFUNCTION = new Integer(6);
    public static final Integer LUA_TLIGHTUSERDATA = new Integer(2);
    public static final Integer LUA_TNIL = new Integer(0);
    public static final Integer LUA_TNONE = new Integer(-1);
    public static final Integer LUA_TNUMBER = new Integer(3);
    public static final Integer LUA_TSTRING = new Integer(4);
    public static final Integer LUA_TTABLE = new Integer(5);
    public static final Integer LUA_TTHREAD = new Integer(8);
    public static final Integer LUA_TUSERDATA = new Integer(7);
    public static final Integer LUA_YIELD = new Integer(2);
    private CPtr luaState;
    private int stateId;

    protected LuaState(int i)
    {
        luaState = _open();
        luajava_open(luaState, i);
        stateId = i;
    }

    protected LuaState(CPtr cptr)
    {
        luaState = cptr;
        stateId = LuaStateFactory.insertLuaState(this);
        luajava_open(cptr, stateId);
    }

    private synchronized native int _LargError(CPtr cptr, int i, String s);

    private synchronized native int _LcallMeta(CPtr cptr, int i, String s);

    private synchronized native void _LcheckAny(CPtr cptr, int i);

    private synchronized native int _LcheckInteger(CPtr cptr, int i);

    private synchronized native double _LcheckNumber(CPtr cptr, int i);

    private synchronized native void _LcheckStack(CPtr cptr, int i, String s);

    private synchronized native String _LcheckString(CPtr cptr, int i);

    private synchronized native void _LcheckType(CPtr cptr, int i, int j);

    private synchronized native int _LdoFile(CPtr cptr, String s);

    private synchronized native int _LdoString(CPtr cptr, String s);

    private synchronized native String _LfindTable(CPtr cptr, int i, String s, int j);

    private synchronized native int _LgetMetaField(CPtr cptr, int i, String s);

    private synchronized native void _LgetMetatable(CPtr cptr, String s);

    private synchronized native int _LgetN(CPtr cptr, int i);

    private synchronized native String _Lgsub(CPtr cptr, String s, String s1, String s2);

    private synchronized native int _LloadBuffer(CPtr cptr, byte abyte0[], long l, String s);

    private synchronized native int _LloadFile(CPtr cptr, String s);

    private synchronized native int _LloadString(CPtr cptr, String s);

    private synchronized native int _LnewMetatable(CPtr cptr, String s);

    private synchronized native int _LoptInteger(CPtr cptr, int i, int j);

    private synchronized native double _LoptNumber(CPtr cptr, int i, double d);

    private synchronized native String _LoptString(CPtr cptr, int i, String s);

    private synchronized native int _Lref(CPtr cptr, int i);

    private synchronized native void _LsetN(CPtr cptr, int i, int j);

    private synchronized native int _Ltyperror(CPtr cptr, int i, String s);

    private synchronized native void _LunRef(CPtr cptr, int i, int j);

    private synchronized native void _Lwhere(CPtr cptr, int i);

    private synchronized native void _call(CPtr cptr, int i, int j);

    private synchronized native int _checkStack(CPtr cptr, int i);

    private synchronized native void _close(CPtr cptr);

    private synchronized native void _concat(CPtr cptr, int i);

    private synchronized native void _createTable(CPtr cptr, int i, int j);

    private synchronized native int _equal(CPtr cptr, int i, int j);

    private synchronized native int _error(CPtr cptr);

    private synchronized native int _gc(CPtr cptr, int i, int j);

    private synchronized native void _getFEnv(CPtr cptr, int i);

    private synchronized native void _getField(CPtr cptr, int i, String s);

    private synchronized native int _getGcCount(CPtr cptr);

    private synchronized native void _getGlobal(CPtr cptr, String s);

    private synchronized native int _getMetaTable(CPtr cptr, int i);

    private synchronized native Object _getObjectFromUserdata(CPtr cptr, int i);

    private synchronized native void _getTable(CPtr cptr, int i);

    private synchronized native int _getTop(CPtr cptr);

    private synchronized native void _insert(CPtr cptr, int i);

    private synchronized native int _isBoolean(CPtr cptr, int i);

    private synchronized native int _isCFunction(CPtr cptr, int i);

    private synchronized native int _isFunction(CPtr cptr, int i);

    private synchronized native boolean _isJavaFunction(CPtr cptr, int i);

    private synchronized native int _isNil(CPtr cptr, int i);

    private synchronized native int _isNone(CPtr cptr, int i);

    private synchronized native int _isNoneOrNil(CPtr cptr, int i);

    private synchronized native int _isNumber(CPtr cptr, int i);

    private synchronized native boolean _isObject(CPtr cptr, int i);

    private synchronized native int _isString(CPtr cptr, int i);

    private synchronized native int _isTable(CPtr cptr, int i);

    private synchronized native int _isThread(CPtr cptr, int i);

    private synchronized native int _isUserdata(CPtr cptr, int i);

    private synchronized native int _lessthan(CPtr cptr, int i, int j);

    private synchronized native void _newTable(CPtr cptr);

    private synchronized native CPtr _newthread(CPtr cptr);

    private synchronized native int _next(CPtr cptr, int i);

    private synchronized native int _objlen(CPtr cptr, int i);

    private synchronized native CPtr _open();

    private synchronized native void _openBase(CPtr cptr);

    private synchronized native void _openDebug(CPtr cptr);

    private synchronized native void _openIo(CPtr cptr);

    private synchronized native void _openLibs(CPtr cptr);

    private synchronized native void _openMath(CPtr cptr);

    private synchronized native void _openOs(CPtr cptr);

    private synchronized native void _openPackage(CPtr cptr);

    private synchronized native void _openString(CPtr cptr);

    private synchronized native void _openTable(CPtr cptr);

    private synchronized native int _pcall(CPtr cptr, int i, int j, int k);

    private synchronized native void _pop(CPtr cptr, int i);

    private synchronized native void _pushBoolean(CPtr cptr, int i);

    private synchronized native void _pushInteger(CPtr cptr, int i);

    private synchronized native void _pushJavaFunction(CPtr cptr, JavaFunction javafunction);

    private synchronized native void _pushJavaObject(CPtr cptr, Object obj);

    private synchronized native void _pushNil(CPtr cptr);

    private synchronized native void _pushNumber(CPtr cptr, double d);

    private synchronized native void _pushString(CPtr cptr, String s);

    private synchronized native void _pushString(CPtr cptr, byte abyte0[], int i);

    private synchronized native void _pushValue(CPtr cptr, int i);

    private synchronized native void _rawGet(CPtr cptr, int i);

    private synchronized native void _rawGetI(CPtr cptr, int i, int j);

    private synchronized native void _rawSet(CPtr cptr, int i);

    private synchronized native void _rawSetI(CPtr cptr, int i, int j);

    private synchronized native int _rawequal(CPtr cptr, int i, int j);

    private synchronized native void _remove(CPtr cptr, int i);

    private synchronized native void _replace(CPtr cptr, int i);

    private synchronized native int _resume(CPtr cptr, int i);

    private synchronized native int _setFEnv(CPtr cptr, int i);

    private synchronized native void _setField(CPtr cptr, int i, String s);

    private synchronized native void _setGlobal(CPtr cptr, String s);

    private synchronized native int _setMetaTable(CPtr cptr, int i);

    private synchronized native void _setTable(CPtr cptr, int i);

    private synchronized native void _setTop(CPtr cptr, int i);

    private synchronized native int _status(CPtr cptr);

    private synchronized native int _strlen(CPtr cptr, int i);

    private synchronized native int _toBoolean(CPtr cptr, int i);

    private synchronized native int _toInteger(CPtr cptr, int i);

    private synchronized native double _toNumber(CPtr cptr, int i);

    private synchronized native String _toString(CPtr cptr, int i);

    private synchronized native CPtr _toThread(CPtr cptr, int i);

    private synchronized native int _type(CPtr cptr, int i);

    private synchronized native String _typeName(CPtr cptr, int i);

    private synchronized native void _xmove(CPtr cptr, CPtr cptr1, int i);

    private synchronized native int _yield(CPtr cptr, int i);

    public static Number convertLuaNumber(Double double1, Class class1)
    {
        if (!class1.isPrimitive()) goto _L2; else goto _L1
_L1:
        if (class1 != Integer.TYPE) goto _L4; else goto _L3
_L3:
        double1 = new Integer(double1.intValue());
_L6:
        return double1;
_L4:
        if (class1 == Long.TYPE)
        {
            return new Long(double1.longValue());
        }
        if (class1 == Float.TYPE)
        {
            return new Float(double1.floatValue());
        }
        if (class1 == Double.TYPE)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (class1 == Byte.TYPE)
        {
            return new Byte(double1.byteValue());
        }
        if (class1 == Short.TYPE)
        {
            return new Short(double1.shortValue());
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (!class1.isAssignableFrom(java/lang/Number))
        {
            break; /* Loop/switch isn't completed */
        }
        if (class1.isAssignableFrom(java/lang/Integer))
        {
            return new Integer(double1.intValue());
        }
        if (class1.isAssignableFrom(java/lang/Long))
        {
            return new Long(double1.longValue());
        }
        if (class1.isAssignableFrom(java/lang/Float))
        {
            return new Float(double1.floatValue());
        }
        if (class1.isAssignableFrom(java/lang/Double))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (class1.isAssignableFrom(java/lang/Byte))
        {
            return new Byte(double1.byteValue());
        }
        if (class1.isAssignableFrom(java/lang/Short))
        {
            return new Short(double1.shortValue());
        }
        break; /* Loop/switch isn't completed */
        if (true) goto _L6; else goto _L5
_L5:
        return null;
    }

    private synchronized native void luajava_open(CPtr cptr, int i);

    public int LargError(int i, String s)
    {
        return _LargError(luaState, i, s);
    }

    public int LcallMeta(int i, String s)
    {
        return _LcallMeta(luaState, i, s);
    }

    public void LcheckAny(int i)
    {
        _LcheckAny(luaState, i);
    }

    public int LcheckInteger(int i)
    {
        return _LcheckInteger(luaState, i);
    }

    public double LcheckNumber(int i)
    {
        return _LcheckNumber(luaState, i);
    }

    public void LcheckStack(int i, String s)
    {
        _LcheckStack(luaState, i, s);
    }

    public String LcheckString(int i)
    {
        return _LcheckString(luaState, i);
    }

    public void LcheckType(int i, int j)
    {
        _LcheckType(luaState, i, j);
    }

    public int LdoFile(String s)
    {
        return _LdoFile(luaState, s);
    }

    public int LdoString(String s)
    {
        return _LdoString(luaState, s);
    }

    public String LfindTable(int i, String s, int j)
    {
        return _LfindTable(luaState, i, s, j);
    }

    public int LgetMetaField(int i, String s)
    {
        return _LgetMetaField(luaState, i, s);
    }

    public void LgetMetatable(String s)
    {
        _LgetMetatable(luaState, s);
    }

    public int LgetN(int i)
    {
        return _LgetN(luaState, i);
    }

    public String Lgsub(String s, String s1, String s2)
    {
        return _Lgsub(luaState, s, s1, s2);
    }

    public int LloadBuffer(byte abyte0[], String s)
    {
        return _LloadBuffer(luaState, abyte0, abyte0.length, s);
    }

    public int LloadFile(String s)
    {
        return _LloadFile(luaState, s);
    }

    public int LloadString(String s)
    {
        return _LloadString(luaState, s);
    }

    public int LnewMetatable(String s)
    {
        return _LnewMetatable(luaState, s);
    }

    public int LoptInteger(int i, int j)
    {
        return _LoptInteger(luaState, i, j);
    }

    public double LoptNumber(int i, double d)
    {
        return _LoptNumber(luaState, i, d);
    }

    public String LoptString(int i, String s)
    {
        return _LoptString(luaState, i, s);
    }

    public int Lref(int i)
    {
        return _Lref(luaState, i);
    }

    public void LsetN(int i, int j)
    {
        _LsetN(luaState, i, j);
    }

    public int Ltyperror(int i, String s)
    {
        return _Ltyperror(luaState, i, s);
    }

    public void LunRef(int i, int j)
    {
        _LunRef(luaState, i, j);
    }

    public void Lwhere(int i)
    {
        _Lwhere(luaState, i);
    }

    public void call(int i, int j)
    {
        _call(luaState, i, j);
    }

    public int checkStack(int i)
    {
        return _checkStack(luaState, i);
    }

    public void close()
    {
        this;
        JVM INSTR monitorenter ;
        LuaStateFactory.removeLuaState(stateId);
        _close(luaState);
        luaState = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void concat(int i)
    {
        _concat(luaState, i);
    }

    public void createTable(int i, int j)
    {
        _createTable(luaState, i, j);
    }

    public String dumpStack()
    {
        int i = getTop();
        StringBuilder stringbuilder = new StringBuilder();
        int j = 1;
        while (j <= i) 
        {
            int k = type(j);
            stringbuilder.append(j).append(": ").append(typeName(k));
            if (k == LUA_TNUMBER.intValue())
            {
                stringbuilder.append(" = ").append(toNumber(j));
            } else
            if (k == LUA_TSTRING.intValue())
            {
                stringbuilder.append(" = '").append(toString(j)).append("'");
            }
            stringbuilder.append("\n");
            j++;
        }
        return stringbuilder.toString();
    }

    public int equal(int i, int j)
    {
        return _equal(luaState, i, j);
    }

    public int error()
    {
        return _error(luaState);
    }

    public int gc(int i, int j)
    {
        return _gc(luaState, i, j);
    }

    public long getCPtrPeer()
    {
        if (luaState != null)
        {
            return luaState.getPeer();
        } else
        {
            return 0L;
        }
    }

    public void getFEnv(int i)
    {
        _getFEnv(luaState, i);
    }

    public void getField(int i, String s)
    {
        _getField(luaState, i, s);
    }

    public int getGcCount()
    {
        return _getGcCount(luaState);
    }

    public void getGlobal(String s)
    {
        this;
        JVM INSTR monitorenter ;
        _getGlobal(luaState, s);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public LuaObject getLuaObject(int i)
    {
        return new LuaObject(this, i);
    }

    public LuaObject getLuaObject(String s)
    {
        return new LuaObject(this, s);
    }

    public LuaObject getLuaObject(LuaObject luaobject, Number number)
    {
        if (luaobject.L.getCPtrPeer() != luaState.getPeer())
        {
            throw new LuaException("Object must have the same LuaState as the parent!");
        } else
        {
            return new LuaObject(luaobject, number);
        }
    }

    public LuaObject getLuaObject(LuaObject luaobject, String s)
    {
        if (luaobject.L.getCPtrPeer() != luaState.getPeer())
        {
            throw new LuaException("Object must have the same LuaState as the parent!");
        } else
        {
            return new LuaObject(luaobject, s);
        }
    }

    public LuaObject getLuaObject(LuaObject luaobject, LuaObject luaobject1)
    {
        if (luaobject.getLuaState().getCPtrPeer() != luaState.getPeer() || luaobject.getLuaState().getCPtrPeer() != luaobject1.getLuaState().getCPtrPeer())
        {
            throw new LuaException("Object must have the same LuaState as the parent!");
        } else
        {
            return new LuaObject(luaobject, luaobject1);
        }
    }

    public int getMetaTable(int i)
    {
        return _getMetaTable(luaState, i);
    }

    public Object getObjectFromUserdata(int i)
    {
        return _getObjectFromUserdata(luaState, i);
    }

    public void getTable(int i)
    {
        _getTable(luaState, i);
    }

    public int getTop()
    {
        return _getTop(luaState);
    }

    public void insert(int i)
    {
        _insert(luaState, i);
    }

    public boolean isBoolean(int i)
    {
        return _isBoolean(luaState, i) != 0;
    }

    public boolean isCFunction(int i)
    {
        return _isCFunction(luaState, i) != 0;
    }

    public boolean isClosed()
    {
        this;
        JVM INSTR monitorenter ;
        CPtr cptr = luaState;
        boolean flag;
        if (cptr == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean isFunction(int i)
    {
        return _isFunction(luaState, i) != 0;
    }

    public boolean isJavaFunction(int i)
    {
        return _isJavaFunction(luaState, i);
    }

    public boolean isNil(int i)
    {
        return _isNil(luaState, i) != 0;
    }

    public boolean isNone(int i)
    {
        return _isNone(luaState, i) != 0;
    }

    public boolean isNoneOrNil(int i)
    {
        return _isNoneOrNil(luaState, i) != 0;
    }

    public boolean isNumber(int i)
    {
        return _isNumber(luaState, i) != 0;
    }

    public boolean isObject(int i)
    {
        return _isObject(luaState, i);
    }

    public boolean isString(int i)
    {
        return _isString(luaState, i) != 0;
    }

    public boolean isTable(int i)
    {
        return _isTable(luaState, i) != 0;
    }

    public boolean isThread(int i)
    {
        return _isThread(luaState, i) != 0;
    }

    public boolean isUserdata(int i)
    {
        return _isUserdata(luaState, i) != 0;
    }

    public int lessthan(int i, int j)
    {
        return _lessthan(luaState, i, j);
    }

    public void newTable()
    {
        _newTable(luaState);
    }

    public LuaState newThread()
    {
        LuaState luastate = new LuaState(_newthread(luaState));
        LuaStateFactory.insertLuaState(luastate);
        return luastate;
    }

    public int next(int i)
    {
        return _next(luaState, i);
    }

    public int objLen(int i)
    {
        return _objlen(luaState, i);
    }

    public void openBase()
    {
        _openBase(luaState);
    }

    public void openDebug()
    {
        _openDebug(luaState);
    }

    public void openIo()
    {
        _openIo(luaState);
    }

    public void openLibs()
    {
        _openLibs(luaState);
    }

    public void openMath()
    {
        _openMath(luaState);
    }

    public void openOs()
    {
        _openOs(luaState);
    }

    public void openPackage()
    {
        _openPackage(luaState);
    }

    public void openString()
    {
        _openString(luaState);
    }

    public void openTable()
    {
        _openTable(luaState);
    }

    public int pcall(int i, int j, int k)
    {
        return _pcall(luaState, i, j, k);
    }

    public void pop(int i)
    {
        _pop(luaState, i);
    }

    public void pushBoolean(boolean flag)
    {
        CPtr cptr = luaState;
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        _pushBoolean(cptr, i);
    }

    public void pushInteger(int i)
    {
        _pushInteger(luaState, i);
    }

    public void pushJavaFunction(JavaFunction javafunction)
    {
        _pushJavaFunction(luaState, javafunction);
    }

    public void pushJavaObject(Object obj)
    {
        _pushJavaObject(luaState, obj);
    }

    public void pushNil()
    {
        _pushNil(luaState);
    }

    public void pushNumber(double d)
    {
        _pushNumber(luaState, d);
    }

    public void pushObjectValue(Object obj)
    {
        if (obj == null)
        {
            pushNil();
            return;
        }
        if (obj instanceof Boolean)
        {
            pushBoolean(((Boolean)obj).booleanValue());
            return;
        }
        if (obj instanceof Number)
        {
            pushNumber(((Number)obj).doubleValue());
            return;
        }
        if (obj instanceof String)
        {
            pushString((String)obj);
            return;
        }
        if (obj instanceof JavaFunction)
        {
            pushJavaFunction((JavaFunction)obj);
            return;
        }
        if (obj instanceof LuaObject)
        {
            ((LuaObject)obj).push();
            return;
        }
        if (obj instanceof byte[])
        {
            pushString((byte[])(byte[])obj);
            return;
        } else
        {
            pushJavaObject(obj);
            return;
        }
    }

    public void pushString(String s)
    {
        if (s == null)
        {
            _pushNil(luaState);
            return;
        } else
        {
            _pushString(luaState, s);
            return;
        }
    }

    public void pushString(byte abyte0[])
    {
        if (abyte0 == null)
        {
            _pushNil(luaState);
            return;
        } else
        {
            _pushString(luaState, abyte0, abyte0.length);
            return;
        }
    }

    public void pushValue(int i)
    {
        _pushValue(luaState, i);
    }

    public void rawGet(int i)
    {
        _rawGet(luaState, i);
    }

    public void rawGetI(int i, int j)
    {
        _rawGetI(luaState, i, j);
    }

    public void rawSet(int i)
    {
        _rawSet(luaState, i);
    }

    public void rawSetI(int i, int j)
    {
        _rawSetI(luaState, i, j);
    }

    public int rawequal(int i, int j)
    {
        return _rawequal(luaState, i, j);
    }

    public void remove(int i)
    {
        _remove(luaState, i);
    }

    public void replace(int i)
    {
        _replace(luaState, i);
    }

    public int resume(int i)
    {
        return _resume(luaState, i);
    }

    public int setFEnv(int i)
    {
        return _setFEnv(luaState, i);
    }

    public void setField(int i, String s)
    {
        _setField(luaState, i, s);
    }

    public void setGlobal(String s)
    {
        this;
        JVM INSTR monitorenter ;
        _setGlobal(luaState, s);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public int setMetaTable(int i)
    {
        return _setMetaTable(luaState, i);
    }

    public void setTable(int i)
    {
        _setTable(luaState, i);
    }

    public void setTop(int i)
    {
        _setTop(luaState, i);
    }

    public int status()
    {
        return _status(luaState);
    }

    public int strLen(int i)
    {
        return _strlen(luaState, i);
    }

    public boolean toBoolean(int i)
    {
        return _toBoolean(luaState, i) != 0;
    }

    public int toInteger(int i)
    {
        return _toInteger(luaState, i);
    }

    public Object toJavaObject(int i)
    {
        this;
        JVM INSTR monitorenter ;
        if (!isBoolean(i)) goto _L2; else goto _L1
_L1:
        Object obj = new Boolean(toBoolean(i));
_L4:
        this;
        JVM INSTR monitorexit ;
        return obj;
_L2:
        if (type(i) == LUA_TSTRING.intValue())
        {
            obj = toString(i);
            continue; /* Loop/switch isn't completed */
        }
        if (isFunction(i))
        {
            obj = getLuaObject(i);
            continue; /* Loop/switch isn't completed */
        }
        if (isTable(i))
        {
            obj = getLuaObject(i);
            continue; /* Loop/switch isn't completed */
        }
        if (type(i) == LUA_TNUMBER.intValue())
        {
            obj = new Double(toNumber(i));
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_119;
        Exception exception;
        exception;
        throw exception;
        if (!isUserdata(i))
        {
            break MISSING_BLOCK_LABEL_153;
        }
        if (isObject(i))
        {
            obj = getObjectFromUserdata(i);
            continue; /* Loop/switch isn't completed */
        }
        obj = getLuaObject(i);
        continue; /* Loop/switch isn't completed */
        boolean flag = isNil(i);
        obj = null;
        if (flag)
        {
            obj = null;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public double toNumber(int i)
    {
        return _toNumber(luaState, i);
    }

    public String toString(int i)
    {
        return _toString(luaState, i);
    }

    public LuaState toThread(int i)
    {
        return new LuaState(_toThread(luaState, i));
    }

    public int type(int i)
    {
        return _type(luaState, i);
    }

    public String typeName(int i)
    {
        return _typeName(luaState, i);
    }

    public void xmove(LuaState luastate, int i)
    {
        _xmove(luaState, luastate.luaState, i);
    }

    public int yield(int i)
    {
        return _yield(luaState, i);
    }

    static 
    {
        System.loadLibrary("luajava");
    }
}
