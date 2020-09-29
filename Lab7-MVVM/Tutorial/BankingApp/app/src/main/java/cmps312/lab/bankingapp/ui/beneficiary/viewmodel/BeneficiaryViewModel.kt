package cmps312.lab.bankingapp.ui.beneficiary.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cmps312.lab.bankingapp.model.Beneficiary
import cmps312.lab.bankingapp.reposiotry.BankRepository

class BeneficiaryViewModel(application: Application) : AndroidViewModel(application) {

    private var _beneficiaries = MutableLiveData<List<Beneficiary>>()

    init {
        BankRepository.initBeneficiaries(application)
        _beneficiaries.postValue(BankRepository.beneficiaries)
    }

    fun beneficiaries() : LiveData<List<Beneficiary>> = _beneficiaries

}