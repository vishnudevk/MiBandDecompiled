.class Lcn/com/smartdevices/bracelet/chart/f;
.super Ljava/lang/Object;

# interfaces
.implements Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;


# instance fields
.field final synthetic a:Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/chart/f;->a:Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public hasData(I)Z
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/f;->a:Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;->a(Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;)Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView$DynamicDetailChartLoadCallback;

    move-result-object v0

    invoke-interface {v0, p1}, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView$DynamicDetailChartLoadCallback;->hasData(I)Z

    move-result v0

    return v0
.end method

.method public loadData(I)Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$ItemData;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/f;->a:Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;->a(Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;)Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView$DynamicDetailChartLoadCallback;

    move-result-object v0

    invoke-interface {v0, p1}, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView$DynamicDetailChartLoadCallback;->loadData(I)Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$ItemData;

    move-result-object v0

    return-object v0
.end method

.method public onDataLoaded(Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$ItemData;)V
    .locals 6

    const/4 v5, 0x1

    if-eqz p1, :cond_2

    move-object v0, p1

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView$DynamicDetailChartData;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/f;->a:Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;->b(Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;)I

    move-result v1

    const/16 v2, 0x10

    if-ne v1, v2, :cond_0

    iget-object v1, v0, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView$DynamicDetailChartData;->sleepData:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView$DynamicDetailChartSleepData;

    iget v3, v1, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView$DynamicDetailChartSleepData;->index:I

    iget v4, p1, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$ItemData;->index:I

    mul-int/lit16 v4, v4, 0x5a0

    add-int/2addr v3, v4

    iput v3, v1, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView$DynamicDetailChartSleepData;->index:I

    goto :goto_0

    :cond_0
    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/f;->a:Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;->b(Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;)I

    move-result v1

    if-ne v1, v5, :cond_1

    iget-object v1, v0, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView$DynamicDetailChartData;->stepData:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView$DynamicDetailChartStepData;

    iget v3, v1, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView$DynamicDetailChartStepData;->index:I

    iget v4, p1, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$ItemData;->index:I

    mul-int/lit8 v4, v4, 0x18

    add-int/2addr v3, v4

    iput v3, v1, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView$DynamicDetailChartStepData;->index:I

    goto :goto_1

    :cond_1
    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/f;->a:Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;->c(Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;)Ljava/util/ArrayList;

    move-result-object v1

    iget v2, p1, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$ItemData;->index:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/f;->a:Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;->c(Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_3

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/f;->a:Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;->d(Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;)I

    move-result v1

    invoke-virtual {p0, v1}, Lcn/com/smartdevices/bracelet/chart/f;->onToItem(I)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/f;->a:Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;

    invoke-static {v1, v0, v5}, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;->a(Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView$DynamicDetailChartData;Z)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/f;->a:Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;->a(Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;)Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView$DynamicDetailChartLoadCallback;

    move-result-object v0

    invoke-interface {v0, p1}, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView$DynamicDetailChartLoadCallback;->onDataLoaded(Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$ItemData;)V

    :cond_2
    :goto_2
    return-void

    :cond_3
    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/f;->a:Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;

    const/4 v2, 0x0

    invoke-static {v1, v0, v2}, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;->a(Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView$DynamicDetailChartData;Z)V

    goto :goto_2
.end method

.method public onToItem(I)V
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/f;->a:Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;->a(Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;)Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView$DynamicDetailChartLoadCallback;

    move-result-object v0

    invoke-interface {v0, p1}, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView$DynamicDetailChartLoadCallback;->onToItem(I)V

    return-void
.end method
