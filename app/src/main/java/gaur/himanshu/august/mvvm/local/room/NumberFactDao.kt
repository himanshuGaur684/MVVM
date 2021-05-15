package gaur.himanshu.august.mvvm.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import gaur.himanshu.august.mvvm.local.respone.NumberResponse

@Dao
interface NumberFactDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(numberResponse: NumberResponse)

    @Query("SELECT * FROM NumberResponse")
    suspend fun getAllData():List<NumberResponse>

}