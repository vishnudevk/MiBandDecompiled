// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.api.share;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.exception.WeiboShareException;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.MD5;
import com.sina.weibo.sdk.utils.Utility;

// Referenced classes of package com.sina.weibo.sdk.api.share:
//            IWeiboShareAPI, ApiUtils, WeiboDownloader, ProvideMessageForWeiboRequest, 
//            SendMessageToWeiboResponse, VersionCheckHandler, BaseRequest, BaseResponse, 
//            IWeiboDownloadListener

public class WeiboShareAPIImpl
    implements IWeiboShareAPI
{

    private static final String TAG = "WeiboApiImpl";
    private String mAppKey;
    private Context mContext;
    private Dialog mDownloadConfirmDialog;
    private IWeiboDownloadListener mDownloadListener;
    private boolean mNeedDownloadWeibo;
    private ApiUtils.WeiboInfo mWeiboInfo;

    public WeiboShareAPIImpl(Context context, String s, boolean flag)
    {
        mWeiboInfo = null;
        mNeedDownloadWeibo = true;
        mDownloadConfirmDialog = null;
        mContext = context;
        mAppKey = s;
        mNeedDownloadWeibo = flag;
        mWeiboInfo = ApiUtils.queryWeiboInfo(mContext);
        if (mWeiboInfo != null)
        {
            LogUtil.d("WeiboApiImpl", mWeiboInfo.toString());
            return;
        } else
        {
            LogUtil.d("WeiboApiImpl", "WeiboInfo: is null");
            return;
        }
    }

    private void sendBroadcast(Context context, String s, String s1, String s2, Bundle bundle)
    {
        Intent intent = new Intent(s);
        String s3 = context.getPackageName();
        intent.putExtra("_weibo_sdkVersion", 22);
        intent.putExtra("_weibo_appPackage", s3);
        intent.putExtra("_weibo_appKey", s1);
        intent.putExtra("_weibo_flag", 0x20130329);
        intent.putExtra("_weibo_sign", MD5.hexdigest(Utility.getSign(context, s3)));
        if (!TextUtils.isEmpty(s2))
        {
            intent.setPackage(s2);
        }
        if (bundle != null)
        {
            intent.putExtras(bundle);
        }
        LogUtil.d("WeiboApiImpl", (new StringBuilder("intent=")).append(intent).append(", extra=").append(intent.getExtras()).toString());
        context.sendBroadcast(intent, "com.sina.weibo.permission.WEIBO_SDK_PERMISSION");
    }

    private boolean shareWithWeibo(Activity activity, String s, String s1, String s2, Bundle bundle)
    {
        if (activity == null || TextUtils.isEmpty(s) || TextUtils.isEmpty(s1) || TextUtils.isEmpty(s2))
        {
            LogUtil.e("ActivityHandler", "send fail, invalid arguments");
            return false;
        }
        Intent intent = new Intent();
        intent.setPackage(s1);
        intent.setAction(s);
        String s3 = activity.getPackageName();
        intent.putExtra("_weibo_sdkVersion", 22);
        intent.putExtra("_weibo_appPackage", s3);
        intent.putExtra("_weibo_appKey", s2);
        intent.putExtra("_weibo_flag", 0x20130329);
        intent.putExtra("_weibo_sign", MD5.hexdigest(Utility.getSign(activity, s3)));
        if (bundle != null)
        {
            intent.putExtras(bundle);
        }
        try
        {
            LogUtil.d("WeiboApiImpl", (new StringBuilder("intent=")).append(intent).append(", extra=").append(intent.getExtras()).toString());
            activity.startActivityForResult(intent, 765);
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            LogUtil.e("WeiboApiImpl", "Failed, target ActivityNotFound");
            return false;
        }
        return true;
    }

    public boolean checkEnvironment(boolean flag)
    {
        if (mWeiboInfo != null)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        if (mDownloadConfirmDialog != null) goto _L4; else goto _L3
_L3:
        mDownloadConfirmDialog = WeiboDownloader.createDownloadConfirmDialog(mContext, mDownloadListener);
        mDownloadConfirmDialog.show();
_L5:
        return false;
_L4:
        if (!mDownloadConfirmDialog.isShowing())
        {
            mDownloadConfirmDialog.show();
        }
        if (true) goto _L5; else goto _L2
_L2:
        throw new WeiboShareException("Weibo is NOT installed!");
        if (!ApiUtils.isWeiboAppSupportAPI(mWeiboInfo.supportApi))
        {
            throw new WeiboShareException("Weibo do NOT support Share API!");
        }
        if (!ApiUtils.validateWeiboSign(mContext, mWeiboInfo.packageName))
        {
            throw new WeiboShareException("Weibo signature is incorrect!");
        } else
        {
            return true;
        }
    }

    public int getWeiboAppSupportAPI()
    {
        if (mWeiboInfo == null)
        {
            return -1;
        } else
        {
            return mWeiboInfo.supportApi;
        }
    }

    public boolean handleWeiboRequest(Intent intent, IWeiboHandler.Request request)
    {
        if (intent == null || request == null)
        {
            return false;
        }
        String s = intent.getStringExtra("_weibo_appPackage");
        String s1 = intent.getStringExtra("_weibo_transaction");
        if (s == null)
        {
            LogUtil.e("WeiboApiImpl", "requestListener() faild appPackage validateSign faild");
            request.onRequest(null);
            return false;
        }
        if (s1 == null)
        {
            LogUtil.e("WeiboApiImpl", "requestListener() faild intent TRAN is null");
            request.onRequest(null);
            return false;
        }
        if (!ApiUtils.validateWeiboSign(mContext, s))
        {
            LogUtil.e("WeiboApiImpl", "requestListener() faild appPackage validateSign faild");
            request.onRequest(null);
            return false;
        } else
        {
            request.onRequest(new ProvideMessageForWeiboRequest(intent.getExtras()));
            return true;
        }
    }

    public boolean handleWeiboResponse(Intent intent, IWeiboHandler.Response response)
    {
        String s = intent.getStringExtra("_weibo_appPackage");
        if (s == null)
        {
            LogUtil.e("WeiboApiImpl", "responseListener() faild appPackage is null");
            return false;
        }
        if (!(response instanceof Activity))
        {
            LogUtil.e("WeiboApiImpl", "responseListener() faild handler is not Activity");
            return false;
        }
        String s1 = ((Activity)response).getCallingPackage();
        LogUtil.d("WeiboApiImpl", (new StringBuilder("responseListener() callPkg : ")).append(s1).toString());
        if (intent.getStringExtra("_weibo_transaction") == null)
        {
            LogUtil.e("WeiboApiImpl", "responseListener() faild intent TRAN is null");
            return false;
        }
        if (!ApiUtils.validateWeiboSign(mContext, s))
        {
            LogUtil.e("WeiboApiImpl", "responseListener() faild appPackage validateSign faild");
            return false;
        } else
        {
            response.onResponse(new SendMessageToWeiboResponse(intent.getExtras()));
            return true;
        }
    }

    public boolean isWeiboAppInstalled()
    {
        return mWeiboInfo != null;
    }

    public boolean isWeiboAppSupportAPI()
    {
        return ApiUtils.isWeiboAppSupportAPI(getWeiboAppSupportAPI());
    }

    public boolean launchWeibo()
    {
        if (mWeiboInfo == null)
        {
            LogUtil.e("WeiboApiImpl", "startWeibo() faild winfo is null");
            return false;
        }
        if (!TextUtils.isEmpty(mWeiboInfo.packageName))
        {
            break MISSING_BLOCK_LABEL_52;
        }
        LogUtil.e("WeiboApiImpl", "startWeibo() faild packageName is null");
        Exception exception;
        return false;
        try
        {
            mContext.startActivity(mContext.getPackageManager().getLaunchIntentForPackage(mWeiboInfo.packageName));
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            LogUtil.e("WeiboApiImpl", exception.getMessage());
            return false;
        }
        return true;
    }

    public boolean registerApp()
    {
        if (!checkEnvironment(mNeedDownloadWeibo))
        {
            return false;
        } else
        {
            sendBroadcast(mContext, "com.sina.weibo.sdk.Intent.ACTION_WEIBO_REGISTER", mAppKey, null, null);
            return true;
        }
    }

    public void registerWeiboDownloadListener(IWeiboDownloadListener iweibodownloadlistener)
    {
        mDownloadListener = iweibodownloadlistener;
    }

    public boolean sendRequest(BaseRequest baserequest)
    {
        if (baserequest == null)
        {
            LogUtil.e("WeiboApiImpl", "sendRequest faild act == null or request == null");
        } else
        if (checkEnvironment(mNeedDownloadWeibo))
        {
            VersionCheckHandler versioncheckhandler = new VersionCheckHandler(mWeiboInfo.packageName);
            if (!baserequest.check(mContext, versioncheckhandler))
            {
                LogUtil.e("WeiboApiImpl", "sendRequest faild request check faild");
                return false;
            } else
            {
                Bundle bundle = new Bundle();
                baserequest.toBundle(bundle);
                return shareWithWeibo((Activity)mContext, "com.sina.weibo.sdk.action.ACTION_WEIBO_ACTIVITY", mWeiboInfo.packageName, mAppKey, bundle);
            }
        }
        return false;
    }

    public boolean sendResponse(BaseResponse baseresponse)
    {
        if (baseresponse == null)
        {
            LogUtil.e("WeiboApiImpl", "sendResponse failed response null");
            return false;
        }
        if (!baseresponse.check(mContext, new VersionCheckHandler()))
        {
            LogUtil.e("WeiboApiImpl", "sendResponse checkArgs fail");
            return false;
        } else
        {
            Bundle bundle = new Bundle();
            baseresponse.toBundle(bundle);
            sendBroadcast(mContext, "com.sina.weibo.sdk.Intent.ACTION_WEIBO_RESPONSE", mAppKey, baseresponse.reqPackageName, bundle);
            return true;
        }
    }
}
