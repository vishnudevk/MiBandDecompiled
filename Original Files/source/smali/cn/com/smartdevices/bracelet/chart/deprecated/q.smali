.class Lcn/com/smartdevices/bracelet/chart/deprecated/q;
.super Lcn/com/smartdevices/bracelet/chart/base/BarChart;


# instance fields
.field final synthetic a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;


# direct methods
.method private constructor <init>(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/q;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/chart/base/BarChart;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;Lcn/com/smartdevices/bracelet/chart/deprecated/o;)V
    .locals 0

    invoke-direct {p0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/q;-><init>(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;)V

    return-void
.end method


# virtual methods
.method protected draw(Landroid/graphics/Canvas;Landroid/graphics/RectF;F)V
    .locals 0

    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    invoke-virtual {p1, p2}, Landroid/graphics/Canvas;->clipRect(Landroid/graphics/RectF;)Z

    invoke-super {p0, p1, p2, p3}, Lcn/com/smartdevices/bracelet/chart/base/BarChart;->draw(Landroid/graphics/Canvas;Landroid/graphics/RectF;F)V

    invoke-virtual {p1}, Landroid/graphics/Canvas;->restore()V

    return-void
.end method

.method protected itemHeight(Landroid/graphics/RectF;Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;)F
    .locals 4

    const/high16 v3, 0x3f80

    iget v0, p2, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->value:I

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/q;->mMaxItemValue:I

    if-lt v0, v1, :cond_0

    invoke-virtual {p1}, Landroid/graphics/RectF;->height()F

    move-result v0

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/q;->mPaddingTop:F

    sub-float/2addr v0, v1

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/q;->mPaddingBottom:F

    sub-float/2addr v0, v1

    :goto_0
    return v0

    :cond_0
    iget v0, p2, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->value:I

    int-to-float v0, v0

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/q;->mMaxItemValue:I

    int-to-float v1, v1

    div-float/2addr v0, v1

    invoke-virtual {p1}, Landroid/graphics/RectF;->height()F

    move-result v1

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/q;->mDensity:F

    mul-float/2addr v2, v3

    sub-float/2addr v1, v2

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/q;->mPaddingTop:F

    sub-float/2addr v1, v2

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/q;->mPaddingBottom:F

    sub-float/2addr v1, v2

    mul-float/2addr v0, v1

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/q;->mDensity:F

    mul-float/2addr v1, v3

    add-float/2addr v0, v1

    goto :goto_0
.end method

.method protected itemOffsetX(Landroid/graphics/RectF;Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;)F
    .locals 3

    invoke-virtual {p1}, Landroid/graphics/RectF;->width()F

    move-result v0

    iget v1, p2, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->index:I

    add-int/lit8 v1, v1, -0x1

    int-to-float v1, v1

    invoke-static {}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->a()F

    move-result v2

    mul-float/2addr v1, v2

    add-float/2addr v0, v1

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/q;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->b(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;)Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;

    move-result-object v1

    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;->getScroll()F

    move-result v1

    add-float/2addr v0, v1

    return v0
.end method

.method protected itemWidth(Landroid/graphics/RectF;Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;)F
    .locals 3

    invoke-static {}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->a()F

    move-result v0

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/q;->mItemPadding:F

    const/high16 v2, 0x4000

    mul-float/2addr v1, v2

    sub-float/2addr v0, v1

    return v0
.end method
