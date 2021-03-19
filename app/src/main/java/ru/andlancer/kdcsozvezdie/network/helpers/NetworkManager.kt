package ru.andlancer.kdcsozvezdie.network.helpers

import ru.andlancer.kdcsozvezdie.network.helpers.auth.AuthApi

interface NetworkManager {

    fun setToken(token: String)

    fun provideApi(): NetworkBaseService

    fun auth(): AuthApi

    fun getToken():String

//    fun getWeather(): Single<ResponseBody>
//
//    fun authLogin(user: AuthLogin): Single<User>
//
//    fun putRegOpros(response: List<FormGeneration.ResponseForm>): Single<ResponseBody>

}