package ru.andlancer.kdcsozvezdie

import android.app.Application
import ru.andlancer.kdcsozvezdie.di.component.DaggerAppComponent
import ru.andlancer.kdcsozvezdie.di.component.DaggerNetworkComponent
import ru.andlancer.kdcsozvezdie.di.module.ContextModule


class App: Application() {

    override fun onCreate() {
        super.onCreate()
        initYandexSDK()
        initDI()

    }

    private fun initYandexSDK(){

    }

    private fun initDI(){
        DI.appComponent = DaggerAppComponent.builder()
            .contextModule(ContextModule(applicationContext))
            .build()

        DI.networkComponent = DaggerNetworkComponent.create()


    }

    companion object{

    }

}