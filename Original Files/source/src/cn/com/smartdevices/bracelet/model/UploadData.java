// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.model;

import android.util.Base64;
import cn.com.smartdevices.bracelet.Debug;
import org.json.JSONException;
import org.json.JSONObject;

public class UploadData
{

    private static final String TAG = "UploadData";
    public byte data[];
    public String date;
    public String indexs;
    public String summary;

    public UploadData()
    {
        date = "";
        data = null;
        summary = "";
        indexs = "";
    }

    private void fromJSONObject(JSONObject jsonobject)
    {
        Debug.i("UploadData", (new StringBuilder()).append("fromJSONObject:").append(jsonobject.toString()).toString());
        try
        {
            String s = jsonobject.getString("data");
            date = jsonobject.getString("date");
            data = Base64.decode(s, 2);
            summary = jsonobject.getString("summary");
            Debug.i("UploadData", (new StringBuilder()).append("fromJSONObject date:\n").append(date).toString());
            Debug.i("UploadData", (new StringBuilder()).append("fromJSONObject summary:\n").append(summary).toString());
            Debug.i("UploadData", (new StringBuilder()).append("fromJSONObject data:\n").append(s).toString());
            return;
        }
        catch (JSONException jsonexception)
        {
            Debug.i("UploadData", (new StringBuilder()).append("fromJSONObject:").append(jsonexception.getMessage()).toString());
        }
    }

    public JSONObject toJSONObject()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            String s = Base64.encodeToString(data, 2);
            jsonobject.put("date", date);
            jsonobject.put("data", s);
            jsonobject.put("summary", summary);
            jsonobject.put("indexs", indexs);
            Debug.i("UploadData", (new StringBuilder()).append("toJSONObject date:\n").append(date).toString());
            Debug.i("UploadData", (new StringBuilder()).append("toJSONObject summary:\n").append(summary).toString());
            Debug.i("UploadData", (new StringBuilder()).append("toJSONObject data:\n").append(s).toString());
            Debug.i("UploadData", (new StringBuilder()).append("toJSONObject indexs:\n").append(indexs).toString());
        }
        catch (JSONException jsonexception)
        {
            Debug.i("UploadData", (new StringBuilder()).append("toJSONObject:").append(jsonexception.getMessage()).toString());
            return jsonobject;
        }
        return jsonobject;
    }
}
