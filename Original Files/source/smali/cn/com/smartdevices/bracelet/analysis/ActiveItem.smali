.class public Lcn/com/smartdevices/bracelet/analysis/ActiveItem;
.super Ljava/lang/Object;


# static fields
.field public static final MODE_ACTIVE:I = 0x0

.field public static final MODE_RUN:I = 0x2

.field public static final MODE_WALK:I = 0x1


# instance fields
.field public activeTime:I

.field public calories:I

.field public dateString:Ljava/lang/String;

.field public distance:I

.field public flag:I

.field public mode:I

.field public runtime:I

.field public start:I

.field public steps:I

.field public stop:I


# direct methods
.method public constructor <init>()V
    .locals 1

    const/4 v0, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput v0, p0, Lcn/com/smartdevices/bracelet/analysis/ActiveItem;->start:I

    iput v0, p0, Lcn/com/smartdevices/bracelet/analysis/ActiveItem;->stop:I

    iput v0, p0, Lcn/com/smartdevices/bracelet/analysis/ActiveItem;->mode:I

    iput v0, p0, Lcn/com/smartdevices/bracelet/analysis/ActiveItem;->distance:I

    iput v0, p0, Lcn/com/smartdevices/bracelet/analysis/ActiveItem;->calories:I

    iput v0, p0, Lcn/com/smartdevices/bracelet/analysis/ActiveItem;->runtime:I

    iput v0, p0, Lcn/com/smartdevices/bracelet/analysis/ActiveItem;->steps:I

    iput v0, p0, Lcn/com/smartdevices/bracelet/analysis/ActiveItem;->flag:I

    iput v0, p0, Lcn/com/smartdevices/bracelet/analysis/ActiveItem;->activeTime:I

    const/4 v0, 0x0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/analysis/ActiveItem;->dateString:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public getActiveTime()I
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/analysis/ActiveItem;->activeTime:I

    return v0
.end method

.method public getCalories()I
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/analysis/ActiveItem;->calories:I

    return v0
.end method

.method public getDateString()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/analysis/ActiveItem;->dateString:Ljava/lang/String;

    return-object v0
.end method

.method public getDistance()I
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/analysis/ActiveItem;->distance:I

    return v0
.end method

.method public getMode()I
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/analysis/ActiveItem;->mode:I

    return v0
.end method

.method public getRuntime()I
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/analysis/ActiveItem;->runtime:I

    return v0
.end method

.method public getStart()I
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/analysis/ActiveItem;->start:I

    return v0
.end method

.method public getSteps()I
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/analysis/ActiveItem;->steps:I

    return v0
.end method

.method public getStop()I
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/analysis/ActiveItem;->stop:I

    return v0
.end method

.method public setActiveTime(I)V
    .locals 0

    iput p1, p0, Lcn/com/smartdevices/bracelet/analysis/ActiveItem;->activeTime:I

    return-void
.end method

.method public setCalories(I)V
    .locals 0

    iput p1, p0, Lcn/com/smartdevices/bracelet/analysis/ActiveItem;->calories:I

    return-void
.end method

.method public setDateString(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/analysis/ActiveItem;->dateString:Ljava/lang/String;

    return-void
.end method

.method public setDistance(I)V
    .locals 0

    iput p1, p0, Lcn/com/smartdevices/bracelet/analysis/ActiveItem;->distance:I

    return-void
.end method

.method public setMode(I)V
    .locals 0

    iput p1, p0, Lcn/com/smartdevices/bracelet/analysis/ActiveItem;->mode:I

    return-void
.end method

.method public setRuntime(I)V
    .locals 0

    iput p1, p0, Lcn/com/smartdevices/bracelet/analysis/ActiveItem;->runtime:I

    return-void
.end method

.method public setStart(I)V
    .locals 0

    iput p1, p0, Lcn/com/smartdevices/bracelet/analysis/ActiveItem;->start:I

    return-void
.end method

.method public setSteps(I)V
    .locals 0

    iput p1, p0, Lcn/com/smartdevices/bracelet/analysis/ActiveItem;->steps:I

    return-void
.end method

.method public setStop(I)V
    .locals 0

    iput p1, p0, Lcn/com/smartdevices/bracelet/analysis/ActiveItem;->stop:I

    return-void
.end method
