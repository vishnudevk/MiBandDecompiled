// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.keplerproject.luajava;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

// Referenced classes of package org.keplerproject.luajava:
//            LuaStateFactory, LuaState, LuaException, LuaObject

public final class LuaJavaAPI
{

    private LuaJavaAPI()
    {
    }

    public static int checkField(int i, Object obj, String s)
    {
        LuaState luastate = LuaStateFactory.getExistingState(i);
        luastate;
        JVM INSTR monitorenter ;
        if (!(obj instanceof Class)) goto _L2; else goto _L1
_L1:
        Class class1 = (Class)obj;
_L4:
        Field field = class1.getField(s);
        if (field != null)
        {
            break; /* Loop/switch isn't completed */
        }
        luastate;
        JVM INSTR monitorexit ;
        return 0;
_L2:
        class1 = obj.getClass();
        if (true) goto _L4; else goto _L3
        Exception exception1;
        exception1;
        luastate;
        JVM INSTR monitorexit ;
        return 0;
_L3:
        Object obj1 = field.get(obj);
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        luastate;
        JVM INSTR monitorexit ;
        return 0;
        Exception exception2;
        exception2;
        luastate;
        JVM INSTR monitorexit ;
        return 0;
        luastate.pushObjectValue(obj1);
        luastate;
        JVM INSTR monitorexit ;
        return 1;
        Exception exception;
        exception;
        luastate;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static int checkMethod(int i, Object obj, String s)
    {
        LuaState luastate = LuaStateFactory.getExistingState(i);
        luastate;
        JVM INSTR monitorenter ;
        if (!(obj instanceof Class)) goto _L2; else goto _L1
_L1:
        Class class1 = (Class)obj;
_L5:
        Method amethod[] = class1.getMethods();
        int j = 0;
_L6:
        if (j >= amethod.length) goto _L4; else goto _L3
_L3:
        if (!amethod[j].getName().equals(s))
        {
            break MISSING_BLOCK_LABEL_77;
        }
        return 1;
_L2:
        class1 = obj.getClass();
          goto _L5
_L4:
        luastate;
        JVM INSTR monitorexit ;
        return 0;
        Exception exception;
        exception;
        luastate;
        JVM INSTR monitorexit ;
        throw exception;
        j++;
          goto _L6
    }

    public static int classIndex(int i, Class class1, String s)
    {
label0:
        {
            synchronized (LuaStateFactory.getExistingState(i))
            {
                if (checkField(i, class1, s) == 0)
                {
                    break label0;
                }
            }
            return 1;
        }
        if (checkMethod(i, class1, s) != 0)
        {
            return 2;
        }
        break MISSING_BLOCK_LABEL_40;
        exception;
        luastate;
        JVM INSTR monitorexit ;
        throw exception;
        luastate;
        JVM INSTR monitorexit ;
        return 0;
    }

    private static Object compareTypes(LuaState luastate, Class class1, int i)
    {
        boolean flag = true;
        if (!luastate.isBoolean(i)) goto _L2; else goto _L1
_L1:
        if (!class1.isPrimitive()) goto _L4; else goto _L3
_L3:
        boolean flag1;
        Class class2;
        class2 = Boolean.TYPE;
        flag1 = false;
        if (class1 == class2) goto _L6; else goto _L5
_L5:
        Object obj = new Boolean(luastate.toBoolean(i));
_L7:
        boolean flag6;
        if (!flag1)
        {
            throw new LuaException("Invalid Parameter.");
        } else
        {
            return obj;
        }
_L4:
        flag6 = class1.isAssignableFrom(java/lang/Boolean);
        flag1 = false;
        if (!flag6)
        {
            continue; /* Loop/switch isn't completed */
        }
_L6:
        flag1 = flag;
        continue; /* Loop/switch isn't completed */
_L2:
        if (luastate.type(i) == LuaState.LUA_TSTRING.intValue())
        {
            boolean flag5 = class1.isAssignableFrom(java/lang/String);
            flag1 = false;
            obj = null;
            if (flag5)
            {
                obj = luastate.toString(i);
                flag1 = flag;
            }
        } else
        if (luastate.isFunction(i))
        {
            boolean flag4 = class1.isAssignableFrom(org/keplerproject/luajava/LuaObject);
            flag1 = false;
            obj = null;
            if (flag4)
            {
                obj = luastate.getLuaObject(i);
                flag1 = flag;
            }
        } else
        if (luastate.isTable(i))
        {
            boolean flag3 = class1.isAssignableFrom(org/keplerproject/luajava/LuaObject);
            flag1 = false;
            obj = null;
            if (flag3)
            {
                obj = luastate.getLuaObject(i);
                flag1 = flag;
            }
        } else
        if (luastate.type(i) == LuaState.LUA_TNUMBER.intValue())
        {
            obj = LuaState.convertLuaNumber(new Double(luastate.toNumber(i)), class1);
            flag1 = false;
            if (obj != null)
            {
                flag1 = flag;
            }
        } else
        if (luastate.isUserdata(i))
        {
            if (luastate.isObject(i))
            {
                Object obj1 = luastate.getObjectFromUserdata(i);
                Object obj2;
                if (!class1.isAssignableFrom(obj1.getClass()))
                {
                    flag = false;
                    obj2 = null;
                } else
                {
                    obj2 = obj1;
                }
                obj = obj2;
                flag1 = flag;
            } else
            {
                boolean flag2 = class1.isAssignableFrom(org/keplerproject/luajava/LuaObject);
                flag1 = false;
                obj = null;
                if (flag2)
                {
                    obj = luastate.getLuaObject(i);
                    flag1 = flag;
                }
            }
        } else
        {
label0:
            {
                if (!luastate.isNil(i))
                {
                    break label0;
                }
                flag1 = flag;
                obj = null;
            }
        }
          goto _L7
        throw new LuaException("Invalid Parameters.");
        if (true) goto _L5; else goto _L8
_L8:
    }

    public static int createProxyObject(int i, String s)
    {
        LuaState luastate = LuaStateFactory.getExistingState(i);
        luastate;
        JVM INSTR monitorenter ;
        if (!luastate.isTable(2))
        {
            throw new LuaException("Parameter is not a table. Can't create proxy.");
        }
        break MISSING_BLOCK_LABEL_42;
        Exception exception1;
        exception1;
        throw new LuaException(exception1);
        Exception exception;
        exception;
        luastate;
        JVM INSTR monitorexit ;
        throw exception;
        luastate.pushJavaObject(luastate.getLuaObject(2).createProxy(s));
        luastate;
        JVM INSTR monitorexit ;
        return 1;
    }

    private static Object getObjInstance(LuaState luastate, Class class1)
    {
        luastate;
        JVM INSTR monitorenter ;
        int i;
        Object aobj[];
        Constructor aconstructor[];
        i = luastate.getTop();
        aobj = new Object[i - 1];
        aconstructor = class1.getConstructors();
        int j = 0;
_L6:
        int k = aconstructor.length;
        Constructor constructor = null;
        if (j >= k) goto _L2; else goto _L1
_L1:
        Class aclass[];
        aclass = aconstructor[j].getParameterTypes();
        if (aclass.length == i - 1)
        {
            break MISSING_BLOCK_LABEL_181;
        }
          goto _L3
_L4:
        int i1 = aclass.length;
        int l;
        if (l >= i1)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        aobj[l] = compareTypes(luastate, aclass[l], l + 2);
        l++;
          goto _L4
        Exception exception2;
        exception2;
        boolean flag = false;
        if (!flag) goto _L3; else goto _L5
_L5:
        constructor = aconstructor[j];
_L2:
        if (constructor != null)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        throw new LuaException("Invalid method call. No such method.");
        Exception exception;
        exception;
        luastate;
        JVM INSTR monitorexit ;
        throw exception;
        Object obj = constructor.newInstance(aobj);
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_170;
        }
        throw new LuaException("Couldn't instantiate java Object");
        Exception exception1;
        exception1;
        throw new LuaException(exception1);
        luastate;
        JVM INSTR monitorexit ;
        return obj;
_L3:
        j++;
          goto _L6
        flag = true;
        l = 0;
          goto _L4
    }

    public static int javaLoadLib(int i, String s, String s1)
    {
        LuaState luastate = LuaStateFactory.getExistingState(i);
        luastate;
        JVM INSTR monitorenter ;
        Class class1 = Class.forName(s);
        Object obj = class1.getMethod(s1, new Class[] {
            org/keplerproject/luajava/LuaState
        }).invoke(null, new Object[] {
            luastate
        });
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        int j;
        if (!(obj instanceof Integer))
        {
            break MISSING_BLOCK_LABEL_89;
        }
        j = ((Integer)obj).intValue();
        return j;
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
        throw new LuaException(classnotfoundexception);
        Exception exception;
        exception;
        luastate;
        JVM INSTR monitorexit ;
        throw exception;
        luastate;
        JVM INSTR monitorexit ;
        return 0;
        Exception exception1;
        exception1;
        throw new LuaException((new StringBuilder()).append("Error on calling method. Library could not be loaded. ").append(exception1.getMessage()).toString());
    }

    public static int javaNew(int i, Class class1)
    {
        synchronized (LuaStateFactory.getExistingState(i))
        {
            luastate.pushJavaObject(getObjInstance(luastate, class1));
        }
        return 1;
        exception;
        luastate;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static int javaNewInstance(int i, String s)
    {
        LuaState luastate = LuaStateFactory.getExistingState(i);
        luastate;
        JVM INSTR monitorenter ;
        Class class1 = Class.forName(s);
        luastate.pushJavaObject(getObjInstance(luastate, class1));
        return 1;
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
        throw new LuaException(classnotfoundexception);
        Exception exception;
        exception;
        luastate;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static int objectIndex(int i, Object obj, String s)
    {
        LuaState luastate = LuaStateFactory.getExistingState(i);
        luastate;
        JVM INSTR monitorenter ;
        int j;
        Object aobj[];
        j = luastate.getTop();
        aobj = new Object[j - 1];
        if (!(obj instanceof Class)) goto _L2; else goto _L1
_L1:
        Class class1 = (Class)obj;
_L6:
        Method amethod[] = class1.getMethods();
        int k = 0;
_L16:
        if (k >= amethod.length) goto _L4; else goto _L3
_L3:
        if (!amethod[k].getName().equals(s))
        {
            break MISSING_BLOCK_LABEL_276;
        }
          goto _L5
_L2:
        class1 = obj.getClass();
          goto _L6
_L5:
        Class aclass[];
        aclass = amethod[k].getParameterTypes();
        if (aclass.length != j - 1)
        {
            break MISSING_BLOCK_LABEL_276;
        }
        int l = 0;
_L9:
        int i1 = aclass.length;
        if (l >= i1) goto _L8; else goto _L7
_L7:
        aobj[l] = compareTypes(luastate, aclass[l], l + 2);
        l++;
          goto _L9
        Exception exception2;
        exception2;
        boolean flag = false;
_L14:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_276;
        }
        Method method = amethod[k];
_L15:
        if (method != null)
        {
            break MISSING_BLOCK_LABEL_178;
        }
        throw new LuaException("Invalid method call. No such method.");
        Exception exception;
        exception;
        luastate;
        JVM INSTR monitorexit ;
        throw exception;
        if (Modifier.isPublic(method.getModifiers()))
        {
            method.setAccessible(true);
        }
        if (!(obj instanceof Class)) goto _L11; else goto _L10
_L10:
        Object obj3 = method.invoke(null, aobj);
        Object obj2 = obj3;
_L13:
        if (obj2 != null)
        {
            break; /* Loop/switch isn't completed */
        }
        luastate;
        JVM INSTR monitorexit ;
        return 0;
_L11:
        Object obj1 = method.invoke(obj, aobj);
        obj2 = obj1;
        if (true) goto _L13; else goto _L12
        Exception exception1;
        exception1;
        throw new LuaException(exception1);
_L12:
        luastate.pushObjectValue(obj2);
        luastate;
        JVM INSTR monitorexit ;
        return 1;
_L8:
        flag = true;
          goto _L14
_L4:
        method = null;
          goto _L15
        k++;
          goto _L16
    }
}
