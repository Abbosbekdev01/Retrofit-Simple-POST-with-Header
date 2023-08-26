package uz.abbosbek.retrofitcustomrequestheaders.api

import okhttp3.Interceptor
import okhttp3.Response

class MyInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Content-type", "application/json; charset=UTF-8")
            .build()

        return chain.proceed(request)
    }
}