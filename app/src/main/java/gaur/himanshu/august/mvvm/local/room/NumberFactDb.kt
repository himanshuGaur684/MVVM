package gaur.himanshu.august.mvvm.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import gaur.himanshu.august.mvvm.local.respone.NumberResponse

@Database(entities = [NumberResponse::class],version = 1,exportSchema = false)
abstract class NumberFactDb(): RoomDatabase() {

    companion object{
        fun getInstance(context: Context): NumberFactDb{
            return Room.databaseBuilder(context,NumberFactDb::class.java,"db").build()
        }
    }

    abstract fun getDao(): NumberFactDao
}