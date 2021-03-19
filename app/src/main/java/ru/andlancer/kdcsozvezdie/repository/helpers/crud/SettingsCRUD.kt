package ru.andlancer.kdcsozvezdie.repository.helpers.crud

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ru.andlancer.kdcsozvezdie.data.db.Journal
import ru.andlancer.kdcsozvezdie.data.db.Settings
import ru.andlancer.kdcsozvezdie.data.db.User
import ru.andlancer.kdcsozvezdie.repository.helpers.HelperDB

class SettingsCRUD(val dataBaseInstance: HelperDB) {

    protected val compositeDisposable = CompositeDisposable()

    fun saveSettings(data: Settings){

        dataBaseInstance?.settingsDao()?.insertSettings(data)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe ({
            },{

            })?.let {
                compositeDisposable.add(it)
            }
    }

    fun updateSettings(data: Settings, result: (Boolean) -> Unit){

        dataBaseInstance?.settingsDao()?.updateSettings(data)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe ({
                result(true)
            },{
                result(false)
            })?.let {
                compositeDisposable.add(it)
            }
    }

    fun getSettings(): Single<Settings> {

        val func = dataBaseInstance?.settingsDao()?.getSettings()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())

            return func

    }

     fun onCleared() {
        compositeDisposable.dispose()
        compositeDisposable.clear()
    }

    fun deleteSettings(data: Settings) {
        dataBaseInstance?.settingsDao()?.deleteSettings(data)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe ({
                //Refresh Page data

            },{

            })?.let {
                compositeDisposable.add(it)
            }
    }

}