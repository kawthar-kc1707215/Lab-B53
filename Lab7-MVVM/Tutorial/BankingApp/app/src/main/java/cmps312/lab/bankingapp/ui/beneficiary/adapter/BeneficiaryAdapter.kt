package cmps312.lab.bankingapp.ui.beneficiary.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import cmps312.lab.bankingapp.R
import cmps312.lab.bankingapp.databinding.ListItemBeneficiaryBinding
import cmps312.lab.bankingapp.model.Beneficiary

class BeneficiaryAdapter(
    private val context: Context,
    private val listener: (Beneficiary) -> Unit
) :
    RecyclerView.Adapter<BeneficiaryAdapter.TransactionViewHolder>() {
    lateinit var beneficiaries: List<Beneficiary>

    init {
        beneficiaries = listOf<Beneficiary>()
    }
    inner class TransactionViewHolder(val binding: ListItemBeneficiaryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(beneficiary: Beneficiary) {
           binding.beneficiary = beneficiary
            val view: View =  binding.root
            view.setOnClickListener {
                listener(beneficiary)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {

        val binding: ListItemBeneficiaryBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.list_item_beneficiary, parent, false
        )
        return TransactionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        holder.bind(beneficiaries[position])
    }

    override fun getItemCount() = beneficiaries.size

    fun updateList(beneficiaries: List<Beneficiary>) {
        this.beneficiaries = beneficiaries;
        notifyDataSetChanged()
    }

}