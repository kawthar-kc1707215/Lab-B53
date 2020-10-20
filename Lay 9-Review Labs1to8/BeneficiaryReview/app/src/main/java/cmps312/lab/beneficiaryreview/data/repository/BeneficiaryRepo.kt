package cmps312.lab.beneficiaryreview.data.repository

import cmps312.lab.beneficiaryreview.model.Beneficiary

object BeneficiaryRepo {
    //you will create the retrofit
    val beneficiaries
            = listOf<Beneficiary>(Beneficiary("Abdulahi", "123",1000) , Beneficiary("Dalal", "145",2000))
    suspend fun getBeneficiaries() = beneficiaries
}