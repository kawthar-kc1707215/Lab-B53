package cmps312.lab.bankingapp.ui.transfer.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import cmps312.lab.bankingapp.model.Transfer
import cmps312.lab.bankingapp.reposiotry.BankRepository

class TransferViewModel(application: Application) : AndroidViewModel(application) {
    private var _transfers = MutableLiveData<MutableList<Transfer>>()
    lateinit var transfer : Transfer

    fun transfers(): LiveData<MutableList<Transfer>> = _transfers

    //initialization
    init {
        BankRepository.initTransfers(application)
        _transfers.postValue(BankRepository.transfers as MutableList<Transfer>)
        //anyone who is observing
    }

}