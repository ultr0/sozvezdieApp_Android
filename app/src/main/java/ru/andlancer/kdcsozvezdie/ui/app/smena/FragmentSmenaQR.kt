package ru.andlancer.kdcsozvezdie.ui.app.smena

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.andlancer.kdcsozvezdie.R

class FragmentSmenaQR : Fragment() {

    companion object {
        fun newInstance() = FragmentSmenaQR()
    }

    private lateinit var viewModel: FragmentSmenaQRViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_smena_q_r, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FragmentSmenaQRViewModel::class.java)
        // TODO: Use the ViewModel
    }

}