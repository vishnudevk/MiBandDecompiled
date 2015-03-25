// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package android.support.v4.content:
//            d, e

public class FileProvider extends ContentProvider
{

    private static final String a[] = {
        "_display_name", "_size"
    };
    private static final String b = "android.support.FILE_PROVIDER_PATHS";
    private static final String c = "root-path";
    private static final String d = "files-path";
    private static final String e = "cache-path";
    private static final String f = "external-path";
    private static final String g = "name";
    private static final String h = "path";
    private static final File i = new File("/");
    private static HashMap j = new HashMap();
    private d k;

    public FileProvider()
    {
    }

    private static int a(String s)
    {
        if ("r".equals(s))
        {
            return 0x10000000;
        }
        if ("w".equals(s) || "wt".equals(s))
        {
            return 0x2c000000;
        }
        if ("wa".equals(s))
        {
            return 0x2a000000;
        }
        if ("rw".equals(s))
        {
            return 0x38000000;
        }
        if ("rwt".equals(s))
        {
            return 0x3c000000;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid mode: ").append(s).toString());
        }
    }

    private static d a(Context context, String s)
    {
        HashMap hashmap = j;
        hashmap;
        JVM INSTR monitorenter ;
        d d1 = (d)j.get(s);
        if (d1 != null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        d d2 = b(context, s);
        d1 = d2;
        j.put(s, d1);
        hashmap;
        JVM INSTR monitorexit ;
        return d1;
        IOException ioexception;
        ioexception;
        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", ioexception);
        Exception exception;
        exception;
        hashmap;
        JVM INSTR monitorexit ;
        throw exception;
        XmlPullParserException xmlpullparserexception;
        xmlpullparserexception;
        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", xmlpullparserexception);
    }

    private static transient File a(File file, String as[])
    {
        int l = as.length;
        int i1 = 0;
        File file1 = file;
        while (i1 < l) 
        {
            String s = as[i1];
            File file2;
            if (s != null)
            {
                file2 = new File(file1, s);
            } else
            {
                file2 = file1;
            }
            i1++;
            file1 = file2;
        }
        return file1;
    }

    private static Object[] a(Object aobj[], int l)
    {
        Object aobj1[] = new Object[l];
        System.arraycopy(((Object) (aobj)), 0, ((Object) (aobj1)), 0, l);
        return aobj1;
    }

    private static String[] a(String as[], int l)
    {
        String as1[] = new String[l];
        System.arraycopy(as, 0, as1, 0, l);
        return as1;
    }

    private static d b(Context context, String s)
    {
        e e1 = new e(s);
        XmlResourceParser xmlresourceparser = context.getPackageManager().resolveContentProvider(s, 128).loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
        if (xmlresourceparser == null)
        {
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
        do
        {
            int l = xmlresourceparser.next();
            if (l != 1)
            {
                if (l == 2)
                {
                    String s1 = xmlresourceparser.getName();
                    String s2 = xmlresourceparser.getAttributeValue(null, "name");
                    String s3 = xmlresourceparser.getAttributeValue(null, "path");
                    File file;
                    if ("root-path".equals(s1))
                    {
                        file = a(i, new String[] {
                            s3
                        });
                    } else
                    if ("files-path".equals(s1))
                    {
                        file = a(context.getFilesDir(), new String[] {
                            s3
                        });
                    } else
                    if ("cache-path".equals(s1))
                    {
                        file = a(context.getCacheDir(), new String[] {
                            s3
                        });
                    } else
                    if ("external-path".equals(s1))
                    {
                        file = a(Environment.getExternalStorageDirectory(), new String[] {
                            s3
                        });
                    } else
                    {
                        file = null;
                    }
                    if (file != null)
                    {
                        e1.a(s2, file);
                    }
                }
            } else
            {
                return e1;
            }
        } while (true);
    }

    public static Uri getUriForFile(Context context, String s, File file)
    {
        return a(context, s).a(file);
    }

    public void attachInfo(Context context, ProviderInfo providerinfo)
    {
        super.attachInfo(context, providerinfo);
        if (providerinfo.exported)
        {
            throw new SecurityException("Provider must not be exported");
        }
        if (!providerinfo.grantUriPermissions)
        {
            throw new SecurityException("Provider must grant uri permissions");
        } else
        {
            k = a(context, providerinfo.authority);
            return;
        }
    }

    public int delete(Uri uri, String s, String as[])
    {
        return !k.a(uri).delete() ? 0 : 1;
    }

    public String getType(Uri uri)
    {
        File file = k.a(uri);
        int l = file.getName().lastIndexOf('.');
        if (l >= 0)
        {
            String s = file.getName().substring(l + 1);
            String s1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(s);
            if (s1 != null)
            {
                return s1;
            }
        }
        return "application/octet-stream";
    }

    public Uri insert(Uri uri, ContentValues contentvalues)
    {
        throw new UnsupportedOperationException("No external inserts");
    }

    public boolean onCreate()
    {
        return true;
    }

    public ParcelFileDescriptor openFile(Uri uri, String s)
    {
        return ParcelFileDescriptor.open(k.a(uri), a(s));
    }

    public Cursor query(Uri uri, String as[], String s, String as1[], String s1)
    {
        File file = k.a(uri);
        if (as == null)
        {
            as = a;
        }
        String as2[] = new String[as.length];
        Object aobj[] = new Object[as.length];
        int l = as.length;
        int i1 = 0;
        int j1 = 0;
        while (i1 < l) 
        {
            String s2 = as[i1];
            String as3[];
            Object aobj1[];
            MatrixCursor matrixcursor;
            int k1;
            if ("_display_name".equals(s2))
            {
                as2[j1] = "_display_name";
                k1 = j1 + 1;
                aobj[j1] = file.getName();
            } else
            if ("_size".equals(s2))
            {
                as2[j1] = "_size";
                k1 = j1 + 1;
                aobj[j1] = Long.valueOf(file.length());
            } else
            {
                k1 = j1;
            }
            i1++;
            j1 = k1;
        }
        as3 = a(as2, j1);
        aobj1 = a(aobj, j1);
        matrixcursor = new MatrixCursor(as3, 1);
        matrixcursor.addRow(aobj1);
        return matrixcursor;
    }

    public int update(Uri uri, ContentValues contentvalues, String s, String as[])
    {
        throw new UnsupportedOperationException("No external updates");
    }

}
