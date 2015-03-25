// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.http;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.SessionExpiredException;
import com.xiaomi.infra.galaxy.common.constants.APILevel;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;
import com.xiaomi.infra.galaxy.common.model.BatchRequest;
import com.xiaomi.infra.galaxy.common.model.BatchResult;
import com.xiaomi.infra.galaxy.common.model.DeleteRequest;
import com.xiaomi.infra.galaxy.common.model.DeleteResult;
import com.xiaomi.infra.galaxy.common.model.GalaxyMarshaller;
import com.xiaomi.infra.galaxy.common.model.GetRequest;
import com.xiaomi.infra.galaxy.common.model.GetResult;
import com.xiaomi.infra.galaxy.common.model.ScanRequest;
import com.xiaomi.infra.galaxy.common.model.ScanResult;
import com.xiaomi.infra.galaxy.common.model.SetRequest;
import com.xiaomi.infra.galaxy.common.model.SetResult;
import com.xiaomi.infra.galaxy.common.util.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package com.xiaomi.infra.galaxy.common.http:
//            ClientConfiguration, GalaxyServiceClient

public abstract class GalaxyClient
{

    private static final Log log = LogFactory.getLog(com/xiaomi/infra/galaxy/common/http/GalaxyClient);
    protected ClientConfiguration clientConfiguration;
    protected GalaxyMarshaller marshaller;
    protected GalaxyServiceClient serviceClient;

    public GalaxyClient(ClientConfiguration clientconfiguration, GalaxyServiceClient galaxyserviceclient, GalaxyMarshaller galaxymarshaller)
    {
        clientConfiguration = clientconfiguration;
        serviceClient = galaxyserviceclient;
        marshaller = galaxymarshaller;
        if (StringUtils.isBlank(clientConfiguration.getAppId()))
        {
            throw new GalaxyClientException(ReturnCode.APP_ID_IS_BLANK, "appId is empty");
        } else
        {
            return;
        }
    }

    public BatchResult batch(BatchRequest batchrequest)
    {
        BatchResult batchresult3;
        try
        {
            batchresult3 = (BatchResult)invoke(batchrequest.getGalaxyRequest(marshaller.marshall(batchrequest), APILevel.User), com/xiaomi/infra/galaxy/common/model/BatchResult);
        }
        catch (SessionExpiredException sessionexpiredexception)
        {
            log.error(sessionexpiredexception);
            BatchResult batchresult2 = new BatchResult();
            batchresult2.setResult(sessionexpiredexception.getReturnCode().getResult());
            return batchresult2;
        }
        catch (GalaxyClientException galaxyclientexception)
        {
            log.error(galaxyclientexception);
            BatchResult batchresult1 = new BatchResult();
            batchresult1.setResult(galaxyclientexception.getReturnCode().getResult());
            return batchresult1;
        }
        catch (Exception exception)
        {
            log.error("operation failed", exception);
            BatchResult batchresult = new BatchResult();
            batchresult.setResult(ReturnCode.OPERATION_FAILED.getResult());
            return batchresult;
        }
        return batchresult3;
    }

    public DeleteResult delete(DeleteRequest deleterequest)
    {
        DeleteResult deleteresult3;
        if (!StringUtils.isNotBlank(deleterequest.getUserId()))
        {
            break MISSING_BLOCK_LABEL_33;
        }
        deleteresult3 = new DeleteResult();
        deleteresult3.setResult(ReturnCode.USER_ID_IS_UNNECESSARY.getResult());
        return deleteresult3;
        DeleteResult deleteresult4;
        try
        {
            deleteresult4 = (DeleteResult)invoke(deleterequest.getGalaxyRequest(marshaller.marshall(deleterequest), APILevel.User), com/xiaomi/infra/galaxy/common/model/DeleteResult);
        }
        catch (SessionExpiredException sessionexpiredexception)
        {
            log.error(sessionexpiredexception);
            DeleteResult deleteresult2 = new DeleteResult();
            deleteresult2.setResult(sessionexpiredexception.getReturnCode().getResult());
            return deleteresult2;
        }
        catch (GalaxyClientException galaxyclientexception)
        {
            log.error(galaxyclientexception);
            DeleteResult deleteresult1 = new DeleteResult();
            deleteresult1.setResult(galaxyclientexception.getReturnCode().getResult());
            return deleteresult1;
        }
        catch (Exception exception)
        {
            log.error("operation failed", exception);
            DeleteResult deleteresult = new DeleteResult();
            deleteresult.setResult(ReturnCode.OPERATION_FAILED.getResult());
            return deleteresult;
        }
        return deleteresult4;
    }

    public GetResult get(GetRequest getrequest)
    {
        GetResult getresult3;
        if (!StringUtils.isNotBlank(getrequest.getUserId()))
        {
            break MISSING_BLOCK_LABEL_33;
        }
        getresult3 = new GetResult();
        getresult3.setResult(ReturnCode.USER_ID_IS_UNNECESSARY.getResult());
        return getresult3;
        GetResult getresult4;
        try
        {
            getresult4 = (GetResult)invoke(getrequest.getGalaxyRequest(marshaller.marshall(getrequest), APILevel.User), com/xiaomi/infra/galaxy/common/model/GetResult);
        }
        catch (SessionExpiredException sessionexpiredexception)
        {
            log.error(sessionexpiredexception);
            GetResult getresult2 = new GetResult();
            getresult2.setResult(sessionexpiredexception.getReturnCode().getResult());
            return getresult2;
        }
        catch (GalaxyClientException galaxyclientexception)
        {
            log.error(galaxyclientexception);
            GetResult getresult1 = new GetResult();
            getresult1.setResult(galaxyclientexception.getReturnCode().getResult());
            return getresult1;
        }
        catch (Exception exception)
        {
            log.error("operation failed", exception);
            GetResult getresult = new GetResult();
            getresult.setResult(ReturnCode.OPERATION_FAILED.getResult());
            return getresult;
        }
        return getresult4;
    }

    protected abstract Object invoke(BasicGalaxyRequest basicgalaxyrequest, Class class1);

    public ScanResult scan(ScanRequest scanrequest)
    {
        ScanResult scanresult3;
        if (!StringUtils.isNotBlank(scanrequest.getUserId()))
        {
            break MISSING_BLOCK_LABEL_33;
        }
        scanresult3 = new ScanResult();
        scanresult3.setResult(ReturnCode.USER_ID_IS_UNNECESSARY.getResult());
        return scanresult3;
        ScanResult scanresult4;
        try
        {
            scanresult4 = (ScanResult)invoke(scanrequest.getGalaxyRequest(marshaller.marshall(scanrequest), APILevel.User), com/xiaomi/infra/galaxy/common/model/ScanResult);
        }
        catch (SessionExpiredException sessionexpiredexception)
        {
            log.error(sessionexpiredexception);
            ScanResult scanresult2 = new ScanResult();
            scanresult2.setResult(sessionexpiredexception.getReturnCode().getResult());
            return scanresult2;
        }
        catch (GalaxyClientException galaxyclientexception)
        {
            log.error(galaxyclientexception);
            ScanResult scanresult1 = new ScanResult();
            scanresult1.setResult(galaxyclientexception.getReturnCode().getResult());
            return scanresult1;
        }
        catch (Exception exception)
        {
            log.error("operation failed", exception);
            ScanResult scanresult = new ScanResult();
            scanresult.setResult(ReturnCode.OPERATION_FAILED.getResult());
            return scanresult;
        }
        return scanresult4;
    }

    public SetResult set(SetRequest setrequest)
    {
        SetResult setresult3;
        if (!StringUtils.isNotBlank(setrequest.getUserId()))
        {
            break MISSING_BLOCK_LABEL_33;
        }
        setresult3 = new SetResult();
        setresult3.setResult(ReturnCode.USER_ID_IS_UNNECESSARY.getResult());
        return setresult3;
        SetResult setresult4;
        try
        {
            setresult4 = (SetResult)invoke(setrequest.getGalaxyRequest(marshaller.marshall(setrequest), APILevel.User), com/xiaomi/infra/galaxy/common/model/SetResult);
        }
        catch (SessionExpiredException sessionexpiredexception)
        {
            log.error(sessionexpiredexception);
            SetResult setresult2 = new SetResult();
            setresult2.setResult(sessionexpiredexception.getReturnCode().getResult());
            return setresult2;
        }
        catch (GalaxyClientException galaxyclientexception)
        {
            log.error(galaxyclientexception);
            SetResult setresult1 = new SetResult();
            setresult1.setResult(galaxyclientexception.getReturnCode().getResult());
            return setresult1;
        }
        catch (Exception exception)
        {
            log.error("operation failed", exception);
            SetResult setresult = new SetResult();
            setresult.setResult(ReturnCode.OPERATION_FAILED.getResult());
            return setresult;
        }
        return setresult4;
    }

    public void shutdown()
    {
        if (serviceClient != null)
        {
            serviceClient.shutdown();
        }
    }

}
