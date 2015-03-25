.class public Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;
.super Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;


# static fields
.field private static final a:Ljava/lang/String; = "Chart.StatisticDaily"


# instance fields
.field private b:[Ljava/lang/String;

.field private c:[Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;-><init>()V

    return-void
.end method


# virtual methods
.method protected formatDate(Lcn/com/smartdevices/bracelet/model/SportDay;)Ljava/lang/String;
    .locals 5

    const/4 v4, 0x1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->mToday:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {p1, v0}, Lcn/com/smartdevices/bracelet/model/SportDay;->equals(Lcn/com/smartdevices/bracelet/model/SportDay;)Z

    move-result v0

    if-eqz v0, :cond_0

    const v0, 0x7f0d01b9

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p1, v4}, Lcn/com/smartdevices/bracelet/model/SportDay;->addDay(I)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->mToday:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/model/SportDay;->equals(Lcn/com/smartdevices/bracelet/model/SportDay;)Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/Locale;->toString()Ljava/lang/String;

    move-result-object v0

    sget-object v1, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v1}, Ljava/util/Locale;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    const v0, 0x7f0d005e

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_1
    new-instance v0, Ljava/text/SimpleDateFormat;

    const v1, 0x7f0d0055

    invoke-virtual {p0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    new-instance v1, Ljava/util/Date;

    invoke-direct {v1}, Ljava/util/Date;-><init>()V

    iget v2, p1, Lcn/com/smartdevices/bracelet/model/SportDay;->mon:I

    invoke-virtual {v1, v2}, Ljava/util/Date;->setMonth(I)V

    iget v2, p1, Lcn/com/smartdevices/bracelet/model/SportDay;->day:I

    invoke-virtual {v1, v2}, Ljava/util/Date;->setDate(I)V

    invoke-virtual {v0, v1}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v0

    const v1, 0x7f0d0057

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object v0, v2, v3

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->b:[Ljava/lang/String;

    invoke-virtual {p1}, Lcn/com/smartdevices/bracelet/model/SportDay;->getWeek()I

    move-result v3

    aget-object v0, v0, v3

    aput-object v0, v2, v4

    invoke-virtual {p0, v1, v2}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method protected formatDateShort(Lcn/com/smartdevices/bracelet/model/SportDay;)Ljava/lang/String;
    .locals 5

    const/4 v4, 0x1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->mToday:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {p1, v0}, Lcn/com/smartdevices/bracelet/model/SportDay;->equals(Lcn/com/smartdevices/bracelet/model/SportDay;)Z

    move-result v0

    if-eqz v0, :cond_0

    const v0, 0x7f0d01b9

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p1, v4}, Lcn/com/smartdevices/bracelet/model/SportDay;->addDay(I)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->mToday:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/model/SportDay;->equals(Lcn/com/smartdevices/bracelet/model/SportDay;)Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/Locale;->toString()Ljava/lang/String;

    move-result-object v0

    sget-object v1, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v1}, Ljava/util/Locale;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    const v0, 0x7f0d005e

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_1
    const v0, 0x7f0d0058

    const/4 v1, 0x3

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    iget v3, p1, Lcn/com/smartdevices/bracelet/model/SportDay;->mon:I

    add-int/lit8 v3, v3, 0x1

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    iget v2, p1, Lcn/com/smartdevices/bracelet/model/SportDay;->day:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v1, v4

    const/4 v2, 0x2

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->c:[Ljava/lang/String;

    invoke-virtual {p1}, Lcn/com/smartdevices/bracelet/model/SportDay;->getWeek()I

    move-result v4

    aget-object v3, v3, v4

    aput-object v3, v1, v2

    invoke-virtual {p0, v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2

    invoke-super {p0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    new-instance v0, Lcn/com/smartdevices/bracelet/chart/data/AsyncChartDataLoader;

    invoke-direct {v0}, Lcn/com/smartdevices/bracelet/chart/data/AsyncChartDataLoader;-><init>()V

    new-instance v1, Lcn/com/smartdevices/bracelet/chart/deprecated/u;

    invoke-direct {v1, p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/u;-><init>(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;)V

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;->setLoadCallback(Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->mActiveStatisticChart:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;

    invoke-virtual {v1, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->setDataLoader(Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->mActiveStatisticChart:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->loadData(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->mActiveStatisticChart:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->setScrollable(Z)V

    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2

    invoke-super {p0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->onCreate(Landroid/os/Bundle;)V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f07000d

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->b:[Ljava/lang/String;

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f07000e

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->c:[Ljava/lang/String;

    return-void
.end method

.method protected updateSleepAchievement(I)V
    .locals 2

    const v1, 0x7f0a014c

    sget v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->sMode:I

    and-int/lit8 v0, v0, 0x1

    if-lez v0, :cond_0

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->getView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    :goto_0
    return-void

    :cond_0
    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->getView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    invoke-super {p0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->updateSleepAchievement(I)V

    goto :goto_0
.end method

.method protected updateSleepRiseTime(I)V
    .locals 2

    const v1, 0x7f0a014a

    sget v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->sMode:I

    and-int/lit8 v0, v0, 0x1

    if-lez v0, :cond_0

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->getView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    :goto_0
    return-void

    :cond_0
    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->getView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    invoke-super {p0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->updateSleepRiseTime(I)V

    goto :goto_0
.end method

.method protected updateSleepStartTime(I)V
    .locals 2

    const v1, 0x7f0a0148

    sget v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->sMode:I

    and-int/lit8 v0, v0, 0x1

    if-lez v0, :cond_0

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->getView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    :goto_0
    return-void

    :cond_0
    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->getView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    invoke-super {p0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->updateSleepStartTime(I)V

    goto :goto_0
.end method

.method protected updateStepAchievement(I)V
    .locals 2

    const v1, 0x7f0a013d

    sget v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->sMode:I

    and-int/lit8 v0, v0, 0x1

    if-lez v0, :cond_0

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->getView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    :goto_0
    return-void

    :cond_0
    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->getView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    invoke-super {p0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->updateStepAchievement(I)V

    goto :goto_0
.end method

.method protected updateStepActiveTime(I)V
    .locals 0

    invoke-super {p0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->updateStepActiveTime(I)V

    return-void
.end method

.method protected updateStepContinueTime(I)V
    .locals 2

    const v1, 0x7f0a013a

    sget v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->sMode:I

    and-int/lit8 v0, v0, 0x1

    if-lez v0, :cond_0

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->getView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    :goto_0
    return-void

    :cond_0
    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->getView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    invoke-super {p0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->updateStepContinueTime(I)V

    goto :goto_0
.end method
