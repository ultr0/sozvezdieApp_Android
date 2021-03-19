package ru.andlancer.kdcsozvezdie.repository.helpers.crud

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ru.andlancer.kdcsozvezdie.data.db.Journal
import ru.andlancer.kdcsozvezdie.data.db.Water
import ru.andlancer.kdcsozvezdie.repository.helpers.HelperDB

class WaterCRUD(val dataBaseInstance: HelperDB) {

    protected val compositeDisposable = CompositeDisposable()


    fun saveWater(data: Water, result: (Boolean, Long?) -> Unit){

        dataBaseInstance?.waterDao()?.insertWater(data)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe ({
                result(true, it)
            },{
                result(false, null)
            })?.let {
                compositeDisposable.add(it)
            }
    }

    fun saveWaters(data: List<Water>, result: (Boolean, List<Long>?) -> Unit){

        dataBaseInstance?.waterDao()?.insertWaters(data)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe ({
                result(true, it)
            },{
                result(false, null)
            })?.let {
                compositeDisposable.add(it)
            }
    }

    fun updateWater(data: Water, result: (Boolean) -> Unit){

        dataBaseInstance?.waterDao()?.updateWater(data)
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

    fun getWater(id:Int): Single<Water> {

        val func = dataBaseInstance?.waterDao()?.getWater(id)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())

            return func

    }

    fun getWatersById(id:Long): Single<List<Water>> {

        val func = dataBaseInstance?.waterDao()?.getWatersById(id)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())

        return func

    }

    fun getWaters(): Single<List<Water>> {

        val func = dataBaseInstance?.waterDao()?.getWaters()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())

        return func

    }

     fun onCleared() {
        compositeDisposable.dispose()
        compositeDisposable.clear()
    }

    fun deleteWater(data: Water) {
        dataBaseInstance?.waterDao()?.deleteWater(data)
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