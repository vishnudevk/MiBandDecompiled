// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.http;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.SessionExpiredException;
import com.xiaomi.infra.galaxy.common.auth.AnonymousGalaxyCredentials;
import com.xiaomi.infra.galaxy.common.auth.Galaxy4Signer;
import com.xiaomi.infra.galaxy.common.auth.SessionCredentials;
import com.xiaomi.infra.galaxy.common.constants.APILevel;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;
import com.xiaomi.infra.galaxy.common.model.GalaxyMarshaller;
import com.xiaomi.infra.galaxy.common.model.MiSatRequest;
import com.xiaomi.infra.galaxy.common.model.OAuthProvider;
import com.xiaomi.infra.galaxy.common.model.QQSatRequest;
import com.xiaomi.infra.galaxy.common.model.StorageAccessTokenRequest;
import com.xiaomi.infra.galaxy.common.model.StorageAccessTokenResult;
import com.xiaomi.infra.galaxy.common.util.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package com.xiaomi.infra.galaxy.common.http:
//            GalaxyClient, ClientConfiguration, GalaxyServiceClient, ExecutionContext

public class BasicGalaxyOAuthClient extends GalaxyClient
{

    private static final Log log = LogFactory.getLog(com/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient);
    private SessionCredentials sessionCredentials;
    private Galaxy4Signer signer;

    public BasicGalaxyOAuthClient(ClientConfiguration clientconfiguration, GalaxyServiceClient galaxyserviceclient, GalaxyMarshaller galaxymarshaller)
    {
        super(clientconfiguration, galaxyserviceclient, galaxymarshaller);
        sessionCredentials = new SessionCredentials(clientconfiguration.getAppId());
        signer = new Galaxy4Signer();
        signer.setServiceName("Galaxy");
        galaxyserviceclient.setConfiguration(clientconfiguration);
    }

    public BasicGalaxyOAuthClient(GalaxyServiceClient galaxyserviceclient, GalaxyMarshaller galaxymarshaller)
    {
        ClientConfiguration clientconfiguration;
        if (galaxyserviceclient == null)
        {
            clientconfiguration = null;
        } else
        {
            clientconfiguration = galaxyserviceclient.getConfiguration();
        }
        this(clientconfiguration, galaxyserviceclient, galaxymarshaller);
    }

    public StorageAccessTokenResult getStorageAccessTokenResult()
    {
        if (sessionCredentials != null)
        {
            return sessionCredentials.getStorageAccessTokenResult();
        } else
        {
            return null;
        }
    }

    public boolean getstorageAccessToken(StorageAccessTokenRequest storageaccesstokenrequest)
    {
        this;
        JVM INSTR monitorenter ;
        String s = clientConfiguration.getAppId();
        if (!StringUtils.isBlank(storageaccesstokenrequest.getAppId())) goto _L2; else goto _L1
_L1:
        log.info("storage access token request's appId is null");
        storageaccesstokenrequest.setAppId(s);
_L5:
        BasicGalaxyRequest basicgalaxyrequest;
        basicgalaxyrequest = storageaccesstokenrequest.getGalaxyRequest(marshaller.marshall(storageaccesstokenrequest), APILevel.User);
        basicgalaxyrequest.addParameter("appid", storageaccesstokenrequest.getAppId());
        if (!StringUtils.isBlank(storageaccesstokenrequest.getAccessToken())) goto _L4; else goto _L3
_L3:
        log.error("storage access token request's access token is null");
        boolean flag = false;
_L6:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        clientConfiguration.setAppId(storageaccesstokenrequest.getAppId());
          goto _L5
        Exception exception1;
        exception1;
        exception1.printStackTrace();
        log.error("get storage access token failed!", exception1);
        clientConfiguration.setAppId(s);
        flag = false;
          goto _L6
_L4:
        basicgalaxyrequest.addParameter("accessToken", storageaccesstokenrequest.getAccessToken());
        if (!StringUtils.isBlank(storageaccesstokenrequest.getOauthAppId()))
        {
            break MISSING_BLOCK_LABEL_177;
        }
        log.error("storage access token request's oauth appId is null");
        flag = false;
          goto _L6
        basicgalaxyrequest.addParameter("oauth_appid", storageaccesstokenrequest.getOauthAppId());
        if (storageaccesstokenrequest.getOauthVersion() != null) goto _L8; else goto _L7
_L7:
        String s1 = "";
_L12:
        OAuthProvider oauthprovider;
        basicgalaxyrequest.addParameter("oauth_version", s1);
        oauthprovider = OAuthProvider.fromValue(storageaccesstokenrequest.getOauthProvider());
        if (oauthprovider != OAuthProvider.QQ) goto _L10; else goto _L9
_L9:
        if (!(storageaccesstokenrequest instanceof QQSatRequest))
        {
            clientConfiguration.setAppId(s);
            throw new GalaxyClientException(ReturnCode.OAUTH_ACCESSTOKEN_IS_INVALID, (new StringBuilder()).append("should use ").append(com/xiaomi/infra/galaxy/common/model/QQSatRequest.getName()).append(" class with qq oauth ").toString());
        }
          goto _L11
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
_L8:
        s1 = storageaccesstokenrequest.getOauthVersion();
          goto _L12
_L11:
        basicgalaxyrequest.addParameter("oauth_qq_openid", ((QQSatRequest)storageaccesstokenrequest).getOpenid());
        basicgalaxyrequest.addParameter("oauth_qq_oauth_type", ((QQSatRequest)storageaccesstokenrequest).getOauthType());
_L14:
        if (!StringUtils.isBlank(storageaccesstokenrequest.getOauthProvider()))
        {
            break MISSING_BLOCK_LABEL_448;
        }
        clientConfiguration.setAppId(s);
        log.error("storage access token request's oauth provider is null");
        flag = false;
          goto _L6
_L10:
        if (oauthprovider != OAuthProvider.XiaoMi) goto _L14; else goto _L13
_L13:
        if (!(storageaccesstokenrequest instanceof MiSatRequest))
        {
            clientConfiguration.setAppId(s);
            throw new GalaxyClientException(ReturnCode.OAUTH_ACCESSTOKEN_IS_INVALID, (new StringBuilder()).append("should use ").append(com/xiaomi/infra/galaxy/common/model/MiSatRequest.getName()).append(" class with xiaomi oauth ").toString());
        }
        basicgalaxyrequest.addParameter("oauth_xiaomi_mackey", ((MiSatRequest)storageaccesstokenrequest).getMacKey());
        basicgalaxyrequest.addParameter("oauht_xiaomi_mac_algorithm", ((MiSatRequest)storageaccesstokenrequest).getMacAlgorithm());
          goto _L14
        StorageAccessTokenResult storageaccesstokenresult;
        basicgalaxyrequest.addParameter("oauth_provider", storageaccesstokenrequest.getOauthProvider());
        basicgalaxyrequest.addHeader("X-XiaoMi-Appid", storageaccesstokenrequest.getAppId());
        ExecutionContext executioncontext = new ExecutionContext();
        executioncontext.setSigner(signer);
        executioncontext.setCredentials(new AnonymousGalaxyCredentials(storageaccesstokenrequest.getAppId()));
        executioncontext.setMarshaller(marshaller);
        storageaccesstokenresult = (StorageAccessTokenResult)serviceClient.execute(basicgalaxyrequest, com/xiaomi/infra/galaxy/common/model/StorageAccessTokenResult, executioncontext);
        if (storageaccesstokenresult.getCode() == 1)
        {
            break MISSING_BLOCK_LABEL_555;
        }
        clientConfiguration.setAppId(s);
        flag = false;
          goto _L6
        sessionCredentials.setStorageAccessTokenResult(storageaccesstokenresult);
        flag = true;
          goto _L6
    }

    protected Object invoke(BasicGalaxyRequest basicgalaxyrequest, Class class1)
    {
        basicgalaxyrequest.addHeader("X-XiaoMi-Appid", sessionCredentials.getGalaxyAppId());
        ExecutionContext executioncontext = new ExecutionContext();
        executioncontext.setSigner(signer);
        executioncontext.setMarshaller(marshaller);
        if (isLogin())
        {
            executioncontext.setCredentials(sessionCredentials);
        } else
        {
            executioncontext.setCredentials(new AnonymousGalaxyCredentials(clientConfiguration.getAppId()));
        }
        return serviceClient.execute(basicgalaxyrequest, class1, executioncontext);
    }

    public boolean isLogin()
    {
        if (sessionCredentials != null) goto _L2; else goto _L1
_L1:
        String s;
        return false;
_L2:
        if (StringUtils.isBlank(s = sessionCredentials.getGalaxySecretKey())) goto _L1; else goto _L3
_L3:
        return true;
        SessionExpiredException sessionexpiredexception;
        sessionexpiredexception;
        logout();
        return false;
    }

    public void logout()
    {
        this;
        JVM INSTR monitorenter ;
        if (sessionCredentials != null)
        {
            sessionCredentials.setStorageAccessTokenResult(null);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setStorageAccessTokenResult(StorageAccessTokenResult storageaccesstokenresult)
    {
        this;
        JVM INSTR monitorenter ;
        if (sessionCredentials == null) goto _L2; else goto _L1
_L1:
        sessionCredentials.setStorageAccessTokenResult(storageaccesstokenresult);
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        sessionCredentials = new SessionCredentials(clientConfiguration.getAppId());
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

}
