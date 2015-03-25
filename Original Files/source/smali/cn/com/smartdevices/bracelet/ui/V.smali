.class Lcn/com/smartdevices/bracelet/ui/V;
.super Ljava/lang/Object;

# interfaces
.implements Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView$DynamicDetailChartLoadCallback;


# instance fields
.field final synthetic a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public hasData(I)Z
    .locals 4

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->b(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcn/com/smartdevices/bracelet/model/SportDay;->addDay(I)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    const-string v1, "Dynamic.Detail"

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

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->d(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/model/SportDay;->before(Lcn/com/smartdevices/bracelet/model/SportDay;)Z

    move-result v1

    if-nez v1, :cond_0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->e(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/model/SportDay;->after(Lcn/com/smartdevices/bracelet/model/SportDay;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const-string v0, "Dynamic.Detail"

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
    .locals 4

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->b(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcn/com/smartdevices/bracelet/model/SportDay;->addDay(I)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v1

    const-string v0, "Dynamic.Detail"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Load Data : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->a(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Lcn/com/smartdevices/bracelet/DataManager;

    move-result-object v0

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/DataManager;->load(Lcn/com/smartdevices/bracelet/model/SportDay;)I

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->a(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Lcn/com/smartdevices/bracelet/DataManager;

    move-result-object v0

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/DataManager;->get(Lcn/com/smartdevices/bracelet/model/SportDay;)Lcn/com/smartdevices/bracelet/model/DaySportData;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v2, v0}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->a(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;Lcn/com/smartdevices/bracelet/model/DaySportData;)Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView$DynamicDetailChartData;

    move-result-object v0

    :goto_0
    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v2}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->c(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcn/com/smartdevices/bracelet/model/SportDay;->equals(Lcn/com/smartdevices/bracelet/model/SportDay;)Z

    move-result v2

    if-eqz v2, :cond_1

    const-string v1, "\u4eca\u5929"

    :goto_1
    iput-object v1, v0, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView$DynamicDetailChartData;->date:Ljava/lang/String;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v2}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->b(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v2

    add-int/lit8 v3, p1, -0x1

    invoke-virtual {v2, v3}, Lcn/com/smartdevices/bracelet/model/SportDay;->addDay(I)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->f(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;Lcn/com/smartdevices/bracelet/model/SportDay;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView$DynamicDetailChartData;->prevDate:Ljava/lang/String;

    return-object v0

    :cond_0
    new-instance v0, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView$DynamicDetailChartData;

    invoke-direct {v0}, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView$DynamicDetailChartData;-><init>()V

    goto :goto_0

    :cond_1
    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lcn/com/smartdevices/bracelet/model/SportDay;->addDay(I)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v1

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v2}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->c(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcn/com/smartdevices/bracelet/model/SportDay;->equals(Lcn/com/smartdevices/bracelet/model/SportDay;)Z

    move-result v1

    if-eqz v1, :cond_2

    const-string v1, "\u6628\u5929"

    goto :goto_1

    :cond_2
    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v2}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->b(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v2

    invoke-virtual {v2, p1}, Lcn/com/smartdevices/bracelet/model/SportDay;->addDay(I)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->f(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;Lcn/com/smartdevices/bracelet/model/SportDay;)Ljava/lang/String;

    move-result-object v1

    goto :goto_1
.end method

.method public onDataLoaded(Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$ItemData;)V
    .locals 10

    const/4 v9, 0x1

    const/4 v0, 0x0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->g(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;

    move-result-object v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->g(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;

    move-result-object v1

    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;->isAttached()Z

    move-result v1

    if-nez v1, :cond_2

    :cond_0
    const-string v0, "Dynamic.Detail"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Chart Already Detached From UI : onDataLoaded , "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v2}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->g(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->w(Ljava/lang/String;Ljava/lang/String;)V

    :cond_1
    :goto_0
    return-void

    :cond_2
    const-string v1, "DynamicView"

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v2}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->k(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->h(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)I

    move-result v1

    if-ne v1, v9, :cond_3

    new-instance v1, Lcn/com/smartdevices/bracelet/analysis/StageSteps;

    invoke-direct {v1}, Lcn/com/smartdevices/bracelet/analysis/StageSteps;-><init>()V

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v2}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->l(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)I

    move-result v2

    iput v2, v1, Lcn/com/smartdevices/bracelet/analysis/StageSteps;->steps:I

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v2}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->m(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)I

    move-result v2

    iput v2, v1, Lcn/com/smartdevices/bracelet/analysis/StageSteps;->count:I

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v2}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->n(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)I

    move-result v2

    iput v2, v1, Lcn/com/smartdevices/bracelet/analysis/StageSteps;->distance:I

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v2}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->o(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2, v0}, Landroid/view/View;->setVisibility(I)V

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v3}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->o(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Landroid/view/View;

    move-result-object v3

    invoke-static {v2, v1, v3}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->a(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;Lcn/com/smartdevices/bracelet/analysis/StageSteps;Landroid/view/View;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    const v3, 0x7f0d0071

    new-array v4, v9, [Ljava/lang/Object;

    iget-object v5, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    const v6, 0x7f0d0050

    const/4 v7, 0x2

    new-array v7, v7, [Ljava/lang/Object;

    iget-object v8, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v8}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->p(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)I

    move-result v8

    invoke-static {v8}, Lcn/com/smartdevices/bracelet/chart/util/ChartData;->formatTime(I)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v7, v0

    iget-object v8, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v8}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->q(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)I

    move-result v8

    invoke-static {v8}, Lcn/com/smartdevices/bracelet/chart/util/ChartData;->formatTime(I)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v7, v9

    invoke-virtual {v5, v6, v7}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v0

    invoke-virtual {v2, v3, v4}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->a(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;Ljava/lang/String;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->p(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)I

    move-result v1

    div-int/lit8 v1, v1, 0x3c

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v2}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->q(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)I

    move-result v2

    div-int/lit8 v2, v2, 0x3c

    sub-int/2addr v2, v1

    add-int/lit8 v2, v2, 0x1

    :goto_1
    if-ge v0, v2, :cond_3

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v3}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->g(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;

    move-result-object v3

    add-int v4, v1, v0

    invoke-virtual {v3, v4}, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;->setStepItemSelection(I)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_3
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->r(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Landroid/animation/Animator;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->r(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Landroid/animation/Animator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/animation/Animator;->start()V

    goto/16 :goto_0
.end method

.method public onToItem(I)V
    .locals 11

    const/16 v10, 0x10

    const/4 v7, 0x4

    const/4 v3, 0x0

    const/4 v9, -0x1

    const/4 v2, 0x1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->g(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->g(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;

    move-result-object v0

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;->isAttached()Z

    move-result v0

    if-nez v0, :cond_2

    :cond_0
    const-string v0, "Dynamic.Detail"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Chart Already Detached From UI : onToItem , "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v2}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->g(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->w(Ljava/lang/String;Ljava/lang/String;)V

    :cond_1
    :goto_0
    return-void

    :cond_2
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->b(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcn/com/smartdevices/bracelet/model/SportDay;->addDay(I)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v4

    const-string v0, "Dynamic.Detail"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "On To : "

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->a(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Lcn/com/smartdevices/bracelet/DataManager;

    move-result-object v0

    invoke-virtual {v0, v4}, Lcn/com/smartdevices/bracelet/DataManager;->get(Lcn/com/smartdevices/bracelet/model/SportDay;)Lcn/com/smartdevices/bracelet/model/DaySportData;

    move-result-object v5

    const/4 v1, 0x0

    const/4 v0, 0x0

    if-eqz v5, :cond_3

    invoke-virtual {v5}, Lcn/com/smartdevices/bracelet/model/DaySportData;->getSleepInfo()Lcn/com/smartdevices/bracelet/analysis/SleepInfo;

    move-result-object v1

    invoke-virtual {v5}, Lcn/com/smartdevices/bracelet/model/DaySportData;->getStepsInfo()Lcn/com/smartdevices/bracelet/analysis/StepsInfo;

    move-result-object v0

    :cond_3
    iget-object v6, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v6}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->h(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)I

    move-result v6

    if-ne v6, v2, :cond_6

    if-nez v0, :cond_4

    new-instance v0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;

    invoke-direct {v0}, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;-><init>()V

    :cond_4
    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    iget-object v4, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v4}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->s(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Landroid/view/View;

    move-result-object v4

    invoke-static {v1, v0, v4}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->a(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;Lcn/com/smartdevices/bracelet/analysis/StepsInfo;Landroid/view/View;)V

    :cond_5
    :goto_1
    if-eqz v5, :cond_e

    invoke-virtual {v5}, Lcn/com/smartdevices/bracelet/model/DaySportData;->getSleepInfo()Lcn/com/smartdevices/bracelet/analysis/SleepInfo;

    move-result-object v0

    if-eqz v0, :cond_d

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/analysis/SleepInfo;->getSleepCount()I

    move-result v0

    if-nez v0, :cond_f

    move v0, v2

    :goto_2
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v1

    iget-object v4, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v4}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->h(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)I

    move-result v4

    if-ne v4, v10, :cond_1

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->b(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    iget-object v4, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v4}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->e(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v4

    invoke-virtual {v0, v4}, Lcn/com/smartdevices/bracelet/model/SportDay;->equals(Lcn/com/smartdevices/bracelet/model/SportDay;)Z

    move-result v0

    if-eqz v0, :cond_1

    const/16 v0, 0xb

    invoke-virtual {v1, v0}, Ljava/util/Calendar;->get(I)I

    move-result v0

    const/4 v1, 0x5

    if-ge v0, v1, :cond_1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->b(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v1

    invoke-virtual {v1, v9}, Lcn/com/smartdevices/bracelet/model/SportDay;->addDay(I)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->b(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;Lcn/com/smartdevices/bracelet/model/SportDay;)Lcn/com/smartdevices/bracelet/model/SportDay;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->g(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;

    move-result-object v0

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;->clearData()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->g(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;

    move-result-object v0

    new-array v1, v2, [I

    aput v9, v1, v3

    invoke-virtual {v0, v3, v1}, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;->loadDynamicData(I[I)Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$ItemData;

    goto/16 :goto_0

    :cond_6
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->h(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)I

    move-result v0

    if-ne v0, v10, :cond_5

    if-eqz v1, :cond_a

    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/analysis/SleepInfo;->getHasSleep()Z

    move-result v0

    if-nez v0, :cond_9

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->t(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Landroid/widget/TextView;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/analysis/SleepInfo;->getSleepCount()I

    move-result v0

    if-nez v0, :cond_8

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->t(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Landroid/widget/TextView;

    move-result-object v0

    const v6, 0x7f0d010d

    invoke-virtual {v0, v6}, Landroid/widget/TextView;->setText(I)V

    :goto_3
    if-nez v1, :cond_7

    new-instance v1, Lcn/com/smartdevices/bracelet/analysis/SleepInfo;

    invoke-direct {v1}, Lcn/com/smartdevices/bracelet/analysis/SleepInfo;-><init>()V

    :cond_7
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/analysis/SleepInfo;->getStartOnBedDate()Ljava/util/Date;

    move-result-object v6

    invoke-virtual {v0, v6}, Ljava/util/Calendar;->setTime(Ljava/util/Date;)V

    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v6

    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/analysis/SleepInfo;->getStopOnBedDate()Ljava/util/Date;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/util/Calendar;->setTime(Ljava/util/Date;)V

    invoke-virtual {v4, v9}, Lcn/com/smartdevices/bracelet/model/SportDay;->addDay(I)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v7

    invoke-virtual {v7, v0}, Lcn/com/smartdevices/bracelet/model/SportDay;->equals(Ljava/util/Calendar;)Z

    move-result v7

    if-eqz v7, :cond_b

    iget-object v7, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    iget-object v8, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v8, v0}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->a(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;Ljava/util/Calendar;)I

    move-result v0

    invoke-static {v7, v0}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->a(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;I)I

    :goto_4
    invoke-virtual {v4, v9}, Lcn/com/smartdevices/bracelet/model/SportDay;->addDay(I)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    invoke-virtual {v0, v6}, Lcn/com/smartdevices/bracelet/model/SportDay;->equals(Ljava/util/Calendar;)Z

    move-result v0

    if-eqz v0, :cond_c

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    iget-object v4, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v4, v6}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->a(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;Ljava/util/Calendar;)I

    move-result v4

    invoke-static {v0, v4}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->b(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;I)I

    :goto_5
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->g(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;

    move-result-object v0

    iget-object v4, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v4}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->u(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)I

    move-result v4

    iget-object v6, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v6}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->v(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)I

    move-result v6

    invoke-virtual {v0, v4, v6}, Lcn/com/smartdevices/bracelet/chart/DynamicDetailChartView;->setStartEndTimeIndex(II)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/analysis/SleepInfo;->getStartDateMin()I

    move-result v4

    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/analysis/SleepInfo;->getStopDateMin()I

    move-result v6

    iget-object v7, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v7}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->w(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Landroid/view/View;

    move-result-object v7

    invoke-static {v0, v1, v4, v6, v7}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->a(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;Lcn/com/smartdevices/bracelet/analysis/SleepInfo;IILandroid/view/View;)V

    goto/16 :goto_1

    :cond_8
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->t(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Landroid/widget/TextView;

    move-result-object v0

    const-string v6, ""

    invoke-virtual {v0, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_3

    :cond_9
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->t(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Landroid/widget/TextView;

    move-result-object v0

    invoke-virtual {v0, v7}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_3

    :cond_a
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->t(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Landroid/widget/TextView;

    move-result-object v0

    invoke-virtual {v0, v7}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_3

    :cond_b
    iget-object v7, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    iget-object v8, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v8, v0}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->b(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;Ljava/util/Calendar;)I

    move-result v0

    invoke-static {v7, v0}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->a(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;I)I

    goto :goto_4

    :cond_c
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    iget-object v4, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v4, v6}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->b(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;Ljava/util/Calendar;)I

    move-result v4

    invoke-static {v0, v4}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->b(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;I)I

    goto :goto_5

    :cond_d
    move v0, v2

    goto/16 :goto_2

    :cond_e
    move v0, v2

    goto/16 :goto_2

    :cond_f
    move v0, v3

    goto/16 :goto_2
.end method

.method public onTouchItem(ILcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;IFF)V
    .locals 9

    const/4 v1, 0x0

    const/4 v8, 0x0

    const/4 v7, 0x1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->h(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)I

    move-result v0

    const/16 v2, 0x10

    if-ne v0, v2, :cond_1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->x(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Landroid/view/View;

    move-result-object v0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v2}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->x(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Landroid/view/View;

    move-result-object v2

    invoke-static {v1, p2, p3, v2}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->a(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;ILandroid/view/View;)V

    :goto_0
    if-nez v0, :cond_4

    :cond_0
    :goto_1
    return-void

    :cond_1
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->h(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)I

    move-result v0

    if-ne v0, v7, :cond_7

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->a(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Lcn/com/smartdevices/bracelet/DataManager;

    move-result-object v0

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v2}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->b(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcn/com/smartdevices/bracelet/DataManager;->get(Lcn/com/smartdevices/bracelet/model/SportDay;)Lcn/com/smartdevices/bracelet/model/DaySportData;

    move-result-object v0

    if-eqz v0, :cond_8

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/model/DaySportData;->getStepsInfo()Lcn/com/smartdevices/bracelet/analysis/StepsInfo;

    move-result-object v0

    :goto_2
    if-nez v0, :cond_2

    new-instance v0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;

    invoke-direct {v0}, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;-><init>()V

    :cond_2
    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->getStageSteps()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_3
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_7

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/analysis/StageSteps;

    iget v3, v0, Lcn/com/smartdevices/bracelet/analysis/StageSteps;->time:I

    if-ne v3, p1, :cond_3

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->o(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Landroid/view/View;

    move-result-object v1

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    const v4, 0x7f0d0071

    new-array v5, v7, [Ljava/lang/Object;

    mul-int/lit8 v6, p1, 0x3c

    invoke-static {v6}, Lcn/com/smartdevices/bracelet/chart/util/ChartData;->formatTime(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v8

    invoke-virtual {v3, v4, v5}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->a(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;Ljava/lang/String;)V

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v3}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->o(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Landroid/view/View;

    move-result-object v3

    invoke-static {v2, v0, v3}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->a(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;Lcn/com/smartdevices/bracelet/analysis/StageSteps;Landroid/view/View;)V

    move-object v0, v1

    goto :goto_0

    :cond_4
    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->y(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Landroid/animation/Animator;

    move-result-object v1

    if-eqz v1, :cond_5

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->y(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Landroid/animation/Animator;

    move-result-object v1

    invoke-virtual {v1}, Landroid/animation/Animator;->isRunning()Z

    move-result v1

    if-eqz v1, :cond_6

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->y(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Landroid/animation/Animator;

    move-result-object v1

    invoke-virtual {v1}, Landroid/animation/Animator;->end()V

    :cond_5
    :goto_3
    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->z(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-virtual {v0, v8}, Landroid/view/View;->setVisibility(I)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v1, v7}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->a(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;Z)Z

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v2, p4, p5, v0}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->a(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;FFLandroid/view/View;)Landroid/animation/Animator;

    move-result-object v0

    invoke-static {v1, v0}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->a(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;Landroid/animation/Animator;)Landroid/animation/Animator;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->A(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Landroid/animation/Animator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/animation/Animator;->start()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->B(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)V

    goto/16 :goto_1

    :cond_6
    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->y(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Landroid/animation/Animator;

    move-result-object v1

    invoke-virtual {v1}, Landroid/animation/Animator;->cancel()V

    goto :goto_3

    :cond_7
    move-object v0, v1

    goto/16 :goto_0

    :cond_8
    move-object v0, v1

    goto/16 :goto_2
.end method

.method public onTouchNothing(FF)V
    .locals 3

    const/4 v0, 0x0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->h(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)I

    move-result v1

    const/16 v2, 0x10

    if-ne v1, v2, :cond_2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->x(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Landroid/view/View;

    move-result-object v0

    :cond_0
    :goto_0
    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->y(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Landroid/animation/Animator;

    move-result-object v1

    if-nez v1, :cond_1

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->z(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Z

    move-result v1

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v2, v0}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->a(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;Landroid/view/View;)Landroid/animation/Animator;

    move-result-object v0

    invoke-static {v1, v0}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->b(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;Landroid/animation/Animator;)Landroid/animation/Animator;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->y(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Landroid/animation/Animator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/animation/Animator;->start()V

    :cond_1
    return-void

    :cond_2
    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->h(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)I

    move-result v1

    const/4 v2, 0x1

    if-ne v1, v2, :cond_0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/V;->a:Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;->o(Lcn/com/smartdevices/bracelet/ui/DynamicDetailFragment;)Landroid/view/View;

    move-result-object v0

    goto :goto_0
.end method
