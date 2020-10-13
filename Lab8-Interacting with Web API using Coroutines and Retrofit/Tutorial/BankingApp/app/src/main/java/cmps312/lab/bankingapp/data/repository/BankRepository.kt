package cmps312.lab.bankingapp.data.repository

import cmps312.lab.bankingapp.data.api.BankService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

object BankRepository {
    val customerId = 10001 //
    const val BASE_URL = "https://cmps312banking.herokuapp.com/api/";

    private val contentType = "application/json".toMediaType()
    val jsonConverterFactory = Json { ignoreUnknownKeys = true }.asConverterFactory(contentType)

    val bankService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(jsonConverterFactory)  //json to kotlin object and vice versa
            .build()
            .create(BankService::class.java)
    }

}