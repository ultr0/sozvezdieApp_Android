package ru.andlancer.kdcsozvezdie.ui.app.smena

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import ru.andlancer.kdcsozvezdie.DI
import ru.andlancer.kdcsozvezdie.R
import ru.andlancer.kdcsozvezdie.adapter.UniDataBindingAdapter
import ru.andlancer.kdcsozvezdie.databinding.FragmentSmenaBronBinding
import ru.andlancer.kdcsozvezdie.databinding.FragmentSmenaDescriptionBinding
import ru.andlancer.kdcsozvezdie.databinding.ItemAppHomeSmenaBinding
import ru.andlancer.kdcsozvezdie.ui.base.viewBinding
import ru.andlancer.kdcsozvezdie.ui.home.AppHomeViewModel
import java.util.ArrayList

class FragmentSmenaBron :  Fragment(R.layout.fragment_smena_bron) {

    private val bindingFragment by viewBinding { FragmentSmenaBronBinding.bind(it) }
    private val homeViewModel by activityViewModels<AppHomeViewModel>()
    val appHelpers = DI.appComponent.appHelpers()
    val network = DI.networkComponent.api()
    var models: MutableList<String> = ArrayList<String>()
    var adapter: UniDataBindingAdapter<String, ItemAppHomeSmenaBinding>? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        with(bindingFragment){
            buttonActionBron.setOnClickListener {
                Navigation.findNavController(root).navigate(R.id.action_fragmentSmenaBron_to_fragmentSmenaQR)
            }
        }

    }

    fun getCount() {
        homeViewModel.getWaterCurrent()
            ?.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                // bindingFragment.countWater.text = "${it.get("current")}/${it.get("max")}"

            })
    }

    fun getJournal(){
//        bindingFragment.actionJournal.text.text = SimpleDateFormat("MMMM d yyyy", Locale.ROOT).format(
//            Date()
//        )
    }

}