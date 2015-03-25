.class public Lcom/twotoasters/jazzylistview/effects/CurlEffect;
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

    const/4 v0, 0x0

    invoke-static {p1, v0}, Lcom/nineoldandroids/view/ViewHelper;->setPivotX(Landroid/view/View;F)V

    invoke-virtual {p1}, Landroid/view/View;->getHeight()I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    int-to-float v0, v0

    invoke-static {p1, v0}, Lcom/nineoldandroids/view/ViewHelper;->setPivotY(Landroid/view/View;F)V

    const/high16 v0, 0x42b4

    invoke-static {p1, v0}, Lcom/nineoldandroids/view/ViewHelper;->setRotationY(Landroid/view/View;F)V

    return-void
.end method

.method public setupAnimation(Landroid/view/View;IILcom/nineoldandroids/view/ViewPropertyAnimator;)V
    .locals 1

    const/high16 v0, -0x3d4c

    invoke-virtual {p4, v0}, Lcom/nineoldandroids/view/ViewPropertyAnimator;->rotationYBy(F)Lcom/nineoldandroids/view/ViewPropertyAnimator;

    return-void
.end method
