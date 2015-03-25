.class Lcn/com/smartdevices/bracelet/chart/deprecated/s;
.super Ljava/lang/Object;

# interfaces
.implements Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld$StatisticChartLoadCallback;


# instance fields
.field final synthetic a:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;

.field final synthetic b:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/s;->b:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;

    iput-object p2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/s;->a:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public hasData(I)Z
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/s;->a:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;

    invoke-interface {v0, p1}, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;->hasData(I)Z

    move-result v0

    return v0
.end method

.method public loadData(I)Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$ItemData;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/s;->b:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;

    invoke-virtual {v0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->loadData(I)V

    const/4 v0, 0x0

    return-object v0
.end method

.method public onDataLoaded(Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$ItemData;)V
    .locals 0

    return-void
.end method

.method public onOverScrolled()V
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/s;->b:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->c(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;)Lcn/com/smartdevices/bracelet/chart/base/ChartScroller;

    move-result-object v0

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/base/ChartScroller;->forceFinishScrolling()V

    return-void
.end method

.method public onToItem(I)V
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/s;->a:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;

    invoke-interface {v0, p1}, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;->onToItem(I)V

    return-void
.end method
