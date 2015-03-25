.class Lcn/com/smartdevices/bracelet/chart/deprecated/d;
.super Lcn/com/smartdevices/bracelet/chart/deprecated/c;


# instance fields
.field final synthetic b:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;


# direct methods
.method private constructor <init>(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;)V
    .locals 1

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->b:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/c;-><init>(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;Lcn/com/smartdevices/bracelet/chart/deprecated/a;)V

    return-void
.end method

.method synthetic constructor <init>(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;Lcn/com/smartdevices/bracelet/chart/deprecated/a;)V
    .locals 0

    invoke-direct {p0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/d;-><init>(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;)V

    return-void
.end method


# virtual methods
.method protected itemHeight(Landroid/graphics/RectF;Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;)F
    .locals 5

    const/high16 v4, 0x3f800000    # 1.0f

    iget v0, p2, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->index:I

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->b:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->c(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;)I

    move-result v1

    if-le v0, v1, :cond_1

    const/4 v0, 0x0

    :cond_0
    :goto_0
    return v0

    :cond_1
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->b:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->f(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;)Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/b;

    iget v1, p2, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->scope:I

    int-to-float v1, v1

    const/high16 v2, 0x44b40000    # 1440.0f

    div-float/2addr v1, v2

    invoke-virtual {p1}, Landroid/graphics/RectF;->height()F

    move-result v2

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->mPaddingTop:F

    sub-float/2addr v2, v3

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->mPaddingBottom:F

    sub-float/2addr v2, v3

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->b:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;

    invoke-static {v3}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->a(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;)F

    move-result v3

    sub-float/2addr v2, v3

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/b;->getPaddingBottom()F

    move-result v0

    sub-float v0, v2, v0

    mul-float/2addr v0, v1

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->mDensity:F

    mul-float/2addr v1, v4

    cmpg-float v1, v0, v1

    if-gez v1, :cond_0

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->mDensity:F

    mul-float/2addr v0, v4

    goto :goto_0
.end method

.method protected itemOffsetX(Landroid/graphics/RectF;Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;)F
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method protected itemOffsetY(Landroid/graphics/RectF;Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;)F
    .locals 4

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->b:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->g(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;)Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/b;

    iget v1, p2, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->index:I

    int-to-float v1, v1

    const/high16 v2, 0x44b40000    # 1440.0f

    div-float/2addr v1, v2

    invoke-virtual {p1}, Landroid/graphics/RectF;->height()F

    move-result v2

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->mPaddingTop:F

    sub-float/2addr v2, v3

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->mPaddingBottom:F

    sub-float/2addr v2, v3

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->b:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;

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
    .locals 3

    iget v0, p2, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->value:I

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->mMaxItemValue:I

    if-lt v0, v1, :cond_0

    invoke-virtual {p1}, Landroid/graphics/RectF;->width()F

    move-result v0

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->mPaddingLeft:F

    sub-float/2addr v0, v1

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->mPaddingRight:F

    sub-float/2addr v0, v1

    :goto_0
    return v0

    :cond_0
    iget v0, p2, Lcn/com/smartdevices/bracelet/chart/base/BarChart$BarItem;->value:I

    int-to-float v0, v0

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->mMaxItemValue:I

    int-to-float v1, v1

    div-float/2addr v0, v1

    invoke-virtual {p1}, Landroid/graphics/RectF;->width()F

    move-result v1

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->mPaddingLeft:F

    sub-float/2addr v1, v2

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->mPaddingRight:F

    sub-float/2addr v1, v2

    mul-float/2addr v0, v1

    goto :goto_0
.end method
