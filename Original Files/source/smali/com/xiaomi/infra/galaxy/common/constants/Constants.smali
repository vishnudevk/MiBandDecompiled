.class public Lcom/xiaomi/infra/galaxy/common/constants/Constants;
.super Ljava/lang/Object;


# static fields
.field public static final AK_CACHED_REQUEST:Ljava/lang/String; = "attr_cached_request"

.field public static final AK_REQUEST:Ljava/lang/String; = "attr_request"

.field public static final AK_TARGETACTION:Ljava/lang/String; = "attr_targetaction"

.field public static AttributeNamePattern:Ljava/util/regex/Pattern; = null

.field public static final CK_TRUSTSTORE:Ljava/lang/String; = "galaxy.truststore"

.field public static final CV_TRUSTSTORE_PASSWORD:Ljava/lang/String; = "galaxy"

.field public static final HK_ACCESS_METHOD:Ljava/lang/String; = "X-XiaoMi-Access-Method"

.field public static final HK_APPID:Ljava/lang/String; = "X-XiaoMi-Appid"

.field public static final HK_AUTHORIZATION:Ljava/lang/String; = "Authorization"

.field public static final HK_CONTENT_SHA256:Ljava/lang/String; = "X-XiaoMi-Content-Sha256"

.field public static final HK_CRC32:Ljava/lang/String; = "X-XiaoMi-Crc32"

.field public static final HK_DATE:Ljava/lang/String; = "X-XiaoMi-Date"

.field public static final HK_TARGET_ACTION:Ljava/lang/String; = "X-XiaoMi-Action"

.field public static final HK_TOKEN:Ljava/lang/String; = "X-XiaoMi-Token"

.field public static final HV_ANONYMOUS:Ljava/lang/String; = "anonymous"

.field public static final HV_APPSECRETTOKEN:Ljava/lang/String; = "appsecrettoken"

.field public static final HV_CONTENT_TYPE_JSON:Ljava/lang/String; = "application/x-xiaomi-json-1.0"

.field public static final HV_MISSO:Ljava/lang/String; = "misso"

.field public static final LIMIT_ATTRIBUTE_NAME_LENGTH:I = 0xff

.field public static final LIMIT_KEY_MAX_LENGTH:I = 0x400

.field public static final LIMIT_TABLE_NAME_LENGTH:I = 0xff

.field public static final PK_ACCESSTOKEN:Ljava/lang/String; = "accessToken"

.field public static final PK_APPID:Ljava/lang/String; = "appid"

.field public static final PK_OAUTHAPPID:Ljava/lang/String; = "oauth_appid"

.field public static final PK_OAUTHPROVIDER:Ljava/lang/String; = "oauth_provider"

.field public static final PK_OAUTHVERSION:Ljava/lang/String; = "oauth_version"

.field public static final PK_QQ_OAUTHTYPE:Ljava/lang/String; = "oauth_qq_oauth_type"

.field public static final PK_QQ_OPENID:Ljava/lang/String; = "oauth_qq_openid"

.field public static final PK_XIAOMI_MACALGORITHM:Ljava/lang/String; = "oauht_xiaomi_mac_algorithm"

.field public static final PK_XIAOMI_MACKEY:Ljava/lang/String; = "oauth_xiaomi_mackey"

.field public static final SERVICE_NAME:Ljava/lang/String; = "Galaxy"

.field public static final SK_CERTCHECKING:Ljava/lang/String; = "com.galaxy.sdk.disableCertChecking"

.field public static final SK_TRUSTSTORE:Ljava/lang/String; = "javax.net.ssl.trustStore"

.field public static final SK_TRUSTSTORE_PASSWORD:Ljava/lang/String; = "javax.net.ssl.trustStorePassword"

.field public static TableNamePattern:Ljava/util/regex/Pattern;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    const/4 v1, 0x2

    const-string v0, "^[a-z_]+[\\w_]*"

    invoke-static {v0, v1}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;I)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/constants/Constants;->TableNamePattern:Ljava/util/regex/Pattern;

    const-string v0, "^[a-z_]+[\\w_]*"

    invoke-static {v0, v1}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;I)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/constants/Constants;->AttributeNamePattern:Ljava/util/regex/Pattern;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method
