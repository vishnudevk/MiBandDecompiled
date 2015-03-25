.class public Lcom/xiaomi/infra/galaxy/common/auth/MiSSOToken;
.super Ljava/lang/Object;


# instance fields
.field private security:Ljava/lang/String;

.field private serviceToken:Ljava/lang/String;

.field private userId:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/auth/MiSSOToken;->userId:Ljava/lang/String;

    iput-object p2, p0, Lcom/xiaomi/infra/galaxy/common/auth/MiSSOToken;->serviceToken:Ljava/lang/String;

    iput-object p3, p0, Lcom/xiaomi/infra/galaxy/common/auth/MiSSOToken;->security:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public getSecurity()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/auth/MiSSOToken;->security:Ljava/lang/String;

    return-object v0
.end method

.method public getServiceToken()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/auth/MiSSOToken;->serviceToken:Ljava/lang/String;

    return-object v0
.end method

.method public getUserId()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/auth/MiSSOToken;->userId:Ljava/lang/String;

    return-object v0
.end method

.method public setSecurity(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/auth/MiSSOToken;->security:Ljava/lang/String;

    return-void
.end method

.method public setServiceToken(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/auth/MiSSOToken;->serviceToken:Ljava/lang/String;

    return-void
.end method

.method public setUserId(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/auth/MiSSOToken;->userId:Ljava/lang/String;

    return-void
.end method
