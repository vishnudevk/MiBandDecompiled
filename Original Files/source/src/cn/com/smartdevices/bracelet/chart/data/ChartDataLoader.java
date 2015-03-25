// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.data;

import android.util.SparseArray;

public class ChartDataLoader
{

    protected LoadCallback mCallback;
    protected boolean mIsCancelled;
    protected SparseArray mItemsData;

    public ChartDataLoader()
    {
        mItemsData = new SparseArray();
    }

    public void cancel()
    {
        mIsCancelled = true;
    }

    public void clearData()
    {
        mItemsData.clear();
    }

    public ItemData getItemData(int i)
    {
        return (ItemData)mItemsData.get(i);
    }

    public LoadCallback getLoadCallback()
    {
        return mCallback;
    }

    public boolean hasItemData(int i)
    {
        return mCallback.hasData(i);
    }

    public boolean isCancelled()
    {
        return mIsCancelled;
    }

    public void loadItemData(int i)
    {
        mIsCancelled = false;
        ItemData itemdata = mCallback.loadData(i);
        itemdata.index = i;
        mItemsData.put(i, itemdata);
        if (!mIsCancelled)
        {
            mCallback.onDataLoaded(itemdata);
        }
    }

    public void onToItem(int i)
    {
        mCallback.onToItem(i);
    }

    public void putItemData(int i, ItemData itemdata)
    {
        mItemsData.put(i, itemdata);
    }

    public void setLoadCallback(LoadCallback loadcallback)
    {
        mCallback = loadcallback;
    }

    private class ItemData
    {

        public int index;

        public ItemData()
        {
        }
    }


    private class LoadCallback
    {

        public abstract boolean hasData(int i);

        public abstract ItemData loadData(int i);

        public abstract void onDataLoaded(ItemData itemdata);

        public abstract void onToItem(int i);
    }

}
