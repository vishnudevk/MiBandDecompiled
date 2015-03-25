.class Lcn/com/smartdevices/bracelet/chart/deprecated/u;
.super Ljava/lang/Object;

# interfaces
.implements Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;


# instance fields
.field final synthetic a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/u;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public hasData(I)Z
    .locals 4

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/u;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->mInitDay:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {v0, p1}, Lcn/com/smartdevices/bracelet/model/SportDay;->addDay(I)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    const-string v1, "Chart.StatisticDaily"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Has Day : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/u;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;

    iget-object v1, v1, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->mStartDay:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/model/SportDay;->before(Lcn/com/smartdevices/bracelet/model/SportDay;)Z

    move-result v1

    if-nez v1, :cond_0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/u;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;

    iget-object v1, v1, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->mStopDay:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/model/SportDay;->after(Lcn/com/smartdevices/bracelet/model/SportDay;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const-string v0, "Chart.StatisticDaily"

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
    .locals 5

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/u;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->mInitDay:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {v0, p1}, Lcn/com/smartdevices/bracelet/model/SportDay;->addDay(I)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    const-string v1, "Chart.StatisticDaily"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Load Day : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/u;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;

    iget-object v1, v1, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->mDataManager:Lcn/com/smartdevices/bracelet/DataManager;

    invoke-virtual {v1, v0}, Lcn/com/smartdevices/bracelet/DataManager;->getSummary(Lcn/com/smartdevices/bracelet/model/SportDay;)Lcn/com/smartdevices/bracelet/model/DaySportData$Summary;

    move-result-object v1

    const-string v2, "Chart.StatisticDaily"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Summary : "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v2, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld$StatisticChartData;

    invoke-direct {v2}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld$StatisticChartData;-><init>()V

    if-eqz v1, :cond_0

    invoke-interface {v1}, Lcn/com/smartdevices/bracelet/model/DaySportData$Summary;->getSteps()I

    move-result v3

    iput v3, v2, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld$StatisticChartData;->stepValue:I

    invoke-interface {v1}, Lcn/com/smartdevices/bracelet/model/DaySportData$Summary;->getSleep()I

    move-result v1

    mul-int/lit8 v1, v1, 0x64

    div-int/lit16 v1, v1, 0x1e0

    iput v1, v2, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld$StatisticChartData;->sleepValue:I

    :cond_0
    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/u;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;

    invoke-virtual {v1, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->formatDateShort(Lcn/com/smartdevices/bracelet/model/SportDay;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, v2, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld$StatisticChartData;->date:Ljava/lang/String;

    return-object v2
.end method

.method public onDataLoaded(Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$ItemData;)V
    .locals 0

    return-void
.end method

.method public onToItem(I)V
    .locals 4

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/u;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->mInitDay:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {v0, p1}, Lcn/com/smartdevices/bracelet/model/SportDay;->addDay(I)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    const-string v1, "Chart.StatisticDaily"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "To Day : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/u;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;

    iput-object v0, v1, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->mCurrentDay:Lcn/com/smartdevices/bracelet/model/SportDay;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/u;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/u;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;

    iget-object v2, v2, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->mCurrentDay:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {v1, v2}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->updateDateTitle(Lcn/com/smartdevices/bracelet/model/SportDay;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/u;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;

    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->cleanStatisticData()V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/u;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;

    iget-object v1, v1, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->mDataManager:Lcn/com/smartdevices/bracelet/DataManager;

    invoke-virtual {v1, v0}, Lcn/com/smartdevices/bracelet/DataManager;->getSummary(Lcn/com/smartdevices/bracelet/model/SportDay;)Lcn/com/smartdevices/bracelet/model/DaySportData$Summary;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/u;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;

    invoke-virtual {v1, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->totalStatisticDataStep(Lcn/com/smartdevices/bracelet/model/DaySportData$Summary;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/u;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;

    invoke-virtual {v1, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->totalStatisticDataSleep(Lcn/com/smartdevices/bracelet/model/DaySportData$Summary;)V

    :cond_0
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/u;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;->updateStatisticInfo()V

    return-void
.end method
