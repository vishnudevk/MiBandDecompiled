// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.constants;

import com.xiaomi.infra.galaxy.common.model.GalaxyMarshaller;
import com.xiaomi.infra.galaxy.common.model.Result;
import com.xiaomi.infra.galaxy.common.util.StringUtils;

public class ReturnCode
{

    public static final ReturnCode ACCESS_DENIED = new ReturnCode(403, 0xfffc55b8, "access is denied");
    public static final ReturnCode ACCESS_METHOD_IS_BLANK = new ReturnCode(200, 0xfffca49e, "access method is blank");
    public static final ReturnCode ACCESS_METHOD_IS_INVALID = new ReturnCode(200, 0xfffca49f, "access method is invalid");
    public static final ReturnCode API_LEVEL_ERROR = new ReturnCode(200, 0xfffca4a0, "api level error");
    public static final ReturnCode APP_ID_IS_BLANK = new ReturnCode(200, 0xfffca49d, "app id is blank");
    public static final ReturnCode APP_NOT_EXISTS = new ReturnCode(200, 0xfffc561a, "app not exists");
    public static final ReturnCode APP_SECRET_IS_BLANK = new ReturnCode(200, 0xfffca49c, "app secret is blank");
    public static final ReturnCode ATTRIBUTE_DEFINITIONS_IS_NULL = new ReturnCode(200, 0xfffca3d4, "attribute definitions is null");
    public static final ReturnCode ATTRIBUTE_NAME_IS_BLANK = new ReturnCode(200, 0xfffca3d6, "attribute name is blank");
    public static final ReturnCode ATTRIBUTE_NAME_IS_INVALID = new ReturnCode(200, 0xfffca3d5, "attribute name is invalid");
    public static final ReturnCode ATTRIBUTE_NAME_IS_UNDEFINED = new ReturnCode(200, 0xfffca3d3, "attribute name is undefined");
    public static final ReturnCode ATTRIBUTE_NAME_TOO_LONG = new ReturnCode(200, 0xfffca3d7, "attribute name is too long");
    public static final ReturnCode ATTRIBUTE_TYPE_IS_BLANK = new ReturnCode(200, 0xfffca3d0, "attribute type is blank");
    public static final ReturnCode ATTRIBUTE_TYPE_IS_INVALID = new ReturnCode(200, 0xfffca3d1, "attribute type is invalid");
    public static final ReturnCode ATTRIBUTE_VALUE_IS_INVALID = new ReturnCode(200, 0xfffca3cd, "attribute value is invalid");
    public static final ReturnCode ATTRIBUTE_VALUE_IS_NULL = new ReturnCode(200, 0xfffca3cc, "attribute value is null");
    public static final ReturnCode BAD_REQUEST = new ReturnCode(400, 0xfffc2f6f, "bad request");
    public static final ReturnCode BATCH_CELLS_IS_EMPTY = new ReturnCode(200, 0xfffca2aa, "batch cells is empty");
    public static final ReturnCode BATCH_CELLS_IS_NOT_ONLY = new ReturnCode(200, 0xfffca2a9, "batch cell is not only");
    public static final ReturnCode BATCH_IS_TOO_BIG = new ReturnCode(200, 0xfffca2a8, "batch cells is too big");
    public static final ReturnCode COMPLEX_CONDITION_NOT_SUPPORTED = new ReturnCode(200, 0xfffca30d, "complex condition is not supported");
    public static final ReturnCode CONDITION_CYCLE_REFERENCE = new ReturnCode(200, 0xfffca30b, "find cycle reference in condition");
    public static final ReturnCode CONDITION_NOT_SUPPORTED = new ReturnCode(200, 0xfffca30e, "condition is not supported");
    public static final ReturnCode CREDENTIAL_TYPE_IS_INVALID = new ReturnCode(200, 0xfffca498, "credential type is invalid");
    public static final ReturnCode DUPLICATE_ATTRIBUTE_NAME = new ReturnCode(200, 0xfffca3d2, "duplicate attribute name");
    public static final ReturnCode DUPLICATE_KEY_NAME = new ReturnCode(200, 0xfffca372, "duplicate key name");
    public static final ReturnCode GENERATE_STORAGEACCESS_TOKEN_FAILED = new ReturnCode(403, 0xfffc7cc5, "generate storage access token failed");
    public static final ReturnCode HTTP_ERROR = new ReturnCode(400, 0xfffc2f70, "http request error");
    public static final ReturnCode INTERFACE_IS_NOT_IMPLEMENTED = new ReturnCode(501, 0xfffca2a6, "interface is not implemented");
    public static final ReturnCode INTERNAL_SERVICE_ERROR = new ReturnCode(200, 0xfffca2a5, "internal server error");
    public static final ReturnCode KEY_IS_TOO_LONG = new ReturnCode(200, 0xfffca36f, "key is too long");
    public static final ReturnCode KEY_NAME_IS_BLANK = new ReturnCode(200, 0xfffca374, "key name is blank");
    public static final ReturnCode KEY_NAME_IS_UNDEFINED = new ReturnCode(200, 0xfffca373, "key name is undefined");
    public static final ReturnCode KEY_TYPE_IS_INVALID = new ReturnCode(200, 0xfffca36d, "key type is invalid");
    public static final ReturnCode KEY_VALUES_IS_EMPTY = new ReturnCode(200, 0xfffca371, "key values is empty");
    public static final ReturnCode KEY_VALUES_IS_INCOMPLETE = new ReturnCode(200, 0xfffca36e, "key values is incomplete");
    public static final ReturnCode KEY_VALUE_IS_NULL = new ReturnCode(200, 0xfffca370, "key value is null");
    public static final ReturnCode NEED_INTEGER_ATTRIBUTE_VALUE = new ReturnCode(200, 0xfffca3cf, "need integer type of attribute value");
    public static final ReturnCode NEED_NUMBER_ATTRIBUTE_VALUE = new ReturnCode(200, 0xfffca3ce, "need number type of attribute value");
    public static final ReturnCode NUBMER_DATA_OVERFLOW = new ReturnCode(200, 0xfffca494, "number data overflow");
    public static final ReturnCode OAUTH_ACCESSTOKEN_IS_INVALID = new ReturnCode(401, 0xfffc7d2c, "oauth access token is invalid");
    public static final ReturnCode OAUTH_APPID_IS_INVALID = new ReturnCode(401, 0xfffc7d2a, "oauth app id is invalid");
    public static final ReturnCode OAUTH_PROVIDER_IS_INVALID = new ReturnCode(401, 0xfffc7d2b, "oauth provider is invalid");
    public static final ReturnCode OAUTH_VERIFY_APPS_IS_EMPTY = new ReturnCode(401, 0xfffc7d28, "oauth verify apps is empty");
    public static final ReturnCode OAUTH_VERIFY_FAILED = new ReturnCode(401, 0xfffc7d29, "oauth verify failed");
    public static final ReturnCode OK = new ReturnCode(200, 1, "success");
    public static final ReturnCode OPERATION_FAILED = new ReturnCode(200, 0xfffca2a4, "operation failed");
    public static final ReturnCode PARAMETER_IS_INVALID = new ReturnCode(200, 0xfffca495, "parameter is invalid");
    public static final ReturnCode PARAMETER_IS_NULL = new ReturnCode(200, 0xfffca497, "parameter is null");
    public static final ReturnCode PARAMETER_TYPE_ERROR = new ReturnCode(200, 0xfffca496, "parameter type error");
    public static final ReturnCode REQUEST_ENTRY_IS_TOO_BIG = new ReturnCode(200, 0xfffca2a7, "request entry is too big");
    public static final ReturnCode RESPONSE_IS_BLANK = new ReturnCode(200, 0xfffc2f6e, "response is blank");
    public static final ReturnCode SET_ACTION_IS_BLANK = new ReturnCode(200, 0xfffca2ac, "set action is blank");
    public static final ReturnCode SET_ACTION_IS_INVALID = new ReturnCode(200, 0xfffca2ab, "set action is invalid");
    public static final ReturnCode SIGNATURE_FAILED = new ReturnCode(200, 0xfffc7c64, "signature failed");
    public static final ReturnCode SIGNATURE_VERIFY_FAILED = new ReturnCode(401, 0xfffc7c63, "signature verify failed");
    public static final ReturnCode STORAGEACCESS_TOKEN_IS_BLANK = new ReturnCode(403, 0xfffc7cc8, "storage access token is blank");
    public static final ReturnCode STORAGEACCESS_TOKEN_IS_EXPIRED = new ReturnCode(403, 0xfffc7cc7, "storage access token is expired");
    public static final ReturnCode STORAGEACCESS_TOKEN_IS_INVALID = new ReturnCode(403, 0xfffc7cc6, "storage access token is invalid");
    public static final ReturnCode SYSTEM_BUSY = new ReturnCode(200, 0xfffc561c, "system busy");
    public static final ReturnCode TABLE_ALREADY_EXISTS = new ReturnCode(200, 0xfffccbb0, "table already exists");
    public static final ReturnCode TABLE_DISABLED = new ReturnCode(200, 0xfffccbae, "table disabled");
    public static final ReturnCode TABLE_NAME_IS_BLANK = new ReturnCode(200, 0xfffca43a, "table name is blank");
    public static final ReturnCode TABLE_NAME_IS_INVALID = new ReturnCode(200, 0xfffca439, "table name is invalid");
    public static final ReturnCode TABLE_NAME_TOO_LONG = new ReturnCode(200, 0xfffca43b, "table name is too long");
    public static final ReturnCode TABLE_NOT_EXISTS = new ReturnCode(200, 0xfffccbaf, "table not exists");
    public static final ReturnCode TABLE_TYPE_IS_BLANK = new ReturnCode(200, 0xfffca437, "table type is blank");
    public static final ReturnCode TABLE_TYPE_IS_INVALID = new ReturnCode(200, 0xfffca438, "table type is invalid");
    public static final ReturnCode THROUGHPUT_EXCEEDED = new ReturnCode(200, 0xfffc561b, "throughput quota exceeded");
    public static final ReturnCode UNEXPECTED_NUMBER_OF_OPERANDS = new ReturnCode(200, 0xfffca310, "the number of operands is unexpected");
    public static final ReturnCode UNEXPECTED_NUMBER_OF_SIMPLE_CONDITIONS = new ReturnCode(200, 0xfffca30c, "the number of simple conditions is unexpected");
    public static final ReturnCode UNEXPECTED_OPERAND_TYPE = new ReturnCode(200, 0xfffca30f, "operand type is unexpected");
    public static final ReturnCode USER_ID_IS_BLANK = new ReturnCode(200, 0xfffca49b, "user id is blank");
    public static final ReturnCode USER_ID_IS_INVALID = new ReturnCode(401, 0xfffca49a, "user id is invalid");
    public static final ReturnCode USER_ID_IS_UNNECESSARY = new ReturnCode(401, 0xfffca499, "user id is unnecessary");
    private Result result;
    private int status;

    private ReturnCode(int i, int j, String s)
    {
        status = i;
        result = new Result(j, s);
    }

    public String getContent(String s, GalaxyMarshaller galaxymarshaller)
    {
        if (result == null)
        {
            return galaxymarshaller.marshall(RESPONSE_IS_BLANK);
        }
        if (StringUtils.isNotBlank(s))
        {
            Result result1 = new Result(result);
            result1.setMessage((new StringBuilder()).append(result.getMessage()).append("@").append(s).toString());
            return galaxymarshaller.marshall(result1);
        } else
        {
            return galaxymarshaller.marshall(result);
        }
    }

    public Result getResult()
    {
        return result;
    }

    public int getStatus()
    {
        return status;
    }

}
