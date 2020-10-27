package cmps312.lab.beneficiaryreview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import cmps312.lab.beneficiaryreview.databinding.BeneficiaryListItemBinding
import cmps312.lab.beneficiaryreview.model.Beneficiary
import cmps312.lab.beneficiaryreview.R

class BeneficiaryAdapter(): RecyclerView.Adapter<BeneficiaryAdapter.BeneficiaryVH>() {

    var beneficiaries = listOf<Beneficiary>()
    set(value) = {
        field = value
        notifyDataSetChanged()
    }
    inner class BeneficiaryVH (val binding: BeneficiaryListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(beneficiary: Beneficiary) {
            binding.beneficiary = beneficiary
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeneficiaryVH {
        val binding: BeneficiaryListItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.beneficiary_list_item,
            parent,
            false
        ) // binding
        return BeneficiaryVH(binding)
    }

    override fun onBindViewHolder(holder: BeneficiaryVH, position: Int) = holder.bind(beneficiaries[position]) // bind to this position, keep doing this till it bind all the positions
    // this will call the bind method
    override fun getItemCount(): Int = beneficiaries.size
}