package ru.andlancer.kdcsozvezdie.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.andlancer.kdcsozvezdie.DI
import ru.andlancer.kdcsozvezdie.data.db.Journal
import ru.andlancer.kdcsozvezdie.repository.helpers.HelperDB
import ru.andlancer.kdcsozvezdie.repository.helpers.crud.JournalCRUD
import ru.andlancer.kdcsozvezdie.repository.helpers.crud.ProfileCRUD
import ru.andlancer.kdcsozvezdie.repository.helpers.crud.WaterCRUD
import kotlin.math.round

class AppHomeViewModel : ViewModel() {
    var context = DI.appComponent.context()

    private var _waterMax: MutableLiveData<Map<String, Int>>? = null
    private var _water: MutableLiveData<Int>? = null

    fun getWater(): LiveData<Map<String, Int>>? {

        _waterMax = MutableLiveData<Map<String, Int>>()

        ProfileCRUD(HelperDB.getDatabasenIstance(context)).getProfile().subscribe(
            {
                    result ->

                var res: MutableMap<String, Int>

                val volume = result.weight * 0.03
                val count = volume / 0.25

                WaterCRUD(HelperDB.getDatabasenIstance(context)).getWaters().subscribe(
                    {
                        res = mutableMapOf<String, Int>("current" to round(it.map { it.volume }.sum() / 250).toInt(), "max" to round(count).toInt())
                        _waterMax?.postValue(res)
                    },
                    {
                        res = mutableMapOf<String, Int>("current" to 0, "max" to round(count).toInt())
                        _waterMax?.postValue(res)
                    }
                )

            },
            {
                    error -> DI.appComponent.appHelpers().ToastMessage(error.message ?: "Error get Profile")
            }
        )

        return _waterMax
    }


    fun getWaterCurrent(): LiveData<Map<String, Int>>? {

        _waterMax = MutableLiveData<Map<String, Int>>()

        JournalCRUD(HelperDB.getDatabasenIstance(context)).getJournalCurent().subscribe(
            {
                val s = it.hashCode()
                getWaterById(_waterMax, it)
            },
            {

            }
        )



        return _waterMax
    }


    fun getWaterById(_waterMax: MutableLiveData<Map<String, Int>>?, journal: Journal)
    {
        ProfileCRUD(HelperDB.getDatabasenIstance(context)).getProfile().subscribe(
            {
                    result ->

                var res: MutableMap<String, Int>

                val volume = result.weight * 0.03
                val count = volume / 0.25

                WaterCRUD(HelperDB.getDatabasenIstance(context)).getWatersById(journal.id!!).subscribe(
                    {
                        res = mutableMapOf<String, Int>("current" to round(it.map { it.volume }.sum() / 250).toInt(), "max" to round(count).toInt())
                        _waterMax?.postValue(res)
                    },
                    {
                        res = mutableMapOf<String, Int>("current" to 0, "max" to round(count).toInt())
                        _waterMax?.postValue(res)
                    }
                )

            },
            {
                    error -> DI.appComponent.appHelpers().ToastMessage(error.message ?: "Error get Profile")
            }
        )
    }
}