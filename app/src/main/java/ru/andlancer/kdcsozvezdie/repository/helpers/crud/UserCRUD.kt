package ru.andlancer.kdcsozvezdie.repository.helpers.crud

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ru.andlancer.kdcsozvezdie.data.db.User
import ru.andlancer.kdcsozvezdie.repository.helpers.HelperDB

class UserCRUD(val dataBaseInstance: HelperDB) {

    protected val compositeDisposable = CompositeDisposable()


    fun saveUser(data: User){

        dataBaseInstance?.userDao()?.insertUser(data)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe ({
            },{

            })?.let {
                compositeDisposable.add(it)
            }
    }

    fun getUser(): Single<User> {

        val func = dataBaseInstance?.userDao()?.getUser()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())

            return func

    }

     fun onCleared() {
        compositeDisposable.dispose()
        compositeDisposable.clear()
    }

    fun dropData() {
        dataBaseInstance?.userDao()?.dropUser()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe ({
                //Refresh Page data

            },{

            })?.let {
                compositeDisposable.add(it)
            }
    }

    fun deleteUser(user: User) {
        dataBaseInstance?.userDao()?.deleteUser(user)
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