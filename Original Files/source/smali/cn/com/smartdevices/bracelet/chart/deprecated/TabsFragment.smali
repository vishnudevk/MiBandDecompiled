.class public Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;
.super Landroid/app/Fragment;

# interfaces
.implements Landroid/view/View$OnClickListener;


# static fields
.field private static final a:Ljava/lang/String; = "TabsFragment"


# instance fields
.field protected mAdapter:Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment$FragmentTabAdapter;

.field protected mFragmentTabs:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment$FragmentTab;",
            ">;"
        }
    .end annotation
.end field

.field protected mPager:Landroid/support/v4/view/ViewPager;

.field protected mTabHost:Landroid/view/ViewGroup;

.field protected mTabHostItems:[Landroid/view/View;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    return-void
.end method

.method private a(I)V
    .locals 5

    const/4 v1, 0x0

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;->mTabHostItems:[Landroid/view/View;

    array-length v3, v2

    move v0, v1

    :goto_0
    if-ge v0, v3, :cond_0

    aget-object v4, v2, v0

    invoke-virtual {v4, v1}, Landroid/view/View;->setActivated(Z)V

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_0
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;->mTabHostItems:[Landroid/view/View;

    aget-object v0, v0, p1

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/view/View;->setActivated(Z)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;->mPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v0, p1}, Landroid/support/v4/view/ViewPager;->setCurrentItem(I)V

    return-void
.end method


# virtual methods
.method public fillFragmentTabs(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment$FragmentTab;",
            ">;)V"
        }
    .end annotation

    return-void
.end method

.method protected inflateLayout()I
    .locals 1

    const v0, 0x7f03004d

    return v0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 4
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    const/4 v2, 0x0

    invoke-super {p0, p1}, Landroid/app/Fragment;->onActivityCreated(Landroid/os/Bundle;)V

    const-string v0, "TabsFragment"

    const-string v1, "OnActivityCreated!!"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0a015d

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;->mTabHost:Landroid/view/ViewGroup;

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0a015c

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v4/view/ViewPager;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;->mPager:Landroid/support/v4/view/ViewPager;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;->mFragmentTabs:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    new-array v0, v0, [Landroid/view/View;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;->mTabHostItems:[Landroid/view/View;

    move v1, v2

    :goto_0
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;->mFragmentTabs:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_0

    const/4 v0, 0x0

    packed-switch v1, :pswitch_data_0

    move-object v3, v0

    :goto_1
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;->mTabHostItems:[Landroid/view/View;

    aput-object v3, v0, v1

    invoke-virtual {v3, p0}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;->mFragmentTabs:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment$FragmentTab;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment$FragmentTab;->a:Ljava/lang/String;

    invoke-virtual {v3, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    :pswitch_0
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;->mTabHost:Landroid/view/ViewGroup;

    const v3, 0x7f0a015e

    invoke-virtual {v0, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    move-object v3, v0

    goto :goto_1

    :pswitch_1
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;->mTabHost:Landroid/view/ViewGroup;

    const v3, 0x7f0a015f

    invoke-virtual {v0, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    move-object v3, v0

    goto :goto_1

    :pswitch_2
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;->mTabHost:Landroid/view/ViewGroup;

    const v3, 0x7f0a0160

    invoke-virtual {v0, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    move-object v3, v0

    goto :goto_1

    :cond_0
    new-instance v0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment$FragmentTabAdapter;

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;->getChildFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment$FragmentTabAdapter;-><init>(Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;Landroid/app/FragmentManager;)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;->mAdapter:Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment$FragmentTabAdapter;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;->mPager:Landroid/support/v4/view/ViewPager;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;->mAdapter:Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment$FragmentTabAdapter;

    invoke-virtual {v0, v1}, Landroid/support/v4/view/ViewPager;->setAdapter(Landroid/support/v4/view/PagerAdapter;)V

    invoke-direct {p0, v2}, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;->a(I)V

    return-void

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 2

    invoke-super {p0, p1}, Landroid/app/Fragment;->onAttach(Landroid/app/Activity;)V

    const-string v0, "TabsFragment"

    const-string v1, "OnAttach!!"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 1

    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    :goto_0
    return-void

    :pswitch_0
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;->a(I)V

    goto :goto_0

    :pswitch_1
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;->a(I)V

    goto :goto_0

    :pswitch_2
    const/4 v0, 0x2

    invoke-direct {p0, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;->a(I)V

    goto :goto_0

    nop

    :pswitch_data_0
    .packed-switch 0x7f0a015e
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2

    invoke-super {p0, p1}, Landroid/app/Fragment;->onCreate(Landroid/os/Bundle;)V

    const-string v0, "TabsFragment"

    const-string v1, "OnCreate!!"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;->mFragmentTabs:Ljava/util/ArrayList;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;->mFragmentTabs:Ljava/util/ArrayList;

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;->fillFragmentTabs(Ljava/util/ArrayList;)V

    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    const-string v0, "TabsFragment"

    const-string v1, "OnCreateView!!"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;->inflateLayout()I

    move-result v0

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onDestroy()V
    .locals 2

    invoke-super {p0}, Landroid/app/Fragment;->onDestroy()V

    const-string v0, "TabsFragment"

    const-string v1, "OnDestroy!!"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public onDestroyView()V
    .locals 2

    invoke-super {p0}, Landroid/app/Fragment;->onDestroyView()V

    const-string v0, "TabsFragment"

    const-string v1, "OnDestroyView!!"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public onDetach()V
    .locals 2

    invoke-super {p0}, Landroid/app/Fragment;->onDetach()V

    const-string v0, "TabsFragment"

    const-string v1, "OnDetach!!"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 4

    invoke-super {p0, p1}, Landroid/app/Fragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;->mPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v0}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v0

    const-string v1, "TabsFragment"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Save Current Item : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    const-string v1, "CurrentTab"

    invoke-virtual {p1, v1, v0}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    return-void
.end method

.method public onViewStateRestored(Landroid/os/Bundle;)V
    .locals 4
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    invoke-super {p0, p1}, Landroid/app/Fragment;->onViewStateRestored(Landroid/os/Bundle;)V

    if-eqz p1, :cond_0

    const-string v0, "CurrentTab"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    const-string v1, "TabsFragment"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Restore Last Item : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;->mPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v1}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v1

    if-eq v0, v1, :cond_0

    invoke-direct {p0, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;->a(I)V

    :cond_0
    return-void
.end method
