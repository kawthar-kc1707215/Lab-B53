package cmps312.lab.bankingapp.ui.beneficiary

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import cmps312.lab.bankingapp.R
import cmps312.lab.bankingapp.model.Beneficiary
import cmps312.lab.bankingapp.ui.beneficiary.adapter.BeneficiaryAdapter
import cmps312.lab.bankingapp.ui.beneficiary.viewmodel.BeneficiaryViewModel
import cmps312.lab.bankingapp.ui.transfer.viewmodel.TransferViewModel
import kotlinx.android.synthetic.main.fragment_select_beneficiary.*

class SelectBeneficiaryFragment : Fragment(R.layout.fragment_select_beneficiary) {

    val beneficiaryViewModel : BeneficiaryViewModel by viewModels() //display the list

    val transferViewModel : TransferViewModel by activityViewModels() //exchange data

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val beneficiaryAdapter : BeneficiaryAdapter
        beneficiaryRV.apply {
            layoutManager = LinearLayoutManager(activity)
            beneficiaryAdapter = BeneficiaryAdapter(view.context, ::updateBeneficiaryAndNavigateToConfirmation)
            adapter = beneficiaryAdapter
        }

        beneficiaryViewModel.beneficiaries().observe(viewLifecycleOwner){
            beneficiaryAdapter.updateList(it)
        }
    }

    private fun updateBeneficiaryAndNavigateToConfirmation(beneficiary: Beneficiary) {

        transferViewModel.transfer.beneficiaryAccountNo = beneficiary.accountNo
        transferViewModel.transfer.beneficiaryName = beneficiary.name

        val action = SelectBeneficiaryFragmentDirections.toTransferConfirmation()
        findNavController().navigate(action)
    }

}