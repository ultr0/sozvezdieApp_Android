package ru.andlancer.kdcsozvezdie.repository.helpers.crud

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ru.andlancer.kdcsozvezdie.data.db.Journal
import ru.andlancer.kdcsozvezdie.repository.helpers.HelperDB
import java.util.*

class JournalCRUD(val dataBaseInstance: HelperDB) {

    protected val compositeDisposable = CompositeDisposable()


    fun saveJournal(data: Journal, result: (Boolean, Long?) -> Unit){

        dataBaseInstance?.journalDao()?.insertJournal(data)
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

    fun saveJournals(data: List<Journal>, result: (Boolean, List<Long>?) -> Unit){

        dataBaseInstance?.journalDao()?.insertJournals(data)
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


    fun updateJournal(data: Journal, result: (Boolean) -> Unit){

        dataBaseInstance?.journalDao()?.updateJournal(data)
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

    fun getJournal(id:Int): Single<Journal> {

        val func = dataBaseInstance?.journalDao()?.getJournal(id)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())

            return func

    }

    fun getJournalToday(date: Date): Single<Journal> {

        val func = dataBaseInstance?.journalDao()?.getJournalToday(date)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())

        return func

    }

    fun getJournalCurent(): Single<Journal> {

        val func = dataBaseInstance?.journalDao()?.getJournalToday(Date())
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())

        return func

    }


    fun getJournals(): Single<List<Journal>> {

        val func = dataBaseInstance?.journalDao()?.getJournals()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())

        return func

    }

     fun onCleared() {
        compositeDisposable.dispose()
        compositeDisposable.clear()
    }

    fun deleteJournal(data: Journal) {
        dataBaseInstance?.journalDao()?.deleteJournal(data)
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