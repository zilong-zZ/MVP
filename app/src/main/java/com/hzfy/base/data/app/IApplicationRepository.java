package com.hzfy.base.data.app;


public interface IApplicationRepository {

    /**
     * @return 是否是debug
     */
    boolean isDebug();

    /**
     * @return 域名url
     */
    String getBaseUrl();

    /**
     * @return 设备号
     */
    String getSerialNumber();

    /**
     * @return 设备唯一标识
     */
    String getDeviceId();

    /**
     * @return 新的唯一标识
     */
    String getNewUUID();

    /**
     * @return AppID
     */
    String getAppId();

    /**
     * @return SignSecret
     */
    String getSignSecret();

}
