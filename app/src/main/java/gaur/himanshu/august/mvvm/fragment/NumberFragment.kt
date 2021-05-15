package gaur.himanshu.august.mvvm.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import dagger.hilt.android.AndroidEntryPoint
import gaur.himanshu.august.mvvm.HistoryActivity
import gaur.himanshu.august.mvvm.databinding.FragmentNumberBinding
import gaur.himanshu.august.mvvm.local.NumberViewModel
import gaur.himanshu.august.mvvm.util.Status

@AndroidEntryPoint
class NumberFragment : Fragment() {


    lateinit var binding: FragmentNumberBinding

    val viewModel: NumberViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNumberBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        binding.goToHistory.setOnClickListener {
            startActivity(Intent(requireActivity(),HistoryActivity::class.java))
        }

        binding.fetchData.setOnClickListener {
            val number = binding.numberEt.text.toString().trim().toInt()
            viewModel.getNumberFact(number)
        }


        viewModel.fact.observe(viewLifecycleOwner) {
            when (it?.getContentIfNotHandled()?.status) {

                Status.LOADING -> {
                    binding.progress.visibility = View.VISIBLE
                }
                Status.ERROR -> {
                    binding.progress.visibility = View.GONE
                }
                Status.SUCCESS -> {
                    binding.progress.visibility = View.GONE
                    binding.numberFact.text = it.peekContent().data?.text
                }


            }
        }


    }

}