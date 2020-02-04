package sv.edu.udb.ejemplos.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User_Session")
data class Session(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "user_id")
    var id: Int? = 0,
    @ColumnInfo(name = "user_name")
    var userName: String? = null,
    @ColumnInfo(name = "user_password")
    var password: String? = null
)