package com.hzfy.base.di.components;

import android.app.Activity;

import com.hzfy.base.di.modules.FragmentModule;
import com.hzfy.library.di.FragmentScope;

import dagger.Component;


@FragmentScope
@Component(dependencies = ApplicationComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();
}
