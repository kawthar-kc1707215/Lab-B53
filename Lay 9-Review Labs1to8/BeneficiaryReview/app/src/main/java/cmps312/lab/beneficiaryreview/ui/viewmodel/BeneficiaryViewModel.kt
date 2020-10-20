package cmps312.lab.beneficiaryreview.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import cmps312.lab.beneficiaryreview.data.repository.BeneficiaryRepo

class BeneficiaryViewModel : ViewModel(){
    private val _beneficiaries = getBeneficiaries() as MutableLiveData

    fun getBeneficiaries() = liveData {
        emit(BeneficiaryRepo.getBeneficiaries())
    }

    val beneficiaries = _beneficiaries
}