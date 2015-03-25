.class public Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;
.super Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;


# static fields
.field private static final a:Ljava/lang/String; = "Chart.StatisticWeekly"


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;-><init>()V

    return-void
.end method


# virtual methods
.method protected formatDate(Lcn/com/smartdevices/bracelet/model/SportDay;)Ljava/lang/String;
    .locals 9

    const v8, 0x7f0d0055

    const/4 v7, 0x2

    const/4 v6, 0x0

    const/4 v5, 0x1

    invoke-virtual {p1}, Lcn/com/smartdevices/bracelet/model/SportDay;->getWeekStartDay()Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;->mToday:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/model/SportDay;->getWeekStartDay()Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/model/SportDay;->equals(Lcn/com/smartdevices/bracelet/model/SportDay;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "\u672c\u5468"

    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p1, v5}, Lcn/com/smartdevices/bracelet/model/SportDay;->addWeek(I)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/model/SportDay;->getWeekStartDay()Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;->mToday:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/model/SportDay;->getWeekStartDay()Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/model/SportDay;->equals(Lcn/com/smartdevices/bracelet/model/SportDay;)Z

    move-result v0

    if-eqz v0, :cond_1

    const-string v0, "\u4e0a\u5468"

    goto :goto_0

    :cond_1
    invoke-virtual {p1}, Lcn/com/smartdevices/bracelet/model/SportDay;->getWeekStartDay()Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    const/4 v1, 0x6

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/model/SportDay;->addDay(I)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    new-array v3, v7, [Ljava/lang/Object;

    iget v4, v0, Lcn/com/smartdevices/bracelet/model/SportDay;->mon:I

    add-int/lit8 v4, v4, 0x1

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v6

    iget v0, v0, Lcn/com/smartdevices/bracelet/model/SportDay;->day:I

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    aput-object v0, v3, v5

    invoke-virtual {p0, v8, v3}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, " - "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    new-array v2, v7, [Ljava/lang/Object;

    iget v3, v1, Lcn/com/smartdevices/bracelet/model/SportDay;->mon:I

    add-int/lit8 v3, v3, 0x1

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v6

    iget v1, v1, Lcn/com/smartdevices/bracelet/model/SportDay;->day:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    aput-object v1, v2, v5

    invoke-virtual {p0, v8, v2}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method protected formatDateShort(Lcn/com/smartdevices/bracelet/model/SportDay;)Ljava/lang/String;
    .locals 9

    const v8, 0x7f0d0056

    const/4 v7, 0x2

    const/4 v6, 0x0

    const/4 v5, 0x1

    invoke-virtual {p1}, Lcn/com/smartdevices/bracelet/model/SportDay;->getWeekStartDay()Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;->mToday:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/model/SportDay;->getWeekStartDay()Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/model/SportDay;->equals(Lcn/com/smartdevices/bracelet/model/SportDay;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "\u672c\u5468"

    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p1, v5}, Lcn/com/smartdevices/bracelet/model/SportDay;->addWeek(I)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/model/SportDay;->getWeekStartDay()Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;->mToday:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/model/SportDay;->getWeekStartDay()Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/model/SportDay;->equals(Lcn/com/smartdevices/bracelet/model/SportDay;)Z

    move-result v0

    if-eqz v0, :cond_1

    const-string v0, "\u4e0a\u5468"

    goto :goto_0

    :cond_1
    invoke-virtual {p1}, Lcn/com/smartdevices/bracelet/model/SportDay;->getWeekStartDay()Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    const/4 v1, 0x6

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/model/SportDay;->addDay(I)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    new-array v3, v7, [Ljava/lang/Object;

    iget v4, v0, Lcn/com/smartdevices/bracelet/model/SportDay;->mon:I

    add-int/lit8 v4, v4, 0x1

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v6

    iget v0, v0, Lcn/com/smartdevices/bracelet/model/SportDay;->day:I

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    aput-object v0, v3, v5

    invoke-virtual {p0, v8, v3}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "-"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    new-array v2, v7, [Ljava/lang/Object;

    iget v3, v1, Lcn/com/smartdevices/bracelet/model/SportDay;->mon:I

    add-int/lit8 v3, v3, 0x1

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v6

    iget v1, v1, Lcn/com/smartdevices/bracelet/model/SportDay;->day:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    aput-object v1, v2, v5

    invoke-virtual {p0, v8, v2}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2

    invoke-super {p0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    new-instance v0, Lcn/com/smartdevices/bracelet/chart/data/AsyncChartDataLoader;

    invoke-direct {v0}, Lcn/com/smartdevices/bracelet/chart/data/AsyncChartDataLoader;-><init>()V

    new-instance v1, Lcn/com/smartdevices/bracelet/chart/deprecated/x;

    invoke-direct {v1, p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/x;-><init>(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;)V

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;->setLoadCallback(Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;->mActiveStatisticChart:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;

    invoke-virtual {v1, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->setDataLoader(Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;->mActiveStatisticChart:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->loadData(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;->mActiveStatisticChart:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->setScrollable(Z)V

    return-void
.end method

.method protected updateSleepAchievement(I)V
    .locals 2

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0a014c

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    return-void
.end method

.method protected updateSleepRiseTime(I)V
    .locals 2

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0a014a

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    return-void
.end method

.method protected updateSleepStartTime(I)V
    .locals 2

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0a0148

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    return-void
.end method

.method protected updateStepAchievement(I)V
    .locals 2

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0a013d

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-virtual {v1}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    :cond_0
    return-void
.end method

.method protected updateStepContinueTime(I)V
    .locals 2

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0a013a

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    return-void
.end method
