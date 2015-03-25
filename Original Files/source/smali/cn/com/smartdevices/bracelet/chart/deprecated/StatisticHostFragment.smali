.class public Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;
.super Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;

# interfaces
.implements Landroid/view/View$OnClickListener;


# static fields
.field public static final DEFAULT_MODE:I = 0x101

.field public static final MODE_AVERAGE:I = 0x100

.field public static final MODE_DETAIL:I = 0x10

.field public static final MODE_SIMPLE:I = 0x1

.field public static final MODE_TOTAL:I = 0x1000

.field private static final a:Ljava/lang/String; = "Statistic.Host"

.field public static sMode:I


# instance fields
.field private b:Landroid/view/View;

.field private c:Landroid/view/View;

.field private d:Landroid/widget/TextView;

.field private e:Landroid/view/View;

.field private f:Landroid/view/View;

.field private g:Landroid/view/View;

.field private h:Landroid/view/View;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;-><init>()V

    return-void
.end method

.method private a(Landroid/content/Context;)I
    .locals 5

    const/16 v0, 0x101

    const-string v1, "StatisticViewMode"

    const/4 v2, 0x0

    invoke-virtual {p1, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    const-string v2, "Mode"

    invoke-interface {v1, v2, v0}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v1

    and-int/lit8 v2, v1, 0x1

    if-nez v2, :cond_0

    and-int/lit8 v2, v1, 0x10

    if-nez v2, :cond_0

    const-string v2, "Statistic.Host"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Invalid Mode Code : "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v2, v1}, Lcn/com/smartdevices/bracelet/Debug;->w(Ljava/lang/String;Ljava/lang/String;)V

    :goto_0
    invoke-direct {p0, p1, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->a(Landroid/content/Context;I)V

    const-string v1, "Statistic.Host"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Read Mode : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {v0}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    return v0

    :cond_0
    and-int/lit16 v2, v1, 0x100

    if-nez v2, :cond_1

    and-int/lit16 v2, v1, 0x1000

    if-nez v2, :cond_1

    const-string v2, "Statistic.Host"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Invalid Mode Code : "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v2, v1}, Lcn/com/smartdevices/bracelet/Debug;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_1
    and-int/lit8 v2, v1, 0x1

    if-lez v2, :cond_2

    and-int/lit8 v2, v1, 0x10

    if-lez v2, :cond_2

    const-string v2, "Statistic.Host"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Invalid Mode Code : "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v2, v1}, Lcn/com/smartdevices/bracelet/Debug;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_2
    and-int/lit16 v2, v1, 0x100

    if-lez v2, :cond_3

    and-int/lit16 v2, v1, 0x1000

    if-lez v2, :cond_3

    const-string v2, "Statistic.Host"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Invalid Mode Code : "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v2, v1}, Lcn/com/smartdevices/bracelet/Debug;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    :cond_3
    move v0, v1

    goto/16 :goto_0
.end method

.method private a()V
    .locals 5

    const v4, 0x7f0a001e

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->getView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->buildDrawingCache()V

    invoke-virtual {v0}, Landroid/view/View;->getDrawingCache()Landroid/graphics/Bitmap;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v3

    invoke-virtual {v3}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/tmp.jpg"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2, v1}, Lcn/com/smartdevices/bracelet/Utils;->saveBitmapToFile(Ljava/lang/String;Landroid/graphics/Bitmap;)Z

    invoke-virtual {v0, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->destroyDrawingCache()V

    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    const-class v3, Lcn/com/smartdevices/bracelet/ui/ShareActivity;

    invoke-virtual {v0, v1, v3}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    const-string v1, "date"

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->d:Landroid/widget/TextView;

    invoke-virtual {v3}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v3

    invoke-virtual {v0, v1, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/CharSequence;)Landroid/content/Intent;

    const-string v1, "Mode"

    const/4 v3, 0x1

    invoke-virtual {v0, v1, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    const-string v1, "Image"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    const v1, 0x8001

    invoke-virtual {p0, v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->startActivityForResult(Landroid/content/Intent;I)V

    return-void
.end method

.method private a(I)V
    .locals 2

    sget v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->sMode:I

    and-int/2addr v0, p1

    if-nez v0, :cond_2

    sget v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->sMode:I

    const/4 v1, 0x1

    if-eq p1, v1, :cond_0

    const/16 v1, 0x10

    if-ne p1, v1, :cond_3

    :cond_0
    sget v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->sMode:I

    and-int/lit8 v0, v0, -0x2

    and-int/lit8 v0, v0, -0x11

    :cond_1
    :goto_0
    or-int/2addr v0, p1

    sput v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->sMode:I

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-direct {p0, v1, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->a(Landroid/content/Context;I)V

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->b()V

    invoke-static {}, Lde/greenrobot/event/EventBus;->getDefault()Lde/greenrobot/event/EventBus;

    move-result-object v0

    new-instance v1, Lcn/com/smartdevices/bracelet/eventbus/EventSwitchViewMode;

    invoke-direct {v1}, Lcn/com/smartdevices/bracelet/eventbus/EventSwitchViewMode;-><init>()V

    invoke-virtual {v0, v1}, Lde/greenrobot/event/EventBus;->post(Ljava/lang/Object;)V

    :cond_2
    return-void

    :cond_3
    const/16 v1, 0x100

    if-eq p1, v1, :cond_4

    const/16 v1, 0x1000

    if-ne p1, v1, :cond_1

    :cond_4
    sget v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->sMode:I

    and-int/lit16 v0, v0, -0x101

    and-int/lit16 v0, v0, -0x1001

    goto :goto_0
.end method

.method private a(Landroid/content/Context;I)V
    .locals 3

    const-string v0, "Statistic.Host"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Save Mode : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {p2}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    const-string v0, "StatisticViewMode"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "Mode"

    invoke-interface {v0, v1, p2}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    return-void
.end method

.method private b()V
    .locals 3

    const/4 v2, 0x1

    const/4 v1, 0x0

    sget v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->sMode:I

    and-int/lit8 v0, v0, 0x1

    if-lez v0, :cond_2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->e:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setActivated(Z)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->f:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setActivated(Z)V

    :cond_0
    :goto_0
    sget v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->sMode:I

    and-int/lit16 v0, v0, 0x100

    if-lez v0, :cond_3

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->g:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setActivated(Z)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->h:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setActivated(Z)V

    :cond_1
    :goto_1
    return-void

    :cond_2
    sget v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->sMode:I

    and-int/lit8 v0, v0, 0x10

    if-lez v0, :cond_0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->e:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setActivated(Z)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->f:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setActivated(Z)V

    goto :goto_0

    :cond_3
    sget v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->sMode:I

    and-int/lit16 v0, v0, 0x1000

    if-lez v0, :cond_1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->g:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setActivated(Z)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->h:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setActivated(Z)V

    goto :goto_1
.end method


# virtual methods
.method public fillFragmentTabs(Ljava/util/ArrayList;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment$FragmentTab;",
            ">;)V"
        }
    .end annotation

    new-instance v0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment$FragmentTab;

    invoke-direct {v0, p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment$FragmentTab;-><init>(Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;)V

    const v1, 0x7f0d01ed

    invoke-virtual {p0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment$FragmentTab;->a:Ljava/lang/String;

    const-class v1, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticDailyFragment;

    iput-object v1, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment$FragmentTab;->b:Ljava/lang/Class;

    invoke-virtual {p1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    new-instance v0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment$FragmentTab;

    invoke-direct {v0, p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment$FragmentTab;-><init>(Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;)V

    const v1, 0x7f0d0101

    invoke-virtual {p0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment$FragmentTab;->a:Ljava/lang/String;

    const-class v1, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticWeeklyFragment;

    iput-object v1, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment$FragmentTab;->b:Ljava/lang/Class;

    invoke-virtual {p1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    new-instance v0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment$FragmentTab;

    invoke-direct {v0, p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment$FragmentTab;-><init>(Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;)V

    const v1, 0x7f0d01f0

    invoke-virtual {p0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment$FragmentTab;->a:Ljava/lang/String;

    const-class v1, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticMonthlyFragment;

    iput-object v1, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment$FragmentTab;->b:Ljava/lang/Class;

    invoke-virtual {p1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method protected inflateLayout()I
    .locals 1

    const v0, 0x7f03004a

    return v0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2

    invoke-super {p0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;->onActivityCreated(Landroid/os/Bundle;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->mPager:Landroid/support/v4/view/ViewPager;

    new-instance v1, Lcn/com/smartdevices/bracelet/chart/deprecated/v;

    invoke-direct {v1, p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/v;-><init>(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;)V

    invoke-virtual {v0, v1}, Landroid/support/v4/view/ViewPager;->setOnPageChangeListener(Landroid/support/v4/view/ViewPager$OnPageChangeListener;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->mPager:Landroid/support/v4/view/ViewPager;

    check-cast v0, Lcn/com/smartdevices/bracelet/view/CustomViewPager;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/view/CustomViewPager;->setSwipeable(Z)V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0a0034

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->b:Landroid/view/View;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->b:Landroid/view/View;

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0a00aa

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->c:Landroid/view/View;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->c:Landroid/view/View;

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0a00d7

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->d:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0a014f

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->e:Landroid/view/View;

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0a0150

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->f:Landroid/view/View;

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0a0152

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->g:Landroid/view/View;

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0a0153

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->h:Landroid/view/View;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->e:Landroid/view/View;

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->f:Landroid/view/View;

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->g:Landroid/view/View;

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->h:Landroid/view/View;

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->b()V

    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 1

    invoke-super {p0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;->onClick(Landroid/view/View;)V

    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    sparse-switch v0, :sswitch_data_0

    :goto_0
    return-void

    :sswitch_0
    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->finish()V

    goto :goto_0

    :sswitch_1
    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->a()V

    goto :goto_0

    :sswitch_2
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->a(I)V

    goto :goto_0

    :sswitch_3
    const/16 v0, 0x10

    invoke-direct {p0, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->a(I)V

    goto :goto_0

    :sswitch_4
    const/16 v0, 0x100

    invoke-direct {p0, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->a(I)V

    goto :goto_0

    :sswitch_5
    const/16 v0, 0x1000

    invoke-direct {p0, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->a(I)V

    goto :goto_0

    :sswitch_data_0
    .sparse-switch
        0x7f0a0034 -> :sswitch_0
        0x7f0a00aa -> :sswitch_1
        0x7f0a014f -> :sswitch_2
        0x7f0a0150 -> :sswitch_3
        0x7f0a0152 -> :sswitch_4
        0x7f0a0153 -> :sswitch_5
    .end sparse-switch
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1

    invoke-super {p0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;->onCreate(Landroid/os/Bundle;)V

    invoke-static {}, Lde/greenrobot/event/EventBus;->getDefault()Lde/greenrobot/event/EventBus;

    move-result-object v0

    invoke-virtual {v0, p0}, Lde/greenrobot/event/EventBus;->register(Ljava/lang/Object;)V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-direct {p0, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->a(Landroid/content/Context;)I

    move-result v0

    sput v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->sMode:I

    return-void
.end method

.method public onDestroy()V
    .locals 1

    invoke-static {}, Lde/greenrobot/event/EventBus;->getDefault()Lde/greenrobot/event/EventBus;

    move-result-object v0

    invoke-virtual {v0, p0}, Lde/greenrobot/event/EventBus;->unregister(Ljava/lang/Object;)V

    invoke-super {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/TabsFragment;->onDestroy()V

    return-void
.end method

.method public onEvent(Lcn/com/smartdevices/bracelet/eventbus/EventUpdateTitle;)V
    .locals 2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->d:Landroid/widget/TextView;

    iget-object v1, p1, Lcn/com/smartdevices/bracelet/eventbus/EventUpdateTitle;->title:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    return-void
.end method
