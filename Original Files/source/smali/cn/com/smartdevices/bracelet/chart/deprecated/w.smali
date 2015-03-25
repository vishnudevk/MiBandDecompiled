.class Lcn/com/smartdevices/bracelet/chart/deprecated/w;
.super Ljava/lang/Object;

# interfaces
.implements Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;


# instance fields
.field final synthetic a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/w;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public hasData(I)Z
    .locals 4

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/w;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;->mInitDay:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {v0, p1}, Lcn/com/smartdevices/bracelet/model/SportDay;->addMonth(I)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    const-string v1, "Chart.StatisticMonthly"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Has Month : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/w;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;

    invoke-virtual {v3, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;->formatDate(Lcn/com/smartdevices/bracelet/model/SportDay;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/model/SportDay;->getMonthStartDay()Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v1

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/w;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;

    iget-object v2, v2, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;->mStartDay:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {v2}, Lcn/com/smartdevices/bracelet/model/SportDay;->getMonthStartDay()Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcn/com/smartdevices/bracelet/model/SportDay;->before(Lcn/com/smartdevices/bracelet/model/SportDay;)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/model/SportDay;->getMonthStartDay()Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/w;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;

    iget-object v1, v1, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;->mStopDay:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/model/SportDay;->getMonthStartDay()Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/model/SportDay;->after(Lcn/com/smartdevices/bracelet/model/SportDay;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const-string v0, "Chart.StatisticMonthly"

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

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/w;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;

    iget-object v1, v1, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;->mInitDay:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {v1, p1}, Lcn/com/smartdevices/bracelet/model/SportDay;->addMonth(I)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v5

    const-string v1, "Chart.StatisticMonthly"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Load Month : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/w;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;

    invoke-virtual {v3, v5}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;->formatDate(Lcn/com/smartdevices/bracelet/model/SportDay;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v5}, Lcn/com/smartdevices/bracelet/model/SportDay;->getMonthStartDay()Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v6

    invoke-virtual {v5}, Lcn/com/smartdevices/bracelet/model/SportDay;->getMonthEndDay()Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v7

    const-string v1, "Chart.StatisticMonthly"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "~"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    move v1, v0

    move v2, v0

    move v3, v0

    move v4, v0

    :goto_0
    iget v8, v7, Lcn/com/smartdevices/bracelet/model/SportDay;->day:I

    if-ge v0, v8, :cond_2

    invoke-virtual {v6, v0}, Lcn/com/smartdevices/bracelet/model/SportDay;->addDay(I)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v8

    const-string v9, "Chart.StatisticMonthly"

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "Load Day : "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v9, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/w;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;

    iget-object v9, v9, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;->mDataManager:Lcn/com/smartdevices/bracelet/DataManager;

    invoke-virtual {v9, v8}, Lcn/com/smartdevices/bracelet/DataManager;->getSummary(Lcn/com/smartdevices/bracelet/model/SportDay;)Lcn/com/smartdevices/bracelet/model/DaySportData$Summary;

    move-result-object v8

    const-string v9, "Chart.StatisticMonthly"

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "Summary : "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    if-eqz v8, :cond_1

    invoke-interface {v8}, Lcn/com/smartdevices/bracelet/model/DaySportData$Summary;->getSteps()I

    move-result v9

    if-lez v9, :cond_0

    invoke-interface {v8}, Lcn/com/smartdevices/bracelet/model/DaySportData$Summary;->getSteps()I

    move-result v9

    add-int/2addr v4, v9

    add-int/lit8 v2, v2, 0x1

    :cond_0
    invoke-interface {v8}, Lcn/com/smartdevices/bracelet/model/DaySportData$Summary;->getSleep()I

    move-result v9

    if-lez v9, :cond_1

    invoke-interface {v8}, Lcn/com/smartdevices/bracelet/model/DaySportData$Summary;->getSleep()I

    move-result v8

    mul-int/lit8 v8, v8, 0x64

    div-int/lit16 v8, v8, 0x1e0

    add-int/2addr v3, v8

    add-int/lit8 v1, v1, 0x1

    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_2
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/w;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;

    invoke-virtual {v0, v4, v3, v2, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;->newStatisticChartData(IIII)Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld$StatisticChartData;

    move-result-object v0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/w;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;

    invoke-virtual {v1, v5}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;->formatDateShort(Lcn/com/smartdevices/bracelet/model/SportDay;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld$StatisticChartData;->date:Ljava/lang/String;

    return-object v0
.end method

.method public onDataLoaded(Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$ItemData;)V
    .locals 0

    return-void
.end method

.method public onToItem(I)V
    .locals 7

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/w;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;->mInitDay:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {v0, p1}, Lcn/com/smartdevices/bracelet/model/SportDay;->addMonth(I)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    const-string v1, "Chart.StatisticMonthly"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "To Month : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/w;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;

    invoke-virtual {v3, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;->formatDate(Lcn/com/smartdevices/bracelet/model/SportDay;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/w;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;

    iput-object v0, v1, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;->mCurrentDay:Lcn/com/smartdevices/bracelet/model/SportDay;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/w;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/w;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;

    iget-object v2, v2, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;->mCurrentDay:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {v1, v2}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;->updateDateTitle(Lcn/com/smartdevices/bracelet/model/SportDay;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/w;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;

    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;->cleanStatisticData()V

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/model/SportDay;->getMonthStartDay()Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v1

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/model/SportDay;->getMonthEndDay()Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v2

    const-string v0, "Chart.StatisticMonthly"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "~"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v3}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v0, 0x0

    :goto_0
    iget v3, v2, Lcn/com/smartdevices/bracelet/model/SportDay;->day:I

    if-ge v0, v3, :cond_0

    invoke-virtual {v1, v0}, Lcn/com/smartdevices/bracelet/model/SportDay;->addDay(I)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v3

    const-string v4, "Chart.StatisticMonthly"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Load Day : "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v4, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/w;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;

    invoke-virtual {v4, v3}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;->totalStatisticData(Lcn/com/smartdevices/bracelet/model/SportDay;)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_0
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/w;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;->updateStatisticInfo()V

    return-void
.end method
