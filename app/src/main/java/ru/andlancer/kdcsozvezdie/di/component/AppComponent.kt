package ru.andlancer.kdcsozvezdie.di.component

import android.content.Context

import dagger.Component
import ru.andlancer.kdcsozvezdie.di.module.ContextModule
import ru.andlancer.kdcsozvezdie.helpers.AppHelpers


@Component(modules = [ContextModule::class])
interface AppComponent {

    fun context(): Context

    fun appHelpers(): AppHelpers



}