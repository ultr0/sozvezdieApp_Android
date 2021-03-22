package ru.andlancer.kdcsozvezdie.ui.auth

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
import ru.andlancer.kdcsozvezdie.databinding.FragmentAuthReg2Binding
import ru.andlancer.kdcsozvezdie.databinding.FragmentAuthRegBinding
import ru.andlancer.kdcsozvezdie.databinding.ItemAppHomeSmenaBinding
import ru.andlancer.kdcsozvezdie.ui.base.viewBinding
import ru.andlancer.kdcsozvezdie.ui.home.AppHomeViewModel
import ru.andlancer.kdcsozvezdie.widgets.spiner.SpinnerAdapter
import ru.andlancer.kdcsozvezdie.widgets.spiner.SpinnerViewBaseAdapter
import java.util.ArrayList

class FragmentAuthReg2 : Fragment(R.layout.fragment_auth_reg2) {

    private val bindingFragment by viewBinding { FragmentAuthReg2Binding.bind(it) }
    private val homeViewModel by activityViewModels<AppHomeViewModel>()
    val appHelpers = DI.appComponent.appHelpers()
    val network = DI.networkComponent.api()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        with(bindingFragment){


            actionRegFinish.setOnClickListener {
                Navigation.findNavController(root).navigate(R.id.action_fragmentAuthReg2_to_fragmentAuthFirstLogin)
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