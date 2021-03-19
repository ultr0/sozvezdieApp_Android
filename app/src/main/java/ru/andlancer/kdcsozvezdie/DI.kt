package ru.andlancer.kdcsozvezdie

import ru.andlancer.kdcsozvezdie.di.component.AppComponent
import ru.andlancer.kdcsozvezdie.di.component.NetworkComponent


object DI {

    lateinit var appComponent: AppComponent
        internal set

    lateinit var networkComponent: NetworkComponent
        internal set


}