.class public Lcom/twotoasters/jazzylistview/effects/ZipperEffect;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/twotoasters/jazzylistview/JazzyEffect;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public initView(Landroid/view/View;II)V
    .locals 2

    const/4 v0, 0x1

    rem-int/lit8 v1, p2, 0x2

    if-nez v1, :cond_1

    move v1, v0

    :goto_0
    if-eqz v1, :cond_0

    const/4 v0, -0x1

    :cond_0
    invoke-virtual {p1}, Landroid/view/View;->getWidth()I

    move-result v1

    mul-int/2addr v0, v1

    int-to-float v0, v0

    invoke-static {p1, v0}, Lcom/nineoldandroids/view/ViewHelper;->setTranslationX(Landroid/view/View;F)V

    return-void

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public setupAnimation(Landroid/view/View;IILcom/nineoldandroids/view/ViewPropertyAnimator;)V
    .locals 1

    const/4 v0, 0x0

    invoke-virtual {p4, v0}, Lcom/nineoldandroids/view/ViewPropertyAnimator;->translationX(F)Lcom/nineoldandroids/view/ViewPropertyAnimator;

    return-void
.end method
