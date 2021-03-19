package ru.andlancer.kdcsozvezdie.repository.dao

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Single
import ru.andlancer.kdcsozvezdie.data.db.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User) : Completable

    @Query("SELECT * FROM User LIMIT 1")
    fun getUser(): Single<User>

    @Delete
    fun deleteUser(person:User) : Completable

    @Query("DELETE FROM User")
    fun dropUser() : Completable

    @Update
    fun updateUser(person:User)

}