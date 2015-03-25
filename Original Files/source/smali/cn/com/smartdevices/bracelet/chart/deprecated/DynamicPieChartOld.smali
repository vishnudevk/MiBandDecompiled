.class public Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;
.super Lcn/com/smartdevices/bracelet/chart/base/PieChart;


# static fields
.field public static final MODE_CALORIE:I = 0x2

.field public static final MODE_GOAL:I = 0x3

.field public static final MODE_NONE:I = 0x0

.field public static final MODE_STEPS:I = 0x1

.field private static final a:Ljava/lang/String; = "Chart.DynamicPieChart"

.field private static final b:F = 8.3f


# instance fields
.field private c:Z

.field private d:I

.field private e:Landroid/graphics/Bitmap;

.field private f:Landroid/graphics/Bitmap;

.field private g:Landroid/graphics/Bitmap;

.field private h:Landroid/graphics/Paint;

.field private i:Landroid/graphics/Paint;

.field private j:Landroid/graphics/Matrix;

.field private k:Landroid/graphics/Shader;

.field private l:F

.field private m:Landroid/graphics/RectF;

.field private n:F

.field private o:Landroid/graphics/Paint;

.field private p:Landroid/graphics/RectF;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 4

    const v3, 0x4104cccd

    const/4 v2, 0x1

    invoke-direct {p0, p1}, Lcn/com/smartdevices/bracelet/chart/base/PieChart;-><init>(Landroid/content/Context;)V

    iput v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->d:I

    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0, v2}, Landroid/graphics/Paint;-><init>(I)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->h:Landroid/graphics/Paint;

    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0, v2}, Landroid/graphics/Paint;-><init>(I)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->i:Landroid/graphics/Paint;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->h:Landroid/graphics/Paint;

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->mDensity:F

    mul-float/2addr v1, v3

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->h:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->h:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Paint$Cap;->ROUND:Landroid/graphics/Paint$Cap;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStrokeCap(Landroid/graphics/Paint$Cap;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->i:Landroid/graphics/Paint;

    const-string v1, "#33ffffff"

    invoke-static {v1}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->i:Landroid/graphics/Paint;

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->mDensity:F

    mul-float/2addr v1, v3

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->i:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    new-instance v0, Landroid/graphics/Matrix;

    invoke-direct {v0}, Landroid/graphics/Matrix;-><init>()V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->j:Landroid/graphics/Matrix;

    const/high16 v0, 0x41a0

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->mDensity:F

    mul-float/2addr v0, v1

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->n:F

    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0, v2}, Landroid/graphics/Paint;-><init>(I)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->o:Landroid/graphics/Paint;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->o:Landroid/graphics/Paint;

    const-string v1, "#33ffffff"

    invoke-static {v1}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->o:Landroid/graphics/Paint;

    const/high16 v1, 0x3f80

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->mDensity:F

    mul-float/2addr v1, v2

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->o:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    return-void
.end method


# virtual methods
.method public dismissLoading()V
    .locals 1

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->c:Z

    return-void
.end method

.method protected drawPie(Landroid/graphics/Canvas;Landroid/graphics/RectF;FFFFF)V
    .locals 6

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->o:Landroid/graphics/Paint;

    invoke-virtual {v0}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v0

    const/high16 v1, 0x4000

    div-float/2addr v0, v1

    sub-float v0, p5, v0

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->n:F

    sub-float/2addr v0, v1

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->o:Landroid/graphics/Paint;

    invoke-virtual {p1, p3, p4, v0, v1}, Landroid/graphics/Canvas;->drawCircle(FFFLandroid/graphics/Paint;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->i:Landroid/graphics/Paint;

    invoke-virtual {v0}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v0

    const/high16 v1, 0x4000

    div-float/2addr v0, v1

    sub-float v0, p5, v0

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->n:F

    const/high16 v2, 0x4000

    mul-float/2addr v1, v2

    sub-float/2addr v0, v1

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->i:Landroid/graphics/Paint;

    invoke-virtual {p1, p3, p4, v0, v1}, Landroid/graphics/Canvas;->drawCircle(FFFLandroid/graphics/Paint;)V

    mul-float v0, p6, p7

    const/high16 v1, 0x3f80

    cmpl-float v1, v0, v1

    if-lez v1, :cond_0

    const/high16 v0, 0x3f80

    :cond_0
    iget-boolean v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->c:Z

    if-eqz v1, :cond_2

    const/4 v1, 0x3

    new-array v1, v1, [I

    fill-array-data v1, :array_0

    const/4 v2, 0x0

    cmpl-float v2, v0, v2

    if-nez v2, :cond_1

    const/high16 v0, 0x3f00

    :cond_1
    const/4 v2, 0x3

    new-array v2, v2, [F

    const/4 v3, 0x0

    const/4 v4, 0x0

    aput v4, v2, v3

    const/4 v3, 0x1

    aput v0, v2, v3

    const/4 v3, 0x2

    const/high16 v4, 0x3f80

    aput v4, v2, v3

    new-instance v3, Landroid/graphics/SweepGradient;

    invoke-direct {v3, p3, p4, v1, v2}, Landroid/graphics/SweepGradient;-><init>(FF[I[F)V

    iput-object v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->k:Landroid/graphics/Shader;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->j:Landroid/graphics/Matrix;

    const/high16 v2, -0x3d4c

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->mRotate:F

    add-float/2addr v2, v3

    invoke-virtual {v1, v2, p3, p4}, Landroid/graphics/Matrix;->setRotate(FFF)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->k:Landroid/graphics/Shader;

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->j:Landroid/graphics/Matrix;

    invoke-virtual {v1, v2}, Landroid/graphics/Shader;->setLocalMatrix(Landroid/graphics/Matrix;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->h:Landroid/graphics/Paint;

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->k:Landroid/graphics/Shader;

    invoke-virtual {v1, v2}, Landroid/graphics/Paint;->setShader(Landroid/graphics/Shader;)Landroid/graphics/Shader;

    :goto_0
    const/high16 v1, 0x3f80

    cmpg-float v1, v0, v1

    if-gez v1, :cond_3

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->m:Landroid/graphics/RectF;

    const/high16 v2, -0x3d4c

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->mRotate:F

    add-float/2addr v2, v3

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->l:F

    add-float/2addr v2, v3

    const/high16 v3, 0x43b4

    iget v4, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->l:F

    const/high16 v5, 0x4000

    mul-float/2addr v4, v5

    sub-float/2addr v3, v4

    mul-float/2addr v3, v0

    const/4 v4, 0x0

    iget-object v5, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->h:Landroid/graphics/Paint;

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawArc(Landroid/graphics/RectF;FFZLandroid/graphics/Paint;)V

    :goto_1
    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->d:I

    packed-switch v0, :pswitch_data_0

    :goto_2
    :pswitch_0
    return-void

    :cond_2
    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->h:Landroid/graphics/Paint;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/graphics/Paint;->setShader(Landroid/graphics/Shader;)Landroid/graphics/Shader;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->h:Landroid/graphics/Paint;

    const/4 v2, -0x1

    invoke-virtual {v1, v2}, Landroid/graphics/Paint;->setColor(I)V

    goto :goto_0

    :cond_3
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->i:Landroid/graphics/Paint;

    invoke-virtual {v0}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v0

    const/high16 v1, 0x4000

    div-float/2addr v0, v1

    sub-float v0, p5, v0

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->n:F

    const/high16 v2, 0x4000

    mul-float/2addr v1, v2

    sub-float/2addr v0, v1

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->h:Landroid/graphics/Paint;

    invoke-virtual {p1, p3, p4, v0, v1}, Landroid/graphics/Canvas;->drawCircle(FFFLandroid/graphics/Paint;)V

    goto :goto_1

    :pswitch_1
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->p:Landroid/graphics/RectF;

    invoke-static {p1, v0}, Lcn/com/smartdevices/bracelet/chart/util/ChartUtil;->erase(Landroid/graphics/Canvas;Landroid/graphics/RectF;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->p:Landroid/graphics/RectF;

    invoke-virtual {v0}, Landroid/graphics/RectF;->centerX()F

    move-result v1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->p:Landroid/graphics/RectF;

    invoke-virtual {v0}, Landroid/graphics/RectF;->centerY()F

    move-result v2

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->mDensityScale:F

    iget-object v4, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->e:Landroid/graphics/Bitmap;

    const/4 v5, 0x0

    move-object v0, p1

    invoke-static/range {v0 .. v5}, Lcn/com/smartdevices/bracelet/chart/util/ChartUtil;->drawBitmapCenter(Landroid/graphics/Canvas;FFFLandroid/graphics/Bitmap;Landroid/graphics/Paint;)V

    goto :goto_2

    :pswitch_2
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->p:Landroid/graphics/RectF;

    invoke-static {p1, v0}, Lcn/com/smartdevices/bracelet/chart/util/ChartUtil;->erase(Landroid/graphics/Canvas;Landroid/graphics/RectF;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->p:Landroid/graphics/RectF;

    invoke-virtual {v0}, Landroid/graphics/RectF;->centerX()F

    move-result v1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->p:Landroid/graphics/RectF;

    invoke-virtual {v0}, Landroid/graphics/RectF;->centerY()F

    move-result v2

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->mDensityScale:F

    iget-object v4, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->f:Landroid/graphics/Bitmap;

    const/4 v5, 0x0

    move-object v0, p1

    invoke-static/range {v0 .. v5}, Lcn/com/smartdevices/bracelet/chart/util/ChartUtil;->drawBitmapCenter(Landroid/graphics/Canvas;FFFLandroid/graphics/Bitmap;Landroid/graphics/Paint;)V

    goto :goto_2

    :pswitch_3
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->p:Landroid/graphics/RectF;

    invoke-static {p1, v0}, Lcn/com/smartdevices/bracelet/chart/util/ChartUtil;->erase(Landroid/graphics/Canvas;Landroid/graphics/RectF;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->p:Landroid/graphics/RectF;

    invoke-virtual {v0}, Landroid/graphics/RectF;->centerX()F

    move-result v1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->p:Landroid/graphics/RectF;

    invoke-virtual {v0}, Landroid/graphics/RectF;->centerY()F

    move-result v2

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->mDensityScale:F

    iget-object v4, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->g:Landroid/graphics/Bitmap;

    const/4 v5, 0x0

    move-object v0, p1

    invoke-static/range {v0 .. v5}, Lcn/com/smartdevices/bracelet/chart/util/ChartUtil;->drawBitmapCenter(Landroid/graphics/Canvas;FFFLandroid/graphics/Bitmap;Landroid/graphics/Paint;)V

    goto :goto_2

    nop

    :array_0
    .array-data 0x4
        0xfft 0xfft 0xfft 0x0t
        0xfft 0xfft 0xfft 0xfft
        0xfft 0xfft 0xfft 0x0t
    .end array-data

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method protected onRectChanged(Landroid/graphics/RectF;)V
    .locals 7

    const/high16 v6, 0x4000

    invoke-super {p0, p1}, Lcn/com/smartdevices/bracelet/chart/base/PieChart;->onRectChanged(Landroid/graphics/RectF;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->h:Landroid/graphics/Paint;

    invoke-virtual {v0}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v0

    div-float/2addr v0, v6

    float-to-double v0, v0

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->mRadius:F

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->n:F

    mul-float/2addr v3, v6

    sub-float/2addr v2, v3

    mul-float/2addr v2, v6

    float-to-double v2, v2

    const-wide v4, 0x400921fb54442d18L

    mul-double/2addr v2, v4

    div-double/2addr v0, v2

    const-wide v2, 0x4076800000000000L

    mul-double/2addr v0, v2

    double-to-float v0, v0

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->l:F

    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0, p1}, Landroid/graphics/RectF;-><init>(Landroid/graphics/RectF;)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->m:Landroid/graphics/RectF;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->m:Landroid/graphics/RectF;

    iget v1, v0, Landroid/graphics/RectF;->left:F

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->h:Landroid/graphics/Paint;

    invoke-virtual {v2}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v2

    div-float/2addr v2, v6

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->n:F

    mul-float/2addr v3, v6

    add-float/2addr v2, v3

    add-float/2addr v1, v2

    iput v1, v0, Landroid/graphics/RectF;->left:F

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->m:Landroid/graphics/RectF;

    iget v1, v0, Landroid/graphics/RectF;->top:F

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->h:Landroid/graphics/Paint;

    invoke-virtual {v2}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v2

    div-float/2addr v2, v6

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->n:F

    mul-float/2addr v3, v6

    add-float/2addr v2, v3

    add-float/2addr v1, v2

    iput v1, v0, Landroid/graphics/RectF;->top:F

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->m:Landroid/graphics/RectF;

    iget v1, v0, Landroid/graphics/RectF;->right:F

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->h:Landroid/graphics/Paint;

    invoke-virtual {v2}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v2

    div-float/2addr v2, v6

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->n:F

    mul-float/2addr v3, v6

    add-float/2addr v2, v3

    sub-float/2addr v1, v2

    iput v1, v0, Landroid/graphics/RectF;->right:F

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->m:Landroid/graphics/RectF;

    iget v1, v0, Landroid/graphics/RectF;->bottom:F

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->h:Landroid/graphics/Paint;

    invoke-virtual {v2}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v2

    div-float/2addr v2, v6

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->n:F

    mul-float/2addr v3, v6

    add-float/2addr v2, v3

    sub-float/2addr v1, v2

    iput v1, v0, Landroid/graphics/RectF;->bottom:F

    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0}, Landroid/graphics/RectF;-><init>()V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->p:Landroid/graphics/RectF;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->p:Landroid/graphics/RectF;

    iget v1, p1, Landroid/graphics/RectF;->left:F

    invoke-virtual {p1}, Landroid/graphics/RectF;->width()F

    move-result v2

    div-float/2addr v2, v6

    add-float/2addr v1, v2

    const/high16 v2, 0x4180

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->mDensity:F

    mul-float/2addr v2, v3

    sub-float/2addr v1, v2

    iput v1, v0, Landroid/graphics/RectF;->left:F

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->p:Landroid/graphics/RectF;

    iget v1, p1, Landroid/graphics/RectF;->top:F

    const/high16 v2, 0x4100

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->mDensity:F

    mul-float/2addr v2, v3

    add-float/2addr v1, v2

    iput v1, v0, Landroid/graphics/RectF;->top:F

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->p:Landroid/graphics/RectF;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->p:Landroid/graphics/RectF;

    iget v1, v1, Landroid/graphics/RectF;->left:F

    const/high16 v2, 0x4200

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->mDensity:F

    mul-float/2addr v2, v3

    add-float/2addr v1, v2

    iput v1, v0, Landroid/graphics/RectF;->right:F

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->p:Landroid/graphics/RectF;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->p:Landroid/graphics/RectF;

    iget v1, v1, Landroid/graphics/RectF;->top:F

    const/high16 v2, 0x41c0

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->mDensity:F

    mul-float/2addr v2, v3

    add-float/2addr v1, v2

    iput v1, v0, Landroid/graphics/RectF;->bottom:F

    return-void
.end method

.method public showLoading()V
    .locals 1

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->c:Z

    return-void
.end method

.method public updateMode(I)V
    .locals 0

    iput p1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->d:I

    return-void
.end method
