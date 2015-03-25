.class public Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;
.super Landroid/app/Fragment;


# static fields
.field public static sRefreshHander:Landroid/os/Handler;


# instance fields
.field private a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;

.field private b:Landroid/view/GestureDetector;

.field private c:Lcn/com/smartdevices/bracelet/DataManager;

.field private d:Lcn/com/smartdevices/bracelet/model/SportDay;

.field private e:Lcn/com/smartdevices/bracelet/model/SportDay;

.field private f:Lcn/com/smartdevices/bracelet/model/SportDay;

.field private g:Lcn/com/smartdevices/bracelet/model/SportDay;

.field private h:Lcn/com/smartdevices/bracelet/model/SportDay;


# direct methods
.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    invoke-static {}, Lcn/com/smartdevices/bracelet/DataManager;->getInstance()Lcn/com/smartdevices/bracelet/DataManager;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->c:Lcn/com/smartdevices/bracelet/DataManager;

    return-void
.end method

.method static synthetic a(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;Lcn/com/smartdevices/bracelet/model/DaySportData;)Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartData;
    .locals 1

    invoke-direct {p0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->a(Lcn/com/smartdevices/bracelet/model/DaySportData;)Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartData;

    move-result-object v0

    return-object v0
.end method

.method private a(Lcn/com/smartdevices/bracelet/model/DaySportData;)Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartData;
    .locals 11

    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    invoke-virtual {p1}, Lcn/com/smartdevices/bracelet/model/DaySportData;->getAnalysisData()Ljava/util/ArrayList;

    move-result-object v4

    const/4 v2, -0x1

    const/4 v3, -0x1

    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v9

    move v4, v2

    move-object v2, v0

    :goto_0
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_5

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/model/SportData;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/model/SportData;->getSportMode()I

    move-result v6

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/model/SportData;->getStep()I

    move-result v10

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/model/SportData;->getTimeIndex()I

    move-result v0

    if-ne v4, v6, :cond_0

    const/16 v5, 0x59f

    if-ne v0, v5, :cond_7

    :cond_0
    if-eqz v2, :cond_6

    iget v4, v2, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartSleepData;->index:I

    sub-int v4, v0, v4

    iput v4, v2, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartSleepData;->length:I

    const/4 v4, 0x0

    :goto_1
    const/4 v2, 0x4

    if-eq v6, v2, :cond_1

    const/4 v2, 0x5

    if-eq v6, v2, :cond_1

    const/4 v2, 0x7

    if-ne v6, v2, :cond_2

    :cond_1
    new-instance v4, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartSleepData;

    invoke-direct {v4}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartSleepData;-><init>()V

    invoke-virtual {v7, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    iput v0, v4, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartSleepData;->index:I

    packed-switch v6, :pswitch_data_0

    :cond_2
    :pswitch_0
    move v5, v6

    :goto_2
    const/16 v2, 0x7e

    if-eq v6, v2, :cond_4

    const/16 v2, 0x7f

    if-eq v6, v2, :cond_4

    const/4 v2, 0x4

    if-eq v6, v2, :cond_4

    const/4 v2, 0x5

    if-eq v6, v2, :cond_4

    const/4 v2, 0x7

    if-eq v6, v2, :cond_4

    if-lez v10, :cond_4

    div-int/lit8 v2, v0, 0x3c

    if-eq v2, v3, :cond_3

    new-instance v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartStepData;

    invoke-direct {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartStepData;-><init>()V

    invoke-virtual {v8, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    iput v2, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartStepData;->index:I

    iput v10, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartStepData;->step:I

    move v1, v2

    :goto_3
    move-object v2, v4

    move v3, v1

    move-object v1, v0

    move v4, v5

    goto :goto_0

    :pswitch_1
    const/4 v2, 0x2

    iput v2, v4, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartSleepData;->mode:I

    move v5, v6

    goto :goto_2

    :pswitch_2
    const/4 v2, 0x3

    iput v2, v4, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartSleepData;->mode:I

    move v5, v6

    goto :goto_2

    :pswitch_3
    const/4 v2, 0x1

    iput v2, v4, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartSleepData;->mode:I

    move v5, v6

    goto :goto_2

    :cond_3
    iget v0, v1, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartStepData;->step:I

    add-int/2addr v0, v10

    iput v0, v1, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartStepData;->step:I

    :cond_4
    move-object v0, v1

    move v1, v3

    goto :goto_3

    :cond_5
    new-instance v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartData;

    invoke-direct {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartData;-><init>()V

    iput-object v7, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartData;->sleepData:Ljava/util/List;

    iput-object v8, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartData;->stepData:Ljava/util/List;

    return-object v0

    :cond_6
    move-object v4, v2

    goto :goto_1

    :cond_7
    move v5, v4

    move-object v4, v2

    goto :goto_2

    nop

    :pswitch_data_0
    .packed-switch 0x4
        :pswitch_1
        :pswitch_2
        :pswitch_0
        :pswitch_3
    .end packed-switch
.end method

.method static synthetic a(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/model/SportDay;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->g:Lcn/com/smartdevices/bracelet/model/SportDay;

    return-object v0
.end method

.method static synthetic a(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;Lcn/com/smartdevices/bracelet/model/SportDay;)Lcn/com/smartdevices/bracelet/model/SportDay;
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->e:Lcn/com/smartdevices/bracelet/model/SportDay;

    return-object p1
.end method

.method private a(I)Ljava/lang/String;
    .locals 3

    div-int/lit8 v0, p1, 0x3c

    rem-int/lit8 v1, p1, 0x3c

    const-string v2, ""

    if-nez v0, :cond_0

    if-nez v1, :cond_0

    const-string v0, "00:00"

    :goto_0
    return-object v0

    :cond_0
    const/16 v2, 0xa

    if-ge v1, v2, :cond_1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ":0"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_1
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ":"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private a(Lcn/com/smartdevices/bracelet/model/SportDay;)Ljava/lang/String;
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget v1, p1, Lcn/com/smartdevices/bracelet/model/SportDay;->mon:I

    add-int/lit8 v1, v1, 0x1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "."

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p1, Lcn/com/smartdevices/bracelet/model/SportDay;->day:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic b(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/model/SportDay;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->e:Lcn/com/smartdevices/bracelet/model/SportDay;

    return-object v0
.end method

.method static synthetic b(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;Lcn/com/smartdevices/bracelet/model/SportDay;)Ljava/lang/String;
    .locals 1

    invoke-direct {p0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->a(Lcn/com/smartdevices/bracelet/model/SportDay;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic c(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/model/SportDay;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->h:Lcn/com/smartdevices/bracelet/model/SportDay;

    return-object v0
.end method

.method static synthetic c(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;Lcn/com/smartdevices/bracelet/model/SportDay;)Lcn/com/smartdevices/bracelet/model/SportDay;
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->d:Lcn/com/smartdevices/bracelet/model/SportDay;

    return-object p1
.end method

.method static synthetic d(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Landroid/view/GestureDetector;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->b:Landroid/view/GestureDetector;

    return-object v0
.end method

.method static synthetic d(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;Lcn/com/smartdevices/bracelet/model/SportDay;)Lcn/com/smartdevices/bracelet/model/SportDay;
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->f:Lcn/com/smartdevices/bracelet/model/SportDay;

    return-object p1
.end method

.method static synthetic e(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/DataManager;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->c:Lcn/com/smartdevices/bracelet/DataManager;

    return-object v0
.end method

.method static synthetic e(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;Lcn/com/smartdevices/bracelet/model/SportDay;)Lcn/com/smartdevices/bracelet/model/SportDay;
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->g:Lcn/com/smartdevices/bracelet/model/SportDay;

    return-object p1
.end method

.method static synthetic f(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/model/SportDay;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->d:Lcn/com/smartdevices/bracelet/model/SportDay;

    return-object v0
.end method

.method static synthetic f(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;Lcn/com/smartdevices/bracelet/model/SportDay;)Lcn/com/smartdevices/bracelet/model/SportDay;
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->h:Lcn/com/smartdevices/bracelet/model/SportDay;

    return-object p1
.end method

.method static synthetic g(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;

    return-object v0
.end method

.method static synthetic h(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/model/SportDay;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->f:Lcn/com/smartdevices/bracelet/model/SportDay;

    return-object v0
.end method

.method public static valueToTime(I)Ljava/lang/String;
    .locals 3

    div-int/lit8 v0, p0, 0x3c

    rem-int/lit8 v1, p0, 0x3c

    const-string v2, ""

    if-nez v0, :cond_0

    if-nez v1, :cond_0

    const-string v0, "00:00"

    :goto_0
    return-object v0

    :cond_0
    const/16 v2, 0xa

    if-ge v1, v2, :cond_1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ":0"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_1
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ":"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method


# virtual methods
.method protected formatTime(II)Ljava/lang/String;
    .locals 2

    const-string v0, ""

    if-nez p1, :cond_0

    if-nez p2, :cond_0

    const-string v0, "00:00"

    :goto_0
    return-object v0

    :cond_0
    const/16 v0, 0xa

    if-ge p2, v0, :cond_1

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ":0"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_1
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method protected formatTimeHourMin(I)[Ljava/lang/String;
    .locals 4

    div-int/lit8 v0, p1, 0x3c

    rem-int/lit8 v1, p1, 0x3c

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/String;

    if-lez v0, :cond_0

    const/4 v3, 0x0

    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    aput-object v0, v2, v3

    :cond_0
    const/4 v0, 0x1

    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v2, v0

    return-object v2
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 5

    const/4 v4, 0x0

    const v0, 0x7f030020

    invoke-virtual {p1, v0, p2, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    const v0, 0x7f0a00a7

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;

    new-instance v0, Landroid/view/GestureDetector;

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->getActivity()Landroid/app/Activity;

    move-result-object v2

    new-instance v3, Lcn/com/smartdevices/bracelet/chart/deprecated/i;

    invoke-direct {v3, p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/i;-><init>(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)V

    invoke-direct {v0, v2, v3}, Landroid/view/GestureDetector;-><init>(Landroid/content/Context;Landroid/view/GestureDetector$OnGestureListener;)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->b:Landroid/view/GestureDetector;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;

    new-instance v2, Lcn/com/smartdevices/bracelet/chart/deprecated/j;

    invoke-direct {v2, p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/j;-><init>(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)V

    invoke-virtual {v0, v2}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    new-instance v0, Lcn/com/smartdevices/bracelet/chart/data/AsyncChartDataLoader;

    invoke-direct {v0}, Lcn/com/smartdevices/bracelet/chart/data/AsyncChartDataLoader;-><init>()V

    new-instance v2, Lcn/com/smartdevices/bracelet/chart/deprecated/k;

    invoke-direct {v2, p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/k;-><init>(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)V

    invoke-virtual {v0, v2}, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;->setLoadCallback(Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;)V

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;

    invoke-virtual {v2, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->setDataLoader(Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;

    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->setScrollable(Z)V

    new-instance v0, Lcn/com/smartdevices/bracelet/chart/deprecated/l;

    invoke-direct {v0, p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/l;-><init>(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)V

    sput-object v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->sRefreshHander:Landroid/os/Handler;

    sget-object v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->sRefreshHander:Landroid/os/Handler;

    invoke-virtual {v0, v4}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    return-object v1
.end method
