package ru.andlancer.kdcsozvezdie.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import ru.andlancer.kdcsozvezdie.DI
import ru.andlancer.kdcsozvezdie.R
import ru.andlancer.kdcsozvezdie.adapter.UniDataBindingAdapter
import ru.andlancer.kdcsozvezdie.data.service.Role
import ru.andlancer.kdcsozvezdie.databinding.FragmentAuthRegBinding
import ru.andlancer.kdcsozvezdie.databinding.ItemAppHomeSmenaBinding
import ru.andlancer.kdcsozvezdie.ui.app.MainActivity
import ru.andlancer.kdcsozvezdie.ui.base.viewBinding
import ru.andlancer.kdcsozvezdie.ui.home.AppHomeViewModel
import ru.andlancer.kdcsozvezdie.widgets.spiner.SpinnerAdapter
import ru.andlancer.kdcsozvezdie.widgets.spiner.SpinnerViewBaseAdapter
import java.util.ArrayList

class FragmentAuthReg : Fragment(R.layout.fragment_auth_reg) {

    private val bindingFragment by viewBinding { FragmentAuthRegBinding.bind(it) }
    private val homeViewModel by activityViewModels<AppHomeViewModel>()
    val appHelpers = DI.appComponent.appHelpers()
    val network = DI.networkComponent.api()
    var models: MutableList<String> = ArrayList<String>()
    var adapter: UniDataBindingAdapter<String, ItemAppHomeSmenaBinding>? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        with(bindingFragment){
            var adapter = SpinnerAdapter()
            adapter.setListener(object : SpinnerViewBaseAdapter.OnItemSelectedListener{
                override fun onItemSelected(any: Any, title: String, position: Int) {
                    spinner.notifySelectedItem(title, position)
                }

            })
            adapter.setItems(
                listOf(
                    "Родитель",
                "Шкiльнiк",
                "")
            )
            spinner.hint = "Роль"
            spinner.setAdapter(adapter)

            var adapter2 = SpinnerAdapter()
            adapter2.setListener(object : SpinnerViewBaseAdapter.OnItemSelectedListener{
                override fun onItemSelected(any: Any, title: String, position: Int) {
                    spinner2.notifySelectedItem(title, position)
                }

            })
            adapter2.setItems(
                listOf(
                    "Хубабуровск",
                "Уссурийск",
                "")
            )
            spinner2.setAdapter(adapter2)
            spinner2.hint = "Город"
            actionRegNext.setOnClickListener {
                Navigation.findNavController(root).navigate(R.id.action_fragmentAuthReg_to_fragmentAuthReg2)
            }


//            buttonActionLogin.setOnClickListener {
//                Navigation.findNavController(root).navigate(R.id.action_fragmentAuthReg_to_fragmentAuthLogin)
//            }
//            buttonActionReg.setOnClickListener {
//                startActivity(
//                    Intent(requireContext(), MainActivity::class.java)
//                    //Intent(this, MainActivity::class.java)
//                )
//            }
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