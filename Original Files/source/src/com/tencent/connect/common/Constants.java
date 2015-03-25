// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.common;


public class Constants
{

    public static final int ACTIVITY_CANCEL = 0;
    public static final int ACTIVITY_OK = -1;
    public static final String CANCEL_URI = "auth://cancel";
    public static final String CLOSE_URI = "auth://close";
    public static final int CODE_REQUEST_MAX = 6656;
    public static final int CODE_REQUEST_MIN = 5656;
    public static final String DEFAULT_PF = "openmobile_android";
    public static final String DOWNLOAD_URI = "download://";
    public static final int ERROR_CONNECTTIMEOUT = -7;
    public static final int ERROR_FILE_EXISTED = -11;
    public static final int ERROR_HTTPSTATUS_ERROR = -9;
    public static final int ERROR_IO = -2;
    public static final int ERROR_JSON = -4;
    public static final int ERROR_LOCATION_TIMEOUT = -13;
    public static final int ERROR_LOCATION_VERIFY_FAILED = -14;
    public static final int ERROR_NETWORK_UNAVAILABLE = -10;
    public static final int ERROR_NO_SDCARD = -12;
    public static final int ERROR_PARAM = -5;
    public static final int ERROR_SOCKETTIMEOUT = -8;
    public static final int ERROR_UNKNOWN = -6;
    public static final int ERROR_URL = -3;
    public static final String GRAPH_BASE = "https://openmobile.qq.com/";
    public static final String GRAPH_INTIMATE_FRIENDS = "friends/get_intimate_friends_weibo";
    public static final String GRAPH_NICK_TIPS = "friends/match_nick_tips_weibo";
    public static final String HTTP_GET = "GET";
    public static final String HTTP_POST = "POST";
    public static final String KEY_ACTION = "key_action";
    public static final String KEY_APP_NAME = "oauth_app_name";
    public static final String KEY_ERROR_CODE = "key_error_code";
    public static final String KEY_ERROR_DETAIL = "key_error_detail";
    public static final String KEY_ERROR_MSG = "key_error_msg";
    public static final String KEY_PARAMS = "key_params";
    public static final String KEY_REQUEST_CODE = "key_request_code";
    public static final String KEY_RESPONSE = "key_response";
    public static final String MOBILEQQ_PACKAGE_NAME = "com.tencent.mobileqq";
    public static final String MSG_CONNECTTIMEOUT_ERROR = "\u7F51\u7EDC\u8FDE\u63A5\u8D85\u65F6!";
    public static final String MSG_IMAGE_ERROR = "\u56FE\u7247\u8BFB\u53D6\u5931\u8D25\uFF0C\u8BF7\u68C0\u67E5\u8BE5\u56FE\u7247\u662F\u5426\u6709\u6548";
    public static final String MSG_IO_ERROR = "\u7F51\u7EDC\u8FDE\u63A5\u5F02\u5E38\uFF0C\u8BF7\u68C0\u67E5\u540E\u91CD\u8BD5!";
    public static final String MSG_JSON_ERROR = "\u670D\u52A1\u5668\u8FD4\u56DE\u6570\u636E\u683C\u5F0F\u6709\u8BEF!";
    public static final String MSG_LOCATION_TIMEOUT_ERROR = "\u5B9A\u4F4D\u8D85\u65F6\uFF0C\u8BF7\u7A0D\u540E\u518D\u8BD5\u6216\u68C0\u67E5\u7F51\u7EDC\u72B6\u51B5\uFF01";
    public static final String MSG_LOCATION_VERIFY_ERROR = "\u5B9A\u4F4D\u5931\u8D25\uFF0C\u9A8C\u8BC1\u5B9A\u4F4D\u7801\u9519\u8BEF\uFF01";
    public static final String MSG_NO_SDCARD = "\u68C0\u6D4B\u4E0D\u5230SD\u5361\uFF0C\u65E0\u6CD5\u53D1\u9001\u8BED\u97F3\uFF01";
    public static final String MSG_OPEN_BROWSER_ERROR = "\u6253\u5F00\u6D4F\u89C8\u5668\u5931\u8D25!";
    public static final String MSG_PARAM_ERROR = "\u4F20\u5165\u53C2\u6570\u6709\u8BEF!";
    public static final String MSG_PARAM_IMAGE_ERROR = "\u7EAF\u56FE\u5206\u4EAB\uFF0CimageUrl \u4E0D\u80FD\u4E3A\u7A7A";
    public static final String MSG_PARAM_IMAGE_URL_FORMAT_ERROR = "\u975E\u6CD5\u7684\u56FE\u7247\u5730\u5740!";
    public static final String MSG_PARAM_IMAGE_URL_MUST_BE_LOCAL = "\u624BQ\u7248\u672C\u8FC7\u4F4E\uFF0C\u7EAF\u56FE\u5206\u4EAB\u4E0D\u652F\u6301\u7F51\u8DEF\u56FE\u7247";
    public static final String MSG_PARAM_NULL_ERROR = "\u4F20\u5165\u53C2\u6570\u4E0D\u53EF\u4EE5\u4E3A\u7A7A";
    public static final String MSG_PARAM_QQ_VERSION_ERROR = "\u4F4E\u7248\u672C\u624BQ\u4E0D\u652F\u6301\u8BE5\u9879\u529F\u80FD!";
    public static final String MSG_PARAM_TARGETURL_ERROR = "targetUrl\u6709\u8BEF";
    public static final String MSG_PARAM_TARGETURL_NULL_ERROR = "targetUrl\u4E3A\u5FC5\u586B\u9879\uFF0C\u8BF7\u8865\u5145\u540E\u5206\u4EAB";
    public static final String MSG_PARAM_TITLE_NULL_ERROR = "title\u4E0D\u80FD\u4E3A\u7A7A!";
    public static final String MSG_SHARE_GETIMG_ERROR = "\u83B7\u53D6\u5206\u4EAB\u56FE\u7247\u5931\u8D25!";
    public static final String MSG_SHARE_NOSD_ERROR = "\u5206\u4EAB\u56FE\u7247\u5931\u8D25\uFF0C\u68C0\u6D4B\u4E0D\u5230SD\u5361!";
    public static final String MSG_SHARE_TO_QQ_ERROR = "\u5206\u4EAB\u7684\u624B\u673AQQ\u5931\u8D25!";
    public static final String MSG_SHARE_TYPE_ERROR = "\u6682\u4E0D\u652F\u6301\u7EAF\u56FE\u7247\u5206\u4EAB\u5230\u7A7A\u95F4\uFF0C\u5EFA\u8BAE\u4F7F\u7528\u56FE\u6587\u5206\u4EAB";
    public static final String MSG_SOCKETTIMEOUT_ERROR = "\u7F51\u7EDC\u8FDE\u63A5\u8D85\u65F6!";
    public static final String MSG_UNKNOWN_ERROR = "\u672A\u77E5\u9519\u8BEF!";
    public static final String MSG_URL_ERROR = "\u8BBF\u95EEurl\u6709\u8BEF!";
    public static String PACKAGE_QQ = "com.tencent.mobileqq";
    public static String PACKAGE_QZONE = "com.qzone";
    public static final String PARAM_ACCESS_TOKEN = "access_token";
    public static final String PARAM_APP_ID = "appid";
    public static final String PARAM_CLIENT_ID = "client_id";
    public static final String PARAM_CONSUMER_KEY = "oauth_consumer_key";
    public static final String PARAM_EXPIRES_IN = "expires_in";
    public static final String PARAM_HOPEN_ID = "hopenid";
    public static final String PARAM_KEY_STR = "keystr";
    public static final String PARAM_KEY_TYPE = "keytype";
    public static final String PARAM_OPEN_ID = "openid";
    public static final String PARAM_PLATFORM = "platform";
    public static final String PARAM_PLATFORM_ID = "pf";
    public static final String PARAM_SCOPE = "scope";
    public static final String PREFERENCE_PF = "pfStore";
    public static final String SDK_BUILD = "1171";
    public static final String SDK_QUA = "V1_AND_OpenSDK_2.1_1077_RDM_B";
    public static final String SDK_VERSION = "2.1";
    public static final String SDK_VERSION_STRING = "Android_SDK_2.1";
    public static String SIGNATRUE_QZONE = "ec96e9ac1149251acbb1b0c5777cae95";
    public static final String SOURCE_QQ = "QQ";
    public static final String SOURCE_QZONE = "qzone";
    public static final int UI_ACTIVITY = 1;
    public static final int UI_CHECK_TOKEN = 3;
    public static final int UI_DIALOG = 2;
    public static final int UI_NONE = -1;

    public Constants()
    {
    }

}
