.class public Lcom/twotoasters/jazzylistview/JazzyHelper;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/widget/AbsListView$OnScrollListener;


# static fields
.field public static final CARDS:I = 0x2

.field public static final CURL:I = 0x3

.field public static final DURATION:I = 0x258

.field public static final FADE:I = 0xc

.field public static final FAN:I = 0x9

.field public static final FLIP:I = 0x5

.field public static final FLY:I = 0x6

.field public static final GROW:I = 0x1

.field public static final HELIX:I = 0x8

.field public static final MAX_VELOCITY_OFF:I = 0x0

.field public static final OPAQUE:I = 0xff

.field public static final REVERSE_FLY:I = 0x7

.field public static final SLIDE_IN:I = 0xe

.field public static final STANDARD:I = 0x0

.field public static final TILT:I = 0xa

.field public static final TRANSPARENT:I = 0x0

.field public static final TWIRL:I = 0xd

.field public static final WAVE:I = 0x4

.field public static final WAVERIGHT:I = 0xf

.field public static final ZIPPER:I = 0xb


# instance fields
.field private a:Lcom/twotoasters/jazzylistview/JazzyEffect;

.field private b:Z

.field private c:I

.field private d:I

.field private e:I

.field private f:J

.field private g:D

.field private h:I

.field private i:Landroid/widget/AbsListView$OnScrollListener;

.field private j:Z

.field private k:Z

.field private l:Z

.field private m:Z

.field private final n:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 6

    const/4 v5, 0x4

    const/4 v1, -0x1

    const/4 v4, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->a:Lcom/twotoasters/jazzylistview/JazzyEffect;

    iput-boolean v4, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->b:Z

    iput v1, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->c:I

    iput v1, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->d:I

    iput v4, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->e:I

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->f:J

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->g:D

    iput v4, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->h:I

    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->n:Ljava/util/HashSet;

    sget-object v0, Lcom/xiaomi/hm/health/R$styleable;->JazzyListView:[I

    invoke-virtual {p1, p2, v0}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    invoke-virtual {v0, v4, v4}, Landroid/content/res/TypedArray;->getInteger(II)I

    move-result v1

    invoke-virtual {v0, v5, v4}, Landroid/content/res/TypedArray;->getInteger(II)I

    move-result v2

    const/4 v3, 0x1

    invoke-virtual {v0, v3, v4}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v3

    iput-boolean v3, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->j:Z

    invoke-virtual {v0, v5, v4}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v3

    iput-boolean v3, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->k:Z

    const/4 v3, 0x3

    invoke-virtual {v0, v3, v4}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v3

    iput-boolean v3, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->m:Z

    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    invoke-virtual {p0, v1}, Lcom/twotoasters/jazzylistview/JazzyHelper;->setTransitionEffect(I)V

    invoke-virtual {p0, v2}, Lcom/twotoasters/jazzylistview/JazzyHelper;->setMaxAnimationVelocity(I)V

    return-void
.end method

.method private a()D
    .locals 2

    iget-wide v0, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->g:D

    return-wide v0
.end method

.method private a(II)V
    .locals 8

    iget v0, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->h:I

    if-lez v0, :cond_0

    iget v0, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->e:I

    if-eq v0, p1, :cond_0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iget-wide v2, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->f:J

    sub-long v2, v0, v2

    const-wide/16 v4, 0x1

    cmp-long v4, v2, v4

    if-gez v4, :cond_3

    const-wide/high16 v4, 0x3ff0000000000000L    # 1.0

    long-to-double v2, v2

    div-double v2, v4, v2

    const-wide v4, 0x408f400000000000L    # 1000.0

    mul-double/2addr v2, v4

    const-wide v4, 0x3fecccccc0000000L    # 0.8999999761581421

    iget-wide v6, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->g:D

    mul-double/2addr v4, v6

    cmpg-double v4, v2, v4

    if-gez v4, :cond_1

    iget-wide v2, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->g:D

    const-wide v4, 0x3fecccccc0000000L    # 0.8999999761581421

    mul-double/2addr v2, v4

    iput-wide v2, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->g:D

    :goto_0
    iput p1, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->e:I

    iput-wide v0, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->f:J

    :cond_0
    return-void

    :cond_1
    const-wide v4, 0x3ff19999a0000000L    # 1.100000023841858

    iget-wide v6, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->g:D

    mul-double/2addr v4, v6

    cmpl-double v4, v2, v4

    if-lez v4, :cond_2

    iget-wide v2, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->g:D

    const-wide v4, 0x3ff19999a0000000L    # 1.100000023841858

    mul-double/2addr v2, v4

    iput-wide v2, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->g:D

    goto :goto_0

    :cond_2
    iput-wide v2, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->g:D

    goto :goto_0

    :cond_3
    const-wide/high16 v4, 0x3ff0000000000000L    # 1.0

    long-to-double v2, v2

    div-double v2, v4, v2

    const-wide v4, 0x408f400000000000L    # 1000.0

    mul-double/2addr v2, v4

    iput-wide v2, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->g:D

    goto :goto_0
.end method

.method private a(Landroid/view/View;II)V
    .locals 4

    iget-boolean v0, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->b:Z

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->j:Z

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->n:Ljava/util/HashSet;

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget-boolean v0, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->k:Z

    if-eqz v0, :cond_2

    iget-boolean v0, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->l:Z

    if-eqz v0, :cond_0

    :cond_2
    iget v0, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->h:I

    if-lez v0, :cond_3

    iget v0, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->h:I

    int-to-double v0, v0

    invoke-direct {p0}, Lcom/twotoasters/jazzylistview/JazzyHelper;->a()D

    move-result-wide v2

    cmpg-double v0, v0, v2

    if-ltz v0, :cond_0

    :cond_3
    iget-boolean v0, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->m:Z

    if-eqz v0, :cond_4

    check-cast p1, Landroid/view/ViewGroup;

    const/4 v0, 0x0

    :goto_1
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v1

    if-ge v0, v1, :cond_5

    invoke-virtual {p1, v0}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    invoke-direct {p0, v1, p2, p3}, Lcom/twotoasters/jazzylistview/JazzyHelper;->b(Landroid/view/View;II)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_4
    invoke-direct {p0, p1, p2, p3}, Lcom/twotoasters/jazzylistview/JazzyHelper;->b(Landroid/view/View;II)V

    :cond_5
    iget-object v0, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->n:Ljava/util/HashSet;

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method private a(Landroid/widget/AbsListView;I)V
    .locals 1

    iget-object v0, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->i:Landroid/widget/AbsListView$OnScrollListener;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->i:Landroid/widget/AbsListView$OnScrollListener;

    invoke-interface {v0, p1, p2}, Landroid/widget/AbsListView$OnScrollListener;->onScrollStateChanged(Landroid/widget/AbsListView;I)V

    :cond_0
    return-void
.end method

.method private a(Landroid/widget/AbsListView;III)V
    .locals 1

    iget-object v0, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->i:Landroid/widget/AbsListView$OnScrollListener;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->i:Landroid/widget/AbsListView$OnScrollListener;

    invoke-interface {v0, p1, p2, p3, p4}, Landroid/widget/AbsListView$OnScrollListener;->onScroll(Landroid/widget/AbsListView;III)V

    :cond_0
    return-void
.end method

.method private b(Landroid/view/View;II)V
    .locals 3

    invoke-static {p1}, Lcom/nineoldandroids/view/ViewPropertyAnimator;->animate(Landroid/view/View;)Lcom/nineoldandroids/view/ViewPropertyAnimator;

    move-result-object v0

    const-wide/16 v1, 0x258

    invoke-virtual {v0, v1, v2}, Lcom/nineoldandroids/view/ViewPropertyAnimator;->setDuration(J)Lcom/nineoldandroids/view/ViewPropertyAnimator;

    move-result-object v0

    new-instance v1, Landroid/view/animation/AccelerateDecelerateInterpolator;

    invoke-direct {v1}, Landroid/view/animation/AccelerateDecelerateInterpolator;-><init>()V

    invoke-virtual {v0, v1}, Lcom/nineoldandroids/view/ViewPropertyAnimator;->setInterpolator(Landroid/view/animation/Interpolator;)Lcom/nineoldandroids/view/ViewPropertyAnimator;

    move-result-object v1

    if-lez p3, :cond_0

    const/4 v0, 0x1

    :goto_0
    iget-object v2, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->a:Lcom/twotoasters/jazzylistview/JazzyEffect;

    invoke-interface {v2, p1, p2, v0}, Lcom/twotoasters/jazzylistview/JazzyEffect;->initView(Landroid/view/View;II)V

    iget-object v2, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->a:Lcom/twotoasters/jazzylistview/JazzyEffect;

    invoke-interface {v2, p1, p2, v0, v1}, Lcom/twotoasters/jazzylistview/JazzyEffect;->setupAnimation(Landroid/view/View;IILcom/nineoldandroids/view/ViewPropertyAnimator;)V

    invoke-virtual {v1}, Lcom/nineoldandroids/view/ViewPropertyAnimator;->start()V

    return-void

    :cond_0
    const/4 v0, -0x1

    goto :goto_0
.end method


# virtual methods
.method public final onScroll(Landroid/widget/AbsListView;III)V
    .locals 7

    const/4 v1, 0x1

    const/4 v2, 0x0

    const/4 v6, -0x1

    iget v0, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->c:I

    if-eq v0, v6, :cond_0

    iget v0, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->d:I

    if-eq v0, v6, :cond_0

    move v0, v1

    :goto_0
    add-int v3, p2, p3

    add-int/lit8 v3, v3, -0x1

    iget-boolean v4, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->b:Z

    if-eqz v4, :cond_2

    if-eqz v0, :cond_2

    invoke-direct {p0, p2, p4}, Lcom/twotoasters/jazzylistview/JazzyHelper;->a(II)V

    move v0, v2

    :goto_1
    add-int v4, p2, v0

    iget v5, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->c:I

    if-ge v4, v5, :cond_1

    invoke-virtual {p1, v0}, Landroid/widget/AbsListView;->getChildAt(I)Landroid/view/View;

    move-result-object v4

    add-int v5, p2, v0

    invoke-direct {p0, v4, v5, v6}, Lcom/twotoasters/jazzylistview/JazzyHelper;->a(Landroid/view/View;II)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_0
    move v0, v2

    goto :goto_0

    :cond_1
    :goto_2
    sub-int v0, v3, v2

    iget v4, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->d:I

    if-le v0, v4, :cond_3

    sub-int v0, v3, p2

    sub-int/2addr v0, v2

    invoke-virtual {p1, v0}, Landroid/widget/AbsListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    sub-int v4, v3, v2

    invoke-direct {p0, v0, v4, v1}, Lcom/twotoasters/jazzylistview/JazzyHelper;->a(Landroid/view/View;II)V

    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    :cond_2
    if-nez v0, :cond_3

    move v0, p2

    :goto_3
    if-ge v0, p3, :cond_3

    iget-object v1, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->n:Ljava/util/HashSet;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    add-int/lit8 v0, v0, 0x1

    goto :goto_3

    :cond_3
    iput p2, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->c:I

    iput v3, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->d:I

    invoke-direct {p0, p1, p2, p3, p4}, Lcom/twotoasters/jazzylistview/JazzyHelper;->a(Landroid/widget/AbsListView;III)V

    return-void
.end method

.method public onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 2

    const/4 v1, 0x1

    const/4 v0, 0x0

    packed-switch p2, :pswitch_data_0

    :goto_0
    invoke-direct {p0, p1, p2}, Lcom/twotoasters/jazzylistview/JazzyHelper;->a(Landroid/widget/AbsListView;I)V

    return-void

    :pswitch_0
    iput-boolean v0, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->b:Z

    iput-boolean v0, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->l:Z

    goto :goto_0

    :pswitch_1
    iput-boolean v1, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->l:Z

    goto :goto_0

    :pswitch_2
    iput-boolean v1, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->b:Z

    iput-boolean v0, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->l:Z

    goto :goto_0

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method

.method public setMaxAnimationVelocity(I)V
    .locals 0

    iput p1, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->h:I

    return-void
.end method

.method public setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V
    .locals 0

    iput-object p1, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->i:Landroid/widget/AbsListView$OnScrollListener;

    return-void
.end method

.method public setShouldOnlyAnimateFling(Z)V
    .locals 0

    iput-boolean p1, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->k:Z

    return-void
.end method

.method public setShouldOnlyAnimateNewItems(Z)V
    .locals 0

    iput-boolean p1, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->j:Z

    return-void
.end method

.method public setSimulateGridWithList(Z)V
    .locals 0

    iput-boolean p1, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->m:Z

    return-void
.end method

.method public setTransitionEffect(I)V
    .locals 1

    packed-switch p1, :pswitch_data_0

    :goto_0
    return-void

    :pswitch_0
    new-instance v0, Lcom/twotoasters/jazzylistview/effects/StandardEffect;

    invoke-direct {v0}, Lcom/twotoasters/jazzylistview/effects/StandardEffect;-><init>()V

    invoke-virtual {p0, v0}, Lcom/twotoasters/jazzylistview/JazzyHelper;->setTransitionEffect(Lcom/twotoasters/jazzylistview/JazzyEffect;)V

    goto :goto_0

    :pswitch_1
    new-instance v0, Lcom/twotoasters/jazzylistview/effects/GrowEffect;

    invoke-direct {v0}, Lcom/twotoasters/jazzylistview/effects/GrowEffect;-><init>()V

    invoke-virtual {p0, v0}, Lcom/twotoasters/jazzylistview/JazzyHelper;->setTransitionEffect(Lcom/twotoasters/jazzylistview/JazzyEffect;)V

    goto :goto_0

    :pswitch_2
    new-instance v0, Lcom/twotoasters/jazzylistview/effects/CardsEffect;

    invoke-direct {v0}, Lcom/twotoasters/jazzylistview/effects/CardsEffect;-><init>()V

    invoke-virtual {p0, v0}, Lcom/twotoasters/jazzylistview/JazzyHelper;->setTransitionEffect(Lcom/twotoasters/jazzylistview/JazzyEffect;)V

    goto :goto_0

    :pswitch_3
    new-instance v0, Lcom/twotoasters/jazzylistview/effects/CurlEffect;

    invoke-direct {v0}, Lcom/twotoasters/jazzylistview/effects/CurlEffect;-><init>()V

    invoke-virtual {p0, v0}, Lcom/twotoasters/jazzylistview/JazzyHelper;->setTransitionEffect(Lcom/twotoasters/jazzylistview/JazzyEffect;)V

    goto :goto_0

    :pswitch_4
    new-instance v0, Lcom/twotoasters/jazzylistview/effects/WaveEffect;

    invoke-direct {v0}, Lcom/twotoasters/jazzylistview/effects/WaveEffect;-><init>()V

    invoke-virtual {p0, v0}, Lcom/twotoasters/jazzylistview/JazzyHelper;->setTransitionEffect(Lcom/twotoasters/jazzylistview/JazzyEffect;)V

    goto :goto_0

    :pswitch_5
    new-instance v0, Lcom/twotoasters/jazzylistview/effects/FlipEffect;

    invoke-direct {v0}, Lcom/twotoasters/jazzylistview/effects/FlipEffect;-><init>()V

    invoke-virtual {p0, v0}, Lcom/twotoasters/jazzylistview/JazzyHelper;->setTransitionEffect(Lcom/twotoasters/jazzylistview/JazzyEffect;)V

    goto :goto_0

    :pswitch_6
    new-instance v0, Lcom/twotoasters/jazzylistview/effects/FlyEffect;

    invoke-direct {v0}, Lcom/twotoasters/jazzylistview/effects/FlyEffect;-><init>()V

    invoke-virtual {p0, v0}, Lcom/twotoasters/jazzylistview/JazzyHelper;->setTransitionEffect(Lcom/twotoasters/jazzylistview/JazzyEffect;)V

    goto :goto_0

    :pswitch_7
    new-instance v0, Lcom/twotoasters/jazzylistview/effects/ReverseFlyEffect;

    invoke-direct {v0}, Lcom/twotoasters/jazzylistview/effects/ReverseFlyEffect;-><init>()V

    invoke-virtual {p0, v0}, Lcom/twotoasters/jazzylistview/JazzyHelper;->setTransitionEffect(Lcom/twotoasters/jazzylistview/JazzyEffect;)V

    goto :goto_0

    :pswitch_8
    new-instance v0, Lcom/twotoasters/jazzylistview/effects/HelixEffect;

    invoke-direct {v0}, Lcom/twotoasters/jazzylistview/effects/HelixEffect;-><init>()V

    invoke-virtual {p0, v0}, Lcom/twotoasters/jazzylistview/JazzyHelper;->setTransitionEffect(Lcom/twotoasters/jazzylistview/JazzyEffect;)V

    goto :goto_0

    :pswitch_9
    new-instance v0, Lcom/twotoasters/jazzylistview/effects/FanEffect;

    invoke-direct {v0}, Lcom/twotoasters/jazzylistview/effects/FanEffect;-><init>()V

    invoke-virtual {p0, v0}, Lcom/twotoasters/jazzylistview/JazzyHelper;->setTransitionEffect(Lcom/twotoasters/jazzylistview/JazzyEffect;)V

    goto :goto_0

    :pswitch_a
    new-instance v0, Lcom/twotoasters/jazzylistview/effects/TiltEffect;

    invoke-direct {v0}, Lcom/twotoasters/jazzylistview/effects/TiltEffect;-><init>()V

    invoke-virtual {p0, v0}, Lcom/twotoasters/jazzylistview/JazzyHelper;->setTransitionEffect(Lcom/twotoasters/jazzylistview/JazzyEffect;)V

    goto :goto_0

    :pswitch_b
    new-instance v0, Lcom/twotoasters/jazzylistview/effects/ZipperEffect;

    invoke-direct {v0}, Lcom/twotoasters/jazzylistview/effects/ZipperEffect;-><init>()V

    invoke-virtual {p0, v0}, Lcom/twotoasters/jazzylistview/JazzyHelper;->setTransitionEffect(Lcom/twotoasters/jazzylistview/JazzyEffect;)V

    goto :goto_0

    :pswitch_c
    new-instance v0, Lcom/twotoasters/jazzylistview/effects/FadeEffect;

    invoke-direct {v0}, Lcom/twotoasters/jazzylistview/effects/FadeEffect;-><init>()V

    invoke-virtual {p0, v0}, Lcom/twotoasters/jazzylistview/JazzyHelper;->setTransitionEffect(Lcom/twotoasters/jazzylistview/JazzyEffect;)V

    goto :goto_0

    :pswitch_d
    new-instance v0, Lcom/twotoasters/jazzylistview/effects/TwirlEffect;

    invoke-direct {v0}, Lcom/twotoasters/jazzylistview/effects/TwirlEffect;-><init>()V

    invoke-virtual {p0, v0}, Lcom/twotoasters/jazzylistview/JazzyHelper;->setTransitionEffect(Lcom/twotoasters/jazzylistview/JazzyEffect;)V

    goto :goto_0

    :pswitch_e
    new-instance v0, Lcom/twotoasters/jazzylistview/effects/SlideInEffect;

    invoke-direct {v0}, Lcom/twotoasters/jazzylistview/effects/SlideInEffect;-><init>()V

    invoke-virtual {p0, v0}, Lcom/twotoasters/jazzylistview/JazzyHelper;->setTransitionEffect(Lcom/twotoasters/jazzylistview/JazzyEffect;)V

    goto/16 :goto_0

    :pswitch_f
    new-instance v0, Lcom/twotoasters/jazzylistview/effects/WaveRightEffect;

    invoke-direct {v0}, Lcom/twotoasters/jazzylistview/effects/WaveRightEffect;-><init>()V

    invoke-virtual {p0, v0}, Lcom/twotoasters/jazzylistview/JazzyHelper;->setTransitionEffect(Lcom/twotoasters/jazzylistview/JazzyEffect;)V

    goto/16 :goto_0

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
        :pswitch_9
        :pswitch_a
        :pswitch_b
        :pswitch_c
        :pswitch_d
        :pswitch_e
        :pswitch_f
    .end packed-switch
.end method

.method public setTransitionEffect(Lcom/twotoasters/jazzylistview/JazzyEffect;)V
    .locals 0

    iput-object p1, p0, Lcom/twotoasters/jazzylistview/JazzyHelper;->a:Lcom/twotoasters/jazzylistview/JazzyEffect;

    return-void
.end method
