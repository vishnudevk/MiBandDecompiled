// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.auth;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.sina.weibo.sdk.utils.NetworkHelper;
import com.sina.weibo.sdk.utils.ResourceManager;
import com.sina.weibo.sdk.utils.Utility;

// Referenced classes of package com.sina.weibo.sdk.auth:
//            WeiboAuthListener, WeiboAuth

public class WeiboDialog extends Dialog
{

    private static final String TAG = "WeiboDialog";
    private static final int WEBVIEW_CONTAINER_MARGIN_TOP = 25;
    private static final int WEBVIEW_MARGIN = 10;
    private static int theme = 0x1030010;
    private String mAuthUrl;
    private Context mContext;
    private boolean mIsDetached;
    private WeiboAuthListener mListener;
    private ProgressDialog mLoadingDlg;
    private RelativeLayout mRootContainer;
    private WebView mWebView;
    private RelativeLayout mWebViewContainer;
    private WeiboAuth mWeibo;

    public WeiboDialog(Context context, String s, WeiboAuthListener weiboauthlistener, WeiboAuth weiboauth)
    {
        super(context, theme);
        mIsDetached = false;
        mAuthUrl = s;
        mListener = weiboauthlistener;
        mContext = context;
        mWeibo = weiboauth;
    }

    private void handleRedirectUrl(String s)
    {
        Bundle bundle = Utility.parseUrl(s);
        String s1 = bundle.getString("error");
        String s2 = bundle.getString("error_code");
        String s3 = bundle.getString("error_description");
        if (s1 == null && s2 == null)
        {
            mListener.onComplete(bundle);
            return;
        } else
        {
            mListener.onWeiboException(new WeiboAuthException(s2, s1, s3));
            return;
        }
    }

    private void initCloseButton()
    {
        ImageView imageview = new ImageView(mContext);
        Drawable drawable = ResourceManager.getDrawable(mContext, 2);
        imageview.setImageDrawable(drawable);
        imageview.setOnClickListener(new _cls1());
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        android.widget.RelativeLayout.LayoutParams layoutparams1 = (android.widget.RelativeLayout.LayoutParams)mWebViewContainer.getLayoutParams();
        layoutparams.leftMargin = 5 + (layoutparams1.leftMargin - drawable.getIntrinsicWidth() / 2);
        layoutparams.topMargin = 5 + (layoutparams1.topMargin - drawable.getIntrinsicHeight() / 2);
        mRootContainer.addView(imageview, layoutparams);
    }

    private void initLoadingDlg()
    {
        mLoadingDlg = new ProgressDialog(getContext());
        mLoadingDlg.requestWindowFeature(1);
        mLoadingDlg.setMessage(ResourceManager.getString(mContext, 1));
    }

    private void initWebView()
    {
        mWebViewContainer = new RelativeLayout(getContext());
        mWebView = new WebView(getContext());
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setSavePassword(false);
        mWebView.setWebViewClient(new WeiboWebViewClient(null));
        mWebView.requestFocus();
        mWebView.setScrollBarStyle(0);
        mWebView.setVisibility(4);
        NetworkHelper.clearCookies(mContext, mAuthUrl);
        mWebView.loadUrl(mAuthUrl);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        android.widget.RelativeLayout.LayoutParams layoutparams1 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        DisplayMetrics displaymetrics = getContext().getResources().getDisplayMetrics();
        int i = (int)(10F * displaymetrics.density);
        layoutparams1.setMargins(i, i, i, i);
        Drawable drawable = ResourceManager.getNinePatchDrawable(mContext, 1);
        mWebViewContainer.setBackgroundDrawable(drawable);
        mWebViewContainer.addView(mWebView, layoutparams1);
        mWebViewContainer.setGravity(17);
        int j = 1 + ResourceManager.getDrawable(mContext, 2).getIntrinsicWidth() / 2;
        layoutparams.setMargins(j, (int)(25F * displaymetrics.density), j, j);
        mRootContainer.addView(mWebViewContainer, layoutparams);
    }

    private void initWindow()
    {
        requestWindowFeature(1);
        getWindow().setFeatureDrawableAlpha(0, 0);
        getWindow().setSoftInputMode(16);
        mRootContainer = new RelativeLayout(getContext());
        mRootContainer.setBackgroundColor(0);
        addContentView(mRootContainer, new android.view.ViewGroup.LayoutParams(-1, -1));
    }

    public void dismiss()
    {
        if (!mIsDetached)
        {
            if (mLoadingDlg != null && mLoadingDlg.isShowing())
            {
                mLoadingDlg.dismiss();
            }
            super.dismiss();
        }
    }

    public void onAttachedToWindow()
    {
        mIsDetached = false;
        super.onAttachedToWindow();
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        if (mListener != null)
        {
            mListener.onCancel();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        initWindow();
        initLoadingDlg();
        initWebView();
        initCloseButton();
    }

    public void onDetachedFromWindow()
    {
        if (mWebView != null)
        {
            mWebViewContainer.removeView(mWebView);
            mWebView.stopLoading();
            mWebView.removeAllViews();
            mWebView.destroy();
            mWebView = null;
        }
        mIsDetached = true;
        super.onDetachedFromWindow();
    }








    private class _cls1
        implements android.view.View.OnClickListener
    {

        final WeiboDialog this$0;

        public void onClick(View view)
        {
            dismiss();
            if (mListener != null)
            {
                mListener.onCancel();
            }
        }

        _cls1()
        {
            this$0 = WeiboDialog.this;
            super();
        }
    }


    private class WeiboWebViewClient extends WebViewClient
    {

        private boolean isCallBacked;
        final WeiboDialog this$0;

        public void onPageFinished(WebView webview, String s)
        {
            LogUtil.d("WeiboDialog", (new StringBuilder("onPageFinished URL: ")).append(s).toString());
            super.onPageFinished(webview, s);
            if (!mIsDetached && mLoadingDlg != null)
            {
                mLoadingDlg.dismiss();
            }
            mWebView.setVisibility(0);
        }

        public void onPageStarted(WebView webview, String s, Bitmap bitmap)
        {
            LogUtil.d("WeiboDialog", (new StringBuilder("onPageStarted URL: ")).append(s).toString());
            if (s.startsWith(mWeibo.getAuthInfo().getRedirectUrl()) && !isCallBacked)
            {
                isCallBacked = true;
                handleRedirectUrl(s);
                webview.stopLoading();
                dismiss();
            } else
            {
                super.onPageStarted(webview, s, bitmap);
                if (!mIsDetached && mLoadingDlg != null && !mLoadingDlg.isShowing())
                {
                    mLoadingDlg.show();
                    return;
                }
            }
        }

        public void onReceivedError(WebView webview, int i, String s, String s1)
        {
            LogUtil.d("WeiboDialog", (new StringBuilder("onReceivedError: errorCode = ")).append(i).append(", description = ").append(s).append(", failingUrl = ").append(s1).toString());
            super.onReceivedError(webview, i, s, s1);
            if (mListener != null)
            {
                mListener.onWeiboException(new WeiboDialogException(s, i, s1));
            }
            dismiss();
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            LogUtil.i("WeiboDialog", (new StringBuilder("load URL: ")).append(s).toString());
            if (s.startsWith("sms:"))
            {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.putExtra("address", s.replace("sms:", ""));
                intent.setType("vnd.android-dir/mms-sms");
                getContext().startActivity(intent);
                return true;
            } else
            {
                return super.shouldOverrideUrlLoading(webview, s);
            }
        }

        private WeiboWebViewClient()
        {
            this$0 = WeiboDialog.this;
            super();
            isCallBacked = false;
        }

        WeiboWebViewClient(WeiboWebViewClient weibowebviewclient)
        {
            this();
        }
    }

}
