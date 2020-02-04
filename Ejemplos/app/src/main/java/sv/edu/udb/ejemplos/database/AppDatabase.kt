package sv.edu.udb.ejemplos.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Session::class, Pet::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun sessionDAO(): UserDAO
    abstract fun petDAO(): PetsDAO
}