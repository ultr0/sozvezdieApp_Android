package ru.andlancer.kdcsozvezdie.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import ru.andlancer.kdcsozvezdie.DI
import ru.andlancer.kdcsozvezdie.R
import ru.andlancer.kdcsozvezdie.adapter.UniDataBindingAdapter
import ru.andlancer.kdcsozvezdie.databinding.FragmentAppHomeBinding
import ru.andlancer.kdcsozvezdie.databinding.ItemAppHomeSmenaBinding
import ru.andlancer.kdcsozvezdie.ui.base.viewBinding
import java.util.*
import kotlin.random.Random


class FragmentAppHome : Fragment(R.layout.fragment_app_home) {

    private val bindingFragment by viewBinding { FragmentAppHomeBinding.bind(it) }
    private val homeViewModel by activityViewModels<AppHomeViewModel>()
    val appHelpers = DI.appComponent.appHelpers()
    val network = DI.networkComponent.api()
    var models: MutableList<String> = ArrayList<String>()
    var adapter: UniDataBindingAdapter<String, ItemAppHomeSmenaBinding>? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = UniDataBindingAdapter<String, ItemAppHomeSmenaBinding>(models, { inflater, viewGroup ->
            ItemAppHomeSmenaBinding.inflate(inflater, viewGroup, false)
        }) { binding, item ->
            //binding.textView3.text = item.name
            //binding.imageView2.setBackgroundColor(item.img)
            binding.action.setOnClickListener {
                val b = Bundle()
                b.putString("title", item)
                Navigation.findNavController(binding.root).navigate(R.id.action_navigation_home_to_fragmentSmenaDescription, b)
            }
        }

        getCount()
        getJournal()

        with(bindingFragment){
            rec.adapter = adapter
            rec.layoutManager = LinearLayoutManager(context)
            models.clear()
            models.addAll(
                listOf(
                    "1 смена",
                    "2 смена",
                    "3 смена",
                    "4 смена",
                    "5 смена",
                )
            )
            adapter?.notifyDataSetChanged()
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