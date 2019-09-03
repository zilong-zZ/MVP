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
package com.hzfy.base.di.components;

import android.content.Context;

import com.hzfy.base.data.app.IApplicationRepository;
import com.hzfy.base.data.gank.GankRepository;
import com.hzfy.base.di.modules.ApplicationModule;
import com.hzfy.base.di.modules.GankModule;
import com.hzfy.base.di.modules.HttpModule;
import com.hzfy.base.di.modules.UtilModule;
import com.hzfy.library.util.handler.IJsonHandler;
import com.hzfy.library.util.schedulers.ISchedulerProvider;

import javax.inject.Singleton;

import dagger.Component;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = {ApplicationModule.class, HttpModule.class, GankModule.class, UtilModule.class})
public interface ApplicationComponent {

    /**
     * @return 上下文
     */
    Context getContext();

    /**
     * @return 应用管理者
     */
    IApplicationRepository getApplicationRepository();

    /**
     * @return 线程调度器
     */
    ISchedulerProvider getSchedulerProvider();


    /**
     * gank 请求管理者
     * @return
     */
    GankRepository getGankRepository();

    /**
     * @return json工具
     */
    IJsonHandler getJsonHandler();
}
