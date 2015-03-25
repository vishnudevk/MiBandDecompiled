.class public Lcom/xiaomi/infra/galaxy/common/auth/MiSSOSigner;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/xiaomi/infra/galaxy/common/auth/Signer;


# static fields
.field private static final miSSOSigner:Lcom/xiaomi/infra/galaxy/common/auth/MiSSOSigner;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/auth/MiSSOSigner;

    invoke-direct {v0}, Lcom/xiaomi/infra/galaxy/common/auth/MiSSOSigner;-><init>()V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/auth/MiSSOSigner;->miSSOSigner:Lcom/xiaomi/infra/galaxy/common/auth/MiSSOSigner;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getInstance()Lcom/xiaomi/infra/galaxy/common/auth/MiSSOSigner;
    .locals 1

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/auth/MiSSOSigner;->miSSOSigner:Lcom/xiaomi/infra/galaxy/common/auth/MiSSOSigner;

    return-object v0
.end method

.method private signature(Ljava/lang/String;Ljava/lang/String;Ljava/util/TreeMap;Ljava/lang/String;)Ljava/lang/String;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/TreeMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            ")",
            "Ljava/lang/String;"
        }
    .end annotation

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-static {p2}, Lcom/xiaomi/infra/galaxy/common/util/StringUtils;->isNotBlank(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "&"

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :cond_0
    if-eqz p3, :cond_2

    invoke-virtual {p3}, Ljava/util/TreeMap;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_2

    invoke-virtual {p3}, Ljava/util/TreeMap;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_1
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {p3, v0}, Ljava/util/TreeMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-static {v1}, Lcom/xiaomi/infra/galaxy/common/util/StringUtils;->isBlank(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_1

    const-string v4, "&"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, "="

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    :cond_2
    invoke-static {p4}, Lcom/xiaomi/infra/galaxy/common/util/StringUtils;->isNotBlank(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_3

    const-string v0, "&"

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :cond_3
    :try_start_0
    const-string v0, "SHA"

    invoke-static {v0}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v0

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->getBytes()[B

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/security/MessageDigest;->update([B)V

    invoke-virtual {v0}, Ljava/security/MessageDigest;->digest()[B

    move-result-object v0

    invoke-static {v0}, Lcom/xiaomi/infra/galaxy/common/util/Base64Utils;->encode([B)Ljava/lang/String;
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    :goto_1
    return-object v0

    :catch_0
    move-exception v0

    const-string v0, ""

    goto :goto_1
.end method


# virtual methods
.method public sign(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Lcom/xiaomi/infra/galaxy/common/auth/GalaxyCredentials;)V
    .locals 4

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getResourcePath()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/xiaomi/infra/galaxy/common/util/StringUtils;->isBlank(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "/"

    :goto_0
    invoke-interface {p2}, Lcom/xiaomi/infra/galaxy/common/auth/GalaxyCredentials;->getGalaxySecretKey()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/util/TreeMap;

    invoke-direct {v2}, Ljava/util/TreeMap;-><init>()V

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getParameters()Ljava/util/Map;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/TreeMap;->putAll(Ljava/util/Map;)V

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getHttpMethod()Lcom/xiaomi/infra/galaxy/common/HttpMethodName;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xiaomi/infra/galaxy/common/HttpMethodName;->name()Ljava/lang/String;

    move-result-object v3

    invoke-direct {p0, v3, v0, v2, v1}, Lcom/xiaomi/infra/galaxy/common/auth/MiSSOSigner;->signature(Ljava/lang/String;Ljava/lang/String;Ljava/util/TreeMap;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "signature"

    invoke-virtual {p1, v1, v0}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->addParameter(Ljava/lang/String;Ljava/lang/String;)V

    return-void

    :cond_0
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getResourcePath()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method
