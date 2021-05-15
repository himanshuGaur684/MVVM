package gaur.himanshu.august.mvvm.local

import android.util.JsonReader
import android.util.Log
import gaur.himanshu.august.mvvm.local.respone.NumberResponse
import gaur.himanshu.august.mvvm.local.room.NumberFactDao
import gaur.himanshu.august.mvvm.remote.retrofit.NumberApi
import gaur.himanshu.august.mvvm.util.Result
import gaur.himanshu.august.mvvm.util.Status

class NumberRepo(private val numberApi: NumberApi,private val numberFactDao: NumberFactDao) {


    suspend fun getNumberFact(number: Int): Result<NumberResponse> {
        return try {

            val response = numberApi.getNumberFact("application/json",number)

            if(response.isSuccessful){
                response.body()?.let {
                    numberFactDao.insert(it)
                }

            }

            return Result(Status.SUCCESS, response.body(), null)

        } catch (e: Exception) {
            Log.d("TAG", "getNumberFact: ${e.message}")
            Result(Status.ERROR, null, null)
        }


    }


    suspend fun getAllData():List<NumberResponse>{
        return numberFactDao.getAllData()
    }


}