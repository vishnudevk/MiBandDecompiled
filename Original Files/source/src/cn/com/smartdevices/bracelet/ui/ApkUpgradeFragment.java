// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.TextView;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.view.CustomToast;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            DimPanelFragment

public class ApkUpgradeFragment extends DimPanelFragment
{

    public static final String DOWNLOAD_ID_REF = "DOWNLOAD_ID_REF";
    public static final String UPDATE_DATE_REF = "UPDATE_DATE_REF";
    private static final String a = "ApkUpgradeFragment";
    private String b;
    private String c;
    private String d;

    public ApkUpgradeFragment()
    {
    }

    protected int inflateLayout()
    {
        return 0x7f030017;
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        super.onCancel(dialoginterface);
        Debug.i("ApkUpgradeFragment", "onCancel();");
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        View view = super.onCreateView(layoutinflater, viewgroup, bundle);
        Bundle bundle1 = getArguments();
        b = bundle1.getString("VERSION_NAME");
        c = bundle1.getString("APK_PATH");
        d = bundle1.getString("CHANGE_LOG");
        ((TextView)view.findViewById(0x7f0a0094)).setText(d);
        return view;
    }

    protected void onEmptyAreaClicked()
    {
        super.onEmptyAreaClicked();
        Debug.i("ApkUpgradeFragment", "onEmptyAreaClicked()");
    }

    protected void onLeftButtonClicked()
    {
        dismiss();
    }

    protected void onRightButtomClicked()
    {
        CustomToast.makeText(getActivity(), 0x7f0d0183, 1).show();
        android.app.DownloadManager.Request request = new android.app.DownloadManager.Request(Uri.parse(c));
        request.setAllowedNetworkTypes(3);
        request.setAllowedOverRoaming(false);
        request.setMimeType(MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(c)));
        request.setShowRunningNotification(true);
        request.setVisibleInDownloadsUi(true);
        try
        {
            request.setDestinationInExternalFilesDir(getActivity(), Environment.DIRECTORY_DOWNLOADS, "apk_upgrade.apk");
        }
        catch (IllegalStateException illegalstateexception)
        {
            illegalstateexception.printStackTrace();
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "apk_upgrade");
        }
        request.setTitle(getResources().getString(0x7f0d006b));
        Keeper.keepDownloadApkId(((DownloadManager)getActivity().getSystemService("download")).enqueue(request));
        dismiss();
    }
}
