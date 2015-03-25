.class public Lcom/xiaomi/infra/galaxy/common/auth/AnonymousGalaxyCredentials;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/xiaomi/infra/galaxy/common/auth/GalaxyCredentials;


# instance fields
.field private galaxyAppId:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/auth/AnonymousGalaxyCredentials;->galaxyAppId:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public getGalaxyAppId()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/auth/AnonymousGalaxyCredentials;->galaxyAppId:Ljava/lang/String;

    return-object v0
.end method

.method public getGalaxySecretKey()Ljava/lang/String;
    .locals 1

    const/4 v0, 0x0

    return-object v0
.end method
