.class public Lcom/twotoasters/jazzylistview/effects/HelixEffect;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/twotoasters/jazzylistview/JazzyEffect;


# static fields
.field private static final a:I = 0xb4


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public initView(Landroid/view/View;II)V
    .locals 1

    const/high16 v0, 0x4334

    invoke-static {p1, v0}, Lcom/nineoldandroids/view/ViewHelper;->setRotationY(Landroid/view/View;F)V

    return-void
.end method

.method public setupAnimation(Landroid/view/View;IILcom/nineoldandroids/view/ViewPropertyAnimator;)V
    .locals 1

    mul-int/lit16 v0, p3, 0xb4

    int-to-float v0, v0

    invoke-virtual {p4, v0}, Lcom/nineoldandroids/view/ViewPropertyAnimator;->rotationYBy(F)Lcom/nineoldandroids/view/ViewPropertyAnimator;

    return-void
.end method
