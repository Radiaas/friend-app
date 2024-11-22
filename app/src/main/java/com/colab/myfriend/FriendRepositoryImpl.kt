package com.colab.myfriend

import com.colab.myfriend.adapter.FriendDao
import com.colab.myfriend.database.Friend
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject

class FriendRepositoryImpl @Inject constructor(
    private val friendDao: FriendDao
) : FriendRepository {

    override fun getAllFriends(): Flow<List<Friend>> {
        return friendDao.getAll()
    }

    override fun getFriendById(id: Int): Flow<Friend?> {
        return friendDao.getItemById(id)
    }

    override suspend fun searchFriend(keyword: String?): List<Friend> {
        return if (keyword.isNullOrEmpty()) {
            friendDao.getAll().firstOrNull() ?: emptyList()
        } else {
            friendDao.findFriend("%$keyword%") // Panggil metode findFriend
        }
    }

    override suspend fun insert(obj: Friend) {
        friendDao.insert(obj)
    }

    override suspend fun insert(vararg obj: Friend) {
        friendDao.insert(*obj)
    }

    override suspend fun insert(obj: List<Friend>) {
        friendDao.insert(obj)
    }

    override suspend fun update(obj: Friend) {
        friendDao.update(obj)
    }

    override suspend fun delete(obj: Friend) {
        friendDao.delete(obj)
    }
}
