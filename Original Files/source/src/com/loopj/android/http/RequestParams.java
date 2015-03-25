// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package com.loopj.android.http:
//            y, v, A, ResponseHandlerInterface

public class RequestParams
{

    public static final String APPLICATION_OCTET_STREAM = "application/octet-stream";
    protected static final String LOG_TAG = "RequestParams";
    protected boolean autoCloseInputStreams;
    protected String contentEncoding;
    protected final ConcurrentHashMap fileParams;
    protected boolean isRepeatable;
    protected final ConcurrentHashMap streamParams;
    protected final ConcurrentHashMap urlParams;
    protected final ConcurrentHashMap urlParamsWithObjects;
    protected boolean useJsonStreamer;

    public RequestParams()
    {
        this((Map)null);
    }

    public RequestParams(String s, String s1)
    {
        this(((Map) (new y(s, s1))));
    }

    public RequestParams(Map map)
    {
        urlParams = new ConcurrentHashMap();
        streamParams = new ConcurrentHashMap();
        fileParams = new ConcurrentHashMap();
        urlParamsWithObjects = new ConcurrentHashMap();
        contentEncoding = "UTF-8";
        if (map != null)
        {
            java.util.Map.Entry entry;
            for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext(); put((String)entry.getKey(), (String)entry.getValue()))
            {
                entry = (java.util.Map.Entry)iterator.next();
            }

        }
    }

    public transient RequestParams(Object aobj[])
    {
        urlParams = new ConcurrentHashMap();
        streamParams = new ConcurrentHashMap();
        fileParams = new ConcurrentHashMap();
        urlParamsWithObjects = new ConcurrentHashMap();
        contentEncoding = "UTF-8";
        int i = aobj.length;
        if (i % 2 != 0)
        {
            throw new IllegalArgumentException("Supplied arguments must be even");
        }
        for (int j = 0; j < i; j += 2)
        {
            put(String.valueOf(aobj[j]), String.valueOf(aobj[j + 1]));
        }

    }

    private List a(String s, Object obj)
    {
        LinkedList linkedlist = new LinkedList();
        if (obj instanceof Map)
        {
            Map map = (Map)obj;
            ArrayList arraylist = new ArrayList(map.keySet());
            Collections.sort(arraylist);
            Iterator iterator1 = arraylist.iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    break;
                }
                Object obj1 = iterator1.next();
                if (obj1 instanceof String)
                {
                    Object obj2 = map.get(obj1);
                    if (obj2 != null)
                    {
                        String s1;
                        if (s == null)
                        {
                            s1 = (String)obj1;
                        } else
                        {
                            s1 = String.format("%s[%s]", new Object[] {
                                s, obj1
                            });
                        }
                        linkedlist.addAll(a(s1, obj2));
                    }
                }
            } while (true);
        } else
        if (obj instanceof List)
        {
            List list = (List)obj;
            int k = list.size();
            for (int l = 0; l < k; l++)
            {
                Object aobj2[] = new Object[2];
                aobj2[0] = s;
                aobj2[1] = Integer.valueOf(l);
                linkedlist.addAll(a(String.format("%s[%d]", aobj2), list.get(l)));
            }

        } else
        if (obj instanceof Object[])
        {
            Object aobj[] = (Object[])(Object[])obj;
            int i = aobj.length;
            for (int j = 0; j < i; j++)
            {
                Object aobj1[] = new Object[2];
                aobj1[0] = s;
                aobj1[1] = Integer.valueOf(j);
                linkedlist.addAll(a(String.format("%s[%d]", aobj1), aobj[j]));
            }

        } else
        if (obj instanceof Set)
        {
            for (Iterator iterator = ((Set)obj).iterator(); iterator.hasNext(); linkedlist.addAll(a(s, iterator.next()))) { }
        } else
        {
            linkedlist.add(new BasicNameValuePair(s, obj.toString()));
        }
        return linkedlist;
    }

    private HttpEntity a()
    {
        UrlEncodedFormEntity urlencodedformentity;
        try
        {
            urlencodedformentity = new UrlEncodedFormEntity(getParamsList(), contentEncoding);
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            Log.e("RequestParams", "createFormEntity failed", unsupportedencodingexception);
            return null;
        }
        return urlencodedformentity;
    }

    private HttpEntity a(ResponseHandlerInterface responsehandlerinterface)
    {
        boolean flag;
        v v1;
        if (!fileParams.isEmpty() || !streamParams.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        v1 = new v(responsehandlerinterface, flag);
        java.util.Map.Entry entry3;
        for (Iterator iterator = urlParams.entrySet().iterator(); iterator.hasNext(); v1.a((String)entry3.getKey(), entry3.getValue()))
        {
            entry3 = (java.util.Map.Entry)iterator.next();
        }

        java.util.Map.Entry entry2;
        for (Iterator iterator1 = urlParamsWithObjects.entrySet().iterator(); iterator1.hasNext(); v1.a((String)entry2.getKey(), entry2.getValue()))
        {
            entry2 = (java.util.Map.Entry)iterator1.next();
        }

        java.util.Map.Entry entry1;
        for (Iterator iterator2 = fileParams.entrySet().iterator(); iterator2.hasNext(); v1.a((String)entry1.getKey(), entry1.getValue()))
        {
            entry1 = (java.util.Map.Entry)iterator2.next();
        }

        Iterator iterator3 = streamParams.entrySet().iterator();
        do
        {
            if (!iterator3.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator3.next();
            StreamWrapper streamwrapper = (StreamWrapper)entry.getValue();
            if (streamwrapper.inputStream != null)
            {
                v1.a((String)entry.getKey(), StreamWrapper.a(streamwrapper.inputStream, streamwrapper.name, streamwrapper.contentType, streamwrapper.autoClose));
            }
        } while (true);
        return v1;
    }

    private HttpEntity b(ResponseHandlerInterface responsehandlerinterface)
    {
        A a1 = new A(responsehandlerinterface);
        a1.a(isRepeatable);
        java.util.Map.Entry entry2;
        for (Iterator iterator = urlParams.entrySet().iterator(); iterator.hasNext(); a1.a((String)entry2.getKey(), (String)entry2.getValue()))
        {
            entry2 = (java.util.Map.Entry)iterator.next();
        }

        BasicNameValuePair basicnamevaluepair;
        for (Iterator iterator1 = a(null, urlParamsWithObjects).iterator(); iterator1.hasNext(); a1.a(basicnamevaluepair.getName(), basicnamevaluepair.getValue()))
        {
            basicnamevaluepair = (BasicNameValuePair)iterator1.next();
        }

        Iterator iterator2 = streamParams.entrySet().iterator();
        do
        {
            if (!iterator2.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry1 = (java.util.Map.Entry)iterator2.next();
            StreamWrapper streamwrapper = (StreamWrapper)entry1.getValue();
            if (streamwrapper.inputStream != null)
            {
                a1.a((String)entry1.getKey(), streamwrapper.name, streamwrapper.inputStream, streamwrapper.contentType);
            }
        } while (true);
        java.util.Map.Entry entry;
        FileWrapper filewrapper;
        for (Iterator iterator3 = fileParams.entrySet().iterator(); iterator3.hasNext(); a1.a((String)entry.getKey(), filewrapper.file, filewrapper.contentType))
        {
            entry = (java.util.Map.Entry)iterator3.next();
            filewrapper = (FileWrapper)entry.getValue();
        }

        return a1;
    }

    public void add(String s, String s1)
    {
        if (s != null && s1 != null)
        {
            Object obj = urlParamsWithObjects.get(s);
            if (obj == null)
            {
                obj = new HashSet();
                put(s, obj);
            }
            if (obj instanceof List)
            {
                ((List)obj).add(s1);
            } else
            if (obj instanceof Set)
            {
                ((Set)obj).add(s1);
                return;
            }
        }
    }

    public HttpEntity getEntity(ResponseHandlerInterface responsehandlerinterface)
    {
        if (useJsonStreamer)
        {
            return a(responsehandlerinterface);
        }
        if (streamParams.isEmpty() && fileParams.isEmpty())
        {
            return a();
        } else
        {
            return b(responsehandlerinterface);
        }
    }

    protected String getParamString()
    {
        return URLEncodedUtils.format(getParamsList(), contentEncoding);
    }

    protected List getParamsList()
    {
        LinkedList linkedlist = new LinkedList();
        java.util.Map.Entry entry;
        for (Iterator iterator = urlParams.entrySet().iterator(); iterator.hasNext(); linkedlist.add(new BasicNameValuePair((String)entry.getKey(), (String)entry.getValue())))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        linkedlist.addAll(a(null, urlParamsWithObjects));
        return linkedlist;
    }

    public void put(String s, int i)
    {
        if (s != null)
        {
            urlParams.put(s, String.valueOf(i));
        }
    }

    public void put(String s, long l)
    {
        if (s != null)
        {
            urlParams.put(s, String.valueOf(l));
        }
    }

    public void put(String s, File file)
    {
        put(s, file, null);
    }

    public void put(String s, File file, String s1)
    {
        if (file == null || !file.exists())
        {
            throw new FileNotFoundException();
        }
        if (s != null)
        {
            fileParams.put(s, new FileWrapper(file, s1));
        }
    }

    public void put(String s, InputStream inputstream)
    {
        put(s, inputstream, null);
    }

    public void put(String s, InputStream inputstream, String s1)
    {
        put(s, inputstream, s1, null);
    }

    public void put(String s, InputStream inputstream, String s1, String s2)
    {
        put(s, inputstream, s1, s2, autoCloseInputStreams);
    }

    public void put(String s, InputStream inputstream, String s1, String s2, boolean flag)
    {
        if (s != null && inputstream != null)
        {
            streamParams.put(s, StreamWrapper.a(inputstream, s1, s2, flag));
        }
    }

    public void put(String s, Object obj)
    {
        if (s != null && obj != null)
        {
            urlParamsWithObjects.put(s, obj);
        }
    }

    public void put(String s, String s1)
    {
        if (s != null && s1 != null)
        {
            urlParams.put(s, s1);
        }
    }

    public void remove(String s)
    {
        urlParams.remove(s);
        streamParams.remove(s);
        fileParams.remove(s);
        urlParamsWithObjects.remove(s);
    }

    public void setAutoCloseInputStreams(boolean flag)
    {
        autoCloseInputStreams = flag;
    }

    public void setContentEncoding(String s)
    {
        if (s != null)
        {
            contentEncoding = s;
            return;
        } else
        {
            Log.d("RequestParams", "setContentEncoding called with null attribute");
            return;
        }
    }

    public void setHttpEntityIsRepeatable(boolean flag)
    {
        isRepeatable = flag;
    }

    public void setUseJsonStreamer(boolean flag)
    {
        useJsonStreamer = flag;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        java.util.Map.Entry entry2;
        for (Iterator iterator = urlParams.entrySet().iterator(); iterator.hasNext(); stringbuilder.append((String)entry2.getValue()))
        {
            entry2 = (java.util.Map.Entry)iterator.next();
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append("&");
            }
            stringbuilder.append((String)entry2.getKey());
            stringbuilder.append("=");
        }

        for (Iterator iterator1 = streamParams.entrySet().iterator(); iterator1.hasNext(); stringbuilder.append("STREAM"))
        {
            java.util.Map.Entry entry1 = (java.util.Map.Entry)iterator1.next();
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append("&");
            }
            stringbuilder.append((String)entry1.getKey());
            stringbuilder.append("=");
        }

        for (Iterator iterator2 = fileParams.entrySet().iterator(); iterator2.hasNext(); stringbuilder.append("FILE"))
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator2.next();
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append("&");
            }
            stringbuilder.append((String)entry.getKey());
            stringbuilder.append("=");
        }

        BasicNameValuePair basicnamevaluepair;
        for (Iterator iterator3 = a(null, urlParamsWithObjects).iterator(); iterator3.hasNext(); stringbuilder.append(basicnamevaluepair.getValue()))
        {
            basicnamevaluepair = (BasicNameValuePair)iterator3.next();
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append("&");
            }
            stringbuilder.append(basicnamevaluepair.getName());
            stringbuilder.append("=");
        }

        return stringbuilder.toString();
    }

    private class StreamWrapper
    {

        public final boolean autoClose;
        public final String contentType;
        public final InputStream inputStream;
        public final String name;

        static StreamWrapper a(InputStream inputstream, String s, String s1, boolean flag)
        {
            if (s1 == null)
            {
                s1 = "application/octet-stream";
            }
            return new StreamWrapper(inputstream, s, s1, flag);
        }

        public StreamWrapper(InputStream inputstream, String s, String s1, boolean flag)
        {
            inputStream = inputstream;
            name = s;
            contentType = s1;
            autoClose = flag;
        }
    }


    private class FileWrapper
    {

        public final String contentType;
        public final File file;

        public FileWrapper(File file1, String s)
        {
            file = file1;
            contentType = s;
        }
    }

}
