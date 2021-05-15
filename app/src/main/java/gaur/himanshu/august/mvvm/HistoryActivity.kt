package gaur.himanshu.august.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.observe
import dagger.hilt.android.AndroidEntryPoint
import gaur.himanshu.august.mvvm.adapters.NumberFactAdapter
import gaur.himanshu.august.mvvm.databinding.ActivityHistoryBinding
import gaur.himanshu.august.mvvm.local.NumberViewModel

@AndroidEntryPoint
class HistoryActivity : AppCompatActivity() {

    lateinit var binding:ActivityHistoryBinding

    val numberFactAdapter= NumberFactAdapter()
    val viewModel:NumberViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= DataBindingUtil.setContentView(this,R.layout.activity_history)

        viewModel.getAllData()

        viewModel.history.observe(this){
            numberFactAdapter.setContentList(it.toMutableList())
        }


        binding.recycler.apply {
            adapter= numberFactAdapter
        }


    }
}