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
package com.hzfy.base.di.modules;

import android.app.Activity;

import com.hzfy.base.common.loading.LoadingView;
import com.hzfy.base.common.toast.ToastView;
import com.hzfy.library.common.loading.ILoadingView;
import com.hzfy.library.common.toast.IToastView;
import com.hzfy.library.di.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * A module to wrap the Activity state and expose it to the graph.
 */
@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    /**
     * Expose the activity to dependents in the graph.
     */
    @Provides
    @ActivityScope
    Activity provideActivity() {
        return this.activity;
    }


    @Provides
    @ActivityScope
    ILoadingView provideLoadingView(LoadingView loadingView) {
        return loadingView;
    }


    @Provides
    @ActivityScope
    IToastView provideToastView(ToastView toastView) {
        return toastView;
    }

}
