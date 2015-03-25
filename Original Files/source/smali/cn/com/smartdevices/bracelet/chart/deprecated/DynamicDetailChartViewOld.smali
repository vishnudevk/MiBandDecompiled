.class public Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;
.super Lcn/com/smartdevices/bracelet/chart/base/BaseChartView;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcn/com/smartdevices/bracelet/chart/base/BaseChartView",
        "<",
        "Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;",
        ">;"
    }
.end annotation


# static fields
.field private static final a:Ljava/lang/String; = "Chart.DynamicDetailChartView"


# instance fields
.field private b:Lcn/com/smartdevices/bracelet/chart/base/Renderer;

.field private c:Lcn/com/smartdevices/bracelet/chart/base/Renderer;

.field private d:Lcn/com/smartdevices/bracelet/chart/base/Renderer;

.field private e:Lcn/com/smartdevices/bracelet/chart/base/Renderer;

.field private f:Lcn/com/smartdevices/bracelet/chart/base/Renderer;

.field private g:Lcn/com/smartdevices/bracelet/chart/base/ChartScroller;

.field private h:I

.field private i:Z

.field private j:Lcn/com/smartdevices/bracelet/chart/base/ChartScroller$ScrollingListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 3

    invoke-direct {p0, p1, p2, p3}, Lcn/com/smartdevices/bracelet/chart/base/BaseChartView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    new-instance v0, Lcn/com/smartdevices/bracelet/chart/deprecated/h;

    invoke-direct {v0, p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/h;-><init>(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->j:Lcn/com/smartdevices/bracelet/chart/base/ChartScroller$ScrollingListener;

    new-instance v0, Lcn/com/smartdevices/bracelet/chart/base/ColorRenderer;

    const v1, -0x4cbec632

    invoke-direct {v0, v1}, Lcn/com/smartdevices/bracelet/chart/base/ColorRenderer;-><init>(I)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->b:Lcn/com/smartdevices/bracelet/chart/base/Renderer;

    new-instance v0, Lcn/com/smartdevices/bracelet/chart/base/ColorRenderer;

    const v1, 0x4d4139ce

    invoke-direct {v0, v1}, Lcn/com/smartdevices/bracelet/chart/base/ColorRenderer;-><init>(I)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->c:Lcn/com/smartdevices/bracelet/chart/base/Renderer;

    new-instance v0, Lcn/com/smartdevices/bracelet/chart/base/ColorRenderer;

    const v1, -0x4c008e00

    invoke-direct {v0, v1}, Lcn/com/smartdevices/bracelet/chart/base/ColorRenderer;-><init>(I)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->d:Lcn/com/smartdevices/bracelet/chart/base/Renderer;

    new-instance v0, Lcn/com/smartdevices/bracelet/chart/base/ColorRenderer;

    const v1, -0x4c390100

    invoke-direct {v0, v1}, Lcn/com/smartdevices/bracelet/chart/base/ColorRenderer;-><init>(I)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->e:Lcn/com/smartdevices/bracelet/chart/base/Renderer;

    new-instance v0, Lcn/com/smartdevices/bracelet/chart/base/ColorRenderer;

    const v1, 0x4dc6ff00

    invoke-direct {v0, v1}, Lcn/com/smartdevices/bracelet/chart/base/ColorRenderer;-><init>(I)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->f:Lcn/com/smartdevices/bracelet/chart/base/Renderer;

    new-instance v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;

    invoke-direct {v0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    new-instance v0, Landroid/view/animation/DecelerateInterpolator;

    invoke-direct {v0}, Landroid/view/animation/DecelerateInterpolator;-><init>()V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->mInterpolator:Landroid/view/animation/Interpolator;

    const-wide/16 v0, 0x1f4

    iput-wide v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->mDuration:J

    new-instance v0, Lcn/com/smartdevices/bracelet/chart/base/ChartScroller;

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->getContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->j:Lcn/com/smartdevices/bracelet/chart/base/ChartScroller$ScrollingListener;

    invoke-direct {v0, v1, v2}, Lcn/com/smartdevices/bracelet/chart/base/ChartScroller;-><init>(Landroid/content/Context;Lcn/com/smartdevices/bracelet/chart/base/ChartScroller$ScrollingListener;)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->g:Lcn/com/smartdevices/bracelet/chart/base/ChartScroller;

    return-void
.end method

.method static synthetic a(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;)I
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->h:I

    return v0
.end method

.method private a(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartData;)V
    .locals 1

    iget-object v0, p1, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartData;->stepData:Ljava/util/List;

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->bindStepData(Ljava/util/List;)V

    iget-object v0, p1, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartData;->sleepData:Ljava/util/List;

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->bindSleepData(Ljava/util/List;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->notifyChanged()V

    return-void
.end method

.method static synthetic a(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartData;)V
    .locals 0

    invoke-direct {p0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->a(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartData;)V

    return-void
.end method

.method static synthetic a(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;Z)Z
    .locals 0

    iput-boolean p1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->i:Z

    return p1
.end method

.method static synthetic b(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;)Z
    .locals 1

    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->i:Z

    return v0
.end method

.method static synthetic c(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;)Lcn/com/smartdevices/bracelet/chart/base/BaseChart;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    return-object v0
.end method

.method static synthetic d(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;)Lcn/com/smartdevices/bracelet/chart/base/BaseChart;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    return-object v0
.end method

.method static synthetic e(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;)Lcn/com/smartdevices/bracelet/chart/base/BaseChart;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    return-object v0
.end method


# virtual methods
.method public bindSleepData(Ljava/util/List;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartSleepData;",
            ">;)V"
        }
    .end annotation

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartSleepData;

    new-instance v3, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld$DynamicDetailBarItem;

    invoke-direct {v3}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld$DynamicDetailBarItem;-><init>()V

    iget v4, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartSleepData;->mode:I

    iput v4, v3, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld$DynamicDetailBarItem;->value:I

    iget v4, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartSleepData;->index:I

    iput v4, v3, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld$DynamicDetailBarItem;->index:I

    iget v4, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartSleepData;->length:I

    iput v4, v3, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld$DynamicDetailBarItem;->scope:I

    iget v0, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartSleepData;->mode:I

    packed-switch v0, :pswitch_data_0

    :goto_1
    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :pswitch_0
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->b:Lcn/com/smartdevices/bracelet/chart/base/Renderer;

    invoke-virtual {v3, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld$DynamicDetailBarItem;->setRenderer(Lcn/com/smartdevices/bracelet/chart/base/Renderer;)V

    goto :goto_1

    :pswitch_1
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->c:Lcn/com/smartdevices/bracelet/chart/base/Renderer;

    invoke-virtual {v3, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld$DynamicDetailBarItem;->setRenderer(Lcn/com/smartdevices/bracelet/chart/base/Renderer;)V

    goto :goto_1

    :pswitch_2
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->d:Lcn/com/smartdevices/bracelet/chart/base/Renderer;

    invoke-virtual {v3, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld$DynamicDetailBarItem;->setRenderer(Lcn/com/smartdevices/bracelet/chart/base/Renderer;)V

    goto :goto_1

    :cond_0
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->addSleepData(Ljava/util/List;)V

    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public bindStepData(Ljava/util/List;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartStepData;",
            ">;)V"
        }
    .end annotation

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartStepData;

    new-instance v3, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld$DynamicDetailBarItem;

    invoke-direct {v3}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld$DynamicDetailBarItem;-><init>()V

    iget v4, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartStepData;->step:I

    iput v4, v3, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld$DynamicDetailBarItem;->value:I

    iget v0, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartStepData;->index:I

    iput v0, v3, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld$DynamicDetailBarItem;->index:I

    const/4 v0, 0x1

    iput v0, v3, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld$DynamicDetailBarItem;->scope:I

    iget v0, v3, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld$DynamicDetailBarItem;->value:I

    const/16 v4, 0x1f4

    if-lt v0, v4, :cond_0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->e:Lcn/com/smartdevices/bracelet/chart/base/Renderer;

    invoke-virtual {v3, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld$DynamicDetailBarItem;->setRenderer(Lcn/com/smartdevices/bracelet/chart/base/Renderer;)V

    :goto_1
    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :cond_0
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->f:Lcn/com/smartdevices/bracelet/chart/base/Renderer;

    invoke-virtual {v3, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld$DynamicDetailBarItem;->setRenderer(Lcn/com/smartdevices/bracelet/chart/base/Renderer;)V

    goto :goto_1

    :cond_1
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->addStepData(Ljava/util/List;)V

    return-void
.end method

.method public clearData()V
    .locals 1

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->i:Z

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->mLoader:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;->clearData()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->clearStepData()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->clearSleepData()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->notifyChanged()V

    return-void
.end method

.method public loadDayActiveData(I)Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$ItemData;
    .locals 4

    iput p1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->h:I

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->mLoader:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;

    invoke-virtual {v0, p1}, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;->getItemData(I)Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$ItemData;

    move-result-object v0

    if-nez v0, :cond_0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->mLoader:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;

    invoke-virtual {v1, p1}, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;->hasItemData(I)Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->mLoader:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;

    new-instance v2, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartData;

    invoke-direct {v2}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartData;-><init>()V

    invoke-virtual {v1, p1, v2}, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;->putItemData(ILcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$ItemData;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->mLoader:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;

    invoke-virtual {v1, p1}, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;->loadItemData(I)V

    :cond_0
    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->mLoader:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;

    add-int/lit8 v2, p1, -0x1

    invoke-virtual {v1, v2}, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;->getItemData(I)Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$ItemData;

    move-result-object v1

    if-nez v1, :cond_1

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->mLoader:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;

    add-int/lit8 v2, p1, -0x1

    invoke-virtual {v1, v2}, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;->hasItemData(I)Z

    move-result v1

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->mLoader:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;

    add-int/lit8 v2, p1, -0x1

    new-instance v3, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartData;

    invoke-direct {v3}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartData;-><init>()V

    invoke-virtual {v1, v2, v3}, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;->putItemData(ILcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$ItemData;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->mLoader:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;

    add-int/lit8 v2, p1, -0x1

    invoke-virtual {v1, v2}, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;->loadItemData(I)V

    :goto_0
    return-object v0

    :cond_1
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->i:Z

    goto :goto_0
.end method

.method public notifyChanged()V
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->notifyChanged()V

    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 4

    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->mScrollable:Z

    if-nez v0, :cond_1

    const/4 v0, 0x0

    :cond_0
    :goto_0
    return v0

    :cond_1
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->g:Lcn/com/smartdevices/bracelet/chart/base/ChartScroller;

    invoke-virtual {v0, p1}, Lcn/com/smartdevices/bracelet/chart/base/ChartScroller;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    const-string v1, "Chart.DynamicDetailChartView"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Consumed : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    invoke-interface {v1, v0}, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V

    goto :goto_0
.end method

.method public refresh()V
    .locals 2

    const-string v0, "Chart.DynamicDetailChartView"

    const-string v1, "Refresh!!"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->w(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->animRefresh()Landroid/animation/Animator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/animation/Animator;->isStarted()Z

    move-result v0

    if-eqz v0, :cond_0

    :goto_0
    return-void

    :cond_0
    invoke-super {p0}, Lcn/com/smartdevices/bracelet/chart/base/BaseChartView;->refresh()V

    goto :goto_0
.end method

.method public refresh(Z)V
    .locals 3

    const-string v0, "Chart.DynamicDetailChartView"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Refresh : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->e(Ljava/lang/String;Ljava/lang/String;)V

    invoke-super {p0, p1}, Lcn/com/smartdevices/bracelet/chart/base/BaseChartView;->refresh(Z)V

    return-void
.end method

.method public setDataLoader(Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;)V
    .locals 3

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->mLoader:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;

    invoke-virtual {p1}, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;->getLoadCallback()Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;

    move-result-object v1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->mLoader:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;

    new-instance v2, Lcn/com/smartdevices/bracelet/chart/deprecated/f;

    invoke-direct {v2, p0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/f;-><init>(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;)V

    invoke-virtual {v0, v2}, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader;->setLoadCallback(Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;

    new-instance v2, Lcn/com/smartdevices/bracelet/chart/deprecated/g;

    invoke-direct {v2, p0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/g;-><init>(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;)V

    invoke-virtual {v0, v2}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->setLoadCallback(Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;)V

    return-void
.end method

.method public setOffset(I)V
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;

    invoke-virtual {v0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->setOffset(I)V

    return-void
.end method

.method public setSleepRiseTime(ILjava/lang/String;Ljava/lang/String;)V
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;

    invoke-virtual {v0, p1, p2, p3}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->setSleepRiseTime(ILjava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public setSleepStartTime(ILjava/lang/String;Ljava/lang/String;)V
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;

    invoke-virtual {v0, p1, p2, p3}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->setSleepStartTime(ILjava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public setStepTime(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;

    invoke-virtual {v0, p1, p2}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->setStepTime(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method
