// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.tauth;


public class UiError
{

    public int errorCode;
    public String errorDetail;
    public String errorMessage;

    public UiError(int i, String s, String s1)
    {
        errorMessage = s;
        errorCode = i;
        errorDetail = s1;
    }
}
