package com.hzfy.library.data;

import com.hzfy.library.common.http.OkHttpFactory;
import com.hzfy.library.common.rx.ResultFunction;
import com.hzfy.library.util.Md5TestUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;

public class BaseRemoteApi {

    protected <T> Observable<T> getResult(Observable<BaseResult<T>> observable) {
        return observable.map(new ResultFunction<T>());
    }

    protected RequestBody getFormRequestBody(Map<String, String> params) {
        return OkHttpFactory.getFormRequestBody(params);
    }

    protected RequestBody getJsonRequestBody(String json) {
        return OkHttpFactory.getJsonRequestBody(json);
    }


    /**
     * 添加公共参数的Map
     */
    protected void setOpenApiParams(Map<String, String> params, String appId, String signSecret) {
        if (params == null) {
            params = new HashMap<>();
        }
        params.put("app_id", appId);//账号唯一标识
        String sign = getSign(params, signSecret);
        params.put("sign", sign);//签名（通过一个秘钥计算出来）
    }


    private String getSign(Map<String, String> params, String secret) {
        if (params == null) {
            return null;
        }
        if (params.containsKey("sign")) {
            params.remove("sign");
        }
        String[] keys = params.keySet().toArray(new String[0]);
        Arrays.sort(keys);

        StringBuilder query = new StringBuilder();
        query.append(secret);

        for (String key : keys) {
            String value = params.get(key);
            if ((!(key.isEmpty())) && (!(value.isEmpty()))) {
                query.append(key).append(value);
            }
        }

        query.append(secret);
        String md5 = null;

        try {
            md5 = Md5TestUtils.EncryptionStr32(query.toString(), Md5TestUtils.MD5);
            return md5.toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return md5;
    }

}
