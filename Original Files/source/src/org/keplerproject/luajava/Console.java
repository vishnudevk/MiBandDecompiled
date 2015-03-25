// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.keplerproject.luajava;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

// Referenced classes of package org.keplerproject.luajava:
//            LuaStateFactory, LuaState, LuaException

public class Console
{

    public Console()
    {
    }

    public static void main(String args[])
    {
        LuaState luastate;
        luastate = LuaStateFactory.newLuaState();
        luastate.openLibs();
        if (args.length <= 0) goto _L2; else goto _L1
_L1:
        int i = 0;
_L3:
        int j;
        if (i >= args.length)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        j = luastate.LloadFile(args[i]);
        if (j != 0)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        j = luastate.pcall(0, 0, 0);
        if (j == 0)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        try
        {
            throw new LuaException((new StringBuilder()).append("Error on file: ").append(args[i]).append(". ").append(luastate.toString(-1)).toString());
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return;
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        BufferedReader bufferedreader;
        System.out.println("API Lua Java - console mode.");
        bufferedreader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("> ");
_L4:
        String s = bufferedreader.readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_240;
        }
        int k;
        if (s.equals("exit"))
        {
            break MISSING_BLOCK_LABEL_240;
        }
        k = luastate.LloadBuffer(s.getBytes(), "from console");
        if (k != 0)
        {
            break MISSING_BLOCK_LABEL_187;
        }
        k = luastate.pcall(0, 0, 0);
        if (k == 0)
        {
            break MISSING_BLOCK_LABEL_229;
        }
        System.err.println((new StringBuilder()).append("Error on line: ").append(s).toString());
        System.err.println(luastate.toString(-1));
        System.out.print("> ");
          goto _L4
        luastate.close();
        return;
    }
}
