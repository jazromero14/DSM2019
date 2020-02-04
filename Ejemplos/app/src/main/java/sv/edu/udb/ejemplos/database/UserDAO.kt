package sv.edu.udb.ejemplos.database

import androidx.room.*

@Dao
interface UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSession(session: Session)

    @Delete()
    fun deleteSession(session: Session)

    @Query("SELECT * FROM User_Session WHERE user_id==:id")
    fun getSession(id: Int): Session
}