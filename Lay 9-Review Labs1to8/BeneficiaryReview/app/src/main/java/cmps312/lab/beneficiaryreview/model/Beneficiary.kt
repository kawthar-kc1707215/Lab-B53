package cmps312.lab.beneficiaryreview.model

class Beneficiary(var name: String = "", var accountNo: String = "", var cid: Int = 0){
    override fun toString(): String {
        return "$name - $cid"
    }
}