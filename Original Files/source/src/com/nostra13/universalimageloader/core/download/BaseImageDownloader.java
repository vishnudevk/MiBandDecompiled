// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.download;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import com.nostra13.universalimageloader.core.assist.ContentLengthInputStream;
import com.nostra13.universalimageloader.utils.IoUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.nostra13.universalimageloader.core.download:
//            ImageDownloader, a

public class BaseImageDownloader
    implements ImageDownloader
{

    protected static final String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%";
    protected static final int BUFFER_SIZE = 32768;
    protected static final String CONTENT_CONTACTS_URI_PREFIX = "content://com.android.contacts/";
    public static final int DEFAULT_HTTP_CONNECT_TIMEOUT = 5000;
    public static final int DEFAULT_HTTP_READ_TIMEOUT = 20000;
    protected static final int MAX_REDIRECT_COUNT = 5;
    private static final String a = "UIL doesn't support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))";
    protected final int connectTimeout;
    protected final Context context;
    protected final int readTimeout;

    public BaseImageDownloader(Context context1)
    {
        context = context1.getApplicationContext();
        connectTimeout = 5000;
        readTimeout = 20000;
    }

    public BaseImageDownloader(Context context1, int i, int j)
    {
        context = context1.getApplicationContext();
        connectTimeout = i;
        readTimeout = j;
    }

    protected HttpURLConnection createConnection(String s, Object obj)
    {
        HttpURLConnection httpurlconnection = (HttpURLConnection)(new URL(Uri.encode(s, "@#&=*+-_.,:!?()/~'%"))).openConnection();
        httpurlconnection.setConnectTimeout(connectTimeout);
        httpurlconnection.setReadTimeout(readTimeout);
        return httpurlconnection;
    }

    public InputStream getStream(String s, Object obj)
    {
        switch (a.a[ImageDownloader.Scheme.ofUri(s).ordinal()])
        {
        default:
            return getStreamFromOtherSource(s, obj);

        case 1: // '\001'
        case 2: // '\002'
            return getStreamFromNetwork(s, obj);

        case 3: // '\003'
            return getStreamFromFile(s, obj);

        case 4: // '\004'
            return getStreamFromContent(s, obj);

        case 5: // '\005'
            return getStreamFromAssets(s, obj);

        case 6: // '\006'
            return getStreamFromDrawable(s, obj);
        }
    }

    protected InputStream getStreamFromAssets(String s, Object obj)
    {
        String s1 = ImageDownloader.Scheme.ASSETS.crop(s);
        return context.getAssets().open(s1);
    }

    protected InputStream getStreamFromContent(String s, Object obj)
    {
        ContentResolver contentresolver = context.getContentResolver();
        Uri uri = Uri.parse(s);
        if (s.startsWith("content://com.android.contacts/"))
        {
            return android.provider.ContactsContract.Contacts.openContactPhotoInputStream(contentresolver, uri);
        } else
        {
            return contentresolver.openInputStream(uri);
        }
    }

    protected InputStream getStreamFromDrawable(String s, Object obj)
    {
        int i = Integer.parseInt(ImageDownloader.Scheme.DRAWABLE.crop(s));
        return context.getResources().openRawResource(i);
    }

    protected InputStream getStreamFromFile(String s, Object obj)
    {
        String s1 = ImageDownloader.Scheme.FILE.crop(s);
        return new ContentLengthInputStream(new BufferedInputStream(new FileInputStream(s1), 32768), (int)(new File(s1)).length());
    }

    protected InputStream getStreamFromNetwork(String s, Object obj)
    {
        HttpURLConnection httpurlconnection = createConnection(s, obj);
        for (int i = 0; httpurlconnection.getResponseCode() / 100 == 3 && i < 5; i++)
        {
            httpurlconnection = createConnection(httpurlconnection.getHeaderField("Location"), obj);
        }

        InputStream inputstream;
        try
        {
            inputstream = httpurlconnection.getInputStream();
        }
        catch (IOException ioexception)
        {
            IoUtils.readAndCloseStream(httpurlconnection.getErrorStream());
            throw ioexception;
        }
        return new ContentLengthInputStream(new BufferedInputStream(inputstream, 32768), httpurlconnection.getContentLength());
    }

    protected InputStream getStreamFromOtherSource(String s, Object obj)
    {
        throw new UnsupportedOperationException(String.format("UIL doesn't support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))", new Object[] {
            s
        }));
    }
}
