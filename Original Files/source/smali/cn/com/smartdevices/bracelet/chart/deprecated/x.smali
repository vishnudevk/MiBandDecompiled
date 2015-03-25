.class Lcn/com/smartdevices/bracelet/chart/deprecated/x;
.super Ljava/lang/Object;

# interfaces
.implements Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;


# instance fields
.field final synthetic a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/x;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public hasData(I)Z
    .locals 4

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/x;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;->mInitDay:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {v0, p1}, Lcn/com/smartdevices/bracelet/model/SportDay;->addWeek(I)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    const-string v1, "Chart.StatisticWeekly"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Has Week : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/x;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;

    invoke-virtual {v3, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;->formatDate(Lcn/com/smartdevices/bracelet/model/SportDay;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/model/SportDay;->getWeekStartDay()Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v1

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/x;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;

    iget-object v2, v2, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;->mStartDay:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {v2}, Lcn/com/smartdevices/bracelet/model/SportDay;->getWeekStartDay()Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcn/com/smartdevices/bracelet/model/SportDay;->before(Lcn/com/smartdevices/bracelet/model/SportDay;)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/model/SportDay;->getWeekStartDay()Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/x;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;

    iget-object v1, v1, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;->mStopDay:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/model/SportDay;->getWeekStartDay()Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/model/SportDay;->after(Lcn/com/smartdevices/bracelet/model/SportDay;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const-string v0, "Chart.StatisticWeekly"

    const-string v1, "False!!"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->w(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public loadData(I)Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$ItemData;
    .locals 12

    const/4 v0, 0x0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/x;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;

    iget-object v1, v1, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;->mInitDay:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {v1, p1}, Lcn/com/smartdevices/bracelet/model/SportDay;->addWeek(I)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v5

    const-string v1, "Chart.StatisticWeekly"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Load Week : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/x;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;

    invoke-virtual {v3, v5}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;->formatDate(Lcn/com/smartdevices/bracelet/model/SportDay;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v5}, Lcn/com/smartdevices/bracelet/model/SportDay;->getWeekStartDay()Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v6

    move v4, v0

    move v2, v0

    move v3, v0

    move v1, v0

    :goto_0
    const/4 v7, 0x7

    if-ge v4, v7, :cond_1

    invoke-virtual {v6, v4}, Lcn/com/smartdevices/bracelet/model/SportDay;->addDay(I)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v7

    const-string v8, "Chart.StatisticWeekly"

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "Load Day : "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v8, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/x;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;

    iget-object v8, v8, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;->mDataManager:Lcn/com/smartdevices/bracelet/DataManager;

    invoke-virtual {v8, v7}, Lcn/com/smartdevices/bracelet/DataManager;->getSummary(Lcn/com/smartdevices/bracelet/model/SportDay;)Lcn/com/smartdevices/bracelet/model/DaySportData$Summary;

    move-result-object v7

    const-string v8, "Chart.StatisticWeekly"

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "Summary : "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    if-eqz v7, :cond_2

    invoke-interface {v7}, Lcn/com/smartdevices/bracelet/model/DaySportData$Summary;->getSteps()I

    move-result v8

    if-lez v8, :cond_0

    invoke-interface {v7}, Lcn/com/smartdevices/bracelet/model/DaySportData$Summary;->getSteps()I

    move-result v8

    add-int/2addr v1, v8

    add-int/lit8 v0, v0, 0x1

    :cond_0
    invoke-interface {v7}, Lcn/com/smartdevices/bracelet/model/DaySportData$Summary;->getSleep()I

    move-result v8

    if-lez v8, :cond_2

    invoke-interface {v7}, Lcn/com/smartdevices/bracelet/model/DaySportData$Summary;->getSleep()I

    move-result v7

    mul-int/lit8 v7, v7, 0x64

    div-int/lit16 v7, v7, 0x1e0

    add-int/2addr v3, v7

    add-int/lit8 v2, v2, 0x1

    move v11, v2

    move v2, v3

    move v3, v1

    move v1, v0

    move v0, v11

    :goto_1
    add-int/lit8 v4, v4, 0x1

    move v11, v0

    move v0, v1

    move v1, v3

    move v3, v2

    move v2, v11

    goto :goto_0

    :cond_1
    iget-object v4, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/x;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;

    invoke-virtual {v4, v1, v3, v0, v2}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;->newStatisticChartData(IIII)Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld$StatisticChartData;

    move-result-object v0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/x;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;

    invoke-virtual {v1, v5}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;->formatDateShort(Lcn/com/smartdevices/bracelet/model/SportDay;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld$StatisticChartData;->date:Ljava/lang/String;

    return-object v0

    :cond_2
    move v11, v2

    move v2, v3

    move v3, v1

    move v1, v0

    move v0, v11

    goto :goto_1
.end method

.method public onDataLoaded(Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$ItemData;)V
    .locals 0

    return-void
.end method

.method public onToItem(I)V
    .locals 6

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/x;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;->mInitDay:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {v0, p1}, Lcn/com/smartdevices/bracelet/model/SportDay;->addWeek(I)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    const-string v1, "Chart.StatisticWeekly"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "To Week : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/x;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;

    invoke-virtual {v3, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;->formatDate(Lcn/com/smartdevices/bracelet/model/SportDay;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/x;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;

    iput-object v0, v1, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;->mCurrentDay:Lcn/com/smartdevices/bracelet/model/SportDay;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/x;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;

    invoke-virtual {v1, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;->updateDateTitle(Lcn/com/smartdevices/bracelet/model/SportDay;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/x;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;

    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;->cleanStatisticData()V

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/model/SportDay;->getWeekStartDay()Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v1

    const/4 v0, 0x0

    :goto_0
    const/4 v2, 0x7

    if-ge v0, v2, :cond_0

    invoke-virtual {v1, v0}, Lcn/com/smartdevices/bracelet/model/SportDay;->addDay(I)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v2

    const-string v3, "Chart.StatisticWeekly"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Load Day : "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/x;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;

    invoke-virtual {v3, v2}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;->totalStatisticData(Lcn/com/smartdevices/bracelet/model/SportDay;)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_0
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/x;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;->updateStatisticInfo()V

    return-void
.end method
