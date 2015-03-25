.class public Lcom/twotoasters/jazzylistview/JazzyListView;
.super Landroid/widget/ListView;


# instance fields
.field private final a:Lcom/twotoasters/jazzylistview/JazzyHelper;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    invoke-direct {p0, p1}, Landroid/widget/ListView;-><init>(Landroid/content/Context;)V

    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/twotoasters/jazzylistview/JazzyListView;->a(Landroid/content/Context;Landroid/util/AttributeSet;)Lcom/twotoasters/jazzylistview/JazzyHelper;

    move-result-object v0

    iput-object v0, p0, Lcom/twotoasters/jazzylistview/JazzyListView;->a:Lcom/twotoasters/jazzylistview/JazzyHelper;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    invoke-direct {p0, p1, p2}, Landroid/widget/ListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    invoke-direct {p0, p1, p2}, Lcom/twotoasters/jazzylistview/JazzyListView;->a(Landroid/content/Context;Landroid/util/AttributeSet;)Lcom/twotoasters/jazzylistview/JazzyHelper;

    move-result-object v0

    iput-object v0, p0, Lcom/twotoasters/jazzylistview/JazzyListView;->a:Lcom/twotoasters/jazzylistview/JazzyHelper;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1

    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    invoke-direct {p0, p1, p2}, Lcom/twotoasters/jazzylistview/JazzyListView;->a(Landroid/content/Context;Landroid/util/AttributeSet;)Lcom/twotoasters/jazzylistview/JazzyHelper;

    move-result-object v0

    iput-object v0, p0, Lcom/twotoasters/jazzylistview/JazzyListView;->a:Lcom/twotoasters/jazzylistview/JazzyHelper;

    return-void
.end method

.method private a(Landroid/content/Context;Landroid/util/AttributeSet;)Lcom/twotoasters/jazzylistview/JazzyHelper;
    .locals 1

    new-instance v0, Lcom/twotoasters/jazzylistview/JazzyHelper;

    invoke-direct {v0, p1, p2}, Lcom/twotoasters/jazzylistview/JazzyHelper;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    invoke-super {p0, v0}, Landroid/widget/ListView;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    return-object v0
.end method


# virtual methods
.method public setMaxAnimationVelocity(I)V
    .locals 1

    iget-object v0, p0, Lcom/twotoasters/jazzylistview/JazzyListView;->a:Lcom/twotoasters/jazzylistview/JazzyHelper;

    invoke-virtual {v0, p1}, Lcom/twotoasters/jazzylistview/JazzyHelper;->setMaxAnimationVelocity(I)V

    return-void
.end method

.method public final setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V
    .locals 1

    iget-object v0, p0, Lcom/twotoasters/jazzylistview/JazzyListView;->a:Lcom/twotoasters/jazzylistview/JazzyHelper;

    invoke-virtual {v0, p1}, Lcom/twotoasters/jazzylistview/JazzyHelper;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    return-void
.end method

.method public setShouldOnlyAnimateFling(Z)V
    .locals 1

    iget-object v0, p0, Lcom/twotoasters/jazzylistview/JazzyListView;->a:Lcom/twotoasters/jazzylistview/JazzyHelper;

    invoke-virtual {v0, p1}, Lcom/twotoasters/jazzylistview/JazzyHelper;->setShouldOnlyAnimateFling(Z)V

    return-void
.end method

.method public setShouldOnlyAnimateNewItems(Z)V
    .locals 1

    iget-object v0, p0, Lcom/twotoasters/jazzylistview/JazzyListView;->a:Lcom/twotoasters/jazzylistview/JazzyHelper;

    invoke-virtual {v0, p1}, Lcom/twotoasters/jazzylistview/JazzyHelper;->setShouldOnlyAnimateNewItems(Z)V

    return-void
.end method

.method public setSimulateGridWithList(Z)V
    .locals 1

    iget-object v0, p0, Lcom/twotoasters/jazzylistview/JazzyListView;->a:Lcom/twotoasters/jazzylistview/JazzyHelper;

    invoke-virtual {v0, p1}, Lcom/twotoasters/jazzylistview/JazzyHelper;->setSimulateGridWithList(Z)V

    if-nez p1, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {p0, v0}, Lcom/twotoasters/jazzylistview/JazzyListView;->setClipChildren(Z)V

    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setTransitionEffect(I)V
    .locals 1

    iget-object v0, p0, Lcom/twotoasters/jazzylistview/JazzyListView;->a:Lcom/twotoasters/jazzylistview/JazzyHelper;

    invoke-virtual {v0, p1}, Lcom/twotoasters/jazzylistview/JazzyHelper;->setTransitionEffect(I)V

    return-void
.end method

.method public setTransitionEffect(Lcom/twotoasters/jazzylistview/JazzyEffect;)V
    .locals 1

    iget-object v0, p0, Lcom/twotoasters/jazzylistview/JazzyListView;->a:Lcom/twotoasters/jazzylistview/JazzyHelper;

    invoke-virtual {v0, p1}, Lcom/twotoasters/jazzylistview/JazzyHelper;->setTransitionEffect(Lcom/twotoasters/jazzylistview/JazzyEffect;)V

    return-void
.end method
