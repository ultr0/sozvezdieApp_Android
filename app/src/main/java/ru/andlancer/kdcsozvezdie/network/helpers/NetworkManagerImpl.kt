package ru.andlancer.kdcsozvezdie.network.helpers


import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.andlancer.kdcsozvezdie.DI
import ru.andlancer.kdcsozvezdie.BuildConfig
import ru.andlancer.kdcsozvezdie.network.Adapters.DateDeserializer
import ru.andlancer.kdcsozvezdie.network.Adapters.DateSerializer
import ru.andlancer.kdcsozvezdie.network.helpers.auth.AuthApi
import ru.andlancer.kdcsozvezdie.network.helpers.auth.AuthApiImpl
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

class NetworkManagerImpl @Inject constructor() : NetworkManager {


    //private val BASE_URL = "http://spacefit.andlancer.ru/api/"
    private val BASE_URL = "http://192.168.43.198:8000/api/"

    //private var TOKEN = "fail"
    var TOKEN = "fail"

    init {
        DI.networkComponent
    }

    override fun setToken(token: String) {
        TOKEN = token
        DI.appComponent.appHelpers().showMessage(TOKEN)
    }

    override fun getToken(): String = TOKEN


    @Singleton
    override fun provideApi(): NetworkBaseService {
        val gson: Gson =
            GsonBuilder()
                .registerTypeAdapter(Date::class.java, DateSerializer())
                //.registerTypeAdapter(Date::class.java, DateDeserializer())
                .create()
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level =
                            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
                    })
                    .addInterceptor { chain ->
                        if (!TOKEN.equals("fail")) {
                            val request = chain.request().newBuilder()
                                .addHeader("Authorization", "Bearer ${TOKEN}").build()
                            chain.proceed(request)
                        } else {
                            chain.proceed(chain.request())
                        }
                    }
                    .build()
            )
            .build()
            .create(NetworkBaseService::class.java)

    }

    override fun auth(): AuthApi = AuthApiImpl()

//    override fun profile(): ProfileApi = ProfileApiImpl()
//
//    override fun water(): WaterApi = WaterApiImpl()


//    override fun getWeather(): Single<ResponseBody> {
//        return DI.networkComponent.api().provideApi().getweather().subscribeOn(
//            Schedulers.io()
//        )
//            .observeOn(AndroidSchedulers.mainThread())
//    }

//    override fun authLogin(user: AuthLogin): Single<User> {
//        return DI.networkComponent.api().provideApi().authLogin(user).subscribeOn(
//            Schedulers.io()
//        )
//            .observeOn(AndroidSchedulers.mainThread())
//    }

//    override fun putRegOpros(response: List<FormGeneration.ResponseForm>): Single<ResponseBody> {
//        return DI.networkComponent.api().provideApi().putRegOpros(response).subscribeOn(
//            Schedulers.io()
//        )
//            .observeOn(AndroidSchedulers.mainThread())
//    }

}