.class public Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld$StatisticBarItem;
.super Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;-><init>()V

    return-void
.end method


# virtual methods
.method protected draw(Landroid/graphics/Canvas;Landroid/graphics/RectF;F)V
    .locals 6

    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld$StatisticBarItem;->needDraw:Z

    if-nez v0, :cond_0

    invoke-virtual {p2}, Landroid/graphics/RectF;->height()F

    move-result v0

    const/4 v1, 0x0

    cmpl-float v0, v0, v1

    if-nez v0, :cond_0

    :goto_0
    return-void

    :cond_0
    iget v0, p2, Landroid/graphics/RectF;->left:F

    invoke-virtual {p2}, Landroid/graphics/RectF;->width()F

    move-result v1

    const/high16 v2, 0x4000

    div-float/2addr v1, v2

    add-float/2addr v1, v0

    iget v2, p2, Landroid/graphics/RectF;->bottom:F

    iget v0, p2, Landroid/graphics/RectF;->bottom:F

    invoke-virtual {p2}, Landroid/graphics/RectF;->height()F

    move-result v3

    mul-float/2addr v3, p3

    sub-float v4, v0, v3

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld$StatisticBarItem;->mRenderer:Lcn/com/smartdevices/bracelet/chart/base/Renderer;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/chart/base/Renderer;->paint:Landroid/graphics/Paint;

    invoke-virtual {p2}, Landroid/graphics/RectF;->width()F

    move-result v3

    invoke-virtual {v0, v3}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld$StatisticBarItem;->mRenderer:Lcn/com/smartdevices/bracelet/chart/base/Renderer;

    iget-object v5, v0, Lcn/com/smartdevices/bracelet/chart/base/Renderer;->paint:Landroid/graphics/Paint;

    move-object v0, p1

    move v3, v1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    goto :goto_0
.end method
