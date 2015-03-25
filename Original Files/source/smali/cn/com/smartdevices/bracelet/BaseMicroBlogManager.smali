.class public Lcn/com/smartdevices/bracelet/BaseMicroBlogManager;
.super Ljava/lang/Object;


# static fields
.field public static final PAGE_BLOG_COUNT:I = 0xa


# instance fields
.field private a:Lcn/com/smartdevices/bracelet/model/PersonInfo;

.field private b:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcn/com/smartdevices/bracelet/model/MicroBlogItem;",
            ">;"
        }
    .end annotation
.end field

.field private c:I


# direct methods
.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/BaseMicroBlogManager;->b:Ljava/util/ArrayList;

    const/4 v0, 0x0

    iput v0, p0, Lcn/com/smartdevices/bracelet/BaseMicroBlogManager;->c:I

    return-void
.end method


# virtual methods
.method public addBlog(Lcn/com/smartdevices/bracelet/model/MicroBlogItem;)V
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/BaseMicroBlogManager;->b:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method public addBlogs(Ljava/util/ArrayList;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcn/com/smartdevices/bracelet/model/MicroBlogItem;",
            ">;)V"
        }
    .end annotation

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/BaseMicroBlogManager;->b:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    return-void
.end method

.method public clearBlogs()V
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/BaseMicroBlogManager;->b:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    const/4 v0, 0x0

    iput v0, p0, Lcn/com/smartdevices/bracelet/BaseMicroBlogManager;->c:I

    return-void
.end method

.method public getBlog(I)Lcn/com/smartdevices/bracelet/model/MicroBlogItem;
    .locals 1

    if-ltz p1, :cond_0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/BaseMicroBlogManager;->b:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    if-le p1, v0, :cond_1

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_1
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/BaseMicroBlogManager;->b:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/model/MicroBlogItem;

    goto :goto_0
.end method

.method public getBlogs()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcn/com/smartdevices/bracelet/model/MicroBlogItem;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/BaseMicroBlogManager;->b:Ljava/util/ArrayList;

    return-object v0
.end method

.method public getCurOwner()Lcn/com/smartdevices/bracelet/model/PersonInfo;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/BaseMicroBlogManager;->a:Lcn/com/smartdevices/bracelet/model/PersonInfo;

    return-object v0
.end method

.method public pageCount()I
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/BaseMicroBlogManager;->c:I

    return v0
.end method

.method public setCurOwner(Lcn/com/smartdevices/bracelet/model/PersonInfo;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/BaseMicroBlogManager;->a:Lcn/com/smartdevices/bracelet/model/PersonInfo;

    return-void
.end method

.method public setCurOwner(Ljava/util/ArrayList;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcn/com/smartdevices/bracelet/model/MicroBlogItem;",
            ">;)V"
        }
    .end annotation

    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_0

    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/model/MicroBlogItem;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/model/MicroBlogItem;->info:Lcn/com/smartdevices/bracelet/model/PersonInfo;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/BaseMicroBlogManager;->a:Lcn/com/smartdevices/bracelet/model/PersonInfo;

    :cond_0
    return-void
.end method

.method public setPageCount(I)V
    .locals 0

    iput p1, p0, Lcn/com/smartdevices/bracelet/BaseMicroBlogManager;->c:I

    return-void
.end method
