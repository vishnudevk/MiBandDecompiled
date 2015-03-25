.class public Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;
.super Lcn/com/smartdevices/bracelet/chart/base/BaseChartView;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcn/com/smartdevices/bracelet/chart/base/BaseChartView",
        "<",
        "Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;",
        ">;"
    }
.end annotation


# static fields
.field private static final a:Ljava/lang/String; = "Chart.DynamicPieChartView"


# instance fields
.field private b:J

.field private c:J

.field private d:Landroid/animation/Animator;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 2

    invoke-direct {p0, p1, p2, p3}, Lcn/com/smartdevices/bracelet/chart/base/BaseChartView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    new-instance v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;

    invoke-direct {v0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    new-instance v0, Landroid/view/animation/OvershootInterpolator;

    invoke-direct {v0}, Landroid/view/animation/OvershootInterpolator;-><init>()V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->mInterpolator:Landroid/view/animation/Interpolator;

    const-wide/16 v0, 0x1

    iput-wide v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->mDuration:J

    return-void
.end method

.method static synthetic a(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;)Lcn/com/smartdevices/bracelet/chart/base/BaseChart;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    return-object v0
.end method

.method private a()V
    .locals 6

    const/high16 v1, 0x3f80

    iget-wide v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->c:J

    iget-wide v4, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->b:J

    sub-long/2addr v2, v4

    invoke-static {v2, v3}, Ljava/lang/Math;->abs(J)J

    move-result-wide v2

    long-to-float v2, v2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->getMaxValue()F

    move-result v0

    div-float v0, v2, v0

    cmpl-float v2, v0, v1

    if-lez v2, :cond_0

    move v0, v1

    :cond_0
    const-wide/high16 v2, 0x4089

    float-to-double v4, v0

    invoke-static {v4, v5}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v4

    mul-double/2addr v2, v4

    double-to-long v2, v2

    iput-wide v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->mDuration:J

    iget-wide v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->mDuration:J

    const-wide/16 v4, 0x0

    cmp-long v2, v2, v4

    if-nez v2, :cond_1

    const-wide/16 v2, 0x1

    iput-wide v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->mDuration:J

    :cond_1
    cmpg-float v2, v0, v1

    if-gez v2, :cond_2

    sub-float v0, v1, v0

    const/high16 v1, 0x40c0

    mul-float/2addr v0, v1

    float-to-double v0, v0

    invoke-static {v0, v1}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v0

    double-to-float v1, v0

    :cond_2
    new-instance v0, Landroid/view/animation/OvershootInterpolator;

    invoke-direct {v0, v1}, Landroid/view/animation/OvershootInterpolator;-><init>(F)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->mInterpolator:Landroid/view/animation/Interpolator;

    return-void
.end method

.method private b()Landroid/animation/Animator;
    .locals 3
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    const/4 v0, 0x2

    new-array v0, v0, [F

    fill-array-data v0, :array_0

    invoke-static {v0}, Landroid/animation/ValueAnimator;->ofFloat([F)Landroid/animation/ValueAnimator;

    move-result-object v0

    new-instance v1, Lcn/com/smartdevices/bracelet/chart/deprecated/m;

    invoke-direct {v1, p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/m;-><init>(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;)V

    invoke-virtual {v0, v1}, Landroid/animation/ValueAnimator;->addListener(Landroid/animation/Animator$AnimatorListener;)V

    new-instance v1, Lcn/com/smartdevices/bracelet/chart/deprecated/n;

    invoke-direct {v1, p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/n;-><init>(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;)V

    invoke-virtual {v0, v1}, Landroid/animation/ValueAnimator;->addUpdateListener(Landroid/animation/ValueAnimator$AnimatorUpdateListener;)V

    const-wide/16 v1, 0xdac

    invoke-virtual {v0, v1, v2}, Landroid/animation/ValueAnimator;->setDuration(J)Landroid/animation/ValueAnimator;

    new-instance v1, Landroid/view/animation/LinearInterpolator;

    invoke-direct {v1}, Landroid/view/animation/LinearInterpolator;-><init>()V

    invoke-virtual {v0, v1}, Landroid/animation/ValueAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/animation/ValueAnimator;->setRepeatMode(I)V

    const/4 v1, -0x1

    invoke-virtual {v0, v1}, Landroid/animation/ValueAnimator;->setRepeatCount(I)V

    return-object v0

    :array_0
    .array-data 0x4
        0x0t 0x0t 0x0t 0x0t
        0x0t 0x0t 0x80t 0x3ft
    .end array-data
.end method

.method static synthetic b(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;)Lcn/com/smartdevices/bracelet/chart/base/BaseChart;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    return-object v0
.end method

.method static synthetic c(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;)Lcn/com/smartdevices/bracelet/chart/base/BaseChart;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    return-object v0
.end method

.method static synthetic d(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;)Lcn/com/smartdevices/bracelet/chart/base/BaseChart;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    return-object v0
.end method

.method static synthetic e(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;)Lcn/com/smartdevices/bracelet/chart/base/BaseChart;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    return-object v0
.end method


# virtual methods
.method public dismissLoading()V
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->d:Landroid/animation/Animator;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->d:Landroid/animation/Animator;

    invoke-virtual {v0}, Landroid/animation/Animator;->end()V

    :cond_0
    return-void
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 7

    const/high16 v6, 0x3f80

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->mAnimFactor:F

    cmpg-float v0, v0, v6

    if-gez v0, :cond_0

    iget-wide v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->b:J

    iget-wide v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->c:J

    iget-wide v4, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->b:J

    sub-long/2addr v2, v4

    long-to-float v2, v2

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->mAnimFactor:F

    mul-float/2addr v2, v3

    float-to-long v2, v2

    add-long v1, v0, v2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;

    long-to-float v1, v1

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->setValue(F)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;

    invoke-virtual {v0, p1, v6}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->draw(Landroid/graphics/Canvas;F)V

    :goto_0
    return-void

    :cond_0
    iget-wide v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->c:J

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;

    long-to-float v1, v1

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->setValue(F)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->mAnimFactor:F

    invoke-virtual {v0, p1, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->draw(Landroid/graphics/Canvas;F)V

    goto :goto_0
.end method

.method public setMaxValue(J)V
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;

    invoke-virtual {v0, p1, p2}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->setMaxValue(J)V

    return-void
.end method

.method public setValue(J)V
    .locals 2

    iget-wide v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->c:J

    iput-wide v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->b:J

    iput-wide p1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->c:J

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->a()V

    return-void
.end method

.method public showLoading()V
    .locals 2

    const-wide/16 v0, 0x0

    invoke-virtual {p0, v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->showLoading(J)V

    return-void
.end method

.method public showLoading(J)V
    .locals 2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->d:Landroid/animation/Animator;

    if-nez v0, :cond_0

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->b()Landroid/animation/Animator;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->d:Landroid/animation/Animator;

    :cond_0
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->d:Landroid/animation/Animator;

    invoke-virtual {v0}, Landroid/animation/Animator;->isStarted()Z

    move-result v0

    if-nez v0, :cond_2

    const-wide/16 v0, 0x0

    cmp-long v0, p1, v0

    if-lez v0, :cond_1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->d:Landroid/animation/Animator;

    invoke-virtual {v0, p1, p2}, Landroid/animation/Animator;->setStartDelay(J)V

    :cond_1
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->d:Landroid/animation/Animator;

    invoke-virtual {v0}, Landroid/animation/Animator;->start()V

    :cond_2
    return-void
.end method

.method public updateMode(I)V
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->mChart:Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;

    invoke-virtual {v0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->updateMode(I)V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->invalidate()V

    return-void
.end method
