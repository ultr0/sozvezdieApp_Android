package ru.andlancer.kdcsozvezdie.repository.helpers.crud

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ru.andlancer.kdcsozvezdie.data.db.Profile
import ru.andlancer.kdcsozvezdie.repository.helpers.HelperDB

class ProfileCRUD(val dataBaseInstance: HelperDB) {

    protected val compositeDisposable = CompositeDisposable()


    fun saveProfile(data: Profile, result: (Boolean) -> Unit){

        dataBaseInstance?.profileDao()?.insertProfile(data)
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

    fun getProfile(): Single<Profile> {

        val func = dataBaseInstance?.profileDao()?.getProfile()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())

            return func

    }

     fun onCleared() {
        compositeDisposable.dispose()
        compositeDisposable.clear()
    }

    fun deleteProfile(data: Profile) {
        dataBaseInstance?.profileDao()?.deleteProfile(data)
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