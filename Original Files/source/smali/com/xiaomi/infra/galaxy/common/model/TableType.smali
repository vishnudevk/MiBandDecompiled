.class public final enum Lcom/xiaomi/infra/galaxy/common/model/TableType;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/xiaomi/infra/galaxy/common/model/TableType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/xiaomi/infra/galaxy/common/model/TableType;

.field public static final enum APP:Lcom/xiaomi/infra/galaxy/common/model/TableType;

.field public static final enum USER:Lcom/xiaomi/infra/galaxy/common/model/TableType;


# instance fields
.field private value:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    const/4 v4, 0x1

    const/4 v3, 0x0

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/TableType;

    const-string v1, "USER"

    const-string v2, "USER"

    invoke-direct {v0, v1, v3, v2}, Lcom/xiaomi/infra/galaxy/common/model/TableType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/model/TableType;->USER:Lcom/xiaomi/infra/galaxy/common/model/TableType;

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/TableType;

    const-string v1, "APP"

    const-string v2, "APP"

    invoke-direct {v0, v1, v4, v2}, Lcom/xiaomi/infra/galaxy/common/model/TableType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/model/TableType;->APP:Lcom/xiaomi/infra/galaxy/common/model/TableType;

    const/4 v0, 0x2

    new-array v0, v0, [Lcom/xiaomi/infra/galaxy/common/model/TableType;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/model/TableType;->USER:Lcom/xiaomi/infra/galaxy/common/model/TableType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/model/TableType;->APP:Lcom/xiaomi/infra/galaxy/common/model/TableType;

    aput-object v1, v0, v4

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/model/TableType;->$VALUES:[Lcom/xiaomi/infra/galaxy/common/model/TableType;

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

    iput-object p3, p0, Lcom/xiaomi/infra/galaxy/common/model/TableType;->value:Ljava/lang/String;

    return-void
.end method

.method public static fromValue(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/TableType;
    .locals 2

    if-eqz p0, :cond_0

    const-string v0, ""

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->TABLE_TYPE_IS_BLANK:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    invoke-direct {v0, v1}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;)V

    throw v0

    :cond_1
    const-string v0, "USER"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/TableType;->USER:Lcom/xiaomi/infra/galaxy/common/model/TableType;

    :goto_0
    return-object v0

    :cond_2
    const-string v0, "APP"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/TableType;->APP:Lcom/xiaomi/infra/galaxy/common/model/TableType;

    goto :goto_0

    :cond_3
    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->TABLE_TYPE_IS_INVALID:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    invoke-direct {v0, v1, p0}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v0
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/TableType;
    .locals 1

    const-class v0, Lcom/xiaomi/infra/galaxy/common/model/TableType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/xiaomi/infra/galaxy/common/model/TableType;

    return-object v0
.end method

.method public static values()[Lcom/xiaomi/infra/galaxy/common/model/TableType;
    .locals 1

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/TableType;->$VALUES:[Lcom/xiaomi/infra/galaxy/common/model/TableType;

    invoke-virtual {v0}, [Lcom/xiaomi/infra/galaxy/common/model/TableType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/xiaomi/infra/galaxy/common/model/TableType;

    return-object v0
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/TableType;->value:Ljava/lang/String;

    return-object v0
.end method
