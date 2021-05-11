package gaur.himanshu.august.mvvm.remote.retrofit

import gaur.himanshu.august.mvvm.local.respone.NumberResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path


const val BASE_URL = "http://numbersapi.com/"

interface NumberApi {


    @GET("{number}")
    suspend fun getNumberFact(
        @Header("Content-Type") str: String,
        @Path("number") number: Int
    ): Response<NumberResponse>

}