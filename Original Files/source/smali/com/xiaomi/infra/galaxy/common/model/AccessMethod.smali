.class public final enum Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;

.field public static final enum AnonReadLoginWrite:Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;

.field public static final enum AnonReadOwnerWrite:Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;

.field public static final enum LoginReadLoginWrite:Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;

.field public static final enum LoginReadOwnerWrite:Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;


# instance fields
.field private value:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;

    const-string v1, "AnonReadOwnerWrite"

    const-string v2, "AnonReadOwnerWrite"

    invoke-direct {v0, v1, v3, v2}, Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;->AnonReadOwnerWrite:Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;

    const-string v1, "LoginReadOwnerWrite"

    const-string v2, "LoginReadOwnerWrite"

    invoke-direct {v0, v1, v4, v2}, Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;->LoginReadOwnerWrite:Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;

    const-string v1, "AnonReadLoginWrite"

    const-string v2, "AnonReadLoginWrite"

    invoke-direct {v0, v1, v5, v2}, Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;->AnonReadLoginWrite:Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;

    const-string v1, "LoginReadLoginWrite"

    const-string v2, "LoginReadLoginWrite"

    invoke-direct {v0, v1, v6, v2}, Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;->LoginReadLoginWrite:Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;

    const/4 v0, 0x4

    new-array v0, v0, [Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;->AnonReadOwnerWrite:Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;

    aput-object v1, v0, v3

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;->LoginReadOwnerWrite:Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;

    aput-object v1, v0, v4

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;->AnonReadLoginWrite:Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;

    aput-object v1, v0, v5

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;->LoginReadLoginWrite:Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;

    aput-object v1, v0, v6

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;->$VALUES:[Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    iput-object p3, p0, Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;->value:Ljava/lang/String;

    return-void
.end method

.method public static fromValue(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;
    .locals 3

    if-eqz p0, :cond_0

    const-string v0, ""

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->ACCESS_METHOD_IS_BLANK:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    const-string v2, "access method is blank"

    invoke-direct {v0, v1, v2}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v0

    :cond_1
    const-string v0, "AnonReadOwnerWrite"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;->AnonReadOwnerWrite:Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;

    :goto_0
    return-object v0

    :cond_2
    const-string v0, "LoginReadOwnerWrite"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;->LoginReadOwnerWrite:Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;

    goto :goto_0

    :cond_3
    const-string v0, "AnonReadLoginWrite"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;->AnonReadLoginWrite:Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;

    goto :goto_0

    :cond_4
    const-string v0, "LoginReadLoginWrite"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;->LoginReadLoginWrite:Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;

    goto :goto_0

    :cond_5
    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->ACCESS_METHOD_IS_INVALID:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    invoke-direct {v0, v1, p0}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v0
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;
    .locals 1

    const-class v0, Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;

    return-object v0
.end method

.method public static values()[Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;
    .locals 1

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;->$VALUES:[Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;

    invoke-virtual {v0}, [Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;

    return-object v0
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;->value:Ljava/lang/String;

    return-object v0
.end method
