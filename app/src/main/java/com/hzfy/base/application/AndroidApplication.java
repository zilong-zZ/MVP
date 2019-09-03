/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hzfy.base.application;


import android.content.Context;
import android.support.multidex.MultiDex;

import com.hzfy.base.BuildConfig;
import com.hzfy.base.di.components.ApplicationComponent;
import com.hzfy.base.di.components.DaggerApplicationComponent;
import com.hzfy.base.di.modules.ApplicationModule;
import com.hzfy.base.di.modules.HttpModule;
import com.hzfy.library.util.LogUtil;

import org.litepal.LitePal;


/**
 * Android Main Application
 */
public class AndroidApplication extends com.hzfy.library.application.AndroidApplication {

    /**
     * 单例在ApplicationComponent中声明
     */
    private ApplicationComponent mApplicationComponent;

    public static AndroidApplication getAndroidApplication() {
        return mAndroidApplication;
    }

    private static AndroidApplication mAndroidApplication;


    @Override
    public void initInjector() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .httpModule(getHttpModule())
                .build();
    }

    @Override
    protected void initEvent() {
        mAndroidApplication = this;

        LitePal.initialize(this);

        LogUtil.setLevel(BuildConfig.DEBUG ? LogUtil.VERBOSE : LogUtil.NOTHING);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        // you must install multiDex whatever tinker is installed!
        MultiDex.install(base);
    }

    private HttpModule getHttpModule() {
        return new HttpModule(BuildConfig.BASE_URL, BuildConfig.DEBUG);
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
