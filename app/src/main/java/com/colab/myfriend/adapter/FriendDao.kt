package com.colab.myfriend.adapter

import androidx.room.*
import com.colab.myfriend.database.Friend
import kotlinx.coroutines.flow.Flow

// Interface Data Access Object (DAO) untuk entitas Friend
@Dao
interface FriendDao {

    @Query("SELECT * from friend WHERE id = :id")
    fun getItemById(id: Int): Flow<Friend?>

    @Insert
    suspend fun insert(friend: Friend)

    @Query("SELECT * FROM friend")
    fun getAll(): Flow<List<Friend>>

    @Update
    suspend fun update(friend: Friend)

    @Delete
    suspend fun delete(friend: Friend)
}
