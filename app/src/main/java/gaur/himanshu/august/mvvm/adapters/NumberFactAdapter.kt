package gaur.himanshu.august.mvvm.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import gaur.himanshu.august.mvvm.databinding.ViewHolderHistoryBinding
import gaur.himanshu.august.mvvm.local.respone.NumberResponse

class NumberFactAdapter : RecyclerView.Adapter<NumberFactAdapter.MyViewHolder>() {


    var list = mutableListOf<NumberResponse>()

    fun setContentList(list: MutableList<NumberResponse>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class MyViewHolder(val viewDataBinding: ViewHolderHistoryBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NumberFactAdapter.MyViewHolder {
        val binding =
            ViewHolderHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return this.list.size
    }

    override fun onBindViewHolder(holder: NumberFactAdapter.MyViewHolder, position: Int) {
        holder.viewDataBinding.numberResponse = this.list[position]
    }
}