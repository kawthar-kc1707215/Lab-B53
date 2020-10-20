package cmps312.lab.bankingapp.ui.transfer.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import cmps312.lab.bankingapp.data.repository.BankRepository
import cmps312.lab.bankingapp.model.Transfer
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class TransferViewModel(appContext: Application) : AndroidViewModel(appContext) {
    private val TAG = "TransferViewModel"

    val accounts = liveData {
        emit(BankRepository.bankService.getAccounts(BankRepository.customerId))
    }

    private var _transfers = getTransfers(BankRepository.customerId) as MutableLiveData
    val transfers = _transfers as LiveData<List<Transfer>>


    fun getTransfers(cid: Int) = liveData {
        emit(BankRepository.bankService.getTransfers(cid))
    }

    //when item is selected from TransferListFragment->TransferDetailsFragment
    lateinit var selectedTransfer: Transfer

    // used for holding the details of new Transfer - used instead of Nav Component nav args
    lateinit var newTransfer: Transfer


    fun setTransferFromDetails(fromAccount: String, amount: Double) {
        newTransfer = Transfer(fromAccount, amount)
    }

    fun setTransferBeneficiaryDetails(beneficiaryName: String, beneficiaryAccountNo: String) {
        newTransfer.beneficiaryName = beneficiaryName
        newTransfer.beneficiaryAccountNo = beneficiaryAccountNo
    }

    //used by TransferConfirmationFragment
    fun addTransfer(transfer: Transfer = newTransfer) {

        viewModelScope.launch {
            //the transfer does not have an ID, so we need to get the added transfer with the ID
            //otherwise we will not be able to delete it unless we call get again
            val response = async {
                BankRepository.bankService.addTransfer(
                    BankRepository.customerId,
                    transfer
                )
            }
            _transfers.value?.let {
                _transfers.value = it + response.await()
            }

        }
    }

    fun deleteTransfer(transfer: Transfer) {
        _transfers.value?.let {
            _transfers.value = it - transfer
        }
        viewModelScope.launch {
            val response = async {
                BankRepository.bankService.deleteTransfer(
                    BankRepository.customerId,
                    transfer.transferId
                )
            }
            Log.d(TAG, "deleteTransfer: ${response.await()}")
        }
    }
}