package gaur.himanshu.august.mvvm.local.respone

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NumberResponse(
    val found: Boolean,
    @PrimaryKey(autoGenerate = false)
    val number: Int,
    val text: String,
    val type: String
)