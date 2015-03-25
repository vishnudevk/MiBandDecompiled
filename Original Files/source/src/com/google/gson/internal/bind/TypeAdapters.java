// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.gson.internal.bind;

import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.util.BitSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.UUID;

// Referenced classes of package com.google.gson.internal.bind:
//            n, y, K, O, 
//            P, Q, R, S, 
//            T, o, p, q, 
//            r, s, t, u, 
//            v, w, x, z, 
//            A, B, D, E, 
//            F, G, H, I, 
//            J, L, M

public final class TypeAdapters
{

    public static final TypeAdapter BIG_DECIMAL = new s();
    public static final TypeAdapter BIG_INTEGER = new t();
    public static final TypeAdapter BIT_SET;
    public static final TypeAdapterFactory BIT_SET_FACTORY;
    public static final TypeAdapter BOOLEAN;
    public static final TypeAdapter BOOLEAN_AS_STRING = new O();
    public static final TypeAdapterFactory BOOLEAN_FACTORY;
    public static final TypeAdapter BYTE;
    public static final TypeAdapterFactory BYTE_FACTORY;
    public static final TypeAdapter CALENDAR;
    public static final TypeAdapterFactory CALENDAR_FACTORY;
    public static final TypeAdapter CHARACTER;
    public static final TypeAdapterFactory CHARACTER_FACTORY;
    public static final TypeAdapter CLASS;
    public static final TypeAdapterFactory CLASS_FACTORY;
    public static final TypeAdapter DOUBLE = new o();
    public static final TypeAdapterFactory ENUM_FACTORY = newEnumTypeHierarchyFactory();
    public static final TypeAdapter FLOAT = new T();
    public static final TypeAdapter INET_ADDRESS;
    public static final TypeAdapterFactory INET_ADDRESS_FACTORY;
    public static final TypeAdapter INTEGER;
    public static final TypeAdapterFactory INTEGER_FACTORY;
    public static final TypeAdapter JSON_ELEMENT;
    public static final TypeAdapterFactory JSON_ELEMENT_FACTORY;
    public static final TypeAdapter LOCALE;
    public static final TypeAdapterFactory LOCALE_FACTORY;
    public static final TypeAdapter LONG = new S();
    public static final TypeAdapter NUMBER;
    public static final TypeAdapterFactory NUMBER_FACTORY;
    public static final TypeAdapter SHORT;
    public static final TypeAdapterFactory SHORT_FACTORY;
    public static final TypeAdapter STRING;
    public static final TypeAdapter STRING_BUFFER;
    public static final TypeAdapterFactory STRING_BUFFER_FACTORY;
    public static final TypeAdapter STRING_BUILDER;
    public static final TypeAdapterFactory STRING_BUILDER_FACTORY;
    public static final TypeAdapterFactory STRING_FACTORY;
    public static final TypeAdapterFactory TIMESTAMP_FACTORY = new B();
    public static final TypeAdapter URI;
    public static final TypeAdapterFactory URI_FACTORY;
    public static final TypeAdapter URL;
    public static final TypeAdapterFactory URL_FACTORY;
    public static final TypeAdapter UUID;
    public static final TypeAdapterFactory UUID_FACTORY;

    private TypeAdapters()
    {
    }

    public static TypeAdapterFactory newEnumTypeHierarchyFactory()
    {
        return new G();
    }

    public static TypeAdapterFactory newFactory(TypeToken typetoken, TypeAdapter typeadapter)
    {
        return new H(typetoken, typeadapter);
    }

    public static TypeAdapterFactory newFactory(Class class1, TypeAdapter typeadapter)
    {
        return new I(class1, typeadapter);
    }

    public static TypeAdapterFactory newFactory(Class class1, Class class2, TypeAdapter typeadapter)
    {
        return new J(class1, class2, typeadapter);
    }

    public static TypeAdapterFactory newFactoryForMultipleTypes(Class class1, Class class2, TypeAdapter typeadapter)
    {
        return new L(class1, class2, typeadapter);
    }

    public static TypeAdapterFactory newTypeHierarchyFactory(Class class1, TypeAdapter typeadapter)
    {
        return new M(class1, typeadapter);
    }

    static 
    {
        CLASS = new n();
        CLASS_FACTORY = newFactory(java/lang/Class, CLASS);
        BIT_SET = new y();
        BIT_SET_FACTORY = newFactory(java/util/BitSet, BIT_SET);
        BOOLEAN = new K();
        BOOLEAN_FACTORY = newFactory(Boolean.TYPE, java/lang/Boolean, BOOLEAN);
        BYTE = new P();
        BYTE_FACTORY = newFactory(Byte.TYPE, java/lang/Byte, BYTE);
        SHORT = new Q();
        SHORT_FACTORY = newFactory(Short.TYPE, java/lang/Short, SHORT);
        INTEGER = new R();
        INTEGER_FACTORY = newFactory(Integer.TYPE, java/lang/Integer, INTEGER);
        NUMBER = new p();
        NUMBER_FACTORY = newFactory(java/lang/Number, NUMBER);
        CHARACTER = new q();
        CHARACTER_FACTORY = newFactory(Character.TYPE, java/lang/Character, CHARACTER);
        STRING = new r();
        STRING_FACTORY = newFactory(java/lang/String, STRING);
        STRING_BUILDER = new u();
        STRING_BUILDER_FACTORY = newFactory(java/lang/StringBuilder, STRING_BUILDER);
        STRING_BUFFER = new v();
        STRING_BUFFER_FACTORY = newFactory(java/lang/StringBuffer, STRING_BUFFER);
        URL = new w();
        URL_FACTORY = newFactory(java/net/URL, URL);
        URI = new x();
        URI_FACTORY = newFactory(java/net/URI, URI);
        INET_ADDRESS = new z();
        INET_ADDRESS_FACTORY = newTypeHierarchyFactory(java/net/InetAddress, INET_ADDRESS);
        UUID = new A();
        UUID_FACTORY = newFactory(java/util/UUID, UUID);
        CALENDAR = new D();
        CALENDAR_FACTORY = newFactoryForMultipleTypes(java/util/Calendar, java/util/GregorianCalendar, CALENDAR);
        LOCALE = new E();
        LOCALE_FACTORY = newFactory(java/util/Locale, LOCALE);
        JSON_ELEMENT = new F();
        JSON_ELEMENT_FACTORY = newTypeHierarchyFactory(com/google/gson/JsonElement, JSON_ELEMENT);
    }
}
