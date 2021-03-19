package ru.andlancer.kdcsozvezdie.di.module

import dagger.Module
import dagger.Provides
import ru.andlancer.kdcsozvezdie.network.helpers.NetworkManager
import ru.andlancer.kdcsozvezdie.network.helpers.NetworkManagerImpl
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun getApi(impl: NetworkManagerImpl): NetworkManager = impl

}