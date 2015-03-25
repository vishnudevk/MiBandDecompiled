// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.achartengine.tools;

import org.achartengine.chart.AbstractChart;
import org.achartengine.chart.RoundChart;
import org.achartengine.chart.XYChart;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

// Referenced classes of package org.achartengine.tools:
//            AbstractTool

public class FitZoom extends AbstractTool
{

    public FitZoom(AbstractChart abstractchart)
    {
        super(abstractchart);
    }

    public void apply()
    {
        if (!(mChart instanceof XYChart)) goto _L2; else goto _L1
_L1:
        if (((XYChart)mChart).getDataset() != null) goto _L4; else goto _L3
_L3:
        return;
_L4:
        int i;
        i = mRenderer.getScalesCount();
        if (!mRenderer.isInitialRangeSet())
        {
            break; /* Loop/switch isn't completed */
        }
        int i1 = 0;
        while (i1 < i) 
        {
            if (mRenderer.isInitialRangeSet(i1))
            {
                mRenderer.setRange(mRenderer.getInitialRange(i1), i1);
            }
            i1++;
        }
        if (true) goto _L3; else goto _L5
_L5:
        XYSeries axyseries[] = ((XYChart)mChart).getDataset().getSeries();
        int j = axyseries.length;
        if (j > 0)
        {
            int k = 0;
            while (k < i) 
            {
                double ad[] = {
                    1.7976931348623157E+308D, -1.7976931348623157E+308D, 1.7976931348623157E+308D, -1.7976931348623157E+308D
                };
                for (int l = 0; l < j; l++)
                {
                    if (k == axyseries[l].getScaleNumber())
                    {
                        ad[0] = Math.min(ad[0], axyseries[l].getMinX());
                        ad[1] = Math.max(ad[1], axyseries[l].getMaxX());
                        ad[2] = Math.min(ad[2], axyseries[l].getMinY());
                        ad[3] = Math.max(ad[3], axyseries[l].getMaxY());
                    }
                }

                double d = Math.abs(ad[1] - ad[0]) / 40D;
                double d1 = Math.abs(ad[3] - ad[2]) / 40D;
                XYMultipleSeriesRenderer xymultipleseriesrenderer = mRenderer;
                double ad1[] = new double[4];
                ad1[0] = ad[0] - d;
                ad1[1] = d + ad[1];
                ad1[2] = ad[2] - d1;
                ad1[3] = d1 + ad[3];
                xymultipleseriesrenderer.setRange(ad1, k);
                k++;
            }
        }
        if (true) goto _L3; else goto _L2
_L2:
        DefaultRenderer defaultrenderer = ((RoundChart)mChart).getRenderer();
        defaultrenderer.setScale(defaultrenderer.getOriginalScale());
        return;
    }
}
