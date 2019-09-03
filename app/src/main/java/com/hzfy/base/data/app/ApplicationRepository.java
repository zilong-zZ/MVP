package com.hzfy.base.data.app;


import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;

import com.hzfy.base.BuildConfig;
import com.hzfy.library.util.StringUtils;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ApplicationRepository implements IApplicationRepository {
    private static final String TAG = "ApplicationRepository";

    private Context mContext;

    private static final String FILE_NAME = "AndroidApplication";

    private static SharedPreferences mAppSharedPreferences;

    @Inject
    public ApplicationRepository(Context androidApplication) {
        mContext = androidApplication;
        mAppSharedPreferences = mContext.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
    }


    @Override
    public boolean isDebug() {
        return !BuildConfig.IS_ONLINE;
    }

    @Override
    public String getBaseUrl() {
        return BuildConfig.BASE_URL;
    }

    @Override
    public String getSerialNumber() {
//        if (isDebug()) {
//            return BuildConfig.SERIAL_NUMBER;
//        }
        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            return Build.UNKNOWN;
        }
        return Build.SERIAL;
    }


    private boolean getBoolean(String key, boolean defValue) {
        return mAppSharedPreferences.getBoolean(key, defValue);
    }

    private void putBoolean(String key, boolean value) {
        mAppSharedPreferences.edit().putBoolean(key, value).apply();
    }


    private String getString(String key, String defValue) {
        return mAppSharedPreferences.getString(key, defValue);
    }

    private void putString(String key, String value) {
        mAppSharedPreferences.edit().putString(key, value).apply();
    }

    private int getInt(String key, int defValue) {
        return mAppSharedPreferences.getInt(key, defValue);
    }

    private void putInt(String key, int value) {
        mAppSharedPreferences.edit().putInt(key, value).apply();
    }

    private static final String KEY_DEVICE_ID = "KEY_DEVICE_ID";

    @Override
    public String getDeviceId() {
        String deviceId = getString(KEY_DEVICE_ID, "");
        if (StringUtils.isEmpty(deviceId)) {
            deviceId = UUID.randomUUID().toString();
            putString(KEY_DEVICE_ID, deviceId);
        }
        return deviceId;
    }

    /**
     * @return 新的唯一标识
     */
    @Override
    public String getNewUUID() {
        return UUID.randomUUID().toString();
    }

    @Override
    public String getAppId() {
        return null;
    }

    @Override
    public String getSignSecret() {
        return null;
    }

}
