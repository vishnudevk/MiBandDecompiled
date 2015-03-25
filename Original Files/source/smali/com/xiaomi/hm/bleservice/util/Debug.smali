.class public final Lcom/xiaomi/hm/bleservice/util/Debug;
.super Ljava/lang/Object;


# static fields
.field private static a:Z = false

.field private static final b:Z = true

.field private static final c:Z = true

.field private static final d:Z = true

.field private static final e:Z = true

.field private static final f:Z = true

.field private static g:Z = false

.field private static h:Z = false

.field private static i:Z = false

.field private static final j:Z = true

.field private static final k:Z = false

.field private static final l:Ljava/lang/String; = "DEBUG"


# direct methods
.method static constructor <clinit>()V
    .locals 2

    const/4 v1, 0x1

    const/4 v0, 0x0

    sput-boolean v0, Lcom/xiaomi/hm/bleservice/util/Debug;->a:Z

    sput-boolean v1, Lcom/xiaomi/hm/bleservice/util/Debug;->g:Z

    sput-boolean v1, Lcom/xiaomi/hm/bleservice/util/Debug;->h:Z

    sput-boolean v1, Lcom/xiaomi/hm/bleservice/util/Debug;->i:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static ASSERT_NOT_NULL(Ljava/lang/Object;)V
    .locals 4

    sget-boolean v0, Lcom/xiaomi/hm/bleservice/util/Debug;->h:Z

    if-eqz v0, :cond_0

    if-nez p0, :cond_0

    const-string v0, "DEBUG"

    const-string v1, ">>> `NOT NULL` ASSERTION FAILED <<<"

    const/4 v2, 0x0

    const/16 v3, 0x65

    invoke-static {v0, v1, v2, v3}, Lcom/xiaomi/hm/bleservice/util/Debug;->a(Ljava/lang/String;Ljava/lang/String;IC)V

    :cond_0
    return-void
.end method

.method public static ASSERT_NULL(Ljava/lang/Object;)V
    .locals 4

    sget-boolean v0, Lcom/xiaomi/hm/bleservice/util/Debug;->h:Z

    if-eqz v0, :cond_0

    if-eqz p0, :cond_0

    const-string v0, "DEBUG"

    const-string v1, ">>> `NULL` ASSERTION FAILED <<<"

    const/4 v2, 0x0

    const/16 v3, 0x65

    invoke-static {v0, v1, v2, v3}, Lcom/xiaomi/hm/bleservice/util/Debug;->a(Ljava/lang/String;Ljava/lang/String;IC)V

    :cond_0
    return-void
.end method

.method public static ASSERT_RUN_ON_THREAD(Ljava/lang/Thread;)V
    .locals 4

    sget-boolean v0, Lcom/xiaomi/hm/bleservice/util/Debug;->h:Z

    if-eqz v0, :cond_0

    if-eqz p0, :cond_0

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Thread;->getId()J

    move-result-wide v0

    invoke-virtual {p0}, Ljava/lang/Thread;->getId()J

    move-result-wide v2

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    const-string v0, "DEBUG"

    const-string v1, ">>> `RUN ON THREAD` ASSERTION FAILED <<<"

    const/4 v2, 0x0

    const/16 v3, 0x65

    invoke-static {v0, v1, v2, v3}, Lcom/xiaomi/hm/bleservice/util/Debug;->a(Ljava/lang/String;Ljava/lang/String;IC)V

    :cond_0
    return-void
.end method

.method public static ASSERT_TRUE(Z)V
    .locals 4

    sget-boolean v0, Lcom/xiaomi/hm/bleservice/util/Debug;->h:Z

    if-eqz v0, :cond_0

    if-nez p0, :cond_0

    const-string v0, "DEBUG"

    const-string v1, ">>> `TRUE` ASSERTION FAILED <<<"

    const/4 v2, 0x0

    const/16 v3, 0x65

    invoke-static {v0, v1, v2, v3}, Lcom/xiaomi/hm/bleservice/util/Debug;->a(Ljava/lang/String;Ljava/lang/String;IC)V

    :cond_0
    return-void
.end method

.method public static DEBUG(Ljava/lang/String;)V
    .locals 3

    const-string v0, "DEBUG"

    const/4 v1, 0x0

    const/16 v2, 0x64

    invoke-static {v0, p0, v1, v2}, Lcom/xiaomi/hm/bleservice/util/Debug;->a(Ljava/lang/String;Ljava/lang/String;IC)V

    return-void
.end method

.method public static DEBUG_LOCK(Ljava/lang/String;)V
    .locals 4

    sget-boolean v0, Lcom/xiaomi/hm/bleservice/util/Debug;->i:Z

    if-eqz v0, :cond_0

    const-string v0, "DEBUG"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "LOCK#"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    const/16 v3, 0x76

    invoke-static {v0, v1, v2, v3}, Lcom/xiaomi/hm/bleservice/util/Debug;->a(Ljava/lang/String;Ljava/lang/String;IC)V

    :cond_0
    return-void
.end method

.method public static ENABLE(ZZZ)V
    .locals 2

    const/4 v0, 0x1

    sput-boolean v0, Lcom/xiaomi/hm/bleservice/util/Debug;->a:Z

    sput-boolean p0, Lcom/xiaomi/hm/bleservice/util/Debug;->g:Z

    sput-boolean p1, Lcom/xiaomi/hm/bleservice/util/Debug;->h:Z

    sput-boolean p2, Lcom/xiaomi/hm/bleservice/util/Debug;->i:Z

    invoke-static {}, Lcom/xiaomi/hm/bleservice/util/Debug;->a()V

    const-string v0, "         ENABLE_VERBOSE: TRUE"

    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/util/Debug;->INFO(Ljava/lang/String;)V

    const-string v0, "           ENABLE_DEBUG: TRUE"

    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/util/Debug;->INFO(Ljava/lang/String;)V

    const-string v0, "            ENABLE_INFO: TRUE"

    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/util/Debug;->INFO(Ljava/lang/String;)V

    const-string v0, "            ENABLE_WARN: TRUE"

    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/util/Debug;->INFO(Ljava/lang/String;)V

    const-string v0, "           ENABLE_ERROR: TRUE"

    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/util/Debug;->INFO(Ljava/lang/String;)V

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "           ENABLE_TRACE: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-boolean v0, Lcom/xiaomi/hm/bleservice/util/Debug;->g:Z

    if-eqz v0, :cond_0

    const-string v0, "TRUE"

    :goto_0
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/util/Debug;->INFO(Ljava/lang/String;)V

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "          ENABLE_ASSERT: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-boolean v0, Lcom/xiaomi/hm/bleservice/util/Debug;->h:Z

    if-eqz v0, :cond_1

    const-string v0, "TRUE"

    :goto_1
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/util/Debug;->INFO(Ljava/lang/String;)V

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "      ENABLE_DEBUG_LOCK: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-boolean v0, Lcom/xiaomi/hm/bleservice/util/Debug;->i:Z

    if-eqz v0, :cond_2

    const-string v0, "TRUE"

    :goto_2
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/util/Debug;->INFO(Ljava/lang/String;)V

    const-string v0, "        ENABLE_LOG_META: TRUE"

    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/util/Debug;->INFO(Ljava/lang/String;)V

    const-string v0, "  ENABLE_LOG_TRACE_INFO: FALSE"

    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/util/Debug;->INFO(Ljava/lang/String;)V

    return-void

    :cond_0
    const-string v0, "FALSE"

    goto :goto_0

    :cond_1
    const-string v0, "FALSE"

    goto :goto_1

    :cond_2
    const-string v0, "FALSE"

    goto :goto_2
.end method

.method public static ERROR(Ljava/lang/String;)V
    .locals 3

    const-string v0, "DEBUG"

    const/4 v1, 0x0

    const/16 v2, 0x65

    invoke-static {v0, p0, v1, v2}, Lcom/xiaomi/hm/bleservice/util/Debug;->a(Ljava/lang/String;Ljava/lang/String;IC)V

    return-void
.end method

.method public static INFO(Ljava/lang/String;)V
    .locals 3

    const-string v0, "DEBUG"

    const/4 v1, 0x0

    const/16 v2, 0x69

    invoke-static {v0, p0, v1, v2}, Lcom/xiaomi/hm/bleservice/util/Debug;->a(Ljava/lang/String;Ljava/lang/String;IC)V

    return-void
.end method

.method public static TRACE()V
    .locals 4

    sget-boolean v0, Lcom/xiaomi/hm/bleservice/util/Debug;->g:Z

    if-eqz v0, :cond_0

    const-string v0, "DEBUG"

    const-string v1, "<<<<===="

    const/4 v2, 0x0

    const/16 v3, 0x76

    invoke-static {v0, v1, v2, v3}, Lcom/xiaomi/hm/bleservice/util/Debug;->a(Ljava/lang/String;Ljava/lang/String;IC)V

    :cond_0
    return-void
.end method

.method public static VERBOSE(Ljava/lang/String;)V
    .locals 3

    const-string v0, "DEBUG"

    const/4 v1, 0x0

    const/16 v2, 0x76

    invoke-static {v0, p0, v1, v2}, Lcom/xiaomi/hm/bleservice/util/Debug;->a(Ljava/lang/String;Ljava/lang/String;IC)V

    return-void
.end method

.method public static WARN(Ljava/lang/String;)V
    .locals 3

    const-string v0, "DEBUG"

    const/4 v1, 0x0

    const/16 v2, 0x77

    invoke-static {v0, p0, v1, v2}, Lcom/xiaomi/hm/bleservice/util/Debug;->a(Ljava/lang/String;Ljava/lang/String;IC)V

    return-void
.end method

.method private static a()V
    .locals 1

    const-string v0, "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM"

    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/util/Debug;->INFO(Ljava/lang/String;)V

    const-string v0, "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM"

    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/util/Debug;->INFO(Ljava/lang/String;)V

    const-string v0, "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM"

    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/util/Debug;->INFO(Ljava/lang/String;)V

    const-string v0, "MM.:  .:\'   `:::  .:`MMMMMMMMMMM|`MMM\'|MMMMMMMMMMM\':  .:\'   `:::  .:\'.MM"

    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/util/Debug;->INFO(Ljava/lang/String;)V

    const-string v0, "MMMM.     :          `MMMMMMMMMM  :*\'  MMMMMMMMMM\'        :        .MMMM"

    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/util/Debug;->INFO(Ljava/lang/String;)V

    const-string v0, "MMMMM.    ::    .     `MMMMMMMM\'  ::   `MMMMMMMM\'   .     ::   .  .MMMMM"

    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/util/Debug;->INFO(Ljava/lang/String;)V

    const-string v0, "MMMMMM. :   :: ::\'  :   :: ::\'  :   :: ::\'      :: ::\'  :   :: ::.MMMMMM"

    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/util/Debug;->INFO(Ljava/lang/String;)V

    const-string v0, "MMMMMMM    ;::         ;::         ;::         ;::         ;::   MMMMMMM"

    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/util/Debug;->INFO(Ljava/lang/String;)V

    const-string v0, "MMMMMMM .:\'   `:::  .:\'   `:::  .:\'   `:::  .:\'   `:::  .:\'   `::MMMMMMM"

    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/util/Debug;->INFO(Ljava/lang/String;)V

    const-string v0, "MMMMMM\'     :           :           :           :           :    `MMMMMM"

    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/util/Debug;->INFO(Ljava/lang/String;)V

    const-string v0, "MMMMM\'______::____      ::    .     ::    .     ::     ___._::____`MMMMM"

    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/util/Debug;->INFO(Ljava/lang/String;)V

    const-string v0, "MMMMMMMMMMMMMMMMMMM`---._ :: ::\'  :   :: ::\'  _.--::MMMMMMMMMMMMMMMMMMMM"

    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/util/Debug;->INFO(Ljava/lang/String;)V

    const-string v0, "MMMMMMMMMMMMMMMMMMMMMMMMMM::.         ::  .--MMMMMMMMMMMMMMMMMMMMMMMMMMM"

    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/util/Debug;->INFO(Ljava/lang/String;)V

    const-string v0, "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMM-.     ;::-MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM"

    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/util/Debug;->INFO(Ljava/lang/String;)V

    const-string v0, "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM. .:\' .MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM"

    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/util/Debug;->INFO(Ljava/lang/String;)V

    const-string v0, "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM.   .MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM"

    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/util/Debug;->INFO(Ljava/lang/String;)V

    const-string v0, "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\\ /MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM"

    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/util/Debug;->INFO(Ljava/lang/String;)V

    const-string v0, "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMVMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM"

    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/util/Debug;->INFO(Ljava/lang/String;)V

    const-string v0, "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM .:ZylvanaS:. MM"

    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/util/Debug;->INFO(Ljava/lang/String;)V

    const-string v0, "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM"

    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/util/Debug;->INFO(Ljava/lang/String;)V

    return-void
.end method

.method private static a(Ljava/lang/String;Ljava/lang/String;IC)V
    .locals 6

    sget-boolean v0, Lcom/xiaomi/hm/bleservice/util/Debug;->a:Z

    if-nez v0, :cond_0

    :goto_0
    return-void

    :cond_0
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Thread;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Thread;->getStackTrace()[Ljava/lang/StackTraceElement;

    move-result-object v1

    add-int/lit8 v2, p2, 0x4

    aget-object v1, v1, v2

    invoke-virtual {v1}, Ljava/lang/StackTraceElement;->getClassName()Ljava/lang/String;

    move-result-object v2

    const/16 v3, 0x2e

    invoke-virtual {v2, v3}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v3

    add-int/lit8 v3, v3, 0x1

    invoke-virtual {v2, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1}, Ljava/lang/StackTraceElement;->getMethodName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1}, Ljava/lang/StackTraceElement;->getLineNumber()I

    move-result v1

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "["

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, "]"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, "<"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ":"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ":"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "> "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, ""

    sparse-switch p3, :sswitch_data_0

    goto :goto_0

    :sswitch_0
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    :sswitch_1
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    :sswitch_2
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    :sswitch_3
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    :sswitch_4
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    :sswitch_data_0
    .sparse-switch
        0x64 -> :sswitch_0
        0x65 -> :sswitch_4
        0x69 -> :sswitch_2
        0x76 -> :sswitch_1
        0x77 -> :sswitch_3
    .end sparse-switch
.end method

.method public static enable(Z)V
    .locals 0

    sput-boolean p0, Lcom/xiaomi/hm/bleservice/util/Debug;->a:Z

    sput-boolean p0, Lcom/xiaomi/hm/bleservice/util/Debug;->g:Z

    sput-boolean p0, Lcom/xiaomi/hm/bleservice/util/Debug;->h:Z

    sput-boolean p0, Lcom/xiaomi/hm/bleservice/util/Debug;->i:Z

    return-void
.end method
