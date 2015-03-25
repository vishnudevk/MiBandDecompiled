.class public Lcn/com/smartdevices/bracelet/analysis/StepsInfo;
.super Ljava/lang/Object;


# static fields
.field public static KEY_ACTIVITY_LIST:Ljava/lang/String; = null

.field public static KEY_CALORIES:Ljava/lang/String; = null

.field public static KEY_CONTINUS_ACTIVE_TIME:Ljava/lang/String; = null

.field public static KEY_DISTANCE:Ljava/lang/String; = null

.field public static KEY_STEPS:Ljava/lang/String; = null

.field public static KEY_STEP_INFO:Ljava/lang/String; = null

.field public static KEY_STEP_RUN_DISTANCE:Ljava/lang/String; = null

.field public static KEY_STEP_RUN_TIME:Ljava/lang/String; = null

.field public static KEY_STEP_WALK_TIME:Ljava/lang/String; = null

.field private static final a:Ljava/lang/String; = "StepsInfo"


# instance fields
.field private b:Lcn/com/smartdevices/bracelet/model/SportDay;

.field private c:I

.field private d:I

.field private e:I

.field private f:I

.field private g:I

.field private h:I

.field private i:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcn/com/smartdevices/bracelet/analysis/StageSteps;",
            ">;"
        }
    .end annotation
.end field

.field private j:I

.field private k:I

.field private l:I

.field private m:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcn/com/smartdevices/bracelet/analysis/ActiveItem;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const-string v0, "stp"

    sput-object v0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->KEY_STEP_INFO:Ljava/lang/String;

    const-string v0, "ttl"

    sput-object v0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->KEY_STEPS:Ljava/lang/String;

    const-string v0, "dis"

    sput-object v0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->KEY_DISTANCE:Ljava/lang/String;

    const-string v0, "cal"

    sput-object v0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->KEY_CALORIES:Ljava/lang/String;

    const-string v0, "conAct"

    sput-object v0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->KEY_CONTINUS_ACTIVE_TIME:Ljava/lang/String;

    const-string v0, "wk"

    sput-object v0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->KEY_STEP_WALK_TIME:Ljava/lang/String;

    const-string v0, "rn"

    sput-object v0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->KEY_STEP_RUN_TIME:Ljava/lang/String;

    const-string v0, "runDist"

    sput-object v0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->KEY_STEP_RUN_DISTANCE:Ljava/lang/String;

    const-string v0, "actives"

    sput-object v0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->KEY_ACTIVITY_LIST:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    const/4 v1, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->b:Lcn/com/smartdevices/bracelet/model/SportDay;

    iput v1, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->c:I

    iput v1, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->d:I

    iput v1, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->e:I

    iput v1, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->f:I

    iput v1, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->g:I

    iput v1, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->h:I

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->i:Ljava/util/ArrayList;

    const/4 v0, -0x1

    iput v0, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->j:I

    iput v1, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->k:I

    iput v1, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->l:I

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->m:Ljava/util/ArrayList;

    new-instance v0, Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-direct {v0}, Lcn/com/smartdevices/bracelet/model/SportDay;-><init>()V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->b:Lcn/com/smartdevices/bracelet/model/SportDay;

    return-void
.end method

.method public constructor <init>(Lcn/com/smartdevices/bracelet/model/SportDay;)V
    .locals 2

    const/4 v1, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->b:Lcn/com/smartdevices/bracelet/model/SportDay;

    iput v1, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->c:I

    iput v1, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->d:I

    iput v1, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->e:I

    iput v1, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->f:I

    iput v1, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->g:I

    iput v1, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->h:I

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->i:Ljava/util/ArrayList;

    const/4 v0, -0x1

    iput v0, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->j:I

    iput v1, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->k:I

    iput v1, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->l:I

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->m:Ljava/util/ArrayList;

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->b:Lcn/com/smartdevices/bracelet/model/SportDay;

    return-void
.end method


# virtual methods
.method public getActMinutes()I
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->k:I

    return v0
.end method

.method public getActiveList()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcn/com/smartdevices/bracelet/analysis/ActiveItem;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->m:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getCalories()I
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->h:I

    return v0
.end method

.method public getContinuesActive()I
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->l:I

    return v0
.end method

.method public getDistance()I
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->f:I

    return v0
.end method

.method public getRealtimeSteps()I
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->j:I

    return v0
.end method

.method public getRunDistance()I
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->g:I

    return v0
.end method

.method public getRunTimeCount()I
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->e:I

    return v0
.end method

.method public getSportDay()Lcn/com/smartdevices/bracelet/model/SportDay;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->b:Lcn/com/smartdevices/bracelet/model/SportDay;

    return-object v0
.end method

.method public getStageSteps()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcn/com/smartdevices/bracelet/analysis/StageSteps;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->i:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getStepsCount()I
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->c:I

    return v0
.end method

.method public getStepsTimeCount()I
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->d:I

    return v0
.end method

.method public getSummaryJson()Lorg/json/JSONObject;
    .locals 4

    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    :try_start_0
    sget-object v1, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->KEY_STEPS:Ljava/lang/String;

    iget v2, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->c:I

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    sget-object v1, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->KEY_DISTANCE:Ljava/lang/String;

    iget v2, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->f:I

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    sget-object v1, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->KEY_CALORIES:Ljava/lang/String;

    iget v2, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->h:I

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    sget-object v1, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->KEY_CONTINUS_ACTIVE_TIME:Ljava/lang/String;

    iget v2, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->l:I

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    sget-object v1, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->KEY_STEP_WALK_TIME:Ljava/lang/String;

    iget v2, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->d:I

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    sget-object v1, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->KEY_STEP_RUN_TIME:Ljava/lang/String;

    iget v2, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->e:I

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    sget-object v1, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->KEY_STEP_RUN_DISTANCE:Ljava/lang/String;

    iget v2, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->g:I

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;I)Lorg/json/JSONObject;

    const-string v1, "StepsInfo"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "rundist = "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget v3, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->g:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-object v0

    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method public setActMinutes(I)V
    .locals 0

    iput p1, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->k:I

    return-void
.end method

.method public setActiveList(Ljava/util/ArrayList;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcn/com/smartdevices/bracelet/analysis/ActiveItem;",
            ">;)V"
        }
    .end annotation

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->m:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->m:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    return-void
.end method

.method public setCalories(I)V
    .locals 0

    iput p1, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->h:I

    return-void
.end method

.method public setContinuesActive(I)V
    .locals 0

    iput p1, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->l:I

    return-void
.end method

.method public setDistance(I)V
    .locals 0

    iput p1, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->f:I

    return-void
.end method

.method public setRealtimeSteps(I)V
    .locals 0

    iput p1, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->j:I

    return-void
.end method

.method public setRunDistance(I)V
    .locals 0

    iput p1, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->g:I

    return-void
.end method

.method public setRunTimeCount(I)V
    .locals 0

    iput p1, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->e:I

    return-void
.end method

.method public setStageSteps(Ljava/util/ArrayList;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcn/com/smartdevices/bracelet/analysis/StageSteps;",
            ">;)V"
        }
    .end annotation

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->i:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->i:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    return-void
.end method

.method public setStepsCount(I)V
    .locals 0

    iput p1, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->c:I

    return-void
.end method

.method public setStepsTimeCount(I)V
    .locals 0

    iput p1, p0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->d:I

    return-void
.end method
