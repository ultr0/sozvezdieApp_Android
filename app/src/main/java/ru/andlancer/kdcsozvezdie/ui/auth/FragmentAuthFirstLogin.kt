package ru.andlancer.kdcsozvezdie.ui.auth

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import android.text.TextPaint
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import ru.andlancer.kdcsozvezdie.DI
import ru.andlancer.kdcsozvezdie.R
import ru.andlancer.kdcsozvezdie.databinding.FragmentAuthFirstLoginBinding
import ru.andlancer.kdcsozvezdie.ui.base.viewBinding
import ru.andlancer.kdcsozvezdie.ui.home.AppHomeViewModel


class FragmentAuthFirstLogin : Fragment(R.layout.fragment_auth_first_login) {

    private val bindingFragment by viewBinding { FragmentAuthFirstLoginBinding.bind(it) }
    private val homeViewModel by activityViewModels<AppHomeViewModel>()
    val appHelpers = DI.appComponent.appHelpers()
    val network = DI.networkComponent.api()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        with(bindingFragment){

            val paint: TextPaint = name.getPaint()
            val width = paint.measureText("Tianjin, China")

            val textShader: Shader = LinearGradient(
                0f, 0f, width, name.getTextSize(), intArrayOf(
                    resources.getColor(R.color.gradient_r_o_start),
                    resources.getColor(R.color.gradient_r_o_end)
                ), null, Shader.TileMode.CLAMP
            )
            name.getPaint().setShader(textShader)
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