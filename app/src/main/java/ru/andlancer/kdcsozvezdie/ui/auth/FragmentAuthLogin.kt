package ru.andlancer.kdcsozvezdie.ui.auth

import android.content.Intent
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
import ru.andlancer.kdcsozvezdie.databinding.FragmentAuthLoginBinding
import ru.andlancer.kdcsozvezdie.databinding.FragmentSmenaBronBinding
import ru.andlancer.kdcsozvezdie.databinding.ItemAppHomeSmenaBinding
import ru.andlancer.kdcsozvezdie.ui.app.MainActivity
import ru.andlancer.kdcsozvezdie.ui.base.viewBinding
import ru.andlancer.kdcsozvezdie.ui.home.AppHomeViewModel
import java.util.ArrayList

class FragmentAuthLogin : Fragment(R.layout.fragment_auth_login) {

    private val bindingFragment by viewBinding { FragmentAuthLoginBinding.bind(it) }
    private val homeViewModel by activityViewModels<AppHomeViewModel>()
    val appHelpers = DI.appComponent.appHelpers()
    val network = DI.networkComponent.api()
    var models: MutableList<String> = ArrayList<String>()
    var adapter: UniDataBindingAdapter<String, ItemAppHomeSmenaBinding>? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        with(bindingFragment){
//            buttonActionLogin.setOnClickListener {
//                startActivity(
//                    Intent(requireContext(), MainActivity::class.java)
//                    //Intent(this, MainActivity::class.java)
//                )
//            }
            buttonActionReg.setOnClickListener {
                Navigation.findNavController(it).navigate(R.id.action_fragmentAuthLogin_to_fragmentAuthReg)
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