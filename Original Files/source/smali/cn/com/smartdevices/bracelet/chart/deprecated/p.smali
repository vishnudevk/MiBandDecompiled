.class Lcn/com/smartdevices/bracelet/chart/deprecated/p;
.super Lcn/com/smartdevices/bracelet/chart/base/BarChart$XAxis;


# instance fields
.field final synthetic a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;

.field private b:Landroid/graphics/Paint;


# direct methods
.method public constructor <init>(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;)V
    .locals 3

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/p;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/chart/base/BarChart$XAxis;-><init>()V

    new-instance v0, Landroid/text/TextPaint;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Landroid/text/TextPaint;-><init>(I)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/p;->b:Landroid/graphics/Paint;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/p;->b:Landroid/graphics/Paint;

    const/4 v1, -0x1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/p;->b:Landroid/graphics/Paint;

    const/high16 v1, 0x4100

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/p;->mDensity:F

    mul-float/2addr v1, v2

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextSize(F)V

    return-void
.end method


# virtual methods
.method protected doScroll(F)V
    .locals 3

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/p;->mScroll:F

    invoke-static {}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->a()F

    move-result v1

    div-float/2addr v0, v1

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v0

    neg-int v0, v0

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/p;->offset:I

    const-string v0, "Chart.StatisticChart"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "DateLine Offset : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/p;->offset:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method protected draw(Landroid/graphics/Canvas;Landroid/graphics/RectF;F)V
    .locals 11

    const/high16 v10, 0x4000

    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0, p2}, Landroid/graphics/RectF;-><init>(Landroid/graphics/RectF;)V

    iget v1, p2, Landroid/graphics/RectF;->right:F

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/p;->mPaddingRight:F

    sub-float/2addr v1, v2

    iput v1, v0, Landroid/graphics/RectF;->right:F

    invoke-virtual {p1, v0}, Landroid/graphics/Canvas;->clipRect(Landroid/graphics/RectF;)Z

    new-instance v1, Landroid/graphics/Rect;

    invoke-direct {v1}, Landroid/graphics/Rect;-><init>()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/p;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->a(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;)Ljava/util/List;

    move-result-object v2

    monitor-enter v2

    :try_start_0
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/p;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->a(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld$DateItem;

    iget v4, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld$DateItem;->a:I

    iget v5, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/p;->offset:I

    add-int/lit8 v5, v5, 0x1

    if-gt v4, v5, :cond_0

    iget v4, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld$DateItem;->a:I

    iget v5, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/p;->offset:I

    add-int/lit8 v5, v5, -0x8

    if-lt v4, v5, :cond_0

    iget v4, p2, Landroid/graphics/RectF;->right:F

    iget v5, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/p;->mPaddingRight:F

    sub-float/2addr v4, v5

    iget v5, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld$DateItem;->a:I

    add-int/lit8 v5, v5, -0x1

    int-to-float v5, v5

    invoke-static {}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->a()F

    move-result v6

    mul-float/2addr v5, v6

    add-float/2addr v4, v5

    iget v5, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/p;->mScroll:F

    add-float/2addr v4, v5

    iget v5, p2, Landroid/graphics/RectF;->top:F

    iget-object v6, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/p;->mRect:Landroid/graphics/RectF;

    iget v6, v6, Landroid/graphics/RectF;->right:F

    iget v7, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/p;->mPaddingRight:F

    sub-float/2addr v6, v7

    invoke-static {}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->a()F

    move-result v7

    mul-float/2addr v7, v10

    sub-float/2addr v6, v7

    cmpg-float v6, v4, v6

    if-gtz v6, :cond_1

    iget-object v6, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/p;->b:Landroid/graphics/Paint;

    const/high16 v7, 0x4100

    iget v8, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/p;->mDensity:F

    mul-float/2addr v7, v8

    invoke-virtual {v6, v7}, Landroid/graphics/Paint;->setTextSize(F)V

    :goto_1
    iget-object v6, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/p;->b:Landroid/graphics/Paint;

    iget-object v7, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld$DateItem;->b:Ljava/lang/String;

    const/4 v8, 0x0

    iget-object v9, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld$DateItem;->b:Ljava/lang/String;

    invoke-virtual {v9}, Ljava/lang/String;->length()I

    move-result v9

    invoke-virtual {v6, v7, v8, v9, v1}, Landroid/graphics/Paint;->getTextBounds(Ljava/lang/String;IILandroid/graphics/Rect;)V

    invoke-static {}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->a()F

    move-result v6

    invoke-virtual {v1}, Landroid/graphics/Rect;->width()I

    move-result v7

    int-to-float v7, v7

    sub-float/2addr v6, v7

    div-float/2addr v6, v10

    add-float/2addr v4, v6

    iget v6, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/p;->stroke:I

    invoke-virtual {v1}, Landroid/graphics/Rect;->height()I

    move-result v7

    add-int/2addr v6, v7

    int-to-float v6, v6

    div-float/2addr v6, v10

    add-float/2addr v5, v6

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld$DateItem;->b:Ljava/lang/String;

    iget-object v6, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/p;->b:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v4, v5, v6}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    :cond_1
    :try_start_1
    iget-object v6, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/p;->b:Landroid/graphics/Paint;

    const/high16 v7, 0x4120

    iget v8, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/p;->mDensity:F

    mul-float/2addr v7, v8

    invoke-virtual {v6, v7}, Landroid/graphics/Paint;->setTextSize(F)V

    goto :goto_1

    :cond_2
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    invoke-virtual {p1}, Landroid/graphics/Canvas;->restore()V

    return-void
.end method
