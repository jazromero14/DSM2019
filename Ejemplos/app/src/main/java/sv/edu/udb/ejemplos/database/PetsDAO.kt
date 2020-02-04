package sv.edu.udb.ejemplos.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PetsDAO {
    @Query("SELECT * FROM PETS")
    fun getAllPets(): MutableList<Pet>

    @Insert
    fun insertPet(pet: Pet)
}