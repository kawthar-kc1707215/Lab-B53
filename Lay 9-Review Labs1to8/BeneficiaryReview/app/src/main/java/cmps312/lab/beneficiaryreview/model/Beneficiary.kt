package cmps312.lab.beneficiaryreview.model

import kotlinx.serialization.Serializable

@Serializable
class Beneficiary(var name: String = "", var accountNo: String = "", var cid: Int = 0){
    override fun toString(): String {
        return "$name - $cid"
    }
}