package sv.edu.udb.ejemplos.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Pets")
data class Pet(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo(name = "name_pet")
    var name: String? = "",
    @ColumnInfo(name = "name_owner")
    var owner: String? = "",
    @ColumnInfo(name = "breed")
    var breed: String? = "",
    @ColumnInfo(name = "genre")
    var genre: String? = "",
    @ColumnInfo(name = "description")
    var description: String? = ""
)