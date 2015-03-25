.class public Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;
.super Lcn/com/smartdevices/bracelet/chart/base/BaseChartView;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcn/com/smartdevices/bracelet/chart/base/BaseChartView",
        "<",
        "Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;",
        ">;"
    }
.end annotation


# static fields
.field private static final a:Ljava/lang/String; = "Chart.StatisticChartView"


# instance fields
.field private b:Lcn/com/smartdevices/bracelet/chart/base/Renderer;

.field private c:Lcn/com/smartdevices/bracelet/chart/base/Renderer;

.field private d:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld$StatisticBarItem;",
            ">;"
        }
    .end annotation
.end field

.field private e:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld$StatisticBarItem;",
            ">;"
        }
    .end annotation
.end field

.field private f:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld$DateItem;",
            ">;"
        }
    .end annotation
.end field

.field private g:Z

.field private h:Lcn/com/smartdevices/bracelet/chart/base/ChartScroller$ScrollingListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 4

    const/4 v3, 0x1

    invoke-direct {p0, p1, p2, p3}, Lcn/com/smartdevices/bracelet/chart/base/BaseChartView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    new-instance v0, Lcn/com/smartdevices/bracelet/chart/deprecated/t;

    invoke-direct {v0, p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/t;-><init>(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->h:Lcn/com/smartdevices/bracelet/chart/base/ChartScroller$ScrollingListener;

    new-instance v0, Lcn/com/smartdevices/bracelet/chart/base/ColorRenderer;

    const v1, -0x33390100

    invoke-direct {v0, v1}, Lcn/com/smartdevices/bracelet/chart/base/ColorRenderer;-><init>(I)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->b:Lcn/com/smartdevices/bracelet/chart/base/Renderer;

    new-instance v0, Lcn/com/smartdevices/bracelet/chart/base/ColorRenderer;

    const v1, -0x33bec632

    invoke-direct {v0, v1}, Lcn/com/smartdevices/bracelet/chart/base/ColorRenderer;-><init>(I)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->c:Lcn/com/smartdevices/bracelet/chart/base/Renderer;

    new-instance v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;

    invoke-direct {v0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;

    invoke-virtual {v0, p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->setContainerView(Landroid/view/View;)V

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->d:Ljava/util/List;

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->e:Ljava/util/List;

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->f:Ljava/util/List;

    new-instance v0, Lcn/com/smartdevices/bracelet/chart/base/ChartScroller;

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->getContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->h:Lcn/com/smartdevices/bracelet/chart/base/ChartScroller$ScrollingListener;

    invoke-direct {v0, v1, v2}, Lcn/com/smartdevices/bracelet/chart/base/ChartScroller;-><init>(Landroid/content/Context;Lcn/com/smartdevices/bracelet/chart/base/ChartScroller$ScrollingListener;)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->mScroller:Lcn/com/smartdevices/bracelet/chart/base/ChartScroller;

    iput-boolean v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->g:Z

    const/4 v0, 0x0

    invoke-virtual {p0, v3, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->setLayerType(ILandroid/graphics/Paint;)V

    return-void
.end method

.method static synthetic a(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;I)I
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->mScrollingOffset:I

    add-int/2addr v0, p1

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->mScrollingOffset:I

    return v0
.end method

.method private a()V
    .locals 2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->d:Ljava/util/List;

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->fillStepData(Ljava/util/List;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->e:Ljava/util/List;

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->fillSleepData(Ljava/util/List;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->f:Ljava/util/List;

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->fillDates(Ljava/util/List;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->notifyChanged()V

    return-void
.end method

.method private a(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld$StatisticChartData;)V
    .locals 2

    new-instance v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld$StatisticBarItem;

    invoke-direct {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld$StatisticBarItem;-><init>()V

    iget v1, p1, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld$StatisticChartData;->stepValue:I

    iput v1, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld$StatisticBarItem;->value:I

    iget v1, p1, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld$StatisticChartData;->index:I

    iput v1, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld$StatisticBarItem;->index:I

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->b:Lcn/com/smartdevices/bracelet/chart/base/Renderer;

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld$StatisticBarItem;->setRenderer(Lcn/com/smartdevices/bracelet/chart/base/Renderer;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->d:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    new-instance v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld$StatisticBarItem;

    invoke-direct {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld$StatisticBarItem;-><init>()V

    iget v1, p1, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld$StatisticChartData;->sleepValue:I

    iput v1, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld$StatisticBarItem;->value:I

    iget v1, p1, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld$StatisticChartData;->index:I

    iput v1, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld$StatisticBarItem;->index:I

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->c:Lcn/com/smartdevices/bracelet/chart/base/Renderer;

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld$StatisticBarItem;->setRenderer(Lcn/com/smartdevices/bracelet/chart/base/Renderer;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->e:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    new-instance v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld$DateItem;

    invoke-direct {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld$DateItem;-><init>()V

    iget v1, p1, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld$StatisticChartData;->index:I

    iput v1, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld$DateItem;->a:I

    iget-object v1, p1, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld$StatisticChartData;->date:Ljava/lang/String;

    iput-object v1, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld$DateItem;->b:Ljava/lang/String;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->f:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method static synthetic a(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;)V
    .locals 0

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->a()V

    return-void
.end method

.method static synthetic a(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld$StatisticChartData;)V
    .locals 0

    invoke-direct {p0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->a(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld$StatisticChartData;)V

    return-void
.end method

.method static synthetic a(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;Z)Z
    .locals 0

    iput-boolean p1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->g:Z

    return p1
.end method

.method static synthetic b(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;I)I
    .locals 0

    iput p1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->mScrollingOffset:I

    return p1
.end method

.method static synthetic b(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;)Z
    .locals 1

    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->g:Z

    return v0
.end method

.method static synthetic b(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;Z)Z
    .locals 0

    iput-boolean p1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->mIsScrollingPerformed:Z

    return p1
.end method

.method static synthetic c(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;)Lcn/com/smartdevices/bracelet/chart/base/ChartScroller;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->mScroller:Lcn/com/smartdevices/bracelet/chart/base/ChartScroller;

    return-object v0
.end method

.method static synthetic c(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;Z)Z
    .locals 0

    iput-boolean p1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->mIsScrollingPerformed:Z

    return p1
.end method

.method static synthetic d(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;)Lcn/com/smartdevices/bracelet/chart/base/BaseChart;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    return-object v0
.end method

.method static synthetic e(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;)I
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->mScrollingOffset:I

    return v0
.end method

.method static synthetic f(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;)Lcn/com/smartdevices/bracelet/chart/base/BaseChart;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    return-object v0
.end method

.method static synthetic g(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;)Lcn/com/smartdevices/bracelet/chart/base/ChartScroller;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->mScroller:Lcn/com/smartdevices/bracelet/chart/base/ChartScroller;

    return-object v0
.end method

.method static synthetic h(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;)Lcn/com/smartdevices/bracelet/chart/base/BaseChart;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    return-object v0
.end method

.method static synthetic i(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;)Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->mLoader:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;

    return-object v0
.end method

.method static synthetic j(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;)Z
    .locals 1

    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->mIsScrollingPerformed:Z

    return v0
.end method


# virtual methods
.method public clearData()V
    .locals 2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->e:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->d:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->f:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->d:Ljava/util/List;

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->fillStepData(Ljava/util/List;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->e:Ljava/util/List;

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->fillSleepData(Ljava/util/List;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->f:Ljava/util/List;

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->fillDates(Ljava/util/List;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->mLoader:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;->clearData()V

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->g:Z

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->notifyChanged()V

    return-void
.end method

.method public loadData(I)V
    .locals 4

    const/4 v0, -0x1

    :goto_0
    const/16 v1, 0x8

    if-gt v0, v1, :cond_1

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->mLoader:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;

    sub-int v2, p1, v0

    invoke-virtual {v1, v2}, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;->getItemData(I)Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$ItemData;

    move-result-object v1

    if-nez v1, :cond_0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->mLoader:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;

    sub-int v2, p1, v0

    invoke-virtual {v1, v2}, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;->hasItemData(I)Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->mLoader:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;

    sub-int v2, p1, v0

    new-instance v3, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld$StatisticChartData;

    invoke-direct {v3}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld$StatisticChartData;-><init>()V

    invoke-virtual {v1, v2, v3}, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;->putItemData(ILcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$ItemData;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->mLoader:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;

    sub-int v2, p1, v0

    invoke-virtual {v1, v2}, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;->loadItemData(I)V

    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_1
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 3

    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->mScrollable:Z

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    const/4 v1, 0x1

    invoke-interface {v0, v1}, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V

    :cond_1
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    :cond_2
    :goto_1
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->mScroller:Lcn/com/smartdevices/bracelet/chart/base/ChartScroller;

    invoke-virtual {v0, p1}, Lcn/com/smartdevices/bracelet/chart/base/ChartScroller;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    goto :goto_0

    :pswitch_0
    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->mIsScrollingPerformed:Z

    if-nez v0, :cond_2

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->mScroller:Lcn/com/smartdevices/bracelet/chart/base/ChartScroller;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->offsetScroll(F)I

    move-result v0

    invoke-virtual {v2, v0}, Lcn/com/smartdevices/bracelet/chart/base/ChartScroller;->scrollX(I)V

    goto :goto_1

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method public setDataLoader(Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;)V
    .locals 3

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->mLoader:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;

    invoke-virtual {p1}, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;->getLoadCallback()Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;

    move-result-object v1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->mLoader:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;

    new-instance v2, Lcn/com/smartdevices/bracelet/chart/deprecated/r;

    invoke-direct {v2, p0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/r;-><init>(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;)V

    invoke-virtual {v0, v2}, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;->setLoadCallback(Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;

    new-instance v2, Lcn/com/smartdevices/bracelet/chart/deprecated/s;

    invoke-direct {v2, p0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/s;-><init>(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;)V

    invoke-virtual {v0, v2}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->setLoadCallback(Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;)V

    return-void
.end method

.method public setMode(I)V
    .locals 0

    return-void
.end method

.method public setStepGoal(I)V
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;

    invoke-virtual {v0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->setStepGoal(I)V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->refresh()V

    return-void
.end method
