.class public Lcom/readystatesoftware/viewbadger/BadgeView;
.super Landroid/widget/TextView;


# static fields
.field public static final POSITION_BOTTOM_LEFT:I = 0x3

.field public static final POSITION_BOTTOM_RIGHT:I = 0x4

.field public static final POSITION_CENTER:I = 0x5

.field public static final POSITION_TOP_LEFT:I = 0x1

.field public static final POSITION_TOP_RIGHT:I = 0x2

.field private static final a:I = 0x5

.field private static final b:I = 0x5

.field private static final c:I = 0x8

.field private static final d:I = 0x2

#the value of this static final field might be set in the static constructor
.field private static final e:I = 0x0

.field private static final f:I = -0x1

.field private static g:Landroid/view/animation/Animation;

.field private static h:Landroid/view/animation/Animation;


# instance fields
.field private i:Landroid/content/Context;

.field private j:Landroid/view/View;

.field private k:I

.field private l:I

.field private m:I

.field private n:I

.field private o:Z

.field private p:Landroid/graphics/drawable/ShapeDrawable;

.field private q:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const-string v0, "#CCFF0000"

    invoke-static {v0}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v0

    sput v0, Lcom/readystatesoftware/viewbadger/BadgeView;->e:I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 2

    const/4 v0, 0x0

    check-cast v0, Landroid/util/AttributeSet;

    const v1, 0x1010084

    invoke-direct {p0, p1, v0, v1}, Lcom/readystatesoftware/viewbadger/BadgeView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    const v0, 0x1010084

    invoke-direct {p0, p1, p2, v0}, Lcom/readystatesoftware/viewbadger/BadgeView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 6

    const/4 v4, 0x0

    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move v3, p3

    invoke-direct/range {v0 .. v5}, Lcom/readystatesoftware/viewbadger/BadgeView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;ILandroid/view/View;I)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;ILandroid/view/View;I)V
    .locals 0

    invoke-direct {p0, p1, p2, p3}, Landroid/widget/TextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    invoke-direct {p0, p1, p4, p5}, Lcom/readystatesoftware/viewbadger/BadgeView;->a(Landroid/content/Context;Landroid/view/View;I)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/view/View;)V
    .locals 6

    const/4 v2, 0x0

    const v3, 0x1010084

    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v4, p2

    invoke-direct/range {v0 .. v5}, Lcom/readystatesoftware/viewbadger/BadgeView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;ILandroid/view/View;I)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/widget/TabWidget;I)V
    .locals 6

    const/4 v2, 0x0

    const v3, 0x1010084

    move-object v0, p0

    move-object v1, p1

    move-object v4, p2

    move v5, p3

    invoke-direct/range {v0 .. v5}, Lcom/readystatesoftware/viewbadger/BadgeView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;ILandroid/view/View;I)V

    return-void
.end method

.method private a(I)I
    .locals 3

    invoke-virtual {p0}, Lcom/readystatesoftware/viewbadger/BadgeView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const/4 v1, 0x1

    int-to-float v2, p1

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    invoke-static {v1, v2, v0}, Landroid/util/TypedValue;->applyDimension(IFLandroid/util/DisplayMetrics;)F

    move-result v0

    float-to-int v0, v0

    return v0
.end method

.method private a()Landroid/graphics/drawable/ShapeDrawable;
    .locals 5

    const/4 v4, 0x0

    const/16 v1, 0x8

    invoke-direct {p0, v1}, Lcom/readystatesoftware/viewbadger/BadgeView;->a(I)I

    move-result v0

    new-array v1, v1, [F

    const/4 v2, 0x0

    int-to-float v3, v0

    aput v3, v1, v2

    const/4 v2, 0x1

    int-to-float v3, v0

    aput v3, v1, v2

    const/4 v2, 0x2

    int-to-float v3, v0

    aput v3, v1, v2

    const/4 v2, 0x3

    int-to-float v3, v0

    aput v3, v1, v2

    const/4 v2, 0x4

    int-to-float v3, v0

    aput v3, v1, v2

    const/4 v2, 0x5

    int-to-float v3, v0

    aput v3, v1, v2

    const/4 v2, 0x6

    int-to-float v3, v0

    aput v3, v1, v2

    const/4 v2, 0x7

    int-to-float v0, v0

    aput v0, v1, v2

    new-instance v0, Landroid/graphics/drawable/shapes/RoundRectShape;

    invoke-direct {v0, v1, v4, v4}, Landroid/graphics/drawable/shapes/RoundRectShape;-><init>([FLandroid/graphics/RectF;[F)V

    new-instance v1, Landroid/graphics/drawable/ShapeDrawable;

    invoke-direct {v1, v0}, Landroid/graphics/drawable/ShapeDrawable;-><init>(Landroid/graphics/drawable/shapes/Shape;)V

    invoke-virtual {v1}, Landroid/graphics/drawable/ShapeDrawable;->getPaint()Landroid/graphics/Paint;

    move-result-object v0

    iget v2, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->n:I

    invoke-virtual {v0, v2}, Landroid/graphics/Paint;->setColor(I)V

    return-object v1
.end method

.method private a(Landroid/content/Context;Landroid/view/View;I)V
    .locals 7

    const-wide/16 v5, 0xc8

    const/4 v1, 0x5

    const/high16 v4, 0x3f80

    const/4 v3, 0x0

    const/4 v2, 0x0

    iput-object p1, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->i:Landroid/content/Context;

    iput-object p2, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->j:Landroid/view/View;

    iput p3, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->q:I

    const/4 v0, 0x2

    iput v0, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->k:I

    invoke-direct {p0, v1}, Lcom/readystatesoftware/viewbadger/BadgeView;->a(I)I

    move-result v0

    iput v0, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->l:I

    iget v0, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->l:I

    iput v0, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->m:I

    sget v0, Lcom/readystatesoftware/viewbadger/BadgeView;->e:I

    iput v0, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->n:I

    sget-object v0, Landroid/graphics/Typeface;->DEFAULT_BOLD:Landroid/graphics/Typeface;

    invoke-virtual {p0, v0}, Lcom/readystatesoftware/viewbadger/BadgeView;->setTypeface(Landroid/graphics/Typeface;)V

    invoke-direct {p0, v1}, Lcom/readystatesoftware/viewbadger/BadgeView;->a(I)I

    move-result v0

    invoke-virtual {p0, v0, v2, v0, v2}, Lcom/readystatesoftware/viewbadger/BadgeView;->setPadding(IIII)V

    const/4 v0, -0x1

    invoke-virtual {p0, v0}, Lcom/readystatesoftware/viewbadger/BadgeView;->setTextColor(I)V

    new-instance v0, Landroid/view/animation/AlphaAnimation;

    invoke-direct {v0, v3, v4}, Landroid/view/animation/AlphaAnimation;-><init>(FF)V

    sput-object v0, Lcom/readystatesoftware/viewbadger/BadgeView;->g:Landroid/view/animation/Animation;

    sget-object v0, Lcom/readystatesoftware/viewbadger/BadgeView;->g:Landroid/view/animation/Animation;

    new-instance v1, Landroid/view/animation/DecelerateInterpolator;

    invoke-direct {v1}, Landroid/view/animation/DecelerateInterpolator;-><init>()V

    invoke-virtual {v0, v1}, Landroid/view/animation/Animation;->setInterpolator(Landroid/view/animation/Interpolator;)V

    sget-object v0, Lcom/readystatesoftware/viewbadger/BadgeView;->g:Landroid/view/animation/Animation;

    invoke-virtual {v0, v5, v6}, Landroid/view/animation/Animation;->setDuration(J)V

    new-instance v0, Landroid/view/animation/AlphaAnimation;

    invoke-direct {v0, v4, v3}, Landroid/view/animation/AlphaAnimation;-><init>(FF)V

    sput-object v0, Lcom/readystatesoftware/viewbadger/BadgeView;->h:Landroid/view/animation/Animation;

    sget-object v0, Lcom/readystatesoftware/viewbadger/BadgeView;->h:Landroid/view/animation/Animation;

    new-instance v1, Landroid/view/animation/AccelerateInterpolator;

    invoke-direct {v1}, Landroid/view/animation/AccelerateInterpolator;-><init>()V

    invoke-virtual {v0, v1}, Landroid/view/animation/Animation;->setInterpolator(Landroid/view/animation/Interpolator;)V

    sget-object v0, Lcom/readystatesoftware/viewbadger/BadgeView;->h:Landroid/view/animation/Animation;

    invoke-virtual {v0, v5, v6}, Landroid/view/animation/Animation;->setDuration(J)V

    iput-boolean v2, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->o:Z

    iget-object v0, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->j:Landroid/view/View;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->j:Landroid/view/View;

    invoke-direct {p0, v0}, Lcom/readystatesoftware/viewbadger/BadgeView;->a(Landroid/view/View;)V

    :goto_0
    return-void

    :cond_0
    invoke-virtual {p0}, Lcom/readystatesoftware/viewbadger/BadgeView;->show()V

    goto :goto_0
.end method

.method private a(Landroid/view/View;)V
    .locals 6

    const/16 v5, 0x8

    const/4 v4, -0x1

    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    invoke-virtual {p1}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    new-instance v2, Landroid/widget/FrameLayout;

    iget-object v3, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->i:Landroid/content/Context;

    invoke-direct {v2, v3}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    instance-of v3, p1, Landroid/widget/TabWidget;

    if-eqz v3, :cond_0

    check-cast p1, Landroid/widget/TabWidget;

    iget v0, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->q:I

    invoke-virtual {p1, v0}, Landroid/widget/TabWidget;->getChildTabViewAt(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->j:Landroid/view/View;

    check-cast v0, Landroid/view/ViewGroup;

    new-instance v1, Landroid/view/ViewGroup$LayoutParams;

    invoke-direct {v1, v4, v4}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v2, v1}, Landroid/view/ViewGroup;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    invoke-virtual {p0, v5}, Lcom/readystatesoftware/viewbadger/BadgeView;->setVisibility(I)V

    invoke-virtual {v2, p0}, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V

    :goto_0
    return-void

    :cond_0
    check-cast v0, Landroid/view/ViewGroup;

    invoke-virtual {v0, p1}, Landroid/view/ViewGroup;->indexOfChild(Landroid/view/View;)I

    move-result v3

    invoke-virtual {v0, p1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    invoke-virtual {v0, v2, v3, v1}, Landroid/view/ViewGroup;->addView(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V

    invoke-virtual {v2, p1}, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V

    invoke-virtual {p0, v5}, Lcom/readystatesoftware/viewbadger/BadgeView;->setVisibility(I)V

    invoke-virtual {v2, p0}, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V

    invoke-virtual {v0}, Landroid/view/ViewGroup;->invalidate()V

    goto :goto_0
.end method

.method private a(ZLandroid/view/animation/Animation;)V
    .locals 1

    invoke-virtual {p0}, Lcom/readystatesoftware/viewbadger/BadgeView;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->p:Landroid/graphics/drawable/ShapeDrawable;

    if-nez v0, :cond_0

    invoke-direct {p0}, Lcom/readystatesoftware/viewbadger/BadgeView;->a()Landroid/graphics/drawable/ShapeDrawable;

    move-result-object v0

    iput-object v0, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->p:Landroid/graphics/drawable/ShapeDrawable;

    :cond_0
    iget-object v0, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->p:Landroid/graphics/drawable/ShapeDrawable;

    invoke-virtual {p0, v0}, Lcom/readystatesoftware/viewbadger/BadgeView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    :cond_1
    invoke-direct {p0}, Lcom/readystatesoftware/viewbadger/BadgeView;->b()V

    if-eqz p1, :cond_2

    invoke-virtual {p0, p2}, Lcom/readystatesoftware/viewbadger/BadgeView;->startAnimation(Landroid/view/animation/Animation;)V

    :cond_2
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/readystatesoftware/viewbadger/BadgeView;->setVisibility(I)V

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->o:Z

    return-void
.end method

.method private a(ZLandroid/view/animation/Animation;Landroid/view/animation/Animation;)V
    .locals 3

    const/4 v0, 0x1

    const/4 v1, 0x0

    iget-boolean v2, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->o:Z

    if-eqz v2, :cond_1

    if-eqz p1, :cond_0

    if-eqz p3, :cond_0

    :goto_0
    invoke-direct {p0, v0, p3}, Lcom/readystatesoftware/viewbadger/BadgeView;->b(ZLandroid/view/animation/Animation;)V

    :goto_1
    return-void

    :cond_0
    move v0, v1

    goto :goto_0

    :cond_1
    if-eqz p1, :cond_2

    if-eqz p2, :cond_2

    :goto_2
    invoke-direct {p0, v0, p2}, Lcom/readystatesoftware/viewbadger/BadgeView;->a(ZLandroid/view/animation/Animation;)V

    goto :goto_1

    :cond_2
    move v0, v1

    goto :goto_2
.end method

.method private b()V
    .locals 4

    const/4 v1, -0x2

    const/4 v3, 0x0

    new-instance v0, Landroid/widget/FrameLayout$LayoutParams;

    invoke-direct {v0, v1, v1}, Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V

    iget v1, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->k:I

    packed-switch v1, :pswitch_data_0

    :goto_0
    invoke-virtual {p0, v0}, Lcom/readystatesoftware/viewbadger/BadgeView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    return-void

    :pswitch_0
    const/16 v1, 0x33

    iput v1, v0, Landroid/widget/FrameLayout$LayoutParams;->gravity:I

    iget v1, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->l:I

    iget v2, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->m:I

    invoke-virtual {v0, v1, v2, v3, v3}, Landroid/widget/FrameLayout$LayoutParams;->setMargins(IIII)V

    goto :goto_0

    :pswitch_1
    const/16 v1, 0x35

    iput v1, v0, Landroid/widget/FrameLayout$LayoutParams;->gravity:I

    iget v1, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->m:I

    iget v2, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->l:I

    invoke-virtual {v0, v3, v1, v2, v3}, Landroid/widget/FrameLayout$LayoutParams;->setMargins(IIII)V

    goto :goto_0

    :pswitch_2
    const/16 v1, 0x53

    iput v1, v0, Landroid/widget/FrameLayout$LayoutParams;->gravity:I

    iget v1, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->l:I

    iget v2, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->m:I

    invoke-virtual {v0, v1, v3, v3, v2}, Landroid/widget/FrameLayout$LayoutParams;->setMargins(IIII)V

    goto :goto_0

    :pswitch_3
    const/16 v1, 0x55

    iput v1, v0, Landroid/widget/FrameLayout$LayoutParams;->gravity:I

    iget v1, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->l:I

    iget v2, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->m:I

    invoke-virtual {v0, v3, v3, v1, v2}, Landroid/widget/FrameLayout$LayoutParams;->setMargins(IIII)V

    goto :goto_0

    :pswitch_4
    const/16 v1, 0x11

    iput v1, v0, Landroid/widget/FrameLayout$LayoutParams;->gravity:I

    invoke-virtual {v0, v3, v3, v3, v3}, Landroid/widget/FrameLayout$LayoutParams;->setMargins(IIII)V

    goto :goto_0

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method

.method private b(ZLandroid/view/animation/Animation;)V
    .locals 1

    const/16 v0, 0x8

    invoke-virtual {p0, v0}, Lcom/readystatesoftware/viewbadger/BadgeView;->setVisibility(I)V

    if-eqz p1, :cond_0

    invoke-virtual {p0, p2}, Lcom/readystatesoftware/viewbadger/BadgeView;->startAnimation(Landroid/view/animation/Animation;)V

    :cond_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->o:Z

    return-void
.end method


# virtual methods
.method public decrement(I)I
    .locals 1

    neg-int v0, p1

    invoke-virtual {p0, v0}, Lcom/readystatesoftware/viewbadger/BadgeView;->increment(I)I

    move-result v0

    return v0
.end method

.method public getBadgeBackgroundColor()I
    .locals 1

    iget v0, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->n:I

    return v0
.end method

.method public getBadgePosition()I
    .locals 1

    iget v0, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->k:I

    return v0
.end method

.method public getHorizontalBadgeMargin()I
    .locals 1

    iget v0, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->l:I

    return v0
.end method

.method public getTarget()Landroid/view/View;
    .locals 1

    iget-object v0, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->j:Landroid/view/View;

    return-object v0
.end method

.method public getVerticalBadgeMargin()I
    .locals 1

    iget v0, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->m:I

    return v0
.end method

.method public hide()V
    .locals 2

    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/readystatesoftware/viewbadger/BadgeView;->b(ZLandroid/view/animation/Animation;)V

    return-void
.end method

.method public hide(Landroid/view/animation/Animation;)V
    .locals 1

    const/4 v0, 0x1

    invoke-direct {p0, v0, p1}, Lcom/readystatesoftware/viewbadger/BadgeView;->b(ZLandroid/view/animation/Animation;)V

    return-void
.end method

.method public hide(Z)V
    .locals 1

    sget-object v0, Lcom/readystatesoftware/viewbadger/BadgeView;->h:Landroid/view/animation/Animation;

    invoke-direct {p0, p1, v0}, Lcom/readystatesoftware/viewbadger/BadgeView;->b(ZLandroid/view/animation/Animation;)V

    return-void
.end method

.method public increment(I)I
    .locals 2

    const/4 v0, 0x0

    invoke-virtual {p0}, Lcom/readystatesoftware/viewbadger/BadgeView;->getText()Ljava/lang/CharSequence;

    move-result-object v1

    if-eqz v1, :cond_0

    :try_start_0
    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    :cond_0
    :goto_0
    add-int/2addr v0, p1

    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/readystatesoftware/viewbadger/BadgeView;->setText(Ljava/lang/CharSequence;)V

    return v0

    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method public isShown()Z
    .locals 1

    iget-boolean v0, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->o:Z

    return v0
.end method

.method public setBadgeBackgroundColor(I)V
    .locals 1

    iput p1, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->n:I

    invoke-direct {p0}, Lcom/readystatesoftware/viewbadger/BadgeView;->a()Landroid/graphics/drawable/ShapeDrawable;

    move-result-object v0

    iput-object v0, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->p:Landroid/graphics/drawable/ShapeDrawable;

    return-void
.end method

.method public setBadgeMargin(I)V
    .locals 0

    iput p1, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->l:I

    iput p1, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->m:I

    return-void
.end method

.method public setBadgeMargin(II)V
    .locals 0

    iput p1, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->l:I

    iput p2, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->m:I

    return-void
.end method

.method public setBadgePosition(I)V
    .locals 0

    iput p1, p0, Lcom/readystatesoftware/viewbadger/BadgeView;->k:I

    return-void
.end method

.method public show()V
    .locals 2

    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/readystatesoftware/viewbadger/BadgeView;->a(ZLandroid/view/animation/Animation;)V

    return-void
.end method

.method public show(Landroid/view/animation/Animation;)V
    .locals 1

    const/4 v0, 0x1

    invoke-direct {p0, v0, p1}, Lcom/readystatesoftware/viewbadger/BadgeView;->a(ZLandroid/view/animation/Animation;)V

    return-void
.end method

.method public show(Z)V
    .locals 1

    sget-object v0, Lcom/readystatesoftware/viewbadger/BadgeView;->g:Landroid/view/animation/Animation;

    invoke-direct {p0, p1, v0}, Lcom/readystatesoftware/viewbadger/BadgeView;->a(ZLandroid/view/animation/Animation;)V

    return-void
.end method

.method public toggle()V
    .locals 2

    const/4 v1, 0x0

    const/4 v0, 0x0

    invoke-direct {p0, v0, v1, v1}, Lcom/readystatesoftware/viewbadger/BadgeView;->a(ZLandroid/view/animation/Animation;Landroid/view/animation/Animation;)V

    return-void
.end method

.method public toggle(Landroid/view/animation/Animation;Landroid/view/animation/Animation;)V
    .locals 1

    const/4 v0, 0x1

    invoke-direct {p0, v0, p1, p2}, Lcom/readystatesoftware/viewbadger/BadgeView;->a(ZLandroid/view/animation/Animation;Landroid/view/animation/Animation;)V

    return-void
.end method

.method public toggle(Z)V
    .locals 2

    sget-object v0, Lcom/readystatesoftware/viewbadger/BadgeView;->g:Landroid/view/animation/Animation;

    sget-object v1, Lcom/readystatesoftware/viewbadger/BadgeView;->h:Landroid/view/animation/Animation;

    invoke-direct {p0, p1, v0, v1}, Lcom/readystatesoftware/viewbadger/BadgeView;->a(ZLandroid/view/animation/Animation;Landroid/view/animation/Animation;)V

    return-void
.end method
