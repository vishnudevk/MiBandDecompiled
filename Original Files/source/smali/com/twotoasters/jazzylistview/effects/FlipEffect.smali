.class public Lcom/twotoasters/jazzylistview/effects/FlipEffect;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/twotoasters/jazzylistview/JazzyEffect;


# static fields
.field private static final a:I = 0x5a


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public initView(Landroid/view/View;II)V
    .locals 1

    invoke-virtual {p1}, Landroid/view/View;->getWidth()I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    int-to-float v0, v0

    invoke-static {p1, v0}, Lcom/nineoldandroids/view/ViewHelper;->setPivotX(Landroid/view/View;F)V

    invoke-virtual {p1}, Landroid/view/View;->getHeight()I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    int-to-float v0, v0

    invoke-static {p1, v0}, Lcom/nineoldandroids/view/ViewHelper;->setPivotY(Landroid/view/View;F)V

    mul-int/lit8 v0, p3, -0x5a

    int-to-float v0, v0

    invoke-static {p1, v0}, Lcom/nineoldandroids/view/ViewHelper;->setRotationX(Landroid/view/View;F)V

    return-void
.end method

.method public setupAnimation(Landroid/view/View;IILcom/nineoldandroids/view/ViewPropertyAnimator;)V
    .locals 1

    mul-int/lit8 v0, p3, 0x5a

    int-to-float v0, v0

    invoke-virtual {p4, v0}, Lcom/nineoldandroids/view/ViewPropertyAnimator;->rotationXBy(F)Lcom/nineoldandroids/view/ViewPropertyAnimator;

    return-void
.end method
