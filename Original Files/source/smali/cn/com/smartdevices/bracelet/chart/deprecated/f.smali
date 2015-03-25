.class Lcn/com/smartdevices/bracelet/chart/deprecated/f;
.super Ljava/lang/Object;

# interfaces
.implements Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;


# instance fields
.field final synthetic a:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;

.field final synthetic b:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/f;->b:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;

    iput-object p2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/f;->a:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public hasData(I)Z
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/f;->a:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;

    invoke-interface {v0, p1}, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;->hasData(I)Z

    move-result v0

    return v0
.end method

.method public loadData(I)Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$ItemData;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/f;->a:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;

    invoke-interface {v0, p1}, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;->loadData(I)Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$ItemData;

    move-result-object v0

    return-object v0
.end method

.method public onDataLoaded(Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$ItemData;)V
    .locals 6

    const/4 v5, 0x1

    if-eqz p1, :cond_4

    move-object v0, p1

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartData;

    iget-object v1, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartData;->sleepData:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartSleepData;

    iget v3, v1, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartSleepData;->index:I

    iget v4, p1, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$ItemData;->index:I

    mul-int/lit16 v4, v4, 0x5a0

    add-int/2addr v3, v4

    iput v3, v1, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartSleepData;->index:I

    goto :goto_0

    :cond_0
    iget-object v1, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartData;->stepData:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartStepData;

    iget v3, v1, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartStepData;->index:I

    iget v4, p1, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$ItemData;->index:I

    mul-int/lit8 v4, v4, 0x18

    add-int/2addr v3, v4

    iput v3, v1, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartStepData;->index:I

    goto :goto_1

    :cond_1
    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/f;->b:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;

    invoke-static {v1, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->a(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartData;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/f;->b:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->a(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;)I

    move-result v0

    iget v1, p1, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$ItemData;->index:I

    if-ne v0, v1, :cond_2

    iget v0, p1, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$ItemData;->index:I

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/f;->onToItem(I)V

    :cond_2
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/f;->b:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->b(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;)Z

    move-result v0

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/f;->b:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;

    invoke-virtual {v0, v5}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->refresh(Z)V

    :cond_3
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/f;->b:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;

    invoke-static {v0, v5}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->a(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;Z)Z

    :cond_4
    return-void
.end method

.method public onToItem(I)V
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/f;->a:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;

    invoke-interface {v0, p1}, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;->onToItem(I)V

    return-void
.end method
