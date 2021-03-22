package ru.andlancer.kdcsozvezdie.ui.splash

import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.andlancer.kdcsozvezdie.R
import ru.andlancer.kdcsozvezdie.ui.app.MainActivity
import ru.andlancer.kdcsozvezdie.ui.auth.AuthActivity
import java.util.concurrent.TimeUnit

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        delay()

//        Single.just("do it!").delay(3, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                SettingsCRUD(HelperDB.getDatabasenIstance(DI.appComponent.context())).getSettings()
//                    .subscribe(
//                        { result ->
//                            if (result.firstRun)
//                                UserCRUD(HelperDB.getDatabasenIstance(DI.appComponent.context())).getUser()
//                                    .subscribe(
//                                        { user ->
//                                            user.accessToken?.let {
//                                                DI.networkComponent.api().setToken(it)
//                                            }
//                                            DI.networkComponent.api().auth().getAcceptReg().subscribe(
//                                                { result ->
//                                                    if (JSONObject(result.string()).getBoolean("reg_opros")) {
//                                                        startActivity(
//                                                            Intent(this, MainActivity::class.java)
//                                                        )
//                                                    } else {
//                                                        finish()
//                                                        startActivity(
//                                                            Intent(this, AuthActivity::class.java)
//                                                        )
//                                                    }
//                                                },
//                                                { error ->
//                                                    when (error) {
//                                                        is HttpException -> {
//                                                            DI.appComponent.appHelpers().ToastMessage(
//                                                                "${
//                                                                    error.code().toString()
//                                                                } ${error.message()} ${
//                                                                    error.response()?.errorBody()?.string()
//                                                                }"
//                                                            )
//                                                            UserCRUD(HelperDB.getDatabasenIstance(DI.appComponent.context())).dropData()
//                                                            finish()
//                                                            startActivity(
//                                                                Intent(this, AuthActivity::class.java)
//                                                            )
//                                                        }
//                                                    }
//                                                }
//                                            )
//                                        },
//                                        { error ->
//                                            DI.appComponent.appHelpers().showMessage(error.message.toString())
//                                            finish()
//                                            startActivity(
//                                                Intent(this, AuthActivity::class.java)
//                                            )
//                                        }
//                                    )
//
//                        },
//                        { error ->
//                            DI.appComponent.appHelpers().showMessage(error.message.toString())
//                            finish()
//                            startActivity(
//                                Intent(this, AuthActivity::class.java)
//                            )
//                        }
//                    )
//
//            }, {})
    }

    fun delay() {
//        Single.just("do it!").delay(3, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                finish()
//                startActivity(
//                    Intent(this, AuthActivity::class.java)
//                    //Intent(this, MainActivity::class.java)
//                )
//            },
//                {
//
//                })

        Observable.intervalRange(
            0L, 100L, 35, 10, TimeUnit.MILLISECONDS,
            AndroidSchedulers.mainThread()
        )
            .subscribe({ v ->
                findViewById<ProgressBar>(R.id.progress).setProgress(v.toInt())
            },
                {

                },
                {
                    finish()
                    startActivity(
                        Intent(this, AuthActivity::class.java)
                        //Intent(this, MainActivity::class.java)
                    )
                }
            )

    }
}