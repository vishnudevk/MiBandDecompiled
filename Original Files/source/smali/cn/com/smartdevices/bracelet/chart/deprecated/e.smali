.class Lcn/com/smartdevices/bracelet/chart/deprecated/e;
.super Lcn/com/smartdevices/bracelet/chart/deprecated/c;


# instance fields
.field final synthetic b:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;

.field private c:F

.field private d:I

.field private e:I


# direct methods
.method private constructor <init>(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;)V
    .locals 1

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->b:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/c;-><init>(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;Lcn/com/smartdevices/bracelet/chart/deprecated/a;)V

    const/16 v0, 0xa

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->e:I

    return-void
.end method

.method synthetic constructor <init>(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;Lcn/com/smartdevices/bracelet/chart/deprecated/a;)V
    .locals 0

    invoke-direct {p0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/e;-><init>(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;)V

    return-void
.end method

.method private a(I)F
    .locals 3

    if-gtz p1, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->c:F

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->e:I

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->e:I

    sub-int/2addr v2, p1

    add-int/lit8 v2, v2, 0x1

    add-int/2addr v1, v2

    mul-int/2addr v1, p1

    int-to-float v1, v1

    const/high16 v2, 0x4000

    div-float/2addr v1, v2

    mul-float/2addr v0, v1

    goto :goto_0
.end method


# virtual methods
.method protected a()V
    .locals 3

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->mRect:Landroid/graphics/RectF;

    if-eqz v0, :cond_0

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->mMaxItemValue:I

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->e:I

    div-int/2addr v0, v1

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->d:I

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->mRect:Landroid/graphics/RectF;

    invoke-virtual {v0}, Landroid/graphics/RectF;->width()F

    move-result v0

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->mPaddingLeft:F

    sub-float/2addr v0, v1

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->mPaddingRight:F

    sub-float/2addr v0, v1

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->d:I

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->e:I

    mul-int/2addr v1, v2

    int-to-float v1, v1

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->mMaxItemValue:I

    int-to-float v2, v2

    div-float/2addr v1, v2

    mul-float/2addr v0, v1

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->e:I

    add-int/lit8 v1, v1, 0x1

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->e:I

    mul-int/2addr v1, v2

    int-to-float v1, v1

    const/high16 v2, 0x4000

    div-float/2addr v1, v2

    div-float/2addr v0, v1

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->c:F

    :cond_0
    return-void
.end method

.method protected a(Ljava/util/List;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;",
            ">;)V"
        }
    .end annotation

    const/16 v1, 0x5dc

    iput v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->mMaxItemValue:I

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->mItems:Ljava/util/List;

    monitor-enter v3

    :try_start_0
    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->mItems:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_0
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;

    move-object v0, v1

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld$DynamicDetailBarItem;

    move-object v2, v0

    iget v2, v2, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld$DynamicDetailBarItem;->index:I

    if-ltz v2, :cond_0

    iget v2, v1, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->value:I

    iget v5, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->mMaxItemValue:I

    if-le v2, v5, :cond_0

    iget v1, v1, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->value:I

    iput v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->mMaxItemValue:I

    goto :goto_0

    :catchall_0
    move-exception v1

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1

    :cond_1
    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    return-void
.end method

.method protected itemHeight(Landroid/graphics/RectF;Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;)F
    .locals 4

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->b:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->d(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;)Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/b;

    iget v1, p2, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->scope:I

    int-to-float v1, v1

    const/high16 v2, 0x41c0

    div-float/2addr v1, v2

    invoke-virtual {p1}, Landroid/graphics/RectF;->height()F

    move-result v2

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->mPaddingTop:F

    sub-float/2addr v2, v3

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->mPaddingBottom:F

    sub-float/2addr v2, v3

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->b:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;

    invoke-static {v3}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->a(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;)F

    move-result v3

    sub-float/2addr v2, v3

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/b;->getPaddingBottom()F

    move-result v0

    sub-float v0, v2, v0

    mul-float/2addr v0, v1

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->mItemPadding:F

    const/high16 v2, 0x4000

    mul-float/2addr v1, v2

    sub-float/2addr v0, v1

    return v0
.end method

.method protected itemOffsetX(Landroid/graphics/RectF;Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;)F
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method protected itemOffsetY(Landroid/graphics/RectF;Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;)F
    .locals 4

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->b:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->e(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;)Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/b;

    iget v1, p2, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->index:I

    int-to-float v1, v1

    const/high16 v2, 0x41c0

    div-float/2addr v1, v2

    invoke-virtual {p1}, Landroid/graphics/RectF;->height()F

    move-result v2

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->mPaddingTop:F

    sub-float/2addr v2, v3

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->mPaddingBottom:F

    sub-float/2addr v2, v3

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->b:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;

    invoke-static {v3}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->a(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;)F

    move-result v3

    sub-float/2addr v2, v3

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/b;->getPaddingBottom()F

    move-result v3

    sub-float/2addr v2, v3

    mul-float/2addr v1, v2

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/b;->c()F

    move-result v0

    add-float/2addr v0, v1

    return v0
.end method

.method protected itemWidth(Landroid/graphics/RectF;Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;)F
    .locals 4

    iget v0, p2, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->value:I

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->mMaxItemValue:I

    if-lt v0, v1, :cond_0

    invoke-virtual {p1}, Landroid/graphics/RectF;->width()F

    move-result v0

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->mPaddingLeft:F

    sub-float/2addr v0, v1

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->mPaddingRight:F

    sub-float/2addr v0, v1

    :goto_0
    return v0

    :cond_0
    iget v0, p2, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->value:I

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->d:I

    add-int/2addr v0, v1

    add-int/lit8 v0, v0, -0x1

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->d:I

    div-int/2addr v0, v1

    iget v1, p2, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->value:I

    add-int/lit8 v1, v1, -0x1

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->d:I

    rem-int/2addr v1, v2

    add-int/lit8 v1, v1, 0x1

    int-to-float v1, v1

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->d:I

    int-to-float v2, v2

    div-float/2addr v1, v2

    add-int/lit8 v2, v0, -0x1

    invoke-direct {p0, v2}, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->a(I)F

    move-result v2

    invoke-direct {p0, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->a(I)F

    move-result v3

    add-int/lit8 v0, v0, -0x1

    invoke-direct {p0, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->a(I)F

    move-result v0

    sub-float v0, v3, v0

    mul-float/2addr v0, v1

    add-float/2addr v0, v2

    goto :goto_0
.end method

.method protected onItemsChanged(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;",
            ">;)V"
        }
    .end annotation

    invoke-super {p0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/c;->onItemsChanged(Ljava/util/List;)V

    invoke-virtual {p0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->a(Ljava/util/List;)V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->a()V

    return-void
.end method

.method protected onRectChanged(Landroid/graphics/RectF;)V
    .locals 0

    invoke-super {p0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/c;->onRectChanged(Landroid/graphics/RectF;)V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->a()V

    return-void
.end method
