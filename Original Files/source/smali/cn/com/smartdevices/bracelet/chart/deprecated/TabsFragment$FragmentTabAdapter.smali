.class public Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment$FragmentTabAdapter;
.super Landroid/support/v13/app/FragmentPagerAdapter;


# instance fields
.field final synthetic a:Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;


# direct methods
.method public constructor <init>(Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;Landroid/app/FragmentManager;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment$FragmentTabAdapter;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;

    invoke-direct {p0, p2}, Landroid/support/v13/app/FragmentPagerAdapter;-><init>(Landroid/app/FragmentManager;)V

    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment$FragmentTabAdapter;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;->mFragmentTabs:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public getItem(I)Landroid/app/Fragment;
    .locals 3

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment$FragmentTabAdapter;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;->mFragmentTabs:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment$FragmentTab;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment$FragmentTabAdapter;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;

    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    iget-object v2, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment$FragmentTab;->b:Ljava/lang/Class;

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment$FragmentTab;->c:Landroid/os/Bundle;

    invoke-static {v1, v2, v0}, Landroid/app/Fragment;->instantiate(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Landroid/app/Fragment;

    move-result-object v0

    return-object v0
.end method

.method public getPageTitle(I)Ljava/lang/CharSequence;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment$FragmentTabAdapter;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;->mFragmentTabs:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment$FragmentTab;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment$FragmentTab;->a:Ljava/lang/String;

    return-object v0
.end method
