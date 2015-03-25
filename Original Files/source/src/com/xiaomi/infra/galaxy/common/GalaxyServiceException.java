// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common;

import com.xiaomi.infra.galaxy.common.constants.ReturnCode;

// Referenced classes of package com.xiaomi.infra.galaxy.common:
//            GalaxyClientException

public class GalaxyServiceException extends GalaxyClientException
{

    private static final long serialVersionUID = 1L;
    private String errorCode;
    private ErrorType errorType;
    private String serviceName;
    private int statusCode;

    public GalaxyServiceException(ReturnCode returncode)
    {
        super(returncode);
        errorType = ErrorType.Unknown;
    }

    public String getErrorCode()
    {
        return errorCode;
    }

    public ErrorType getErrorType()
    {
        return errorType;
    }

    public String getServiceName()
    {
        return serviceName;
    }

    public int getStatusCode()
    {
        return statusCode;
    }

    public void setErrorCode(String s)
    {
        errorCode = s;
    }

    public void setErrorType(ErrorType errortype)
    {
        errorType = errortype;
    }

    public void setServiceName(String s)
    {
        serviceName = s;
    }

    public void setStatusCode(int i)
    {
        statusCode = i;
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getSimpleName()).append(": ").append("Status Code: ").append(getStatusCode()).append(", Galaxy Service: ").append(getServiceName()).append(", ").append(", Galaxy Error Code: ").append(getErrorCode()).append(", ").append("Galaxy Error Message: ").append(getMessage()).toString();
    }

    private class ErrorType extends Enum
    {

        private static final ErrorType $VALUES[];
        public static final ErrorType Client;
        public static final ErrorType Service;
        public static final ErrorType Unknown;

        public static ErrorType valueOf(String s)
        {
            return (ErrorType)Enum.valueOf(com/xiaomi/infra/galaxy/common/GalaxyServiceException$ErrorType, s);
        }

        public static ErrorType[] values()
        {
            return (ErrorType[])$VALUES.clone();
        }

        static 
        {
            Client = new ErrorType("Client", 0);
            Service = new ErrorType("Service", 1);
            Unknown = new ErrorType("Unknown", 2);
            ErrorType aerrortype[] = new ErrorType[3];
            aerrortype[0] = Client;
            aerrortype[1] = Service;
            aerrortype[2] = Unknown;
            $VALUES = aerrortype;
        }

        private ErrorType(String s, int i)
        {
            super(s, i);
        }
    }

}
