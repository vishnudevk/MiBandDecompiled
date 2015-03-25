.class public Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;
.super Lcn/com/smartdevices/bracelet/chart/base/BarChart;


# static fields
.field private static final a:Ljava/lang/String; = "Chart.DynamicDetailChart"

.field private static final b:I = 0x5dc


# instance fields
.field private c:Lcn/com/smartdevices/bracelet/chart/deprecated/d;

.field private d:Lcn/com/smartdevices/bracelet/chart/deprecated/e;

.field private e:F

.field private f:F

.field private g:F

.field private h:I

.field private i:Ljava/lang/String;

.field private j:Ljava/lang/String;

.field private k:I

.field private l:Ljava/lang/String;

.field private m:Ljava/lang/String;

.field private n:Ljava/lang/String;

.field private o:Ljava/lang/String;

.field private p:Landroid/graphics/Paint;

.field private q:Landroid/graphics/Paint;

.field private r:Landroid/graphics/Paint;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 7

    const/4 v6, 0x0

    const/4 v5, 0x1

    const/high16 v4, 0x3f800000    # 1.0f

    const/4 v3, 0x0

    invoke-direct {p0, p1}, Lcn/com/smartdevices/bracelet/chart/base/BarChart;-><init>(Landroid/content/Context;)V

    iput v4, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->e:F

    iput v4, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->f:F

    new-instance v0, Lcn/com/smartdevices/bracelet/chart/deprecated/b;

    invoke-direct {v0, p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/b;-><init>(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mYAxis:Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mYAxis:Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;

    const/high16 v1, 0x41880000    # 17.0f

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mDensity:F

    mul-float/2addr v1, v2

    float-to-int v1, v1

    iput v1, v0, Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;->stroke:I

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mYAxis:Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;

    const/high16 v1, 0x41700000    # 15.0f

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mDensity:F

    mul-float/2addr v1, v2

    float-to-int v1, v1

    int-to-float v1, v1

    invoke-virtual {v0, v3, v3, v3, v1}, Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;->setPadding(FFFF)V

    new-instance v0, Lcn/com/smartdevices/bracelet/chart/deprecated/d;

    invoke-direct {v0, p0, v6}, Lcn/com/smartdevices/bracelet/chart/deprecated/d;-><init>(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;Lcn/com/smartdevices/bracelet/chart/deprecated/a;)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->c:Lcn/com/smartdevices/bracelet/chart/deprecated/d;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->c:Lcn/com/smartdevices/bracelet/chart/deprecated/d;

    const/high16 v1, 0x42700000    # 60.0f

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mDensity:F

    mul-float/2addr v1, v2

    float-to-int v1, v1

    int-to-float v1, v1

    invoke-virtual {v0, v3, v3, v1, v3}, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->setPadding(FFFF)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->c:Lcn/com/smartdevices/bracelet/chart/deprecated/d;

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->setMaxItemValue(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->c:Lcn/com/smartdevices/bracelet/chart/deprecated/d;

    invoke-virtual {v0, v4}, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->setItemPadding(F)V

    new-instance v0, Lcn/com/smartdevices/bracelet/chart/deprecated/e;

    invoke-direct {v0, p0, v6}, Lcn/com/smartdevices/bracelet/chart/deprecated/e;-><init>(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;Lcn/com/smartdevices/bracelet/chart/deprecated/a;)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->d:Lcn/com/smartdevices/bracelet/chart/deprecated/e;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->d:Lcn/com/smartdevices/bracelet/chart/deprecated/e;

    invoke-virtual {v0, v3, v3, v3, v3}, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->setPadding(FFFF)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->d:Lcn/com/smartdevices/bracelet/chart/deprecated/e;

    const/16 v1, 0x5dc

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->setMaxItemValue(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->d:Lcn/com/smartdevices/bracelet/chart/deprecated/e;

    invoke-virtual {v0, v4}, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->setItemPadding(F)V

    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->p:Landroid/graphics/Paint;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->p:Landroid/graphics/Paint;

    const v1, 0x4dffffff    # 5.3687088E8f

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->p:Landroid/graphics/Paint;

    invoke-virtual {v0, v4}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0, v5}, Landroid/graphics/Paint;-><init>(I)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->q:Landroid/graphics/Paint;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->q:Landroid/graphics/Paint;

    const v1, -0x7f000001

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0, v5}, Landroid/graphics/Paint;-><init>(I)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->r:Landroid/graphics/Paint;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->r:Landroid/graphics/Paint;

    const/4 v1, -0x1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    invoke-static {}, Lcn/com/smartdevices/bracelet/chart/typeface/TypefaceManager;->getInstance()Lcn/com/smartdevices/bracelet/chart/typeface/TypefaceManager;

    move-result-object v0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mContext:Landroid/content/Context;

    sget-object v2, Lcn/com/smartdevices/bracelet/chart/typeface/MIUITextStyle;->NORMAL:Lcn/com/smartdevices/bracelet/chart/typeface/MIUITextStyle;

    invoke-virtual {v0, v1, v2}, Lcn/com/smartdevices/bracelet/chart/typeface/TypefaceManager;->getTypeface(Landroid/content/Context;Lcn/com/smartdevices/bracelet/chart/typeface/TypefaceManager$TextStyle;)Landroid/graphics/Typeface;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->r:Landroid/graphics/Paint;

    invoke-virtual {v1, v0}, Landroid/graphics/Paint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;

    :cond_0
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->r:Landroid/graphics/Paint;

    const/high16 v1, 0x41500000    # 13.0f

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mDensity:F

    mul-float/2addr v1, v2

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextSize(F)V

    const/high16 v0, 0x428a0000    # 69.0f

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mDensity:F

    mul-float/2addr v0, v1

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->g:F

    return-void
.end method

.method static synthetic a(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;)F
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->g:F

    return v0
.end method

.method static synthetic a(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;F)F
    .locals 0

    iput p1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mScroll:F

    return p1
.end method

.method private a(Landroid/graphics/Canvas;F)V
    .locals 13

    const/high16 v12, 0x41900000    # 18.0f

    const/high16 v11, 0x41000000    # 8.0f

    const/high16 v10, 0x40a00000    # 5.0f

    const/high16 v9, 0x40000000    # 2.0f

    const/4 v8, 0x0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mYAxis:Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;

    move-object v6, v0

    check-cast v6, Lcn/com/smartdevices/bracelet/chart/deprecated/b;

    new-instance v7, Landroid/graphics/Rect;

    invoke-direct {v7}, Landroid/graphics/Rect;-><init>()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->q:Landroid/graphics/Paint;

    const/high16 v1, 0x41300000    # 11.0f

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mDensity:F

    mul-float/2addr v1, v2

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextSize(F)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->i:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mRect:Landroid/graphics/RectF;

    iget v1, v0, Landroid/graphics/RectF;->left:F

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mRect:Landroid/graphics/RectF;

    iget v0, v0, Landroid/graphics/RectF;->right:F

    mul-float v3, v0, p2

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->h:I

    int-to-float v0, v0

    const/high16 v2, 0x44b40000    # 1440.0f

    div-float/2addr v0, v2

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mRect:Landroid/graphics/RectF;

    invoke-virtual {v2}, Landroid/graphics/RectF;->height()F

    move-result v2

    iget v4, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->g:F

    sub-float/2addr v2, v4

    invoke-virtual {v6}, Lcn/com/smartdevices/bracelet/chart/deprecated/b;->getPaddingBottom()F

    move-result v4

    sub-float/2addr v2, v4

    mul-float/2addr v0, v2

    invoke-virtual {v6}, Lcn/com/smartdevices/bracelet/chart/deprecated/b;->c()F

    move-result v2

    add-float/2addr v0, v2

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->p:Landroid/graphics/Paint;

    invoke-virtual {v2}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v2

    div-float/2addr v2, v9

    add-float/2addr v2, v0

    iget-object v5, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->p:Landroid/graphics/Paint;

    move-object v0, p1

    move v4, v2

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->q:Landroid/graphics/Paint;

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->i:Ljava/lang/String;

    iget-object v4, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->i:Ljava/lang/String;

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    invoke-virtual {v0, v3, v8, v4, v7}, Landroid/graphics/Paint;->getTextBounds(Ljava/lang/String;IILandroid/graphics/Rect;)V

    const/high16 v0, 0x425c0000    # 55.0f

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mDensity:F

    mul-float/2addr v0, v3

    add-float/2addr v0, v1

    invoke-virtual {v7}, Landroid/graphics/Rect;->height()I

    move-result v1

    int-to-float v1, v1

    add-float/2addr v1, v2

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mDensity:F

    mul-float/2addr v2, v11

    add-float/2addr v1, v2

    mul-float/2addr v1, p2

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->i:Ljava/lang/String;

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->r:Landroid/graphics/Paint;

    invoke-virtual {p1, v2, v0, v1, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->j:Ljava/lang/String;

    invoke-virtual {v7}, Landroid/graphics/Rect;->width()I

    move-result v3

    int-to-float v3, v3

    add-float/2addr v0, v3

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mDensity:F

    mul-float/2addr v3, v10

    add-float/2addr v0, v3

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->q:Landroid/graphics/Paint;

    invoke-virtual {p1, v2, v0, v1, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    :cond_0
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->l:Ljava/lang/String;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mRect:Landroid/graphics/RectF;

    iget v1, v0, Landroid/graphics/RectF;->left:F

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mRect:Landroid/graphics/RectF;

    iget v0, v0, Landroid/graphics/RectF;->right:F

    mul-float v3, v0, p2

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->k:I

    int-to-float v0, v0

    const/high16 v2, 0x44b40000    # 1440.0f

    div-float/2addr v0, v2

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mRect:Landroid/graphics/RectF;

    invoke-virtual {v2}, Landroid/graphics/RectF;->height()F

    move-result v2

    iget v4, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->g:F

    sub-float/2addr v2, v4

    invoke-virtual {v6}, Lcn/com/smartdevices/bracelet/chart/deprecated/b;->getPaddingBottom()F

    move-result v4

    sub-float/2addr v2, v4

    mul-float/2addr v0, v2

    invoke-virtual {v6}, Lcn/com/smartdevices/bracelet/chart/deprecated/b;->c()F

    move-result v2

    add-float/2addr v0, v2

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->p:Landroid/graphics/Paint;

    invoke-virtual {v2}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v2

    div-float/2addr v2, v9

    add-float/2addr v2, v0

    float-to-int v0, v2

    const/4 v4, 0x1

    if-le v0, v4, :cond_1

    iget-object v5, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->p:Landroid/graphics/Paint;

    move-object v0, p1

    move v4, v2

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    :cond_1
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->q:Landroid/graphics/Paint;

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->l:Ljava/lang/String;

    iget-object v4, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->l:Ljava/lang/String;

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    invoke-virtual {v0, v3, v8, v4, v7}, Landroid/graphics/Paint;->getTextBounds(Ljava/lang/String;IILandroid/graphics/Rect;)V

    const/high16 v0, 0x425c0000    # 55.0f

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mDensity:F

    mul-float/2addr v0, v3

    add-float/2addr v0, v1

    invoke-virtual {v7}, Landroid/graphics/Rect;->height()I

    move-result v1

    int-to-float v1, v1

    add-float/2addr v1, v2

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mDensity:F

    mul-float/2addr v2, v11

    add-float/2addr v1, v2

    mul-float/2addr v1, p2

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->l:Ljava/lang/String;

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->r:Landroid/graphics/Paint;

    invoke-virtual {p1, v2, v0, v1, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->m:Ljava/lang/String;

    invoke-virtual {v7}, Landroid/graphics/Rect;->width()I

    move-result v3

    int-to-float v3, v3

    add-float/2addr v0, v3

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mDensity:F

    mul-float/2addr v3, v10

    add-float/2addr v0, v3

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->q:Landroid/graphics/Paint;

    invoke-virtual {p1, v2, v0, v1, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    :cond_2
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->n:Ljava/lang/String;

    if-nez v0, :cond_3

    const-string v0, ""

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->n:Ljava/lang/String;

    :cond_3
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mYAxis:Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;->getRect()Landroid/graphics/RectF;

    move-result-object v0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->q:Landroid/graphics/Paint;

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->n:Ljava/lang/String;

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->n:Ljava/lang/String;

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    invoke-virtual {v1, v2, v8, v3, v7}, Landroid/graphics/Paint;->getTextBounds(Ljava/lang/String;IILandroid/graphics/Rect;)V

    invoke-virtual {v0}, Landroid/graphics/RectF;->centerX()F

    move-result v1

    invoke-virtual {v7}, Landroid/graphics/Rect;->width()I

    move-result v2

    div-int/lit8 v2, v2, 0x2

    int-to-float v2, v2

    sub-float/2addr v1, v2

    iget v2, v0, Landroid/graphics/RectF;->bottom:F

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->g:F

    sub-float/2addr v2, v3

    invoke-virtual {v7}, Landroid/graphics/Rect;->height()I

    move-result v3

    int-to-float v3, v3

    add-float/2addr v2, v3

    const/high16 v3, 0x41200000    # 10.0f

    iget v4, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mDensity:F

    mul-float/2addr v3, v4

    add-float/2addr v2, v3

    invoke-virtual {v6}, Lcn/com/smartdevices/bracelet/chart/deprecated/b;->c()F

    move-result v3

    add-float/2addr v2, v3

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->n:Ljava/lang/String;

    iget-object v4, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->q:Landroid/graphics/Paint;

    invoke-virtual {p1, v3, v1, v2, v4}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->q:Landroid/graphics/Paint;

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mDensity:F

    mul-float/2addr v2, v12

    invoke-virtual {v1, v2}, Landroid/graphics/Paint;->setTextSize(F)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->o:Ljava/lang/String;

    if-nez v1, :cond_4

    const-string v1, ""

    iput-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->o:Ljava/lang/String;

    :cond_4
    invoke-virtual {v7}, Landroid/graphics/Rect;->height()I

    move-result v1

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->q:Landroid/graphics/Paint;

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->o:Ljava/lang/String;

    iget-object v4, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->o:Ljava/lang/String;

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    invoke-virtual {v2, v3, v8, v4, v7}, Landroid/graphics/Paint;->getTextBounds(Ljava/lang/String;IILandroid/graphics/Rect;)V

    invoke-virtual {v0}, Landroid/graphics/RectF;->centerX()F

    move-result v2

    invoke-virtual {v7}, Landroid/graphics/Rect;->width()I

    move-result v3

    div-int/lit8 v3, v3, 0x2

    int-to-float v3, v3

    sub-float/2addr v2, v3

    iget v0, v0, Landroid/graphics/RectF;->bottom:F

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->g:F

    sub-float/2addr v0, v3

    int-to-float v1, v1

    add-float/2addr v0, v1

    invoke-virtual {v7}, Landroid/graphics/Rect;->height()I

    move-result v1

    int-to-float v1, v1

    add-float/2addr v0, v1

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mDensity:F

    mul-float/2addr v1, v12

    add-float/2addr v0, v1

    invoke-virtual {v6}, Lcn/com/smartdevices/bracelet/chart/deprecated/b;->c()F

    move-result v1

    add-float/2addr v0, v1

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->o:Ljava/lang/String;

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->q:Landroid/graphics/Paint;

    invoke-virtual {p1, v1, v2, v0, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    return-void
.end method

.method static synthetic b(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;)I
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->h:I

    return v0
.end method

.method static synthetic c(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;)I
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->k:I

    return v0
.end method

.method static synthetic d(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;)Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mYAxis:Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;

    return-object v0
.end method

.method static synthetic e(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;)Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mYAxis:Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;

    return-object v0
.end method

.method static synthetic f(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;)Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mYAxis:Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;

    return-object v0
.end method

.method static synthetic g(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;)Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mYAxis:Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;

    return-object v0
.end method


# virtual methods
.method public addSleepData(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld$DynamicDetailBarItem;",
            ">;)V"
        }
    .end annotation

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->c:Lcn/com/smartdevices/bracelet/chart/deprecated/d;

    invoke-virtual {v0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->addItems(Ljava/util/List;)V

    return-void
.end method

.method public addStepData(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld$DynamicDetailBarItem;",
            ">;)V"
        }
    .end annotation

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->d:Lcn/com/smartdevices/bracelet/chart/deprecated/e;

    invoke-virtual {v0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->addItems(Ljava/util/List;)V

    return-void
.end method

.method public clearSleepData()V
    .locals 3

    const/4 v2, 0x0

    const/4 v1, 0x0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->c:Lcn/com/smartdevices/bracelet/chart/deprecated/d;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->clearItems()V

    iput v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->h:I

    iput v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->k:I

    iput-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->i:Ljava/lang/String;

    iput-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->l:Ljava/lang/String;

    return-void
.end method

.method public clearStepData()V
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->d:Lcn/com/smartdevices/bracelet/chart/deprecated/e;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->clearItems()V

    const/4 v0, 0x0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->o:Ljava/lang/String;

    return-void
.end method

.method protected doScroll(F)V
    .locals 4

    const/4 v3, 0x0

    const-string v0, "Chart.DynamicDetailChart"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Scroll :"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->w(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mLoadCallback:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;

    if-nez v0, :cond_0

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mYAxis:Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/b;

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mScroll:F

    cmpl-float v1, v1, v3

    if-lez v1, :cond_1

    iput v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mScroll:F

    :cond_1
    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mScroll:F

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/b;->d()F

    move-result v2

    cmpg-float v1, v1, v2

    if-gez v1, :cond_2

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/b;->d()F

    move-result v1

    iput v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mScroll:F

    :cond_2
    const-string v1, "Chart.DynamicDetailChart"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "ScrollTo : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mScroll:F

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/Debug;->w(Ljava/lang/String;Ljava/lang/String;)V

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mScroll:F

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/b;->scrollTo(F)V

    goto :goto_0
.end method

.method public draw(Landroid/graphics/Canvas;F)V
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->c:Lcn/com/smartdevices/bracelet/chart/deprecated/d;

    invoke-virtual {v0, p1, p2}, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->draw(Landroid/graphics/Canvas;F)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->d:Lcn/com/smartdevices/bracelet/chart/deprecated/e;

    invoke-virtual {v0, p1, p2}, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->draw(Landroid/graphics/Canvas;F)V

    invoke-super {p0, p1, p2}, Lcn/com/smartdevices/bracelet/chart/base/BarChart;->draw(Landroid/graphics/Canvas;F)V

    invoke-direct {p0, p1, p2}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->a(Landroid/graphics/Canvas;F)V

    return-void
.end method

.method public fillSleepData(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld$DynamicDetailBarItem;",
            ">;)V"
        }
    .end annotation

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->c:Lcn/com/smartdevices/bracelet/chart/deprecated/d;

    invoke-virtual {v0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->fillItems(Ljava/util/List;)V

    return-void
.end method

.method public fillStepData(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld$DynamicDetailBarItem;",
            ">;)V"
        }
    .end annotation

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->d:Lcn/com/smartdevices/bracelet/chart/deprecated/e;

    invoke-virtual {v0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->fillItems(Ljava/util/List;)V

    return-void
.end method

.method public getEdgeLength()F
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mYAxis:Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/b;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/b;->d()F

    move-result v0

    return v0
.end method

.method public notifyChanged()V
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->c:Lcn/com/smartdevices/bracelet/chart/deprecated/d;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->notifyChanged()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->d:Lcn/com/smartdevices/bracelet/chart/deprecated/e;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->notifyChanged()V

    return-void
.end method

.method protected onRectChanged(Landroid/graphics/RectF;)V
    .locals 5

    const/high16 v4, 0x3f800000    # 1.0f

    invoke-super {p0, p1}, Lcn/com/smartdevices/bracelet/chart/base/BarChart;->onRectChanged(Landroid/graphics/RectF;)V

    new-instance v0, Landroid/graphics/RectF;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mYAxis:Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;

    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;->getRect()Landroid/graphics/RectF;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/graphics/RectF;-><init>(Landroid/graphics/RectF;)V

    invoke-virtual {p1}, Landroid/graphics/RectF;->width()F

    move-result v1

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mYAxis:Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;

    iget v2, v2, Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;->stroke:I

    int-to-float v2, v2

    sub-float/2addr v1, v2

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->e:F

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->f:F

    add-float/2addr v2, v3

    div-float/2addr v1, v2

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->f:F

    mul-float/2addr v1, v2

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/graphics/RectF;->offset(FF)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mYAxis:Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;

    invoke-virtual {v1, v0}, Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;->setRect(Landroid/graphics/RectF;)V

    new-instance v1, Landroid/graphics/RectF;

    invoke-direct {v1, p1}, Landroid/graphics/RectF;-><init>(Landroid/graphics/RectF;)V

    iget v2, v0, Landroid/graphics/RectF;->right:F

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mDensity:F

    mul-float/2addr v3, v4

    add-float/2addr v2, v3

    iput v2, v1, Landroid/graphics/RectF;->left:F

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->d:Lcn/com/smartdevices/bracelet/chart/deprecated/e;

    invoke-virtual {v2, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/e;->setRect(Landroid/graphics/RectF;)V

    new-instance v1, Landroid/graphics/RectF;

    invoke-direct {v1, p1}, Landroid/graphics/RectF;-><init>(Landroid/graphics/RectF;)V

    iget v0, v0, Landroid/graphics/RectF;->right:F

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mDensity:F

    mul-float/2addr v2, v4

    add-float/2addr v0, v2

    iput v0, v1, Landroid/graphics/RectF;->left:F

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->c:Lcn/com/smartdevices/bracelet/chart/deprecated/d;

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/d;->setRect(Landroid/graphics/RectF;)V

    return-void
.end method

.method public setOffset(I)V
    .locals 2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->mYAxis:Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/b;

    invoke-static {v0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/b;->a(Lcn/com/smartdevices/bracelet/chart/deprecated/b;I)I

    const/4 v1, 0x0

    iput v1, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/b;->offset:I

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/b;->a()V

    return-void
.end method

.method public setSleepRiseTime(ILjava/lang/String;Ljava/lang/String;)V
    .locals 0

    iput p1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->k:I

    iput-object p2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->l:Ljava/lang/String;

    iput-object p3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->m:Ljava/lang/String;

    return-void
.end method

.method public setSleepStartTime(ILjava/lang/String;Ljava/lang/String;)V
    .locals 0

    iput p1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->h:I

    iput-object p2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->i:Ljava/lang/String;

    iput-object p3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->j:Ljava/lang/String;

    return-void
.end method

.method public setStepTime(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->n:Ljava/lang/String;

    iput-object p2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartOld;->o:Ljava/lang/String;

    return-void
.end method
