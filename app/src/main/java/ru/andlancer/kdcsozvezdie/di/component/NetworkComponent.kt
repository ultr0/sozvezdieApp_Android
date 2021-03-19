package ru.andlancer.kdcsozvezdie.di.component

import dagger.Component
import ru.andlancer.kdcsozvezdie.di.module.NetworkModule
import ru.andlancer.kdcsozvezdie.network.helpers.NetworkManager

import javax.inject.Singleton


@Singleton
@Component(modules = [NetworkModule::class])
interface NetworkComponent {

    @Singleton
    fun api(): NetworkManager

}