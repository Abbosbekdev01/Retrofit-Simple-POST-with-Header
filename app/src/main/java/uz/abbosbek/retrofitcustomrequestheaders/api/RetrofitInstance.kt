package uz.abbosbek.retrofitcustomrequestheaders.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.abbosbek.retrofitcustomrequestheaders.utils.Constants.Companion.BASE_URL

object RetrofitInstance {

    private val client = OkHttpClient.Builder().apply {
        addInterceptor(MyInterceptor())
    }.build()


    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    }
}