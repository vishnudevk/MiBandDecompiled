.class public Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;
.super Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;


# static fields
.field private static final a:Ljava/lang/String; = "Chart.StatisticMonthly"


# instance fields
.field private b:[Ljava/lang/String;


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

    iget v0, p1, Lcn/com/smartdevices/bracelet/model/SportDay;->year:I

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;->mToday:Lcn/com/smartdevices/bracelet/model/SportDay;

    iget v1, v1, Lcn/com/smartdevices/bracelet/model/SportDay;->year:I

    if-ne v0, v1, :cond_0

    iget v0, p1, Lcn/com/smartdevices/bracelet/model/SportDay;->mon:I

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;->mToday:Lcn/com/smartdevices/bracelet/model/SportDay;

    iget v1, v1, Lcn/com/smartdevices/bracelet/model/SportDay;->mon:I

    if-ne v0, v1, :cond_0

    const v0, 0x7f0d0059

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p1, v4}, Lcn/com/smartdevices/bracelet/model/SportDay;->addMonth(I)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    iget v0, v0, Lcn/com/smartdevices/bracelet/model/SportDay;->year:I

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;->mToday:Lcn/com/smartdevices/bracelet/model/SportDay;

    iget v1, v1, Lcn/com/smartdevices/bracelet/model/SportDay;->year:I

    if-ne v0, v1, :cond_1

    invoke-virtual {p1, v4}, Lcn/com/smartdevices/bracelet/model/SportDay;->addMonth(I)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    iget v0, v0, Lcn/com/smartdevices/bracelet/model/SportDay;->mon:I

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;->mToday:Lcn/com/smartdevices/bracelet/model/SportDay;

    iget v1, v1, Lcn/com/smartdevices/bracelet/model/SportDay;->mon:I

    if-ne v0, v1, :cond_1

    const v0, 0x7f0d0052

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_1
    const v0, 0x7f0d005c

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    iget v3, p1, Lcn/com/smartdevices/bracelet/model/SportDay;->year:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;->b:[Ljava/lang/String;

    iget v3, p1, Lcn/com/smartdevices/bracelet/model/SportDay;->mon:I

    aget-object v2, v2, v3

    aput-object v2, v1, v4

    invoke-virtual {p0, v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method protected formatDateShort(Lcn/com/smartdevices/bracelet/model/SportDay;)Ljava/lang/String;
    .locals 3

    const/4 v2, 0x1

    iget v0, p1, Lcn/com/smartdevices/bracelet/model/SportDay;->year:I

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;->mToday:Lcn/com/smartdevices/bracelet/model/SportDay;

    iget v1, v1, Lcn/com/smartdevices/bracelet/model/SportDay;->year:I

    if-ne v0, v1, :cond_0

    iget v0, p1, Lcn/com/smartdevices/bracelet/model/SportDay;->mon:I

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;->mToday:Lcn/com/smartdevices/bracelet/model/SportDay;

    iget v1, v1, Lcn/com/smartdevices/bracelet/model/SportDay;->mon:I

    if-ne v0, v1, :cond_0

    const v0, 0x7f0d0059

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p1, v2}, Lcn/com/smartdevices/bracelet/model/SportDay;->addMonth(I)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    iget v0, v0, Lcn/com/smartdevices/bracelet/model/SportDay;->year:I

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;->mToday:Lcn/com/smartdevices/bracelet/model/SportDay;

    iget v1, v1, Lcn/com/smartdevices/bracelet/model/SportDay;->year:I

    if-ne v0, v1, :cond_1

    invoke-virtual {p1, v2}, Lcn/com/smartdevices/bracelet/model/SportDay;->addMonth(I)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    iget v0, v0, Lcn/com/smartdevices/bracelet/model/SportDay;->mon:I

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;->mToday:Lcn/com/smartdevices/bracelet/model/SportDay;

    iget v1, v1, Lcn/com/smartdevices/bracelet/model/SportDay;->mon:I

    if-ne v0, v1, :cond_1

    const v0, 0x7f0d0052

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_1
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget v1, p1, Lcn/com/smartdevices/bracelet/model/SportDay;->year:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;->b:[Ljava/lang/String;

    iget v2, p1, Lcn/com/smartdevices/bracelet/model/SportDay;->mon:I

    aget-object v1, v1, v2

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

    new-instance v1, Lcn/com/smartdevices/bracelet/chart/deprecated/w;

    invoke-direct {v1, p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/w;-><init>(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;)V

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;->setLoadCallback(Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;->mActiveStatisticChart:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;

    invoke-virtual {v1, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->setDataLoader(Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;->mActiveStatisticChart:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->loadData(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;->mActiveStatisticChart:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->setScrollable(Z)V

    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2

    invoke-super {p0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->onCreate(Landroid/os/Bundle;)V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f070001

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;->b:[Ljava/lang/String;

    return-void
.end method

.method protected updateSleepAchievement(I)V
    .locals 2

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;->getView()Landroid/view/View;

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

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;->getView()Landroid/view/View;

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

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;->getView()Landroid/view/View;

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

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;->getView()Landroid/view/View;

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

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0a013a

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    return-void
.end method
