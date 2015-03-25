.class public Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;
.super Lcn/com/smartdevices/bracelet/chart/base/BarChart;


# static fields
.field public static final BAR_ITEM_SIZE:I = 0x8

.field private static final a:Ljava/lang/String; = "Chart.StatisticChart"

.field private static b:F


# instance fields
.field private c:Lcn/com/smartdevices/bracelet/chart/deprecated/q;

.field private d:Lcn/com/smartdevices/bracelet/chart/deprecated/q;

.field private e:F

.field private f:F

.field private g:Landroid/graphics/Paint;

.field private h:I

.field private i:I

.field private j:Landroid/graphics/Paint;

.field private k:Landroid/graphics/Paint;

.field private l:Landroid/graphics/Bitmap;

.field private m:Landroid/graphics/Bitmap;

.field private n:Landroid/graphics/Paint;

.field private o:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld$DateItem;",
            ">;"
        }
    .end annotation
.end field

.field private p:Landroid/view/View;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 8

    const/4 v7, 0x0

    const/4 v6, 0x1

    const/4 v3, 0x0

    const/high16 v5, 0x3f80

    invoke-direct {p0, p1}, Lcn/com/smartdevices/bracelet/chart/base/BarChart;-><init>(Landroid/content/Context;)V

    const/high16 v0, 0x4040

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->e:F

    const/high16 v0, 0x4000

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->f:F

    const/high16 v0, 0x41b0

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->mDensity:F

    mul-float/2addr v0, v1

    float-to-int v0, v0

    int-to-float v0, v0

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->mPaddingRight:F

    new-instance v0, Lcn/com/smartdevices/bracelet/chart/deprecated/p;

    invoke-direct {v0, p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/p;-><init>(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->mXAxis:Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->mXAxis:Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;

    const/high16 v1, 0x4160

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->mDensity:F

    mul-float/2addr v1, v2

    float-to-int v1, v1

    iput v1, v0, Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;->stroke:I

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->mXAxis:Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->mPaddingRight:F

    invoke-virtual {v0, v3, v3, v1, v3}, Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;->setPadding(FFFF)V

    const/16 v0, 0x2710

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->h:I

    const/16 v0, 0x64

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->i:I

    new-instance v0, Lcn/com/smartdevices/bracelet/chart/deprecated/q;

    invoke-direct {v0, p0, v7}, Lcn/com/smartdevices/bracelet/chart/deprecated/q;-><init>(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;Lcn/com/smartdevices/bracelet/chart/deprecated/o;)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->c:Lcn/com/smartdevices/bracelet/chart/deprecated/q;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->c:Lcn/com/smartdevices/bracelet/chart/deprecated/q;

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->h:I

    int-to-double v1, v1

    const-wide v3, 0x3ff999999999999aL

    mul-double/2addr v1, v3

    double-to-int v1, v1

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/q;->setMaxItemValue(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->c:Lcn/com/smartdevices/bracelet/chart/deprecated/q;

    invoke-virtual {v0, v5}, Lcn/com/smartdevices/bracelet/chart/deprecated/q;->setItemPadding(F)V

    new-instance v0, Lcn/com/smartdevices/bracelet/chart/deprecated/q;

    invoke-direct {v0, p0, v7}, Lcn/com/smartdevices/bracelet/chart/deprecated/q;-><init>(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;Lcn/com/smartdevices/bracelet/chart/deprecated/o;)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->d:Lcn/com/smartdevices/bracelet/chart/deprecated/q;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->d:Lcn/com/smartdevices/bracelet/chart/deprecated/q;

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->i:I

    int-to-double v1, v1

    const-wide v3, 0x3ff3333333333333L

    mul-double/2addr v1, v3

    double-to-int v1, v1

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/q;->setMaxItemValue(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->d:Lcn/com/smartdevices/bracelet/chart/deprecated/q;

    invoke-virtual {v0, v5}, Lcn/com/smartdevices/bracelet/chart/deprecated/q;->setItemPadding(F)V

    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->g:Landroid/graphics/Paint;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->g:Landroid/graphics/Paint;

    new-instance v1, Landroid/graphics/PorterDuffXfermode;

    sget-object v2, Landroid/graphics/PorterDuff$Mode;->SRC_IN:Landroid/graphics/PorterDuff$Mode;

    invoke-direct {v1, v2}, Landroid/graphics/PorterDuffXfermode;-><init>(Landroid/graphics/PorterDuff$Mode;)V

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setXfermode(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;

    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->j:Landroid/graphics/Paint;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->j:Landroid/graphics/Paint;

    const v1, -0x7f001000

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->j:Landroid/graphics/Paint;

    invoke-virtual {v0, v5}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->k:Landroid/graphics/Paint;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->k:Landroid/graphics/Paint;

    const v1, -0x7f000001

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->k:Landroid/graphics/Paint;

    invoke-virtual {v0, v5}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0, v6}, Landroid/graphics/Paint;-><init>(I)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->n:Landroid/graphics/Paint;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->n:Landroid/graphics/Paint;

    invoke-virtual {v0, v6}, Landroid/graphics/Paint;->setDither(Z)V

    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f02004a

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    check-cast v0, Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {v0}, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->l:Landroid/graphics/Bitmap;

    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f020049

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    check-cast v0, Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {v0}, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->m:Landroid/graphics/Bitmap;

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->o:Ljava/util/List;

    return-void
.end method

.method static synthetic a()F
    .locals 1

    sget v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->b:F

    return v0
.end method

.method static synthetic a(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;)Ljava/util/List;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->o:Ljava/util/List;

    return-object v0
.end method

.method private a(Landroid/graphics/Canvas;)V
    .locals 3

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->g:Landroid/graphics/Paint;

    const v1, -0x7f390100

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    new-instance v0, Landroid/graphics/RectF;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->c:Lcn/com/smartdevices/bracelet/chart/deprecated/q;

    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/q;->getRect()Landroid/graphics/RectF;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/graphics/RectF;-><init>(Landroid/graphics/RectF;)V

    iget v1, v0, Landroid/graphics/RectF;->right:F

    sget v2, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->b:F

    sub-float/2addr v1, v2

    iput v1, v0, Landroid/graphics/RectF;->right:F

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->g:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->drawRect(Landroid/graphics/RectF;Landroid/graphics/Paint;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->g:Landroid/graphics/Paint;

    const v1, -0x7fbec632

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    new-instance v0, Landroid/graphics/RectF;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->d:Lcn/com/smartdevices/bracelet/chart/deprecated/q;

    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/q;->getRect()Landroid/graphics/RectF;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/graphics/RectF;-><init>(Landroid/graphics/RectF;)V

    iget v1, v0, Landroid/graphics/RectF;->right:F

    sget v2, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->b:F

    sub-float/2addr v1, v2

    iput v1, v0, Landroid/graphics/RectF;->right:F

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->g:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->drawRect(Landroid/graphics/RectF;Landroid/graphics/Paint;)V

    return-void
.end method

.method static synthetic b(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;)Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->mXAxis:Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;

    return-object v0
.end method

.method private b(Landroid/graphics/Canvas;)V
    .locals 12

    const/4 v9, 0x1

    const/4 v8, 0x0

    const/4 v1, 0x0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->mRect:Landroid/graphics/RectF;

    iget v0, v0, Landroid/graphics/RectF;->right:F

    const/high16 v2, 0x4198

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->mDensity:F

    mul-float/2addr v2, v3

    sub-float v3, v0, v2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->c:Lcn/com/smartdevices/bracelet/chart/deprecated/q;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/q;->getRect()Landroid/graphics/RectF;

    move-result-object v0

    iget v2, v0, Landroid/graphics/RectF;->bottom:F

    iget v4, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->h:I

    int-to-float v4, v4

    iget-object v5, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->c:Lcn/com/smartdevices/bracelet/chart/deprecated/q;

    invoke-virtual {v5}, Lcn/com/smartdevices/bracelet/chart/deprecated/q;->getMaxItemValue()I

    move-result v5

    int-to-float v5, v5

    div-float/2addr v4, v5

    invoke-virtual {v0}, Landroid/graphics/RectF;->height()F

    move-result v0

    mul-float/2addr v0, v4

    sub-float/2addr v2, v0

    iget-object v5, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->j:Landroid/graphics/Paint;

    move-object v0, p1

    move v4, v2

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    float-to-int v0, v3

    int-to-float v5, v0

    float-to-int v0, v2

    int-to-float v6, v0

    iget v7, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->mDensityScale:F

    iget-object v10, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->l:Landroid/graphics/Bitmap;

    iget-object v11, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->n:Landroid/graphics/Paint;

    move-object v4, p1

    invoke-static/range {v4 .. v11}, Lcn/com/smartdevices/bracelet/chart/util/ChartUtil;->drawBitmapCenter(Landroid/graphics/Canvas;FFFZZLandroid/graphics/Bitmap;Landroid/graphics/Paint;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->d:Lcn/com/smartdevices/bracelet/chart/deprecated/q;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/q;->getRect()Landroid/graphics/RectF;

    move-result-object v0

    iget v2, v0, Landroid/graphics/RectF;->bottom:F

    iget v4, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->i:I

    int-to-float v4, v4

    iget-object v5, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->d:Lcn/com/smartdevices/bracelet/chart/deprecated/q;

    invoke-virtual {v5}, Lcn/com/smartdevices/bracelet/chart/deprecated/q;->getMaxItemValue()I

    move-result v5

    int-to-float v5, v5

    div-float/2addr v4, v5

    invoke-virtual {v0}, Landroid/graphics/RectF;->height()F

    move-result v0

    mul-float/2addr v0, v4

    sub-float/2addr v2, v0

    iget-object v5, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->k:Landroid/graphics/Paint;

    move-object v0, p1

    move v4, v2

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    float-to-int v0, v3

    int-to-float v5, v0

    float-to-int v0, v2

    int-to-float v6, v0

    iget v7, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->mDensityScale:F

    iget-object v10, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->m:Landroid/graphics/Bitmap;

    iget-object v11, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->n:Landroid/graphics/Paint;

    move-object v4, p1

    invoke-static/range {v4 .. v11}, Lcn/com/smartdevices/bracelet/chart/util/ChartUtil;->drawBitmapCenter(Landroid/graphics/Canvas;FFFZZLandroid/graphics/Bitmap;Landroid/graphics/Paint;)V

    return-void
.end method


# virtual methods
.method protected doScroll(F)V
    .locals 7

    const/4 v2, 0x1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->mLoadCallback:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;

    if-nez v0, :cond_0

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->mXAxis:Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/p;

    iget v5, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/p;->offset:I

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->mScroll:F

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/p;->scrollTo(F)V

    iget v3, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/p;->offset:I

    const/4 v1, 0x0

    const/4 v4, 0x0

    cmpg-float v4, p1, v4

    if-gez v4, :cond_4

    add-int/lit8 v4, v3, 0x1

    move v3, v5

    :goto_1
    if-le v4, v5, :cond_2

    iget-object v6, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->mLoadCallback:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;

    invoke-interface {v6, v4}, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;->hasData(I)Z

    move-result v6

    if-nez v6, :cond_1

    const-string v1, "Chart.StatisticChart"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "No Item Data : "

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3}, Lcn/com/smartdevices/bracelet/Debug;->w(Ljava/lang/String;Ljava/lang/String;)V

    move v1, v2

    move v3, v4

    :cond_1
    add-int/lit8 v4, v4, -0x1

    goto :goto_1

    :cond_2
    add-int/lit8 v2, v3, -0x1

    :goto_2
    const-string v3, "Chart.StatisticChart"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "ScrollTo : "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget v5, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->mScroll:F

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    if-eqz v1, :cond_3

    neg-int v1, v2

    int-to-float v1, v1

    sget v2, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->b:F

    mul-float/2addr v1, v2

    iput v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->mScroll:F

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->mScroll:F

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/p;->scrollTo(F)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->mLoadCallback:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;

    check-cast v1, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld$StatisticChartLoadCallback;

    invoke-interface {v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld$StatisticChartLoadCallback;->onOverScrolled()V

    :cond_3
    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->mLoadCallback:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;

    iget v0, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/p;->offset:I

    invoke-interface {v1, v0}, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;->loadData(I)Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$ItemData;

    goto :goto_0

    :cond_4
    add-int/lit8 v4, v3, -0x1

    move v3, v5

    :goto_3
    if-ge v4, v5, :cond_6

    iget-object v6, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->mLoadCallback:Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;

    invoke-interface {v6, v4}, Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;->hasData(I)Z

    move-result v6

    if-nez v6, :cond_5

    const-string v1, "Chart.StatisticChart"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "No Item Data : "

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3}, Lcn/com/smartdevices/bracelet/Debug;->w(Ljava/lang/String;Ljava/lang/String;)V

    move v1, v2

    move v3, v4

    :cond_5
    add-int/lit8 v4, v4, 0x1

    goto :goto_3

    :cond_6
    add-int/lit8 v2, v3, 0x1

    goto :goto_2
.end method

.method public draw(Landroid/graphics/Canvas;F)V
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->d:Lcn/com/smartdevices/bracelet/chart/deprecated/q;

    invoke-virtual {v0, p1, p2}, Lcn/com/smartdevices/bracelet/chart/deprecated/q;->draw(Landroid/graphics/Canvas;F)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->c:Lcn/com/smartdevices/bracelet/chart/deprecated/q;

    invoke-virtual {v0, p1, p2}, Lcn/com/smartdevices/bracelet/chart/deprecated/q;->draw(Landroid/graphics/Canvas;F)V

    invoke-direct {p0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->a(Landroid/graphics/Canvas;)V

    invoke-direct {p0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->b(Landroid/graphics/Canvas;)V

    invoke-super {p0, p1, p2}, Lcn/com/smartdevices/bracelet/chart/base/BarChart;->draw(Landroid/graphics/Canvas;F)V

    return-void
.end method

.method public fillDates(Ljava/util/List;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld$DateItem;",
            ">;)V"
        }
    .end annotation

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->o:Ljava/util/List;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->o:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->o:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public fillSleepData(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld$StatisticBarItem;",
            ">;)V"
        }
    .end annotation

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->d:Lcn/com/smartdevices/bracelet/chart/deprecated/q;

    invoke-virtual {v0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/q;->fillItems(Ljava/util/List;)V

    return-void
.end method

.method public fillStepData(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld$StatisticBarItem;",
            ">;)V"
        }
    .end annotation

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->c:Lcn/com/smartdevices/bracelet/chart/deprecated/q;

    invoke-virtual {v0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/q;->fillItems(Ljava/util/List;)V

    return-void
.end method

.method public itemOffset()I
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->mXAxis:Lcn/com/smartdevices/bracelet/chart/base/BarChart$Axis;

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/p;

    iget v0, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/p;->offset:I

    return v0
.end method

.method public justified()I
    .locals 4

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->mScroll:F

    sget v1, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->b:F

    rem-float/2addr v0, v1

    float-to-int v0, v0

    invoke-static {v0}, Ljava/lang/Math;->abs(I)I

    move-result v1

    int-to-float v1, v1

    sget v2, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->b:F

    const/high16 v3, 0x4000

    div-float/2addr v2, v3

    cmpl-float v1, v1, v2

    if-lez v1, :cond_0

    if-lez v0, :cond_1

    sget v1, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->b:F

    int-to-float v0, v0

    sub-float v0, v1, v0

    neg-float v0, v0

    float-to-int v0, v0

    :cond_0
    :goto_0
    return v0

    :cond_1
    sget v1, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->b:F

    int-to-float v0, v0

    add-float/2addr v0, v1

    float-to-int v0, v0

    goto :goto_0
.end method

.method public notifyChanged()V
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->c:Lcn/com/smartdevices/bracelet/chart/deprecated/q;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/q;->notifyChanged()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->d:Lcn/com/smartdevices/bracelet/chart/deprecated/q;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/q;->notifyChanged()V

    return-void
.end method

.method public offsetScroll(F)I
    .locals 2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->mRect:Landroid/graphics/RectF;

    iget v0, v0, Landroid/graphics/RectF;->right:F

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->mPaddingRight:F

    sub-float/2addr v0, v1

    sub-float/2addr v0, p1

    sget v1, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->b:F

    div-float/2addr v0, v1

    float-to-int v0, v0

    int-to-float v0, v0

    sget v1, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->b:F

    mul-float/2addr v0, v1

    float-to-int v0, v0

    neg-int v0, v0

    return v0
.end method

.method public onRectChanged(Landroid/graphics/RectF;)V
    .locals 6

    const/high16 v5, 0x4040

    invoke-super {p0, p1}, Lcn/com/smartdevices/bracelet/chart/base/BarChart;->onRectChanged(Landroid/graphics/RectF;)V

    const/high16 v0, 0x4234

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->mDensity:F

    mul-float/2addr v0, v1

    sput v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->b:F

    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0, p1}, Landroid/graphics/RectF;-><init>(Landroid/graphics/RectF;)V

    iget v1, v0, Landroid/graphics/RectF;->top:F

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->mDensity:F

    mul-float/2addr v2, v5

    add-float/2addr v1, v2

    iput v1, v0, Landroid/graphics/RectF;->top:F

    iget v1, p1, Landroid/graphics/RectF;->right:F

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->mPaddingRight:F

    sub-float/2addr v1, v2

    iput v1, v0, Landroid/graphics/RectF;->right:F

    iget v1, p1, Landroid/graphics/RectF;->bottom:F

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->e:F

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->e:F

    iget v4, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->f:F

    add-float/2addr v3, v4

    div-float/2addr v2, v3

    mul-float/2addr v1, v2

    iput v1, v0, Landroid/graphics/RectF;->bottom:F

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->c:Lcn/com/smartdevices/bracelet/chart/deprecated/q;

    invoke-virtual {v1, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/q;->setRect(Landroid/graphics/RectF;)V

    new-instance v1, Landroid/graphics/RectF;

    invoke-direct {v1, p1}, Landroid/graphics/RectF;-><init>(Landroid/graphics/RectF;)V

    iget v0, v0, Landroid/graphics/RectF;->bottom:F

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->mDensity:F

    mul-float/2addr v2, v5

    add-float/2addr v0, v2

    iput v0, v1, Landroid/graphics/RectF;->top:F

    iget v0, p1, Landroid/graphics/RectF;->right:F

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->mPaddingRight:F

    sub-float/2addr v0, v2

    iput v0, v1, Landroid/graphics/RectF;->right:F

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->d:Lcn/com/smartdevices/bracelet/chart/deprecated/q;

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/q;->setRect(Landroid/graphics/RectF;)V

    return-void
.end method

.method public setContainerView(Landroid/view/View;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->p:Landroid/view/View;

    return-void
.end method

.method public setStepGoal(I)V
    .locals 5

    iput p1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->h:I

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->c:Lcn/com/smartdevices/bracelet/chart/deprecated/q;

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->h:I

    int-to-double v1, v1

    const-wide v3, 0x3ff999999999999aL

    mul-double/2addr v1, v3

    double-to-int v1, v1

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/q;->setMaxItemValue(I)V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartOld;->notifyChanged()V

    return-void
.end method
