package ru.andlancer.kdcsozvezdie.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.andlancer.kdcsozvezdie.helpers.AppHelpers
import ru.andlancer.kdcsozvezdie.helpers.AppHelpersImpl
import javax.inject.Inject

@Module
class ContextModule @Inject constructor(val context: Context) {

    @Provides
    fun getHelpers(impl: AppHelpersImpl): AppHelpers = impl

    @Provides
    //@Singleton
    fun context(): Context = context.applicationContext




}