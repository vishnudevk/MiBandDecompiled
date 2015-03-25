// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.constants;

import java.util.regex.Pattern;

public class Constants
{

    public static final String AK_CACHED_REQUEST = "attr_cached_request";
    public static final String AK_REQUEST = "attr_request";
    public static final String AK_TARGETACTION = "attr_targetaction";
    public static Pattern AttributeNamePattern = Pattern.compile("^[a-z_]+[\\w_]*", 2);
    public static final String CK_TRUSTSTORE = "galaxy.truststore";
    public static final String CV_TRUSTSTORE_PASSWORD = "galaxy";
    public static final String HK_ACCESS_METHOD = "X-XiaoMi-Access-Method";
    public static final String HK_APPID = "X-XiaoMi-Appid";
    public static final String HK_AUTHORIZATION = "Authorization";
    public static final String HK_CONTENT_SHA256 = "X-XiaoMi-Content-Sha256";
    public static final String HK_CRC32 = "X-XiaoMi-Crc32";
    public static final String HK_DATE = "X-XiaoMi-Date";
    public static final String HK_TARGET_ACTION = "X-XiaoMi-Action";
    public static final String HK_TOKEN = "X-XiaoMi-Token";
    public static final String HV_ANONYMOUS = "anonymous";
    public static final String HV_APPSECRETTOKEN = "appsecrettoken";
    public static final String HV_CONTENT_TYPE_JSON = "application/x-xiaomi-json-1.0";
    public static final String HV_MISSO = "misso";
    public static final int LIMIT_ATTRIBUTE_NAME_LENGTH = 255;
    public static final int LIMIT_KEY_MAX_LENGTH = 1024;
    public static final int LIMIT_TABLE_NAME_LENGTH = 255;
    public static final String PK_ACCESSTOKEN = "accessToken";
    public static final String PK_APPID = "appid";
    public static final String PK_OAUTHAPPID = "oauth_appid";
    public static final String PK_OAUTHPROVIDER = "oauth_provider";
    public static final String PK_OAUTHVERSION = "oauth_version";
    public static final String PK_QQ_OAUTHTYPE = "oauth_qq_oauth_type";
    public static final String PK_QQ_OPENID = "oauth_qq_openid";
    public static final String PK_XIAOMI_MACALGORITHM = "oauht_xiaomi_mac_algorithm";
    public static final String PK_XIAOMI_MACKEY = "oauth_xiaomi_mackey";
    public static final String SERVICE_NAME = "Galaxy";
    public static final String SK_CERTCHECKING = "com.galaxy.sdk.disableCertChecking";
    public static final String SK_TRUSTSTORE = "javax.net.ssl.trustStore";
    public static final String SK_TRUSTSTORE_PASSWORD = "javax.net.ssl.trustStorePassword";
    public static Pattern TableNamePattern = Pattern.compile("^[a-z_]+[\\w_]*", 2);

    public Constants()
    {
    }

}
