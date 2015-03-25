// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.stream;

import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;

// Referenced classes of package com.google.gson.stream:
//            JsonReader

final class a extends JsonReaderInternalAccess
{

    a()
    {
    }

    public void promoteNameToValue(JsonReader jsonreader)
    {
        if (jsonreader instanceof JsonTreeReader)
        {
            ((JsonTreeReader)jsonreader).promoteNameToValue();
            return;
        }
        int i = JsonReader.a(jsonreader);
        if (i == 0)
        {
            i = JsonReader.b(jsonreader);
        }
        if (i == 13)
        {
            JsonReader.a(jsonreader, 9);
            return;
        }
        if (i == 12)
        {
            JsonReader.a(jsonreader, 8);
            return;
        }
        if (i == 14)
        {
            JsonReader.a(jsonreader, 10);
            return;
        } else
        {
            throw new IllegalStateException((new StringBuilder()).append("Expected a name but was ").append(jsonreader.peek()).append(" ").append(" at line ").append(JsonReader.c(jsonreader)).append(" column ").append(JsonReader.d(jsonreader)).toString());
        }
    }
}
