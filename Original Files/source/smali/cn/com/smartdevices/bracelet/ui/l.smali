.class Lcn/com/smartdevices/bracelet/ui/l;
.super Lcn/com/smartdevices/bracelet/BleTask/BleCallBack;


# instance fields
.field final synthetic b:Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/ui/l;->b:Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/BleTask/BleCallBack;-><init>()V

    return-void
.end method


# virtual methods
.method public onFailed(Ljava/lang/Object;)V
    .locals 2

    invoke-super {p0, p1}, Lcn/com/smartdevices/bracelet/BleTask/BleCallBack;->onFailed(Ljava/lang/Object;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/l;->b:Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->onTogglePairResult(Lcom/xiaomi/hm/bleservice/profile/IMiLiProfile$DeviceInfo;)V

    return-void
.end method

.method public onFinish(Ljava/lang/Object;)V
    .locals 1

    invoke-super {p0, p1}, Lcn/com/smartdevices/bracelet/BleTask/BleCallBack;->onFinish(Ljava/lang/Object;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/l;->b:Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;

    check-cast p1, Lcom/xiaomi/hm/bleservice/profile/IMiLiProfile$DeviceInfo;

    invoke-virtual {v0, p1}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->onTogglePairResult(Lcom/xiaomi/hm/bleservice/profile/IMiLiProfile$DeviceInfo;)V

    return-void
.end method

.method public onProgress(I)V
    .locals 1

    invoke-super {p0, p1}, Lcn/com/smartdevices/bracelet/BleTask/BleCallBack;->onProgress(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/l;->b:Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;

    invoke-virtual {v0, p1}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->onTogglePairProgress(I)V

    return-void
.end method
